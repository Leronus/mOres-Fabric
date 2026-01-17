package mod.leronus.mores.handlers;

import mod.leronus.mores.item.ModTags;
import mod.leronus.mores.mixin.access.MobEntityBodyArmorAccessor;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AnimalArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public final class ModShearableAnimalArmorHandler {
    private ModShearableAnimalArmorHandler() {}

    public static void register() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            ItemStack held = player.getStackInHand(hand);
            if (!(held.getItem() instanceof ShearsItem)) return ActionResult.PASS;
            if (!(entity instanceof LivingEntity living)) return ActionResult.PASS;

            // Only entities that can use BODY (wolves, horses, etc.)
            if (!living.canUseSlot(EquipmentSlot.BODY)) return ActionResult.PASS;

            // Read body armor in the *most correct* way for 1.21.1:
            // mobs store it in MobEntity#bodyArmor; other living entities may use equipment directly.
            ItemStack worn = getBodyArmorStack(living);
            if (worn.isEmpty()) return ActionResult.PASS;

            // Gate by your tag
            if (!worn.isIn(ModTags.Items.SHEAR_REMOVES_ANIMAL_ARMOR)) return ActionResult.PASS;

            // Optional safety
            if (!(worn.getItem() instanceof AnimalArmorItem)) return ActionResult.PASS;

            if (world.isClient) {
                return ActionResult.SUCCESS;
            }

            // Copy FIRST (the underlying storage may be cleared/mutated)
            ItemStack toGive = worn.copy();
            toGive.setCount(1);

            // Clear BOTH storages so the wolf truly becomes "unarmored"
            clearBodyArmor(living);

            // Give/drop the armor item
            giveOrDrop(player, world, living, toGive);

            // Damage shears
            held.damage(1, player, LivingEntity.getSlotForHand(hand));

            // Effects
            world.playSound(
                    null,
                    entity.getX(), entity.getY(), entity.getZ(),
                    SoundEvents.ENTITY_SHEEP_SHEAR,
                    SoundCategory.PLAYERS,
                    1.0f, 1.0f
            );
            world.emitGameEvent(player, GameEvent.SHEAR, entity.getPos());

            return ActionResult.SUCCESS;
        });
    }

    private static ItemStack getBodyArmorStack(LivingEntity living) {
        if (living instanceof MobEntity mob) {
            // 1.21.1: this is the authoritative body armor storage for mobs
            ItemStack body = ((MobEntityBodyArmorAccessor) mob).mores$getBodyArmor();
            if (!body.isEmpty()) return body;
        }
        return living.getEquippedStack(EquipmentSlot.BODY);
    }

    private static void clearBodyArmor(LivingEntity living) {
        // Clear via normal API (updates equipment + sends packets)
        living.equipStack(EquipmentSlot.BODY, ItemStack.EMPTY);

        // ALSO force-clear MobEntity#bodyArmor (fixes wolves still acting armored)
        if (living instanceof MobEntity mob) {
            ((MobEntityBodyArmorAccessor) mob).mores$setBodyArmor(ItemStack.EMPTY);
        }
    }

    private static void giveOrDrop(PlayerEntity player, World world, LivingEntity living, ItemStack stack) {
        if (player.getInventory().insertStack(stack)) return;

        ItemEntity itemEntity = new ItemEntity(world, living.getX(), living.getBodyY(0.5), living.getZ(), stack);
        itemEntity.setPickupDelay(0);
        world.spawnEntity(itemEntity);
    }
}
