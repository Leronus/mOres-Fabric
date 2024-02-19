package mod.leronus.mores.item.custom;

import mod.leronus.mores.item.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBattleAxeItem extends SwordItem {
    public ModBattleAxeItem(ToolMaterial toolMaterial, int attackDamageModifier, float attackSpeedModifier, Item.Settings settings) {
        super(toolMaterial, attackDamageModifier, attackSpeedModifier, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.getItem() instanceof ModBattleAxeItem){
//            tooltip.add(Text.literal(""));
//            if (stack.getItem() == ModItems.ONYX_BATTLEAXE) {
//                tooltip.add(Text.translatable("mores.bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.wither_effect").formatted(Formatting.DARK_GRAY)));
//            }
            tooltip.add(Text.literal(""));
            tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(stack.getItem().getMaxDamage())).formatted(Formatting.LIGHT_PURPLE)));
//            if (stack.getItem() == ModItems.RUBY_SWORD || stack.getItem() == ModItems.RUBY_MACE || stack.getItem() == ModItems.RUBY_BATTLEAXE || stack.getItem() == ModItems.RUBY_DAGGER) {
//                tooltip.add(Text.translatable(Formatting.GRAY + "mores.bonus" + Formatting.RED + "Burn Effect"));
//            }
        }
    }
}
