package mod.leronus.mores.trade;

import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

import java.util.ArrayList;
import java.util.List;

public class ModArmorerTradesWeighted {

    public static void register() {

        /* ==================== NOVICE (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> {
            factories.clear();
            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY:COAL", 40,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COAL, 15, 1, 16, 2)));
            pool.add(new KeyedTrade("BUY:TIN_INGOT", 16,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TIN_INGOT, 26, 1, 16, 2)));

            // Armor slot keys prevent “3 helmet trades”
            pool.add(new KeyedTrade("HELMET", 12, new TradeOffers.SellItemFactory(Items.IRON_HELMET, 5, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("CHESTPLATE", 12, new TradeOffers.SellItemFactory(Items.IRON_CHESTPLATE, 9, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("LEGGINGS", 12, new TradeOffers.SellItemFactory(Items.IRON_LEGGINGS, 7, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("BOOTS", 12, new TradeOffers.SellItemFactory(Items.IRON_BOOTS, 4, 1, 12, 1, 0.2f)));

            pool.add(new KeyedTrade("HELMET", 12, new TradeOffers.SellItemFactory(ModItems.COBALT_HELMET, 5, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("CHESTPLATE", 12, new TradeOffers.SellItemFactory(ModItems.COBALT_CHESTPLATE, 9, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("LEGGINGS", 12, new TradeOffers.SellItemFactory(ModItems.COBALT_LEGGINGS, 7, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("BOOTS", 12, new TradeOffers.SellItemFactory(ModItems.COBALT_BOOTS, 4, 1, 12, 1, 0.2f)));

            pool.add(new KeyedTrade("HELMET", 12, new TradeOffers.SellItemFactory(ModItems.SILVER_HELMET, 4, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("CHESTPLATE", 12, new TradeOffers.SellItemFactory(ModItems.SILVER_CHESTPLATE, 8, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("LEGGINGS", 12, new TradeOffers.SellItemFactory(ModItems.SILVER_LEGGINGS, 6, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("BOOTS", 12, new TradeOffers.SellItemFactory(ModItems.SILVER_BOOTS, 3, 1, 12, 1, 0.2f)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== APPRENTICE (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> {
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

        /* ==================== JOURNEYMAN (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 3, factories -> {
            factories.clear();
            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY:LAVA_BUCKET", 40,
                    TradeFactoryUtil.buyItemForEmeralds(Items.LAVA_BUCKET, 1, 1, 12, 20)));
            pool.add(new KeyedTrade("BUY:ROSE_GOLD_INGOT", 35,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.ROSE_GOLD_INGOT, 2, 1, 12, 20)));

            pool.add(new KeyedTrade("BUY:SAPPHIRE_GEM", 35,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SAPPHIRE_GEM, 1, 1, 12, 20)));
            pool.add(new KeyedTrade("BUY:TOURMALINE_GEM", 35,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TOURMALINE_GEM, 1, 1, 12, 20)));
            pool.add(new KeyedTrade("BUY:SPINEL_GEM", 35,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SPINEL_GEM, 1, 1, 12, 20)));

            // Shields: key "SHIELD" so you won't roll multiple shield variants in same set.
            pool.add(new KeyedTrade("SHIELD", 15, new TradeOffers.SellItemFactory(ModItems.LAPIS_LAZULI_SHIELD, 12, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("SHIELD", 5, new TradeOffers.SellItemFactory(ModItems.MOISSANITE_SHIELD, 15, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("SHIELD", 10, new TradeOffers.SellItemFactory(ModItems.SAPPHIRE_SHIELD, 14, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("SHIELD", 10, new TradeOffers.SellItemFactory(ModItems.RUBY_SHIELD, 13, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("SHIELD", 15, new TradeOffers.SellItemFactory(ModItems.SPINEL_SHIELD, 12, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("SHIELD", 20, new TradeOffers.SellItemFactory(ModItems.TOPAZ_SHIELD, 11, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("SHIELD", 20, new TradeOffers.SellItemFactory(ModItems.TOURMALINE_SHIELD, 10, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("SHIELD", 25, new TradeOffers.SellItemFactory(ModItems.TANZANITE_SHIELD, 9, 1, 3, 10, 0.2f)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== EXPERT (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 4, factories -> {
            factories.clear();
            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            // Key by armor slot (no multi-leggings etc.)
            pool.add(new KeyedTrade("LEGGINGS", 35, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_LEGGINGS, 19, 33, 3, 15)));
            pool.add(new KeyedTrade("BOOTS", 35, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_BOOTS, 13, 27, 3, 15)));

            pool.add(new KeyedTrade("LEGGINGS", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_LEGGINGS, 27, 41, 3, 15)));
            pool.add(new KeyedTrade("BOOTS", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_BOOTS, 19, 33, 3, 15)));

            pool.add(new KeyedTrade("LEGGINGS", 15, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_LEGGINGS, 23, 37, 3, 15)));
            pool.add(new KeyedTrade("BOOTS", 15, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_BOOTS, 17, 31, 3, 15)));

            pool.add(new KeyedTrade("LEGGINGS", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_LEGGINGS, 27, 41, 3, 15)));
            pool.add(new KeyedTrade("BOOTS", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_BOOTS, 21, 35, 3, 15)));

            pool.add(new KeyedTrade("LEGGINGS", 25, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_LEGGINGS, 21, 35, 3, 15)));
            pool.add(new KeyedTrade("BOOTS", 25, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_BOOTS, 15, 29, 3, 15)));

            pool.add(new KeyedTrade("LEGGINGS", 15, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_LEGGINGS, 22, 36, 3, 15)));
            pool.add(new KeyedTrade("BOOTS", 15, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_BOOTS, 16, 30, 3, 15)));

            pool.add(new KeyedTrade("LEGGINGS", 30, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_LEGGINGS, 19, 33, 3, 15)));
            pool.add(new KeyedTrade("BOOTS", 30, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_BOOTS, 13, 27, 3, 15)));

            pool.add(new KeyedTrade("LEGGINGS", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_LEGGINGS, 23, 37, 3, 15)));
            pool.add(new KeyedTrade("BOOTS", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_BOOTS, 17, 31, 3, 15)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== MASTER (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 5, factories -> {
            factories.clear();
            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("CHESTPLATE", 30, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_CHESTPLATE, 20, 34, 3, 30)));
            pool.add(new KeyedTrade("HELMET", 30, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_HELMET, 12, 26, 3, 30)));

            pool.add(new KeyedTrade("CHESTPLATE", 25, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_CHESTPLATE, 27, 41, 3, 30)));
            pool.add(new KeyedTrade("HELMET", 25, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_HELMET, 17, 31, 3, 30)));

            pool.add(new KeyedTrade("CHESTPLATE", 20, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_CHESTPLATE, 25, 39, 3, 30)));
            pool.add(new KeyedTrade("HELMET", 20, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_HELMET, 15, 29, 3, 30)));

            pool.add(new KeyedTrade("CHESTPLATE", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_CHESTPLATE, 30, 44, 3, 30)));
            pool.add(new KeyedTrade("HELMET", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_HELMET, 20, 34, 3, 30)));

            pool.add(new KeyedTrade("CHESTPLATE", 35, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_CHESTPLATE, 25, 39, 3, 30)));
            pool.add(new KeyedTrade("HELMET", 35, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_HELMET, 15, 29, 3, 30)));

            pool.add(new KeyedTrade("CHESTPLATE", 45, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_CHESTPLATE, 24, 38, 3, 30)));
            pool.add(new KeyedTrade("HELMET", 45, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_HELMET, 14, 28, 3, 30)));

            pool.add(new KeyedTrade("CHESTPLATE", 50, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_CHESTPLATE, 23, 37, 3, 30)));
            pool.add(new KeyedTrade("HELMET", 50, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_HELMET, 13, 27, 3, 30)));

            pool.add(new KeyedTrade("CHESTPLATE", 55, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_CHESTPLATE, 22, 36, 3, 30)));
            pool.add(new KeyedTrade("HELMET", 55, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_HELMET, 12, 26, 3, 30)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });
    }
}
