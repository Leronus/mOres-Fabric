package mod.leronus.mores.item;

import mod.leronus.mores.Mores;
import mod.leronus.mores.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MATERIAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mores.MOD_ID, "materials"),
            FabricItemGroup.builder().displayName(Text.translatable("creativemodetab.mores_materials"))
                    .icon(() -> new ItemStack(ModItems.RUBY_GEM)).entries((displayContext, entries) -> {
                       entries.add(ModItems.ANTHRACITE);
                       entries.add(ModItems.RAW_TIN);
                       entries.add(ModItems.RAW_SILVER);
                       entries.add(ModItems.RAW_COBALT);
                       entries.add(ModItems.TIN_NUGGET);

                       entries.add(ModItems.BRONZE_NUGGET);
                       entries.add(ModItems.SILVER_NUGGET);
                       entries.add(ModItems.COBALT_NUGGET);
                       entries.add(ModItems.STERLING_NUGGET);
                       entries.add(ModItems.STEEL_NUGGET);
                       entries.add(ModItems.TIN_INGOT);

                       entries.add(ModItems.BRONZE_INGOT);
                       entries.add(ModItems.SILVER_INGOT);
                       entries.add(ModItems.COBALT_INGOT);
                       entries.add(ModItems.STERLING_INGOT);

                       entries.add(ModItems.STEEL_INGOT);
                       entries.add(ModItems.OBSIDIAN_INGOT);
                       entries.add(ModItems.TOPAZ_GEM);
                       entries.add(ModItems.TOURMALINE_GEM);
                       entries.add(ModItems.TANZANITE_GEM);

                       entries.add(ModItems.RUBY_GEM);
                       entries.add(ModItems.SAPPHIRE_GEM);
                       entries.add(ModItems.MOISSANITE_GEM);

                       entries.add(ModItems.TURQUOISE_GEM);
                       entries.add(ModItems.ONYX_GEM);
                       entries.add(ModItems.GRAPHENE_GEM);
                    }).build());
    public static final ItemGroup BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mores.MOD_ID, "blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("creativemodetab.mores_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.TURQUOISE_BLOCK)).entries((displayContext, entries) -> {
//                        entries.add(ModBlocks.ALLOY_FURNACE);
                        entries.add(ModBlocks.RAW_TIN_BLOCK);
                        entries.add(ModBlocks.RAW_SILVER_BLOCK);
                        entries.add(ModBlocks.RAW_COBALT_BLOCK);
                        entries.add(ModBlocks.TIN_BLOCK);
                        entries.add(ModBlocks.BRONZE_BLOCK);
                        entries.add(ModBlocks.SILVER_BLOCK);
                        entries.add(ModBlocks.COBALT_BLOCK);
                        entries.add(ModBlocks.STERLING_BLOCK);
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModBlocks.TOPAZ_BLOCK);
                        entries.add(ModBlocks.TOURMALINE_BLOCK);
                        entries.add(ModBlocks.TANZANITE_BLOCK);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.SAPPHIRE_BLOCK);
                        entries.add(ModBlocks.MOISSANITE_BLOCK);
                        entries.add(ModBlocks.TURQUOISE_BLOCK);
                        entries.add(ModBlocks.ONYX_BLOCK);
                        entries.add(ModBlocks.GRAPHENE_BLOCK);
                    }).build());

    public static final ItemGroup ORE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mores.MOD_ID, "ores"),
            FabricItemGroup.builder().displayName(Text.translatable("creativemodetab.mores_ores"))
                    .icon(() -> new ItemStack(ModBlocks.DEEPSLATE_TURQUOISE_ORE)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ANTHRACITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ANTHRACITE_ORE);
                        entries.add(ModBlocks.NETHER_ANTHRACITE_ORE);
                        entries.add(ModBlocks.TIN_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TIN_ORE);
                        entries.add(ModBlocks.SILVER_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SILVER_ORE);
                        entries.add(ModBlocks.NETHER_SILVER_ORE);
                        entries.add(ModBlocks.COBALT_ORE);
                        entries.add(ModBlocks.DEEPSLATE_COBALT_ORE);
                        entries.add(ModBlocks.TOPAZ_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TOPAZ_ORE);
                        entries.add(ModBlocks.TOURMALINE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TOURMALINE_ORE);
                        entries.add(ModBlocks.NETHER_TANZANITE_ORE);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.SAPPHIRE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
                        entries.add(ModBlocks.NETHER_SAPPHIRE_ORE);
                        entries.add(ModBlocks.MOISSANITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_MOISSANITE_ORE);
                        entries.add(ModBlocks.TURQUOISE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TURQUOISE_ORE);
                        entries.add(ModBlocks.ONYX_ORE);
                    }).build());

    public static final ItemGroup TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mores.MOD_ID, "tools"),
            FabricItemGroup.builder().displayName(Text.translatable("creativemodetab.mores_tools"))
                    .icon(() -> new ItemStack(ModItems.COBALT_PICKAXE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TIN_PICKAXE);
                        entries.add(ModItems.TIN_AXE);
                        entries.add(ModItems.TIN_SHOVEL);
                        entries.add(ModItems.TIN_HOE);
                        entries.add(ModItems.COPPER_PICKAXE);
                        entries.add(ModItems.COPPER_AXE);
                        entries.add(ModItems.COPPER_SHOVEL);
                        entries.add(ModItems.COPPER_HOE);
                        entries.add(ModItems.BRONZE_PICKAXE);
                        entries.add(ModItems.BRONZE_AXE);
                        entries.add(ModItems.BRONZE_SHOVEL);
                        entries.add(ModItems.BRONZE_HOE);
                        entries.add(ModItems.SILVER_PICKAXE);
                        entries.add(ModItems.SILVER_AXE);
                        entries.add(ModItems.SILVER_SHOVEL);
                        entries.add(ModItems.SILVER_HOE);
                        entries.add(ModItems.COBALT_PICKAXE);
                        entries.add(ModItems.COBALT_AXE);
                        entries.add(ModItems.COBALT_SHOVEL);
                        entries.add(ModItems.COBALT_HOE);
                        entries.add(ModItems.STERLING_PICKAXE);
                        entries.add(ModItems.STERLING_AXE);
                        entries.add(ModItems.STERLING_SHOVEL);
                        entries.add(ModItems.STERLING_HOE);
                        entries.add(ModItems.STEEL_PICKAXE);
                        entries.add(ModItems.STEEL_AXE);
                        entries.add(ModItems.STEEL_SHOVEL);
                        entries.add(ModItems.STEEL_HOE);
                        entries.add(ModItems.AMETHYST_PICKAXE);
                        entries.add(ModItems.AMETHYST_AXE);
                        entries.add(ModItems.AMETHYST_SHOVEL);
                        entries.add(ModItems.AMETHYST_HOE);
                        entries.add(ModItems.EMERALD_PICKAXE);
                        entries.add(ModItems.EMERALD_AXE);
                        entries.add(ModItems.EMERALD_SHOVEL);
                        entries.add(ModItems.EMERALD_HOE);
                        entries.add(ModItems.TOPAZ_PICKAXE);
                        entries.add(ModItems.TOPAZ_AXE);
                        entries.add(ModItems.TOPAZ_SHOVEL);
                        entries.add(ModItems.TOPAZ_HOE);
                        entries.add(ModItems.TOURMALINE_PICKAXE);
                        entries.add(ModItems.TOURMALINE_AXE);
                        entries.add(ModItems.TOURMALINE_SHOVEL);
                        entries.add(ModItems.TOURMALINE_HOE);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_HOE);
                        entries.add(ModItems.SAPPHIRE_PICKAXE);
                        entries.add(ModItems.SAPPHIRE_AXE);
                        entries.add(ModItems.SAPPHIRE_SHOVEL);
                        entries.add(ModItems.SAPPHIRE_HOE);
                        entries.add(ModItems.TANZANITE_PICKAXE);
                        entries.add(ModItems.TANZANITE_AXE);
                        entries.add(ModItems.TANZANITE_SHOVEL);
                        entries.add(ModItems.TANZANITE_HOE);
                        entries.add(ModItems.MOISSANITE_PICKAXE);
                        entries.add(ModItems.MOISSANITE_AXE);
                        entries.add(ModItems.MOISSANITE_SHOVEL);
                        entries.add(ModItems.MOISSANITE_HOE);
                        entries.add(ModItems.TURQUOISE_PICKAXE);
                        entries.add(ModItems.TURQUOISE_AXE);
                        entries.add(ModItems.TURQUOISE_SHOVEL);
                        entries.add(ModItems.TURQUOISE_HOE);
                        entries.add(ModItems.OBSIDIAN_PICKAXE);
                        entries.add(ModItems.OBSIDIAN_AXE);
                        entries.add(ModItems.OBSIDIAN_SHOVEL);
                        entries.add(ModItems.OBSIDIAN_HOE);
                        entries.add(ModItems.ONYX_PICKAXE);
                        entries.add(ModItems.ONYX_AXE);
                        entries.add(ModItems.ONYX_SHOVEL);
                        entries.add(ModItems.ONYX_HOE);
                        entries.add(ModItems.GRAPHENE_PICKAXE);
                        entries.add(ModItems.GRAPHENE_AXE);
                        entries.add(ModItems.GRAPHENE_SHOVEL);
                        entries.add(ModItems.GRAPHENE_HOE);
                    }).build());

    public static final ItemGroup WEAPONS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mores.MOD_ID, "weapons"),
            FabricItemGroup.builder().displayName(Text.translatable("creativemodetab.mores_weapons"))
                    .icon(() -> new ItemStack(ModItems.NETHERITE_BATTLEAXE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.WOOD_BATTLEAXE);
                        entries.add(ModItems.WOOD_MACE);
                        entries.add(ModItems.WOOD_DAGGER);
                        entries.add(ModItems.STONE_BATTLEAXE);
                        entries.add(ModItems.STONE_MACE);
                        entries.add(ModItems.STONE_DAGGER);
                        entries.add(ModItems.TIN_SWORD);
                        entries.add(ModItems.TIN_BATTLEAXE);
                        entries.add(ModItems.TIN_MACE);
                        entries.add(ModItems.TIN_DAGGER);
                        entries.add(ModItems.COPPER_SWORD);
                        entries.add(ModItems.COPPER_BATTLEAXE);
                        entries.add(ModItems.COPPER_MACE);
                        entries.add(ModItems.COPPER_DAGGER);
                        entries.add(ModItems.BRONZE_SWORD);
                        entries.add(ModItems.BRONZE_BATTLEAXE);
                        entries.add(ModItems.BRONZE_MACE);
                        entries.add(ModItems.BRONZE_DAGGER);
                        entries.add(ModItems.SILVER_SWORD);
                        entries.add(ModItems.SILVER_BATTLEAXE);
                        entries.add(ModItems.SILVER_MACE);
                        entries.add(ModItems.SILVER_DAGGER);
                        entries.add(ModItems.GOLD_BATTLEAXE);
                        entries.add(ModItems.GOLD_MACE);
                        entries.add(ModItems.GOLD_DAGGER);
                        entries.add(ModItems.IRON_BATTLEAXE);
                        entries.add(ModItems.IRON_MACE);
                        entries.add(ModItems.IRON_DAGGER);
                        entries.add(ModItems.COBALT_SWORD);
                        entries.add(ModItems.COBALT_BATTLEAXE);
                        entries.add(ModItems.COBALT_MACE);
                        entries.add(ModItems.COBALT_DAGGER);
                        entries.add(ModItems.STERLING_SWORD);
                        entries.add(ModItems.STERLING_BATTLEAXE);
                        entries.add(ModItems.STERLING_MACE);
                        entries.add(ModItems.STERLING_DAGGER);
                        entries.add(ModItems.STEEL_SWORD);
                        entries.add(ModItems.STEEL_BATTLEAXE);
                        entries.add(ModItems.STEEL_MACE);
                        entries.add(ModItems.STEEL_DAGGER);
                        entries.add(ModItems.AMETHYST_SWORD);
                        entries.add(ModItems.AMETHYST_BATTLEAXE);
                        entries.add(ModItems.AMETHYST_MACE);
                        entries.add(ModItems.AMETHYST_DAGGER);
                        entries.add(ModItems.EMERALD_SWORD);
                        entries.add(ModItems.EMERALD_BATTLEAXE);
                        entries.add(ModItems.EMERALD_MACE);
                        entries.add(ModItems.EMERALD_DAGGER);
                        entries.add(ModItems.TOPAZ_SWORD);
                        entries.add(ModItems.TOPAZ_BATTLEAXE);
                        entries.add(ModItems.TOPAZ_MACE);
                        entries.add(ModItems.TOPAZ_DAGGER);
                        entries.add(ModItems.TOURMALINE_SWORD);
                        entries.add(ModItems.TOURMALINE_BATTLEAXE);
                        entries.add(ModItems.TOURMALINE_MACE);
                        entries.add(ModItems.TOURMALINE_DAGGER);
                        entries.add(ModItems.DIAMOND_BATTLEAXE);
                        entries.add(ModItems.DIAMOND_MACE);
                        entries.add(ModItems.DIAMOND_DAGGER);
                        entries.add(ModItems.RUBY_SWORD);
                        entries.add(ModItems.RUBY_BATTLEAXE);
                        entries.add(ModItems.RUBY_MACE);
                        entries.add(ModItems.RUBY_DAGGER);
                        entries.add(ModItems.SAPPHIRE_SWORD);
                        entries.add(ModItems.SAPPHIRE_BATTLEAXE);
                        entries.add(ModItems.SAPPHIRE_MACE);
                        entries.add(ModItems.SAPPHIRE_DAGGER);
                        entries.add(ModItems.TANZANITE_SWORD);
                        entries.add(ModItems.TANZANITE_BATTLEAXE);
                        entries.add(ModItems.TANZANITE_MACE);
                        entries.add(ModItems.TANZANITE_DAGGER);
                        entries.add(ModItems.MOISSANITE_SWORD);
                        entries.add(ModItems.MOISSANITE_BATTLEAXE);
                        entries.add(ModItems.MOISSANITE_MACE);
                        entries.add(ModItems.MOISSANITE_DAGGER);
                        entries.add(ModItems.TURQUOISE_SWORD);
                        entries.add(ModItems.TURQUOISE_BATTLEAXE);
                        entries.add(ModItems.TURQUOISE_MACE);
                        entries.add(ModItems.TURQUOISE_DAGGER);
                        entries.add(ModItems.OBSIDIAN_SWORD);
                        entries.add(ModItems.OBSIDIAN_BATTLEAXE);
                        entries.add(ModItems.OBSIDIAN_MACE);
                        entries.add(ModItems.OBSIDIAN_DAGGER);
                        entries.add(ModItems.NETHERITE_BATTLEAXE);
                        entries.add(ModItems.NETHERITE_MACE);
                        entries.add(ModItems.NETHERITE_DAGGER);
                        entries.add(ModItems.ONYX_SWORD);
                        entries.add(ModItems.ONYX_BATTLEAXE);
                        entries.add(ModItems.ONYX_MACE);
                        entries.add(ModItems.ONYX_DAGGER);
                        entries.add(ModItems.GRAPHENE_SWORD);
                        entries.add(ModItems.GRAPHENE_BATTLEAXE);
                        entries.add(ModItems.GRAPHENE_MACE);
                        entries.add(ModItems.GRAPHENE_DAGGER);
                    }).build());

    public static final ItemGroup ARMOR_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mores.MOD_ID, "armor"),
            FabricItemGroup.builder().displayName(Text.translatable("creativemodetab.mores_armor"))
                    .icon(() -> new ItemStack(ModItems.GRAPHENE_CHESTPLATE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TIN_HELMET);
                        entries.add(ModItems.TIN_CHESTPLATE);
                        entries.add(ModItems.TIN_LEGGINGS);
                        entries.add(ModItems.TIN_BOOTS);
                        entries.add(ModItems.COPPER_HELMET);
                        entries.add(ModItems.COPPER_CHESTPLATE);
                        entries.add(ModItems.COPPER_LEGGINGS);
                        entries.add(ModItems.COPPER_BOOTS);
                        entries.add(ModItems.BRONZE_HELMET);
                        entries.add(ModItems.BRONZE_CHESTPLATE);
                        entries.add(ModItems.BRONZE_LEGGINGS);
                        entries.add(ModItems.BRONZE_BOOTS);
                        entries.add(ModItems.SILVER_HELMET);
                        entries.add(ModItems.SILVER_CHESTPLATE);
                        entries.add(ModItems.SILVER_LEGGINGS);
                        entries.add(ModItems.SILVER_BOOTS);
                        entries.add(ModItems.COBALT_HELMET);
                        entries.add(ModItems.COBALT_CHESTPLATE);
                        entries.add(ModItems.COBALT_LEGGINGS);
                        entries.add(ModItems.COBALT_BOOTS);
                        entries.add(ModItems.STERLING_HELMET);
                        entries.add(ModItems.STERLING_CHESTPLATE);
                        entries.add(ModItems.STERLING_LEGGINGS);
                        entries.add(ModItems.STERLING_BOOTS);
                        entries.add(ModItems.STEEL_HELMET);
                        entries.add(ModItems.STEEL_CHESTPLATE);
                        entries.add(ModItems.STEEL_LEGGINGS);
                        entries.add(ModItems.STEEL_BOOTS);
                        entries.add(ModItems.AMETHYST_HELMET);
                        entries.add(ModItems.AMETHYST_CHESTPLATE);
                        entries.add(ModItems.AMETHYST_LEGGINGS);
                        entries.add(ModItems.AMETHYST_BOOTS);
                        entries.add(ModItems.EMERALD_HELMET);
                        entries.add(ModItems.EMERALD_CHESTPLATE);
                        entries.add(ModItems.EMERALD_LEGGINGS);
                        entries.add(ModItems.EMERALD_BOOTS);
                        entries.add(ModItems.TOPAZ_HELMET);
                        entries.add(ModItems.TOPAZ_CHESTPLATE);
                        entries.add(ModItems.TOPAZ_LEGGINGS);
                        entries.add(ModItems.TOPAZ_BOOTS);
                        entries.add(ModItems.TOURMALINE_HELMET);
                        entries.add(ModItems.TOURMALINE_CHESTPLATE);
                        entries.add(ModItems.TOURMALINE_LEGGINGS);
                        entries.add(ModItems.TOURMALINE_BOOTS);
                        entries.add(ModItems.RUBY_HELMET);
                        entries.add(ModItems.RUBY_CHESTPLATE);
                        entries.add(ModItems.RUBY_LEGGINGS);
                        entries.add(ModItems.RUBY_BOOTS);
                        entries.add(ModItems.SAPPHIRE_HELMET);
                        entries.add(ModItems.SAPPHIRE_CHESTPLATE);
                        entries.add(ModItems.SAPPHIRE_LEGGINGS);
                        entries.add(ModItems.SAPPHIRE_BOOTS);
                        entries.add(ModItems.TANZANITE_HELMET);
                        entries.add(ModItems.TANZANITE_CHESTPLATE);
                        entries.add(ModItems.TANZANITE_LEGGINGS);
                        entries.add(ModItems.TANZANITE_BOOTS);
                        entries.add(ModItems.MOISSANITE_HELMET);
                        entries.add(ModItems.MOISSANITE_CHESTPLATE);
                        entries.add(ModItems.MOISSANITE_LEGGINGS);
                        entries.add(ModItems.MOISSANITE_BOOTS);
                        entries.add(ModItems.TURQUOISE_HELMET);
                        entries.add(ModItems.TURQUOISE_CHESTPLATE);
                        entries.add(ModItems.TURQUOISE_LEGGINGS);
                        entries.add(ModItems.TURQUOISE_BOOTS);
                        entries.add(ModItems.OBSIDIAN_HELMET);
                        entries.add(ModItems.OBSIDIAN_CHESTPLATE);
                        entries.add(ModItems.OBSIDIAN_LEGGINGS);
                        entries.add(ModItems.OBSIDIAN_BOOTS);
                        entries.add(ModItems.ONYX_HELMET);
                        entries.add(ModItems.ONYX_CHESTPLATE);
                        entries.add(ModItems.ONYX_LEGGINGS);
                        entries.add(ModItems.ONYX_BOOTS);
                        entries.add(ModItems.GRAPHENE_HELMET);
                        entries.add(ModItems.GRAPHENE_CHESTPLATE);
                        entries.add(ModItems.GRAPHENE_LEGGINGS);
                        entries.add(ModItems.GRAPHENE_BOOTS);
                    }).build());

    public static final ItemGroup SHIELDS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mores.MOD_ID, "shields"),
            FabricItemGroup.builder().displayName(Text.translatable("creativemodetab.mores_shields"))
                    .icon(() -> new ItemStack(ModItems.BRONZE_SHIELD)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TIN_SHIELD);
                        entries.add(ModItems.COPPER_SHIELD);
                        entries.add(ModItems.BRONZE_SHIELD);
                        entries.add(ModItems.SILVER_SHIELD);
                        entries.add(ModItems.COBALT_SHIELD);
                        entries.add(ModItems.STERLING_SHIELD);
                        entries.add(ModItems.STEEL_SHIELD);
                        entries.add(ModItems.AMETHYST_SHIELD);
                        entries.add(ModItems.EMERALD_SHIELD);
                        entries.add(ModItems.TOPAZ_SHIELD);
                        entries.add(ModItems.TOURMALINE_SHIELD);
                        entries.add(ModItems.RUBY_SHIELD);
                        entries.add(ModItems.SAPPHIRE_SHIELD);
                        entries.add(ModItems.TANZANITE_SHIELD);
                        entries.add(ModItems.MOISSANITE_SHIELD);
                        entries.add(ModItems.TURQUOISE_SHIELD);
                        entries.add(ModItems.OBSIDIAN_SHIELD);
                        entries.add(ModItems.ONYX_SHIELD);
                        entries.add(ModItems.GRAPHENE_SHIELD);
                    }).build());

        public static final ItemGroup HORSE_ARMOR_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mores.MOD_ID, "horse_armor"),
            FabricItemGroup.builder().displayName(Text.translatable("creativemodetab.mores_horse_armor"))
                    .icon(() -> new ItemStack(ModItems.TOURMALINE_HORSE_ARMOR)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TIN_HORSE_ARMOR);
                        entries.add(ModItems.COPPER_HORSE_ARMOR);
                        entries.add(ModItems.BRONZE_HORSE_ARMOR);
                        entries.add(ModItems.SILVER_HORSE_ARMOR);
                        entries.add(ModItems.COBALT_HORSE_ARMOR);
                        entries.add(ModItems.STERLING_HORSE_ARMOR);
                        entries.add(ModItems.STEEL_HORSE_ARMOR);
                        entries.add(ModItems.AMETHYST_HORSE_ARMOR);
                        entries.add(ModItems.EMERALD_HORSE_ARMOR);
                        entries.add(ModItems.TOPAZ_HORSE_ARMOR);
                        entries.add(ModItems.TOURMALINE_HORSE_ARMOR);
                        entries.add(ModItems.RUBY_HORSE_ARMOR);
                        entries.add(ModItems.SAPPHIRE_HORSE_ARMOR);
                        entries.add(ModItems.TANZANITE_HORSE_ARMOR);
                        entries.add(ModItems.MOISSANITE_HORSE_ARMOR);
                        entries.add(ModItems.TURQUOISE_HORSE_ARMOR);
                        entries.add(ModItems.OBSIDIAN_HORSE_ARMOR);
                        entries.add(ModItems.ONYX_HORSE_ARMOR);
                        entries.add(ModItems.GRAPHENE_HORSE_ARMOR);
                        entries.add(ModItems.NETHERITE_HORSE_ARMOR);
                    }).build());

    public static final ItemGroup FOOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mores.MOD_ID, "food"),
            FabricItemGroup.builder().displayName(Text.translatable("creativemodetab.mores_foods"))
                    .icon(() -> new ItemStack(ModItems.COBALT_APPLE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BRONZE_APPLE);
                        entries.add(ModItems.SILVER_APPLE);
                        entries.add(ModItems.COBALT_APPLE);
                        entries.add(ModItems.CHOCOLATE);
                        entries.add(ModItems.VELVET);
                        entries.add(ModItems.CARROT_PIE);
//                        entries.add(ModItems.DUCK);
//                        entries.add(ModItems.COOKED_DUCK);
                    }).build());

//    public static final ItemGroup ENTITIES_GROUP = Registry.register(Registries.ITEM_GROUP,
//            new Identifier(Mores.MOD_ID, "Entities"),
//            FabricItemGroup.builder().displayName(Text.translatable("creativemodetab.mores_entities"))
//                    .icon(() -> new ItemStack(ModItems.DUCK_SPAWN_EGG)).entries((displayContext, entries) -> {
//                        entries.add(ModItems.DUCK_SPAWN_EGG);
//                    }).build());

    public static void registerItemGroups() {

    }
}