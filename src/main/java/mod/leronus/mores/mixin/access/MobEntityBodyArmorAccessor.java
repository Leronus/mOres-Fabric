package mod.leronus.mores.mixin.access;

import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MobEntity.class)
public interface MobEntityBodyArmorAccessor {
    @Accessor("bodyArmor")
    ItemStack mores$getBodyArmor();

    @Accessor("bodyArmor")
    void mores$setBodyArmor(ItemStack stack);
}
