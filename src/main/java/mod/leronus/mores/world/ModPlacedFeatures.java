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
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> OVERWORLD_ANTHRACITE_LOWER = registerKey("overworld_anthracite_lower_placed");
    public static final RegistryKey<PlacedFeature> OVERWORLD_ANTHRACITE_UPPER = registerKey("overworld_anthracite_upper_placed");
    public static final RegistryKey<PlacedFeature> NETHER_ANTHRACITE = registerKey("nether_anthracite_placed");

    public static final RegistryKey<PlacedFeature> TIN_SMALL = registerKey("tin_small_placed");
    public static final RegistryKey<PlacedFeature> TIN_LARGE = registerKey("tin_large_placed");

    public static final RegistryKey<PlacedFeature> ELECTRUM_SMALL = registerKey("electrum_small_placed");
    public static final RegistryKey<PlacedFeature> ELECTRUM_LARGE = registerKey("electrum_large_placed");

    public static final RegistryKey<PlacedFeature> SILVER_SMALL = registerKey("silver_small_placed");
    public static final RegistryKey<PlacedFeature> SILVER_MIDDLE = registerKey("silver_middle_placed");
    public static final RegistryKey<PlacedFeature> SILVER_UPPER = registerKey("silver_upper_placed");
    public static final RegistryKey<PlacedFeature> NETHER_SILVER = registerKey("nether_silver_placed");
    public static final RegistryKey<PlacedFeature> ENDER_SILVER = registerKey("ender_silver_placed");

    public static final RegistryKey<PlacedFeature> COBALT_SMALL = registerKey("cobalt_small_placed");
    public static final RegistryKey<PlacedFeature> COBALT_MIDDLE = registerKey("cobalt_middle_placed");
    public static final RegistryKey<PlacedFeature> COBALT_UPPER = registerKey("cobalt_upper_placed");
    public static final RegistryKey<PlacedFeature> ENDER_COBALT = registerKey("ender_cobalt_placed");

    public static final RegistryKey<PlacedFeature> TURQUOISE = registerKey("turquoise_placed");
    public static final RegistryKey<PlacedFeature> TURQUOISE_BURIED = registerKey("turquoise_buried_placed");

    public static final RegistryKey<PlacedFeature> QUARTZ = registerKey("quartz_placed");
    public static final RegistryKey<PlacedFeature> QUARTZ_UPPER = registerKey("quartz_upper_placed");
    public static final RegistryKey<PlacedFeature> CITRINE = registerKey("citrine_placed");
    public static final RegistryKey<PlacedFeature> CITRINE_UPPER = registerKey("citrine_upper_placed");
    public static final RegistryKey<PlacedFeature> NETHER_CITRINE = registerKey("nether_citrine_placed");

    public static final RegistryKey<PlacedFeature> NETHER_ONYX = registerKey("nether_onyx_placed");
    public static final RegistryKey<PlacedFeature> ENDER_ONYX = registerKey("ender_onyx_placed");

    public static final RegistryKey<PlacedFeature> TANZANITE_SMALL = registerKey("tanzanite_small_placed");
    public static final RegistryKey<PlacedFeature> TANZANITE_MEDIUM = registerKey("tanzanite_medium_placed");
    public static final RegistryKey<PlacedFeature> TANZANITE_LARGE = registerKey("tanzanite_large_placed");
    public static final RegistryKey<PlacedFeature> TANZANITE_BURIED = registerKey("tanzanite_buried_placed");
    public static final RegistryKey<PlacedFeature> NETHER_TANZANITE = registerKey("nether_tanzanite_placed");
    public static final RegistryKey<PlacedFeature> ENDER_TANZANITE = registerKey("ender_tanzanite_placed");

    public static final RegistryKey<PlacedFeature> TOPAZ_SMALL = registerKey("topaz_small_placed");
    public static final RegistryKey<PlacedFeature> TOPAZ_MEDIUM = registerKey("topaz_medium_placed");
    public static final RegistryKey<PlacedFeature> TOPAZ_LARGE = registerKey("topaz_large_placed");
    public static final RegistryKey<PlacedFeature> TOPAZ_BURIED = registerKey("topaz_buried_placed");
    public static final RegistryKey<PlacedFeature> NETHER_TOPAZ = registerKey("nether_topaz_placed");
    public static final RegistryKey<PlacedFeature> ENDER_TOPAZ = registerKey("ender_topaz_placed");

    public static final RegistryKey<PlacedFeature> TOURMALINE_SMALL = registerKey("tourmaline_small_placed");
    public static final RegistryKey<PlacedFeature> TOURMALINE_MEDIUM = registerKey("tourmaline_medium_placed");
    public static final RegistryKey<PlacedFeature> TOURMALINE_LARGE = registerKey("tourmaline_large_placed");
    public static final RegistryKey<PlacedFeature> TOURMALINE_BURIED = registerKey("tourmaline_buried_placed");
    public static final RegistryKey<PlacedFeature> NETHER_TOURMALINE = registerKey("nether_tourmaline_placed");
    public static final RegistryKey<PlacedFeature> ENDER_TOURMALINE = registerKey("ender_tourmaline_placed");

    public static final RegistryKey<PlacedFeature> SPINEL_SMALL = registerKey("spinel_small_placed");
    public static final RegistryKey<PlacedFeature> SPINEL_MEDIUM = registerKey("spinel_medium_placed");
    public static final RegistryKey<PlacedFeature> SPINEL_LARGE = registerKey("spinel_large_placed");
    public static final RegistryKey<PlacedFeature> SPINEL_BURIED = registerKey("spinel_buried_placed");
    public static final RegistryKey<PlacedFeature> NETHER_SPINEL = registerKey("nether_spinel_placed");
    public static final RegistryKey<PlacedFeature> ENDER_SPINEL = registerKey("ender_spinel_placed");

    public static final RegistryKey<PlacedFeature> RUBY_SMALL = registerKey("ruby_small_placed");
    public static final RegistryKey<PlacedFeature> RUBY_MEDIUM = registerKey("ruby_medium_placed");
    public static final RegistryKey<PlacedFeature> RUBY_LARGE = registerKey("ruby_large_placed");
    public static final RegistryKey<PlacedFeature> RUBY_BURIED = registerKey("ruby_buried_placed");
    public static final RegistryKey<PlacedFeature> NETHER_RUBY = registerKey("nether_ruby_placed");
    public static final RegistryKey<PlacedFeature> ENDER_RUBY = registerKey("ender_ruby_placed");

    public static final RegistryKey<PlacedFeature> SAPPHIRE_SMALL = registerKey("sapphire_small_placed");
    public static final RegistryKey<PlacedFeature> SAPPHIRE_MEDIUM = registerKey("sapphire_medium_placed");
    public static final RegistryKey<PlacedFeature> SAPPHIRE_LARGE = registerKey("sapphire_large_placed");
    public static final RegistryKey<PlacedFeature> SAPPHIRE_BURIED = registerKey("sapphire_buried_placed");
    public static final RegistryKey<PlacedFeature> NETHER_SAPPHIRE = registerKey("nether_sapphire_placed");
    public static final RegistryKey<PlacedFeature> ENDER_SAPPHIRE = registerKey("ender_sapphire_placed");

    public static final RegistryKey<PlacedFeature> MOISSANITE_SMALL = registerKey("moissanite_small_placed");
    public static final RegistryKey<PlacedFeature> MOISSANITE_MEDIUM = registerKey("moissanite_medium_placed");
    public static final RegistryKey<PlacedFeature> MOISSANITE_LARGE = registerKey("moissanite_large_placed");
    public static final RegistryKey<PlacedFeature> MOISSANITE_BURIED = registerKey("moissanite_buried_placed");
    public static final RegistryKey<PlacedFeature> NETHER_MOISSANITE = registerKey("nether_moissanite_placed");
    public static final RegistryKey<PlacedFeature> ENDER_MOISSANITE = registerKey("ender_moissanite_placed");

    public static final RegistryKey<PlacedFeature> ENDERITE_SMALL = registerKey("enderite_small_placed");
    public static final RegistryKey<PlacedFeature> ENDERITE_LARGE = registerKey("enderite_large_placed");

    public static final RegistryKey<PlacedFeature> LEMON_OAK = registerKey("lemon_oak_placed");

//        ORE_GOLD_DELTAS, registryEntry3, modifiersWithCount(20, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));
//        ORE_QUARTZ_DELTAS, registryEntry4, modifiersWithCount(32, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));
//        ORE_GOLD_NETHER, registryEntry3, modifiersWithCount(10, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));
//        ORE_QUARTZ_NETHER, registryEntry4, modifiersWithCount(16, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE));

//        ORE_COAL_UPPER, registryEntry13, modifiersWithCount(30, HeightRangePlacementModifier.uniform(YOffset.fixed(136), YOffset.getTop())));
//        ORE_COAL_LOWER, registryEntry14, modifiersWithCount(20, HeightRangePlacementModifier.trapezoid(YOffset.fixed(0), YOffset.fixed(192))));
//        ORE_IRON_UPPER, registryEntry15, modifiersWithCount(90, HeightRangePlacementModifier.trapezoid(YOffset.fixed(80), YOffset.fixed(384))));
//        ORE_IRON_MIDDLE, registryEntry15, modifiersWithCount(10, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-24), YOffset.fixed(56))));
//        ORE_IRON_SMALL, registryEntry16, modifiersWithCount(10, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(72))));
//        ORE_GOLD_EXTRA, registryEntry17, modifiersWithCount(50, HeightRangePlacementModifier.uniform(YOffset.fixed(32), YOffset.fixed(256))));
//        ORE_GOLD, registryEntry18, modifiersWithCount(4, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(32))));
//        ORE_GOLD_LOWER, registryEntry18, modifiers(CountPlacementModifier.of(UniformIntProvider.create(0, 1)), HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-48))));
//        ORE_REDSTONE, registryEntry19, modifiersWithCount(4, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(15))));
//        ORE_REDSTONE_LOWER, registryEntry19, modifiersWithCount(8, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-32), YOffset.aboveBottom(32))));
//        ORE_DIAMOND, registryEntry20, modifiersWithCount(7, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
//        ORE_DIAMOND_MEDIUM, registryEntry21, modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-4))));
//        ORE_DIAMOND_LARGE, registryEntry22, modifiersWithRarity(9, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
//        ORE_DIAMOND_BURIED, registryEntry23, modifiersWithCount(4, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
//        ORE_LAPIS, registryEntry24, modifiersWithCount(2, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-32), YOffset.fixed(32))));
//        ORE_LAPIS_BURIED, registryEntry25, modifiersWithCount(4, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))));
//        ORE_EMERALD, registryEntry27, modifiersWithCount(100, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-16), YOffset.fixed(480))));
//        ORE_ANCIENT_DEBRIS_LARGE, registryEntry28, new PlacementModifier[]{SquarePlacementModifier.of(), HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(24)), BiomePlacementModifier.of()});
//        ORE_DEBRIS_SMALL, registryEntry29, new PlacementModifier[]{SquarePlacementModifier.of(), PlacedFeatures.EIGHT_ABOVE_AND_BELOW_RANGE, BiomePlacementModifier.of()});
//        ORE_COPPER, registryEntry30, modifiersWithCount(16, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-16), YOffset.fixed(112))));
//        ORE_COPPER_LARGE, registryEntry31, modifiersWithCount(16, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-16), YOffset.fixed(112))));

//        BOTTOM_TO_TOP_RANGE = HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop());
//        TEN_ABOVE_AND_BELOW_RANGE = HeightRangePlacementModifier.uniform(YOffset.aboveBottom(10), YOffset.belowTop(10));
//        EIGHT_ABOVE_AND_BELOW_RANGE = HeightRangePlacementModifier.uniform(YOffset.aboveBottom(8), YOffset.belowTop(8));
//        FOUR_ABOVE_AND_BELOW_RANGE = HeightRangePlacementModifier.uniform(YOffset.aboveBottom(4), YOffset.belowTop(4));
//        BOTTOM_TO_120_RANGE = HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(256));

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, OVERWORLD_ANTHRACITE_UPPER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OVERWORLD_ANTHRACITE_ORE),
                ModOrePlacement.modifiersWithCount(24, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(64), YOffset.getTop())));
        register(context, OVERWORLD_ANTHRACITE_LOWER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OVERWORLD_ANTHRACITE_ORE),
                ModOrePlacement.modifiersWithCount(16, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.getBottom(), YOffset.fixed(32))));
        register(context, NETHER_ANTHRACITE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_ANTHRACITE_ORE),
                ModOrePlacement.modifiersWithCount(14, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

        register(context, TIN_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TIN_SMALL_ORE),
                ModOrePlacement.modifiersWithCount(13, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-24), YOffset.fixed(104))));
        register(context, TIN_LARGE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TIN_LARGE_ORE),
                ModOrePlacement.modifiersWithCount(9, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-8), YOffset.fixed(120))));

        register(context, ELECTRUM_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ELECTRUM_SMALL_ORE),
                ModOrePlacement.modifiersWithCount(7, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.getBottom(), YOffset.fixed(8))));
        register(context, ELECTRUM_LARGE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ELECTRUM_LARGE_ORE),
                ModOrePlacement.modifiersWithCount(9, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-8), YOffset.fixed(384))));

        register(context, SILVER_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SILVER_SMALL_ORE),
                ModOrePlacement.modifiersWithCount(12, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(90))));
        register(context, SILVER_UPPER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SILVER_UPPER_ORE),
                ModOrePlacement.modifiersWithCount(75, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(90), YOffset.fixed(384))));
        register(context, SILVER_MIDDLE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SILVER_MIDDLE_ORE),
                ModOrePlacement.modifiersWithCount(11, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-8), YOffset.fixed(90))));
        register(context, NETHER_SILVER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_SILVER_ORE),
                ModOrePlacement.modifiersWithCount(14, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));
        register(context, ENDER_SILVER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDER_SILVER_ORE),
                ModOrePlacement.modifiersWithCount(7, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

        register(context, COBALT_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COBALT_SMALL_ORE),
                ModOrePlacement.modifiersWithCount(10, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(80))));
        register(context, COBALT_UPPER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COBALT_UPPER_ORE),
                ModOrePlacement.modifiersWithCount(55, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(80), YOffset.aboveBottom(384))));
        register(context, COBALT_MIDDLE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COBALT_MIDDLE_ORE),
                ModOrePlacement.modifiersWithCount(10, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-56), YOffset.fixed(24))));
        register(context, ENDER_COBALT, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDER_COBALT_ORE),
                ModOrePlacement.modifiersWithCount(7, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

        register(context, TURQUOISE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TURQUOISE_ORE),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-32), YOffset.fixed(24))));
        register(context, TURQUOISE_BURIED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TURQUOISE_BURIED_ORE),
                ModOrePlacement.modifiersWithCount(4, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))));

        register(context, QUARTZ, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.QUARTZ_ORE),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-32), YOffset.fixed(24))));
        register(context, QUARTZ_UPPER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.QUARTZ_ORE),
                ModOrePlacement.modifiersWithCount(9, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(128), YOffset.fixed(384))));
        register(context, CITRINE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CITRINE_ORE),
                ModOrePlacement.modifiersWithCount(1, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-32), YOffset.fixed(32))));
        register(context, CITRINE_UPPER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CITRINE_ORE),
                ModOrePlacement.modifiersWithCount(8, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(128), YOffset.fixed(384))));
        register(context, NETHER_CITRINE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_CITRINE_ORE),
                ModOrePlacement.modifiersWithCount(14, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

        register(context, NETHER_ONYX, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_ONYX_ORE),
                ModOrePlacement.modifiersWithCount(12, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));
        register(context, ENDER_ONYX, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDER_ONYX_ORE),
                ModOrePlacement.modifiersWithCount(10, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

        register(context, TANZANITE_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TANZANITE_SMALL_ORE),
                ModOrePlacement.modifiersWithCount(7, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-70), YOffset.aboveBottom(70))));
        register(context, TANZANITE_MEDIUM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TANZANITE_MEDIUM_ORE),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-54), YOffset.fixed(6))));
        register(context, TANZANITE_LARGE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TANZANITE_LARGE_ORE),
                ModOrePlacement.modifiersWithRarity(7, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-70), YOffset.aboveBottom(70))));
        register(context, TANZANITE_BURIED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TANZANITE_BURIED_ORE),
                ModOrePlacement.modifiersWithCount(4, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-70), YOffset.aboveBottom(70))));
        register(context, NETHER_TANZANITE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_TANZANITE_ORE),
                ModOrePlacement.modifiersWithCount(6, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));
        register(context, ENDER_TANZANITE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDER_TANZANITE_ORE),
                ModOrePlacement.modifiersWithCount(6, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

        register(context, TOPAZ_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOPAZ_SMALL_ORE),
                ModOrePlacement.modifiersWithCount(7, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-65), YOffset.aboveBottom(75))));
        register(context, TOPAZ_MEDIUM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOPAZ_MEDIUM_ORE),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-44), YOffset.fixed(16))));
        register(context, TOPAZ_LARGE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOPAZ_LARGE_ORE),
                ModOrePlacement.modifiersWithRarity(8, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-65), YOffset.aboveBottom(65))));
        register(context, TOPAZ_BURIED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOPAZ_BURIED_ORE),
                ModOrePlacement.modifiersWithCount(4, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-65), YOffset.aboveBottom(75))));
        register(context, NETHER_TOPAZ, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_TOPAZ_ORE),
                ModOrePlacement.modifiersWithCount(6, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));
        register(context, ENDER_TOPAZ, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDER_TOPAZ_ORE),
                ModOrePlacement.modifiersWithCount(6, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

        register(context, TOURMALINE_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOURMALINE_SMALL_ORE),
                ModOrePlacement.modifiersWithCount(7, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-65), YOffset.aboveBottom(75))));
        register(context, TOURMALINE_MEDIUM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOURMALINE_MEDIUM_ORE),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-44), YOffset.fixed(16))));
        register(context, TOURMALINE_LARGE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOURMALINE_LARGE_ORE),
                ModOrePlacement.modifiersWithRarity(8, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-65), YOffset.aboveBottom(65))));
        register(context, TOURMALINE_BURIED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TOURMALINE_BURIED_ORE),
                ModOrePlacement.modifiersWithCount(4, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-65), YOffset.aboveBottom(65))));
        register(context, NETHER_TOURMALINE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_TOURMALINE_ORE),
                ModOrePlacement.modifiersWithCount(6, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));
        register(context, ENDER_TOURMALINE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDER_TOURMALINE_ORE),
                ModOrePlacement.modifiersWithCount(6, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

        register(context, SPINEL_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SPINEL_SMALL_ORE),
                ModOrePlacement.modifiersWithCount(6, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-70), YOffset.aboveBottom(70))));
        register(context, SPINEL_MEDIUM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SPINEL_MEDIUM_ORE),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-54), YOffset.fixed(6))));
        register(context, SPINEL_LARGE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SPINEL_LARGE_ORE),
                ModOrePlacement.modifiersWithRarity(7, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-70), YOffset.aboveBottom(65))));
        register(context, SPINEL_BURIED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SPINEL_BURIED_ORE),
                ModOrePlacement.modifiersWithCount(5, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-70), YOffset.aboveBottom(65))));
        register(context, NETHER_SPINEL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_SPINEL_ORE),
                ModOrePlacement.modifiersWithCount(5, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));
        register(context, ENDER_SPINEL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDER_SPINEL_ORE),
                ModOrePlacement.modifiersWithCount(5, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

        register(context, RUBY_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBY_SMALL_ORE),
                ModOrePlacement.modifiersWithCount(6, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-90), YOffset.aboveBottom(75))));
        register(context, RUBY_MEDIUM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBY_MEDIUM_ORE),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-64), YOffset.aboveBottom(-4))));
        register(context, RUBY_LARGE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBY_LARGE_ORE),
                ModOrePlacement.modifiersWithRarity(6, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-100), YOffset.aboveBottom(65))));
        register(context, RUBY_BURIED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RUBY_BURIED_ORE),
                ModOrePlacement.modifiersWithCount(4, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-90), YOffset.aboveBottom(70))));
        register(context, NETHER_RUBY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_RUBY_ORE),
                ModOrePlacement.modifiersWithCount(4, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));
        register(context, ENDER_RUBY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDER_RUBY_ORE),
                ModOrePlacement.modifiersWithCount(4, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));


        register(context, SAPPHIRE_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPPHIRE_SMALL_ORE),
                ModOrePlacement.modifiersWithCount(7, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-90), YOffset.aboveBottom(75))));
        register(context, SAPPHIRE_MEDIUM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPPHIRE_MEDIUM_ORE),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-4))));
        register(context, SAPPHIRE_LARGE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPPHIRE_LARGE_ORE),
                ModOrePlacement.modifiersWithRarity(6, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-100), YOffset.aboveBottom(65))));
        register(context, SAPPHIRE_BURIED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPPHIRE_BURIED_ORE),
                ModOrePlacement.modifiersWithCount(3, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-90), YOffset.aboveBottom(70))));
        register(context, NETHER_SAPPHIRE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_SAPPHIRE_ORE),
                ModOrePlacement.modifiersWithCount(4, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));
        register(context, ENDER_SAPPHIRE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDER_SAPPHIRE_ORE),
                ModOrePlacement.modifiersWithCount(4, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));


        register(context, MOISSANITE_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MOISSANITE_SMALL_ORE),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-120), YOffset.aboveBottom(70))));
        register(context, MOISSANITE_MEDIUM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MOISSANITE_MEDIUM_ORE),
                ModOrePlacement.modifiersWithCount(1, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(6))));
        register(context, MOISSANITE_LARGE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MOISSANITE_LARGE_ORE),
                ModOrePlacement.modifiersWithRarity(2, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-120), YOffset.aboveBottom(40))));
        register(context, MOISSANITE_BURIED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MOISSANITE_BURIED_ORE),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-120), YOffset.aboveBottom(40))));
        register(context, NETHER_MOISSANITE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_MOISSANITE_ORE),
                ModOrePlacement.modifiersWithCount(3, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));
        register(context, ENDER_MOISSANITE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDER_MOISSANITE_ORE),
                ModOrePlacement.modifiersWithCount(3, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

        register(context, ENDERITE_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDERITE_SMALL_ORE),
                ModOrePlacement.modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));
        register(context, ENDERITE_LARGE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDERITE_LARGE_ORE),
                ModOrePlacement.modifiersWithCount(1, // VeinsPerChunk
                        HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())));

        register(context, LEMON_OAK, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LEMON_OAK_TREE_WG),
                List.of(
                        // placement rules match vanilla oak
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        SquarePlacementModifier.of(),
                        BiomePlacementModifier.of()
                ));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Mores.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}