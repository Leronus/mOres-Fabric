package mod.leronus.mores.access;

import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;

import java.lang.reflect.Field;
import java.util.List;

public final class PlayerRendererFeatureAccess {
    private PlayerRendererFeatureAccess() {}

    public static List<?> getFeaturesList(Object renderer) {
        for (Field f : LivingEntityRenderer.class.getDeclaredFields()) {
            if (!List.class.isAssignableFrom(f.getType())) continue;

            try {
                f.setAccessible(true);
                Object v = f.get(renderer);
                if (!(v instanceof List<?> list)) continue;

                // Feature list is either empty or contains FeatureRenderer objects
                if (list.isEmpty() || list.get(0) instanceof FeatureRenderer) {
                    return list;
                }
            } catch (Throwable ignored) {}
        }
        return null;
    }
}
