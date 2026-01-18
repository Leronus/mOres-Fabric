package mod.leronus.mores.mixin;

import mod.leronus.mores.Mores;
import mod.leronus.mores.item.ModArmorMaterials;
import mod.leronus.mores.item.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.item.AnimalArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Applies potion/attribute bonuses to HORSES based on equipped BODY armor.
 *
 * - Keeps your existing LAPIS/TURQUOISE water logic.
 * - Adds: moissanite poison immunity, ruby fire resistance, tanzanite speed,
 *         onyx wither immunity, tourmaline regeneration, spinel extra hearts,
 *         amethyst slow falling.
 * - Obsidian explosion immunity is handled via AnimalArmorExplosionImmunityMixin.
 */
@Mixin(LivingEntity.class)
public abstract class HorseArmorEffectsMixin {

    // Existing water-movement efficiency modifier (used for lapis/turquoise water behavior)
    @Unique
    private static final Identifier MORES$WATER_EFF_ID =
            Identifier.of(Mores.MOD_ID, "horse_water_movement_efficiency");

    @Unique
    private static final EntityAttributeModifier MORES$WATER_EFF_MOD =
            new EntityAttributeModifier(
                    MORES$WATER_EFF_ID,
                    1.0D,
                    EntityAttributeModifier.Operation.ADD_VALUE
            );

    // Spinel extra hearts for animals
    @Unique
    private static final Identifier MORES$SPINEL_ANIMAL_MAX_HEALTH_ID =
            Identifier.of(Mores.MOD_ID, "spinel_animal_max_health_bonus");

    @Inject(method = "tickMovement", at = @At("TAIL"))
    private void mores$horseArmorEffects(CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (!(self instanceof AbstractHorseEntity horse)) return;
        if (!(horse.getWorld() instanceof ServerWorld)) return;

        ItemStack armorStack = horse.getEquippedStack(EquipmentSlot.BODY);
        ArmorMaterial material = getArmorMaterialOrNull(armorStack);

        // Always keep modifiers tidy (even if not touching water)
        EntityAttributeInstance waterEff = horse.getAttributeInstance(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY);
        if (waterEff != null && material != ModArmorMaterials.LAPIS_LAZULI.value() && material != ModArmorMaterials.TURQUOISE.value()) {
            EntityAttributeModifier existing = waterEff.getModifier(MORES$WATER_EFF_ID);
            if (existing != null) waterEff.removeModifier(existing);
        }

        // 1) Spinel extra hearts (+4 max health)
        applyOrRemoveSpinelMaxHealth(horse, material);

        // 2) Immunities (clear negative effects)
        if (material == ModArmorMaterials.MOISSANITE.value()) {
            horse.removeStatusEffect(StatusEffects.POISON);
        }
        if (material == ModArmorMaterials.ONYX.value()) {
            horse.removeStatusEffect(StatusEffects.WITHER);
        }

        // 3) Simple potion bonuses (short duration, constantly refreshed; no particles)
        if (material == ModArmorMaterials.RUBY.value()) {
            horse.addStatusEffect(sigEffect(StatusEffects.FIRE_RESISTANCE));
        }
        if (material == ModArmorMaterials.TANZANITE.value()) {
            horse.addStatusEffect(sigEffect(StatusEffects.SPEED));
        }
        if (material == ModArmorMaterials.TOURMALINE.value()) {
            horse.addStatusEffect(sigEffect(StatusEffects.REGENERATION));
        }
        if (material == ModArmorMaterials.AMETHYST.value()) {
            horse.addStatusEffect(sigEffect(StatusEffects.SLOW_FALLING));
        }

        // 4) Existing water special-casing for TURQUOISE + LAPIS
        boolean lapis = armorStack.isOf(ModItems.LAPIS_LAZULI_HORSE_ARMOR);
        boolean turquoise = armorStack.isOf(ModItems.TURQUOISE_HORSE_ARMOR);

        if (!horse.isTouchingWater()) return;

        // TURQUOISE: float + Dolphin's Grace
        if (turquoise) {
            Vec3d v = horse.getVelocity();
            if (horse.isSubmergedInWater()) {
                horse.setVelocity(v.x, Math.max(v.y, 0.06D), v.z);
            } else {
                horse.setVelocity(v.x, Math.max(v.y, 0.02D), v.z);
            }

            horse.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.DOLPHINS_GRACE,
                    40,
                    0,
                    true,
                    false,
                    false
            ));

            if (waterEff != null && waterEff.getModifier(MORES$WATER_EFF_ID) == null) {
                waterEff.addTemporaryModifier(MORES$WATER_EFF_MOD);
            }
            return;
        }

        // LAPIS: sink + water breathing
        if (lapis) {
            horse.setAir(horse.getMaxAir());

            if (horse.isSubmergedInWater()) {
                Vec3d v = horse.getVelocity();
                horse.setVelocity(v.x, v.y - 0.03D, v.z);
            }

            if (waterEff != null && waterEff.getModifier(MORES$WATER_EFF_ID) == null) {
                waterEff.addTemporaryModifier(MORES$WATER_EFF_MOD);
            }
        }
    }

    @Unique
    private static ArmorMaterial getArmorMaterialOrNull(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return null;
        if (!(stack.getItem() instanceof AnimalArmorItem aai)) return null;
        return aai.getMaterial().value();
    }

    @Unique
    private static StatusEffectInstance sigEffect(net.minecraft.registry.entry.RegistryEntry<net.minecraft.entity.effect.StatusEffect> effect) {
        return new StatusEffectInstance(effect, 40, 0, true, false, false);
    }

    @Unique
    private static void applyOrRemoveSpinelMaxHealth(LivingEntity entity, ArmorMaterial material) {
        EntityAttributeInstance maxHealth = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (maxHealth == null) return;

        boolean shouldHave = material == ModArmorMaterials.SPINEL.value();
        EntityAttributeModifier existing = maxHealth.getModifier(MORES$SPINEL_ANIMAL_MAX_HEALTH_ID);

        if (shouldHave) {
            if (existing == null) {
                maxHealth.addTemporaryModifier(new EntityAttributeModifier(
                        MORES$SPINEL_ANIMAL_MAX_HEALTH_ID,
                        4.0,
                        EntityAttributeModifier.Operation.ADD_VALUE
                ));
            }
        } else {
            if (existing != null) {
                maxHealth.removeModifier(existing);
                float max = (float) entity.getMaxHealth();
                if (entity.getHealth() > max) entity.setHealth(max);
            }
        }
    }
}
