package mod.leronus.mores.item.custom;

import mod.leronus.mores.item.ModItems;
import net.minecraft.client.item.TooltipType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ModBattleAxeItem extends SwordItem {
    public ModBattleAxeItem(ToolMaterial toolMaterial, int attackDamageModifier, float attackSpeedModifier, Item.Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.getItem() instanceof ModBattleAxeItem){
            tooltip.add(Text.literal(""));
            if (stack.getItem() == ModItems.ONYX_BATTLEAXE) {
                tooltip.add(Text.translatable("mores.bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.wither_effect").formatted(Formatting.DARK_GRAY)));
            }
            tooltip.add(Text.literal(""));
            tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(((ModBattleAxeItem) stack.getItem()).getMaterial().getDurability())).formatted(Formatting.LIGHT_PURPLE)));
            if (stack.getItem() == ModItems.RUBY_SWORD || stack.getItem() == ModItems.RUBY_MACE || stack.getItem() == ModItems.RUBY_BATTLEAXE || stack.getItem() == ModItems.RUBY_DAGGER) {
                tooltip.add(Text.translatable(Formatting.GRAY + "mores.bonus" + Formatting.RED + "Burn Effect"));
            }
        }
    }
}
