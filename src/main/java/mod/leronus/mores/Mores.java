package mod.leronus.mores;

import mod.leronus.mores.blocks.ModBlocks;
import mod.leronus.mores.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mores implements ModInitializer {
	public static final String MOD_ID = "mores";
    public static final Logger LOGGER = LoggerFactory.getLogger("mores");

	@Override
	public void onInitialize() {
//		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

//		ModLootTableModifiers.modifyLootTables();
//		ModCustomTrades.registerCustomTrades();

//		ModSounds.registerSounds();

//		ModBlockEntities.registerBlockEntities();
//		ModScreenHandlers.registerScreenHandlers();

//		ModRecipes.registerRecipes();
//		ModTrunkPlacerTypes.register();

		FuelRegistry.INSTANCE.add(ModItems.ANTHRACITE, 4000);
//		FabricDefaultAttributeRegistry.register(ModEntities.ALLOY_BLOCK, AlloyBlockEntity.createAlloyAttributes());

//		ModWorldGeneration.generateModWorldGen();

		CustomPortalBuilder.beginPortal()
				.frameBlock(ModBlocks.RUBY_BLOCK)
				.lightWithItem(ModItems.ANTHRACITE)
				.destDimID(new Identifier(Mores.MOD_ID, "reloaded"))
				.tintColor(0xc76efa)
				.registerPortal();
	}
}