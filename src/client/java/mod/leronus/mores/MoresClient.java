package mod.leronus.mores;

import eu.midnightdust.lib.config.MidnightConfig;
import mod.leronus.mores.client.VanillaTooltipHook;
import mod.leronus.mores.client.render.ShieldLikeRenderer;
import mod.leronus.mores.client.screen.AlloyFurnaceScreen;
import mod.leronus.mores.config.ClientConfig;
import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.registry.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.item.Item;

public class MoresClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MidnightConfig.init(Mores.MOD_ID, ClientConfig.class);
        VanillaTooltipHook.init();
        HandledScreens.register(ModScreenHandlers.ALLOY_FURNACE, AlloyFurnaceScreen::new);

        ShieldLikeRenderer shieldRenderer = new ShieldLikeRenderer();

        // Register all your shields in one place
        registerShield(shieldRenderer,
                ModItems.TIN_SHIELD,
                ModItems.SILVER_SHIELD,
                ModItems.COPPER_SHIELD,
                ModItems.STERLING_SILVER_SHIELD,
                ModItems.ROSE_GOLD_SHIELD,
                ModItems.BRONZE_SHIELD,
                ModItems.COBALT_SHIELD,
                ModItems.CARBON_STEEL_SHIELD,
                ModItems.HARDENED_STEEL_SHIELD,
                ModItems.TURQUOISE_SHIELD,
                ModItems.LAPIS_LAZULI_SHIELD,
                ModItems.AMETHYST_SHIELD,
                ModItems.CITRINE_SHIELD,
                ModItems.ONYX_SHIELD,
                ModItems.TANZANITE_SHIELD,
                ModItems.TOURMALINE_SHIELD,
                ModItems.TOPAZ_SHIELD,
                ModItems.EMERALD_SHIELD,
                ModItems.SPINEL_SHIELD,
                ModItems.RUBY_SHIELD,
                ModItems.SAPPHIRE_SHIELD,
                ModItems.MOISSANITE_SHIELD,
                ModItems.OBSIDIAN_SHIELD,
                ModItems.GRAPHENE_SHIELD,
                ModItems.ADAMANTIUM_SHIELD,
                ModItems.ENDERITE_SHIELD
        );
    }

    private static void registerShield(ShieldLikeRenderer renderer, Item... items) {
        for (Item item : items) {
            BuiltinItemRendererRegistry.INSTANCE.register(item, renderer);
        }
    }
}
