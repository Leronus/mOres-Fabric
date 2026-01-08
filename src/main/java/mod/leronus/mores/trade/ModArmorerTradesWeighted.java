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
 * Armorer trades:
 * - Always exactly 3 trades per level (your table says "(3 slots)" everywhere)
 * - Trades are chosen by WEIGHT (your "Probability" column)
 * - Vanilla trades are "modified" by simply re-adding them with your weights.
 *
 * IMPORTANT:
 * This system assumes you are not relying on vanilla's own trade pool randomness.
 * You're defining the pool and selecting from it yourself.
 */
public class ModArmorerTradesWeighted {

    public static void register() {

        /* ==================== NOVICE (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> {
            factories.clear();
            Random random = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            // 40% Coal -> Emerald (vanilla item, your weight)
            pool.add(new WeightedTrade(40,
                    new TradeOffers.BuyItemFactory(Items.COAL, 15, 1, 16, 2)));

            // 16% Tin Ingot -> Emerald (mod item)
            pool.add(new WeightedTrade(16,
                    new TradeOffers.BuyItemFactory(ModItems.TIN_INGOT, 26, 1, 16, 2)));

            // Iron armor (vanilla outputs)
            pool.add(new WeightedTrade(12,
                    new TradeOffers.SellItemFactory(Items.IRON_HELMET, 5, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(12,
                    new TradeOffers.SellItemFactory(Items.IRON_CHESTPLATE, 9, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(12,
                    new TradeOffers.SellItemFactory(Items.IRON_LEGGINGS, 7, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(12,
                    new TradeOffers.SellItemFactory(Items.IRON_BOOTS, 4, 1, 12, 1, 0.2f)));

            // Cobalt armor (mod outputs)
            pool.add(new WeightedTrade(12,
                    new TradeOffers.SellItemFactory(ModItems.COBALT_HELMET, 5, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(12,
                    new TradeOffers.SellItemFactory(ModItems.COBALT_CHESTPLATE, 9, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(12,
                    new TradeOffers.SellItemFactory(ModItems.COBALT_LEGGINGS, 7, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(12,
                    new TradeOffers.SellItemFactory(ModItems.COBALT_BOOTS, 4, 1, 12, 1, 0.2f)));

            // Silver armor (mod outputs)
            pool.add(new WeightedTrade(12,
                    new TradeOffers.SellItemFactory(ModItems.SILVER_HELMET, 4, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(12,
                    new TradeOffers.SellItemFactory(ModItems.SILVER_CHESTPLATE, 8, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(12,
                    new TradeOffers.SellItemFactory(ModItems.SILVER_LEGGINGS, 6, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(12,
                    new TradeOffers.SellItemFactory(ModItems.SILVER_BOOTS, 3, 1, 12, 1, 0.2f)));

            // Pick exactly 3
            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== APPRENTICE (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> {
            factories.clear();
            Random random = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            // (Modified vanilla) 60% Iron Ingot -> Emerald
            pool.add(new WeightedTrade(60,
                    new TradeOffers.BuyItemFactory(Items.IRON_INGOT, 4, 1, 12, 10)));

            // (Modified vanilla) 60% Emerald -> Bell
            pool.add(new WeightedTrade(60,
                    new TradeOffers.SellItemFactory(Items.BELL, 36, 1, 12, 5, 0.2f)));

            // 60% Silver Ingot -> Emerald
            pool.add(new WeightedTrade(60,
                    new TradeOffers.BuyItemFactory(ModItems.SILVER_INGOT, 7, 1, 12, 10)));

            // 60% Copper Ingot -> Emerald (vanilla copper ingot)
            pool.add(new WeightedTrade(60,
                    new TradeOffers.BuyItemFactory(Items.COPPER_INGOT, 10, 1, 12, 10)));

            // 60% Cobalt Ingot -> Emerald
            pool.add(new WeightedTrade(60,
                    new TradeOffers.BuyItemFactory(ModItems.COBALT_INGOT, 4, 1, 12, 10)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== JOURNEYMAN (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 3, factories -> {
            factories.clear();
            Random random = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            // 40% Lava Bucket -> Emerald (villager wants lava bucket)
            pool.add(new WeightedTrade(40,
                    new TradeOffers.BuyItemFactory(Items.LAVA_BUCKET, 1, 1, 12, 20)));

            // 35% Rose Gold Ingot -> Emerald
            pool.add(new WeightedTrade(35,
                    new TradeOffers.BuyItemFactory(ModItems.ROSE_GOLD_INGOT, 2, 1, 12, 20)));

            // 35% Gems -> Emerald (villager buys your gems)
            pool.add(new WeightedTrade(35,
                    new TradeOffers.BuyItemFactory(ModItems.SAPPHIRE_GEM, 1, 1, 12, 20)));
            pool.add(new WeightedTrade(35,
                    new TradeOffers.BuyItemFactory(ModItems.TOURMALINE_GEM, 1, 1, 12, 20)));
            pool.add(new WeightedTrade(35,
                    new TradeOffers.BuyItemFactory(ModItems.SPINEL_GEM, 1, 1, 12, 20)));

            // Shields (villager sells shields)
            pool.add(new WeightedTrade(15,
                    new TradeOffers.SellItemFactory(ModItems.LAPIS_LAZULI_SHIELD, 12, 1, 3, 10, 0.2f)));
            pool.add(new WeightedTrade(5,
                    new TradeOffers.SellItemFactory(ModItems.MOISSANITE_SHIELD, 15, 1, 3, 10, 0.2f)));
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellItemFactory(ModItems.SAPPHIRE_SHIELD, 14, 1, 3, 10, 0.2f)));
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellItemFactory(ModItems.RUBY_SHIELD, 13, 1, 3, 10, 0.2f)));
            pool.add(new WeightedTrade(15,
                    new TradeOffers.SellItemFactory(ModItems.SPINEL_SHIELD, 12, 1, 3, 10, 0.2f)));
            pool.add(new WeightedTrade(20,
                    new TradeOffers.SellItemFactory(ModItems.TOPAZ_SHIELD, 11, 1, 3, 10, 0.2f)));
            pool.add(new WeightedTrade(20,
                    new TradeOffers.SellItemFactory(ModItems.TOURMALINE_SHIELD, 10, 1, 3, 10, 0.2f)));
            pool.add(new WeightedTrade(25,
                    new TradeOffers.SellItemFactory(ModItems.TANZANITE_SHIELD, 9, 1, 3, 10, 0.2f)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== EXPERT (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 4, factories -> {
            factories.clear();
            Random random = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            // (Modified vanilla) Enchanted Diamond armor
            pool.add(new WeightedTrade(35,
                    new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_LEGGINGS, 19, 33, 3, 15)));
            pool.add(new WeightedTrade(35,
                    new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_BOOTS, 13, 27, 3, 15)));

            // Moissanite
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_LEGGINGS, 27, 41, 3, 15)));
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_BOOTS, 19, 33, 3, 15)));

            // Sapphire
            pool.add(new WeightedTrade(15,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_LEGGINGS, 23, 37, 3, 15)));
            pool.add(new WeightedTrade(15,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_BOOTS, 17, 31, 3, 15)));

            // Ruby
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_LEGGINGS, 27, 41, 3, 15)));
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_BOOTS, 21, 35, 3, 15)));

            // Spinel
            pool.add(new WeightedTrade(25,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_LEGGINGS, 21, 35, 3, 15)));
            pool.add(new WeightedTrade(25,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_BOOTS, 15, 29, 3, 15)));

            // Topaz
            pool.add(new WeightedTrade(15,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_LEGGINGS, 22, 36, 3, 15)));
            pool.add(new WeightedTrade(15,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_BOOTS, 16, 30, 3, 15)));

            // Tourmaline
            pool.add(new WeightedTrade(30,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_LEGGINGS, 19, 33, 3, 15)));
            pool.add(new WeightedTrade(30,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_BOOTS, 13, 27, 3, 15)));

            // Tanzanite
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_LEGGINGS, 23, 37, 3, 15)));
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_BOOTS, 17, 31, 3, 15)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== MASTER (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 5, factories -> {
            factories.clear();
            Random random = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            // (Modified vanilla) Enchanted Diamond armor
            pool.add(new WeightedTrade(30,
                    new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_CHESTPLATE, 20, 34, 3, 30)));
            pool.add(new WeightedTrade(30,
                    new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_HELMET, 12, 26, 3, 30)));

            // Moissanite
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_CHESTPLATE, 29, 43, 3, 30)));
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_HELMET, 19, 33, 3, 30)));

            // Sapphire
            pool.add(new WeightedTrade(15,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_CHESTPLATE, 25, 39, 3, 30)));
            pool.add(new WeightedTrade(15,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_HELMET, 17, 31, 3, 30)));

            // Ruby
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_CHESTPLATE, 29, 43, 3, 30)));
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_HELMET, 21, 35, 3, 30)));

            // Spinel
            pool.add(new WeightedTrade(25,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_CHESTPLATE, 23, 37, 3, 30)));
            pool.add(new WeightedTrade(25,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_HELMET, 15, 29, 3, 30)));

            // Topaz
            pool.add(new WeightedTrade(15,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_CHESTPLATE, 24, 38, 3, 30)));
            pool.add(new WeightedTrade(15,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_HELMET, 16, 30, 3, 30)));

            // Tourmaline
            pool.add(new WeightedTrade(30,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_CHESTPLATE, 21, 35, 3, 30)));
            pool.add(new WeightedTrade(30,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_HELMET, 13, 27, 3, 30)));

            // Tanzanite
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_CHESTPLATE, 25, 39, 3, 30)));
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_HELMET, 17, 31, 3, 30)));

            // 10% Hardened Steel Smithing Template (correct constant name in your ModItems)
            pool.add(new WeightedTrade(10,
                    new TradeOffers.SellItemFactory(ModItems.HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE,
                            48, 1, 1, 30, 0.5f)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });
    }
}
