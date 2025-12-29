package mod.leronus.mores.block.screen;

import mod.leronus.mores.block.entity.AlloyFurnaceBlockEntity;
import mod.leronus.mores.registry.ModScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;

public class AlloyFurnaceScreenHandler extends ScreenHandler {

    private final Inventory inventory;
    private final PropertyDelegate properties;

    public AlloyFurnaceScreenHandler(int syncId, PlayerInventory playerInv) {
        this(syncId, playerInv, new SimpleInventory(AlloyFurnaceBlockEntity.SIZE), new net.minecraft.screen.ArrayPropertyDelegate(4));
    }

    public AlloyFurnaceScreenHandler(int syncId, PlayerInventory playerInv, Inventory inventory, PropertyDelegate properties) {
        super(ModScreenHandlers.ALLOY_FURNACE, syncId);
        this.inventory = inventory;
        this.properties = properties;

        checkSize(inventory, AlloyFurnaceBlockEntity.SIZE);
        checkDataCount(properties, 4);

        inventory.onOpen(playerInv.player);

        // Inputs (choose coordinates to match furnace texture; you can tweak)
        this.addSlot(new Slot(inventory, AlloyFurnaceBlockEntity.INPUT_A, 44, 17));
        this.addSlot(new Slot(inventory, AlloyFurnaceBlockEntity.INPUT_B, 67, 17));

        // Fuel
        this.addSlot(new Slot(inventory, AlloyFurnaceBlockEntity.FUEL, 56, 53) {
            @Override
            public boolean canInsert(ItemStack stack) {
                // keep it simple; BE also validates fuel
                Integer fuel = net.fabricmc.fabric.api.registry.FuelRegistry.INSTANCE.get(stack.getItem());
                return fuel != null && fuel > 0;
            }
        });

        // Output
        this.addSlot(new Slot(inventory, AlloyFurnaceBlockEntity.OUTPUT, 116, 35) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });

        // Player inventory
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Hotbar
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, 142));
        }

        addProperties(properties);
    }



    @Override
    public boolean canUse(PlayerEntity player) {
        return inventory.canPlayerUse(player);
    }

    // ---- progress helpers for your Screen ----

    public int getBurnTime() {
        return properties.get(0);
    }

    public int getFuelTime() {
        return properties.get(1);
    }

    public int getCookTime() {
        return properties.get(2);
    }

    public int getCookTimeTotal() {
        return properties.get(3);
    }

    public boolean isBurning() {
        return getBurnTime() > 0;
    }

    /**
     * Scale flame height like vanilla (0..13)
     */
    public int getFuelProgress() {
        int burn = getBurnTime();
        int fuel = getFuelTime();
        if (fuel == 0) fuel = 200;
        return burn * 13 / fuel;
    }

    /**
     * Scale arrow width like vanilla (0..24)
     */
    public int getCookProgress() {
        int cook = getCookTime();
        int total = getCookTimeTotal();
        if (total == 0) total = 200;
        return cook * 24 / total;
    }

    // ---- shift-click behavior ----

    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasStack()) {
            ItemStack original = slot.getStack();
            newStack = original.copy();

            int containerSlots = AlloyFurnaceBlockEntity.SIZE; // 4
            int playerInvStart = containerSlots;
            int playerInvEnd = playerInvStart + 36;

            // If clicked inside our block inventory -> move to player inventory
            if (index < containerSlots) {
                if (!this.insertItem(original, playerInvStart, playerInvEnd, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // From player inventory -> try fuel, then inputs
                Integer fuel = net.fabricmc.fabric.api.registry.FuelRegistry.INSTANCE.get(original.getItem());
                if (fuel != null && fuel > 0) {
                    if (!this.insertItem(original, AlloyFurnaceBlockEntity.FUEL, AlloyFurnaceBlockEntity.FUEL + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    // Try inputs A and B
                    if (!this.insertItem(original, AlloyFurnaceBlockEntity.INPUT_A, AlloyFurnaceBlockEntity.INPUT_B + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            }

            if (original.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        inventory.onClose(player);
    }
}
