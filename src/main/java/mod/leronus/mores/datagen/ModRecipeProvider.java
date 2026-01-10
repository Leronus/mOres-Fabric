package mod.leronus.mores.datagen;

import mod.leronus.mores.recipe.AlloyingRecipe;
import mod.leronus.mores.recipe.ShieldDecorationRecipe;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static mod.leronus.mores.item.ModItems.*;
import static net.minecraft.item.Items.*;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        //TODO Add tags for minecraft:egg (so mores:duck_egg and other eggs can be used for the carrot_pie & velvet)

        generateBlocks(exporter);
        generateShieldDecoration(exporter);
        generateFood(exporter);
        generateMiscellaneous(exporter);

        generateWood(exporter);
        generateStone(exporter);
        generateChainmail(exporter);
        generateTin(exporter);
        generateGold(exporter);
        generateSilver(exporter);
        generateCopper(exporter);
        generateSterlingSilver(exporter);
        generateRoseGold(exporter);
        generateBronze(exporter);
        generateIron(exporter);
        generateCobalt(exporter);
        generateCarbonSteel(exporter);
        generateHardenedSteel(exporter);
        generateTurquoise(exporter);
        generateLapisLazuli(exporter);
        generateAmethyst(exporter);
        generateTanzanite(exporter);
        generateTourmaline(exporter);
        generateTopaz(exporter);
        generateEmerald(exporter);
        generateDiamond(exporter);
        generateRuby(exporter);
        generateSapphire(exporter);
        generateSpinel(exporter);
        generateCitrine(exporter);
        generateMoissanite(exporter);
        generateOnyx(exporter);
        generateObsidian(exporter);
        generateNetherite(exporter);
        generateGraphene(exporter);
        generateAdamantium(exporter);
        generateEnderite(exporter);

        generateSmokingCooking(exporter);
        generateSmelting(exporter);
        generateBlasting(exporter);
        generateAlloying(exporter);
    }

    private void generateBlocks(RecipeExporter exporter) {
        //Alloy Furnace
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "alloy_furnace")), 1)
                .pattern("###")
                .pattern("#F#")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "tin_ingot")))
                .input('F', Registries.ITEM.get(Identifier.of("minecraft", "furnace")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tin_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tin_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "alloy_furnace"));
    }

    private void generateShieldDecoration(RecipeExporter exporter) {
        /* Shield Decoration */
        ComplexRecipeJsonBuilder.create(ShieldDecorationRecipe::new).offerTo(exporter, Identifier.of("mores", "shield_decoration"));

    }

    private void generateFood(RecipeExporter exporter) {
        /* Food */
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, Registries.ITEM.get(Identifier.of("mores", "carrot_pie")), 1)
                .input(Registries.ITEM.get(Identifier.of("minecraft", "carrot")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "wheat")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "egg")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "carrot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "carrot"))))
                .offerTo(exporter, Identifier.of("mores", "carrot_pie"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, Registries.ITEM.get(Identifier.of("mores", "chocolate")), 1)
                .input(Registries.ITEM.get(Identifier.of("minecraft", "cocoa_beans")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "cocoa_beans")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "milk_bucket")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "sugar")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "sugar")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "cocoa_beans"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "cocoa_beans"))))
                .offerTo(exporter, Identifier.of("mores", "chocolate"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, Registries.ITEM.get(Identifier.of("mores", "velvet")), 1)
                .input(Registries.ITEM.get(Identifier.of("minecraft", "egg")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "beetroot")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "wheat")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "sugar")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "egg"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "egg"))))
                .offerTo(exporter, Identifier.of("mores", "velvet"));
        //Apples
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, Registries.ITEM.get(Identifier.of("mores", "silver_apple")), 1)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .input('X', Registries.ITEM.get(Identifier.of("minecraft", "apple")))
                .criterion("has_ingot_silver", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver"))))
                .offerTo(exporter, Identifier.of("mores", "silver_apple"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, Registries.ITEM.get(Identifier.of("mores", "bronze_apple")), 1)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .input('X', Registries.ITEM.get(Identifier.of("minecraft", "apple")))
                .criterion("has_ingot_bronze", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_apple"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, Registries.ITEM.get(Identifier.of("mores", "cobalt_apple")), 1)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .input('X', Registries.ITEM.get(Identifier.of("minecraft", "apple")))
                .criterion("has_ingot_cobalt", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_apple"));


    }

    private void generateMiscellaneous(RecipeExporter exporter) {
        /* -- Miscellaneous -- */
        //Torch
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("minecraft", "torch")), 8)
                .pattern("#")
                .pattern("X")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "anthracite")))
                .input('X', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "anthracite"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "anthracite"))))
                .offerTo(exporter, Identifier.of("mores", "torch_from_anthracite"));
        //Flint and Steel
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("minecraft", "flint_and_steel")), 1)
                .input(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "flint")))
                .criterion("has_ingot_carbon_steel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel"))))
                .offerTo(exporter, Identifier.of("mores", "flint_and_carbon_steel"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("minecraft", "flint_and_steel")), 1)
                .input(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "flint")))
                .criterion("has_ingot_hardened_steel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel"))))
                .offerTo(exporter, Identifier.of("mores", "flint_and_hardened_steel"));
        //Saddle
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("minecraft", "saddle")), 1)
                .pattern(" L ")
                .pattern("LIL")
                .input('L', Registries.ITEM.get(Identifier.of("minecraft", "leather")))
                .input('I', Registries.ITEM.get(Identifier.of("minecraft", "iron_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "leather"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "leather"))))
                .offerTo(exporter, Identifier.of("mores", "saddle"));


    }

    private void generateWood(RecipeExporter exporter) {
        /* -- Wood -- */
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "wood_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "wood_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "wood_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "wood_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "wood_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "wood_dagger"));

    }

    private void generateStone(RecipeExporter exporter) {
        /* -- Stone -- */
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "stone_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "cobblestone")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "stone_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "stone_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "cobblestone")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "stone_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "stone_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "cobblestone")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "stone_dagger"));

    }

    private void generateChainmail(RecipeExporter exporter) {
        /* -- Chainmail -- */
        //Items
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "chainmail")), 2)
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "iron_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "iron_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "iron_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "chainmail"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("minecraft", "iron_ingot")), 2)
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "chainmail")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "chainmail"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "chainmail"))))
                .offerTo(exporter, Identifier.of("mores", "iron_ingot_from_chainmail"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("minecraft", "chainmail_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "chainmail")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "chainmail"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "chainmail"))))
                .offerTo(exporter, Identifier.of("mores", "chainmail_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("minecraft", "chainmail_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "chainmail")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "chainmail"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "chainmail"))))
                .offerTo(exporter, Identifier.of("mores", "chainmail_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("minecraft", "chainmail_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "chainmail")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "chainmail"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "chainmail"))))
                .offerTo(exporter, Identifier.of("mores", "chainmail_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("minecraft", "chainmail_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "chainmail")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "chainmail"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "chainmail"))))
                .offerTo(exporter, Identifier.of("mores", "chainmail_boots"));

    }

    private void generateTin(RecipeExporter exporter) {
        /* -- Tin -- */
        //Items & Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "tin_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "tin_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tin_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tin_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "tin_block_from_ingots"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_ingot")), 1)
                .group("tin_ingot")
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "tin_nugget")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tin_nugget"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tin_nugget"))))
                .offerTo(exporter, Identifier.of("mores", "tin_ingot_from_nuggets"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_ingot")), 9)
                .group("tin_ingot")
                .input(Registries.ITEM.get(Identifier.of("mores", "tin_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tin_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tin_block"))))
                .offerTo(exporter, Identifier.of("mores", "tin_ingot_from_tin_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "raw_tin_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "raw_tin")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_tin"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_tin"))))
                .offerTo(exporter, Identifier.of("mores", "raw_tin_block"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "raw_tin")), 9)
                .group("raw_tin")
                .input(Registries.ITEM.get(Identifier.of("mores", "raw_tin_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_tin_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_tin_block"))))
                .offerTo(exporter, Identifier.of("mores", "raw_tin_from_raw_tin_block"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_nugget")), 9)
                .input(Registries.ITEM.get(Identifier.of("mores", "tin_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tin_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tin_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "tin_nuggets_from_ingot"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tin_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tin_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "tin_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tin_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "tin_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tin_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "tin_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tin_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "tin_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tin_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tin_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tin_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tin_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tin_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tin_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tin_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tin_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "tin_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tin_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion("has_ingot_tin", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin"))))
                .offerTo(exporter, Identifier.of("mores", "tin_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tin_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion("has_ingot_tin", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin"))))
                .offerTo(exporter, Identifier.of("mores", "tin_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tin_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion("has_ingot_tin", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin"))))
                .offerTo(exporter, Identifier.of("mores", "tin_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tin_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion("has_ingot_tin", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin"))))
                .offerTo(exporter, Identifier.of("mores", "tin_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tin_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "tin_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "tin_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tin_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tin_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "tin_horse_armor"));


    }

    private void generateGold(RecipeExporter exporter) {
        /* -- Gold -- */
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "gold_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "gold_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "gold_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "gold_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "gold_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "gold_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "gold_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "gold_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "gold_dagger"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("minecraft", "golden_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("minecraft", "golden_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("minecraft", "golden_leggings")))
                .input('G', Registries.ITEM.get(Identifier.of("minecraft", "gold_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "golden_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "golden_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "gold_horse_armor"));

    }

    private void generateSilver(RecipeExporter exporter) {
        /* -- Silver -- */
        //Items & Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_ingot")), 1)
                .group("silver_ingot")
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "silver_nugget")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "silver_nugget"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "silver_nugget"))))
                .offerTo(exporter, Identifier.of("mores", "silver_ingot_from_nuggets"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_ingot")), 9)
                .group("silver_ingot")
                .input(Registries.ITEM.get(Identifier.of("mores", "silver_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "silver_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "silver_block"))))
                .offerTo(exporter, Identifier.of("mores", "silver_ingot_from_silver_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "silver_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "silver_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "silver_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "silver_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "silver_block_from_ingots"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_nugget")), 9)
                .input(Registries.ITEM.get(Identifier.of("mores", "silver_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "silver_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "silver_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "silver_nuggets_from_ingots"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "raw_silver_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "raw_silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_silver"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_silver"))))
                .offerTo(exporter, Identifier.of("mores", "raw_silver_block"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "raw_silver")), 9)
                .group("raw_silver")
                .input(Registries.ITEM.get(Identifier.of("mores", "raw_silver_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_silver_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_silver_block"))))
                .offerTo(exporter, Identifier.of("mores", "raw_silver_from_raw_silver_block"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "silver_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "silver_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "silver_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "silver_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "silver_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "silver_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "silver_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "silver_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "silver_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "silver_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "silver_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "silver_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "silver_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "silver_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "silver_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "silver_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "silver_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "silver_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "silver_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion("has_ingot_silver", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver"))))
                .offerTo(exporter, Identifier.of("mores", "silver_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "silver_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion("has_ingot_silver", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver"))))
                .offerTo(exporter, Identifier.of("mores", "silver_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "silver_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion("has_ingot_silver", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver"))))
                .offerTo(exporter, Identifier.of("mores", "silver_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "silver_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion("has_ingot_silver", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver"))))
                .offerTo(exporter, Identifier.of("mores", "silver_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "silver_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "silver_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "silver_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "silver_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "silver_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "silver_horse_armor"));


    }

    private void generateCopper(RecipeExporter exporter) {
        /* -- Will be partially vanilla in 1.21.9 -- */
        //Items & Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")), 1)
                .group("copper_ingot")
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "copper_nugget")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "copper_nugget"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "copper_nugget"))))
                .offerTo(exporter, Identifier.of("mores", "copper_ingot_from_nuggets"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "copper_nugget")), 9)
                .input(Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "copper_nuggets_from_ingot"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "copper_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "copper_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "copper_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "copper_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "copper_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "copper_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "copper_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "copper_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "copper_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "copper_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "copper_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "copper_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "copper_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "copper_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "copper_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "copper_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "copper_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "copper_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "copper_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "copper_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "copper_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "copper_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "copper_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "copper_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "copper_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "copper_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "copper_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "copper_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "copper_leggings")))
                .input('G', Registries.ITEM.get(Identifier.of("minecraft", "copper_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "copper_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "copper_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "copper_horse_armor"));

    }

    private void generateSterlingSilver(RecipeExporter exporter) {
        /* -- Sterling Silver -- */
        //Blocks & Items
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "sterling_silver_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_block_from_ingot"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_ingot")), 1)
                .group("sterling_silver_ingot")
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "sterling_silver_nugget")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_nugget"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_nugget"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_ingot_from_nuggets"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_ingot")), 9)
                .group("sterling_silver_ingot")
                .input(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_block"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_ingot_from_sterling_silver_block"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_nugget")), 9)
                .input(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_nuggets_from_ingot"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion("has_ingot_sterling_silver", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion("has_ingot_sterling_silver", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion("has_ingot_sterling_silver", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion("has_ingot_sterling_silver", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "sterling_silver_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "sterling_silver_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_horse_armor"));


    }

    private void generateRoseGold(RecipeExporter exporter) {
        /* -- Rose Gold -- */
        //Blocks & Items
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "rose_gold_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "rose_gold_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_block_from_ingots"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "rose_gold_ingot")), 1)
                .group("rose_gold_ingot")
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "rose_gold_nugget")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_nugget"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_nugget"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_ingot_from_nuggets"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "rose_gold_ingot")), 9)
                .group("rose_gold_ingot")
                .input(Registries.ITEM.get(Identifier.of("mores", "rose_gold_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_block"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_ingot_from_rose_gold_block"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "rose_gold_nugget")), 9)
                .input(Registries.ITEM.get(Identifier.of("mores", "rose_gold_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_nuggets_from_ingot"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "rose_gold_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "rose_gold_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "rose_gold_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "rose_gold_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "rose_gold_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "rose_gold_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "rose_gold_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "rose_gold_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "rose_gold_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "rose_gold_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion("has_ingot_rose_gold", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "rose_gold_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion("has_ingot_rose_gold", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "rose_gold_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion("has_ingot_rose_gold", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "rose_gold_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion("has_ingot_rose_gold", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "rose_gold_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "rose_gold_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "rose_gold_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/rose_gold")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_horse_armor"));


    }

    private void generateBronze(RecipeExporter exporter) {
        /* -- Bronze -- */
        //Items & Blocks
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "bronze_ingot")), 9)
                .group("bronze_ingot")
                .input(Registries.ITEM.get(Identifier.of("mores", "bronze_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "bronze_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "bronze_block"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_ingot_from_bronze_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "bronze_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "bronze_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "bronze_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "bronze_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_block_from_ingots"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "bronze_ingot")), 1)
                .group("bronze_ingot")
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "bronze_nugget")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "bronze_nugget"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "bronze_nugget"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_ingot_from_nuggets"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "bronze_nugget")), 9)
                .input(Registries.ITEM.get(Identifier.of("mores", "bronze_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "bronze_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "bronze_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_nuggets_from_ingot"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "bronze_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "bronze_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "bronze_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "bronze_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "bronze_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "bronze_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "bronze_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "bronze_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_dagger"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "bronze_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "bronze_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion("has_ingot_bronze", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "bronze_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion("has_ingot_bronze", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "bronze_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion("has_ingot_bronze", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "bronze_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion("has_ingot_bronze", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "bronze_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "bronze_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "bronze_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "bronze_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "bronze_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "bronze_horse_armor"));


    }

    private void generateIron(RecipeExporter exporter) {
        /* -- Iron -- */
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "iron_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "iron_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "iron_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "iron_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "iron_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "iron_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "iron_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "iron_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "iron_dagger"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("minecraft", "iron_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("minecraft", "iron_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("minecraft", "iron_leggings")))
                .input('G', Registries.ITEM.get(Identifier.of("minecraft", "iron_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "iron_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "iron_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "iron_horse_armor"));


    }

    private void generateCobalt(RecipeExporter exporter) {
        /* -- Cobalt -- */
        //Blocks & Items
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_ingot")), 9)
                .group("cobalt_ingot")
                .input(Registries.ITEM.get(Identifier.of("mores", "cobalt_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_block"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_ingots_from_cobalt_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "cobalt_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "cobalt_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_ingot")), 1)
                .group("cobalt_ingot")
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "cobalt_nugget")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_nugget"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_nugget"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_ingot_from_nuggets"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_nugget")), 9)
                .input(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion("has_ingot_cobalt", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_nuggets_from_ingot"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "raw_cobalt_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "raw_cobalt")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt"))))
                .offerTo(exporter, Identifier.of("mores", "raw_cobalt_block_from_raw_cobalt"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "raw_cobalt")), 9)
                .group("raw_cobalt")
                .input(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt_block"))))
                .offerTo(exporter, Identifier.of("mores", "raw_cobalt_from_raw_cobalt_block"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "cobalt_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "cobalt_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "cobalt_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "cobalt_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "cobalt_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "cobalt_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "cobalt_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "cobalt_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "cobalt_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion("has_ingot_cobalt", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "cobalt_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion("has_ingot_cobalt", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "cobalt_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion("has_ingot_cobalt", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "cobalt_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion("has_ingot_cobalt", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_boots"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "cobalt_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_shovel"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "cobalt_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "cobalt_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "cobalt_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_horse_armor"));


    }

    private void generateCarbonSteel(RecipeExporter exporter) {
        /* Carbon Steel */
        //Items & Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_ingot")), 1)
                .group("carbon_steel_ingot")
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "carbon_steel_nugget")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_nugget"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_nugget"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_ingot_from_nuggets"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_ingot")), 9)
                .group("carbon_steel_ingot")
                .input(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_block"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_ingot_from_carbon_steel_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion("has_ingot_carbon_steel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_block_from_ingots"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_nugget")), 9)
                .input(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_nuggets_from_ingot"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion("has_ingot_carbon_steel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion("has_ingot_carbon_steel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion("has_ingot_carbon_steel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion("has_ingot_carbon_steel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "carbon_steel_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "carbon_steel_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/carbon_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_horse_armor"));

    }

    private void generateHardenedSteel(RecipeExporter exporter) {
        /* -- Hardened Steel */
        //Items & Blocks
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_ingot")), 1)
                .input(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_scrap")))
                .input(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_ingot")))
                .input(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_ingot")))
                .input(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_scrap")))
                .input(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_scrap")))
                .input(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_ingot")))
                .input(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_scrap")))
                .input(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_scrap"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_scrap"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_ingot"));
        //TODO Check if correct
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_upgrade_smithing_template")), 7)
                .pattern("#S#")
                .pattern("#C#")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .input('C', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "stone_crafting_materials")))
                .input('S', Registries.ITEM.get(Identifier.of("mores", "hardened_steel_upgrade_smithing_template")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "iron_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "iron_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_upgrade_smithing_template"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_ingot")), 9)
                .group("hardened_steel_ingot")
                .input(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_block"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_ingot_from_hardened_steel_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion("has_ingot_hardened_steel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_block_from_ingots"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_nugget")), 9)
                .input(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_nuggets_from_ingot"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion("has_ingot_hardened_steel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion("has_ingot_hardened_steel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion("has_ingot_hardened_steel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion("has_ingot_hardened_steel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "hardened_steel_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "hardened_steel_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/hardened_steel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_horse_armor"));


    }

    private void generateTurquoise(RecipeExporter exporter) {
        /* -- Turquoise -- */
        //Blocks & Items
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "turquoise_gem")), 1)
                .pattern("#Q")
                .pattern("Q#")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "dust/turquoise")))
                .input('Q', Registries.ITEM.get(Identifier.of("minecraft", "quartz")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "turquoise_dust"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "turquoise_gem"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_gem_from_dust"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "turquoise_gem")), 9)
                .group("turquoise_gem")
                .input(Registries.ITEM.get(Identifier.of("mores", "turquoise_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "turquoise_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "turquoise_block"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_gem_from_turquoise_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "turquoise_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "turquoise_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "turquoise_gem"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_block"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "turquoise_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "turquoise_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "turquoise_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "turquoise_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "turquoise_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "turquoise_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "turquoise_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "turquoise_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "turquoise_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "turquoise_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion("has_gem_turquoise", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "turquoise_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion("has_gem_turquoise", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "turquoise_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion("has_gem_turquoise", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "turquoise_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion("has_gem_turquoise", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "turquoise_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "turquoise_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "turquoise_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "turquoise_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "turquoise_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_horse_armor"));
    }

    private void generateLapisLazuli(RecipeExporter exporter) {
        /* -- Lapis Lazuli -- */
        //Blocks & Items
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_gem")), 1)
                .pattern("#Q")
                .pattern("Q#")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "dust/lapis_lazuli")))
                .input('Q', Registries.ITEM.get(Identifier.of("minecraft", "quartz")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_dust"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_gem"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_gem_from_dust"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion("has_gem_lapis_lazuli", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion("has_gem_lapis_lazuli", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion("has_gem_lapis_lazuli", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion("has_gem_lapis_lazuli", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/lapis_lazuli")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "lapis_lazuli_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "lapis_lazuli_horse_armor"));
    }
    private void generateAmethyst(RecipeExporter exporter) {
        /* Amethyst */
        //Blocks & Items
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")), 1)
                .pattern("#Q")
                .pattern("Q#")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "dust/amethyst")))
                .input('Q', Registries.ITEM.get(Identifier.of("minecraft", "quartz")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_dust"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_gem"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_gem_from_dust"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "amethyst_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_gem"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_block"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "amethyst_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "amethyst_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "amethyst_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "amethyst_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_shovel"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "amethyst_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_hoe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "amethyst_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "amethyst_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "amethyst_dagger")), 1)
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "amethyst_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "amethyst_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_gem"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "amethyst_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_gem"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "amethyst_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_gem"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "amethyst_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_gem"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "amethyst_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "amethyst_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "amethyst_leggings")))
                .input('G', Registries.ITEM.get(Identifier.of("mores", "amethyst_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "amethyst_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "amethyst_horse_armor"));


    }

    private void generateTourmaline(RecipeExporter exporter) {
        /* -- Tourmaline -- */
        //Items & Blocks
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tourmaline_gem")), 9)
                .group("tourmaline_gem")
                .input(Registries.ITEM.get(Identifier.of("mores", "tourmaline_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tourmaline_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tourmaline_block"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_gem_from_tourmaline_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "tourmaline_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "tourmaline_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tourmaline_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tourmaline_gem"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_block"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tourmaline_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tourmaline_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tourmaline_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_dagger"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tourmaline_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "tourmaline_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "tourmaline_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "tourmaline_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "tourmaline_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_hoe"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tourmaline_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tourmaline_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion("has_gem_tourmaline", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tourmaline_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion("has_gem_tourmaline", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tourmaline_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion("has_gem_tourmaline", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tourmaline_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion("has_gem_tourmaline", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tourmaline_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "tourmaline_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "tourmaline_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tourmaline_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tourmaline_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_horse_armor"));
    }

    private void generateTanzanite(RecipeExporter exporter) {
        /* -- Tanzanite -- */
        //Items & Blocks
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tanzanite_gem")), 9)
                .group("tanzanite_gem")
                .input(Registries.ITEM.get(Identifier.of("mores", "tanzanite_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tanzanite_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tanzanite_block"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_gem_from_tanzanite_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "tanzanite_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "tanzanite_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tanzanite_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tanzanite_gem"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_block"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tanzanite_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tanzanite_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tanzanite_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_dagger"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tanzanite_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "tanzanite_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "tanzanite_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "tanzanite_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "tanzanite_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_hoe"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tanzanite_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tanzanite_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion("has_gem_tanzanite", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tanzanite_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion("has_gem_tanzanite", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tanzanite_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion("has_gem_tanzanite", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tanzanite_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion("has_gem_tanzanite", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "tanzanite_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "tanzanite_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "tanzanite_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tanzanite_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tanzanite_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_horse_armor"));
    }

    private void generateTopaz(RecipeExporter exporter) {
        /* -- Topaz -- */
        //Items & Blocks
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "topaz_gem")), 9)
                .group("topaz_gem")
                .input(Registries.ITEM.get(Identifier.of("mores", "topaz_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "topaz_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "topaz_block"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_gem_from_topaz_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "topaz_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "topaz_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "topaz_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "topaz_gem"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_block"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "topaz_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "topaz_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "topaz_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "topaz_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "topaz_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "topaz_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "topaz_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "topaz_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "topaz_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "topaz_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion("has_gem_topaz", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "topaz_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion("has_gem_topaz", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "topaz_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion("has_gem_topaz", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_boots"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "topaz_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion("has_gem_topaz", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_leggings"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "topaz_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "topaz_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "topaz_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "topaz_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "topaz_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_horse_armor"));


    }

    private void generateEmerald(RecipeExporter exporter) {
        /* -- Emerald -- */
        //Items & Blocks
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "emerald_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "emerald_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "emerald_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "emerald_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "emerald_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "emerald_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "emerald_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "emerald_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "emerald_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "emerald_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "emerald"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "emerald"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "emerald_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "emerald"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "emerald"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "emerald_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "emerald"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "emerald"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "emerald_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "emerald"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "emerald"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "emerald_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "emerald_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "emerald_leggings")))
                .input('G', Registries.ITEM.get(Identifier.of("minecraft", "emerald")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "emerald_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "emerald_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "emerald_horse_armor"));


    }

    private void generateDiamond(RecipeExporter exporter) {
        /* -- Diamond -- */
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "diamond")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "diamond_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "diamond")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "diamond_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "diamond_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', Registries.ITEM.get(Identifier.of("minecraft", "diamond")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "diamond_dagger"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("minecraft", "diamond_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("minecraft", "diamond_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("minecraft", "diamond_leggings")))
                .input('G', Registries.ITEM.get(Identifier.of("minecraft", "diamond")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "diamond_horse_armor"));


    }

    private void generateRuby(RecipeExporter exporter) {
        /* -- Ruby -- */
        //Items & Blocks
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "ruby_gem")), 9)
                .group("ruby_gem")
                .input(Registries.ITEM.get(Identifier.of("mores", "ruby_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "ruby_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "ruby_block"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_gem_from_ruby_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "ruby_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "ruby_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "ruby_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "ruby_gem"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_block"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "ruby_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "ruby_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "ruby_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "ruby_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "ruby_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "ruby_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "ruby_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "ruby_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "ruby_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "ruby_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion("has_gem_ruby", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "ruby_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion("has_gem_ruby", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "ruby_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion("has_gem_ruby", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "ruby_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion("has_gem_ruby", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "ruby_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "ruby_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "ruby_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "ruby_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "ruby_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_horse_armor"));


    }

    private void generateSapphire(RecipeExporter exporter) {
        /* -- Sapphire -- */
        //Items & Blocks
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sapphire_gem")), 9)
                .group("sapphire_gem")
                .input(Registries.ITEM.get(Identifier.of("mores", "sapphire_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "sapphire_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "sapphire_block"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_gem_from_sapphire_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "sapphire_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "sapphire_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "sapphire_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "sapphire_gem"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_block"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sapphire_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "sapphire_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "sapphire_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "sapphire_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "sapphire_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sapphire_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sapphire_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sapphire_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sapphire_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sapphire_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion("has_gem_sapphire", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sapphire_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion("has_gem_sapphire", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sapphire_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion("has_gem_sapphire", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sapphire_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion("has_gem_sapphire", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "sapphire_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "sapphire_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "sapphire_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "sapphire_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "sapphire_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_horse_armor"));


    }

    private void generateSpinel(RecipeExporter exporter) {
        /* -- Spinel -- */
        //Items & Blocks
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "spinel_gem")), 9)
                .group("spinel_gem")
                .input(Registries.ITEM.get(Identifier.of("mores", "spinel_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "spinel_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "spinel_block"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_gem_from_spinel_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "spinel_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "spinel_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "spinel_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "spinel_gem"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_block"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "spinel_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "spinel_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "spinel_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "spinel_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "spinel_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "spinel_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "spinel_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "spinel_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "spinel_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "spinel_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion("has_gem_spinel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "spinel_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion("has_gem_spinel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "spinel_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion("has_gem_spinel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "spinel_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion("has_gem_spinel", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "spinel_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "spinel_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "spinel_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/spinel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "spinel_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "spinel_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_horse_armor"));


    }

    private void generateCitrine(RecipeExporter exporter) {
        /* -- Citrine -- */
        //Items & Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "citrine_gem")), 1)
                .pattern("#Q")
                .pattern("Q#")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "dust/quartz")))
                .input('Q', Registries.ITEM.get(Identifier.of("mores", "citrine")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "citrine_dust"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "citrine_gem"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_gem_from_dust"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "citrine_gem")), 9)
                .group("citrine_gem")
                .input(Registries.ITEM.get(Identifier.of("mores", "citrine_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "citrine_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "citrine_block"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_gem_from_citrine_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "citrine_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "citrine_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "citrine_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "citrine_gem"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_block"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "citrine_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "citrine_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "citrine_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "citrine_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "citrine_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "citrine_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "citrine_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "citrine_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "citrine_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "citrine_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion("has_gem_citrine", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "citrine_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion("has_gem_citrine", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "citrine_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion("has_gem_citrine", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "citrine_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion("has_gem_citrine", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "citrine_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "citrine_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "citrine_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/citrine")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "citrine_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "citrine_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_horse_armor"));


    }

    private void generateMoissanite(RecipeExporter exporter) {
        /* -- Moissanite -- */
        //Items & Blocks
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "moissanite_gem")), 9)
                .group("moissanite_gem")
                .input(Registries.ITEM.get(Identifier.of("mores", "moissanite_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "moissanite_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "moissanite_block"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_gem_from_moissanite_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "moissanite_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "moissanite_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "moissanite_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "moissanite_gem"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_block"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "moissanite_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "moissanite_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "moissanite_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "moissanite_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "moissanite_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "moissanite_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "moissanite_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "moissanite_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "moissanite_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "moissanite_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion("has_gem_moissanite", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "moissanite_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion("has_gem_moissanite", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "moissanite_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion("has_gem_moissanite", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "moissanite_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion("has_gem_moissanite", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "moissanite_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "moissanite_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "moissanite_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "moissanite_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "moissanite_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_horse_armor"));

    }

    private void generateOnyx(RecipeExporter exporter) {
        /* -- Onyx -- */
        //Items & Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "onyx_gem")), 1)
                .pattern("#Q")
                .pattern("Q#")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "dust/quartz")))
                .input('Q', Registries.ITEM.get(Identifier.of("mores", "onyx")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "onyx_dust"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "onyx_gem"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_gem_from_dust"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "onyx_gem")), 9)
                .group("onyx_gem")
                .input(Registries.ITEM.get(Identifier.of("mores", "onyx_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "onyx_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "onyx_block"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_gem_from_onyx_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "onyx_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("mores", "onyx_gem")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "onyx_gem"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "onyx_gem"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_block"));
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "onyx_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "onyx_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "onyx_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "onyx_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "onyx_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "onyx_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "onyx_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "onyx_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "onyx_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "onyx_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion("has_gem_onyx", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "onyx_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion("has_gem_onyx", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "onyx_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion("has_gem_onyx", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "onyx_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion("has_gem_onyx", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "onyx_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "onyx_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "onyx_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "onyx_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "onyx_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_horse_armor"));


    }

    private void generateObsidian(RecipeExporter exporter) {
        /* -- Obsidian -- */
        //Items
        //TODO Obsidian ingot from scrap
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot")), 1)
                .input(Registries.ITEM.get(Identifier.of("mores", "obsidian_scrap")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "gold_ingot")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "gold_ingot")))
                .input(Registries.ITEM.get(Identifier.of("mores", "obsidian_scrap")))
                .input(Registries.ITEM.get(Identifier.of("mores", "obsidian_scrap")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "gold_ingot")))
                .input(Registries.ITEM.get(Identifier.of("mores", "obsidian_scrap")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "gold_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "obsidian_scrap"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "obsidian_scrap"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_ingot"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template")), 2)
                .pattern("#S#")
                .pattern("#C#")
                .pattern("###")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "diamond")))
                .input('C', Registries.ITEM.get(Identifier.of("minecraft", "obsidian")))
                .input('S', Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_upgrade_smithing_template"));
        //Tools
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_sword"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "obsidian_sword")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_sword"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_sword"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_sword_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_pickaxe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot"))), RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "obsidian_pickaxe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_pickaxe_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_shovel"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot"))), RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "obsidian_shovel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_shovel"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_shovel"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_shovel_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_hoe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot"))), RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "obsidian_hoe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_hoe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_hoe"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_hoe_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_axe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot"))), RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "obsidian_axe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_axe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_axe"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_axe_smithing"));
        //Weapons
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "obsidian_battle_axe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_battle_axe_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "obsidian_battle_mace")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_battle_mace_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "diamond_dagger"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "obsidian_dagger")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "diamond_dagger"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "diamond_dagger"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_dagger_smithing"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "obsidian_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/obsidian")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_shield"));
        //Armor
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_helmet"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "obsidian_helmet")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_helmet_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_chestplate"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "obsidian_chestplate")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_chestplate"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_chestplate"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_chestplate_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_leggings"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "obsidian_leggings")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_leggings"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_leggings"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_leggings_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_boots"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "obsidian_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "obsidian_boots")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_boots"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_boots"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_boots_smithing"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "obsidian_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "obsidian_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "obsidian_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/obsidian")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "obsidian_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "obsidian_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_horse_armor"));


    }

    private void generateNetherite(RecipeExporter exporter) {
        /* -- Netherite -- */
        //Weapons
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "netherite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "netherite_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "netherite_battle_axe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe"))))
                .offerTo(exporter, Identifier.of("mores", "netherite_battle_axe_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "netherite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "netherite_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "netherite_battle_mace")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace"))))
                .offerTo(exporter, Identifier.of("mores", "netherite_battle_mace_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "netherite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "diamond_dagger"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "netherite_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "netherite_dagger")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "diamond_dagger"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "diamond_dagger"))))
                .offerTo(exporter, Identifier.of("mores", "netherite_dagger_smithing"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "netherite_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("minecraft", "netherite_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("minecraft", "netherite_leggings")))
                .input('G', Registries.ITEM.get(Identifier.of("minecraft", "netherite_ingot")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "netherite_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "netherite_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "netherite_horse_armor"));

    }

    private void generateGraphene(RecipeExporter exporter) {
        /* -- Graphene -- */
        //Items & Blocks
        //Tools
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "graphene_sword")), 1)
                .pattern("$")
                .pattern("$")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "graphene_axe")), 1)
                .pattern("$$")
                .pattern("$#")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "graphene_pickaxe")), 1)
                .pattern("$$$")
                .pattern(" # ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_pickaxe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "graphene_shovel")), 1)
                .pattern("$")
                .pattern("#")
                .pattern("#")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_shovel"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "graphene_hoe")), 1)
                .pattern("$$")
                .pattern(" #")
                .pattern(" #")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_hoe"));
        //Weapons
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "graphene_battle_axe")), 1)
                .pattern("$ $")
                .pattern("$#$")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_battle_axe"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "graphene_battle_mace")), 1)
                .pattern(" $$")
                .pattern(" $$")
                .pattern("#  ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_battle_mace"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "graphene_dagger")), 1)
                .pattern(" $ ")
                .pattern(" # ")
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "stick")))
                .input('$', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "stick"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_dagger"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "graphene_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_shield"));
        //Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "graphene_helmet")), 1)
                .pattern("###")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion("has_gem_graphene", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_helmet"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "graphene_chestplate")), 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion("has_gem_graphene", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_chestplate"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "graphene_leggings")), 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion("has_gem_graphene", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_leggings"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "graphene_boots")), 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion("has_gem_graphene", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_boots"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "graphene_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "graphene_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "graphene_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "graphene_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "graphene_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "graphene_horse_armor"));


    }
    private void generateAdamantium(RecipeExporter exporter) {
        /* -- Adamantium -- */
        //Items & Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template")), 2)
                .pattern("#S#")
                .pattern("#C#")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/adamantium")))
                .input('C', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "stone_crafting_materials")))
                .input('S', Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_upgrade_smithing_template"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot")), 9)
                .group("adamantium_ingot")
                .input(Registries.ITEM.get(Identifier.of("mores", "adamantium_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "adamantium_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "adamantium_block"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_ingot_from_adamantium_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "adamantium_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/adamantium")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_block"));
        //Tools
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_sword"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "adamantium_sword")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_sword"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_sword"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_sword_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_pickaxe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "adamantium_pickaxe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_pickaxe_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_shovel"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "adamantium_shovel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_shovel"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_shovel"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_shovel_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_hoe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "adamantium_hoe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_hoe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_hoe"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_hoe_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_axe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "adamantium_axe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_axe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_axe"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_axe_smithing"));
        //Weapons
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "adamantium_battle_axe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_battle_axe_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "adamantium_battle_mace")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_battle_mace_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "diamond_dagger"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "adamantium_dagger")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "diamond_dagger"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "diamond_dagger"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_dagger_smithing"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "adamantium_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/adamantium")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_shield"));
        //Armor
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_helmet"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "adamantium_helmet")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_helmet_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_chestplate"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "adamantium_chestplate")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_chestplate"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_chestplate"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_chestplate_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_leggings"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "adamantium_leggings")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_leggings"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_leggings"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_leggings_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_boots"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "adamantium_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "adamantium_boots")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_boots"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_boots"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_boots_smithing"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "adamantium_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "adamantium_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "adamantium_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/adamantium")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "adamantium_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "adamantium_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "adamantium_horse_armor"));
    }

    private void generateEnderite(RecipeExporter exporter) {
        /* -- Enderite -- */
        //Items & Blocks
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "enderite_ingot")), 1)
                .input(Registries.ITEM.get(Identifier.of("mores", "enderite_scrap")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "netherite_ingot")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "netherite_ingot")))
                .input(Registries.ITEM.get(Identifier.of("mores", "enderite_scrap")))
                .input(Registries.ITEM.get(Identifier.of("mores", "enderite_scrap")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "netherite_ingot")))
                .input(Registries.ITEM.get(Identifier.of("mores", "enderite_scrap")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "netherite_ingot")))
                .input(Registries.ITEM.get(Identifier.of("minecraft", "ender_pearl")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "enderite_scrap"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "enderite_scrap"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_ingot"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template")), 2)
                .pattern("#S#")
                .pattern("#C#")
                .pattern("###")
                .input('C', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/enderite")))
                .input('#', Registries.ITEM.get(Identifier.of("minecraft", "end_stone")))
                .input('S', Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_upgrade_smithing_template"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "enderite_ingot")), 9)
                .group("enderite_ingot")
                .input(Registries.ITEM.get(Identifier.of("mores", "enderite_block")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "enderite_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "enderite_block"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_ingot_from_enderite_block"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Registries.ITEM.get(Identifier.of("mores", "enderite_block")), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/enderite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_block"));
        //Tools
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_sword"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "enderite_sword")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_sword"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_sword"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_sword_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_pickaxe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "enderite_pickaxe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_pickaxe_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_shovel"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "enderite_shovel")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_shovel"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_shovel"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_shovel_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_hoe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "enderite_hoe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_hoe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_hoe"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_hoe_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_axe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), RecipeCategory.TOOLS, Registries.ITEM.get(Identifier.of("mores", "enderite_axe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_axe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_axe"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_axe_smithing"));
        //Weapons
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "enderite_battle_axe")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_axe"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_battle_axe_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "enderite_battle_mace")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "diamond_battle_mace"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_battle_mace_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "diamond_dagger"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "enderite_dagger")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "diamond_dagger"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "diamond_dagger"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_dagger_smithing"));
        //Shield
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "enderite_shield")), 1)
                .pattern("WoW")
                .pattern("WWW")
                .pattern(" W ")
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks")))
                .input('o', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/enderite")))
                .criterion("has_planks", conditionsFromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "planks"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_shield"));
        //Armor
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_helmet"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "enderite_helmet")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_helmet_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_chestplate"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "enderite_chestplate")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_chestplate"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_chestplate"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_chestplate_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_leggings"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "enderite_leggings")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_leggings"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_leggings"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_leggings_smithing"));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_upgrade_smithing_template"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "diamond_boots"))), Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "enderite_ingot"))), RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "enderite_boots")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_boots"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "diamond_boots"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_boots_smithing"));
        //Horse Armor
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Registries.ITEM.get(Identifier.of("mores", "enderite_horse_armor")), 1)
                .pattern("  H")
                .pattern("GWG")
                .pattern("L L")
                .input('H', Registries.ITEM.get(Identifier.of("mores", "enderite_helmet")))
                .input('W', TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wool")))
                .input('L', Registries.ITEM.get(Identifier.of("mores", "enderite_leggings")))
                .input('G', TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/enderite")))
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "enderite_helmet"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "enderite_helmet"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_horse_armor"));
    }

    private void generateSmokingCooking(RecipeExporter exporter) {
        /* -- Smoking / Cooking -- */
        //Duck
        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_duck"))), RecipeCategory.FOOD, Registries.ITEM.get(Identifier.of("mores", "cooked_duck")), 0.35f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_duck"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_duck"))))
                .offerTo(exporter, Identifier.of("mores", "cooked_duck_from_smoking"));
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_duck"))), RecipeCategory.FOOD, Registries.ITEM.get(Identifier.of("mores", "cooked_duck")), 0.35f, 600)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_duck"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_duck"))))
                .offerTo(exporter, Identifier.of("mores", "cooked_duck_from_campfire_cooking"));


    }

    private void generateSmelting(RecipeExporter exporter) {
        /* -- Smelting -- */
        //Duck
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_duck"))), RecipeCategory.FOOD, Registries.ITEM.get(Identifier.of("mores", "cooked_duck")), 0.35f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_duck"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_duck"))))
                .offerTo(exporter, Identifier.of("mores", "cooked_duck"));
        //Anthracite
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "anthracite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "anthracite")), 0.3f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "anthracite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "anthracite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "anthracite_from_smelting_anthracite_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_anthracite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "anthracite")), 0.3f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_anthracite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_anthracite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "anthracite_from_smelting_deepslate_anthracite_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_anthracite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "anthracite")), 0.3f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_anthracite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_anthracite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "anthracite_from_smelting_nether_anthracite_ore"));
        //Copper
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "copper_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "copper_shovel")), Registries.ITEM.get(Identifier.of("mores", "copper_axe")), Registries.ITEM.get(Identifier.of("mores", "copper_hoe")), Registries.ITEM.get(Identifier.of("mores", "copper_sword")), Registries.ITEM.get(Identifier.of("mores", "copper_helmet")), Registries.ITEM.get(Identifier.of("mores", "copper_chestplate")), Registries.ITEM.get(Identifier.of("mores", "copper_leggings")), Registries.ITEM.get(Identifier.of("mores", "copper_boots")), Registries.ITEM.get(Identifier.of("mores", "copper_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "copper_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "copper_dagger")), Registries.ITEM.get(Identifier.of("mores", "copper_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "copper_nugget")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "copper_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "copper_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "copper_nugget_from_smelting"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "raw_copper_block"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("minecraft", "copper_block")), 6.3f, 1800)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "raw_copper_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "raw_copper_block"))))
                .offerTo(exporter, Identifier.of("mores", "copper_block_from_raw_copper_block_smelting"));
        //Tin
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "tin_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "tin_shovel")), Registries.ITEM.get(Identifier.of("mores", "tin_axe")), Registries.ITEM.get(Identifier.of("mores", "tin_hoe")), Registries.ITEM.get(Identifier.of("mores", "tin_sword")), Registries.ITEM.get(Identifier.of("mores", "tin_helmet")), Registries.ITEM.get(Identifier.of("mores", "tin_chestplate")), Registries.ITEM.get(Identifier.of("mores", "tin_leggings")), Registries.ITEM.get(Identifier.of("mores", "tin_boots")), Registries.ITEM.get(Identifier.of("mores", "tin_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "tin_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "tin_dagger")), Registries.ITEM.get(Identifier.of("mores", "tin_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_nugget")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tin_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tin_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "tin_nugget_from_smelting"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_tin"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_ingot")), 0.5f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_tin"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_tin"))))
                .offerTo(exporter, Identifier.of("mores", "tin_ingot_from_smelting_raw_tin"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_tin_block"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_block")), 6.3f, 1800)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_tin_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_tin_block"))))
                .offerTo(exporter, Identifier.of("mores", "tin_block_from_raw_tin_block_smelting"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "tin_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_ingot")), 0.5f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tin_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tin_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tin_ingot_from_smelting_tin_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_tin_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_ingot")), 0.5f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_tin_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_tin_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tin_ingot_from_smelting_deepslate_tin_ore"));

        //Gold
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "raw_gold_block"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("minecraft", "gold_block")), 9.0f, 1800)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "raw_gold_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "raw_gold_block"))))
                .offerTo(exporter, Identifier.of("mores", "gold_block_from_raw_gold_block_smelting"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "gold_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "gold_dagger")), Registries.ITEM.get(Identifier.of("mores", "gold_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("minecraft", "gold_nugget")), 0.1f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "gold_battle_mace"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "gold_battle_mace"))))
                .offerTo(exporter, Identifier.of("mores", "gold_nugget_from_smelting"));
        //Silver
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "silver_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "silver_shovel")), Registries.ITEM.get(Identifier.of("mores", "silver_axe")), Registries.ITEM.get(Identifier.of("mores", "silver_hoe")), Registries.ITEM.get(Identifier.of("mores", "silver_sword")), Registries.ITEM.get(Identifier.of("mores", "silver_helmet")), Registries.ITEM.get(Identifier.of("mores", "silver_chestplate")), Registries.ITEM.get(Identifier.of("mores", "silver_leggings")), Registries.ITEM.get(Identifier.of("mores", "silver_boots")), Registries.ITEM.get(Identifier.of("mores", "silver_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "silver_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "silver_dagger")), Registries.ITEM.get(Identifier.of("mores", "silver_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_nugget")), 0.1f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "silver_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "silver_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "silver_nugget_from_smelting"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_silver"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_ingot")), 0.6f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_silver"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_silver"))))
                .offerTo(exporter, Identifier.of("mores", "silver_ingot_from_smelting_raw_silver"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_silver_block"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_block")), 7.8f, 1800)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_silver_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_silver_block"))))
                .offerTo(exporter, Identifier.of("mores", "silver_block_from_raw_silver_block_smelting"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "silver_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_ingot")), 0.6f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "silver_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "silver_ore"))))
                .offerTo(exporter, Identifier.of("mores", "silver_ingot_from_smelting_silver_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_silver_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_ingot")), 0.6f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_silver_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_silver_ore"))))
                .offerTo(exporter, Identifier.of("mores", "silver_ingot_from_smelting_deepslate_silver_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_silver_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_ingot")), 0.6f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_silver_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_silver_ore"))))
                .offerTo(exporter, Identifier.of("mores", "silver_ingot_from_smelting_nether_silver_ore"));
        //Electrum
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "electrum_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_ingot")), 0.6f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "electrum_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "electrum_ore"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_ingot_from_smelting_electrum_ore"));
        //Sterling Silver
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_shovel")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_axe")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_hoe")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_sword")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_helmet")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_chestplate")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_leggings")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_boots")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_dagger")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_nugget")), 0.1f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_nugget_from_smelting"));
        //Rose Gold
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "rose_gold_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_shovel")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_axe")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_hoe")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_sword")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_helmet")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_chestplate")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_leggings")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_boots")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_dagger")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "rose_gold_nugget")), 0.1f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_nugget_from_smelting"));
        //Iron
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "iron_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "iron_dagger")), Registries.ITEM.get(Identifier.of("mores", "iron_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("minecraft", "iron_nugget")), 0.1f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "iron_battle_mace"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "iron_battle_mace"))))
                .offerTo(exporter, Identifier.of("mores", "iron_nugget_from_smelting"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "raw_iron_block"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("minecraft", "iron_block")), 6.3f, 1800)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "raw_iron_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "raw_iron_block"))))
                .offerTo(exporter, Identifier.of("mores", "iron_block_from_raw_iron_block_smelting"));
        //Cobalt
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "cobalt_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "cobalt_shovel")), Registries.ITEM.get(Identifier.of("mores", "cobalt_axe")), Registries.ITEM.get(Identifier.of("mores", "cobalt_hoe")), Registries.ITEM.get(Identifier.of("mores", "cobalt_sword")), Registries.ITEM.get(Identifier.of("mores", "cobalt_helmet")), Registries.ITEM.get(Identifier.of("mores", "cobalt_chestplate")), Registries.ITEM.get(Identifier.of("mores", "cobalt_leggings")), Registries.ITEM.get(Identifier.of("mores", "cobalt_boots")), Registries.ITEM.get(Identifier.of("mores", "cobalt_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "cobalt_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "cobalt_dagger")), Registries.ITEM.get(Identifier.of("mores", "cobalt_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_nugget")), 0.1f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_nugget_from_smelting"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_ingot")), 0.8f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_ingot_from_smelting_raw_cobalt"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt_block"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_block")), 7.0f, 1800)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt_block"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_block_from_raw_cobalt_block_smelting"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "cobalt_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_ingot")), 0.8f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_ore"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_ingot_from_smelting_cobalt_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_cobalt_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_ingot")), 0.8f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_cobalt_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_cobalt_ore"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_ingot_from_smelting_deepslate_cobalt_ore"));
        //Carbon Steel
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_shovel")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_axe")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_hoe")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_sword")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_helmet")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_chestplate")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_leggings")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_boots")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_dagger")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_nugget")), 0.1f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_nugget_from_smelting"));
        //Hardened Steel
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_shovel")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_axe")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_hoe")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_sword")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_helmet")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_chestplate")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_leggings")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_boots")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_dagger")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_nugget")), 0.1f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_nugget_from_smelting"));
        //Turquoise
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "turquoise_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "turquoise")), 0.9f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "turquoise_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "turquoise_ore"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_from_smelting_turquoise_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_turquoise_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "turquoise")), 0.9f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_turquoise_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_turquoise_ore"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_from_smelting_deepslate_turquoise_ore"));
        //Tanzanite
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "tanzanite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tanzanite_gem")), 0.9f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tanzanite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tanzanite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_gem_from_smelting_tanzanite_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_tanzanite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tanzanite_gem")), 0.9f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_tanzanite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_tanzanite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_gem_from_smelting_deepslate_tanzanite_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_tanzanite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tanzanite_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_tanzanite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_tanzanite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_gem_from_smelting_nether_tanzanite_ore"));
        //Tourmaline
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "tourmaline_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tourmaline_gem")), 0.9f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tourmaline_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tourmaline_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_gem_from_smelting_tourmaline_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_tourmaline_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tourmaline_gem")), 0.9f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_tourmaline_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_tourmaline_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_gem_from_smelting_deepslate_tourmaline_ore"));
        //Topaz
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "topaz_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "topaz_gem")), 0.9f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "topaz_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "topaz_ore"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_gem_from_smelting_topaz_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_topaz_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "topaz_gem")), 0.9f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_topaz_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_topaz_ore"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_gem_from_smelting_deepslate_topaz_ore"));
        //Ruby
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "ruby_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "ruby_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "ruby_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "ruby_ore"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_gem_from_smelting_ruby_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_ruby_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "ruby_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_ruby_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_ruby_ore"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_gem_from_smelting_deepslate_ruby_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_ruby_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "ruby_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_ruby_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_ruby_ore"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_gem_from_smelting_nether_ruby_ore"));
        //Sapphire
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "sapphire_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sapphire_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "sapphire_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "sapphire_ore"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_gem_from_smelting_sapphire_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_sapphire_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sapphire_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_sapphire_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_sapphire_ore"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_gem_from_smelting_deepslate_sapphire_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_sapphire_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sapphire_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_sapphire_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_sapphire_ore"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_gem_from_smelting_sapphire_nether_ore"));
        //Spinel
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "spinel_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "spinel_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "spinel_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "spinel_ore"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_gem_from_smelting_spinel_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_spinel_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "spinel_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_spinel_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_spinel_ore"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_gem_from_smelting_deepslate_spinel_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_spinel_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "spinel_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_spinel_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_spinel_ore"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_gem_from_smelting_spinel_nether_ore"));
        //Citrine
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "citrine_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "citrine")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "citrine_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "citrine_ore"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_from_smelting_citrine_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_citrine_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "citrine")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_citrine_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_citrine_ore"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_from_smelting_citrine_nether_ore"));
        //Moissanite
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "moissanite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "moissanite_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "moissanite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "moissanite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_gem_from_smelting_moissanite_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_moissanite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "moissanite_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_moissanite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_moissanite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_gem_from_smelting_deepslate_moissanite_ore"));
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_moissanite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "moissanite_gem")), 1.0f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_moissanite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_moissanite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_gem_from_smelting_nether_moissanite_ore"));
        //Onyx
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "ender_onyx_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "onyx")), 1.1f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "ender_onyx_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "ender_onyx_ore"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_from_smelting_ender_onyx_ore"));
        //Enderite
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "primordial_debris"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "enderite_scrap")), 1.1f, 200)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "primordial_debris"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "primordial_debris"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_scrap_from_primordial_debris"));


    }

    private void generateBlasting(RecipeExporter exporter) {
        /* -- Blasting -- */

        //Anthracite
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "anthracite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "anthracite")), 0.3f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "anthracite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "anthracite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "anthracite_from_blasting_anthracite_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_anthracite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "anthracite")), 0.3f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_anthracite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_anthracite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "anthracite_from_blasting_deepslate_anthracite_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_anthracite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "anthracite")), 0.3f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_anthracite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_anthracite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "anthracite_from_blasting_nether_anthracite_ore"));
        //Copper
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "copper_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "copper_shovel")), Registries.ITEM.get(Identifier.of("mores", "copper_axe")), Registries.ITEM.get(Identifier.of("mores", "copper_hoe")), Registries.ITEM.get(Identifier.of("mores", "copper_sword")), Registries.ITEM.get(Identifier.of("mores", "copper_helmet")), Registries.ITEM.get(Identifier.of("mores", "copper_chestplate")), Registries.ITEM.get(Identifier.of("mores", "copper_leggings")), Registries.ITEM.get(Identifier.of("mores", "copper_boots")), Registries.ITEM.get(Identifier.of("mores", "copper_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "copper_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "copper_dagger")), Registries.ITEM.get(Identifier.of("mores", "copper_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "copper_nugget")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "copper_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "copper_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "copper_nugget_from_blasting"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "raw_copper_block"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("minecraft", "copper_block")), 6.3f, 900)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "raw_copper_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "raw_copper_block"))))
                .offerTo(exporter, Identifier.of("mores", "copper_block_from_raw_copper_block_blasting"));
        //Tin
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "tin_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "tin_shovel")), Registries.ITEM.get(Identifier.of("mores", "tin_axe")), Registries.ITEM.get(Identifier.of("mores", "tin_hoe")), Registries.ITEM.get(Identifier.of("mores", "tin_sword")), Registries.ITEM.get(Identifier.of("mores", "tin_helmet")), Registries.ITEM.get(Identifier.of("mores", "tin_chestplate")), Registries.ITEM.get(Identifier.of("mores", "tin_leggings")), Registries.ITEM.get(Identifier.of("mores", "tin_boots")), Registries.ITEM.get(Identifier.of("mores", "tin_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "tin_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "tin_dagger")), Registries.ITEM.get(Identifier.of("mores", "tin_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_nugget")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tin_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tin_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "tin_nugget_from_blasting"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_tin"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_ingot")), 0.5f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_tin"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_tin"))))
                .offerTo(exporter, Identifier.of("mores", "tin_ingot_from_blasting_raw_tin"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_tin_block"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_block")), 6.3f, 900)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_tin_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_tin_block"))))
                .offerTo(exporter, Identifier.of("mores", "tin_block_from_raw_tin_block_blasting"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "tin_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_ingot")), 0.5f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tin_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tin_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tin_ingot_from_blasting_tin_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_tin_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tin_ingot")), 0.5f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_tin_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_tin_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tin_ingot_from_blasting_deepslate_tin_ore"));
        //Gold
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "raw_gold_block"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("minecraft", "gold_block")), 9.0f, 900)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "raw_gold_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "raw_gold_block"))))
                .offerTo(exporter, Identifier.of("mores", "gold_block_from_raw_gold_block_blasting"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "gold_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "gold_dagger")), Registries.ITEM.get(Identifier.of("mores", "gold_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("minecraft", "gold_nugget")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "gold_battle_mace"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "gold_battle_mace"))))
                .offerTo(exporter, Identifier.of("mores", "gold_nugget_from_blasting"));
        //Silver
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "silver_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "silver_shovel")), Registries.ITEM.get(Identifier.of("mores", "silver_axe")), Registries.ITEM.get(Identifier.of("mores", "silver_hoe")), Registries.ITEM.get(Identifier.of("mores", "silver_sword")), Registries.ITEM.get(Identifier.of("mores", "silver_helmet")), Registries.ITEM.get(Identifier.of("mores", "silver_chestplate")), Registries.ITEM.get(Identifier.of("mores", "silver_leggings")), Registries.ITEM.get(Identifier.of("mores", "silver_boots")), Registries.ITEM.get(Identifier.of("mores", "silver_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "silver_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "silver_dagger")), Registries.ITEM.get(Identifier.of("mores", "silver_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_nugget")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "silver_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "silver_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "silver_nugget_from_blasting"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_silver"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_ingot")), 0.6f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_silver"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_silver"))))
                .offerTo(exporter, Identifier.of("mores", "silver_ingot_from_blasting_raw_silver"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_silver_block"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_block")), 7.8f, 900)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_silver_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_silver_block"))))
                .offerTo(exporter, Identifier.of("mores", "silver_block_from_raw_silver_block_blasting"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "silver_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_ingot")), 0.6f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "silver_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "silver_ore"))))
                .offerTo(exporter, Identifier.of("mores", "silver_ingot_from_blasting_silver_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_silver_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_ingot")), 0.6f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_silver_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_silver_ore"))))
                .offerTo(exporter, Identifier.of("mores", "silver_ingot_from_blasting_deepslate_silver_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_silver_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "silver_ingot")), 0.6f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_silver_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_silver_ore"))))
                .offerTo(exporter, Identifier.of("mores", "silver_ingot_from_blasting_nether_silver_ore"));
        //Electrum
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "electrum_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_ingot")), 0.6f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "electrum_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "electrum_ore"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_ingot_from_blasting_electrum_ore"));
        //Sterling Silver
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_shovel")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_axe")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_hoe")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_sword")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_helmet")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_chestplate")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_leggings")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_boots")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_dagger")), Registries.ITEM.get(Identifier.of("mores", "sterling_silver_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sterling_silver_nugget")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "sterling_silver_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "sterling_silver_nugget_from_blasting"));
        //Rose Gold
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "rose_gold_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_shovel")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_axe")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_hoe")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_sword")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_helmet")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_chestplate")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_leggings")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_boots")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_dagger")), Registries.ITEM.get(Identifier.of("mores", "rose_gold_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "rose_gold_nugget")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "rose_gold_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "rose_gold_nugget_from_blasting"));
        //Iron
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "iron_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "iron_dagger")), Registries.ITEM.get(Identifier.of("mores", "iron_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("minecraft", "iron_nugget")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "iron_battle_mace"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "iron_battle_mace"))))
                .offerTo(exporter, Identifier.of("mores", "iron_nugget_from_blasting"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "raw_iron_block"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("minecraft", "iron_block")), 6.3f, 900)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "raw_iron_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "raw_iron_block"))))
                .offerTo(exporter, Identifier.of("mores", "iron_block_from_raw_iron_block_blasting"));
        //Cobalt
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "cobalt_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "cobalt_shovel")), Registries.ITEM.get(Identifier.of("mores", "cobalt_axe")), Registries.ITEM.get(Identifier.of("mores", "cobalt_hoe")), Registries.ITEM.get(Identifier.of("mores", "cobalt_sword")), Registries.ITEM.get(Identifier.of("mores", "cobalt_helmet")), Registries.ITEM.get(Identifier.of("mores", "cobalt_chestplate")), Registries.ITEM.get(Identifier.of("mores", "cobalt_leggings")), Registries.ITEM.get(Identifier.of("mores", "cobalt_boots")), Registries.ITEM.get(Identifier.of("mores", "cobalt_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "cobalt_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "cobalt_dagger")), Registries.ITEM.get(Identifier.of("mores", "cobalt_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_nugget")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_nugget_from_blasting"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_ingot")), 0.8f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_ingot_from_blasting_raw_cobalt"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt_block"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_block")), 7.0f, 900)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt_block"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "raw_cobalt_block"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_block_from_raw_cobalt_block_blasting"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "cobalt_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_ingot")), 0.8f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "cobalt_ore"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_ingot_from_blasting_cobalt_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_cobalt_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "cobalt_ingot")), 0.8f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_cobalt_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_cobalt_ore"))))
                .offerTo(exporter, Identifier.of("mores", "cobalt_ingot_from_blasting_deepslate_cobalt_ore"));
        //Carbon Steel
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_ingot"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "hot_carbon_steel_scrap")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_ingot"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_ingot"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_scrap_from_ingot"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_shovel")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_axe")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_hoe")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_sword")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_helmet")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_chestplate")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_leggings")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_boots")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_dagger")), Registries.ITEM.get(Identifier.of("mores", "carbon_steel_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "carbon_steel_nugget")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "carbon_steel_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "carbon_steel_nugget_from_blasting"));
        //Hardened Steel
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_pickaxe")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_shovel")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_axe")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_hoe")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_sword")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_helmet")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_chestplate")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_leggings")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_boots")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_horse_armor")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_battle_mace")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_dagger")), Registries.ITEM.get(Identifier.of("mores", "hardened_steel_battle_axe"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "hardened_steel_nugget")), 0.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_pickaxe"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "hardened_steel_pickaxe"))))
                .offerTo(exporter, Identifier.of("mores", "hardened_steel_nugget_from_blasting"));
        //Turquoise
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "turquoise_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "turquoise")), 0.9f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "turquoise_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "turquoise_ore"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_from_blasting_turquoise_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_turquoise_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "turquoise")), 0.9f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_turquoise_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_turquoise_ore"))))
                .offerTo(exporter, Identifier.of("mores", "turquoise_from_blasting_deepslate_turquoise_ore"));
        //Tanzanite
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "tanzanite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tanzanite_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tanzanite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tanzanite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_gem_from_blasting_tanzanite_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_tanzanite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tanzanite_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_tanzanite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_tanzanite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_gem_from_blasting_deepslate_tanzanite_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_tanzanite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tanzanite_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_tanzanite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_tanzanite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tanzanite_gem_from_blasting_nether_tanzanite_ore"));
        //Tourmaline
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "tourmaline_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tourmaline_gem")), 0.9f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "tourmaline_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "tourmaline_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_gem_from_blasting_tourmaline_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_tourmaline_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "tourmaline_gem")), 0.9f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_tourmaline_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_tourmaline_ore"))))
                .offerTo(exporter, Identifier.of("mores", "tourmaline_gem_from_blasting_deepslate_tourmaline_ore"));
        //Topaz
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "topaz_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "topaz_gem")), 0.9f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "topaz_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "topaz_ore"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_gem_from_blasting_topaz_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_topaz_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "topaz_gem")), 0.9f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_topaz_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_topaz_ore"))))
                .offerTo(exporter, Identifier.of("mores", "topaz_gem_from_blasting_deepslate_topaz_ore"));
        //Ruby
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "ruby_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "ruby_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "ruby_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "ruby_ore"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_gem_from_blasting_ruby_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_ruby_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "ruby_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_ruby_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_ruby_ore"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_gem_from_blasting_deepslate_ruby_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_ruby_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "ruby_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_ruby_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_ruby_ore"))))
                .offerTo(exporter, Identifier.of("mores", "ruby_gem_from_blasting_nether_ruby_ore"));
        //Sapphire
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "sapphire_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sapphire_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "sapphire_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "sapphire_ore"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_gem_from_blasting_sapphire_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_sapphire_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sapphire_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_sapphire_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_sapphire_ore"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_gem_from_blasting_deepslate_sapphire_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_sapphire_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "sapphire_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_sapphire_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_sapphire_ore"))))
                .offerTo(exporter, Identifier.of("mores", "sapphire_gem_from_blasting_nether_sapphire_ore"));
        //Spinel
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "spinel_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "spinel_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "spinel_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "spinel_ore"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_gem_from_blasting_spinel_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_spinel_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "spinel_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_spinel_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_spinel_ore"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_gem_from_blasting_deepslate_spinel_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_spinel_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "spinel_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_spinel_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_spinel_ore"))))
                .offerTo(exporter, Identifier.of("mores", "spinel_gem_from_blasting_nether_spinel_ore"));
        //Citrine
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "citrine_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "citrine")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "citrine_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "citrine_ore"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_from_blasting_citrine_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_citrine_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "citrine")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_citrine_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_citrine_ore"))))
                .offerTo(exporter, Identifier.of("mores", "citrine_from_blasting_nether_citrine_ore"));
        //Moissanite
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "moissanite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "moissanite_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "moissanite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "moissanite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_gem_from_blasting_moissanite_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "deepslate_moissanite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "moissanite_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_moissanite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "deepslate_moissanite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_gem_from_blasting_deepslate_moissanite_ore"));
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "nether_moissanite_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "moissanite_gem")), 1.0f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "nether_moissanite_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "nether_moissanite_ore"))))
                .offerTo(exporter, Identifier.of("mores", "moissanite_gem_from_blasting_nether_moissanite_ore"));
        //Onyx
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "ender_onyx_ore"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "onyx")), 1.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "ender_onyx_ore"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "ender_onyx_ore"))))
                .offerTo(exporter, Identifier.of("mores", "onyx_from_blasting_ender_onyx_ore"));
        //Obsidian
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("minecraft", "obsidian"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "obsidian_scrap")), 0.7f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("minecraft", "obsidian"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("minecraft", "obsidian"))))
                .offerTo(exporter, Identifier.of("mores", "obsidian_scrap_from_blasting_obsidian"));
        //Enderite
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Registries.ITEM.get(Identifier.of("mores", "primordial_debris"))), RecipeCategory.MISC, Registries.ITEM.get(Identifier.of("mores", "enderite_scrap")), 1.1f, 100)
                .criterion(hasItem(Registries.ITEM.get(Identifier.of("mores", "primordial_debris"))), conditionsFromItem(Registries.ITEM.get(Identifier.of("mores", "primordial_debris"))))
                .offerTo(exporter, Identifier.of("mores", "enderite_scrap_from_blasting_primordial_debris"));
    }

    private void generateAlloying(RecipeExporter exporter) {
        offerAlloying(exporter,
                "bronze_from_copper_tin",
                Ingredient.ofItems(COPPER_INGOT),
                Ingredient.ofItems(TIN_INGOT),
                new ItemStack(BRONZE_INGOT, 1),
                0.2f, 200,
                "soul"
        );

        offerAlloying(exporter,
                "sterling_silver_from_copper_silver",
                Ingredient.ofItems(COPPER_INGOT),
                Ingredient.ofItems(SILVER_INGOT),
                new ItemStack(STERLING_SILVER_INGOT, 1),
                0.2f, 200,
                "soul"
        );

        offerAlloying(exporter,
                "rose_gold_from_copper_gold",
                Ingredient.ofItems(COPPER_INGOT),
                Ingredient.ofItems(GOLD_INGOT),
                new ItemStack(ROSE_GOLD_INGOT, 1),
                0.2f, 200,
                "red"
        );

        // carbon steel: (coal OR anthracite) + iron (both orders)
        Ingredient coalOrAnthracite = Ingredient.ofItems(
                COAL,
                ANTHRACITE
        );

        offerAlloying(exporter,
                "carbon_steel_from_iron_coal",
                Ingredient.ofItems(IRON_INGOT),
                coalOrAnthracite,
                new ItemStack(CARBON_STEEL_INGOT, 1),
                0.3f, 200,
                "soul"
        );

        offerAlloying(exporter,
                "adamantium_from_iron_diamond",
                Ingredient.ofItems(IRON_INGOT),
                Ingredient.ofItems(DIAMOND),
                new ItemStack(ADAMANTIUM_INGOT, 1),
                0.3f, 200,
                "blue"
        );
        //TODO Confirm graphene
        offerAlloying(exporter,
                "graphene_from_onyx_turquoise",
                Ingredient.ofItems(ONYX_GEM),
                Ingredient.ofItems(TURQUOISE_GEM),
                new ItemStack(GRAPHENE_GEM, 1),
                0.3f, 200,
                "purple"
        );
    }


    private static void offerAlloying(
            RecipeExporter exporter,
            String recipeName,
            Ingredient a,
            Ingredient b,
            ItemStack result,
            float experience,
            int cookingTime,
            String theme
    ) {
        Identifier id = Identifier.of(mod.leronus.mores.Mores.MOD_ID, recipeName);

        // Exporter wants a real Recipe<?> in 1.21.1
        exporter.accept(
                id,
                new AlloyingRecipe(a, b, result, experience, cookingTime, theme),
                null
        );
    }
}
