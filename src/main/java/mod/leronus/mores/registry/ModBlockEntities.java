package mod.leronus.mores.registry;

import mod.leronus.mores.Mores;
import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.block.entity.AlloyFurnaceBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ModBlockEntities {

    public static BlockEntityType<AlloyFurnaceBlockEntity> ALLOY_FURNACE_BE;

    private ModBlockEntities() {}

    public static void registerBlockEntities() {
        Mores.LOGGER.info("Registering Block Entities for " + Mores.MOD_ID);
        ALLOY_FURNACE_BE = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                id("alloy_furnace"),
                FabricBlockEntityTypeBuilder
                        .create(AlloyFurnaceBlockEntity::new, ModBlocks.ALLOY_FURNACE)
                        .build()
        );
    }

    private static Identifier id(String path) {
        return Identifier.of(Mores.MOD_ID, path);
    }
}
