package mod.leronus.mores.trade;

import mod.leronus.mores.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;

import java.util.ArrayList;
import java.util.List;

public class ModClericTradesWeighted {

    public static void addLevelOffers(Entity villager, TradeOfferList offers, int level, Random r) {

        // ==================== LEVEL 1 (2 slots) ====================
        if (level == 1) {
            // 32 Rotten Flesh -> 1 Emerald (stock 16, xp 2, mult 0.05)
            addFactory(offers,
                    TradeFactoryUtil.buyItemForEmeralds(Items.ROTTEN_FLESH, 32, 1, 16, 2, 0.05f),
                    villager, r);

            // 1 Emerald -> 2 Redstone Dust (stock 12, xp 1, mult 0.05)
            addFactory(offers,
                    new TradeOffers.SellItemFactory(Items.REDSTONE, 1, 2, 12, 1, 0.05f),
                    villager, r);

            return;
        }

        // ==================== LEVEL 2 (2 slots) ====================
        if (level == 2) {
            // 3 Gold Ingot -> 1 Emerald (stock 12, xp 10, mult 0.05)
            addFactory(offers,
                    TradeFactoryUtil.buyItemForEmeralds(Items.GOLD_INGOT, 3, 1, 12, 10, 0.05f),
                    villager, r);

            // 1 Emerald -> 1 Lapis Lazuli (stock 12, xp 5, mult 0.05)
            addFactory(offers,
                    new TradeOffers.SellItemFactory(Items.LAPIS_LAZULI, 1, 1, 12, 5, 0.05f),
                    villager, r);

            return;
        }

        // ==================== LEVEL 3 (3 slots) ====================
        // Always include the 2 fixed trades, plus 1 extra gem trade (50/50)
        if (level == 3) {
            addFactory(offers,
                    TradeFactoryUtil.buyItemForEmeralds(Items.RABBIT_FOOT, 2, 1, 12, 20, 0.05f),
                    villager, r);

            addFactory(offers,
                    new TradeOffers.SellItemFactory(Items.GLOWSTONE, 4, 1, 12, 10, 0.05f),
                    villager, r);

            List<KeyedTrade> extraPool = new ArrayList<>();
            // Lapis gem xp corrected to 20
            extraPool.add(new KeyedTrade("BUY_LAPIS_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.LAPIS_LAZULI_GEM, 1, 1, 12, 20, 0.05f)));
            extraPool.add(new KeyedTrade("BUY_TURQUOISE_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TURQUOISE_GEM, 1, 1, 12, 20, 0.05f)));

            addSelected(extraPool, offers, 1, villager, r);
            return;
        }

        // ==================== LEVEL 4 (3 slots) ====================
        // Pick 3 from list with weights (67 vs 50)
        if (level == 4) {
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY_TURTLE_SCUTE", 67,
                    TradeFactoryUtil.buyItemForEmeralds(Items.TURTLE_SCUTE, 4, 1, 12, 30, 0.05f)));

            pool.add(new KeyedTrade("BUY_GLASS_BOTTLE", 67,
                    TradeFactoryUtil.buyItemForEmeralds(Items.GLASS_BOTTLE, 9, 1, 12, 30, 0.05f)));

            pool.add(new KeyedTrade("SELL_ENDER_PEARL", 67,
                    new TradeOffers.SellItemFactory(Items.ENDER_PEARL, 5, 1, 12, 15, 0.05f)));

            pool.add(new KeyedTrade("BUY_CITRINE_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.CITRINE_GEM, 1, 1, 12, 30, 0.05f)));

            // Amethyst gem xp corrected to 30
            pool.add(new KeyedTrade("BUY_AMETHYST_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.AMETHYST_GEM, 1, 1, 12, 30, 0.05f)));

            addSelected(pool, offers, 3, villager, r);
            return;
        }

        // ==================== LEVEL 5 (3 slots) ====================
        // Pick 3 from 4 (all 50%), Quartz Dust multiplier corrected to 0.05
        if (level == 5) {
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY_NETHER_WART", 50,
                    TradeFactoryUtil.buyItemForEmeralds(Items.NETHER_WART, 22, 1, 12, 30, 0.05f)));

            pool.add(new KeyedTrade("SELL_XP_BOTTLE", 50,
                    new TradeOffers.SellItemFactory(Items.EXPERIENCE_BOTTLE, 3, 1, 12, 30, 0.05f)));

            // Quartz Dust multiplier corrected to 0.05
            pool.add(new KeyedTrade("BUY_QUARTZ_DUST", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.QUARTZ_DUST, 24, 1, 16, 20, 0.05f)));

            pool.add(new KeyedTrade("BUY_ONYX_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.ONYX_GEM, 1, 1, 12, 30, 0.05f)));

            addSelected(pool, offers, 3, villager, r);
        }
    }

    private static void addSelected(List<KeyedTrade> pool, TradeOfferList offers, int count, Entity villager, Random r) {
        if (pool.isEmpty() || count <= 0) return;

        List<KeyedTrade> selected = KeyedTradeSelector.select(pool, Math.min(count, pool.size()), r);
        for (KeyedTrade kt : selected) {
            TradeOffer offer = kt.factory().create(villager, r);
            if (offer != null) offers.add(offer);
        }
    }

    private static void addFactory(TradeOfferList offers, TradeOffers.Factory factory, Entity villager, Random r) {
        TradeOffer offer = factory.create(villager, r);
        if (offer != null) offers.add(offer);
    }
}
