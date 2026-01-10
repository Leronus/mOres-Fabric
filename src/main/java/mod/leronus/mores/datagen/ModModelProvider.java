package mod.leronus.mores.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mod.leronus.mores.Mores;
import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.block.custom.AlloyFurnaceBlock;
import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.trim.ModTrimMaterials;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANDESITE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANITE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAVEL_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUFF_TIN_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANDESITE_SILVER_ORE);
        blockStateModelGenerator.registerSingleton(ModBlocks.BASALT_SILVER_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.BLACKSTONE_SILVER_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CALCITE_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIORITE_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANITE_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAVEL_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUFF_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ELECTRUM_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANDESITE_COBALT_ORE);
        blockStateModelGenerator.registerSingleton(ModBlocks.BASALT_COBALT_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.BLACKSTONE_COBALT_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CALCITE_COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIORITE_COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANITE_COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAVEL_COBALT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUFF_COBALT_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURQUOISE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TURQUOISE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUARTZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CITRINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_CITRINE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TANZANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TANZANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_TANZANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_TANZANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANDESITE_TANZANITE_ORE);
        blockStateModelGenerator.registerSingleton(ModBlocks.BASALT_TANZANITE_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.BLACKSTONE_TANZANITE_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CALCITE_TANZANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIORITE_TANZANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANITE_TANZANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAVEL_TANZANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUFF_TANZANITE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOURMALINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TOURMALINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_TOURMALINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_TOURMALINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANDESITE_TOURMALINE_ORE);
        blockStateModelGenerator.registerSingleton(ModBlocks.BASALT_TOURMALINE_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.BLACKSTONE_TOURMALINE_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CALCITE_TOURMALINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIORITE_TOURMALINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANITE_TOURMALINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAVEL_TOURMALINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUFF_TOURMALINE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANDESITE_TOPAZ_ORE);
        blockStateModelGenerator.registerSingleton(ModBlocks.BASALT_TOPAZ_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.BLACKSTONE_TOPAZ_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CALCITE_TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIORITE_TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANITE_TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAVEL_TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUFF_TOPAZ_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPINEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SPINEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SPINEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_SPINEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANDESITE_SPINEL_ORE);
        blockStateModelGenerator.registerSingleton(ModBlocks.BASALT_SPINEL_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.BLACKSTONE_SPINEL_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CALCITE_SPINEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIORITE_SPINEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANITE_SPINEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAVEL_SPINEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUFF_SPINEL_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANDESITE_RUBY_ORE);
        blockStateModelGenerator.registerSingleton(ModBlocks.BASALT_RUBY_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.BLACKSTONE_RUBY_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CALCITE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIORITE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANITE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAVEL_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUFF_RUBY_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANDESITE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSingleton(ModBlocks.BASALT_SAPPHIRE_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.BLACKSTONE_SAPPHIRE_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CALCITE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIORITE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANITE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAVEL_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUFF_SAPPHIRE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOISSANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_MOISSANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_MOISSANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_MOISSANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANDESITE_MOISSANITE_ORE);
        blockStateModelGenerator.registerSingleton(ModBlocks.BASALT_MOISSANITE_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(ModBlocks.BLACKSTONE_MOISSANITE_ORE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CALCITE_MOISSANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIORITE_MOISSANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANITE_MOISSANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAVEL_MOISSANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUFF_MOISSANITE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_ONYX_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDER_ONYX_ORE);
        blockStateModelGenerator.registerSingleton(ModBlocks.PRIMORDIAL_DEBRIS, TexturedModel.CUBE_COLUMN);

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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CITRINE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TANZANITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOURMALINE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPINEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOISSANITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ONYX_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADAMANTIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDERITE_BLOCK);
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


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//        ModTrimMaterials.class.getName();

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
        itemModelGenerator.register(ModItems.QUARTZ_DUST, Models.GENERATED);
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
        itemModelGenerator.register(ModItems.ADAMANTIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.HOT_CARBON_STEEL_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARBON_STEEL_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERITE_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

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
        itemModelGenerator.register(ModItems.TANZANITE_GEM, Models.GENERATED);
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
        Identifier baseId = ModelIds.getItemModelId(ModItems.ROSE_GOLD_SPEAR); // mores:item/rose_gold_spear
        Identifier inHandId = Identifier.of(baseId.getNamespace(), baseId.getPath() + "_in_hand");
        // Base model: generated + override to _in_hand while using
        itemModelGenerator.writer.accept(baseId, spearBaseJson(baseId.getNamespace(), "rose_gold_spear"));
        // In-hand model: uses minecraft:item/spear_in_hand parent
        itemModelGenerator.writer.accept(inHandId, spearInHandJson(baseId.getNamespace(), "rose_gold_spear"));


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

        itemModelGenerator.register(ModItems.ENDERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_BATTLE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_BATTLE_MACE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_DAGGER, Models.HANDHELD);

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
        itemModelGenerator.register(ModItems.TANZANITE_HORSE_ARMOR, Models.GENERATED);
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
        itemModelGenerator.register(ModItems.ENDERITE_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.ROSE_GOLD_WOLF_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_DUCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_DUCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUCK_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWEET_CAROLINE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.CIPHER_MUSIC_DISC, Models.GENERATED);

        //TODO Fix duck egg
//        itemModelGenerator.register(ModItems.DUCK_SPAWN_EGG,
//                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

        /* Shields */
        registerShield(itemModelGenerator, "tin_shield");
        registerShield(itemModelGenerator, "silver_shield");
//        registerShield(itemModelGenerator, "gold_shield");
        registerShield(itemModelGenerator, "copper_shield");
        registerShield(itemModelGenerator, "sterling_silver_shield");
        registerShield(itemModelGenerator, "rose_gold_shield");
        registerShield(itemModelGenerator, "bronze_shield");
        registerShield(itemModelGenerator, "cobalt_shield");
        registerShield(itemModelGenerator, "carbon_steel_shield");
        registerShield(itemModelGenerator, "hardened_steel_shield");
        registerShield(itemModelGenerator, "amethyst_shield");
        registerShield(itemModelGenerator, "turquoise_shield");
        registerShield(itemModelGenerator, "citrine_shield");
        registerShield(itemModelGenerator, "lapis_lazuli_shield");
        registerShield(itemModelGenerator, "tanzanite_shield");
        registerShield(itemModelGenerator, "topaz_shield");
        registerShield(itemModelGenerator, "tourmaline_shield");
        registerShield(itemModelGenerator, "emerald_shield");
        registerShield(itemModelGenerator, "spinel_shield");
        registerShield(itemModelGenerator, "ruby_shield");
        registerShield(itemModelGenerator, "sapphire_shield");
        registerShield(itemModelGenerator, "moissanite_shield");
        registerShield(itemModelGenerator, "onyx_shield");
        registerShield(itemModelGenerator, "obsidian_shield");
        registerShield(itemModelGenerator, "adamantium_shield");
        registerShield(itemModelGenerator, "graphene_shield");
        registerShield(itemModelGenerator, "enderite_shield");

    }

    /* ---------------- helpers ---------------- */
    private static Supplier<JsonElement> spearBaseJson(String modid, String name) {
        return () -> {
            JsonObject root = new JsonObject();
            root.addProperty("parent", "minecraft:item/generated");

            JsonObject textures = new JsonObject();
            textures.addProperty("layer0", modid + ":item/" + name);
            root.add("textures", textures);

            JsonArray overrides = new JsonArray();
            JsonObject ov = new JsonObject();

            JsonObject predicate = new JsonObject();
            predicate.addProperty("spears:in_gui", 0);
            ov.add("predicate", predicate);

            ov.addProperty("model", modid + ":item/" + name + "_in_hand");
            overrides.add(ov);

            root.add("overrides", overrides);
            return root;
        };
    }

    private static Supplier<JsonElement> spearInHandJson(String modid, String name) {
        return () -> {
            JsonObject root = new JsonObject();
            root.addProperty("parent", "minecraft:item/spear_in_hand");

            JsonObject textures = new JsonObject();
            textures.addProperty("layer0", modid + ":item/" + name + "_in_hand"); // <-- important
            root.add("textures", textures);

            return root;
        };
    }

    private static void registerShield(ItemModelGenerator gen, String name) {
        Identifier baseId = Identifier.of(Mores.MOD_ID, "item/" + name);
        Identifier blockingId = Identifier.of(Mores.MOD_ID, "item/" + name + "_blocking");

        // points to:
        // assets/mores/textures/entity/shield/<name>.png
        // assets/mores/textures/entity/shield/<name>_nopattern.png
        Identifier texPattern = Identifier.of(Mores.MOD_ID, "entity/shield/" + name);
        Identifier texNoPattern = Identifier.of(Mores.MOD_ID, "entity/shield/" + name + "_nopattern");

        // ---- base model ----
        gen.writer.accept(baseId, () -> {
            var json = new com.google.gson.JsonObject();
            json.addProperty("parent", "minecraft:item/shield");

            var textures = new com.google.gson.JsonObject();
            textures.addProperty("shield", texPattern.toString());
            textures.addProperty("shield_nopattern", texNoPattern.toString());
            json.add("textures", textures);

            // override to OUR blocking model (not vanilla)
            var overrides = new com.google.gson.JsonArray();
            var entry = new com.google.gson.JsonObject();

            var predicate = new com.google.gson.JsonObject();
            predicate.addProperty("blocking", 1.0f);

            entry.add("predicate", predicate);
            entry.addProperty("model", blockingId.toString());

            overrides.add(entry);
            json.add("overrides", overrides);

            return json;
        });

        // ---- blocking model ----
        gen.writer.accept(blockingId, () -> {
            var json = new com.google.gson.JsonObject();
            json.addProperty("parent", "minecraft:item/shield_blocking");

            var textures = new com.google.gson.JsonObject();
            textures.addProperty("shield", texPattern.toString());
            textures.addProperty("shield_nopattern", texNoPattern.toString());
            json.add("textures", textures);

            return json;
        });
    }
}