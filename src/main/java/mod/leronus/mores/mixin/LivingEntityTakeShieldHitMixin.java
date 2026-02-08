package mod.leronus.mores.mixin;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import mod.leronus.mores.item.custom.ModBattleMaceItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Makes ModBattleMaceItem disable shields the same way axes do,
 * but on the correct "shield blocked hit" pathway.
 *
 * Target method exists in Yarn 1.21.x:
 * LivingEntity.takeShieldHit(LivingEntity attacker) :contentReference[oaicite:1]{index=1}
 */
@Mixin(LivingEntity.class)
public abstract class LivingEntityTakeShieldHitMixin {

    @Inject(method = "takeShieldHit", at = @At("HEAD"))
    private void mores$battleMaceDisablesShieldOnBlock(LivingEntity attacker, CallbackInfo ci) {
        LivingEntity target = (LivingEntity) (Object) this;

        // Server only
        if (target.getWorld().isClient) return;

        // Only players have shields + cooldown manager in the way we want
        if (!(target instanceof PlayerEntity player)) return;

        // Attacker must be using a battle mace
        ItemStack weapon = attacker.getMainHandStack();
        if (!(weapon.getItem() instanceof ModBattleMaceItem)) return;

        // Player must actually be blocking with a shield item
        if (!player.isUsingItem() || !player.isBlocking()) return;

        ItemStack active = player.getActiveItem();
        if (!isShield(active)) return;

        // Axe-like behavior:
        // sprinting: guaranteed disable
        // otherwise: 25% chance
        float chance = attacker.isSprinting() ? 1.0f : 0.25f;

        if (attacker.getRandom().nextFloat() >= chance) return;

        // Disable shield and prevent instant re-raise "flicker"
        player.disableShield();
        player.clearActiveItem();

        Item activeItem = active.getItem();
        int cooldown = getShieldCooldownTicks(activeItem);

        player.getItemCooldownManager().set(activeItem, cooldown);
    }

    private static boolean isShield(ItemStack stack) {
        Item item = stack.getItem();
        return (item instanceof ShieldItem) || (item instanceof FabricShieldItem);
    }

    private static int getShieldCooldownTicks(Item shieldItem) {
        if (shieldItem instanceof FabricShieldItem modShield) {
            return modShield.getCoolDownTicks();
        }
        return 100; // vanilla fallback
    }
}
