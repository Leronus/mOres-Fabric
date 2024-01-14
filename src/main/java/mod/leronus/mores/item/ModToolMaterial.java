package mod.leronus.mores.item;


import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;

import java.util.function.Supplier;

/**
 * Enum that initializes all the mOres tool materials
 * @author Leronus
 */
public enum ModToolMaterial implements ToolMaterial {
    TIN(0, 100, 4.8F, 1.5F, 6, () -> Ingredient.ofItems(ModItems.TIN_INGOT)),
    COPPER(1, 90, 5.0F, 1.5F, 4, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    SILVER(2, 230, 5.5F, 2.0F, 16, () -> Ingredient.ofItems(ModItems.SILVER_INGOT)),
    BRONZE(2, 270, 6.0F, 2.0F, 7, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT)),
    IRON(2, 250, 6.0F, 2.0F, 14, () -> Ingredient.ofItems(Items.DIAMOND)),
    STERLING(2, 320, 6.0F, 2.2F, 14, () -> Ingredient.ofItems(ModItems.STERLING_INGOT)),
    COBALT(2, 350, 6.5F, 2.2F, 12, () -> Ingredient.ofItems(ModItems.COBALT_INGOT)),
    STEEL(3, 600, 6.5F, 2.5F, 18, () -> Ingredient.ofItems(ModItems.STEEL_INGOT)),
    AMETHYST(2, 700, 6.5F, 2.7F, 8, () -> Ingredient.ofItems(Items.AMETHYST_SHARD)),
    EMERALD(2, 900, 7.5F, 2.7F, 17,  () -> Ingredient.ofItems(Items.EMERALD)),
    TOPAZ(2, 1300, 7.0F, 2.7F, 14,  () -> Ingredient.ofItems(ModItems.TOPAZ_GEM)),
    TOURMALINE(2, 1500, 7.0F, 2.7F, 13, () -> Ingredient.ofItems(ModItems.TOURMALINE_GEM)),
    DIAMOND(3, 1561, 8.0F, 3.0F, 10, () -> Ingredient.ofItems(Items.DIAMOND)),
    SAPPHIRE(3, 1782, 8.0F, 3.5F, 15, () -> Ingredient.ofItems(ModItems.SAPPHIRE_GEM)),
    TANZANITE(3, 1957, 8.0F, 3.5F, 17, () -> Ingredient.ofItems(ModItems.TANZANITE_GEM)),
    OBSIDIAN(3, 2169, 8.5F, 3.5F, 13, () -> Ingredient.ofItems(Items.OBSIDIAN)),
    RUBY(3, 1601, 8.0F, 3.5F, 11,  () -> Ingredient.ofItems(ModItems.RUBY_GEM)),
    MOISSANITE(3, 1723, 8.0F, 3.5F, 23, () -> Ingredient.ofItems(ModItems.MOISSANITE_GEM)),
    NETHERITE(4, 2031, 9.0F, 4.0F, 15, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    ONYX(4, 2700, 9.5F, 4.0F, 14, () -> Ingredient.ofItems(ModItems.ONYX_GEM)),
    TURQUOISE(4, 2400, 9.0F, 4.0F, 14, () -> Ingredient.ofItems(ModItems.TURQUOISE_GEM)),
    GRAPHENE(5, 3569, 11.0F, 6.0F, 18, () -> Ingredient.ofItems(ModItems.GRAPHENE_GEM));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attckDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attckDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
