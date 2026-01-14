package mod.leronus.mores;

import eu.midnightdust.lib.config.MidnightConfig;
import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.entity.ModEntities;
import mod.leronus.mores.render.HardenedSteelGolemRenderer;
import mod.leronus.mores.render.ShieldLikeRenderer;
import mod.leronus.mores.screen.AlloyFurnaceScreen;
import mod.leronus.mores.config.ClientConfig;
import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.registry.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.gui.screen.ingame.StonecutterScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MoresClient implements ClientModInitializer {
    private static boolean lastSent = false;
    @Override
    public void onInitializeClient() {
        MidnightConfig.init(Mores.MOD_ID, ClientConfig.class);
        VanillaTooltipHook.init();
        HandledScreens.register(ModScreenHandlers.ALLOY_FURNACE, AlloyFurnaceScreen::new);
        HandledScreens.register(ModScreenHandlers.STEEL_CUTTER, StonecutterScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STEEL_CUTTER, RenderLayer.getCutout());
        ShieldLikeRenderer shieldRenderer = new ShieldLikeRenderer();
        EntityRendererRegistry.register(
                ModEntities.HARDENED_STEEL_GOLEM,
                HardenedSteelGolemRenderer::new
        );
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
