package mod.leronus.mores.compat.rei;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

import mod.leronus.mores.block.ModBlocks;              // adjust if your package differs
import mod.leronus.mores.recipe.AlloyingRecipe;
import mod.leronus.mores.registry.ModRecipes;
import mod.leronus.mores.screen.AlloyFurnaceScreen;    // must extend HandledScreen<AlloyFurnaceScreenHandler>

public class MoresReiClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new AlloyingCategory());
        registry.addWorkstations(AlloyingCategory.ID, EntryStacks.of(ModBlocks.ALLOY_FURNACE));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        // ✅ Matches the DisplayRegistry decompile you posted
        registry.registerRecipeFiller(
                AlloyingRecipe.class,
                ModRecipes.ALLOYING,
                AlloyingDisplay::new
        );
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        // ✅ Matches the ScreenRegistry decompile you posted
        registry.registerContainerClickArea(
                new Rectangle(78, 32, 28, 18),
                AlloyFurnaceScreen.class,
                AlloyingCategory.ID
        );
    }
}
