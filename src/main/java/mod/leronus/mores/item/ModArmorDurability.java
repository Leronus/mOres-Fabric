package mod.leronus.mores.item;

import net.minecraft.item.ArmorItem;

public final class ModArmorDurability {
    public static final int TIN = 164;
    public static final int SILVER = 179;
    public static final int COPPER = 191;
    public static final int STERLING_SILVER = 215;
    public static final int ROSE_GOLD = 223;
    public static final int BRONZE = 320;

    public static final int COBALT = 309;
    public static final int CARBON_STEEL = 500;

    public static final int TURQUOISE = 625;
    public static final int LAPIS_LAZULI = 787;
    public static final int AMETHYST = 843;
    public static final int CITRINE = 888;
    public static final int ONYX = 932;
    public static final int TANZANITE = 1001;
    public static final int TOURMALINE = 1257;
    public static final int TOPAZ = 1369;
    public static final int SPINEL = 1203;
    public static final int EMERALD = 1199;

    public static final int HARDENED_STEEL = 2000;

    // Vanilla reference values you listed (kept here for comparison / reuse)
    public static final int DIAMOND = 1561;
    public static final int NETHERITE = 2031;

    public static final int RUBY = 1651;
    public static final int SAPPHIRE = 1771;
    public static final int MOISSANITE = 1801;

    public static final int GRAPHENE_CHAINMAIL = 1500;
    public static final int OBSIDIAN = 2111;
    public static final int ADAMANTIUM = 1741;
    public static final int ENDERITE = 2999;

    public static int scale(int base, ArmorItem.Type type) {
        return switch (type) {
            case HELMET -> (int)(base * 0.75);
            case CHESTPLATE, BODY -> base;
            case LEGGINGS -> (int)(base * 0.9);
            case BOOTS -> (int)(base * 0.65);
        };
    }

}


