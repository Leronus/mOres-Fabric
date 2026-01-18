package mod.leronus.mores.mixin;

import mod.leronus.mores.item.ModArmorMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.AnimalArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Obsidian animal armor: explosion immunity for wolves + horses.
 */
@Mixin(LivingEntity.class)
public abstract class AnimalArmorExplosionImmunityMixin {

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void mores$obsidianAnimalArmorExplosionImmunity(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;

        if (!(self instanceof AbstractHorseEntity) && !(self instanceof WolfEntity)) return;
        if (!source.isIn(DamageTypeTags.IS_EXPLOSION)) return;

        ItemStack armorStack = self.getEquippedStack(EquipmentSlot.BODY);
        if (armorStack.isEmpty()) return;
        if (!(armorStack.getItem() instanceof AnimalArmorItem aai)) return;

        ArmorMaterial mat = aai.getMaterial().value();
        if (mat != ModArmorMaterials.OBSIDIAN.value()) return;

        // Cancel explosion damage entirely.
        cir.setReturnValue(false);
    }
}
