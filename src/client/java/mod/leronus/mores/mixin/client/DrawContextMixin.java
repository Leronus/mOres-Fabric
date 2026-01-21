package mod.leronus.mores.mixin.client;

import mod.leronus.mores.SpearsRenderState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = DrawContext.class, priority = 2000)
public abstract class DrawContextMixin {

    @Redirect(
            method = "drawItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;IIII)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/item/ItemRenderer;getModel(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/LivingEntity;I)Lnet/minecraft/client/render/model/BakedModel;"
            )
    )
    private BakedModel mores$forceGuiModelResolve(
            ItemRenderer itemRenderer,
            ItemStack stack,
            World world,
            LivingEntity entity,
            int seed
    ) {
        // This method is only used for GUI item drawing (hotbar/inventory/slots/tooltips/etc.)
        SpearsRenderState.pushGui(true);
        try {
            return itemRenderer.getModel(stack, world, entity, seed);
        } finally {
            SpearsRenderState.popGui();
        }
    }
}
