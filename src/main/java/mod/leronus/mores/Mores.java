package mod.leronus.mores;

import com.notunanancyowen.spears.Spears;
import com.notunanancyowen.spears.components.*;
import eu.midnightdust.lib.config.MidnightConfig;
import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.entity.ModDuckEntity;
import mod.leronus.mores.entity.ModEntities;
import mod.leronus.mores.entity.ModGolemEntity;
import mod.leronus.mores.handlers.ModArmorBonusHandler;
import mod.leronus.mores.config.CommonConfig;
import mod.leronus.mores.handlers.ModShearableAnimalArmorHandler;
import mod.leronus.mores.item.ModItemGroups;
import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.loot.ModChestLootInjector;
import mod.leronus.mores.network.ModNetworking;
import mod.leronus.mores.registry.ModFuels;
import mod.leronus.mores.registry.ModRecipes;
import mod.leronus.mores.registry.ModBlockEntities;
import mod.leronus.mores.registry.ModScreenHandlers;
import mod.leronus.mores.sound.ModSounds;
import mod.leronus.mores.trade.ModTradeOverride;
import mod.leronus.mores.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

import static mod.leronus.mores.util.SpearSounds.vanillaSound;

public class Mores implements ModInitializer {
	public static final String MOD_ID = "mores";
    public static final Logger LOGGER = LoggerFactory.getLogger("mores");

	@Override
	public void onInitialize() {
        MidnightConfig.init(MOD_ID, CommonConfig.class);
        ModArmorBonusHandler.registerArmorBonuses();
        ModEntities.registerEntities();
        ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModTradeOverride.registerCustomTrades();
		ModSounds.registerSounds();
        ModRecipes.registerRecipes();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
        ModNetworking.registerServerReceivers();
        ModShearableAnimalArmorHandler.register();
        ModChestLootInjector.register();
        ModFuels.register();
		ModWorldGeneration.generateModWorldGen();

        //Register Golem Attributes
        FabricDefaultAttributeRegistry.register(
                ModEntities.HARDENED_STEEL_GOLEM,
                ModGolemEntity.createHardenedSteelGolemAttributes()
        );
        //Register Duck Attributes
        FabricDefaultAttributeRegistry.register(
                ModEntities.DUCK,
                ModDuckEntity.createDuckAttributes()
        );

        // Register Spear Attributes (only if the Spears mod is loaded)
        if (FabricLoader.getInstance().isModLoaded("spears")) {
            // Use a mutable set so we can safely add only what exists
            final Set<Item> SPEARS_WITH_SHARED_ATTRS = new HashSet<>();
            if (ModItems.ROSE_GOLD_SPEAR != null) SPEARS_WITH_SHARED_ATTRS.add(ModItems.ROSE_GOLD_SPEAR);
            if (ModItems.CARBON_STEEL_SPEAR != null) SPEARS_WITH_SHARED_ATTRS.add(ModItems.CARBON_STEEL_SPEAR);
            if (ModItems.HARDENED_STEEL_SPEAR != null) SPEARS_WITH_SHARED_ATTRS.add(ModItems.HARDENED_STEEL_SPEAR);
            if (ModItems.ENDERITE_SPEAR != null) SPEARS_WITH_SHARED_ATTRS.add(ModItems.ENDERITE_SPEAR);
            SPEARS_WITH_SHARED_ATTRS.add(Spears.WOODEN_SPEAR);
            SPEARS_WITH_SHARED_ATTRS.add(Spears.STONE_SPEAR);
            SPEARS_WITH_SHARED_ATTRS.add(Spears.IRON_SPEAR);
            SPEARS_WITH_SHARED_ATTRS.add(Spears.GOLDEN_SPEAR);
            SPEARS_WITH_SHARED_ATTRS.add(Spears.DIAMOND_SPEAR);
            SPEARS_WITH_SHARED_ATTRS.add(Spears.NETHERITE_SPEAR);

            registerSpearAttributes(SPEARS_WITH_SHARED_ATTRS);
        }
	}

    private static void registerSpearAttributes(Set<Item> SPEARS_WITH_SHARED_ATTRS) {
        DefaultItemComponentEvents.MODIFY.register(ctx -> {
            ctx.modify(
                    SPEARS_WITH_SHARED_ATTRS::contains,
                    (builder, item) -> {
                        // Everything below references Spears API classes,
                        // so it MUST stay inside the isModLoaded guard.

                        builder.add(Spears.USE_EFFECTS,
                                new UseEffects(1.0F, true, false));

                        builder.add(Spears.SWING_ANIMATION,
                                new SwingAnimation(19, "stab"));

                        builder.add(Spears.PIERCING_WEAPON,
                                new PiercingWeapon(
                                        0.25F, true, false,
                                        vanillaSound("item.spear.attack"),
                                        vanillaSound("item.spear.hit")
                                ));

                        builder.add(Spears.KINETIC_WEAPON,
                                new KineticWeapon(
                                        0.125F, 10, 12,
                                        KineticWeapon.Condition.ofMinSpeed(50, 8.0F),
                                        KineticWeapon.Condition.ofMinSpeed(90, 5.1F),
                                        KineticWeapon.Condition.ofMinRelativeSpeed(225, 4.6F),
                                        0.38F, 0.95F,
                                        vanillaSound("item.spear.use"),
                                        vanillaSound("item.spear.hit")
                                ));

                        builder.add(Spears.ATTACK_RANGE,
                                new AttackRange(1.5F, 4.25F));

                        builder.add(Spears.MINIMUM_ATTACK_CHARGE, 0.75F);
                    }
            );
        });
    }
}