package mod.leronus.mores.item.custom;

import mod.leronus.mores.item.ModToolMaterials;
import net.minecraft.client.item.TooltipType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ModAxeItem extends AxeItem {
    public ModAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.getItem() instanceof MiningToolItem item) {
                        if (item.getMaterial() == ModToolMaterials.RUBY){
                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable("mores.bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.auto_smelt").formatted(Formatting.DARK_RED)));
            }
            tooltip.add(Text.literal(""));
//            tooltip.add(Text.translatable("mores.harvest_level").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(item.getMaterial().getMiningLevel())).formatted(Formatting.GOLD)));
            tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(item.getMaterial().getDurability())).formatted(Formatting.LIGHT_PURPLE)));
            tooltip.add(Text.translatable("mores.efficiency").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(item.getMaterial().getMiningSpeedMultiplier())).formatted(Formatting.RED)));
        }
    }
}
