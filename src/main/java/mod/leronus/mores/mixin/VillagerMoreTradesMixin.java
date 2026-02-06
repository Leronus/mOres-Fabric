package mod.leronus.mores.mixin;

import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.village.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(VillagerEntity.class)
public abstract class VillagerMoreTradesMixin {

    @ModifyConstant(method = "fillRecipes", constant = @Constant(intValue = 2))
    private int mores$moreTradesPerLevel(int original) {
        VillagerEntity self = (VillagerEntity) (Object) this;
        VillagerProfession prof = self.getVillagerData().getProfession();

        if (prof == VillagerProfession.ARMORER
                || prof == VillagerProfession.TOOLSMITH
                || prof == VillagerProfession.WEAPONSMITH
                || prof == VillagerProfession.CLERIC) {
            return 3; // your boosted value
        }

        return original; // everyone else (including beekeeper) stays vanilla
    }
}
