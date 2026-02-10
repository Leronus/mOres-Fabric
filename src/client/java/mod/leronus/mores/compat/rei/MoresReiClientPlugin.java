package mod.leronus.mores.compat.rei;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.recipe.AlloyingRecipe;
import mod.leronus.mores.recipe.SteelCuttingRecipe;
import mod.leronus.mores.registry.ModRecipes;
import mod.leronus.mores.screen.AlloyFurnaceScreen;

public class MoresReiClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new AlloyingCategory());
        registry.addWorkstations(AlloyingCategory.ID, EntryStacks.of(ModBlocks.ALLOY_FURNACE));

        registry.add(new SteelCuttingCategory());
        registry.addWorkstations(SteelCuttingCategory.ID, EntryStacks.of(ModBlocks.STEEL_CUTTER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(
                AlloyingRecipe.class,
                ModRecipes.ALLOYING,
                AlloyingDisplay::new
        );
        registry.registerRecipeFiller(
                SteelCuttingRecipe.class,
                ModRecipes.STEEL_CUTTING,
                SteelCuttingDisplay::new
        );
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        // REI "+" / click areas (on burn arrow e.g.)
        registry.registerContainerClickArea(
                new Rectangle(78, 32, 28, 18),
                AlloyFurnaceScreen.class,
                AlloyingCategory.ID
        );
    }
}
