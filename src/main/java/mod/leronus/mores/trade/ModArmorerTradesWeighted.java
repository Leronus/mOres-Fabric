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

public class ModArmorerTradesWeighted {

    public static void addLevelOffers(Entity villager, TradeOfferList offers, int level, Random r) {

        // ==================== LEVEL 1: 1 buy + 2 sell ====================
        if (level == 1) {
            List<KeyedTrade> buyPool = new ArrayList<>();
            List<KeyedTrade> sellPool = new ArrayList<>();

            // BUY (pick 1)
            buyPool.add(new KeyedTrade("BUY_COAL", 50,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COAL, 15, 1, 16, 2, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_ANTHRACITE", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.ANTHRACITE, 9, 1, 12, 2, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_RAW_SILVER", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.RAW_SILVER, 7, 1, 12, 2, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_RAW_COPPER", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.RAW_COPPER, 16, 1, 12, 2, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_RAW_TIN", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.RAW_TIN, 14, 1, 12, 2, 0.05f)));

            // SELL (pick 2) — keys are unique per item so you can get e.g. helmet+boots, but never duplicates
            // Iron
            sellPool.add(new KeyedTrade("SELL_IRON_HELMET", 10, new TradeOffers.SellItemFactory(Items.IRON_HELMET, 5, 1, 12, 1, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_IRON_CHEST", 10, new TradeOffers.SellItemFactory(Items.IRON_CHESTPLATE, 9, 1, 12, 1, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_IRON_LEGS", 10, new TradeOffers.SellItemFactory(Items.IRON_LEGGINGS, 7, 1, 12, 1, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_IRON_BOOTS", 10, new TradeOffers.SellItemFactory(Items.IRON_BOOTS, 4, 1, 12, 1, 0.20f)));

            // Cobalt
            sellPool.add(new KeyedTrade("SELL_COBALT_HELMET", 14, new TradeOffers.SellItemFactory(ModItems.COBALT_HELMET, 5, 1, 12, 1, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_COBALT_CHEST", 14, new TradeOffers.SellItemFactory(ModItems.COBALT_CHESTPLATE, 9, 1, 12, 1, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_COBALT_LEGS", 14, new TradeOffers.SellItemFactory(ModItems.COBALT_LEGGINGS, 7, 1, 12, 1, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_COBALT_BOOTS", 14, new TradeOffers.SellItemFactory(ModItems.COBALT_BOOTS, 4, 1, 12, 1, 0.20f)));

            // Silver
            sellPool.add(new KeyedTrade("SELL_SILVER_HELMET", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_HELMET, 4, 1, 12, 1, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_SILVER_CHEST", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_CHESTPLATE, 8, 1, 12, 1, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_SILVER_LEGS", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_LEGGINGS, 6, 1, 12, 1, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_SILVER_BOOTS", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_BOOTS, 3, 1, 12, 1, 0.20f)));

            addSelected(buyPool, offers, 1, villager, r);
            addSelected(sellPool, offers, 2, villager, r);
            return;
        }

        // ==================== LEVEL 2: 2 buy + 1 sell ====================
        if (level == 2) {
            List<KeyedTrade> buyPool = new ArrayList<>();
            List<KeyedTrade> sellPool = new ArrayList<>();

            buyPool.add(new KeyedTrade("BUY_IRON_INGOT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.IRON_INGOT, 4, 1, 12, 10, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_SILVER_INGOT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SILVER_INGOT, 7, 1, 12, 10, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_COPPER_INGOT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COPPER_INGOT, 10, 1, 12, 10, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_COBALT_INGOT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.COBALT_INGOT, 4, 1, 12, 10, 0.05f)));

            // ONE sell slot: either bell OR graphene chainmail piece
            sellPool.add(new KeyedTrade("SELL_BELL", 20,
                    new TradeOffers.SellItemFactory(Items.BELL, 24, 1, 12, 5, 0.05f)));

            sellPool.add(new KeyedTrade("SELL_GRAPHENE_CHAINMAIL_HELMET", 20,
                    new TradeOffers.SellItemFactory(ModItems.GRAPHENE_CHAINMAIL_HELMET, 36, 1, 3, 10, 0.05f)));
            sellPool.add(new KeyedTrade("SELL_GRAPHENE_CHAINMAIL_CHESTPLATE", 20,
                    new TradeOffers.SellItemFactory(ModItems.GRAPHENE_CHAINMAIL_CHESTPLATE, 36, 1, 3, 10, 0.05f)));
            sellPool.add(new KeyedTrade("SELL_GRAPHENE_CHAINMAIL_LEGGINGS", 20,
                    new TradeOffers.SellItemFactory(ModItems.GRAPHENE_CHAINMAIL_LEGGINGS, 36, 1, 3, 10, 0.05f)));
            sellPool.add(new KeyedTrade("SELL_GRAPHENE_CHAINMAIL_BOOTS", 20,
                    new TradeOffers.SellItemFactory(ModItems.GRAPHENE_CHAINMAIL_BOOTS, 36, 1, 3, 10, 0.05f)));

            addSelected(buyPool, offers, 2, villager, r);
            addSelected(sellPool, offers, 1, villager, r);
            return;
        }

        // ==================== LEVEL 3: pick 3 ====================
        if (level == 3) {
            List<KeyedTrade> buyLavaPool = new ArrayList<>();
            List<KeyedTrade> sellShieldPool = new ArrayList<>();
            List<KeyedTrade> buyGemPool = new ArrayList<>();

            buyLavaPool.add(new KeyedTrade("BUY_LAVA_BUCKET", 18,
                    TradeFactoryUtil.buyItemForEmeralds(Items.LAVA_BUCKET, 1, 1, 12, 20, 0.05f)));
            buyLavaPool.add(new KeyedTrade("BUY_ROSE_GOLD", 18,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.ROSE_GOLD_INGOT, 2, 1, 12, 20, 0.05f)));

            // Shields (sells to you)
            sellShieldPool.add(new KeyedTrade("SELL_SHIELD_COBALT", 18, new TradeOffers.SellItemFactory(ModItems.COBALT_SHIELD, 12, 1, 3, 10, 0.20f)));
            sellShieldPool.add(new KeyedTrade("SELL_SHIELD_CARBON_STEEL", 18, new TradeOffers.SellItemFactory(ModItems.CARBON_STEEL_SHIELD, 12, 1, 3, 10, 0.20f)));
            sellShieldPool.add(new KeyedTrade("SELL_SHIELD_TOPAZ", 14, new TradeOffers.SellItemFactory(ModItems.TOPAZ_SHIELD, 11, 1, 3, 10, 0.20f)));
            sellShieldPool.add(new KeyedTrade("SELL_SHIELD_TOURMALINE", 10, new TradeOffers.SellItemFactory(ModItems.TOURMALINE_SHIELD, 10, 1, 3, 10, 0.20f)));
            sellShieldPool.add(new KeyedTrade("SELL_SHIELD_RUBY", 10, new TradeOffers.SellItemFactory(ModItems.RUBY_SHIELD, 13, 1, 3, 10, 0.20f)));
            sellShieldPool.add(new KeyedTrade("SELL_SHIELD_SAPPHIRE", 10, new TradeOffers.SellItemFactory(ModItems.SAPPHIRE_SHIELD, 14, 1, 3, 10, 0.20f)));
            sellShieldPool.add(new KeyedTrade("SELL_SHIELD_EMERALD", 12, new TradeOffers.SellItemFactory(ModItems.EMERALD_SHIELD, 14, 1, 3, 10, 0.20f)));
            sellShieldPool.add(new KeyedTrade("SELL_SHIELD_AMETHYST", 12, new TradeOffers.SellItemFactory(ModItems.AMETHYST_SHIELD, 14, 1, 3, 10, 0.20f)));
            sellShieldPool.add(new KeyedTrade("SELL_SHIELD_LAPIS", 16, new TradeOffers.SellItemFactory(ModItems.LAPIS_LAZULI_SHIELD, 12, 1, 3, 10, 0.20f)));
            sellShieldPool.add(new KeyedTrade("SELL_SHIELD_CITRINE", 12, new TradeOffers.SellItemFactory(ModItems.CITRINE_SHIELD, 12, 1, 3, 10, 0.20f)));

            // Gems (villager buys from you)
            buyGemPool.add(new KeyedTrade("BUY_SAPPHIRE_GEM", 12, TradeFactoryUtil.buyItemForEmeralds(ModItems.SAPPHIRE_GEM, 1, 1, 12, 20, 0.05f)));
            buyGemPool.add(new KeyedTrade("BUY_SPINEL_GEM", 12, TradeFactoryUtil.buyItemForEmeralds(ModItems.SPINEL_GEM, 1, 1, 12, 20, 0.05f)));
            buyGemPool.add(new KeyedTrade("BUY_RUBY_GEM", 11, TradeFactoryUtil.buyItemForEmeralds(ModItems.RUBY_GEM, 1, 1, 12, 20, 0.05f)));
            buyGemPool.add(new KeyedTrade("BUY_TOPAZ_GEM", 14, TradeFactoryUtil.buyItemForEmeralds(ModItems.TOPAZ_GEM, 1, 1, 12, 20, 0.05f)));
            buyGemPool.add(new KeyedTrade("BUY_TOURMALINE_GEM", 15, TradeFactoryUtil.buyItemForEmeralds(ModItems.TOURMALINE_GEM, 1, 1, 12, 20, 0.05f)));
            buyGemPool.add(new KeyedTrade("BUY_TANZANITE_GEM", 13, TradeFactoryUtil.buyItemForEmeralds(ModItems.TANZANITE_GEM, 1, 1, 12, 20, 0.05f)));

            addSelected(buyLavaPool, offers, 1, villager, r);
            addSelected(sellShieldPool, offers, 1, villager, r);
            addSelected(buyGemPool, offers, 1, villager, r);
            return;
        }

        // ==================== LEVEL 4: pick 3 ====================
        if (level == 4) {
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("SELL_ENCH_DIAMOND_LEGS", 14, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_LEGGINGS, 19, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_DIAMOND_BOOTS", 14, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_BOOTS, 13, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_SAPPHIRE_LEGS", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_LEGGINGS, 23, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_SAPPHIRE_BOOTS", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_BOOTS, 17, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_RUBY_LEGS", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_LEGGINGS, 27, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_RUBY_BOOTS", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_BOOTS, 21, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_SPINEL_LEGS", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_LEGGINGS, 21, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_SPINEL_BOOTS", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_BOOTS, 15, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_MOISSANITE_LEGS", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_LEGGINGS, 27, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_MOISSANITE_BOOTS", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_BOOTS, 19, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_TOPAZ_LEGS", 6, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_LEGGINGS, 22, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_TOPAZ_BOOTS", 6, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_BOOTS, 16, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_TOURMALINE_LEGS", 5, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_LEGGINGS, 19, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_TOURMALINE_BOOTS", 5, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_BOOTS, 13, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_TANZANITE_LEGS", 3, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_LEGGINGS, 23, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_TANZANITE_BOOTS", 3, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_BOOTS, 17, 3, 30, 0.20f)));

            addSelected(pool, offers, 3, villager, r);
            return;
        }

        // ==================== LEVEL 5: pick 3 (template rare) ====================
        if (level == 5) {
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("SELL_ENCH_DIAMOND_CHEST", 14, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_CHESTPLATE, 20, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_DIAMOND_HELM", 14, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_HELMET, 12, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_SAPPHIRE_CHEST", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_CHESTPLATE, 25, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_SAPPHIRE_HELM", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_HELMET, 17, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_RUBY_CHEST", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_CHESTPLATE, 29, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_RUBY_HELM", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_HELMET, 21, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_SPINEL_CHEST", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_CHESTPLATE, 23, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_SPINEL_HELM", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_HELMET, 15, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_MOISSANITE_CHEST", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_CHESTPLATE, 29, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_MOISSANITE_HELM", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_HELMET, 19, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_TOPAZ_CHEST", 16, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_CHESTPLATE, 24, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_TOPAZ_HELM", 16, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_HELMET, 16, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_TOURMALINE_CHEST", 16, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_CHESTPLATE, 21, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_TOURMALINE_HELM", 16, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_HELMET, 13, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_TANZANITE_CHEST", 16, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_CHESTPLATE, 25, 3, 30, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_TANZANITE_HELM", 16, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_HELMET, 17, 3, 30, 0.20f)));

            pool.add(new KeyedTrade("SELL_TEMPLATE_HARDENED_STEEL", 2,
                    new TradeOffers.SellItemFactory(ModItems.HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE, 48, 1, 1, 30, 0.05f)));

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
}
