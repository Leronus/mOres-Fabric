package mod.leronus.mores.trade;

import net.minecraft.village.TradeOffers;

/** Weighted entry with a de-dupe key. Use per-item keys (not per-category) unless you want category de-dupe. */
public record WeightedTrade(String key, int weight, TradeOffers.Factory factory) {
    public String effectiveKey() {
        if (key != null && !key.isBlank()) return key;
        return "UNKEYED@" + System.identityHashCode(this);
    }
}
