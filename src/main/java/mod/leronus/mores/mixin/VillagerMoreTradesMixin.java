package mod.leronus.mores.mixin;

import net.minecraft.entity.passive.VillagerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(VillagerEntity.class)
public abstract class VillagerMoreTradesMixin {

    @ModifyConstant(
            method = "fillRecipes",
            constant = @Constant(intValue = 2)
    )
    private int mores$moreTradesPerLevel(int original) {
        // Vanilla uses 2 "new trades" per level in Java Edition.
        // Change to 3 (or 4, etc.)
        return 3;
    }
}
