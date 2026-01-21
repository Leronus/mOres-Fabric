package mod.leronus.mores.mixin.client;

import mod.leronus.mores.SpearsRenderState;
import net.minecraft.client.item.ClampedModelPredicateProvider;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = ModelPredicateProviderRegistry.class, priority =  2000)
public abstract class ModelPredicateProviderRegistryMixin {

    @Shadow
    private static ClampedModelPredicateProvider register(Identifier id, ClampedModelPredicateProvider provider) {
        return null;
    }

    static {
        // IMPORTANT: This must match your JSON key exactly: "spears:in_gui"
        register(Identifier.of("spears", "in_gui"),
                (stack, world, entity, seed) -> SpearsRenderState.isInGui() ? 0.0F : 1.0F
        );
    }
}
