package mod.leronus.mores.item.custom;

import com.google.common.collect.ImmutableMap;
import mod.leronus.mores.item.ModArmorMaterials;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterials.TIN, new StatusEffectInstance(StatusEffects.JUMP_BOOST, 10, 1,
                            false, true, false))
                    .put(ModArmorMaterials.COBALT, new StatusEffectInstance(StatusEffects.HASTE, 10, 0,
                            false, true, false))
                    .put(ModArmorMaterials.STEEL, new StatusEffectInstance(StatusEffects.STRENGTH, 10, 0,
                            false, true, false))
                    .put(ModArmorMaterials.AMETHYST, new StatusEffectInstance(StatusEffects.SLOW_FALLING, 10, 0,
                            false, true, false))
                    .put(ModArmorMaterials.EMERALD, new StatusEffectInstance(StatusEffects.LUCK, 10, 0,
                            false, true, false))
                    .put(ModArmorMaterials.TOPAZ, new StatusEffectInstance(StatusEffects.HASTE, 10, 1,
                            false, true, false))
                    .put(ModArmorMaterials.TOURMALINE, new StatusEffectInstance(StatusEffects.REGENERATION, 10, 0,
                            false, true, false))
                    .put(ModArmorMaterials.TANZANITE, new StatusEffectInstance(StatusEffects.SPEED, 10, 0,
                            false, true, false))
                    .put(ModArmorMaterials.RUBY, new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 10, 0,
                            false, true, false))
                    .put(ModArmorMaterials.SAPPHIRE, new StatusEffectInstance(StatusEffects.NIGHT_VISION, 250, 0,
                            false, true, false))
                    .put(ModArmorMaterials.MOISSANITE, new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 10, 0,
                            false, true, false))
                    .put(ModArmorMaterials.TURQUOISE, new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 10, 0,
                            false, true, false))
                    .build();

    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player && hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());
        StatusEffect playerEffect = mapStatusEffect.getEffectType();
        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect));
        }
        if (hasCorrectArmorOn(mapArmorMaterial, player) && playerEffect == StatusEffects.NIGHT_VISION){
            player.setStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 250, 0,
                    false, true, false), null);
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack: player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.getItem() instanceof ModArmorItem){
            ModArmorItem item = (ModArmorItem) stack.getItem();

            if (item.getMaterial() == ModArmorMaterials.TIN) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.full_set_bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.jump_boost").formatted(Formatting.YELLOW)));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.TIN.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.COBALT) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.full_set_bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.haste").formatted(Formatting.GOLD)));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.COBALT.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.AMETHYST) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.full_set_bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.slow_falling").formatted(Formatting.YELLOW)));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.AMETHYST.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.OBSIDIAN) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.OBSIDIAN.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.EMERALD) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.full_set_bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.luck").formatted(Formatting.GREEN)));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.EMERALD.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.TOURMALINE) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.full_set_bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.regeneration").formatted(Formatting.RED)));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.TOURMALINE.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.TANZANITE) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.full_set_bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.speed").formatted(Formatting.YELLOW)));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.TANZANITE.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.RUBY) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.full_set_bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.fire_resistance").formatted(Formatting.DARK_RED)));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.RUBY.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.SAPPHIRE) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.full_set_bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.night_vision").formatted(Formatting.BLUE)));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.SAPPHIRE.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.TURQUOISE) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.full_set_bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.water_effects").formatted(Formatting.AQUA)));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.TURQUOISE.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.COPPER) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.COPPER.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.BRONZE) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.BRONZE.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.SILVER) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.SILVER.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.STERLING) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.STERLING.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.STEEL) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.full_set_bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.strength").formatted(Formatting.DARK_PURPLE)));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.STEEL.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.TOPAZ) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.full_set_bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.haste").formatted(Formatting.GOLD)));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.TOPAZ.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.MOISSANITE) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.full_set_bonus").formatted(Formatting.GRAY).append(Text.translatable("mores.conduit").formatted(Formatting.AQUA)));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.MOISSANITE.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.ONYX) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.ONYX.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            } else if (item.getMaterial() == ModArmorMaterials.GRAPHENE) {
                //Making the tooltips
                tooltip.add(Text.translatable(""));
                tooltip.add(Text.translatable("mores.durability").formatted(Formatting.GRAY).append(Text.translatable(String.valueOf(ModArmorMaterials.GRAPHENE.getDurability(item.getType()))).formatted(Formatting.LIGHT_PURPLE)));
            }
        }
    }
}