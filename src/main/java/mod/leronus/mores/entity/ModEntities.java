package mod.leronus.mores.entity;

import mod.leronus.mores.Mores;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class ModEntities {
    public static EntityType<ModGolemEntity> HARDENED_STEEL_GOLEM;
    public static EntityType<ModDuckEntity> DUCK;

    public static void registerEntities() {
        HARDENED_STEEL_GOLEM = Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of(Mores.MOD_ID, "hardened_steel_golem"),
                EntityType.Builder.<ModGolemEntity>create(ModGolemEntity::new, SpawnGroup.MISC)
                        .dimensions(1.4F, 2.7F)
                        .maxTrackingRange(10)
                        .trackingTickInterval(3)
                        .build()
        );
        DUCK = Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of(Mores.MOD_ID, "duck"),
                EntityType.Builder.<ModDuckEntity>create(ModDuckEntity::new, SpawnGroup.CREATURE)
                        .dimensions(0.4F, 0.7F)
                        .eyeHeight(0.644F)
                        .passengerAttachments(new Vec3d((double)0.0F, 0.7, -0.1))
                        .maxTrackingRange(10)
                        .build());
    }
}