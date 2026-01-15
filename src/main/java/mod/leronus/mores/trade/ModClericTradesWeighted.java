package mod.leronus.mores.trade;

import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

import java.util.ArrayList;
import java.util.List;

public class ModClericTradesWeighted {

    private static boolean REGISTERED = false;

    public static void register() {
        if (REGISTERED) return;
        REGISTERED = true;

        // NOVICE (2 slots vanilla)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> {
            factories.clear();
            factories.add(TradeFactoryUtil.buyItemForEmeralds(Items.ROTTEN_FLESH, 32, 1, 16, 2, 0.05f));
            factories.add(new TradeOffers.SellItemFactory(Items.REDSTONE, 1, 2, 12, 1, 0.05f));
        });

        // APPRENTICE (2 slots vanilla)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 2, factories -> {
            factories.clear();
            factories.add(TradeFactoryUtil.buyItemForEmeralds(Items.GOLD_INGOT, 3, 1, 12, 10, 0.05f));
            factories.add(new TradeOffers.SellItemFactory(Items.LAPIS_LAZULI, 1, 1, 12, 5, 0.05f));
        });

        // JOURNEYMAN (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 3, factories -> {
            factories.clear();
            Random random = Random.create();

            List<WeightedTrade> guaranteed = new ArrayList<>();
            List<WeightedTrade> pool = new ArrayList<>();

            guaranteed.add(new WeightedTrade("BUY_RABBIT_FOOT", 1,
                    TradeFactoryUtil.buyItemForEmeralds(Items.RABBIT_FOOT, 2, 1, 12, 20, 0.05f)));

            guaranteed.add(new WeightedTrade("SELL_GLOWSTONE", 1,
                    new TradeOffers.SellItemFactory(Items.GLOWSTONE, 4, 1, 12, 10, 0.05f)));

            // jouw fix: lapis gem XP 30 -> 20
            pool.add(new WeightedTrade("BUY_LAPIS_GEM", 60,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.LAPIS_LAZULI_GEM, 1, 1, 12, 20, 0.05f)));

            pool.add(new WeightedTrade("BUY_TURQUOISE_GEM", 40,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TURQUOISE_GEM, 1, 1, 12, 20, 0.05f)));

            WeightedTradeSelector.selectWithGuaranteed(guaranteed, pool, 3, random)
                    .forEach(t -> factories.add(t.factory()));
        });

        // EXPERT (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 4, factories -> {
            factories.clear();
            Random random = Random.create();

            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_TURTLE_SCUTE", 34,
                    TradeFactoryUtil.buyItemForEmeralds(Items.TURTLE_SCUTE, 4, 1, 12, 30, 0.05f)));
            pool.add(new WeightedTrade("BUY_GLASS_BOTTLE", 33,
                    TradeFactoryUtil.buyItemForEmeralds(Items.GLASS_BOTTLE, 9, 1, 12, 30, 0.05f)));
            pool.add(new WeightedTrade("SELL_ENDER_PEARL", 33,
                    new TradeOffers.SellItemFactory(Items.ENDER_PEARL, 5, 1, 12, 15, 0.05f)));

            // jouw fix: amethyst XP 15 -> 30
            pool.add(new WeightedTrade("BUY_CITRINE_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.CITRINE_GEM, 1, 1, 12, 30, 0.05f)));
            pool.add(new WeightedTrade("BUY_AMETHYST_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.AMETHYST_GEM, 1, 1, 12, 30, 0.05f)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        // MASTER (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 5, factories -> {
            factories.clear();
            Random random = Random.create();

            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_NETHER_WART", 34,
                    TradeFactoryUtil.buyItemForEmeralds(Items.NETHER_WART, 22, 1, 12, 30, 0.05f)));

            pool.add(new WeightedTrade("SELL_XP_BOTTLE", 33,
                    new TradeOffers.SellItemFactory(Items.EXPERIENCE_BOTTLE, 3, 1, 12, 30, 0.05f)));

            // jouw fix: quartz dust multiplier 0.04 -> 0.05
            pool.add(new WeightedTrade("BUY_QUARTZ_DUST", 33,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.QUARTZ_DUST, 24, 1, 16, 20, 0.05f)));

            pool.add(new WeightedTrade("BUY_ONYX_GEM", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.ONYX_GEM, 1, 1, 12, 30, 0.05f)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });
    }
}
