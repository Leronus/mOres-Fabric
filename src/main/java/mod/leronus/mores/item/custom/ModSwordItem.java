package mod.leronus.mores.item.custom;

import mod.leronus.mores.item.ModItems;
import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ModSwordItem extends SwordItem {

    public ModSwordItem(ToolMaterial toolMaterial, Item.Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.getItem() instanceof ModSwordItem){
        tooltip.add(Text.literal(""));
        if (stack.getItem() == ModItems.ONYX_SWORD || stack.getItem() == ModItems.ONYX_MACE || stack.getItem() == ModItems.ONYX_DAGGER) {
            tooltip.add(Text.translatable("mores.bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.wither_effect").formatted(Formatting.DARK_GRAY)));
        }
        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(((ModSwordItem) stack.getItem()).getMaterial().getDurability())).formatted(Formatting.LIGHT_PURPLE)));
            if (stack.getItem() == ModItems.RUBY_SWORD || stack.getItem() == ModItems.RUBY_MACE || stack.getItem() == ModItems.RUBY_DAGGER) {
                tooltip.add(Text.translatable(Formatting.GRAY + "mores.bonus" + Formatting.RED + "Burn Effect"));
            }
        }
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
        //If the item is an onyx sword, apply wither effect on targetEntity
        if(stack.getItem() == ModItems.ONYX_SWORD || stack.getItem() == ModItems.ONYX_MACE || stack.getItem() == ModItems.ONYX_DAGGER) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 250, 1, false, false));
        }
        //If the item is a ruby sword, apply fire effect on targetEntity
        if(stack.getItem() == ModItems.RUBY_SWORD || stack.getItem() == ModItems.RUBY_MACE || stack.getItem() == ModItems.RUBY_DAGGER) {
            target.setOnFireFor(5);
        }
        return super.postHit(stack, target, attacker);
    }
}