package mod.leronus.mores.trade;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import mod.leronus.mores.item.ModItems;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffers;

import java.util.ArrayList;
import java.util.List;

public class ModArmorerTradesWeighted {

    public static Int2ObjectMap<TradeOffers.Factory[]> buildLeveledTradeMap() {
        Int2ObjectMap<TradeOffers.Factory[]> out = new Int2ObjectOpenHashMap<>();
        Random r = Random.create();

        // LEVEL 1: 1 buy + 2 sell
        {
            List<WeightedTrade> buyPool = new ArrayList<>();
            List<WeightedTrade> sellPool = new ArrayList<>();

            buyPool.add(new WeightedTrade("BUY", 50,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COAL, 15, 1, 16, 2, 0.05f)));
            buyPool.add(new WeightedTrade("BUY", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.ANTHRACITE, 9, 1, 12, 2, 0.05f)));
            buyPool.add(new WeightedTrade("BUY", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.RAW_SILVER, 7, 1, 12, 2, 0.05f)));
            buyPool.add(new WeightedTrade("BUY", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.RAW_COPPER, 16, 1, 12, 2, 0.05f)));
            buyPool.add(new WeightedTrade("BUY", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.RAW_TIN, 14, 1, 12, 2, 0.05f)));

            // 2 armor sells; key prevents 2 helmets etc.
            sellPool.add(new WeightedTrade("SELL_ARMOR", 10, new TradeOffers.SellItemFactory(Items.IRON_HELMET, 5, 1, 12, 1, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_ARMOR", 10, new TradeOffers.SellItemFactory(Items.IRON_CHESTPLATE, 9, 1, 12, 1, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_ARMOR", 10, new TradeOffers.SellItemFactory(Items.IRON_LEGGINGS, 7, 1, 12, 1, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_ARMOR", 10, new TradeOffers.SellItemFactory(Items.IRON_BOOTS, 4, 1, 12, 1, 0.20f)));

            sellPool.add(new WeightedTrade("SELL_ARMOR", 14, new TradeOffers.SellItemFactory(ModItems.COBALT_HELMET, 5, 1, 12, 1, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_ARMOR", 14, new TradeOffers.SellItemFactory(ModItems.COBALT_CHESTPLATE, 9, 1, 12, 1, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_ARMOR", 14, new TradeOffers.SellItemFactory(ModItems.COBALT_LEGGINGS, 7, 1, 12, 1, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_ARMOR", 14, new TradeOffers.SellItemFactory(ModItems.COBALT_BOOTS, 4, 1, 12, 1, 0.20f)));

            sellPool.add(new WeightedTrade("SELL_ARMOR", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_HELMET, 4, 1, 12, 1, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_ARMOR", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_CHESTPLATE, 8, 1, 12, 1, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_ARMOR", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_LEGGINGS, 6, 1, 12, 1, 0.20f)));
            sellPool.add(new WeightedTrade("SELL_ARMOR", 16, new TradeOffers.SellItemFactory(ModItems.SILVER_BOOTS, 3, 1, 12, 1, 0.20f)));

            out.put(1, concat(
                    pick(buyPool, 1, r),
                    pick(sellPool, 2, r)
            ));
        }

        // LEVEL 2: 2 buy + 1 sell
        {
            List<WeightedTrade> buyPool = new ArrayList<>();
            List<WeightedTrade> sellPool = new ArrayList<>();

            buyPool.add(new WeightedTrade("BUY", 25, TradeFactoryUtil.buyItemForEmeralds(Items.IRON_INGOT, 4, 1, 12, 10, 0.05f)));
            buyPool.add(new WeightedTrade("BUY", 25, TradeFactoryUtil.buyItemForEmeralds(ModItems.SILVER_INGOT, 7, 1, 12, 10, 0.05f)));
            buyPool.add(new WeightedTrade("BUY", 25, TradeFactoryUtil.buyItemForEmeralds(Items.COPPER_INGOT, 10, 1, 12, 10, 0.05f)));
            buyPool.add(new WeightedTrade("BUY", 25, TradeFactoryUtil.buyItemForEmeralds(ModItems.COBALT_INGOT, 4, 1, 12, 10, 0.05f)));

            // ONE sell slot: either bell or graphene chainmail pieces
            sellPool.add(new WeightedTrade("SELL_SPECIAL", 20, new TradeOffers.SellItemFactory(Items.BELL, 24, 1, 12, 5, 0.05f)));

            sellPool.add(new WeightedTrade("SELL_SPECIAL", 20, new TradeOffers.SellItemFactory(ModItems.GRAPHENE_CHAINMAIL_HELMET, 36, 1, 3, 10, 0.05f)));
            sellPool.add(new WeightedTrade("SELL_SPECIAL", 20, new TradeOffers.SellItemFactory(ModItems.GRAPHENE_CHAINMAIL_CHESTPLATE, 36, 1, 3, 10, 0.05f)));
            sellPool.add(new WeightedTrade("SELL_SPECIAL", 20, new TradeOffers.SellItemFactory(ModItems.GRAPHENE_CHAINMAIL_LEGGINGS, 36, 1, 3, 10, 0.05f)));
            sellPool.add(new WeightedTrade("SELL_SPECIAL", 20, new TradeOffers.SellItemFactory(ModItems.GRAPHENE_CHAINMAIL_BOOTS, 36, 1, 3, 10, 0.05f)));

            out.put(2, concat(
                    pick(buyPool, 2, r),
                    pick(sellPool, 1, r)
            ));
        }

        // LEVEL 3: pick 3
        {
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY", 18, TradeFactoryUtil.buyItemForEmeralds(Items.LAVA_BUCKET, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY", 18, TradeFactoryUtil.buyItemForEmeralds(ModItems.ROSE_GOLD_INGOT, 2, 1, 12, 20, 0.05f)));

            pool.add(new WeightedTrade("SELL_SHIELD", 18, new TradeOffers.SellItemFactory(ModItems.COBALT_SHIELD, 12, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_SHIELD", 18, new TradeOffers.SellItemFactory(ModItems.CARBON_STEEL_SHIELD, 12, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_SHIELD", 14, new TradeOffers.SellItemFactory(ModItems.TOPAZ_SHIELD, 11, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_SHIELD", 10, new TradeOffers.SellItemFactory(ModItems.TOURMALINE_SHIELD, 10, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_SHIELD", 10, new TradeOffers.SellItemFactory(ModItems.RUBY_SHIELD, 13, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_SHIELD", 10, new TradeOffers.SellItemFactory(ModItems.SAPPHIRE_SHIELD, 14, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_SHIELD", 12, new TradeOffers.SellItemFactory(ModItems.EMERALD_SHIELD, 14, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_SHIELD", 12, new TradeOffers.SellItemFactory(ModItems.AMETHYST_SHIELD, 14, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_SHIELD", 16, new TradeOffers.SellItemFactory(ModItems.LAPIS_LAZULI_SHIELD, 12, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_SHIELD", 12, new TradeOffers.SellItemFactory(ModItems.CITRINE_SHIELD, 12, 1, 3, 10, 0.20f)));

            pool.add(new WeightedTrade("BUY_GEM", 12, TradeFactoryUtil.buyItemForEmeralds(ModItems.SAPPHIRE_GEM, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_GEM", 12, TradeFactoryUtil.buyItemForEmeralds(ModItems.SPINEL_GEM, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_GEM", 11, TradeFactoryUtil.buyItemForEmeralds(ModItems.RUBY_GEM, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_GEM", 14, TradeFactoryUtil.buyItemForEmeralds(ModItems.TOPAZ_GEM, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_GEM", 15, TradeFactoryUtil.buyItemForEmeralds(ModItems.TOURMALINE_GEM, 1, 1, 12, 20, 0.05f)));
            pool.add(new WeightedTrade("BUY_GEM", 13, TradeFactoryUtil.buyItemForEmeralds(ModItems.TANZANITE_GEM, 1, 1, 12, 20, 0.05f)));

            out.put(3, pick(pool, 3, r));
        }

        // LEVEL 4: pick 3
        {
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("SELL_ENCH", 14, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_LEGGINGS, 19, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 14, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_BOOTS, 13, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_LEGGINGS, 23, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_BOOTS, 17, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_LEGGINGS, 27, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_BOOTS, 21, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_LEGGINGS, 21, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_BOOTS, 15, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_LEGGINGS, 27, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_BOOTS, 19, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 6, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_LEGGINGS, 22, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 6, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_BOOTS, 16, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 5, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_LEGGINGS, 19, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 5, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_BOOTS, 13, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 3, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_LEGGINGS, 23, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 3, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_BOOTS, 17, 3, 30, 0.20f)));

            out.put(4, pick(pool, 3, r));
        }

        // LEVEL 5: pick 3 (template rare)
        {
            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("SELL_ENCH", 14, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_CHESTPLATE, 20, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 14, new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_HELMET, 12, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_CHESTPLATE, 25, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_HELMET, 17, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_CHESTPLATE, 29, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 12, new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_HELMET, 21, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_CHESTPLATE, 23, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 14, new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_HELMET, 15, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_CHESTPLATE, 29, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 10, new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_HELMET, 19, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 16, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_CHESTPLATE, 24, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 16, new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_HELMET, 16, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 16, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_CHESTPLATE, 21, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 16, new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_HELMET, 13, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_ENCH", 16, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_CHESTPLATE, 25, 3, 30, 0.20f)));
            pool.add(new WeightedTrade("SELL_ENCH", 16, new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_HELMET, 17, 3, 30, 0.20f)));

            pool.add(new WeightedTrade("SELL_TEMPLATE", 2,
                    new TradeOffers.SellItemFactory(ModItems.HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE, 48, 1, 1, 30, 0.05f)));

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
