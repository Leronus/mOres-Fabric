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

    public static final RegistryKey<ConfiguredFeature<?, ?>> COBALT_UPPER_ORE_KEY = registerKey("cobalt_upper_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COBALT_MIDDLE_ORE_KEY = registerKey("cobalt_middle_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COBALT_SMALL_ORE_KEY = registerKey("cobalt_small_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TOPAZ_SMALL_ORE_KEY = registerKey("topaz_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOPAZ_LARGE_ORE_KEY = registerKey("topaz_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOPAZ_BURIED_ORE_KEY = registerKey("topaz_buried_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TOURMALINE_SMALL_ORE_KEY = registerKey("tourmaline_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOURMALINE_LARGE_ORE_KEY = registerKey("tourmaline_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TOURMALINE_BURIED_ORE_KEY = registerKey("tourmaline_buried_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_SMALL_ORE_KEY = registerKey("ruby_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_LARGE_ORE_KEY = registerKey("ruby_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RUBY_BURIED_ORE_KEY = registerKey("ruby_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_SMALL_ORE_KEY = registerKey("sapphire_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_LARGE_ORE_KEY = registerKey("sapphire_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_BURIED_ORE_KEY = registerKey("sapphire_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_SAPPHIRE_ORE_KEY = registerKey("nether_sapphire_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MOISSANITE_SMALL_ORE_KEY = registerKey("moissanite_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOISSANITE_LARGE_ORE_KEY = registerKey("moissanite_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOISSANITE_BURIED_ORE_KEY = registerKey("moissanite_buried_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_MOISSANITE_ORE_KEY = registerKey("nether_moissanite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_TANZANITE_ORE_KEY = registerKey("nether_tanzanite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> TURQUOISE_SMALL_ORE_KEY = registerKey("turquoise_small_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TURQUOISE_LARGE_ORE_KEY = registerKey("turquoise_large_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TURQUOISE_BURIED_ORE_KEY = registerKey("turquoise_buried_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> END_ONYX_ORE_KEY = registerKey("end_onyx_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        List<OreFeatureConfig.Target> OVERWORLD_TIN_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TIN_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TIN_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> OVERWORLD_COBALT_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.COBALT_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_COBALT_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> OVERWORLD_SILVER_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.SILVER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_SILVER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> OVERWORLD_TOPAZ_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TOPAZ_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> OVERWORLD_TOURMALINE_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TOURMALINE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TOURMALINE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> OVERWORLD_SAPPHIRE_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> OVERWORLD_RUBY_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> OVERWORLD_MOISSANITE_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.MOISSANITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_MOISSANITE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> OVERWORLD_TURQUOISE_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.TURQUOISE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_TURQUOISE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> OVERWORLD_ANTHRACITE_ORES = List.of(
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.ANTHRACITE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_ANTHRACITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> NETHER_SILVER_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_SILVER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> NETHER_TANZANITE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_TANZANITE_ORE.getDefaultState())
                /*,OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), BlockInit.DEEPSLATE_TANZANITE_ORE.getDefaultState()())*/);

        List<OreFeatureConfig.Target> NETHER_RUBY_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_RUBY_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> NETHER_SAPPHIRE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_SAPPHIRE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> NETHER_MOISSANITE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_MOISSANITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> NETHER_ANTHRACITE_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.NETHER_ANTHRACITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> END_ONYX_ORES = List.of(
                OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ONYX_ORE.getDefaultState()));

        register(context, OVERWORLD_ANTHRACITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_ANTHRACITE_ORES,6, 0.3F));
        register(context, NETHER_ANTHRACITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_ANTHRACITE_ORES,13, 0.65F));

        register(context, TIN_UPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TIN_ORES,10));
        register(context, TIN_MIDDLE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TIN_ORES,8));
        register(context, TIN_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TIN_ORES,4));

        register(context, COBALT_UPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_COBALT_ORES,8, 0.8F));
        register(context, COBALT_MIDDLE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_COBALT_ORES,8, 0.8F));
        register(context, COBALT_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_COBALT_ORES,4, 0.5F));

        register(context, SILVER_UPPER_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SILVER_ORES,8));
        register(context, SILVER_MIDDLE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SILVER_ORES,8));
        register(context, SILVER_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SILVER_ORES,4));
        register(context, NETHER_SILVER_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_SILVER_ORES,9));

        register(context, TOPAZ_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOPAZ_ORES,4, 0.2F));
        register(context, TOPAZ_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOPAZ_ORES,10, 0.6F));
        register(context, TOPAZ_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOPAZ_ORES,8, 0.8F));

        register(context, TOURMALINE_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOURMALINE_ORES,4, 0.1F));
        register(context, TOURMALINE_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOURMALINE_ORES,10, 0.8F));
        register(context, TOURMALINE_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TOURMALINE_ORES,8, 0.6F));

        register(context, NETHER_TANZANITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_TANZANITE_ORES,9, 0.5F));

        register(context, RUBY_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY_ORES,4, 0.5F));
        register(context, RUBY_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY_ORES,10, 0.7F));
        register(context, RUBY_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_RUBY_ORES,8, 1.0F));
        register(context, NETHER_RUBY_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_RUBY_ORES,6, 0.8F));

        register(context, SAPPHIRE_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SAPPHIRE_ORES,4, 0.5F));
        register(context, SAPPHIRE_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SAPPHIRE_ORES,10, 0.7F));
        register(context, SAPPHIRE_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_SAPPHIRE_ORES,8, 1.0F));
        register(context, NETHER_SAPPHIRE_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_SAPPHIRE_ORES,5, 0.7F));

        register(context, TURQUOISE_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TURQUOISE_ORES,6, 0.5F));
        register(context, TURQUOISE_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TURQUOISE_ORES,7, 0.7F));
        register(context, TURQUOISE_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_TURQUOISE_ORES,6, 1.0F));

        register(context, END_ONYX_ORE_KEY, Feature.ORE, new OreFeatureConfig(END_ONYX_ORES,6));

        register(context, MOISSANITE_SMALL_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_MOISSANITE_ORES,2, 0.5F));
        register(context, MOISSANITE_LARGE_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_MOISSANITE_ORES,6, 0.7F));
        register(context, MOISSANITE_BURIED_ORE_KEY, Feature.ORE, new OreFeatureConfig(OVERWORLD_MOISSANITE_ORES,4, 1.0F));
        register(context, NETHER_MOISSANITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(NETHER_MOISSANITE_ORES,4));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Mores.MOD_ID, name));
    }


    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}