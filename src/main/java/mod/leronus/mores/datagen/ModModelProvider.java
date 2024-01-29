package mod.leronus.mores.datagen;

import mod.leronus.mores.blocks.ModBlocks;
import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_COBALT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_SILVER_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANTHRACITE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_COBALT_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOURMALINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TOURMALINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TOPAZ_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_TANZANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOISSANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_MOISSANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_MOISSANITE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TURQUOISE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ONYX_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBALT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMETHYST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STERLING_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOURMALINE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TANZANITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ONYX_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAPHENE_BLOCK);



//        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.ALLOY_FURNACE);
        }

//    private void registerCustomLamp(BlockStateModelGenerator blockStateModelGenerator) {
//        Identifier identifier = TexturedModel.CUBE_ALL.upload(ModBlocks.SAPPHIRE_LAMP_BLOCK, blockStateModelGenerator.modelCollector);
//        Identifier identifier2 = blockStateModelGenerator.createSubModel(ModBlocks.SAPPHIRE_LAMP_BLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
//        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.SAPPHIRE_LAMP_BLOCK)
//                .coordinate(BlockStateModelGenerator.createBooleanModelMap(SapphireLampBlock.CLICKED, identifier2, identifier)));
//
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK_1);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK_2);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK_3);
//
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WAXED_SAPPHIRE_BLOCK);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WAXED_SAPPHIRE_BLOCK_1);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WAXED_SAPPHIRE_BLOCK_2);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WAXED_SAPPHIRE_BLOCK_3);

//        blockStateModelGenerator.registerCooker(ModBlocks.ALLOY_FURNACE, TexturedModel.ORIENTABLE);
//    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SILVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.COBALT_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_COBALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STERLING_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.TOPAZ_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOURMALINE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TANZANITE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOISSANITE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQUOISE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONYX_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPHENE_GEM, Models.GENERATED);


        itemModelGenerator.register(ModItems.TIN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.SILVER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.COBALT_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.STERLING_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.AMETHYST_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.EMERALD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TOPAZ_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TOURMALINE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TANZANITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.SAPPHIRE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.MOISSANITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TURQUOISE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.OBSIDIAN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ONYX_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.GRAPHENE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.WOOD_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WOOD_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WOOD_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_BATTLEAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_DAGGER, Models.HANDHELD);


        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TIN_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TIN_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TIN_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TIN_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SILVER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SILVER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SILVER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SILVER_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COBALT_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COBALT_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COBALT_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COBALT_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STERLING_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STERLING_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STERLING_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STERLING_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOPAZ_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOPAZ_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOPAZ_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOPAZ_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOURMALINE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOURMALINE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOURMALINE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOURMALINE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TANZANITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TANZANITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TANZANITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TANZANITE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MOISSANITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MOISSANITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MOISSANITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MOISSANITE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TURQUOISE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TURQUOISE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TURQUOISE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TURQUOISE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OBSIDIAN_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OBSIDIAN_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OBSIDIAN_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.OBSIDIAN_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ONYX_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ONYX_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ONYX_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ONYX_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GRAPHENE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GRAPHENE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GRAPHENE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GRAPHENE_BOOTS));

        itemModelGenerator.register(ModItems.TIN_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.STERLING_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOURMALINE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TANZANITE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOISSANITE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQUOISE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONYX_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPHENE_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.ANTHRACITE, Models.GENERATED);

        itemModelGenerator.register(ModItems.BRONZE_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COBALT_APPLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.VELVET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOCOLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARROT_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHAIN, Models.GENERATED);
//        itemModelGenerator.register(ModItems.DUCK, Models.GENERATED);
//        itemModelGenerator.register(ModItems.COOKED_DUCK, Models.GENERATED);
//        itemModelGenerator.register(ModItems.DUCK_EGG, Models.GENERATED);
//        itemModelGenerator.register(ModItems.SWEET_CAROLINE_MUSIC_DISC, Models.GENERATED);

//        itemModelGenerator.register(ModItems.DUCK_SPAWN_EGG,
//                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

        /*
        Shields?
        //
         */
    }
}