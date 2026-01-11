package mod.leronus.mores.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.world.World;

public class ModGolemEntity extends IronGolemEntity {
    public ModGolemEntity(EntityType<? extends IronGolemEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createHardenedSteelGolemAttributes() {
        double baseHealth = 100.0;
        double baseAttack = 15.0;

        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, baseHealth * 2.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, baseAttack * 2.0)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.0D);
    }
}
