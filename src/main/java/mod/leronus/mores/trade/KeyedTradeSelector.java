package mod.leronus.mores.trade;

import net.minecraft.util.math.random.Random;

import java.util.ArrayList;
import java.util.List;

/**
 * Weighted selection of exactly N trades, WITHOUT allowing duplicate keys.
 * When one trade is selected, all remaining trades with the same key are removed.
 */
public final class KeyedTradeSelector {

    private KeyedTradeSelector() {}

    public static List<KeyedTrade> select(List<KeyedTrade> pool, int count, Random random) {
        List<KeyedTrade> available = new ArrayList<>(pool);
        List<KeyedTrade> selected = new ArrayList<>();

        for (int i = 0; i < count && !available.isEmpty(); i++) {
            int totalWeight = 0;
            for (KeyedTrade t : available) totalWeight += Math.max(0, t.weight());

            int pickedIndex;
            if (totalWeight <= 0) {
                pickedIndex = random.nextInt(available.size());
            } else {
                int roll = random.nextInt(totalWeight);
                int acc = 0;
                pickedIndex = 0;

                for (int j = 0; j < available.size(); j++) {
                    KeyedTrade t = available.get(j);
                    acc += Math.max(0, t.weight());
                    if (roll < acc) {
                        pickedIndex = j;
                        break;
                    }
                }
            }

            KeyedTrade picked = available.get(pickedIndex);
            selected.add(picked);

            // Remove the picked trade and all trades sharing the same key.
            String key = picked.key();
            available.removeIf(t -> t.key().equals(key));
        }

        return selected;
    }

    public static List<KeyedTrade> selectWithGuaranteed(
            List<KeyedTrade> guaranteed,
            List<KeyedTrade> weightedPool,
            int totalCount,
            Random random
    ) {
        List<KeyedTrade> result = new ArrayList<>(guaranteed);

        int remaining = totalCount - result.size();
        if (remaining > 0) {
            // Also ensure guaranteed keys don't appear again in weighted pool.
            List<KeyedTrade> filtered = new ArrayList<>(weightedPool);
            for (KeyedTrade g : guaranteed) {
                filtered.removeIf(t -> t.key().equals(g.key()));
            }
            result.addAll(select(filtered, remaining, random));
        }

        if (result.size() > totalCount) {
            return result.subList(0, totalCount);
        }
        return result;
    }
}
