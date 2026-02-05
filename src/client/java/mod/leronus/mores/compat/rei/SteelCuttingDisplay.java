package mod.leronus.mores.compat.rei;

import java.util.List;
import java.util.Optional;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryIngredients;

import mod.leronus.mores.recipe.SteelCuttingRecipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.util.Identifier;

public class SteelCuttingDisplay extends BasicDisplay {

    private final RecipeEntry<SteelCuttingRecipe> entry;

    public SteelCuttingDisplay(RecipeEntry<SteelCuttingRecipe> entry) {
        super(
                List.of(EntryIngredients.ofIngredient(entry.value().getInput())), // adjust method name if different
                List.of(EntryIngredients.of(entry.value().getResultStack())),      // adjust method name if different
                Optional.ofNullable(entry.id())
        );
        this.entry = entry;
    }

    public SteelCuttingRecipe getRecipe() {
        return entry.value();
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return SteelCuttingCategory.ID;
    }

    public Identifier getId() {
        return entry.id();
    }
}
