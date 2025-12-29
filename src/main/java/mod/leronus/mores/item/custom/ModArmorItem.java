package mod.leronus.mores.item.custom;

import mod.leronus.mores.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModArmorItem extends ArmorItem {

    // Identifier-based attribute modifier key (1.21+ style)
    private static final Identifier SPINEL_MAX_HEALTH_ID =
            Identifier.of("mores", "spinel_max_health_bonus");

    private static final Map<RegistryEntry<ArmorMaterial>, ArrayList<StatusEffectInstance>> MATERIAL_TO_EFFECT;

    static {
        MATERIAL_TO_EFFECT = new HashMap<>();

        addValue(ModArmorMaterials.HARDENED_STEEL, StatusEffects.STRENGTH, -1, 0);

        addValue(ModArmorMaterials.AMETHYST, StatusEffects.SLOW_FALLING, -1, 0);
        addValue(ModArmorMaterials.EMERALD, StatusEffects.LUCK, -1, 0);

        addValue(ModArmorMaterials.TOPAZ, StatusEffects.HASTE, -1, 0);
        addValue(ModArmorMaterials.TOURMALINE, StatusEffects.REGENERATION, -1, 0);

        addValue(ModArmorMaterials.SPINEL, StatusEffects.SATURATION, -1, 0);

        addValue(ModArmorMaterials.RUBY, StatusEffects.FIRE_RESISTANCE, -1, 0);

        addValue(ModArmorMaterials.SAPPHIRE, StatusEffects.NIGHT_VISION, -1, 0);
        addValue(ModArmorMaterials.MOISSANITE, StatusEffects.JUMP_BOOST, -1, 0);

        addValue(ModArmorMaterials.TURQUOISE, StatusEffects.DOLPHINS_GRACE, -1, 0);
    }

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    private static void addValue(RegistryEntry<ArmorMaterial> key,
                                 RegistryEntry<StatusEffect> effect,
                                 int duration,
                                 int amplifier) {

        StatusEffectInstance newEffect = new StatusEffectInstance(effect, duration, amplifier, false, false, true);

        ArrayList<StatusEffectInstance> tempList = MATERIAL_TO_EFFECT.get(key);
        if (tempList == null) tempList = new ArrayList<>();
        tempList.add(newEffect);

        MATERIAL_TO_EFFECT.put(key, tempList);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {

            // Apply set effects if fully equipped, otherwise remove
            if (hasFullArmorSet(player)) {
                evaluateArmorEffect(player);
            } else {
                removeArmorEffect(player);
            }

            // Citrine: ensure health bonus is applied only when wearing full Citrine set
            // (This makes removal reliable even if multiple pieces are taken off at once.)
            if (hasFullSpinelSet(player)) {
                applySpinelBonus(player);
            } else {
                removeCitrineBonus(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasFullArmorSet(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasFullSpinelSet(PlayerEntity player) {
        // Prevent Elytra / non-armor in slots from causing issues
        for (ItemStack armor : player.getInventory().armor) {
            if (!armor.isEmpty() && !(armor.getItem() instanceof ArmorItem)) return false;
        }

        ItemStack bootsStack = player.getInventory().getArmorStack(0);
        ItemStack leggingsStack = player.getInventory().getArmorStack(1);
        ItemStack chestStack = player.getInventory().getArmorStack(2);
        ItemStack helmetStack = player.getInventory().getArmorStack(3);

        if (bootsStack.isEmpty() || leggingsStack.isEmpty() || chestStack.isEmpty() || helmetStack.isEmpty()) {
            return false;
        }

        ArmorItem boots = (ArmorItem) bootsStack.getItem();
        ArmorItem leggings = (ArmorItem) leggingsStack.getItem();
        ArmorItem chest = (ArmorItem) chestStack.getItem();
        ArmorItem helmet = (ArmorItem) helmetStack.getItem();

        ArmorMaterial spinelMaterial = ModArmorMaterials.SPINEL.value();

        return boots.getMaterial().value() == spinelMaterial
                && leggings.getMaterial().value() == spinelMaterial
                && chest.getMaterial().value() == spinelMaterial
                && helmet.getMaterial().value() == spinelMaterial;
    }

    private void evaluateArmorEffect(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, ArrayList<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT.entrySet()) {
            ArmorMaterial material = entry.getKey().value();

            entry.getValue().forEach(effect -> {
                if (hasCorrectArmor(material, player) && isStatusMissing(player, effect)) {
                    addStatus(player, effect);
                }
            });
        }
    }

    private void removeArmorEffect(PlayerEntity player) {
        // Remove any infinite/long-running effects applied by this system
        for (Map.Entry<RegistryEntry<ArmorMaterial>, ArrayList<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT.entrySet()) {
            entry.getValue().forEach(effect -> {
                if (player.hasStatusEffect(effect.getEffectType())) {
                    StatusEffectInstance cur = player.getStatusEffect(effect.getEffectType());
                    // Only remove if it's one of our "infinite" style effects (duration -1 in your config),
                    // or if it shows as infinite in your mapping environment.
                    if (cur != null && (cur.isInfinite() || effect.getDuration() < 0)) {
                        removeStatus(player, effect);
                    }
                }
            });
        }
    }

    private boolean hasCorrectArmor(ArmorMaterial material, PlayerEntity player) {
        // Prevent Elytra / non-armor in slots from crashing
        for (ItemStack armor : player.getInventory().armor)
            if (!armor.isEmpty() && !(armor.getItem() instanceof ArmorItem))
                return false;

        ItemStack bootsStack = player.getInventory().getArmorStack(0);
        ItemStack leggingsStack = player.getInventory().getArmorStack(1);
        ItemStack chestStack = player.getInventory().getArmorStack(2);
        ItemStack helmetStack = player.getInventory().getArmorStack(3);

        if (bootsStack.isEmpty() || leggingsStack.isEmpty() || chestStack.isEmpty() || helmetStack.isEmpty()) {
            return false;
        }

        ArmorItem boots = (ArmorItem) bootsStack.getItem();
        ArmorItem leggings = (ArmorItem) leggingsStack.getItem();
        ArmorItem chestplate = (ArmorItem) chestStack.getItem();
        ArmorItem helmet = (ArmorItem) helmetStack.getItem();

        return helmet.getMaterial().value() == material
                && chestplate.getMaterial().value() == material
                && leggings.getMaterial().value() == material
                && boots.getMaterial().value() == material;
    }

    private boolean isStatusMissing(PlayerEntity player, StatusEffectInstance effect) {
        return !player.hasStatusEffect(effect.getEffectType());
    }

    private void addStatus(PlayerEntity player, StatusEffectInstance effect) {
        player.addStatusEffect(new StatusEffectInstance(
                effect.getEffectType(),
                effect.getDuration(),
                effect.getAmplifier(),
                effect.isAmbient(),
                effect.shouldShowParticles(),
                effect.shouldShowIcon()
        ));
    }

    private void removeStatus(PlayerEntity player, StatusEffectInstance effect) {
        player.removeStatusEffect(effect.getEffectType());
    }

    // === Citrine bonus: +4 max health (2 hearts), regenerates naturally via food/saturation ===

    private void applySpinelBonus(PlayerEntity player) {
        EntityAttributeInstance attr = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attr == null) return;

        // Fabric/1.21 uses Identifier for modifier keys
        if (attr.getModifier(SPINEL_MAX_HEALTH_ID) != null) return;

        EntityAttributeModifier mod = new EntityAttributeModifier(
                SPINEL_MAX_HEALTH_ID,
                4.0, // +4 health = 2 hearts
                EntityAttributeModifier.Operation.ADD_VALUE
        );

        attr.addTemporaryModifier(mod);
    }

    private void removeCitrineBonus(PlayerEntity player) {
        EntityAttributeInstance attr = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attr == null) return;

        if (attr.getModifier(SPINEL_MAX_HEALTH_ID) != null) {
            attr.removeModifier(SPINEL_MAX_HEALTH_ID);

            // Clamp current health to new max
            float max = (float) player.getMaxHealth();
            if (player.getHealth() > max) {
                player.setHealth(max);
            }
        }
    }
}
