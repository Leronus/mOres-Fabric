package mod.leronus.mores.block.entity;

import mod.leronus.mores.block.custom.AlloyFurnaceBlock;
import mod.leronus.mores.block.screen.AlloyFurnaceScreenHandler;
import mod.leronus.mores.recipe.AlloyRecipeInput;
import mod.leronus.mores.recipe.AlloyingRecipe;
import mod.leronus.mores.registry.ModRecipes;
import mod.leronus.mores.registry.ModBlockEntities;
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

import java.util.List;
import java.util.Optional;

public class AlloyFurnaceBlockEntity extends LockableContainerBlockEntity implements SidedInventory {

    public static final int INPUT_A = 0;
    public static final int INPUT_B = 1;
    public static final int FUEL = 2;
    public static final int OUTPUT = 3;
    public static final int SIZE = 4;

    private static final int[] TOP_SLOTS = new int[]{INPUT_A, INPUT_B};
    private static final int[] SIDE_SLOTS = new int[]{FUEL};
    private static final int[] BOTTOM_SLOTS = new int[]{OUTPUT};

    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(SIZE, ItemStack.EMPTY);

    // Furnace-like timers
    private int burnTime;        // ticks remaining
    private int fuelTime;        // total ticks for current fuel (UI scaling)
    private int cookTime;        // progress
    private int cookTimeTotal = 200;

    // GUI theme sync (0 soul, 1 red, 2 purple, 3 blue)
    private int themeId;

    private final PropertyDelegate propertyDelegate = new ArrayPropertyDelegate(5) {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> burnTime;
                case 1 -> fuelTime;
                case 2 -> cookTime;
                case 3 -> cookTimeTotal;
                case 4 -> themeId;
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
                case 4 -> themeId = value;
            }
        }

        @Override
        public int size() {
            return 5;
        }
    };

    private Text customName;

    public AlloyFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ALLOY_FURNACE_BE, pos, state);
    }

    // =========================
    // TICK
    // =========================

    public static void tick(World world, BlockPos pos, BlockState state, AlloyFurnaceBlockEntity be) {
        if (world.isClient) return;

        boolean dirty = false;

        // 1) burnTime always ticks down like vanilla (even if inputs removed)
        if (be.burnTime > 0) {
            be.burnTime--;
            dirty = true;
            if (be.burnTime == 0) {
                be.fuelTime = 0; // so flame UI doesn't look "full"
                dirty = true;
            }
        }

        // 2) Update GUI themeId (server-synced)
        int newThemeId = be.computeThemeId(world);
        if (newThemeId != be.themeId) {
            be.themeId = newThemeId;
            dirty = true;
        }

        // 3) Try find a recipe we can actually craft right now
        Optional<RecipeEntry<AlloyingRecipe>> match = be.getMatchingRecipe(world);
        boolean canCraft = match.isPresent() && be.canAcceptRecipeOutput(world.getRegistryManager(), match.get().value());

        // 4) If not burning AND can craft, consume 1 fuel to start burning
        if (be.burnTime == 0 && canCraft) {
            ItemStack fuelStack = be.inventory.get(FUEL);
            int fuel = be.getFuelTime(fuelStack);

            if (fuel > 0) {
                Item fuelItem = fuelStack.getItem();

                be.burnTime = fuel;
                be.fuelTime = fuel;
                dirty = true;

                fuelStack.decrement(1);

                Item remainder = fuelItem.getRecipeRemainder();
                if (remainder != null && fuelStack.isEmpty()) {
                    be.inventory.set(FUEL, new ItemStack(remainder));
                }
            }
        }

        // 5) Cooking progress only while burning AND recipe valid
        if (be.burnTime > 0 && canCraft) {
            AlloyingRecipe recipe = match.get().value();
            be.cookTimeTotal = recipe.getCookingTime();

            be.cookTime++;
            dirty = true;

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
            if (!canCraft && be.cookTimeTotal != 200) {
                be.cookTimeTotal = 200;
                dirty = true;
            }
        }

        // 6) Sync LIT strictly to burnTime > 0 (prevents "stuck lit")
        boolean shouldBeLit = be.burnTime > 0;
        if (state.get(AlloyFurnaceBlock.LIT) != shouldBeLit) {
            world.setBlockState(pos, state.with(AlloyFurnaceBlock.LIT, shouldBeLit), 3);
            dirty = true;
        }

        if (dirty) {
            be.markDirty();
            markDirty(world, pos, state);
        }
    }

    // =========================
    // THEME (SERVER -> GUI)
    // =========================

    private int computeThemeId(World world) {
        Optional<RecipeEntry<AlloyingRecipe>> match = getMatchingRecipe(world);
        if (match.isEmpty()) return 0; // SOUL
        return themeIdFromString(match.get().value().getTheme());
    }

    private static int themeIdFromString(String id) {
        if (id == null) return 0;
        return switch (id) {
            case "red" -> 1;
            case "purple" -> 2;
            case "blue" -> 3;
            default -> 0;
        };
    }

    // =========================
    // STRICT INPUT RULES
    // =========================
    // Called by ScreenHandler slot.canInsert(...) AND also used by shift-click.

    public boolean isValidInputCandidate(int targetSlot, ItemStack candidate) {
        if (candidate == null || candidate.isEmpty()) return false;
        if (world == null) return false;

        if (targetSlot != INPUT_A && targetSlot != INPUT_B) return false;

        int otherSlot = (targetSlot == INPUT_A) ? INPUT_B : INPUT_A;

        ItemStack other = inventory.get(otherSlot);

        // Rule: if other slot has same item, forbid (prevents copper+copper etc)
        if (!other.isEmpty() && ItemStack.areItemsAndComponentsEqual(candidate, other)) {
            return false;
        }

        // If the other slot is empty:
        // allow only if candidate is used in ANY alloying recipe (as ingredient A or B)
        if (other.isEmpty()) {
            return isUsedInAnyAlloyRecipe(candidate);
        }

        // If other slot is filled:
        // allow only if there exists a recipe that matches (candidate + other) in any order
        // AND output can be accepted
        Optional<RecipeEntry<AlloyingRecipe>> match = world.getRecipeManager()
                .getFirstMatch(ModRecipes.ALLOYING, new AlloyRecipeInput(candidate, other), world);

        if (match.isEmpty()) return false;

        return canAcceptRecipeOutput(world.getRegistryManager(), match.get().value());
    }

    private boolean isUsedInAnyAlloyRecipe(ItemStack candidate) {
        if (world == null) return false;

        List<RecipeEntry<AlloyingRecipe>> all = world.getRecipeManager().listAllOfType(ModRecipes.ALLOYING);
        for (RecipeEntry<AlloyingRecipe> entry : all) {
            AlloyingRecipe r = entry.value();
            if (r.ingredientA().test(candidate) || r.ingredientB().test(candidate)) {
                return true;
            }
        }
        return false;
    }

    // =========================
    // RECIPE / CRAFTING
    // =========================

    private Optional<RecipeEntry<AlloyingRecipe>> getMatchingRecipe(World world) {
        ItemStack a = inventory.get(INPUT_A);
        ItemStack b = inventory.get(INPUT_B);

        if (a.isEmpty() || b.isEmpty()) return Optional.empty();

        AlloyRecipeInput input = new AlloyRecipeInput(a, b);
        return world.getRecipeManager().getFirstMatch(ModRecipes.ALLOYING, input, world);
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

    // =========================
    // INVENTORY BOILERPLATE
    // =========================

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

        burnTime = nbt.getInt("BurnTime");
        fuelTime = nbt.getInt("FuelTime");
        cookTime = nbt.getInt("CookTime");
        cookTimeTotal = nbt.getInt("CookTimeTotal");
        themeId = nbt.getInt("ThemeId");

        if (nbt.contains("CustomName", 8)) {
            customName = Text.Serialization.fromJson(nbt.getString("CustomName"), registryLookup);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);

        nbt.putInt("BurnTime", burnTime);
        nbt.putInt("FuelTime", fuelTime);
        nbt.putInt("CookTime", cookTime);
        nbt.putInt("CookTimeTotal", cookTimeTotal);
        nbt.putInt("ThemeId", themeId);

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

    // =========================
    // SIDED INVENTORY (HOPPERS)
    // =========================

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

        if (slot == INPUT_A || slot == INPUT_B) {
            return isValidInputCandidate(slot, stack);
        }

        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return slot == OUTPUT;
    }
}
