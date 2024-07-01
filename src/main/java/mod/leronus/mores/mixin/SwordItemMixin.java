package mod.leronus.mores.mixin;

//import net.minecraft.item.Item;
//import org.spongepowered.asm.mixin.Mixin;
//
//@Mixin(net.minecraft.item.SwordItem.class)
//public class SwordItemMixin extends Item {
//	public SwordItemMixin(Settings settings) {
//		super(settings);
//	}
//	@Override
//	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
//		tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(stack.getItem().getMaxDamage())).formatted(Formatting.LIGHT_PURPLE)));
//	}
//}