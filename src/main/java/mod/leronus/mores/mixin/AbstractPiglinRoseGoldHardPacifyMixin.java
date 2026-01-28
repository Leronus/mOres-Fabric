package mod.leronus.mores.mixin;

import mod.leronus.mores.handlers.ModArmorBonusHandler;
import mod.leronus.mores.item.ModArmorMaterials;
import net.minecraft.entity.CrossbowUser;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(AbstractPiglinEntity.class)
public abstract class AbstractPiglinRoseGoldHardPacifyMixin {

    private static final double ROSE_GOLD_CALM_RADIUS = 48.0;

    /**
     * Run at TAIL to override whatever the AI decided this tick.
     * This prevents the aggro/attack-pose flicker.
     */
    @Inject(method = "mobTick", at = @At("TAIL"))
    private void mores$hardPacify(CallbackInfo ci) {
        AbstractPiglinEntity piglin = (AbstractPiglinEntity) (Object) this;
        if (piglin.getWorld().isClient()) return;

        PlayerEntity player = piglin.getWorld().getClosestPlayer(piglin, ROSE_GOLD_CALM_RADIUS);
        if (player == null) return;

        // Only apply if the nearby player wears full Rose Gold and is NOT provoked
        if (!ModArmorBonusHandler.isWearingFullSet(player, ModArmorMaterials.ROSE_GOLD.value())) return;
        if (ModArmorBonusHandler.isPlayerProvokedPiglins(player)) return;

        // Only calm if THIS piglin is focused on THAT player (prevents interfering with other fights)
        boolean focusedOnPlayer = false;

        if (piglin.getTarget() == player) focusedOnPlayer = true;
        if (piglin.getAttacker() == player) focusedOnPlayer = true;

        if (!focusedOnPlayer && piglin instanceof Angerable anger) {
            UUID angryAt = anger.getAngryAt();
            if (angryAt != null && angryAt.equals(player.getUuid())) focusedOnPlayer = true;
        }

        if (!focusedOnPlayer) return;

        // Clear target/attacker
        piglin.setTarget(null);
        piglin.setAttacker(null);

        // Kill attack pose (fixes the arms-up flicker)
        piglin.setAttacking(false);

        // Stop item-use state (crossbow charge / etc.)
        piglin.stopUsingItem();
        piglin.clearActiveItem();

        if ((Object) piglin instanceof CrossbowUser cu) {
            cu.setCharging(false);
        }

        // Clear brain anger/combat memories
        var brain = piglin.getBrain();
        brain.forget(MemoryModuleType.ATTACK_TARGET);
        brain.forget(MemoryModuleType.ANGRY_AT);
        brain.forget(MemoryModuleType.UNIVERSAL_ANGER);
        brain.forget(MemoryModuleType.HURT_BY);
        brain.forget(MemoryModuleType.HURT_BY_ENTITY);

        // Clear anger state
        if (piglin instanceof Angerable anger) {
            anger.setAngerTime(0);
            anger.setAngryAt(null);
        }
    }
}
