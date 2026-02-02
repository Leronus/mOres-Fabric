package mod.leronus.mores.mixin.client;

import com.redlimerl.detailab.DetailArmorBar;
import com.redlimerl.detailab.api.DetailArmorBarAPI;
import com.redlimerl.detailab.api.render.CustomArmorBar;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Pseudo
@Mixin(targets = "com.redlimerl.detailab.render.ArmorBarRenderer", remap = false)
public abstract class MultiArmorBarMixin {

    /**
     * DetailABReconst method signature (from your decompile):
     *   public void render(DrawContext context, PlayerEntity player, int y_base)
     */
    @Inject(
            method = "render(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/entity/player/PlayerEntity;I)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void mores$renderAllRows(DrawContext context, PlayerEntity player, int y_base, CallbackInfo ci) {
        List<Pair<ItemStack, CustomArmorBar>> armorPoints = getArmorPoints_CopyOfDetailAB(player);
        int totalArmorPoint = armorPoints.size();

        // If no points, let the original mod handle empty-bar behavior (toggleEmptyBar, etc.)
        if (totalArmorPoint == 0) return;

        MinecraftClient client = MinecraftClient.getInstance();
        int screenWidth = client.getWindow().getScaledWidth() / 2 - 91
                + DetailArmorBar.getConfig().getOptions().armorBarOffsetX;
        int yPosBase = y_base + DetailArmorBar.getConfig().getOptions().armorBarOffsetY;

        // Rows: each row is 20 points (10 icons).
        int rows = (totalArmorPoint - 1) / 20;

        // Draw bottom row (0..19), then overflow rows above it (20..39, etc.)
        for (int row = 0; row <= rows; row++) {
            int stackRow = row * 20;
            int yPosRow = yPosBase - row * 10; // row height is 10px in DetailAB
            drawOneRow(context, armorPoints, totalArmorPoint, screenWidth, yPosRow, stackRow);
        }

        // IMPORTANT:
        // Do NOT draw the "stack indicator" (it renders as a chestplate icon on the far left).
        // That indicator is what you asked to remove.

        ci.cancel();
    }

    /**
     * Draw one row exactly like DetailAB does, but selecting the correct slice by stackRow.
     */
    private static void drawOneRow(DrawContext context,
                                   List<Pair<ItemStack, CustomArmorBar>> armorPoints,
                                   int totalArmorPoint,
                                   int screenWidth,
                                   int yPos,
                                   int stackRow) {

        final int maxSlots = 10;

        for (int count = 0; count < maxSlots; count++) {
            int xPos;
            if (DetailArmorBar.getConfig().getOptions().toggleInverseSlot) {
                xPos = screenWidth + (9 - count) * 8;
            } else {
                xPos = screenWidth + count * 8;
            }

            int idx1 = count * 2 + stackRow;
            int idx2 = count * 2 + 1 + stackRow;

            // two points (full icon or split)
            if (idx2 < totalArmorPoint) {
                Pair<ItemStack, CustomArmorBar> am1 = armorPoints.get(idx1);
                Pair<ItemStack, CustomArmorBar> am2 = armorPoints.get(idx2);

                if (am1.getRight() == am2.getRight()) {
                    am1.getRight().draw(am1.getLeft(), context, xPos, yPos, false, false);
                } else {
                    am2.getRight().draw(am2.getLeft(), context, xPos, yPos, true, true);
                    am1.getRight().draw(am1.getLeft(), context, xPos, yPos, true, false);
                }
                continue;
            }

            // one point (half)
            if (idx1 < totalArmorPoint) {
                CustomArmorBar.EMPTY.draw(ItemStack.EMPTY, context, xPos, yPos, false, false);
                Pair<ItemStack, CustomArmorBar> am = armorPoints.get(idx1);
                am.getRight().draw(am.getLeft(), context, xPos, yPos, true, false);
                continue;
            }

            // empty
            CustomArmorBar.EMPTY.draw(ItemStack.EMPTY, context, xPos, yPos, false, false);
        }
    }

    /**
     * Copy of DetailABReconst getArmorPoints(player) logic, including:
     * - armor points from items
     * - item bars (elytra etc.)
     * - base armor attribute points
     * - attribute-modifier armor points
     * - special-item sorting behavior
     */
    private static List<Pair<ItemStack, CustomArmorBar>> getArmorPoints_CopyOfDetailAB(PlayerEntity player) {
        ArrayList<Pair<ItemStack, CustomArmorBar>> armorPoints = new ArrayList<>();
        ArrayList<Pair<ItemStack, CustomArmorBar>> itemPoints = new ArrayList<>();
        int sumArmor = 0;

        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ItemStack itemStack = player.getEquippedStack(slot);
            if (itemStack.isEmpty()) continue;

            int defense = getDefense_Copy(itemStack, slot);
            if (defense > 0) {
                CustomArmorBar barData = DetailArmorBar.getConfig().getOptions().toggleArmorTypes
                        ? DetailArmorBarAPI.getArmorBarList().getOrDefault(itemStack.getItem(), CustomArmorBar.DEFAULT)
                        : CustomArmorBar.DEFAULT;

                sumArmor += defense;
                for (int i = 0; i < defense; i++) {
                    armorPoints.add(new Pair<>(itemStack, barData));
                }
            }

            // Special item bar (elytra etc.)
            if (DetailArmorBar.getConfig().getOptions().toggleItemBar
                    && DetailArmorBarAPI.getItemBarList().containsKey(itemStack.getItem())) {

                Item item = itemStack.getItem();
                if (item instanceof ArmorItem armorItem) {
                    if (armorItem.getSlotType() != slot) continue;
                } else if (itemStack.isOf(Items.ELYTRA) && slot != EquipmentSlot.CHEST) {
                    continue;
                }

                CustomArmorBar barData = DetailArmorBarAPI.getItemBarList().get(itemStack.getItem());
                Pair<ItemStack, CustomArmorBar> pair = new Pair<>(itemStack, barData);

                if (DetailArmorBar.getConfig().getOptions().toggleSortSpecialItem) {
                    itemPoints.add(pair);
                    itemPoints.add(pair);
                } else {
                    if (armorPoints.size() % 2 == 1) {
                        armorPoints.add(new Pair<>(ItemStack.EMPTY, CustomArmorBar.EMPTY));
                    }
                    armorPoints.add(pair);
                    armorPoints.add(pair);
                }
            }
        }

        // Base armor attribute points (GENERIC_ARMOR base value)
        double baseArmor = player.getAttributeBaseValue(EntityAttributes.GENERIC_ARMOR);
        for (int i = 0; (double) i < baseArmor; i++) {
            armorPoints.add(new Pair<>(ItemStack.EMPTY, CustomArmorBar.DEFAULT));
        }

        // Sort special items after armor if enabled
        if (DetailArmorBar.getConfig().getOptions().toggleSortSpecialItem) {
            if (armorPoints.size() % 2 == 1) {
                armorPoints.add(new Pair<>(ItemStack.EMPTY, CustomArmorBar.EMPTY));
            }
            armorPoints.addAll(itemPoints);
        }

        return armorPoints;
    }

    /**
     * Copy of DetailABReconst getDefense(itemStack, slot):
     * - supports ArmorItem protection
     * - supports attribute-modifiers armor (GENERIC_ARMOR) in that equipment slot
     */
    private static int getDefense_Copy(ItemStack itemStack, EquipmentSlot slot) {
        Item item = itemStack.getItem();
        if (item instanceof ArmorItem armorItem) {
            if (armorItem.getSlotType() == slot) {
                return armorItem.getProtection();
            }
        }

        AttributeModifiersComponent modifier = itemStack.getOrDefault(
                DataComponentTypes.ATTRIBUTE_MODIFIERS,
                AttributeModifiersComponent.DEFAULT
        );

        for (AttributeModifiersComponent.Entry entry : modifier.modifiers()) {
            if (entry.slot().matches(slot) && entry.attribute().matches(EntityAttributes.GENERIC_ARMOR)) {
                return (int) entry.modifier().value();
            }
        }

        return 0;
    }
}
