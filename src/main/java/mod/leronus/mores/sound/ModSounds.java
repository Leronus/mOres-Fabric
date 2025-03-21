package mod.leronus.mores.sound;

import mod.leronus.mores.Mores;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent SWEET_CAROLINE_BOOTLEG = registerSoundEvent("sweet_caroline_bootleg");
    public static final SoundEvent CIPHER = registerSoundEvent( "cipher");
    public static final SoundEvent WORTEL9 = registerSoundEvent( "wortel9");
    public static final SoundEvent WATWAAROM = registerSoundEvent( "watwaarom");

    public static final RegistryKey<JukeboxSong> SWEET_CAROLINE_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Mores.MOD_ID, "sweet_caroline_bootleg"));

    public static final RegistryKey<JukeboxSong> CIPHER_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Mores.MOD_ID, "cipher"));

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Mores.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Mores.LOGGER.info("Registering Sounds for " + Mores.MOD_ID);
    }
}
