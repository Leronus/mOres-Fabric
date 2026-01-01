package mod.leronus.mores.handlers;

import mod.leronus.mores.config.CommonConfig;
import mod.leronus.mores.item.ModArmorMaterials;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.*;

public final class ArmorBonusHandler {

    private ArmorBonusHandler() {}

    private static final Identifier SPINEL_MAX_HEALTH_ID =
            Identifier.of("mores", "spinel_max_health_bonus");

    private static final int CHECK_INTERVAL_TICKS = 20; // 1 second

    private static final Map<UUID, Long> NEXT_CHECK = new HashMap<>();

    // “Signature” templates: infinite duration (-1), ambient=false, particles=false, icon=true
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> EFFECTS_BY_MATERIAL = new HashMap<>();

    public static void init() {
        // Build the mapping once
        put(ModArmorMaterials.HARDENED_STEEL.value(), moresEffect(net.minecraft.entity.effect.StatusEffects.STRENGTH, 0));

        put(ModArmorMaterials.AMETHYST.value(), moresEffect(net.minecraft.entity.effect.StatusEffects.SLOW_FALLING, 0));
        put(ModArmorMaterials.EMERALD.value(), moresEffect(net.minecraft.entity.effect.StatusEffects.LUCK, 0));
        put(ModArmorMaterials.TURQUOISE.value(), moresEffect(net.minecraft.entity.effect.StatusEffects.DOLPHINS_GRACE, 0));
        put(ModArmorMaterials.LAPIS_LAZULI.value(), moresEffect(StatusEffects.WATER_BREATHING, 0));

        put(ModArmorMaterials.TOPAZ.value(), moresEffect(net.minecraft.entity.effect.StatusEffects.HASTE, 0));
        put(ModArmorMaterials.TOURMALINE.value(), moresEffect(net.minecraft.entity.effect.StatusEffects.REGENERATION, 0));

        put(ModArmorMaterials.RUBY.value(), moresEffect(net.minecraft.entity.effect.StatusEffects.FIRE_RESISTANCE, 0));

        put(ModArmorMaterials.SAPPHIRE.value(), moresEffect(net.minecraft.entity.effect.StatusEffects.NIGHT_VISION, 0));
        put(ModArmorMaterials.MOISSANITE.value(), moresEffect(net.minecraft.entity.effect.StatusEffects.JUMP_BOOST, 0));

        ServerTickEvents.END_SERVER_TICK.register(ArmorBonusHandler::onServerTick);
    }

    private static void put(ArmorMaterial mat, StatusEffectInstance effect) {
        EFFECTS_BY_MATERIAL.computeIfAbsent(mat, k -> new ArrayList<>()).add(effect);
    }

    /**
     * Create a “signature” effect instance that we can recognize later.
     * Duration is infinite (-1) so players see ∞ while wearing the set.
     */
    private static StatusEffectInstance moresEffect(net.minecraft.registry.entry.RegistryEntry<net.minecraft.entity.effect.StatusEffect> effect, int amplifier) {
        return new StatusEffectInstance(effect, -1, amplifier, false, false, true);
    }

    private static void onServerTick(MinecraftServer server) {
        long now = server.getOverworld().getTime();

        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            UUID id = player.getUuid();

            Long next = NEXT_CHECK.get(id);
            if (next != null && now < next) continue;
            NEXT_CHECK.put(id, now + CHECK_INTERVAL_TICKS);

            tickPlayer(player);
        }
    }

    private static void tickPlayer(PlayerEntity player) {
        // If disabled: remove ours and exit
        if (!CommonConfig.enableArmorSetBonuses || !CommonConfig.enablePotionHeartEffects) {
            removeOnlyOurInfiniteEffects(player);
            removeSpinelBonus(player);
            return;
        }

        ArmorMaterial fullSetMaterial = getFullSetMaterialOrNull(player);

        if (fullSetMaterial != null) {
            // Apply effects for this set
            List<StatusEffectInstance> list = EFFECTS_BY_MATERIAL.get(fullSetMaterial);
            if (list != null) {
                for (StatusEffectInstance template : list) {
                    applyIfMissingOrOurs(player, template);
                }
            }

            // Spinel bonus
            if (fullSetMaterial == ModArmorMaterials.SPINEL.value()) {
                applySpinelBonus(player);
            } else {
                removeSpinelBonus(player);
            }
        } else {
            // Not a full set: remove ours immediately
            removeOnlyOurInfiniteEffects(player);
            removeSpinelBonus(player);
        }
    }

    /**
     * Returns the shared ArmorMaterial if all 4 armor slots contain ArmorItem of the same material, otherwise returns null.
     */
    private static ArmorMaterial getFullSetMaterialOrNull(PlayerEntity player) {
        ArmorItem[] armor = getArmorItemsOrNull(player);
        if (armor == null) return null;

        ArmorMaterial m0 = armor[0].getMaterial().value();
        return (armor[1].getMaterial().value() == m0
                && armor[2].getMaterial().value() == m0
                && armor[3].getMaterial().value() == m0) ? m0 : null;
    }

    /**
     * Returns {boots, leggings, chest, helmet} if all 4 slots are filled with ArmorItem, else null.
     */
    private static ArmorItem[] getArmorItemsOrNull(PlayerEntity player) {
        ItemStack bootsStack = player.getInventory().getArmorStack(0);
        ItemStack leggingsStack = player.getInventory().getArmorStack(1);
        ItemStack chestStack = player.getInventory().getArmorStack(2);
        ItemStack helmetStack = player.getInventory().getArmorStack(3);

        if (bootsStack.isEmpty() || leggingsStack.isEmpty() || chestStack.isEmpty() || helmetStack.isEmpty()) return null;

        if (!(bootsStack.getItem() instanceof ArmorItem boots)) return null;
        if (!(leggingsStack.getItem() instanceof ArmorItem leggings)) return null;
        if (!(chestStack.getItem() instanceof ArmorItem chest)) return null;
        if (!(helmetStack.getItem() instanceof ArmorItem helmet)) return null;

        return new ArmorItem[]{boots, leggings, chest, helmet};
    }

    private static void applyIfMissingOrOurs(PlayerEntity player, StatusEffectInstance template) {
        StatusEffectInstance cur = player.getStatusEffect(template.getEffectType());

        if (cur == null) {
            player.addStatusEffect(copy(template));
            return;
        }

        // don't touch other mods' version if signature differs
        if (!looksLikeOurEffect(cur, template)) return;

        // if ours but not infinite, re-apply
        if (!cur.isInfinite()) {
            player.addStatusEffect(copy(template));
        }
    }

    private static void removeOnlyOurInfiniteEffects(PlayerEntity player) {
        for (List<StatusEffectInstance> list : EFFECTS_BY_MATERIAL.values()) {
            for (StatusEffectInstance template : list) {
                StatusEffectInstance cur = player.getStatusEffect(template.getEffectType());
                if (cur == null) continue;

                if (cur.isInfinite() && looksLikeOurEffect(cur, template)) {
                    player.removeStatusEffect(template.getEffectType());
                }
            }
        }
    }

    private static boolean looksLikeOurEffect(StatusEffectInstance cur, StatusEffectInstance template) {
        return cur.getAmplifier() == template.getAmplifier()
                && cur.isAmbient() == template.isAmbient()
                && cur.shouldShowParticles() == template.shouldShowParticles()
                && cur.shouldShowIcon() == template.shouldShowIcon();
    }

    private static StatusEffectInstance copy(StatusEffectInstance template) {
        return new StatusEffectInstance(
                template.getEffectType(),
                template.getDuration(), // -1
                template.getAmplifier(),
                template.isAmbient(),
                template.shouldShowParticles(),
                template.shouldShowIcon()
        );
    }

    private static void applySpinelBonus(PlayerEntity player) {
        EntityAttributeInstance attr = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attr == null) return;
        if (attr.getModifier(SPINEL_MAX_HEALTH_ID) != null) return;

        attr.addTemporaryModifier(new EntityAttributeModifier(
                SPINEL_MAX_HEALTH_ID,
                4.0,
                EntityAttributeModifier.Operation.ADD_VALUE
        ));
    }

    private static void removeSpinelBonus(PlayerEntity player) {
        EntityAttributeInstance attr = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attr == null) return;

        if (attr.getModifier(SPINEL_MAX_HEALTH_ID) != null) {
            attr.removeModifier(SPINEL_MAX_HEALTH_ID);

            float max = (float) player.getMaxHealth();
            if (player.getHealth() > max) {
                player.setHealth(max);
            }
        }
    }
}
