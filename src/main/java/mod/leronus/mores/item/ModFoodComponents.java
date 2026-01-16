package mod.leronus.mores.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent DARK_CHOCOLATE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).snack().build();
    public static final FoodComponent MILK_CHOCOLATE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3f).snack().build();
    public static final FoodComponent WHITE_CHOCOLATE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.2f).snack().build();
    public static final FoodComponent CARROT_PIE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.6f).build();
    public static final FoodComponent VELVET = new FoodComponent.Builder().nutrition(4).saturationModifier(0.6f).build();
    public static final FoodComponent LEMON_FRUIT = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();
    public static final FoodComponent LEMON_PIE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.6f).build();
    public static final FoodComponent APPLE_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).build();
    public static final FoodComponent SWEET_BERRY_PIE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).build();

    public static final FoodComponent SILVER_APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 2000), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 150), 1.0f).alwaysEdible().build();
    public static final FoodComponent BRONZE_APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100), 1.0f).alwaysEdible().build();
    public static final FoodComponent COBALT_APPLE = new FoodComponent.Builder().nutrition(5).saturationModifier(1.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2400), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 1.0f).alwaysEdible().build();
}