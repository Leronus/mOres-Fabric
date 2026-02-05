package mod.leronus.mores.item.custom;

import mod.leronus.mores.Mores;
import mod.leronus.mores.handlers.ModTooltipHandler;
import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.mixin.access.LivingEntityAccessor;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModAxeItem extends AxeItem {
    public ModAxeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    private static final Identifier CITRINE_BLOCK_REACH_ID =
            Identifier.of(Mores.MOD_ID, "citrine_block_reach");
    private static final Identifier CITRINE_ENTITY_REACH_ID =
            Identifier.of(Mores.MOD_ID, "citrine_entity_reach");

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //If the item is a moissanite sword, apply poison effect on targetEntity
        if(stack.getItem() == ModItems.AMETHYST_AXE) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 250, 1, false, false));
        }
        //If the item is an onyx axe, apply wither effect on targetEntity
        if(stack.getItem() == ModItems.ONYX_AXE) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 250, 1, false, false));
        }
        //If the item is a ruby axe, apply fire effect on targetEntity
        if(stack.getItem() == ModItems.RUBY_AXE) {
            target.setOnFireFor(5);
        }
        //If the item is a sapphire sword, apply glowing effect on targetEntity
        if(stack.getItem() == ModItems.SAPPHIRE_AXE || stack.getItem() == ModItems.SAPPHIRE_DAGGER) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 250, 1, false, false));
        }
        //If the item is a moissanite axe, apply poison effect on targetEntity
        if(stack.getItem() == ModItems.MOISSANITE_AXE) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 250, 1, false, false));
        }
        // Spinel lifesteal (~13% = ~½ heart per hit at 7.5 damage)
        if (!attacker.getWorld().isClient
                && (stack.getItem() == ModItems.SPINEL_AXE)
                && attacker instanceof LivingEntity) {

            float dealt = ((LivingEntityAccessor) target).mores$getLastDamageTaken();

            // ~13% lifesteal
            float heal = dealt * 0.133f;

            if (heal > 0.0f) {
                attacker.heal(heal);
            }
        }
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
