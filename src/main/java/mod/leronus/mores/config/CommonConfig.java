package mod.leronus.mores.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class CommonConfig extends MidnightConfig {

    public static final String GAMEPLAY = "gameplay";
    public static final String ALLOYING = "alloying";
    public static final String WORLDGEN = "worldgen";

    // Gameplay
    @Entry(category = GAMEPLAY, name = "Enable tool and weapon bonuses (onyx wither/ruby autosmelt)")
    public static boolean enableToolAndWeaponBonuses = true;

    @Entry(category = GAMEPLAY, name = "Enable armor set bonuses")
    public static boolean enableArmorSetBonuses = true;

    @Entry(category = GAMEPLAY, name = "Enable potion / heart effects")
    public static boolean enablePotionHeartEffects = true;

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
