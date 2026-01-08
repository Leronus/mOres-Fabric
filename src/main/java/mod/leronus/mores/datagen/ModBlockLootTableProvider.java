package mod.leronus.mores.datagen;

import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {

    public ModBlockLootTableProvider(FabricDataOutput dataOutput,
                                     CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    // Ordered to match your material/tag order as closely as possible,
    // using only the loot tables present in blocks.zip.
    @Override
    public void generate() {
        // =========================
        // ALLOY FURNACE
        // =========================
        addDrop(ModBlocks.ALLOY_FURNACE);

        // =========================
        // ANTHRACITE
        // =========================
        addDrop(ModBlocks.ANTHRACITE_ORE, multipleOreDrops(ModBlocks.ANTHRACITE_ORE, ModItems.ANTHRACITE, 1f, 4f));
        addDrop(ModBlocks.DEEPSLATE_ANTHRACITE_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_ANTHRACITE_ORE, ModItems.ANTHRACITE, 1f, 5f));
        addDrop(ModBlocks.NETHER_ANTHRACITE_ORE, multipleOreDrops(ModBlocks.NETHER_ANTHRACITE_ORE, ModItems.ANTHRACITE, 1f, 6f));

        // =========================
        // TIN_INGOT (ores -> RAW_TIN)
        // =========================
        addDrop(ModBlocks.TIN_ORE, multipleOreDrops(ModBlocks.TIN_ORE, ModItems.RAW_TIN, 2f, 5f));
        addDrop(ModBlocks.DEEPSLATE_TIN_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN, 3f, 6f));

        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.RAW_TIN_BLOCK);

        // =========================
        // SILVER_INGOT (ores -> RAW_SILVER)
        // =========================
        addDrop(ModBlocks.SILVER_ORE, multipleOreDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER, 1f, 3f));
        addDrop(ModBlocks.DEEPSLATE_SILVER_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER, 1f, 4f));

        // Nether variant drops SILVER_NUGGET
        addDrop(ModBlocks.NETHER_SILVER_ORE, multipleOreDrops(ModBlocks.NETHER_SILVER_ORE, ModItems.SILVER_NUGGET, 1f, 5f));

        addDrop(ModBlocks.SILVER_BLOCK);
        addDrop(ModBlocks.RAW_SILVER_BLOCK);

        // =========================
        // SILVER_INGOT (ores -> RAW_SILVER)
        // =========================
        addDrop(ModBlocks.ELECTRUM_ORE,
                randomOneOfThreeDrops(ModBlocks.ELECTRUM_ORE,
                        ModItems.RAW_SILVER, 1f, 3f, 1,
                        Items.RAW_GOLD, 1f, 3f, 1,
                        Items.RAW_COPPER, 1f, 4f, 1));
        //TODO Add deepslate variant
//        addDrop(ModBlocks.DEEPSLATE_ELECTRUM_ORE,
//                randomOreDrops(ModBlocks.DEEPSLATE_ELECTRUM_ORE,
//                        ModItems.RAW_SILVER, 1f, 3f,
//                        Items.RAW_GOLD, 1f, 3f,
//                        Items.RAW_COPPER, 1f, 4f));


        // =========================
        // BRONZE_INGOT
        // =========================
        addDrop(ModBlocks.BRONZE_BLOCK);

        // =========================
        // COBALT_INGOT (ores -> RAW_COBALT)
        // =========================
        addDrop(ModBlocks.COBALT_ORE, oreDrop(ModBlocks.COBALT_ORE, ModItems.RAW_COBALT));
        addDrop(ModBlocks.DEEPSLATE_COBALT_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_COBALT_ORE, ModItems.RAW_COBALT, 1f, 2f));

        addDrop(ModBlocks.COBALT_BLOCK);
        addDrop(ModBlocks.RAW_COBALT_BLOCK);

        // =========================
        // STERLING_SILVER_INGOT
        // =========================
        addDrop(ModBlocks.STERLING_SILVER_BLOCK);

        // =========================
        // ROSE_GOLD_INGOT
        // =========================
        addDrop(ModBlocks.ROSE_GOLD_BLOCK);

        // =========================
        // CARBON_STEEL_INGOT / HARDENED_STEEL_INGOT
        // =========================
        addDrop(ModBlocks.CARBON_STEEL_BLOCK);
        addDrop(ModBlocks.HARDENED_STEEL_BLOCK);

        // =========================
        // AMETHYST
        // =========================
        addDrop(ModBlocks.AMETHYST_BLOCK);

        // =========================
        // TURQUOISE
        // =========================
        addDrop(ModBlocks.TURQUOISE_ORE, multipleOreDrops(ModBlocks.TURQUOISE_ORE, ModItems.TURQUOISE, 4f, 9f));
        addDrop(ModBlocks.DEEPSLATE_TURQUOISE_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_TURQUOISE_ORE, ModItems.TURQUOISE_GEM, 4f, 9f));
        addDrop(ModBlocks.TURQUOISE_BLOCK);

        // =========================
        // CITRINE (no blocks in attached loot tables)
        // =========================
        addDrop(ModBlocks.CITRINE_BLOCK);
        addDrop(ModBlocks.CITRINE_ORE, oreDrop(ModBlocks.CITRINE_ORE, ModItems.CITRINE));
        addDrop(ModBlocks.NETHER_CITRINE_ORE, oreDrop(ModBlocks.NETHER_CITRINE_ORE, ModItems.CITRINE));


        // =========================
        // ONYX (ore drops ONYX_GEM, block drops itself)
        // =========================
        addDrop(ModBlocks.ENDER_ONYX_ORE, oreDrop(ModBlocks.ENDER_ONYX_ORE, ModItems.ONYX));
        addDrop(ModBlocks.ONYX_BLOCK);

        // =========================
        // QUARTZ
        // =========================
        addDrop(ModBlocks.QUARTZ_ORE, oreDrop(ModBlocks.QUARTZ_ORE, Items.QUARTZ));

        // =========================
        // TANZANITE
        // =========================
        addDrop(ModBlocks.TANZANITE_ORE, oreDrop(ModBlocks.TANZANITE_ORE, ModItems.TANZANITE_GEM));
        addDrop(ModBlocks.DEEPSLATE_TANZANITE_ORE, oreDrop(ModBlocks.DEEPSLATE_TANZANITE_ORE, ModItems.TANZANITE_GEM));
        addDrop(ModBlocks.NETHER_TANZANITE_ORE, oreDrop(ModBlocks.NETHER_TANZANITE_ORE, ModItems.TANZANITE_GEM));
        addDrop(ModBlocks.TANZANITE_BLOCK);

        // =========================
        // TOURMALINE
        // =========================
        addDrop(ModBlocks.TOURMALINE_ORE, oreDrop(ModBlocks.TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.DEEPSLATE_TOURMALINE_ORE, oreDrop(ModBlocks.DEEPSLATE_TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.TOURMALINE_BLOCK);

        // =========================
        // TOPAZ
        // =========================
        addDrop(ModBlocks.TOPAZ_ORE, oreDrop(ModBlocks.TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.DEEPSLATE_TOPAZ_ORE, oreDrop(ModBlocks.DEEPSLATE_TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.TOPAZ_BLOCK);

        // =========================
        // RUBY
        // =========================
        addDrop(ModBlocks.RUBY_ORE, oreDrop(ModBlocks.RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, oreDrop(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.NETHER_RUBY_ORE, oreDrop(ModBlocks.NETHER_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.RUBY_BLOCK);

        // =========================
        // SAPPHIRE
        // =========================
        addDrop(ModBlocks.SAPPHIRE_ORE, oreDrop(ModBlocks.SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, oreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.NETHER_SAPPHIRE_ORE, oreDrop(ModBlocks.NETHER_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.SAPPHIRE_BLOCK);

        // =========================
        // SPINEL
        // =========================
        addDrop(ModBlocks.SPINEL_ORE, oreDrop(ModBlocks.SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.DEEPSLATE_SPINEL_ORE, oreDrop(ModBlocks.DEEPSLATE_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.NETHER_SPINEL_ORE, oreDrop(ModBlocks.NETHER_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.SPINEL_BLOCK);

        // =========================
        // MOISSANITE
        // =========================
        addDrop(ModBlocks.MOISSANITE_ORE, oreDrop(ModBlocks.MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.DEEPSLATE_MOISSANITE_ORE, oreDrop(ModBlocks.DEEPSLATE_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.NETHER_MOISSANITE_ORE, oreDrop(ModBlocks.NETHER_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.MOISSANITE_BLOCK);

        // =========================
        // GRAPHENE
        // =========================
        addDrop(ModBlocks.GRAPHENE_BLOCK);

        // =========================
        // ADAMANTIUM
        // =========================
        addDrop(ModBlocks.ADAMANTIUM_BLOCK);

        // =========================
        // ENDERITE
        // =========================
        addDrop(ModBlocks.ENDERITE_BLOCK);
        addDrop(ModBlocks.PRIMORDIAL_DEBRIS);

    }

    /**
     * Matches your attached loot tables:
     * - Silk Touch: drop the ore block
     * - Otherwise: drop the given item, Fortune applies (ore_drops), explosion_decay applies
     */
    private LootTable.Builder oreDrop(Block drop, Item item) {
        RegistryWrapper.Impl<Enchantment> impl =
                this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        return this.dropsWithSilkTouch(
                drop,
                this.applyExplosionDecay(
                        drop,
                        ((LeafEntry.Builder<?>)
                                ItemEntry.builder(item)
                                        .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))))
                )
        );
    }

    /**
     * Matches your attached loot tables for tin_ore / deepslate_tin_ore:
     * - Silk Touch: drop the ore block
     * - Otherwise: drop the given item with uniform count [minDrops..maxDrops],
     *   Fortune applies (ore_drops), explosion_decay applies
     */
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl =
                this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        return this.dropsWithSilkTouch(
                drop,
                this.applyExplosionDecay(
                        drop,
                        ((LeafEntry.Builder<?>)
                                ItemEntry.builder(item)
                                        .apply(SetCountLootFunction.builder(
                                                UniformLootNumberProvider.create(minDrops, maxDrops)
                                        )))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }


    private LootTable.Builder randomOneOfThreeDrops(
            Block ore,
            Item itemA, float minA, float maxA, int weightA,
            Item itemB, float minB, float maxB, int weightB,
            Item itemC, float minC, float maxC, int weightC
    ) {
        RegistryWrapper.Impl<Enchantment> ench =
                this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        var fortune = ench.getOrThrow(Enchantments.FORTUNE);

        int sum = weightA + weightB + weightC;
        if (sum <= 0) throw new IllegalArgumentException("Weights must be > 0");

        // Chained probabilities for AlternativeEntry (first match wins):
        // A triggers with pA
        // B triggers with pB / (1 - pA) which simplifies to weightB/(weightB+weightC)
        // C is fallback
        float chanceA = (float) weightA / (float) sum;
        float chanceB = (float) weightB / (float) (weightB + weightC);

        LeafEntry.Builder<?> a = this.applyExplosionDecay(
                ore,
                ((LeafEntry.Builder<?>) ItemEntry.builder(itemA)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minA, maxA))))
                        .apply(ApplyBonusLootFunction.oreDrops(fortune))
        ).conditionally(RandomChanceLootCondition.builder(chanceA));

        LeafEntry.Builder<?> b = this.applyExplosionDecay(
                ore,
                ((LeafEntry.Builder<?>) ItemEntry.builder(itemB)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minB, maxB))))
                        .apply(ApplyBonusLootFunction.oreDrops(fortune))
        ).conditionally(RandomChanceLootCondition.builder(chanceB));

        LeafEntry.Builder<?> c = this.applyExplosionDecay(
                ore,
                ((LeafEntry.Builder<?>) ItemEntry.builder(itemC)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minC, maxC))))
                        .apply(ApplyBonusLootFunction.oreDrops(fortune))
        );

        // dropsWithSilkTouch wants a LootPoolEntry.Builder<?> (AlternativeEntry is perfect)
        return this.dropsWithSilkTouch(ore, AlternativeEntry.builder(a, b, c));
    }
}
