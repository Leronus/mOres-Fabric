package mod.leronus.mores.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModHoeItem extends HoeItem {
    public ModHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.getItem() instanceof MiningToolItem item) {
            //            if (item.getMaterial() == ModToolMaterials.RUBY){
//                tooltip.add(Text.literal(""));
//                tooltip.add(Text.translatable("mores.bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.auto_smelt").formatted(Formatting.DARK_RED)));
//            }
            tooltip.add(Text.literal(""));
            tooltip.add(Text.translatable("mores.harvest_level").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(item.getMaterial().getMiningLevel())).formatted(Formatting.GOLD)));
            tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(item.getMaxDamage())).formatted(Formatting.LIGHT_PURPLE)));
            tooltip.add(Text.translatable("mores.efficiency").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(item.getMaterial().getMiningSpeedMultiplier())).formatted(Formatting.RED)));
        }
    }
}
