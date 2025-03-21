package mod.leronus.mores.datagen;

import mod.leronus.mores.item.ModTags;
import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.TIN_SWORD)
                .add(ModItems.COPPER_SWORD)
                .add(ModItems.SILVER_SWORD)
                .add(ModItems.BRONZE_SWORD)
                .add(ModItems.COBALT_SWORD)
                .add(ModItems.STERLING_SWORD)
                .add(ModItems.STEEL_SWORD)
                .add(ModItems.AMETHYST_SWORD)
                .add(ModItems.EMERALD_SWORD)
                .add(ModItems.OBSIDIAN_SWORD)
                .add(ModItems.TOPAZ_SWORD)
                .add(ModItems.TOURMALINE_SWORD)
                .add(ModItems.TANZANITE_SWORD)
                .add(ModItems.RUBY_SWORD)
                .add(ModItems.SAPPHIRE_SWORD)
                .add(ModItems.MOISSANITE_SWORD)
                .add(ModItems.TURQUOISE_SWORD)
                .add(ModItems.ONYX_SWORD)
                .add(ModItems.GRAPHENE_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.TIN_PICKAXE)
                .add(ModItems.COPPER_PICKAXE)
                .add(ModItems.SILVER_PICKAXE)
                .add(ModItems.BRONZE_PICKAXE)
                .add(ModItems.COBALT_PICKAXE)
                .add(ModItems.STERLING_PICKAXE)
                .add(ModItems.STEEL_PICKAXE)
                .add(ModItems.AMETHYST_PICKAXE)
                .add(ModItems.EMERALD_PICKAXE)
                .add(ModItems.OBSIDIAN_PICKAXE)
                .add(ModItems.TOPAZ_PICKAXE)
                .add(ModItems.TOURMALINE_PICKAXE)
                .add(ModItems.TANZANITE_PICKAXE)
                .add(ModItems.RUBY_PICKAXE)
                .add(ModItems.SAPPHIRE_PICKAXE)
                .add(ModItems.MOISSANITE_PICKAXE)
                .add(ModItems.TURQUOISE_PICKAXE)
                .add(ModItems.ONYX_PICKAXE)
                .add(ModItems.GRAPHENE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.TIN_SHOVEL)
                .add(ModItems.COPPER_SHOVEL)
                .add(ModItems.SILVER_SHOVEL)
                .add(ModItems.BRONZE_SHOVEL)
                .add(ModItems.COBALT_SHOVEL)
                .add(ModItems.STERLING_SHOVEL)
                .add(ModItems.STEEL_SHOVEL)
                .add(ModItems.AMETHYST_SHOVEL)
                .add(ModItems.EMERALD_SHOVEL)
                .add(ModItems.OBSIDIAN_SHOVEL)
                .add(ModItems.TOPAZ_SHOVEL)
                .add(ModItems.TOURMALINE_SHOVEL)
                .add(ModItems.TANZANITE_SHOVEL)
                .add(ModItems.RUBY_SHOVEL)
                .add(ModItems.SAPPHIRE_SHOVEL)
                .add(ModItems.MOISSANITE_SHOVEL)
                .add(ModItems.TURQUOISE_SHOVEL)
                .add(ModItems.ONYX_SHOVEL)
                .add(ModItems.GRAPHENE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.TIN_AXE)
                .add(ModItems.COPPER_AXE)
                .add(ModItems.SILVER_AXE)
                .add(ModItems.BRONZE_AXE)
                .add(ModItems.COBALT_AXE)
                .add(ModItems.STERLING_AXE)
                .add(ModItems.STEEL_AXE)
                .add(ModItems.AMETHYST_AXE)
                .add(ModItems.EMERALD_AXE)
                .add(ModItems.OBSIDIAN_AXE)
                .add(ModItems.TOPAZ_AXE)
                .add(ModItems.TOURMALINE_AXE)
                .add(ModItems.TANZANITE_AXE)
                .add(ModItems.RUBY_AXE)
                .add(ModItems.SAPPHIRE_AXE)
                .add(ModItems.MOISSANITE_AXE)
                .add(ModItems.TURQUOISE_AXE)
                .add(ModItems.ONYX_AXE)
                .add(ModItems.GRAPHENE_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.TIN_HOE)
                .add(ModItems.COPPER_HOE)
                .add(ModItems.SILVER_HOE)
                .add(ModItems.BRONZE_HOE)
                .add(ModItems.COBALT_HOE)
                .add(ModItems.STERLING_HOE)
                .add(ModItems.STEEL_HOE)
                .add(ModItems.AMETHYST_HOE)
                .add(ModItems.EMERALD_HOE)
                .add(ModItems.OBSIDIAN_HOE)
                .add(ModItems.TOPAZ_HOE)
                .add(ModItems.TOURMALINE_HOE)
                .add(ModItems.TANZANITE_HOE)
                .add(ModItems.RUBY_HOE)
                .add(ModItems.SAPPHIRE_HOE)
                .add(ModItems.MOISSANITE_HOE)
                .add(ModItems.TURQUOISE_HOE)
                .add(ModItems.ONYX_HOE)
                .add(ModItems.GRAPHENE_HOE);

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

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.TIN_INGOT);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
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

        getOrCreateTagBuilder(ConventionalItemTags.MUSIC_DISCS)
                .add(ModItems.SWEET_CAROLINE_MUSIC_DISC, ModItems.CIPHER_DISC);

//        getOrCreateTagBuilder(ItemTags.IRON_ORES)
//                .add(ModBlocks.SILVER_ORE.asItem());
//
//        getOrCreateTagBuilder(ItemTags.DIAMOND_ORES)
//                .add(ModBlocks.TURQUOISE_ORE.asItem());

        /**
         * Tags for recipes (universal)
         */
        getOrCreateTagBuilder(ModTags.Items.GRAPHENE_GEM)
            .add(ModItems.GRAPHENE_GEM);
        getOrCreateTagBuilder(ModTags.Items.MOISSANITE_GEM)
                .add(ModItems.MOISSANITE_GEM);
        getOrCreateTagBuilder(ModTags.Items.ONYX_GEM)
                .add(ModItems.ONYX_GEM);
        getOrCreateTagBuilder(ModTags.Items.RUBY_GEM)
                .add(ModItems.RUBY_GEM);
        getOrCreateTagBuilder(ModTags.Items.SAPPHIRE_GEM)
                .add(ModItems.SAPPHIRE_GEM);
        getOrCreateTagBuilder(ModTags.Items.TANZANITE_GEM)
                .add(ModItems.TANZANITE_GEM);
        getOrCreateTagBuilder(ModTags.Items.TOPAZ_GEM)
                .add(ModItems.TOPAZ_GEM);
        getOrCreateTagBuilder(ModTags.Items.TOURMALINE_GEM)
                .add(ModItems.TOURMALINE_GEM);
        getOrCreateTagBuilder(ModTags.Items.TURQUOISE_GEM)
                .add(ModItems.TURQUOISE_GEM);
        getOrCreateTagBuilder(ModTags.Items.BRONZE_INGOT)
                .add(ModItems.BRONZE_INGOT);
        getOrCreateTagBuilder(ModTags.Items.COBALT_INGOT)
                .add(ModItems.COBALT_INGOT);
        getOrCreateTagBuilder(ModTags.Items.OBSIDIAN_INGOT)
                .add(ModItems.OBSIDIAN_INGOT);
        getOrCreateTagBuilder(ModTags.Items.SILVER_INGOT)
                .add(ModItems.SILVER_INGOT);
        getOrCreateTagBuilder(ModTags.Items.STEEL_INGOT)
                .add(ModItems.STEEL_INGOT);
        getOrCreateTagBuilder(ModTags.Items.STERLING_INGOT)
                .add(ModItems.STERLING_INGOT);
        getOrCreateTagBuilder(ModTags.Items.TIN_INGOT)
                .add(ModItems.TIN_INGOT);
    }
}