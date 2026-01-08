package mod.leronus.mores.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.passive.WolfEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WolfEntity.class)
public abstract class WolfArmorSyncMixin {

    @Inject(method = "hasArmor()Z", at = @At("HEAD"), cancellable = true)
    private void mores$hasArmorFromBodySlot(CallbackInfoReturnable<Boolean> cir) {
        WolfEntity wolf = (WolfEntity)(Object)this;
        // treat BODY slot as "wolf has armor"
        cir.setReturnValue(!wolf.getEquippedStack(EquipmentSlot.BODY).isEmpty());
    }
}
