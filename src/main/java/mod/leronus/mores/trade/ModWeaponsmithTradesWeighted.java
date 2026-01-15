package mod.leronus.mores.trade;

import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

import java.util.ArrayList;
import java.util.List;

public class ModWeaponsmithTradesWeighted {

    private static boolean REGISTERED = false;

    public static void register() {
        if (REGISTERED) return;
        REGISTERED = true;

        // NOVICE (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 1, factories -> {
            factories.clear();
            Random r = Random.create();

            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_COAL", 35,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COAL, 15, 1, 16, 2, 0.05f)));

            pool.add(new WeightedTrade("SELL_IRON_SWORD", 35,
                    new TradeOffers.SellItemFactory(Items.IRON_SWORD, 3, 1, 12, 1, 0.20f)));

            pool.add(new WeightedTrade("SELL_IRON_DAGGER", 30,
                    new TradeOffers.SellItemFactory(ModItems.IRON_DAGGER, 2, 1, 12, 1, 0.20f)));

            pool.add(new WeightedTrade("SELL_IRON_BATTLE_AXE", 25,
                    new TradeOffers.SellItemFactory(ModItems.IRON_BATTLE_AXE, 4, 1, 12, 1, 0.20f)));

            pool.add(new WeightedTrade("SELL_IRON_BATTLE_MACE", 25,
                    new TradeOffers.SellItemFactory(ModItems.IRON_BATTLE_MACE, 4, 1, 12, 1, 0.20f)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });

        // APPRENTICE (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 2, factories -> {
            factories.clear();
            Random r = Random.create();

            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_IRON_INGOT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.IRON_INGOT, 4, 1, 12, 10, 0.05f)));

            pool.add(new WeightedTrade("SELL_BELL", 25,
                    new TradeOffers.SellItemFactory(Items.BELL, 36, 1, 12, 5, 0.05f)));

            pool.add(new WeightedTrade("BUY_SILVER_INGOT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SILVER_INGOT, 7, 1, 12, 10, 0.05f)));

            pool.add(new WeightedTrade("BUY_COPPER_INGOT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COPPER_INGOT, 10, 1, 12, 10, 0.05f)));

            pool.add(new WeightedTrade("BUY_COBALT_INGOT", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.COBALT_INGOT, 4, 1, 12, 10, 0.05f)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });

        // JOURNEYMAN (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3, factories -> {
            factories.clear();
            Random r = Random.create();

            List<WeightedTrade> pool = new ArrayList<>();

            pool.add(new WeightedTrade("BUY_FLINT", 30,
                    TradeFactoryUtil.buyItemForEmeralds(Items.FLINT, 24, 1, 12, 20, 0.05f)));

            pool.add(new WeightedTrade("BUY_STERLING_SILVER", 25,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.STERLING_SILVER_INGOT, 2, 1, 12, 20, 0.05f)));

            pool.add(new WeightedTrade("BUY_MOISSANITE", 20,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.MOISSANITE_GEM, 1, 1, 12, 20, 0.05f)));

            // dagger sell slot – tier weights (tanzanite lowest)
            pool.add(new WeightedTrade("SELL_DAGGER_MOISSANITE", 5,
                    new TradeOffers.SellItemFactory(ModItems.MOISSANITE_DAGGER, 3, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_DAGGER_SAPPHIRE", 7,
                    new TradeOffers.SellItemFactory(ModItems.SAPPHIRE_DAGGER, 3, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_DAGGER_RUBY", 6,
                    new TradeOffers.SellItemFactory(ModItems.RUBY_DAGGER, 3, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_DAGGER_SPINEL", 9,
                    new TradeOffers.SellItemFactory(ModItems.SPINEL_DAGGER, 3, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_DAGGER_TOPAZ", 9,
                    new TradeOffers.SellItemFactory(ModItems.TOPAZ_DAGGER, 3, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_DAGGER_TOURMALINE", 8,
                    new TradeOffers.SellItemFactory(ModItems.TOURMALINE_DAGGER, 2, 1, 3, 10, 0.20f)));
            pool.add(new WeightedTrade("SELL_DAGGER_TANZANITE", 7,
                    new TradeOffers.SellItemFactory(ModItems.TANZANITE_DAGGER, 2, 1, 3, 10, 0.20f)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });

        // EXPERT (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 4, factories -> {
            factories.clear();
            Random r = Random.create();

            List<WeightedTrade> pool = new ArrayList<>();

            // enchanted sword / mace – allow variety, no broad keys
            pool.add(new WeightedTrade("ENCH_SWORD_DIAMOND", 13,
                    new TradeOffers.SellEnchantedToolFactory(Items.DIAMOND_SWORD, 13, 27, 3, 15)));
            pool.add(new WeightedTrade("ENCH_MACE_DIAMOND", 14,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.DIAMOND_BATTLE_MACE, 20, 34, 3, 15)));

            pool.add(new WeightedTrade("ENCH_SWORD_MOISSANITE", 10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_SWORD, 15, 29, 3, 15)));
            pool.add(new WeightedTrade("ENCH_MACE_MOISSANITE", 10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_BATTLE_MACE, 22, 36, 3, 15)));

            pool.add(new WeightedTrade("ENCH_SWORD_SAPPHIRE", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_SWORD, 14, 28, 3, 15)));
            pool.add(new WeightedTrade("ENCH_MACE_SAPPHIRE", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_BATTLE_MACE, 21, 35, 3, 15)));

            pool.add(new WeightedTrade("ENCH_SWORD_RUBY", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_SWORD, 18, 32, 3, 15)));
            pool.add(new WeightedTrade("ENCH_MACE_RUBY", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_BATTLE_MACE, 25, 39, 3, 15)));

            pool.add(new WeightedTrade("ENCH_SWORD_SPINEL", 14,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_SWORD, 13, 27, 3, 15)));
            pool.add(new WeightedTrade("ENCH_MACE_SPINEL", 14,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_BATTLE_MACE, 20, 34, 3, 15)));
            pool.add(new WeightedTrade("ENCH_SWORD_TOPAZ", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_SWORD, 12, 26, 3, 15)));
            pool.add(new WeightedTrade("ENCH_MACE_TOPAZ", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_BATTLE_MACE, 19, 33, 3, 15)));

            pool.add(new WeightedTrade("ENCH_SWORD_TOURMALINE", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_SWORD, 11, 25, 3, 15)));
            pool.add(new WeightedTrade("ENCH_MACE_TOURMALINE", 16,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_BATTLE_MACE, 19, 33, 3, 15)));

            pool.add(new WeightedTrade("ENCH_SWORD_TANZANITE", 14,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_SWORD, 10, 24, 3, 15)));
            pool.add(new WeightedTrade("ENCH_MACE_TANZANITE", 15,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_BATTLE_MACE, 18, 32, 3, 15)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });

        // MASTER (3 slots)
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 5, factories -> {
            factories.clear();
            Random r = Random.create();

            List<WeightedTrade> pool = new ArrayList<>();

            // buy materials (normal multiplier)
            pool.add(new WeightedTrade("BUY_TIN", 18,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.TIN_INGOT, 26, 1, 16, 30, 0.05f)));
            pool.add(new WeightedTrade("BUY_IRON", 24,
                    TradeFactoryUtil.buyItemForEmeralds(Items.IRON_INGOT, 4, 1, 12, 30, 0.05f)));
            pool.add(new WeightedTrade("BUY_SILVER", 24,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.SILVER_INGOT, 7, 1, 12, 30, 0.05f)));
            pool.add(new WeightedTrade("BUY_COPPER", 24,
                    TradeFactoryUtil.buyItemForEmeralds(Items.COPPER_INGOT, 10, 1, 12, 30, 0.05f)));
            pool.add(new WeightedTrade("BUY_COBALT", 23,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.COBALT_INGOT, 4, 1, 12, 30, 0.05f)));
            pool.add(new WeightedTrade("BUY_STERLING_SILVER", 22,
                    TradeFactoryUtil.buyItemForEmeralds(ModItems.STERLING_SILVER_INGOT, 4, 1, 12, 30, 0.05f)));

            // master sells – allow multiple different items (keys per item)
            pool.add(new WeightedTrade("ENCH_AXE_DIAMOND", 11,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.DIAMOND_BATTLE_AXE, 18, 32, 3, 30)));
            pool.add(new WeightedTrade("ENCH_AXE_MOISSANITE", 7,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.MOISSANITE_BATTLE_AXE, 24, 38, 3, 30)));
            pool.add(new WeightedTrade("ENCH_AXE_SAPPHIRE", 10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SAPPHIRE_BATTLE_AXE, 22, 36, 3, 30)));
            pool.add(new WeightedTrade("ENCH_AXE_RUBY", 9,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.RUBY_BATTLE_AXE, 28, 42, 3, 30)));
            pool.add(new WeightedTrade("ENCH_AXE_SPINEL", 10,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.SPINEL_BATTLE_AXE, 20, 34, 3, 30)));
            pool.add(new WeightedTrade("ENCH_AXE_TOPAZ", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOPAZ_BATTLE_AXE, 20, 34, 3, 30)));
            pool.add(new WeightedTrade("ENCH_AXE_TOURMALINE", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TOURMALINE_BATTLE_AXE, 19, 33, 3, 30)));
            pool.add(new WeightedTrade("ENCH_AXE_TANZANITE", 12,
                    new TradeOffers.SellEnchantedToolFactory(ModItems.TANZANITE_BATTLE_AXE, 18, 32, 3, 30)));

            // TEMPLATE: SUPER RARE + NORMAL multiplier (geen 0.5)
            pool.add(new WeightedTrade("TEMPLATE_OBSIDIAN", 1,
                    new TradeOffers.SellItemFactory(ModItems.OBSIDIAN_UPGRADE_SMITHING_TEMPLATE, 60, 1, 1, 30, 0.05f)));

            WeightedTradeSelector.select(pool, 3, r).forEach(t -> factories.add(t.factory()));
        });
    }
}
