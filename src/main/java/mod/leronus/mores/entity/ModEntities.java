package mod.leronus.mores.entity;

import mod.leronus.mores.Mores;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ModGolemEntity> HARDENED_STEEL_GOLEM = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Mores.MOD_ID, "hardened_steel_golem"),
            EntityType.Builder.<ModGolemEntity>create(ModGolemEntity::new, SpawnGroup.MISC)
                    .dimensions(1.4F, 2.7F)
                    .maxTrackingRange(10)
                    .trackingTickInterval(3)
                    .build()
    );

    public static void init() {}
}