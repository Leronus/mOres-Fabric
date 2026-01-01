package mod.leronus.mores.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mod.leronus.mores.registry.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public class AlloyingRecipe implements Recipe<AlloyRecipeInput> {
    private final Ingredient ingredientA;
    private final Ingredient ingredientB;
    private final ItemStack result;
    private final float experience;
    private final int cookingTime;
    private final String theme;

    public AlloyingRecipe(Ingredient a, Ingredient b, ItemStack result, float exp, int time, String theme) {
        this.ingredientA = a;
        this.ingredientB = b;
        this.result = result;
        this.experience = exp;
        this.cookingTime = time;
        this.theme = theme;
    }

    public Ingredient ingredientA() { return ingredientA; }
    public Ingredient ingredientB() { return ingredientB; }

    /** Convenience copy for crafting/output. */
    public ItemStack getResultStack() { return result.copy(); }

    public float getExperience() { return experience; }
    public int getCookingTime() { return cookingTime; }
    public String getTheme() { return theme; }

    @Override
    public boolean matches(AlloyRecipeInput input, World world) {
        // IMPORTANT: DO NOT block matches on client.
        // The client must be able to find the matching recipe to show the correct theme in the GUI.
        if (input == null) return false;

        // Allow either order:
        boolean direct = ingredientA.test(input.a()) && ingredientB.test(input.b());
        boolean swapped = ingredientA.test(input.b()) && ingredientB.test(input.a());
        return direct || swapped;
    }

    @Override
    public ItemStack craft(AlloyRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return result.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup lookup) {
        return result.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ALLOYING_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.ALLOYING;
    }

    public static final class Serializer implements RecipeSerializer<AlloyingRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        // JSON / datapack codec
        private static final MapCodec<AlloyingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient_a").forGetter(AlloyingRecipe::ingredientA),
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient_b").forGetter(AlloyingRecipe::ingredientB),
                ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(r -> r.result),
                Codec.FLOAT.optionalFieldOf("experience", 0.0f).forGetter(AlloyingRecipe::getExperience),
                Codec.INT.optionalFieldOf("cookingtime", 200).forGetter(AlloyingRecipe::getCookingTime),
                Codec.STRING.optionalFieldOf("theme", "default").forGetter(AlloyingRecipe::getTheme)
        ).apply(instance, AlloyingRecipe::new));

        // Network codec (server -> client recipe sync)
        public static final PacketCodec<RegistryByteBuf, AlloyingRecipe> PACKET_CODEC =
                PacketCodec.ofStatic(Serializer::write, Serializer::read);

        private static AlloyingRecipe read(RegistryByteBuf buf) {
            Ingredient a = Ingredient.PACKET_CODEC.decode(buf);
            Ingredient b = Ingredient.PACKET_CODEC.decode(buf);
            ItemStack result = ItemStack.PACKET_CODEC.decode(buf);
            float exp = buf.readFloat();
            int time = buf.readVarInt();
            String theme = buf.readString();
            return new AlloyingRecipe(a, b, result, exp, time, theme);
        }

        private static void write(RegistryByteBuf buf, AlloyingRecipe recipe) {
            Ingredient.PACKET_CODEC.encode(buf, recipe.ingredientA());
            Ingredient.PACKET_CODEC.encode(buf, recipe.ingredientB());
            ItemStack.PACKET_CODEC.encode(buf, recipe.getResultStack());
            buf.writeFloat(recipe.getExperience());
            buf.writeVarInt(recipe.getCookingTime());
            buf.writeString(recipe.getTheme());
        }

        @Override
        public MapCodec<AlloyingRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, AlloyingRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
