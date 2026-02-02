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

public final class ModReflectEnchantmentOverrideProvider implements DataProvider {

    private final DataOutput.PathResolver enchantmentPath;

    public ModReflectEnchantmentOverrideProvider(FabricDataOutput output) {
        this.enchantmentPath = output.getResolver(DataOutput.OutputType.DATA_PACK, "enchantment");
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        Identifier id = Identifier.of("fabricshieldlib", "reflect");
        Path path = enchantmentPath.resolveJson(id);

        JsonObject root = new JsonObject();

        root.addProperty("anvil_cost", 5);

        JsonObject description = new JsonObject();
        description.addProperty("translate", "enchantment.fabricshieldlib.reflect");
        root.add("description", description);

        root.add("min_cost", cost(10));
        root.add("max_cost", cost(15));
        root.addProperty("max_level", 1);

        JsonArray slots = new JsonArray();
        slots.add("hand");
        root.add("slots", slots);

        // Enchanting table rolls: allow on BOOKS (most reliable)
        root.addProperty("primary_items", "minecraft:book");

        // Supported items: explicit list (NO TAGS — avoids codec hell)
        JsonArray supported = new JsonArray();
        supported.add("minecraft:shield");

        supported.add("mores:tin_shield");
        supported.add("mores:silver_shield");
        supported.add("mores:copper_shield");
        supported.add("mores:sterling_silver_shield");
        supported.add("mores:rose_gold_shield");
        supported.add("mores:bronze_shield");
        supported.add("mores:cobalt_shield");
        supported.add("mores:carbon_steel_shield");
        supported.add("mores:hardened_steel_shield");
        supported.add("mores:turquoise_shield");
        supported.add("mores:lapis_lazuli_shield");
        supported.add("mores:amethyst_shield");
        supported.add("mores:citrine_shield");
        supported.add("mores:onyx_shield");
        supported.add("mores:tanzanite_shield");
        supported.add("mores:tourmaline_shield");
        supported.add("mores:topaz_shield");
        supported.add("mores:spinel_shield");
        supported.add("mores:emerald_shield");
        supported.add("mores:ruby_shield");
        supported.add("mores:sapphire_shield");
        supported.add("mores:moissanite_shield");
        supported.add("mores:obsidian_shield");
        supported.add("mores:adamantium_shield");
        supported.add("mores:enderite_shield");

        root.add("supported_items", supported);

        root.addProperty("weight", 10);

        return DataProvider.writeToPath(writer, root, path);
    }

    private static JsonObject cost(int base) {
        JsonObject obj = new JsonObject();
        obj.addProperty("base", base);
        obj.addProperty("per_level_above_first", 0);
        return obj;
    }

    @Override
    public String getName() {
        return "Mores Reflect Enchantment Override (fabricshieldlib:reflect)";
    }
}
