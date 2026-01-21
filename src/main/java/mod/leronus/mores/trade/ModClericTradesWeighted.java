package mod.leronus.mores.trade;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import mod.leronus.mores.item.ModItems;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffers;

import java.util.ArrayList;
import java.util.List;

public class ModClericTradesWeighted {

    public static Int2ObjectMap<TradeOffers.Factory[]> buildLeveledTradeMap() {
        Int2ObjectMap<TradeOffers.Factory[]> out = new Int2ObjectOpenHashMap<>();
        Random r = Random.create();

        // ==================== LEVEL 1 (2 slots) ====================
        {
            TradeOffers.Factory[] trades = new TradeOffers.Factory[] {
                    // 32 Rotten Flesh -> 1 Emerald (stock 16, xp 2, mult 0.05)
                    TradeFactoryUtil.buyItemForEmeralds(Items.ROTTEN_FLESH, 32, 1, 16, 2, 0.05f),

                    // 1 Emerald -> 2 Redstone Dust (stock 12, xp 1, mult 0.05)
                    new TradeOffers.SellItemFactory(Items.REDSTONE, 1, 2, 12, 1, 0.05f)
            };
            out.put(1, trades);
        }

        // ==================== LEVEL 2 (2 slots) ====================
        {
            TradeOffers.Factory[] trades = new TradeOffers.Factory[] {
                    // 3 Gold Ingot -> 1 Emerald (stock 12, xp 10, mult 0.05)
                    TradeFactoryUtil.buyItemForEmeralds(Items.GOLD_INGOT, 3, 1, 12, 10, 0.05f),

                    // 1 Emerald -> 1 Lapis Lazuli (stock 12, xp 5, mult 0.05)
                    new TradeOffers.SellItemFactory(Items.LAPIS_LAZULI, 1, 1, 12, 5, 0.05f)
            };
            out.put(2, trades);
        }

        // ==================== LEVEL 3 (3 slots) ====================
        // Always include the 2 vanilla trades, plus 1 extra gem trade (50/50)
        {
            TradeOffers.Factory fixed1 =
                    TradeFactoryUtil.buyItemForEmeralds(Items.RABBIT_FOOT, 2, 1, 12, 20, 0.05f);

            TradeOffers.Factory fixed2 =
                    new TradeOffers.SellItemFactory(Items.GLOWSTONE, 4, 1, 12, 10, 0.05f);

            List<WeightedTrade> extraPool = new ArrayList<>();
            // 50% Lapis Gem -> Emerald (xp corrected to 20)
            extraPool.add(new WeightedTrade("BUY_LAPIS_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.LAPIS_LAZULI_GEM, 1, 1, 12, 20, 0.05f)));
            // 50% Turquoise Gem -> Emerald (xp 20)
            extraPool.add(new WeightedTrade("BUY_TURQUOISE_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TURQUOISE_GEM, 1, 1, 12, 20, 0.05f)));

            TradeOffers.Factory extra = pick(extraPool, 1, r)[0];

            out.put(3, new TradeOffers.Factory[] { fixed1, fixed2, extra });
        }

        // ==================== LEVEL 4 (3 slots) ====================
        // Pick 3 from the sheet list with weights (67 vs 50).
        {
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_TURTLE_SCUTE", 67,
                    TradeFactoryUtil.buyItemForEmeralds(Items.TURTLE_SCUTE, 4, 1, 12, 30, 0.05f)));

            pool.add(new WeightedTrade("BUY_GLASS_BOTTLE", 67,
                    TradeFactoryUtil.buyItemForEmeralds(Items.GLASS_BOTTLE, 9, 1, 12, 30, 0.05f)));

            // 5 Emerald -> 1 Ender Pearl (stock 12, xp 15, mult 0.05)
            pool.add(new WeightedTrade("SELL_ENDER_PEARL", 67,
                    new TradeOffers.SellItemFactory(Items.ENDER_PEARL, 5, 1, 12, 15, 0.05f)));

            pool.add(new WeightedTrade("BUY_CITRINE_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.CITRINE_GEM, 1, 1, 12, 30, 0.05f)));

            // Amethyst gem xp corrected to 30
            pool.add(new WeightedTrade("BUY_AMETHYST_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.AMETHYST_GEM, 1, 1, 12, 30, 0.05f)));

            out.put(4, pick(pool, 3, r));
        }

        // ==================== LEVEL 5 (3 slots) ====================
        // Pick 3 from 4 (all 50%), with Quartz Dust multiplier corrected to 0.05.
        {
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_NETHER_WART", 50,
                    TradeFactoryUtil.buyItemForEmeralds(Items.NETHER_WART, 22, 1, 12, 30, 0.05f)));

            pool.add(new WeightedTrade("SELL_XP_BOTTLE", 50,
                    new TradeOffers.SellItemFactory(Items.EXPERIENCE_BOTTLE, 3, 1, 12, 30, 0.05f)));

            // Quartz Dust multiplier corrected to 0.05 (and wants 24 for 1 emerald, stock 16, xp 20)
            pool.add(new WeightedTrade("BUY_QUARTZ_DUST", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.QUARTZ_DUST, 24, 1, 16, 20, 0.05f)));

            pool.add(new WeightedTrade("BUY_ONYX_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.ONYX_GEM, 1, 1, 12, 30, 0.05f)));

            out.put(5, pick(pool, 3, r));
        }

        return out;
    }

    private static TradeOffers.Factory[] pick(List<WeightedTrade> pool, int count, Random r) {
        return WeightedTradeSelector.select(pool, Math.min(count, pool.size()), r)
                .stream()
                .map(WeightedTrade::factory)
                .toArray(TradeOffers.Factory[]::new);
    }
}
