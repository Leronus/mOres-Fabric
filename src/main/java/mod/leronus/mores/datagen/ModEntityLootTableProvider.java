package mod.leronus.mores.datagen;

import mod.leronus.mores.item.ModItems;
import mod.leronus.mores.loot.ModLootTables;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.FurnaceSmeltLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModEntityLootTableProvider extends SimpleFabricLootTableProvider {

    public ModEntityLootTableProvider(FabricDataOutput output,
                                      CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup, LootContextTypes.ENTITY);
    }

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> exporter) {

        // =========================
        // DUCK drops (on death)
        // =========================
        exporter.accept(ModLootTables.DUCK,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(ModItems.RAW_DUCK)
                                        .apply(
                                                FurnaceSmeltLootFunction.builder()
                                                        .conditionally(EntityPropertiesLootCondition.builder(
                                                                LootContext.EntityTarget.THIS,
                                                                EntityPredicate.Builder.create()
                                                                        .flags(EntityFlagsPredicate.Builder.create().onFire(true))
                                                        ))
                                        )
                                )
                        )
                        // feathers: 0–2
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(Items.FEATHER)
                                        .apply(SetCountLootFunction.builder(
                                                UniformLootNumberProvider.create(0.0F, 2.0F)))))
                        // duck egg: 10% chance (optional)
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(0.10F))
                                .with(ItemEntry.builder(ModItems.DUCK_EGG)))
        );

        // =========================
        // HARDENED STEEL GOLEM drops (on death)
        // =========================
        exporter.accept(ModLootTables.HARDENED_STEEL_GOLEM,
                LootTable.builder()
                        // nuggets: 2–5
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(ModItems.HARDENED_STEEL_NUGGET)
                                        .apply(SetCountLootFunction.builder(
                                                UniformLootNumberProvider.create(1.0F, 6.0F)))))
                        // extra iron ingot: 0–2 (example)
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(ModItems.HARDENED_STEEL_INGOT)
                                        .apply(SetCountLootFunction.builder(
                                                UniformLootNumberProvider.create(3.0F, 5.0F)))))
                        // poppy flower: 0–2 (example)
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(Items.POPPY)
                                        .apply(SetCountLootFunction.builder(
                                                UniformLootNumberProvider.create(0.0F, 2.0F)))))
        );
    }
}
