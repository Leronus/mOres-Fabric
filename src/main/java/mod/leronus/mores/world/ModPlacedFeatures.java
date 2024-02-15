package mod.leronus.mores.world;

import mod.leronus.mores.Mores;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> OVERWORLD_ANTHRACITE_PLACED_KEY = registerKey("overworld_anthracite_placed");
    public static final RegistryKey<PlacedFeature> NETHER_ANTHRACITE_PLACED_KEY = registerKey("nether_anthracite_placed");

    public static final RegistryKey<PlacedFeature> TIN_UPPER_PLACED_KEY = registerKey("tin_upper_placed");
    public static final RegistryKey<PlacedFeature> TIN_MIDDLE_PLACED_KEY = registerKey("tin_middle_placed");
    public static final RegistryKey<PlacedFeature> TIN_SMALL_PLACED_KEY = registerKey("tin_small_placed");

    public static final RegistryKey<PlacedFeature> COBALT_UPPER_PLACED_KEY = registerKey("cobalt_upper_placed");
    public static final RegistryKey<PlacedFeature> COBALT_MIDDLE_PLACED_KEY = registerKey("cobalt_middle_placed");
    public static final RegistryKey<PlacedFeature> COBALT_SMALL_PLACED_KEY = registerKey("cobalt_small_placed");

    public static final RegistryKey<PlacedFeature> SILVER_UPPER_PLACED_KEY = registerKey("silver_upper_placed");
    public static final RegistryKey<PlacedFeature> SILVER_MIDDLE_PLACED_KEY = registerKey("silver_middle_placed");
    public static final RegistryKey<PlacedFeature> SILVER_SMALL_PLACED_KEY = registerKey("silver_small_placed");
    public static final RegistryKey<PlacedFeature> NETHER_SILVER_PLACED_KEY = registerKey("nether_silver_placed");

    public static final RegistryKey<PlacedFeature> TOPAZ_SMALL_PLACED_KEY = registerKey("topaz_small_placed");
    public static final RegistryKey<PlacedFeature> TOPAZ_LARGE_PLACED_KEY = registerKey("topaz_large_placed");
    public static final RegistryKey<PlacedFeature> TOPAZ_BURIED_PLACED_KEY = registerKey("topaz_buried_placed");

    public static final RegistryKey<PlacedFeature> TOURMALINE_SMALL_PLACED_KEY = registerKey("tourmaline_small_placed");
    public static final RegistryKey<PlacedFeature> TOURMALINE_LARGE_PLACED_KEY = registerKey("tourmaline_large_placed");
    public static final RegistryKey<PlacedFeature> TOURMALINE_BURIED_PLACED_KEY = registerKey("tourmaline_buried_placed");

    public static final RegistryKey<PlacedFeature> RUBY_SMALL_PLACED_KEY = registerKey("ruby_small_placed");
    public static final RegistryKey<PlacedFeature> RUBY_LARGE_PLACED_KEY = registerKey("ruby_large_placed");
    public static final RegistryKey<PlacedFeature> RUBY_BURIED_PLACED_KEY = registerKey("ruby_buried_placed");
    public static final RegistryKey<PlacedFeature> NETHER_RUBY_PLACED_KEY = registerKey("nether_ruby_placed");

    public static final RegistryKey<PlacedFeature> SAPPHIRE_SMALL_PLACED_KEY = registerKey("sapphire_small_placed");
    public static final RegistryKey<PlacedFeature> SAPPHIRE_LARGE_PLACED_KEY = registerKey("sapphire_large_placed");
    public static final RegistryKey<PlacedFeature> SAPPHIRE_BURIED_PLACED_KEY = registerKey("sapphire_buried_placed");
    public static final RegistryKey<PlacedFeature> NETHER_SAPPHIRE_PLACED_KEY = registerKey("nether_sapphire_placed");

    public static final RegistryKey<PlacedFeature> NETHER_TANZANITE_PLACED_KEY = registerKey("nether_tanzanite_placed");

    public static final RegistryKey<PlacedFeature> MOISSANITE_SMALL_PLACED_KEY = registerKey("moissanite_small_placed");
    public static final RegistryKey<PlacedFeature> MOISSANITE_LARGE_PLACED_KEY = registerKey("moissanite_large_placed");
    public static final RegistryKey<PlacedFeature> MOISSANITE_BURIED_PLACED_KEY = registerKey("moissanite_buried_placed");
    public static final RegistryKey<PlacedFeature> NETHER_MOISSANITE_PLACED_KEY = registerKey("nether_moissanite_placed");

    public static final RegistryKey<PlacedFeature> TURQUOISE_SMALL_PLACED_KEY = registerKey("turquoise_small_placed");
    public static final RegistryKey<PlacedFeature> TURQUOISE_LARGE_PLACED_KEY = registerKey("turquoise_large_placed");
    public static final RegistryKey<PlacedFeature> TURQUOISE_BURIED_PLACED_KEY = registerKey("turquoise_buried_placed");

    public static final RegistryKey<PlacedFeature> END_ONYX_PLACED_KEY = registerKey("end_onyx_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, OVERWORLD_ANTHRACITE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OVERWORLD_ANTHRACITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(80))));
        register(context, NETHER_ANTHRACITE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_ANTHRACITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(256))));

        register(context, TIN_UPPER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TIN_UPPER_ORE_KEY),
                ModOrePlacement.modifiersWithCount(13, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(80), YOffset.aboveBottom(312))));
        register(context, TIN_MIDDLE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TIN_MIDDLE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(64), YOffset.aboveBottom(80))));
        register(context, TIN_SMALL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TIN_SMALL_ORE_KEY),
                ModOrePlacement.modifiersWithRarity(4, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(312))));


        //TODO Finish all the values (dont forget to change triangle to uniform for equal distribution &&.aboveBottom() 0 -> y = -64 aka.aboveBottom() 64 would be y = 0
        register(context, SILVER_UPPER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SILVER_UPPER_ORE_KEY),
                ModOrePlacement.modifiersWithCount(13, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(104), YOffset.aboveBottom(312))));
        register(context, SILVER_MIDDLE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SILVER_MIDDLE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(9, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(54), YOffset.aboveBottom(120))));
        register(context, SILVER_SMALL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SILVER_SMALL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(5, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(312))));
        register(context, NETHER_SILVER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_SILVER_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(312))));

        register(context, COBALT_UPPER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COBALT_UPPER_ORE_KEY),
                ModOrePlacement.modifiersWithCount(6, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(84), YOffset.aboveBottom(312))));
        register(context, COBALT_MIDDLE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COBALT_MIDDLE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(12, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(64), YOffset.aboveBottom(84))));
        register(context, COBALT_SMALL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COBALT_SMALL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(5, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(312))));

        register(context, TOPAZ_SMALL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOPAZ_SMALL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(78))));
        register(context, TOPAZ_LARGE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOPAZ_LARGE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(64))));
        register(context, TOPAZ_BURIED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOPAZ_BURIED_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(64))));

        register(context, TOURMALINE_SMALL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOURMALINE_SMALL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(74))));
        register(context, TOURMALINE_LARGE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOURMALINE_LARGE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(1, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(70))));
        register(context, TOURMALINE_BURIED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOURMALINE_BURIED_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(70))));

        register(context, RUBY_SMALL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBY_SMALL_ORE_KEY),
                ModOrePlacement.modifiersWithRarity(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(72))));
        register(context, RUBY_LARGE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBY_LARGE_ORE_KEY),
                ModOrePlacement.modifiersWithRarity(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(42))));
        register(context, RUBY_BURIED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBY_BURIED_ORE_KEY),
                ModOrePlacement.modifiersWithRarity(3, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(52))));
        register(context, NETHER_RUBY_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_RUBY_ORE_KEY),
                ModOrePlacement.modifiersWithCount(4, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(312))));


        register(context, SAPPHIRE_SMALL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPPHIRE_SMALL_ORE_KEY),
                ModOrePlacement.modifiersWithRarity(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(74))));
        register(context, SAPPHIRE_LARGE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPPHIRE_LARGE_ORE_KEY),
                ModOrePlacement.modifiersWithRarity(3, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(36))));
        register(context, SAPPHIRE_BURIED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPPHIRE_BURIED_ORE_KEY),
                ModOrePlacement.modifiersWithRarity(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(46))));
        register(context, NETHER_SAPPHIRE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_SAPPHIRE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(4, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(312))));


        register(context, NETHER_TANZANITE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_TANZANITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(9, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(312))));


        register(context, MOISSANITE_SMALL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MOISSANITE_SMALL_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(80))));
        register(context, MOISSANITE_LARGE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MOISSANITE_LARGE_ORE_KEY),
                ModOrePlacement.modifiersWithRarity(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(20))));
        register(context, MOISSANITE_BURIED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MOISSANITE_BURIED_ORE_KEY),
                ModOrePlacement.modifiersWithRarity(3, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(30))));
        register(context, NETHER_MOISSANITE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_MOISSANITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(7, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(312))));

        register(context, TURQUOISE_SMALL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TURQUOISE_SMALL_ORE_KEY),
                ModOrePlacement.modifiersWithRarity(5, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(12))));
        register(context, TURQUOISE_LARGE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TURQUOISE_LARGE_ORE_KEY),
                ModOrePlacement.modifiersWithRarity(1, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(12))));
        register(context, TURQUOISE_BURIED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TURQUOISE_BURIED_ORE_KEY),
                ModOrePlacement.modifiersWithRarity(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(0), YOffset.aboveBottom(16))));

        register(context, END_ONYX_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_ONYX_ORE_KEY),
                ModOrePlacement.modifiersWithCount(7, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(312))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Mores.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}