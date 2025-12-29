package mod.leronus.mores;

import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.item.ModItemGroups;
import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.recipe.ModRecipeTypes;
import mod.leronus.mores.registry.ModBlockEntities;
import mod.leronus.mores.registry.ModScreenHandlers;
import mod.leronus.mores.sound.ModSounds;
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
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
//		ModLootTableModifiers.modifyLootTables();
//		ModCustomTrades.registerCustomTrades();
		ModSounds.registerSounds();
        ModRecipeTypes.registerRecipes();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

        //TODO Check anthracite
		FuelRegistry.INSTANCE.add(ModItems.ANTHRACITE, 4000);

		ModWorldGeneration.generateModWorldGen();
	}
}