package mod.leronus.mores.mixin;

import net.minecraft.client.item.TooltipType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(net.minecraft.item.SwordItem.class)
public class SwordItemMixin extends Item {
	public SwordItemMixin(Settings settings) {
		super(settings);
	}
	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(stack.getMaxDamage())).formatted(Formatting.LIGHT_PURPLE)));
	}
}