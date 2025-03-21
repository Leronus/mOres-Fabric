package mod.leronus.mores.datagen;

import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.item.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ANTHRACITE_ORE)
                .add(ModBlocks.TIN_ORE)
                .add(ModBlocks.SILVER_ORE)
                .add(ModBlocks.COBALT_ORE)
                .add(ModBlocks.TOPAZ_ORE)
                .add(ModBlocks.TOURMALINE_ORE)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.MOISSANITE_ORE)
                .add(ModBlocks.TURQUOISE_ORE)
                .add(ModBlocks.ONYX_ORE)
                .add(ModBlocks.DEEPSLATE_ANTHRACITE_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE)
                .add(ModBlocks.DEEPSLATE_SILVER_ORE)
                .add(ModBlocks.DEEPSLATE_COBALT_ORE)
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_TOURMALINE_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_MOISSANITE_ORE)
                .add(ModBlocks.DEEPSLATE_TURQUOISE_ORE)
                .add(ModBlocks.NETHER_SILVER_ORE)
                .add(ModBlocks.NETHER_TANZANITE_ORE)
                .add(ModBlocks.NETHER_RUBY_ORE)
                .add(ModBlocks.NETHER_SAPPHIRE_ORE)
                .add(ModBlocks.NETHER_MOISSANITE_ORE)
                .add(ModBlocks.NETHER_ANTHRACITE_ORE)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.RAW_TIN_BLOCK)
                .add(ModBlocks.SILVER_BLOCK)
                .add(ModBlocks.RAW_SILVER_BLOCK)
                .add(ModBlocks.COBALT_BLOCK)
                .add(ModBlocks.RAW_COBALT_BLOCK)
                .add(ModBlocks.BRONZE_BLOCK)
                .add(ModBlocks.STERLING_BLOCK)
                .add(ModBlocks.STEEL_BLOCK)
                .add(ModBlocks.AMETHYST_BLOCK)
                .add(ModBlocks.TOPAZ_BLOCK)
                .add(ModBlocks.TOURMALINE_BLOCK)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.TANZANITE_BLOCK)
                .add(ModBlocks.MOISSANITE_BLOCK)
                .add(ModBlocks.TURQUOISE_BLOCK)
                .add(ModBlocks.ONYX_BLOCK);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.TIN_BLOCK)
                .add(ModBlocks.SILVER_BLOCK)
                .add(ModBlocks.COBALT_BLOCK)
                .add(ModBlocks.BRONZE_BLOCK)
                .add(ModBlocks.STERLING_BLOCK)
                .add(ModBlocks.STEEL_BLOCK)
                .add(ModBlocks.AMETHYST_BLOCK)
                .add(ModBlocks.TOPAZ_BLOCK)
                .add(ModBlocks.TOURMALINE_BLOCK)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.TANZANITE_BLOCK)
                .add(ModBlocks.MOISSANITE_BLOCK)
                .add(ModBlocks.TURQUOISE_BLOCK)
                .add(ModBlocks.ONYX_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SILVER_ORE)
                .add(ModBlocks.COBALT_ORE)
                .add(ModBlocks.ANTHRACITE_ORE)
                .add(ModBlocks.DEEPSLATE_ANTHRACITE_ORE)
                .add(ModBlocks.DEEPSLATE_SILVER_ORE)
                .add(ModBlocks.DEEPSLATE_COBALT_ORE)
                .add(ModBlocks.DEEPSLATE_TIN_ORE);


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TOPAZ_ORE)
                .add(ModBlocks.TOURMALINE_ORE)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.NETHER_SILVER_ORE)
                .add(ModBlocks.NETHER_TANZANITE_ORE)
                .add(ModBlocks.NETHER_ANTHRACITE_ORE)
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_TOURMALINE_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.SILVER_BLOCK)
                .add(ModBlocks.BRONZE_BLOCK)
                .add(ModBlocks.COBALT_BLOCK)
                .add(ModBlocks.STERLING_BLOCK)
                .add(ModBlocks.STEEL_BLOCK)
                .add(ModBlocks.AMETHYST_BLOCK)
                .add(ModBlocks.RAW_SILVER_BLOCK)
                .add(ModBlocks.RAW_COBALT_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MOISSANITE_ORE)
                .add(ModBlocks.TURQUOISE_ORE)
                .add(ModBlocks.DEEPSLATE_MOISSANITE_ORE)
                .add(ModBlocks.DEEPSLATE_TURQUOISE_ORE)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.TANZANITE_BLOCK)
                .add(ModBlocks.MOISSANITE_BLOCK);

        /**
         * Custom mod tag
         */
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_GRAPHENE_TOOL)
                .add(ModBlocks.MOISSANITE_BLOCK)
                .add(ModBlocks.TURQUOISE_BLOCK)
                .add(ModBlocks.ONYX_BLOCK)
                .add(ModBlocks.GRAPHENE_BLOCK);
    }
}