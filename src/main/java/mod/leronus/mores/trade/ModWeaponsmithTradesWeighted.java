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

public class ModWeaponsmithTradesWeighted {

    public static void addLevelOffers(Entity villager, TradeOfferList offers, int level, Random r) {

        // ==================== LEVEL 1: 1 buy + 2 sell ====================
        if (level == 1) {
            List<KeyedTrade> buyPool = new ArrayList<>();
            List<KeyedTrade> sellPool = new ArrayList<>();

            buyPool.add(new KeyedTrade("BUY_COAL", 50,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COAL, 15, 1, 16, 2, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_ANTHRACITE", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.ANTHRACITE, 9, 1, 12, 2, 0.05f)));

            // give these distinct keys so the villager can roll e.g. sword + dagger
            sellPool.add(new KeyedTrade("SELL_IRON_SWORD", 25,
                    new TradeOffers.SellItemFactory(Items.IRON_SWORD, 3, 1, 12, 1, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_IRON_DAGGER", 25,
                    new TradeOffers.SellItemFactory(ModItems.IRON_DAGGER, 2, 1, 12, 1, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_IRON_BATTLE_AXE", 25,
                    new TradeOffers.SellItemFactory(ModItems.IRON_BATTLE_AXE, 4, 1, 12, 1, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_IRON_BATTLE_MACE", 25,
                    new TradeOffers.SellItemFactory(ModItems.IRON_BATTLE_MACE, 4, 1, 12, 1, 0.20f)));

            addSelected(buyPool, offers, 1, villager, r);
            addSelected(sellPool, offers, 2, villager, r);
            return;
        }

        // ==================== LEVEL 2 (3 slots) ====================
        if (level == 2) {
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY_IRON", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.IRON_INGOT, 4, 1, 12, 10, 0.05f)));
            pool.add(new KeyedTrade("SELL_BELL", 25,
                    new TradeOffers.SellItemFactory(Items.BELL, 36, 1, 12, 5, 0.05f)));
            pool.add(new KeyedTrade("BUY_SILVER", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SILVER_INGOT, 7, 1, 12, 10, 0.05f)));
            pool.add(new KeyedTrade("BUY_COPPER", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COPPER_INGOT, 10, 1, 12, 10, 0.05f)));
            pool.add(new KeyedTrade("BUY_COBALT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.COBALT_INGOT, 4, 1, 12, 10, 0.05f)));
            pool.add(new KeyedTrade("BUY_TIN", 18,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TIN_INGOT, 26, 1, 16, 10, 0.05f)));

            addSelected(pool, offers, 3, villager, r);
            return;
        }

        // ==================== LEVEL 3 (3 slots): 2 buy + 1 dagger ====================
        // This avoids “3 random things” and keeps the intended structure stable per villager.
        if (level == 3) {
            List<KeyedTrade> buyPool = new ArrayList<>();
            List<KeyedTrade> daggerPool = new ArrayList<>();

            buyPool.add(new KeyedTrade("BUY_FLINT", 30,
                    TradeFactoryUtil.buyItemForEmeralds(Items.FLINT, 24, 1, 12, 20, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_STERLING_SILVER", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.STERLING_SILVER_INGOT, 2, 1, 12, 20, 0.05f)));

            // all daggers share the same “DAGGER” category key? NO: that would force only 1 total anyway.
            // Here we want 1 dagger slot, so we just select 1 from this pool.
            daggerPool.add(new KeyedTrade("SELL_DAGGER_MOISSANITE", 5,
                    new TradeOffers.SellItemFactory(ModItems.MOISSANITE_DAGGER, 3, 1, 3, 10, 0.20f)));
            daggerPool.add(new KeyedTrade("SELL_DAGGER_SAPPHIRE", 7,
                    new TradeOffers.SellItemFactory(ModItems.SAPPHIRE_DAGGER, 3, 1, 3, 10, 0.20f)));
            daggerPool.add(new KeyedTrade("SELL_DAGGER_RUBY", 6,
                    new TradeOffers.SellItemFactory(ModItems.RUBY_DAGGER, 3, 1, 3, 10, 0.20f)));
            daggerPool.add(new KeyedTrade("SELL_DAGGER_SPINEL", 9,
                    new TradeOffers.SellItemFactory(ModItems.SPINEL_DAGGER, 3, 1, 3, 10, 0.20f)));
            daggerPool.add(new KeyedTrade("SELL_DAGGER_TOPAZ", 9,
                    new TradeOffers.SellItemFactory(ModItems.TOPAZ_DAGGER, 3, 1, 3, 10, 0.20f)));
            daggerPool.add(new KeyedTrade("SELL_DAGGER_TOURMALINE", 8,
                    new TradeOffers.SellItemFactory(ModItems.TOURMALINE_DAGGER, 2, 1, 3, 10, 0.20f)));
            daggerPool.add(new KeyedTrade("SELL_DAGGER_TANZANITE", 7,
                    new TradeOffers.SellItemFactory(ModItems.TANZANITE_DAGGER, 2, 1, 3, 10, 0.20f)));

            addSelected(buyPool, offers, 2, villager, r);
            addSelected(daggerPool, offers, 1, villager, r);
            return;
        }

        // ==================== LEVEL 4 (3 slots) ====================
        if (level == 4) {
            List<KeyedTrade> buyPool = new ArrayList<>();
            List<KeyedTrade> sellPool = new ArrayList<>();

            buyPool.add(new KeyedTrade("BUY_TOPAZ", 20,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TOPAZ_GEM, 2, 1, 12, 20, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_TANZANITE", 20,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TANZANITE_GEM, 2, 1, 12, 20, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_TOURMALINE", 20,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TOURMALINE_GEM, 2, 1, 12, 20, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_SPINEL", 20,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SPINEL_GEM, 1, 1, 12, 20, 0.05f)));

            sellPool.add(new KeyedTrade("ENCH_SWORD_DIAMOND", 13,
                    new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_SWORD, 13, 3, 15, 0.20f)));
            sellPool.add(new KeyedTrade("ENCH_BATTLE_MACE_DIAMOND", 14,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.DIAMOND_BATTLE_MACE, 20, 3, 15, 0.20f)));

            sellPool.add(new KeyedTrade("ENCH_SWORD_MOISSANITE", 10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_SWORD, 15, 3, 15, 0.20f)));
            sellPool.add(new KeyedTrade("ENCH_BATTLE_MACE_MOISSANITE", 10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_BATTLE_MACE, 22, 3, 15, 0.20f)));

            sellPool.add(new KeyedTrade("ENCH_SWORD_SAPPHIRE", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_SWORD, 14, 3, 15, 0.20f)));
            sellPool.add(new KeyedTrade("ENCH_BATTLE_MACE_SAPPHIRE", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_BATTLE_MACE, 21, 3, 15, 0.20f)));

            sellPool.add(new KeyedTrade("ENCH_SWORD_RUBY", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_SWORD, 18, 3, 15, 0.20f)));
            sellPool.add(new KeyedTrade("ENCH_BATTLE_MACE_RUBY", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_BATTLE_MACE, 25, 3, 15, 0.20f)));

            sellPool.add(new KeyedTrade("ENCH_SWORD_SPINEL", 14,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_SWORD, 13, 3, 15, 0.20f)));
            sellPool.add(new KeyedTrade("ENCH_BATTLE_MACE_SPINEL", 14,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_BATTLE_MACE, 20, 3, 15, 0.20f)));

            sellPool.add(new KeyedTrade("ENCH_SWORD_TOPAZ", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_SWORD, 12, 3, 15, 0.20f)));
            sellPool.add(new KeyedTrade("ENCH_BATTLE_MACE_TOPAZ", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_BATTLE_MACE, 19, 3, 15, 0.20f)));

            sellPool.add(new KeyedTrade("ENCH_SWORD_TOURMALINE", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_SWORD, 11, 3, 15, 0.20f)));
            sellPool.add(new KeyedTrade("ENCH_BATTLE_MACE_TOURMALINE", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_BATTLE_MACE, 19, 3, 15, 0.20f)));

            sellPool.add(new KeyedTrade("ENCH_SWORD_TANZANITE", 14,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_SWORD, 10, 3, 15, 0.20f)));
            sellPool.add(new KeyedTrade("ENCH_BATTLE_MACE_TANZANITE", 15,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_BATTLE_MACE, 18, 3, 15, 0.20f)));

            addSelected(buyPool, offers, 1, villager, r);
            addSelected(sellPool, offers, 2, villager, r);
            return;
        }

        // ==================== LEVEL 5: 1 buy + 2 sell ====================
        if (level == 5) {
            List<KeyedTrade> buyPool = new ArrayList<>();
            List<KeyedTrade> battleAxeSellPool = new ArrayList<>();

            buyPool.add(new KeyedTrade("BUY_SAPPHIRE", 20,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SAPPHIRE_GEM, 1, 1, 12, 20, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_RUBY", 20,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.RUBY_GEM, 1, 1, 12, 20, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_MOISSANITE", 20,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.MOISSANITE_GEM, 1, 2, 12, 20, 0.05f)));

            battleAxeSellPool.add(new KeyedTrade("ENCH_BATTLE_AXE_DIAMOND", 11,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.DIAMOND_BATTLE_AXE, 18, 3, 30, 0.20f)));
            battleAxeSellPool.add(new KeyedTrade("ENCH_BATTLE_AXE_MOISS", 7,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_BATTLE_AXE, 24, 3, 30, 0.20f)));
            battleAxeSellPool.add(new KeyedTrade("ENCH_BATTLE_AXE_SAPPHIRE", 10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_BATTLE_AXE, 22, 3, 30, 0.20f)));
            battleAxeSellPool.add(new KeyedTrade("ENCH_BATTLE_AXE_RUBY", 9,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_BATTLE_AXE, 28, 3, 30, 0.20f)));
            battleAxeSellPool.add(new KeyedTrade("ENCH_BATTLE_AXE_SPINEL", 10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_BATTLE_AXE, 20, 3, 30, 0.20f)));
            battleAxeSellPool.add(new KeyedTrade("ENCH_BATTLE_AXE_TOPAZ", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_BATTLE_AXE, 20, 3, 30, 0.20f)));
            battleAxeSellPool.add(new KeyedTrade("ENCH_BATTLE_AXE_TOURMALINE", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_BATTLE_AXE, 19, 3, 30, 0.20f)));
            battleAxeSellPool.add(new KeyedTrade("ENCH_BATTLE_AXE_TANZANITE", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_BATTLE_AXE, 18, 3, 30, 0.20f)));

            addSelected(buyPool, offers, 1, villager, r);
            addSelected(battleAxeSellPool, offers, 1, villager, r);
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
}
