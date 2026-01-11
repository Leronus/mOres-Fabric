package mod.leronus.mores.render;

import mod.leronus.mores.Mores;
import mod.leronus.mores.entity.ModGolemEntity;
import net.minecraft.client.render.entity.IronGolemEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.Identifier;

public class HardenedSteelGolemRenderer extends IronGolemEntityRenderer {

    private static final Identifier TEXTURE =
            Identifier.of(Mores.MOD_ID, "textures/entity/golem/hardened_steel_golem.png");

    public HardenedSteelGolemRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(IronGolemEntity entity) {
        return TEXTURE;
    }
}
