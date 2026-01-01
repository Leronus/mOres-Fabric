package mod.leronus.mores.client.config;

import eu.midnightdust.lib.config.MidnightConfig;
import mod.leronus.mores.Mores;
import net.minecraft.client.gui.screen.Screen;

public final class ConfigScreen {
    private ConfigScreen() {}

    public static Screen create(Screen parent) {
        return MidnightConfig.getScreen(parent, Mores.MOD_ID);
    }
}
