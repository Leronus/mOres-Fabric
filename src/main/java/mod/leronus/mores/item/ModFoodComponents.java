package mod.leronus.mores.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CHOCOLATE = new FoodComponent.Builder().hunger(4).saturationModifier(0.8f).build();
    public static final FoodComponent CARROT_PIE = new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build();
    public static final FoodComponent VELVET = new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build();

    public static final FoodComponent SILVER_APPLE = new FoodComponent.Builder().hunger(5).saturationModifier(0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200), 0.25f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 0.25f).build();
    public static final FoodComponent BRONZE_APPLE = new FoodComponent.Builder().hunger(5).saturationModifier(0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200), 0.25f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 0.25f).build();
    public static final FoodComponent COBALT_APPLE = new FoodComponent.Builder().hunger(5).saturationModifier(0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 400), 0.25f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 0.25f).build();
}