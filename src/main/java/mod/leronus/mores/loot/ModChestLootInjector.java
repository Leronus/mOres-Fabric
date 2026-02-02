package mod.leronus.mores.loot;

import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.Locale;

/**
 * Vanilla+ chest loot injector (ADD-ONLY, high compatibility).
 *
 * Key rules enforced:
 * - ENDERITE scrap/ingot only in THE END (End City / End loot tables).
 * - HOT_CARBON_STEEL_SCRAP never appears in loot.
 * - Dungeons: only CARBON_STEEL_SCRAP + OBSIDIAN_SCRAP, and HARDENED_STEEL_SCRAP very rarely.
 * - Obsidian appears in Nether as well (scrap + ingot).
 * - Hardened steel scrap: very rare but possible in dungeons.
 * - Adamantium ingot: rare overworld treasure (rarer than diamond feel).
 * - Pies are village-weighted; no pies in dungeons.
 * - Lemons can appear in dungeons (low chance) since apples/carrots can.
 * - Only inject our two discs (Cipher & Sweet Caroline); vanilla discs remain possible.
 */
public final class ModChestLootInjector {

    private ModChestLootInjector() {}

    // -------------------------------------------------------------------------
    // MUSIC DISCS (ONLY these two injected)
    // -------------------------------------------------------------------------

    private static final Item[] ALLOWED_DISCS = new Item[]{
            ModItems.CIPHER_MUSIC_DISC,
            ModItems.SWEET_CAROLINE_MUSIC_DISC
    };

    // -------------------------------------------------------------------------
    // FOODS (ONLY your mod foods)
    // -------------------------------------------------------------------------

    private static final Item[] PIES = new Item[]{
            ModItems.APPLE_PIE,
            ModItems.CARROT_PIE,
            ModItems.LEMON_PIE,
            ModItems.SWEET_BERRY_PIE
    };

    private static final Item[] CHOCOLATES = new Item[]{
            ModItems.DARK_CHOCOLATE,
            ModItems.MILK_CHOCOLATE,
            ModItems.WHITE_CHOCOLATE
    };

    private static final Item[] LEMONS_OAKY = new Item[]{
            ModItems.LEMON,
            ModItems.LEMON_PIE
    };

    private static final Item[] DUNGEON_LEMONS = new Item[]{
            ModItems.LEMON
    };

    private static final Item[] DUCK_FOODS = new Item[]{
            ModItems.RAW_DUCK,
            ModItems.COOKED_DUCK
    };

    // Special foods (spawn where it makes sense, including dungeons)
    private static final Item SPECIAL_SILVER_CARROT = ModItems.SILVER_CARROT;

    private static final Item[] SPECIAL_APPLES = new Item[]{
            ModItems.SILVER_APPLE,
            ModItems.BRONZE_APPLE,
            ModItems.COBALT_APPLE,
            ModItems.ROSE_GOLD_APPLE
    };

    private static final Item[] SPECIAL_APPLES_ENCHANTED = new Item[]{
            ModItems.ENCHANTED_COBALT_APPLE,
            ModItems.ENCHANTED_ROSE_GOLD_APPLE
    };

    // -------------------------------------------------------------------------
    // SMITHING TEMPLATES
    // (kept sensible: enderite template in end loot, nether/deep for hardened/obsidian)
    // -------------------------------------------------------------------------

    private static final Item TEMPLATE_HARDENED = ModItems.HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE;
    private static final Item TEMPLATE_OBSIDIAN = ModItems.OBSIDIAN_UPGRADE_SMITHING_TEMPLATE;
    private static final Item TEMPLATE_ENDERITE = ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE;
    private static final Item TEMPLATE_ADAMANTIUM = ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE;

    // -------------------------------------------------------------------------
    // MATERIALS
    // -------------------------------------------------------------------------

    private static final Item[] EARLY_INGOTS = new Item[]{
            ModItems.TIN_INGOT,
            ModItems.BRONZE_INGOT
    };

    private static final Item[] EARLY_MID_INGOTS = new Item[]{
            ModItems.SILVER_INGOT,
            ModItems.STERLING_SILVER_INGOT,
            ModItems.CARBON_STEEL_INGOT,
            ModItems.COBALT_INGOT,
            ModItems.ROSE_GOLD_INGOT
    };

    private static final Item[] LATE_INGOTS = new Item[]{
            ModItems.HARDENED_STEEL_INGOT,
            ModItems.OBSIDIAN_INGOT,
            ModItems.ADAMANTIUM_INGOT
    };

    private static final Item[] ENDERITE_INGOTS = new Item[]{
            ModItems.ENDERITE_INGOT
    };

    private static final Item[] RAW_MATERIALS = new Item[]{
            ModItems.RAW_TIN,
            ModItems.RAW_SILVER,
            ModItems.RAW_COBALT
    };

    // Nuggets (keep variety; includes tin nugget and others)
    private static final Item[] NUGGETS = new Item[]{
            ModItems.TIN_NUGGET,
            ModItems.COPPER_NUGGET,
            ModItems.SILVER_NUGGET,
            ModItems.STERLING_SILVER_NUGGET,
            ModItems.ROSE_GOLD_NUGGET,
            ModItems.BRONZE_NUGGET,
            ModItems.COBALT_NUGGET,
            ModItems.CARBON_STEEL_NUGGET,
            ModItems.HARDENED_STEEL_NUGGET
    };

    // DUNGEON SCRAPS (STRICT)
    // - NO hot carbon steel scrap
    // - NO enderite scrap outside end
    private static final Item[] DUNGEON_SCRAPS = new Item[]{
            ModItems.CARBON_STEEL_SCRAP,
            ModItems.OBSIDIAN_SCRAP,
    };

    // NETHER SCRAPS (obsidian belongs here too)
    private static final Item[] NETHER_SCRAPS = new Item[]{
            ModItems.CARBON_STEEL_SCRAP,
            ModItems.OBSIDIAN_SCRAP,
    };

    // END SCRAPS (enderite ONLY here)
    private static final Item[] END_SCRAPS = new Item[]{
            ModItems.OBSIDIAN_SCRAP,
            ModItems.ENDERITE_SCRAP
    };

    private static final Item[] DUSTS = new Item[]{
            ModItems.QUARTZ_DUST,
            ModItems.LAPIS_LAZULI_DUST,
            ModItems.AMETHYST_DUST,
            ModItems.TURQUOISE_DUST
    };

    // Gems (used mainly for treasure flavor; you already have these)
    private static final Item[] GEMS_EARLY_MID = new Item[]{
            ModItems.LAPIS_LAZULI_GEM,
            ModItems.TURQUOISE_GEM,
            ModItems.AMETHYST_GEM,
            ModItems.TANZANITE_GEM,
            ModItems.TOPAZ_GEM,
            ModItems.TOURMALINE_GEM,
            ModItems.CITRINE_GEM,
            ModItems.ONYX_GEM
    };

    private static final Item[] GEMS_LATE = new Item[]{
            ModItems.RUBY_GEM,
            ModItems.SAPPHIRE_GEM,
            ModItems.MOISSANITE_GEM
    };

    // Also requested you liked finding anthracite
    private static final Item ANTHRACITE = ModItems.ANTHRACITE;

    // -------------------------------------------------------------------------
    // TIERS: TOOLS/ARMOR/SHIELDS
    // (kept from your current file; only weights/rolls adjusted in logic below)
    // -------------------------------------------------------------------------

    private static final Item[] EARLY_TOOLS = new Item[]{
            ModItems.TIN_SWORD, ModItems.TIN_PICKAXE, ModItems.TIN_AXE, ModItems.TIN_SHOVEL, ModItems.TIN_HOE,
            ModItems.COPPER_SWORD, ModItems.COPPER_PICKAXE, ModItems.COPPER_AXE, ModItems.COPPER_SHOVEL, ModItems.COPPER_HOE,
            ModItems.BRONZE_SWORD, ModItems.BRONZE_PICKAXE, ModItems.BRONZE_AXE, ModItems.BRONZE_SHOVEL, ModItems.BRONZE_HOE
    };

    private static final Item[] EARLY_ARMOR = new Item[]{
            ModItems.TIN_HELMET, ModItems.TIN_CHESTPLATE, ModItems.TIN_LEGGINGS, ModItems.TIN_BOOTS,
            ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS,
            ModItems.BRONZE_HELMET, ModItems.BRONZE_CHESTPLATE, ModItems.BRONZE_LEGGINGS, ModItems.BRONZE_BOOTS
    };

    private static final Item[] EARLY_SHIELDS = new Item[]{
            ModItems.TIN_SHIELD, ModItems.COPPER_SHIELD, ModItems.BRONZE_SHIELD
    };

    // EARLY_MID includes your special weapons (battle_mace/dagger)
    private static final Item[] EARLY_MID_TOOLS = new Item[]{
            // some early basics
            ModItems.TIN_SWORD, ModItems.TIN_PICKAXE, ModItems.COPPER_PICKAXE, ModItems.BRONZE_SWORD,

            // silver + specials
            ModItems.SILVER_SWORD, ModItems.SILVER_PICKAXE, ModItems.SILVER_AXE, ModItems.SILVER_SHOVEL, ModItems.SILVER_HOE,
            ModItems.SILVER_BATTLE_AXE, ModItems.SILVER_BATTLE_MACE, ModItems.SILVER_DAGGER,

            // sterling + specials
            ModItems.STERLING_SILVER_SWORD, ModItems.STERLING_SILVER_PICKAXE, ModItems.STERLING_SILVER_AXE, ModItems.STERLING_SILVER_SHOVEL, ModItems.STERLING_SILVER_HOE,
            ModItems.STERLING_SILVER_BATTLE_AXE, ModItems.STERLING_SILVER_BATTLE_MACE, ModItems.STERLING_SILVER_DAGGER,

            // cobalt + specials
            ModItems.COBALT_SWORD, ModItems.COBALT_PICKAXE, ModItems.COBALT_AXE, ModItems.COBALT_SHOVEL, ModItems.COBALT_HOE,
            ModItems.COBALT_BATTLE_AXE, ModItems.COBALT_BATTLE_MACE, ModItems.COBALT_DAGGER,

            // rose gold specials (as you had)
            ModItems.ROSE_GOLD_SWORD, ModItems.ROSE_GOLD_PICKAXE, ModItems.ROSE_GOLD_AXE, ModItems.ROSE_GOLD_SHOVEL, ModItems.ROSE_GOLD_HOE,
            ModItems.ROSE_GOLD_BATTLE_AXE, ModItems.ROSE_GOLD_BATTLE_MACE, ModItems.ROSE_GOLD_DAGGER,

            // carbon steel + specials
            ModItems.CARBON_STEEL_SWORD, ModItems.CARBON_STEEL_PICKAXE, ModItems.CARBON_STEEL_AXE, ModItems.CARBON_STEEL_SHOVEL, ModItems.CARBON_STEEL_HOE,
            ModItems.CARBON_STEEL_BATTLE_AXE, ModItems.CARBON_STEEL_BATTLE_MACE, ModItems.CARBON_STEEL_DAGGER
    };

    private static final Item[] EARLY_MID_ARMOR = new Item[]{
            ModItems.TIN_HELMET, ModItems.TIN_CHESTPLATE, ModItems.TIN_LEGGINGS, ModItems.TIN_BOOTS,
            ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS,
            ModItems.BRONZE_HELMET, ModItems.BRONZE_CHESTPLATE, ModItems.BRONZE_LEGGINGS, ModItems.BRONZE_BOOTS,

            ModItems.SILVER_HELMET, ModItems.SILVER_CHESTPLATE, ModItems.SILVER_LEGGINGS, ModItems.SILVER_BOOTS,
            ModItems.STERLING_SILVER_HELMET, ModItems.STERLING_SILVER_CHESTPLATE, ModItems.STERLING_SILVER_LEGGINGS, ModItems.STERLING_SILVER_BOOTS,
            ModItems.COBALT_HELMET, ModItems.COBALT_CHESTPLATE, ModItems.COBALT_LEGGINGS, ModItems.COBALT_BOOTS,
            ModItems.ROSE_GOLD_HELMET, ModItems.ROSE_GOLD_CHESTPLATE, ModItems.ROSE_GOLD_LEGGINGS, ModItems.ROSE_GOLD_BOOTS,
            ModItems.CARBON_STEEL_HELMET, ModItems.CARBON_STEEL_CHESTPLATE, ModItems.CARBON_STEEL_LEGGINGS, ModItems.CARBON_STEEL_BOOTS
    };

    private static final Item[] EARLY_MID_SHIELDS = new Item[]{
            ModItems.TIN_SHIELD, ModItems.COPPER_SHIELD, ModItems.BRONZE_SHIELD,
            ModItems.SILVER_SHIELD, ModItems.STERLING_SILVER_SHIELD, ModItems.COBALT_SHIELD, ModItems.ROSE_GOLD_SHIELD, ModItems.CARBON_STEEL_SHIELD
    };

    // LATE: ruby/sapphire/moissanite + adamantium/obsidian/hardened steel
    private static final Item[] LATE_TOOLS = new Item[]{
            ModItems.RUBY_SWORD, ModItems.RUBY_PICKAXE, ModItems.RUBY_AXE, ModItems.RUBY_SHOVEL, ModItems.RUBY_HOE,
            ModItems.SAPPHIRE_SWORD, ModItems.SAPPHIRE_PICKAXE, ModItems.SAPPHIRE_AXE, ModItems.SAPPHIRE_SHOVEL, ModItems.SAPPHIRE_HOE,
            ModItems.MOISSANITE_SWORD, ModItems.MOISSANITE_PICKAXE, ModItems.MOISSANITE_AXE, ModItems.MOISSANITE_SHOVEL, ModItems.MOISSANITE_HOE,

            ModItems.HARDENED_STEEL_SWORD, ModItems.HARDENED_STEEL_PICKAXE, ModItems.HARDENED_STEEL_AXE, ModItems.HARDENED_STEEL_SHOVEL, ModItems.HARDENED_STEEL_HOE,
            ModItems.OBSIDIAN_SWORD, ModItems.OBSIDIAN_PICKAXE, ModItems.OBSIDIAN_AXE, ModItems.OBSIDIAN_SHOVEL, ModItems.OBSIDIAN_HOE,
            ModItems.ADAMANTIUM_SWORD, ModItems.ADAMANTIUM_PICKAXE, ModItems.ADAMANTIUM_AXE, ModItems.ADAMANTIUM_SHOVEL, ModItems.ADAMANTIUM_HOE
    };

    private static final Item[] LATE_ARMOR = new Item[]{
            ModItems.RUBY_HELMET, ModItems.RUBY_CHESTPLATE, ModItems.RUBY_LEGGINGS, ModItems.RUBY_BOOTS,
            ModItems.SAPPHIRE_HELMET, ModItems.SAPPHIRE_CHESTPLATE, ModItems.SAPPHIRE_LEGGINGS, ModItems.SAPPHIRE_BOOTS,
            ModItems.MOISSANITE_HELMET, ModItems.MOISSANITE_CHESTPLATE, ModItems.MOISSANITE_LEGGINGS, ModItems.MOISSANITE_BOOTS,

            ModItems.HARDENED_STEEL_HELMET, ModItems.HARDENED_STEEL_CHESTPLATE, ModItems.HARDENED_STEEL_LEGGINGS, ModItems.HARDENED_STEEL_BOOTS,
            ModItems.OBSIDIAN_HELMET, ModItems.OBSIDIAN_CHESTPLATE, ModItems.OBSIDIAN_LEGGINGS, ModItems.OBSIDIAN_BOOTS,
            ModItems.ADAMANTIUM_HELMET, ModItems.ADAMANTIUM_CHESTPLATE, ModItems.ADAMANTIUM_LEGGINGS, ModItems.ADAMANTIUM_BOOTS
    };

    private static final Item[] LATE_SHIELDS = new Item[]{
            ModItems.RUBY_SHIELD,
            ModItems.SAPPHIRE_SHIELD,
            ModItems.MOISSANITE_SHIELD,
            ModItems.HARDENED_STEEL_SHIELD,
            ModItems.OBSIDIAN_SHIELD,
            ModItems.ADAMANTIUM_SHIELD
    };

    // ENDERITE: end-only, ultra rare
    private static final Item[] ENDERITE_TOOLS = new Item[]{
            ModItems.ENDERITE_SWORD, ModItems.ENDERITE_PICKAXE, ModItems.ENDERITE_AXE, ModItems.ENDERITE_SHOVEL, ModItems.ENDERITE_HOE
    };

    private static final Item[] ENDERITE_ARMOR = new Item[]{
            ModItems.ENDERITE_HELMET, ModItems.ENDERITE_CHESTPLATE, ModItems.ENDERITE_LEGGINGS, ModItems.ENDERITE_BOOTS
    };

    private static final Item[] ENDERITE_SHIELDS = new Item[]{
            ModItems.ENDERITE_SHIELD
    };

    // -------------------------------------------------------------------------
    // REGISTER
    // -------------------------------------------------------------------------

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (!source.isBuiltin()) return;

            Identifier id = key.getValue();
            String path = id.getPath().toLowerCase(Locale.ROOT);

            if (!looksLikeChestLoot(path)) return;

            ChestCategory cat = categorize(path);

            switch (cat) {
                // -----------------------------------------
                // VILLAGES (all variants; includes "village")
                // Early variety: tools not too spammy, pies strong.
                // -----------------------------------------
                case VILLAGE -> {
                    // Early gear common but not bulky
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.52f, 0.30f, 0.10f,
                            1, 1);

                    // Some early-mid spice (silver/sterling/cobalt/carbon steel etc)
                    addGear(tableBuilder, EARLY_MID_TOOLS, EARLY_MID_ARMOR, EARLY_MID_SHIELDS,
                            0.16f, 0.08f, 0.03f,
                            1, 1);

                    // Pies belong here
                    addPies(tableBuilder, 0.72f, 1, 2);

                    // Lemons in oaky villages
                    if (isOaky(path)) {
                        addSimpleItems(tableBuilder, LEMONS_OAKY, 0.26f, 1, 2, WeightProfile.FLAT);
                    }

                    // Chocolate only jungle-ish village
                    if (isJungle(path)) {
                        addSimpleItems(tableBuilder, CHOCOLATES, 0.18f, 1, 2, WeightProfile.FLAT);
                    }

                    // Special foods (apples/carrots) modest in villages
                    addSpecialFoods(tableBuilder,
                            0.10f,  // silver carrot
                            0.08f,  // apples
                            0.004f  // enchanted apples ultra rare
                    );

                    // Metals + nuggets with variety
                    addOverworldMetals(tableBuilder, path, 0.78f);
                    addOverworldGems(tableBuilder, path, 0.18f);
                }

                // -----------------------------------------
                // DUNGEONS / MINESHAFTS
                // Dusts yes, pies no, lemons low, special foods yes.
                // STRICT scrap rules enforced here.
                // -----------------------------------------
                case DUNGEON_MINESHAFT -> {
                    // Reduce tool spam
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.36f, 0.18f, 0.08f,
                            1, 1);

                    addGear(tableBuilder, EARLY_MID_TOOLS, EARLY_MID_ARMOR, EARLY_MID_SHIELDS,
                            0.08f, 0.04f, 0.02f,
                            1, 1);

                    // No pies in dungeons
                    // Lemons make more sense (low chance)
                    addSimpleItems(tableBuilder, DUNGEON_LEMONS, 0.10f, 1, 1, WeightProfile.FLAT);

                    // Duck small chance
                    addSimpleItems(tableBuilder, DUCK_FOODS, 0.16f, 1, 1, WeightProfile.FLAT);

                    // Special foods: yes (to "alternate" feel with vanilla golden apple)
                    // (We cannot remove golden apple from vanilla tables; we add our set in same places.)
                    addSpecialFoods(tableBuilder,
                            0.14f,   // silver carrot (more common than apples)
                            0.10f,   // apples (rare-ish)
                            0.0035f  // enchanted apples (VERY rare)
                    );

                    // Materials you liked:
                    // - quartz dust, lapis dust
                    // - anthracite
                    // - tin ingot (also bronze/sterling possible)
                    addUndergroundMetals(tableBuilder, path, 0.80f);
                    addUndergroundDusts(tableBuilder, 0.74f);
                    addAnthracite(tableBuilder, 0.28f);

                    // STRICT dungeon scraps:
                    // carbon steel scrap + obsidian scrap, hardened steel scrap very rare
                    addDungeonScrapsStrict(tableBuilder, 0.56f);

                    // Discs (only ours injected), vanilla discs still possible
                    addDiscs(tableBuilder, 0.06f);
                }

                // -----------------------------------------
                // TEMPLES / PYRAMIDS
                // -----------------------------------------
                case TEMPLE_PYRAMID -> {
                    addGear(tableBuilder, EARLY_MID_TOOLS, EARLY_MID_ARMOR, EARLY_MID_SHIELDS,
                            0.46f, 0.22f, 0.10f,
                            1, 1);

                    // LATE items can appear here rarely (treasure)
                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.08f, 0.04f, 0.02f,
                            1, 1);

                    // Pies low, lemons only if oaky, chocolate only jungle temple-ish
                    addPies(tableBuilder, 0.16f, 1, 1);

                    if (isJungle(path)) {
                        addSimpleItems(tableBuilder, CHOCOLATES, 0.24f, 1, 2, WeightProfile.FLAT);
                    }
                    if (isOaky(path)) {
                        addSimpleItems(tableBuilder, LEMONS_OAKY, 0.12f, 1, 1, WeightProfile.FLAT);
                    }

                    addSpecialFoods(tableBuilder, 0.10f, 0.08f, 0.003f);

                    addOverworldMetals(tableBuilder, path, 0.80f);
                    addOverworldGems(tableBuilder, path, 0.50f);
                    addContextDusts(tableBuilder, path, 0.20f);

                    addDiscs(tableBuilder, 0.04f);

                    // Templates: overworld rich gets hardened/obsidian sometimes
                    addTemplatesOverworldRich(tableBuilder, 0.06f);
                }

                // -----------------------------------------
                // OUTPOST / TOWER / CAMP
                // -----------------------------------------
                case OUTPOST_TOWER -> {
                    addGear(tableBuilder, EARLY_MID_TOOLS, EARLY_MID_ARMOR, EARLY_MID_SHIELDS,
                            0.48f, 0.24f, 0.12f,
                            1, 1);

                    addSpecialFoods(tableBuilder, 0.10f, 0.08f, 0.003f);

                    addPies(tableBuilder, 0.12f, 1, 1);
                    addSimpleItems(tableBuilder, DUCK_FOODS, 0.18f, 1, 1, WeightProfile.FLAT);

                    addOverworldMetals(tableBuilder, path, 0.82f);
                    addOverworldGems(tableBuilder, path, 0.30f);
                    addContextDusts(tableBuilder, path, 0.16f);

                    addDiscs(tableBuilder, 0.03f);
                    addTemplatesOverworldRich(tableBuilder, 0.05f);
                }

                // -----------------------------------------
                // SHIPWRECK / OCEAN
                // -----------------------------------------
                case SHIPWRECK_OCEAN -> {
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.30f, 0.14f, 0.08f,
                            1, 1);

                    // Foods low
                    addPies(tableBuilder, 0.08f, 1, 1);
                    addSimpleItems(tableBuilder, DUCK_FOODS, 0.08f, 1, 1, WeightProfile.FLAT);

                    addSpecialFoods(tableBuilder, 0.06f, 0.05f, 0.002f);

                    addOverworldMetals(tableBuilder, path, 0.60f);
                    addOverworldGems(tableBuilder, path, 0.18f);
                }

                // -----------------------------------------
                // STRONGHOLD
                // -----------------------------------------
                case STRONGHOLD -> {
                    addGear(tableBuilder, EARLY_MID_TOOLS, EARLY_MID_ARMOR, EARLY_MID_SHIELDS,
                            0.54f, 0.28f, 0.14f,
                            1, 1);

                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.14f, 0.07f, 0.03f,
                            1, 1);

                    addSpecialFoods(tableBuilder, 0.12f, 0.10f, 0.0035f);

                    addPies(tableBuilder, 0.10f, 1, 1);
                    addSimpleItems(tableBuilder, DUNGEON_LEMONS, 0.08f, 1, 1, WeightProfile.FLAT);

                    addUndergroundMetals(tableBuilder, path, 0.86f);
                    addUndergroundDusts(tableBuilder, 0.52f);
                    addAnthracite(tableBuilder, 0.22f);

                    // stronghold uses dungeon-leaning scraps, but still strict (no enderite, no hot scrap)
                    addDungeonScrapsStrict(tableBuilder, 0.42f);

                    addDiscs(tableBuilder, 0.06f);

                    // Templates: hardened + obsidian moderate
                    addTemplatesDeep(tableBuilder, 0.12f);
                }

                // -----------------------------------------
                // MANSION
                // -----------------------------------------
                case MANSION -> {
                    addGear(tableBuilder, EARLY_MID_TOOLS, EARLY_MID_ARMOR, EARLY_MID_SHIELDS,
                            0.56f, 0.30f, 0.14f,
                            1, 1);

                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.12f, 0.06f, 0.03f,
                            1, 1);

                    addPies(tableBuilder, 0.28f, 1, 2);
                    if (isOaky(path)) addSimpleItems(tableBuilder, LEMONS_OAKY, 0.16f, 1, 2, WeightProfile.FLAT);

                    addSpecialFoods(tableBuilder, 0.12f, 0.10f, 0.004f);

                    addOverworldMetals(tableBuilder, path, 0.86f);
                    addOverworldGems(tableBuilder, path, 0.62f);
                    addContextDusts(tableBuilder, path, 0.18f);

                    addDiscs(tableBuilder, 0.06f);
                    addTemplatesOverworldRich(tableBuilder, 0.10f);
                }

                // -----------------------------------------
                // NETHER (Bastion/Fortress/etc)
                // Obsidian is valid here.
                // No enderite outside end.
                // -----------------------------------------
                case NETHER -> {
                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.56f, 0.32f, 0.16f,
                            1, 1);

                    // Foods minimal
                    addPies(tableBuilder, 0.05f, 1, 1);

                    addSpecialFoods(tableBuilder, 0.08f, 0.06f, 0.0025f);

                    // Nether metals: obsidian ingot/scrap included; no enderite
                    addNetherMetals(tableBuilder, 0.88f);
                    addNetherDusts(tableBuilder, 0.55f);
                    addNetherScrapsStrict(tableBuilder, 0.74f);

                    addDiscs(tableBuilder, 0.05f);

                    // Templates: hardened + obsidian (adamantium very small)
                    addTemplatesNether(tableBuilder, 0.22f);
                }

                // -----------------------------------------
                // DEEP DARK / ANCIENT CITY
                // Still no enderite scrap here.
                // -----------------------------------------
                case DEEP_DARK -> {
                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.58f, 0.34f, 0.16f,
                            1, 1);

                    addSpecialFoods(tableBuilder, 0.12f, 0.10f, 0.004f);

                    addPies(tableBuilder, 0.06f, 1, 1);

                    addUndergroundMetals(tableBuilder, path, 0.90f);
                    addUndergroundDusts(tableBuilder, 0.80f);
                    addAnthracite(tableBuilder, 0.30f);

                    // deep dark scraps strict (still no enderite)
                    addDungeonScrapsStrict(tableBuilder, 0.48f);

                    addDiscs(tableBuilder, 0.07f);

                    // Templates: hardened/obsidian, adamantium small chance
                    addTemplatesDeep(tableBuilder, 0.22f);
                    addAdamantiumTemplate(tableBuilder, 0.06f);
                }

                // -----------------------------------------
                // END CITY (ENDERITE ONLY HERE)
                // -----------------------------------------
                case END_CITY -> {
                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.60f, 0.36f, 0.18f,
                            1, 1);

                    // ENDERITE ultra rare (tools/armor/shield)
                    addGear(tableBuilder, ENDERITE_TOOLS, ENDERITE_ARMOR, ENDERITE_SHIELDS,
                            0.08f, 0.04f, 0.02f,
                            1, 1);

                    addSpecialFoods(tableBuilder, 0.10f, 0.08f, 0.004f);

                    addPies(tableBuilder, 0.06f, 1, 1);

                    // End metals/scraps: enderite allowed ONLY HERE
                    addEndMetalsStrict(tableBuilder, 0.92f);
                    addEndScrapsStrict(tableBuilder, 0.70f);

                    addLateGems(tableBuilder, 0.32f);

                    addDiscs(tableBuilder, 0.05f);

                    // Templates: enderite + adamantium key
                    addTemplatesEnd(tableBuilder, 0.32f);
                }

                // -----------------------------------------
                // GENERIC CHESTS (light touch)
                // -----------------------------------------
                case GENERIC -> {
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.12f, 0.06f, 0.03f,
                            1, 1);

                    addSpecialFoods(tableBuilder, 0.05f, 0.04f, 0.0015f);

                    addPies(tableBuilder, 0.08f, 1, 1);

                    addOverworldMetals(tableBuilder, path, 0.16f);
                    addOverworldGems(tableBuilder, path, 0.08f);

                    addDiscs(tableBuilder, 0.01f);
                }
            }
        });
    }

    // -------------------------------------------------------------------------
    // CATEGORY DETECTION
    // -------------------------------------------------------------------------

    private enum ChestCategory {
        VILLAGE,
        DUNGEON_MINESHAFT,
        TEMPLE_PYRAMID,
        OUTPOST_TOWER,
        SHIPWRECK_OCEAN,
        STRONGHOLD,
        MANSION,
        NETHER,
        DEEP_DARK,
        END_CITY,
        GENERIC
    }

    private static ChestCategory categorize(String path) {
        if (containsAny(path, "end_city", "endcity", "end_city_treasure")) return ChestCategory.END_CITY;
        if (containsAny(path, "ancient_city", "deep_dark", "sculk", "underground_city")) return ChestCategory.DEEP_DARK;
        if (containsAny(path, "bastion", "fortress", "nether", "piglin")) return ChestCategory.NETHER;
        if (containsAny(path, "stronghold")) return ChestCategory.STRONGHOLD;
        if (containsAny(path, "mansion", "woodland", "illager_mansion")) return ChestCategory.MANSION;
        if (containsAny(path, "shipwreck", "ocean_ruin", "oceanruin", "wreck")) return ChestCategory.SHIPWRECK_OCEAN;
        if (containsAny(path, "outpost", "watchtower", "tower", "camp")) return ChestCategory.OUTPOST_TOWER;
        if (containsAny(path, "desert_pyramid", "pyramid", "jungle_temple", "temple")) return ChestCategory.TEMPLE_PYRAMID;
        if (containsAny(path, "abandoned_mineshaft", "mineshaft", "dungeon", "spawner")) return ChestCategory.DUNGEON_MINESHAFT;
        if (containsAny(path, "village", "villages", "fortified_village", "town")) return ChestCategory.VILLAGE;
        return ChestCategory.GENERIC;
    }

    private static boolean looksLikeChestLoot(String path) {
        return path.contains("chests/") ||
                path.contains("chest/") ||
                path.contains("loot/chests") ||
                path.contains("containers/");
    }

    private static boolean containsAny(String haystack, String... needles) {
        for (String n : needles) {
            if (haystack.contains(n)) return true;
        }
        return false;
    }

    private static boolean isJungle(String path) {
        return containsAny(path, "jungle", "bamboo", "jungle_temple");
    }

    private static boolean isOaky(String path) {
        return containsAny(path, "forest", "oak", "plains", "meadow", "grove", "wood", "village");
    }

    // -------------------------------------------------------------------------
    // WEIGHTING (explicit chances for battle_mace and dagger)
    // -------------------------------------------------------------------------

    private enum WeightProfile { TOOLS, ARMOR, FLAT }

    private static int weightFor(Item it, WeightProfile profile) {
        if (profile == WeightProfile.FLAT) return 10;

        String s = it.toString().toLowerCase(Locale.ROOT);

        if (profile == WeightProfile.TOOLS) {
            if (s.contains("pickaxe")) return 18;
            if (s.contains("sword")) return 16;

            // Explicit special weapon weighting
            if (s.contains("battle_mace")) return 12;
            if (s.contains("battle_axe")) return 12;
            if (s.contains("dagger")) return 11;

            if (s.contains("axe")) return 12;
            if (s.contains("shovel")) return 10;
            if (s.contains("hoe")) return 8;
            return 10;
        }

        // ARMOR
        if (s.contains("chestplate")) return 15;
        if (s.contains("leggings")) return 14;
        if (s.contains("helmet")) return 13;
        if (s.contains("boots")) return 12;
        return 12;
    }

    // -------------------------------------------------------------------------
    // CORE POOL HELPERS (NO loot functions used)
    // -------------------------------------------------------------------------

    private static LootPool.Builder weightedPool(Item[] items, float chance, int rollsMin, int rollsMax, WeightProfile profile) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(rollsMin == rollsMax
                        ? ConstantLootNumberProvider.create(rollsMin)
                        : UniformLootNumberProvider.create(rollsMin, rollsMax))
                .conditionally(RandomChanceLootCondition.builder(chance));

        for (Item it : items) {
            pool.with(ItemEntry.builder(it).weight(weightFor(it, profile)));
        }
        return pool;
    }

    private static void addGear(net.minecraft.loot.LootTable.Builder tableBuilder,
                                Item[] tools, Item[] armor, Item[] shields,
                                float toolChance, float armorChance, float shieldChance,
                                int toolRollsMin, int toolRollsMax) {

        tableBuilder.pool(weightedPool(tools, toolChance, toolRollsMin, toolRollsMax, WeightProfile.TOOLS));
        tableBuilder.pool(weightedPool(armor, armorChance, 1, 1, WeightProfile.ARMOR));
        tableBuilder.pool(weightedPool(shields, shieldChance, 1, 1, WeightProfile.FLAT));
    }

    private static void addSimpleItems(net.minecraft.loot.LootTable.Builder tableBuilder,
                                       Item[] items, float chance, int rollsMin, int rollsMax, WeightProfile profile) {
        tableBuilder.pool(weightedPool(items, chance, rollsMin, rollsMax, profile));
    }

    // -------------------------------------------------------------------------
    // FOODS
    // -------------------------------------------------------------------------

    private static void addPies(net.minecraft.loot.LootTable.Builder tableBuilder, float chance, int rollsMin, int rollsMax) {
        tableBuilder.pool(weightedPool(PIES, chance, rollsMin, rollsMax, WeightProfile.FLAT));
    }

    // -------------------------------------------------------------------------
    // DISCS
    // -------------------------------------------------------------------------

    private static void addDiscs(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        tableBuilder.pool(weightedPool(ALLOWED_DISCS, chance, 1, 1, WeightProfile.FLAT));
    }

    // -------------------------------------------------------------------------
    // SPECIAL FOODS (silver carrot + apples + enchanted apples)
    // -------------------------------------------------------------------------

    private static void addSpecialFoods(net.minecraft.loot.LootTable.Builder tableBuilder,
                                        float silverCarrotChance,
                                        float applesChance,
                                        float enchantedApplesChance) {

        // Silver carrot: common-ish special snack
        tableBuilder.pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(silverCarrotChance))
                .with(ItemEntry.builder(SPECIAL_SILVER_CARROT).weight(10))
        );

        // Apples: rare treasure (aiming for golden apple-ish feel)
        LootPool.Builder apples = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(applesChance));

        // Weighting: cobalt/rose-gold slightly rarer than silver/bronze
        apples.with(ItemEntry.builder(ModItems.SILVER_APPLE).weight(8));
        apples.with(ItemEntry.builder(ModItems.BRONZE_APPLE).weight(8));
        apples.with(ItemEntry.builder(ModItems.COBALT_APPLE).weight(5));
        apples.with(ItemEntry.builder(ModItems.ROSE_GOLD_APPLE).weight(5));

        tableBuilder.pool(apples);

        // Enchanted apples: VERY rare (enchanted golden apple vibe)
        LootPool.Builder enchanted = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(enchantedApplesChance));

        enchanted.with(ItemEntry.builder(ModItems.ENCHANTED_COBALT_APPLE).weight(1));
        enchanted.with(ItemEntry.builder(ModItems.ENCHANTED_ROSE_GOLD_APPLE).weight(1));

        tableBuilder.pool(enchanted);
    }

    // -------------------------------------------------------------------------
    // MATERIAL POOLS (simulate stacks with more rolls, no SetCount)
    // -------------------------------------------------------------------------

    private static void addAnthracite(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        tableBuilder.pool(LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance))
                .with(ItemEntry.builder(ANTHRACITE).weight(10)));
    }

    private static void addOverworldMetals(net.minecraft.loot.LootTable.Builder tableBuilder, String path, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(2, 4))
                .conditionally(RandomChanceLootCondition.builder(chance));

        for (Item it : EARLY_INGOTS) pool.with(ItemEntry.builder(it).weight(14));
        for (Item it : RAW_MATERIALS) pool.with(ItemEntry.builder(it).weight(13));
        for (Item it : NUGGETS) pool.with(ItemEntry.builder(it).weight(12));
        for (Item it : EARLY_MID_INGOTS) pool.with(ItemEntry.builder(it).weight(8));

        // Adamantium ingot: rare overworld treasure (rarer than diamond feel)
        // Weight rises slightly in rich structures.
        int rich = containsAny(path, "mansion", "stronghold", "temple", "pyramid") ? 2 : 1;
        pool.with(ItemEntry.builder(ModItems.ADAMANTIUM_INGOT).weight(rich));

        // Obsidian ingot can appear as ultra-rare overworld treasure too (optional spice)
        pool.with(ItemEntry.builder(ModItems.OBSIDIAN_INGOT).weight(1));

        // Hardened steel ingot extremely rare overworld
        pool.with(ItemEntry.builder(ModItems.HARDENED_STEEL_INGOT).weight(1));

        // Never add enderite outside end (not included)

        tableBuilder.pool(pool);
    }

    private static void addOverworldGems(net.minecraft.loot.LootTable.Builder tableBuilder, String path, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance));

        int rich = containsAny(path, "temple", "pyramid", "mansion", "stronghold") ? 14 : 10;
        for (Item it : GEMS_EARLY_MID) pool.with(ItemEntry.builder(it).weight(rich));
        for (Item it : GEMS_LATE) pool.with(ItemEntry.builder(it).weight(3));

        tableBuilder.pool(pool);
    }

    private static void addLateGems(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        tableBuilder.pool(weightedPool(GEMS_LATE, chance, 1, 2, WeightProfile.FLAT));
    }

    private static void addUndergroundMetals(net.minecraft.loot.LootTable.Builder tableBuilder, String path, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(2, 5))
                .conditionally(RandomChanceLootCondition.builder(chance));

        for (Item it : RAW_MATERIALS) pool.with(ItemEntry.builder(it).weight(14));
        for (Item it : NUGGETS) pool.with(ItemEntry.builder(it).weight(13));
        for (Item it : EARLY_INGOTS) pool.with(ItemEntry.builder(it).weight(12));

        // Early-mid ingots can appear in dungeons (you liked sterling)
        for (Item it : EARLY_MID_INGOTS) pool.with(ItemEntry.builder(it).weight(8));

        // Adamantium ingot: very rare underground treasure too
        pool.with(ItemEntry.builder(ModItems.ADAMANTIUM_INGOT).weight(1));

        // Obsidian ingot possible but rare underground
        pool.with(ItemEntry.builder(ModItems.OBSIDIAN_INGOT).weight(1));

        // Never enderite here

        tableBuilder.pool(pool);
    }

    private static void addUndergroundDusts(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 3))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Underground emphasis: quartz + lapis (you liked those)
        pool.with(ItemEntry.builder(ModItems.QUARTZ_DUST).weight(14));
        pool.with(ItemEntry.builder(ModItems.LAPIS_LAZULI_DUST).weight(16));

        // plus amethyst dust
        pool.with(ItemEntry.builder(ModItems.AMETHYST_DUST).weight(14));

        // turquoise dust occasionally
        pool.with(ItemEntry.builder(ModItems.TURQUOISE_DUST).weight(10));

        tableBuilder.pool(pool);
    }

    private static void addContextDusts(net.minecraft.loot.LootTable.Builder tableBuilder, String path, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance));

        if (containsAny(path, "desert", "badlands", "mesa", "pyramid", "temple")) {
            pool.with(ItemEntry.builder(ModItems.TURQUOISE_DUST).weight(14));
        }

        if (containsAny(path, "stronghold", "mansion", "temple")) {
            pool.with(ItemEntry.builder(ModItems.LAPIS_LAZULI_DUST).weight(12));
        }

        pool.with(ItemEntry.builder(ModItems.AMETHYST_DUST).weight(10));
        pool.with(ItemEntry.builder(ModItems.QUARTZ_DUST).weight(10));

        tableBuilder.pool(pool);
    }

    private static void addNetherMetals(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(2, 5))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Nether: obsidian is valid and should be present.
        pool.with(ItemEntry.builder(ModItems.OBSIDIAN_INGOT).weight(14));
        pool.with(ItemEntry.builder(ModItems.HARDENED_STEEL_INGOT).weight(10));
        pool.with(ItemEntry.builder(ModItems.ADAMANTIUM_INGOT).weight(4)); // rare-ish nether

        // Carbon steel and nuggets
        pool.with(ItemEntry.builder(ModItems.CARBON_STEEL_INGOT).weight(8));
        for (Item it : NUGGETS) pool.with(ItemEntry.builder(it).weight(11));

        // Never enderite ingot here

        tableBuilder.pool(pool);
    }

    private static void addNetherDusts(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 3))
                .conditionally(RandomChanceLootCondition.builder(chance));

        pool.with(ItemEntry.builder(ModItems.QUARTZ_DUST).weight(18));
        pool.with(ItemEntry.builder(ModItems.ONYX_GEM).weight(10));
        pool.with(ItemEntry.builder(ModItems.TOURMALINE_GEM).weight(10));

        tableBuilder.pool(pool);
    }

    private static void addEndMetalsStrict(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(2, 4))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // End: enderite ingot allowed (rare), obsidian/adamantium/hardened present too.
        pool.with(ItemEntry.builder(ModItems.ADAMANTIUM_INGOT).weight(10));
        pool.with(ItemEntry.builder(ModItems.OBSIDIAN_INGOT).weight(10));
        pool.with(ItemEntry.builder(ModItems.HARDENED_STEEL_INGOT).weight(8));

        pool.with(ItemEntry.builder(ModItems.ENDERITE_INGOT).weight(2)); // rare

        tableBuilder.pool(pool);
    }

    // -------------------------------------------------------------------------
    // SCRAPS (STRICT BY CONTEXT)
    // -------------------------------------------------------------------------

    private static void addDungeonScrapsStrict(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Carbon steel scrap common-ish
        pool.with(ItemEntry.builder(ModItems.CARBON_STEEL_SCRAP).weight(16));

        // Obsidian scrap uncommon
        pool.with(ItemEntry.builder(ModItems.OBSIDIAN_SCRAP).weight(8));

        // Absolutely no enderite scrap here.
        // Absolutely no hot carbon steel scrap.

        tableBuilder.pool(pool);
    }

    private static void addNetherScrapsStrict(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance));

        pool.with(ItemEntry.builder(ModItems.CARBON_STEEL_SCRAP).weight(12));
        pool.with(ItemEntry.builder(ModItems.OBSIDIAN_SCRAP).weight(14)); // obsidian emphasized in nether

        // No enderite scrap here.

        tableBuilder.pool(pool);
    }

    private static void addEndScrapsStrict(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 3))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // End: enderite scrap allowed (rare), obsidian scrap common
        pool.with(ItemEntry.builder(ModItems.OBSIDIAN_SCRAP).weight(14));
        pool.with(ItemEntry.builder(ModItems.ENDERITE_SCRAP).weight(2));

        tableBuilder.pool(pool);
    }

    // -------------------------------------------------------------------------
    // TEMPLATES (kept sensible and constrained)
    // -------------------------------------------------------------------------

    private static void addTemplatesOverworldRich(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance));

        pool.with(ItemEntry.builder(TEMPLATE_HARDENED).weight(10));
        pool.with(ItemEntry.builder(TEMPLATE_OBSIDIAN).weight(8));

        tableBuilder.pool(pool);
    }

    private static void addTemplatesNether(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance));

        pool.with(ItemEntry.builder(TEMPLATE_HARDENED).weight(12));
        pool.with(ItemEntry.builder(TEMPLATE_OBSIDIAN).weight(12));
        pool.with(ItemEntry.builder(TEMPLATE_ADAMANTIUM).weight(2));

        tableBuilder.pool(pool);
    }

    private static void addTemplatesDeep(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance));

        pool.with(ItemEntry.builder(TEMPLATE_HARDENED).weight(12));
        pool.with(ItemEntry.builder(TEMPLATE_OBSIDIAN).weight(10));
        pool.with(ItemEntry.builder(TEMPLATE_ADAMANTIUM).weight(3));

        tableBuilder.pool(pool);
    }

    private static void addAdamantiumTemplate(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        tableBuilder.pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance))
                .with(ItemEntry.builder(TEMPLATE_ADAMANTIUM).weight(10)));
    }

    private static void addTemplatesEnd(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // End: enderite template primary
        pool.with(ItemEntry.builder(TEMPLATE_ENDERITE).weight(12));
        pool.with(ItemEntry.builder(TEMPLATE_ADAMANTIUM).weight(10));

        // tiny echo
        pool.with(ItemEntry.builder(TEMPLATE_HARDENED).weight(2));
        pool.with(ItemEntry.builder(TEMPLATE_OBSIDIAN).weight(2));

        tableBuilder.pool(pool);
    }
}
