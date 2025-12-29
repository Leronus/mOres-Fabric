package mod.leronus.mores.datagen;

import mod.leronus.mores.Mores;
import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.block.custom.AlloyFurnaceBlock;
import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ANTHRACITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_ANTHRACITE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_COBALT_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TURQUOISE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOURMALINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TOURMALINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TOPAZ_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPINEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SPINEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SPINEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_CITRINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOISSANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_MOISSANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_MOISSANITE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_ONYX_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STERLING_SILVER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROSE_GOLD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBALT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CARBON_STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HARDENED_STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AMETHYST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOURMALINE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPINEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CITRINE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOISSANITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ONYX_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAPHENE_BLOCK);

        registerAlloyFurnace(blockStateModelGenerator);
        }


    private static void registerAlloyFurnace(BlockStateModelGenerator gen) {
        // Texture ids under assets/mores/textures/block/
        Identifier top = Identifier.of(Mores.MOD_ID, "block/alloy_furnace_top");
        Identifier side = Identifier.of(Mores.MOD_ID, "block/alloy_furnace_side");
        Identifier frontOff = Identifier.of(Mores.MOD_ID, "block/alloy_furnace_front");
        Identifier frontOn = Identifier.of(Mores.MOD_ID, "block/alloy_furnace_front_lit");

        // Model ids that will be written
        Identifier modelOff = ModelIds.getBlockModelId(ModBlocks.ALLOY_FURNACE);
        Identifier modelOn = modelOff.withSuffixedPath("_on");

        // Write the two block models (orientable furnace-style model)
        Models.ORIENTABLE_WITH_BOTTOM.upload(
                modelOff,
                new TextureMap()
                        .put(TextureKey.TOP, top)
                        .put(TextureKey.BOTTOM, top)
                        .put(TextureKey.SIDE, side)
                        .put(TextureKey.FRONT, frontOff),
                gen.modelCollector
        );

        Models.ORIENTABLE_WITH_BOTTOM.upload(
                modelOn,
                new TextureMap()
                        .put(TextureKey.TOP, top)
                        .put(TextureKey.BOTTOM, top)
                        .put(TextureKey.SIDE, side)
                        .put(TextureKey.FRONT, frontOn),
                gen.modelCollector
        );

        // Blockstate: facing rotation + lit swaps model
        gen.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.ALLOY_FURNACE)
                        .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
                        .coordinate(BlockStateModelGenerator.createBooleanModelMap(AlloyFurnaceBlock.LIT, modelOn, modelOff))
        );

        // Item model: parent to the OFF block model
        gen.registerParentedItemModel(ModBlocks.ALLOY_FURNACE, modelOff);
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
        itemModelGenerator.register(ModItems.ANTHRACITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CITRINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQUOISE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONYX, Models.GENERATED);

        itemModelGenerator.register(ModItems.BRONZE_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COBALT_APPLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.VELVET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOCOLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARROT_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHAINMAIL, Models.GENERATED);

        itemModelGenerator.register(ModItems.AMETHYST_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQUOISE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_DUST, Models.GENERATED);

        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SILVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.STERLING_SILVER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COBALT_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_COBALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARBON_STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.HARDENED_STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.HOT_CARBON_STEEL_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARBON_STEEL_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.TIN_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.STERLING_SILVER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_GOLD_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COBALT_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARBON_STEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.HARDENED_STEEL_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.AMETHYST_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQUOISE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOURMALINE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPINEL_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CITRINE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOISSANITE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONYX_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPHENE_GEM, Models.GENERATED);


        itemModelGenerator.register(ModItems.TIN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TIN_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.SILVER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.STERLING_SILVER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_SILVER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_SILVER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_SILVER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_SILVER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_SILVER_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_SILVER_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STERLING_SILVER_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ROSE_GOLD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSE_GOLD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSE_GOLD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSE_GOLD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSE_GOLD_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSE_GOLD_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSE_GOLD_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSE_GOLD_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.COBALT_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COBALT_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CARBON_STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CARBON_STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CARBON_STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CARBON_STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CARBON_STEEL_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CARBON_STEEL_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CARBON_STEEL_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CARBON_STEEL_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.HARDENED_STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HARDENED_STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HARDENED_STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HARDENED_STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HARDENED_STEEL_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HARDENED_STEEL_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HARDENED_STEEL_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HARDENED_STEEL_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.AMETHYST_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.LAPIS_LAZULI_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TURQUOISE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TURQUOISE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TANZANITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TANZANITE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TOPAZ_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOPAZ_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TOURMALINE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOURMALINE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CITRINE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CITRINE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CITRINE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CITRINE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CITRINE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CITRINE_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CITRINE_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CITRINE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.EMERALD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMERALD_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.SAPPHIRE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAPPHIRE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.SPINEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPINEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPINEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPINEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPINEL_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPINEL_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPINEL_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPINEL_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.MOISSANITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOISSANITE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.OBSIDIAN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.OBSIDIAN_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ONYX_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.GRAPHENE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GRAPHENE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ADAMANTIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADAMANTIUM_DAGGER, Models.HANDHELD);

//        itemModelGenerator.register(ModItems.ENDERITE_SWORD, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.ENDERITE_PICKAXE, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.ENDERITE_SHOVEL, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.ENDERITE_AXE, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.ENDERITE_HOE, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.ENDERITE_BATTLE_AXE, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.ENDERITE_BATTLE_MACE, Models.HANDHELD);
//        itemModelGenerator.register(ModItems.ENDERITE_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.WOOD_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WOOD_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WOOD_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_DAGGER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_DAGGER, Models.HANDHELD);


        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TIN_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TIN_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TIN_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TIN_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SILVER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SILVER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SILVER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SILVER_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COPPER_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STERLING_SILVER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STERLING_SILVER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STERLING_SILVER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STERLING_SILVER_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ROSE_GOLD_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ROSE_GOLD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ROSE_GOLD_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ROSE_GOLD_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COBALT_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COBALT_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COBALT_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.COBALT_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CARBON_STEEL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CARBON_STEEL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CARBON_STEEL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CARBON_STEEL_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HARDENED_STEEL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HARDENED_STEEL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HARDENED_STEEL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HARDENED_STEEL_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.LAPIS_LAZULI_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.LAPIS_LAZULI_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.LAPIS_LAZULI_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.LAPIS_LAZULI_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TURQUOISE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TURQUOISE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TURQUOISE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TURQUOISE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TANZANITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TANZANITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TANZANITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TANZANITE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOPAZ_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOPAZ_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOPAZ_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOPAZ_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOURMALINE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOURMALINE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOURMALINE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TOURMALINE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.EMERALD_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.EMERALD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.EMERALD_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.EMERALD_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SAPPHIRE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SAPPHIRE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SAPPHIRE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SAPPHIRE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SPINEL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SPINEL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SPINEL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SPINEL_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CITRINE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CITRINE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CITRINE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CITRINE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MOISSANITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MOISSANITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MOISSANITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MOISSANITE_BOOTS));

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

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADAMANTIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADAMANTIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADAMANTIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ADAMANTIUM_BOOTS));

//        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_HELMET));
//        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_CHESTPLATE));
//        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_LEGGINGS));
//        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_BOOTS));


        itemModelGenerator.register(ModItems.TIN_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.STERLING_SILVER_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSE_GOLD_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.COBALT_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARBON_STEEL_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.HARDENED_STEEL_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQUOISE_HORSE_ARMOR, Models.GENERATED);
//        itemModelGenerator.register(ModItems.TANZANITE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOURMALINE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPINEL_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.CITRINE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOISSANITE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONYX_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPHENE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAMANTIUM_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_HORSE_ARMOR, Models.GENERATED);
//        itemModelGenerator.register(ModItems.ENDERITE_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_DUCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_DUCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUCK_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWEET_CAROLINE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.CIPHER_DISC, Models.GENERATED);

        //TODO Fix duck egg
//        itemModelGenerator.register(ModItems.DUCK_SPAWN_EGG,
//                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

        /* Shields? */
        itemModelGenerator.register(ModItems.TIN_SHIELD, Models.GENERATED);
//        itemModelGenerator.register(ModItems.GOLD_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STERLING_SILVER_SHIELD, Models.GENERATED);
//        itemModelGenerator.register(ModItems.ROSE_GOLD_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.COBALT_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARBON_STEEL_SHIELD, Models.GENERATED);
//        itemModelGenerator.register(ModItems.HARDENED_STEEL_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.TURQUOISE_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOURMALINE_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_SHIELD, Models.GENERATED);
//        itemModelGenerator.register(ModItems.DIAMOND_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_SHIELD, Models.GENERATED);
//        itemModelGenerator.register(ModItems.SPINEL_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CITRINE_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOISSANITE_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONYX_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_SHIELD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPHENE_SHIELD, Models.GENERATED);
//        itemModelGenerator.register(ModItems.NETHERITE_SHIELD, Models.GENERATED);
    }
}