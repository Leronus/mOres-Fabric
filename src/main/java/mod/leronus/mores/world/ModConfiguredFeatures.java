package mod.leronus.mores.world;

import mod.leronus.mores.Mores;
import mod.leronus.mores.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> OVERWORLD_ANTHRACITE_ORE_KEY = registerKey("overworld_anthracite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_ANTHRACITE_ORE_KEY = registerKey("nether_anthracite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_UPPER_ORE_KEY = registerKey("tin_upper_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_MIDDLE_ORE_KEY = registerKey("tin_middle_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_SMALL_ORE_KEY = registerKey("tin_small_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SILVER_UPPER_ORE_KEY = registerKey("silver_upper_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SILVER_MIDDLE_ORE_KEY = registerKey("silver_middle_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SILVER_SMALL_ORE_KEY = registerKey("silver_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_SILVER_ORE_KEY = registerKey("nether_silver_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_SILVER_ORE_KEY = registerKey("ender_silver_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> COBALT_UPPER_ORE_KEY = registerKey("cobalt_upper_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COBALT_MIDDLE_ORE_KEY = registerKey("cobalt_middle_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COBALT_SMALL_ORE_KEY = registerKey("cobalt_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_COBALT_ORE_KEY = registerKey("ender_cobalt_ore");

    //TODO Make one key once ready to make changes
    public static final RegistryKey<ConfiguredFeature<?, ?>> TURQUOISE_SMALL_ORE_KEY = registerKey("turquoise_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TURQUOISE_LARGE_ORE_KEY = registerKey("turquoise_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TURQUOISE_BURIED_ORE_KEY = registerKey("turquoise_buried_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> QUARTZ_ORE_KEY = registerKey("quartz_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CITRINE_ORE_KEY = registerKey("citrine_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_CITRINE_ORE_KEY = registerKey("nether_citrine_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TANZANITE_SMALL_ORE_KEY = registerKey("tanzanite_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TANZANITE_LARGE_ORE_KEY = registerKey("tanzanite_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TANZANITE_BURIED_ORE_KEY = registerKey("tanzanite_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TANZANITE_ORE_KEY = registerKey("nether_tanzanite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_TANZANITE_ORE_KEY = registerKey("ender_tanzanite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TOPAZ_SMALL_ORE_KEY = registerKey("topaz_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOPAZ_LARGE_ORE_KEY = registerKey("topaz_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOPAZ_BURIED_ORE_KEY = registerKey("topaz_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TOPAZ_ORE_KEY = registerKey("nether_topaz_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_TOPAZ_ORE_KEY = registerKey("ender_topaz_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TOURMALINE_SMALL_ORE_KEY = registerKey("tourmaline_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOURMALINE_LARGE_ORE_KEY = registerKey("tourmaline_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOURMALINE_BURIED_ORE_KEY = registerKey("tourmaline_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TOURMALINE_ORE_KEY = registerKey("nether_tourmaline_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_TOURMALINE_ORE_KEY = registerKey("ender_tourmaline_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_SMALL_ORE_KEY = registerKey("ruby_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_LARGE_ORE_KEY = registerKey("ruby_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_BURIED_ORE_KEY = registerKey("ruby_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_RUBY_ORE_KEY = registerKey("ender_ruby_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_SMALL_ORE_KEY = registerKey("sapphire_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_LARGE_ORE_KEY = registerKey("sapphire_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_BURIED_ORE_KEY = registerKey("sapphire_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_SAPPHIRE_ORE_KEY = registerKey("nether_sapphire_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_SAPPHIRE_ORE_KEY = registerKey("ender_sapphire_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SPINEL_SMALL_ORE_KEY = registerKey("spinel_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPINEL_LARGE_ORE_KEY = registerKey("spinel_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPINEL_BURIED_ORE_KEY = registerKey("spinel_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_SPINEL_ORE_KEY = registerKey("nether_spinel_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_SPINEL_ORE_KEY = registerKey("ender_spinel_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MOISSANITE_SMALL_ORE_KEY = registerKey("moissanite_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOISSANITE_LARGE_ORE_KEY = registerKey("moissanite_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOISSANITE_BURIED_ORE_KEY = registerKey("moissanite_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_MOISSANITE_ORE_KEY = registerKey("nether_moissanite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_MOISSANITE_ORE_KEY = registerKey("ender_moissanite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_ONYX_ORE_KEY = registerKey("nether_onyx_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDER_ONYX_ORE_KEY = registerKey("ender_onyx_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDERITE_ORE_KEY = registerKey("enderite_ore");

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

        // (no universal variants exist for TURQUOISE in your ModBlocks)
        List<OreFeatureConfig.Target> OVERWORLD_TURQUOISE_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TURQUOISE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TURQUOISE_ORE.getDefaultState())
        );

        // (no universal variants exist for ANTHRACITE in your ModBlocks)
        List<OreFeatureConfig.Target> OVERWORLD_ANTHRACITE_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.ANTHRACITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_ANTHRACITE_ORE.getDefaultState())
        );

        // --- Nether ores (netherrack + basalt + blackstone variants where you have them) ---
        List<OreFeatureConfig.Target> NETHER_SILVER_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_SILVER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BASALT), ModBlocks.BASALT_SILVER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.BLACKSTONE), ModBlocks.BLACKSTONE_SILVER_ORE.getDefaultState())
        );

        // (no basalt/blackstone citrine variants exist in your ModBlocks)
        List<OreFeatureConfig.Target> NETHER_CITRINE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_CITRINE_ORE.getDefaultState())
                /*,OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), BlockInit.DEEPSLATE_TANZANITE_ORE.getDefaultState()())*/
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

        List<OreFeatureConfig.Target> END_ONYX_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDER_ONYX_ORE.getDefaultState())
        );

        // --- Register configured features ---
        register(context, OVERWORLD_ANTHRACITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_ANTHRACITE_ORES, 6, 0.3F));
        register(context, NETHER_ANTHRACITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_ANTHRACITE_ORES, 13, 0.65F));

        register(context, TIN_UPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TIN_ORES, 10));
        register(context, TIN_MIDDLE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TIN_ORES, 8));
        register(context, TIN_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TIN_ORES, 4));

        register(context, COBALT_UPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_COBALT_ORES, 8, 0.8F));
        register(context, COBALT_MIDDLE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_COBALT_ORES, 8, 0.8F));
        register(context, COBALT_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_COBALT_ORES, 4, 0.5F));
//        register(context, ENDER_COBALT_ORE_KEY, Feature.ORE, new OreFeatureConfig(ENDER_COBALT_ORES, 4));

        register(context, SILVER_UPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SILVER_ORES, 8));
        register(context, SILVER_MIDDLE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SILVER_ORES, 8));
        register(context, SILVER_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SILVER_ORES, 4));
        register(context, NETHER_SILVER_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_SILVER_ORES, 9));
//        register(context, ENDER_SILVER_ORE_KEY, Feature.ORE, new OreFeatureConfig(ENDER_SILVER_ORES, 4));

        register(context, TURQUOISE_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TURQUOISE_ORES, 6, 0.5F));
        register(context, TURQUOISE_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TURQUOISE_ORES, 7, 0.7F));
        register(context, TURQUOISE_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TURQUOISE_ORES, 6, 1.0F));

        //Overworld Quartz
        register(context, NETHER_CITRINE_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_CITRINE_ORES, 9, 0.5F));

//        register(context, TANZANITE_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TANZANITE_ORES, 4, 0.2F));
//        register(context, TANZANITE_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TANZANITE_ORES, 10, 0.6F));
//        register(context, TANZANITE_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TANZANITE_ORES, 8, 0.8F));
        //Nether Tanzanite
        //Ender Tanzanite

        register(context, TOPAZ_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOPAZ_ORES, 4, 0.2F));
        register(context, TOPAZ_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOPAZ_ORES, 10, 0.6F));
        register(context, TOPAZ_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOPAZ_ORES, 8, 0.8F));
        //Nether Topaz
        //Ender Topaz

        register(context, TOURMALINE_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOURMALINE_ORES, 4, 0.1F));
        register(context, TOURMALINE_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOURMALINE_ORES, 10, 0.8F));
        register(context, TOURMALINE_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOURMALINE_ORES, 8, 0.6F));
        //Nether Tourmaline
        //Ender Tourmaline

        register(context, RUBY_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY_ORES, 4, 0.5F));
        register(context, RUBY_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY_ORES, 10, 0.7F));
        register(context, RUBY_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY_ORES, 8, 1.0F));
        register(context, NETHER_RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_RUBY_ORES, 6, 0.8F));
        //Ender Ruby

        register(context, SAPPHIRE_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SAPPHIRE_ORES, 4, 0.5F));
        register(context, SAPPHIRE_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SAPPHIRE_ORES, 10, 0.7F));
        register(context, SAPPHIRE_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SAPPHIRE_ORES, 8, 1.0F));
        register(context, NETHER_SAPPHIRE_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_SAPPHIRE_ORES, 5, 0.7F));
        //Ender Sapphire

//        register(context, SPINEL_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SPINEL_ORES, 4, 0.5F));
//        register(context, SPINEL_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SPINEL_ORES, 10, 0.7F));
//        register(context, SPINEL_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SPINEL_ORES, 8, 1.0F));
//        register(context, NETHER_SPINEL_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_SPINEL_ORES, 5, 0.7F));
        //Ender Spinel

        //Nether Onyx
        register(context, ENDER_ONYX_ORE_KEY, Feature.ORE, new OreFeatureConfig(END_ONYX_ORES, 6));

        register(context, MOISSANITE_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_MOISSANITE_ORES, 2, 0.5F));
        register(context, MOISSANITE_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_MOISSANITE_ORES, 6, 0.7F));
        register(context, MOISSANITE_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_MOISSANITE_ORES, 4, 1.0F));
        register(context, NETHER_MOISSANITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_MOISSANITE_ORES, 4));
//        register(context, ENDER_MOISSANITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(ENDER_MOISSANITE_ORES, 5));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Mores.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
