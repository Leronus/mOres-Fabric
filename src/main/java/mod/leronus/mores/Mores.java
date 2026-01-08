package mod.leronus.mores;

import com.notunanancyowen.spears.Spears;
import com.notunanancyowen.spears.components.*;
import eu.midnightdust.lib.config.MidnightConfig;
import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.handlers.ArmorBonusHandler;
import mod.leronus.mores.config.CommonConfig;
import mod.leronus.mores.item.ModItemGroups;
import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.loot.ModChestLootInjector;
import mod.leronus.mores.registry.ModRecipes;
import mod.leronus.mores.registry.ModBlockEntities;
import mod.leronus.mores.registry.ModScreenHandlers;
import mod.leronus.mores.sound.ModSounds;
import mod.leronus.mores.trade.ModArmorerTradesWeighted;
import mod.leronus.mores.trade.ModClericTradesWeighted;
import mod.leronus.mores.trade.ModToolsmithTradesWeighted;
import mod.leronus.mores.trade.ModWeaponsmithTradesWeighted;
import mod.leronus.mores.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static mod.leronus.mores.util.SpearSounds.vanillaSound;

public class Mores implements ModInitializer {
	public static final String MOD_ID = "mores";
    public static final Logger LOGGER = LoggerFactory.getLogger("mores");

	@Override
	public void onInitialize() {
        MidnightConfig.init(MOD_ID, CommonConfig.class);
        ArmorBonusHandler.init();
        ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
//		ModLootTableModifiers.modifyLootTables();
//		ModCustomTrades.registerCustomTrades();
		ModSounds.registerSounds();
        ModRecipes.registerRecipes();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

        ModArmorerTradesWeighted.register();
        ModClericTradesWeighted.register();
        ModToolsmithTradesWeighted.register();
        ModWeaponsmithTradesWeighted.register();

        ModChestLootInjector.register();

        //TODO Check anthracite
		FuelRegistry.INSTANCE.add(ModItems.ANTHRACITE, 4000);

		ModWorldGeneration.generateModWorldGen();


        DefaultItemComponentEvents.MODIFY.register(ctx -> {
            ctx.modify(
                    item -> item == ModItems.ROSE_GOLD_SPEAR,
                    (builder, item) -> {

                        // Movement + sprint behavior (fixes shield slowdown)
                        builder.add(Spears.USE_EFFECTS,
                                new UseEffects(1.0F, true, false)
                        );

                        // Stab animation
                        builder.add(Spears.SWING_ANIMATION,
                                new SwingAnimation(19, "stab")
                        );

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

                        // Reach
                        builder.add(Spears.ATTACK_RANGE,
                                new AttackRange(2.0F, 4.5F)
                        );

                        builder.add(Spears.MINIMUM_ATTACK_CHARGE, 1.0F);
                    }
            );
        });

	}
}