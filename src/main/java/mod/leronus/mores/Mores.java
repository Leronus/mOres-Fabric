package mod.leronus.mores;

import com.notunanancyowen.spears.Spears;
import com.notunanancyowen.spears.components.*;
import eu.midnightdust.lib.config.MidnightConfig;
import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.entity.ModEntities;
import mod.leronus.mores.entity.ModGolemEntity;
import mod.leronus.mores.handlers.ModArmorBonuses;
import mod.leronus.mores.config.CommonConfig;
import mod.leronus.mores.item.ModItemGroups;
import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.loot.ModChestLootInjector;
import mod.leronus.mores.network.ModNetworking;
import mod.leronus.mores.registry.ModCustomTrades;
import mod.leronus.mores.registry.ModRecipes;
import mod.leronus.mores.registry.ModBlockEntities;
import mod.leronus.mores.registry.ModScreenHandlers;
import mod.leronus.mores.sound.ModSounds;
import mod.leronus.mores.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

import static mod.leronus.mores.util.SpearSounds.vanillaSound;

public class Mores implements ModInitializer {
	public static final String MOD_ID = "mores";
    public static final Logger LOGGER = LoggerFactory.getLogger("mores");

	@Override
	public void onInitialize() {
        MidnightConfig.init(MOD_ID, CommonConfig.class);
        ModArmorBonuses.registerArmorBonuses();
        ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
//		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();
		ModSounds.registerSounds();
        ModRecipes.registerRecipes();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
        ModNetworking.registerServerReceivers();


        ModChestLootInjector.register();

        //TODO Check anthracite
		FuelRegistry.INSTANCE.add(ModItems.ANTHRACITE, 4000);

		ModWorldGeneration.generateModWorldGen();

        //Register Golem Attributes
        FabricDefaultAttributeRegistry.register(
                ModEntities.HARDENED_STEEL_GOLEM,
                ModGolemEntity.createHardenedSteelGolemAttributes()
        );

        //Register Spear Attributes
         final Set<Item> SPEARS_WITH_SHARED_ATTRS = Set.of(
                ModItems.ROSE_GOLD_SPEAR,
                ModItems.CARBON_STEEL_SPEAR,
                ModItems.HARDENED_STEEL_SPEAR,
                ModItems.ENDERITE_SPEAR
        );

        DefaultItemComponentEvents.MODIFY.register(ctx -> {
            ctx.modify(
                    SPEARS_WITH_SHARED_ATTRS::contains,
                    (builder, item) -> {
                        builder.add(Spears.USE_EFFECTS, new UseEffects(1.0F, true, false));
                        builder.add(Spears.SWING_ANIMATION, new SwingAnimation(19, "stab"));

                        builder.add(Spears.PIERCING_WEAPON, new PiercingWeapon(
                                0.25F, true, false,
                                vanillaSound("item.spear.attack"),
                                vanillaSound("item.spear.hit")
                        ));

                        builder.add(Spears.KINETIC_WEAPON, new KineticWeapon(
                                0.125F, 10, 12,
                                KineticWeapon.Condition.ofMinSpeed(50, 8.0F),
                                KineticWeapon.Condition.ofMinSpeed(90, 5.1F),
                                KineticWeapon.Condition.ofMinRelativeSpeed(225, 4.6F),
                                0.38F, 0.95F,
                                vanillaSound("item.spear.use"),
                                vanillaSound("item.spear.hit")
                        ));

                        builder.add(Spears.ATTACK_RANGE, new AttackRange(2.0F, 4.5F));
                        builder.add(Spears.MINIMUM_ATTACK_CHARGE, 1.0F);
                    }
            );
        });


	}
}