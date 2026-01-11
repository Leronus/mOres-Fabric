package mod.leronus.mores.mixin;

import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.entity.ModEntities;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CarvedPumpkinBlock.class)
public abstract class CarvedPumpkinBlockMixin {

    @Unique
    private static BlockPattern MORES$HARDENED_STEEL_GOLEM_PATTERN;

    /**
     * In 1.21.x Yarn, golem spawning is triggered from CarvedPumpkinBlock#trySpawnEntity(World, BlockPos).
     * We inject after vanilla checks (snow + iron golems) and add our hardened-steel golem.
     */
    @Inject(method = "trySpawnEntity", at = @At("TAIL"))
    private void mores$trySpawnHardenedSteelGolem(World world, BlockPos pos, CallbackInfo ci) {
        if (!(world instanceof ServerWorld serverWorld)) return;

        BlockPattern pattern = mores$getHardenedSteelGolemPattern();
        BlockPattern.Result result = pattern.searchAround(serverWorld, pos);
        if (result == null) return;

        // Remove the structure blocks (including the pumpkin)
        for (int x = 0; x < pattern.getWidth(); x++) {
            for (int y = 0; y < pattern.getHeight(); y++) {
                BlockPos bp = result.translate(x, y, 0).getBlockPos();
                serverWorld.breakBlock(bp, false);
            }
        }

        // Spawn position: center of the "T"
        BlockPos spawnPos = result.translate(1, 1, 0).getBlockPos();

        var golem = ModEntities.HARDENED_STEEL_GOLEM.create(serverWorld);
        if (golem == null) return;

        golem.refreshPositionAndAngles(
                spawnPos.getX() + 0.5D,
                spawnPos.getY(),
                spawnPos.getZ() + 0.5D,
                0.0F,
                0.0F
        );

        serverWorld.spawnEntity(golem);

        // --- Vanilla-style feedback ---
        // Block break particles using your hardened steel block state.
        serverWorld.syncWorldEvent(
                2001, // "block break" event id
                spawnPos,
                Block.getRawIdFromState(ModBlocks.HARDENED_STEEL_BLOCK.getDefaultState())
        );

        // Deeper sound: lower pitch (< 1.0f). Try 0.7f for "heavier".
        serverWorld.playSound(
                null,
                spawnPos,
                SoundEvents.BLOCK_METAL_PLACE,
                SoundCategory.BLOCKS,
                1.0F,
                0.7F
        );
    }

    @Unique
    private static BlockPattern mores$getHardenedSteelGolemPattern() {
        if (MORES$HARDENED_STEEL_GOLEM_PATTERN == null) {
            MORES$HARDENED_STEEL_GOLEM_PATTERN = BlockPatternBuilder.start()
                    // Same shape as iron golem:
                    //   ~ ^ ~
                    //   # # #
                    //   ~ # ~
                    .aisle("~^~", "###", "~#~")
                    .where('^', p -> {
                        var s = p.getBlockState();
                        // Allow both carved pumpkin and jack o'lantern (vanilla-like)
                        return s.isOf(Blocks.CARVED_PUMPKIN) || s.isOf(Blocks.JACK_O_LANTERN);
                    })
                    .where('#', p -> p.getBlockState().isOf(ModBlocks.HARDENED_STEEL_BLOCK))
                    .where('~', p -> p.getBlockState().isAir())
                    .build();
        }
        return MORES$HARDENED_STEEL_GOLEM_PATTERN;
    }
}
