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

    public static void register() {

        /* ==================== NOVICE (fixed 100%) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> {
            factories.clear();

            factories.add(TradeFactoryUtil.buyItemForEmeralds(Items.ROTTEN_FLESH, 32, 1, 16, 2));

            factories.add(new TradeOffers.SellItemFactory(
                    Items.REDSTONE, 1, 2, 12, 1, 0.05f));
        });

        /* ==================== APPRENTICE (fixed 100%) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 2, factories -> {
            factories.clear();

            factories.add(TradeFactoryUtil.buyItemForEmeralds(Items.GOLD_INGOT, 3, 1, 12, 10));

            factories.add(new TradeOffers.SellItemFactory(
                    Items.LAPIS_LAZULI, 1, 1, 12, 5, 0.05f));
        });

        /* ==================== JOURNEYMAN (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 3, factories -> {
            factories.clear();
            Random random = Random.create();

            List<KeyedTrade> guaranteed = new ArrayList<>();
            guaranteed.add(new KeyedTrade("BUY:RABBIT_FOOT", 100,
                    TradeFactoryUtil.buyItemForEmeralds(Items.RABBIT_FOOT, 2, 1, 12, 20)));
            guaranteed.add(new KeyedTrade("SELL:GLOWSTONE", 100,
                    new TradeOffers.SellItemFactory(Items.GLOWSTONE, 4, 1, 12, 10, 0.05f)));

            List<KeyedTrade> weighted = new ArrayList<>();
            weighted.add(new KeyedTrade("BUY:LAPIS_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.LAPIS_LAZULI_GEM, 1, 1, 12, 30)));
            weighted.add(new KeyedTrade("BUY:TURQUOISE_GEM", 50,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TURQUOISE_GEM, 1, 1, 12, 20)));

            KeyedTradeSelector.selectWithGuaranteed(guaranteed, weighted, 3, random)
                    .forEach(t -> factories.add(t.factory()));
        });

        /* ==================== EXPERT (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 4, factories -> {
            factories.clear();
            Random random = Random.create();

            List<KeyedTrade> pool = new ArrayList<>();
            pool.add(new KeyedTrade("BUY:TURTLE_SCUTE", 67, TradeFactoryUtil.buyItemForEmeralds(Items.TURTLE_SCUTE, 4, 1, 12, 30)));
            pool.add(new KeyedTrade("BUY:GLASS_BOTTLE", 67, TradeFactoryUtil.buyItemForEmeralds(Items.GLASS_BOTTLE, 9, 1, 12, 30)));
            pool.add(new KeyedTrade("SELL:ENDER_PEARL", 67, new TradeOffers.SellItemFactory(Items.ENDER_PEARL, 5, 1, 12, 15, 0.05f)));

            pool.add(new KeyedTrade("BUY:CITRINE_GEM", 50, TradeFactoryUtil.buyItemForEmeralds(ModItems.CITRINE_GEM, 1, 1, 12, 30)));
            pool.add(new KeyedTrade("BUY:AMETHYST_GEM", 50, TradeFactoryUtil.buyItemForEmeralds(ModItems.AMETHYST_GEM, 1, 1, 12, 15)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== MASTER (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 5, factories -> {
            factories.clear();
            Random random = Random.create();

            List<KeyedTrade> pool = new ArrayList<>();
            pool.add(new KeyedTrade("BUY:NETHER_WART", 50, TradeFactoryUtil.buyItemForEmeralds(Items.NETHER_WART, 22, 1, 12, 30)));
            pool.add(new KeyedTrade("SELL:BOTTLE_O_ENCHANTING", 50, new TradeOffers.SellItemFactory(Items.EXPERIENCE_BOTTLE, 3, 1, 12, 30, 0.05f)));

            // keep your other master rows here if they exist in your file

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });
    }
}
