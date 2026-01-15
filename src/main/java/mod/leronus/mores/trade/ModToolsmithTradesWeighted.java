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

    private static boolean REGISTERED = false;

    public static void register() {
        if (REGISTERED) return;
        REGISTERED = true;

        // NOVICE (3 slots) – NO STONE TOOLS
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, factories -> {
            factories.clear();
            Random r = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_COAL", 30,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COAL, 15, 1, 16, 2, 0.05f)));

            // iron/cobalt/silver: balance so iron not 0/7 and silver not 6/7
            pool.add(new WeightedTrade("SELL_IRON_AXE", 18, new TradeOffers.SellItemFactory(Items.IRON_AXE, 3, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_IRON_PICK", 18, new TradeOffers.SellItemFactory(Items.IRON_PICKAXE, 3, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_IRON_SHOVEL", 18, new TradeOffers.SellItemFactory(Items.IRON_SHOVEL, 2, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_IRON_HOE", 18, new TradeOffers.SellItemFactory(Items.IRON_HOE, 2, 1, 12, 1, 0.20f)));

            pool.add(new WeightedTrade("SELL_COBALT_AXE", 16, new TradeOffers.SellItemFactory(ModItems.COBALT_AXE, 3, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_COBALT_PICK", 16, new TradeOffers.SellItemFactory(ModItems.COBALT_PICKAXE, 3, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_COBALT_SHOVEL", 16, new TradeOffers.SellItemFactory(ModItems.COBALT_SHOVEL, 2, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_COBALT_HOE", 16, new TradeOffers.SellItemFactory(ModItems.COBALT_HOE, 2, 1, 12, 1, 0.20f)));

            pool.add(new WeightedTrade("SELL_SILVER_AXE", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_AXE, 3, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_SILVER_PICK", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_PICKAXE, 3, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_SILVER_SHOVEL", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_SHOVEL, 2, 1, 12, 1, 0.20f)));
            pool.add(new WeightedTrade("SELL_SILVER_HOE", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_HOE, 2, 1, 12, 1, 0.20f)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });

        // APPRENTICE (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 2, factories -> {
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

        // JOURNEYMAN (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3, factories -> {
            factories.clear();
            Random r = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_FLINT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.FLINT, 30, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_CARBON_STEEL", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.CARBON_STEEL_INGOT, 2, 1, 12, 20, 0.05f)));

            // gem buy – ruby/moissanite omhoog
            pool.add(new WeightedTrade("BUY_RUBY", 16,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.RUBY_GEM, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_MOISSANITE", 14,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.MOISSANITE_GEM, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_TOPAZ", 8,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TOPAZ_GEM, 1, 1, 12, 20, 0.05f)));

            // hoe sells
            pool.add(new WeightedTrade("SELL_DIAMOND_HOE", 14, new TradeOffers.SellItemFactory(Items.DIAMOND_HOE, 4, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_RUBY_HOE", 12, new TradeOffers.SellItemFactory(ModItems.RUBY_HOE, 5, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_MOISS_HOE", 10, new TradeOffers.SellItemFactory(ModItems.MOISSANITE_HOE, 5, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_SPINEL_HOE", 10, new TradeOffers.SellItemFactory(ModItems.SPINEL_HOE, 4, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_SAPPHIRE_HOE", 10, new TradeOffers.SellItemFactory(ModItems.SAPPHIRE_HOE, 5, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_TOPAZ_HOE", 7, new TradeOffers.SellItemFactory(ModItems.TOPAZ_HOE, 4, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_TOUR_HOE", 6, new TradeOffers.SellItemFactory(ModItems.TOURMALINE_HOE, 3, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_TANZ_HOE", 4, new TradeOffers.SellItemFactory(ModItems.TANZANITE_HOE, 3, 1, 3, 10, 0.20f)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });

        // EXPERT (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 4, factories -> {
            factories.clear();
            Random r = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("ENCH_AXE_DIAMOND", 11, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_AXE, 17, 31, 3, 15)));
            pool.add(new WeightedTrade("ENCH_SHOVEL_DIAMOND", 10, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_SHOVEL, 10, 24, 3, 15)));

            pool.add(new WeightedTrade("ENCH_AXE_RUBY", 8, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_AXE, 25, 39, 3, 15)));
            pool.add(new WeightedTrade("ENCH_SHOVEL_RUBY", 8, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_SHOVEL, 17, 31, 3, 15)));

            pool.add(new WeightedTrade("ENCH_AXE_MOISS", 9, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_AXE, 23, 38, 3, 15)));
            pool.add(new WeightedTrade("ENCH_SHOVEL_MOISS", 9, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_SHOVEL, 14, 29, 3, 15)));

            pool.add(new WeightedTrade("ENCH_AXE_SPINEL", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_AXE, 17, 31, 3, 15)));
            pool.add(new WeightedTrade("ENCH_SHOVEL_SPINEL", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_SHOVEL, 10, 24, 3, 15)));

            pool.add(new WeightedTrade("ENCH_AXE_TOPAZ", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_AXE, 17, 31, 3, 15)));
            pool.add(new WeightedTrade("ENCH_SHOVEL_TOPAZ", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_SHOVEL, 10, 24, 3, 15)));

            pool.add(new WeightedTrade("ENCH_AXE_TANZ", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_AXE, 13, 27, 3, 15)));
            pool.add(new WeightedTrade("ENCH_SHOVEL_TANZ", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_SHOVEL, 8, 22, 3, 15)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });

        // MASTER (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 5, factories -> {
            factories.clear();
            Random r = Random.create();
            List<WeightedTrade> pool = new ArrayList<>();

            // allow multiple pickaxes because keys per item
            pool.add(new WeightedTrade("ENCH_PICK_DIAMOND", 12, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_PICKAXE, 18, 32, 3, 30)));
            pool.add(new WeightedTrade("ENCH_PICK_RUBY", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_PICKAXE, 40, 54, 3, 30)));
            pool.add(new WeightedTrade("ENCH_PICK_MOISS", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_PICKAXE, 25, 39, 3, 30)));
            pool.add(new WeightedTrade("ENCH_PICK_SPINEL", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_PICKAXE, 17, 31, 3, 30)));
            pool.add(new WeightedTrade("ENCH_PICK_SAPPHIRE", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_PICKAXE, 22, 36, 3, 30)));
            pool.add(new WeightedTrade("ENCH_PICK_TOPAZ", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_PICKAXE, 16, 30, 3, 30)));
            pool.add(new WeightedTrade("ENCH_PICK_TOUR", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_PICKAXE, 16, 30, 3, 30)));
            pool.add(new WeightedTrade("ENCH_PICK_TANZ", 13, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_PICKAXE, 14, 28, 3, 30)));

            // template rare
            pool.add(new WeightedTrade("TEMPLATE_ADAMANTIUM", 1,
                    new TradeOffers.SellItemFactory(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, 54, 1, 1, 30, 0.05f)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });
    }
}
