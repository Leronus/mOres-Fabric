package mod.leronus.mores.mixin.client;

import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.slot.SlotEntryReference;
import io.wispforest.accessories.api.slot.SlotReference;
import io.wispforest.accessories.api.slot.SlotType;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.CapeFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Method;

@Mixin(CapeFeatureRenderer.class)
public abstract class CapeFeatureRendererMixin {

    // Change these if your slot keys differ in Accessories' container map
    private static final String BACK_SLOT = "back";
    private static final String CAPE_SLOT = "cape";

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void mores$hideCapeWhenBackOrCapeOccupied(MatrixStack matrices,
                                                      VertexConsumerProvider vertexConsumers,
                                                      int light,
                                                      AbstractClientPlayerEntity player,
                                                      float limbAngle,
                                                      float limbDistance,
                                                      float tickDelta,
                                                      float animationProgress,
                                                      float headYaw,
                                                      float headPitch,
                                                      CallbackInfo ci) {

        var cap = AccessoriesCapability.get(player);
        if (cap == null) return;

        // Fast path: if neither container exists, do nothing.
        // (This is safe because getContainers() is Map<String, AccessoriesContainer>)
        var containers = cap.getContainers();
        boolean hasBackContainer = containers != null && containers.containsKey(BACK_SLOT);
        boolean hasCapeContainer = containers != null && containers.containsKey(CAPE_SLOT);
        if (!hasBackContainer && !hasCapeContainer) return;

        for (SlotEntryReference entry : cap.getAllEquipped(true)) {
            if (entry == null) continue;

            // If stack is empty, ignore
            var stack = entry.stack();
            if (stack == null || stack.isEmpty()) continue;

            var ref = entry.reference();
            if (ref == null) continue;

            String slotName = tryGetSlotName(ref);
            if (slotName == null) continue;

            if (BACK_SLOT.equals(slotName) || CAPE_SLOT.equals(slotName)) {
                // Something is equipped in back/cape slot => hide vanilla cape
                ci.cancel();
                return;
            }
        }
    }

    /**
     * Tries hard to extract a stable "slot name" from SlotReference across Accessories versions.
     * This avoids you needing to know the exact method name on SlotReference.
     */
    private static String tryGetSlotName(SlotReference ref) {
        // 1) Common patterns: slotName(): String / slotId(): String
        String name = invokeString(ref, "slotName");
        if (name != null) return name;

        name = invokeString(ref, "slotId");
        if (name != null) return name;

        name = invokeString(ref, "name");
        if (name != null) return name;

        // 2) Patterns that return SlotType: slotType(): SlotType / slot(): SlotType / type(): SlotType
        SlotType type = invokeSlotType(ref, "slotType");
        if (type != null) return type.name();

        type = invokeSlotType(ref, "slot");
        if (type != null) return type.name();

        type = invokeSlotType(ref, "type");
        if (type != null) return type.name();

        // 3) Last resort: sometimes SlotReference has a SlotTypeReference with slotName()
        Object slotTypeRef = invokeObject(ref, "typeReference");
        if (slotTypeRef != null) {
            String viaRef = invokeString(slotTypeRef, "slotName");
            if (viaRef != null) return viaRef;
        }

        // If nothing worked, return null so we don’t break rendering.
        return null;
    }

    private static String invokeString(Object target, String methodName) {
        try {
            Method m = target.getClass().getMethod(methodName);
            Object out = m.invoke(target);
            return out instanceof String s ? s : null;
        } catch (Throwable ignored) {
            return null;
        }
    }

    private static SlotType invokeSlotType(Object target, String methodName) {
        try {
            Method m = target.getClass().getMethod(methodName);
            Object out = m.invoke(target);
            return out instanceof SlotType st ? st : null;
        } catch (Throwable ignored) {
            return null;
        }
    }

    private static Object invokeObject(Object target, String methodName) {
        try {
            Method m = target.getClass().getMethod(methodName);
            return m.invoke(target);
        } catch (Throwable ignored) {
            return null;
        }
    }
}
