package mod.leronus.mores.item;

import mod.leronus.mores.Mores;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public final class ModArmorMaterials {
    private ModArmorMaterials() {}

    // ---------------------------------------------------------------------------------
    // Values below are from your sheet screenshot:
    // - Boots/Leggings/Chestplate/Helmet columns (H/I/J/K)
    // - BODY uses Horse/Wolf value columns (L/M) (same in your sheet)
    // - Enchantability uses the *second enchant column* (N) as you requested
    // - Toughness (O) / Knockback (P)
    // ---------------------------------------------------------------------------------

    // Metals
    public static final RegistryEntry<ArmorMaterial> TIN = register("tin",
            human(1, 3, 4, 2, 4, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                    () -> Ingredient.ofItems(ModItems.TIN_INGOT), "tin", 0.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> SILVER = register("silver",
            human(2, 4, 5, 2, 5, 9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
                    () -> Ingredient.ofItems(ModItems.SILVER_INGOT), "silver", 0.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> COPPER = register("copper",
            human(2, 5, 6, 2, 6, 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                    () -> Ingredient.ofItems(Items.COPPER_INGOT), "copper", 0.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> STERLING_SILVER = register("sterling_silver",
            human(2, 5, 6, 2, 7, 10, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
                    () -> Ingredient.ofItems(ModItems.STERLING_SILVER_INGOT), "sterling_silver", 0.5f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> ROSE_GOLD = register("rose_gold",
            human(2, 5, 6, 2, 8, 33, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
                    () -> Ingredient.ofItems(ModItems.ROSE_GOLD_INGOT), "rose_gold", 0.5f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> BRONZE = register("bronze",
            human(2, 5, 6, 2, 7, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                    () -> Ingredient.ofItems(ModItems.BRONZE_INGOT), "bronze", 0.5f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> COBALT = register("cobalt",
            human(2, 5, 6, 2, 6, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                    () -> Ingredient.ofItems(ModItems.COBALT_INGOT), "cobalt", 0.5f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> CARBON_STEEL = register("carbon_steel",
            human(2, 5, 6, 2, 8, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                    () -> Ingredient.ofItems(ModItems.CARBON_STEEL_INGOT), "carbon_steel", 0.5f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> HARDENED_STEEL = register("hardened_steel",
            human(2, 5, 6, 2, 10, 12, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.ofItems(ModItems.HARDENED_STEEL_INGOT), "hardened_steel", 1.0f, 0.1f));

    // Gems / special
    public static final RegistryEntry<ArmorMaterial> TURQUOISE = register("turquoise",
            human(2, 5, 6, 2, 9, 21, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(ModItems.TURQUOISE_GEM), "turquoise", 1.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> LAPIS_LAZULI = register("lapis_lazuli",
            human(2, 5, 6, 2, 9, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(ModItems.LAPIS_LAZULI_GEM), "lapis_lazuli", 1.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> AMETHYST = register("amethyst",
            human(2, 5, 6, 2, 9, 26, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(ModItems.AMETHYST_GEM), "amethyst", 1.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> CITRINE = register("citrine",
            human(3, 6, 8, 3, 9, 16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(ModItems.CITRINE_GEM), "citrine", 1.5f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> TANZANITE = register("tanzanite",
            human(3, 6, 8, 3, 10, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(ModItems.TANZANITE_GEM), "tanzanite", 2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> TOURMALINE = register("tourmaline",
            human(3, 6, 8, 3, 11, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(ModItems.TOURMALINE_GEM), "tourmaline", 2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> TOPAZ = register("topaz",
            human(3, 6, 8, 3, 11, 11, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(ModItems.TOPAZ_GEM), "topaz", 2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> SPINEL = register("spinel",
            human(3, 6, 8, 3, 11, 9, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(ModItems.SPINEL_GEM), "spinel", 2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> EMERALD = register("emerald",
            human(3, 6, 8, 3, 11, 16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(Items.EMERALD), "emerald", 2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> RUBY = register("ruby",
            human(3, 6, 8, 3, 12, 9, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(ModItems.RUBY_GEM), "ruby", 2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> SAPPHIRE = register("sapphire",
            human(3, 6, 8, 3, 12, 13, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(ModItems.SAPPHIRE_GEM), "sapphire", 2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> MOISSANITE = register("moissanite",
            human(3, 6, 8, 3, 13, 14, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(ModItems.MOISSANITE_GEM), "moissanite", 2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> ONYX = register("onyx",
            human(3, 6, 8, 3, 9, 13, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(ModItems.ONYX_GEM), "onyx", 2.0f, 0.0f));

    // High tier
    public static final RegistryEntry<ArmorMaterial> GRAPHENE_CHAINMAIL = register("graphene_chainmail",
            human(2, 5, 6, 2, 8, 16, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
                    () -> Ingredient.ofItems(ModItems.GRAPHENE_CHAINMAIL), "graphene_chainmail", 2.0f, 0.05f));

    public static final RegistryEntry<ArmorMaterial> OBSIDIAN = register("obsidian",
            human(3, 6, 8, 3, 11, 19, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.ofItems(ModItems.OBSIDIAN_INGOT), "obsidian", 2.5f, 0.1f));

    public static final RegistryEntry<ArmorMaterial> ADAMANTIUM = register("adamantium",
            human(3, 6, 8, 3, 13, 16, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT), "adamantium", 2.5f, 1.0f));

    public static final RegistryEntry<ArmorMaterial> NETHERITE = register("netherite",
            human(3, 6, 8, 3, 11, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.ofItems(Items.NETHERITE_INGOT), "netherite", 3.0f, 0.1f));

    public static final RegistryEntry<ArmorMaterial> ENDERITE = register("enderite",
            human(4, 7, 9, 4, 15, 21, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.ofItems(ModItems.ENDERITE_INGOT), "enderite", 4.0f, 0.5f));

    // =========================================================
    // Helpers
    // =========================================================

    private static ArmorMaterial human(
            int boots, int leggings, int chestplate, int helmet,
            int bodyProtection,
            int armorEnchantability,
            RegistryEntry<SoundEvent> equipSound,
            Supplier<Ingredient> repairIngredient,
            String layerTextureId,
            float toughness,
            float knockbackResistance
    ) {
        return new ArmorMaterial(
                Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                    map.put(ArmorItem.Type.BOOTS, boots);
                    map.put(ArmorItem.Type.LEGGINGS, leggings);
                    map.put(ArmorItem.Type.CHESTPLATE, chestplate);
                    map.put(ArmorItem.Type.HELMET, helmet);
                    // Animal armor reads BODY in 1.21.x
                    map.put(ArmorItem.Type.BODY, bodyProtection);
                }),
                armorEnchantability,
                equipSound,
                repairIngredient,
                List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, layerTextureId))),
                toughness,
                knockbackResistance
        );
    }

    private static RegistryEntry<ArmorMaterial> register(String idPath, ArmorMaterial material) {
        return Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                Identifier.of(Mores.MOD_ID, idPath),
                material
        );
    }
}
