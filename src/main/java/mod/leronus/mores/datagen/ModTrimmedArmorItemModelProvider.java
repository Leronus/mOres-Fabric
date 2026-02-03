package mod.leronus.mores.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public final class ModTrimmedArmorItemModelProvider implements DataProvider {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final FabricDataOutput output;

    private record TrimDef(String name, float idx) {}

    // Vanilla trim_type values (Mojang)
    private static final List<TrimDef> VANILLA_TRIMS = List.of(
            new TrimDef("quartz", 0.1f),
            new TrimDef("iron", 0.2f),
            new TrimDef("gold", 0.3f),
            new TrimDef("diamond", 0.4f),
            new TrimDef("netherite", 0.5f),
            new TrimDef("redstone", 0.6f),
            new TrimDef("copper", 0.7f),
            new TrimDef("emerald", 0.8f),
            new TrimDef("lapis", 0.9f),
            new TrimDef("amethyst", 1.0f)
    );

    // MUST match ModTrimMaterials itemModelIndex exactly
    private static final List<TrimDef> MORES_TRIMS = List.of(
            new TrimDef("tin", 0.11f),
            new TrimDef("silver", 0.12f),
            new TrimDef("sterling_silver", 0.13f),
            new TrimDef("rose_gold", 0.14f),
            new TrimDef("bronze", 0.15f),
            new TrimDef("cobalt", 0.16f),
            new TrimDef("carbon_steel", 0.17f),
            new TrimDef("hardened_steel", 0.18f),

            new TrimDef("citrine", 0.19f),
            new TrimDef("onyx", 0.21f),
            new TrimDef("turquoise", 0.22f),
            new TrimDef("topaz", 0.23f),
            new TrimDef("tourmaline", 0.24f),
            new TrimDef("spinel", 0.25f),
            new TrimDef("ruby", 0.26f),
            new TrimDef("sapphire", 0.27f),
            new TrimDef("moissanite", 0.28f),

            new TrimDef("obsidian", 0.31f),
            new TrimDef("adamantium", 0.33f),
            new TrimDef("enderite", 0.34f)
    );

    public ModTrimmedArmorItemModelProvider(FabricDataOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        DataOutput.PathResolver models = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "models/item");

        return CompletableFuture.allOf(
                // ----- VANILLA ARMOR (so your custom trim materials render on vanilla armor items) -----
                writeVanillaArmor(writer, models, Items.DIAMOND_HELMET, "diamond_helmet", "helmet"),
                writeVanillaArmor(writer, models, Items.DIAMOND_CHESTPLATE, "diamond_chestplate", "chestplate"),
                writeVanillaArmor(writer, models, Items.DIAMOND_LEGGINGS, "diamond_leggings", "leggings"),
                writeVanillaArmor(writer, models, Items.DIAMOND_BOOTS, "diamond_boots", "boots"),

                writeVanillaArmor(writer, models, Items.IRON_HELMET, "iron_helmet", "helmet"),
                writeVanillaArmor(writer, models, Items.IRON_CHESTPLATE, "iron_chestplate", "chestplate"),
                writeVanillaArmor(writer, models, Items.IRON_LEGGINGS, "iron_leggings", "leggings"),
                writeVanillaArmor(writer, models, Items.IRON_BOOTS, "iron_boots", "boots"),

                writeVanillaArmor(writer, models, Items.NETHERITE_HELMET, "netherite_helmet", "helmet"),
                writeVanillaArmor(writer, models, Items.NETHERITE_CHESTPLATE, "netherite_chestplate", "chestplate"),
                writeVanillaArmor(writer, models, Items.NETHERITE_LEGGINGS, "netherite_leggings", "leggings"),
                writeVanillaArmor(writer, models, Items.NETHERITE_BOOTS, "netherite_boots", "boots"),

                writeVanillaArmor(writer, models, Items.GOLDEN_HELMET, "golden_helmet", "helmet"),
                writeVanillaArmor(writer, models, Items.GOLDEN_CHESTPLATE, "golden_chestplate", "chestplate"),
                writeVanillaArmor(writer, models, Items.GOLDEN_LEGGINGS, "golden_leggings", "leggings"),
                writeVanillaArmor(writer, models, Items.GOLDEN_BOOTS, "golden_boots", "boots"),

                writeVanillaArmor(writer, models, Items.CHAINMAIL_HELMET, "chainmail_helmet", "helmet"),
                writeVanillaArmor(writer, models, Items.CHAINMAIL_CHESTPLATE, "chainmail_chestplate", "chestplate"),
                writeVanillaArmor(writer, models, Items.CHAINMAIL_LEGGINGS, "chainmail_leggings", "leggings"),
                writeVanillaArmor(writer, models, Items.CHAINMAIL_BOOTS, "chainmail_boots", "boots"),

                // ----- Metals -----
                writeArmor(writer, models, ModItems.TIN_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.TIN_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.TIN_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.TIN_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.SILVER_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.SILVER_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.SILVER_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.SILVER_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.COPPER_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.COPPER_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.COPPER_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.COPPER_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.STERLING_SILVER_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.STERLING_SILVER_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.STERLING_SILVER_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.STERLING_SILVER_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.ROSE_GOLD_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.ROSE_GOLD_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.ROSE_GOLD_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.ROSE_GOLD_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.BRONZE_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.BRONZE_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.BRONZE_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.BRONZE_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.COBALT_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.COBALT_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.COBALT_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.COBALT_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.CARBON_STEEL_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.CARBON_STEEL_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.CARBON_STEEL_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.CARBON_STEEL_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.HARDENED_STEEL_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.HARDENED_STEEL_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.HARDENED_STEEL_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.HARDENED_STEEL_BOOTS, "boots"),

                // ----- Gems / misc -----
                writeArmor(writer, models, ModItems.AMETHYST_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.AMETHYST_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.AMETHYST_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.AMETHYST_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.LAPIS_LAZULI_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.LAPIS_LAZULI_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.LAPIS_LAZULI_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.LAPIS_LAZULI_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.TURQUOISE_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.TURQUOISE_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.TURQUOISE_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.TURQUOISE_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.TANZANITE_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.TANZANITE_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.TANZANITE_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.TANZANITE_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.TOPAZ_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.TOPAZ_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.TOPAZ_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.TOPAZ_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.TOURMALINE_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.TOURMALINE_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.TOURMALINE_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.TOURMALINE_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.EMERALD_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.EMERALD_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.EMERALD_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.EMERALD_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.RUBY_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.RUBY_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.RUBY_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.RUBY_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.SAPPHIRE_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.SAPPHIRE_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.SAPPHIRE_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.SAPPHIRE_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.SPINEL_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.SPINEL_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.SPINEL_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.SPINEL_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.CITRINE_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.CITRINE_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.CITRINE_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.CITRINE_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.MOISSANITE_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.MOISSANITE_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.MOISSANITE_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.MOISSANITE_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.OBSIDIAN_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.OBSIDIAN_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.OBSIDIAN_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.OBSIDIAN_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.ONYX_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.ONYX_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.ONYX_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.ONYX_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.GRAPHENE_CHAINMAIL_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.GRAPHENE_CHAINMAIL_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.GRAPHENE_CHAINMAIL_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.GRAPHENE_CHAINMAIL_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.ADAMANTIUM_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.ADAMANTIUM_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.ADAMANTIUM_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.ADAMANTIUM_BOOTS, "boots"),

                writeArmor(writer, models, ModItems.ENDERITE_HELMET, "helmet"),
                writeArmor(writer, models, ModItems.ENDERITE_CHESTPLATE, "chestplate"),
                writeArmor(writer, models, ModItems.ENDERITE_LEGGINGS, "leggings"),
                writeArmor(writer, models, ModItems.ENDERITE_BOOTS, "boots")
        );
    }

    private static CompletableFuture<?> writeArmor(DataWriter writer, DataOutput.PathResolver models, Item armorItem, String piece) {
        Identifier id = Registries.ITEM.getId(armorItem);
        String modid = id.getNamespace();
        String armorPath = id.getPath();

        JsonObject base = new JsonObject();
        base.addProperty("parent", "minecraft:item/generated");

        JsonObject textures = new JsonObject();
        textures.addProperty("layer0", modid + ":item/" + armorPath);
        base.add("textures", textures);

        JsonArray overrides = new JsonArray();
        CompletableFuture<?> all = CompletableFuture.completedFuture(null);

        for (TrimDef t : VANILLA_TRIMS) {
            overrides.add(makeOverride(modid, armorPath, t.name(), t.idx()));
            all = CompletableFuture.allOf(all, writePerTrim(writer, models, modid, armorPath, piece, t.name()));
        }
        for (TrimDef t : MORES_TRIMS) {
            overrides.add(makeOverride(modid, armorPath, t.name(), t.idx()));
            all = CompletableFuture.allOf(all, writePerTrim(writer, models, modid, armorPath, piece, t.name()));
        }

        base.add("overrides", overrides);

        Path basePath = models.resolve(Identifier.of(modid + ":" + armorPath), "json");
        return CompletableFuture.allOf(all, DataProvider.writeToPath(writer, GSON.toJsonTree(base), basePath));
    }

    private CompletableFuture<?> writeVanillaArmor(
            DataWriter writer,
            DataOutput.PathResolver models,
            Item item,
            String vanillaItemName,   // e.g. "diamond_helmet"
            String piece              // "helmet", "chestplate", "leggings", "boots"
    ) {
        Identifier baseModelId = Identifier.of("minecraft", vanillaItemName);

        JsonObject base = new JsonObject();
        base.addProperty("parent", "minecraft:item/generated");

        JsonObject textures = new JsonObject();
        textures.addProperty("layer0", "minecraft:item/" + vanillaItemName);
        base.add("textures", textures);

        // overrides
        JsonArray overrides = new JsonArray();

        // vanilla trims + your trims
        for (TrimDef t : VANILLA_TRIMS) {
            overrides.add(trimOverride("minecraft:item/" + vanillaItemName + "_" + t.name + "_trim", t.idx));
            writeVanillaTrimModel(writer, models, vanillaItemName, piece, t.name);
        }
        for (TrimDef t : MORES_TRIMS) {
            overrides.add(trimOverride("minecraft:item/" + vanillaItemName + "_" + t.name + "_trim", t.idx));
            writeVanillaTrimModel(writer, models, vanillaItemName, piece, t.name);
        }

        base.add("overrides", overrides);

        Path path = models.resolve(baseModelId, "json");
        return DataProvider.writeToPath(writer, base, path);
    }

    private JsonObject trimOverride(String model, float idx) {
        JsonObject o = new JsonObject();
        JsonObject pred = new JsonObject();
        pred.addProperty("trim_type", idx);
        o.add("predicate", pred);
        o.addProperty("model", model);
        return o;
    }

    private CompletableFuture<?> writeVanillaTrimModel(
            DataWriter writer,
            DataOutput.PathResolver models,
            String vanillaItemName,
            String piece,
            String trimName
    ) {
        Identifier modelId = Identifier.of("minecraft", vanillaItemName + "_" + trimName + "_trim");

        JsonObject m = new JsonObject();
        m.addProperty("parent", "minecraft:item/generated");

        JsonObject tex = new JsonObject();
        tex.addProperty("layer0", "minecraft:item/" + vanillaItemName);
        tex.addProperty("layer1", "minecraft:trims/items/" + piece + "_trim_" + trimName);
        m.add("textures", tex);

        Path path = models.resolve(modelId, "json");
        return DataProvider.writeToPath(writer, m, path);
    }


    private static CompletableFuture<?> writePerTrim(DataWriter writer, DataOutput.PathResolver models, String modid, String armorPath, String piece, String trimName) {
        JsonObject m = new JsonObject();
        m.addProperty("parent", "minecraft:item/generated");

        JsonObject textures = new JsonObject();
        textures.addProperty("layer0", modid + ":item/" + armorPath);
        textures.addProperty("layer1", "minecraft:trims/items/" + piece + "_trim_" + trimName);
        m.add("textures", textures);

        Path p = models.resolve(Identifier.of(modid + ":" + armorPath + "_" + trimName + "_trim"), "json");
        return DataProvider.writeToPath(writer, GSON.toJsonTree(m), p);
    }

    private static JsonObject makeOverride(String modid, String armorPath, String trimName, float idx) {
        JsonObject obj = new JsonObject();

        JsonObject predicate = new JsonObject();
        predicate.addProperty("trim_type", idx);
        obj.add("predicate", predicate);

        obj.addProperty("model", modid + ":item/" + armorPath + "_" + trimName + "_trim");
        return obj;
    }

    @Override
    public String getName() {
        return "Trimmed Armor Item Models";
    }
}
