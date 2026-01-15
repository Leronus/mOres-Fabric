package mod.leronus.mores.mixin;

import mod.leronus.mores.entity.ModMobEquipmentHelper;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.*;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class MobEntityEquipmentMixin {

    /**
     * Normal equipment hook (works for most mobs).
     */
    @Inject(
            method = "initEquipment(Lnet/minecraft/util/math/random/Random;Lnet/minecraft/world/LocalDifficulty;)V",
            at = @At("TAIL")
    )
    private void mores$afterInitEquipment(Random random, LocalDifficulty difficulty, CallbackInfo ci) {
        MobEntity mob = (MobEntity) (Object) this;

        // Wither skeleton
        if (mob instanceof WitherSkeletonEntity witherSkeleton) {
            ModMobEquipmentHelper.maybeUpgradeWitherSkeleton(witherSkeleton, random, difficulty);
            return;
        }

        // Piglin
        if (mob instanceof PiglinEntity piglin) {
            ModMobEquipmentHelper.maybeUpgradePiglin(piglin, random, difficulty);
            return;
        }

        // IMPORTANT: Zombified piglins handled by ZombifiedPiglinEntityMixin + initialize() below (final safety)
        if (mob instanceof ZombifiedPiglinEntity) {
            return;
        }

        if (mob instanceof VindicatorEntity vindicator) {
            ModMobEquipmentHelper.maybeUpgradeVindicator(vindicator, random, difficulty);
            return;
        }

        if (mob instanceof VexEntity vex) {
            ModMobEquipmentHelper.maybeUpgradeVex(vex, random);
            return;
        }

        // Skeleton / Stray (Stray extends SkeletonEntity)
        if (mob instanceof SkeletonEntity skeleton) {
            ModMobEquipmentHelper.maybeUpgradeSkeletonLike(skeleton, random, difficulty);
            return;
        }

        // Zombies (+ variants)
        if (mob instanceof ZombieEntity zombie && !(mob instanceof DrownedEntity)) {
            ModMobEquipmentHelper.maybeUpgradeZombieLike(zombie, random, difficulty);
        }
    }

    /**
     * FINAL safety net: runs after full initialization (MobEntity declares this method, so it resolves).
     * This ensures zombified piglins keep rose_gold if anything re-asserts gold sword after initEquipment.
     */
    @Inject(
            method = "initialize(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/world/LocalDifficulty;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/entity/EntityData;)Lnet/minecraft/entity/EntityData;",
            at = @At("TAIL")
    )
    private void mores$afterInitialize(ServerWorldAccess world,
                                       LocalDifficulty difficulty,
                                       SpawnReason spawnReason,
                                       @Nullable EntityData entityData,
                                       CallbackInfoReturnable<EntityData> cir) {

        MobEntity mob = (MobEntity) (Object) this;

        if (mob instanceof ZombifiedPiglinEntity zp) {
            ModMobEquipmentHelper.maybeUpgradeZombifiedPiglin(zp, zp.getRandom());
        }
    }
}
