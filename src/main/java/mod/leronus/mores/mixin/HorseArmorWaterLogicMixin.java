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
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class HorseArmorWaterLogicMixin {

    @Unique
    private static final Identifier MORES$TURQUOISE_WATER_EFF_ID =
            Identifier.of(Mores.MOD_ID, "turquoise_horse_water_eff");

    @Unique
    private static final Identifier MORES$LAPIS_WATER_EFF_ID =
            Identifier.of(Mores.MOD_ID, "lapis_horse_water_eff");

    @Unique
    private static final EntityAttributeModifier MORES$TURQUOISE_WATER_EFF =
            new EntityAttributeModifier(
                    MORES$TURQUOISE_WATER_EFF_ID,
                    0.5D,
                    EntityAttributeModifier.Operation.ADD_VALUE
            );

    @Unique
    private static final EntityAttributeModifier MORES$LAPIS_WATER_EFF =
            new EntityAttributeModifier(
                    MORES$LAPIS_WATER_EFF_ID,
                    0.9D,
                    EntityAttributeModifier.Operation.ADD_VALUE
            );

    @Inject(method = "tickMovement()V", at = @At("TAIL"))
    private void mores$horseArmorWaterLogic(CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;

        if (!(self instanceof AbstractHorseEntity horse)) return;
        if (!(horse.getWorld() instanceof ServerWorld)) return;

        ItemStack armor = horse.getEquippedStack(EquipmentSlot.BODY);
        boolean turquoise = armor.isOf(ModItems.TURQUOISE_HORSE_ARMOR);
        boolean lapis = armor.isOf(ModItems.LAPIS_LAZULI_HORSE_ARMOR);

        // If neither armor is worn, remove our modifiers and do nothing.
        if (!turquoise && !lapis) {
            mores$clearWaterModifiers(horse);
            return;
        }

        // Apply “water movement efficiency” (helps both).
        mores$applyWaterModifiers(horse, turquoise, lapis);

        // Only do buoyancy/sinking tuning when in water.
        if (!horse.isTouchingWater()) return;

        // --- Effects ---
        if (turquoise) {
            horse.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.DOLPHINS_GRACE,
                    40,
                    0,
                    true,
                    false,
                    false
            ));
        }

        if (lapis) {
            // “Water breathing” for the horse
            horse.setAir(horse.getMaxAir());
        }

        // --- Buoyancy / sinking tuning (NO travel override!) ---
        World world = horse.getWorld();
        BlockPos pos = horse.getBlockPos();

        boolean fluidHereIsWater = world.getFluidState(pos).isIn(FluidTags.WATER);
        boolean solidDirectlyBelow =
                fluidHereIsWater
                        && world.getFluidState(pos.down()).isEmpty()
                        && world.getBlockState(pos.down()).isSolidBlock(world, pos.down());

        double vy = horse.getVelocity().y;

        if (turquoise) {
            // Turquoise behavior:
            // - Shallow water: stay grounded so the horse can step up/out (fixes your screenshot).
            // - Deep water: float.

            if (solidDirectlyBelow) {
                // "Plant the feet": small downward bias to keep onGround contact.
                vy -= 0.10D;

                // Don’t let it plunge; we just want ground contact.
                if (vy < -0.18D) vy = -0.18D;

                // Also prevent upward bobbing while in shallow water.
                if (vy > 0.03D) vy = 0.03D;
            } else {
                // Deep water float
                if (horse.isSubmergedInWater()) {
                    vy = Math.max(vy, 0.18D);
                } else {
                    vy = Math.max(vy, 0.07D);
                }

                // Clamp sinking drift
                if (vy < -0.005D) vy = -0.005D;
            }
        } else if (lapis) {
            // Lapis behavior:
            // sink much faster (your request), but keep vanilla steering/animation.

            if (!horse.isOnGround()) {
                // MUCH stronger sink force
                vy -= 0.28D;            // was 0.14; this is noticeably faster

                // Allow faster terminal sink
                if (vy < -0.85D) vy = -0.85D;
            } else {
                // On the bottom, stop bobbing upward
                if (vy > 0.02D) vy = 0.02D;
            }
        }

        horse.setVelocity(horse.getVelocity().x, vy, horse.getVelocity().z);
        horse.fallDistance = 0.0F;
    }

    @Unique
    private static void mores$applyWaterModifiers(AbstractHorseEntity horse, boolean turquoise, boolean lapis) {
        EntityAttributeInstance inst = horse.getAttributeInstance(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY);
        if (inst == null) return;

        EntityAttributeModifier t = inst.getModifier(MORES$TURQUOISE_WATER_EFF_ID);
        EntityAttributeModifier l = inst.getModifier(MORES$LAPIS_WATER_EFF_ID);

        if (turquoise) {
            if (t == null) inst.addTemporaryModifier(MORES$TURQUOISE_WATER_EFF);
        } else if (t != null) {
            inst.removeModifier(t);
        }

        if (lapis) {
            if (l == null) inst.addTemporaryModifier(MORES$LAPIS_WATER_EFF);
        } else if (l != null) {
            inst.removeModifier(l);
        }
    }

    @Unique
    private static void mores$clearWaterModifiers(AbstractHorseEntity horse) {
        EntityAttributeInstance inst = horse.getAttributeInstance(EntityAttributes.GENERIC_WATER_MOVEMENT_EFFICIENCY);
        if (inst == null) return;

        EntityAttributeModifier t = inst.getModifier(MORES$TURQUOISE_WATER_EFF_ID);
        if (t != null) inst.removeModifier(t);

        EntityAttributeModifier l = inst.getModifier(MORES$LAPIS_WATER_EFF_ID);
        if (l != null) inst.removeModifier(l);
    }
}
