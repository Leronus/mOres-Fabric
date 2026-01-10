package mod.leronus.mores.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.ColoredFallingBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ColorCode;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;

public class FallingOreBlock extends ColoredFallingBlock {
    private final IntProvider xp;

    public FallingOreBlock(IntProvider xp, ColorCode color, Settings settings) {
        super(color, settings);
        this.xp = xp;
    }

    @Override
    protected void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        super.onStacksDropped(state, world, pos, tool, dropExperience);

        // dropExperience is false for Silk Touch (and some other cases).
        if (dropExperience) {
            dropExperienceWhenMined(world, pos, tool, this.xp);
        }
    }
}

