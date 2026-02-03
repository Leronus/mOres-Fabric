package mod.leronus.mores;


import com.redlimerl.detailab.api.DetailArmorBarAPI;
import com.redlimerl.detailab.api.render.ArmorBarRenderManager;
import com.redlimerl.detailab.api.render.TextureOffset;
import eu.midnightdust.lib.config.MidnightConfig;
import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.entity.ModEntities;
import mod.leronus.mores.render.DuckRenderer;
import mod.leronus.mores.render.HardenedSteelGolemRenderer;
import mod.leronus.mores.render.ShieldLikeRenderer;
import mod.leronus.mores.screen.AlloyFurnaceScreen;
import mod.leronus.mores.config.ClientConfig;
import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.registry.ModScreenHandlers;
import mod.leronus.mores.screen.SteelCutterScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class MoresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MidnightConfig.init(Mores.MOD_ID, ClientConfig.class);
        VanillaTooltipHook.init();
        HandledScreens.register(ModScreenHandlers.ALLOY_FURNACE, AlloyFurnaceScreen::new);
        HandledScreens.register(ModScreenHandlers.STEEL_CUTTER, SteelCutterScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STEEL_CUTTER, RenderLayer.getCutout());
        ShieldLikeRenderer shieldRenderer = new ShieldLikeRenderer();
        EntityRendererRegistry.register(
                ModEntities.HARDENED_STEEL_GOLEM,
                HardenedSteelGolemRenderer::new
        );
        EntityRendererRegistry.register(
                ModEntities.DUCK,
                DuckRenderer::new
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
//                ModItems.GRAPHENE_SHIELD,
                ModItems.ADAMANTIUM_SHIELD,
                ModItems.ENDERITE_SHIELD
        );

        // Leaves need cutoutMipped for correct transparency + mipmapping
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEMON_OAK_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEMON_OAK_SAPLING, RenderLayer.getCutout());

        // Biome foliage tint for the block in-world
        ColorProviderRegistry.BLOCK.register(
                (state, world, pos, tintIndex) ->
                        (world != null && pos != null) ? BiomeColors.getFoliageColor(world, pos) : 0x48B518,
                ModBlocks.LEMON_OAK_LEAVES
        );

        // Inventory tint (uses a default foliage color, like vanilla)
        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) -> 0x48B518,
                ModBlocks.LEMON_OAK_LEAVES.asItem()
        );
//        // Register Detail Armor Bar Textures (only if the mod is loaded)
        if (FabricLoader.getInstance().isModLoaded("detailabreconst")) {
            Mores.LOGGER.info("DetailAB loaded");
            Identifier tinTexture = Identifier.of(Mores.MOD_ID, "textures/ab/tin_sheet.png");
            Identifier silverTexture = Identifier.of(Mores.MOD_ID, "textures/ab/silver_sheet.png");
            Identifier bronzeTexture = Identifier.of(Mores.MOD_ID, "textures/ab/bronze_sheet.png");
            Identifier sterlingSilverTexture = Identifier.of(Mores.MOD_ID, "textures/ab/sterling_silver_sheet.png");
            Identifier roseGoldTexture = Identifier.of(Mores.MOD_ID, "textures/ab/rose_gold_sheet.png");
            Identifier carbonSteelTexture = Identifier.of(Mores.MOD_ID, "textures/ab/carbon_steel_sheet.png");
            Identifier cobaltTexture = Identifier.of(Mores.MOD_ID, "textures/ab/cobalt_sheet.png");
            Identifier amethystTexture = Identifier.of(Mores.MOD_ID, "textures/ab/amethyst_sheet.png");
            Identifier turquoiseTexture = Identifier.of(Mores.MOD_ID, "textures/ab/turquoise_sheet.png");
            Identifier lapisLazuliTexture = Identifier.of(Mores.MOD_ID, "textures/ab/lapis_lazuli_sheet.png");
            Identifier citrineTexture = Identifier.of(Mores.MOD_ID, "textures/ab/citrine_sheet.png");
            Identifier onyxTexture = Identifier.of(Mores.MOD_ID, "textures/ab/onyx_sheet.png");
            Identifier topazTexture = Identifier.of(Mores.MOD_ID, "textures/ab/topaz_sheet.png");
            Identifier tourmalineTexture = Identifier.of(Mores.MOD_ID, "textures/ab/tourmaline_sheet.png");
            Identifier tanzaniteTexture = Identifier.of(Mores.MOD_ID, "textures/ab/tanzanite_sheet.png");
            Identifier emeraldTexture = Identifier.of(Mores.MOD_ID, "textures/ab/emerald_sheet.png");
            Identifier spinelTexture = Identifier.of(Mores.MOD_ID, "textures/ab/spinel_sheet.png");
            Identifier rubyTexture = Identifier.of(Mores.MOD_ID, "textures/ab/ruby_sheet.png");
            Identifier sapphireTexture = Identifier.of(Mores.MOD_ID, "textures/ab/sapphire_sheet.png");
            Identifier moissaniteTexture = Identifier.of(Mores.MOD_ID, "textures/ab/moissanite_sheet.png");
            Identifier adamantiumTexture = Identifier.of(Mores.MOD_ID, "textures/ab/adamantium_sheet.png");
            Identifier obsidianTexture = Identifier.of(Mores.MOD_ID, "textures/ab/obsidian_sheet.png");
            Identifier hardenedSteelTexture = Identifier.of(Mores.MOD_ID, "textures/ab/hardened_steel_sheet.png");
            Identifier enderiteTexture = Identifier.of(Mores.MOD_ID, "textures/ab/enderite_sheet.png");

            TextureOffset full     = new TextureOffset(0, 0);
            TextureOffset half     = new TextureOffset(18, 0);
            TextureOffset outline  = new TextureOffset(9, 0);
            TextureOffset outlineHalf = new TextureOffset(27, 0);

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.TIN_HELMET, ModItems.TIN_CHESTPLATE,
                            ModItems.TIN_LEGGINGS, ModItems.TIN_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            tinTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.SILVER_HELMET, ModItems.SILVER_CHESTPLATE,
                            ModItems.SILVER_LEGGINGS, ModItems.SILVER_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            silverTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.BRONZE_HELMET, ModItems.BRONZE_CHESTPLATE,
                            ModItems.BRONZE_LEGGINGS, ModItems.BRONZE_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            bronzeTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.STERLING_SILVER_HELMET, ModItems.STERLING_SILVER_CHESTPLATE,
                            ModItems.STERLING_SILVER_LEGGINGS, ModItems.STERLING_SILVER_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            sterlingSilverTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.ROSE_GOLD_HELMET, ModItems.ROSE_GOLD_CHESTPLATE,
                            ModItems.ROSE_GOLD_LEGGINGS, ModItems.ROSE_GOLD_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            roseGoldTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.CARBON_STEEL_HELMET, ModItems.CARBON_STEEL_CHESTPLATE,
                            ModItems.CARBON_STEEL_LEGGINGS, ModItems.CARBON_STEEL_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            carbonSteelTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.COBALT_HELMET, ModItems.COBALT_CHESTPLATE,
                            ModItems.COBALT_LEGGINGS, ModItems.COBALT_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            cobaltTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.AMETHYST_HELMET, ModItems.AMETHYST_CHESTPLATE,
                            ModItems.AMETHYST_LEGGINGS, ModItems.AMETHYST_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            amethystTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.CITRINE_HELMET, ModItems.CITRINE_CHESTPLATE,
                            ModItems.CITRINE_LEGGINGS, ModItems.CITRINE_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            citrineTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.TURQUOISE_HELMET, ModItems.TURQUOISE_CHESTPLATE,
                            ModItems.TURQUOISE_LEGGINGS, ModItems.TURQUOISE_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            turquoiseTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.LAPIS_LAZULI_HELMET, ModItems.LAPIS_LAZULI_CHESTPLATE,
                            ModItems.LAPIS_LAZULI_LEGGINGS, ModItems.LAPIS_LAZULI_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            lapisLazuliTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.ONYX_HELMET, ModItems.ONYX_CHESTPLATE,
                            ModItems.ONYX_LEGGINGS, ModItems.ONYX_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            onyxTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.TANZANITE_HELMET, ModItems.TANZANITE_CHESTPLATE,
                            ModItems.TANZANITE_LEGGINGS, ModItems.TANZANITE_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            tanzaniteTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.TOPAZ_HELMET, ModItems.TOPAZ_CHESTPLATE,
                            ModItems.TOPAZ_LEGGINGS, ModItems.TOPAZ_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            topazTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.TOURMALINE_HELMET, ModItems.TOURMALINE_CHESTPLATE,
                            ModItems.TOURMALINE_LEGGINGS, ModItems.TOURMALINE_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            tourmalineTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.SPINEL_HELMET, ModItems.SPINEL_CHESTPLATE,
                            ModItems.SPINEL_LEGGINGS, ModItems.SPINEL_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            spinelTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.EMERALD_HELMET, ModItems.EMERALD_CHESTPLATE,
                            ModItems.EMERALD_LEGGINGS, ModItems.EMERALD_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            emeraldTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();


            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.RUBY_HELMET, ModItems.RUBY_CHESTPLATE,
                            ModItems.RUBY_LEGGINGS, ModItems.RUBY_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            rubyTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.SAPPHIRE_HELMET, ModItems.SAPPHIRE_CHESTPLATE,
                            ModItems.SAPPHIRE_LEGGINGS, ModItems.SAPPHIRE_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            sapphireTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.MOISSANITE_HELMET, ModItems.MOISSANITE_CHESTPLATE,
                            ModItems.MOISSANITE_LEGGINGS, ModItems.MOISSANITE_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            moissaniteTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.OBSIDIAN_HELMET, ModItems.OBSIDIAN_CHESTPLATE,
                            ModItems.OBSIDIAN_LEGGINGS, ModItems.OBSIDIAN_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            obsidianTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.ADAMANTIUM_HELMET, ModItems.ADAMANTIUM_CHESTPLATE,
                            ModItems.ADAMANTIUM_LEGGINGS, ModItems.ADAMANTIUM_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            adamantiumTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.HARDENED_STEEL_HELMET, ModItems.HARDENED_STEEL_CHESTPLATE,
                            ModItems.HARDENED_STEEL_LEGGINGS, ModItems.HARDENED_STEEL_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            hardenedSteelTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();

            DetailArmorBarAPI.customArmorBarBuilder()
                    .armor(ModItems.ENDERITE_HELMET, ModItems.ENDERITE_CHESTPLATE,
                            ModItems.ENDERITE_LEGGINGS, ModItems.ENDERITE_BOOTS)
                    .render(stack -> new ArmorBarRenderManager(
                            enderiteTexture,
                            36, 9,
                            full,
                            half,
                            outline,
                            outlineHalf
                    ))
                    .register();
        }
    }

    private static void registerShield(ShieldLikeRenderer renderer, Item... items) {
        for (Item item : items) {
            BuiltinItemRendererRegistry.INSTANCE.register(item, renderer);
        }
    }
}
