package mod.leronus.mores.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public final class ModReflectEnchantmentTagProvider implements DataProvider {

    private final DataOutput.PathResolver tagResolver;

    public ModReflectEnchantmentTagProvider(FabricDataOutput output) {
        // writes into: data/minecraft/tags/enchantment/<name>.json
        this.tagResolver = output.getResolver(DataOutput.OutputType.DATA_PACK, "tags/enchantment");
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        CompletableFuture<?> a = writeTag(writer, "in_enchanting_table");
        CompletableFuture<?> b = writeTag(writer, "on_random_loot");
        CompletableFuture<?> c = writeTag(writer, "tradeable"); // optional, but harmless to include

        return CompletableFuture.allOf(a, b, c);
    }

    private CompletableFuture<?> writeTag(DataWriter writer, String tagName) {
        Identifier id = Identifier.of("minecraft", tagName);
        Path path = tagResolver.resolveJson(id);

        JsonObject root = new JsonObject();
        root.addProperty("replace", false);

        JsonArray values = new JsonArray();
        values.add("fabricshieldlib:reflect");
        root.add("values", values);

        return DataProvider.writeToPath(writer, root, path);
    }

    @Override
    public String getName() {
        return "Mores Enchantment Visibility Tags";
    }
}
