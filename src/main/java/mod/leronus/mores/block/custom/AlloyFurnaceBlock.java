package mod.leronus.mores.block.custom;

import com.mojang.serialization.MapCodec;
import mod.leronus.mores.block.entity.AlloyFurnaceBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class AlloyFurnaceBlock extends BlockWithEntity implements BlockEntityProvider {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = Properties.LIT;

    public AlloyFurnaceBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(LIT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        if (!state.get(LIT)) return;

        double x = pos.getX() + 0.5;
        double y = pos.getY();
        double z = pos.getZ() + 0.5;

        // Optional furnace crackle
        if (random.nextDouble() < 0.1) {
            world.playSound(
                    x, y, z,
                    SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE,
                    SoundCategory.BLOCKS,
                    1.0F,
                    1.0F,
                    false
            );
        }

        Direction facing = state.get(FACING);

        double frontOffset = 0.52;
        double sideJitter = random.nextDouble() * 0.6 - 0.3;

        double px = x + facing.getOffsetX() * frontOffset + (facing.getAxis() == Direction.Axis.Z ? sideJitter : 0.0);
        double py = y + 0.6 + random.nextDouble() * 0.2;
        double pz = z + facing.getOffsetZ() * frontOffset + (facing.getAxis() == Direction.Axis.X ? sideJitter : 0.0);

        // ALWAYS soul visuals outside the GUI
        world.addParticle(ParticleTypes.SMOKE, px, py, pz, 0.0, 0.0, 0.0);
        world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, px, py, pz, 0.0, 0.0, 0.0);
    }


    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AlloyFurnaceBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;

        BlockEntity be = world.getBlockEntity(pos);
        if (be instanceof NamedScreenHandlerFactory factory) {
            player.openHandledScreen(factory);
            player.incrementStat(Stats.INTERACT_WITH_FURNACE);
        }
        return ActionResult.CONSUME;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if (world.isClient) return;

        if (stack.contains(DataComponentTypes.CUSTOM_NAME)) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof AlloyFurnaceBlockEntity alloy) {
                alloy.setCustomName(stack.getName());
            }
        }
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof Inventory inv) {
                ItemScatterer.spawn(world, pos, inv);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return net.minecraft.screen.ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient) return null;
        return (w, p, s, be) -> {
            if (be instanceof AlloyFurnaceBlockEntity alloy) {
                AlloyFurnaceBlockEntity.tick(w, p, s, alloy);
            }
        };
    }

    public static final MapCodec<AlloyFurnaceBlock> CODEC =
            createCodec(AlloyFurnaceBlock::new);

    @Override
    public MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }
}
