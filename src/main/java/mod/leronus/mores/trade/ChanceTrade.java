package mod.leronus.mores.trade;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;

import org.jetbrains.annotations.Nullable;

public class ChanceTrade implements TradeOffers.Factory {

    private final TradeOffers.Factory delegate;
    private final float chance;

    public ChanceTrade(float chance, TradeOffers.Factory delegate) {
        this.chance = chance;
        this.delegate = delegate;
    }

    @Nullable
    @Override
    public TradeOffer create(Entity entity, Random random) {
        if (random.nextFloat() <= chance) {
            return delegate.create(entity, random);
        }
        return null;
    }
}
