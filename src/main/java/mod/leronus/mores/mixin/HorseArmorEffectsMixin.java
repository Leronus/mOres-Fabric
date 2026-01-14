package mod.leronus.mores.mixin;

import mod.leronus.mores.Mores;
import mod.leronus.mores.item.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class HorseArmorEffectsMixin {

    @Unique
    private static final Identifier MORES$WATER_EFF_ID =
            Identifier.of(Mores.MOD_ID, "horse_water_movement_efficiency");

    @Unique
    private static final EntityAttributeModifier MORES$WATER_EFF_MOD =
            new EntityAttributeModifier(
                    MORES$WATER_EFF_ID,
                    1.0D, // tune: 0.5–2.0 (higher = faster in water)
                    EntityAttributeModifier.Operation.ADD_VALUE
            );

    @Inject(method = "tickMovement", at = @At("TAIL"))
    private void mores$horseArmorWaterLogic(CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;

        if (!(self instanceof AbstractHorseEntity horse)) return;
        if (!(horse.getWorld() instanceof ServerWorld)) return;

        ItemStack armor = horse.getEquippedStack(EquipmentSlot.BODY);
        boolean lapis = armor.isOf(ModItems.LAPIS_LAZULI_HORSE_ARMOR);
        boolean turquoise = armor.isOf(ModItems.TURQUOISE_HORSE_ARMOR);

        // If neither armor is equipped, remove our water speed modifier if present.
        EntityAttributeInstance eff = horse.getAttributeInstance(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY);
        if (eff != null) {
            EntityAttributeModifier existing = eff.getModifier(MORES$WATER_EFF_ID);
            if (!lapis && !turquoise) {
                if (existing != null) eff.removeModifier(existing);
            }
        }

        // Only care about water behavior when touching water
        if (!horse.isTouchingWater()) return;

        // TURQUOISE: float + Dolphin's Grace (surface swimmer vibe)
        if (turquoise) {
            // Keep the horse from sinking: if it goes under, push it back up a bit.
            Vec3d v = horse.getVelocity();
            if (horse.isSubmergedInWater()) {
                // stronger upward push if fully submerged
                horse.setVelocity(v.x, Math.max(v.y, 0.06D), v.z);
            } else {
                // mild buoyancy while touching water
                horse.setVelocity(v.x, Math.max(v.y, 0.02D), v.z);
            }

            // Dolphin's Grace (refresh constantly)
            horse.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.DOLPHINS_GRACE,
                    40,
                    0,
                    true,
                    false,
                    false
            ));

            // (Optional) tiny speed help so it feels good on water
            if (eff != null && eff.getModifier(MORES$WATER_EFF_ID) == null) {
                eff.addTemporaryModifier(MORES$WATER_EFF_MOD);
            }

            return; // do not apply lapis sinking logic
        }

        // LAPIS: sink + water breathing (underwater rider vibe)
        if (lapis) {
            // Water breathing for the HORSE (prevents drowning / forced surfacing behavior)
            horse.setAir(horse.getMaxAir());

            // Sinking feel like skeleton horse: when submerged, apply a gentle downward bias.
            if (horse.isSubmergedInWater()) {
                Vec3d v = horse.getVelocity();
                horse.setVelocity(v.x, v.y - 0.03D, v.z); // tune: 0.02–0.06
            }

            // Make underwater movement less restrictive than vanilla horse
            if (eff != null && eff.getModifier(MORES$WATER_EFF_ID) == null) {
                eff.addTemporaryModifier(MORES$WATER_EFF_MOD);
            }
        }
    }
}
