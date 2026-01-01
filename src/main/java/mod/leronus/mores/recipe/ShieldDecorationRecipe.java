package mod.leronus.mores.recipe;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShield;
import mod.leronus.mores.registry.ModRecipes;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.item.BannerItem;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.DyeColor;
import net.minecraft.world.World;

public class ShieldDecorationRecipe extends SpecialCraftingRecipe {

    public ShieldDecorationRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        ItemStack shield = ItemStack.EMPTY;
        ItemStack banner = ItemStack.EMPTY;

        for (int i = 0; i < input.getSize(); i++) {
            ItemStack stack = input.getStackInSlot(i);
            if (stack.isEmpty()) continue;

            if (stack.getItem() instanceof BannerItem) {
                if (!banner.isEmpty()) return false;
                banner = stack;
                continue;
            }

            if (stack.getItem() instanceof FabricShield fabricShield && fabricShield.supportsBanner()) {
                if (!shield.isEmpty()) return false;

                // Reject only if it's ACTUALLY decorated already
                if (stack.get(DataComponentTypes.BASE_COLOR) != null) return false;

                BannerPatternsComponent existing = stack.get(DataComponentTypes.BANNER_PATTERNS);
                if (existing != null && !existing.layers().isEmpty()) return false;

                shield = stack;
                continue;
            }

            return false;
        }

        return !shield.isEmpty() && !banner.isEmpty();
    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        ItemStack shield = ItemStack.EMPTY;
        ItemStack banner = ItemStack.EMPTY;

        for (int i = 0; i < input.getSize(); i++) {
            ItemStack stack = input.getStackInSlot(i);
            if (stack.isEmpty()) continue;

            if (stack.getItem() instanceof BannerItem) banner = stack;
            else shield = stack;
        }

        if (shield.isEmpty() || banner.isEmpty()) return ItemStack.EMPTY;

        ItemStack out = shield.copy();
        out.setCount(1);

        // Correct in 1.21.x: base color comes from the banner ITEM type
        DyeColor base = ((BannerItem) banner.getItem()).getColor();
        out.set(DataComponentTypes.BASE_COLOR, base);

        // Patterns are stored as a component (may be absent or empty)
        BannerPatternsComponent patterns = banner.get(DataComponentTypes.BANNER_PATTERNS);
        if (patterns != null && !patterns.layers().isEmpty()) {
            out.set(DataComponentTypes.BANNER_PATTERNS, patterns);
        }

        return out;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.SHIELD_DECORATION;
    }
}
