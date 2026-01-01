package mod.leronus.mores.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class ClientConfig extends MidnightConfig {

    public static final String VISUAL = "visual";

    @Entry(category = VISUAL, name = "Alloy Furnace: fire & smoke particles")
    public static boolean alloyFurnaceParticles = true;

    @Entry(category = VISUAL, name = "Alloy Furnace: active glow when burning")
    public static boolean alloyFurnaceActiveGlow = true;

    @Entry(category = VISUAL, name = "Use themed alloy furnace UI")
    public static boolean themedAlloyFurnaceUI = true;

    @Entry(category = VISUAL, name = "Enable extra mOres tooltips for all combat items (durability, efficiency, set bonus)")
    public static boolean extraTooltips = true;
}
