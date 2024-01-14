package mod.leronus.mores.item;

import mod.leronus.mores.Mores;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    /**
     * Slot[]{Feet, Legs, Chest, Helm}
     */
//    LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.LEATHER)),
    TIN("tin", 5, new int[] {1, 4, 5, 1}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(ModItems.TIN_INGOT)),
    COPPER("copper", 6, new int[] {1, 4, 5, 1}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
//    GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    SILVER("silver", 12, new int[] {1, 4, 5, 1}, 24, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(ModItems.SILVER_INGOT)),
//    CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    BRONZE("bronze", 11, new int[] {2, 5, 6, 2}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT)),
//    IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    STERLING("sterling", 17, new int[] {2, 5, 6, 2}, 17, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(ModItems.STERLING_INGOT)),
    COBALT("cobalt", 18, new int[] {2, 5, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> Ingredient.ofItems(ModItems.COBALT_INGOT)),
    STEEL("steel", 22, new int[] {2, 6, 7, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 1.0F, 0.1F, () -> Ingredient.ofItems(ModItems.STEEL_INGOT)),
    AMETHYST("amethyst", 22, new int[] {2, 6, 7, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.AMETHYST_SHARD)),
    EMERALD("emerald", 26, new int[] {2, 6, 7, 3}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> Ingredient.ofItems(Items.EMERALD)),
    TOPAZ("topaz", 22, new int[] {2, 6, 7, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> Ingredient.ofItems(ModItems.TOPAZ_GEM)),
    TOURMALINE("tourmaline", 25, new int[] {2, 6, 7, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> Ingredient.ofItems(ModItems.TOURMALINE_GEM)),
    //    DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(Items.DIAMOND)),
    RUBY("ruby", 35, new int[] {2, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(ModItems.RUBY_GEM)),
    SAPPHIRE("sapphire", 39, new int[] {3, 6, 8, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(ModItems.SAPPHIRE_GEM)),
    MOISSANITE("moissanite", 36, new int[] {3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(ModItems.MOISSANITE_GEM)),
    TANZANITE("tanzanite", 38, new int[] {3, 7, 8, 4}, 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> Ingredient.ofItems(ModItems.TANZANITE_GEM)),
    OBSIDIAN("obsidian", 44, new int[] {3, 7, 8, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.0F, 0.5F, () -> Ingredient.ofItems(ModItems.OBSIDIAN_INGOT)),
    TURQUOISE("turquoise", 38, new int[] {3, 6, 8, 3}, 14, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.ofItems(ModItems.TURQUOISE_GEM)),
    ONYX("onyx", 51, new int[] {3, 7, 8, 4}, 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, 0.0F, () -> Ingredient.ofItems(ModItems.ONYX_GEM)),
//    NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    GRAPHENE("graphene", 66, new int[] {3, 7, 8, 4}, 16, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () -> Ingredient.ofItems(ModItems.GRAPHENE_GEM));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 15, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound,
                      float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return Mores.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}