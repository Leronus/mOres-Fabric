package mod.leronus.mores.world.gen.lemon;

import mod.leronus.mores.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public final class ModLemonSaplingGenerator {

    public static final SaplingGenerator LEMON_OAK =
            new SaplingGenerator(
                    "lemon_oak",
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.LEMON_OAK_TREE_SAPLING),
                    Optional.empty()
            );

    private ModLemonSaplingGenerator() {}
}
