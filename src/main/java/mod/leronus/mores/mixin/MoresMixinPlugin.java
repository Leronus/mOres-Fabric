package mod.leronus.mores.mixin;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MoresMixinPlugin implements IMixinConfigPlugin {

    @Override public void onLoad(String mixinPackage) {}

    @Override public String getRefMapperConfig() { return null; }

    @Override public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        // Gate anything that touches DetailAB
        if (mixinClassName.endsWith("MultiArmorBarMixin")) {
            return isModLoaded("detailabreconst");
        }
        // Only gate THIS mixin
        if (mixinClassName.endsWith("CapeFeatureRendererMixin")) {
            return isModLoaded("accessories");
        }
        return true;
    }

    private static boolean isModLoaded(String modId) {
        try {
            // Don't hard-link FabricLoader, keep it safe
            Class<?> fl = Class.forName("net.fabricmc.loader.api.FabricLoader");
            Object instance = fl.getMethod("getInstance").invoke(null);
            return (boolean) fl.getMethod("isModLoaded", String.class).invoke(instance, modId);
        } catch (Throwable t) {
            return false;
        }
    }

    @Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override public List<String> getMixins() { return null; }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {}

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {}
}
