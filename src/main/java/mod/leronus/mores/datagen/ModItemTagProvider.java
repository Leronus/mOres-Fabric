package mod.leronus.mores.datagen;

import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.item.ModItemTags;
import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        ModItems.SILVER_HELMET, ModItems.SILVER_CHESTPLATE, ModItems.SILVER_LEGGINGS, ModItems.SILVER_BOOTS,
                        ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS,
                        ModItems.COBALT_HELMET, ModItems.COBALT_CHESTPLATE, ModItems.COBALT_LEGGINGS, ModItems.COBALT_BOOTS,
                        ModItems.BRONZE_HELMET, ModItems.BRONZE_CHESTPLATE, ModItems.BRONZE_LEGGINGS, ModItems.BRONZE_BOOTS,
                        ModItems.TIN_HELMET, ModItems.TIN_CHESTPLATE, ModItems.TIN_LEGGINGS, ModItems.TIN_BOOTS,
                        ModItems.STERLING_HELMET, ModItems.STERLING_CHESTPLATE, ModItems.STERLING_LEGGINGS, ModItems.STERLING_BOOTS,
                        ModItems.STEEL_HELMET, ModItems.STEEL_CHESTPLATE, ModItems.STEEL_LEGGINGS, ModItems.STEEL_BOOTS,
                        ModItems.AMETHYST_HELMET, ModItems.AMETHYST_CHESTPLATE, ModItems.AMETHYST_LEGGINGS, ModItems.AMETHYST_BOOTS,
                        ModItems.EMERALD_HELMET, ModItems.EMERALD_CHESTPLATE, ModItems.EMERALD_LEGGINGS, ModItems.EMERALD_BOOTS,
                        ModItems.TOURMALINE_HELMET, ModItems.TOURMALINE_CHESTPLATE, ModItems.TOURMALINE_LEGGINGS, ModItems.TOURMALINE_BOOTS,
                        ModItems.TOPAZ_HELMET, ModItems.TOPAZ_CHESTPLATE, ModItems.TOPAZ_LEGGINGS, ModItems.TOPAZ_BOOTS,
                        ModItems.RUBY_HELMET, ModItems.RUBY_CHESTPLATE, ModItems.RUBY_LEGGINGS, ModItems.RUBY_BOOTS,
                        ModItems.SAPPHIRE_HELMET, ModItems.SAPPHIRE_CHESTPLATE, ModItems.SAPPHIRE_LEGGINGS, ModItems.SAPPHIRE_BOOTS,
                        ModItems.TANZANITE_HELMET, ModItems.TANZANITE_CHESTPLATE, ModItems.TANZANITE_LEGGINGS, ModItems.TANZANITE_BOOTS,
                        ModItems.TURQUOISE_HELMET, ModItems.TURQUOISE_CHESTPLATE, ModItems.TURQUOISE_LEGGINGS, ModItems.TURQUOISE_BOOTS,
                        ModItems.MOISSANITE_HELMET, ModItems.MOISSANITE_CHESTPLATE, ModItems.MOISSANITE_LEGGINGS, ModItems.MOISSANITE_BOOTS,
                        ModItems.ONYX_HELMET, ModItems.ONYX_CHESTPLATE, ModItems.ONYX_LEGGINGS, ModItems.ONYX_BOOTS,
                        ModItems.OBSIDIAN_HELMET, ModItems.OBSIDIAN_CHESTPLATE, ModItems.OBSIDIAN_LEGGINGS, ModItems.OBSIDIAN_BOOTS,
                        ModItems.GRAPHENE_HELMET, ModItems.GRAPHENE_CHESTPLATE, ModItems.GRAPHENE_LEGGINGS, ModItems.GRAPHENE_BOOTS
                     );

//        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
//                .add(ModItems.SWEET_CAROLINE_MUSIC_DISC, ModItems.CIPHER_DISC);

//        getOrCreateTagBuilder(ItemTags.IRON_ORES)
//                .add(ModBlocks.SILVER_ORE.asItem());
//
//        getOrCreateTagBuilder(ItemTags.DIAMOND_ORES)
//                .add(ModBlocks.TURQUOISE_ORE.asItem());

        getOrCreateTagBuilder(ModItemTags.GRAPHENE_GEM)
            .add(ModItems.GRAPHENE_GEM);
        getOrCreateTagBuilder(ModItemTags.MOISSANITE_GEM)
                .add(ModItems.MOISSANITE_GEM);
        getOrCreateTagBuilder(ModItemTags.ONYX_GEM)
                .add(ModItems.ONYX_GEM);
        getOrCreateTagBuilder(ModItemTags.RUBY_GEM)
                .add(ModItems.RUBY_GEM);
        getOrCreateTagBuilder(ModItemTags.SAPPHIRE_GEM)
                .add(ModItems.SAPPHIRE_GEM);
        getOrCreateTagBuilder(ModItemTags.TANZANITE_GEM)
                .add(ModItems.TANZANITE_GEM);
        getOrCreateTagBuilder(ModItemTags.TOPAZ_GEM)
                .add(ModItems.TOPAZ_GEM);
        getOrCreateTagBuilder(ModItemTags.TOURMALINE_GEM)
                .add(ModItems.TOURMALINE_GEM);
        getOrCreateTagBuilder(ModItemTags.TURQUOISE_GEM)
                .add(ModItems.TURQUOISE_GEM);
        getOrCreateTagBuilder(ModItemTags.BRONZE_INGOT)
                .add(ModItems.BRONZE_INGOT);
        getOrCreateTagBuilder(ModItemTags.COBALT_INGOT)
                .add(ModItems.COBALT_INGOT);
        getOrCreateTagBuilder(ModItemTags.OBSIDIAN_INGOT)
                .add(ModItems.OBSIDIAN_INGOT);
        getOrCreateTagBuilder(ModItemTags.SILVER_INGOT)
                .add(ModItems.SILVER_INGOT);
        getOrCreateTagBuilder(ModItemTags.STEEL_INGOT)
                .add(ModItems.STEEL_INGOT);
        getOrCreateTagBuilder(ModItemTags.STERLING_INGOT)
                .add(ModItems.STERLING_INGOT);
        getOrCreateTagBuilder(ModItemTags.TIN_INGOT)
                .add(ModItems.TIN_INGOT);

    }
}