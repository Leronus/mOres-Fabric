package mod.leronus.mores.handlers;

import mod.leronus.mores.config.ClientConfig;
import mod.leronus.mores.item.ModArmorMaterials;
import mod.leronus.mores.item.ModToolMaterials;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.List;

public final class ModTooltipHandler {
    private ModTooltipHandler() {}

    /**
     * Called from ItemTooltipCallback (runs after vanilla has added the attribute section),
     * so we can guarantee our lines appear BELOW:
     * "When in main hand: ..."
     */
    public static void appendCombatTooltips(ItemStack stack, List<Text> tooltip, TooltipType type) {
        if (!ClientConfig.extraTooltips) return;

        Item item = stack.getItem();

        // 1) Remove any existing mores tooltip lines (from appendTooltip or earlier callbacks)
        //    so we can re-add them in a consistent order at the bottom.
        removeMoresTooltipLines(tooltip);

        // 2) Tools / Weapons
        if (item instanceof ToolItem tool) {
            addToolSection(stack, tooltip, tool);
            return;
        }

        // 3) Armor (player armor)
        if (item instanceof ArmorItem armor) {
            addArmorSection(stack, tooltip, armor);
            return;
        }

        // 4) Animal armor (horse + wolf armor in 1.21+)
        if (item instanceof AnimalArmorItem) {
            addAnimalArmorSection(stack, tooltip);
        }
    }

    /* -----------------------------
       TOOL SECTION
       Desired order:
       (vanilla attribute section)
       [blank line]
       Durability
       Efficiency (if present)
       Bonus (if present)
       ----------------------------- */
    private static void addToolSection(ItemStack stack, List<Text> tooltip, ToolItem tool) {
        ToolMaterial mat = tool.getMaterial();

        tooltip.add(Text.literal(""));

        // Durability (∞ if unbreakable / non-damageable)
        tooltip.add(durabilityLine(stack));

        // Efficiency (mining tools only)
        if (tool instanceof MiningToolItem) {
            float speed = mat.getMiningSpeedMultiplier();
            tooltip.add(
                    Text.translatable("mores.efficiency").formatted(Formatting.GRAY)
                            .append(Text.literal(String.valueOf(speed)).formatted(Formatting.RED))
            );
        }

        // Bonus (Onyx/Ruby)
        Text bonus = toolBonusLine(mat);
        if (bonus != null) {
            tooltip.add(bonus);
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
        return null;
    }

    /* -----------------------------
       ARMOR SECTION
       Put durability first, then bonus (same ordering logic you wanted).
       ----------------------------- */
    private static void addArmorSection(ItemStack stack, List<Text> tooltip, ArmorItem armor) {
        var armorMaterial = armor.getMaterial().value();

        tooltip.add(Text.literal(""));
        tooltip.add(durabilityLine(stack));

        Text bonus = armorBonusLine(armorMaterial);
        if (bonus != null) {
            tooltip.add(bonus);
        }
    }

    private static Text armorBonusLine(ArmorMaterial armorMaterial) {
        if (armorMaterial == ModArmorMaterials.HARDENED_STEEL.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.strength").formatted(Formatting.RED));
        } else if (armorMaterial == ModArmorMaterials.AMETHYST.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.night_vision").formatted(Formatting.DARK_PURPLE));
        } else if (armorMaterial == ModArmorMaterials.TANZANITE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.speed").formatted(Formatting.AQUA));
        } else if (armorMaterial == ModArmorMaterials.TOURMALINE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.resistance").formatted(Formatting.GRAY));
        } else if (armorMaterial == ModArmorMaterials.RUBY.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.fire_resistance").formatted(Formatting.GOLD));
        } else if (armorMaterial == ModArmorMaterials.SAPPHIRE.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.regeneration").formatted(Formatting.LIGHT_PURPLE));
        } else if (armorMaterial == ModArmorMaterials.SPINEL.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.absorption").formatted(Formatting.YELLOW));
        } else if (armorMaterial == ModArmorMaterials.LAPIS_LAZULI.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.water_breathing").formatted(Formatting.DARK_AQUA));
        } else if (armorMaterial == ModArmorMaterials.TOPAZ.value()) {
            return Text.translatable("mores.bonus").formatted(Formatting.GRAY)
                    .append(Text.translatable("mores.haste").formatted(Formatting.GOLD));
        }
        return null;
    }

    /* -----------------------------
       ANIMAL ARMOR SECTION (horse + wolf)
       Vanilla horse armor showing 0 durability is normal because it’s not damageable.
       We show ∞ instead, and now your mores horse/wolf armor will also show it.
       ----------------------------- */
    private static void addAnimalArmorSection(ItemStack stack, List<Text> tooltip) {
        tooltip.add(Text.literal(""));
        tooltip.add(durabilityLine(stack));
    }

    /* -----------------------------
       Durability line helper
       - If item is damageable: show max durability
       - If not damageable (horse armor etc): show ∞
       ----------------------------- */
    private static Text durabilityLine(ItemStack stack) {
        if (!stack.isDamageable() || stack.getMaxDamage() <= 0) {
            return Text.translatable("mores.durability").formatted(Formatting.GRAY)
                    .append(Text.literal("∞").formatted(Formatting.LIGHT_PURPLE));
        }

        return Text.translatable("mores.durability").formatted(Formatting.GRAY)
                .append(Text.literal(String.valueOf(stack.getMaxDamage())).formatted(Formatting.LIGHT_PURPLE));
    }

    /* -----------------------------
       Removal / normalization
       Removes:
       - "Durability ..." line
       - "Efficiency ..." line
       - "Bonus ..." line
       - any empty spacer lines adjacent to those
       ----------------------------- */
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

                // remove one spacer line before/after if it’s an empty line
                if (i - 1 >= 0 && tooltip.get(i - 1).getString().isEmpty()) toRemove.add(i - 1);
                if (i + 1 < tooltip.size() && tooltip.get(i + 1).getString().isEmpty()) toRemove.add(i + 1);
            }
        }

        // Remove duplicates + remove from end so indices don’t shift
        toRemove.stream().distinct().sorted((a, b) -> Integer.compare(b, a)).forEach(idx -> {
            if (idx >= 0 && idx < tooltip.size()) tooltip.remove((int) idx);
        });
    }
}
