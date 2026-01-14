package mod.leronus.mores.mixin;

import mod.leronus.mores.item.ModItems;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractHorseEntity.class)
public abstract class AbstractHorseEntityRideInWaterMixin {

    @Unique
    private static boolean mores$hasWaterArmor(AbstractHorseEntity horse) {
        ItemStack armor = horse.getEquippedStack(EquipmentSlot.BODY);
        return armor.isOf(ModItems.LAPIS_LAZULI_HORSE_ARMOR) || armor.isOf(ModItems.TURQUOISE_HORSE_ARMOR);
    }

    /**
     * Some versions expose these methods on AbstractHorseEntity.
     * require = 0 keeps it from crashing if a name doesn't exist in your mappings.
     */
    @Inject(method = "shouldDismountUnderwater()Z", at = @At("HEAD"), cancellable = true, require = 0)
    private void mores$noDismountUnderwater(CallbackInfoReturnable<Boolean> cir) {
        AbstractHorseEntity horse = (AbstractHorseEntity) (Object) this;
        if (mores$hasWaterArmor(horse)) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "canBeRiddenInWater()Z", at = @At("HEAD"), cancellable = true, require = 0)
    private void mores$canBeRiddenInWater(CallbackInfoReturnable<Boolean> cir) {
        AbstractHorseEntity horse = (AbstractHorseEntity) (Object) this;
        if (mores$hasWaterArmor(horse)) {
            cir.setReturnValue(true);
        }
    }
}
