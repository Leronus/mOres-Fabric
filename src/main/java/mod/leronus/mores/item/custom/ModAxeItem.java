package mod.leronus.mores.item.custom;

import mod.leronus.mores.handlers.ModTooltipHandler;
import mod.leronus.mores.item.ModItems;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.text.Text;

import java.util.List;

public class ModAxeItem extends AxeItem {
    public ModAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //If the item is an onyx battleaxe, apply wither effect on targetEntity
        if(stack.getItem() == ModItems.ONYX_AXE) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 250, 1, false, false));
        }
        //If the item is a ruby sword, apply fire effect on targetEntity
        if(stack.getItem() == ModItems.RUBY_AXE) {
            target.setOnFireFor(5);
        }
        return super.postHit(stack, target, attacker);
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        ModTooltipHandler.appendCombatTooltips(stack, tooltip, type);
    }
}
