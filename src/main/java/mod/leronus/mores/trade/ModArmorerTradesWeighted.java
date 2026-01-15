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

    private static boolean REGISTERED = false;

    public static void register() {
        if (REGISTERED) return;
        REGISTERED = true;

        // NOVICE (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> {
            factories.clear() ;
            Random r = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_COAL", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COAL, 15, 1, 16, 2, 0.05f)));

            // Armor sells – iron weight lager, cobalt/silver hoger
            pool.add(new WeightedTrade("SELL_IRON_HELMET", 10, new TradeOffers.SellItemFactory(Items.IRON_HELMET, 5, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_IRON_CHEST", 10, new TradeOffers.SellItemFactory(Items.IRON_CHESTPLATE, 9, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_IRON_LEGS", 10, new TradeOffers.SellItemFactory(Items.IRON_LEGGINGS, 7, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_IRON_BOOTS", 10, new TradeOffers.SellItemFactory(Items.IRON_BOOTS, 4, 1, 12, 1, 0.20f)));

            pool.add(new WeightedTrade("SELL_COBALT_HELMET", 14, new TradeOffers.SellItemFactory(ModItems.COBALT_HELMET, 5, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_COBALT_CHEST", 14, new TradeOffers.SellItemFactory(ModItems.COBALT_CHESTPLATE, 9, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_COBALT_LEGS", 14, new TradeOffers.SellItemFactory(ModItems.COBALT_LEGGINGS, 7, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_COBALT_BOOTS", 14, new TradeOffers.SellItemFactory(ModItems.COBALT_BOOTS, 4, 1, 12, 1, 0.20f)));

            pool.add(new WeightedTrade("SELL_SILVER_HELMET", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_HELMET, 4, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_SILVER_CHEST", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_CHESTPLATE, 8, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_SILVER_LEGS", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_LEGGINGS, 6, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_SILVER_BOOTS", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_BOOTS, 3, 1, 12, 1, 0.20f)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });

        // APPRENTICE (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, factories -> {
            factories.clear();
            Random r = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_IRON", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.IRON_INGOT, 4, 1, 12, 10, 0.05f)));
            pool.add(new WeightedTrade("SELL_BELL", 20,
                    new TradeOffers.SellItemFactory(Items.BELL, 36, 1, 12, 5, 0.05f)));
            pool.add(new WeightedTrade("BUY_SILVER", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SILVER_INGOT, 7, 1, 12, 10, 0.05f)));
            pool.add(new WeightedTrade("BUY_COPPER", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COPPER_INGOT, 10, 1, 12, 10, 0.05f)));
            pool.add(new WeightedTrade("BUY_COBALT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.COBALT_INGOT, 4, 1, 12, 10, 0.05f)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });

        // JOURNEYMAN (3 slots) – more shields!
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 3, factories -> {
            factories.clear();
            Random r = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_LAVA_BUCKET", 18,
                    TradeFactoryUtil.buyItemForEmeralds(Items.LAVA_BUCKET, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_ROSE_GOLD", 18,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.ROSE_GOLD_INGOT, 2, 1, 12, 20, 0.05f)));

            // Shields: higher overall weights so they appear more across villagers
            pool.add(new WeightedTrade("SHIELD_COBALT", 18, new TradeOffers.SellItemFactory(ModItems.COBALT_SHIELD, 12, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SHIELD_CARBON_STEEL", 18, new TradeOffers.SellItemFactory(ModItems.CARBON_STEEL_SHIELD, 12, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SHIELD_TOPAZ", 14, new TradeOffers.SellItemFactory(ModItems.TOPAZ_SHIELD, 11, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SHIELD_TOURMALINE", 10, new TradeOffers.SellItemFactory(ModItems.TOURMALINE_SHIELD, 10, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SHIELD_RUBY", 10, new TradeOffers.SellItemFactory(ModItems.RUBY_SHIELD, 13, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SHIELD_SAPPHIRE", 10, new TradeOffers.SellItemFactory(ModItems.SAPPHIRE_SHIELD, 14, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SHIELD_EMERALD", 12, new TradeOffers.SellItemFactory(ModItems.EMERALD_SHIELD, 14, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SHIELD_AMETHYST", 12, new TradeOffers.SellItemFactory(ModItems.AMETHYST_SHIELD, 14, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SHIELD_LAPIS", 16, new TradeOffers.SellItemFactory(ModItems.LAPIS_LAZULI_SHIELD, 12, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SHIELD_CITRINE", 12, new TradeOffers.SellItemFactory(ModItems.CITRINE_SHIELD, 12, 1, 3, 10, 0.20f)));

            // Gems buy (keep variety)
            pool.add(new WeightedTrade("BUY_SAPPHIRE", 12,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SAPPHIRE_GEM, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_SPINEL", 12,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SPINEL_GEM, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_RUBY", 11,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.RUBY_GEM, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_TOPAZ", 14,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TOPAZ_GEM, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_TOURMALINE", 15,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TOURMALINE_GEM, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_TANZANITE", 13,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TANZANITE_GEM, 1, 1, 12, 20, 0.05f)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });

        // EXPERT (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 4, factories -> {
            factories.clear();
            Random r = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            // diamond + mores armor; tanz/topaz/tour lower weights
            pool.add(new WeightedTrade("ENCH_DIAMOND_LEGS", 14,
                    new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_LEGGINGS, 19, 33, 3, 15)));
            pool.add(new WeightedTrade("ENCH_DIAMOND_BOOTS", 14,
                    new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_BOOTS, 13, 27, 3, 15)));

            pool.add(new WeightedTrade("ENCH_SAPPHIRE_LEGS", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_LEGGINGS, 23, 37, 3, 15)));
            pool.add(new WeightedTrade("ENCH_SAPPHIRE_BOOTS", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_BOOTS, 17, 31, 3, 15)));

            pool.add(new WeightedTrade("ENCH_RUBY_LEGS", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_LEGGINGS, 27, 41, 3, 15)));
            pool.add(new WeightedTrade("ENCH_RUBY_BOOTS", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_BOOTS, 21, 35, 3, 15)));

            pool.add(new WeightedTrade("ENCH_SPINEL_LEGS", 14,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_LEGGINGS, 21, 35, 3, 15)));
            pool.add(new WeightedTrade("ENCH_SPINEL_BOOTS", 14,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_BOOTS, 15, 29, 3, 15)));

            pool.add(new WeightedTrade("ENCH_MOISSANITE_LEGS", 10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_LEGGINGS, 27, 41, 3, 15)));
            pool.add(new WeightedTrade("ENCH_MOISSANITE_BOOTS", 10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_BOOTS, 19, 33, 3, 15)));

            pool.add(new WeightedTrade("ENCH_TOPAZ_LEGS", 6,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_LEGGINGS, 22, 36, 3, 15)));
            pool.add(new WeightedTrade("ENCH_TOPAZ_BOOTS", 6,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_BOOTS, 16, 30, 3, 15)));

            pool.add(new WeightedTrade("ENCH_TOUR_LEGS", 5,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_LEGGINGS, 19, 33, 3, 15)));
            pool.add(new WeightedTrade("ENCH_TOUR_BOOTS", 5,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_BOOTS, 13, 27, 3, 15)));

            pool.add(new WeightedTrade("ENCH_TANZ_LEGS", 3,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_LEGGINGS, 23, 37, 3, 15)));
            pool.add(new WeightedTrade("ENCH_TANZ_BOOTS", 3,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_BOOTS, 17, 31, 3, 15)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });

        // MASTER (3 slots) – template rare + normal multiplier
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 5, factories -> {
            factories.clear();
            Random r = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("ENCH_DIAMOND_CHEST", 14,
                    new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_CHESTPLATE, 20, 34, 3, 30)));
            pool.add(new WeightedTrade("ENCH_DIAMOND_HELM", 14,
                    new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_HELMET, 12, 26, 3, 30)));

            pool.add(new WeightedTrade("ENCH_SAPPHIRE_CHEST", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_CHESTPLATE, 25, 39, 3, 30)));
            pool.add(new WeightedTrade("ENCH_SAPPHIRE_HELM", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_HELMET, 17, 31, 3, 30)));

            pool.add(new WeightedTrade("ENCH_RUBY_CHEST", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_CHESTPLATE, 29, 43, 3, 30)));
            pool.add(new WeightedTrade("ENCH_RUBY_HELM", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_HELMET, 21, 35, 3, 30)));

            pool.add(new WeightedTrade("ENCH_SPINEL_CHEST", 14,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_CHESTPLATE, 23, 37, 3, 30)));
            pool.add(new WeightedTrade("ENCH_SPINEL_HELM", 14,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_HELMET, 15, 29, 3, 30)));

            pool.add(new WeightedTrade("ENCH_MOISSANITE_CHEST", 10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_CHESTPLATE, 29, 43, 3, 30)));
            pool.add(new WeightedTrade("ENCH_MOISSANITE_HELM", 10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_HELMET, 19, 33, 3, 30)));

            pool.add(new WeightedTrade("ENCH_TOPAZ_CHEST", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_CHESTPLATE, 24, 38, 3, 30)));
            pool.add(new WeightedTrade("ENCH_TOPAZ_HELM", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_HELMET, 16, 30, 3, 30)));

            pool.add(new WeightedTrade("ENCH_TOUR_CHEST", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_CHESTPLATE, 21, 35, 3, 30)));
            pool.add(new WeightedTrade("ENCH_TOUR_HELM", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_HELMET, 13, 27, 3, 30)));

            pool.add(new WeightedTrade("ENCH_TANZ_CHEST", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_CHESTPLATE, 25, 39, 3, 30)));
            pool.add(new WeightedTrade("ENCH_TANZ_HELM", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_HELMET, 17, 31, 3, 30)));

            pool.add(new WeightedTrade("TEMPLATE_HARDENED_STEEL", 2,
                    new TradeOffers.SellItemFactory(ModItems.HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE, 48, 1, 1, 30, 0.05f)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });
    }
}
