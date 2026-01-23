package mod.leronus.mores.entity.projectile;

import mod.leronus.mores.entity.ModDuckEntity;
import mod.leronus.mores.entity.ModEntities;
import mod.leronus.mores.item.ModItems;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ModEggEntity extends ThrownItemEntity {
    private static final EntityDimensions EMPTY_DIMENSIONS = EntityDimensions.fixed(0.0F, 0.0F);
    public ModEggEntity(World world, LivingEntity owner) {
        super(EntityType.EGG, owner, world);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        if (!this.getWorld().isClient) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for(int j = 0; j < i; ++j) {
                    ModDuckEntity duckEntity = (ModDuckEntity) ModEntities.DUCK.create(this.getWorld());
                    if (duckEntity != null) {
                        duckEntity.setBreedingAge(-24000);
                        duckEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
                        if (!duckEntity.recalculateDimensions(EMPTY_DIMENSIONS)) {
                            break;
                        }

                        this.getWorld().spawnEntity(duckEntity);
                    }
                }
            }

            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.DUCK_EGG;
    }
}
