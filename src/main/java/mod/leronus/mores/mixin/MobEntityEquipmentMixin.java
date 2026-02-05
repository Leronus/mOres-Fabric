package mod.leronus.mores.mixin;

import mod.leronus.mores.config.CommonConfig;
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

        // initialize() below (final safety)
        if (mob instanceof PiglinEntity) return;
        if (mob instanceof ZombifiedPiglinEntity) return;
        if (mob instanceof PiglinBruteEntity) return;
        if (mob instanceof VexEntity) return;
        if (mob instanceof VindicatorEntity) return;
        if (mob instanceof WitherSkeletonEntity) return;

        // Skeleton
        if (mob instanceof SkeletonEntity skeleton) {
            ModMobEquipmentHelper.maybeUpgradeSkeletonLike(skeleton, random);
            return;
        }

        // Zombies (+ variants)
        if (mob instanceof ZombieEntity zombie && !(mob instanceof DrownedEntity)) {
            ModMobEquipmentHelper.maybeUpgradeZombieLike(zombie, random);
        }
    }

    /**
     * FINAL safety net: runs after full initialization (MobEntity declares this method, so it resolves).
     * This ensures zombified piglins keep rose_gold if anything re-asserts gold sword after initEquipment.
     *
     * Also: This is where we do the "Trial Chamber" detection and exotic gear roll.
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

        if (!CommonConfig.enableHostileGearGeneration) return;

        MobEntity mob = (MobEntity) (Object) this;

        // Your existing special cases
        if (mob instanceof ZombifiedPiglinEntity zp) {
            ModMobEquipmentHelper.maybeUpgradeZombifiedPiglin(zp, zp.getRandom());
        }
        if (mob instanceof PiglinEntity pe) {
            ModMobEquipmentHelper.maybeUpgradePiglin(pe, pe.getRandom());
        }
        if (mob instanceof PiglinBruteEntity pbe) {
            ModMobEquipmentHelper.maybeUpgradePiglinBrute(pbe, pbe.getRandom());
        }
        if (mob instanceof VindicatorEntity vex) {
            ModMobEquipmentHelper.maybeUpgradeVex(vex, vex.getRandom());
        }
        if (mob instanceof VindicatorEntity vd) {
            ModMobEquipmentHelper.maybeUpgradeVindicator(vd, vd.getRandom());
        }
        if (mob instanceof WitherSkeletonEntity wk) {
            ModMobEquipmentHelper.maybeUpgradeWitherSkeleton(wk, wk.getRandom());
        }

        // NEW: very rare exotic gear roll (more frequent in Trial Chambers)
        // Apply to typical "diamond-like" spawners (zombie/skeleton variants + vindicator + wither skeleton etc).
        if (mob instanceof ZombieEntity && !(mob instanceof DrownedEntity)
                || mob instanceof SkeletonEntity
                || mob instanceof StrayEntity
                || mob instanceof HuskEntity
                || mob instanceof WitherSkeletonEntity
                || mob instanceof VindicatorEntity) {

            ModMobEquipmentHelper.maybeApplyExoticLoadoutIfEligible(mob, mob.getRandom());
        }
    }
}
