package mod.leronus.mores.sound;

import mod.leronus.mores.Mores;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent SWEET_CAROLINE_BOOTLEG = registerSoundEvent("sweet_caroline_bootleg");
    public static final SoundEvent CIPHER = registerSoundEvent( "cipher");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Mores.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Mores.LOGGER.info("Registering Sounds for " + Mores.MOD_ID);
    }
}
