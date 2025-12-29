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

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> TIN = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "tin"));
    public static final RegistryKey<ArmorTrimMaterial> SILVER = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "silver"));
    public static final RegistryKey<ArmorTrimMaterial> STERLING_SILVER = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "sterling_silver"));
    public static final RegistryKey<ArmorTrimMaterial> ROSE_GOLD = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "rose_gold"));
    public static final RegistryKey<ArmorTrimMaterial> BRONZE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "bronze"));
    public static final RegistryKey<ArmorTrimMaterial> COBALT = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "cobalt"));
    public static final RegistryKey<ArmorTrimMaterial> CARBON_STEEL = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "carbon_steel"));
//    public static final RegistryKey<ArmorTrimMaterial> HARDENED_STEEL = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
//            Identifier.of(Mores.MOD_ID, "hardened_steel"));
    public static final RegistryKey<ArmorTrimMaterial> TURQUOISE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "turquoise"));
    public static final RegistryKey<ArmorTrimMaterial> TOPAZ = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "topaz"));
    public static final RegistryKey<ArmorTrimMaterial> TOURMALINE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "tourmaline"));
//    public static final RegistryKey<ArmorTrimMaterial> SPINEL = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
//            Identifier.of(Mores.MOD_ID, "spinel"));
    public static final RegistryKey<ArmorTrimMaterial> RUBY = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "ruby"));
    public static final RegistryKey<ArmorTrimMaterial> SAPPHIRE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "sapphire"));
    public static final RegistryKey<ArmorTrimMaterial> CITRINE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "citrine"));
    public static final RegistryKey<ArmorTrimMaterial> MOISSANITE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "moissanite"));
    public static final RegistryKey<ArmorTrimMaterial> ONYX = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "onyx"));
    public static final RegistryKey<ArmorTrimMaterial> OBSIDIAN = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "obsidian"));
    public static final RegistryKey<ArmorTrimMaterial> GRAPHENE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(Mores.MOD_ID, "graphene"));

    //TODO ADD ALL TRIM MATERIALS
    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, TIN, Registries.ITEM.getEntry(ModItems.TIN_INGOT),
                Style.EMPTY.withColor(TextColor.parse("#ffffff").getOrThrow()), 1.0f);

    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style, float itemModelIndex) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimKey.getValue().getPath(), item, itemModelIndex, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}
