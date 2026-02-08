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
        int level = self.getVillagerData().getLevel();

        if (prof == VillagerProfession.CLERIC) {
            // Cleric keeps vanilla 2 trades at level 1-2, then gets 3 later.
            return level <= 2 ? 2 : 3;
        }

        if (prof == VillagerProfession.ARMORER
                || prof == VillagerProfession.TOOLSMITH
                || prof == VillagerProfession.WEAPONSMITH) {
            return 3;
        }

        return original;
    }
}
