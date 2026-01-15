package mod.leronus.mores.trade;

import mod.leronus.mores.mixin.TradeOffersAccessor;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

import java.util.Map;

public final class VillagerTradeOverwriter {

    private VillagerTradeOverwriter() {}

    /**
     * Replaces ALL trades for a profession.
     *
     * tradesByLevel must be length 5 (levels 1..5), each entry is an array of factories for that level.
     *
     * This is the key to "vanilla + mores mixed" WITHOUT duplicates:
     * we replace vanilla's table, so vanilla isn't injected anymore for those professions.
     */
    public static void replaceProfessionTrades(VillagerProfession profession, TradeOffers.Factory[][] tradesByLevel) {
        if (tradesByLevel == null || tradesByLevel.length != 5) {
            throw new IllegalArgumentException("tradesByLevel must be length 5 (levels 1..5).");
        }

        Map<VillagerProfession, TradeOffers.Factory[][]> map =
                TradeOffersAccessor.mores$getProfessionToLeveledTrade();

        map.put(profession, tradesByLevel);
    }
}
