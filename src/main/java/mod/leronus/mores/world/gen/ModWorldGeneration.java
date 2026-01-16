package mod.leronus.mores.world.gen;

import mod.leronus.mores.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
//        BiomeModifications.addFeature(
//                BiomeSelectors.foundInOverworld(),
//                GenerationStep.Feature.VEGETAL_DECORATION,
//                ModPlacedFeatures.LEMON_OAK_PLACED_KEY
//        );
    }

}