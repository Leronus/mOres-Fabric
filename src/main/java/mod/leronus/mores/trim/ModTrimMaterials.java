package mod.leronus.mores.trim;

import mod.leronus.mores.Mores;
import mod.leronus.mores.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public final class ModTrimMaterials {
    private ModTrimMaterials() {}

    public static final RegistryKey<ArmorTrimMaterial> TIN = key("tin");
    public static final RegistryKey<ArmorTrimMaterial> SILVER = key("silver");
    public static final RegistryKey<ArmorTrimMaterial> STERLING_SILVER = key("sterling_silver");
    public static final RegistryKey<ArmorTrimMaterial> ROSE_GOLD = key("rose_gold");
    public static final RegistryKey<ArmorTrimMaterial> BRONZE = key("bronze");
    public static final RegistryKey<ArmorTrimMaterial> COBALT = key("cobalt");
    public static final RegistryKey<ArmorTrimMaterial> CARBON_STEEL = key("carbon_steel");
    public static final RegistryKey<ArmorTrimMaterial> HARDENED_STEEL = key("hardened_steel");

    public static final RegistryKey<ArmorTrimMaterial> CITRINE = key("citrine");
    public static final RegistryKey<ArmorTrimMaterial> ONYX = key("onyx");
    public static final RegistryKey<ArmorTrimMaterial> TURQUOISE = key("turquoise");
    public static final RegistryKey<ArmorTrimMaterial> TOPAZ = key("topaz");
    public static final RegistryKey<ArmorTrimMaterial> TOURMALINE = key("tourmaline");
    public static final RegistryKey<ArmorTrimMaterial> SPINEL = key("spinel");
    public static final RegistryKey<ArmorTrimMaterial> RUBY = key("ruby");
    public static final RegistryKey<ArmorTrimMaterial> SAPPHIRE = key("sapphire");
    public static final RegistryKey<ArmorTrimMaterial> MOISSANITE = key("moissanite");

    public static final RegistryKey<ArmorTrimMaterial> OBSIDIAN = key("obsidian");
    public static final RegistryKey<ArmorTrimMaterial> GRAPHENE = key("graphene");
    public static final RegistryKey<ArmorTrimMaterial> ADAMANTIUM = key("adamantium");
    public static final RegistryKey<ArmorTrimMaterial> ENDERITE = key("enderite");

    public static void bootstrap(Registerable<ArmorTrimMaterial> registry) {
        // If you want your trim to show up in the smithing table AND render correctly,
        // the ITEM used as the ingredient must also be:
        // (1) in the minecraft:trim_materials tag (resources section below)
        // (2) created with new Item.Settings().trimMaterial(<this key>)
        // See notes below.

        register(registry, TIN, itemEntry(ModItems.TIN_INGOT), color("#CFCFCF"), 0.11f);
        register(registry, SILVER, itemEntry(ModItems.SILVER_INGOT), color("#E7EEF2"), 0.12f);
        register(registry, STERLING_SILVER, itemEntry(ModItems.STERLING_SILVER_INGOT), color("#DDE7EA"), 0.13f);
        register(registry, ROSE_GOLD, itemEntry(ModItems.ROSE_GOLD_INGOT), color("#F2A0A0"), 0.14f);
        register(registry, BRONZE, itemEntry(ModItems.BRONZE_INGOT), color("#C47A3C"), 0.15f);
        register(registry, COBALT, itemEntry(ModItems.COBALT_INGOT), color("#2F63D6"), 0.16f);
        register(registry, CARBON_STEEL, itemEntry(ModItems.CARBON_STEEL_INGOT), color("#6B6B6B"), 0.17f);
        register(registry, HARDENED_STEEL, itemEntry(ModItems.HARDENED_STEEL_INGOT), color("#4C4C4C"), 0.18f);

        register(registry, CITRINE, itemEntry(ModItems.CITRINE_GEM), color("#F2C94C"), 0.19f);
        register(registry, ONYX, itemEntry(ModItems.ONYX_GEM), color("#1A1A1A"), 0.21f);
        register(registry, TURQUOISE, itemEntry(ModItems.TURQUOISE_GEM), color("#2EC4B6"), 0.22f);
        register(registry, TOPAZ, itemEntry(ModItems.TOPAZ_GEM), color("#F2994A"), 0.23f);
        register(registry, TOURMALINE, itemEntry(ModItems.TOURMALINE_GEM), color("#2ECC71"), 0.24f);
        register(registry, SPINEL, itemEntry(ModItems.SPINEL_GEM), color("#D7263D"), 0.25f);
        register(registry, RUBY, itemEntry(ModItems.RUBY_GEM), color("#B80F2B"), 0.26f);
        register(registry, SAPPHIRE, itemEntry(ModItems.SAPPHIRE_GEM), color("#1F6FEB"), 0.27f);
        register(registry, MOISSANITE, itemEntry(ModItems.MOISSANITE_GEM), color("#9AE6FF"), 0.28f);

        register(registry, OBSIDIAN, itemEntry(ModItems.OBSIDIAN_INGOT), color("#2A1636"), 0.31f);
        register(registry, GRAPHENE, itemEntry(ModItems.GRAPHENE_GEM), color("#111111"), 0.32f);
        register(registry, ADAMANTIUM, itemEntry(ModItems.ADAMANTIUM_INGOT), color("#00D1B2"), 0.33f);
        register(registry, ENDERITE, itemEntry(ModItems.ENDERITE_INGOT), color("#8B5CF6"), 0.34f);
    }

    private static RegistryKey<ArmorTrimMaterial> key(String path) {
        return RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(Mores.MOD_ID, path));
    }

    private static RegistryEntry<Item> itemEntry(Item item) {
        return Registries.ITEM.getEntry(item);
    }

    private static Style color(String hex) {
        return Style.EMPTY.withColor(TextColor.parse(hex).getOrThrow());
    }

    private static void register(
            Registerable<ArmorTrimMaterial> registry,
            RegistryKey<ArmorTrimMaterial> key,
            RegistryEntry<Item> ingredient,
            Style style,
            float itemModelIndex
    ) {
        ArmorTrimMaterial material = new ArmorTrimMaterial(
                key.getValue().getPath(), // assetName used by atlases/palettes
                ingredient,
                itemModelIndex,
                Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", key.getValue())).fillStyle(style)
        );

        registry.register(key, material);
    }
}
