package mod.leronus.mores.mixin;

import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.item.ModTags;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {

    @Inject(method = "tick", at = @At("TAIL"))
    private void mores$quenchHotScrap(CallbackInfo ci) {
        ItemEntity self = (ItemEntity) (Object) this;
        World world = self.getWorld();
        if (world.isClient) return;

        ItemStack stack = self.getStack();
        if (!stack.isOf(ModItems.HOT_CARBON_STEEL_SCRAP)) return;

        // Check if the item entity is in water
        BlockPos pos = self.getBlockPos();
        boolean inWater = world.getFluidState(pos).isIn(FluidTags.WATER);

        // Optional: also count "touching water" (splashing in waterlogged blocks etc.)
        // boolean inWater = self.isTouchingWater() || world.getFluidState(pos).isIn(FluidTags.WATER);

        if (!inWater) return;

        int count = stack.getCount();
        self.setStack(new ItemStack(ModItems.CARBON_STEEL_SCRAP, count));

        ServerWorld serverWorld = (ServerWorld) world;
        serverWorld.spawnParticles(
                ParticleTypes.SMOKE,
                self.getX(), self.getY() + 0.1, self.getZ(),
                6,          // count
                0.05, 0.05, 0.05,  // spread (dx, dy, dz)
                0.01        // speed
        );
        // Nice feedback (optional)
        world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.6f, 1.2f);
    }

    @Shadow public abstract ItemStack getStack();

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void mores$obsidianItemsIgnoreExplosionDamage(
            DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir
    ) {
        // Only explosions
        if (!source.isIn(DamageTypeTags.IS_EXPLOSION)) return;

        ItemStack stack = this.getStack();

        if (stack.isIn(ModTags.Items.OBSIDIAN_GEAR)) {
            // Returning false = "not damaged" => explosion won't delete it
            cir.setReturnValue(false);
        }
    }
}

