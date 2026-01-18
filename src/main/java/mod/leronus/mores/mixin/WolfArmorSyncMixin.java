package mod.leronus.mores.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WolfEntity.class)
public abstract class WolfArmorSyncMixin {

    /**
     * Keep vanilla behavior intact and just additionally treat BODY slot as "has armor".
     * (Do NOT cancel at HEAD - we don't want to skip vanilla internals.)
     */
    @Inject(method = "hasArmor()Z", at = @At("RETURN"), cancellable = true)
    private void mores$hasArmorAlsoFromBodySlot(CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValueZ()) return;

        WolfEntity wolf = (WolfEntity)(Object)this;
        cir.setReturnValue(!wolf.getEquippedStack(EquipmentSlot.BODY).isEmpty());
    }

    /**
     * Force body-armor stack accessors to read from the synced BODY slot.
     * require = 0 makes this safe across minor mapping/name differences.
     */
    @Inject(
            method = "getBodyArmor()Lnet/minecraft/item/ItemStack;",
            at = @At("HEAD"),
            cancellable = true,
            require = 0
    )
    private void mores$getBodyArmorFromBodySlot(CallbackInfoReturnable<ItemStack> cir) {
        WolfEntity wolf = (WolfEntity)(Object)this;
        cir.setReturnValue(wolf.getEquippedStack(EquipmentSlot.BODY));
    }

    @Inject(
            method = "getBodyArmorStack()Lnet/minecraft/item/ItemStack;",
            at = @At("HEAD"),
            cancellable = true,
            require = 0
    )
    private void mores$getBodyArmorStackFromBodySlot(CallbackInfoReturnable<ItemStack> cir) {
        WolfEntity wolf = (WolfEntity)(Object)this;
        cir.setReturnValue(wolf.getEquippedStack(EquipmentSlot.BODY));
    }

    /**
     * THIS is the invincibility fix:
     * Vanilla wolf armor is a "shield layer" (absorbs damage into durability) via applyDamage().
     * That behavior is controlled by shouldArmorAbsorbDamage().
     *
     * We only want that shield behavior for vanilla Items.WOLF_ARMOR.
     * For your custom canine armor, return false so damage goes through normally and
     * is reduced by armor/toughness attributes (horse-style).
     */
    @Inject(
            method = "shouldArmorAbsorbDamage(Lnet/minecraft/entity/damage/DamageSource;)Z",
            at = @At("HEAD"),
            cancellable = true
    )
    private void mores$onlyAbsorbWithVanillaWolfArmor(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        WolfEntity wolf = (WolfEntity)(Object)this;

        // If wolf has armor (per our hasArmor BODY-slot truth),
        // but it's not the vanilla wolf armor item, disable the "absorb into durability" mechanic.
        if (wolf.hasArmor() && !wolf.getBodyArmor().isOf(Items.WOLF_ARMOR)) {
            cir.setReturnValue(false);
        }
    }
}
