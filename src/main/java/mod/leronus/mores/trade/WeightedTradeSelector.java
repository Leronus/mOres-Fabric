package mod.leronus.mores.trade;

import net.minecraft.util.math.random.Random;

import java.util.*;

public final class WeightedTradeSelector {

    private WeightedTradeSelector() {}

    /** Select exactly count trades from pool, no duplicate keys. */
    public static List<WeightedTrade> select(List<WeightedTrade> pool, int count, Random random) {
        List<WeightedTrade> available = new ArrayList<>(pool);
        List<WeightedTrade> out = new ArrayList<>();
        Set<String> used = new HashSet<>();

        while (out.size() < count && !available.isEmpty()) {
            List<WeightedTrade> filtered = new ArrayList<>();
            for (WeightedTrade t : available) {
                if (!used.contains(t.effectiveKey())) filtered.add(t);
            }
            if (filtered.isEmpty()) break;

            int total = 0;
            for (WeightedTrade t : filtered) total += Math.max(0, t.weight());

            WeightedTrade picked;
            if (total <= 0) {
                picked = filtered.get(random.nextInt(filtered.size()));
            } else {
                int roll = random.nextInt(total);
                int acc = 0;
                picked = filtered.get(0);
                for (WeightedTrade t : filtered) {
                    acc += Math.max(0, t.weight());
                    if (roll < acc) {
                        picked = t;
                        break;
                    }
                }
            }

            out.add(picked);
            used.add(picked.effectiveKey());

            String k = picked.effectiveKey();
            available.removeIf(t -> t.effectiveKey().equals(k));
        }

        return out;
    }

    /** Guaranteed first, then weighted fill to totalCount, no duplicate keys across both groups. */
    public static List<WeightedTrade> selectWithGuaranteed(
            List<WeightedTrade> guaranteed,
            List<WeightedTrade> pool,
            int totalCount,
            Random random
    ) {
        List<WeightedTrade> out = new ArrayList<>();
        Set<String> used = new HashSet<>();

        for (WeightedTrade g : guaranteed) {
            if (out.size() >= totalCount) break;
            String k = g.effectiveKey();
            if (used.add(k)) out.add(g);
        }

        int remaining = totalCount - out.size();
        if (remaining <= 0) return out;

        List<WeightedTrade> filteredPool = new ArrayList<>();
        for (WeightedTrade t : pool) {
            if (!used.contains(t.effectiveKey())) filteredPool.add(t);
        }

        out.addAll(select(filteredPool, remaining, random));
        if (out.size() > totalCount) return out.subList(0, totalCount);
        return out;
    }
}
