package mod.leronus.mores.trade;

import net.minecraft.village.TradeOffers;

/**
 * One trade entry plus its selection weight.
 * In spreadsheets, we treat "Probability" as "Weight".
 * - Higher weight = trade is chosen more often.
 * - This is NOT a chance roll that can fail; it's weighted selection.
 */
public record WeightedTrade(int weight, TradeOffers.Factory factory) {}
