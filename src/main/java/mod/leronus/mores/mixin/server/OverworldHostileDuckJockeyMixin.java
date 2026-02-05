package mod.leronus.mores.mixin.server;

import mod.leronus.mores.entity.ModDuckEntity;
import mod.leronus.mores.entity.ModEntities;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class OverworldHostileDuckJockeyMixin {

    // Tune this
    private static final float DUCK_JOCKEY_CHANCE = 0.03f; // 3%

    // Which spawn reasons count
    private static final boolean ALLOW_NATURAL = true;
    private static final boolean ALLOW_CHUNK_GENERATION = true;
    private static final boolean ALLOW_SPAWNER = true;

    // Prevent giant mobs riding ducks (recommended)
    private static final boolean SIZE_LIMIT = true;
    private static final float MAX_WIDTH = 1.4f;
    private static final float MAX_HEIGHT = 2.2f;

    @Inject(
            method = "initialize(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/world/LocalDifficulty;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/entity/EntityData;)Lnet/minecraft/entity/EntityData;",
            at = @At("RETURN")
    )
    private void mores$overworldHostileDuckJockey(ServerWorldAccess world, LocalDifficulty difficulty,
                                                  SpawnReason reason, @Nullable EntityData entityData,
                                                  CallbackInfoReturnable<EntityData> cir) {

        if (!(world instanceof ServerWorld serverWorld)) return;

        // Overworld only
        if (serverWorld.getRegistryKey() != World.OVERWORLD) return;

        MobEntity mob = (MobEntity) (Object) this;

        // Must be an allowed rider
        if (!canBeDuckJockeyRider(mob)) return;

        // Only allow certain spawn reasons
        if (!isAllowedSpawnReason(reason)) return;

        // Don’t mess with existing riders/mounts
        if (mob.hasVehicle() || mob.hasPassengers()) return;

        // Don’t recurse: don’t make ducks ride ducks / duck entities be riders
        if (mob instanceof ModDuckEntity) return;

        // Skip bosses
        EntityType<?> t = mob.getType();
        if (t == EntityType.ENDER_DRAGON || t == EntityType.WITHER || t == EntityType.WARDEN) return;

        // Size sanity
        if (SIZE_LIMIT) {
            var dims = mob.getDimensions(mob.getPose());
            if (dims.width() > MAX_WIDTH || dims.height() > MAX_HEIGHT) return;
        }

        // Chance gate
        if (serverWorld.getRandom().nextFloat() >= DUCK_JOCKEY_CHANCE) return;

        // Grounded + valid placement
        BlockPos ground = serverWorld.getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, mob.getBlockPos());
        if (Math.abs(mob.getY() - ground.getY()) > 2.5) return;

        // Spawn duck
        ModDuckEntity duck = ModEntities.DUCK.create(serverWorld);
        if (duck == null) return;

        duck.refreshPositionAndAngles(
                ground.getX() + 0.5, ground.getY(), ground.getZ() + 0.5,
                mob.getYaw(), mob.getPitch()
        );

        // Optional: ensure space & spawn restrictions
        if (!serverWorld.isSpaceEmpty(duck)) return;
        if (!SpawnRestriction.canSpawn(ModEntities.DUCK, serverWorld, SpawnReason.NATURAL, ground, serverWorld.getRandom())) return;

        if (!serverWorld.spawnEntity(duck)) return;

        // Put hostile on the duck
        mob.startRiding(duck, true);
        duck.setHasJockey(true);

    }

    private static boolean canBeDuckJockeyRider(MobEntity mob) {
        // Must be a monster (helps prevent “weird places” + excludes lots of non-hostiles)
        if (mob.getType().getSpawnGroup() != SpawnGroup.MONSTER) return false;

        // Must be hostile (your existing rule)
        if (!(mob instanceof HostileEntity)) return false;

        // Explicitly exclude “no-arm / weird-body” hostiles (even if they’re hostile monsters)
        if (mob instanceof CreeperEntity) return false;
        if (mob instanceof SpiderEntity) return false;
        if (mob instanceof EndermiteEntity) return false;
        if (mob instanceof SilverfishEntity) return false;
        if (mob instanceof BlazeEntity) return false;
        if (mob instanceof GuardianEntity) return false;
        if (mob instanceof VexEntity) return false;

        // Allow “armed/humanoid-ish” hostiles (these are the ones players expect as riders)
        // pillager/vindicator/evoker/illusioner etc.
        return mob instanceof ZombieEntity || mob instanceof AbstractSkeletonEntity || mob instanceof AbstractPiglinEntity || mob instanceof RaiderEntity || mob instanceof EndermanEntity;
    }

    private static boolean isAllowedSpawnReason(SpawnReason reason) {
        return switch (reason) {
            case NATURAL -> ALLOW_NATURAL;
            case CHUNK_GENERATION -> ALLOW_CHUNK_GENERATION;
            case SPAWNER -> ALLOW_SPAWNER;
            default -> false;
        };
    }
}
