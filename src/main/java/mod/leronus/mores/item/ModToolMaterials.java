package mod.leronus.mores.item;


import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

/**
 * Enum that initializes all the mOres tool materials
 * @author Leronus
 */
public enum ModToolMaterials implements ToolMaterial {
    WOOD(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 59, 2.0F, 0.0F, 15, () -> Ingredient.ofItems(Items.OAK_PLANKS)),
    STONE(BlockTags.INCORRECT_FOR_STONE_TOOL, 131, 4.0F, 1.0F, 5, () -> Ingredient.ofItems(Items.COBBLESTONE)),
    TIN(BlockTags.INCORRECT_FOR_STONE_TOOL, 164, 5.0F, 1.5F, 10, () -> Ingredient.ofItems(ModItems.TIN_INGOT)),
    GOLD(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 32, 12.0F, 0.0F, 22, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    SILVER(BlockTags.INCORRECT_FOR_IRON_TOOL, 179, 6.0F, 2.0F, 16, () -> Ingredient.ofItems(ModItems.SILVER_INGOT)),
    COPPER(BlockTags.INCORRECT_FOR_IRON_TOOL, 191, 6.0F, 2.0F, 14, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    STERLING_SILVER(BlockTags.INCORRECT_FOR_IRON_TOOL, 215, 7.0F, 2.5F, 15, () -> Ingredient.ofItems(ModItems.STERLING_SILVER_INGOT)),
    ROSE_GOLD(BlockTags.INCORRECT_FOR_IRON_TOOL, 223, 12.0F, 2.0F, 18, () -> Ingredient.ofItems(ModItems.ROSE_GOLD_INGOT)),
    BRONZE(BlockTags.INCORRECT_FOR_IRON_TOOL, 270, 6.0F, 2.0F, 13, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT)),
    IRON(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    COBALT(BlockTags.INCORRECT_FOR_IRON_TOOL, 309, 6.5F, 2.5F, 11, () -> Ingredient.ofItems(ModItems.COBALT_INGOT)),
    CARBON_STEEL(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 500, 6.5F, 2.5F, 15, () -> Ingredient.ofItems(ModItems.CARBON_STEEL_INGOT)),
    HARDENED_STEEL(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 8.5F, 3.0F, 18, () -> Ingredient.ofItems(ModItems.HARDENED_STEEL_INGOT)),
    TURQUOISE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 625, 8.5F, 3.0F, 29, () -> Ingredient.ofItems(ModItems.TURQUOISE_GEM)),
    LAPIS_LAZULI(BlockTags.INCORRECT_FOR_IRON_TOOL, 787, 8.5F, 3.0F, 36, () -> Ingredient.ofItems(ModItems.LAPIS_LAZULI_GEM)),
    AMETHYST(BlockTags.INCORRECT_FOR_IRON_TOOL, 843, 8.5F, 3.0F, 23, () -> Ingredient.ofItems(ModItems.AMETHYST_GEM)),
    CITRINE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 888, 8.0F, 2.5F, 19, () -> Ingredient.ofItems(ModItems.CITRINE_GEM)),
    ONYX(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 932, 8.5F, 3.0F, 14, () -> Ingredient.ofItems(ModItems.ONYX_GEM)),
    TANZANITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1001, 7.5F, 3.0F, 7, () -> Ingredient.ofItems(ModItems.TANZANITE_GEM)),
    TOURMALINE(BlockTags.INCORRECT_FOR_IRON_TOOL, 1257, 7.0F, 3.0F, 16, () -> Ingredient.ofItems(ModItems.TOURMALINE_GEM)),
    TOPAZ(BlockTags.INCORRECT_FOR_IRON_TOOL, 1069, 8.0F, 3.0F, 18,  () -> Ingredient.ofItems(ModItems.TOPAZ_GEM)),
    SPINEL(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1423, 8.0F, 3.5F, 17, () -> Ingredient.ofItems(ModItems.SPINEL_GEM)),
    EMERALD(BlockTags.INCORRECT_FOR_IRON_TOOL, 1199, 8.0F, 3.0F, 14,  () -> Ingredient.ofItems(Items.EMERALD)),
    DIAMOND(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 8.0F, 3.0F, 10, () -> Ingredient.ofItems(Items.DIAMOND)),
    RUBY(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1651, 8.5F, 3.5F, 6,  () -> Ingredient.ofItems(ModItems.RUBY_GEM)),
    SAPPHIRE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1771, 8.5F, 3.5F, 8, () -> Ingredient.ofItems(ModItems.SAPPHIRE_GEM)),
    MOISSANITE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1802, 8.5F, 3.5F, 11, () -> Ingredient.ofItems(ModItems.MOISSANITE_GEM)),
    OBSIDIAN(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2111, 9.0F, 3.5F, 19, () -> Ingredient.ofItems(ModItems.OBSIDIAN_INGOT)),
    NETHERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
//    GRAPHENE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3569, 12.0F, 6.0F, 18, () -> Ingredient.ofItems(ModItems.GRAPHENE_GEM)),
    ADAMANTIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1741, 9.0F, 3.5F, 12, () -> Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT)),
    ENDERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2999, 12.0F, 5.0F, 20, () -> Ingredient.ofItems(ModItems.GRAPHENE_CHAINMAIL));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(TagKey<Block> inverseTag, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient)
    {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability()
    {
        return itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier()
    {
        return miningSpeed;
    }

    @Override
    public float getAttackDamage()
    {
        return attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag()
    {
        return inverseTag;
    }

    @Override
    public int getEnchantability()
    {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return repairIngredient.get();
    }
}