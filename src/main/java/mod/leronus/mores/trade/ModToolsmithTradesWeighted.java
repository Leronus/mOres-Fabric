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
 * Toolsmith trades:
 * - ALWAYS exactly 3 trades per level (weighted selection)
 * - Includes "modified vanilla probability" by re-adding vanilla trades with your chosen weights.
 *
 * Requires your global "3 trades per level" slot-cap mixin to be active.
 */
public class ModToolsmithTradesWeighted {

    public static void register() {

        /* ==================== NOVICE (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, factories -> {
            Random random = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            // (Modified vanilla) 40% Coal -> Emerald
            pool.add(new WeightedTrade(40, new TradeOffers.BuyItemFactory(
                    Items.COAL, 15, 1, 16, 2)));

            // Iron tools
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    Items.IRON_AXE, 3, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    Items.IRON_SHOVEL, 2, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    Items.IRON_PICKAXE, 3, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    Items.IRON_HOE, 2, 1, 12, 1, 0.2f)));

            // Cobalt tools
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    ModItems.COBALT_AXE, 3, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    ModItems.COBALT_SHOVEL, 2, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    ModItems.COBALT_PICKAXE, 3, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    ModItems.COBALT_HOE, 2, 1, 12, 1, 0.2f)));

            // Silver tools
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    ModItems.SILVER_AXE, 3, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    ModItems.SILVER_SHOVEL, 2, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    ModItems.SILVER_PICKAXE, 3, 1, 12, 1, 0.2f)));
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    ModItems.SILVER_HOE, 2, 1, 12, 1, 0.2f)));

            // 30% Tin Ingot -> Emerald
            pool.add(new WeightedTrade(30, new TradeOffers.BuyItemFactory(
                    ModItems.TIN_INGOT, 26, 1, 16, 2)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== APPRENTICE (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 2, factories -> {
            Random random = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            // (Modified vanilla) 60% Iron Ingot -> Emerald
            pool.add(new WeightedTrade(60, new TradeOffers.BuyItemFactory(
                    Items.IRON_INGOT, 4, 1, 12, 10)));

            // (Modified vanilla) 60% Emerald -> Bell
            pool.add(new WeightedTrade(60, new TradeOffers.SellItemFactory(
                    Items.BELL, 36, 1, 12, 5, 0.2f)));

            // 60% Silver Ingot -> Emerald
            pool.add(new WeightedTrade(60, new TradeOffers.BuyItemFactory(
                    ModItems.SILVER_INGOT, 7, 1, 12, 10)));

            // 60% Copper Ingot -> Emerald (vanilla copper ingot)
            pool.add(new WeightedTrade(60, new TradeOffers.BuyItemFactory(
                    Items.COPPER_INGOT, 10, 1, 12, 10)));

            // 60% Cobalt Ingot -> Emerald
            pool.add(new WeightedTrade(60, new TradeOffers.BuyItemFactory(
                    ModItems.COBALT_INGOT, 4, 1, 12, 10)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== JOURNEYMAN (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3, factories -> {
            Random random = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            // (Modified vanilla) 30% Flint -> Emerald
            pool.add(new WeightedTrade(30, new TradeOffers.BuyItemFactory(
                    Items.FLINT, 30, 1, 12, 20)));

            // 25% Carbon Steel Ingot -> Emerald
            pool.add(new WeightedTrade(25, new TradeOffers.BuyItemFactory(
                    ModItems.CARBON_STEEL_INGOT, 2, 1, 12, 20)));

            // 25% Ruby Gem -> Emerald
            pool.add(new WeightedTrade(25, new TradeOffers.BuyItemFactory(
                    ModItems.RUBY_GEM, 1, 1, 12, 20)));

            // 25% Topaz Gem -> Emerald
            pool.add(new WeightedTrade(25, new TradeOffers.BuyItemFactory(
                    ModItems.TOPAZ_GEM, 1, 1, 12, 20)));

            // 25% Diamond -> Emerald
            pool.add(new WeightedTrade(25, new TradeOffers.BuyItemFactory(
                    Items.DIAMOND, 1, 1, 12, 20)));

            // (Modified vanilla) 10% Emerald -> Diamond Hoe
            pool.add(new WeightedTrade(10, new TradeOffers.SellItemFactory(
                    Items.DIAMOND_HOE, 4, 1, 3, 10, 0.2f)));

            // 5% Emerald -> Moissanite Hoe
            pool.add(new WeightedTrade(5, new TradeOffers.SellItemFactory(
                    ModItems.MOISSANITE_HOE, 5, 1, 3, 10, 0.2f)));

            // 5% Emerald -> Sapphire Hoe
            pool.add(new WeightedTrade(5, new TradeOffers.SellItemFactory(
                    ModItems.SAPPHIRE_HOE, 5, 1, 3, 10, 0.2f)));

            // 5% Emerald -> Ruby Hoe
            pool.add(new WeightedTrade(5, new TradeOffers.SellItemFactory(
                    ModItems.RUBY_HOE, 5, 1, 3, 10, 0.2f)));

            // 10% Emerald -> Spinel Hoe
            pool.add(new WeightedTrade(10, new TradeOffers.SellItemFactory(
                    ModItems.SPINEL_HOE, 4, 1, 3, 10, 0.2f)));

            // 15% Emerald -> Topaz Hoe
            pool.add(new WeightedTrade(15, new TradeOffers.SellItemFactory(
                    ModItems.TOPAZ_HOE, 4, 1, 3, 10, 0.2f)));

            // 20% Emerald -> Tourmaline Hoe
            pool.add(new WeightedTrade(20, new TradeOffers.SellItemFactory(
                    ModItems.TOURMALINE_HOE, 3, 1, 3, 10, 0.2f)));

            // 25% Emerald -> Tanzanite Hoe
            pool.add(new WeightedTrade(25, new TradeOffers.SellItemFactory(
                    ModItems.TANZANITE_HOE, 3, 1, 3, 10, 0.2f)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== EXPERT (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 4, factories -> {
            Random random = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            // (Modified vanilla) 16% Enchanted Diamond Axe
            pool.add(new WeightedTrade(16, new TradeOffers.SellEnchantedToolFactory(
                    Items.DIAMOND_AXE, 17, 31, 3, 15)));

            // (Modified vanilla) 16% Enchanted Diamond Shovel
            pool.add(new WeightedTrade(16, new TradeOffers.SellEnchantedToolFactory(
                    Items.DIAMOND_SHOVEL, 10, 24, 3, 15)));

            // 10% Enchanted Moissanite Axe
            pool.add(new WeightedTrade(10, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.MOISSANITE_AXE, 23, 38, 3, 15)));

            // 10% Enchanted Moissanite Shovel
            pool.add(new WeightedTrade(10, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.MOISSANITE_SHOVEL, 17, 31, 3, 15)));

            // 14% Enchanted Sapphire Axe
            pool.add(new WeightedTrade(14, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.SAPPHIRE_AXE, 20, 34, 3, 15)));

            // 14% Enchanted Sapphire Shovel
            pool.add(new WeightedTrade(14, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.SAPPHIRE_SHOVEL, 13, 27, 3, 15)));

            // 9% Enchanted Ruby Axe
            pool.add(new WeightedTrade(9, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.RUBY_AXE, 25, 39, 3, 15)));

            // 9% Enchanted Ruby Shovel
            pool.add(new WeightedTrade(9, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.RUBY_SHOVEL, 21, 35, 3, 15)));

            // 21% Enchanted Spinel Axe
            pool.add(new WeightedTrade(21, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.SPINEL_AXE, 17, 31, 3, 15)));

            // 21% Enchanted Spinel Shovel
            pool.add(new WeightedTrade(21, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.SPINEL_SHOVEL, 10, 24, 3, 15)));

            // 23% Enchanted Topaz Axe
            pool.add(new WeightedTrade(23, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.TOPAZ_AXE, 17, 31, 3, 15)));

            // 23% Enchanted Topaz Shovel
            pool.add(new WeightedTrade(23, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.TOPAZ_SHOVEL, 10, 24, 3, 15)));

            // 26% Enchanted Tourmaline Axe
            pool.add(new WeightedTrade(26, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.TOURMALINE_AXE, 16, 30, 3, 15)));

            // 26% Enchanted Tourmaline Shovel
            pool.add(new WeightedTrade(26, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.TOURMALINE_SHOVEL, 9, 23, 3, 15)));

            // 31% Enchanted Tanzanite Axe
            pool.add(new WeightedTrade(31, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.TANZANITE_AXE, 13, 27, 3, 15)));

            // 31% Enchanted Tanzanite Shovel
            pool.add(new WeightedTrade(31, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.TANZANITE_SHOVEL, 6, 20, 3, 15)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== MASTER (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 5, factories -> {
            Random random = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            // (Modified vanilla) 40% Enchanted Diamond Pickaxe
            pool.add(new WeightedTrade(40, new TradeOffers.SellEnchantedToolFactory(
                    Items.DIAMOND_PICKAXE, 18, 32, 3, 30)));

            // 25% Enchanted Moissanite Pickaxe
            pool.add(new WeightedTrade(25, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.MOISSANITE_PICKAXE, 25, 39, 3, 30)));

            // 30% Enchanted Sapphire Pickaxe
            pool.add(new WeightedTrade(30, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.SAPPHIRE_PICKAXE, 22, 36, 3, 30)));

            // 10% Enchanted Ruby Pickaxe
            pool.add(new WeightedTrade(10, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.RUBY_PICKAXE, 40, 54, 3, 30)));

            // 35% Enchanted Spinel Pickaxe
            pool.add(new WeightedTrade(35, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.SPINEL_PICKAXE, 17, 31, 3, 30)));

            // 45% Enchanted Topaz Pickaxe
            pool.add(new WeightedTrade(45, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.TOPAZ_PICKAXE, 16, 30, 3, 30)));

            // 50% Enchanted Tourmaline Pickaxe
            pool.add(new WeightedTrade(50, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.TOURMALINE_PICKAXE, 16, 30, 3, 30)));

            // 55% Enchanted Tanzanite Pickaxe
            pool.add(new WeightedTrade(55, new TradeOffers.SellEnchantedToolFactory(
                    ModItems.TANZANITE_PICKAXE, 14, 28, 3, 30)));

            // 10% Adamantium Smithing Template (your item name is ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE)
            pool.add(new WeightedTrade(10, new TradeOffers.SellItemFactory(
                    ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, 54, 1, 1, 30, 0.5f)));

            WeightedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });
    }
}
