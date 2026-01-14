package mod.leronus.mores.trade;

import net.minecraft.village.TradeOffers;

/**
 * Like WeightedTrade, but with a "key" used to prevent duplicates.
 * Example keys:
 *  - "AXE", "PICKAXE", "HELMET"
 *  - "BUY:moditems:silver_ingot"
 *  - "SELL:minecraft:bell"
 */
public record KeyedTrade(String key, int weight, TradeOffers.Factory factory) {}
