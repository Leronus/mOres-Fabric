package mod.leronus.mores.handlers;

import mod.leronus.mores.config.ClientConfig;
import mod.leronus.mores.item.ModArmorMaterials;
import mod.leronus.mores.item.ModToolMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.List;

public final class ModTooltipHandler {
    private ModTooltipHandler() {}

    public static void appendCombatTooltips(ItemStack stack, List<Text> tooltip, TooltipType type) {
        if (!ClientConfig.extraTooltips) return;

        Item item = stack.getItem();

        removeMoresTooltipLines(tooltip);

        if (item instanceof ToolItem tool) {
            addToolSection(stack, tooltip, tool);
            return;
        }

        // IMPORTANT:
        // Some (or all) of your animal armors are ArmorItem with slot BODY.
        // Those must be treated as ANIMAL armor, not player armor.
        if (item instanceof ArmorItem armor) {
            if (armor.getSlotType() == EquipmentSlot.BODY) {
                addAnimalArmorSection(stack, tooltip);
            } else {
                addArmorSection(stack, tooltip, armor);
            }
            return;
        }

        if (item instanceof AnimalArmorItem) {
            addAnimalArmorSection(stack, tooltip);
        }
    }

    private static void addToolSection(ItemStack stack, List<Text> tooltip, ToolItem tool) {
        ToolMaterial mat = tool.getMaterial();

        tooltip.add(Text.literal(""));
        tooltip.add(durabilityLine(stack));

        if (tool instanceof MiningToolItem) {
            float speed = mat.getMiningSpeedMultiplier();
            tooltip.add(
                    Text.translatable("mores.efficiency").formatted(Formatting.GRAY)
                            .append(Text.literal(String.valueOf(speed)).formatted(Formatting.RED))
            );
        }

        Text bonus = toolBonusLine(mat);
        if (bonus != null) tooltip.add(bonus);
    }

    private static Text toolBonusLine(ToolMaterial toolMaterial) {
        if (toolMaterial == ModToolMaterials.ONYX) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.wither_effect").formatted(Formatting.DARK_GRAY));
        }
        if (toolMaterial == ModToolMaterials.RUBY) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.burn_effect").formatted(Formatting.DARK_RED));
        }
        return null;
    }

    private static void addArmorSection(ItemStack stack, List<Text> tooltip, ArmorItem armor) {
        var armorMaterial = armor.getMaterial().value();

        tooltip.add(Text.literal(""));
        tooltip.add(durabilityLine(stack));

        Text bonus = armorBonusLine(armorMaterial);
        if (bonus != null) tooltip.add(bonus);
    }

    /**
     * PLAYER ARMOR ONLY bonuses.
     */
    private static Text armorBonusLine(ArmorMaterial armorMaterial) {
        if (armorMaterial == ModArmorMaterials.HARDENED_STEEL.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.strength").formatted(Formatting.WHITE));
        } else if (armorMaterial == ModArmorMaterials.ROSE_GOLD.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.piglin_immunity").formatted(Formatting.GOLD));
        } else if (armorMaterial == ModArmorMaterials.GRAPHENE_CHAINMAIL.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.jump_boost").formatted(Formatting.YELLOW));
        } else if (armorMaterial == ModArmorMaterials.LAPIS_LAZULI.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.water_breathing").formatted(Formatting.AQUA));
        } else if (armorMaterial == ModArmorMaterials.TURQUOISE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.dolphins_grace").formatted(Formatting.AQUA));
        } else if (armorMaterial == ModArmorMaterials.AMETHYST.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.slow_falling").formatted(Formatting.YELLOW));
        } else if (armorMaterial == ModArmorMaterials.ONYX.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.wither_immunity").formatted(Formatting.DARK_GRAY));
        } else if (armorMaterial == ModArmorMaterials.CITRINE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.extra_block_reach").formatted(Formatting.GOLD));
        } else if (armorMaterial == ModArmorMaterials.TANZANITE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.speed").formatted(Formatting.WHITE));
        } else if (armorMaterial == ModArmorMaterials.TOURMALINE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.regeneration").formatted(Formatting.RED));
        } else if (armorMaterial == ModArmorMaterials.TOPAZ.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.haste").formatted(Formatting.GOLD));
        } else if (armorMaterial == ModArmorMaterials.SPINEL.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.extra_hearts").formatted(Formatting.RED));
        } else if (armorMaterial == ModArmorMaterials.RUBY.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.fire_resistance").formatted(Formatting.RED));
        } else if (armorMaterial == ModArmorMaterials.SAPPHIRE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.night_vision").formatted(Formatting.WHITE));
        } else if (armorMaterial == ModArmorMaterials.MOISSANITE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.poison_immunity").formatted(Formatting.GREEN));
        } else if (armorMaterial == ModArmorMaterials.OBSIDIAN.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.explosion_immunity").formatted(Formatting.DARK_PURPLE));
        } else if (armorMaterial == ModArmorMaterials.ENDERITE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.endermen_immunity").formatted(Formatting.DARK_PURPLE));
        }
        return null;
    }

    private static void addAnimalArmorSection(ItemStack stack, List<Text> tooltip) {
        tooltip.add(Text.literal(""));
        tooltip.add(durabilityLine(stack));

        ArmorMaterial mat = getAnimalArmorMaterialOrNull(stack);
        if (mat == null) return;

        Text bonus = animalArmorBonusLine(mat);
        if (bonus != null) tooltip.add(bonus);
    }

    /**
     * ANIMAL ARMOR ONLY bonuses.
     * Player-only: ROSE_GOLD, HARDENED_STEEL, CITRINE, TOPAZ, SAPPHIRE, ENDERITE are intentionally NOT shown.
     * (Emerald luck also skipped.)
     */
    private static Text animalArmorBonusLine(ArmorMaterial armorMaterial) {
        if (armorMaterial == ModArmorMaterials.LAPIS_LAZULI.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.water_breathing").formatted(Formatting.AQUA));
        } else if (armorMaterial == ModArmorMaterials.TURQUOISE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.dolphins_grace").formatted(Formatting.AQUA));
        } else if (armorMaterial == ModArmorMaterials.MOISSANITE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.poison_immunity").formatted(Formatting.GREEN));
        } else if (armorMaterial == ModArmorMaterials.RUBY.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.fire_resistance").formatted(Formatting.RED));
        } else if (armorMaterial == ModArmorMaterials.TANZANITE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.speed").formatted(Formatting.WHITE));
        } else if (armorMaterial == ModArmorMaterials.ONYX.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.wither_immunity").formatted(Formatting.DARK_GRAY));
        } else if (armorMaterial == ModArmorMaterials.TOURMALINE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.regeneration").formatted(Formatting.RED));
        } else if (armorMaterial == ModArmorMaterials.SPINEL.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.extra_hearts").formatted(Formatting.RED));
        } else if (armorMaterial == ModArmorMaterials.OBSIDIAN.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.explosion_immunity").formatted(Formatting.DARK_PURPLE));
        } else if (armorMaterial == ModArmorMaterials.AMETHYST.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.slow_falling").formatted(Formatting.YELLOW));
        }

        return null;
    }

    private static ArmorMaterial getAnimalArmorMaterialOrNull(ItemStack stack) {
        Item item = stack.getItem();

        // If you are using AnimalArmorItem
        if (item instanceof AnimalArmorItem animalArmor) {
            return animalArmor.getMaterial().value();
        }

        // If your animal armor is implemented as ArmorItem(BODY)
        if (item instanceof ArmorItem armor && armor.getSlotType() == EquipmentSlot.BODY) {
            return armor.getMaterial().value();
        }

        return null;
    }

    private static Text durabilityLine(ItemStack stack) {
        if (!stack.isDamageable() || stack.getMaxDamage() <= 0) {
            return Text.translatable("mores.durability").formatted(Formatting.GRAY)
                    .append(Text.literal("∞").formatted(Formatting.LIGHT_PURPLE));
        }

        return Text.translatable("mores.durability").formatted(Formatting.GRAY)
                .append(Text.literal(String.valueOf(stack.getMaxDamage())).formatted(Formatting.LIGHT_PURPLE));
    }

    private static void removeMoresTooltipLines(List<Text> tooltip) {
        String durabilityPrefix = Text.translatable("mores.durability").getString();
        String efficiencyPrefix = Text.translatable("mores.efficiency").getString();
        String bonusPrefix = Text.translatable("mores.bonus").getString();

        List<Integer> toRemove = new ArrayList<>();

        for (int i = 0; i < tooltip.size(); i++) {
            String s = tooltip.get(i).getString();

            boolean isOurLine =
                    s.startsWith(durabilityPrefix) ||
                            s.startsWith(efficiencyPrefix) ||
                            s.startsWith(bonusPrefix);

            if (isOurLine) {
                toRemove.add(i);

                if (i - 1 >= 0 && tooltip.get(i - 1).getString().isEmpty()) toRemove.add(i - 1);
                if (i + 1 < tooltip.size() && tooltip.get(i + 1).getString().isEmpty()) toRemove.add(i + 1);
            }
        }

        toRemove.stream().distinct().sorted((a, b) -> Integer.compare(b, a)).forEach(idx -> {
            if (idx >= 0 && idx < tooltip.size()) tooltip.remove((int) idx);
        });
    }
}
