package mod.leronus.mores.item.custom;

import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.item.ModToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ModHoeItem extends HoeItem {
    public ModHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //If the item is an onyx battleaxe, apply wither effect on targetEntity
        if(stack.getItem() == ModItems.ONYX_HOE) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 250, 1, false, false));
        }
        //If the item is a ruby sword, apply fire effect on targetEntity
        if(stack.getItem() == ModItems.RUBY_HOE) {
            target.setOnFireFor(5);
        }
        return super.postHit(stack, target, attacker);
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
