package mod.leronus.mores.recipe;

import mod.leronus.mores.Mores;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ModRecipeTypes {

    public static RecipeType<AlloyingRecipe> ALLOYING;
    public static RecipeSerializer<AlloyingRecipe> ALLOYING_SERIALIZER;

    private ModRecipeTypes() {}

    public static void registerRecipes() {
        Mores.LOGGER.info("Registering Recipes for " + Mores.MOD_ID);

        ALLOYING = Registry.register(
                Registries.RECIPE_TYPE,
                id("alloying"),
                new RecipeType<>() {}
        );

        ALLOYING_SERIALIZER = Registry.register(
                Registries.RECIPE_SERIALIZER,
                id("alloying"),
                AlloyingRecipe.Serializer.INSTANCE
        );
    }

    private static Identifier id(String path) {
        return Identifier.of(Mores.MOD_ID, path);
    }
}
