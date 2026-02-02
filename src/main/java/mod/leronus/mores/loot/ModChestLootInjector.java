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
 * IMPORTANT:
 * - This does NOT add any vanilla items.
 * - This does NOT add stone/iron tools.
 * - True "replacement" (removing vanilla entries) is not reliably possible using LootTableEvents.MODIFY alone.
 *   Instead, we inject your tools/armor often enough that they effectively replace the feel, while vanilla can still occur.
 */
public final class ModChestLootInjector {

    private ModChestLootInjector() {}

    // -------------------------------------------------------------------------
    // TIERS (tools/armor focus)
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

    private static final Item[] MID_TOOLS = new Item[]{
            ModItems.SILVER_SWORD, ModItems.SILVER_PICKAXE, ModItems.SILVER_AXE, ModItems.SILVER_SHOVEL, ModItems.SILVER_HOE,
            ModItems.STERLING_SILVER_SWORD, ModItems.STERLING_SILVER_PICKAXE, ModItems.STERLING_SILVER_AXE, ModItems.STERLING_SILVER_SHOVEL, ModItems.STERLING_SILVER_HOE,
            ModItems.COBALT_SWORD, ModItems.COBALT_PICKAXE, ModItems.COBALT_AXE, ModItems.COBALT_SHOVEL, ModItems.COBALT_HOE,
            ModItems.ROSE_GOLD_SWORD, ModItems.ROSE_GOLD_PICKAXE, ModItems.ROSE_GOLD_AXE, ModItems.ROSE_GOLD_SHOVEL, ModItems.ROSE_GOLD_HOE
    };

    private static final Item[] MID_ARMOR = new Item[]{
            ModItems.SILVER_HELMET, ModItems.SILVER_CHESTPLATE, ModItems.SILVER_LEGGINGS, ModItems.SILVER_BOOTS,
            ModItems.STERLING_SILVER_HELMET, ModItems.STERLING_SILVER_CHESTPLATE, ModItems.STERLING_SILVER_LEGGINGS, ModItems.STERLING_SILVER_BOOTS,
            ModItems.COBALT_HELMET, ModItems.COBALT_CHESTPLATE, ModItems.COBALT_LEGGINGS, ModItems.COBALT_BOOTS,
            ModItems.ROSE_GOLD_HELMET, ModItems.ROSE_GOLD_CHESTPLATE, ModItems.ROSE_GOLD_LEGGINGS, ModItems.ROSE_GOLD_BOOTS
    };

    private static final Item[] MID_SHIELDS = new Item[]{
            ModItems.SILVER_SHIELD, ModItems.STERLING_SILVER_SHIELD, ModItems.COBALT_SHIELD, ModItems.ROSE_GOLD_SHIELD
    };

    private static final Item[] LATE_TOOLS = new Item[]{
            ModItems.CARBON_STEEL_SWORD, ModItems.CARBON_STEEL_PICKAXE, ModItems.CARBON_STEEL_AXE, ModItems.CARBON_STEEL_SHOVEL, ModItems.CARBON_STEEL_HOE,
            ModItems.HARDENED_STEEL_SWORD, ModItems.HARDENED_STEEL_PICKAXE, ModItems.HARDENED_STEEL_AXE, ModItems.HARDENED_STEEL_SHOVEL, ModItems.HARDENED_STEEL_HOE,
            ModItems.OBSIDIAN_SWORD, ModItems.OBSIDIAN_PICKAXE, ModItems.OBSIDIAN_AXE, ModItems.OBSIDIAN_SHOVEL, ModItems.OBSIDIAN_HOE,
            ModItems.ENDERITE_SWORD, ModItems.ENDERITE_PICKAXE, ModItems.ENDERITE_AXE, ModItems.ENDERITE_SHOVEL, ModItems.ENDERITE_HOE,
            ModItems.ADAMANTIUM_SWORD, ModItems.ADAMANTIUM_PICKAXE, ModItems.ADAMANTIUM_AXE, ModItems.ADAMANTIUM_SHOVEL, ModItems.ADAMANTIUM_HOE
    };

    private static final Item[] LATE_ARMOR = new Item[]{
            ModItems.CARBON_STEEL_HELMET, ModItems.CARBON_STEEL_CHESTPLATE, ModItems.CARBON_STEEL_LEGGINGS, ModItems.CARBON_STEEL_BOOTS,
            ModItems.HARDENED_STEEL_HELMET, ModItems.HARDENED_STEEL_CHESTPLATE, ModItems.HARDENED_STEEL_LEGGINGS, ModItems.HARDENED_STEEL_BOOTS,
            ModItems.OBSIDIAN_HELMET, ModItems.OBSIDIAN_CHESTPLATE, ModItems.OBSIDIAN_LEGGINGS, ModItems.OBSIDIAN_BOOTS,
            ModItems.ENDERITE_HELMET, ModItems.ENDERITE_CHESTPLATE, ModItems.ENDERITE_LEGGINGS, ModItems.ENDERITE_BOOTS,
            ModItems.ADAMANTIUM_HELMET, ModItems.ADAMANTIUM_CHESTPLATE, ModItems.ADAMANTIUM_LEGGINGS, ModItems.ADAMANTIUM_BOOTS
    };

    private static final Item[] LATE_SHIELDS = new Item[]{
            ModItems.CARBON_STEEL_SHIELD, ModItems.HARDENED_STEEL_SHIELD, ModItems.OBSIDIAN_SHIELD, ModItems.ENDERITE_SHIELD, ModItems.ADAMANTIUM_SHIELD
    };

    // -------------------------------------------------------------------------
    // FOODS (ONLY your mod foods)
    // Rules:
    // - Chocolate only in jungle-ish loot
    // - Lemons only in oak/forest-ish loot
    // - Pies widely available
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

    private static final Item[] DUCK_FOODS = new Item[]{
            ModItems.RAW_DUCK,
            ModItems.COOKED_DUCK
    };

    // -------------------------------------------------------------------------
    // SMITHING TEMPLATES (keep + ensure late-structure findability)
    // -------------------------------------------------------------------------

    private static final Item[] UPGRADE_TEMPLATES = new Item[]{
            ModItems.HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE,
            ModItems.OBSIDIAN_UPGRADE_SMITHING_TEMPLATE,
            ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE,
            ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE
    };

    // -------------------------------------------------------------------------
    // MATERIALS (ingots, nuggets, raws, gems, dusts, scraps)
    // -------------------------------------------------------------------------

    private static final Item[] EARLY_INGOTS = new Item[]{
            ModItems.TIN_INGOT,
            ModItems.BRONZE_INGOT
    };

    private static final Item[] MID_INGOTS = new Item[]{
            ModItems.SILVER_INGOT,
            ModItems.STERLING_SILVER_INGOT,
            ModItems.COBALT_INGOT,
            ModItems.ROSE_GOLD_INGOT
    };

    private static final Item[] LATE_INGOTS = new Item[]{
            ModItems.CARBON_STEEL_INGOT,
            ModItems.HARDENED_STEEL_INGOT,
            ModItems.OBSIDIAN_INGOT,
            ModItems.ENDERITE_INGOT,
            ModItems.ADAMANTIUM_INGOT
    };

    private static final Item[] RAW_MATERIALS = new Item[]{
            ModItems.RAW_TIN,
            ModItems.RAW_SILVER,
            ModItems.RAW_COBALT
    };

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

    private static final Item[] SCRAPS_SPECIAL = new Item[]{
            ModItems.HOT_CARBON_STEEL_SCRAP,
            ModItems.CARBON_STEEL_SCRAP,
            ModItems.OBSIDIAN_SCRAP,
            ModItems.ENDERITE_SCRAP,
            ModItems.ANTHRACITE
    };

    private static final Item[] DUSTS = new Item[]{
            ModItems.QUARTZ_DUST,
            ModItems.LAPIS_LAZULI_DUST,
            ModItems.AMETHYST_DUST,
            ModItems.TURQUOISE_DUST
    };

    private static final Item[] GEMS = new Item[]{
            ModItems.LAPIS_LAZULI_GEM,
            ModItems.TURQUOISE_GEM,
            ModItems.AMETHYST_GEM,
            ModItems.TANZANITE_GEM,
            ModItems.TOPAZ_GEM,
            ModItems.TOURMALINE_GEM,
            ModItems.RUBY_GEM,
            ModItems.SAPPHIRE_GEM,
            ModItems.SPINEL_GEM,
            ModItems.CITRINE_GEM,
            ModItems.MOISSANITE_GEM,
            ModItems.ONYX_GEM
    };

    // -------------------------------------------------------------------------
    // REGISTER
    // -------------------------------------------------------------------------

    public static void register() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (!source.isBuiltin()) return;

            Identifier id = key.getValue();
            String ns = id.getNamespace().toLowerCase(Locale.ROOT);
            String path = id.getPath().toLowerCase(Locale.ROOT);

            if (!looksLikeChestLoot(path)) return;

            ChestCategory cat = categorize(ns, path);

            switch (cat) {
                case VILLAGE_EARLY -> {
                    // Strong early presence to "feel like replacement"
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.78f, 0.70f, 0.18f);

                    addFoods(tableBuilder, path,
                            0.55f,  // pies
                            0.20f,  // lemons (only if oak-ish)
                            0.12f,  // chocolate (only if jungle-ish)
                            0.18f); // duck

                    addMaterialsOverworld(tableBuilder, path,
                            0.88f,  // metals/raw/nuggets
                            0.72f); // gems/dusts

                    // No templates here.
                }

                case DUNGEON_MINESHAFT -> {
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.82f, 0.74f, 0.20f);

                    addFoods(tableBuilder, path,
                            0.45f, 0.14f, 0.08f, 0.22f);

                    addMaterialsUnderground(tableBuilder, path,
                            0.92f, 0.86f);
                }

                case TEMPLE_PYRAMID -> {
                    addGear(tableBuilder, MID_TOOLS, MID_ARMOR, MID_SHIELDS,
                            0.82f, 0.76f, 0.22f);

                    addFoods(tableBuilder, path,
                            0.52f, 0.18f, 0.14f, 0.20f);

                    addMaterialsOverworld(tableBuilder, path,
                            0.94f, 0.90f);

                    // Small chance for templates in high-value overworld structures
                    addTemplates(tableBuilder, 0.08f);
                }

                case OUTPOST_TOWER -> {
                    addGear(tableBuilder, MID_TOOLS, MID_ARMOR, MID_SHIELDS,
                            0.84f, 0.78f, 0.24f);

                    addFoods(tableBuilder, path,
                            0.45f, 0.14f, 0.10f, 0.24f);

                    addMaterialsOverworld(tableBuilder, path,
                            0.92f, 0.84f);

                    addTemplates(tableBuilder, 0.06f);
                }

                case SHIPWRECK_OCEAN -> {
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.64f, 0.54f, 0.14f);

                    addFoods(tableBuilder, path,
                            0.34f, 0.10f, 0.08f, 0.18f);

                    addMaterialsOverworld(tableBuilder, path,
                            0.88f, 0.70f);
                }

                case STRONGHOLD -> {
                    addGear(tableBuilder, MID_TOOLS, MID_ARMOR, MID_SHIELDS,
                            0.86f, 0.80f, 0.26f);

                    addFoods(tableBuilder, path,
                            0.44f, 0.12f, 0.10f, 0.18f);

                    addMaterialsUnderground(tableBuilder, path,
                            0.96f, 0.94f);

                    addTemplates(tableBuilder, 0.14f);
                }

                case MANSION -> {
                    addGear(tableBuilder, MID_TOOLS, MID_ARMOR, MID_SHIELDS,
                            0.86f, 0.80f, 0.28f);

                    addFoods(tableBuilder, path,
                            0.60f, 0.22f, 0.12f, 0.20f);

                    addMaterialsOverworld(tableBuilder, path,
                            0.96f, 0.96f);

                    addTemplates(tableBuilder, 0.16f);
                }

                case BASTION_FORTRESS -> {
                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.90f, 0.84f, 0.32f);

                    // No lemons here, chocolate only if jungle-ish (won't trigger in nether)
                    addFoods(tableBuilder, path,
                            0.28f, 0.00f, 0.00f, 0.16f);

                    addMaterialsNether(tableBuilder,
                            0.98f, 0.96f);

                    addTemplates(tableBuilder, 0.30f);
                }

                case ANCIENT_CITY_DEEP -> {
                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.92f, 0.86f, 0.34f);

                    addFoods(tableBuilder, path,
                            0.34f, 0.00f, 0.00f, 0.16f);

                    addMaterialsDeepDark(tableBuilder,
                            0.99f, 0.99f);

                    addTemplates(tableBuilder, 0.34f);
                }

                case END_CITY -> {
                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.94f, 0.88f, 0.35f);

                    addFoods(tableBuilder, path,
                            0.32f, 0.00f, 0.00f, 0.14f);

                    addMaterialsEnd(tableBuilder,
                            0.99f, 0.99f);

                    addTemplates(tableBuilder, 0.44f);
                }

                case GENERIC_CHEST -> {
                    // Very light touch
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.22f, 0.18f, 0.06f);

                    addFoods(tableBuilder, path,
                            0.20f, 0.06f, 0.06f, 0.08f);

                    addMaterialsOverworld(tableBuilder, path,
                            0.22f, 0.18f);

                    addTemplates(tableBuilder, 0.02f);
                }
            }
        });
    }

    // -------------------------------------------------------------------------
    // CATEGORY (pattern-based for mod structures)
    // -------------------------------------------------------------------------

    private enum ChestCategory {
        VILLAGE_EARLY,
        DUNGEON_MINESHAFT,
        TEMPLE_PYRAMID,
        OUTPOST_TOWER,
        SHIPWRECK_OCEAN,
        STRONGHOLD,
        MANSION,
        BASTION_FORTRESS,
        ANCIENT_CITY_DEEP,
        END_CITY,
        GENERIC_CHEST
    }

    private static ChestCategory categorize(String namespace, String path) {
        if (containsAny(path, "end_city", "endcity", "end_city_treasure")) return ChestCategory.END_CITY;
        if (containsAny(path, "ancient_city", "deep_dark", "sculk", "underground_city")) return ChestCategory.ANCIENT_CITY_DEEP;
        if (containsAny(path, "bastion", "fortress", "nether", "piglin")) return ChestCategory.BASTION_FORTRESS;
        if (containsAny(path, "stronghold")) return ChestCategory.STRONGHOLD;
        if (containsAny(path, "mansion", "woodland", "illager_mansion")) return ChestCategory.MANSION;
        if (containsAny(path, "shipwreck", "ocean_ruin", "oceanruin", "wreck")) return ChestCategory.SHIPWRECK_OCEAN;
        if (containsAny(path, "outpost", "watchtower", "tower", "camp")) return ChestCategory.OUTPOST_TOWER;
        if (containsAny(path, "desert_pyramid", "pyramid", "jungle_temple", "temple")) return ChestCategory.TEMPLE_PYRAMID;
        if (containsAny(path, "abandoned_mineshaft", "mineshaft", "dungeon", "spawner")) return ChestCategory.DUNGEON_MINESHAFT;
        if (containsAny(path, "village", "fortified_village", "town")) return ChestCategory.VILLAGE_EARLY;
        return ChestCategory.GENERIC_CHEST;
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

    // -------------------------------------------------------------------------
    // INJECTION: GEAR
    // -------------------------------------------------------------------------

    private static void addGear(net.minecraft.loot.LootTable.Builder tableBuilder,
                                Item[] tools, Item[] armor, Item[] shields,
                                float toolChance, float armorChance, float shieldChance) {

        // Tools: rolls 1-2
        tableBuilder.pool(weightedPool(tools, toolChance, 1, 2, WeightProfile.TOOLS));

        // Armor: rolls 1 (keeps armor meaningful, not flooding)
        tableBuilder.pool(weightedPool(armor, armorChance, 1, 1, WeightProfile.ARMOR));

        // Shields: rolls 1, low chance
        tableBuilder.pool(weightedPool(shields, shieldChance, 1, 1, WeightProfile.FLAT));
    }

    private enum WeightProfile { TOOLS, ARMOR, FLAT }

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

    private static int weightFor(Item it, WeightProfile profile) {
        if (profile == WeightProfile.FLAT) return 10;

        String s = it.toString().toLowerCase(Locale.ROOT);

        if (profile == WeightProfile.TOOLS) {
            if (s.contains("pickaxe")) return 20;
            if (s.contains("sword")) return 18;
            if (s.contains("battle_axe")) return 14;
            if (s.contains("axe")) return 13;
            if (s.contains("shovel")) return 11;
            if (s.contains("hoe")) return 9;
            return 10;
        }

        // ARMOR
        if (s.contains("chestplate")) return 16;
        if (s.contains("leggings")) return 15;
        if (s.contains("helmet")) return 14;
        if (s.contains("boots")) return 13;
        return 13;
    }

    // -------------------------------------------------------------------------
    // INJECTION: FOODS (ONLY mod foods)
    // -------------------------------------------------------------------------

    private static void addFoods(net.minecraft.loot.LootTable.Builder tableBuilder,
                                 String lootPath,
                                 float pieChance,
                                 float lemonChance,
                                 float chocolateChance,
                                 float duckChance) {

        // Pies: everywhere (rolls 1-2)
        tableBuilder.pool(weightedPool(PIES, pieChance, 1, 2, WeightProfile.FLAT));

        // Duck: general savory loot (rolls 1)
        tableBuilder.pool(weightedPool(DUCK_FOODS, duckChance, 1, 1, WeightProfile.FLAT));

        // Lemons: oak/forest/plains/village-ish ONLY
        if (containsAny(lootPath, "forest", "oak", "plains", "meadow", "village", "grove", "wood")) {
            tableBuilder.pool(weightedPool(LEMONS_OAKY, lemonChance, 1, 2, WeightProfile.FLAT));
        }

        // Chocolate: jungle-ish ONLY
        if (containsAny(lootPath, "jungle", "bamboo", "temple", "jungle_temple")) {
            tableBuilder.pool(weightedPool(CHOCOLATES, chocolateChance, 1, 2, WeightProfile.FLAT));
        }
    }

    // -------------------------------------------------------------------------
    // INJECTION: MATERIALS (lots of variety)
    // NOTE: No SetCount loot function used (to avoid protected builder issues).
    // Instead we use more rolls + more pools to simulate stacks.
    // -------------------------------------------------------------------------

    private static void addMaterialsOverworld(net.minecraft.loot.LootTable.Builder tableBuilder,
                                              String lootPath,
                                              float metalsChance,
                                              float gemsDustChance) {

        // Metals: rolls 2-5 (makes "stacks" without SetCount)
        tableBuilder.pool(materialPoolOverworldMetals(metalsChance, lootPath));

        // Gems/Dusts: rolls 1-3
        tableBuilder.pool(materialPoolGemsDusts(gemsDustChance, lootPath, MaterialCtx.OVERWORLD));

        // Light scraps in certain overworld loot
        if (containsAny(lootPath, "mineshaft", "dungeon", "stronghold", "mansion", "temple", "pyramid")) {
            tableBuilder.pool(weightedPool(SCRAPS_SPECIAL, 0.30f, 1, 2, WeightProfile.FLAT));
        }
    }

    private static void addMaterialsUnderground(net.minecraft.loot.LootTable.Builder tableBuilder,
                                                String lootPath,
                                                float metalsChance,
                                                float gemsDustChance) {

        tableBuilder.pool(materialPoolOverworldMetals(metalsChance, lootPath));
        tableBuilder.pool(materialPoolGemsDusts(gemsDustChance, lootPath, MaterialCtx.UNDERGROUND));

        // More scraps underground
        tableBuilder.pool(weightedPool(SCRAPS_SPECIAL, 0.55f, 1, 3, WeightProfile.FLAT));
    }

    private static void addMaterialsNether(net.minecraft.loot.LootTable.Builder tableBuilder,
                                           float metalsChance,
                                           float gemsDustChance) {

        tableBuilder.pool(materialPoolNetherMetals(metalsChance));
        tableBuilder.pool(materialPoolGemsDusts(gemsDustChance, "nether", MaterialCtx.NETHER));

        // Scraps are very common in nether structures
        tableBuilder.pool(weightedPool(SCRAPS_SPECIAL, 0.85f, 1, 4, WeightProfile.FLAT));
    }

    private static void addMaterialsDeepDark(net.minecraft.loot.LootTable.Builder tableBuilder,
                                             float metalsChance,
                                             float gemsDustChance) {

        tableBuilder.pool(materialPoolDeepDarkMetals(metalsChance));
        tableBuilder.pool(materialPoolGemsDusts(gemsDustChance, "deep_dark", MaterialCtx.DEEP_DARK));

        // Scraps very common
        tableBuilder.pool(weightedPool(SCRAPS_SPECIAL, 0.92f, 1, 4, WeightProfile.FLAT));
    }

    private static void addMaterialsEnd(net.minecraft.loot.LootTable.Builder tableBuilder,
                                        float metalsChance,
                                        float gemsDustChance) {

        tableBuilder.pool(materialPoolEndMetals(metalsChance));
        tableBuilder.pool(materialPoolGemsDusts(gemsDustChance, "end", MaterialCtx.END));

        tableBuilder.pool(weightedPool(SCRAPS_SPECIAL, 0.88f, 1, 4, WeightProfile.FLAT));
    }

    private static LootPool.Builder materialPoolOverworldMetals(float chance, String lootPath) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(2, 5))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Always possible
        for (Item it : EARLY_INGOTS) pool.with(ItemEntry.builder(it).weight(14));
        for (Item it : RAW_MATERIALS) pool.with(ItemEntry.builder(it).weight(13));
        for (Item it : NUGGETS) pool.with(ItemEntry.builder(it).weight(12));

        // Mid ingots: richer loot = more weight
        int midWeight = containsAny(lootPath, "temple", "pyramid", "outpost", "stronghold", "mansion", "mineshaft", "dungeon") ? 12 : 7;
        for (Item it : MID_INGOTS) pool.with(ItemEntry.builder(it).weight(midWeight));

        // Rare chance to see a late ingot in “big” overworld loot (spicy finds)
        int lateWeight = containsAny(lootPath, "mansion", "stronghold") ? 3 : 1;
        for (Item it : LATE_INGOTS) pool.with(ItemEntry.builder(it).weight(lateWeight));

        return pool;
    }

    private static LootPool.Builder materialPoolNetherMetals(float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(2, 5))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Nether leans late ingots + nuggets + scraps
        for (Item it : LATE_INGOTS) pool.with(ItemEntry.builder(it).weight(14));
        for (Item it : NUGGETS) pool.with(ItemEntry.builder(it).weight(11));
        for (Item it : SCRAPS_SPECIAL) pool.with(ItemEntry.builder(it).weight(13));

        // Still possible to see mid ingots (rare-ish)
        for (Item it : MID_INGOTS) pool.with(ItemEntry.builder(it).weight(5));

        return pool;
    }

    private static LootPool.Builder materialPoolDeepDarkMetals(float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(2, 4))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Deep dark: hardened/obsidian/enderite feel right
        pool.with(ItemEntry.builder(ModItems.HARDENED_STEEL_INGOT).weight(16));
        pool.with(ItemEntry.builder(ModItems.OBSIDIAN_INGOT).weight(15));
        pool.with(ItemEntry.builder(ModItems.ENDERITE_INGOT).weight(13));
        pool.with(ItemEntry.builder(ModItems.CARBON_STEEL_INGOT).weight(12));

        for (Item it : SCRAPS_SPECIAL) pool.with(ItemEntry.builder(it).weight(14));
        for (Item it : NUGGETS) pool.with(ItemEntry.builder(it).weight(10));

        // Mid ingots still possible
        for (Item it : MID_INGOTS) pool.with(ItemEntry.builder(it).weight(6));

        return pool;
    }

    private static LootPool.Builder materialPoolEndMetals(float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(2, 4))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // End: enderite + adamantium are the stars
        pool.with(ItemEntry.builder(ModItems.ENDERITE_INGOT).weight(16));
        pool.with(ItemEntry.builder(ModItems.ADAMANTIUM_INGOT).weight(14));
        pool.with(ItemEntry.builder(ModItems.OBSIDIAN_INGOT).weight(10));

        pool.with(ItemEntry.builder(ModItems.ENDERITE_SCRAP).weight(15));
        pool.with(ItemEntry.builder(ModItems.OBSIDIAN_SCRAP).weight(12));

        for (Item it : NUGGETS) pool.with(ItemEntry.builder(it).weight(9));
        for (Item it : MID_INGOTS) pool.with(ItemEntry.builder(it).weight(6));

        return pool;
    }

    private enum MaterialCtx { OVERWORLD, UNDERGROUND, NETHER, DEEP_DARK, END }

    private static LootPool.Builder materialPoolGemsDusts(float chance, String lootPath, MaterialCtx ctx) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 3))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Gems everywhere; more weight in rich structures
        int gemWeight = containsAny(lootPath, "temple", "pyramid", "mansion", "stronghold", "ancient_city", "end_city", "bastion", "fortress") ? 14 : 10;
        for (Item it : GEMS) pool.with(ItemEntry.builder(it).weight(gemWeight));

        // Dusts “where it makes sense”
        switch (ctx) {
            case NETHER -> {
                pool.with(ItemEntry.builder(ModItems.QUARTZ_DUST).weight(18));
                pool.with(ItemEntry.builder(ModItems.ONYX_GEM).weight(10));
                pool.with(ItemEntry.builder(ModItems.TOURMALINE_GEM).weight(10));
            }
            case DEEP_DARK -> {
                pool.with(ItemEntry.builder(ModItems.AMETHYST_DUST).weight(18));
                pool.with(ItemEntry.builder(ModItems.LAPIS_LAZULI_DUST).weight(16));
            }
            case UNDERGROUND -> {
                pool.with(ItemEntry.builder(ModItems.AMETHYST_DUST).weight(16));
                pool.with(ItemEntry.builder(ModItems.LAPIS_LAZULI_DUST).weight(16));
            }
            case OVERWORLD -> {
                if (containsAny(lootPath, "desert", "badlands", "mesa", "pyramid", "temple")) {
                    pool.with(ItemEntry.builder(ModItems.TURQUOISE_DUST).weight(16));
                }
                if (containsAny(lootPath, "stronghold", "mansion", "temple")) {
                    pool.with(ItemEntry.builder(ModItems.LAPIS_LAZULI_DUST).weight(14));
                }
            }
            case END -> {
                // Keep dust minimal in End
                pool.with(ItemEntry.builder(ModItems.MOISSANITE_GEM).weight(12));
                pool.with(ItemEntry.builder(ModItems.ONYX_GEM).weight(10));
            }
        }

        return pool;
    }

    // -------------------------------------------------------------------------
    // INJECTION: TEMPLATES
    // -------------------------------------------------------------------------

    private static void addTemplates(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        tableBuilder.pool(weightedPool(UPGRADE_TEMPLATES, chance, 1, 1, WeightProfile.FLAT));
    }
}
