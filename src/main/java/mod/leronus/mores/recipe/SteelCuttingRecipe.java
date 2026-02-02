package mod.leronus.mores.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mod.leronus.mores.registry.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.StonecuttingRecipe;

/**
 * StonecuttingRecipe clone that uses a custom RecipeType/Serializer so it won't show in vanilla stonecutter.
 */
public class SteelCuttingRecipe extends StonecuttingRecipe {

    public SteelCuttingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(group, ingredient, result);
    }

    /**
     * IMPORTANT:
     * Prevents vanilla recipe book from trying to categorize this custom recipe type,
     * which is what causes the "Unknown recipe category" warnings.
     */
    @Override
    public boolean isIgnoredInRecipeBook() {
        return true;
    }

    public Ingredient getInput() {
        return this.getIngredients().get(0);
    }

    public ItemStack getResultStack() {
        return this.getResult(null);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.STEEL_CUTTING_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.STEEL_CUTTING;
    }

    public static final class Serializer implements RecipeSerializer<SteelCuttingRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        private static final MapCodec<SteelCuttingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Codec.STRING.optionalFieldOf("group", "").forGetter(SteelCuttingRecipe::getGroup),
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(SteelCuttingRecipe::getInput),
                ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(SteelCuttingRecipe::getResultStack)
        ).apply(instance, SteelCuttingRecipe::new));

        public static final PacketCodec<RegistryByteBuf, SteelCuttingRecipe> PACKET_CODEC =
                PacketCodec.ofStatic(Serializer::write, Serializer::read);

        private static SteelCuttingRecipe read(RegistryByteBuf buf) {
            String group = buf.readString();
            Ingredient ingredient = Ingredient.PACKET_CODEC.decode(buf);
            ItemStack result = ItemStack.PACKET_CODEC.decode(buf);
            return new SteelCuttingRecipe(group, ingredient, result);
        }

        private static void write(RegistryByteBuf buf, SteelCuttingRecipe recipe) {
            buf.writeString(recipe.getGroup());
            Ingredient.PACKET_CODEC.encode(buf, recipe.getInput());
            ItemStack.PACKET_CODEC.encode(buf, recipe.getResultStack());
        }

        @Override
        public MapCodec<SteelCuttingRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, SteelCuttingRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
