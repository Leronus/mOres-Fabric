package mod.leronus.mores.mixin;

import mod.leronus.mores.trade.ModArmorerTradesWeighted;
import mod.leronus.mores.trade.ModClericTradesWeighted;
import mod.leronus.mores.trade.ModToolsmithTradesWeighted;
import mod.leronus.mores.trade.ModWeaponsmithTradesWeighted;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.VillagerProfession;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VillagerEntity.class)
public abstract class VillagerMoresRecipeMixin {

    @Inject(method = "fillRecipes", at = @At("HEAD"), cancellable = true)
    private void mores$overrideTrades(CallbackInfo ci) {
        VillagerEntity villager = (VillagerEntity) (Object) this;
        VillagerProfession prof = villager.getVillagerData().getProfession();

        if (prof != VillagerProfession.ARMORER
                && prof != VillagerProfession.TOOLSMITH
                && prof != VillagerProfession.WEAPONSMITH
                && prof != VillagerProfession.CLERIC) {
            return; // not our professions -> let vanilla run
        }

        TradeOfferList offers = villager.getOffers();
        int level = villager.getVillagerData().getLevel();

        // We DO NOT clear offers. We only add missing levels, like vanilla does.
        // This avoids nuking existing discounts/special price adjustments.
        int existing = offers.size();
        int target = expectedTotalOffers(prof, level);

        if (existing >= target) {
            ci.cancel();
            return;
        }

        // Determine which levels are missing based on how many offers already exist.
        // Assumes our offers-per-level is fixed and stable.
        int nextLevelToAdd = 1;
        int cumulative = 0;
        while (nextLevelToAdd <= level) {
            cumulative += offersPerLevel(prof, nextLevelToAdd);
            if (existing < cumulative) break;
            nextLevelToAdd++;
        }

        for (int lvl = nextLevelToAdd; lvl <= level; lvl++) {
            long seed = villager.getUuid().getMostSignificantBits()
                    ^ villager.getUuid().getLeastSignificantBits()
                    ^ ((long) lvl * 0x9E3779B97F4A7C15L)
                    ^ prof.hashCode();

            Random r = Random.create(seed);

            if (prof == VillagerProfession.ARMORER) {
                ModArmorerTradesWeighted.addLevelOffers(villager, offers, lvl, r);
            } else if (prof == VillagerProfession.TOOLSMITH) {
                ModToolsmithTradesWeighted.addLevelOffers(villager, offers, lvl, r);
            } else if (prof == VillagerProfession.WEAPONSMITH) {
                ModWeaponsmithTradesWeighted.addLevelOffers(villager, offers, lvl, r);
            } else if (prof == VillagerProfession.CLERIC) {
                ModClericTradesWeighted.addLevelOffers(villager, offers, lvl, r);
            }
        }

        ci.cancel(); // stop vanilla from adding vanilla trades
    }

    private static int offersPerLevel(VillagerProfession prof, int level) {
        if (prof == VillagerProfession.CLERIC) {
            return level <= 2 ? 2 : 3;
        }
        // Your intended setup:
        // Armorer/Toolsmith/Weaponsmith: 3 per level
        if (prof == VillagerProfession.ARMORER
                || prof == VillagerProfession.TOOLSMITH
                || prof == VillagerProfession.WEAPONSMITH) {
            return 3;
        }
        // Default vanilla behavior not used here
        return 2;
    }

    private static int expectedTotalOffers(VillagerProfession prof, int villagerLevel) {
        int total = 0;
        for (int lvl = 1; lvl <= villagerLevel; lvl++) {
            total += offersPerLevel(prof, lvl);
        }
        return total;
    }
}
