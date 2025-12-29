package mod.leronus.mores.item.custom;

import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.item.ModToolMaterials;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ModBattleAxeItem extends SwordItem {
    public ModBattleAxeItem(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, settings);
    }

    /**
     * Called when an enemy is attacked using the sword
     * @param stack Itemstack used to attack with
     * @param target Target entity that is being attacked
     * @param attacker The entity attacking the enemy
     * @return Hurt enemy
     */
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //If the item is an onyx battleaxe, apply wither effect on targetEntity
        if(stack.getItem() == ModItems.ONYX_BATTLE_AXE) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 250, 1, false, false));
        }
        //If the item is a ruby sword, apply fire effect on targetEntity
        if(stack.getItem() == ModItems.RUBY_BATTLE_AXE) {
            target.setOnFireFor(5);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.getItem() instanceof ModBattleAxeItem){
            if (((ToolItem) stack.getItem()).getMaterial() == ModToolMaterials.ONYX) {
                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable("mores.bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.wither_effect").formatted(Formatting.DARK_GRAY)));
            }
            if (((ToolItem) stack.getItem()).getMaterial() == ModToolMaterials.RUBY) {
                tooltip.add(Text.literal(""));
                tooltip.add(Text.translatable("mores.bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.burn_effect").formatted(Formatting.DARK_RED)));
            }
            tooltip.add(Text.literal(""));
            tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(((ModBattleAxeItem) stack.getItem()).getMaterial().getDurability())).formatted(Formatting.LIGHT_PURPLE)));
        }
    }
}
