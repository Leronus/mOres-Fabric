package mod.leronus.mores.item;

import com.terraformersmc.modmenu.util.mod.Mod;
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


public class ModArmorMaterials
{
    public static final RegistryEntry<ArmorMaterial> TIN = register("tin",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 1);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 5);
                        map.put(ArmorItem.Type.HELMET, 1);
                        map.put(ArmorItem.Type.BODY, 4);
                    }),
            13, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.TIN_INGOT));

    public static final RegistryEntry<ArmorMaterial> COPPER = register("copper",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 1);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 5);
                        map.put(ArmorItem.Type.HELMET, 1);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            9, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(Items.COPPER_INGOT));

    public static final RegistryEntry<ArmorMaterial> SILVER = register("silver",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 1);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 5);
                        map.put(ArmorItem.Type.HELMET, 1);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            24, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.SILVER_INGOT));

    public static final RegistryEntry<ArmorMaterial> CHAINMAIL = register("chainmail",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 1);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 5);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.CHAIN));

    public static final RegistryEntry<ArmorMaterial> BRONZE = register("bronze",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 5);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            11, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.BRONZE_INGOT));

    public static final RegistryEntry<ArmorMaterial> STERLING = register("sterling",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 5);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            17, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.STERLING_INGOT));

    public static final RegistryEntry<ArmorMaterial> COBALT = register("cobalt",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 5);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            10, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.COBALT_INGOT));

    public static final RegistryEntry<ArmorMaterial> STEEL = register("steel",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 7);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            15, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            1.0f, 0.5f,
            () -> Ingredient.ofItems(ModItems.STEEL_INGOT));

    public static final RegistryEntry<ArmorMaterial> AMETHYST = register("amethyst",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 7);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(Items.AMETHYST_SHARD));

    public static final RegistryEntry<ArmorMaterial> EMERALD = register("emerald",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 7);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(Items.EMERALD));

    public static final RegistryEntry<ArmorMaterial> TOPAZ = register("topaz",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 7);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            1.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.TOPAZ_GEM));

    public static final RegistryEntry<ArmorMaterial> TOURMALINE = register("tourmaline",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 7);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            1.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.TOURMALINE_GEM));

    public static final RegistryEntry<ArmorMaterial> RUBY = register("ruby",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            2.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.RUBY_GEM));

    public static final RegistryEntry<ArmorMaterial> SAPPHIRE = register("sapphire",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            2.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.SAPPHIRE_GEM));

    public static final RegistryEntry<ArmorMaterial> MOISSANITE = register("moissanite",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            2.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.MOISSANITE_GEM));

    public static final RegistryEntry<ArmorMaterial> TANZANITE = register("tanzanite",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 4);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            2.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.TANZANITE_GEM));

    public static final RegistryEntry<ArmorMaterial> OBSIDIAN = register("obsidian",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 4);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            13, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            2.0f, 0.2f,
            () -> Ingredient.ofItems(ModItems.OBSIDIAN_INGOT));

    public static final RegistryEntry<ArmorMaterial> TURQUOISE = register("turquoise",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 4);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            14, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            2.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.TURQUOISE_GEM));

    public static final RegistryEntry<ArmorMaterial> ONYX = register("onyx",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 4);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            3.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.ONYX_GEM));

    public static final RegistryEntry<ArmorMaterial> GRAPHENE = register("graphene",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 4);
                        map.put(ArmorItem.Type.BODY, 5);
                    }),
            16, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            4.0f, 0.1f,
            () -> Ingredient.ofItems(ModItems.GRAPHENE_GEM));

    public ModArmorMaterials()
    {
        throw new AssertionError();
    }

    //region HELPER METHODS
    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient)
    {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.of(Mores.MOD_ID, id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers)
    {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values())
        {
            enumMap.put(type, defense.get(type));
        }
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Mores.MOD_ID, id),
                new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient,
                        layers, toughness, knockbackResistance));
    }
    //endregion
}