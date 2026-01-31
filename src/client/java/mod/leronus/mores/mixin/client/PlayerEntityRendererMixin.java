package mod.leronus.mores.mixin.client;

import mod.leronus.mores.access.PlayerRendererFeatureAccess;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin {

    private static final String YYZS_DETAILED =
            "com.yyz.yyzsbackpack.client.DetailedBackpackFeatureRenderer";
    private static final String YYZS_SIMPLIFIED =
            "com.yyz.yyzsbackpack.client.SimplifiedBackpackFeatureRenderer";

    @Inject(method = "render", at = @At("HEAD"))
    private void mores$stripYyzsBackpackFeaturesEveryRender(
            AbstractClientPlayerEntity player,
            float yaw,
            float tickDelta,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            CallbackInfo ci
    ) {
        List<?> features = PlayerRendererFeatureAccess.getFeaturesList(this);
        if (features == null || features.isEmpty()) return;

        features.removeIf(f -> {
            if (f == null) return false;
            String n = f.getClass().getName();
            return YYZS_DETAILED.equals(n) || YYZS_SIMPLIFIED.equals(n);
        });
    }
}
