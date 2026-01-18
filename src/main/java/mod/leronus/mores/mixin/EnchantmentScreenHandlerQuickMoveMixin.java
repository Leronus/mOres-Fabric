package mod.leronus.mores.mixin;

import mod.leronus.mores.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.EnchantmentScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantmentScreenHandler.class)
public abstract class EnchantmentScreenHandlerQuickMoveMixin {

    /**
     * quickMove has: else if (itemStack2.isOf(Items.LAPIS_LAZULI)) { ... }
     * Redirect just that isOf() call so Turquoise is treated like lapis.
     */
    @Redirect(
            method = "quickMove",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
            )
    )
    private boolean mores$shiftClickTreatTurquoiseAsLapis(ItemStack stack, Item item) {
        if (item == Items.LAPIS_LAZULI) {
            return stack.isOf(Items.LAPIS_LAZULI) || stack.isOf(ModItems.TURQUOISE);
        }
        return stack.isOf(item);
    }
}
