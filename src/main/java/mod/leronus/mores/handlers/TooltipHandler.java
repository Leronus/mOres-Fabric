package mod.leronus.mores.handlers;

import mod.leronus.mores.config.ClientConfig;
import mod.leronus.mores.item.ModArmorMaterials;
import mod.leronus.mores.item.ModToolMaterials;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public final class TooltipHandler {
    private TooltipHandler() {}

    /**
     * Called from appendTooltip methods.
     * Safe to call from VanillaTooltipHook to affect vanilla items.
     */
    public static void appendCombatTooltips(ItemStack stack, List<Text> tooltip, TooltipType type) {
        if (!ClientConfig.extraTooltips) return;

        Item item = stack.getItem();

        /* =========================
           TOOLS / WEAPONS
           ========================= */
        if (item instanceof ToolItem tool) {
            ToolMaterial toolMaterial = tool.getMaterial();

            // Tool Bonus lines (Onyx Wither / Ruby Burn)
            if (toolMaterial == ModToolMaterials.ONYX) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.wither_effect").formatted(Formatting.DARK_GRAY))
                );
            } else if (toolMaterial == ModToolMaterials.RUBY) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.burn_effect").formatted(Formatting.DARK_RED))
                );
            }

            // Durability line (works for vanilla too)
            tooltip.add(Text.literal(""));
            tooltip.add(
                    Text.translatable("mores.durability").formatted(Formatting.GRAY)
                            .append(Text.literal(String.valueOf(stack.getMaxDamage())).formatted(Formatting.LIGHT_PURPLE))
            );

            // Efficiency line only for mining tools (pickaxe/axe/shovel/hoe)
            if (tool instanceof MiningToolItem) {
                tooltip.add(
                        Text.translatable("mores.efficiency").formatted(Formatting.GRAY)
                                .append(Text.literal(String.valueOf(toolMaterial.getMiningSpeedMultiplier())).formatted(Formatting.RED))
                );
            }

            return;
        }

        /* =========================
           ARMOR
           ========================= */
        if (item instanceof ArmorItem armor) {
            ArmorMaterial armorMaterial = armor.getMaterial().value();

            // Armor Bonus lines
            if (armorMaterial == ModArmorMaterials.HARDENED_STEEL.value()) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.strength").formatted(Formatting.RED))
                );
            } else if (armorMaterial == ModArmorMaterials.AMETHYST.value()) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.slow_falling").formatted(Formatting.DARK_PURPLE))
                );
            } else if (armorMaterial == ModArmorMaterials.EMERALD.value()) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.luck").formatted(Formatting.GREEN))
                );
            } else if (armorMaterial == ModArmorMaterials.TURQUOISE.value()) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.dolphins_grace").formatted(Formatting.AQUA))
                );
            } else if (armorMaterial == ModArmorMaterials.LAPIS_LAZULI.value()) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.water_breathing").formatted(Formatting.DARK_AQUA))
                );
            } else if (armorMaterial == ModArmorMaterials.TOPAZ.value()) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.haste").formatted(Formatting.GOLD))
                );
            } else if (armorMaterial == ModArmorMaterials.TOURMALINE.value()) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.regeneration").formatted(Formatting.DARK_PURPLE))
                );
            } else if (armorMaterial == ModArmorMaterials.RUBY.value()) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.fire_resistance").formatted(Formatting.DARK_RED))
                );
            } else if (armorMaterial == ModArmorMaterials.SAPPHIRE.value()) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.night_vision").formatted(Formatting.BLUE))
                );
            } else if (armorMaterial == ModArmorMaterials.MOISSANITE.value()) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.jump_boost").formatted(Formatting.GREEN))
                );
            } else if (armorMaterial == ModArmorMaterials.ONYX.value()) {
                tooltip.add(Text.literal(""));
                tooltip.add(
                        Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                                .append(Text.translatable("mores.wither_resistance").formatted(Formatting.DARK_GRAY))
                );
            }

            // Durability line (works for vanilla too)
            tooltip.add(Text.literal(""));
            tooltip.add(
                    Text.translatable("mores.durability").formatted(Formatting.GRAY)
                            .append(Text.literal(String.valueOf(stack.getMaxDamage())).formatted(Formatting.LIGHT_PURPLE))
            );
        }
    }
}
