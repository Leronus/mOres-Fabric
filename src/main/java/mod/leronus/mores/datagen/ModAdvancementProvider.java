package mod.leronus.mores.datagen;

import mod.leronus.mores.Mores;
import mod.leronus.mores.block.ModBlocks;
import mod.leronus.mores.entity.ModEntities;
import mod.leronus.mores.item.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;

import net.minecraft.advancement.criterion.*;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
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
                        "Eat a silver apple.",
                        AdvancementFrame.TASK,
                        7, 4
                ))
                .criterion("has_silver_apple", eatItem(ModItems.SILVER_APPLE))
                .build(exporter, id("eat_silver_apple"));
        AdvancementEntry obtainSilverNugget = Advancement.Builder.create()
                .parent(obtainSilver)
                .display(display(
                        ModItems.SILVER_NUGGET,
                        "McNugget",
                        "Obtain a silver nugget.",
                        AdvancementFrame.TASK,
                        7, 4
                ))
                .criterion("has_silver_nugget", hasItem(ModItems.SILVER_NUGGET))
                .build(exporter, id("obtain_silver_nugget"));

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
                .criterion("has_cobalt", hasItem(ModItems.COBALT_INGOT))
                .build(exporter, id("obtain_cobalt_ingot"));

        AdvancementEntry fullCobaltArmor = Advancement.Builder.create()
                .parent(obtainCobalt)
                .display(display(
                        ModItems.COBALT_CHESTPLATE,
                        "Built Different",
                        "Craft a full set of cobalt armor.",
                        AdvancementFrame.TASK,
                        5, 9
                ))
                .criterion("cobalt_helmet", hasItem(ModItems.COBALT_HELMET))
                .criterion("cobalt_chestplate", hasItem(ModItems.COBALT_CHESTPLATE))
                .criterion("cobalt_leggings", hasItem(ModItems.COBALT_LEGGINGS))
                .criterion("cobalt_boots", hasItem(ModItems.COBALT_BOOTS))
                .build(exporter, id("full_cobalt_armor"));

        // -------------------------
        // DUST/GEM BRANCH
        // -------------------------
        // Turquoise
        AdvancementEntry obtainTurquoise = Advancement.Builder.create()
                .parent(obtainCobalt)
                .display(display(
                        ModItems.TURQUOISE_GEM,
                        "Aqua Coin",
                        "Obtain a turquoise gem.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_turquoise_gem", hasItem(ModItems.TURQUOISE_GEM))
                .build(exporter, id("obtain_turquoise_gem"));
        AdvancementEntry fullTurquoiseArmor = Advancement.Builder.create()
                .parent(obtainTurquoise)
                .display(display(
                        ModItems.TURQUOISE_HELMET,
                        "Submarine Poseidon",
                        "Craft a full set of turquoise armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("turquoise_helmet", hasItem(ModItems.TURQUOISE_HELMET))
                .criterion("turquoise_chestplate", hasItem(ModItems.TURQUOISE_CHESTPLATE))
                .criterion("turquoise_leggings", hasItem(ModItems.TURQUOISE_LEGGINGS))
                .criterion("turquoise_boots", hasItem(ModItems.TURQUOISE_BOOTS))
                .build(exporter, id("full_turquoise_armor"));

        // LapisLazuli
        AdvancementEntry obtainLapisLazuli = Advancement.Builder.create()
                .parent(obtainCobalt)
                .display(display(
                        ModItems.LAPIS_LAZULI_GEM,
                        "The Sea Calls To Me",
                        "Obtain a lapis lazuli gem.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_lapis_lazuli_gem", hasItem(ModItems.LAPIS_LAZULI_GEM))
                .build(exporter, id("obtain_lapis_lazuli_gem"));
        AdvancementEntry fullLapisLazuliArmor = Advancement.Builder.create()
                .parent(obtainLapisLazuli)
                .display(display(
                        ModItems.LAPIS_LAZULI_HELMET,
                        "OceanGate Titan",
                        "Craft a full set of lapis lazuli armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("lapis_lazuli_helmet", hasItem(ModItems.LAPIS_LAZULI_HELMET))
                .criterion("lapis_lazuli_chestplate", hasItem(ModItems.LAPIS_LAZULI_CHESTPLATE))
                .criterion("lapis_lazuli_leggings", hasItem(ModItems.LAPIS_LAZULI_LEGGINGS))
                .criterion("lapis_lazuli_boots", hasItem(ModItems.LAPIS_LAZULI_BOOTS))
                .build(exporter, id("full_lapis_lazuli_armor"));

        // Amethyst
        AdvancementEntry obtainAmethyst = Advancement.Builder.create()
                .parent(obtainCobalt)
                .display(display(
                        ModItems.AMETHYST_GEM,
                        "Awtysm",
                        "Obtain an amethyst gem.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_amethyst_gem", hasItem(ModItems.AMETHYST_GEM))
                .build(exporter, id("obtain_amethyst_gem"));
        AdvancementEntry fullAmethystArmor = Advancement.Builder.create()
                .parent(obtainAmethyst)
                .display(display(
                        ModItems.AMETHYST_HELMET,
                        "Soft Landing",
                        "Craft a full set of amethyst armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("amethyst_helmet", hasItem(ModItems.AMETHYST_HELMET))
                .criterion("amethyst_chestplate", hasItem(ModItems.AMETHYST_CHESTPLATE))
                .criterion("amethyst_leggings", hasItem(ModItems.AMETHYST_LEGGINGS))
                .criterion("amethyst_boots", hasItem(ModItems.AMETHYST_BOOTS))
                .build(exporter, id("full_amethyst_armor"));

        // -------------------------
        // CRYSTAL/ROCKY BRANCH
        // -------------------------
        // Citrine
        AdvancementEntry obtainCitrine = Advancement.Builder.create()
                .parent(obtainLapisLazuli)
                .display(display(
                        ModItems.CITRINE_GEM,
                        "Citroën",
                        "Obtain an citrine gem.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_citrine_gem", hasItem(ModItems.CITRINE_GEM))
                .build(exporter, id("obtain_citrine_gem"));
        AdvancementEntry fullCitrineArmor = Advancement.Builder.create()
                .parent(obtainCitrine)
                .display(display(
                        ModItems.CITRINE_CHESTPLATE,
                        "You're Reaching",
                        "Craft a full set of citrine armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("citrine_helmet", hasItem(ModItems.CITRINE_HELMET))
                .criterion("citrine_chestplate", hasItem(ModItems.CITRINE_CHESTPLATE))
                .criterion("citrine_leggings", hasItem(ModItems.CITRINE_LEGGINGS))
                .criterion("citrine_boots", hasItem(ModItems.CITRINE_BOOTS))
                .build(exporter, id("full_citrine_armor"));
        // Onyx
        AdvancementEntry obtainOnyx = Advancement.Builder.create()
                .parent(obtainLapisLazuli)
                .display(display(
                        ModItems.ONYX_GEM,
                        "Wither Currency",
                        "Obtain an onyx gem.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_onyx_gem", hasItem(ModItems.ONYX_GEM))
                .build(exporter, id("obtain_onyx_gem"));
        AdvancementEntry fullOnyxArmor = Advancement.Builder.create()
                .parent(obtainOnyx)
                .display(display(
                        ModItems.ONYX_CHESTPLATE,
                        "The Dark Knight",
                        "Craft a full set of onyx armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("onyx_helmet", hasItem(ModItems.ONYX_HELMET))
                .criterion("onyx_chestplate", hasItem(ModItems.ONYX_CHESTPLATE))
                .criterion("onyx_leggings", hasItem(ModItems.ONYX_LEGGINGS))
                .criterion("onyx_boots", hasItem(ModItems.ONYX_BOOTS))
                .build(exporter, id("full_onyx_armor"));

        // -------------------------
        // GEM BRANCH
        // -------------------------
        // Tanzanite
        AdvancementEntry obtainTanzanite = Advancement.Builder.create()
                .parent(obtainCitrine)
                .display(display(
                        ModItems.TANZANITE_GEM,
                        "",
                        "Obtain an tanzanite gem.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_tanzanite_gem", hasItem(ModItems.TANZANITE_GEM))
                .build(exporter, id("obtain_tanzanite_gem"));
        AdvancementEntry fullTanzaniteArmor = Advancement.Builder.create()
                .parent(obtainTanzanite)
                .display(display(
                        ModItems.TANZANITE_CHESTPLATE,
                        "The Flash",
                        "Craft a full set of tanzanite armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("tanzanite_helmet", hasItem(ModItems.TANZANITE_HELMET))
                .criterion("tanzanite_chestplate", hasItem(ModItems.TANZANITE_CHESTPLATE))
                .criterion("tanzanite_leggings", hasItem(ModItems.TANZANITE_LEGGINGS))
                .criterion("tanzanite_boots", hasItem(ModItems.TANZANITE_BOOTS))
                .build(exporter, id("full_tanzanite_armor"));
        // Topaz
        AdvancementEntry obtainTopaz = Advancement.Builder.create()
                .parent(obtainCitrine)
                .display(display(
                        ModItems.TOPAZ_GEM,
                        "Topazzler",
                        "Obtain an topaz gem.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_topaz_gem", hasItem(ModItems.TOPAZ_GEM))
                .build(exporter, id("obtain_topaz_gem"));
        AdvancementEntry fullTopazArmor = Advancement.Builder.create()
                .parent(obtainTopaz)
                .display(display(
                        ModItems.TOPAZ_CHESTPLATE,
                        "Efficiency 100",
                        "Craft a full set of topaz armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("topaz_helmet", hasItem(ModItems.TOPAZ_HELMET))
                .criterion("topaz_chestplate", hasItem(ModItems.TOPAZ_CHESTPLATE))
                .criterion("topaz_leggings", hasItem(ModItems.TOPAZ_LEGGINGS))
                .criterion("topaz_boots", hasItem(ModItems.TOPAZ_BOOTS))
                .build(exporter, id("full_topaz_armor"));
        // Tourmaline
        AdvancementEntry obtainTourmaline = Advancement.Builder.create()
                .parent(obtainCitrine)
                .display(display(
                        ModItems.TOURMALINE_GEM,
                        "Valentine",
                        "Obtain an tourmaline gem.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_tourmaline_gem", hasItem(ModItems.TOURMALINE_GEM))
                .build(exporter, id("obtain_tourmaline_gem"));
        AdvancementEntry fullTourmalineArmor = Advancement.Builder.create()
                .parent(obtainTourmaline)
                .display(display(
                        ModItems.TOURMALINE_CHESTPLATE,
                        "Yes, I'm a SIMP - Sniper Monkey",
                        "Craft a full set of tourmaline armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("tourmaline_helmet", hasItem(ModItems.TOURMALINE_HELMET))
                .criterion("tourmaline_chestplate", hasItem(ModItems.TOURMALINE_CHESTPLATE))
                .criterion("tourmaline_leggings", hasItem(ModItems.TOURMALINE_LEGGINGS))
                .criterion("tourmaline_boots", hasItem(ModItems.TOURMALINE_BOOTS))
                .build(exporter, id("full_tourmaline_armor"));

        // Spinel
        AdvancementEntry obtainSpinel = Advancement.Builder.create()
                .parent(obtainTourmaline)
                .display(display(
                        ModItems.SPINEL_GEM,
                        "Love",
                        "Obtain an spinel gem.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_spinel_gem", hasItem(ModItems.SPINEL_GEM))
                .build(exporter, id("obtain_spinel_gem"));
        AdvancementEntry fullSpinelArmor = Advancement.Builder.create()
                .parent(obtainSpinel)
                .display(display(
                        ModItems.SPINEL_CHESTPLATE,
                        "Healthy",
                        "Craft a full set of spinel armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("spinel_helmet", hasItem(ModItems.SPINEL_HELMET))
                .criterion("spinel_chestplate", hasItem(ModItems.SPINEL_CHESTPLATE))
                .criterion("spinel_leggings", hasItem(ModItems.SPINEL_LEGGINGS))
                .criterion("spinel_boots", hasItem(ModItems.SPINEL_BOOTS))
                .build(exporter, id("full_spinel_armor"));

        // Emerald
//        AdvancementEntry fullEmeraldArmor = Advancement.Builder.create()
//                .parent(root)
//                .display(display(
//                        ModItems.EMERALD_CHESTPLATE,
//                        "Healthy",
//                        "Craft a full set of emerald armor.",
//                        AdvancementFrame.TASK,
//                        10, 9
//                ))
//                .criterion("emerald_helmet", hasItem(ModItems.EMERALD_HELMET))
//                .criterion("emerald_chestplate", hasItem(ModItems.EMERALD_CHESTPLATE))
//                .criterion("emerald_leggings", hasItem(ModItems.EMERALD_LEGGINGS))
//                .criterion("emerald_boots", hasItem(ModItems.EMERALD_BOOTS))
//                .build(exporter, id("full_emerald_armor"));

        // Sapphire
        AdvancementEntry obtainSapphire = Advancement.Builder.create()
                .parent(obtainTourmaline)
                .display(display(
                        ModItems.SAPPHIRE_GEM,
                        "Latios",
                        "Obtain an sapphire gem.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_sapphire_gem", hasItem(ModItems.SAPPHIRE_GEM))
                .build(exporter, id("obtain_sapphire_gem"));
        AdvancementEntry fullSapphireArmor = Advancement.Builder.create()
                .parent(obtainSapphire)
                .display(display(
                        ModItems.SAPPHIRE_CHESTPLATE,
                        "I'm Blue",
                        "Craft a full set of sapphire armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("sapphire_helmet", hasItem(ModItems.SAPPHIRE_HELMET))
                .criterion("sapphire_chestplate", hasItem(ModItems.SAPPHIRE_CHESTPLATE))
                .criterion("sapphire_leggings", hasItem(ModItems.SAPPHIRE_LEGGINGS))
                .criterion("sapphire_boots", hasItem(ModItems.SAPPHIRE_BOOTS))
                .build(exporter, id("full_sapphire_armor"));

        // Ruby
        AdvancementEntry obtainRuby = Advancement.Builder.create()
                .parent(obtainTourmaline)
                .display(display(
                        ModItems.RUBY_GEM,
                        "Blood Diamond",
                        "Obtain an ruby gem.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_ruby_gem", hasItem(ModItems.RUBY_GEM))
                .build(exporter, id("obtain_ruby_gem"));
        AdvancementEntry fullRubyArmor = Advancement.Builder.create()
                .parent(obtainRuby)
                .display(display(
                        ModItems.RUBY_CHESTPLATE,
                        "Elmo",
                        "Craft a full set of ruby armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("ruby_helmet", hasItem(ModItems.RUBY_HELMET))
                .criterion("ruby_chestplate", hasItem(ModItems.RUBY_CHESTPLATE))
                .criterion("ruby_leggings", hasItem(ModItems.RUBY_LEGGINGS))
                .criterion("ruby_boots", hasItem(ModItems.RUBY_BOOTS))
                .build(exporter, id("full_ruby_armor"));

        // Moissanite
        AdvancementEntry obtainMoissanite = Advancement.Builder.create()
                .parent(obtainSapphire)
                .display(display(
                        ModItems.MOISSANITE_GEM,
                        "What are you doing in my Swamp?",
                        "Obtain an moissanite gem.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_moissanite_gem", hasItem(ModItems.MOISSANITE_GEM))
                .build(exporter, id("obtain_moissanite_gem"));
        AdvancementEntry fullMoissaniteArmor = Advancement.Builder.create()
                .parent(obtainMoissanite)
                .display(display(
                        ModItems.MOISSANITE_CHESTPLATE,
                        "Shrek the Ogre",
                        "Craft a full set of moissanite armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("moissanite_helmet", hasItem(ModItems.MOISSANITE_HELMET))
                .criterion("moissanite_chestplate", hasItem(ModItems.MOISSANITE_CHESTPLATE))
                .criterion("moissanite_leggings", hasItem(ModItems.MOISSANITE_LEGGINGS))
                .criterion("moissanite_boots", hasItem(ModItems.MOISSANITE_BOOTS))
                .build(exporter, id("full_moissanite_armor"));

        // Obsidian
        AdvancementEntry obtainObsidian = Advancement.Builder.create()
                .parent(obtainSapphire)
                .display(display(
                        ModItems.OBSIDIAN_INGOT,
                        "Lava Bucket Challenge",
                        "Obtain an obsidian ingot.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_obsidian_ingot", hasItem(ModItems.OBSIDIAN_INGOT))
                .build(exporter, id("obtain_obsidian_ingot"));
        AdvancementEntry fullObsidianArmor = Advancement.Builder.create()
                .parent(obtainObsidian)
                .display(display(
                        ModItems.OBSIDIAN_CHESTPLATE,
                        "Bombsquad",
                        "Craft a full set of obsidian armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("obsidian_helmet", hasItem(ModItems.OBSIDIAN_HELMET))
                .criterion("obsidian_chestplate", hasItem(ModItems.OBSIDIAN_CHESTPLATE))
                .criterion("obsidian_leggings", hasItem(ModItems.OBSIDIAN_LEGGINGS))
                .criterion("obsidian_boots", hasItem(ModItems.OBSIDIAN_BOOTS))
                .build(exporter, id("full_obsidian_armor"));

        // Enderite
        AdvancementEntry obtainEnderite = Advancement.Builder.create()
                .parent(obtainObsidian)
                .display(display(
                        ModBlocks.PRIMORDIAL_DEBRIS,
                        "Hidden in the Ends",
                        "Obtain Primordial Debris.",
                        AdvancementFrame.TASK,
                        4, 8
                ))
                .criterion("has_primordial_debris", hasItem(ModBlocks.PRIMORDIAL_DEBRIS))
                .build(exporter, id("obtain_primordial_debris"));
        AdvancementEntry fullEnderiteArmor = Advancement.Builder.create()
                .parent(obtainEnderite)
                .display(display(
                        ModItems.ENDERITE_CHESTPLATE,
                        "Indestructible",
                        "Craft a full set of enderite armor.",
                        AdvancementFrame.TASK,
                        10, 9
                ))
                .criterion("enderite_helmet", hasItem(ModItems.ENDERITE_HELMET))
                .criterion("enderite_chestplate", hasItem(ModItems.ENDERITE_CHESTPLATE))
                .criterion("enderite_leggings", hasItem(ModItems.ENDERITE_LEGGINGS))
                .criterion("enderite_boots", hasItem(ModItems.ENDERITE_BOOTS))
                .build(exporter, id("full_enderite_armor"));



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
        AdvancementEntry roseGoldApple = Advancement.Builder.create()
                .parent(obtainRoseGold)
                .display(display(
                        ModItems.ROSE_GOLD_APPLE,
                        "Pink snacc",
                        "Eat a rose gold apple.",
                        AdvancementFrame.TASK,
                        6, 6
                ))
                .criterion("eat_rose_gold_apple", eatItem(ModItems.ROSE_GOLD_APPLE))
                .build(exporter, id("eat_rose_gold_apple"));

        // Adamantium
        AdvancementEntry obtainAdamantium = Advancement.Builder.create()
                .parent(alloyFurnace)
                .display(display(
                        ModItems.ADAMANTIUM_INGOT,
                        "Adamantium",
                        "Obtain an adamantium ingot by alloying iron and diamond.",
                        AdvancementFrame.TASK,
                        4, 6
                ))
                .criterion("has_adamantium", hasItem(ModItems.ADAMANTIUM_INGOT))
                .build(exporter, id("obtain_adamantium_ingot"));
        AdvancementEntry fullAdamantiumArmor = Advancement.Builder.create()
                .parent(obtainAdamantium)
                .display(display(
                        ModItems.ADAMANTIUM_CHESTPLATE,
                        "Immovable Object",
                        "Craft a full set of adamantium armor.",
                        AdvancementFrame.TASK,
                        6, 7
                ))
                .criterion("adamantium_helmet", hasItem(ModItems.ADAMANTIUM_HELMET))
                .criterion("adamantium_chestplate", hasItem(ModItems.ADAMANTIUM_CHESTPLATE))
                .criterion("adamantium_leggings", hasItem(ModItems.ADAMANTIUM_LEGGINGS))
                .criterion("adamantium_boots", hasItem(ModItems.ADAMANTIUM_BOOTS))
                .build(exporter, id("full_adamantium_armor"));

        AdvancementEntry gravelLucky = Advancement.Builder.create()
                .parent(root) // or parent to your “gravel ores” hub
                .display(display(
                        Items.FLINT,
                        "Gravel Jackpot",
                        "Get flint and a gem from mOres gravel ores.",
                        AdvancementFrame.GOAL,
                        9, 4
                ))
                .criterion("gravel_jackpot", Criteria.IMPOSSIBLE.create(new ImpossibleCriterion.Conditions()))
                .build(exporter, id("gravel_jackpot"));


        // -------------------------
        // Misc
        // -------------------------
        AdvancementEntry killDuck = Advancement.Builder.create()
                .parent(root)
                .display(display(
                        ModItems.DUCK_EGG,
                        "You Animal",
                        "Kill a duck.",
                        AdvancementFrame.TASK,
                        7, 4
                ))
                .criterion("kill_duck", killEntity(ModEntities.DUCK))
                .build(exporter, id("kill_duck"));
        AdvancementEntry eatRawDuck = Advancement.Builder.create()
                .parent(killDuck)
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


        @SuppressWarnings("removal")
        AdvancementEntry waxOff = Advancement.Builder.create()
                .parent(Identifier.of("minecraft", "husbandry/wax_on")) // <-- vanilla location
                .display(new AdvancementDisplay(
                        new ItemStack(Items.STONE_AXE),
                        Text.translatable("advancements.husbandry.wax_off.title"),
                        Text.translatable("advancements.husbandry.wax_off.description"),
                        Optional.empty(),
                        AdvancementFrame.TASK,
                        true, true, false
                ))
                .criterion("wax_off", itemUsedOnBlock(
                        LocationPredicate.Builder.create().block(
                                BlockPredicate.Builder.create().blocks(
                                        Blocks.WAXED_COPPER_BLOCK,
                                        Blocks.WAXED_EXPOSED_COPPER,
                                        Blocks.WAXED_WEATHERED_COPPER,
                                        Blocks.WAXED_OXIDIZED_COPPER,

                                        Blocks.WAXED_CUT_COPPER,
                                        Blocks.WAXED_EXPOSED_CUT_COPPER,
                                        Blocks.WAXED_WEATHERED_CUT_COPPER,
                                        Blocks.WAXED_OXIDIZED_CUT_COPPER,

                                        Blocks.WAXED_CUT_COPPER_SLAB,
                                        Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB,
                                        Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB,
                                        Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB,

                                        Blocks.WAXED_CUT_COPPER_STAIRS,
                                        Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS,
                                        Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS,
                                        Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS,

                                        // 1.21+ extras (if present in your version)
                                        Blocks.WAXED_CHISELED_COPPER,
                                        Blocks.WAXED_EXPOSED_CHISELED_COPPER,
                                        Blocks.WAXED_WEATHERED_CHISELED_COPPER,
                                        Blocks.WAXED_OXIDIZED_CHISELED_COPPER,
                                        Blocks.WAXED_COPPER_DOOR,
                                        Blocks.WAXED_EXPOSED_COPPER_DOOR,
                                        Blocks.WAXED_WEATHERED_COPPER_DOOR,
                                        Blocks.WAXED_OXIDIZED_COPPER_DOOR,
                                        Blocks.WAXED_COPPER_TRAPDOOR,
                                        Blocks.WAXED_EXPOSED_COPPER_TRAPDOOR,
                                        Blocks.WAXED_WEATHERED_COPPER_TRAPDOOR,
                                        Blocks.WAXED_OXIDIZED_COPPER_TRAPDOOR,
                                        Blocks.WAXED_COPPER_GRATE,
                                        Blocks.WAXED_EXPOSED_COPPER_GRATE,
                                        Blocks.WAXED_WEATHERED_COPPER_GRATE,
                                        Blocks.WAXED_OXIDIZED_COPPER_GRATE,
                                        Blocks.WAXED_COPPER_BULB,
                                        Blocks.WAXED_EXPOSED_COPPER_BULB,
                                        Blocks.WAXED_WEATHERED_COPPER_BULB,
                                        Blocks.WAXED_OXIDIZED_COPPER_BULB
                                )
                        ),
                        ItemPredicate.Builder.create().tag(ItemTags.AXES) // your axes must be in this tag
                ))
                .build(exporter, mc("husbandry/wax_off"));


    }
    // -------- helpers --------
    private static String id(String path) {
        return Mores.MOD_ID + ":" + path;
    }
    private static String mc(String path) {return "minecraft:" + path;
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
    private static AdvancementCriterion<?> itemUsedOnBlock(
            net.minecraft.predicate.entity.LocationPredicate.Builder location,
            net.minecraft.predicate.item.ItemPredicate.Builder item
    ) {
        return net.minecraft.advancement.criterion.ItemCriterion.Conditions.createItemUsedOnBlock(location, item);
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
