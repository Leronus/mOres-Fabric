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
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.GroupEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
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
        addDrop(ModBlocks.STEEL_CUTTER);

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
        addDrop(ModBlocks.ANDESITE_TIN_ORE, multipleOreDrops(ModBlocks.ANDESITE_TIN_ORE, ModItems.RAW_TIN, 2f, 5f));
        addDrop(ModBlocks.GRANITE_TIN_ORE, multipleOreDrops(ModBlocks.GRANITE_TIN_ORE, ModItems.RAW_TIN, 2f, 5f));
        addDrop(ModBlocks.GRAVEL_TIN_ORE, multipleOreDrops(ModBlocks.GRAVEL_TIN_ORE, ModItems.RAW_TIN, 2f, 5f));
        addDrop(ModBlocks.TUFF_TIN_ORE, multipleOreDrops(ModBlocks.TUFF_TIN_ORE, ModItems.RAW_TIN, 2f, 5f));
        addDrop(ModBlocks.DEEPSLATE_TIN_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN, 3f, 6f));

        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.RAW_TIN_BLOCK);

        // =========================
        // SILVER_INGOT (ores -> RAW_SILVER)
        // =========================
        addDrop(ModBlocks.SILVER_ORE, multipleOreDrops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER, 1f, 3f));
        addDrop(ModBlocks.DEEPSLATE_SILVER_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER, 3f, 6f));
        addDrop(ModBlocks.ANDESITE_SILVER_ORE, multipleOreDrops(ModBlocks.ANDESITE_SILVER_ORE, ModItems.RAW_SILVER, 1f, 3f));
        addDrop(ModBlocks.BASALT_SILVER_ORE, multipleOreDrops(ModBlocks.BASALT_SILVER_ORE, ModItems.RAW_SILVER, 1f, 3f));
        addDrop(ModBlocks.BLACKSTONE_SILVER_ORE, multipleOreDrops(ModBlocks.BLACKSTONE_SILVER_ORE, ModItems.RAW_SILVER, 1f, 3f));
        addDrop(ModBlocks.CALCITE_SILVER_ORE, multipleOreDrops(ModBlocks.CALCITE_SILVER_ORE, ModItems.RAW_SILVER, 1f, 3f));
        addDrop(ModBlocks.DIORITE_SILVER_ORE, multipleOreDrops(ModBlocks.DIORITE_SILVER_ORE, ModItems.RAW_SILVER, 1f, 3f));
        addDrop(ModBlocks.GRANITE_SILVER_ORE, multipleOreDrops(ModBlocks.GRANITE_SILVER_ORE, ModItems.RAW_SILVER, 1f, 3f));
        addDrop(ModBlocks.GRAVEL_SILVER_ORE, multipleOreDrops(ModBlocks.GRAVEL_SILVER_ORE, ModItems.RAW_SILVER, 1f, 3f));
        addDrop(ModBlocks.TUFF_SILVER_ORE, multipleOreDrops(ModBlocks.TUFF_SILVER_ORE, ModItems.RAW_SILVER, 1f, 3f));
        addDrop(ModBlocks.ENDER_SILVER_ORE, multipleOreDrops(ModBlocks.ENDER_SILVER_ORE, ModItems.RAW_SILVER, 3f, 6f));

        // Nether variant drops SILVER_NUGGET
        addDrop(ModBlocks.NETHER_SILVER_ORE, multipleOreDrops(ModBlocks.NETHER_SILVER_ORE, ModItems.SILVER_NUGGET, 4f, 8f));

        addDrop(ModBlocks.SILVER_BLOCK);
        addDrop(ModBlocks.RAW_SILVER_BLOCK);

        // =========================
        // SILVER_INGOT (ores -> RAW_SILVER)
        // =========================
        addDrop(ModBlocks.ELECTRUM_ORE,
                allThreeDrops(ModBlocks.ELECTRUM_ORE,
                        ModItems.RAW_SILVER, 1f, 3f,
                        Items.RAW_GOLD, 1f, 3f,
                        Items.RAW_COPPER, 1f, 4f));
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
        addDrop(ModBlocks.ANDESITE_COBALT_ORE, multipleOreDrops(ModBlocks.ANDESITE_COBALT_ORE, ModItems.RAW_COBALT, 1f, 2f));
        addDrop(ModBlocks.BASALT_COBALT_ORE, multipleOreDrops(ModBlocks.BASALT_COBALT_ORE, ModItems.RAW_COBALT, 1f, 2f));
        addDrop(ModBlocks.BLACKSTONE_COBALT_ORE, multipleOreDrops(ModBlocks.BLACKSTONE_COBALT_ORE, ModItems.RAW_COBALT, 1f, 2f));
        addDrop(ModBlocks.CALCITE_COBALT_ORE, multipleOreDrops(ModBlocks.CALCITE_COBALT_ORE, ModItems.RAW_COBALT, 1f, 2f));
        addDrop(ModBlocks.DIORITE_COBALT_ORE, multipleOreDrops(ModBlocks.DIORITE_COBALT_ORE, ModItems.RAW_COBALT, 1f, 2f));
        addDrop(ModBlocks.GRANITE_COBALT_ORE, multipleOreDrops(ModBlocks.GRANITE_COBALT_ORE, ModItems.RAW_COBALT, 1f, 2f));
        addDrop(ModBlocks.GRAVEL_COBALT_ORE, multipleOreDrops(ModBlocks.GRAVEL_COBALT_ORE, ModItems.RAW_COBALT, 1f, 2f));
        addDrop(ModBlocks.TUFF_COBALT_ORE, multipleOreDrops(ModBlocks.TUFF_COBALT_ORE, ModItems.RAW_COBALT, 1f, 2f));
        addDrop(ModBlocks.ENDER_COBALT_ORE, multipleOreDrops(ModBlocks.ENDER_COBALT_ORE, ModItems.RAW_COBALT, 3f, 6f));

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
        addDrop(ModBlocks.TURQUOISE_ORE, multipleOreDrops(ModBlocks.TURQUOISE_ORE, ModItems.TURQUOISE, 3f, 7f));
        addDrop(ModBlocks.DEEPSLATE_TURQUOISE_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_TURQUOISE_ORE, ModItems.TURQUOISE, 3f, 7f));
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
        addDrop(ModBlocks.NETHER_ONYX_ORE, oreDrop(ModBlocks.NETHER_ONYX_ORE, ModItems.ONYX));
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
        addDrop(ModBlocks.ENDER_TANZANITE_ORE, oreDrop(ModBlocks.ENDER_TANZANITE_ORE, ModItems.TANZANITE_GEM));
        addDrop(ModBlocks.ANDESITE_TANZANITE_ORE, oreDrop(ModBlocks.ANDESITE_TANZANITE_ORE, ModItems.TANZANITE_GEM));
        addDrop(ModBlocks.BASALT_TANZANITE_ORE, oreDrop(ModBlocks.BASALT_TANZANITE_ORE, ModItems.TANZANITE_GEM));
        addDrop(ModBlocks.BLACKSTONE_TANZANITE_ORE, oreDrop(ModBlocks.BLACKSTONE_TANZANITE_ORE, ModItems.TANZANITE_GEM));
        addDrop(ModBlocks.CALCITE_TANZANITE_ORE, oreDrop(ModBlocks.CALCITE_TANZANITE_ORE, ModItems.TANZANITE_GEM));
        addDrop(ModBlocks.DIORITE_TANZANITE_ORE, oreDrop(ModBlocks.DIORITE_TANZANITE_ORE, ModItems.TANZANITE_GEM));
        addDrop(ModBlocks.GRANITE_TANZANITE_ORE, oreDrop(ModBlocks.GRANITE_TANZANITE_ORE, ModItems.TANZANITE_GEM));
        addDrop(ModBlocks.GRAVEL_TANZANITE_ORE, gravelOreDropWithFortuneFlint(ModBlocks.GRAVEL_TANZANITE_ORE, ModItems.TANZANITE_GEM));
        addDrop(ModBlocks.TUFF_TANZANITE_ORE, oreDrop(ModBlocks.TUFF_TANZANITE_ORE, ModItems.TANZANITE_GEM));
        addDrop(ModBlocks.TANZANITE_BLOCK);

        // =========================
        // TOURMALINE
        // =========================
        addDrop(ModBlocks.TOURMALINE_ORE, oreDrop(ModBlocks.TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.DEEPSLATE_TOURMALINE_ORE, oreDrop(ModBlocks.DEEPSLATE_TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.NETHER_TOURMALINE_ORE, oreDrop(ModBlocks.NETHER_TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.ENDER_TOURMALINE_ORE, oreDrop(ModBlocks.ENDER_TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.ANDESITE_TOURMALINE_ORE, oreDrop(ModBlocks.ANDESITE_TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.BASALT_TOURMALINE_ORE, oreDrop(ModBlocks.BASALT_TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.BLACKSTONE_TOURMALINE_ORE, oreDrop(ModBlocks.BLACKSTONE_TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.CALCITE_TOURMALINE_ORE, oreDrop(ModBlocks.CALCITE_TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.DIORITE_TOURMALINE_ORE, oreDrop(ModBlocks.DIORITE_TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.GRANITE_TOURMALINE_ORE, oreDrop(ModBlocks.GRANITE_TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.GRAVEL_TOURMALINE_ORE, gravelOreDropWithFortuneFlint(ModBlocks.GRAVEL_TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.TUFF_TOURMALINE_ORE, oreDrop(ModBlocks.TUFF_TOURMALINE_ORE, ModItems.TOURMALINE_GEM));
        addDrop(ModBlocks.TOURMALINE_BLOCK);

        // =========================
        // TOPAZ
        // =========================
        addDrop(ModBlocks.TOPAZ_ORE, oreDrop(ModBlocks.TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.DEEPSLATE_TOPAZ_ORE, oreDrop(ModBlocks.DEEPSLATE_TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.NETHER_TOPAZ_ORE, oreDrop(ModBlocks.NETHER_TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.ENDER_TOPAZ_ORE, oreDrop(ModBlocks.ENDER_TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.ANDESITE_TOPAZ_ORE, oreDrop(ModBlocks.ANDESITE_TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.BASALT_TOPAZ_ORE, oreDrop(ModBlocks.BASALT_TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.BLACKSTONE_TOPAZ_ORE, oreDrop(ModBlocks.BLACKSTONE_TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.CALCITE_TOPAZ_ORE, oreDrop(ModBlocks.CALCITE_TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.DIORITE_TOPAZ_ORE, oreDrop(ModBlocks.DIORITE_TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.GRANITE_TOPAZ_ORE, oreDrop(ModBlocks.GRANITE_TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.GRAVEL_TOPAZ_ORE, gravelOreDropWithFortuneFlint(ModBlocks.GRAVEL_TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.TUFF_TOPAZ_ORE, oreDrop(ModBlocks.TUFF_TOPAZ_ORE, ModItems.TOPAZ_GEM));
        addDrop(ModBlocks.TOPAZ_BLOCK);

        // =========================
        // RUBY
        // =========================
        addDrop(ModBlocks.RUBY_ORE, oreDrop(ModBlocks.RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, oreDrop(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.NETHER_RUBY_ORE, oreDrop(ModBlocks.NETHER_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.ENDER_RUBY_ORE, oreDrop(ModBlocks.ENDER_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.ANDESITE_RUBY_ORE, oreDrop(ModBlocks.ANDESITE_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.BASALT_RUBY_ORE, oreDrop(ModBlocks.BASALT_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.BLACKSTONE_RUBY_ORE, oreDrop(ModBlocks.BLACKSTONE_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.CALCITE_RUBY_ORE, oreDrop(ModBlocks.CALCITE_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.DIORITE_RUBY_ORE, oreDrop(ModBlocks.DIORITE_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.GRANITE_RUBY_ORE, oreDrop(ModBlocks.GRANITE_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.GRAVEL_RUBY_ORE, gravelOreDropWithFortuneFlint(ModBlocks.GRAVEL_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.TUFF_RUBY_ORE, oreDrop(ModBlocks.TUFF_RUBY_ORE, ModItems.RUBY_GEM));
        addDrop(ModBlocks.RUBY_BLOCK);

        // =========================
        // SAPPHIRE
        // =========================
        addDrop(ModBlocks.SAPPHIRE_ORE, oreDrop(ModBlocks.SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, oreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.NETHER_SAPPHIRE_ORE, oreDrop(ModBlocks.NETHER_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.ENDER_SAPPHIRE_ORE, oreDrop(ModBlocks.ENDER_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.ANDESITE_SAPPHIRE_ORE, oreDrop(ModBlocks.ANDESITE_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.BASALT_SAPPHIRE_ORE, oreDrop(ModBlocks.BASALT_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.BLACKSTONE_SAPPHIRE_ORE, oreDrop(ModBlocks.BLACKSTONE_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.CALCITE_SAPPHIRE_ORE, oreDrop(ModBlocks.CALCITE_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.DIORITE_SAPPHIRE_ORE, oreDrop(ModBlocks.DIORITE_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.GRANITE_SAPPHIRE_ORE, oreDrop(ModBlocks.GRANITE_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.GRAVEL_SAPPHIRE_ORE, gravelOreDropWithFortuneFlint(ModBlocks.GRAVEL_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.TUFF_SAPPHIRE_ORE, oreDrop(ModBlocks.TUFF_SAPPHIRE_ORE, ModItems.SAPPHIRE_GEM));
        addDrop(ModBlocks.SAPPHIRE_BLOCK);

        // =========================
        // SPINEL
        // =========================
        addDrop(ModBlocks.SPINEL_ORE, oreDrop(ModBlocks.SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.DEEPSLATE_SPINEL_ORE, oreDrop(ModBlocks.DEEPSLATE_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.NETHER_SPINEL_ORE, oreDrop(ModBlocks.NETHER_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.ENDER_SPINEL_ORE, oreDrop(ModBlocks.ENDER_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.ANDESITE_SPINEL_ORE, oreDrop(ModBlocks.ANDESITE_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.BASALT_SPINEL_ORE, oreDrop(ModBlocks.BASALT_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.BLACKSTONE_SPINEL_ORE, oreDrop(ModBlocks.BLACKSTONE_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.CALCITE_SPINEL_ORE, oreDrop(ModBlocks.CALCITE_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.DIORITE_SPINEL_ORE, oreDrop(ModBlocks.DIORITE_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.GRANITE_SPINEL_ORE, oreDrop(ModBlocks.GRANITE_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.GRAVEL_SPINEL_ORE, gravelOreDropWithFortuneFlint(ModBlocks.GRAVEL_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.TUFF_SPINEL_ORE, oreDrop(ModBlocks.TUFF_SPINEL_ORE, ModItems.SPINEL_GEM));
        addDrop(ModBlocks.SPINEL_BLOCK);

        // =========================
        // MOISSANITE
        // =========================
        addDrop(ModBlocks.MOISSANITE_ORE, oreDrop(ModBlocks.MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.DEEPSLATE_MOISSANITE_ORE, oreDrop(ModBlocks.DEEPSLATE_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.NETHER_MOISSANITE_ORE, oreDrop(ModBlocks.NETHER_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.ENDER_MOISSANITE_ORE, oreDrop(ModBlocks.ENDER_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.ANDESITE_MOISSANITE_ORE, oreDrop(ModBlocks.ANDESITE_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.BASALT_MOISSANITE_ORE, oreDrop(ModBlocks.BASALT_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.BLACKSTONE_MOISSANITE_ORE, oreDrop(ModBlocks.BLACKSTONE_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.CALCITE_MOISSANITE_ORE, oreDrop(ModBlocks.CALCITE_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.DIORITE_MOISSANITE_ORE, oreDrop(ModBlocks.DIORITE_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.GRANITE_MOISSANITE_ORE, oreDrop(ModBlocks.GRANITE_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.GRAVEL_MOISSANITE_ORE, gravelOreDropWithFortuneFlint(ModBlocks.GRAVEL_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.TUFF_MOISSANITE_ORE, oreDrop(ModBlocks.TUFF_MOISSANITE_ORE, ModItems.MOISSANITE_GEM));
        addDrop(ModBlocks.MOISSANITE_BLOCK);


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

    private LootTable.Builder allThreeDrops(
            Block ore,
            Item itemA, float minA, float maxA,
            Item itemB, float minB, float maxB,
            Item itemC, float minC, float maxC
    ) {
        RegistryWrapper.Impl<Enchantment> ench =
                this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        var fortune = ench.getOrThrow(Enchantments.FORTUNE);

        LeafEntry.Builder<?> a = this.applyExplosionDecay(
                ore,
                ((LeafEntry.Builder<?>) ItemEntry.builder(itemA)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minA, maxA))))
                        .apply(ApplyBonusLootFunction.oreDrops(fortune))
        );

        LeafEntry.Builder<?> b = this.applyExplosionDecay(
                ore,
                ((LeafEntry.Builder<?>) ItemEntry.builder(itemB)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minB, maxB))))
                        .apply(ApplyBonusLootFunction.oreDrops(fortune))
        );

        LeafEntry.Builder<?> c = this.applyExplosionDecay(
                ore,
                ((LeafEntry.Builder<?>) ItemEntry.builder(itemC)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minC, maxC))))
                        .apply(ApplyBonusLootFunction.oreDrops(fortune))
        );

        // Drop all three entries (A+B+C) when NOT silk touch.
        return this.dropsWithSilkTouch(ore, GroupEntry.create(a, b, c));
    }


    private LootTable.Builder gravelOreDropWithFortuneFlint(Block drop, Item gem) {
        RegistryWrapper.Impl<Enchantment> ench =
                this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        var fortune = ench.getOrThrow(Enchantments.FORTUNE);

        // Always 1 gem, but Fortune can increase it (vanilla ore behavior)
        LeafEntry.Builder<?> gemEntry =
                this.applyExplosionDecay(
                        drop,
                        ((LeafEntry.Builder<?>) ItemEntry.builder(gem))
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .apply(ApplyBonusLootFunction.oreDrops(fortune))
                );

        // Sometimes flint (Fortune-boosted exactly like gravel)
        LeafEntry.Builder<?> flintEntry =
                this.applyExplosionDecay(drop, ItemEntry.builder(Items.FLINT))
                        .conditionally(TableBonusLootCondition.builder(
                                fortune,
                                new float[]{0.1F, 0.14285715F, 0.25F, 1.0F}
                        ));

        // Silk Touch -> block; otherwise drop gem (always) + flint (sometimes)
        return this.dropsWithSilkTouch(drop, GroupEntry.create(gemEntry, flintEntry));
    }


}
