package mod.leronus.mores;

import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldSetModelCallback;
import mod.leronus.mores.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ShieldItem;

import static com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient.renderBanner;

public class MoresClient implements ClientModInitializer {
    public static final ModelLayerLocation tin_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "tin_shield"),"main");
    public static final ModelLayerLocation copper_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "copper_shield"),"main");
    public static final ModelLayerLocation bronze_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "bronze_shield"),"main");
    public static final ModelLayerLocation silver_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "silver_shield"),"main");
    public static final ModelLayerLocation cobalt_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "cobalt_shield"),"main");
    public static final ModelLayerLocation sterling_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "sterling_shield"),"main");
    public static final ModelLayerLocation steel_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "steel_shield"),"main");
    public static final ModelLayerLocation amethyst_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "amethyst_shield"),"main");
    public static final ModelLayerLocation emerald_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "emerald_shield"),"main");

    public static final ModelLayerLocation topaz_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "topaz_shield"),"main");
    public static final ModelLayerLocation tourmaline_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "tourmaline_shield"),"main");
    public static final ModelLayerLocation tanzanite_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "tanzanite_shield"),"main");
    public static final ModelLayerLocation ruby_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "ruby_shield"),"main");
    public static final ModelLayerLocation sapphire_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "sapphire_shield"),"main");
    public static final ModelLayerLocation moissanite_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "moissanite_shield"),"main");
    public static final ModelLayerLocation obsidian_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "obsidian_shield"),"main");
    public static final ModelLayerLocation turquoise_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "turquoise_shield"),"main");
    public static final ModelLayerLocation onyx_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "onyx_shield"),"main");
    public static final ModelLayerLocation graphene_shield_model_layer = new ModelLayerLocation(new ResourceLocation("mores", "graphene_shield"),"main");

    public static ShieldModel modelTinShield;
    public static ShieldModel modelCopperShield;
    public static ShieldModel modelBronzeShield;
    public static ShieldModel modelSilverShield;
    public static ShieldModel modelCobaltShield;
    public static ShieldModel modelSterlingShield;
    public static ShieldModel modelSteelShield;
    public static ShieldModel modelAmethystShield;
    public static ShieldModel modelEmeraldShield;

    public static ShieldModel modelTopazShield;
    public static ShieldModel modelTourmalineShield;
    public static ShieldModel modelTanzaniteShield;
    public static ShieldModel modelRubyShield;
    public static ShieldModel modelSapphireShield;
    public static ShieldModel modelMoissaniteShield;
    public static ShieldModel modelObsidianShield;
    public static ShieldModel modelTurquoiseShield;
    public static ShieldModel modelOnyxShield;
    public static ShieldModel modelGrapheneShield;

    public static final Material LOCATION_COPPER_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/copper_shield"));
    public static final Material LOCATION_COPPER_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/copper_shield_nopattern"));

    public static final Material LOCATION_TIN_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/tin_shield"));
    public static final Material LOCATION_TIN_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/tin_shield_nopattern"));

    public static final Material LOCATION_SILVER_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/silver_shield"));
    public static final Material LOCATION_SILVER_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/silver_shield_nopattern"));

    public static final Material LOCATION_BRONZE_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/bronze_shield"));
    public static final Material LOCATION_BRONZE_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/bronze_shield_nopattern"));

    public static final Material LOCATION_COBALT_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/cobalt_shield"));
    public static final Material LOCATION_COBALT_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/cobalt_shield_nopattern"));

    public static final Material LOCATION_OBSIDIAN_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/obsidian_shield"));
    public static final Material LOCATION_OBSIDIAN_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/obsidian_shield_nopattern"));

    public static final Material LOCATION_STERLING_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/sterling_shield"));
    public static final Material LOCATION_STERLING_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/sterling_shield_nopattern"));

    public static final Material LOCATION_STEEL_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/steel_shield"));
    public static final Material LOCATION_STEEL_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/steel_shield_nopattern"));

    public static final Material LOCATION_AMETHYST_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/amethyst_shield"));
    public static final Material LOCATION_AMETHYST_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/amethyst_shield_nopattern"));

    public static final Material LOCATION_EMERALD_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/emerald_shield"));
    public static final Material LOCATION_EMERALD_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/emerald_shield_nopattern"));

    public static final Material LOCATION_TOPAZ_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/topaz_shield"));
    public static final Material LOCATION_TOPAZ_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/topaz_shield_nopattern"));

    public static final Material LOCATION_TOURMALINE_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/tourmaline_shield"));
    public static final Material LOCATION_TOURMALINE_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/tourmaline_shield_nopattern"));

    public static final Material LOCATION_TANZANITE_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/tanzanite_shield"));
    public static final Material LOCATION_TANZANITE_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/tanzanite_shield_nopattern"));

    public static final Material LOCATION_RUBY_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/ruby_shield"));
    public static final Material LOCATION_RUBY_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/ruby_shield_nopattern"));

    public static final Material LOCATION_SAPPHIRE_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/sapphire_shield"));
    public static final Material LOCATION_SAPPHIRE_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/sapphire_shield_nopattern"));

    public static final Material LOCATION_MOISSANITE_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/moissanite_shield"));
    public static final Material LOCATION_MOISSANITE_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/moissanite_shield_nopattern"));

    public static final Material LOCATION_ONYX_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/onyx_shield"));
    public static final Material LOCATION_ONYX_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/onyx_shield_nopattern"));

    public static final Material LOCATION_GRAPHENE_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/graphene_shield"));
    public static final Material LOCATION_GRAPHENE_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/graphene_shield_nopattern"));

    public static final Material LOCATION_TURQUOISE_SHIELD_BASE = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/turquoise_shield"));
    public static final Material LOCATION_TURQUOISE_SHIELD_BASE_NOPATTERN = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("mores", "entity/turquoise_shield_nopattern"));

    @Override
    public void onInitializeClient() {
//        HandledScreens.register(ModScreenHandlers.ALLOY_FURNACE_SCREEN_HANDLER, AlloyFurnaceScreen::new);

//        BlockEntityRendererFactories.register(ModBlockEntities.ALLOY_FURNACE_BLOCK_ENTITY, AlloyFurnaceBlockEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(tin_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(copper_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(bronze_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(silver_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(cobalt_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(sterling_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(steel_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(amethyst_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(emerald_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(topaz_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(tourmaline_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(tanzanite_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(ruby_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(sapphire_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(moissanite_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(obsidian_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(turquoise_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(onyx_shield_model_layer, ShieldModel::createLayer);
        EntityModelLayerRegistry.registerModelLayer(graphene_shield_model_layer, ShieldModel::createLayer);

        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelTinShield = new ShieldModel(loader.bakeLayer(tin_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelCopperShield = new ShieldModel(loader.bakeLayer(copper_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelBronzeShield = new ShieldModel(loader.bakeLayer(bronze_shield_model_layer));
            return InteractionResult.PASS;
        });        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelSilverShield = new ShieldModel(loader.bakeLayer(silver_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelCobaltShield = new ShieldModel(loader.bakeLayer(cobalt_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelSterlingShield = new ShieldModel(loader.bakeLayer(sterling_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelSteelShield = new ShieldModel(loader.bakeLayer(steel_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelAmethystShield = new ShieldModel(loader.bakeLayer(amethyst_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelEmeraldShield = new ShieldModel(loader.bakeLayer(emerald_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelTopazShield = new ShieldModel(loader.bakeLayer(topaz_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelTourmalineShield = new ShieldModel(loader.bakeLayer(tourmaline_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelTanzaniteShield = new ShieldModel(loader.bakeLayer(tanzanite_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelRubyShield = new ShieldModel(loader.bakeLayer(ruby_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelSapphireShield = new ShieldModel(loader.bakeLayer(sapphire_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelMoissaniteShield = new ShieldModel(loader.bakeLayer(moissanite_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelObsidianShield = new ShieldModel(loader.bakeLayer(obsidian_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelTurquoiseShield = new ShieldModel(loader.bakeLayer(turquoise_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelOnyxShield = new ShieldModel(loader.bakeLayer(onyx_shield_model_layer));
            return InteractionResult.PASS;
        });
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelGrapheneShield = new ShieldModel(loader.bakeLayer(graphene_shield_model_layer));
            return InteractionResult.PASS;
        });

        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.TIN_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelTinShield, LOCATION_TIN_SHIELD_BASE, LOCATION_TIN_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });

        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.COPPER_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelCopperShield, LOCATION_COPPER_SHIELD_BASE, LOCATION_COPPER_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.BRONZE_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelBronzeShield, LOCATION_BRONZE_SHIELD_BASE, LOCATION_BRONZE_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.SILVER_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelSilverShield, LOCATION_SILVER_SHIELD_BASE, LOCATION_SILVER_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.COBALT_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelCobaltShield, LOCATION_COBALT_SHIELD_BASE, LOCATION_COBALT_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.STERLING_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelSterlingShield, LOCATION_STERLING_SHIELD_BASE, LOCATION_STERLING_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.STEEL_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelSteelShield, LOCATION_STEEL_SHIELD_BASE, LOCATION_STEEL_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.AMETHYST_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelAmethystShield, LOCATION_AMETHYST_SHIELD_BASE, LOCATION_AMETHYST_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.EMERALD_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelEmeraldShield, LOCATION_EMERALD_SHIELD_BASE, LOCATION_EMERALD_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.TOPAZ_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelTopazShield, LOCATION_TOPAZ_SHIELD_BASE, LOCATION_TOPAZ_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.TOURMALINE_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelTourmalineShield, LOCATION_TOURMALINE_SHIELD_BASE, LOCATION_TOURMALINE_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.TANZANITE_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelTanzaniteShield, LOCATION_TANZANITE_SHIELD_BASE, LOCATION_TANZANITE_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.RUBY_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelRubyShield, LOCATION_RUBY_SHIELD_BASE, LOCATION_RUBY_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.SAPPHIRE_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelSapphireShield, LOCATION_SAPPHIRE_SHIELD_BASE, LOCATION_SAPPHIRE_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.MOISSANITE_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelMoissaniteShield, LOCATION_MOISSANITE_SHIELD_BASE, LOCATION_MOISSANITE_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.OBSIDIAN_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelObsidianShield, LOCATION_OBSIDIAN_SHIELD_BASE, LOCATION_OBSIDIAN_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.TURQUOISE_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelTurquoiseShield, LOCATION_TURQUOISE_SHIELD_BASE, LOCATION_TURQUOISE_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.ONYX_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelOnyxShield, LOCATION_ONYX_SHIELD_BASE, LOCATION_ONYX_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.GRAPHENE_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelGrapheneShield, LOCATION_GRAPHENE_SHIELD_BASE, LOCATION_GRAPHENE_SHIELD_BASE_NOPATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
    }
}