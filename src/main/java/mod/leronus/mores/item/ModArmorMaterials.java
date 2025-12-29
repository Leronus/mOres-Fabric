package mod.leronus.mores.item;

import mod.leronus.mores.Mores;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;


public class ModArmorMaterials
{
    public static final RegistryEntry<ArmorMaterial> TIN = registerArmorMaterial("tin",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 1);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 5);
                        map.put(ArmorItem.Type.HELMET, 1);
                        map.put(ArmorItem.Type.BODY, 4);
                    }),
            13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ModItems.TIN_INGOT),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "tin"))), 0.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> SILVER = registerArmorMaterial("silver",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 5);
            }),
                    24, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> Ingredient.ofItems(ModItems.SILVER_INGOT),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "silver"))), 0.0f, 0.0f));


    public static final RegistryEntry<ArmorMaterial> COPPER = registerArmorMaterial("copper",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 1);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 5);
                        map.put(ArmorItem.Type.HELMET, 1);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(Items.COPPER_INGOT),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "copper"))), 0.0f, 0.0f));

//    public static final RegistryEntry<ArmorMaterial> CHAINMAIL = registerArmorMaterial("chainmail",
//            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
//                        map.put(ArmorItem.Type.BOOTS, 1);
//                        map.put(ArmorItem.Type.LEGGINGS, 4);
//                        map.put(ArmorItem.Type.CHESTPLATE, 5);
//                        map.put(ArmorItem.Type.HELMET, 2);
//                        map.put(ArmorItem.Type.BODY, 5);
//                    }),
//            12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, () -> Ingredient.ofItems(ModItems.CHAINMAIL),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "chainmail"))), 0.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> STERLING_SILVER = registerArmorMaterial("sterling_silver",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 5);
            }),
                    17, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ModItems.STERLING_SILVER_INGOT),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "sterling"))), 0.0f, 0.0f));

    //TODO Check stats
    public static final RegistryEntry<ArmorMaterial> ROSE_GOLD = registerArmorMaterial("rose_gold",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 5);
            }),
                    17, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ModItems.ROSE_GOLD_INGOT),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "rose_gold"))), 0.0f, 0.0f));


    public static final RegistryEntry<ArmorMaterial> BRONZE = registerArmorMaterial("bronze",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 5);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "bronze"))), 0.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> COBALT = registerArmorMaterial("cobalt",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 5);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            10, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> Ingredient.ofItems(ModItems.COBALT_INGOT),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "cobalt"))),0.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> CARBON_STEEL = registerArmorMaterial("carbon_steel",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 7);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            15, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> Ingredient.ofItems(ModItems.CARBON_STEEL_INGOT),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "carbon_steel"))), 1.0f, 0.5f));

    //TODO Check stats
    public static final RegistryEntry<ArmorMaterial> HARDENED_STEEL = registerArmorMaterial("hardened_steel",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 5);
            }),
                    17, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(ModItems.HARDENED_STEEL_INGOT),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "hardened_steel"))), 0.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> TURQUOISE = registerArmorMaterial("turquoise",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 5);
            }),
                    14, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.TURQUOISE_GEM),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "turquoise"))),2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> LAPIS_LAZULI = registerArmorMaterial("lapis_lazuli",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 8);
            }),
                    36, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.LAPIS_LAZULI_GEM),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "lapis_lazuli"))),2.0f, 0.0f));


    public static final RegistryEntry<ArmorMaterial> AMETHYST = registerArmorMaterial("amethyst",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 7);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(Items.AMETHYST_SHARD),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "amethyst"))), 0.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> TANZANITE = registerArmorMaterial("tanzanite",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 5);
            }),
                    12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.TANZANITE_GEM),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "tanzanite"))), 2.0f, 0.0f));


    public static final RegistryEntry<ArmorMaterial> TOURMALINE = registerArmorMaterial("tourmaline",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 5);
            }),
                    12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.TOURMALINE_GEM),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "tourmaline"))), 1.0f, 0.0f));


    public static final RegistryEntry<ArmorMaterial> TOPAZ = registerArmorMaterial("topaz",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 7);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.TOPAZ_GEM),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "topaz"))), 1.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> EMERALD = registerArmorMaterial("emerald",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 5);
            }),
                    25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(Items.EMERALD),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "emerald"))), 0.0f, 0.0f));


    public static final RegistryEntry<ArmorMaterial> RUBY = registerArmorMaterial("ruby",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,() -> Ingredient.ofItems(ModItems.RUBY_GEM),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "ruby"))), 2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> SAPPHIRE = registerArmorMaterial("sapphire",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.SAPPHIRE_GEM),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "sapphire"))), 2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> SPINEL = registerArmorMaterial("spinel",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 5);
            }),
                    16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.SPINEL_GEM),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "spinel"))), 2.0f, 0.0f));


    public static final RegistryEntry<ArmorMaterial> MOISSANITE = registerArmorMaterial("moissanite",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.MOISSANITE_GEM),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "moissanite"))), 2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> CITRINE = registerArmorMaterial("citrine",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 4);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,() -> Ingredient.ofItems(ModItems.CITRINE_GEM),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "citrine"))), 2.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> ONYX = registerArmorMaterial("onyx",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                    map.put(ArmorItem.Type.BOOTS, 3);
                    map.put(ArmorItem.Type.LEGGINGS, 7);
                    map.put(ArmorItem.Type.CHESTPLATE, 8);
                    map.put(ArmorItem.Type.HELMET, 4);
                    map.put(ArmorItem.Type.BODY, 5);
                    }),
            18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,() -> Ingredient.ofItems(ModItems.ONYX_GEM), List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "onyx"))),3.0f, 0.0f));

    public static final RegistryEntry<ArmorMaterial> OBSIDIAN = registerArmorMaterial("obsidian",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 5);
            }),
                    13, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.OBSIDIAN_INGOT),List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "obsidian"))), 2.0f, 0.2f));


    public static final RegistryEntry<ArmorMaterial> GRAPHENE = registerArmorMaterial("graphene",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 5);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.GRAPHENE_GEM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "graphene"))), 4.0F,0.1F));

    public static final RegistryEntry<ArmorMaterial> ADAMANTIUM = registerArmorMaterial("adamantium",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 5);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.ADAMANTIUM_GEM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "adamantium"))), 4.0F,0.1F));

    public static final RegistryEntry<ArmorMaterial> ENDERITE = registerArmorMaterial("enderite",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 5);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.ENDERITE_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, "enderite"))), 4.0F,0.1F));



    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Mores.MOD_ID, name), material.get());
    }
    //endregion
}