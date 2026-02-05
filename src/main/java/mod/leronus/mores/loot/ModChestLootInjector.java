package mod.leronus.mores.loot;

import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.Locale;

/**
 * Vanilla+ chest loot injector (ADD-ONLY, high compatibility) for Fabric 1.21.1.
 *
 * Core rules enforced:
 * - ENDERITE scrap/ingot ONLY in THE END (end city / end chests).
 * - HOT_CARBON_STEEL_SCRAP NEVER appears in loot (not used anywhere).
 * - Dungeons/mineshafts: CARBON_STEEL_SCRAP common-ish, OBSIDIAN_SCRAP very rare.
 * - Obsidian is Nether + (very rare) Overworld treasure. Obsidian scrap is rarer than adamantium.
 * - Adamantium ingot is rare overworld treasure (rarer than diamond vibe, but not absurd).
 * - Pies mostly in villages (and mansion), NOT in dungeons/mineshafts.
 * - Lemons can appear in dungeons/mineshafts (low) since apples/carrots can.
 * - Inject ONLY Cipher + Sweet Caroline discs (vanilla discs still possible).
 *
 * Stack variety:
 * - Dusts and nuggets use SetCount (real stack sizes) so you get 2–6 nuggets / 2–5 dust in ONE slot.
 * - Duck meats/eggs also use SetCount so you see small stacks (1–3 meat, 1–2 eggs).
 *
 * Tier split:
 * EARLY (metals): tin, copper, bronze, silver, sterling silver, carbon steel, cobalt (+ rose gold)
 * MID: amethyst, lapis lazuli, onyx, citrine, turquoise, topaz, tourmaline, tanzanite
 * LATE: ruby, sapphire, spinel, moissanite + obsidian/adamantium/hardened ingots
 * SUPER RARE: enderite (end-only)
 *
 * Stronghold library improvements:
 * - Treat STRONGHOLD_LIBRARY as a special chest category.
 * - Push cobalt/rose_gold out of library “treasure feel” and bias toward mid/late gems + late ingots (NO enderite).
 * - Ensure mores loot shows up reliably (very high injection chances + a tiny “safety net” pool).
 * - Stronghold horse armor is biased toward mid/late (lapis/spinel/sapphire/ruby/obsidian/adamantium/etc).
 *
 * NOTE on blocks & alloy furnace:
 * - Diamond blocks basically don’t spawn as vanilla chest loot; “block treasure” usually feels weird as loot.
 *   Gem blocks + machines fit better as worldgen/structure placement (or boss rewards / special structures).
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
    // FOODS (mod-only)
    // -------------------------------------------------------------------------

    private static final Item[] PIES = new Item[]{
            ModItems.APPLE_PIE,
            ModItems.CARROT_PIE,
            ModItems.LEMON_PIE,
            ModItems.SWEET_BERRY_PIE,
            ModItems.VELVET
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

    private static final Item[] DUCK_MEATS = new Item[]{
            ModItems.RAW_DUCK,
            ModItems.COOKED_DUCK
    };

    private static final Item DUCK_EGG = ModItems.DUCK_EGG;

    // Special foods
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
    // -------------------------------------------------------------------------

    private static final Item TEMPLATE_HARDENED = ModItems.HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE;
    private static final Item TEMPLATE_OBSIDIAN = ModItems.OBSIDIAN_UPGRADE_SMITHING_TEMPLATE;
    private static final Item TEMPLATE_ADAMANTIUM = ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE;
    private static final Item TEMPLATE_ENDERITE = ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE;

    // -------------------------------------------------------------------------
    // MATERIALS (split tiers)
    // -------------------------------------------------------------------------

    // EARLY metals
    private static final Item[] EARLY_INGOTS = new Item[]{
            ModItems.TIN_INGOT,
            ModItems.BRONZE_INGOT,
            ModItems.SILVER_INGOT,
            ModItems.STERLING_SILVER_INGOT,
            ModItems.CARBON_STEEL_INGOT,
            ModItems.COBALT_INGOT,
            ModItems.ROSE_GOLD_INGOT
    };

    private static final Item[] EARLY_RAW = new Item[]{
            ModItems.RAW_TIN,
            ModItems.RAW_SILVER,
            ModItems.RAW_COBALT
    };

    private static final Item[] EARLY_NUGGETS = new Item[]{
            ModItems.TIN_NUGGET,
            ModItems.COPPER_NUGGET,
            ModItems.BRONZE_NUGGET,
            ModItems.SILVER_NUGGET,
            ModItems.STERLING_SILVER_NUGGET,
            ModItems.COBALT_NUGGET,
            ModItems.ROSE_GOLD_NUGGET,
            ModItems.CARBON_STEEL_NUGGET,
            ModItems.HARDENED_STEEL_NUGGET
    };

    // MID gems + dusts
    private static final Item[] MID_GEMS = new Item[]{
            ModItems.AMETHYST_GEM,
            ModItems.LAPIS_LAZULI_GEM,
            ModItems.ONYX_GEM,
            ModItems.CITRINE_GEM,
            ModItems.TURQUOISE_GEM,
            ModItems.TOPAZ_GEM,
            ModItems.TOURMALINE_GEM,
            ModItems.TANZANITE_GEM
    };

    private static final Item[] MID_DUSTS = new Item[]{
            ModItems.QUARTZ_DUST,
            ModItems.LAPIS_LAZULI_DUST,
            ModItems.AMETHYST_DUST,
            ModItems.TURQUOISE_DUST
    };

    // LATE gems/metals
    private static final Item[] LATE_GEMS = new Item[]{
            ModItems.RUBY_GEM,
            ModItems.SAPPHIRE_GEM,
            ModItems.SPINEL_GEM,
            ModItems.MOISSANITE_GEM
    };

    private static final Item OBSIDIAN_INGOT = ModItems.OBSIDIAN_INGOT;
    private static final Item ADAMANTIUM_INGOT = ModItems.ADAMANTIUM_INGOT;
    private static final Item HARDENED_STEEL_INGOT = ModItems.HARDENED_STEEL_INGOT;

    // End-only
    private static final Item ENDERITE_INGOT = ModItems.ENDERITE_INGOT;
    private static final Item ENDERITE_SCRAP = ModItems.ENDERITE_SCRAP;

    // Scraps (strict by context; HOT_CARBON_STEEL_SCRAP intentionally unused)
    private static final Item CARBON_STEEL_SCRAP = ModItems.CARBON_STEEL_SCRAP;
    private static final Item OBSIDIAN_SCRAP = ModItems.OBSIDIAN_SCRAP;

    private static final Item ANTHRACITE = ModItems.ANTHRACITE;

    // -------------------------------------------------------------------------
    // GEAR TIERS (weapons/tools + armor + shields + horse/wolf armor)
    // -------------------------------------------------------------------------

    // EARLY METAL GEAR (includes special weapons too)
    private static final Item[] EARLY_TOOLS = new Item[]{
            // Tin
            ModItems.TIN_SWORD, ModItems.TIN_PICKAXE, ModItems.TIN_AXE, ModItems.TIN_SHOVEL, ModItems.TIN_HOE,
            ModItems.TIN_BATTLE_AXE, ModItems.TIN_BATTLE_MACE, ModItems.TIN_DAGGER,

            // Copper
            ModItems.COPPER_SWORD, ModItems.COPPER_PICKAXE, ModItems.COPPER_AXE, ModItems.COPPER_SHOVEL, ModItems.COPPER_HOE,
            ModItems.COPPER_BATTLE_AXE, ModItems.COPPER_BATTLE_MACE, ModItems.COPPER_DAGGER,

            // Bronze
            ModItems.BRONZE_SWORD, ModItems.BRONZE_PICKAXE, ModItems.BRONZE_AXE, ModItems.BRONZE_SHOVEL, ModItems.BRONZE_HOE,
            ModItems.BRONZE_BATTLE_AXE, ModItems.BRONZE_BATTLE_MACE, ModItems.BRONZE_DAGGER,

            // Silver
            ModItems.SILVER_SWORD, ModItems.SILVER_PICKAXE, ModItems.SILVER_AXE, ModItems.SILVER_SHOVEL, ModItems.SILVER_HOE,
            ModItems.SILVER_BATTLE_AXE, ModItems.SILVER_BATTLE_MACE, ModItems.SILVER_DAGGER,

            // Sterling Silver
            ModItems.STERLING_SILVER_SWORD, ModItems.STERLING_SILVER_PICKAXE, ModItems.STERLING_SILVER_AXE, ModItems.STERLING_SILVER_SHOVEL, ModItems.STERLING_SILVER_HOE,
            ModItems.STERLING_SILVER_BATTLE_AXE, ModItems.STERLING_SILVER_BATTLE_MACE, ModItems.STERLING_SILVER_DAGGER,

            // Carbon Steel
            ModItems.CARBON_STEEL_SWORD, ModItems.CARBON_STEEL_PICKAXE, ModItems.CARBON_STEEL_AXE, ModItems.CARBON_STEEL_SHOVEL, ModItems.CARBON_STEEL_HOE,
            ModItems.CARBON_STEEL_BATTLE_AXE, ModItems.CARBON_STEEL_BATTLE_MACE, ModItems.CARBON_STEEL_DAGGER,

            // Cobalt
            ModItems.COBALT_SWORD, ModItems.COBALT_PICKAXE, ModItems.COBALT_AXE, ModItems.COBALT_SHOVEL, ModItems.COBALT_HOE,
            ModItems.COBALT_BATTLE_AXE, ModItems.COBALT_BATTLE_MACE, ModItems.COBALT_DAGGER,

            // Rose Gold
            ModItems.ROSE_GOLD_SWORD, ModItems.ROSE_GOLD_PICKAXE, ModItems.ROSE_GOLD_AXE, ModItems.ROSE_GOLD_SHOVEL, ModItems.ROSE_GOLD_HOE,
            ModItems.ROSE_GOLD_BATTLE_AXE, ModItems.ROSE_GOLD_BATTLE_MACE, ModItems.ROSE_GOLD_DAGGER
    };

    private static final Item[] EARLY_ARMOR = new Item[]{
            ModItems.TIN_HELMET, ModItems.TIN_CHESTPLATE, ModItems.TIN_LEGGINGS, ModItems.TIN_BOOTS,
            ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS,
            ModItems.BRONZE_HELMET, ModItems.BRONZE_CHESTPLATE, ModItems.BRONZE_LEGGINGS, ModItems.BRONZE_BOOTS,
            ModItems.SILVER_HELMET, ModItems.SILVER_CHESTPLATE, ModItems.SILVER_LEGGINGS, ModItems.SILVER_BOOTS,
            ModItems.STERLING_SILVER_HELMET, ModItems.STERLING_SILVER_CHESTPLATE, ModItems.STERLING_SILVER_LEGGINGS, ModItems.STERLING_SILVER_BOOTS,
            ModItems.CARBON_STEEL_HELMET, ModItems.CARBON_STEEL_CHESTPLATE, ModItems.CARBON_STEEL_LEGGINGS, ModItems.CARBON_STEEL_BOOTS,
            ModItems.COBALT_HELMET, ModItems.COBALT_CHESTPLATE, ModItems.COBALT_LEGGINGS, ModItems.COBALT_BOOTS,
            ModItems.ROSE_GOLD_HELMET, ModItems.ROSE_GOLD_CHESTPLATE, ModItems.ROSE_GOLD_LEGGINGS, ModItems.ROSE_GOLD_BOOTS
    };

    private static final Item[] EARLY_SHIELDS = new Item[]{
            ModItems.TIN_SHIELD, ModItems.COPPER_SHIELD, ModItems.BRONZE_SHIELD,
            ModItems.SILVER_SHIELD, ModItems.STERLING_SILVER_SHIELD, ModItems.CARBON_STEEL_SHIELD, ModItems.COBALT_SHIELD, ModItems.ROSE_GOLD_SHIELD
    };

    // MID GEM GEAR
    private static final Item[] MID_TOOLS = new Item[]{
            ModItems.AMETHYST_SWORD, ModItems.AMETHYST_PICKAXE, ModItems.AMETHYST_AXE, ModItems.AMETHYST_SHOVEL, ModItems.AMETHYST_HOE,
            ModItems.AMETHYST_BATTLE_AXE, ModItems.AMETHYST_BATTLE_MACE, ModItems.AMETHYST_DAGGER,

            ModItems.LAPIS_LAZULI_SWORD, ModItems.LAPIS_LAZULI_PICKAXE, ModItems.LAPIS_LAZULI_AXE, ModItems.LAPIS_LAZULI_SHOVEL, ModItems.LAPIS_LAZULI_HOE,
            ModItems.LAPIS_LAZULI_BATTLE_AXE, ModItems.LAPIS_LAZULI_BATTLE_MACE, ModItems.LAPIS_LAZULI_DAGGER,

            ModItems.ONYX_SWORD, ModItems.ONYX_PICKAXE, ModItems.ONYX_AXE, ModItems.ONYX_SHOVEL, ModItems.ONYX_HOE,
            ModItems.ONYX_BATTLE_AXE, ModItems.ONYX_BATTLE_MACE, ModItems.ONYX_DAGGER,

            ModItems.CITRINE_SWORD, ModItems.CITRINE_PICKAXE, ModItems.CITRINE_AXE, ModItems.CITRINE_SHOVEL, ModItems.CITRINE_HOE,
            ModItems.CITRINE_BATTLE_AXE, ModItems.CITRINE_BATTLE_MACE, ModItems.CITRINE_DAGGER,

            ModItems.TURQUOISE_SWORD, ModItems.TURQUOISE_PICKAXE, ModItems.TURQUOISE_AXE, ModItems.TURQUOISE_SHOVEL, ModItems.TURQUOISE_HOE,
            ModItems.TURQUOISE_BATTLE_AXE, ModItems.TURQUOISE_BATTLE_MACE, ModItems.TURQUOISE_DAGGER,

            ModItems.TOPAZ_SWORD, ModItems.TOPAZ_PICKAXE, ModItems.TOPAZ_AXE, ModItems.TOPAZ_SHOVEL, ModItems.TOPAZ_HOE,
            ModItems.TOPAZ_BATTLE_AXE, ModItems.TOPAZ_BATTLE_MACE, ModItems.TOPAZ_DAGGER,

            ModItems.TOURMALINE_SWORD, ModItems.TOURMALINE_PICKAXE, ModItems.TOURMALINE_AXE, ModItems.TOURMALINE_SHOVEL, ModItems.TOURMALINE_HOE,
            ModItems.TOURMALINE_BATTLE_AXE, ModItems.TOURMALINE_BATTLE_MACE, ModItems.TOURMALINE_DAGGER,

            ModItems.TANZANITE_SWORD, ModItems.TANZANITE_PICKAXE, ModItems.TANZANITE_AXE, ModItems.TANZANITE_SHOVEL, ModItems.TANZANITE_HOE,
            ModItems.TANZANITE_BATTLE_AXE, ModItems.TANZANITE_BATTLE_MACE, ModItems.TANZANITE_DAGGER
    };

    private static final Item[] MID_ARMOR = new Item[]{
            ModItems.AMETHYST_HELMET, ModItems.AMETHYST_CHESTPLATE, ModItems.AMETHYST_LEGGINGS, ModItems.AMETHYST_BOOTS,
            ModItems.LAPIS_LAZULI_HELMET, ModItems.LAPIS_LAZULI_CHESTPLATE, ModItems.LAPIS_LAZULI_LEGGINGS, ModItems.LAPIS_LAZULI_BOOTS,
            ModItems.ONYX_HELMET, ModItems.ONYX_CHESTPLATE, ModItems.ONYX_LEGGINGS, ModItems.ONYX_BOOTS,
            ModItems.CITRINE_HELMET, ModItems.CITRINE_CHESTPLATE, ModItems.CITRINE_LEGGINGS, ModItems.CITRINE_BOOTS,
            ModItems.TURQUOISE_HELMET, ModItems.TURQUOISE_CHESTPLATE, ModItems.TURQUOISE_LEGGINGS, ModItems.TURQUOISE_BOOTS,
            ModItems.TOPAZ_HELMET, ModItems.TOPAZ_CHESTPLATE, ModItems.TOPAZ_LEGGINGS, ModItems.TOPAZ_BOOTS,
            ModItems.TOURMALINE_HELMET, ModItems.TOURMALINE_CHESTPLATE, ModItems.TOURMALINE_LEGGINGS, ModItems.TOURMALINE_BOOTS,
            ModItems.TANZANITE_HELMET, ModItems.TANZANITE_CHESTPLATE, ModItems.TANZANITE_LEGGINGS, ModItems.TANZANITE_BOOTS
    };

    private static final Item[] MID_SHIELDS = new Item[]{
            ModItems.AMETHYST_SHIELD,
            ModItems.LAPIS_LAZULI_SHIELD,
            ModItems.ONYX_SHIELD,
            ModItems.CITRINE_SHIELD,
            ModItems.TURQUOISE_SHIELD,
            ModItems.TOPAZ_SHIELD,
            ModItems.TOURMALINE_SHIELD,
            ModItems.TANZANITE_SHIELD
    };

    // LATE GEAR
    private static final Item[] LATE_TOOLS = new Item[]{
            ModItems.RUBY_SWORD, ModItems.RUBY_PICKAXE, ModItems.RUBY_AXE, ModItems.RUBY_SHOVEL, ModItems.RUBY_HOE,
            ModItems.RUBY_BATTLE_AXE, ModItems.RUBY_BATTLE_MACE, ModItems.RUBY_DAGGER,

            ModItems.SAPPHIRE_SWORD, ModItems.SAPPHIRE_PICKAXE, ModItems.SAPPHIRE_AXE, ModItems.SAPPHIRE_SHOVEL, ModItems.SAPPHIRE_HOE,
            ModItems.SAPPHIRE_BATTLE_AXE, ModItems.SAPPHIRE_BATTLE_MACE, ModItems.SAPPHIRE_DAGGER,

            ModItems.SPINEL_SWORD, ModItems.SPINEL_PICKAXE, ModItems.SPINEL_AXE, ModItems.SPINEL_SHOVEL, ModItems.SPINEL_HOE,
            ModItems.SPINEL_BATTLE_AXE, ModItems.SPINEL_BATTLE_MACE, ModItems.SPINEL_DAGGER,

            ModItems.MOISSANITE_SWORD, ModItems.MOISSANITE_PICKAXE, ModItems.MOISSANITE_AXE, ModItems.MOISSANITE_SHOVEL, ModItems.MOISSANITE_HOE,
            ModItems.MOISSANITE_BATTLE_AXE, ModItems.MOISSANITE_BATTLE_MACE, ModItems.MOISSANITE_DAGGER,

            ModItems.OBSIDIAN_SWORD, ModItems.OBSIDIAN_PICKAXE, ModItems.OBSIDIAN_AXE, ModItems.OBSIDIAN_SHOVEL, ModItems.OBSIDIAN_HOE,
            ModItems.OBSIDIAN_BATTLE_AXE, ModItems.OBSIDIAN_BATTLE_MACE, ModItems.OBSIDIAN_DAGGER,

            ModItems.ADAMANTIUM_SWORD, ModItems.ADAMANTIUM_PICKAXE, ModItems.ADAMANTIUM_AXE, ModItems.ADAMANTIUM_SHOVEL, ModItems.ADAMANTIUM_HOE,
            ModItems.ADAMANTIUM_BATTLE_AXE, ModItems.ADAMANTIUM_BATTLE_MACE, ModItems.ADAMANTIUM_DAGGER,

            ModItems.HARDENED_STEEL_SWORD, ModItems.HARDENED_STEEL_PICKAXE, ModItems.HARDENED_STEEL_AXE, ModItems.HARDENED_STEEL_SHOVEL, ModItems.HARDENED_STEEL_HOE
    };

    private static final Item[] LATE_ARMOR = new Item[]{
            ModItems.RUBY_HELMET, ModItems.RUBY_CHESTPLATE, ModItems.RUBY_LEGGINGS, ModItems.RUBY_BOOTS,
            ModItems.SAPPHIRE_HELMET, ModItems.SAPPHIRE_CHESTPLATE, ModItems.SAPPHIRE_LEGGINGS, ModItems.SAPPHIRE_BOOTS,
            ModItems.SPINEL_HELMET, ModItems.SPINEL_CHESTPLATE, ModItems.SPINEL_LEGGINGS, ModItems.SPINEL_BOOTS,
            ModItems.MOISSANITE_HELMET, ModItems.MOISSANITE_CHESTPLATE, ModItems.MOISSANITE_LEGGINGS, ModItems.MOISSANITE_BOOTS,
            ModItems.OBSIDIAN_HELMET, ModItems.OBSIDIAN_CHESTPLATE, ModItems.OBSIDIAN_LEGGINGS, ModItems.OBSIDIAN_BOOTS,
            ModItems.ADAMANTIUM_HELMET, ModItems.ADAMANTIUM_CHESTPLATE, ModItems.ADAMANTIUM_LEGGINGS, ModItems.ADAMANTIUM_BOOTS,
            ModItems.HARDENED_STEEL_HELMET, ModItems.HARDENED_STEEL_CHESTPLATE, ModItems.HARDENED_STEEL_LEGGINGS, ModItems.HARDENED_STEEL_BOOTS
    };

    private static final Item[] LATE_SHIELDS = new Item[]{
            ModItems.RUBY_SHIELD,
            ModItems.SAPPHIRE_SHIELD,
            ModItems.SPINEL_SHIELD,
            ModItems.MOISSANITE_SHIELD,
            ModItems.OBSIDIAN_SHIELD,
            ModItems.ADAMANTIUM_SHIELD,
            ModItems.HARDENED_STEEL_SHIELD
    };

    // SUPER RARE (End-only)
    private static final Item[] ENDERITE_TOOLS = new Item[]{
            ModItems.ENDERITE_SWORD, ModItems.ENDERITE_PICKAXE, ModItems.ENDERITE_AXE, ModItems.ENDERITE_SHOVEL, ModItems.ENDERITE_HOE,
            ModItems.ENDERITE_BATTLE_AXE, ModItems.ENDERITE_BATTLE_MACE, ModItems.ENDERITE_DAGGER
    };

    private static final Item[] ENDERITE_ARMOR = new Item[]{
            ModItems.ENDERITE_HELMET, ModItems.ENDERITE_CHESTPLATE, ModItems.ENDERITE_LEGGINGS, ModItems.ENDERITE_BOOTS
    };

    private static final Item[] ENDERITE_SHIELDS = new Item[]{
            ModItems.ENDERITE_SHIELD
    };

    // Horse armor (tiered)
    private static final Item[] EARLY_HORSE_ARMOR = new Item[]{
            ModItems.TIN_HORSE_ARMOR,
            ModItems.COPPER_HORSE_ARMOR,
            ModItems.BRONZE_HORSE_ARMOR,
            ModItems.SILVER_HORSE_ARMOR,
            ModItems.STERLING_SILVER_HORSE_ARMOR,
            ModItems.COBALT_HORSE_ARMOR,
            ModItems.CARBON_STEEL_HORSE_ARMOR,
            ModItems.ROSE_GOLD_HORSE_ARMOR
    };

    private static final Item[] MID_HORSE_ARMOR = new Item[]{
            ModItems.AMETHYST_HORSE_ARMOR,
            ModItems.LAPIS_LAZULI_HORSE_ARMOR,
            ModItems.ONYX_HORSE_ARMOR,
            ModItems.CITRINE_HORSE_ARMOR,
            ModItems.TURQUOISE_HORSE_ARMOR,
            ModItems.TOPAZ_HORSE_ARMOR,
            ModItems.TOURMALINE_HORSE_ARMOR,
            ModItems.TANZANITE_HORSE_ARMOR
    };

    private static final Item[] LATE_HORSE_ARMOR = new Item[]{
            ModItems.RUBY_HORSE_ARMOR,
            ModItems.SAPPHIRE_HORSE_ARMOR,
            ModItems.SPINEL_HORSE_ARMOR,
            ModItems.MOISSANITE_HORSE_ARMOR,
            ModItems.OBSIDIAN_HORSE_ARMOR,
            ModItems.ADAMANTIUM_HORSE_ARMOR,
            ModItems.HARDENED_STEEL_HORSE_ARMOR
            // If you *also* have EMERALD_HORSE_ARMOR in ModItems and want it here, add it above.
    };

    private static final Item[] ENDERITE_HORSE_ARMOR = new Item[]{
            ModItems.ENDERITE_HORSE_ARMOR
    };

    // Wolf armor
    private static final Item[] WOLF_ARMOR_ALL = new Item[]{
            ModItems.TIN_WOLF_ARMOR,
            ModItems.COPPER_WOLF_ARMOR,
            ModItems.BRONZE_WOLF_ARMOR,
            ModItems.SILVER_WOLF_ARMOR,
            ModItems.STERLING_SILVER_WOLF_ARMOR,
            ModItems.ROSE_GOLD_WOLF_ARMOR,
            ModItems.COBALT_WOLF_ARMOR,
            ModItems.CARBON_STEEL_WOLF_ARMOR,
            ModItems.HARDENED_STEEL_WOLF_ARMOR,
            ModItems.GOLD_WOLF_ARMOR,
            ModItems.IRON_WOLF_ARMOR,
            ModItems.DIAMOND_WOLF_ARMOR
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

                // -----------------------------------------------------------------
                // VILLAGES (all variants)
                // -----------------------------------------------------------------
                case VILLAGE -> {
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.50f, 0.28f, 0.10f, 1, 1);

                    addGear(tableBuilder, MID_TOOLS, MID_ARMOR, MID_SHIELDS,
                            0.10f, 0.05f, 0.02f, 1, 1);

                    // Horse/wolf armor slightly increased (tiny bump)
                    addHorseArmor(tableBuilder, EARLY_HORSE_ARMOR, 0.12f);
                    addWolfArmor(tableBuilder, 0.06f);

                    // Foods
                    addPies(tableBuilder, 0.72f, 1, 2);

                    if (isOaky(path)) addSimpleItems(tableBuilder, LEMONS_OAKY, 0.26f, 1, 2, WeightProfile.FLAT);
                    if (isJungle(path)) addSimpleItems(tableBuilder, CHOCOLATES, 0.18f, 1, 2, WeightProfile.FLAT);

                    // Duck: villages/plains/river vibes -> small bump in villages
                    addDuckLoot(tableBuilder, 0.18f, 0.10f);

                    addSpecialFoods(tableBuilder,
                            0.10f,
                            0.07f,
                            0.0012f
                    );

                    addEarlyMaterials(tableBuilder, path, 0.80f);
                    addMidMaterials(tableBuilder, path, 0.18f);
                    addLateMaterials(tableBuilder, path, 0.035f);
                }

                // -----------------------------------------------------------------
                // STRONGHOLD LIBRARY (special: make it feel late-game / treasurey)
                // -----------------------------------------------------------------
                case STRONGHOLD_LIBRARY -> {
                    // Keep some gear, but bias upward a bit
                    addGear(tableBuilder, MID_TOOLS, MID_ARMOR, MID_SHIELDS,
                            0.10f, 0.05f, 0.02f, 1, 1);

                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.08f, 0.04f, 0.02f, 1, 1);

                    // Horse armor: library should have “better” finds
                    addHorseArmor(tableBuilder, MID_HORSE_ARMOR, 0.06f);
                    addHorseArmor(tableBuilder, LATE_HORSE_ARMOR, 0.05f);

                    addWolfArmor(tableBuilder, 0.05f);

                    // Food: no pies here; light lemon; duck light
                    addSimpleItems(tableBuilder, DUNGEON_LEMONS, 0.08f, 1, 1, WeightProfile.FLAT);
                    addDuckLoot(tableBuilder, 0.12f, 0.06f);

                    // Specials: same “golden apple-ish” vibe; enchanted extremely rare
                    addSpecialFoods(tableBuilder,
                            0.12f,
                            0.10f,
                            0.0022f
                    );

                    // Discs: a library is a fine place for rare discs
                    addDiscs(tableBuilder, 0.08f);

                    // Materials:
                    // - Reduce EARLY (no “cobalt/rose gold spam”)
                    // - Increase MID gems/dusts
                    // - Increase LATE treasure (obsidian/hardened/adamantium + ruby/sapphire/spinel/moissanite)
                    addEarlyMaterialsLow(tableBuilder, path, 0.35f);
                    addMidMaterials(tableBuilder, path, 0.78f);
                    addLateMaterials(tableBuilder, path, 0.18f);

                    // Extra “library treasure” pool: gems + late ingots, very high chance
                    addStrongholdLibraryTreasure(tableBuilder, 0.90f);

                    // Anthracite: okay as a small extra
                    addAnthracite(tableBuilder, 0.20f);

                    // Scraps: still strict (no enderite); obsidian scrap stays very rare
                    addDungeonScrapsStrict(tableBuilder, 0.42f);

                    // Safety net: ensure at least *some* mores item appears most of the time.
                    // (Add-only can’t guarantee per chest 100%, but this makes “no mores loot” extremely unlikely.)
                    addMoresSafetyNet(tableBuilder, 0.85f);
                }

                // -----------------------------------------------------------------
                // DUNGEON / MINESHAFT / STRONGHOLD (non-library) / IGLOO / RUINS / SHIPWRECK / TREASURE
                // -----------------------------------------------------------------
                case DUNGEON_MINESHAFT, STRONGHOLD, IGLOO, RUINED_PORTAL_OVERWORLD, UNDERWATER_RUIN, SHIPWRECK, BURIED_TREASURE -> {

                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.34f, 0.16f, 0.07f, 1, 1);

                    addGear(tableBuilder, MID_TOOLS, MID_ARMOR, MID_SHIELDS,
                            0.07f, 0.03f, 0.015f, 1, 1);

                    float lateGearChance = (cat == ChestCategory.BURIED_TREASURE) ? 0.06f : 0.02f;
                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            lateGearChance, lateGearChance * 0.45f, lateGearChance * 0.25f, 1, 1);

                    // Horse armor slightly increased (tiny bump)
                    addHorseArmor(tableBuilder, EARLY_HORSE_ARMOR, 0.06f);
                    addHorseArmor(tableBuilder, MID_HORSE_ARMOR, (cat == ChestCategory.BURIED_TREASURE) ? 0.03f : 0.02f);

                    addWolfArmor(tableBuilder, 0.04f);

                    // Foods: NO pies here. Lemons low.
                    addSimpleItems(tableBuilder, DUNGEON_LEMONS, 0.10f, 1, 1, WeightProfile.FLAT);

                    // Duck: dungeons/ruins occasionally
                    addDuckLoot(tableBuilder, 0.16f, 0.08f);

                    addSpecialFoods(tableBuilder,
                            0.14f,
                            0.10f,
                            0.0020f
                    );

                    addDiscs(tableBuilder, 0.06f);

                    addEarlyMaterials(tableBuilder, path, 0.78f);
                    addMidMaterials(tableBuilder, path, 0.42f);
                    addLateMaterials(tableBuilder, path, 0.055f);

                    addAnthracite(tableBuilder, 0.28f);

                    addDungeonScrapsStrict(tableBuilder, 0.56f);

                    // Very rare hardened ingot treasure (fits “rare steel parts”)
                    addVeryRareHardenedIngotTreasure(tableBuilder, 0.010f);
                }

                // -----------------------------------------------------------------
                // TEMPLE / PYRAMID / OUTPOST / MANSION
                // -----------------------------------------------------------------
                case TEMPLE_PYRAMID, OUTPOST, MANSION -> {

                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.44f, 0.22f, 0.10f, 1, 1);

                    addGear(tableBuilder, MID_TOOLS, MID_ARMOR, MID_SHIELDS,
                            0.16f, 0.08f, 0.04f, 1, 1);

                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.06f, 0.03f, 0.015f, 1, 1);

                    // Horse armor: slight bump, these places feel “treasure-y”
                    addHorseArmor(tableBuilder, EARLY_HORSE_ARMOR, 0.10f);
                    addHorseArmor(tableBuilder, MID_HORSE_ARMOR, 0.05f);
                    addHorseArmor(tableBuilder, LATE_HORSE_ARMOR, (cat == ChestCategory.MANSION) ? 0.03f : 0.02f);

                    addWolfArmor(tableBuilder, 0.06f);

                    float pieChance = (cat == ChestCategory.MANSION) ? 0.28f : 0.14f;
                    addPies(tableBuilder, pieChance, 1, (cat == ChestCategory.MANSION) ? 2 : 1);

                    if (isJungle(path)) addSimpleItems(tableBuilder, CHOCOLATES, 0.24f, 1, 2, WeightProfile.FLAT);
                    if (isOaky(path)) addSimpleItems(tableBuilder, LEMONS_OAKY, 0.12f, 1, 2, WeightProfile.FLAT);

                    // Duck: outposts/camps/mansions sometimes
                    addDuckLoot(tableBuilder, 0.18f, 0.10f);

                    addSpecialFoods(tableBuilder,
                            0.10f,
                            0.08f,
                            0.0020f
                    );

                    addDiscs(tableBuilder, 0.04f);

                    addEarlyMaterials(tableBuilder, path, 0.80f);
                    addMidMaterials(tableBuilder, path, 0.32f);
                    addLateMaterials(tableBuilder, path, 0.085f);

                    addTemplatesOverworldRich(tableBuilder, 0.06f);
                }

                // -----------------------------------------------------------------
                // NETHER structures
                // -----------------------------------------------------------------
                case NETHER -> {

                    addGear(tableBuilder, MID_TOOLS, MID_ARMOR, MID_SHIELDS,
                            0.10f, 0.05f, 0.02f, 1, 1);

                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.46f, 0.24f, 0.12f, 1, 1);

                    addHorseArmor(tableBuilder, LATE_HORSE_ARMOR, 0.07f);
                    addWolfArmor(tableBuilder, 0.04f);

                    // Duck minimal in nether
                    addDuckLoot(tableBuilder, 0.05f, 0.00f);

                    addSpecialFoods(tableBuilder,
                            0.08f,
                            0.06f,
                            0.0018f
                    );

                    addDiscs(tableBuilder, 0.05f);

                    addEarlyMaterials(tableBuilder, path, 0.48f);
                    addMidMaterials(tableBuilder, path, 0.34f);
                    addLateMaterials(tableBuilder, path, 0.12f);

                    addNetherScrapsStrict(tableBuilder, 0.74f);
                    addTemplatesNether(tableBuilder, 0.22f);
                }

                // -----------------------------------------------------------------
                // END (End City treasure)
                // -----------------------------------------------------------------
                case END_CITY -> {

                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.56f, 0.30f, 0.14f, 1, 1);

                    addGear(tableBuilder, ENDERITE_TOOLS, ENDERITE_ARMOR, ENDERITE_SHIELDS,
                            0.08f, 0.04f, 0.02f, 1, 1);

                    addHorseArmor(tableBuilder, LATE_HORSE_ARMOR, 0.07f);
                    addHorseArmor(tableBuilder, ENDERITE_HORSE_ARMOR, 0.02f);

                    addWolfArmor(tableBuilder, 0.05f);

                    addSpecialFoods(tableBuilder,
                            0.10f,
                            0.08f,
                            0.0025f
                    );

                    addDiscs(tableBuilder, 0.05f);

                    addEarlyMaterials(tableBuilder, path, 0.30f);
                    addMidMaterials(tableBuilder, path, 0.22f);
                    addLateMaterials(tableBuilder, path, 0.16f);

                    addEnderiteOnly(tableBuilder, 0.28f);
                    addTemplatesEnd(tableBuilder, 0.32f);
                }

                // -----------------------------------------------------------------
                // Generic: very light touch
                // -----------------------------------------------------------------
                case GENERIC -> {

                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.10f, 0.05f, 0.02f, 1, 1);

                    addHorseArmor(tableBuilder, EARLY_HORSE_ARMOR, 0.03f);
                    addWolfArmor(tableBuilder, 0.02f);

                    addPies(tableBuilder, 0.08f, 1, 1);
                    addDuckLoot(tableBuilder, 0.06f, 0.03f);

                    addSpecialFoods(tableBuilder, 0.05f, 0.04f, 0.0010f);

                    addEarlyMaterials(tableBuilder, path, 0.14f);
                    addMidMaterials(tableBuilder, path, 0.06f);
                    addLateMaterials(tableBuilder, path, 0.015f);

                    addDiscs(tableBuilder, 0.01f);
                }
            }
        });
    }

    // -------------------------------------------------------------------------
    // CHEST CATEGORY DETECTION (broader vanilla coverage + stronghold library)
    // -------------------------------------------------------------------------

    private enum ChestCategory {
        VILLAGE,
        STRONGHOLD_LIBRARY,
        DUNGEON_MINESHAFT,
        STRONGHOLD,
        IGLOO,
        TEMPLE_PYRAMID,
        OUTPOST,
        MANSION,
        SHIPWRECK,
        UNDERWATER_RUIN,
        BURIED_TREASURE,
        RUINED_PORTAL_OVERWORLD,
        NETHER,
        END_CITY,
        GENERIC
    }

    private static ChestCategory categorize(String path) {
        // END
        if (containsAny(path, "end_city", "endcity", "end_city_treasure")) return ChestCategory.END_CITY;

        // NETHER structures
        if (containsAny(path, "bastion", "nether", "fortress", "nether_bridge", "piglin", "ruined_portal/nether")) return ChestCategory.NETHER;

        // Stronghold library (special)
        if (containsAny(path, "stronghold_library", "stronghold/library")) return ChestCategory.STRONGHOLD_LIBRARY;

        // Stronghold other
        if (containsAny(path, "stronghold")) return ChestCategory.STRONGHOLD;

        // Dungeons/mineshafts
        if (containsAny(path, "abandoned_mineshaft", "mineshaft", "dungeon", "simple_dungeon", "spawner")) return ChestCategory.DUNGEON_MINESHAFT;

        // Igloo
        if (containsAny(path, "igloo")) return ChestCategory.IGLOO;

        // Temples / pyramids
        if (containsAny(path, "desert_pyramid", "pyramid", "jungle_temple", "temple")) return ChestCategory.TEMPLE_PYRAMID;

        // Outpost
        if (containsAny(path, "pillager_outpost", "outpost", "watchtower")) return ChestCategory.OUTPOST;

        // Mansion
        if (containsAny(path, "woodland_mansion", "mansion", "illager_mansion")) return ChestCategory.MANSION;

        // Shipwreck
        if (containsAny(path, "shipwreck")) return ChestCategory.SHIPWRECK;

        // Underwater ruins
        if (containsAny(path, "underwater_ruin", "ocean_ruin", "oceanruin")) return ChestCategory.UNDERWATER_RUIN;

        // Buried treasure
        if (containsAny(path, "buried_treasure")) return ChestCategory.BURIED_TREASURE;

        // Overworld ruined portals
        if (containsAny(path, "ruined_portal")) return ChestCategory.RUINED_PORTAL_OVERWORLD;

        // Villages
        if (containsAny(path, "village", "villages")) return ChestCategory.VILLAGE;

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
    // WEIGHTING
    // -------------------------------------------------------------------------

    private enum WeightProfile { TOOLS, ARMOR, FLAT }

    private static int weightFor(Item it, WeightProfile profile) {
        if (profile == WeightProfile.FLAT) return 10;

        String s = it.toString().toLowerCase(Locale.ROOT);

        if (profile == WeightProfile.TOOLS) {
            if (s.contains("pickaxe")) return 18;
            if (s.contains("sword")) return 16;

            if (s.contains("battle_mace")) return 12;
            if (s.contains("battle_axe")) return 12;
            if (s.contains("dagger")) return 11;

            if (s.contains("axe")) return 12;
            if (s.contains("shovel")) return 10;
            if (s.contains("hoe")) return 8;
            return 10;
        }

        if (s.contains("chestplate")) return 15;
        if (s.contains("leggings")) return 14;
        if (s.contains("helmet")) return 13;
        if (s.contains("boots")) return 12;
        return 12;
    }

    // -------------------------------------------------------------------------
    // POOL HELPERS
    // -------------------------------------------------------------------------

    private static LootPool.Builder weightedPool(Item[] items, float chance, int rollsMin, int rollsMax, WeightProfile profile) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(rollsMin == rollsMax
                        ? ConstantLootNumberProvider.create(rollsMin)
                        : UniformLootNumberProvider.create(rollsMin, rollsMax))
                .conditionally(RandomChanceLootCondition.builder(chance));

        for (Item it : items) pool.with(ItemEntry.builder(it).weight(weightFor(it, profile)));
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

    private static void addPies(net.minecraft.loot.LootTable.Builder tableBuilder, float chance, int rollsMin, int rollsMax) {
        tableBuilder.pool(weightedPool(PIES, chance, rollsMin, rollsMax, WeightProfile.FLAT));
    }

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

        tableBuilder.pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(silverCarrotChance))
                .with(ItemEntry.builder(SPECIAL_SILVER_CARROT).weight(10)));

        LootPool.Builder apples = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(applesChance));

        // Cobalt / Rose gold slightly rarer than silver / bronze
        apples.with(ItemEntry.builder(ModItems.SILVER_APPLE).weight(8));
        apples.with(ItemEntry.builder(ModItems.BRONZE_APPLE).weight(8));
        apples.with(ItemEntry.builder(ModItems.COBALT_APPLE).weight(5));
        apples.with(ItemEntry.builder(ModItems.ROSE_GOLD_APPLE).weight(5));
        tableBuilder.pool(apples);

        LootPool.Builder enchanted = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(enchantedApplesChance));

        enchanted.with(ItemEntry.builder(ModItems.ENCHANTED_COBALT_APPLE).weight(1));
        enchanted.with(ItemEntry.builder(ModItems.ENCHANTED_ROSE_GOLD_APPLE).weight(1));
        tableBuilder.pool(enchanted);
    }

    // -------------------------------------------------------------------------
    // DUCK LOOT (real stack sizes)
    // -------------------------------------------------------------------------

    private static void addDuckLoot(net.minecraft.loot.LootTable.Builder tableBuilder, float meatChance, float eggChance) {
        // Meat stacks: 1–3 in one slot
        LootPool.Builder meat = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(meatChance));

        meat.with(ItemEntry.builder(ModItems.RAW_DUCK)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)))
                .weight(6));
        meat.with(ItemEntry.builder(ModItems.COOKED_DUCK)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
                .weight(4));

        tableBuilder.pool(meat);

        // Eggs: 1–2 in one slot
        if (eggChance > 0.0f) {
            LootPool.Builder eggs = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(eggChance))
                    .with(ItemEntry.builder(DUCK_EGG)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)))
                            .weight(10));
            tableBuilder.pool(eggs);
        }
    }

    // -------------------------------------------------------------------------
    // HORSE / WOLF ARMOR
    // -------------------------------------------------------------------------

    private static void addHorseArmor(net.minecraft.loot.LootTable.Builder tableBuilder, Item[] horseArmor, float chance) {
        tableBuilder.pool(weightedPool(horseArmor, chance, 1, 1, WeightProfile.FLAT));
    }

    private static void addWolfArmor(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        tableBuilder.pool(weightedPool(WOLF_ARMOR_ALL, chance, 1, 1, WeightProfile.FLAT));
    }

    // -------------------------------------------------------------------------
    // MATERIALS (with real stack variety for nuggets/dusts)
    // -------------------------------------------------------------------------

    private static void addAnthracite(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        tableBuilder.pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance))
                .with(ItemEntry.builder(ANTHRACITE)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3)))
                        .weight(10)));
    }

    /**
     * Standard early materials:
     * - Metals/raw: 1–3 rolls (separate stacks)
     * - Nuggets: 1 stack with 2–6 count (less intrusive, fewer single-nugget slots)
     */
    private static void addEarlyMaterials(net.minecraft.loot.LootTable.Builder tableBuilder, String path, float chance) {
        // Ingots/raw: 1–3 picks
        LootPool.Builder metals = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 3))
                .conditionally(RandomChanceLootCondition.builder(chance));

        for (Item it : EARLY_INGOTS) metals.with(ItemEntry.builder(it).weight(10));
        for (Item it : EARLY_RAW) metals.with(ItemEntry.builder(it).weight(12));
        tableBuilder.pool(metals);

        // Nuggets: one slot, stack 2–6
        addStackedSingleSlot(tableBuilder, EARLY_NUGGETS, chance * 0.70f, 2, 6, 10);
    }

    /**
     * Stronghold library: reduce early “metal clutter” even more.
     */
    private static void addEarlyMaterialsLow(net.minecraft.loot.LootTable.Builder tableBuilder, String path, float chance) {
        LootPool.Builder metals = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Bias toward “useful” early metals if they appear
        for (Item it : EARLY_INGOTS) metals.with(ItemEntry.builder(it).weight(8));
        for (Item it : EARLY_RAW) metals.with(ItemEntry.builder(it).weight(10));
        tableBuilder.pool(metals);

        // Nuggets: rarer in library, but still stacky
        addStackedSingleSlot(tableBuilder, EARLY_NUGGETS, chance * 0.40f, 2, 5, 9);
    }

    private static void addMidMaterials(net.minecraft.loot.LootTable.Builder tableBuilder, String path, float chance) {
        // Gems: 1–2 rolls
        LootPool.Builder gems = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance));

        int gemWeight = containsAny(path, "dungeon", "mineshaft", "stronghold", "temple", "pyramid") ? 12 : 8;
        for (Item it : MID_GEMS) gems.with(ItemEntry.builder(it).weight(gemWeight));
        tableBuilder.pool(gems);

        // Dusts: one slot, stack 2–5
        addStackedSingleSlot(tableBuilder, MID_DUSTS, chance * 0.80f, 2, 5, 12);
    }

    private static void addLateMaterials(net.minecraft.loot.LootTable.Builder tableBuilder, String path, float chance) {
        // Late gems 1–2 (rolls), ingots very rare (weighted)
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance));

        int lateGemWeight = containsAny(path, "mansion", "stronghold", "temple", "pyramid", "buried_treasure") ? 8 : 5;
        for (Item it : LATE_GEMS) pool.with(ItemEntry.builder(it).weight(lateGemWeight));

        // Adamantium: rare; Obsidian: rarer; Hardened: rare-ish (steel focus)
        int rich = containsAny(path, "mansion", "stronghold", "temple", "pyramid", "buried_treasure") ? 3 : 2;

        pool.with(ItemEntry.builder(ADAMANTIUM_INGOT).weight(rich));  // rare
        pool.with(ItemEntry.builder(OBSIDIAN_INGOT).weight(1));       // rarer
        pool.with(ItemEntry.builder(HARDENED_STEEL_INGOT).weight(2)); // rare-ish

        tableBuilder.pool(pool);
    }

    /**
     * Stronghold library treasure:
     * - Mid gems (citrine/lapis/amethyst etc) and Late gems (spinel/sapphire/ruby/moissanite)
     * - Late ingots (hardened/adamantium/obsidian) present, but obsidian is the rarest of the three.
     *
     * This is intentionally “treasurey” and avoids pushing cobalt/rose_gold as the highlight.
     */
    private static void addStrongholdLibraryTreasure(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Mid gems (strong)
        for (Item it : MID_GEMS) pool.with(ItemEntry.builder(it).weight(12));

        // Late gems (stronger)
        for (Item it : LATE_GEMS) pool.with(ItemEntry.builder(it).weight(10));

        // Late ingots
        pool.with(ItemEntry.builder(HARDENED_STEEL_INGOT).weight(4));
        pool.with(ItemEntry.builder(ADAMANTIUM_INGOT).weight(3));
        pool.with(ItemEntry.builder(OBSIDIAN_INGOT).weight(2)); // slightly rarer than adamantium here too

        tableBuilder.pool(pool);

        // A little dust stack in libraries also feels okay (scrolls/arcane vibe)
        addStackedSingleSlot(tableBuilder, MID_DUSTS, chance * 0.55f, 2, 4, 10);
    }

    /**
     * Adds one item stack in a single slot with a SetCount range.
     * This is the key to avoiding “lots of single nuggets everywhere”.
     */
    private static void addStackedSingleSlot(net.minecraft.loot.LootTable.Builder tableBuilder,
                                             Item[] items,
                                             float chance,
                                             int minCount,
                                             int maxCount,
                                             int weightEach) {

        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance));

        for (Item it : items) {
            pool.with(ItemEntry.builder(it)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minCount, maxCount)))
                    .weight(weightEach));
        }

        tableBuilder.pool(pool);
    }

    // Enderite-only pool
    private static void addEnderiteOnly(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance));

        pool.with(ItemEntry.builder(ENDERITE_INGOT).weight(2));
        pool.with(ItemEntry.builder(ENDERITE_SCRAP).weight(2));

        tableBuilder.pool(pool);
    }

    /**
     * “Safety net” pool:
     * Adds 1 modest mores item with high chance to prevent “empty” looking chests in special places.
     * (Still add-only; cannot truly force 100% per-chest, but this makes misses very rare.)
     */
    private static void addMoresSafetyNet(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Pick from a small set that feels “stronghold library-ish”
        pool.with(ItemEntry.builder(ModItems.LAPIS_LAZULI_DUST)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 5)))
                .weight(10));
        pool.with(ItemEntry.builder(ModItems.AMETHYST_DUST)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2, 5)))
                .weight(10));
        pool.with(ItemEntry.builder(ModItems.LAPIS_LAZULI_GEM).weight(8));
        pool.with(ItemEntry.builder(ModItems.AMETHYST_GEM).weight(8));
        pool.with(ItemEntry.builder(ModItems.CITRINE_GEM).weight(6));
        pool.with(ItemEntry.builder(ModItems.SAPPHIRE_GEM).weight(4));
        pool.with(ItemEntry.builder(ModItems.SPINEL_GEM).weight(4));

        tableBuilder.pool(pool);
    }

    // -------------------------------------------------------------------------
    // SCRAPS (STRICT BY CONTEXT)
    // -------------------------------------------------------------------------

    private static void addDungeonScrapsStrict(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance));

        pool.with(ItemEntry.builder(CARBON_STEEL_SCRAP).weight(16));

        // Obsidian scrap very rare (rarer than adamantium)
        pool.with(ItemEntry.builder(OBSIDIAN_SCRAP).weight(1));

        // NEVER: enderite scrap
        // NEVER: hot carbon steel scrap
        tableBuilder.pool(pool);
    }

    private static void addNetherScrapsStrict(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 3))
                .conditionally(RandomChanceLootCondition.builder(chance));

        pool.with(ItemEntry.builder(CARBON_STEEL_SCRAP).weight(12));
        pool.with(ItemEntry.builder(OBSIDIAN_SCRAP).weight(3));

        // NO enderite scrap here.
        tableBuilder.pool(pool);
    }

    private static void addVeryRareHardenedIngotTreasure(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        tableBuilder.pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance))
                .with(ItemEntry.builder(HARDENED_STEEL_INGOT).weight(1)));
    }

    // -------------------------------------------------------------------------
    // TEMPLATES
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

    private static void addTemplatesEnd(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance));

        pool.with(ItemEntry.builder(TEMPLATE_ENDERITE).weight(12));
        pool.with(ItemEntry.builder(TEMPLATE_ADAMANTIUM).weight(10));
        pool.with(ItemEntry.builder(TEMPLATE_HARDENED).weight(2));
        pool.with(ItemEntry.builder(TEMPLATE_OBSIDIAN).weight(2));

        tableBuilder.pool(pool);
    }
}
