package mod.leronus.mores.item.custom;

import mod.leronus.mores.Mores;
import mod.leronus.mores.handlers.ModTooltipHandler;
import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.mixin.access.LivingEntityAccessor;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModBattleMaceItem extends SwordItem {

    private static final Identifier CITRINE_BLOCK_REACH_ID =
            Identifier.of(Mores.MOD_ID, "citrine_block_reach");
    private static final Identifier CITRINE_ENTITY_REACH_ID =
            Identifier.of(Mores.MOD_ID, "citrine_entity_reach");

    public ModBattleMaceItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // ===== On-hit effects =====
        if (stack.isOf(ModItems.AMETHYST_BATTLE_MACE)) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 250, 1, false, false));
        }

        if (stack.isOf(ModItems.ONYX_BATTLE_MACE)) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 250, 1, false, false));
        }

        if (stack.isOf(ModItems.RUBY_BATTLE_MACE)) {
            target.setOnFireFor(5);
        }

        if (stack.isOf(ModItems.SAPPHIRE_BATTLE_MACE) || stack.isOf(ModItems.SAPPHIRE_DAGGER)) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 250, 1, false, false));
        }

        if (stack.isOf(ModItems.MOISSANITE_BATTLE_MACE)) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 250, 1, false, false));
        }

        // ===== Spinel lifesteal (~13%) =====
        if (!attacker.getWorld().isClient && stack.isOf(ModItems.SPINEL_BATTLE_MACE)) {
            float dealt = ((LivingEntityAccessor) target).mores$getLastDamageTaken();
            float heal = dealt * 0.133f;
            if (heal > 0.0f) {
                attacker.heal(heal);
            }
        }

        // IMPORTANT:
        // Shield disabling is handled by the mixin on LivingEntity.takeShieldHit(...)
        // so it runs when hits are BLOCKED (the correct path), not only on landed damage.

        return super.postHit(stack, target, attacker);
    }

    public static AttributeModifiersComponent addReach(AttributeModifiersComponent base, double blocks) {
        return base
                .with(
                        EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                        new EntityAttributeModifier(
                                CITRINE_BLOCK_REACH_ID,
                                blocks,
                                EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.MAINHAND
                )
                .with(
                        EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE,
                        new EntityAttributeModifier(
                                CITRINE_ENTITY_REACH_ID,
                                blocks,
                                EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.MAINHAND
                );
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        ModTooltipHandler.appendCombatTooltips(stack, tooltip, type);
    }
}
