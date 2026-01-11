package mod.leronus.mores.registry;

import mod.leronus.mores.trade.ModArmorerTradesWeighted;
import mod.leronus.mores.trade.ModClericTradesWeighted;
import mod.leronus.mores.trade.ModToolsmithTradesWeighted;
import mod.leronus.mores.trade.ModWeaponsmithTradesWeighted;

public final class ModCustomTrades {
    private ModCustomTrades() {}

    public static void registerCustomTrades() {
        ModArmorerTradesWeighted.register();
        ModClericTradesWeighted.register();
        ModToolsmithTradesWeighted.register();
        ModWeaponsmithTradesWeighted.register();
    }
}
