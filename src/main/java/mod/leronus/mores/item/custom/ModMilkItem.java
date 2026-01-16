package mod.leronus.mores.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Food item that clears ALL status effects on finish (milk bucket behavior).
 * Put this on milk_chocolate + white_chocolate.
 */
public class ModMilkItem extends Item {

    public ModMilkItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        // Let vanilla handle hunger/saturation + consumption
        ItemStack result = super.finishUsing(stack, world, user);

        // Clear effects server-side (important!)
        if (!world.isClient) {
            user.clearStatusEffects(); // milk-like: removes all (good and bad)
        }

        return result;
    }
}
