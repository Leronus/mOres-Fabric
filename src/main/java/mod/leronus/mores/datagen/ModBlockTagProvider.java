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
                ModBlocks.TIN_ORE, ModBlocks.DEEPSLATE_TIN_ORE,
                ModBlocks.SILVER_ORE,  ModBlocks.DEEPSLATE_SILVER_ORE, ModBlocks.NETHER_SILVER_ORE,
                ModBlocks.COBALT_ORE, ModBlocks.DEEPSLATE_COBALT_ORE,
                ModBlocks.TURQUOISE_ORE, ModBlocks.DEEPSLATE_TURQUOISE_ORE,
                ModBlocks.NETHER_CITRINE_ORE,
                ModBlocks.ENDER_ONYX_ORE,
                ModBlocks.TANZANITE_ORE, ModBlocks.DEEPSLATE_TANZANITE_ORE, ModBlocks.NETHER_TANZANITE_ORE,
                ModBlocks.TOPAZ_ORE, ModBlocks.DEEPSLATE_TOPAZ_ORE, ModBlocks.TOURMALINE_ORE, ModBlocks.DEEPSLATE_TOURMALINE_ORE, ModBlocks.SPINEL_ORE, ModBlocks.NETHER_SPINEL_ORE,
                ModBlocks.SPINEL_ORE, ModBlocks.DEEPSLATE_SPINEL_ORE, ModBlocks.NETHER_SPINEL_ORE,
                ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE,
                ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModBlocks.NETHER_SAPPHIRE_ORE,
                ModBlocks.MOISSANITE_ORE, ModBlocks.DEEPSLATE_MOISSANITE_ORE, ModBlocks.NETHER_MOISSANITE_ORE,
                ModBlocks.PRIMORDIAL_DEBRIS,

                ModBlocks.TIN_BLOCK, ModBlocks.RAW_TIN_BLOCK, ModBlocks.SILVER_BLOCK, ModBlocks.RAW_SILVER_BLOCK,
                ModBlocks.COBALT_BLOCK, ModBlocks.RAW_COBALT_BLOCK, ModBlocks.BRONZE_BLOCK, ModBlocks.STERLING_SILVER_BLOCK,
                ModBlocks.CARBON_STEEL_BLOCK, ModBlocks.HARDENED_STEEL_BLOCK, ModBlocks.AMETHYST_BLOCK,
                ModBlocks.TURQUOISE_BLOCK, ModBlocks.CITRINE_BLOCK, ModBlocks.ONYX_BLOCK,
                ModBlocks.TOPAZ_BLOCK, ModBlocks.TOURMALINE_BLOCK, ModBlocks.TANZANITE_BLOCK,
                ModBlocks.RUBY_BLOCK, ModBlocks.SAPPHIRE_BLOCK,
                ModBlocks.MOISSANITE_BLOCK, ModBlocks.ADAMANTIUM_BLOCK, ModBlocks.ENDERITE_BLOCK);

        //Beacon
        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(
                ModBlocks.TIN_BLOCK, ModBlocks.SILVER_BLOCK, ModBlocks.COBALT_BLOCK, ModBlocks.BRONZE_BLOCK, ModBlocks.STERLING_SILVER_BLOCK,
                ModBlocks.ROSE_GOLD_BLOCK, ModBlocks.CARBON_STEEL_BLOCK, ModBlocks.HARDENED_STEEL_BLOCK, ModBlocks.AMETHYST_BLOCK, ModBlocks.TOPAZ_BLOCK,
                ModBlocks.TOURMALINE_BLOCK, ModBlocks.TANZANITE_BLOCK, ModBlocks.RUBY_BLOCK, ModBlocks.SAPPHIRE_BLOCK, ModBlocks.SPINEL_BLOCK, ModBlocks.CITRINE_BLOCK,
                ModBlocks.MOISSANITE_BLOCK, ModBlocks.TURQUOISE_BLOCK, ModBlocks.ONYX_BLOCK, ModBlocks.ADAMANTIUM_BLOCK, ModBlocks.ENDERITE_BLOCK);

        //TODO Add Universal Ores (Diorite/Granite/Tuff/Andesite)
        //Ores
        getOrCreateTagBuilder(ConventionalBlockTags.ORES).add(
                ModBlocks.ANTHRACITE_ORE, ModBlocks.TIN_ORE, ModBlocks.SILVER_ORE, ModBlocks.COBALT_ORE, ModBlocks.TURQUOISE_ORE, ModBlocks.TANZANITE_ORE, ModBlocks.TOPAZ_ORE, ModBlocks.TOURMALINE_ORE,
                ModBlocks.RUBY_ORE, ModBlocks.SAPPHIRE_ORE, ModBlocks.SPINEL_ORE, ModBlocks.MOISSANITE_ORE,
                ModBlocks.ENDER_ONYX_ORE, ModBlocks.DEEPSLATE_ANTHRACITE_ORE, ModBlocks.DEEPSLATE_TIN_ORE, ModBlocks.DEEPSLATE_SILVER_ORE, ModBlocks.DEEPSLATE_COBALT_ORE,
                ModBlocks.DEEPSLATE_TOPAZ_ORE, ModBlocks.DEEPSLATE_TOURMALINE_ORE, ModBlocks.DEEPSLATE_TANZANITE_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SPINEL_ORE,
                ModBlocks.DEEPSLATE_MOISSANITE_ORE, ModBlocks.DEEPSLATE_TURQUOISE_ORE, ModBlocks.NETHER_SILVER_ORE, ModBlocks.NETHER_TANZANITE_ORE,
                ModBlocks.NETHER_CITRINE_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.NETHER_SAPPHIRE_ORE, ModBlocks.NETHER_SPINEL_ORE, ModBlocks.NETHER_MOISSANITE_ORE, ModBlocks.NETHER_ANTHRACITE_ORE
        );

        //TODO Check to confirm (re-order)
        //Harvest Levels
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.SILVER_ORE, ModBlocks.RAW_TIN_BLOCK, ModBlocks.COBALT_ORE, ModBlocks.ANTHRACITE_ORE, ModBlocks.DEEPSLATE_ANTHRACITE_ORE, ModBlocks.DEEPSLATE_SILVER_ORE,
                ModBlocks.DEEPSLATE_COBALT_ORE, ModBlocks.DEEPSLATE_TIN_ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.BRONZE_BLOCK, ModBlocks.COBALT_BLOCK, ModBlocks.STERLING_SILVER_BLOCK, ModBlocks.CARBON_STEEL_BLOCK, ModBlocks.HARDENED_STEEL_BLOCK, ModBlocks.ROSE_GOLD_BLOCK,
                ModBlocks.AMETHYST_BLOCK, ModBlocks.SPINEL_BLOCK, ModBlocks.CITRINE_BLOCK, ModBlocks.ONYX_BLOCK,
                ModBlocks.TOPAZ_BLOCK, ModBlocks.TOURMALINE_BLOCK, ModBlocks.TURQUOISE_BLOCK, ModBlocks.TANZANITE_BLOCK,
                ModBlocks.NETHER_CITRINE_ORE, ModBlocks.TOPAZ_ORE, ModBlocks.TOURMALINE_ORE, ModBlocks.RUBY_ORE, ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_TOPAZ_ORE, ModBlocks.DEEPSLATE_TOURMALINE_ORE, ModBlocks.DEEPSLATE_RUBY_ORE,
                ModBlocks.SILVER_BLOCK, ModBlocks.RAW_COBALT_BLOCK, ModBlocks.RAW_SILVER_BLOCK,
                ModBlocks.NETHER_ANTHRACITE_ORE, ModBlocks.NETHER_SILVER_ORE,
                ModBlocks.TURQUOISE_ORE, ModBlocks.DEEPSLATE_TURQUOISE_ORE,
                ModBlocks.TANZANITE_ORE, ModBlocks.DEEPSLATE_TANZANITE_ORE, ModBlocks.NETHER_TANZANITE_ORE
                );
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.SPINEL_ORE, ModBlocks.DEEPSLATE_SPINEL_ORE, ModBlocks.NETHER_SPINEL_ORE,
                ModBlocks.MOISSANITE_ORE, ModBlocks.DEEPSLATE_MOISSANITE_ORE, ModBlocks.NETHER_MOISSANITE_ORE,
                ModBlocks.RUBY_BLOCK, ModBlocks.SAPPHIRE_BLOCK);

        /*
         * Custom harvest level
         */
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_GRAPHENE_TOOL).add(
                ModBlocks.MOISSANITE_BLOCK,
                ModBlocks.ONYX_BLOCK,
                ModBlocks.GRAPHENE_BLOCK,
                ModBlocks.ADAMANTIUM_BLOCK,
                ModBlocks.PRIMORDIAL_DEBRIS,
                ModBlocks.ENDERITE_BLOCK);
    }
}