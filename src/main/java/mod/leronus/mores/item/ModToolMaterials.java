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
    TIN(BlockTags.INCORRECT_FOR_STONE_TOOL, 100, 4.8F, 1.5F, 6, () -> Ingredient.ofItems(ModItems.TIN_INGOT)),
    GOLD(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 32, 12.0F, 0.0F, 22, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    SILVER(BlockTags.INCORRECT_FOR_IRON_TOOL, 230, 5.5F, 2.0F, 16, () -> Ingredient.ofItems(ModItems.SILVER_INGOT)),
    COPPER(BlockTags.INCORRECT_FOR_IRON_TOOL, 90, 5.0F, 1.5F, 4, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    STERLING_SILVER(BlockTags.INCORRECT_FOR_IRON_TOOL, 320, 6.0F, 2.2F, 14, () -> Ingredient.ofItems(ModItems.STERLING_SILVER_INGOT)),
    //TODO CHECK STATS
    ROSE_GOLD(BlockTags.INCORRECT_FOR_IRON_TOOL, 320, 6.0F, 2.2F, 14, () -> Ingredient.ofItems(ModItems.ROSE_GOLD_INGOT)),
    BRONZE(BlockTags.INCORRECT_FOR_IRON_TOOL, 270, 6.0F, 2.0F, 7, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT)),
    IRON(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    COBALT(BlockTags.INCORRECT_FOR_IRON_TOOL, 350, 6.5F, 2.2F, 12, () -> Ingredient.ofItems(ModItems.COBALT_INGOT)),
    CARBON_STEEL(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 600, 6.5F, 2.5F, 18, () -> Ingredient.ofItems(ModItems.CARBON_STEEL_INGOT)),
    //TODO CHECK STATS
    HARDENED_STEEL(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 600, 6.5F, 2.5F, 18, () -> Ingredient.ofItems(ModItems.HARDENED_STEEL_INGOT)),
    //TODO CHECK STATS
    TURQUOISE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2400, 9.0F, 4.0F, 14, () -> Ingredient.ofItems(ModItems.TURQUOISE_GEM)),
    AMETHYST(BlockTags.INCORRECT_FOR_IRON_TOOL, 700, 6.5F, 2.7F, 8, () -> Ingredient.ofItems(ModItems.AMETHYST_GEM)),
    LAPIS_LAZULI(BlockTags.INCORRECT_FOR_IRON_TOOL, 700, 6.5F, 2.7F, 8, () -> Ingredient.ofItems(ModItems.LAPIS_LAZULI_GEM)),
    TANZANITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2400, 9.0F, 4.0F, 14, () -> Ingredient.ofItems(ModItems.TANZANITE_GEM)),
    TOURMALINE(BlockTags.INCORRECT_FOR_IRON_TOOL, 1500, 7.0F, 2.7F, 13, () -> Ingredient.ofItems(ModItems.TOURMALINE_GEM)),
    TOPAZ(BlockTags.INCORRECT_FOR_IRON_TOOL, 1300, 7.0F, 2.7F, 14,  () -> Ingredient.ofItems(ModItems.TOPAZ_GEM)),
    EMERALD(BlockTags.INCORRECT_FOR_IRON_TOOL, 900, 7.5F, 2.7F, 17,  () -> Ingredient.ofItems(Items.EMERALD)),
    DIAMOND(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 8.0F, 3.0F, 10, () -> Ingredient.ofItems(Items.DIAMOND)),
    RUBY(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1601, 8.0F, 3.5F, 11,  () -> Ingredient.ofItems(ModItems.RUBY_GEM)),
    SAPPHIRE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1782, 8.0F, 3.5F, 15, () -> Ingredient.ofItems(ModItems.SAPPHIRE_GEM)),
    //TODO CHECK STATS
    SPINEL(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1957, 8.0F, 3.5F, 17, () -> Ingredient.ofItems(ModItems.SPINEL_GEM)),
    CITRINE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1957, 8.0F, 3.5F, 17, () -> Ingredient.ofItems(ModItems.CITRINE_GEM)),
    MOISSANITE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1723, 8.0F, 3.5F, 23, () -> Ingredient.ofItems(ModItems.MOISSANITE_GEM)),
    ONYX(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2700, 10.0F, 4.0F, 14, () -> Ingredient.ofItems(ModItems.ONYX_GEM)),
    OBSIDIAN(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2169, 8.5F, 3.5F, 13, () -> Ingredient.ofItems(Items.OBSIDIAN)),
    NETHERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    GRAPHENE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3569, 12.0F, 6.0F, 18, () -> Ingredient.ofItems(ModItems.GRAPHENE_GEM)),
    ADAMANTIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3569, 12.0F, 6.0F, 18, () -> Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT)),
    ENDERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3569, 12.0F, 6.0F, 18, () -> Ingredient.ofItems(ModItems.GRAPHENE_GEM));

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