package mod.leronus.mores;

import eu.midnightdust.lib.config.MidnightConfig;
import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.handlers.ArmorBonusHandler;
import mod.leronus.mores.config.CommonConfig;
import mod.leronus.mores.item.ModItemGroups;
import mod.leronus.mores.item.ModItems;
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
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

        //TODO Check anthracite
		FuelRegistry.INSTANCE.add(ModItems.ANTHRACITE, 4000);

		ModWorldGeneration.generateModWorldGen();
	}
}