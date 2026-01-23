package mod.leronus.mores.render;

import mod.leronus.mores.Mores;
import mod.leronus.mores.entity.ModDuckEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class DuckRenderer extends MobEntityRenderer<ModDuckEntity, DuckEntityModel<ModDuckEntity>> {

    private static final Identifier TEXTURE =
            Identifier.of(Mores.MOD_ID, "textures/entity/duck/duck_entity_model.png");

    public DuckRenderer(EntityRendererFactory.Context context) {
        super(context, new DuckEntityModel<>(context.getPart(EntityModelLayers.CHICKEN)), 0.3F);
    }
    @Override
    protected float getAnimationProgress(ModDuckEntity duck, float tickDelta) {
        // interpolate the same fields chicken uses
        float flap = MathHelper.lerp(tickDelta, duck.prevFlapProgress, duck.flapProgress);
        float deviation = MathHelper.lerp(tickDelta, duck.prevMaxWingDeviation, duck.maxWingDeviation);

        // THIS is the important part: convert flap progress into an oscillating roll angle
        return MathHelper.sin(flap) * deviation;
    }

    @Override
    public Identifier getTexture(ModDuckEntity entity) {
        return TEXTURE;
    }
}
