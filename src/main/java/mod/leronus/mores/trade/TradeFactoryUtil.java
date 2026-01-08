package mod.leronus.mores.trade;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;

import java.util.Optional;

public final class TradeFactoryUtil {
    private TradeFactoryUtil() {}

    public static TradeOffers.Factory buyItemForEmeralds(
            Item buyItem, int buyCount,
            int emeraldCount,
            int maxUses,
            int villagerXp,
            float priceMultiplier
    ) {
        return (entity, random) -> new TradeOffer(
                new TradedItem(buyItem, buyCount),
                Optional.empty(), // <-- 2nd cost is Optional in 1.21.1
                new ItemStack(Items.EMERALD, emeraldCount),
                maxUses,
                villagerXp,
                priceMultiplier
        );
    }
}
