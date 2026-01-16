package mod.leronus.mores.mixin;

import mod.leronus.mores.config.CommonConfig;
import mod.leronus.mores.world.ModConfiguredFeatures;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.RandomFeature;
import net.minecraft.world.gen.feature.RandomFeatureEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.lang.reflect.Field;

/**
 * Replaces vanilla oak-like RandomFeature choices with your lemon oak 1/N of the time.
 *
 * Design goals:
 * - No @Accessor usage (field names change constantly).
 * - No mixin annotation processor required (runtime remap is fine).
 * - Reflection is done by "read field, check runtime type", so it's resilient across versions.
 */
@Mixin(RandomFeature.class)
public abstract class OakToLemonTreeMixin {

    // Cache the discovered fields (per-class) once we successfully find them
    private static volatile Field RANDOM_ENTRY_PLACED_FIELD;      // RandomFeatureEntry -> RegistryEntry<PlacedFeature>
    private static volatile Field PLACED_FEATURE_CONFIGURED_FIELD; // PlacedFeature -> RegistryEntry<ConfiguredFeature<?,?>>

    // -----------------------------
    // Redirect 1: chosen entry path
    // -----------------------------
    @Redirect(
            method = "generate(Lnet/minecraft/world/gen/feature/util/FeatureContext;)Z",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/RandomFeatureEntry;generate(" +
                            "Lnet/minecraft/world/StructureWorldAccess;" +
                            "Lnet/minecraft/world/gen/chunk/ChunkGenerator;" +
                            "Lnet/minecraft/util/math/random/Random;" +
                            "Lnet/minecraft/util/math/BlockPos;)Z"
            )
    )
    private boolean mores$redirectEntryGenerate(
            RandomFeatureEntry entry,
            StructureWorldAccess world,
            ChunkGenerator generator,
            Random random,
            BlockPos pos
    ) {
        // Config toggle
        if (!CommonConfig.enableLemonOakWorldgen) {
            return entry.generate(world, generator, random, pos);
        }

        // 1 in N chance (N=10 => 10%)
        int oneIn = Math.max(1, CommonConfig.lemonLeavesReplaceVanillaLeavesChance);
        if (random.nextInt(oneIn) != 0) {
            return entry.generate(world, generator, random, pos);
        }

        // Only swap if the chosen entry is "oak-like"
        if (!mores$isOakEntry(entry)) {
            return entry.generate(world, generator, random, pos);
        }

        // Generate lemon oak instead
        boolean ok = mores$generateLemonOak(world, generator, random, pos);
        return ok || entry.generate(world, generator, random, pos);
    }

    // --------------------------------
    // Redirect 2: defaultFeature fallback
    // --------------------------------
    @Redirect(
            method = "generate(Lnet/minecraft/world/gen/feature/util/FeatureContext;)Z",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/gen/feature/PlacedFeature;generateUnregistered(" +
                            "Lnet/minecraft/world/StructureWorldAccess;" +
                            "Lnet/minecraft/world/gen/chunk/ChunkGenerator;" +
                            "Lnet/minecraft/util/math/random/Random;" +
                            "Lnet/minecraft/util/math/BlockPos;)Z"
            )
    )
    private boolean mores$redirectDefaultGenerate(
            PlacedFeature placed,
            StructureWorldAccess world,
            ChunkGenerator generator,
            Random random,
            BlockPos pos
    ) {
        // Config toggle
        if (!CommonConfig.enableLemonOakWorldgen) {
            return placed.generateUnregistered(world, generator, random, pos);
        }

        // 1 in N chance (N=10 => 10%)
        int oneIn = Math.max(1, CommonConfig.lemonLeavesReplaceVanillaLeavesChance);
        if (random.nextInt(oneIn) != 0) {
            return placed.generateUnregistered(world, generator, random, pos);
        }

        // Only swap if the default is "oak-like"
        if (!mores$isOakPlaced(placed)) {
            return placed.generateUnregistered(world, generator, random, pos);
        }

        boolean ok = mores$generateLemonOak(world, generator, random, pos);
        return ok || placed.generateUnregistered(world, generator, random, pos);
    }

    // -----------------------------
    // Oak detection (reflection)
    // -----------------------------
    private static boolean mores$isOakEntry(RandomFeatureEntry entry) {
        return mores$isOakPlaced(mores$getPlacedFeature(entry));
    }

    private static boolean mores$isOakPlaced(PlacedFeature placed) {
        if (placed == null) return false;

        RegistryEntry<ConfiguredFeature<?, ?>> configuredEntry = mores$getConfiguredFeatureEntry(placed);
        if (configuredEntry == null) return false;

        var optKey = configuredEntry.getKey();
        if (optKey.isEmpty()) return false;

        Identifier id = optKey.get().getValue();
        String path = id.getPath();

        // HARD EXCLUDES (so you don't replace dark oak forests)
        if (path.contains("dark_oak")) return false;

        // Optional: exclude pale oak (some packs / future versions)
        if (path.contains("pale_oak")) return false;

        // Include vanilla oak variants + modded oak variants
        // Examples caught:
        // - oak, fancy_oak, oak_bees_*, fancy_oak_bees_*
        // - modded: mystic_oak_tree, autumn_oak, etc.
        // Also catches "oak_forest_*" configured feature ids used by some biome configs.
        return path.contains("oak");
    }

    /**
     * RandomFeatureEntry -> PlacedFeature
     * Finds the correct RegistryEntry field by reading candidate fields and checking their value() type.
     */
    private static PlacedFeature mores$getPlacedFeature(RandomFeatureEntry entry) {
        try {
            Field f = RANDOM_ENTRY_PLACED_FIELD;
            if (f != null) {
                Object v = f.get(entry);
                PlacedFeature pf = mores$asPlacedFeature(v);
                if (pf != null) return pf;

                // Cache might be stale/wrong across mappings; clear and re-scan.
                RANDOM_ENTRY_PLACED_FIELD = null;
            }

            for (Field field : entry.getClass().getDeclaredFields()) {
                if (!RegistryEntry.class.isAssignableFrom(field.getType())) continue;
                field.setAccessible(true);

                Object v = field.get(entry);
                PlacedFeature pf = mores$asPlacedFeature(v);
                if (pf != null) {
                    RANDOM_ENTRY_PLACED_FIELD = field;
                    return pf;
                }
            }
        } catch (Throwable ignored) {
        }
        return null;
    }

    /**
     * PlacedFeature -> RegistryEntry<ConfiguredFeature<?,?>>
     * Finds the correct RegistryEntry field by reading candidate fields and checking their value() type.
     */
    @SuppressWarnings("unchecked")
    private static RegistryEntry<ConfiguredFeature<?, ?>> mores$getConfiguredFeatureEntry(PlacedFeature placed) {
        try {
            Field f = PLACED_FEATURE_CONFIGURED_FIELD;
            if (f != null) {
                Object v = f.get(placed);
                RegistryEntry<ConfiguredFeature<?, ?>> ce = mores$asConfiguredFeatureEntry(v);
                if (ce != null) return ce;

                PLACED_FEATURE_CONFIGURED_FIELD = null;
            }

            for (Field field : placed.getClass().getDeclaredFields()) {
                if (!RegistryEntry.class.isAssignableFrom(field.getType())) continue;
                field.setAccessible(true);

                Object v = field.get(placed);
                RegistryEntry<ConfiguredFeature<?, ?>> ce = mores$asConfiguredFeatureEntry(v);
                if (ce != null) {
                    PLACED_FEATURE_CONFIGURED_FIELD = field;
                    return ce;
                }
            }
        } catch (Throwable ignored) {
        }
        return null;
    }

    private static PlacedFeature mores$asPlacedFeature(Object maybeRegistryEntry) {
        if (!(maybeRegistryEntry instanceof RegistryEntry<?> re)) return null;
        Object value = re.value();
        return (value instanceof PlacedFeature pf) ? pf : null;
    }

    @SuppressWarnings("unchecked")
    private static RegistryEntry<ConfiguredFeature<?, ?>> mores$asConfiguredFeatureEntry(Object maybeRegistryEntry) {
        if (!(maybeRegistryEntry instanceof RegistryEntry<?> re)) return null;
        Object value = re.value();
        if (!(value instanceof ConfiguredFeature<?, ?>)) return null;
        return (RegistryEntry<ConfiguredFeature<?, ?>>) re;
    }

    // -----------------------------
    // Lemon generation
    // -----------------------------
    private static boolean mores$generateLemonOak(
            StructureWorldAccess world,
            ChunkGenerator generator,
            Random random,
            BlockPos pos
    ) {
        var reg = world.getRegistryManager().get(RegistryKeys.CONFIGURED_FEATURE);
        var lemonOpt = reg.getEntry(ModConfiguredFeatures.LEMON_OAK_TREE_WG);

        if (lemonOpt.isEmpty()) {
            // If not registered for some reason, fail gracefully.
            return false;
        }

        return lemonOpt.get().value().generate(world, generator, random, pos);
    }
}
