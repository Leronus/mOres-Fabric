package mod.leronus.mores.trade;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;
import org.jetbrains.annotations.Nullable;

public final class TradeFactoryUtil {

    private TradeFactoryUtil() {}

    /**
     * Villager buys {@code buyCount} of {@code item} and pays {@code emeraldCount} emeralds.
     *
     * IMPORTANT (1.21+): TradeOffer expects TradedItem for buy inputs, not ItemStack.
     */
    public static TradeOffers.Factory buyItemForEmeralds(
            Item item,
            int buyCount,
            int emeraldCount,
            int maxUses,
            int experience,
            float priceMultiplier
    ) {
        return new TradeOffers.Factory() {
            @Nullable
            @Override
            public TradeOffer create(Entity entity, Random random) {
                return new TradeOffer(
                        new TradedItem(item, buyCount),                 // villager buys this
                        new ItemStack(Items.EMERALD, emeraldCount),     // villager sells emeralds
                        maxUses,
                        experience,
                        priceMultiplier
                );
            }
        };
    }

    public static TradeOffers.Factory buyItemForEmeralds(
            Item item,
            int buyCount,
            int emeraldCount,
            int maxUses,
            int experience
    ) {
        return buyItemForEmeralds(item, buyCount, emeraldCount, maxUses, experience, 0.05f);
    }
}
