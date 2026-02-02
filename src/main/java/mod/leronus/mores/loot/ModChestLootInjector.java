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
 * Goals per request:
 * - No vanilla items injected by us.
 * - No extra stone/iron tools injected by us.
 * - Loot "makes sense": pies in villages, dusts in dungeons/underground, etc.
 * - Disc pool contains ONLY: Cipher + Sweet Caroline.
 * - Tier split:
 *   EARLY: tin/copper/bronze
 *   EARLY_MID: tin/silver/copper/bronze/sterling_silver/carbon_steel/cobalt
 *   LATE_MID: amethyst/lapis/turquoise/onyx/citrine/topaz/tourmaline/tanzanite
 *   LATE: ruby/sapphire/moissanite + adamantium/obsidian/hardened_steel
 *   ENDERITE: ultra rare (rarer than netherite vibe), end-focused
 * - Smithing templates: hardened/obsidian in nether/deep; enderite in end; adamantium mostly end city.
 *
 * NOTE:
 * True "replacement" (removing vanilla entries) isn't reliably possible with LootTableEvents.MODIFY alone.
 */
public final class ModChestLootInjector {

    private ModChestLootInjector() {}

    // -------------------------------------------------------------------------
    // MUSIC DISCS (ONLY these two)
    // -------------------------------------------------------------------------

    private static final Item[] ALLOWED_DISCS = new Item[]{
            ModItems.CIPHER_MUSIC_DISC,
            ModItems.SWEET_CAROLINE_MUSIC_DISC
    };

    // -------------------------------------------------------------------------
    // FOODS (ONLY your mod foods)
    // Rules:
    // - Pies strongly village-weighted
    // - Chocolate only jungle-ish
    // - Lemons only oak/forest-ish
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
    // SMITHING TEMPLATES
    // -------------------------------------------------------------------------

    private static final Item TEMPLATE_HARDENED = ModItems.HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE;
    private static final Item TEMPLATE_OBSIDIAN = ModItems.OBSIDIAN_UPGRADE_SMITHING_TEMPLATE;
    private static final Item TEMPLATE_ENDERITE = ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE;
    private static final Item TEMPLATE_ADAMANTIUM = ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE;

    // -------------------------------------------------------------------------
    // MATERIALS (ingots, nuggets, raws, gems, dusts, scraps)
    // -------------------------------------------------------------------------

    private static final Item[] EARLY_INGOTS = new Item[]{
            ModItems.TIN_INGOT,
            ModItems.BRONZE_INGOT
    };

    private static final Item[] EARLY_MID_INGOTS = new Item[]{
            ModItems.SILVER_INGOT,
            ModItems.STERLING_SILVER_INGOT,
            ModItems.CARBON_STEEL_INGOT,
            ModItems.COBALT_INGOT
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

    private static final Item[] NUGGETS = new Item[]{
            ModItems.TIN_NUGGET,
            ModItems.COPPER_NUGGET,
            ModItems.SILVER_NUGGET,
            ModItems.STERLING_SILVER_NUGGET,
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

    // -------------------------------------------------------------------------
    // TIERS: TOOLS/ARMOR/SHIELDS
    //
    // IMPORTANT:
    // - We only reference items we can reasonably expect exist based on your earlier snippet:
    //   (silver/sterling/cobalt/rose_gold/carbon_steel have battle_axe/battle_mace/dagger)
    // - For gem tiers, we reference standard tools/armor names you requested (assumes they exist).
    //   If any of these do not exist in ModItems, your IDE will highlight them immediately.
    // -------------------------------------------------------------------------

    // EARLY: tin / copper / bronze
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

    // EARLY_MID: tin/silver/copper/bronze/sterling_silver/carbon_steel/cobalt
    // (Includes special weapons you explicitly have: battle_axe, battle_mace, dagger)
    private static final Item[] EARLY_MID_TOOLS = new Item[]{
            // keep some early basics
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
            ModItems.CARBON_STEEL_HELMET, ModItems.CARBON_STEEL_CHESTPLATE, ModItems.CARBON_STEEL_LEGGINGS, ModItems.CARBON_STEEL_BOOTS
    };

    private static final Item[] EARLY_MID_SHIELDS = new Item[]{
            ModItems.TIN_SHIELD, ModItems.COPPER_SHIELD, ModItems.BRONZE_SHIELD,
            ModItems.SILVER_SHIELD, ModItems.STERLING_SILVER_SHIELD, ModItems.COBALT_SHIELD, ModItems.CARBON_STEEL_SHIELD
    };

    // LATE_MID: amethyst, lapis lazuli, turquoise, onyx, citrine, topaz, tourmaline, tanzanite
    // (assumes these exist in ModItems; if not, remove missing lines)
    private static final Item[] LATE_MID_TOOLS = new Item[]{
            ModItems.AMETHYST_SWORD, ModItems.AMETHYST_PICKAXE, ModItems.AMETHYST_AXE, ModItems.AMETHYST_SHOVEL, ModItems.AMETHYST_HOE,
            ModItems.LAPIS_LAZULI_SWORD, ModItems.LAPIS_LAZULI_PICKAXE, ModItems.LAPIS_LAZULI_AXE, ModItems.LAPIS_LAZULI_SHOVEL, ModItems.LAPIS_LAZULI_HOE,
            ModItems.TURQUOISE_SWORD, ModItems.TURQUOISE_PICKAXE, ModItems.TURQUOISE_AXE, ModItems.TURQUOISE_SHOVEL, ModItems.TURQUOISE_HOE,
            ModItems.ONYX_SWORD, ModItems.ONYX_PICKAXE, ModItems.ONYX_AXE, ModItems.ONYX_SHOVEL, ModItems.ONYX_HOE,
            ModItems.CITRINE_SWORD, ModItems.CITRINE_PICKAXE, ModItems.CITRINE_AXE, ModItems.CITRINE_SHOVEL, ModItems.CITRINE_HOE,
            ModItems.TOPAZ_SWORD, ModItems.TOPAZ_PICKAXE, ModItems.TOPAZ_AXE, ModItems.TOPAZ_SHOVEL, ModItems.TOPAZ_HOE,
            ModItems.TOURMALINE_SWORD, ModItems.TOURMALINE_PICKAXE, ModItems.TOURMALINE_AXE, ModItems.TOURMALINE_SHOVEL, ModItems.TOURMALINE_HOE,
            ModItems.TANZANITE_SWORD, ModItems.TANZANITE_PICKAXE, ModItems.TANZANITE_AXE, ModItems.TANZANITE_SHOVEL, ModItems.TANZANITE_HOE
    };

    private static final Item[] LATE_MID_ARMOR = new Item[]{
            ModItems.AMETHYST_HELMET, ModItems.AMETHYST_CHESTPLATE, ModItems.AMETHYST_LEGGINGS, ModItems.AMETHYST_BOOTS,
            ModItems.LAPIS_LAZULI_HELMET, ModItems.LAPIS_LAZULI_CHESTPLATE, ModItems.LAPIS_LAZULI_LEGGINGS, ModItems.LAPIS_LAZULI_BOOTS,
            ModItems.TURQUOISE_HELMET, ModItems.TURQUOISE_CHESTPLATE, ModItems.TURQUOISE_LEGGINGS, ModItems.TURQUOISE_BOOTS,
            ModItems.ONYX_HELMET, ModItems.ONYX_CHESTPLATE, ModItems.ONYX_LEGGINGS, ModItems.ONYX_BOOTS,
            ModItems.CITRINE_HELMET, ModItems.CITRINE_CHESTPLATE, ModItems.CITRINE_LEGGINGS, ModItems.CITRINE_BOOTS,
            ModItems.TOPAZ_HELMET, ModItems.TOPAZ_CHESTPLATE, ModItems.TOPAZ_LEGGINGS, ModItems.TOPAZ_BOOTS,
            ModItems.TOURMALINE_HELMET, ModItems.TOURMALINE_CHESTPLATE, ModItems.TOURMALINE_LEGGINGS, ModItems.TOURMALINE_BOOTS,
            ModItems.TANZANITE_HELMET, ModItems.TANZANITE_CHESTPLATE, ModItems.TANZANITE_LEGGINGS, ModItems.TANZANITE_BOOTS
    };

    private static final Item[] LATE_MID_SHIELDS = new Item[]{
            ModItems.AMETHYST_SHIELD,
            ModItems.LAPIS_LAZULI_SHIELD,
            ModItems.TURQUOISE_SHIELD,
            ModItems.ONYX_SHIELD,
            ModItems.CITRINE_SHIELD,
            ModItems.TOPAZ_SHIELD,
            ModItems.TOURMALINE_SHIELD,
            ModItems.TANZANITE_SHIELD
    };

    // LATE: ruby, sapphire, moissanite, adamantium, obsidian, hardened steel
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

    // ENDERITE: ultimate rare loot; end-focused
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
                // -----------------------------
                // Villages (cover all village variants)
                // Make it useful but NOT bulky.
                // Pies are primarily here.
                // -----------------------------
                case VILLAGE -> {
                    // Gear: mostly EARLY, occasional EARLY_MID
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.55f, // tool chance
                            0.38f, // armor chance
                            0.12f, // shield chance
                            1, 1   // tool rolls: 1
                    );

                    addGear(tableBuilder, EARLY_MID_TOOLS, EARLY_MID_ARMOR, EARLY_MID_SHIELDS,
                            0.18f,
                            0.10f,
                            0.04f,
                            1, 1
                    );

                    // Foods: pies strongly village
                    addPies(tableBuilder, 0.70f, 1, 2);

                    // Lemons only oak/forest/plains village-ish
                    if (isOaky(path)) {
                        addSimpleItems(tableBuilder, LEMONS_OAKY, 0.28f, 1, 2, WeightProfile.FLAT);
                    }

                    // Duck small chance
                    addSimpleItems(tableBuilder, DUCK_FOODS, 0.16f, 1, 1, WeightProfile.FLAT);

                    // Materials: mostly ingots/nuggets, some gems, dust minimal here
                    addOverworldMetals(tableBuilder, path, 0.78f);
                    addOverworldGems(tableBuilder, path, 0.22f);
                }

                // -----------------------------
                // Dungeons / Mineshafts
                // Dusts belong here.
                // Reduce tool flood.
                // -----------------------------
                case DUNGEON_MINESHAFT -> {
                    // Gear: mostly EARLY, rare EARLY_MID
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.42f,
                            0.22f,
                            0.10f,
                            1, 1
                    );

                    addGear(tableBuilder, EARLY_MID_TOOLS, EARLY_MID_ARMOR, EARLY_MID_SHIELDS,
                            0.10f,
                            0.06f,
                            0.03f,
                            1, 1
                    );

                    // Foods: pies rare here (make sense), duck a bit more likely
                    addPies(tableBuilder, 0.14f, 1, 1);
                    addSimpleItems(tableBuilder, DUCK_FOODS, 0.22f, 1, 1, WeightProfile.FLAT);

                    // Materials: dusts + scraps + nuggets + raws
                    addUndergroundMetals(tableBuilder, path, 0.82f);
                    addUndergroundDusts(tableBuilder, 0.72f);
                    addScraps(tableBuilder, 0.52f, 1, 3);

                    // Discs (only cipher + sweet caroline), rare, dungeon-appropriate
                    addDiscs(tableBuilder, 0.06f);
                }

                // -----------------------------
                // Temples / Pyramids (includes jungle temple)
                // If jungle temple: chocolates allowed.
                // -----------------------------
                case TEMPLE_PYRAMID -> {
                    // Gear: EARLY_MID common, LATE_MID occasional
                    addGear(tableBuilder, EARLY_MID_TOOLS, EARLY_MID_ARMOR, EARLY_MID_SHIELDS,
                            0.48f,
                            0.26f,
                            0.12f,
                            1, 1
                    );

                    addGear(tableBuilder, LATE_MID_TOOLS, LATE_MID_ARMOR, LATE_MID_SHIELDS,
                            0.14f,
                            0.08f,
                            0.04f,
                            1, 1
                    );

                    // Foods: pies moderate, chocolates only if jungle-ish
                    addPies(tableBuilder, 0.28f, 1, 1);
                    if (isJungle(path)) {
                        addSimpleItems(tableBuilder, CHOCOLATES, 0.22f, 1, 2, WeightProfile.FLAT);
                    }
                    if (isOaky(path)) {
                        addSimpleItems(tableBuilder, LEMONS_OAKY, 0.12f, 1, 1, WeightProfile.FLAT);
                    }

                    // Materials: gems common, dust some, metals moderate
                    addOverworldMetals(tableBuilder, path, 0.70f);
                    addOverworldGems(tableBuilder, path, 0.55f);
                    addContextDusts(tableBuilder, path, 0.22f);

                    // Discs rare
                    addDiscs(tableBuilder, 0.04f);

                    // Templates: small chance for hardened/obsidian in rich overworld loot
                    addTemplatesOverworldRich(tableBuilder, 0.06f);
                }

                // -----------------------------
                // Outposts / Towers / Camps
                // -----------------------------
                case OUTPOST_TOWER -> {
                    addGear(tableBuilder, EARLY_MID_TOOLS, EARLY_MID_ARMOR, EARLY_MID_SHIELDS,
                            0.50f,
                            0.26f,
                            0.14f,
                            1, 1
                    );

                    // Late-mid rare
                    addGear(tableBuilder, LATE_MID_TOOLS, LATE_MID_ARMOR, LATE_MID_SHIELDS,
                            0.10f,
                            0.06f,
                            0.03f,
                            1, 1
                    );

                    // Foods: pies low, duck moderate
                    addPies(tableBuilder, 0.18f, 1, 1);
                    addSimpleItems(tableBuilder, DUCK_FOODS, 0.22f, 1, 1, WeightProfile.FLAT);

                    // Materials: metals + nuggets + some gems
                    addOverworldMetals(tableBuilder, path, 0.80f);
                    addOverworldGems(tableBuilder, path, 0.35f);
                    addContextDusts(tableBuilder, path, 0.18f);

                    // Discs very rare
                    addDiscs(tableBuilder, 0.03f);

                    // Templates small
                    addTemplatesOverworldRich(tableBuilder, 0.05f);
                }

                // -----------------------------
                // Shipwreck / Ocean ruins
                // -----------------------------
                case SHIPWRECK_OCEAN -> {
                    // Gear: mainly EARLY, not a weapon fountain
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.34f,
                            0.18f,
                            0.10f,
                            1, 1
                    );

                    // Foods: pies very low, duck low
                    addPies(tableBuilder, 0.10f, 1, 1);
                    addSimpleItems(tableBuilder, DUCK_FOODS, 0.10f, 1, 1, WeightProfile.FLAT);

                    // Materials: nuggets/ingots/gems light
                    addOverworldMetals(tableBuilder, path, 0.62f);
                    addOverworldGems(tableBuilder, path, 0.22f);
                }

                // -----------------------------
                // Stronghold (mid-high)
                // -----------------------------
                case STRONGHOLD -> {
                    // Gear: EARLY_MID common, LATE_MID moderate
                    addGear(tableBuilder, EARLY_MID_TOOLS, EARLY_MID_ARMOR, EARLY_MID_SHIELDS,
                            0.56f,
                            0.30f,
                            0.16f,
                            1, 1
                    );

                    addGear(tableBuilder, LATE_MID_TOOLS, LATE_MID_ARMOR, LATE_MID_SHIELDS,
                            0.24f,
                            0.14f,
                            0.06f,
                            1, 1
                    );

                    // Foods: pies low here
                    addPies(tableBuilder, 0.16f, 1, 1);
                    addSimpleItems(tableBuilder, DUCK_FOODS, 0.14f, 1, 1, WeightProfile.FLAT);

                    // Materials: gems + dust + scraps more likely
                    addUndergroundMetals(tableBuilder, path, 0.86f);
                    addUndergroundDusts(tableBuilder, 0.58f);
                    addScraps(tableBuilder, 0.50f, 1, 3);
                    addLateGems(tableBuilder, 0.18f);

                    // Discs rare
                    addDiscs(tableBuilder, 0.06f);

                    // Templates: hardened/obsidian moderate
                    addTemplatesDeep(tableBuilder, 0.12f);
                }

                // -----------------------------
                // Mansion
                // -----------------------------
                case MANSION -> {
                    addGear(tableBuilder, EARLY_MID_TOOLS, EARLY_MID_ARMOR, EARLY_MID_SHIELDS,
                            0.58f,
                            0.32f,
                            0.16f,
                            1, 1
                    );

                    addGear(tableBuilder, LATE_MID_TOOLS, LATE_MID_ARMOR, LATE_MID_SHIELDS,
                            0.22f,
                            0.12f,
                            0.06f,
                            1, 1
                    );

                    // Foods: pies moderate (it’s a big house), lemons possible if forest-ish
                    addPies(tableBuilder, 0.30f, 1, 2);
                    if (isOaky(path)) addSimpleItems(tableBuilder, LEMONS_OAKY, 0.18f, 1, 2, WeightProfile.FLAT);

                    // Materials: lots of gems, some dust
                    addOverworldMetals(tableBuilder, path, 0.85f);
                    addOverworldGems(tableBuilder, path, 0.65f);
                    addContextDusts(tableBuilder, path, 0.20f);
                    addLateGems(tableBuilder, 0.20f);

                    addDiscs(tableBuilder, 0.06f);

                    addTemplatesOverworldRich(tableBuilder, 0.10f);
                }

                // -----------------------------
                // Nether: Bastion / Fortress
                // Late gear + templates, pies nearly none
                // -----------------------------
                case NETHER -> {
                    // Gear: LATE common, ENDERITE *not* here (enderite is end-focused)
                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.58f,
                            0.34f,
                            0.18f,
                            1, 1
                    );

                    // Foods: basically none besides tiny pies chance
                    addPies(tableBuilder, 0.06f, 1, 1);

                    // Materials: late ingots + scraps common, dust context quartz
                    addNetherMetals(tableBuilder, 0.88f);
                    addNetherDusts(tableBuilder, 0.55f);
                    addScraps(tableBuilder, 0.78f, 1, 4);
                    addLateGems(tableBuilder, 0.16f);

                    addDiscs(tableBuilder, 0.05f);

                    // Templates: hardened + obsidian main
                    addTemplatesNether(tableBuilder, 0.22f);
                }

                // -----------------------------
                // Ancient City / Deep Dark
                // Late gear, heavy dust/scraps, templates
                // -----------------------------
                case DEEP_DARK -> {
                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.60f,
                            0.36f,
                            0.18f,
                            1, 1
                    );

                    // Foods: low pies
                    addPies(tableBuilder, 0.08f, 1, 1);

                    // Materials: dust heavy, scraps heavy, late gems some
                    addUndergroundMetals(tableBuilder, path, 0.90f);
                    addUndergroundDusts(tableBuilder, 0.78f);
                    addScraps(tableBuilder, 0.88f, 1, 4);
                    addLateGems(tableBuilder, 0.22f);

                    addDiscs(tableBuilder, 0.07f);

                    // Templates: hardened + obsidian moderate-high; adamantium small chance
                    addTemplatesDeep(tableBuilder, 0.22f);
                    addAdamantiumTemplate(tableBuilder, 0.06f);
                }

                // -----------------------------
                // End City (enderite ultra rare + enderite template)
                // -----------------------------
                case END_CITY -> {
                    // LATE gear common
                    addGear(tableBuilder, LATE_TOOLS, LATE_ARMOR, LATE_SHIELDS,
                            0.62f,
                            0.38f,
                            0.20f,
                            1, 1
                    );

                    // ENDERITE ultra rare (rarer than netherite vibe)
                    addGear(tableBuilder, ENDERITE_TOOLS, ENDERITE_ARMOR, ENDERITE_SHIELDS,
                            0.08f,   // tool chance
                            0.04f,   // armor chance
                            0.02f,   // shield chance
                            1, 1
                    );

                    // Foods: minimal
                    addPies(tableBuilder, 0.08f, 1, 1);

                    // Materials: enderite ingot/scrap rare; late gems more common
                    addEndMetals(tableBuilder, 0.92f);
                    addScraps(tableBuilder, 0.70f, 1, 4);
                    addLateGems(tableBuilder, 0.32f);

                    // Disc chance small
                    addDiscs(tableBuilder, 0.05f);

                    // Templates: enderite + adamantium are key here
                    addTemplatesEnd(tableBuilder, 0.32f);
                }

                // -----------------------------
                // Generic chest: very light touch
                // -----------------------------
                case GENERIC -> {
                    addGear(tableBuilder, EARLY_TOOLS, EARLY_ARMOR, EARLY_SHIELDS,
                            0.14f,
                            0.08f,
                            0.04f,
                            1, 1
                    );

                    // Pies rare
                    addPies(tableBuilder, 0.10f, 1, 1);

                    // Metals small
                    addOverworldMetals(tableBuilder, path, 0.18f);
                    addOverworldGems(tableBuilder, path, 0.08f);

                    // Discs extremely rare
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
        // End first
        if (containsAny(path, "end_city", "endcity", "end_city_treasure")) return ChestCategory.END_CITY;

        // Deep dark / ancient city
        if (containsAny(path, "ancient_city", "deep_dark", "sculk", "underground_city")) return ChestCategory.DEEP_DARK;

        // Nether
        if (containsAny(path, "bastion", "fortress", "nether", "piglin")) return ChestCategory.NETHER;

        // Stronghold
        if (containsAny(path, "stronghold")) return ChestCategory.STRONGHOLD;

        // Mansion
        if (containsAny(path, "mansion", "woodland", "illager_mansion")) return ChestCategory.MANSION;

        // Shipwreck/ocean
        if (containsAny(path, "shipwreck", "ocean_ruin", "oceanruin", "wreck")) return ChestCategory.SHIPWRECK_OCEAN;

        // Outposts/towers/camps
        if (containsAny(path, "outpost", "watchtower", "tower", "camp")) return ChestCategory.OUTPOST_TOWER;

        // Temples/pyramids
        if (containsAny(path, "desert_pyramid", "pyramid", "jungle_temple", "temple")) return ChestCategory.TEMPLE_PYRAMID;

        // Dungeons/mineshafts
        if (containsAny(path, "abandoned_mineshaft", "mineshaft", "dungeon", "spawner")) return ChestCategory.DUNGEON_MINESHAFT;

        // Villages (covers all village variants because they include "village" in path)
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
    // WEIGHTING
    // Add explicit chances for battle_mace and dagger by weighting them.
    // -------------------------------------------------------------------------

    private enum WeightProfile { TOOLS, ARMOR, FLAT }

    private static int weightFor(Item it, WeightProfile profile) {
        if (profile == WeightProfile.FLAT) return 10;

        String s = it.toString().toLowerCase(Locale.ROOT);

        if (profile == WeightProfile.TOOLS) {
            // Core tools slightly favored; specials present but not spammy
            if (s.contains("pickaxe")) return 18;
            if (s.contains("sword")) return 16;

            // Explicit: battle mace + dagger chances
            if (s.contains("battle_mace")) return 12;   // noticeable but not too common
            if (s.contains("dagger")) return 11;        // slightly less than mace
            if (s.contains("battle_axe")) return 12;

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

        // Tools
        tableBuilder.pool(weightedPool(tools, toolChance, toolRollsMin, toolRollsMax, WeightProfile.TOOLS));

        // Armor (single roll keeps it from bloating)
        tableBuilder.pool(weightedPool(armor, armorChance, 1, 1, WeightProfile.ARMOR));

        // Shields (single roll, low chance)
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
        // Pies should be mostly in villages (we control chance per category)
        tableBuilder.pool(weightedPool(PIES, chance, rollsMin, rollsMax, WeightProfile.FLAT));
    }

    // -------------------------------------------------------------------------
    // DISCS (ONLY cipher + sweet caroline)
    // -------------------------------------------------------------------------

    private static void addDiscs(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        tableBuilder.pool(weightedPool(ALLOWED_DISCS, chance, 1, 1, WeightProfile.FLAT));
    }

    // -------------------------------------------------------------------------
    // MATERIAL POOLS (simulate stacks with more rolls, no SetCount)
    // -------------------------------------------------------------------------

    private static void addOverworldMetals(net.minecraft.loot.LootTable.Builder tableBuilder, String path, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(2, 4))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Common overworld metals
        for (Item it : EARLY_INGOTS) pool.with(ItemEntry.builder(it).weight(14));
        for (Item it : RAW_MATERIALS) pool.with(ItemEntry.builder(it).weight(13));
        for (Item it : NUGGETS) pool.with(ItemEntry.builder(it).weight(12));

        // Early-mid ingots are more likely in rich structures
        int rich = containsAny(path, "temple", "pyramid", "outpost", "stronghold", "mansion", "mineshaft", "dungeon") ? 12 : 7;
        for (Item it : EARLY_MID_INGOTS) pool.with(ItemEntry.builder(it).weight(rich));

        // Late ingots are very rare overworld
        for (Item it : LATE_INGOTS) pool.with(ItemEntry.builder(it).weight(1));

        tableBuilder.pool(pool);
    }

    private static void addOverworldGems(net.minecraft.loot.LootTable.Builder tableBuilder, String path, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance));

        int rich = containsAny(path, "temple", "pyramid", "mansion", "stronghold") ? 14 : 10;
        for (Item it : GEMS_EARLY_MID) pool.with(ItemEntry.builder(it).weight(rich));

        // Late gems are rarer overworld
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
        for (Item it : EARLY_MID_INGOTS) pool.with(ItemEntry.builder(it).weight(10));

        // Late ingots underground are possible but still uncommon
        for (Item it : LATE_INGOTS) pool.with(ItemEntry.builder(it).weight(3));

        tableBuilder.pool(pool);
    }

    private static void addUndergroundDusts(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        // Dusts should feel “dungeon/underground”
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 3))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Underground emphasis: amethyst + lapis dust
        pool.with(ItemEntry.builder(ModItems.AMETHYST_DUST).weight(16));
        pool.with(ItemEntry.builder(ModItems.LAPIS_LAZULI_DUST).weight(16));

        // Turquoise dust occasionally
        pool.with(ItemEntry.builder(ModItems.TURQUOISE_DUST).weight(10));

        // Quartz dust rare underground
        pool.with(ItemEntry.builder(ModItems.QUARTZ_DUST).weight(6));

        tableBuilder.pool(pool);
    }

    private static void addContextDusts(net.minecraft.loot.LootTable.Builder tableBuilder, String path, float chance) {
        // Light dust presence in some overworld structures
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 2))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Desert-ish -> turquoise dust
        if (containsAny(path, "desert", "badlands", "mesa", "pyramid", "temple")) {
            pool.with(ItemEntry.builder(ModItems.TURQUOISE_DUST).weight(14));
        }

        // Stronghold/mansion/temple -> lapis dust
        if (containsAny(path, "stronghold", "mansion", "temple")) {
            pool.with(ItemEntry.builder(ModItems.LAPIS_LAZULI_DUST).weight(12));
        }

        // A little amethyst dust as general “arcane”
        pool.with(ItemEntry.builder(ModItems.AMETHYST_DUST).weight(10));

        // Quartz dust tiny chance
        pool.with(ItemEntry.builder(ModItems.QUARTZ_DUST).weight(6));

        tableBuilder.pool(pool);
    }

    private static void addNetherMetals(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(2, 5))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Late ingots are common in nether loot
        for (Item it : LATE_INGOTS) pool.with(ItemEntry.builder(it).weight(14));

        // Early-mid ingots still possible but less
        for (Item it : EARLY_MID_INGOTS) pool.with(ItemEntry.builder(it).weight(6));

        // Nuggets and scraps
        for (Item it : NUGGETS) pool.with(ItemEntry.builder(it).weight(12));
        for (Item it : SCRAPS_SPECIAL) pool.with(ItemEntry.builder(it).weight(14));

        tableBuilder.pool(pool);
    }

    private static void addNetherDusts(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(1, 3))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Quartz dust belongs here
        pool.with(ItemEntry.builder(ModItems.QUARTZ_DUST).weight(18));

        // Some onyx/tourmaline vibe
        pool.with(ItemEntry.builder(ModItems.ONYX_GEM).weight(10));
        pool.with(ItemEntry.builder(ModItems.TOURMALINE_GEM).weight(10));

        tableBuilder.pool(pool);
    }

    private static void addEndMetals(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(UniformLootNumberProvider.create(2, 4))
                .conditionally(RandomChanceLootCondition.builder(chance));

        // Late ingots + scraps are common
        for (Item it : LATE_INGOTS) pool.with(ItemEntry.builder(it).weight(12));
        for (Item it : SCRAPS_SPECIAL) pool.with(ItemEntry.builder(it).weight(12));

        // ENDERITE ingot is rare-but-real
        for (Item it : ENDERITE_INGOTS) pool.with(ItemEntry.builder(it).weight(2));

        tableBuilder.pool(pool);
    }

    private static void addScraps(net.minecraft.loot.LootTable.Builder tableBuilder, float chance, int rollsMin, int rollsMax) {
        tableBuilder.pool(weightedPool(SCRAPS_SPECIAL, chance, rollsMin, rollsMax, WeightProfile.FLAT));
    }

    // -------------------------------------------------------------------------
    // TEMPLATES (kept sensible and constrained)
    // -------------------------------------------------------------------------

    private static void addTemplatesOverworldRich(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        // small chance: hardened + obsidian only
        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance));

        pool.with(ItemEntry.builder(TEMPLATE_HARDENED).weight(10));
        pool.with(ItemEntry.builder(TEMPLATE_OBSIDIAN).weight(8));

        tableBuilder.pool(pool);
    }

    private static void addTemplatesNether(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        // nether: hardened + obsidian primary
        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance));

        pool.with(ItemEntry.builder(TEMPLATE_HARDENED).weight(12));
        pool.with(ItemEntry.builder(TEMPLATE_OBSIDIAN).weight(10));

        // adamantium very rare in nether (mostly end city)
        pool.with(ItemEntry.builder(TEMPLATE_ADAMANTIUM).weight(2));

        tableBuilder.pool(pool);
    }

    private static void addTemplatesDeep(net.minecraft.loot.LootTable.Builder tableBuilder, float chance) {
        // deep structures: hardened + obsidian, with a little adamantium chance
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
        // end city: enderite + adamantium, with small hardened/obsidian echo
        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance));

        pool.with(ItemEntry.builder(TEMPLATE_ENDERITE).weight(12));     // key
        pool.with(ItemEntry.builder(TEMPLATE_ADAMANTIUM).weight(10));   // key
        pool.with(ItemEntry.builder(TEMPLATE_HARDENED).weight(3));
        pool.with(ItemEntry.builder(TEMPLATE_OBSIDIAN).weight(3));

        tableBuilder.pool(pool);
    }
}
