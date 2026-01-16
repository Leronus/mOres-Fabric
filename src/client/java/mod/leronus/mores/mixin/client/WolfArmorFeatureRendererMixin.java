package mod.leronus.mores.mixin.client;

import net.minecraft.client.render.entity.feature.WolfArmorFeatureRenderer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * 1.21.x changed how wolf armor is stored/accessed internally.
 * <p>
 * Vanilla renderer wants "the wolf's body armor stack", but depending on the exact
 * mappings/version it may call WolfEntity#getBodyArmor() or WolfEntity#getBodyArmorStack().
 * <p>
 * This mixin redirects either call to the stable API: wolf.getEquippedStack(EquipmentSlot.BODY)
 * <p>
 * require = 0 makes it safe across minor mapping changes:
 * - If the target method doesn't exist, the redirect is simply ignored.
 */
@Mixin(WolfArmorFeatureRenderer.class)
public abstract class WolfArmorFeatureRendererMixin {

    /**
     * Variant A: some versions/mappings used WolfEntity#getBodyArmor()
     */
    @Redirect(
            method = "render(Lnet/minecraft/client/util/math/MatrixStack;" +
                    "Lnet/minecraft/client/render/VertexConsumerProvider;I" +
                    "Lnet/minecraft/entity/passive/WolfEntity;FFFFFF)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/passive/WolfEntity;getBodyArmor()Lnet/minecraft/item/ItemStack;"
            ),
            require = 0
    )
    private ItemStack mores$redirectGetBodyArmor(WolfEntity wolf) {
        return wolf.getEquippedStack(EquipmentSlot.BODY);
    }

    /**
     * Variant B: some versions/mappings use WolfEntity#getBodyArmorStack()
     */
    @Redirect(
            method = "render(Lnet/minecraft/client/util/math/MatrixStack;" +
                    "Lnet/minecraft/client/render/VertexConsumerProvider;I" +
                    "Lnet/minecraft/entity/passive/WolfEntity;FFFFFF)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/passive/WolfEntity;getBodyArmorStack()Lnet/minecraft/item/ItemStack;"
            ),
            require = 0
    )
    private ItemStack mores$redirectGetBodyArmorStack(WolfEntity wolf) {
        return wolf.getEquippedStack(EquipmentSlot.BODY);
    }
}
