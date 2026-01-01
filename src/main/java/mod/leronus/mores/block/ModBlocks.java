package mod.leronus.mores.block;

import mod.leronus.mores.Mores;
import mod.leronus.mores.block.custom.AlloyFurnaceBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;


/**
 * Class that initialises all blocks from mOres
 * @author Leronus
 */
public class ModBlocks {
    /**
     * Fills the registry with blocks
     */
    //.strength(destroyTime, blastResistance)
            //TODO check stats
    public static final Block QUARTZ_ORE = registerBlock("quartz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block ELECTRUM_ORE = registerBlock("electrum_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.GOLD_ORE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block ANTHRACITE_ORE = registerBlock("anthracite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.COAL_ORE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block NETHER_ANTHRACITE_ORE = registerBlock("nether_anthracite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(1, 3), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.BLACK).strength(3.0F, 3.0F).sounds(BlockSoundGroup.NETHER_GOLD_ORE).requiresTool()));
    public static final Block DEEPSLATE_ANTHRACITE_ORE = registerBlock("deepslate_anthracite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(1, 3), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_COAL_ORE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    public static final Block TIN_ORE = registerBlock("tin_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.COPPER_ORE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block TIN_BLOCK = registerBlock("tin_block", new Block(AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block", new Block(AbstractBlock.Settings.copy(Blocks.RAW_COPPER_BLOCK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_COPPER_ORE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SILVER_ORE = registerBlock("silver_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.IRON_ORE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SILVER_BLOCK = registerBlock("silver_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block", new Block(AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block NETHER_SILVER_ORE = registerBlock("nether_silver_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.LIGHT_GRAY).strength(3.0F, 3.0F).sounds(BlockSoundGroup.NETHER_GOLD_ORE).requiresTool()));

    public static final Block COBALT_ORE = registerBlock("cobalt_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.IRON_ORE).mapColor(MapColor.LIGHT_BLUE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block COBALT_BLOCK = registerBlock("cobalt_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.LIGHT_BLUE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block", new Block(AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.LIGHT_BLUE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore", new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).mapColor(MapColor.LIGHT_BLUE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    public static final Block BRONZE_BLOCK = registerBlock("bronze_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.BROWN).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block STERLING_SILVER_BLOCK = registerBlock("sterling_silver_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.LIGHT_GRAY).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    //TODO CHECK STATS
    public static final Block ROSE_GOLD_BLOCK = registerBlock("rose_gold_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.LIGHT_GRAY).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block CARBON_STEEL_BLOCK = registerBlock("carbon_steel_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.GRAY).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block HARDENED_STEEL_BLOCK = registerBlock("hardened_steel_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.GRAY).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));

    public static final Block AMETHYST_BLOCK = registerBlock("amethyst_block", new Block(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    //TODO CHECK STATS
    public static final Block TURQUOISE_ORE = registerBlock("turquoise_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.CYAN).strength(4.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block TURQUOISE_BLOCK = registerBlock("turquoise_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.CYAN).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_TURQUOISE_ORE = registerBlock("deepslate_turquoise_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 9), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.CYAN).strength(5.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    //TODO CHECK STATS
    public static final Block CITRINE_BLOCK = registerBlock("citrine_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.ORANGE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block CITRINE_ORE = registerBlock("citrine_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).mapColor(MapColor.ORANGE).strength(4.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
    public static final Block NETHER_CITRINE_ORE = registerBlock("nether_citrine_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.ORANGE).strength(4.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));

    public static final Block ENDER_ONYX_ORE = registerBlock("ender_onyx_ore", new ExperienceDroppingBlock(UniformIntProvider.create(4, 10), AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS).mapColor(MapColor.BLACK).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block ONYX_BLOCK = registerBlock("onyx_block", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.BLACK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));

    public static final Block TOURMALINE_ORE = registerBlock("tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.PINK).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block TOURMALINE_BLOCK = registerBlock("tourmaline_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.PINK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_TOURMALINE_ORE = registerBlock("deepslate_tourmaline_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.PINK).strength(4.5F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block TOPAZ_ORE = registerBlock("topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 6), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.LIGHT_BLUE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block TOPAZ_BLOCK = registerBlock("topaz_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.LIGHT_BLUE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 6), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.LIGHT_BLUE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    //TODO CHECK STATS
    public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.PURPLE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.PURPLE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.PINK).strength(4.5F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block NETHER_TANZANITE_ORE = registerBlock("nether_tanzanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.PURPLE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));

    //TODO CHECK STATS
    public static final Block SPINEL_ORE = registerBlock("spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.BLUE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SPINEL_BLOCK = registerBlock("spinel_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.BLUE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_SPINEL_ORE = registerBlock("deepslate_spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.BLUE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block NETHER_SPINEL_ORE = registerBlock("nether_spinel_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.BLUE).strength(4.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));

    public static final Block RUBY_ORE = registerBlock("ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.RED).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.RED).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.RED).strength(4.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.RED).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.BLUE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.BLUE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.BLUE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.BLUE).strength(4.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));

    public static final Block MOISSANITE_ORE = registerBlock("moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 8), AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE).mapColor(MapColor.LICHEN_GREEN).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block MOISSANITE_BLOCK = registerBlock("moissanite_block", new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).mapColor(MapColor.LICHEN_GREEN).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block NETHER_MOISSANITE_ORE = registerBlock("nether_moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 8), AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.LICHEN_GREEN).strength(5.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool()));
    public static final Block DEEPSLATE_MOISSANITE_ORE = registerBlock("deepslate_moissanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 8), AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.LICHEN_GREEN).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    public static final Block GRAPHENE_BLOCK = registerBlock("graphene_block", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.GREEN).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block ADAMANTIUM_BLOCK = registerBlock("adamantium_block", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.CYAN).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));

    public static final Block PRIMORDIAL_DEBRIS = registerBlock("primordial_debris", new Block(AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS).mapColor(MapColor.DARK_GREEN).strength(30.0F, 1200.0F).sounds(BlockSoundGroup.ANCIENT_DEBRIS)));
    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block", new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.DARK_GREEN).strength(50.0F, 1200.0F).sounds(BlockSoundGroup.NETHERITE)));

    public static final AlloyFurnaceBlock ALLOY_FURNACE = registerBlock("alloy_furnace", new AlloyFurnaceBlock(AbstractBlock.Settings.copy(Blocks.FURNACE).mapColor(MapColor.LIGHT_GRAY).strength(4.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));

    private static void addItemsToBuildingBlockItemGroup(FabricItemGroupEntries entries) {
        entries.add(ALLOY_FURNACE);

        entries.add(TIN_BLOCK);
        entries.add(TIN_ORE);
        entries.add(DEEPSLATE_TIN_ORE);
        entries.add(RAW_TIN_BLOCK);

        entries.add(SILVER_BLOCK);
        entries.add(SILVER_ORE);
        entries.add(NETHER_SILVER_ORE);
        entries.add(DEEPSLATE_SILVER_ORE);
        entries.add(RAW_SILVER_BLOCK);
        entries.add(ELECTRUM_ORE);

        entries.add(COBALT_BLOCK);
        entries.add(COBALT_ORE);
        entries.add(DEEPSLATE_COBALT_ORE);
        entries.add(RAW_COBALT_BLOCK);

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

        entries.add(TOURMALINE_BLOCK);
        entries.add(TOURMALINE_ORE);
        entries.add(DEEPSLATE_TOURMALINE_ORE);

        entries.add(TOPAZ_BLOCK);
        entries.add(TOPAZ_ORE);
        entries.add(DEEPSLATE_TOPAZ_ORE);

        entries.add(SPINEL_BLOCK);
        entries.add(SPINEL_ORE);
        entries.add(DEEPSLATE_SPINEL_ORE);
        entries.add(NETHER_SPINEL_ORE);

        entries.add(RUBY_BLOCK);
        entries.add(RUBY_ORE);
        entries.add(DEEPSLATE_RUBY_ORE);
        entries.add(NETHER_RUBY_ORE);

        entries.add(SAPPHIRE_BLOCK);
        entries.add(SAPPHIRE_ORE);
        entries.add(DEEPSLATE_SAPPHIRE_ORE);
        entries.add(NETHER_SAPPHIRE_ORE);

        entries.add(MOISSANITE_BLOCK);
        entries.add(MOISSANITE_ORE);
        entries.add(DEEPSLATE_MOISSANITE_ORE);
        entries.add(NETHER_MOISSANITE_ORE);

        entries.add(ENDER_ONYX_ORE);
        entries.add(ADAMANTIUM_BLOCK);
        entries.add(GRAPHENE_BLOCK);

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

