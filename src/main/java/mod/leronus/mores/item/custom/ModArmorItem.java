package mod.leronus.mores.item.custom;

import mod.leronus.mores.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModArmorItem extends ArmorItem
{
    private static final Map<RegistryEntry<ArmorMaterial>, ArrayList<StatusEffectInstance>> MATERIAL_TO_EFFECT;

    static
    {
        MATERIAL_TO_EFFECT = new HashMap<>();
        addValue(ModArmorMaterials.TIN, StatusEffects.JUMP_BOOST, 10, 0);
        addValue(ModArmorMaterials.COBALT, StatusEffects.HASTE, 10, 0);
        addValue(ModArmorMaterials.STEEL, StatusEffects.STRENGTH, 10, 0);

        addValue(ModArmorMaterials.AMETHYST, StatusEffects.SLOW_FALLING, 10, 0);
        addValue(ModArmorMaterials.EMERALD, StatusEffects.LUCK, 10, 0);

        addValue(ModArmorMaterials.TOPAZ, StatusEffects.HASTE, 10, 1);
        addValue(ModArmorMaterials.TOURMALINE, StatusEffects.REGENERATION, 10, 0);

        addValue(ModArmorMaterials.TANZANITE, StatusEffects.SPEED, 10, 0);
        addValue(ModArmorMaterials.RUBY, StatusEffects.FIRE_RESISTANCE, 10, 0);

        addValue(ModArmorMaterials.SAPPHIRE, StatusEffects.NIGHT_VISION, 1200, 0);
        addValue(ModArmorMaterials.MOISSANITE, StatusEffects.CONDUIT_POWER, 10, 0);

        addValue(ModArmorMaterials.TURQUOISE, StatusEffects.WATER_BREATHING, 10, 0);
        addValue(ModArmorMaterials.TURQUOISE, StatusEffects.DOLPHINS_GRACE, 10, 0);
    }

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings)
    {
        super(material, type, settings);
    }

    private static void addValue(RegistryEntry<ArmorMaterial> key, RegistryEntry<StatusEffect> effect, int duration, int amplifier)
    {
        ArrayList tempList;

        StatusEffectInstance newEffect = new StatusEffectInstance(effect, duration, amplifier, false, false, true);

        if (MATERIAL_TO_EFFECT.containsKey(key))
        {
            tempList = MATERIAL_TO_EFFECT.get(key);
            if (tempList == null)
                tempList = new ArrayList<>();
            tempList.add(newEffect);
        }
        else
        {
            tempList = new ArrayList<>();
            tempList.add(newEffect);
        }

        MATERIAL_TO_EFFECT.put(key, tempList);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if (!world.isClient())
            if (entity instanceof PlayerEntity player && hasFullArmorSet(player))
                evaluateArmorEffect(player);
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasFullArmorSet(PlayerEntity player)
    {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private void evaluateArmorEffect(PlayerEntity player)
    {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, ArrayList<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT.entrySet())
        {
            ArmorMaterial material = entry.getKey().value();

            entry.getValue().forEach((effect) ->
            {
                if (hasCorrectArmor(material, player) && isStatusFading(player, effect))
                    addStatus(player, effect);
            });
        }
    }

    private boolean hasCorrectArmor(ArmorMaterial material, PlayerEntity player)
    {
        // Preventing Elytra from Crashing the Game (Elytra is not ArmorItem)
        for (ItemStack armor : player.getInventory().armor)
            if (!(armor.getItem() instanceof ArmorItem))
                return false;

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial().value() == material &&
                chestplate.getMaterial().value() == material &&
                leggings.getMaterial().value() == material &&
                boots.getMaterial().value() == material;
    }

    private boolean isStatusFading(PlayerEntity player, StatusEffectInstance effect)
    {
        StatusEffectInstance playerEffect = player.getStatusEffect(effect.getEffectType());

        return playerEffect == null ||
                !player.hasStatusEffect(effect.getEffectType()) ||
                playerEffect.isDurationBelow(220);
    }

    private void addStatus(PlayerEntity player, StatusEffectInstance effect)
    {
        player.addStatusEffect(new StatusEffectInstance(effect.getEffectType(),
                effect.getDuration(),
                effect.getAmplifier(),
                effect.isAmbient(),
                effect.shouldShowParticles(),
                effect.shouldShowIcon()));
    }
}