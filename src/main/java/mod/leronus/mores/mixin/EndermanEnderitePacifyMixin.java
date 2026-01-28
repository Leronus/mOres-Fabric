package mod.leronus.mores.mixin;

import mod.leronus.mores.handlers.ModArmorBonusHandler;
import mod.leronus.mores.item.ModArmorMaterials;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public abstract class EndermanEnderitePacifyMixin {
    /**
     * Pumpkin-like behavior: when wearing full Enderite, the enderman will not
     * treat the player as "staring", so it won't become angry from looking.
     *
     * The method name is stable in Yarn but require=0 avoids hard crashes if it changes.
     */
    @Inject(method = "isPlayerStaring(Lnet/minecraft/entity/player/PlayerEntity;)Z",
            at = @At("HEAD"), cancellable = true, require = 0)
    private void mores$enderiteActsLikePumpkin(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        if (ModArmorBonusHandler.isWearingFullSet(player, ModArmorMaterials.ENDERITE.value())) {
            cir.setReturnValue(false);
        }
    }
}
