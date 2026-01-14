package mod.leronus.mores.trade;

import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

import java.util.ArrayList;
import java.util.List;

public class ModWeaponsmithTradesWeighted {

    public static void register() {

        /* ==================== NOVICE (3 trades) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 1, factories -> {
            factories.clear();

            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY:COAL", 40,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COAL, 15, 1, 16, 2)));
            pool.add(new KeyedTrade("BUY:TIN_INGOT", 30,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TIN_INGOT, 26, 1, 16, 2)));

            pool.add(new KeyedTrade("SWORD", 15, new TradeOffers.SellItemFactory(Items.IRON_SWORD, 3, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("DAGGER", 20, new TradeOffers.SellItemFactory(ModItems.IRON_DAGGER, 2, 1, 12, 1, 0.2f)));

            pool.add(new KeyedTrade("SWORD", 20, new TradeOffers.SellItemFactory(ModItems.COBALT_SWORD, 3, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("DAGGER", 20, new TradeOffers.SellItemFactory(ModItems.COBALT_DAGGER, 2, 1, 12, 1, 0.2f)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== APPRENTICE (3 trades) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 2, factories -> {
            factories.clear();

            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY:IRON_INGOT", 60,
                    TradeFactoryUtil.buyItemForEmeralds(Items.IRON_INGOT, 4, 1, 12, 10)));
            pool.add(new KeyedTrade("SELL:BELL", 60,
                    new TradeOffers.SellItemFactory(Items.BELL, 36, 1, 12, 5, 0.2f)));

            // FIXED payouts
            pool.add(new KeyedTrade("BUY:SILVER_INGOT", 60,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SILVER_INGOT, 7, 1, 12, 10)));
            pool.add(new KeyedTrade("BUY:COPPER_INGOT", 60,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COPPER_INGOT, 10, 1, 12, 10)));
            pool.add(new KeyedTrade("BUY:COBALT_INGOT", 60,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.COBALT_INGOT, 4, 1, 12, 10)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== JOURNEYMAN (3 trades) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3, factories -> {
            factories.clear();

            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY:FLINT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.FLINT, 24, 1, 12, 20)));
            pool.add(new KeyedTrade("BUY:STERLING_SILVER_INGOT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.STERLING_SILVER_INGOT, 2, 1, 12, 20)));
            pool.add(new KeyedTrade("BUY:MOISSANITE_GEM", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.MOISSANITE_GEM, 1, 1, 12, 20)));

            // Example sell pool (kept as in your file): ensure key prevents duplicates
            pool.add(new KeyedTrade("DAGGER", 35,
                    new TradeOffers.SellItemFactory(ModItems.TANZANITE_DAGGER, 2, 1, 3, 10, 0.2f)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== MASTER (3 trades) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 5, factories -> {
            factories.clear();

            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BATTLE_AXE", 55,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_BATTLE_AXE, 18, 32, 3, 30)));

            pool.add(new KeyedTrade("SELL:OBSIDIAN_TEMPLATE", 10,
                    new TradeOffers.SellItemFactory(ModItems.OBSIDIAN_UPGRADE_SMITHING_TEMPLATE, 60, 1, 1, 30, 0.5f)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });
    }
}
