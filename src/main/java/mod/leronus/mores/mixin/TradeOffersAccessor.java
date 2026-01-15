package mod.leronus.mores.mixin;

import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

/**
 * Accessor to vanilla trade table so we can REPLACE profession trades (no duplicates).
 *
 * Yarn name is commonly PROFESSION_TO_LEVELED_TRADE in modern versions.
 * If your mappings differ, the compiler will tell you the correct field name.
 */
@Mixin(TradeOffers.class)
public interface TradeOffersAccessor {

    @Accessor("PROFESSION_TO_LEVELED_TRADE")
    static Map<VillagerProfession, TradeOffers.Factory[][]> mores$getProfessionToLeveledTrade() {
        throw new AssertionError();
    }
}
