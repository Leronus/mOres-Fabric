package mod.leronus.mores.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent DARK_CHOCOLATE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).snack().build();
    public static final FoodComponent MILK_CHOCOLATE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).snack().build();
    public static final FoodComponent WHITE_CHOCOLATE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.2f).snack().build();
    public static final FoodComponent CARROT_PIE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.4f).build();
    public static final FoodComponent VELVET = new FoodComponent.Builder().nutrition(6).saturationModifier(0.4f).build();
    public static final FoodComponent LEMON_FRUIT = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();
    public static final FoodComponent LEMON_PIE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.6f).build();
    public static final FoodComponent APPLE_PIE = new FoodComponent.Builder().nutrition(9).saturationModifier(0.3f).build();
    public static final FoodComponent SWEET_BERRY_PIE = new FoodComponent.Builder().nutrition(7).saturationModifier(0.3f).build();
    public static final FoodComponent SILVER_CARROT = new FoodComponent.Builder().nutrition(4).saturationModifier(0.9f).build();
    public static final FoodComponent SILVER_APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 150), 1.0f)
            .alwaysEdible().build();
    public static final FoodComponent BRONZE_APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2400), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 125), 1.0f)
            .alwaysEdible().build();
    public static final FoodComponent COBALT_APPLE = new FoodComponent.Builder().nutrition(5).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2400), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 175), 1.0f)
            .alwaysEdible().build();
    public static final FoodComponent ENCHANTED_COBALT_APPLE = new FoodComponent.Builder()
            .nutrition(5).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 6000, 1), 1.0f)          // 5:00 Haste II
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1), 1.0f)    // 0:30 Regen II
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0), 1.0f)     // 5:00 Resistance I
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0f)// 5:00 Fire Res
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0f)     // 2:00 Absorption IV
            .alwaysEdible().build();
    public static final FoodComponent ROSE_GOLD_APPLE = new FoodComponent.Builder().nutrition(5).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2400), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 1.0f)
            .alwaysEdible().build();
    public static final FoodComponent ENCHANTED_ROSE_GOLD_APPLE = new FoodComponent.Builder()
            .nutrition(5).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 6000, 1), 1.0f)          // 5:00 Strength II
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1), 1.0f)    // 0:30 Regen II
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0), 1.0f)     // 5:00 Resistance I
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0f)// 5:00 Fire Res
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0f)     // 2:00 Absorption IV
            .alwaysEdible().build();

}