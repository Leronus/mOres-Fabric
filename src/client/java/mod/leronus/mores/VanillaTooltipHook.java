package mod.leronus.mores;

import mod.leronus.mores.handlers.ModTooltipHandler;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

public final class VanillaTooltipHook {
    private VanillaTooltipHook() {}

    public static void init() {
        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
            Item item = stack.getItem();

            // Prevent duplicate tooltips: your mod items already call TooltipHandler in appendTooltip
            String namespace = Registries.ITEM.getId(item).getNamespace();
            if ("mores".equals(namespace)) return;

            ModTooltipHandler.appendCombatTooltips(stack, lines, type);
        });
    }
}
