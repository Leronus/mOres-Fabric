package mod.leronus.mores;

import mod.leronus.mores.client.screen.AlloyFurnaceScreen;
import mod.leronus.mores.registry.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class MoresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.ALLOY_FURNACE, AlloyFurnaceScreen::new);
    }
}