package mod.leronus.mores.render;

import mod.leronus.mores.Mores;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public final class ShieldLikeRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {

    private ShieldEntityModel model; // lazy init

    private ShieldEntityModel getOrCreateModel() {
        if (model != null) return model;

        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.getEntityModelLoader() == null) return null;

        model = new ShieldEntityModel(client.getEntityModelLoader().getModelPart(EntityModelLayers.SHIELD));
        return model;
    }

    @Override
    public void render(ItemStack stack,
                       ModelTransformationMode mode,
                       MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers,
                       int light,
                       int overlay) {

        ShieldEntityModel shieldModel = getOrCreateModel();
        if (shieldModel == null) return;

        Identifier itemId = Registries.ITEM.getId(stack.getItem());
        Identifier baseTexture = Identifier.of(
                Mores.MOD_ID,
                "textures/entity/shield/" + itemId.getPath() + "_nopattern.png"
        );

        matrices.push();

        // Vanilla model-space flip for ShieldEntityModel in item rendering
        matrices.scale(1.0F, -1.0F, -1.0F);

        // 1) Base metal texture
        VertexConsumer baseVc = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(baseTexture));
        shieldModel.getPlate().render(matrices, baseVc, light, overlay);
        shieldModel.getHandle().render(matrices, baseVc, light, overlay);

        boolean glint = stack.hasGlint();

        // 2) Base dye color layer (plain banners rely on this)
        DyeColor baseColor = stack.get(DataComponentTypes.BASE_COLOR);
        if (baseColor != null) {
            SpriteIdentifier baseSprite = TexturedRenderLayers.SHIELD_BASE;
            VertexConsumer tintVc = baseSprite.getVertexConsumer(
                    vertexConsumers,
                    atlas -> TexturedRenderLayers.getShieldPatterns(),
                    glint
            );
            shieldModel.getPlate().render(matrices, tintVc, light, OverlayTexture.DEFAULT_UV, baseColor.getEntityColor());
        }

        // 3) Pattern layers
        BannerPatternsComponent patterns = stack.get(DataComponentTypes.BANNER_PATTERNS);
        if (patterns != null && !patterns.layers().isEmpty()) {
            for (BannerPatternsComponent.Layer layer : patterns.layers()) {
                SpriteIdentifier sprite = TexturedRenderLayers.getShieldPatternTextureId(layer.pattern());
                VertexConsumer patternVc = sprite.getVertexConsumer(
                        vertexConsumers,
                        atlas -> TexturedRenderLayers.getShieldPatterns(),
                        glint
                );
                shieldModel.getPlate().render(matrices, patternVc, light, OverlayTexture.DEFAULT_UV, layer.color().getEntityColor());
            }
        }

        matrices.pop();
    }
}
