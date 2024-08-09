package mod.leronus.mores.item.custom;

import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.item.ModToolMaterials;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
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
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.getItem() instanceof MiningToolItem item) {
            tooltip.add(Text.literal(""));
            if (((ToolItem) stack.getItem()).getMaterial() == ModToolMaterials.ONYX) {
                tooltip.add(Text.translatable("mores.bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.wither_effect").formatted(Formatting.DARK_GRAY)));
            }
            if (((ToolItem) stack.getItem()).getMaterial() == ModToolMaterials.RUBY) {
                tooltip.add(Text.translatable("mores.bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.burn_effect").formatted(Formatting.DARK_RED)));
            }
            tooltip.add(Text.literal(""));
            tooltip.add(Text.translatable("mores.harvest_level").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(item.getMaterial().getMiningLevel())).formatted(Formatting.GOLD)));
            tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(item.getMaxDamage())).formatted(Formatting.LIGHT_PURPLE)));
            tooltip.add(Text.translatable("mores.efficiency").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(item.getMaterial().getMiningSpeedMultiplier())).formatted(Formatting.RED)));
        }
    }
}
