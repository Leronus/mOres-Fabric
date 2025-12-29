package mod.leronus.mores.registry;

import mod.leronus.mores.Mores;
import mod.leronus.mores.block.screen.AlloyFurnaceScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public final class ModScreenHandlers {

    public static ScreenHandlerType<AlloyFurnaceScreenHandler> ALLOY_FURNACE;

    private ModScreenHandlers() {}

    public static void registerScreenHandlers() {
        Mores.LOGGER.info("Registering Screen Handlers for " + Mores.MOD_ID);
        ALLOY_FURNACE = Registry.register(
                Registries.SCREEN_HANDLER,
                id("alloy_furnace"),
                new ScreenHandlerType<>(AlloyFurnaceScreenHandler::new, FeatureFlags.VANILLA_FEATURES)
        );
    }

    private static Identifier id(String path) {
        return Identifier.of(Mores.MOD_ID, path);
    }
}
