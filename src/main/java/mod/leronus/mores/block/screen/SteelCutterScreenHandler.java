package mod.leronus.mores.block.screen;

import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.registry.ModRecipes;
import mod.leronus.mores.registry.ModScreenHandlers;
import mod.leronus.mores.recipe.SteelCuttingRecipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class SteelCutterScreenHandler extends ScreenHandler {

    private final ScreenHandlerContext context;
    private final BlockPos posOrNull;
    private final PlayerEntity player;

    private final Inventory input = new SimpleInventory(1) {
        @Override
        public void markDirty() {
            super.markDirty();
            SteelCutterScreenHandler.this.onContentChanged(this);
        }
    };

    private final CraftingResultInventory output = new CraftingResultInventory();
    private final Property selectedRecipe = Property.create();

    private List<RecipeEntry<SteelCuttingRecipe>> availableRecipes = List.of();
    private ItemStack lastInput = ItemStack.EMPTY;

    private Runnable contentsChangedListener = () -> {};

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    // Client constructor
    public SteelCutterScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    // Server constructor
    public SteelCutterScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ModScreenHandlers.STEEL_CUTTER, syncId);
        this.context = context;
        this.player = playerInventory.player;
        this.posOrNull = context.get((world, pos) -> pos).orElse(null);

        this.addProperty(this.selectedRecipe);

        // Input slot
        this.addSlot(new Slot(this.input, 0, 20, 33));

        // Output slot
        this.addSlot(new Slot(this.output, 0, 143, 33) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }

            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                SteelCutterScreenHandler.this.input.removeStack(0, 1);
                SteelCutterScreenHandler.this.onContentChanged(SteelCutterScreenHandler.this.input);
                super.onTakeItem(player, stack);
            }
        });

        // Player inventory
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Hotbar
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    // ---- vanilla-like API used by the screen ----

    public void setContentsChangedListener(Runnable listener) {
        this.contentsChangedListener = (listener == null) ? () -> {} : listener;
    }

    public boolean canCraft() {
        return !this.input.getStack(0).isEmpty() && !this.availableRecipes.isEmpty();
    }

    public List<RecipeEntry<SteelCuttingRecipe>> getAvailableRecipes() {
        return this.availableRecipes;
    }

    public int getAvailableRecipeCount() {
        return this.availableRecipes.size();
    }

    public int getSelectedRecipe() {
        return this.selectedRecipe.get();
    }

    public boolean isValidRecipeIndex(int idx) {
        return idx >= 0 && idx < this.availableRecipes.size();
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (this.isValidRecipeIndex(id)) {
            this.selectedRecipe.set(id);
            this.updateOutput();
            return true;
        }
        return false;
    }

    @Override
    public void onContentChanged(Inventory inventory) {
        ItemStack in = this.input.getStack(0);

        // Refresh recipe list when the item changes
        if (!ItemStack.areItemsEqual(in, this.lastInput)) {
            this.lastInput = in.copy();
            this.selectedRecipe.set(-1);
            this.output.setStack(0, ItemStack.EMPTY);
            this.availableRecipes = List.of();

            if (!in.isEmpty()) {
                SingleStackRecipeInput recipeInput = new SingleStackRecipeInput(in);
                var world = this.player.getWorld();

                this.availableRecipes = world.getRecipeManager()
                        .getAllMatches(ModRecipes.STEEL_CUTTING, recipeInput, world);
            }
        }

        // Always update output
        this.updateOutput();

        // Notify screen like vanilla does
        this.contentsChangedListener.run();

        super.onContentChanged(inventory);
    }

    private void updateOutput() {
        int idx = this.selectedRecipe.get();

        if (!this.isValidRecipeIndex(idx)) {
            this.output.setStack(0, ItemStack.EMPTY);
            return;
        }

        ItemStack in = this.input.getStack(0);
        if (in.isEmpty()) {
            this.output.setStack(0, ItemStack.EMPTY);
            return;
        }

        var world = this.player.getWorld();
        SingleStackRecipeInput recipeInput = new SingleStackRecipeInput(in);

        RecipeEntry<SteelCuttingRecipe> entry = this.availableRecipes.get(idx);
        ItemStack result = entry.value().craft(recipeInput, world.getRegistryManager());

        this.output.setLastRecipe(entry);
        this.output.setStack(0, result);
    }

    // ---- Shift-click / quick move ----
    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack original = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);

        if (slot != null && slot.hasStack()) {
            ItemStack stack = slot.getStack();
            original = stack.copy();

            // slot indices:
            // 0 input, 1 output, 2..38 player inv
            if (slotIndex == OUTPUT_SLOT) {
                if (!this.insertItem(stack, 2, 38, true)) return ItemStack.EMPTY;
                slot.onQuickTransfer(stack, original);
            } else if (slotIndex >= 2) {
                if (!this.insertItem(stack, INPUT_SLOT, INPUT_SLOT + 1, false)) return ItemStack.EMPTY;
            } else {
                if (!this.insertItem(stack, 2, 38, false)) return ItemStack.EMPTY;
            }

            if (stack.isEmpty()) slot.setStack(ItemStack.EMPTY);
            else slot.markDirty();

            if (stack.getCount() == original.getCount()) return ItemStack.EMPTY;

            slot.onTakeItem(player, stack);
        }

        return original;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        if (this.posOrNull == null) return true;

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

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.context.run((world, pos) -> this.dropInventory(player, this.input));
    }
}
