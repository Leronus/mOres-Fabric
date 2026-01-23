package mod.leronus.mores.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class CommonConfig extends MidnightConfig {

    public static final String GAMEPLAY = "gameplay";
    public static final String ALLOYING = "alloying";
    public static final String WORLDGEN = "worldgen";

    // Gameplay
    @Entry(category = GAMEPLAY, name = "Enable tool and weapon bonuses (onyx wither/ruby autosmelt)")
    public static boolean enableToolAndWeaponBonuses = true;

    @Entry(category = GAMEPLAY, name = "Enable all armor set bonuses")
    public static boolean enableArmorSetBonuses = true;

    // =========================
    // LEMON OAK WORLDGEN
    // =========================
    @Entry(category = WORLDGEN, name = "Enable lemon leaves generation")
    public static boolean enableLemonOakWorldgen = true;

    /**
     * Chance that a vanilla OAK variant gets lemon leaves. (requires restart)
     * 10 = 10% (1 in 10), 20 = 5%, 5 = 20%.
     */
    @Entry(category = WORLDGEN, min = 1, max = 200, isSlider = true, name = "Lemon leaves per oak tree chance")
    public static int lemonLeavesReplaceVanillaLeavesChance = 10;

    /**
     * How many of the leaf placements become lemon leaves. (requires restart)
     * Worldgen target: ~3–5 lemons -> ~4–6
     */
    @Entry(category = WORLDGEN, min = 0, max = 100, isSlider = true, name = "Lemon leaves per oak leaves weight")
    public static int lemonLeafWeightWorldgen = 5;

    /**
     * Sapling-grown lemon oak tree should have more lemons.
     * Sapling target: ~6–8 lemons -> ~10–14 weight (requires restart)
     */
    @Entry(category = WORLDGEN, min = 0, max = 100, isSlider = true, name = "Lemon leaves from sapling weight")
    public static int lemonLeavesFromSaplingWeight = 12;

    // =========================
    // MOB WEAPON/ARMOR GENERATION
    // =========================
    @Entry(category = WORLDGEN, name = "Enable mob weapon and armor generation")
    public static boolean enableMobGeneration = true;
    @Entry(category = WORLDGEN, name = "Mob Hand Drop Chance")
    public static float handDropChance = 0.03f;
    @Entry(category = WORLDGEN, name = "Mob Armor Drop Chance")
    public static float armorDropChance = 0.03f;

    @Entry(category = WORLDGEN, min = 0, max = 100, isSlider = false, name = "Zombie Upgrade Minimum (1/4)")
    public static int zombieUpgradeMin = 4;
    @Entry(category = WORLDGEN, min = 0, max = 100, isSlider = false, name = "Zombie Upgrade Maximum (1/7)")
    public static int zombieUpgradeMax = 7;
    @Entry(category = WORLDGEN, name = "Zombie Weapon Chance")
    public static float zombieWeaponChance = 0.70f;
    @Entry(category = WORLDGEN, name = "Zombie Armor Chance")
    public static float zombieArmorChance = 0.75f;
    @Entry(category = WORLDGEN, name = "Skeleton Armor Chance")
    public static float skeletonArmorChance = 0.22f;
    @Entry(category = WORLDGEN, name = "Piglin Armor Chance")
    public static float piglinArmorChance = 0.15f;
    @Entry(category = WORLDGEN, name = "Piglin Sword Chance")
    public static float piglinSwordChance = 0.10f;
    @Entry(category = WORLDGEN, name = "Zombified Piglin Sword Chance")
    public static float zombifiedPiglinSwordChance = 0.10f;
    @Entry(category = WORLDGEN, name = "Piglin Brute Axe Chance")
    public static float piglinBruteAxeChance = 0.10f;
    @Entry(category = WORLDGEN, name = "Wither Upgrade Chance")
    public static float witherUpgradeChance = 0.15f;
    @Entry(category = WORLDGEN, name = "Wither with Upgrade Armor Chance")
    public static float witherWithArmorUpgradeChance = 0.12f;
    @Entry(category = WORLDGEN, name = "Wither Strong Sword Chance")
    public static float witherStrongSwordChance = 0.18f;
    @Entry(category = WORLDGEN, name = "Wither Very Strong Sword Chance")
    public static float witherVeryStrongSwordChance = 0.06f;
    @Entry(category = WORLDGEN, name = "Vindicator Weapon Chance")
    public static float vindicatorWeaponChance = 0.18f;
    @Entry(category = WORLDGEN, name = "Vex Weapon Chance")
    public static float vexWeaponChance = 0.18f;

    // Materials (restart required in practice)
    @Entry(category = GAMEPLAY, name = "Material presets (restart required)")
    public static MaterialPreset materialPreset = MaterialPreset.DEFAULT;

    public enum MaterialPreset {
        DEFAULT, SOFTER, HARDER
    }

    // Alloy Furnace (logic)
    @Entry(category = ALLOYING, min = 1, max = 200000, isSlider = true, name = "Base cook time (ticks)")
    public static int alloyFurnaceCookTimeTicks = 200;

    @Entry(category = ALLOYING, min = 0, max = 64, isSlider = false, name = "Extra time per ingredient (ticks)")
    public static int alloyFurnaceExtraTimePerIngredientTicks = 20;

    @Entry(category = ALLOYING, min = 0.05D, max = 10.0D, isSlider = true, precision = 100, name = "Fuel multiplier")
    public static double alloyFurnaceFuelMultiplier = 1.0D;

    // Worldgen (note: affects new chunks)
    @Entry(category = WORLDGEN, name = "Enable ore generation")
    public static boolean enableOreGeneration = true;

    @Entry(category = WORLDGEN, min = -64, max = 320, isSlider = true, name = "Tin Ore min Y")
    public static int tinOreMinY = 0;
    @Entry(category = WORLDGEN, min = -64, max = 320, isSlider = true, name = "Tin Ore max Y")
    public static int tinOreMaxY = 64;
    @Entry(category = WORLDGEN, min = 1, max = 64, isSlider = true, name = "Tin Ore vein size")
    public static int tinOreVeinSize = 8;
    @Entry(category = WORLDGEN, min = 0, max = 50, isSlider = true, name = "Tin Ore veins per chunk")
    public static int tinOreVeinsPerChunk = 10;

    //Copper etc
}
