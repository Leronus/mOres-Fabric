package mod.leronus.mores.util;

import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.Optional;

public final class SpearSounds {
    private SpearSounds() {}

    public static Optional<RegistryEntry<SoundEvent>> vanillaSound(String vanillaId) {
        // getEntry() returns Optional<RegistryEntry.Reference<SoundEvent>>
        // We widen it to Optional<RegistryEntry<SoundEvent>> inside the Optional
        return Registries.SOUND_EVENT
                .getEntry(Identifier.ofVanilla(vanillaId))
                .map(e -> (RegistryEntry<SoundEvent>) e);
    }
}
