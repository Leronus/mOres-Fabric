package mod.leronus.mores.datagen;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

/**
 * Generates:
 * - data/mores/jukebox_song/cipher.json
 * - data/mores/jukebox_song/sweet_caroline.json
 *
 * This avoids registry issues (no RegistryKeys.JUKEBOX_SONG, no Registries.JUKEBOX_SONG).
 */
public class ModJukeboxSongProvider implements DataProvider {

    private final FabricDataOutput output;

    public ModJukeboxSongProvider(FabricDataOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        // This resolver writes to: data/<namespace>/<path>
        DataOutput.PathResolver resolver =
                output.getResolver(DataOutput.OutputType.DATA_PACK, "jukebox_song");

        return CompletableFuture.allOf(
                writeSong(writer, resolver,
                        "cipher",
                        "mores:cipher",
                        "item.mores.cipher_music_disc.desc",
                        3820,
                        5
                ),
                writeSong(writer, resolver,
                        "sweet_caroline",
                        "mores:sweet_caroline_bootleg",
                        "item.mores.sweet_caroline_music_disc.desc",
                        4040,
                        4
                )
        );
    }

    private CompletableFuture<?> writeSong(
            DataWriter writer,
            DataOutput.PathResolver resolver,
            String fileName,
            String soundEventId,
            String descKey,
            int lengthSeconds,
            int comparatorOutput
    ) {
        JsonObject root = new JsonObject();
        root.addProperty("sound_event", soundEventId);

        JsonObject desc = new JsonObject();
        desc.addProperty("translate", descKey);
        root.add("description", desc);

        root.addProperty("length_in_seconds", lengthSeconds);
        root.addProperty("comparator_output", comparatorOutput);

        Path path = resolver.resolveJson(Identifier.of("mores", fileName));
        return DataProvider.writeToPath(writer, root, path);
    }


    @Override
    public String getName() {
        return "Jukebox Songs";
    }
}
