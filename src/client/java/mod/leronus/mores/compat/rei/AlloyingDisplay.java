package mod.leronus.mores.compat.rei;

import java.util.List;
import java.util.Optional;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryIngredients;

import mod.leronus.mores.recipe.AlloyingRecipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.util.Identifier;

public class AlloyingDisplay extends BasicDisplay {

    private final RecipeEntry<AlloyingRecipe> entry;

    // IMPORTANT: This constructor is what REI will call via registerRecipeFiller(type, AlloyingDisplay::new)
    public AlloyingDisplay(RecipeEntry<AlloyingRecipe> entry) {
        super(
                List.of(
                        EntryIngredients.ofIngredient(entry.value().ingredientA()),
                        EntryIngredients.ofIngredient(entry.value().ingredientB())
                ),
                List.of(EntryIngredients.of(entry.value().getResultStack())),
                Optional.ofNullable(entry.id()) // <- recipe id comes from RecipeEntry in modern MC
        );
        this.entry = entry;
    }

    public AlloyingRecipe getRecipe() {
        return entry.value();
    }

    public Identifier getRecipeId() {
        return entry.id();
    }

    public float getExperience() {
        return entry.value().getExperience();
    }

    public int getCookTime() {
        return entry.value().getCookingTime();
    }

    public String getTheme() {
        return entry.value().getTheme();
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return AlloyingCategory.ID;
    }
}
