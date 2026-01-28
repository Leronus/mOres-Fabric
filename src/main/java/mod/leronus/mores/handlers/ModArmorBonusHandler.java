package mod.leronus.mores.handlers;

import mod.leronus.mores.config.CommonConfig;
import mod.leronus.mores.item.ModArmorMaterials;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;

import java.util.*;

/**
 * Full-player-armor-set bonuses.
 *
 * Notes:
 * - “Infinite” potion effects are applied with duration -1.
 * - Immunities/pacification are handled here on a short interval to feel responsive.
 * - Explosion immunity for OBSIDIAN is handled by a small damage mixin (see mixin class below).
 */
public final class ModArmorBonusHandler {

    private ModArmorBonusHandler() {}

    private static final Identifier SPINEL_MAX_HEALTH_ID =
            Identifier.of("mores", "spinel_max_health_bonus");

    private static final Identifier CITRINE_REACH_ID =
            Identifier.of("mores", "citrine_block_reach_bonus");

    private static final int PROVOKE_TICKS = 20 * 30; // 30 seconds
    private static final Map<UUID, Long> PROVOKED_UNTIL = new HashMap<>();

    private static final int CHECK_INTERVAL_TICKS = 5; // 0.25s
    private static final Map<UUID, Long> NEXT_CHECK = new HashMap<>();

    // Signature templates: duration -1, ambient=false, particles=false, icon=true
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> EFFECTS_BY_MATERIAL = new HashMap<>();

    public static void registerArmorBonuses() {
        // Effects (simple “always-on while full set”)
        put(ModArmorMaterials.HARDENED_STEEL.value(), moresEffect(StatusEffects.STRENGTH, 0));
        put(ModArmorMaterials.LAPIS_LAZULI.value(), moresEffect(StatusEffects.WATER_BREATHING, 0));
        put(ModArmorMaterials.AMETHYST.value(), moresEffect(StatusEffects.SLOW_FALLING, 0));
        put(ModArmorMaterials.GRAPHENE_CHAINMAIL.value(), moresEffect(StatusEffects.JUMP_BOOST, 1));
        put(ModArmorMaterials.TOURMALINE.value(), moresEffect(StatusEffects.REGENERATION, 0));
        put(ModArmorMaterials.TOPAZ.value(), moresEffect(StatusEffects.HASTE, 0));
        put(ModArmorMaterials.TANZANITE.value(), moresEffect(StatusEffects.SPEED, 0));
        put(ModArmorMaterials.RUBY.value(), moresEffect(StatusEffects.FIRE_RESISTANCE, 0));
        put(ModArmorMaterials.TURQUOISE.value(), moresEffect(StatusEffects.DOLPHINS_GRACE, 0));
        put(ModArmorMaterials.EMERALD.value(), moresEffect(StatusEffects.LUCK, 0));
        put(ModArmorMaterials.SAPPHIRE.value(), moresEffect(StatusEffects.NIGHT_VISION, 0));

        // Spinel extra hearts handled via attribute (see tick)
        // Citrine +1 block reach handled via attribute (see tick)
        // Moissanite poison immunity handled via tick (see tick)
        // Onyx wither immunity handled via tick (see tick)
        // Obsidian explosion immunity handled via mixin (cancel explosion damage)

        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (world.isClient()) return ActionResult.PASS;

            if (entity instanceof AbstractPiglinEntity) {
                markProvokedPiglins(player);
            }
            return ActionResult.PASS;
        });

        ServerTickEvents.END_SERVER_TICK.register(ModArmorBonusHandler::onServerTick);
    }

    private static void put(ArmorMaterial mat, StatusEffectInstance effect) {
        EFFECTS_BY_MATERIAL.computeIfAbsent(mat, k -> new ArrayList<>()).add(effect);
    }

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
        if (!CommonConfig.enableArmorSetBonuses) {
            removeOnlyOurInfiniteEffects(player);
            removeSpinelBonus(player);
            removeCitrineReach(player);
            return;
        }

        ArmorMaterial fullSetMaterial = getFullSetMaterialOrNull(player);

        if (fullSetMaterial != null) {
            // 1) Standard “infinite” effects
            List<StatusEffectInstance> list = EFFECTS_BY_MATERIAL.get(fullSetMaterial);
            if (list != null) {
                for (StatusEffectInstance template : list) {
                    applyIfMissingOrOurs(player, template);
                }
            }

            // 2) Attribute bonuses
            if (fullSetMaterial == ModArmorMaterials.SPINEL.value()) {
                applySpinelBonus(player);
            } else {
                removeSpinelBonus(player);
            }

            if (fullSetMaterial == ModArmorMaterials.CITRINE.value()) {
                applyCitrineReach(player);
            } else {
                removeCitrineReach(player);
            }

            // 3) Immunities / pacification
            if (fullSetMaterial == ModArmorMaterials.MOISSANITE.value()) {
                player.removeStatusEffect(StatusEffects.POISON);
            }
            if (fullSetMaterial == ModArmorMaterials.ONYX.value()) {
                player.removeStatusEffect(StatusEffects.WITHER);
            }
        } else {
            removeOnlyOurInfiniteEffects(player);
            removeSpinelBonus(player);
            removeCitrineReach(player);
        }
    }
    public static void markProvokedPiglins(PlayerEntity player) {
        if (player.getServer() == null) return;
        long now = player.getServer().getOverworld().getTime();
        PROVOKED_UNTIL.put(player.getUuid(), now + PROVOKE_TICKS);
    }
    private static boolean isProvoked(PlayerEntity player) {
        if (!(player instanceof ServerPlayerEntity sp)) return false;
        long now = sp.getServer().getOverworld().getTime();
        long until = PROVOKED_UNTIL.getOrDefault(player.getUuid(), 0L);
        return now < until;
    }
    public static boolean isPlayerProvokedPiglins(PlayerEntity player) {
        return isProvoked(player);
    }

    // =========================================================
    // PUBLIC HELPERS (used by mixins / other systems)
    // =========================================================

    /** True if the player currently wears a full set of the given armor material. */
    public static boolean isWearingFullSet(PlayerEntity player, ArmorMaterial material) {
        ArmorItem[] armor = getArmorItemsOrNull(player);
        if (armor == null) return false;

        ArmorMaterial m0 = armor[0].getMaterial().value();
        if (m0 != material) return false;

        return armor[1].getMaterial().value() == material
                && armor[2].getMaterial().value() == material
                && armor[3].getMaterial().value() == material;
    }

    /** For your obsidian “set bonus” checks. */
    public static boolean isWearingFullObsidian(PlayerEntity player) {
        return CommonConfig.enableArmorSetBonuses
                && isWearingFullSet(player, ModArmorMaterials.OBSIDIAN.value());
    }

    // =========================================================

    private static ArmorMaterial getFullSetMaterialOrNull(PlayerEntity player) {
        ArmorItem[] armor = getArmorItemsOrNull(player);
        if (armor == null) return null;

        ArmorMaterial m0 = armor[0].getMaterial().value();
        return (armor[1].getMaterial().value() == m0
                && armor[2].getMaterial().value() == m0
                && armor[3].getMaterial().value() == m0) ? m0 : null;
    }

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

        if (!looksLikeOurEffect(cur, template)) return;

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
                template.getDuration(),
                template.getAmplifier(),
                template.isAmbient(),
                template.shouldShowParticles(),
                template.shouldShowIcon()
        );
    }

    // =========================
    // SPINEL: +2 hearts (+4 max health)
    // =========================
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

    // =========================
    // CITRINE: +1 block interaction range
    // =========================
    private static void applyCitrineReach(PlayerEntity player) {
        EntityAttributeInstance attr = player.getAttributeInstance(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE);
        if (attr == null) return;
        if (attr.getModifier(CITRINE_REACH_ID) != null) return;

        attr.addTemporaryModifier(new EntityAttributeModifier(
                CITRINE_REACH_ID,
                1.0,
                EntityAttributeModifier.Operation.ADD_VALUE
        ));
    }

    private static void removeCitrineReach(PlayerEntity player) {
        EntityAttributeInstance attr = player.getAttributeInstance(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE);
        if (attr == null) return;
        if (attr.getModifier(CITRINE_REACH_ID) != null) {
            attr.removeModifier(CITRINE_REACH_ID);
        }
    }

    // =========================
    // ROSE GOLD: pacify Piglin Brutes
    // =========================
    private static void clearPiglinTargets(PlayerEntity player, double radius) {
        if (!(player instanceof ServerPlayerEntity sp)) return;
        var world = sp.getServerWorld();

        // If you implement "provoked" logic, keep this guard:
        if (isProvoked(player)) return;

        Box box = player.getBoundingBox().expand(radius);

        for (AbstractPiglinEntity piglin : world.getEntitiesByClass(AbstractPiglinEntity.class, box, p -> true)) {
            if (piglin.getTarget() == player) {
                piglin.setTarget(null);
            }

            // Clear AI memory so they don't instantly reacquire
            var brain = piglin.getBrain();
            brain.forget(MemoryModuleType.ATTACK_TARGET);
            brain.forget(MemoryModuleType.ANGRY_AT);
            brain.forget(MemoryModuleType.UNIVERSAL_ANGER);
        }
    }


    // =========================
    // ENDERITE: pacify Endermen
    // =========================
    private static void clearEndermanTargets(PlayerEntity player, double radius) {
        if (!(player instanceof ServerPlayerEntity sp)) return;
        var world = sp.getServerWorld();

        Box box = player.getBoundingBox().expand(radius);
        for (EndermanEntity enderman : world.getEntitiesByClass(EndermanEntity.class, box, e -> true)) {
            if (enderman.getTarget() == player) {
                enderman.setTarget(null);
            }
        }
    }
}
