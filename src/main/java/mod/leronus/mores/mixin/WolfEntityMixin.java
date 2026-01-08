package mod.leronus.mores.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AnimalArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WolfEntity.class)
public abstract class WolfEntityMixin {

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    private void mores$equipCustomWolfArmor(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        WolfEntity wolf = (WolfEntity)(Object)this;
        ItemStack held = player.getStackInHand(hand);

        if (!(held.getItem() instanceof AnimalArmorItem armor)) return;
        if (armor.getType() != AnimalArmorItem.Type.CANINE) return;

        if (!wolf.isTamed()) return;
        if (!wolf.isOwner(player)) return;

        // Use the SYNCED slot as the source of truth
        if (!wolf.getEquippedStack(EquipmentSlot.BODY).isEmpty()) return;

        if (wolf.getWorld().isClient) {
            // client: consume interaction so vanilla doesn't do other stuff
            cir.setReturnValue(ActionResult.SUCCESS);
            return;
        }

        // server: equip 1 copy into BODY slot (replicates to client)
        ItemStack one = held.copy();
        one.setCount(1);
        wolf.equipStack(EquipmentSlot.BODY, one);
        wolf.hasArmor();
        if (!player.getAbilities().creativeMode) {
            held.decrement(1);
        }

        // sound (your mappings support this)
        wolf.playSound(SoundEvents.ITEM_ARMOR_EQUIP_WOLF.value(), 1.0F, 1.0F);

        cir.setReturnValue(ActionResult.SUCCESS);
    }
}
