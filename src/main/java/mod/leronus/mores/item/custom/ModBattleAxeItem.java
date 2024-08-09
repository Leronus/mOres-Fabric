package mod.leronus.mores.item.custom;

import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.item.ModToolMaterials;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBattleAxeItem extends SwordItem {
    public ModBattleAxeItem(ToolMaterial toolMaterial, int attackDamageModifier, float attackSpeedModifier, Item.Settings settings) {
        super(toolMaterial, attackDamageModifier, attackSpeedModifier, settings);
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
        if(stack.getItem() == ModItems.ONYX_BATTLEAXE) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 250, 1, false, false));
        }
        //If the item is a ruby sword, apply fire effect on targetEntity
        if(stack.getItem() == ModItems.RUBY_BATTLEAXE) {
            target.setOnFireFor(5);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.getItem() instanceof ModBattleAxeItem){
            tooltip.add(Text.literal(""));
            if (((ToolItem) stack.getItem()).getMaterial() == ModToolMaterials.ONYX) {
                tooltip.add(Text.translatable("mores.bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.wither_effect").formatted(Formatting.DARK_GRAY)));
            }
            if (((ToolItem) stack.getItem()).getMaterial() == ModToolMaterials.RUBY) {
                tooltip.add(Text.translatable("mores.bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.burn_effect").formatted(Formatting.DARK_RED)));
            }
            tooltip.add(Text.literal(""));
            tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(stack.getItem().getMaxDamage())).formatted(Formatting.LIGHT_PURPLE)));
        }
    }
}
