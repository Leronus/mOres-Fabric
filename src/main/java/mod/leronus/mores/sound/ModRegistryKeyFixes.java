package mod.leronus.mores.sound;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

/**
 * Workaround: define the JUKEBOX_SONG registry key manually (minecraft:jukebox_song).
 * This avoids relying on RegistryKeys.JUKEBOX_SONG / Registries.JUKEBOX_SONG.
 */
public final class ModRegistryKeyFixes {
    public static final RegistryKey<Registry<JukeboxSong>> JUKEBOX_SONG_REGISTRY =
            RegistryKey.ofRegistry(Identifier.of("minecraft", "jukebox_song"));

    private ModRegistryKeyFixes() {}
}
