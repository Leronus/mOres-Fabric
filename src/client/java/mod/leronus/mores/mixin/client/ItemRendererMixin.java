package mod.leronus.mores.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.notunanancyowen.spears.Spears;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = ItemRenderer.class, priority = 2000)
public abstract class ItemRendererMixin {

    @WrapOperation(
            method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/item/ItemRenderer;renderBakedItemModel(Lnet/minecraft/client/render/model/BakedModel;Lnet/minecraft/item/ItemStack;IILnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;)V"
            )
    )
    private void mores$forceBaseModelInGui(
            ItemRenderer instance,
            BakedModel model,
            ItemStack stack,
            int light,
            int overlay,
            MatrixStack matrices,
            VertexConsumer vertices,
            Operation<Void> original,
            @Local(argsOnly = true) ModelTransformationMode renderMode
    ) {
        boolean guiLike =
                renderMode == ModelTransformationMode.GUI ||
                        renderMode == ModelTransformationMode.GROUND ||
                        renderMode == ModelTransformationMode.FIXED;

        if (guiLike && isSpear(stack)) {
            // force base model
            original.call(
                    instance,
                    instance.getModels().getModel(stack),
                    stack,
                    light,
                    overlay,
                    matrices,
                    vertices
            );
        } else {
            // normal behavior (in-hand, etc.)
            original.call(instance, model, stack, light, overlay, matrices, vertices);
        }
    }

    private static boolean isSpear(ItemStack stack) {
        return stack.isIn(Spears.SPEARS)
                || stack.getItem().toString().contains("spear"); // optional safety
    }
}
