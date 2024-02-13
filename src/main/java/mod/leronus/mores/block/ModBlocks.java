package mod.leronus.mores.block;

import mod.leronus.mores.Mores;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
    public static final Block ANTHRACITE_ORE = registerBlock("anthracite_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.COAL_ORE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(0, 2)));
    public static final Block NETHER_ANTHRACITE_ORE = registerBlock("nether_anthracite_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.BLACK).strength(3.0F, 3.0F).sounds(BlockSoundGroup.NETHER_GOLD_ORE).requiresTool(), UniformIntProvider.create(1, 3)));
    public static final Block DEEPSLATE_ANTHRACITE_ORE = registerBlock("deepslate_anthracite_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COAL_ORE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool(), UniformIntProvider.create(1, 3)));

    public static final Block TIN_ORE = registerBlock("tin_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.COPPER_ORE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block TIN_BLOCK = registerBlock("tin_block", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_COPPER_BLOCK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COPPER_ORE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SILVER_ORE = registerBlock("silver_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block SILVER_BLOCK = registerBlock("silver_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block NETHER_SILVER_ORE = registerBlock("nether_silver_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.LIGHT_GRAY).strength(3.0F, 3.0F).sounds(BlockSoundGroup.NETHER_GOLD_ORE).requiresTool(), UniformIntProvider.create(0, 2)));

    public static final Block COBALT_ORE = registerBlock("cobalt_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).mapColor(MapColor.LIGHT_BLUE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block COBALT_BLOCK = registerBlock("cobalt_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.LIGHT_BLUE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.LIGHT_BLUE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE).mapColor(MapColor.LIGHT_BLUE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    public static final Block BRONZE_BLOCK = registerBlock("bronze_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.BROWN).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));

    public static final Block STERLING_BLOCK = registerBlock("sterling_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.LIGHT_GRAY).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));

    public static final Block AMETHYST_BLOCK = registerBlock("amethyst_block", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    public static final Block STEEL_BLOCK = registerBlock("steel_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.GRAY).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block TOPAZ_ORE = registerBlock("topaz_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).mapColor(MapColor.LIGHT_BLUE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(3, 6)));
    public static final Block TOPAZ_BLOCK = registerBlock("topaz_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).mapColor(MapColor.LIGHT_BLUE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.LIGHT_BLUE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool(), UniformIntProvider.create(3, 6)));

    public static final Block TOURMALINE_ORE = registerBlock("tourmaline_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).mapColor(MapColor.PINK).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(3, 7)));
    public static final Block TOURMALINE_BLOCK = registerBlock("tourmaline_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).mapColor(MapColor.PINK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_TOURMALINE_ORE = registerBlock("deepslate_tourmaline_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.PINK).strength(4.5F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(3, 7)));

    public static final Block NETHER_TANZANITE_ORE = registerBlock("nether_tanzanite_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.PURPLE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(3, 7)));
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).mapColor(MapColor.PURPLE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));

    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).mapColor(MapColor.BLUE).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(2, 5)));
    public static final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).mapColor(MapColor.BLUE).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.BLUE).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool(), UniformIntProvider.create(3, 8)));
    public static final Block NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.BLUE).strength(4.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(3, 8)));

    public static final Block TURQUOISE_ORE = registerBlock("turquoise_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).mapColor(MapColor.CYAN).strength(4.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(3, 9)));
    public static final Block TURQUOISE_BLOCK = registerBlock("turquoise_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).mapColor(MapColor.CYAN).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block DEEPSLATE_TURQUOISE_ORE = registerBlock("deepslate_turquoise_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.CYAN).strength(5.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool(), UniformIntProvider.create(3, 9)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).mapColor(MapColor.RED).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(3, 8)));
    public static final Block RUBY_BLOCK = registerBlock("ruby_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).mapColor(MapColor.RED).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.RED).strength(4.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(3, 8)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.RED).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool(), UniformIntProvider.create(3, 8)));

    public static final Block MOISSANITE_ORE = registerBlock("moissanite_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).mapColor(MapColor.LICHEN_GREEN).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(3, 8)));
    public static final Block MOISSANITE_BLOCK = registerBlock("moissanite_block", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).mapColor(MapColor.LICHEN_GREEN).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block NETHER_MOISSANITE_ORE = registerBlock("nether_moissanite_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE).mapColor(MapColor.LICHEN_GREEN).strength(5.0F, 3.0F).sounds(BlockSoundGroup.NETHER_ORE).requiresTool(), UniformIntProvider.create(2, 8)));
    public static final Block DEEPSLATE_MOISSANITE_ORE = registerBlock("deepslate_moissanite_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).mapColor(MapColor.LICHEN_GREEN).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool(), UniformIntProvider.create(2, 8)));
    public static final Block ONYX_ORE = registerBlock("onyx_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS).mapColor(MapColor.BLACK).sounds(BlockSoundGroup.STONE).requiresTool(), UniformIntProvider.create(4, 10)));
    public static final Block ONYX_BLOCK = registerBlock("onyx_block", new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).mapColor(MapColor.BLACK).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));

    public static final Block GRAPHENE_BLOCK = registerBlock("graphene_block", new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).mapColor(MapColor.GREEN).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool()));

//    public static final AlloyFurnaceBlock ALLOY_FURNACE = registerBlock("alloy_furnace", new AlloyFurnaceBlock(FabricBlockSettings.copyOf(Blocks.FURNACE).mapColor(MapColor.LIGHT_GRAY).strength(4.0F, 6.0F).sounds(BlockSoundGroup.METAL).requiresTool().lightLevel(LightUtils.setSwitchedLight(BlockStateProperties.LIT, 13))));

    private static void addItemsToBuildingBlockItemGroup(FabricItemGroupEntries entries) {
        entries.add(TIN_BLOCK);
        entries.add(TIN_ORE);
        entries.add(DEEPSLATE_TIN_ORE);
        entries.add(RAW_TIN_BLOCK);

        entries.add(SILVER_BLOCK);
        entries.add(SILVER_ORE);
        entries.add(NETHER_SILVER_ORE);
        entries.add(DEEPSLATE_SILVER_ORE);
        entries.add(RAW_SILVER_BLOCK);

        entries.add(BRONZE_BLOCK);

        entries.add(COBALT_BLOCK);
        entries.add(COBALT_ORE);
        entries.add(DEEPSLATE_COBALT_ORE);
        entries.add(RAW_COBALT_BLOCK);

        entries.add(STERLING_BLOCK);
        entries.add(STEEL_BLOCK);
        entries.add(AMETHYST_BLOCK);

        entries.add(TOPAZ_BLOCK);
        entries.add(TOPAZ_ORE);
        entries.add(DEEPSLATE_TOPAZ_ORE);

        entries.add(TOURMALINE_BLOCK);
        entries.add(TOURMALINE_ORE);
        entries.add(DEEPSLATE_TOURMALINE_ORE);

        entries.add(TANZANITE_BLOCK);
        entries.add(NETHER_TANZANITE_ORE);

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

        entries.add(TURQUOISE_BLOCK);
        entries.add(TURQUOISE_ORE);
        entries.add(DEEPSLATE_TURQUOISE_ORE);

        entries.add(ONYX_ORE);

        entries.add(GRAPHENE_BLOCK);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Mores.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Mores.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Mores.LOGGER.info("Registering ModBlocks for " + Mores.MOD_ID);
    }
}

