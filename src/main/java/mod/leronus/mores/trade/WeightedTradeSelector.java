package mod.leronus.mores.trade;

import net.minecraft.util.math.random.Random;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility for picking a fixed number of UNIQUE trades from a weighted pool.
 * This gives you "always N trades, chosen by weight".
 */
public final class WeightedTradeSelector {

    private WeightedTradeSelector() {}

    /**
     * Select exactly {@code count} UNIQUE entries from {@code pool} using weights.
     */
    public static List<WeightedTrade> select(List<WeightedTrade> pool, int count, Random random) {
        List<WeightedTrade> available = new ArrayList<>(pool);
        List<WeightedTrade> selected = new ArrayList<>();

        for (int i = 0; i < count && !available.isEmpty(); i++) {
            int totalWeight = 0;
            for (WeightedTrade t : available) totalWeight += Math.max(0, t.weight());

            // If all weights are 0, fall back to uniform selection.
            if (totalWeight <= 0) {
                int idx = random.nextInt(available.size());
                selected.add(available.remove(idx));
                continue;
            }

            int roll = random.nextInt(totalWeight);
            int acc = 0;

            for (int j = 0; j < available.size(); j++) {
                WeightedTrade t = available.get(j);
                acc += Math.max(0, t.weight());
                if (roll < acc) {
                    selected.add(t);
                    available.remove(j);
                    break;
                }
            }
        }

        return selected;
    }

    /**
     * Convenience helper:
     * - First adds all "guaranteed" trades (e.g. 100% rows)
     * - Then fills remaining slots from a weighted pool.
     * This is useful for tables like Cleric:
     * - some rows are 100% (must always appear)
     * - then still "total 3 trades"
     */
    public static List<WeightedTrade> selectWithGuaranteed(
            List<WeightedTrade> guaranteed,
            List<WeightedTrade> weightedPool,
            int totalCount,
            Random random
    ) {
        List<WeightedTrade> result = new ArrayList<>(guaranteed);

        int remaining = totalCount - result.size();
        if (remaining > 0) {
            result.addAll(select(weightedPool, remaining, random));
        }

        // If guaranteed > totalCount (shouldn't happen), trim.
        if (result.size() > totalCount) {
            return result.subList(0, totalCount);
        }
        return result;
    }
}
