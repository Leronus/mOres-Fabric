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

    public static void register() {

        /* ==================== NOVICE (3 trades) ==================== */
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.WEAPONSMITH, 1, factories -> {
                    factories.clear();

                    Random random = Random.create();
                    List<WeightedTrade> pool = new ArrayList<>();

                    // MODIFIED VANILLA
                    pool.add(new WeightedTrade(40,
                            new TradeOffers.BuyItemFactory(
                                    Items.COAL, 15, 1, 16, 2)));

                    pool.add(new WeightedTrade(30,
                            new TradeOffers.BuyItemFactory(
                                    ModItems.TIN_INGOT, 26, 1, 16, 2)));

                    // Iron weapons
                    pool.add(new WeightedTrade(15,
                            new TradeOffers.SellItemFactory(
                                    Items.IRON_SWORD, 3, 1, 12, 1, 0.2f)));

                    pool.add(new WeightedTrade(20,
                            new TradeOffers.SellItemFactory(
                                    ModItems.IRON_DAGGER, 2, 1, 12, 1, 0.2f)));

                    // Cobalt weapons
                    pool.add(new WeightedTrade(20,
                            new TradeOffers.SellItemFactory(
                                    ModItems.COBALT_SWORD, 3, 1, 12, 1, 0.2f)));

                    pool.add(new WeightedTrade(20,
                            new TradeOffers.SellItemFactory(
                                    ModItems.COBALT_DAGGER, 2, 1, 12, 1, 0.2f)));

                    WeightedTradeSelector.select(pool, 3, random)
                            .forEach(t -> factories.add(t.factory()));
                });

        /* ==================== APPRENTICE (3 trades) ==================== */
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.WEAPONSMITH, 2, factories -> {
                    factories.clear();

                    Random random = Random.create();
                    List<WeightedTrade> pool = List.of(
                            // MODIFIED VANILLA
                            new WeightedTrade(60,
                                    new TradeOffers.BuyItemFactory(
                                            Items.IRON_INGOT, 4, 1, 12, 10)),
                            new WeightedTrade(60,
                                    new TradeOffers.SellItemFactory(
                                            Items.BELL, 36, 1, 12, 5, 0.2f)),

                            new WeightedTrade(60,
                                    new TradeOffers.BuyItemFactory(
                                            ModItems.SILVER_INGOT, 7, 1, 12, 10)),
                            new WeightedTrade(60,
                                    new TradeOffers.BuyItemFactory(
                                            Items.COPPER_INGOT, 10, 1, 12, 10)),
                            new WeightedTrade(60,
                                    new TradeOffers.BuyItemFactory(
                                            ModItems.COBALT_INGOT, 4, 1, 12, 10))
                    );

                    WeightedTradeSelector.select(new ArrayList<>(pool), 3, random)
                            .forEach(t -> factories.add(t.factory()));
                });

        /* ==================== JOURNEYMAN (3 trades) ==================== */
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.WEAPONSMITH, 3, factories -> {
                    factories.clear();

                    Random random = Random.create();
                    List<WeightedTrade> pool = new ArrayList<>();

                    // MODIFIED VANILLA
                    pool.add(new WeightedTrade(25,
                            new TradeOffers.BuyItemFactory(
                                    Items.FLINT, 24, 1, 12, 20)));

                    pool.add(new WeightedTrade(25,
                            new TradeOffers.BuyItemFactory(
                                    ModItems.STERLING_SILVER_INGOT, 2, 1, 12, 20)));

                    pool.add(new WeightedTrade(25,
                            new TradeOffers.BuyItemFactory(
                                    ModItems.MOISSANITE_GEM, 1, 1, 12, 20)));

                    // Daggers
                    pool.add(new WeightedTrade(35,
                            new TradeOffers.SellItemFactory(
                                    ModItems.TANZANITE_DAGGER, 2, 1, 3, 10, 0.2f)));

                    WeightedTradeSelector.select(pool, 3, random)
                            .forEach(t -> factories.add(t.factory()));
                });

        /* ==================== MASTER (3 trades) ==================== */
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.WEAPONSMITH, 5, factories -> {
                    factories.clear();

                    Random random = Random.create();
                    List<WeightedTrade> pool = new ArrayList<>();

                    pool.add(new WeightedTrade(55,
                            new TradeOffers.SellEnchantedToolFactory(
                                    ModItems.TANZANITE_BATTLE_AXE,
                                    18, 32, 3, 30)));

                    pool.add(new WeightedTrade(10,
                            new TradeOffers.SellItemFactory(
                                    ModItems.OBSIDIAN_UPGRADE_SMITHING_TEMPLATE,
                                    60, 1, 1, 30, 0.5f)));

                    WeightedTradeSelector.select(pool, 3, random)
                            .forEach(t -> factories.add(t.factory()));
                });
    }
}
