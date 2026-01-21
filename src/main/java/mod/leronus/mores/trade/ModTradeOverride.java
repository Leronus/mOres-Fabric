package mod.leronus.mores.trade;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

import java.util.Map;

import static mod.leronus.mores.mixin.TradeOffersAccessor.mores$getProfessionToLeveledTrade;

public final class ModTradeOverride {

    private static boolean REGISTERED = false;

    private ModTradeOverride() {}

    public static void registerCustomTrades() {
        if (REGISTERED) return;
        REGISTERED = true;

        // Run when server is starting (after mods like Repurposed Structures have registered their trades)
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            Map<VillagerProfession, Int2ObjectMap<TradeOffers.Factory[]>> profMap =
                    mores$getProfessionToLeveledTrade();

            // Replace ONLY these professions’ leveled trade maps (type stays Int2ObjectMap -> safe for other mods)
            profMap.put(VillagerProfession.ARMORER, ModArmorerTradesWeighted.buildLeveledTradeMap());
            profMap.put(VillagerProfession.TOOLSMITH, ModToolsmithTradesWeighted.buildLeveledTradeMap());
            profMap.put(VillagerProfession.WEAPONSMITH, ModWeaponsmithTradesWeighted.buildLeveledTradeMap());
            profMap.put(VillagerProfession.CLERIC, ModClericTradesWeighted.buildLeveledTradeMap());
        });
    }
}
