package mod.leronus.mores.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record AlloyRecipeInput(ItemStack a, ItemStack b) implements RecipeInput {
    @Override public ItemStack getStackInSlot(int slot) {
        return switch (slot) {
            case 0 -> a;
            case 1 -> b;
            default -> ItemStack.EMPTY;
        };
    }

    @Override
    public int getSize() {
        return 2;
    }
}
