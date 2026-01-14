package mod.leronus.mores.trade;

import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

import java.util.ArrayList;
import java.util.List;

public class ModToolsmithTradesWeighted {

    public static void register() {

        /* ==================== NOVICE (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, factories -> {
            factories.clear();
            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY:COAL", 40,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COAL, 15, 1, 16, 2)));

            // Tools: key by TOOL TYPE so you can't roll 3 axes.
            pool.add(new KeyedTrade("AXE", 15, new TradeOffers.SellItemFactory(Items.IRON_AXE, 3, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("SHOVEL", 15, new TradeOffers.SellItemFactory(Items.IRON_SHOVEL, 2, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("PICKAXE", 15, new TradeOffers.SellItemFactory(Items.IRON_PICKAXE, 3, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("HOE", 15, new TradeOffers.SellItemFactory(Items.IRON_HOE, 2, 1, 12, 1, 0.2f)));

            pool.add(new KeyedTrade("AXE", 15, new TradeOffers.SellItemFactory(ModItems.COBALT_AXE, 3, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("SHOVEL", 15, new TradeOffers.SellItemFactory(ModItems.COBALT_SHOVEL, 2, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("PICKAXE", 15, new TradeOffers.SellItemFactory(ModItems.COBALT_PICKAXE, 3, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("HOE", 15, new TradeOffers.SellItemFactory(ModItems.COBALT_HOE, 2, 1, 12, 1, 0.2f)));

            pool.add(new KeyedTrade("AXE", 15, new TradeOffers.SellItemFactory(ModItems.SILVER_AXE, 3, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("SHOVEL", 15, new TradeOffers.SellItemFactory(ModItems.SILVER_SHOVEL, 2, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("PICKAXE", 15, new TradeOffers.SellItemFactory(ModItems.SILVER_PICKAXE, 3, 1, 12, 1, 0.2f)));
            pool.add(new KeyedTrade("HOE", 15, new TradeOffers.SellItemFactory(ModItems.SILVER_HOE, 2, 1, 12, 1, 0.2f)));

            pool.add(new KeyedTrade("BUY:TIN_INGOT", 30,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TIN_INGOT, 26, 1, 16, 2)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== APPRENTICE (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 2, factories -> {
            factories.clear();
            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY:IRON_INGOT", 60,
                    TradeFactoryUtil.buyItemForEmeralds(Items.IRON_INGOT, 4, 1, 12, 10)));

            pool.add(new KeyedTrade("SELL:BELL", 60,
                    new TradeOffers.SellItemFactory(Items.BELL, 36, 1, 12, 5, 0.2f)));

            // IMPORTANT FIXES:
            // 7 silver -> 1 emerald (NOT 10)
            pool.add(new KeyedTrade("BUY:SILVER_INGOT", 60,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SILVER_INGOT, 7, 1, 12, 10)));

            // 10 copper -> 1 emerald (NOT 10)
            pool.add(new KeyedTrade("BUY:COPPER_INGOT", 60,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COPPER_INGOT, 10, 1, 12, 10)));

            pool.add(new KeyedTrade("BUY:COBALT_INGOT", 60,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.COBALT_INGOT, 4, 1, 12, 10)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== JOURNEYMAN (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3, factories -> {
            factories.clear();
            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY:FLINT", 30,
                    TradeFactoryUtil.buyItemForEmeralds(Items.FLINT, 30, 1, 12, 20)));

            pool.add(new KeyedTrade("BUY:CARBON_STEEL_INGOT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.CARBON_STEEL_INGOT, 2, 1, 12, 20)));

            pool.add(new KeyedTrade("BUY:RUBY_GEM", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.RUBY_GEM, 1, 1, 12, 20)));

            pool.add(new KeyedTrade("BUY:TOPAZ_GEM", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TOPAZ_GEM, 1, 1, 12, 20)));

            pool.add(new KeyedTrade("BUY:DIAMOND", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.DIAMOND, 1, 1, 12, 20)));

            // Hoe sells: key "HOE" so you won't get multiple hoe rows this roll.
            pool.add(new KeyedTrade("HOE", 10, new TradeOffers.SellItemFactory(Items.DIAMOND_HOE, 4, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("HOE", 5, new TradeOffers.SellItemFactory(ModItems.MOISSANITE_HOE, 5, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("HOE", 5, new TradeOffers.SellItemFactory(ModItems.SAPPHIRE_HOE, 5, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("HOE", 5, new TradeOffers.SellItemFactory(ModItems.RUBY_HOE, 5, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("HOE", 10, new TradeOffers.SellItemFactory(ModItems.SPINEL_HOE, 4, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("HOE", 15, new TradeOffers.SellItemFactory(ModItems.TOPAZ_HOE, 4, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("HOE", 20, new TradeOffers.SellItemFactory(ModItems.TOURMALINE_HOE, 3, 1, 3, 10, 0.2f)));
            pool.add(new KeyedTrade("HOE", 25, new TradeOffers.SellItemFactory(ModItems.TANZANITE_HOE, 3, 1, 3, 10, 0.2f)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== EXPERT (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 4, factories -> {
            factories.clear();
            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            // Enchanted tool rows: key by tool type (no multiple axes)
            pool.add(new KeyedTrade("AXE", 16, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_AXE, 17, 31, 3, 15)));
            pool.add(new KeyedTrade("SHOVEL", 16, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_SHOVEL, 10, 24, 3, 15)));

            pool.add(new KeyedTrade("AXE", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_AXE, 23, 38, 3, 15)));
            pool.add(new KeyedTrade("SHOVEL", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_SHOVEL, 14, 29, 3, 15)));

            pool.add(new KeyedTrade("AXE", 15, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_AXE, 20, 34, 3, 15)));
            pool.add(new KeyedTrade("SHOVEL", 15, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_SHOVEL, 12, 26, 3, 15)));

            pool.add(new KeyedTrade("AXE", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_AXE, 25, 39, 3, 15)));
            pool.add(new KeyedTrade("SHOVEL", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_SHOVEL, 17, 31, 3, 15)));

            pool.add(new KeyedTrade("AXE", 20, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_AXE, 17, 31, 3, 15)));
            pool.add(new KeyedTrade("SHOVEL", 20, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_SHOVEL, 10, 24, 3, 15)));

            pool.add(new KeyedTrade("AXE", 25, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_AXE, 17, 31, 3, 15)));
            pool.add(new KeyedTrade("SHOVEL", 25, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_SHOVEL, 10, 24, 3, 15)));

            pool.add(new KeyedTrade("AXE", 30, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_AXE, 16, 30, 3, 15)));
            pool.add(new KeyedTrade("SHOVEL", 30, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_SHOVEL, 9, 23, 3, 15)));

            pool.add(new KeyedTrade("AXE", 35, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_AXE, 13, 27, 3, 15)));
            pool.add(new KeyedTrade("SHOVEL", 35, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_SHOVEL, 8, 22, 3, 15)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });

        /* ==================== MASTER (3 slots) ==================== */
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 5, factories -> {
            factories.clear();
            Random random = Random.create();
            List<KeyedTrade> pool = new ArrayList<>();

            // Pickaxe is the main category here.
            pool.add(new KeyedTrade("PICKAXE", 40, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_PICKAXE, 18, 32, 3, 30)));
            pool.add(new KeyedTrade("PICKAXE", 25, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_PICKAXE, 25, 39, 3, 30)));
            pool.add(new KeyedTrade("PICKAXE", 30, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_PICKAXE, 22, 36, 3, 30)));
            pool.add(new KeyedTrade("PICKAXE", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_PICKAXE, 40, 54, 3, 30)));
            pool.add(new KeyedTrade("PICKAXE", 35, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_PICKAXE, 17, 31, 3, 30)));
            pool.add(new KeyedTrade("PICKAXE", 45, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_PICKAXE, 16, 30, 3, 30)));
            pool.add(new KeyedTrade("PICKAXE", 50, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_PICKAXE, 16, 30, 3, 30)));
            pool.add(new KeyedTrade("PICKAXE", 55, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_PICKAXE, 14, 28, 3, 30)));

            pool.add(new KeyedTrade("SELL:ADAMANTIUM_TEMPLATE", 10,
                    new TradeOffers.SellItemFactory(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, 54, 1, 1, 30, 0.5f)));

            KeyedTradeSelector.select(pool, 3, random).forEach(t -> factories.add(t.factory()));
        });
    }
}
