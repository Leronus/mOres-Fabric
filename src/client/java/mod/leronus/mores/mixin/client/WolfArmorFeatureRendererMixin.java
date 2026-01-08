package mod.leronus.mores.mixin.client;

import net.minecraft.client.render.entity.feature.WolfArmorFeatureRenderer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WolfArmorFeatureRenderer.class)
public abstract class WolfArmorFeatureRendererMixin {

    // Redirect the ItemStack fetch used by the renderer
    @Redirect(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/passive/WolfEntity;getBodyArmor()Lnet/minecraft/item/ItemStack;"
            )
    )
    private ItemStack mores$useBodyEquipmentSlot(WolfEntity wolf) {
        return wolf.getEquippedStack(EquipmentSlot.BODY);
    }
}
