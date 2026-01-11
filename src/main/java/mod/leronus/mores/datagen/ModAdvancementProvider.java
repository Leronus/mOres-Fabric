package mod.leronus.mores.datagen;

import mod.leronus.mores.Mores;
import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.entity.ModEntities;
import mod.leronus.mores.item.ModItems;

import mod.leronus.mores.item.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;

import net.minecraft.advancement.criterion.*;

import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {

    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registries, Consumer<AdvancementEntry> exporter) {

        // -------------------------
        // ROOT TAB
        // -------------------------
        AdvancementEntry root = Advancement.Builder.create()
                .display(displayWithBackground(
                        ModBlocks.ENDER_RUBY_ORE,
                        "mOres Reloaded",
                        "Progress through new ores, alloys, and gems.",
                        Identifier.of(Mores.MOD_ID, "textures/gui/advancements/background.png"),
                        AdvancementFrame.TASK,
                        0, 0
                ))
                .criterion("has_crafting_table", hasItem(Items.CRAFTING_TABLE))
                .build(exporter, id("root"));


        // -------------------------
        // TIN BRANCH
        // -------------------------
        AdvancementEntry obtainTin = Advancement.Builder.create()
                .parent(root)
                .display(display(
                        ModItems.TIN_INGOT,
                        "Obtain Tin Ingot",
                        "Acquire a tin ingot.",
                        AdvancementFrame.TASK,
                        2, 0
                ))
                .criterion("has_tin", hasItem(ModItems.TIN_INGOT))
                .build(exporter, id("obtain_tin_ingot"));

        AdvancementEntry fullTinArmor = Advancement.Builder.create()
                .parent(obtainTin)
                .display(display(
                        ModItems.TIN_CHESTPLATE,
                        "Whiter than Bart",
                        "Craft a full set of tin armor.",
                        AdvancementFrame.TASK,
                        3, 2
                ))
                .criterion("tin_helmet", hasItem(ModItems.TIN_HELMET))
                .criterion("tin_chestplate", hasItem(ModItems.TIN_CHESTPLATE))
                .criterion("tin_leggings", hasItem(ModItems.TIN_LEGGINGS))
                .criterion("tin_boots", hasItem(ModItems.TIN_BOOTS))
                .build(exporter, id("full_tin_armor"));


        // -------------------------
        // METAL BRANCH
        // -------------------------
        AdvancementEntry obtainSilver = Advancement.Builder.create()
                .parent(obtainTin)
                .display(display(
                        ModItems.SILVER_INGOT,
                        "Obtain Silver Ingot",
                        "Acquire a silver ingot.",
                        AdvancementFrame.TASK,
                        6, 0
                ))
                .criterion("has_silver", hasItem(ModItems.SILVER_INGOT))
                .build(exporter, id("obtain_silver_ingot"));
        AdvancementEntry fullSilverArmor = Advancement.Builder.create()
                .parent(obtainSilver)
                .display(display(
                        ModItems.SILVER_CHESTPLATE,
                        "Quicksilver",
                        "Craft a full set of silver armor.",
                        AdvancementFrame.TASK,
                        7, 2
                ))
                .criterion("silver_helmet", hasItem(ModItems.SILVER_HELMET))
                .criterion("silver_chestplate", hasItem(ModItems.SILVER_CHESTPLATE))
                .criterion("silver_leggings", hasItem(ModItems.SILVER_LEGGINGS))
                .criterion("silver_boots", hasItem(ModItems.SILVER_BOOTS))
                .build(exporter, id("full_silver_armor"));
        AdvancementEntry eatSilverApple = Advancement.Builder.create()
                .parent(obtainSilver)
                .display(display(
                        ModItems.SILVER_APPLE,
                        "Crunchy",
                        "Craft a silver apple.",
                        AdvancementFrame.TASK,
                        7, 4
                ))
                .criterion("has_silver_apple", hasItem(ModItems.SILVER_APPLE))
                .build(exporter, id("eat_silver_apple"));

        // Cobalt
        AdvancementEntry obtainCobalt = Advancement.Builder.create()
                .parent(obtainSilver)
                .display(display(
                        ModItems.COBALT_INGOT,
                        "Very Cobalt",
                        "Obtain a cobalt ingot.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_carbon_steel", hasItem(ModItems.CARBON_STEEL_INGOT))
                .build(exporter, id("hephaestus"));

        AdvancementEntry fullCobaltArmor = Advancement.Builder.create()
                .parent(obtainCobalt)
                .display(display(
                        ModItems.COBALT_CHESTPLATE,
                        "Built Different",
                        "Craft a full set of cobalt armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("cobalt_helmet", hasItem(ModItems.COBALT_HELMET))
                .criterion("cobalt_chestplate", hasItem(ModItems.COBALT_CHESTPLATE))
                .criterion("cobalt_leggings", hasItem(ModItems.COBALT_LEGGINGS))
                .criterion("cobalt_boots", hasItem(ModItems.COBALT_BOOTS))
                .build(exporter, id("full_cobalt_armor"));

        // -------------------------
        // ALLOY FURNACE BRANCH
        // -------------------------
        AdvancementEntry alloyFurnace = Advancement.Builder.create()
                .parent(obtainTin)
                .display(display(
                        ModBlocks.ALLOY_FURNACE.asItem(),
                        "Alloying Time",
                        "Craft an alloy furnace.",
                        AdvancementFrame.TASK,
                        2, 6
                ))
                .criterion("has_alloy_furnace", hasItem(ModBlocks.ALLOY_FURNACE.asItem()))
                .build(exporter, id("craft_alloy_furnace"));

        // Bronze
        AdvancementEntry obtainBronze = Advancement.Builder.create()
                .parent(alloyFurnace)
                .display(display(
                        ModItems.BRONZE_INGOT,
                        "The Bronze Age",
                        "Obtain a bronze ingot by alloying copper and tin.",
                        AdvancementFrame.TASK,
                        4, 6
                ))
                .criterion("has_bronze", hasItem(ModItems.BRONZE_INGOT))
                .build(exporter, id("obtain_bronze_ingot"));
        AdvancementEntry bronzeApple = Advancement.Builder.create()
                .parent(obtainBronze)
                .display(display(
                        ModItems.BRONZE_APPLE,
                        "Bronze Snacc",
                        "Eat a bronze apple.",
                        AdvancementFrame.TASK,
                        6, 6
                ))
                .criterion("eat_bronze_apple", eatItem(ModItems.BRONZE_APPLE))
                .build(exporter, id("eat_bronze_apple"));
        AdvancementEntry fullBronzeArmor = Advancement.Builder.create()
                .parent(obtainBronze)
                .display(display(
                        ModItems.BRONZE_CHESTPLATE,
                        "Hoplite",
                        "Craft a full set of bronze armor.",
                        AdvancementFrame.TASK,
                        6, 7
                ))
                .criterion("bronze_helmet", hasItem(ModItems.BRONZE_HELMET))
                .criterion("bronze_chestplate", hasItem(ModItems.BRONZE_CHESTPLATE))
                .criterion("bronze_leggings", hasItem(ModItems.BRONZE_LEGGINGS))
                .criterion("bronze_boots", hasItem(ModItems.BRONZE_BOOTS))
                .build(exporter, id("craft_full_bronze_armor"));

        // Rose Gold
        AdvancementEntry obtainRoseGold = Advancement.Builder.create()
                .parent(alloyFurnace)
                .display(display(
                        ModItems.ROSE_GOLD_INGOT,
                        "Ohh Prettyyyy",
                        "Obtain a rose gold ingot by alloying copper and gold.",
                        AdvancementFrame.TASK,
                        4, 6
                ))
                .criterion("has_rose_gold", hasItem(ModItems.ROSE_GOLD_INGOT))
                .build(exporter, id("obtain_rose_gold_ingot"));
        AdvancementEntry fullRoseGoldArmor = Advancement.Builder.create()
                .parent(obtainRoseGold)
                .display(display(
                        ModItems.ROSE_GOLD_CHESTPLATE,
                        "Piggies love me",
                        "Craft a full set of rose gold armor.",
                        AdvancementFrame.TASK,
                        6, 7
                ))
                .criterion("rose_gold_helmet", hasItem(ModItems.ROSE_GOLD_HELMET))
                .criterion("rose_gold_chestplate", hasItem(ModItems.ROSE_GOLD_CHESTPLATE))
                .criterion("rose_gold_leggings", hasItem(ModItems.ROSE_GOLD_LEGGINGS))
                .criterion("rose_gold_boots", hasItem(ModItems.ROSE_GOLD_BOOTS))
                .build(exporter, id("full_rose_gold_armor"));


        // Steel
        AdvancementEntry hephaestus = Advancement.Builder.create()
                .parent(alloyFurnace)
                .display(display(
                        ModItems.CARBON_STEEL_INGOT,
                        "Hephaestus",
                        "Obtain a carbon steel ingot.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_carbon_steel", hasItem(ModItems.CARBON_STEEL_INGOT))
                .build(exporter, id("hephaestus"));

        AdvancementEntry hotHotHot = Advancement.Builder.create()
                .parent(hephaestus)
                .display(display(
                        ModItems.HOT_CARBON_STEEL_SCRAP,
                        "Hot, Hot, Hot!",
                        "Smelt a carbon steel ingot.",
                        AdvancementFrame.TASK,
                        6, 9
                ))
                .criterion("has_hot_carbon_steel", hasItem(ModItems.HOT_CARBON_STEEL_SCRAP))
                .build(exporter, id("hot_hot_hot"));

        AdvancementEntry iAmIronMan = Advancement.Builder.create()
                .parent(hotHotHot)
                .display(display(
                        ModItems.HARDENED_STEEL_INGOT,
                        "I Am Iron Man",
                        "Create hardened steel.",
                        AdvancementFrame.TASK,
                        8, 9
                ))
                .criterion("has_hardened_steel", hasItem(ModItems.HARDENED_STEEL_INGOT))
                .build(exporter, id("i_am_iron_man"));

        AdvancementEntry fullHardenedSteelArmor = Advancement.Builder.create()
                .parent(iAmIronMan)
                .display(display(
                        ModItems.HARDENED_STEEL_CHESTPLATE,
                        "Man of Steel",
                        "Craft a full set of hardened steel armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("hardened_steel_helmet", hasItem(ModItems.HARDENED_STEEL_HELMET))
                .criterion("hardened_steel_chestplate", hasItem(ModItems.HARDENED_STEEL_CHESTPLATE))
                .criterion("hardened_steel_leggings", hasItem(ModItems.HARDENED_STEEL_LEGGINGS))
                .criterion("hardened_steel_boots", hasItem(ModItems.HARDENED_STEEL_BOOTS))
                .build(exporter, id("full_hardened_steel_armor"));

        AdvancementEntry hardenedSteelGolem = Advancement.Builder.create()
                .parent(iAmIronMan)
                .display(display(
                        ModBlocks.HARDENED_STEEL_BLOCK.asItem(),
                        "Hired Brother",
                        "Build a Hardened Steel Golem.",
                        AdvancementFrame.GOAL, // GOAL or CHALLENGE both fit
                        2, 10 // pick a lane so it doesn't clutter root
                ))
                .criterion("summon_hardened_steel_golem", summonEntity(ModEntities.HARDENED_STEEL_GOLEM))
                .build(exporter, id("summon_hardened_steel_golem"));


//
//        AdvancementEntry gravelLucky = Advancement.Builder.create()
//                .parent(root) // or parent to your “gravel ores” hub
//                .display(display(
//                        Items.FLINT,
//                        "Gravel Jackpot",
//                        "Get flint and a gem from mOres gravel ores.",
//                        AdvancementFrame.GOAL,
//                        9, 4
//                ))
//                .criterion("has_flint", hasItem(Items.FLINT))
//                .criterion("has_any_gem", hasAnyItem(
//                        ModItems.TOPAZ,
//                        ModItems.TOURMALINE,
//                        ModItems.TANZANITE,
//                        ModItems.RUBY,
//                        ModItems.SAPPHIRE,
//                        ModItems.SPINEL,
//                        ModItems.MOISSANITE
//                ))
//                .build(exporter, id("gravel_jackpot"));


        // -------------------------
        // Misc
        // -------------------------
//        AdvancementEntry killDuck = Advancement.Builder.create()
//                .parent(root)
//                .display(display(
//                        ModItems.DUCK_EGG,
//                        "You Animal",
//                        "Kill a duck.",
//                        AdvancementFrame.TASK,
//                        7, 4
//                ))
//                .criterion("kill_duck", killEntity(ModEntities.DUCK))
//                .build(exporter, id("kill_duck"));
        AdvancementEntry eatRawDuck = Advancement.Builder.create()
                .parent(root)
                .display(display(
                        ModItems.RAW_DUCK,
                        "You Savage",
                        "Eat a raw duck.",
                        AdvancementFrame.TASK,
                        7, 4
                ))
                .criterion("eat_raw_duck", eatItem(ModItems.RAW_DUCK))
                .build(exporter, id("eat_raw_duck"));
        AdvancementEntry eatCookedDuck = Advancement.Builder.create()
                .parent(eatRawDuck)
                .display(display(
                        ModItems.COOKED_DUCK,
                        "Mmm tasty (but still wrong)",
                        "Eat a cooked duck.",
                        AdvancementFrame.TASK,
                        7, 4
                ))
                .criterion("eat_cooked_duck", eatItem(ModItems.COOKED_DUCK))
                .build(exporter, id("eat_cooked_duck"));

        AdvancementEntry where = Advancement.Builder.create()
                .parent(root)
                .display(display(
                        Items.BEDROCK,
                        "Where?!",
                        "Find the absolute bottom of the world.",
                        AdvancementFrame.CHALLENGE,
                        0, 8
                ))
                .criterion("at_bottom_y", TickCriterion.Conditions.createLocation(
                        LocationPredicate.Builder.create()
                                .y(NumberRange.DoubleRange.exactly(-63.0))
                ))
                .build(exporter, id("where"));
    }

    // -------- helpers --------
    private static String id(String path) {
        return Mores.MOD_ID + ":" + path;
    }

    private static AdvancementCriterion<?> hasItem(ItemConvertible item) {
        return Criteria.INVENTORY_CHANGED.create(InventoryChangedCriterion.Conditions.items(item).conditions());
    }
    private static AdvancementCriterion<?> hasAnyItem(ItemConvertible... items) {
        return InventoryChangedCriterion.Conditions.items(items);
    }
    private static AdvancementCriterion<?> eatItem(ItemConvertible item) {
        return Criteria.CONSUME_ITEM.create(ConsumeItemCriterion.Conditions.item(item).conditions());
    }
    private static AdvancementCriterion<?> killEntity(EntityType<?> type) {
        return OnKilledCriterion.Conditions.createPlayerKilledEntity(EntityPredicate.Builder.create().type(type));
    }
    private static AdvancementCriterion<?> summonEntity(EntityType<?> type) {
        return SummonedEntityCriterion.Conditions.create(EntityPredicate.Builder.create().type(type)
        );
    }

    private static AdvancementDisplay display(
            ItemConvertible icon,
            String title,
            String description,
            AdvancementFrame frame,
            float x, float y
    ) {
        AdvancementDisplay d = new AdvancementDisplay(
                new ItemStack(icon),
                Text.literal(title),
                Text.literal(description),
                Optional.empty(),
                frame,
                true,
                true,
                false
        );
        d.setPos(x, y); // <-- THIS is the correct method in mappings
        return d;
    }

    private static AdvancementDisplay displayWithBackground(
            ItemConvertible icon,
            String title,
            String description,
            Identifier background,
            AdvancementFrame frame,
            float x, float y
    ) {
        AdvancementDisplay d = new AdvancementDisplay(
                new ItemStack(icon),
                Text.literal(title),
                Text.literal(description),
                Optional.of(background),
                frame,
                true,
                true,
                false
        );
        d.setPos(x, y);
        return d;
    }
}
