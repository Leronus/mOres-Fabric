package mod.leronus.mores.mixin;

import mod.leronus.mores.handlers.ModArmorBonusHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.DamageTypeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class ObsidianExplosionImmunityMixin {

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void mores$obsidianExplosionImmunity(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (!source.isIn(DamageTypeTags.IS_EXPLOSION)) return;

        LivingEntity self = (LivingEntity) (Object) this;
        if (!(self instanceof PlayerEntity player)) return;

        if (ModArmorBonusHandler.isWearingFullObsidian(player)) {
            cir.setReturnValue(false); // cancel damage => 0 explosion damage
        }
    }
}
