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

public class ModToolsmithTradesWeighted {

    public static void addLevelOffers(Entity villager, TradeOfferList offers, int level, Random r) {
        if (level == 1) {
            // 3 slots
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY_COAL", 30,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COAL, 15, 1, 16, 2, 0.05f)));

            pool.add(new KeyedTrade("SELL_AXE", 18, new TradeOffers.SellItemFactory(Items.IRON_AXE, 3, 1, 12, 1, 0.20f)));
            pool.add(new KeyedTrade("SELL_PICK", 18, new TradeOffers.SellItemFactory(Items.IRON_PICKAXE, 3, 1, 12, 1, 0.20f)));
            pool.add(new KeyedTrade("SELL_SHOVEL", 18, new TradeOffers.SellItemFactory(Items.IRON_SHOVEL, 2, 1, 12, 1, 0.20f)));
            pool.add(new KeyedTrade("SELL_HOE", 18, new TradeOffers.SellItemFactory(Items.IRON_HOE, 2, 1, 12, 1, 0.20f)));

            pool.add(new KeyedTrade("SELL_AXE", 16, new TradeOffers.SellItemFactory(ModItems.COBALT_AXE, 3, 1, 12, 1, 0.20f)));
            pool.add(new KeyedTrade("SELL_PICK", 16, new TradeOffers.SellItemFactory(ModItems.COBALT_PICKAXE, 3, 1, 12, 1, 0.20f)));
            pool.add(new KeyedTrade("SELL_SHOVEL", 16, new TradeOffers.SellItemFactory(ModItems.COBALT_SHOVEL, 2, 1, 12, 1, 0.20f)));
            pool.add(new KeyedTrade("SELL_HOE", 16, new TradeOffers.SellItemFactory(ModItems.COBALT_HOE, 2, 1, 12, 1, 0.20f)));

            pool.add(new KeyedTrade("SELL_AXE", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_AXE, 3, 1, 12, 1, 0.20f)));
            pool.add(new KeyedTrade("SELL_PICK", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_PICKAXE, 3, 1, 12, 1, 0.20f)));
            pool.add(new KeyedTrade("SELL_SHOVEL", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_SHOVEL, 2, 1, 12, 1, 0.20f)));
            pool.add(new KeyedTrade("SELL_HOE", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_HOE, 2, 1, 12, 1, 0.20f)));

            addSelected(pool, offers, 3, villager, r);
            return;
        }

        if (level == 2) {
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("BUY_IRON", 25, TradeFactoryUtil.buyItemForEmeralds(Items.IRON_INGOT, 4, 1, 12, 10, 0.05f)));
            pool.add(new KeyedTrade("SELL_BELL", 20, new TradeOffers.SellItemFactory(Items.BELL, 36, 1, 12, 5, 0.05f)));
            pool.add(new KeyedTrade("BUY_SILVER", 25, TradeFactoryUtil.buyItemForEmeralds(ModItems.SILVER_INGOT, 7, 1, 12, 10, 0.05f)));
            pool.add(new KeyedTrade("BUY_COPPER", 25, TradeFactoryUtil.buyItemForEmeralds(Items.COPPER_INGOT, 10, 1, 12, 10, 0.05f)));
            pool.add(new KeyedTrade("BUY_COBALT", 25, TradeFactoryUtil.buyItemForEmeralds(ModItems.COBALT_INGOT, 4, 1, 12, 10, 0.05f)));

            addSelected(pool, offers, 3, villager, r);
            return;
        }

        if (level == 3) {
            // 2 buy + 1 sell (hoes), no duplicates
            List<KeyedTrade> buyPool = new ArrayList<>();
            List<KeyedTrade> sellPool = new ArrayList<>();

            buyPool.add(new KeyedTrade("BUY_FLINT", WeightTiers.COMMON,
                    TradeFactoryUtil.buyItemForEmeralds(Items.FLINT, 30, 1, 12, 20, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_CARBON_STEEL", WeightTiers.UNCOMMON,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.CARBON_STEEL_INGOT, 2, 1, 12, 20, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_TOPAZ", WeightTiers.UNCOMMON,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TOPAZ_GEM, 1, 1, 12, 20, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_RUBY", WeightTiers.RARE,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.RUBY_GEM, 1, 1, 12, 20, 0.05f)));
            buyPool.add(new KeyedTrade("BUY_MOISSANITE", WeightTiers.RARE,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.MOISSANITE_GEM, 1, 1, 12, 20, 0.05f)));

            sellPool.add(new KeyedTrade("SELL_HOE", WeightTiers.UNCOMMON, new TradeOffers.SellItemFactory(Items.DIAMOND_HOE, 4, 1, 3, 10, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_HOE", WeightTiers.UNCOMMON, new TradeOffers.SellItemFactory(ModItems.RUBY_HOE, 5, 1, 3, 10, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_HOE", WeightTiers.UNCOMMON, new TradeOffers.SellItemFactory(ModItems.MOISSANITE_HOE, 5, 1, 3, 10, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_HOE", WeightTiers.UNCOMMON, new TradeOffers.SellItemFactory(ModItems.SPINEL_HOE, 4, 1, 3, 10, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_HOE", WeightTiers.UNCOMMON, new TradeOffers.SellItemFactory(ModItems.SAPPHIRE_HOE, 5, 1, 3, 10, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_HOE", WeightTiers.UNCOMMON, new TradeOffers.SellItemFactory(ModItems.TOPAZ_HOE, 4, 1, 3, 10, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_HOE", WeightTiers.UNCOMMON, new TradeOffers.SellItemFactory(ModItems.TOURMALINE_HOE, 3, 1, 3, 10, 0.20f)));
            sellPool.add(new KeyedTrade("SELL_HOE", WeightTiers.UNCOMMON, new TradeOffers.SellItemFactory(ModItems.TANZANITE_HOE, 3, 1, 3, 10, 0.20f)));

            addSelected(buyPool, offers, 2, villager, r);
            addSelected(sellPool, offers, 1, villager, r);
            return;
        }

        if (level == 4) {
            List<KeyedTrade> pool = new ArrayList<>();

            pool.add(new KeyedTrade("SELL_ENCH_AXE", 9, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_AXE, 17, 3, 15, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_SHOVEL", 9, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_SHOVEL, 10, 3, 15, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_AXE", 8, new TradeOffers.SellEnchantedToolFactory(ModItems.CITRINE_AXE, 16, 3, 15, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_SHOVEL", 8, new TradeOffers.SellEnchantedToolFactory(ModItems.CITRINE_SHOVEL, 9, 3, 15, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_AXE", 9, new TradeOffers.SellEnchantedToolFactory(ModItems.LAPIS_LAZULI_AXE, 14, 3, 15, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_SHOVEL", 9, new TradeOffers.SellEnchantedToolFactory(ModItems.LAPIS_LAZULI_SHOVEL, 7, 3, 15, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_AXE", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_AXE, 17, 3, 15, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_SHOVEL", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_SHOVEL, 10, 3, 15, 0.20f)));

            pool.add(new KeyedTrade("SELL_ENCH_AXE", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.TURQUOISE_AXE, 16, 3, 15, 0.20f)));
            pool.add(new KeyedTrade("SELL_ENCH_SHOVEL", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.TURQUOISE_SHOVEL, 9, 3, 15, 0.20f)));

            addSelected(pool, offers, 3, villager, r);
            return;
        }

        if (level == 5) {
            List<KeyedTrade> sellPickaxePool = new ArrayList<>();
            List<KeyedTrade> sellRandomPool = new ArrayList<>();

            //Smithing Templates
            sellRandomPool.add(new KeyedTrade("SELL_ENCH_AXE", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.ONYX_AXE, 18, 3, 30, 0.20f)));
            sellRandomPool.add(new KeyedTrade("SELL_ENCH_AXE", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_AXE, 18, 3, 30, 0.20f)));
            sellRandomPool.add(new KeyedTrade("SELL_ENCH_AXE", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_AXE, 18, 3, 30, 0.20f)));
            sellRandomPool.add(new KeyedTrade("SELL_ENCH_AXE", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_AXE, 18, 3, 30, 0.20f)));
            sellRandomPool.add(new KeyedTrade("SELL_ENCH_AXE", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.EMERALD_AXE, 18, 3, 30, 0.20f)));
            sellRandomPool.add(new KeyedTrade("SELL_ENCH_AXE", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_AXE, 18, 3, 30, 0.20f)));
            sellRandomPool.add(new KeyedTrade("SELL_TEMPLATE", 1,
                    new TradeOffers.SellItemFactory(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, 52, 1, 1, 30, 0.05f)));
            sellRandomPool.add(new KeyedTrade("SELL_TEMPLATE", 1,
                    new TradeOffers.SellItemFactory(ModItems.OBSIDIAN_UPGRADE_SMITHING_TEMPLATE, 48, 1, 1, 30, 0.05f)));
            sellRandomPool.add(new KeyedTrade("SELL_TEMPLATE", 1,
                    new TradeOffers.SellItemFactory(ModItems.HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE, 44, 1, 1, 30, 0.05f)));


            sellPickaxePool.add(new KeyedTrade("SELL_ENCH_PICK", 12, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_PICKAXE, 18, 3, 30, 0.20f)));
            sellPickaxePool.add(new KeyedTrade("SELL_ENCH_PICK", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_PICKAXE, 40, 3, 30, 0.20f)));
            sellPickaxePool.add(new KeyedTrade("SELL_ENCH_PICK", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_PICKAXE, 25, 3, 30, 0.20f)));
            sellPickaxePool.add(new KeyedTrade("SELL_ENCH_PICK", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_PICKAXE, 17, 3, 30, 0.20f)));
            sellPickaxePool.add(new KeyedTrade("SELL_ENCH_PICK", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_PICKAXE, 22, 3, 30, 0.20f)));
            sellPickaxePool.add(new KeyedTrade("SELL_ENCH_PICK", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_PICKAXE, 16, 3, 30, 0.20f)));
            sellPickaxePool.add(new KeyedTrade("SELL_ENCH_PICK", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_PICKAXE, 16, 3, 30, 0.20f)));
            sellPickaxePool.add(new KeyedTrade("SELL_ENCH_PICK", 13, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_PICKAXE, 14, 3, 30, 0.20f)));
            sellPickaxePool.add(new KeyedTrade("SELL_TEMPLATE", 1,
                    new TradeOffers.SellItemFactory(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, 52, 1, 1, 30, 0.05f)));
            sellPickaxePool.add(new KeyedTrade("SELL_TEMPLATE", 1,
                    new TradeOffers.SellItemFactory(ModItems.OBSIDIAN_UPGRADE_SMITHING_TEMPLATE, 48, 1, 1, 30, 0.05f)));
            sellPickaxePool.add(new KeyedTrade("SELL_TEMPLATE", 1,
                    new TradeOffers.SellItemFactory(ModItems.HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE, 44, 1, 1, 30, 0.05f)));

            addSelected(sellRandomPool, offers, 1, villager, r);
            addSelected(sellPickaxePool, offers, 1, villager, r);
        }
    }

    private static void addSelected(List<KeyedTrade> pool, TradeOfferList offers, int count, Entity villager, Random r) {
        List<KeyedTrade> selected = KeyedTradeSelector.select(pool, Math.min(count, pool.size()), r);
        for (KeyedTrade kt : selected) {
            TradeOffer offer = kt.factory().create(villager, r);
            if (offer != null) offers.add(offer);
        }
    }
}
