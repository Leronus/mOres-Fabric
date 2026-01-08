package mod.leronus.mores.sound;

import mod.leronus.mores.Mores;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

/**
 * Holds RegistryKeys for your songs.
 *
 * NOTE:
 * - Do NOT register JukeboxSong in code.
 * - The song entries come from data: data/mores/jukebox_song/*.json
 * - These keys are used by your music disc Items via .jukeboxPlayable(...)
 */
public final class ModJukeboxSongs {

    // RegistryKey for a song entry uses the song's id directly:
    // "mores:cipher" -> data/mores/jukebox_song/cipher.json
    public static final RegistryKey<JukeboxSong> CIPHER =
            RegistryKey.of(ModRegistryKeyFixes.JUKEBOX_SONG_REGISTRY, Identifier.of(Mores.MOD_ID, "cipher"));

    public static final RegistryKey<JukeboxSong> SWEET_CAROLINE =
            RegistryKey.of(ModRegistryKeyFixes.JUKEBOX_SONG_REGISTRY, Identifier.of(Mores.MOD_ID, "sweet_caroline"));

    private ModJukeboxSongs() {}
}
