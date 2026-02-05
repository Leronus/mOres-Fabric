package mod.leronus.mores.item.custom;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import mod.leronus.mores.Mores;
import mod.leronus.mores.handlers.ModTooltipHandler;
import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.mixin.access.LivingEntityAccessor;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModBattleMaceItem extends SwordItem {
    public ModBattleMaceItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    private static final Identifier CITRINE_BLOCK_REACH_ID =
            Identifier.of(Mores.MOD_ID, "citrine_block_reach");
    private static final Identifier CITRINE_ENTITY_REACH_ID =
            Identifier.of(Mores.MOD_ID, "citrine_entity_reach");

    /**
     * Called when an enemy is attacked using the sword
     * @param stack Itemstack used to attack with
     * @param target Target entity that is being attacked
     * @param attacker The entity attacking the enemy
     * @return Hurt enemy
     */
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        //If the item is a moissanite sword, apply poison effect on targetEntity
        if(stack.getItem() == ModItems.AMETHYST_BATTLE_MACE) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 250, 1, false, false));
        }
        //If the item is an onyx battle_mace, apply wither effect on targetEntity
        if(stack.getItem() == ModItems.ONYX_BATTLE_MACE) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 250, 1, false, false));
        }
        //If the item is a ruby sword, apply fire effect on targetEntity
        if(stack.getItem() == ModItems.RUBY_BATTLE_MACE) {
            target.setOnFireFor(5);
        }
        //If the item is a sapphire sword, apply glowing effect on targetEntity
        if(stack.getItem() == ModItems.SAPPHIRE_BATTLE_MACE || stack.getItem() == ModItems.SAPPHIRE_DAGGER) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 250, 1, false, false));
        }
        //If the item is a moissanite sword, apply poison effect on targetEntity
        if(stack.getItem() == ModItems.MOISSANITE_BATTLE_MACE) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 250, 1, false, false));
        }

        // Spinel lifesteal (~13% = ~½ heart per hit at 7.5 damage)
        if (!attacker.getWorld().isClient
                && (stack.getItem() == ModItems.SPINEL_BATTLE_MACE)
                && attacker instanceof LivingEntity) {

            float dealt = ((LivingEntityAccessor) target).mores$getLastDamageTaken();

            // ~13% lifesteal
            float heal = dealt * 0.133f;

            if (heal > 0.0f) {
                attacker.heal(heal);
            }
        }

        // Only do shield logic server-side
        if (!attacker.getWorld().isClient && target instanceof PlayerEntity player) {
            // Player must be actively using an item (blocking)
            if (player.isUsingItem()) {
                ItemStack active = player.getActiveItem();
                Item activeItem = active.getItem();

                // Works for vanilla shield + most modded shields (ShieldItem)
                if (activeItem instanceof ShieldItem || active.isOf(Items.SHIELD) || activeItem instanceof FabricShieldItem) {
                     //sprint & chance-based disable (more "classic axe" feel)
                     float chance = attacker.isSprinting() ? 1.0f : 0.25f;
                     if (attacker.getWorld().random.nextFloat() < chance) {
                         player.disableShield();
                     }
                }
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
