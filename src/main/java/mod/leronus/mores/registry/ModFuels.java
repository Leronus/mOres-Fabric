package mod.leronus.mores.registry;

import mod.leronus.mores.Mores;
import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

/**
 * Central place to register furnace fuels.
 * Call {@link #register()} from your mod initializer.
 */
public final class ModFuels {
    private ModFuels() {}

    // Vanilla wooden tools burn time: 200 ticks (10 seconds)
    private static final int WOODEN_TOOL_FUEL_TICKS = 200;
    private static final int ANTHRACITE_FUEL_TICKS = 4000;

    public static void register() {
        // If you have direct item fields (recommended)
        FuelRegistry.INSTANCE.add(ModItems.WOODEN_BATTLE_AXE, WOODEN_TOOL_FUEL_TICKS);
        FuelRegistry.INSTANCE.add(ModItems.WOODEN_BATTLE_MACE, WOODEN_TOOL_FUEL_TICKS);
        FuelRegistry.INSTANCE.add(ModItems.WOODEN_DAGGER, WOODEN_TOOL_FUEL_TICKS);
        FuelRegistry.INSTANCE.add(ModItems.ANTHRACITE, ANTHRACITE_FUEL_TICKS);
    }

    /**
     * Safe registry lookup by id. Uses mores namespace.
     * Useful if an item is optional / gated by config and may not be registered.
     */
    @SuppressWarnings("SameParameterValue")
    private static void addFuelIfPresent(String path, int burnTicks) {
        Identifier id = Identifier.of(Mores.MOD_ID, path);
        if (!Registries.ITEM.containsId(id)) return;
        FuelRegistry.INSTANCE.add(Registries.ITEM.get(id), burnTicks);
    }
}
