package mod.leronus.mores.mixin;

import mod.leronus.mores.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * 1.21.1 class order:
 * $1 = SimpleInventory anon
 * $2 = slot(0) anon (max count 1)
 * $3 = slot(1) anon (lapis slot) -> overrides canInsert
 */
@Mixin(targets = "net.minecraft.screen.EnchantmentScreenHandler$3")
public abstract class EnchantmentLapisSlotMixin {

    @Inject(method = "canInsert(Lnet/minecraft/item/ItemStack;)Z", at = @At("HEAD"), cancellable = true)
    private void mores$allowTurquoiseLikeLapis(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(stack.isOf(Items.LAPIS_LAZULI) || stack.isOf(ModItems.TURQUOISE));
    }
}
