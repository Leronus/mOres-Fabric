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
    // MOB (ENTITY/WEAPON/ARMOR) GENERATION
    // =========================
    @Entry(category = WORLDGEN, name = "Enable Hardened Steel Golem natural generation")
    public static boolean enableHardenedSteelGolemSpawn = true;
    @Entry(category = WORLDGEN, name = "Hardened Steel Golem spawn chance")
    public static float hardenedSteelGolemSpawnChance = 0.85f;
    @Entry(category = WORLDGEN, name = "Enable mob weapon and armor generation")
    public static boolean enableHostileGearGeneration = true;
    @Entry(category = WORLDGEN, name = "Mob hand drop chance")
    public static float handDropChance = 0.085f;
    @Entry(category = WORLDGEN, name = "Mob armor drop chance")
    public static float armorDropChance = 0.085f;

    @Entry(category = WORLDGEN, min = 0, max = 100, isSlider = false, name = "Zombie upgrade minimum (1/4)")
    public static int zombieUpgradeMin = 4;
    @Entry(category = WORLDGEN, min = 0, max = 100, isSlider = false, name = "Zombie upgrade maximum (1/7)")
    public static int zombieUpgradeMax = 7;
    @Entry(category = WORLDGEN, name = "Zombie weapon chance")
    public static float zombieWeaponChance = 0.70f;
    @Entry(category = WORLDGEN, name = "Zombie armor chance")
    public static float zombieArmorChance = 0.75f;
    @Entry(category = WORLDGEN, name = "Skeleton armor chance")
    public static float skeletonArmorChance = 0.22f;
    @Entry(category = WORLDGEN, name = "Piglin armor chance")
    public static float piglinArmorChance = 0.15f;
    @Entry(category = WORLDGEN, name = "Piglin sword chance")
    public static float piglinSwordChance = 0.10f;
    @Entry(category = WORLDGEN, name = "Zombified Piglin sword chance")
    public static float zombifiedPiglinSwordChance = 0.10f;
    @Entry(category = WORLDGEN, name = "Piglin Brute axe chance")
    public static float piglinBruteAxeChance = 0.10f;
    @Entry(category = WORLDGEN, name = "Wither upgrade chance")
    public static float witherUpgradeChance = 0.15f;
    @Entry(category = WORLDGEN, name = "Wither with upgrade armor chance")
    public static float witherWithArmorUpgradeChance = 0.12f;
    @Entry(category = WORLDGEN, name = "Wither strong sword chance")
    public static float witherStrongSwordChance = 0.18f;
    @Entry(category = WORLDGEN, name = "Wither very Strong sword chance")
    public static float witherVeryStrongSwordChance = 0.06f;
    @Entry(category = WORLDGEN, name = "Vindicator weapon chance")
    public static float vindicatorWeaponChance = 0.18f;
    @Entry(category = WORLDGEN, name = "Vex weapon chance")
    public static float vexWeaponChance = 0.18f;


    // Worldgen (note: affects new chunks)
//    @Entry(category = WORLDGEN, name = "Enable ore generation")
//    public static boolean enableOreGeneration = true;

//    @Entry(category = WORLDGEN, min = -64, max = 320, isSlider = true, name = "Tin Ore min Y")
//    public static int tinOreMinY = 0;
//    @Entry(category = WORLDGEN, min = -64, max = 320, isSlider = true, name = "Tin Ore max Y")
//    public static int tinOreMaxY = 64;
//    @Entry(category = WORLDGEN, min = 1, max = 64, isSlider = true, name = "Tin Ore vein size")
//    public static int tinOreVeinSize = 8;
//    @Entry(category = WORLDGEN, min = 0, max = 50, isSlider = true, name = "Tin Ore veins per chunk")
//    public static int tinOreVeinsPerChunk = 10;

    //Copper etc
}
