package mod.leronus.mores.handlers;

import mod.leronus.mores.config.ClientConfig;
import mod.leronus.mores.item.ModArmorMaterials;
import mod.leronus.mores.item.ModToolMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class ModTooltipHandler {
    private ModTooltipHandler() {}

    public static void appendCombatTooltips(ItemStack stack, List<Text> tooltip, TooltipType type) {
        if (!ClientConfig.extraTooltips) return;

        Item item = stack.getItem();

        // remove our own previous lines (if tooltip is rebuilt multiple times)
        removeMoresTooltipLines(tooltip);

        // Tools / weapons
        if (item instanceof ToolItem tool) {
            addToolSection(stack, tooltip, tool);
            return;
        }

        // Armor (player armor vs animal armor implemented as ArmorItem(BODY))
        if (item instanceof ArmorItem armor) {
            if (armor.getSlotType() == EquipmentSlot.BODY) {
                addAnimalArmorSection(stack, tooltip);
            } else {
                addArmorSection(stack, tooltip, armor);
            }
        }
    }

    // -------------------------------------------------------------------------
    // TOOL SECTION
    // -------------------------------------------------------------------------

    private static void addToolSection(ItemStack stack, List<Text> tooltip, ToolItem tool) {
        ToolMaterial mat = tool.getMaterial();

        // Extra: battle axe penalty / battle mace shield behavior
        addWeaponSpecialLines(stack, tooltip, tool);

        tooltip.add(Text.literal(""));
        tooltip.add(durabilityLine(stack));

        // Mining efficiency line for actual mining tools
        if (tool instanceof MiningToolItem) {
            float speed = mat.getMiningSpeedMultiplier();
            tooltip.add(
                    Text.translatable("mores.efficiency").formatted(Formatting.GRAY)
                            .append(Text.literal(String.valueOf(speed)).formatted(Formatting.RED))
            );
        }

        // Material-based bonuses (onyx/ruby tool effects etc)
        Text bonus = toolBonusLine(mat);
        if (bonus != null) tooltip.add(bonus);
    }

    /**
     * Adds special tooltip lines that depend on the specific weapon type/name.
     *
     * - Battle Axe: show "-50% mining speed"
     * - Battle Mace: show shield disable behavior text
     */
    private static void addWeaponSpecialLines(ItemStack stack, List<Text> tooltip, ToolItem tool) {
        String id = tool.toString().toLowerCase();

        // Battle Axe: mining penalty line
        // (You asked for a lang entry that shows -50% mining speed.)
        if (id.contains("battle_axe")) {
            tooltip.add(Text.translatable("mores.battle_axe_penalty").formatted(Formatting.DARK_RED));
        }

        // Battle Mace: shield disable behavior description
        // Best phrasing: clear + short + avoids hardcoding % in UI.
        if (id.contains("battle_mace")) {
            tooltip.add(Text.translatable("mores.battle_mace_shield_on_hit").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("mores.battle_mace_shield_chance").formatted(Formatting.DARK_GREEN));
            tooltip.add(Text.translatable("mores.battle_mace_shield_on_hit_when_sprinting").formatted(Formatting.GRAY));
            tooltip.add(Text.translatable("mores.battle_mace_shield_sprinting").formatted(Formatting.DARK_GREEN));
        }
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
        if (toolMaterial == ModToolMaterials.MOISSANITE) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.poison_effect").formatted(Formatting.GREEN));
        }
        if (toolMaterial == ModToolMaterials.SAPPHIRE) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.glowing_effect").formatted(Formatting.AQUA));
        }
        if (toolMaterial == ModToolMaterials.AMETHYST) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.levitating_effect").formatted(Formatting.YELLOW));
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // PLAYER ARMOR SECTION
    // -------------------------------------------------------------------------

    private static void addArmorSection(ItemStack stack, List<Text> tooltip, ArmorItem armor) {
        ArmorMaterial armorMaterial = armor.getMaterial().value();

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

    // -------------------------------------------------------------------------
    // ANIMAL ARMOR SECTION (ArmorItem slot BODY)
    // -------------------------------------------------------------------------

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

        // Your project implements animal armor as ArmorItem(BODY)
        if (item instanceof ArmorItem armor && armor.getSlotType() == EquipmentSlot.BODY) {
            return armor.getMaterial().value();
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // DURABILITY LINE
    // -------------------------------------------------------------------------

    private static Text durabilityLine(ItemStack stack) {
        if (!stack.isDamageable() || stack.getMaxDamage() <= 0) {
            return Text.translatable("mores.durability").formatted(Formatting.GRAY)
                    .append(Text.literal("∞").formatted(Formatting.LIGHT_PURPLE));
        }
        return Text.translatable("mores.durability").formatted(Formatting.GRAY)
                .append(Text.literal(String.valueOf(stack.getMaxDamage())).formatted(Formatting.LIGHT_PURPLE));
    }

    // -------------------------------------------------------------------------
    // REMOVE PREVIOUS LINES (prevents duplication)
    // -------------------------------------------------------------------------

    private static void removeMoresTooltipLines(List<Text> tooltip) {
        String durabilityPrefix = Text.translatable("mores.durability").getString();
        String efficiencyPrefix = Text.translatable("mores.efficiency").getString();
        String bonusPrefix = Text.translatable("mores.bonus").getString();

        // Also remove our new special lines
        String battleAxePenalty = Text.translatable("mores.battle_axe_penalty").getString();
        String maceSprint = Text.translatable("mores.battle_mace_shield_sprinting").getString();
        String maceWhenSprint = Text.translatable("mores.battle_mace_shield_on_hit_when_sprinting").getString();
        String maceOnHit = Text.translatable("mores.battle_mace_shield_on_hit").getString();
        String maceChance = Text.translatable("mores.battle_mace_shield_chance").getString();

        List<Integer> toRemove = new ArrayList<>();

        for (int i = 0; i < tooltip.size(); i++) {
            String s = tooltip.get(i).getString();

            boolean isOurLine =
                    s.startsWith(durabilityPrefix) ||
                            s.startsWith(efficiencyPrefix) ||
                            s.startsWith(bonusPrefix) ||
                            s.equals(battleAxePenalty) ||
                            s.equals(maceSprint) ||
                            s.equals(maceWhenSprint) ||
                            s.equals(maceOnHit) ||
                            s.equals(maceChance);

            if (isOurLine) {
                toRemove.add(i);

                // remove surrounding blank lines if present
                if (i - 1 >= 0 && tooltip.get(i - 1).getString().isEmpty()) toRemove.add(i - 1);
                if (i + 1 < tooltip.size() && tooltip.get(i + 1).getString().isEmpty()) toRemove.add(i + 1);
            }
        }

        toRemove.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(idx -> {
                    if (idx >= 0 && idx < tooltip.size()) tooltip.remove((int) idx);
                });
    }
}
