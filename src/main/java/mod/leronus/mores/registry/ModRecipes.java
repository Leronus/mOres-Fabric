package mod.leronus.mores.registry;

import mod.leronus.mores.Mores;
import mod.leronus.mores.recipe.AlloyingRecipe;
import mod.leronus.mores.recipe.ShieldDecorationRecipe;
import mod.leronus.mores.recipe.SteelCuttingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ModRecipes {

    public static RecipeType<AlloyingRecipe> ALLOYING;
    public static RecipeSerializer<AlloyingRecipe> ALLOYING_SERIALIZER;
    public static RecipeSerializer<ShieldDecorationRecipe> SHIELD_DECORATION;
    public static RecipeType<SteelCuttingRecipe> STEEL_CUTTING;
    public static RecipeSerializer<SteelCuttingRecipe> STEEL_CUTTING_SERIALIZER;

    private ModRecipes() {}

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

        STEEL_CUTTING = Registry.register(
                Registries.RECIPE_TYPE,
                id("steel_cutting"),
                new RecipeType<>() {}
        );

        STEEL_CUTTING_SERIALIZER = Registry.register(
                Registries.RECIPE_SERIALIZER,
                id("steel_cutting"),
                SteelCuttingRecipe.Serializer.INSTANCE
        );

        SHIELD_DECORATION = Registry.register(
                Registries.RECIPE_SERIALIZER,
                id("shield_decoration"),
                new SpecialRecipeSerializer<>(ShieldDecorationRecipe::new)
        );
    }

    private static Identifier id(String path) {
        return Identifier.of(Mores.MOD_ID, path);
    }
}
