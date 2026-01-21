package mod.leronus.mores.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(TradeOffers.class)
public interface TradeOffersAccessor {

    // NOTE: field name must match your mappings. This is the common one in 1.21.x yarn.
    @Accessor("PROFESSION_TO_LEVELED_TRADE")
    static Map<VillagerProfession, Int2ObjectMap<TradeOffers.Factory[]>> mores$getProfessionToLeveledTrade() {
        throw new AssertionError();
    }
}