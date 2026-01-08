package mod.leronus.mores.datagen;

import mod.leronus.mores.Mores;
import mod.leronus.mores.sound.ModRegistryKeyFixes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModDynamicRegistryProvider extends FabricDynamicRegistryProvider {

    public ModDynamicRegistryProvider(
            FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture
    ) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        // Generate all entries from the JUKEBOX_SONG registry in our namespace ("mores")
        entries.addAll(registries.getWrapperOrThrow(ModRegistryKeyFixes.JUKEBOX_SONG_REGISTRY));
    }

    @Override
    public String getName() {
        return Mores.MOD_ID + " Dynamic Registries";
    }
}
