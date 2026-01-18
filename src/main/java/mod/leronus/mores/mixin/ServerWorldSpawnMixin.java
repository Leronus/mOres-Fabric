package mod.leronus.mores.mixin;

import mod.leronus.mores.entity.ModEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerWorld.class)
public abstract class ServerWorldSpawnMixin {

    @Inject(
            method = "spawnEntity(Lnet/minecraft/entity/Entity;)Z",
            at = @At("RETURN"),
            require = 0
    )
    private void mores$afterSpawnEntity(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) return;
        //Debug
        //System.out.println("[MORES] ServerWorld#spawnEntity hit: " + entity.getType());

        // IMPORTANT: only react to VANILLA iron golems (prevents recursion because your golem extends IronGolemEntity)
        if (entity.getType() != EntityType.IRON_GOLEM) return;

        IronGolemEntity iron = (IronGolemEntity) entity;

        // Village golems are NOT player-created; player-built golems are.
        if (iron.isPlayerCreated()) return;

        ServerWorld world = (ServerWorld) (Object) this;

        // 75% chance to ALSO spawn hardened steel golem
        if (world.getRandom().nextFloat() >= 0.75f) return;

        Entity created = ModEntities.HARDENED_STEEL_GOLEM.create(world);
        if (!(created instanceof MobEntity steel)) return;

        // Spawn near the iron golem
        Vec3d p = iron.getPos();
        double dx = (world.getRandom().nextDouble() - 0.5) * 6.0;
        double dz = (world.getRandom().nextDouble() - 0.5) * 6.0;

        BlockPos base = BlockPos.ofFloored(p.x + dx, p.y, p.z + dz);
        BlockPos top = world.getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, base);

        steel.refreshPositionAndAngles(
                top.getX() + 0.5, top.getY(), top.getZ() + 0.5,
                world.getRandom().nextFloat() * 360.0f, 0.0f
        );

        // make sure it isn't considered player-created
        if (steel instanceof IronGolemEntity g) g.setPlayerCreated(false);

        world.spawnEntity(steel);
    }
}
