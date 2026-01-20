package mod.leronus.mores.item;

import net.minecraft.item.ArmorItem;

public final class ModArmorDurability {
    public static final int TIN = 164;
    public static final int SILVER = 179;
    public static final int COPPER = 191;
    public static final int STERLING_SILVER = 215;
    public static final int ROSE_GOLD = 223;
    public static final int BRONZE = 320;
    public static final int IRON = 240;

    public static final int COBALT = 270;
    public static final int CARBON_STEEL = 330;
    public static final int GRAPHENE_CHAINMAIL = 400;

    public static final int TURQUOISE = 260;
    public static final int LAPIS_LAZULI = 320;
    public static final int AMETHYST = 325;
    public static final int CITRINE = 335;
    public static final int ONYX = 420;
    public static final int TANZANITE = 421;
    public static final int TOURMALINE = 440;
    public static final int TOPAZ = 450;
    public static final int SPINEL = 469;
    public static final int EMERALD = 500;
    public static final int HARDENED_STEEL = 750;

    // Vanilla reference values you listed (kept here for comparison / reuse)
    public static final int DIAMOND = 528;
    public static final int NETHERITE = 592;

    public static final int RUBY = 537;
    public static final int SAPPHIRE = 546;
    public static final int MOISSANITE = 559;

    public static final int OBSIDIAN = 696;
    public static final int ADAMANTIUM = 768;
    public static final int ENDERITE = 1056;

    public static int scale(int base, ArmorItem.Type type) {
        return switch (type) {
            case HELMET -> (int)(base * 0.75);
            case CHESTPLATE, BODY -> base;
            case LEGGINGS -> (int)(base * 0.9);
            case BOOTS -> (int)(base * 0.65);
        };
    }

}


