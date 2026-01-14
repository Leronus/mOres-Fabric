package mod.leronus.mores.mixin;

import mod.leronus.mores.item.ModItems;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityDismountUnderwaterMixin {

    @Unique
    private static boolean mores$hasWaterArmor(Entity e) {
        if (!(e instanceof AbstractHorseEntity horse)) return false;
        ItemStack armor = horse.getEquippedStack(EquipmentSlot.BODY);
        return armor.isOf(ModItems.LAPIS_LAZULI_HORSE_ARMOR) || armor.isOf(ModItems.TURQUOISE_HORSE_ARMOR);
    }

    @Inject(method = "shouldDismountUnderwater()Z", at = @At("HEAD"), cancellable = true, require = 0)
    private void mores$entityNoDismountUnderwater(CallbackInfoReturnable<Boolean> cir) {
        if (mores$hasWaterArmor((Entity) (Object) this)) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "canBeRiddenInWater()Z", at = @At("HEAD"), cancellable = true, require = 0)
    private void mores$entityCanBeRiddenInWater(CallbackInfoReturnable<Boolean> cir) {
        if (mores$hasWaterArmor((Entity) (Object) this)) {
            cir.setReturnValue(true);
        }
    }
}
