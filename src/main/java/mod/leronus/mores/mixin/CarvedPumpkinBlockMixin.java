package mod.leronus.mores.mixin;

import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.entity.ModEntities;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.server.network.ServerPlayerEntity;
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
     * Inject after vanilla snow/iron golem checks and attempt to spawn
     * the Hardened Steel Golem using a custom block pattern.
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
                serverWorld.setBlockState(bp, Blocks.AIR.getDefaultState(), Block.NOTIFY_LISTENERS);
            }
        }

        // Spawn position: center of the T shape
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

        if (!serverWorld.spawnEntity(golem)) return;

        // Mark as player-created (vanilla iron golem behavior)
        golem.setPlayerCreated(true);

        // Trigger summoned_entity criterion for nearby players
        for (ServerPlayerEntity player : serverWorld.getNonSpectatingEntities(
                ServerPlayerEntity.class,
                golem.getBoundingBox().expand(5.0D)
        )) {
            Criteria.SUMMONED_ENTITY.trigger(player, golem);
        }

        // --- Vanilla-style feedback ---

        // Block break particles
        serverWorld.syncWorldEvent(
                2001, // Block break event
                spawnPos,
                Block.getRawIdFromState(ModBlocks.HARDENED_STEEL_BLOCK.getDefaultState())
        );

        // Heavy metal placement sound
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
                    // Shape:
                    //   ~ ^ ~
                    //   # # #
                    //   ~ # ~
                    .aisle("~^~", "###", "~#~")
                    .where('^', p -> {
                        var s = p.getBlockState();
                        return s.isOf(Blocks.CARVED_PUMPKIN)
                                || s.isOf(Blocks.JACK_O_LANTERN);
                    })
                    .where('#', p -> p.getBlockState().isOf(ModBlocks.HARDENED_STEEL_BLOCK))
                    .where('~', p -> p.getBlockState().isAir())
                    .build();
        }
        return MORES$HARDENED_STEEL_GOLEM_PATTERN;
    }
}
