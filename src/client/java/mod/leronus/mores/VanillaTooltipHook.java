package mod.leronus.mores;

import mod.leronus.mores.handlers.ModTooltipHandler;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;

public final class VanillaTooltipHook {
    private VanillaTooltipHook() {}

    public static void init() {
        // Run for ALL items (vanilla + mores). The handler will de-duplicate and re-order.
        ItemTooltipCallback.EVENT.register((stack, context, type, lines) -> {
            ModTooltipHandler.appendCombatTooltips(stack, lines, type);
        });
    }
}
