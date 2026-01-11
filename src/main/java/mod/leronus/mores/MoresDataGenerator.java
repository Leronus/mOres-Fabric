package mod.leronus.mores;

import mod.leronus.mores.datagen.*;
import mod.leronus.mores.trim.ModTrimMaterials;
import mod.leronus.mores.world.ModConfiguredFeatures;
import mod.leronus.mores.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class MoresDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModTrimmedArmorItemModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
//		pack.addProvider(ModPaintingVariantTagProvider::new);
		pack.addProvider(ModAdvancementProvider::new);
		pack.addProvider(ModDynamicRegistryProvider::new);
        pack.addProvider(ModJukeboxSongProvider::new);
        pack.addProvider(ModWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, ModTrimMaterials::bootstrap);

		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}