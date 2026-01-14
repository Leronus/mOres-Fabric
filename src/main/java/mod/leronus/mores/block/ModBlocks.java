package mod.leronus.mores.block;

import mod.leronus.mores.Mores;
import mod.leronus.mores.block.custom.AlloyFurnaceBlock;
import mod.leronus.mores.block.custom.FallingOreBlock;
import mod.leronus.mores.block.custom.SteelCutterBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static net.minecraft.block.Blocks.DIAMOND_ORE;
import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;


/**
 * Class that initialises all blocks from mOres
 * @author Leronus
 */
public class ModBlocks {
    /**
     * Fills the registry with blocks
     */
    //.strength(destroyTime, blastResistance)
    public static final AlloyFurnaceBlock ALLOY_FURNACE = registerBlock("alloy_furnace", new AlloyFurnaceBlock(AbstractBlock.Settings.copy(Blocks.FURNACE).mapColor(MapColor.LIGHT_GRAY).strength(4.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool().luminance(createLightLevelFromLitBlockState(13))));
    public static final SteelCutterBlock STEEL_CUTTER = registerBlock("steel_cutter", new SteelCutterBlock(AbstractBlock.Settings.copy(Blocks.STONECUTTER).sounds(BlockSoundGroup.METAL).requiresTool()));

    public static final Block QUARTZ_ORE = registerBlock("quartz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block ELECTRUM_ORE = registerBlock("electrum_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.GOLD_ORE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block ANTHRACITE_ORE = registerBlock("anthracite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.COAL_ORE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block NETHER_ANTHRACITE_ORE = registerBlock("nether_anthracite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(1, 3), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.BLACK).strength(3.0F, 3.0F).sounds(BlockSoundGroup.NETHER_GOLD_ORE).requiresTool()));
    public static final Block DEEPSLATE_ANTHRACITE_ORE = registerBlock("deepslate_anthracite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(1, 3), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_COAL_ORE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    public static final Block TIN_BLOCK = registerBlock("tin_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresTool().strength(4.0F, 5.0F).sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresTool().strength(4.0F, 5.0F).sounds(BlockSoundGroup.METAL)));
    public static final Block TIN_ORE = registerBlock("tin_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.COPPER_ORE).requiresTool().strength(2.5F, 2.5F)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_COPPER_ORE).requiresTool().strength(4.0F, 2.5F)));
    public static final Block ANDESITE_TIN_ORE = registerBlock("andesite_tin_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.ANDESITE).requiresTool().strength(2.5F, 2.5F)));
    public static final Block GRANITE_TIN_ORE = registerBlock("granite_tin_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool().strength(2.5F, 2.5F)));
    public static final Block GRAVEL_TIN_ORE = registerBlock("gravel_tin_ore", new FallingOreBlock(ConstantIntProvider.create(0), new ColorCode(-8356741), AbstractBlock.Settings.copy(Blocks.GRAVEL).requiresTool().strength(0.9F)));
    public static final Block TUFF_TIN_ORE = registerBlock("tuff_tin_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.TUFF).requiresTool().strength(2.5F, 2.5F)));

    public static final Block SILVER_BLOCK = registerBlock("silver_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block", new Block(AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)));
    public static final Block SILVER_ORE = registerBlock("silver_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.IRON_ORE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).requiresTool().strength(4.5F, 3.0F)));
    public static final Block NETHER_SILVER_ORE = registerBlock("nether_silver_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block ENDER_SILVER_ORE = registerBlock("ender_silver_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.END_STONE).requiresTool().strength(4.0F, 4.5F)));
    public static final Block ANDESITE_SILVER_ORE = registerBlock("andesite_silver_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.ANDESITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BASALT_SILVER_ORE = registerBlock("basalt_silver_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.BASALT).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BLACKSTONE_SILVER_ORE = registerBlock("blackstone_silver_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.BLACKSTONE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block CALCITE_SILVER_ORE = registerBlock("calcite_silver_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool().strength(1.5F)));
    public static final Block DIORITE_SILVER_ORE = registerBlock("diorite_silver_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.DIORITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRANITE_SILVER_ORE = registerBlock("granite_silver_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRAVEL_SILVER_ORE = registerBlock("gravel_silver_ore", new FallingOreBlock(ConstantIntProvider.create(0), new ColorCode(-8356741), AbstractBlock.Settings.copy(Blocks.GRAVEL).requiresTool().strength(1.2F)));
    public static final Block TUFF_SILVER_ORE = registerBlock("tuff_silver_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.TUFF).requiresTool().strength(3.0F, 3.0F)));

    public static final Block COBALT_BLOCK = registerBlock("cobalt_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block", new Block(AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)));
    public static final Block COBALT_ORE = registerBlock("cobalt_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.IRON_ORE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).strength(4.5F, 3.0F)));
    public static final Block ENDER_COBALT_ORE = registerBlock("ender_cobalt_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.END_STONE).requiresTool().strength(4.5F, 4.5F)));
    public static final Block ANDESITE_COBALT_ORE = registerBlock("andesite_cobalt_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.ANDESITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BASALT_COBALT_ORE = registerBlock("basalt_cobalt_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.BASALT).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BLACKSTONE_COBALT_ORE = registerBlock("blackstone_cobalt_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.BLACKSTONE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block CALCITE_COBALT_ORE = registerBlock("calcite_cobalt_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool().strength(1.5F)));
    public static final Block DIORITE_COBALT_ORE = registerBlock("diorite_cobalt_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.DIORITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRANITE_COBALT_ORE = registerBlock("granite_cobalt_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRAVEL_COBALT_ORE = registerBlock("gravel_cobalt_ore", new FallingOreBlock(ConstantIntProvider.create(0), new ColorCode(-8356741), AbstractBlock.Settings.copy(Blocks.GRAVEL).requiresTool().strength(1.2F)));
    public static final Block TUFF_COBALT_ORE = registerBlock("tuff_cobalt_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(Blocks.TUFF).requiresTool().strength(3.0F, 3.0F)));

    public static final Block BRONZE_BLOCK = registerBlock("bronze_block", new Block(AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block STERLING_SILVER_BLOCK = registerBlock("sterling_silver_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.OFF_WHITE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.DULL_PINK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block CARBON_STEEL_BLOCK = registerBlock("carbon_steel_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.BROWN).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block HARDENED_STEEL_BLOCK = registerBlock("hardened_steel_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.IRON_GRAY).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block AMETHYST_BLOCK = registerBlock("amethyst_block", new Block(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    public static final Block TURQUOISE_BLOCK = registerBlock("turquoise_block", new Block(AbstractBlock.Settings.copy(Blocks.LAPIS_BLOCK).mapColor(MapColor.CYAN).strength(3.0F, 3.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block TURQUOISE_ORE = registerBlock("turquoise_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 6), AbstractBlock.Settings.copy(Blocks.LAPIS_ORE).mapColor(MapColor.CYAN).strength(4.5F, 3.0F).requiresTool()));
    public static final Block DEEPSLATE_TURQUOISE_ORE = registerBlock("deepslate_turquoise_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 6), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_LAPIS_ORE).mapColor(MapColor.CYAN).strength(4.5F, 3.0F).requiresTool()));

    public static final Block CITRINE_BLOCK = registerBlock("citrine_block", new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.ORANGE).strength(1.0F).requiresTool()));
    public static final Block CITRINE_ORE = registerBlock("citrine_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.ORANGE).requiresTool().strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE)));
    public static final Block NETHER_CITRINE_ORE = registerBlock("nether_citrine_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.ORANGE).requiresTool().strength(3.0F, 3.0F)));

    public static final Block ONYX_BLOCK = registerBlock("onyx_block", new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK).mapColor(MapColor.BLACK).strength(1.2F).requiresTool()));
    public static final Block NETHER_ONYX_ORE = registerBlock("nether_onyx_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.BLACK).requiresTool()));
    public static final Block ENDER_ONYX_ORE = registerBlock("ender_onyx_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.copy(Blocks.END_STONE).requiresTool()));

    public static final Block TOURMALINE_BLOCK = registerBlock("tourmaline_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.PINK).strength(5.0F, 6.0F).requiresTool()));
    public static final Block TOURMALINE_ORE = registerBlock("tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block DEEPSLATE_TOURMALINE_ORE = registerBlock("deepslate_tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).strength(4.5F, 3.0F).requiresTool()));
    public static final Block NETHER_TOURMALINE_ORE = registerBlock("nether_tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(DIAMOND_ORE).strength(2.5F, 1.5F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
    public static final Block ENDER_TOURMALINE_ORE = registerBlock("ender_tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.END_STONE).requiresTool().strength(4.5F, 4.5F)));
    public static final Block ANDESITE_TOURMALINE_ORE = registerBlock("andesite_tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.ANDESITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BASALT_TOURMALINE_ORE = registerBlock("basalt_tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.BASALT).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BLACKSTONE_TOURMALINE_ORE = registerBlock("blackstone_tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.BLACKSTONE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block CALCITE_TOURMALINE_ORE = registerBlock("calcite_tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool().strength(1.5F)));
    public static final Block DIORITE_TOURMALINE_ORE = registerBlock("diorite_tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DIORITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRANITE_TOURMALINE_ORE = registerBlock("granite_tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool().strength(3.0F, 3.0F)));
    //TODO Figure out how to award xp
    public static final Block GRAVEL_TOURMALINE_ORE = registerBlock("gravel_tourmaline_ore", new FallingOreBlock(UniformIntProvider.create(3, 7), new ColorCode(-8356741), AbstractBlock.Settings.copy(Blocks.GRAVEL).requiresTool().strength(1.2F)));
    public static final Block TUFF_TOURMALINE_ORE = registerBlock("tuff_tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.TUFF).requiresTool().strength(3.0F, 3.0F)));

    public static final Block TOPAZ_BLOCK = registerBlock("topaz_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.LIGHT_BLUE).strength(5.0F, 6.0F).requiresTool()));
    public static final Block TOPAZ_ORE = registerBlock("topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block NETHER_TOPAZ_ORE = registerBlock("nether_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).strength(2.5F, 2.5F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
    public static final Block ENDER_TOPAZ_ORE = registerBlock("ender_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.END_STONE).requiresTool().strength(4.5F, 4.5F)));
    public static final Block ANDESITE_TOPAZ_ORE = registerBlock("andesite_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.ANDESITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BASALT_TOPAZ_ORE = registerBlock("basalt_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.BASALT).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BLACKSTONE_TOPAZ_ORE = registerBlock("blackstone_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.BLACKSTONE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block CALCITE_TOPAZ_ORE = registerBlock("calcite_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool().strength(1.5F)));
    public static final Block DIORITE_TOPAZ_ORE = registerBlock("diorite_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DIORITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRANITE_TOPAZ_ORE = registerBlock("granite_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRAVEL_TOPAZ_ORE = registerBlock("gravel_topaz_ore", new FallingOreBlock(UniformIntProvider.create(3, 7), new ColorCode(-8356741), AbstractBlock.Settings.copy(Blocks.GRAVEL).requiresTool().strength(1.2F)));
    public static final Block TUFF_TOPAZ_ORE = registerBlock("tuff_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.TUFF).requiresTool().strength(3.0F, 3.0F)));

    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.PURPLE).strength(5.0F, 6.0F).requiresTool()));
    public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).strength(4.5F, 3.0F).requiresTool()));
    public static final Block NETHER_TANZANITE_ORE = registerBlock("nether_tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).strength(2.5F, 2.5F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
    public static final Block ENDER_TANZANITE_ORE = registerBlock("ender_tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.END_STONE).requiresTool().strength(4.5F, 4.5F)));
    public static final Block ANDESITE_TANZANITE_ORE = registerBlock("andesite_tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.ANDESITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BASALT_TANZANITE_ORE = registerBlock("basalt_tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.BASALT).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BLACKSTONE_TANZANITE_ORE = registerBlock("blackstone_tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.BLACKSTONE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block CALCITE_TANZANITE_ORE = registerBlock("calcite_tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool().strength(1.5F)));
    public static final Block DIORITE_TANZANITE_ORE = registerBlock("diorite_tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DIORITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRANITE_TANZANITE_ORE = registerBlock("granite_tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRAVEL_TANZANITE_ORE = registerBlock("gravel_tanzanite_ore", new FallingOreBlock(UniformIntProvider.create(3, 7), new ColorCode(-8356741), AbstractBlock.Settings.copy(Blocks.GRAVEL).requiresTool().strength(1.2F)));
    public static final Block TUFF_TANZANITE_ORE = registerBlock("tuff_tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.TUFF).requiresTool().strength(3.0F, 3.0F)));

    public static final Block SPINEL_BLOCK = registerBlock("spinel_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.DARK_RED).strength(5.0F, 6.0F).requiresTool()));
    public static final Block SPINEL_ORE = registerBlock("spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block DEEPSLATE_SPINEL_ORE = registerBlock("deepslate_spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block NETHER_SPINEL_ORE = registerBlock("nether_spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).strength(2.5F, 2.5F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
    public static final Block ENDER_SPINEL_ORE = registerBlock("ender_spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.END_STONE).requiresTool().strength(4.5F, 4.5F)));
    public static final Block ANDESITE_SPINEL_ORE = registerBlock("andesite_spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.ANDESITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BASALT_SPINEL_ORE = registerBlock("basalt_spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.BASALT).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BLACKSTONE_SPINEL_ORE = registerBlock("blackstone_spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.BLACKSTONE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block CALCITE_SPINEL_ORE = registerBlock("calcite_spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool().strength(1.5F)));
    public static final Block DIORITE_SPINEL_ORE = registerBlock("diorite_spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DIORITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRANITE_SPINEL_ORE = registerBlock("granite_spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRAVEL_SPINEL_ORE = registerBlock("gravel_spinel_ore", new FallingOreBlock(UniformIntProvider.create(3, 7), new ColorCode(-8356741), AbstractBlock.Settings.copy(Blocks.GRAVEL).requiresTool().strength(1.2F)));
    public static final Block TUFF_SPINEL_ORE = registerBlock("tuff_spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.TUFF).requiresTool().strength(3.0F, 3.0F)));

    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.RED).strength(5.0F, 6.0F).requiresTool()));
    public static final Block RUBY_ORE = registerBlock("ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(DIAMOND_ORE).strength(2.5F, 2.5F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
    public static final Block ENDER_RUBY_ORE = registerBlock("ender_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.END_STONE).requiresTool().strength(4.5F, 4.5F)));
    public static final Block ANDESITE_RUBY_ORE = registerBlock("andesite_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.ANDESITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BASALT_RUBY_ORE = registerBlock("basalt_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.BASALT).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BLACKSTONE_RUBY_ORE = registerBlock("blackstone_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.BLACKSTONE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block CALCITE_RUBY_ORE = registerBlock("calcite_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool().strength(1.5F)));
    public static final Block DIORITE_RUBY_ORE = registerBlock("diorite_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.DIORITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRANITE_RUBY_ORE = registerBlock("granite_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRAVEL_RUBY_ORE = registerBlock("gravel_ruby_ore", new FallingOreBlock(UniformIntProvider.create(3, 9), new ColorCode(-8356741), AbstractBlock.Settings.copy(Blocks.GRAVEL).requiresTool().strength(1.2F)));
    public static final Block TUFF_RUBY_ORE = registerBlock("tuff_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.TUFF).requiresTool().strength(3.0F, 3.0F)));

    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.BLUE).strength(5.0F, 6.0F).requiresTool()));
    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 10), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(DIAMOND_ORE).strength(2.5F, 2.5F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
    public static final Block ENDER_SAPPHIRE_ORE = registerBlock("ender_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.END_STONE).requiresTool().strength(4.5F, 4.5F)));
    public static final Block ANDESITE_SAPPHIRE_ORE = registerBlock("andesite_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.ANDESITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BASALT_SAPPHIRE_ORE = registerBlock("basalt_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.BASALT).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BLACKSTONE_SAPPHIRE_ORE = registerBlock("blackstone_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.BLACKSTONE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block CALCITE_SAPPHIRE_ORE = registerBlock("calcite_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool().strength(1.5F)));
    public static final Block DIORITE_SAPPHIRE_ORE = registerBlock("diorite_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.DIORITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRANITE_SAPPHIRE_ORE = registerBlock("granite_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRAVEL_SAPPHIRE_ORE = registerBlock("gravel_sapphire_ore", new FallingOreBlock(UniformIntProvider.create(3, 9), new ColorCode(-8356741), AbstractBlock.Settings.copy(Blocks.GRAVEL).requiresTool().strength(1.2F)));
    public static final Block TUFF_SAPPHIRE_ORE = registerBlock("tuff_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.TUFF).requiresTool().strength(3.0F, 3.0F)));

    public static final Block MOISSANITE_BLOCK = registerBlock("moissanite_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.LICHEN_GREEN).strength(5.5F, 6.0F).requiresTool()));
    public static final Block MOISSANITE_ORE = registerBlock("moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(4, 9), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).strength(3.0F, 3.0F).requiresTool()));
    public static final Block DEEPSLATE_MOISSANITE_ORE = registerBlock("deepslate_moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(4, 10), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block NETHER_MOISSANITE_ORE = registerBlock("nether_moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(4, 9), AbstractBlock.Settings.copy(DIAMOND_ORE).strength(5.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
    public static final Block ENDER_MOISSANITE_ORE = registerBlock("ender_moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.END_STONE).requiresTool().strength(4.5F, 4.5F)));
    public static final Block ANDESITE_MOISSANITE_ORE = registerBlock("andesite_moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.ANDESITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BASALT_MOISSANITE_ORE = registerBlock("basalt_moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.BASALT).requiresTool().strength(3.0F, 3.0F)));
    public static final Block BLACKSTONE_MOISSANITE_ORE = registerBlock("blackstone_moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.BLACKSTONE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block CALCITE_MOISSANITE_ORE = registerBlock("calcite_moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool().strength(1.5F)));
    public static final Block DIORITE_MOISSANITE_ORE = registerBlock("diorite_moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.DIORITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRANITE_MOISSANITE_ORE = registerBlock("granite_moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool().strength(3.0F, 3.0F)));
    public static final Block GRAVEL_MOISSANITE_ORE = registerBlock("gravel_moissanite_ore", new FallingOreBlock(UniformIntProvider.create(3, 9), new ColorCode(-8356741), AbstractBlock.Settings.copy(Blocks.GRAVEL).requiresTool().strength(1.2F)));
    public static final Block TUFF_MOISSANITE_ORE = registerBlock("tuff_moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.TUFF).requiresTool().strength(3.0F, 3.0F)));

    public static final Block ADAMANTIUM_BLOCK = registerBlock("adamantium_block", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.CYAN).strength(6.0F, 7.0F).requiresTool()));

    public static final Block PRIMORDIAL_DEBRIS = registerBlock("primordial_debris", new Block(AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS).mapColor(MapColor.DARK_GREEN).strength(35.0F, 1500.0F).sounds(BlockSoundGroup.ANCIENT_DEBRIS)));
    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.DARK_GREEN).strength(60.0F, 1500.0F).sounds(BlockSoundGroup.NETHERITE)));

    private static void addItemsToBuildingBlockItemGroup(FabricItemGroupEntries entries) {
        entries.add(ALLOY_FURNACE);

        entries.add(TIN_BLOCK);
        entries.add(RAW_TIN_BLOCK);
        entries.add(TIN_ORE);
        entries.add(DEEPSLATE_TIN_ORE);
        entries.add(ANDESITE_TIN_ORE);
        entries.add(GRANITE_TIN_ORE);
        entries.add(GRAVEL_TIN_ORE);
        entries.add(TUFF_TIN_ORE);

        entries.add(SILVER_BLOCK);
        entries.add(RAW_SILVER_BLOCK);
        entries.add(ELECTRUM_ORE);
        entries.add(SILVER_ORE);
        entries.add(NETHER_SILVER_ORE);
        entries.add(ENDER_SILVER_ORE);
        entries.add(DEEPSLATE_SILVER_ORE);
        entries.add(ANDESITE_SILVER_ORE);
        entries.add(BASALT_SILVER_ORE);
        entries.add(BLACKSTONE_SILVER_ORE);
        entries.add(CALCITE_SILVER_ORE);
        entries.add(DIORITE_SILVER_ORE);
        entries.add(GRANITE_SILVER_ORE);
        entries.add(GRAVEL_SILVER_ORE);
        entries.add(TUFF_SILVER_ORE);

        entries.add(COBALT_BLOCK);
        entries.add(RAW_COBALT_BLOCK);
        entries.add(COBALT_ORE);
        entries.add(DEEPSLATE_COBALT_ORE);
        entries.add(ENDER_COBALT_ORE);
        entries.add(ANDESITE_COBALT_ORE);
        entries.add(BASALT_COBALT_ORE);
        entries.add(BLACKSTONE_COBALT_ORE);
        entries.add(CALCITE_COBALT_ORE);
        entries.add(DIORITE_COBALT_ORE);
        entries.add(GRANITE_COBALT_ORE);
        entries.add(GRAVEL_COBALT_ORE);
        entries.add(TUFF_COBALT_ORE);

        entries.add(BRONZE_BLOCK);
        entries.add(STERLING_SILVER_BLOCK);
        entries.add(ROSE_GOLD_BLOCK);
        entries.add(CARBON_STEEL_BLOCK);
        entries.add(HARDENED_STEEL_BLOCK);

        entries.add(TURQUOISE_BLOCK);
        entries.add(TURQUOISE_ORE);
        entries.add(DEEPSLATE_TURQUOISE_ORE);

        entries.add(AMETHYST_BLOCK);
        entries.add(QUARTZ_ORE);

        entries.add(CITRINE_BLOCK);
        entries.add(CITRINE_ORE);
        entries.add(NETHER_CITRINE_ORE);

        entries.add(TANZANITE_BLOCK);
        entries.add(TANZANITE_ORE);
        entries.add(DEEPSLATE_TANZANITE_ORE);
        entries.add(NETHER_TANZANITE_ORE);
        entries.add(ENDER_TANZANITE_ORE);
        entries.add(ANDESITE_TANZANITE_ORE);
        entries.add(BASALT_TANZANITE_ORE);
        entries.add(BLACKSTONE_TANZANITE_ORE);
        entries.add(CALCITE_TANZANITE_ORE);
        entries.add(DIORITE_TANZANITE_ORE);
        entries.add(GRANITE_TANZANITE_ORE);
        entries.add(GRAVEL_TANZANITE_ORE);
        entries.add(TUFF_TANZANITE_ORE);

        entries.add(TOURMALINE_BLOCK);
        entries.add(TOURMALINE_ORE);
        entries.add(DEEPSLATE_TOURMALINE_ORE);
        entries.add(NETHER_TOURMALINE_ORE);
        entries.add(ENDER_TOURMALINE_ORE);
        entries.add(ANDESITE_TOURMALINE_ORE);
        entries.add(BASALT_TOURMALINE_ORE);
        entries.add(BLACKSTONE_TOURMALINE_ORE);
        entries.add(CALCITE_TOURMALINE_ORE);
        entries.add(DIORITE_TOURMALINE_ORE);
        entries.add(GRANITE_TOURMALINE_ORE);
        entries.add(GRAVEL_TOURMALINE_ORE);
        entries.add(TUFF_TOURMALINE_ORE);

        entries.add(TOPAZ_BLOCK);
        entries.add(TOPAZ_ORE);
        entries.add(DEEPSLATE_TOPAZ_ORE);
        entries.add(NETHER_TOPAZ_ORE);
        entries.add(ENDER_TOPAZ_ORE);
        entries.add(ANDESITE_TOPAZ_ORE);
        entries.add(BASALT_TOPAZ_ORE);
        entries.add(BLACKSTONE_TOPAZ_ORE);
        entries.add(CALCITE_TOPAZ_ORE);
        entries.add(DIORITE_TOPAZ_ORE);
        entries.add(GRANITE_TOPAZ_ORE);
        entries.add(GRAVEL_TOPAZ_ORE);
        entries.add(TUFF_TOPAZ_ORE);

        entries.add(SPINEL_BLOCK);
        entries.add(SPINEL_ORE);
        entries.add(DEEPSLATE_SPINEL_ORE);
        entries.add(NETHER_SPINEL_ORE);
        entries.add(ENDER_SPINEL_ORE);
        entries.add(ANDESITE_SPINEL_ORE);
        entries.add(BASALT_SPINEL_ORE);
        entries.add(BLACKSTONE_SPINEL_ORE);
        entries.add(CALCITE_SPINEL_ORE);
        entries.add(DIORITE_SPINEL_ORE);
        entries.add(GRANITE_SPINEL_ORE);
        entries.add(GRAVEL_SPINEL_ORE);
        entries.add(TUFF_SPINEL_ORE);

        entries.add(RUBY_BLOCK);
        entries.add(RUBY_ORE);
        entries.add(DEEPSLATE_RUBY_ORE);
        entries.add(NETHER_RUBY_ORE);
        entries.add(ENDER_RUBY_ORE);
        entries.add(ANDESITE_RUBY_ORE);
        entries.add(BASALT_RUBY_ORE);
        entries.add(BLACKSTONE_RUBY_ORE);
        entries.add(CALCITE_RUBY_ORE);
        entries.add(DIORITE_RUBY_ORE);
        entries.add(GRANITE_RUBY_ORE);
        entries.add(GRAVEL_RUBY_ORE);
        entries.add(TUFF_RUBY_ORE);

        entries.add(SAPPHIRE_BLOCK);
        entries.add(SAPPHIRE_ORE);
        entries.add(DEEPSLATE_SAPPHIRE_ORE);
        entries.add(NETHER_SAPPHIRE_ORE);
        entries.add(ENDER_SAPPHIRE_ORE);
        entries.add(ANDESITE_SAPPHIRE_ORE);
        entries.add(BASALT_SAPPHIRE_ORE);
        entries.add(BLACKSTONE_SAPPHIRE_ORE);
        entries.add(CALCITE_SAPPHIRE_ORE);
        entries.add(DIORITE_SAPPHIRE_ORE);
        entries.add(GRANITE_SAPPHIRE_ORE);
        entries.add(GRAVEL_SAPPHIRE_ORE);
        entries.add(TUFF_SAPPHIRE_ORE);

        entries.add(MOISSANITE_BLOCK);
        entries.add(MOISSANITE_ORE);
        entries.add(DEEPSLATE_MOISSANITE_ORE);
        entries.add(NETHER_MOISSANITE_ORE);
        entries.add(ENDER_MOISSANITE_ORE);
        entries.add(ANDESITE_MOISSANITE_ORE);
        entries.add(BASALT_MOISSANITE_ORE);
        entries.add(BLACKSTONE_MOISSANITE_ORE);
        entries.add(CALCITE_MOISSANITE_ORE);
        entries.add(DIORITE_MOISSANITE_ORE);
        entries.add(GRANITE_MOISSANITE_ORE);
        entries.add(GRAVEL_MOISSANITE_ORE);
        entries.add(TUFF_MOISSANITE_ORE);

        entries.add(NETHER_ONYX_ORE);
        entries.add(ENDER_ONYX_ORE);
        entries.add(ADAMANTIUM_BLOCK);

        entries.add(PRIMORDIAL_DEBRIS);
        entries.add(ENDERITE_BLOCK);
    }

    private static <T extends Block> T registerBlock(String name, T block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Mores.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(
                Registries.ITEM,
                Identifier.of(Mores.MOD_ID, name),
                new BlockItem(block, new Item.Settings())
        );
    }

    public static void registerModBlocks() {
        Mores.LOGGER.info("Registering ModBlocks for " + Mores.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToBuildingBlockItemGroup);
    }
}

