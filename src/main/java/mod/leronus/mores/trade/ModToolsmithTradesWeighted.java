package mod.leronus.mores.trade;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import mod.leronus.mores.item.ModItems;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffers;

import java.util.ArrayList;
import java.util.List;

public class ModToolsmithTradesWeighted {

    public static Int2ObjectMap<TradeOffers.Factory[]> buildLeveledTradeMap() {
        Int2ObjectMap<TradeOffers.Factory[]> out = new Int2ObjectOpenHashMap<>();
        Random r = Random.create();

        // ==================== LEVEL 1 (3 slots) ====================
        {
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_COAL", 30,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COAL, 15, 1, 16, 2, 0.05f)));

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

            out.put(1, pick(pool, 3, r));
        }

        // ==================== LEVEL 2 (3 slots) ====================
        {
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

            out.put(2, pick(pool, 3, r));
        }

        // ==================== LEVEL 3 (3 slots): 2 buy + 1 sell (hoes) ====================
        {
            List<WeightedTrade> buyPool = new ArrayList<>();
            List<WeightedTrade> sellPool = new ArrayList<>();

            buyPool.add(new WeightedTrade("BUY_FLINT", 50,
                    TradeFactoryUtil.buyItemForEmeralds(Items.FLINT, 30, 1, 12, 20, 0.05f)));
            buyPool.add(new WeightedTrade("BUY_CARBON_STEEL", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.CARBON_STEEL_INGOT, 2, 1, 12, 20, 0.05f)));
            buyPool.add(new WeightedTrade("BUY_TOPAZ", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TOPAZ_GEM, 1, 1, 12, 20, 0.05f)));
            buyPool.add(new WeightedTrade("BUY_RUBY", 10,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.RUBY_GEM, 1, 1, 12, 20, 0.05f)));
            buyPool.add(new WeightedTrade("BUY_MOISSANITE", 10,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.MOISSANITE_GEM, 1, 1, 12, 20, 0.05f)));

            sellPool.add(new WeightedTrade("SELL_HOE_DIAMOND", 25, new TradeOffers.SellItemFactory(Items.DIAMOND_HOE, 4, 1, 3, 10, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_HOE_RUBY", 25, new TradeOffers.SellItemFactory(ModItems.RUBY_HOE, 5, 1, 3, 10, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_HOE_MOISSANITE", 25, new TradeOffers.SellItemFactory(ModItems.MOISSANITE_HOE, 5, 1, 3, 10, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_HOE_SPINEL", 25, new TradeOffers.SellItemFactory(ModItems.SPINEL_HOE, 4, 1, 3, 10, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_HOE_SAPPHIRE", 25, new TradeOffers.SellItemFactory(ModItems.SAPPHIRE_HOE, 5, 1, 3, 10, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_HOE_TOPAZ", 25, new TradeOffers.SellItemFactory(ModItems.TOPAZ_HOE, 4, 1, 3, 10, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_HOE_TOURMALINE", 25, new TradeOffers.SellItemFactory(ModItems.TOURMALINE_HOE, 3, 1, 3, 10, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_HOE_TANZANITE", 25, new TradeOffers.SellItemFactory(ModItems.TANZANITE_HOE, 3, 1, 3, 10, 0.20f)));

            out.put(3, concat(
                    pick(buyPool, 2, r),
                    pick(sellPool, 1, r)
            ));
        }

        // ==================== LEVEL 4 (3 slots) ====================
        {
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("ENCH_AXE_DIAMOND", 9, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_AXE, 17, 3, 15, 0.20f)));
            pool.add(new WeightedTrade("ENCH_SHOVEL_DIAMOND", 9, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_SHOVEL, 10, 3, 15, 0.20f)));

            pool.add(new WeightedTrade("ENCH_AXE_RUBY", 8, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_AXE, 25, 3, 15, 0.20f)));
            pool.add(new WeightedTrade("ENCH_SHOVEL_RUBY", 8, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_SHOVEL, 17, 3, 15, 0.20f)));

            pool.add(new WeightedTrade("ENCH_AXE_MOISS", 9, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_AXE, 23, 3, 15, 0.20f)));
            pool.add(new WeightedTrade("ENCH_SHOVEL_MOISS", 9, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_SHOVEL, 14, 3, 15, 0.20f)));

            pool.add(new WeightedTrade("ENCH_AXE_SPINEL", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_AXE, 17, 3, 15, 0.20f)));
            pool.add(new WeightedTrade("ENCH_SHOVEL_SPINEL", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_SHOVEL, 10, 3, 15, 0.20f)));

            pool.add(new WeightedTrade("ENCH_AXE_TOPAZ", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_AXE, 17, 3, 15, 0.20f)));
            pool.add(new WeightedTrade("ENCH_SHOVEL_TOPAZ", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_SHOVEL, 10, 3, 15, 0.20f)));

            pool.add(new WeightedTrade("ENCH_AXE_TANZ", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_AXE, 13, 3, 15, 0.20f)));
            pool.add(new WeightedTrade("ENCH_SHOVEL_TANZ", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_SHOVEL, 8, 3, 15, 0.20f)));

            out.put(4, pick(pool, 3, r));
        }

        // ==================== LEVEL 5 (3 slots) ====================
        {
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("ENCH_PICK_DIAMOND", 12, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_PICKAXE, 18, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("ENCH_PICK_RUBY", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_PICKAXE, 40, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("ENCH_PICK_MOISS", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_PICKAXE, 25, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("ENCH_PICK_SPINEL", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_PICKAXE, 17, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("ENCH_PICK_SAPPHIRE", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_PICKAXE, 22, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("ENCH_PICK_TOPAZ", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_PICKAXE, 16, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("ENCH_PICK_TOUR", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_PICKAXE, 16, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("ENCH_PICK_TANZ", 13, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_PICKAXE, 14, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("TEMPLATE_ADAMANTIUM", 1,
                    new TradeOffers.SellItemFactory(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, 54, 1, 1, 30, 0.05f)));

            out.put(5, pick(pool, 3, r));
        }

        return out;
    }

    private static TradeOffers.Factory[] pick(List<WeightedTrade> pool, int count, Random r) {
        return WeightedTradeSelector.select(pool, Math.min(count, pool.size()), r)
                .stream()
                .map(WeightedTrade::factory)
                .toArray(TradeOffers.Factory[]::new);
    }

    private static TradeOffers.Factory[] concat(TradeOffers.Factory[] a, TradeOffers.Factory[] b) {
        TradeOffers.Factory[] out = new TradeOffers.Factory[a.length + b.length];
        System.arraycopy(a, 0, out, 0, a.length);
        System.arraycopy(b, 0, out, a.length, b.length);
        return out;
    }
}
