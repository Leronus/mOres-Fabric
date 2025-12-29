package mod.leronus.mores.block.entity;


import mod.leronus.mores.block.custom.AlloyFurnaceBlock;
import mod.leronus.mores.recipe.AlloyRecipeInput;
import mod.leronus.mores.recipe.AlloyingRecipe;
import mod.leronus.mores.registry.ModBlockEntities;
import mod.leronus.mores.recipe.ModRecipeTypes;
import mod.leronus.mores.block.screen.AlloyFurnaceScreenHandler;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Optional;

public class AlloyFurnaceBlockEntity extends LockableContainerBlockEntity implements SidedInventory {

    public static final int INPUT_A = 0;
    public static final int INPUT_B = 1;
    public static final int FUEL = 2;
    public static final int OUTPUT = 3;
    public static final int SIZE = 4;

    // Hopper automation rules
    private static final int[] TOP_SLOTS = new int[]{INPUT_A, INPUT_B};
    private static final int[] SIDE_SLOTS = new int[]{FUEL};
    private static final int[] BOTTOM_SLOTS = new int[]{OUTPUT};

    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(SIZE, ItemStack.EMPTY);

    // Furnace-like progress fields
    private int burnTime;       // remaining burn time
    private int fuelTime;       // total burn time for current fuel item
    private int cookTime;       // progress
    private int cookTimeTotal = 200;

    // Property delegate for syncing to client screen
    private final PropertyDelegate propertyDelegate = new ArrayPropertyDelegate(4) {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> burnTime;
                case 1 -> fuelTime;
                case 2 -> cookTime;
                case 3 -> cookTimeTotal;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> burnTime = value;
                case 1 -> fuelTime = value;
                case 2 -> cookTime = value;
                case 3 -> cookTimeTotal = value;
            }
        }

        @Override
        public int size() {
            return 4;
        }
    };

    private Text customName;

    public AlloyFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ALLOY_FURNACE_BE, pos, state);
    }

    // ---- ticking ----

    public static void tick(World world, BlockPos pos, BlockState state, AlloyFurnaceBlockEntity be) {
        if (world.isClient) return;

        boolean wasBurning = be.isBurning();
        boolean dirty = false;

        if (be.isBurning()) {
            be.burnTime--;
        }

        Optional<RecipeEntry<AlloyingRecipe>> match = be.getMatchingRecipe(world);

        boolean canCraft = match.isPresent() && be.canAcceptRecipeOutput(world.getRegistryManager(), match.get().value());

        if (!be.isBurning() && canCraft) {
            int fuel = be.getFuelTime(be.inventory.get(FUEL));
            if (fuel > 0) {
                be.burnTime = fuel;
                be.fuelTime = fuel;
                dirty = true;

                ItemStack fuelStack = be.inventory.get(FUEL);

                // consume exactly 1 fuel
                fuelStack.decrement(1);

                // handle recipe remainder (lava bucket → empty bucket)
                Item remainder = fuelStack.getItem().getRecipeRemainder();
                if (remainder != null && fuelStack.isEmpty()) {
                    be.inventory.set(FUEL, new ItemStack(remainder));
                }
            }
        }

        if (be.isBurning() && canCraft) {
            be.cookTime++;
            AlloyingRecipe recipe = match.get().value();
            be.cookTimeTotal = recipe.getCookingTime();

            if (be.cookTime >= be.cookTimeTotal) {
                be.cookTime = 0;
                be.craftRecipe(world.getRegistryManager(), recipe);
                dirty = true;
            }
        } else {
            if (be.cookTime != 0) {
                be.cookTime = 0;
                dirty = true;
            }
        }

        if (wasBurning != be.isBurning()) {
            dirty = true;
            world.setBlockState(pos, state.with(AlloyFurnaceBlock.LIT, be.isBurning()), 3);
        }

        if (dirty) {
            markDirty(world, pos, state);
        }
    }

    private Optional<RecipeEntry<AlloyingRecipe>> getMatchingRecipe(World world) {
        ItemStack a = inventory.get(INPUT_A);
        ItemStack b = inventory.get(INPUT_B);

        if (a.isEmpty() || b.isEmpty()) return Optional.empty();

        AlloyRecipeInput input = new AlloyRecipeInput(a, b);
        return world.getRecipeManager().getFirstMatch(ModRecipeTypes.ALLOYING, input, world);
    }

    private boolean canAcceptRecipeOutput(RegistryWrapper.WrapperLookup lookup, AlloyingRecipe recipe) {
        ItemStack result = recipe.getResult(lookup);
        if (result.isEmpty()) return false;

        ItemStack out = inventory.get(OUTPUT);
        if (out.isEmpty()) return true;

        if (!ItemStack.areItemsAndComponentsEqual(out, result)) return false;

        int max = Math.min(getMaxCountPerStack(), out.getMaxCount());
        return out.getCount() + result.getCount() <= max;
    }

    private void craftRecipe(RegistryWrapper.WrapperLookup lookup, AlloyingRecipe recipe) {
        if (!canAcceptRecipeOutput(lookup, recipe)) return;

        ItemStack result = recipe.getResult(lookup).copy();

        // Consume 1 from each input slot (you can change amounts later)
        inventory.get(INPUT_A).decrement(1);
        inventory.get(INPUT_B).decrement(1);

        ItemStack out = inventory.get(OUTPUT);
        if (out.isEmpty()) {
            inventory.set(OUTPUT, result);
        } else {
            out.increment(result.getCount());
        }
    }

    private int getFuelTime(ItemStack fuelStack) {
        if (fuelStack.isEmpty()) return 0;
        Integer time = FuelRegistry.INSTANCE.get(fuelStack.getItem());
        return time == null ? 0 : time;
    }

    private boolean isBurning() {
        return burnTime > 0;
    }

    // ---- inventory / container boilerplate ----

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.mores.alloy_furnace");
    }

    public void setCustomName(Text name) {
        this.customName = name;
    }

    @Override
    public Text getName() {
        return customName != null ? customName : getContainerName();
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new AlloyFurnaceScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public int size() {
        return SIZE;
    }

    @Override
    protected DefaultedList<ItemStack> getHeldStacks() {
        return inventory;
    }

    @Override
    protected void setHeldStacks(DefaultedList<ItemStack> stacks) {
        this.inventory = stacks;
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        inventory = DefaultedList.ofSize(SIZE, ItemStack.EMPTY);
        Inventories.readNbt(nbt, inventory, registryLookup);

        burnTime = nbt.getShort("BurnTime");
        fuelTime = nbt.getShort("FuelTime");
        cookTime = nbt.getShort("CookTime");
        cookTimeTotal = nbt.getShort("CookTimeTotal");

        if (nbt.contains("CustomName", 8)) {
            customName = Text.Serialization.fromJson(nbt.getString("CustomName"), registryLookup);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);

        nbt.putShort("BurnTime", (short) burnTime);
        nbt.putShort("FuelTime", (short) fuelTime);
        nbt.putShort("CookTime", (short) cookTime);
        nbt.putShort("CookTimeTotal", (short) cookTimeTotal);

        if (customName != null) {
            nbt.putString("CustomName", Text.Serialization.toJsonString(customName, registryLookup));
        }
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        if (world == null) return false;
        if (world.getBlockEntity(pos) != this) return false;
        return player.squaredDistanceTo(
                pos.getX() + 0.5,
                pos.getY() + 0.5,
                pos.getZ() + 0.5
        ) <= 64.0;
    }

    // ---- sided inventory (hoppers) ----

    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.DOWN) return BOTTOM_SLOTS;
        if (side == Direction.UP) return TOP_SLOTS;
        return SIDE_SLOTS;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction dir) {
        if (slot == OUTPUT) return false;
        if (slot == FUEL) {
            return getFuelTime(stack) > 0;
        }
        // allow both inputs from top by default
        return slot == INPUT_A || slot == INPUT_B;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return slot == OUTPUT;
    }
}
