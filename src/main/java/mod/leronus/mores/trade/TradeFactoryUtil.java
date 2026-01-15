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

    /** Villager buys item(s) and pays emerald(s). Correct for 1.21+ (TradedItem input). */
    public static TradeOffers.Factory buyItemForEmeralds(
            Item item,
            int buyCount,
            int emeraldCount,
            int maxUses,
            int villagerXp,
            float priceMultiplier
    ) {
        return new TradeOffers.Factory() {
            @Nullable
            @Override
            public TradeOffer create(Entity entity, Random random) {
                return new TradeOffer(
                        new TradedItem(item, buyCount),
                        new ItemStack(Items.EMERALD, emeraldCount),
                        maxUses,
                        villagerXp,
                        priceMultiplier
                );
            }
        };
    }
}
