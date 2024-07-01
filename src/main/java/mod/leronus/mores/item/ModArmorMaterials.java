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

//    SILVER("silver", 12, new int[] {1, 4, 5, 1}, 24, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(ModItems.SILVER_INGOT)),
//    //    CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
//    BRONZE("bronze", 11, new int[] {2, 5, 6, 2}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT)),
//    //    IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
//    STERLING("sterling", 17, new int[] {2, 5, 6, 2}, 17, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(ModItems.STERLING_INGOT)),
//    COBALT("cobalt", 18, new int[] {2, 5, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(ModItems.COBALT_INGOT)),
//    STEEL("steel", 22, new int[] {2, 6, 7, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 1.0F, 0.1F, () -> Ingredient.ofItems(ModItems.STEEL_INGOT)),
//    AMETHYST("amethyst", 22, new int[] {2, 6, 7, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.AMETHYST_SHARD)),
//    EMERALD("emerald", 26, new int[] {2, 6, 7, 3}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> Ingredient.ofItems(Items.EMERALD)),
//    TOPAZ("topaz", 22, new int[] {2, 6, 7, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> Ingredient.ofItems(ModItems.TOPAZ_GEM)),
//    TOURMALINE("tourmaline", 25, new int[] {2, 6, 7, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> Ingredient.ofItems(ModItems.TOURMALINE_GEM)),
//    //    DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(Items.DIAMOND)),
//    RUBY("ruby", 35, new int[] {2, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(ModItems.RUBY_GEM)),
//    SAPPHIRE("sapphire", 39, new int[] {3, 6, 8, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(ModItems.SAPPHIRE_GEM)),
//    MOISSANITE("moissanite", 36, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(ModItems.MOISSANITE_GEM)),
//    TANZANITE("tanzanite", 38, new int[] {3, 7, 8, 4}, 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> Ingredient.ofItems(ModItems.TANZANITE_GEM)),
//    OBSIDIAN("obsidian", 44, new int[] {3, 7, 8, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.0F, 0.5F, () -> Ingredient.ofItems(ModItems.OBSIDIAN_INGOT)),
//    TURQUOISE("turquoise", 38, new int[] {3, 6, 8, 3}, 14, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(ModItems.TURQUOISE_GEM)),
//    ONYX("onyx", 51, new int[] {3, 7, 8, 4}, 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, 0.0F, () -> Ingredient.ofItems(ModItems.ONYX_GEM)),
//    //    NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
//    GRAPHENE("graphene", 66, new int[] {3, 7, 8, 4}, 16, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () -> Ingredient.ofItems(ModItems.GRAPHENE_GEM));

    public static final RegistryEntry<ArmorMaterial> SILVER = register("silver",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 5);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 7);
                    }),
            0, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.SILVER_INGOT));

    public static final RegistryEntry<ArmorMaterial> BRONZE = register("bronze",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 1);
                        map.put(ArmorItem.Type.LEGGINGS, 5);
                        map.put(ArmorItem.Type.CHESTPLATE, 7);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 7);
                    }),
            0, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.BRONZE_INGOT));

    public static final RegistryEntry<ArmorMaterial> STERLING = register("sterling",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 15);
                    }),
            0, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.STERLING_INGOT));

    public static final RegistryEntry<ArmorMaterial> COBALT = register("cobalt",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 7);
                    }),
            0, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.COBALT_INGOT));

    public static final RegistryEntry<ArmorMaterial> STEEL = register("steel",
            Util.make(new EnumMap(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY, 7);
                    }),
            0, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.STEEL_INGOT));

    public ModArmorMaterials()
    {
        throw new AssertionError();
    }

    //region HELPER METHODS
    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient)
    {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(new Identifier(Mores.MOD_ID, id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers)
    {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values())
        {
            enumMap.put(type, defense.get(type));
        }
        return Registry.registerReference(Registries.ARMOR_MATERIAL, new Identifier(Mores.MOD_ID, id),
                new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient,
                        layers, toughness, knockbackResistance));
    }
    //endregion
}