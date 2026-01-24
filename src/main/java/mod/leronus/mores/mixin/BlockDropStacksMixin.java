package mod.leronus.mores.mixin;

import mod.leronus.mores.Mores;
import mod.leronus.mores.item.ModTags;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(Block.class)
public class BlockDropStacksMixin {

    private static final Identifier GRAVEL_JACKPOT_ID = Identifier.of(Mores.MOD_ID, "gravel_jackpot");
    private static final String GRAVEL_JACKPOT_CRITERION = "gravel_jackpot";

    @Redirect(
            method = "dropStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/Block;getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;"
            )
    )
    private static List<ItemStack> mores$gravelJackpot_captureDrops(
            BlockState state,
            ServerWorld world,
            BlockPos pos,
            BlockEntity blockEntity,
            Entity entity,
            ItemStack tool
    ) {
        // This is the REAL drop list Minecraft will use:
        List<ItemStack> drops = Block.getDroppedStacks(state, world, pos, blockEntity, entity, tool);

        if (entity instanceof ServerPlayerEntity player && state.isIn(ModTags.Blocks.GRAVEL_ORES)) {
            boolean hasFlint = false;
            boolean hasGem = false;

            for (ItemStack s : drops) {
                if (s.isOf(Items.FLINT)) hasFlint = true;
                if (s.isIn(ModTags.Items.GEMS)) hasGem = true;
            }

            if (hasFlint && hasGem) {
                grantAdvancement(player, GRAVEL_JACKPOT_ID, GRAVEL_JACKPOT_CRITERION);
            }
        }

        return drops; // IMPORTANT: return unchanged so vanilla drop behavior stays the same
    }

    private static void grantAdvancement(ServerPlayerEntity player, Identifier advancementId, String criterionName) {
        AdvancementEntry adv = player.server.getAdvancementLoader().get(advancementId);
        if (adv == null) return;

        var progress = player.getAdvancementTracker().getProgress(adv);
        if (progress.isDone()) return;

        for (String criterion : progress.getUnobtainedCriteria()) {
            if (criterion.equals(criterionName)) {
                player.getAdvancementTracker().grantCriterion(adv, criterionName);
                break;
            }
        }
    }
}
