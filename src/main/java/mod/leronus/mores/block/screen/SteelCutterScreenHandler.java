package mod.leronus.mores.block.screen;

import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.registry.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.StonecutterScreenHandler;
import net.minecraft.util.math.BlockPos;

public class SteelCutterScreenHandler extends StonecutterScreenHandler {

    private final ScreenHandlerContext context;
    private final BlockPos posOrNull;

    // Client constructor (syncId, inv) required by ScreenHandlerType factory
    public SteelCutterScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    // Server constructor (syncId, inv, context) used by the block factory
    public SteelCutterScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(syncId, playerInventory, context);
        this.context = context;

        // Capture the position if we have it (server). Client uses EMPTY.
        this.posOrNull = context.get((world, pos) -> pos).orElse(null);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        // Client-side: don't hard-close the UI because we don't have a real pos.
        if (this.posOrNull == null) return true;

        // Server-side: validate distance + correct block
        return player.getWorld().getBlockState(this.posOrNull).isOf(ModBlocks.STEEL_CUTTER)
                && player.squaredDistanceTo(
                this.posOrNull.getX() + 0.5,
                this.posOrNull.getY() + 0.5,
                this.posOrNull.getZ() + 0.5
        ) <= 64.0;
    }

    @Override
    public ScreenHandlerType<?> getType() {
        return ModScreenHandlers.STEEL_CUTTER;
    }
}
