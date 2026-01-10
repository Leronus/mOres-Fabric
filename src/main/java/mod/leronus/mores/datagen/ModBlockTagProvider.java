package mod.leronus.mores.datagen;

import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.item.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //Ores & Blocks
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(
                ModBlocks.ANTHRACITE_ORE, ModBlocks.DEEPSLATE_ANTHRACITE_ORE, ModBlocks.NETHER_ANTHRACITE_ORE,
                ModBlocks.TIN_ORE, ModBlocks.DEEPSLATE_TIN_ORE, ModBlocks.ANDESITE_TIN_ORE, ModBlocks.GRANITE_TIN_ORE, ModBlocks.TUFF_TIN_ORE,
                ModBlocks.SILVER_ORE,  ModBlocks.DEEPSLATE_SILVER_ORE, ModBlocks.NETHER_SILVER_ORE, ModBlocks.ENDER_SILVER_ORE, ModBlocks.ELECTRUM_ORE,
                ModBlocks.ANDESITE_SILVER_ORE,  ModBlocks.BASALT_SILVER_ORE, ModBlocks.BLACKSTONE_SILVER_ORE, ModBlocks.CALCITE_SILVER_ORE, ModBlocks.DIORITE_SILVER_ORE,
                ModBlocks.GRANITE_SILVER_ORE, ModBlocks.TUFF_SILVER_ORE,
                ModBlocks.COBALT_ORE, ModBlocks.DEEPSLATE_COBALT_ORE, ModBlocks.ENDER_COBALT_ORE,
                ModBlocks.ANDESITE_COBALT_ORE,  ModBlocks.BASALT_COBALT_ORE, ModBlocks.BLACKSTONE_COBALT_ORE, ModBlocks.CALCITE_COBALT_ORE, ModBlocks.DIORITE_COBALT_ORE,
                ModBlocks.GRANITE_COBALT_ORE, ModBlocks.TUFF_COBALT_ORE,
                ModBlocks.TURQUOISE_ORE, ModBlocks.DEEPSLATE_TURQUOISE_ORE,
                ModBlocks.CITRINE_ORE, ModBlocks.NETHER_CITRINE_ORE,
                ModBlocks.ENDER_ONYX_ORE,
                ModBlocks.QUARTZ_ORE,
                ModBlocks.TANZANITE_ORE, ModBlocks.DEEPSLATE_TANZANITE_ORE, ModBlocks.NETHER_TANZANITE_ORE, ModBlocks.ENDER_TANZANITE_ORE,
                ModBlocks.ANDESITE_TANZANITE_ORE,  ModBlocks.BASALT_TANZANITE_ORE, ModBlocks.BLACKSTONE_TANZANITE_ORE, ModBlocks.CALCITE_TANZANITE_ORE, ModBlocks.DIORITE_TANZANITE_ORE,
                ModBlocks.GRANITE_TANZANITE_ORE, ModBlocks.TUFF_TANZANITE_ORE,
                ModBlocks.TOPAZ_ORE, ModBlocks.DEEPSLATE_TOPAZ_ORE, ModBlocks.NETHER_TOPAZ_ORE, ModBlocks.ENDER_TOPAZ_ORE,
                ModBlocks.ANDESITE_TOPAZ_ORE,  ModBlocks.BASALT_TOPAZ_ORE, ModBlocks.BLACKSTONE_TOPAZ_ORE, ModBlocks.CALCITE_TOPAZ_ORE, ModBlocks.DIORITE_TOPAZ_ORE,
                ModBlocks.GRANITE_TOPAZ_ORE, ModBlocks.TUFF_TOPAZ_ORE,
                ModBlocks.TOURMALINE_ORE, ModBlocks.DEEPSLATE_TOURMALINE_ORE, ModBlocks.NETHER_TOURMALINE_ORE, ModBlocks.ENDER_TOURMALINE_ORE,
                ModBlocks.ANDESITE_TOURMALINE_ORE,  ModBlocks.BASALT_TOURMALINE_ORE, ModBlocks.BLACKSTONE_TOURMALINE_ORE, ModBlocks.CALCITE_TOURMALINE_ORE, ModBlocks.DIORITE_TOURMALINE_ORE,
                ModBlocks.GRANITE_TOURMALINE_ORE, ModBlocks.TUFF_TOURMALINE_ORE,
                ModBlocks.SPINEL_ORE, ModBlocks.DEEPSLATE_SPINEL_ORE, ModBlocks.NETHER_SPINEL_ORE, ModBlocks.ENDER_SPINEL_ORE,
                ModBlocks.ANDESITE_SPINEL_ORE,  ModBlocks.BASALT_SPINEL_ORE, ModBlocks.BLACKSTONE_SPINEL_ORE, ModBlocks.CALCITE_SPINEL_ORE, ModBlocks.DIORITE_SPINEL_ORE,
                ModBlocks.GRANITE_SPINEL_ORE, ModBlocks.TUFF_SPINEL_ORE,
                ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.ENDER_RUBY_ORE,
                ModBlocks.ANDESITE_RUBY_ORE,  ModBlocks.BASALT_RUBY_ORE, ModBlocks.BLACKSTONE_RUBY_ORE, ModBlocks.CALCITE_RUBY_ORE, ModBlocks.DIORITE_RUBY_ORE,
                ModBlocks.GRANITE_RUBY_ORE, ModBlocks.TUFF_RUBY_ORE,
                ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModBlocks.NETHER_SAPPHIRE_ORE, ModBlocks.ENDER_SAPPHIRE_ORE,
                ModBlocks.ANDESITE_SAPPHIRE_ORE,  ModBlocks.BASALT_SAPPHIRE_ORE, ModBlocks.BLACKSTONE_SAPPHIRE_ORE, ModBlocks.CALCITE_SAPPHIRE_ORE, ModBlocks.DIORITE_SAPPHIRE_ORE,
                ModBlocks.GRANITE_SAPPHIRE_ORE, ModBlocks.TUFF_SAPPHIRE_ORE,
                ModBlocks.MOISSANITE_ORE, ModBlocks.DEEPSLATE_MOISSANITE_ORE, ModBlocks.NETHER_MOISSANITE_ORE, ModBlocks.ENDER_MOISSANITE_ORE,
                ModBlocks.ANDESITE_MOISSANITE_ORE,  ModBlocks.BASALT_MOISSANITE_ORE, ModBlocks.BLACKSTONE_MOISSANITE_ORE, ModBlocks.CALCITE_MOISSANITE_ORE, ModBlocks.DIORITE_MOISSANITE_ORE,
                ModBlocks.GRANITE_MOISSANITE_ORE, ModBlocks.TUFF_MOISSANITE_ORE,
                ModBlocks.PRIMORDIAL_DEBRIS,

                ModBlocks.TIN_BLOCK, ModBlocks.RAW_TIN_BLOCK, ModBlocks.SILVER_BLOCK, ModBlocks.RAW_SILVER_BLOCK,
                ModBlocks.COBALT_BLOCK, ModBlocks.RAW_COBALT_BLOCK, ModBlocks.BRONZE_BLOCK, ModBlocks.STERLING_SILVER_BLOCK,
                ModBlocks.CARBON_STEEL_BLOCK, ModBlocks.HARDENED_STEEL_BLOCK, ModBlocks.AMETHYST_BLOCK,
                ModBlocks.TURQUOISE_BLOCK, ModBlocks.CITRINE_BLOCK, ModBlocks.ONYX_BLOCK,
                ModBlocks.TOPAZ_BLOCK, ModBlocks.TOURMALINE_BLOCK, ModBlocks.TANZANITE_BLOCK,
                ModBlocks.RUBY_BLOCK, ModBlocks.SAPPHIRE_BLOCK,
                ModBlocks.MOISSANITE_BLOCK, ModBlocks.ADAMANTIUM_BLOCK, ModBlocks.ENDERITE_BLOCK);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(
                ModBlocks.GRAVEL_TIN_ORE,
                ModBlocks.GRAVEL_SILVER_ORE,
                ModBlocks.GRAVEL_COBALT_ORE,
                ModBlocks.GRAVEL_TANZANITE_ORE,
                ModBlocks.GRAVEL_TOPAZ_ORE,
                ModBlocks.GRAVEL_TOURMALINE_ORE,
                ModBlocks.GRAVEL_SPINEL_ORE,
                ModBlocks.GRAVEL_RUBY_ORE,
                ModBlocks.GRAVEL_SAPPHIRE_ORE,
                ModBlocks.GRAVEL_SPINEL_ORE,
                ModBlocks.GRAVEL_MOISSANITE_ORE
        );

        //Beacon
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(
                ModBlocks.TIN_BLOCK, ModBlocks.SILVER_BLOCK, ModBlocks.COBALT_BLOCK, ModBlocks.BRONZE_BLOCK, ModBlocks.STERLING_SILVER_BLOCK,
                ModBlocks.ROSE_GOLD_BLOCK, ModBlocks.CARBON_STEEL_BLOCK, ModBlocks.HARDENED_STEEL_BLOCK, ModBlocks.AMETHYST_BLOCK, ModBlocks.TOPAZ_BLOCK,
                ModBlocks.TOURMALINE_BLOCK, ModBlocks.TANZANITE_BLOCK, ModBlocks.RUBY_BLOCK, ModBlocks.SAPPHIRE_BLOCK, ModBlocks.SPINEL_BLOCK, ModBlocks.CITRINE_BLOCK,
                ModBlocks.MOISSANITE_BLOCK, ModBlocks.TURQUOISE_BLOCK, ModBlocks.ONYX_BLOCK, ModBlocks.ADAMANTIUM_BLOCK, ModBlocks.ENDERITE_BLOCK);

        //TODO Add Universal Ores (Diorite/Granite/Tuff/Andesite)
        //Ores
        getOrCreateTagBuilder(ConventionalBlockTags.ORES).add(
                ModBlocks.ANTHRACITE_ORE, ModBlocks.DEEPSLATE_ANTHRACITE_ORE, ModBlocks.NETHER_ANTHRACITE_ORE,
                ModBlocks.TIN_ORE, ModBlocks.DEEPSLATE_TIN_ORE, ModBlocks.ANDESITE_TIN_ORE, ModBlocks.GRANITE_TIN_ORE, ModBlocks.GRAVEL_TIN_ORE, ModBlocks.TUFF_TIN_ORE,
                ModBlocks.SILVER_ORE, ModBlocks.DEEPSLATE_SILVER_ORE, ModBlocks.NETHER_SILVER_ORE, ModBlocks.ENDER_SILVER_ORE, ModBlocks.ANDESITE_SILVER_ORE, ModBlocks.BASALT_SILVER_ORE, ModBlocks.BLACKSTONE_SILVER_ORE, ModBlocks.CALCITE_SILVER_ORE, ModBlocks.DIORITE_SILVER_ORE,
                ModBlocks.GRANITE_SILVER_ORE, ModBlocks.GRAVEL_SILVER_ORE, ModBlocks.TUFF_SILVER_ORE,
                ModBlocks.COBALT_ORE, ModBlocks.DEEPSLATE_COBALT_ORE, ModBlocks.ENDER_COBALT_ORE, ModBlocks.ANDESITE_COBALT_ORE, ModBlocks.BASALT_COBALT_ORE, ModBlocks.BLACKSTONE_COBALT_ORE, ModBlocks.CALCITE_COBALT_ORE, ModBlocks.DIORITE_COBALT_ORE,
                ModBlocks.GRANITE_COBALT_ORE, ModBlocks.GRAVEL_COBALT_ORE, ModBlocks.TUFF_COBALT_ORE,
                ModBlocks.TURQUOISE_ORE, ModBlocks.DEEPSLATE_TURQUOISE_ORE,
                ModBlocks.ENDER_ONYX_ORE,
                ModBlocks.CITRINE_ORE, ModBlocks.NETHER_CITRINE_ORE,
                ModBlocks.TANZANITE_ORE, ModBlocks.DEEPSLATE_TANZANITE_ORE, ModBlocks.NETHER_TANZANITE_ORE, ModBlocks.ENDER_TANZANITE_ORE, ModBlocks.ANDESITE_TANZANITE_ORE, ModBlocks.BASALT_TANZANITE_ORE, ModBlocks.BLACKSTONE_TANZANITE_ORE, ModBlocks.CALCITE_TANZANITE_ORE, ModBlocks.DIORITE_TANZANITE_ORE,
                ModBlocks.GRANITE_TANZANITE_ORE, ModBlocks.GRAVEL_TANZANITE_ORE, ModBlocks.TUFF_TANZANITE_ORE,
                ModBlocks.TOPAZ_ORE, ModBlocks.DEEPSLATE_TOPAZ_ORE, ModBlocks.NETHER_TOPAZ_ORE, ModBlocks.ENDER_TOPAZ_ORE, ModBlocks.ANDESITE_TOPAZ_ORE, ModBlocks.BASALT_TOPAZ_ORE, ModBlocks.BLACKSTONE_TOPAZ_ORE, ModBlocks.CALCITE_TOPAZ_ORE, ModBlocks.DIORITE_TOPAZ_ORE,
                ModBlocks.GRANITE_TOPAZ_ORE, ModBlocks.GRAVEL_TOPAZ_ORE, ModBlocks.TUFF_TOPAZ_ORE,
                ModBlocks.TOURMALINE_ORE, ModBlocks.DEEPSLATE_TOURMALINE_ORE, ModBlocks.NETHER_TOURMALINE_ORE, ModBlocks.ENDER_TOURMALINE_ORE, ModBlocks.ANDESITE_TOURMALINE_ORE, ModBlocks.BASALT_TOURMALINE_ORE, ModBlocks.BLACKSTONE_TOURMALINE_ORE, ModBlocks.CALCITE_TOURMALINE_ORE, ModBlocks.DIORITE_TOURMALINE_ORE,
                ModBlocks.GRANITE_TOURMALINE_ORE, ModBlocks.GRAVEL_TOURMALINE_ORE, ModBlocks.TUFF_TOURMALINE_ORE,
                ModBlocks.SPINEL_ORE, ModBlocks.DEEPSLATE_SPINEL_ORE, ModBlocks.NETHER_SPINEL_ORE, ModBlocks.ENDER_SPINEL_ORE, ModBlocks.ANDESITE_SPINEL_ORE, ModBlocks.BASALT_SPINEL_ORE, ModBlocks.BLACKSTONE_SPINEL_ORE, ModBlocks.CALCITE_SPINEL_ORE, ModBlocks.DIORITE_SPINEL_ORE,
                ModBlocks.GRANITE_SPINEL_ORE, ModBlocks.GRAVEL_SPINEL_ORE, ModBlocks.TUFF_SPINEL_ORE,
                ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.ENDER_RUBY_ORE, ModBlocks.ANDESITE_RUBY_ORE, ModBlocks.BASALT_RUBY_ORE, ModBlocks.BLACKSTONE_RUBY_ORE, ModBlocks.CALCITE_RUBY_ORE, ModBlocks.DIORITE_RUBY_ORE,
                ModBlocks.GRANITE_RUBY_ORE, ModBlocks.GRAVEL_RUBY_ORE, ModBlocks.TUFF_RUBY_ORE,
                ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModBlocks.NETHER_SAPPHIRE_ORE, ModBlocks.ENDER_SAPPHIRE_ORE, ModBlocks.ANDESITE_SAPPHIRE_ORE, ModBlocks.BASALT_SAPPHIRE_ORE, ModBlocks.BLACKSTONE_SAPPHIRE_ORE, ModBlocks.CALCITE_SAPPHIRE_ORE, ModBlocks.DIORITE_SAPPHIRE_ORE,
                ModBlocks.GRANITE_SAPPHIRE_ORE, ModBlocks.GRAVEL_SAPPHIRE_ORE, ModBlocks.TUFF_SAPPHIRE_ORE,
                ModBlocks.MOISSANITE_ORE, ModBlocks.DEEPSLATE_MOISSANITE_ORE, ModBlocks.NETHER_MOISSANITE_ORE, ModBlocks.ENDER_MOISSANITE_ORE, ModBlocks.ANDESITE_MOISSANITE_ORE, ModBlocks.BASALT_MOISSANITE_ORE, ModBlocks.BLACKSTONE_MOISSANITE_ORE, ModBlocks.CALCITE_MOISSANITE_ORE, ModBlocks.DIORITE_MOISSANITE_ORE,
                ModBlocks.GRANITE_MOISSANITE_ORE, ModBlocks.GRAVEL_MOISSANITE_ORE, ModBlocks.TUFF_MOISSANITE_ORE
        );

        //Harvest Levels
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.TIN_BLOCK, ModBlocks.ALLOY_FURNACE,
                ModBlocks.ANTHRACITE_ORE, ModBlocks.DEEPSLATE_ANTHRACITE_ORE, ModBlocks.NETHER_ANTHRACITE_ORE,
                ModBlocks.RAW_TIN_BLOCK, ModBlocks.DEEPSLATE_TIN_ORE, ModBlocks.ANDESITE_TIN_ORE, ModBlocks.GRANITE_TIN_ORE, ModBlocks.GRAVEL_TIN_ORE, ModBlocks.TUFF_TIN_ORE,
                ModBlocks.SILVER_ORE, ModBlocks.DEEPSLATE_SILVER_ORE, ModBlocks.NETHER_SILVER_ORE, ModBlocks.ELECTRUM_ORE, ModBlocks.ENDER_SILVER_ORE, ModBlocks.ANDESITE_SILVER_ORE, ModBlocks.BASALT_SILVER_ORE, ModBlocks.BLACKSTONE_SILVER_ORE, ModBlocks.CALCITE_SILVER_ORE, ModBlocks.DIORITE_SILVER_ORE,
                ModBlocks.GRANITE_SILVER_ORE, ModBlocks.GRAVEL_SILVER_ORE, ModBlocks.TUFF_SILVER_ORE,
                ModBlocks.COBALT_ORE, ModBlocks.DEEPSLATE_COBALT_ORE, ModBlocks.ENDER_COBALT_ORE, ModBlocks.ANDESITE_COBALT_ORE, ModBlocks.BASALT_COBALT_ORE, ModBlocks.BLACKSTONE_COBALT_ORE, ModBlocks.CALCITE_COBALT_ORE, ModBlocks.DIORITE_COBALT_ORE,
                ModBlocks.GRANITE_COBALT_ORE, ModBlocks.GRAVEL_COBALT_ORE, ModBlocks.TUFF_COBALT_ORE
        );
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.RAW_COBALT_BLOCK, ModBlocks.RAW_SILVER_BLOCK,
                ModBlocks.SILVER_BLOCK, ModBlocks.BRONZE_BLOCK, ModBlocks.STERLING_SILVER_BLOCK, ModBlocks.ROSE_GOLD_BLOCK,
                ModBlocks.COBALT_BLOCK, ModBlocks.CARBON_STEEL_BLOCK,
                ModBlocks.TURQUOISE_BLOCK, ModBlocks.AMETHYST_BLOCK, ModBlocks.CITRINE_BLOCK, ModBlocks.ONYX_BLOCK,
                ModBlocks.TOPAZ_BLOCK, ModBlocks.TOURMALINE_BLOCK, ModBlocks.TANZANITE_BLOCK,
                ModBlocks.TURQUOISE_ORE, ModBlocks.DEEPSLATE_TURQUOISE_ORE,
                ModBlocks.CITRINE_ORE, ModBlocks.NETHER_CITRINE_ORE,
                ModBlocks.ENDER_ONYX_ORE,
                ModBlocks.TANZANITE_ORE, ModBlocks.DEEPSLATE_TANZANITE_ORE, ModBlocks.NETHER_TANZANITE_ORE, ModBlocks.ENDER_TANZANITE_ORE, ModBlocks.ANDESITE_TANZANITE_ORE, ModBlocks.BASALT_TANZANITE_ORE, ModBlocks.BLACKSTONE_TANZANITE_ORE, ModBlocks.CALCITE_TANZANITE_ORE, ModBlocks.DIORITE_TANZANITE_ORE,
                ModBlocks.GRANITE_TANZANITE_ORE, ModBlocks.GRAVEL_TANZANITE_ORE, ModBlocks.TUFF_TANZANITE_ORE,
                ModBlocks.TOPAZ_ORE, ModBlocks.DEEPSLATE_TOPAZ_ORE, ModBlocks.NETHER_TOPAZ_ORE, ModBlocks.ENDER_TOPAZ_ORE, ModBlocks.ANDESITE_TOPAZ_ORE, ModBlocks.BASALT_TOPAZ_ORE, ModBlocks.BLACKSTONE_TOPAZ_ORE, ModBlocks.CALCITE_TOPAZ_ORE, ModBlocks.DIORITE_TOPAZ_ORE,
                ModBlocks.GRANITE_TOPAZ_ORE, ModBlocks.GRAVEL_TOPAZ_ORE, ModBlocks.TUFF_TOPAZ_ORE,
                ModBlocks.TOURMALINE_ORE, ModBlocks.DEEPSLATE_TOURMALINE_ORE, ModBlocks.NETHER_TOURMALINE_ORE, ModBlocks.ENDER_TOURMALINE_ORE, ModBlocks.ANDESITE_TOURMALINE_ORE, ModBlocks.BASALT_TOURMALINE_ORE, ModBlocks.BLACKSTONE_TOURMALINE_ORE, ModBlocks.CALCITE_TOURMALINE_ORE, ModBlocks.DIORITE_TOURMALINE_ORE,
                ModBlocks.GRANITE_TOURMALINE_ORE, ModBlocks.GRAVEL_TOURMALINE_ORE, ModBlocks.TUFF_TOURMALINE_ORE,
                ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.ENDER_RUBY_ORE, ModBlocks.ANDESITE_RUBY_ORE, ModBlocks.BASALT_RUBY_ORE, ModBlocks.BLACKSTONE_RUBY_ORE, ModBlocks.CALCITE_RUBY_ORE, ModBlocks.DIORITE_RUBY_ORE,
                ModBlocks.GRANITE_RUBY_ORE, ModBlocks.GRAVEL_RUBY_ORE, ModBlocks.TUFF_RUBY_ORE,
                ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModBlocks.NETHER_SAPPHIRE_ORE, ModBlocks.ENDER_SAPPHIRE_ORE, ModBlocks.ANDESITE_SAPPHIRE_ORE, ModBlocks.BASALT_SAPPHIRE_ORE, ModBlocks.BLACKSTONE_SAPPHIRE_ORE, ModBlocks.CALCITE_SAPPHIRE_ORE, ModBlocks.DIORITE_SAPPHIRE_ORE,
                ModBlocks.GRANITE_SAPPHIRE_ORE, ModBlocks.GRAVEL_SAPPHIRE_ORE, ModBlocks.TUFF_SAPPHIRE_ORE,
                ModBlocks.SPINEL_ORE, ModBlocks.DEEPSLATE_SPINEL_ORE, ModBlocks.NETHER_SPINEL_ORE, ModBlocks.ENDER_SPINEL_ORE, ModBlocks.ANDESITE_SPINEL_ORE, ModBlocks.BASALT_SPINEL_ORE, ModBlocks.BLACKSTONE_SPINEL_ORE, ModBlocks.CALCITE_SPINEL_ORE, ModBlocks.DIORITE_SPINEL_ORE,
                ModBlocks.GRANITE_SPINEL_ORE, ModBlocks.GRAVEL_SPINEL_ORE, ModBlocks.TUFF_SPINEL_ORE
        );
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.HARDENED_STEEL_BLOCK,
                ModBlocks.SPINEL_BLOCK, ModBlocks.RUBY_BLOCK, ModBlocks.SAPPHIRE_BLOCK,
                ModBlocks.MOISSANITE_ORE, ModBlocks.DEEPSLATE_MOISSANITE_ORE, ModBlocks.NETHER_MOISSANITE_ORE, ModBlocks.ENDER_MOISSANITE_ORE, ModBlocks.ANDESITE_MOISSANITE_ORE, ModBlocks.BASALT_MOISSANITE_ORE, ModBlocks.BLACKSTONE_MOISSANITE_ORE, ModBlocks.CALCITE_MOISSANITE_ORE, ModBlocks.DIORITE_MOISSANITE_ORE,
                ModBlocks.GRANITE_MOISSANITE_ORE, ModBlocks.GRAVEL_MOISSANITE_ORE, ModBlocks.TUFF_MOISSANITE_ORE
        );

        /*
         * Custom harvest level
         */
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_ADAMANTIUM_TOOL).add(
                ModBlocks.MOISSANITE_BLOCK,
                ModBlocks.ADAMANTIUM_BLOCK,
                ModBlocks.PRIMORDIAL_DEBRIS,
                ModBlocks.ENDERITE_BLOCK);
    }
}