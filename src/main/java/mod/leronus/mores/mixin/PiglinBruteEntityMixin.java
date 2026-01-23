package mod.leronus.mores.mixin;

import mod.leronus.mores.entity.ModMobEquipmentHelper;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PiglinBruteEntity.class)
public abstract class PiglinBruteEntityMixin {
    @Inject(
            method = "initEquipment(Lnet/minecraft/util/math/random/Random;Lnet/minecraft/world/LocalDifficulty;)V",
            at = @At("TAIL"),
            require = 0
    )
    private void mores$afterInitEquipment(Random random, LocalDifficulty difficulty, CallbackInfo ci) {
        ModMobEquipmentHelper.maybeUpgradePiglinBrute((PiglinBruteEntity)(Object)this, random);
    }
}
