package mod.leronus.mores.trade;

import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

import java.util.ArrayList;
import java.util.List;

/**
 * Cleric trades:
 * - Novice + Apprentice are fully fixed (table shows 100% rows only)
 * - Journeyman/Expert/Master want 3 trades total.
 * - Where your table has 100% rows AND still says "(3 slots)",
 *   we GUARANTEE those and only weight-roll the remaining slot(s).
 */
public class ModClericTradesWeighted {

    public static void register() {

        /* ==================== NOVICE (fixed 100%) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> {
            // 32 Rotten Flesh -> Emerald
            factories.add(new TradeOffers.BuyItemFactory(
                    Items.ROTTEN_FLESH, 32, 1, 16, 2));

            // Emerald -> 2 Redstone Dust
            factories.add(new TradeOffers.SellItemFactory(
                    Items.REDSTONE, 1, 2, 12, 1, 0.05f));
        });

        /* ==================== APPRENTICE (fixed 100%) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 2, factories -> {
            // 3 Gold Ingot -> Emerald
            factories.add(new TradeOffers.BuyItemFactory(
                    Items.GOLD_INGOT, 3, 1, 12, 10));

            // Emerald -> Lapis Lazuli (your sheet didn’t specify count; commonly 1)
            factories.add(new TradeOffers.SellItemFactory(
                    Items.LAPIS_LAZULI, 1, 1, 12, 5, 0.05f));
        });

        /* ==================== JOURNEYMAN (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 3, factories -> {
            Random random = Random.create();

            // Guaranteed (100%) trades
            List<WeightedTrade> guaranteed = new ArrayList<>();
            guaranteed.add(new WeightedTrade(100,
                    new TradeOffers.BuyItemFactory(Items.RABBIT_FOOT, 2, 1, 12, 20)));
            guaranteed.add(new WeightedTrade(100,
                    new TradeOffers.SellItemFactory(Items.GLOWSTONE, 4, 1, 12, 10, 0.05f)));

            // Weighted optional trades for remaining slot(s)
            List<WeightedTrade> weighted = new ArrayList<>();
            weighted.add(new WeightedTrade(50,
                    new TradeOffers.BuyItemFactory(ModItems.LAPIS_LAZULI_GEM, 1, 1, 12, 30)));
            weighted.add(new WeightedTrade(50,
                    new TradeOffers.BuyItemFactory(ModItems.TURQUOISE_GEM, 1, 1, 12, 20)));

            WeightedTradeSelector
                    .selectWithGuaranteed(guaranteed, weighted, 3, random)
                    .forEach(t -> factories.add(t.factory()));
        });

        /* ==================== EXPERT (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 4, factories -> {
            Random random = Random.create();

            // No 100% rows here, so just weight-select 3 from full pool.
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade(67,
                    new TradeOffers.BuyItemFactory(Items.TURTLE_SCUTE, 4, 1, 12, 30)));
            pool.add(new WeightedTrade(67,
                    new TradeOffers.BuyItemFactory(Items.GLASS_BOTTLE, 9, 1, 12, 30)));
            pool.add(new WeightedTrade(67,
                    new TradeOffers.SellItemFactory(Items.ENDER_PEARL, 5, 1, 12, 15, 0.05f)));

            pool.add(new WeightedTrade(50,
                    new TradeOffers.BuyItemFactory(ModItems.CITRINE_GEM, 1, 1, 12, 30)));
            pool.add(new WeightedTrade(50,
                    new TradeOffers.BuyItemFactory(ModItems.AMETHYST_GEM, 1, 1, 12, 15)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== MASTER (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 5, factories -> {
            Random random = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade(50,
                    new TradeOffers.BuyItemFactory(Items.NETHER_WART, 22, 1, 12, 30)));
            pool.add(new WeightedTrade(50,
                    new TradeOffers.SellItemFactory(Items.EXPERIENCE_BOTTLE, 3, 1, 12, 30, 0.05f)));
            pool.add(new WeightedTrade(50,
                    new TradeOffers.BuyItemFactory(ModItems.QUARTZ_DUST, 24, 1, 16, 20)));
            pool.add(new WeightedTrade(50,
                    new TradeOffers.BuyItemFactory(ModItems.ONYX_GEM, 1, 1, 12, 30)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });
    }
}
