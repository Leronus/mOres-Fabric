package mod.leronus.mores.world;

import mod.leronus.mores.Mores;
import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.config.CommonConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> OVERWORLD_ANTHRACITE_ORE = registerKey("overworld_anthracite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_ANTHRACITE_ORE = registerKey("nether_anthracite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_LARGE_ORE = registerKey("tin_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_SMALL_ORE = registerKey("tin_small_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SILVER_SMALL_ORE = registerKey("silver_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SILVER_UPPER_ORE = registerKey("silver_upper_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SILVER_MIDDLE_ORE = registerKey("silver_middle_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_SILVER_ORE = registerKey("nether_silver_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_SILVER_ORE = registerKey("ender_silver_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> COBALT_SMALL_ORE = registerKey("cobalt_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COBALT_UPPER_ORE = registerKey("cobalt_upper_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COBALT_MIDDLE_ORE = registerKey("cobalt_middle_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_COBALT_ORE = registerKey("ender_cobalt_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TURQUOISE_ORE = registerKey("turquoise_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TURQUOISE_BURIED_ORE = registerKey("turquoise_buried_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> QUARTZ_ORE = registerKey("quartz_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CITRINE_ORE = registerKey("citrine_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_CITRINE_ORE = registerKey("nether_citrine_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TANZANITE_SMALL_ORE = registerKey("tanzanite_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TANZANITE_LARGE_ORE = registerKey("tanzanite_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TANZANITE_BURIED_ORE = registerKey("tanzanite_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TANZANITE_MEDIUM_ORE = registerKey("tanzanite_medium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TANZANITE_ORE = registerKey("nether_tanzanite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_TANZANITE_ORE = registerKey("ender_tanzanite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TOPAZ_SMALL_ORE = registerKey("topaz_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOPAZ_LARGE_ORE = registerKey("topaz_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOPAZ_BURIED_ORE = registerKey("topaz_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOPAZ_MEDIUM_ORE = registerKey("topaz_medium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TOPAZ_ORE = registerKey("nether_topaz_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_TOPAZ_ORE = registerKey("ender_topaz_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TOURMALINE_SMALL_ORE = registerKey("tourmaline_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOURMALINE_LARGE_ORE = registerKey("tourmaline_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOURMALINE_BURIED_ORE = registerKey("tourmaline_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOURMALINE_MEDIUM_ORE = registerKey("tourmaline_medium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TOURMALINE_ORE = registerKey("nether_tourmaline_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_TOURMALINE_ORE = registerKey("ender_tourmaline_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_SMALL_ORE = registerKey("ruby_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_LARGE_ORE = registerKey("ruby_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_BURIED_ORE = registerKey("ruby_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_MEDIUM_ORE = registerKey("ruby_medium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_RUBY_ORE = registerKey("nether_ruby_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_RUBY_ORE = registerKey("ender_ruby_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_SMALL_ORE = registerKey("sapphire_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_LARGE_ORE = registerKey("sapphire_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_BURIED_ORE = registerKey("sapphire_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_MEDIUM_ORE = registerKey("sapphire_medium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_SAPPHIRE_ORE = registerKey("nether_sapphire_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_SAPPHIRE_ORE = registerKey("ender_sapphire_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SPINEL_SMALL_ORE = registerKey("spinel_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPINEL_LARGE_ORE = registerKey("spinel_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPINEL_BURIED_ORE = registerKey("spinel_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPINEL_MEDIUM_ORE = registerKey("spinel_medium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_SPINEL_ORE = registerKey("nether_spinel_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_SPINEL_ORE = registerKey("ender_spinel_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MOISSANITE_SMALL_ORE = registerKey("moissanite_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOISSANITE_LARGE_ORE = registerKey("moissanite_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOISSANITE_BURIED_ORE = registerKey("moissanite_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOISSANITE_MEDIUM_ORE = registerKey("moissanite_medium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_MOISSANITE_ORE = registerKey("nether_moissanite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_MOISSANITE_ORE = registerKey("ender_moissanite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_ONYX_ORE = registerKey("nether_onyx_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_ONYX_ORE = registerKey("ender_onyx_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDERITE_SMALL_ORE = registerKey("enderite_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDERITE_LARGE_ORE = registerKey("enderite_large_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> LEMON_OAK_TREE_WG =
            registerKey("lemon_oak_tree_wg");

    public static final RegistryKey<ConfiguredFeature<?, ?>> LEMON_OAK_TREE_SAPLING =
            registerKey("lemon_oak_tree_sapling");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        // --- Overworld ores (stone + deepslate + "universal" variants) ---
        List<OreFeatureConfig.Target> OVERWORLD_TIN_ORES = List.of(
                // specific blocks first -> overrides generic STONE_ORE_REPLACEABLES
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.ANDESITE), ModBlocks.ANDESITE_TIN_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRANITE), ModBlocks.GRANITE_TIN_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.TUFF), ModBlocks.TUFF_TIN_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRAVEL), ModBlocks.GRAVEL_TIN_ORE.getDefaultState()),

                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TIN_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TIN_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_COBALT_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.ANDESITE), ModBlocks.ANDESITE_COBALT_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DIORITE), ModBlocks.DIORITE_COBALT_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRANITE), ModBlocks.GRANITE_COBALT_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.TUFF), ModBlocks.TUFF_COBALT_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.CALCITE), ModBlocks.CALCITE_COBALT_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRAVEL), ModBlocks.GRAVEL_COBALT_ORE.getDefaultState()),

                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.COBALT_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_COBALT_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_SILVER_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.ANDESITE), ModBlocks.ANDESITE_SILVER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DIORITE), ModBlocks.DIORITE_SILVER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRANITE), ModBlocks.GRANITE_SILVER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.TUFF), ModBlocks.TUFF_SILVER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.CALCITE), ModBlocks.CALCITE_SILVER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRAVEL), ModBlocks.GRAVEL_SILVER_ORE.getDefaultState()),

                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.SILVER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_SILVER_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_TURQUOISE_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TURQUOISE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TURQUOISE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_QUARTZ_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.QUARTZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_QUARTZ_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_CITRINE_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.CITRINE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_TANZANITE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.ANDESITE), ModBlocks.ANDESITE_TANZANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DIORITE), ModBlocks.DIORITE_TANZANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRANITE), ModBlocks.GRANITE_TANZANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.TUFF), ModBlocks.TUFF_TANZANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.CALCITE), ModBlocks.CALCITE_TANZANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRAVEL), ModBlocks.GRAVEL_TANZANITE_ORE.getDefaultState()),

                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TANZANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TANZANITE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_TOPAZ_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.ANDESITE), ModBlocks.ANDESITE_TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DIORITE), ModBlocks.DIORITE_TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRANITE), ModBlocks.GRANITE_TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.TUFF), ModBlocks.TUFF_TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.CALCITE), ModBlocks.CALCITE_TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRAVEL), ModBlocks.GRAVEL_TOPAZ_ORE.getDefaultState()),

                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TOPAZ_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_TOURMALINE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.ANDESITE), ModBlocks.ANDESITE_TOURMALINE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DIORITE), ModBlocks.DIORITE_TOURMALINE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRANITE), ModBlocks.GRANITE_TOURMALINE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.TUFF), ModBlocks.TUFF_TOURMALINE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.CALCITE), ModBlocks.CALCITE_TOURMALINE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRAVEL), ModBlocks.GRAVEL_TOURMALINE_ORE.getDefaultState()),

                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TOURMALINE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TOURMALINE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_SPINEL_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.ANDESITE), ModBlocks.ANDESITE_SPINEL_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DIORITE), ModBlocks.DIORITE_SPINEL_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRANITE), ModBlocks.GRANITE_SPINEL_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.TUFF), ModBlocks.TUFF_SPINEL_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.CALCITE), ModBlocks.CALCITE_SPINEL_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRAVEL), ModBlocks.GRAVEL_SPINEL_ORE.getDefaultState()),

                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.SPINEL_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_SPINEL_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_SAPPHIRE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.ANDESITE), ModBlocks.ANDESITE_SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DIORITE), ModBlocks.DIORITE_SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRANITE), ModBlocks.GRANITE_SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.TUFF), ModBlocks.TUFF_SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.CALCITE), ModBlocks.CALCITE_SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRAVEL), ModBlocks.GRAVEL_SAPPHIRE_ORE.getDefaultState()),

                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_RUBY_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.ANDESITE), ModBlocks.ANDESITE_RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DIORITE), ModBlocks.DIORITE_RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRANITE), ModBlocks.GRANITE_RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.TUFF), ModBlocks.TUFF_RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.CALCITE), ModBlocks.CALCITE_RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRAVEL), ModBlocks.GRAVEL_RUBY_ORE.getDefaultState()),

                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_MOISSANITE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.ANDESITE), ModBlocks.ANDESITE_MOISSANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.DIORITE), ModBlocks.DIORITE_MOISSANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRANITE), ModBlocks.GRANITE_MOISSANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.TUFF), ModBlocks.TUFF_MOISSANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.CALCITE), ModBlocks.CALCITE_MOISSANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.GRAVEL), ModBlocks.GRAVEL_MOISSANITE_ORE.getDefaultState()),

                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.MOISSANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_MOISSANITE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> OVERWORLD_ANTHRACITE_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.ANTHRACITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_ANTHRACITE_ORE.getDefaultState())
        );

        // --- Nether ores ---
        List<OreFeatureConfig.Target> NETHER_SILVER_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_SILVER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BASALT), ModBlocks.BASALT_SILVER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BLACKSTONE), ModBlocks.BLACKSTONE_SILVER_ORE.getDefaultState())
        );


        List<OreFeatureConfig.Target> NETHER_CITRINE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_CITRINE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> NETHER_ONYX_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_ONYX_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> NETHER_TANZANITE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_TANZANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BASALT), ModBlocks.BASALT_TANZANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BLACKSTONE), ModBlocks.BLACKSTONE_TANZANITE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> NETHER_TOPAZ_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BASALT), ModBlocks.BASALT_TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BLACKSTONE), ModBlocks.BLACKSTONE_TOPAZ_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> NETHER_TOURMALINE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_TOURMALINE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BASALT), ModBlocks.BASALT_TOURMALINE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BLACKSTONE), ModBlocks.BLACKSTONE_TOURMALINE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> NETHER_SPINEL_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_SPINEL_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BASALT), ModBlocks.BASALT_SPINEL_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BLACKSTONE), ModBlocks.BLACKSTONE_SPINEL_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> NETHER_RUBY_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BASALT), ModBlocks.BASALT_RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BLACKSTONE), ModBlocks.BLACKSTONE_RUBY_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> NETHER_SAPPHIRE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BASALT), ModBlocks.BASALT_SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BLACKSTONE), ModBlocks.BLACKSTONE_SAPPHIRE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> NETHER_MOISSANITE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_MOISSANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BASALT), ModBlocks.BASALT_MOISSANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BLACKSTONE), ModBlocks.BLACKSTONE_MOISSANITE_ORE.getDefaultState())
        );

        List<OreFeatureConfig.Target> NETHER_ANTHRACITE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_ANTHRACITE_ORE.getDefaultState())
        );

        // --- Ender ores (netherrack + basalt + blackstone variants where you have them) ---
        List<OreFeatureConfig.Target> ENDER_SILVER_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDER_SILVER_ORE.getDefaultState())
        );
        List<OreFeatureConfig.Target> ENDER_COBALT_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDER_COBALT_ORE.getDefaultState())
        );
        List<OreFeatureConfig.Target> ENDER_ONYX_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDER_ONYX_ORE.getDefaultState())
        );
        List<OreFeatureConfig.Target> ENDER_TANZANITE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDER_TANZANITE_ORE.getDefaultState())
        );
        List<OreFeatureConfig.Target> ENDER_TOURMALINE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDER_TOURMALINE_ORE.getDefaultState())
        );
        List<OreFeatureConfig.Target> ENDER_TOPAZ_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDER_TOPAZ_ORE.getDefaultState())
        );
        List<OreFeatureConfig.Target> ENDER_RUBY_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDER_RUBY_ORE.getDefaultState())
        );
        List<OreFeatureConfig.Target> ENDER_SAPPHIRE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDER_SAPPHIRE_ORE.getDefaultState())
        );
        List<OreFeatureConfig.Target> ENDER_SPINEL_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDER_SPINEL_ORE.getDefaultState())
        );
        List<OreFeatureConfig.Target> ENDER_MOISSANITE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDER_MOISSANITE_ORE.getDefaultState())
        );
        List<OreFeatureConfig.Target> ENDERITE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.PRIMORDIAL_DEBRIS.getDefaultState())
        );
        //        ORE_NETHER_GOLD, Feature.ORE, new OreFeatureConfig(ruleTest4, Blocks.NETHER_GOLD_ORE.getDefaultState(), 10));
        //        ORE_QUARTZ, Feature.ORE, new OreFeatureConfig(ruleTest4, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 14));
        //        ORE_COAL, Feature.ORE, new OreFeatureConfig(list6, 17));
        //        ORE_COAL_BURIED, Feature.ORE, new OreFeatureConfig(list6, 17, 0.5F));
        //        ORE_IRON, Feature.ORE, new OreFeatureConfig(list, 9));
        //        ORE_IRON_SMALL, Feature.ORE, new OreFeatureConfig(list, 4));
        //        ORE_GOLD, Feature.ORE, new OreFeatureConfig(list2, 9));
        //        ORE_GOLD_BURIED, Feature.ORE, new OreFeatureConfig(list2, 9, 0.5F));
        //        ORE_REDSTONE, Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(ruleTest2, Blocks.REDSTONE_ORE.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, Blocks.DEEPSLATE_REDSTONE_ORE.getDefaultState())), 8));
        //        ORE_DIAMOND_SMALL, Feature.ORE, new OreFeatureConfig(list3, 4, 0.5F));
        //        ORE_DIAMOND_LARGE, Feature.ORE, new OreFeatureConfig(list3, 12, 0.7F));
        //        ORE_DIAMOND_BURIED, Feature.ORE, new OreFeatureConfig(list3, 8, 1.0F));
        //        ORE_DIAMOND_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 8, 0.5F));
        //        ORE_LAPIS, Feature.ORE, new OreFeatureConfig(list4, 7));
        //        ORE_LAPIS_BURIED, Feature.ORE, new OreFeatureConfig(list4, 7, 1.0F));
        //        ORE_EMERALD, Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(ruleTest2, Blocks.EMERALD_ORE.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, Blocks.DEEPSLATE_EMERALD_ORE.getDefaultState())), 3));
        //        ORE_ANCIENT_DEBRIS_LARGE, Feature.SCATTERED_ORE, new OreFeatureConfig(ruleTest5, Blocks.ANCIENT_DEBRIS.getDefaultState(), 3, 1.0F));
        //        ORE_ANCIENT_DEBRIS_SMALL, Feature.SCATTERED_ORE, new OreFeatureConfig(ruleTest5, Blocks.ANCIENT_DEBRIS.getDefaultState(), 2, 1.0F));
        //        ORE_COPPER_SMALL, Feature.ORE, new OreFeatureConfig(list5, 10));
        //        ORE_COPPER_LARGE, Feature.ORE, new OreFeatureConfig(list5, 20));

        // --- Register configured features ---
        register(context, OVERWORLD_ANTHRACITE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_ANTHRACITE_ORES, 6, 0.3F));
        register(context, NETHER_ANTHRACITE_ORE, Feature.ORE, new OreFeatureConfig(NETHER_ANTHRACITE_ORES, 13, 0.65F));

        register(context, TIN_SMALL_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TIN_ORES, 6));
        register(context, TIN_LARGE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TIN_ORES, 12));

        register(context, SILVER_SMALL_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_SILVER_ORES, 5));
        register(context, SILVER_UPPER_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_SILVER_ORES, 8));
        register(context, SILVER_MIDDLE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_SILVER_ORES, 9));
        register(context, NETHER_SILVER_ORE, Feature.ORE, new OreFeatureConfig(NETHER_SILVER_ORES, 10));
        register(context, ENDER_SILVER_ORE, Feature.ORE, new OreFeatureConfig(ENDER_SILVER_ORES, 8));

        register(context, COBALT_SMALL_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_COBALT_ORES, 4));
        register(context, COBALT_UPPER_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_COBALT_ORES, 10));
        register(context, COBALT_MIDDLE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_COBALT_ORES, 10));
        register(context, ENDER_COBALT_ORE, Feature.ORE, new OreFeatureConfig(ENDER_COBALT_ORES, 8));

        register(context, TURQUOISE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TURQUOISE_ORES, 7));
        register(context, TURQUOISE_BURIED_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TURQUOISE_ORES, 7, 1.0F));

        register(context, QUARTZ_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_QUARTZ_ORES, 12, 0.7F));
        register(context, CITRINE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_CITRINE_ORES, 12, 0.7F));
        register(context, NETHER_CITRINE_ORE, Feature.ORE, new OreFeatureConfig(NETHER_CITRINE_ORES, 12));

        register(context, NETHER_ONYX_ORE, Feature.ORE, new OreFeatureConfig(NETHER_ONYX_ORES, 12));
        register(context, ENDER_ONYX_ORE, Feature.ORE, new OreFeatureConfig(ENDER_ONYX_ORES, 12));

        register(context, TANZANITE_SMALL_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TANZANITE_ORES, 4, 0.2F));
        register(context, TANZANITE_LARGE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TANZANITE_ORES, 12, 0.6F));
        register(context, TANZANITE_BURIED_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TANZANITE_ORES, 8, 0.8F));
        register(context, TANZANITE_MEDIUM_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TANZANITE_ORES, 8, 0.4F));
        register(context, NETHER_TANZANITE_ORE, Feature.ORE, new OreFeatureConfig(NETHER_TANZANITE_ORES, 6));
        register(context, ENDER_TANZANITE_ORE, Feature.ORE, new OreFeatureConfig(ENDER_TANZANITE_ORES, 6, 0.2F));

        register(context, TOPAZ_SMALL_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOPAZ_ORES, 4, 0.2F));
        register(context, TOPAZ_LARGE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOPAZ_ORES, 12, 0.6F));
        register(context, TOPAZ_BURIED_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOPAZ_ORES, 8, 0.8F));
        register(context, TOPAZ_MEDIUM_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOPAZ_ORES, 8, 0.4F));
        register(context, NETHER_TOPAZ_ORE, Feature.ORE, new OreFeatureConfig(NETHER_TOPAZ_ORES, 6, 0.2F));
        register(context, ENDER_TOPAZ_ORE, Feature.ORE, new OreFeatureConfig(ENDER_TOPAZ_ORES, 6, 0.2F));

        register(context, TOURMALINE_SMALL_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOURMALINE_ORES, 4, 0.1F));
        register(context, TOURMALINE_LARGE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOURMALINE_ORES, 12, 0.8F));
        register(context, TOURMALINE_BURIED_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOURMALINE_ORES, 8, 0.6F));
        register(context, TOURMALINE_MEDIUM_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOURMALINE_ORES, 8, 0.4F));
        register(context, NETHER_TOURMALINE_ORE, Feature.ORE, new OreFeatureConfig(NETHER_TOURMALINE_ORES, 6, 0.2F));
        register(context, ENDER_TOURMALINE_ORE, Feature.ORE, new OreFeatureConfig(ENDER_TOURMALINE_ORES, 6, 0.2F));

        register(context, RUBY_SMALL_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY_ORES, 4, 0.5F));
        register(context, RUBY_LARGE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY_ORES, 12, 0.7F));
        register(context, RUBY_BURIED_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY_ORES, 8, 1.0F));
        register(context, RUBY_MEDIUM_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY_ORES, 8, 0.5F));
        register(context, NETHER_RUBY_ORE, Feature.ORE, new OreFeatureConfig(NETHER_RUBY_ORES, 6, 0.2F));
        register(context, ENDER_RUBY_ORE, Feature.ORE, new OreFeatureConfig(ENDER_RUBY_ORES, 6, 0.2F));

        register(context, SAPPHIRE_SMALL_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_SAPPHIRE_ORES, 4, 0.5F));
        register(context, SAPPHIRE_LARGE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_SAPPHIRE_ORES, 12, 0.7F));
        register(context, SAPPHIRE_BURIED_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_SAPPHIRE_ORES, 8, 1.0F));
        register(context, SAPPHIRE_MEDIUM_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_SAPPHIRE_ORES, 8, 0.5F));
        register(context, NETHER_SAPPHIRE_ORE, Feature.ORE, new OreFeatureConfig(NETHER_SAPPHIRE_ORES, 6, 0.2F));
        register(context, ENDER_SAPPHIRE_ORE, Feature.ORE, new OreFeatureConfig(ENDER_SAPPHIRE_ORES, 6, 0.2F));

        register(context, SPINEL_SMALL_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_SPINEL_ORES, 4, 0.5F));
        register(context, SPINEL_LARGE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_SPINEL_ORES, 12, 0.7F));
        register(context, SPINEL_BURIED_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_SPINEL_ORES, 8, 1.0F));
        register(context, SPINEL_MEDIUM_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_SPINEL_ORES, 8, 0.5F));
        register(context, NETHER_SPINEL_ORE, Feature.ORE, new OreFeatureConfig(NETHER_SPINEL_ORES, 5, 0.2F));
        register(context, ENDER_SPINEL_ORE, Feature.ORE, new OreFeatureConfig(ENDER_SPINEL_ORES, 5, 0.2F));

        register(context, MOISSANITE_SMALL_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_MOISSANITE_ORES, 4, 0.6F));
        register(context, MOISSANITE_LARGE_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_MOISSANITE_ORES, 10, 0.8F));
        register(context, MOISSANITE_BURIED_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_MOISSANITE_ORES, 8, 1.0F));
        register(context, MOISSANITE_MEDIUM_ORE, Feature.ORE, new OreFeatureConfig(OVERWORLD_MOISSANITE_ORES, 8, 0.6F));
        register(context, NETHER_MOISSANITE_ORE, Feature.ORE, new OreFeatureConfig(NETHER_MOISSANITE_ORES, 4));
        register(context, ENDER_MOISSANITE_ORE, Feature.ORE, new OreFeatureConfig(ENDER_MOISSANITE_ORES, 1, 0.3F));

        register(context, ENDERITE_SMALL_ORE, Feature.SCATTERED_ORE, new OreFeatureConfig(ENDERITE_ORES, 2, 1.0F));
        register(context, ENDERITE_LARGE_ORE, Feature.SCATTERED_ORE, new OreFeatureConfig(ENDERITE_ORES, 3, 1.0F));

        // --------------------
        // Lemon Oak Tree configs
        // --------------------

        int lemonWeightWorldgen = clamp01_100(CommonConfig.lemonLeafWeightWorldgen);
        int lemonWeightSapling  = clamp01_100(CommonConfig.lemonLeavesFromSaplingWeight);

        TreeFeatureConfig worldgenConfig = makeLemonOakConfig(lemonWeightWorldgen);
        TreeFeatureConfig saplingConfig  = makeLemonOakConfig(lemonWeightSapling);

        register(context, LEMON_OAK_TREE_WG, Feature.TREE, worldgenConfig);
        register(context, LEMON_OAK_TREE_SAPLING, Feature.TREE, saplingConfig);

    }
    private static int clamp01_100(int v) {
        if (v < 0) return 0;
        if (v > 100) return 100;
        return v;
    }


    private static TreeFeatureConfig makeLemonOakConfig(int lemonWeight) {
        int oakWeight = 100 - lemonWeight;

        // Mix lemon leaf block into normal oak leaves
        WeightedBlockStateProvider mixedLeaves = new WeightedBlockStateProvider(
                net.minecraft.util.collection.DataPool.<net.minecraft.block.BlockState>builder()
                        .add(net.minecraft.block.Blocks.OAK_LEAVES.getDefaultState(), oakWeight)
                        .add(mod.leronus.mores.block.ModBlocks.LEMON_OAK_LEAVES.getDefaultState(), lemonWeight)
        );

        return new TreeFeatureConfig.Builder(
                net.minecraft.world.gen.stateprovider.BlockStateProvider.of(net.minecraft.block.Blocks.OAK_LOG),
                new net.minecraft.world.gen.trunk.StraightTrunkPlacer(4, 2, 0),
                mixedLeaves,
                new net.minecraft.world.gen.foliage.BlobFoliagePlacer(
                        net.minecraft.util.math.intprovider.ConstantIntProvider.create(2),
                        net.minecraft.util.math.intprovider.ConstantIntProvider.create(0),
                        3
                ),
                new net.minecraft.world.gen.feature.size.TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build();
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Mores.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
