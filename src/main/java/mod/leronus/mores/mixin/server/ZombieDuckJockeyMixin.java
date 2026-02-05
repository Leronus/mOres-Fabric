package mod.leronus.mores.mixin.server;

import com.mojang.logging.LogUtils;
import mod.leronus.mores.entity.ModDuckEntity;
import mod.leronus.mores.entity.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ZombieEntity.class)
public abstract class ZombieDuckJockeyMixin {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final float DUCK_MOUNT_CHANCE = 0.25f; // set lower later

    @Inject(
            method = "initialize(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/world/LocalDifficulty;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/entity/EntityData;)Lnet/minecraft/entity/EntityData;",
            at = @At("RETURN")
    )
    private void mores$afterZombieInit(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason reason,
                                       @Nullable EntityData entityData,
                                       CallbackInfoReturnable<EntityData> cir) {

        if (!(world instanceof ServerWorld serverWorld)) return;

        ZombieEntity zombie = (ZombieEntity)(Object)this;
//        zombie.setBaby(true);

        // NOW this should reflect the final zombie state
//        LOGGER.info("[MORES] Zombie init done: baby={}, hasVehicle={}", zombie.isBaby(), zombie.hasVehicle());

        if (!zombie.isBaby()) return;
        if (!zombie.hasVehicle()) return;

        Entity vehicle = zombie.getVehicle();
        if (!(vehicle instanceof ChickenEntity chicken)) return;

        if (serverWorld.getRandom().nextFloat() >= DUCK_MOUNT_CHANCE) return;

        ModDuckEntity duck = ModEntities.DUCK.create(serverWorld);
        if (duck == null) return;

        duck.refreshPositionAndAngles(chicken.getX(), chicken.getY(), chicken.getZ(), chicken.getYaw(), chicken.getPitch());

        if (!serverWorld.spawnEntity(duck)) return;

        zombie.stopRiding();
        zombie.startRiding(duck, true);

        duck.setHasJockey(true);
        chicken.discard();

//        LOGGER.info("[MORES] Swapped chicken jockey -> duck jockey at {}", zombie.getBlockPos());
    }
}
