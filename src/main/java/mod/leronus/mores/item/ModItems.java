package mod.leronus.mores.item;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import mod.leronus.mores.Mores;
import mod.leronus.mores.item.custom.ModArmorItem;
import mod.leronus.mores.item.custom.ModBattleAxeItem;
import mod.leronus.mores.item.custom.ModSwordItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * Class that initialise all items from mOres
 */
public class ModItems {
    /**
     * Fills the registry with items
     */
//    public static final Item SWEET_CAROLINE_MUSIC_DISC = registerItem("sweet_caroline_music_disc", new MusicDiscItem(4, ModSounds.SWEET_CAROLINE_BOOTLEG, new FabricItemSettings(1).rarity(Rarity.RARE), 4040));
//    public static final Item CIPHER_DISC = registerItem("cipher_music_disc", new MusicDiscItem(5, ModSounds.CIPHER, new FabricItemSettings(1).rarity(Rarity.RARE), 3820));


    public static final Item CHOCOLATE = registerItem("chocolate", new Item(new FabricItemSettings().food(ModFoodComponents.CHOCOLATE)));
    public static final Item CARROT_PIE = registerItem("carrot_pie", new Item(new FabricItemSettings().food(ModFoodComponents.CARROT_PIE)));
    public static final Item VELVET = registerItem("velvet", new Item(new FabricItemSettings().food(ModFoodComponents.VELVET)));

    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new FabricItemSettings()));
    public static final Item RAW_SILVER = registerItem("raw_silver", new Item(new FabricItemSettings()));
    public static final Item RAW_COBALT = registerItem("raw_cobalt", new Item(new FabricItemSettings()));

    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new FabricItemSettings()));
    public static final Item SILVER_INGOT = registerItem("silver_ingot", new Item(new FabricItemSettings()));
    public static final Item COBALT_INGOT = registerItem("cobalt_ingot", new Item(new FabricItemSettings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new FabricItemSettings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item STERLING_INGOT = registerItem("sterling_ingot", new Item(new FabricItemSettings()));
    public static final Item OBSIDIAN_INGOT = registerItem("obsidian_ingot", new Item(new FabricItemSettings()));

    public static final Item TOPAZ_GEM = registerItem("topaz_gem", new Item(new FabricItemSettings()));
    public static final Item TOURMALINE_GEM = registerItem("tourmaline_gem", new Item(new FabricItemSettings()));
    public static final Item TANZANITE_GEM = registerItem("tanzanite_gem", new Item(new FabricItemSettings()));
    public static final Item RUBY_GEM = registerItem("ruby_gem", new Item(new FabricItemSettings()));
    public static final Item SAPPHIRE_GEM = registerItem("sapphire_gem", new Item(new FabricItemSettings()));
    public static final Item TURQUOISE_GEM = registerItem("turquoise_gem", new Item(new FabricItemSettings()));
    public static final Item MOISSANITE_GEM = registerItem("moissanite_gem", new Item(new FabricItemSettings()));
    public static final Item ONYX_GEM = registerItem("onyx_gem", new Item(new FabricItemSettings()));
    public static final Item GRAPHENE_GEM = registerItem("graphene_gem", new Item(new FabricItemSettings()));

    public static final Item CHAIN = registerItem("chain", new Item(new FabricItemSettings()));

    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item(new FabricItemSettings()));
    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new FabricItemSettings()));
    public static final Item SILVER_NUGGET = registerItem("silver_nugget", new Item(new FabricItemSettings()));
    public static final Item COBALT_NUGGET = registerItem("cobalt_nugget", new Item(new FabricItemSettings()));
    public static final Item BRONZE_NUGGET = registerItem("bronze_nugget", new Item(new FabricItemSettings()));
    public static final Item STEEL_NUGGET = registerItem("steel_nugget", new Item(new FabricItemSettings()));
    public static final Item STERLING_NUGGET = registerItem("sterling_nugget", new Item(new FabricItemSettings()));

    public static final Item SILVER_APPLE = registerItem("silver_apple", new Item(new FabricItemSettings().food(ModFoodComponents.SILVER_APPLE)));
    public static final Item BRONZE_APPLE = registerItem("bronze_apple", new Item(new FabricItemSettings().food(ModFoodComponents.BRONZE_APPLE)));
    public static final Item COBALT_APPLE = registerItem("cobalt_apple", new Item(new FabricItemSettings().food(ModFoodComponents.COBALT_APPLE)));

//    public static final Item DUCK = registerItem("duck", new Item(new FabricItemSettings()).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build())));
//    public static final Item COOKED_DUCK = registerItem("cooked_duck", new Item(new FabricItemSettings()).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).meat().build())));
//
    public static final Item ANTHRACITE = registerItem("anthracite", new Item(new FabricItemSettings()));

//    public static final Item DUCK_SPAWN_EGG  = registerItem("duck_spawn_egg", new ForgeSpawnEggItem(ModEntityTypes.DUCK, 0x006808, 0xFFD400, new FabricItemSettings));
//    public static final Item DUCK_EGG  = registerItem("duck_egg", new ModEggItem(new FabricItemSettings));

//    public static final Item OBSIDIAN_UPGRADE_SMITHING_TEMPLATE = registerItem("obsidian_upgrade_smithing_template", ()-> ModSmithingTemplateItem.createObsidianUpgradeTemplate());
//    public static final Item SICKO_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("sicko_armor_trim_smithing_template", ()-> ModSmithingTemplateItem.createArmorTrimTemplate(ModArmorTrimPatterns.SICKO));


    //All horse armor
    public static final Item COPPER_HORSE_ARMOR = registerItem("copper_horse_armor", new HorseArmorItem(3, "copper", (new FabricItemSettings()).maxCount(1)));
    public static final Item TIN_HORSE_ARMOR = registerItem("tin_horse_armor", new HorseArmorItem(2, "tin", (new FabricItemSettings()).maxCount(1)));
    public static final Item SILVER_HORSE_ARMOR = registerItem("silver_horse_armor", new HorseArmorItem(5, "silver", (new FabricItemSettings()).maxCount(1)));
    public static final Item COBALT_HORSE_ARMOR = registerItem("cobalt_horse_armor", new HorseArmorItem(6, "cobalt", (new FabricItemSettings()).maxCount(1)));
    public static final Item BRONZE_HORSE_ARMOR = registerItem("bronze_horse_armor", new HorseArmorItem(4, "bronze", (new FabricItemSettings()).maxCount(1)));
    public static final Item STEEL_HORSE_ARMOR = registerItem("steel_horse_armor", new HorseArmorItem(8, "steel", (new FabricItemSettings()).maxCount(1)));
    public static final Item STERLING_HORSE_ARMOR = registerItem("sterling_horse_armor", new HorseArmorItem(7, "sterling", (new FabricItemSettings()).maxCount(1)));
    public static final Item AMETHYST_HORSE_ARMOR = registerItem("amethyst_horse_armor", new HorseArmorItem(7, "amethyst", (new FabricItemSettings()).maxCount(1)));
    public static final Item OBSIDIAN_HORSE_ARMOR = registerItem("obsidian_horse_armor", new HorseArmorItem(9, "obsidian", (new FabricItemSettings()).maxCount(1)));
    public static final Item EMERALD_HORSE_ARMOR = registerItem("emerald_horse_armor", new HorseArmorItem(8, "emerald", (new FabricItemSettings()).maxCount(1)));
    public static final Item TOPAZ_HORSE_ARMOR = registerItem("topaz_horse_armor", new HorseArmorItem(9, "topaz", (new FabricItemSettings()).maxCount(1)));
    public static final Item TOURMALINE_HORSE_ARMOR = registerItem("tourmaline_horse_armor", new HorseArmorItem(10, "tourmaline", (new FabricItemSettings()).maxCount(1)));
    public static final Item TANZANITE_HORSE_ARMOR = registerItem("tanzanite_horse_armor", new HorseArmorItem(10, "tanzanite", (new FabricItemSettings()).maxCount(1)));
    public static final Item RUBY_HORSE_ARMOR = registerItem("ruby_horse_armor", new HorseArmorItem(12, "ruby", (new FabricItemSettings()).maxCount(1)));
    public static final Item SAPPHIRE_HORSE_ARMOR = registerItem("sapphire_horse_armor", new HorseArmorItem(11, "sapphire", (new FabricItemSettings()).maxCount(1)));
    public static final Item TURQUOISE_HORSE_ARMOR = registerItem("turquoise_horse_armor", new HorseArmorItem(12, "turquoise", (new FabricItemSettings()).maxCount(1)));
    public static final Item MOISSANITE_HORSE_ARMOR = registerItem("moissanite_horse_armor", new HorseArmorItem(13, "moissanite", (new FabricItemSettings()).maxCount(1)));
    public static final Item ONYX_HORSE_ARMOR = registerItem("onyx_horse_armor", new HorseArmorItem(14, "onyx", (new FabricItemSettings()).maxCount(1)));
    public static final Item GRAPHENE_HORSE_ARMOR = registerItem("graphene_horse_armor", new HorseArmorItem(16, "graphene", (new FabricItemSettings()).maxCount(1)));
    public static final Item NETHERITE_HORSE_ARMOR = registerItem("netherite_horse_armor", new HorseArmorItem(15, "netherite", (new FabricItemSettings()).maxCount(1)));


    //All armor
    public static final Item TIN_HELMET = registerItem("tin_helmet", new ModArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item TIN_CHESTPLATE = registerItem("tin_chestplate", new ModArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item TIN_LEGGINGS = registerItem("tin_leggings", new ModArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item TIN_BOOTS = registerItem("tin_boots", new ModArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item COPPER_HELMET = registerItem("copper_helmet", new ModArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", new ModArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings", new ModArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item COPPER_BOOTS = registerItem("copper_boots", new ModArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item SILVER_HELMET = registerItem("silver_helmet", new ModArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item SILVER_CHESTPLATE = registerItem("silver_chestplate", new ModArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item SILVER_LEGGINGS = registerItem("silver_leggings", new ModArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item SILVER_BOOTS = registerItem("silver_boots", new ModArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item BRONZE_HELMET = registerItem("bronze_helmet", new ModArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item BRONZE_CHESTPLATE = registerItem("bronze_chestplate", new ModArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item BRONZE_LEGGINGS = registerItem("bronze_leggings", new ModArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item BRONZE_BOOTS = registerItem("bronze_boots", new ModArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item STERLING_HELMET = registerItem("sterling_helmet", new ModArmorItem(ModArmorMaterials.STERLING, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item STERLING_CHESTPLATE = registerItem("sterling_chestplate", new ModArmorItem(ModArmorMaterials.STERLING, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item STERLING_LEGGINGS = registerItem("sterling_leggings", new ModArmorItem(ModArmorMaterials.STERLING, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item STERLING_BOOTS = registerItem("sterling_boots", new ModArmorItem(ModArmorMaterials.STERLING, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item OBSIDIAN_HELMET = registerItem("obsidian_helmet", new ModArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item OBSIDIAN_CHESTPLATE = registerItem("obsidian_chestplate", new ModArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item OBSIDIAN_LEGGINGS = registerItem("obsidian_leggings", new ModArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item OBSIDIAN_BOOTS = registerItem("obsidian_boots", new ModArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item COBALT_HELMET = registerItem("cobalt_helmet", new ModArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item COBALT_CHESTPLATE = registerItem("cobalt_chestplate", new ModArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item COBALT_LEGGINGS = registerItem("cobalt_leggings", new ModArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item COBALT_BOOTS = registerItem("cobalt_boots", new ModArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item STEEL_HELMET = registerItem("steel_helmet", new ModArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item STEEL_CHESTPLATE = registerItem("steel_chestplate", new ModArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item STEEL_LEGGINGS = registerItem("steel_leggings", new ModArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item STEEL_BOOTS = registerItem("steel_boots", new ModArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item AMETHYST_HELMET = registerItem("amethyst_helmet", new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item AMETHYST_CHESTPLATE = registerItem("amethyst_chestplate", new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item AMETHYST_LEGGINGS = registerItem("amethyst_leggings", new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item AMETHYST_BOOTS = registerItem("amethyst_boots", new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item EMERALD_HELMET = registerItem("emerald_helmet", new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item EMERALD_CHESTPLATE = registerItem("emerald_chestplate", new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item EMERALD_LEGGINGS = registerItem("emerald_leggings", new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item EMERALD_BOOTS = registerItem("emerald_boots", new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item TOPAZ_HELMET = registerItem("topaz_helmet", new ModArmorItem(ModArmorMaterials.TOPAZ, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item TOPAZ_CHESTPLATE = registerItem("topaz_chestplate", new ModArmorItem(ModArmorMaterials.TOPAZ, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item TOPAZ_LEGGINGS = registerItem("topaz_leggings", new ModArmorItem(ModArmorMaterials.TOPAZ, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item TOPAZ_BOOTS = registerItem("topaz_boots", new ModArmorItem(ModArmorMaterials.TOPAZ, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item TOURMALINE_HELMET = registerItem("tourmaline_helmet", new ModArmorItem(ModArmorMaterials.TOURMALINE, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item TOURMALINE_CHESTPLATE = registerItem("tourmaline_chestplate", new ModArmorItem(ModArmorMaterials.TOURMALINE, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item TOURMALINE_LEGGINGS = registerItem("tourmaline_leggings", new ModArmorItem(ModArmorMaterials.TOURMALINE, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item TOURMALINE_BOOTS = registerItem("tourmaline_boots", new ModArmorItem(ModArmorMaterials.TOURMALINE, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item TANZANITE_HELMET = registerItem("tanzanite_helmet", new ModArmorItem(ModArmorMaterials.TANZANITE, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item TANZANITE_CHESTPLATE = registerItem("tanzanite_chestplate", new ModArmorItem(ModArmorMaterials.TANZANITE, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item TANZANITE_LEGGINGS = registerItem("tanzanite_leggings", new ModArmorItem(ModArmorMaterials.TANZANITE, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item TANZANITE_BOOTS = registerItem("tanzanite_boots", new ModArmorItem(ModArmorMaterials.TANZANITE, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet", new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate", new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings", new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots", new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item SAPPHIRE_HELMET = registerItem("sapphire_helmet", new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item SAPPHIRE_CHESTPLATE = registerItem("sapphire_chestplate", new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item SAPPHIRE_LEGGINGS = registerItem("sapphire_leggings", new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item SAPPHIRE_BOOTS = registerItem("sapphire_boots", new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item TURQUOISE_HELMET = registerItem("turquoise_helmet", new ModArmorItem(ModArmorMaterials.TURQUOISE, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item TURQUOISE_CHESTPLATE = registerItem("turquoise_chestplate", new ModArmorItem(ModArmorMaterials.TURQUOISE, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item TURQUOISE_LEGGINGS = registerItem("turquoise_leggings", new ModArmorItem(ModArmorMaterials.TURQUOISE, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item TURQUOISE_BOOTS = registerItem("turquoise_boots", new ModArmorItem(ModArmorMaterials.TURQUOISE, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item MOISSANITE_HELMET = registerItem("moissanite_helmet", new ModArmorItem(ModArmorMaterials.MOISSANITE, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item MOISSANITE_CHESTPLATE = registerItem("moissanite_chestplate", new ModArmorItem(ModArmorMaterials.MOISSANITE, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item MOISSANITE_LEGGINGS = registerItem("moissanite_leggings", new ModArmorItem(ModArmorMaterials.MOISSANITE, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item MOISSANITE_BOOTS = registerItem("moissanite_boots", new ModArmorItem(ModArmorMaterials.MOISSANITE, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item ONYX_HELMET = registerItem("onyx_helmet", new ModArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item ONYX_CHESTPLATE = registerItem("onyx_chestplate", new ModArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item ONYX_LEGGINGS = registerItem("onyx_leggings", new ModArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item ONYX_BOOTS = registerItem("onyx_boots", new ModArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.BOOTS, (new FabricItemSettings())));

    public static final Item GRAPHENE_HELMET = registerItem("graphene_helmet", new ModArmorItem(ModArmorMaterials.GRAPHENE, ArmorItem.Type.HELMET, (new FabricItemSettings())));
    public static final Item GRAPHENE_CHESTPLATE = registerItem("graphene_chestplate", new ModArmorItem(ModArmorMaterials.GRAPHENE, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));
    public static final Item GRAPHENE_LEGGINGS = registerItem("graphene_leggings", new ModArmorItem(ModArmorMaterials.GRAPHENE, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));
    public static final Item GRAPHENE_BOOTS = registerItem("graphene_boots", new ModArmorItem(ModArmorMaterials.GRAPHENE, ArmorItem.Type.BOOTS, (new FabricItemSettings())));


    //All swords
    //p_i48460_2_: Attack Damage (1 = 1 Attack Point)
    //p_i48460_3_: Attack Speed (1.0F = ... Attack Speed)
    public static final Item TIN_SWORD = registerItem("tin_sword", new ModSwordItem(ModToolMaterials.TIN, 3, -2.4F, new FabricItemSettings()));
    public static final Item COPPER_SWORD = registerItem("copper_sword", new ModSwordItem(ModToolMaterials.COPPER, 3, -2.4F, new FabricItemSettings()));

    public static final Item SILVER_SWORD = registerItem("silver_sword", new ModSwordItem(ModToolMaterials.SILVER, 3, -2.4F, new FabricItemSettings()));

    public static final Item BRONZE_SWORD = registerItem("bronze_sword", new ModSwordItem(ModToolMaterials.BRONZE, 3, -2.4F, new FabricItemSettings()));

    public static final Item OBSIDIAN_SWORD = registerItem("obsidian_sword", new ModSwordItem(ModToolMaterials.OBSIDIAN, 3, -2.4F, new FabricItemSettings()));
    public static final Item COBALT_SWORD = registerItem("cobalt_sword", new ModSwordItem(ModToolMaterials.COBALT, 3, -2.4F, new FabricItemSettings()));
    public static final Item STEEL_SWORD = registerItem("steel_sword", new ModSwordItem(ModToolMaterials.STEEL, 3, -2.4F, new FabricItemSettings()));
    public static final Item STERLING_SWORD = registerItem("sterling_sword", new ModSwordItem(ModToolMaterials.STERLING, 3, -2.4F, new FabricItemSettings()));

    public static final Item AMETHYST_SWORD = registerItem("amethyst_sword", new ModSwordItem(ModToolMaterials.AMETHYST, 3, -2.4F, new FabricItemSettings()));
    public static final Item EMERALD_SWORD = registerItem("emerald_sword", new ModSwordItem(ModToolMaterials.EMERALD, 3, -2.4F, new FabricItemSettings()));

    public static final Item TOPAZ_SWORD = registerItem("topaz_sword", new ModSwordItem(ModToolMaterials.TOPAZ, 3, -2.4F, new FabricItemSettings()));
    public static final Item TOURMALINE_SWORD = registerItem("tourmaline_sword", new ModSwordItem(ModToolMaterials.TOURMALINE, 3, -2.4F, new FabricItemSettings()));
    public static final Item TANZANITE_SWORD = registerItem("tanzanite_sword", new ModSwordItem(ModToolMaterials.TANZANITE, 3, -2.4F, new FabricItemSettings()));

    public static final Item RUBY_SWORD = registerItem("ruby_sword", new ModSwordItem(ModToolMaterials.RUBY, 3, -2.4F, new FabricItemSettings()));
    public static final Item SAPPHIRE_SWORD = registerItem("sapphire_sword", new ModSwordItem(ModToolMaterials.SAPPHIRE, 3, -2.4F, new FabricItemSettings()));
    public static final Item TURQUOISE_SWORD = registerItem("turquoise_sword", new ModSwordItem(ModToolMaterials.TURQUOISE, 3, -2.4F, new FabricItemSettings()));

    public static final Item MOISSANITE_SWORD = registerItem("moissanite_sword", new ModSwordItem(ModToolMaterials.MOISSANITE, 3, -2.4F, new FabricItemSettings()));
    public static final Item ONYX_SWORD = registerItem("onyx_sword", new ModSwordItem(ModToolMaterials.ONYX, 3, -2.4F, new FabricItemSettings()));

    public static final Item GRAPHENE_SWORD = registerItem("graphene_sword", new ModSwordItem(ModToolMaterials.GRAPHENE, 3, -2.4F, new FabricItemSettings()));

    //All battleaxes
    //p_i48460_2_: Attack Damage (1 = 1 Attack Point)
    //p_i48460_3_: Attack Speed (1.0F = ... Attack Speed)
    public static final Item WOOD_BATTLEAXE = registerItem("wood_battleaxe", new ModBattleAxeItem(ToolMaterials.WOOD, 5, -2.8F, new FabricItemSettings()));
    public static final Item STONE_BATTLEAXE = registerItem("stone_battleaxe", new ModBattleAxeItem(ToolMaterials.STONE, 5, -2.8F, new FabricItemSettings()));
    public static final Item IRON_BATTLEAXE = registerItem("iron_battleaxe", new ModBattleAxeItem(ToolMaterials.IRON, 5, -2.8F, new FabricItemSettings()));
    public static final Item GOLD_BATTLEAXE = registerItem("gold_battleaxe", new ModBattleAxeItem(ToolMaterials.GOLD, 5, -2.8F, new FabricItemSettings()));
    public static final Item DIAMOND_BATTLEAXE = registerItem("diamond_battleaxe", new ModBattleAxeItem(ToolMaterials.DIAMOND, 5, -2.8F, new FabricItemSettings()));
    public static final Item NETHERITE_BATTLEAXE = registerItem("netherite_battleaxe", new ModBattleAxeItem(ToolMaterials.NETHERITE, 5, -2.8F, new FabricItemSettings()));

    public static final Item TIN_BATTLEAXE = registerItem("tin_battleaxe", new ModBattleAxeItem(ModToolMaterials.TIN, 5, -2.8F, new FabricItemSettings()));
    public static final Item COPPER_BATTLEAXE = registerItem("copper_battleaxe", new ModBattleAxeItem(ModToolMaterials.COPPER, 5, -2.8F, new FabricItemSettings()));

    public static final Item SILVER_BATTLEAXE = registerItem("silver_battleaxe", new ModBattleAxeItem(ModToolMaterials.SILVER, 5, -2.8F, new FabricItemSettings()));

    public static final Item BRONZE_BATTLEAXE = registerItem("bronze_battleaxe", new ModBattleAxeItem(ModToolMaterials.BRONZE, 5, -2.8F, new FabricItemSettings()));

    public static final Item OBSIDIAN_BATTLEAXE = registerItem("obsidian_battleaxe", new ModBattleAxeItem(ModToolMaterials.OBSIDIAN, 5, -2.7F, new FabricItemSettings()));
    public static final Item COBALT_BATTLEAXE = registerItem("cobalt_battleaxe", new ModBattleAxeItem(ModToolMaterials.COBALT, 5, -2.7F, new FabricItemSettings()));
    public static final Item STEEL_BATTLEAXE = registerItem("steel_battleaxe", new ModBattleAxeItem(ModToolMaterials.STEEL, 5, -2.7F, new FabricItemSettings()));
    public static final Item STERLING_BATTLEAXE = registerItem("sterling_battleaxe", new ModBattleAxeItem(ModToolMaterials.STERLING, 5, -2.7F, new FabricItemSettings()));

    public static final Item AMETHYST_BATTLEAXE = registerItem("amethyst_battleaxe", new ModBattleAxeItem(ModToolMaterials.AMETHYST, 5, -2.7F, new FabricItemSettings()));
    public static final Item EMERALD_BATTLEAXE = registerItem("emerald_battleaxe", new ModBattleAxeItem(ModToolMaterials.EMERALD, 5, -2.7F, new FabricItemSettings()));

    public static final Item TOPAZ_BATTLEAXE = registerItem("topaz_battleaxe", new ModBattleAxeItem(ModToolMaterials.TOPAZ, 5, -2.6F, new FabricItemSettings()));
    public static final Item TOURMALINE_BATTLEAXE = registerItem("tourmaline_battleaxe", new ModBattleAxeItem(ModToolMaterials.TOURMALINE, 5, -2.6F, new FabricItemSettings()));
    public static final Item TANZANITE_BATTLEAXE = registerItem("tanzanite_battleaxe", new ModBattleAxeItem(ModToolMaterials.TANZANITE, 5, -2.6F, new FabricItemSettings()));

    public static final Item RUBY_BATTLEAXE = registerItem("ruby_battleaxe", new ModBattleAxeItem(ModToolMaterials.RUBY, 5, -2.6F, new FabricItemSettings()));
    public static final Item SAPPHIRE_BATTLEAXE = registerItem("sapphire_battleaxe", new ModBattleAxeItem(ModToolMaterials.SAPPHIRE, 5, -2.6F, new FabricItemSettings()));
    public static final Item TURQUOISE_BATTLEAXE = registerItem("turquoise_battleaxe", new ModBattleAxeItem(ModToolMaterials.TURQUOISE, 5, -2.6F, new FabricItemSettings()));

    public static final Item MOISSANITE_BATTLEAXE = registerItem("moissanite_battleaxe", new ModBattleAxeItem(ModToolMaterials.MOISSANITE, 5, -2.6F, new FabricItemSettings()));
    public static final Item ONYX_BATTLEAXE = registerItem("onyx_battleaxe", new ModBattleAxeItem(ModToolMaterials.ONYX, 5, -2.6F, new FabricItemSettings()));

    public static final Item GRAPHENE_BATTLEAXE = registerItem("graphene_battleaxe", new ModBattleAxeItem(ModToolMaterials.GRAPHENE, 5, -2.6F, new FabricItemSettings()));


    //All maces
    //p_i48460_2_: Attack Damage (1 = 1 Attack Point)
    //p_i48460_3_: Attack Speed (1.0F = ... Attack Speed)
    //TODO Check attack values
    public static final Item WOOD_MACE = registerItem("wood_mace", new ModSwordItem(ToolMaterials.WOOD, 3, -2.2F, new FabricItemSettings()));
    public static final Item STONE_MACE = registerItem("stone_mace", new ModSwordItem(ToolMaterials.STONE, 3, -2.2F, new FabricItemSettings()));
    public static final Item IRON_MACE = registerItem("iron_mace", new ModSwordItem(ToolMaterials.IRON, 3, -2.2F, new FabricItemSettings()));
    public static final Item GOLD_MACE = registerItem("gold_mace", new ModSwordItem(ToolMaterials.GOLD, 3, -2.2F, new FabricItemSettings()));
    public static final Item DIAMOND_MACE = registerItem("diamond_mace", new ModSwordItem(ToolMaterials.DIAMOND, 3, -2.1F, new FabricItemSettings()));
    public static final Item NETHERITE_MACE = registerItem("netherite_mace", new ModSwordItem(ToolMaterials.NETHERITE, 3, -2.0F, new FabricItemSettings()));

    public static final Item TIN_MACE = registerItem("tin_mace", new ModSwordItem(ModToolMaterials.TIN, 3, -2.2F, new FabricItemSettings()));
    public static final Item COPPER_MACE = registerItem("copper_mace", new ModSwordItem(ModToolMaterials.COPPER, 3, -2.2F, new FabricItemSettings()));

    public static final Item SILVER_MACE = registerItem("silver_mace", new ModSwordItem(ModToolMaterials.SILVER, 3, -2.2F, new FabricItemSettings()));

    public static final Item BRONZE_MACE = registerItem("bronze_mace", new ModSwordItem(ModToolMaterials.BRONZE, 3, -2.2F, new FabricItemSettings()));

    public static final Item OBSIDIAN_MACE = registerItem("obsidian_mace", new ModSwordItem(ModToolMaterials.OBSIDIAN, 3, -2.1F, new FabricItemSettings()));
    public static final Item COBALT_MACE = registerItem("cobalt_mace", new ModSwordItem(ModToolMaterials.COBALT, 3, -2.1F, new FabricItemSettings()));
    public static final Item STEEL_MACE = registerItem("steel_mace", new ModSwordItem(ModToolMaterials.STEEL, 3, -2.1F, new FabricItemSettings()));
    public static final Item STERLING_MACE = registerItem("sterling_mace", new ModSwordItem(ModToolMaterials.STERLING, 3, -2.1F, new FabricItemSettings()));

    public static final Item AMETHYST_MACE = registerItem("amethyst_mace", new ModSwordItem(ModToolMaterials.AMETHYST, 3, -2.1F, new FabricItemSettings()));
    public static final Item EMERALD_MACE = registerItem("emerald_mace", new ModSwordItem(ModToolMaterials.EMERALD, 3, -2.1F, new FabricItemSettings()));

    public static final Item TOPAZ_MACE = registerItem("topaz_mace", new ModSwordItem(ModToolMaterials.TOPAZ, 3, -2.0F, new FabricItemSettings()));
    public static final Item TOURMALINE_MACE = registerItem("tourmaline_mace", new ModSwordItem(ModToolMaterials.TOURMALINE, 3, -2.0F, new FabricItemSettings()));
    public static final Item TANZANITE_MACE = registerItem("tanzanite_mace", new ModSwordItem(ModToolMaterials.TANZANITE, 3, -2.0F, new FabricItemSettings()));

    public static final Item RUBY_MACE = registerItem("ruby_mace", new ModSwordItem(ModToolMaterials.RUBY, 3, -2.0F, new FabricItemSettings()));
    public static final Item SAPPHIRE_MACE = registerItem("sapphire_mace", new ModSwordItem(ModToolMaterials.SAPPHIRE, 3, -2.0F, new FabricItemSettings()));
    public static final Item TURQUOISE_MACE = registerItem("turquoise_mace", new ModSwordItem(ModToolMaterials.TURQUOISE, 3, -2.0F, new FabricItemSettings()));

    public static final Item MOISSANITE_MACE = registerItem("moissanite_mace", new ModSwordItem(ModToolMaterials.MOISSANITE, 3, -2.0F, new FabricItemSettings()));
    public static final Item ONYX_MACE = registerItem("onyx_mace", new ModSwordItem(ModToolMaterials.ONYX, 3, -2.0F, new FabricItemSettings()));

    public static final Item GRAPHENE_MACE = registerItem("graphene_mace", new ModSwordItem(ModToolMaterials.GRAPHENE, 3, -1.8F, new FabricItemSettings()));


    //All daggers
    //p_i48460_2_: Attack Damage (1 = 1 Attack Point)
    //p_i48460_3_: Attack Speed (1.0F = ... Attack Speed)
    public static final Item WOOD_DAGGER = registerItem("wood_dagger", new ModSwordItem(ToolMaterials.WOOD, 1, -1.8F, new FabricItemSettings()));
    public static final Item STONE_DAGGER = registerItem("stone_dagger", new ModSwordItem(ToolMaterials.STONE, 1, -1.8F, new FabricItemSettings()));
    public static final Item IRON_DAGGER = registerItem("iron_dagger", new ModSwordItem(ToolMaterials.IRON, 1, -1.8F, new FabricItemSettings()));
    public static final Item GOLD_DAGGER = registerItem("gold_dagger", new ModSwordItem(ToolMaterials.GOLD, 1, -1.8F, new FabricItemSettings()));
    public static final Item DIAMOND_DAGGER = registerItem("diamond_dagger", new ModSwordItem(ToolMaterials.DIAMOND, 1, -1.7F, new FabricItemSettings()));
    public static final Item NETHERITE_DAGGER = registerItem("netherite_dagger", new ModSwordItem(ToolMaterials.NETHERITE, 1, -1.5F, new FabricItemSettings()));

    public static final Item TIN_DAGGER = registerItem("tin_dagger", new ModSwordItem(ModToolMaterials.TIN, 1, -1.8F, new FabricItemSettings()));
    public static final Item COPPER_DAGGER = registerItem("copper_dagger", new ModSwordItem(ModToolMaterials.COPPER, 1, -1.8F, new FabricItemSettings()));

    public static final Item SILVER_DAGGER = registerItem("silver_dagger", new ModSwordItem(ModToolMaterials.SILVER, 1, -1.8F, new FabricItemSettings()));

    public static final Item BRONZE_DAGGER = registerItem("bronze_dagger", new ModSwordItem(ModToolMaterials.BRONZE, 1, -1.8F, new FabricItemSettings()));

    public static final Item OBSIDIAN_DAGGER = registerItem("obsidian_dagger", new ModSwordItem(ModToolMaterials.OBSIDIAN, 1, -1.8F, new FabricItemSettings()));
    public static final Item COBALT_DAGGER = registerItem("cobalt_dagger", new ModSwordItem(ModToolMaterials.COBALT, 1, -1.8F, new FabricItemSettings()));
    public static final Item STEEL_DAGGER = registerItem("steel_dagger", new ModSwordItem(ModToolMaterials.STEEL, 1, -1.8F, new FabricItemSettings()));
    public static final Item STERLING_DAGGER = registerItem("sterling_dagger", new ModSwordItem(ModToolMaterials.STERLING, 1, -1.8F, new FabricItemSettings()));

    public static final Item AMETHYST_DAGGER = registerItem("amethyst_dagger", new ModSwordItem(ModToolMaterials.AMETHYST, 1, -1.8F, new FabricItemSettings()));
    public static final Item EMERALD_DAGGER = registerItem("emerald_dagger", new ModSwordItem(ModToolMaterials.EMERALD, 1, -1.8F, new FabricItemSettings()));

    public static final Item TOPAZ_DAGGER = registerItem("topaz_dagger", new ModSwordItem(ModToolMaterials.TOPAZ, 1, -1.7F, new FabricItemSettings()));
    public static final Item TOURMALINE_DAGGER = registerItem("tourmaline_dagger", new ModSwordItem(ModToolMaterials.TOURMALINE, 1, -1.7F, new FabricItemSettings()));
    public static final Item TANZANITE_DAGGER = registerItem("tanzanite_dagger", new ModSwordItem(ModToolMaterials.TANZANITE, 1, -1.7F, new FabricItemSettings()));

    public static final Item RUBY_DAGGER = registerItem("ruby_dagger", new ModSwordItem(ModToolMaterials.RUBY, 1, -1.7F, new FabricItemSettings()));
    public static final Item SAPPHIRE_DAGGER = registerItem("sapphire_dagger", new ModSwordItem(ModToolMaterials.SAPPHIRE, 1, -1.7F, new FabricItemSettings()));
    public static final Item TURQUOISE_DAGGER = registerItem("turquoise_dagger", new ModSwordItem(ModToolMaterials.TURQUOISE, 1, -1.7F, new FabricItemSettings()));

    public static final Item MOISSANITE_DAGGER = registerItem("moissanite_dagger", new ModSwordItem(ModToolMaterials.MOISSANITE, 1, -1.7F, new FabricItemSettings()));
    public static final Item ONYX_DAGGER = registerItem("onyx_dagger", new ModSwordItem(ModToolMaterials.ONYX, 1, -1.6F, new FabricItemSettings()));

    public static final Item GRAPHENE_DAGGER = registerItem("graphene_dagger", new ModSwordItem(ModToolMaterials.GRAPHENE, 1, -1.5F, new FabricItemSettings()));


    // All pickaxes
    public static final Item TIN_PICKAXE = registerItem("tin_pickaxe", new PickaxeItem(ModToolMaterials.TIN, 1, -2.8F, new FabricItemSettings()));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", new PickaxeItem(ModToolMaterials.COPPER, 1, -2.8F, new FabricItemSettings()));

    public static final Item SILVER_PICKAXE = registerItem("silver_pickaxe", new PickaxeItem(ModToolMaterials.SILVER, 1, -2.8F, new FabricItemSettings()));

    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe", new PickaxeItem(ModToolMaterials.BRONZE, 1, -2.8F, new FabricItemSettings()));

    public static final Item OBSIDIAN_PICKAXE = registerItem("obsidian_pickaxe", new PickaxeItem(ModToolMaterials.OBSIDIAN, 1, -2.8F, new FabricItemSettings()));
    public static final Item COBALT_PICKAXE = registerItem("cobalt_pickaxe", new PickaxeItem(ModToolMaterials.COBALT, 1, -2.8F, new FabricItemSettings()));
    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe", new PickaxeItem(ModToolMaterials.STEEL, 1, -2.8F, new FabricItemSettings()));
    public static final Item STERLING_PICKAXE = registerItem("sterling_pickaxe", new PickaxeItem(ModToolMaterials.STERLING, 1, -2.8F, new FabricItemSettings()));

    public static final Item AMETHYST_PICKAXE = registerItem("amethyst_pickaxe", new PickaxeItem(ModToolMaterials.AMETHYST, 1, -2.8F, new FabricItemSettings()));
    public static final Item EMERALD_PICKAXE = registerItem("emerald_pickaxe", new PickaxeItem(ModToolMaterials.EMERALD, 1, -2.8F, new FabricItemSettings()));

    public static final Item TOPAZ_PICKAXE = registerItem("topaz_pickaxe", new PickaxeItem(ModToolMaterials.TOPAZ, 1, -2.8F, new FabricItemSettings()));
    public static final Item TOURMALINE_PICKAXE = registerItem("tourmaline_pickaxe", new PickaxeItem(ModToolMaterials.TOURMALINE, 1, -2.8F, new FabricItemSettings()));
    public static final Item TANZANITE_PICKAXE = registerItem("tanzanite_pickaxe", new PickaxeItem(ModToolMaterials.TANZANITE, 1, -2.8F, new FabricItemSettings()));

    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(ModToolMaterials.RUBY, 1, -2.8F, new FabricItemSettings()));
    public static final Item SAPPHIRE_PICKAXE = registerItem("sapphire_pickaxe", new PickaxeItem(ModToolMaterials.SAPPHIRE, 1, -2.8F, new FabricItemSettings()));
    public static final Item TURQUOISE_PICKAXE = registerItem("turquoise_pickaxe", new PickaxeItem(ModToolMaterials.TURQUOISE, 1, -2.8F, new FabricItemSettings()));

    public static final Item MOISSANITE_PICKAXE = registerItem("moissanite_pickaxe", new PickaxeItem(ModToolMaterials.MOISSANITE, 3, -2.8F, new FabricItemSettings()));
    public static final Item ONYX_PICKAXE = registerItem("onyx_pickaxe", new PickaxeItem(ModToolMaterials.ONYX, 1, -2.8F, new FabricItemSettings()));

    public static final Item GRAPHENE_PICKAXE = registerItem("graphene_pickaxe", new PickaxeItem(ModToolMaterials.GRAPHENE, 1, -2.8F, new FabricItemSettings()));


    //All axes
    //TODO Checkout items for proper atk dmg and speed values
    public static final Item TIN_AXE = registerItem("tin_axe", new AxeItem(ModToolMaterials.TIN, 6.0F, -3.2F, new FabricItemSettings()));
    public static final Item COPPER_AXE = registerItem("copper_axe", new AxeItem(ModToolMaterials.COPPER, 6.0F, -3.2F, new FabricItemSettings()));

    public static final Item SILVER_AXE = registerItem("silver_axe", new AxeItem(ModToolMaterials.SILVER, 6.0F, -3.2F, new FabricItemSettings()));

    public static final Item BRONZE_AXE = registerItem("bronze_axe", new AxeItem(ModToolMaterials.BRONZE, 6.0F, -3.2F, new FabricItemSettings()));

    public static final Item OBSIDIAN_AXE = registerItem("obsidian_axe", new AxeItem(ModToolMaterials.OBSIDIAN, 6.0F, -3.2F, new FabricItemSettings()));
    public static final Item COBALT_AXE = registerItem("cobalt_axe", new AxeItem(ModToolMaterials.COBALT, 6.0F, -3.2F, new FabricItemSettings()));
    public static final Item STEEL_AXE = registerItem("steel_axe", new AxeItem(ModToolMaterials.STEEL, 6.0F, -3.2F, new FabricItemSettings()));
    public static final Item STERLING_AXE = registerItem("sterling_axe", new AxeItem(ModToolMaterials.STERLING, 6.0F, -3.2F, new FabricItemSettings()));

    public static final Item AMETHYST_AXE = registerItem("amethyst_axe", new AxeItem(ModToolMaterials.AMETHYST, 6.0F, -3.2F, new FabricItemSettings()));
    public static final Item EMERALD_AXE = registerItem("emerald_axe", new AxeItem(ModToolMaterials.EMERALD, 6.0F, -3.2F, new FabricItemSettings()));

    public static final Item TOPAZ_AXE = registerItem("topaz_axe", new AxeItem(ModToolMaterials.TOPAZ, 6.0F, -3.2F, new FabricItemSettings()));
    public static final Item TOURMALINE_AXE = registerItem("tourmaline_axe", new AxeItem(ModToolMaterials.TOURMALINE, 6.0F, -3.2F, new FabricItemSettings()));
    public static final Item TANZANITE_AXE = registerItem("tanzanite_axe", new AxeItem(ModToolMaterials.TANZANITE, 6.0F, -3.2F, new FabricItemSettings()));

    public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(ModToolMaterials.RUBY, 6.0F, -3.2F, new FabricItemSettings()));
    public static final Item SAPPHIRE_AXE = registerItem("sapphire_axe", new AxeItem(ModToolMaterials.SAPPHIRE, 6.0F, -3.2F, new FabricItemSettings()));
    public static final Item TURQUOISE_AXE = registerItem("turquoise_axe", new AxeItem(ModToolMaterials.TURQUOISE, 6.0F, -3.2F, new FabricItemSettings()));

    public static final Item MOISSANITE_AXE = registerItem("moissanite_axe", new AxeItem(ModToolMaterials.MOISSANITE, 6.0F, -3.2F, new FabricItemSettings()));
    public static final Item ONYX_AXE = registerItem("onyx_axe", new AxeItem(ModToolMaterials.ONYX, 6.0F, -3.2F, new FabricItemSettings()));

    public static final Item GRAPHENE_AXE = registerItem("graphene_axe", new AxeItem(ModToolMaterials.GRAPHENE, 6.0F, -3.2F, new FabricItemSettings()));


    //All shovels
    public static final Item TIN_SHOVEL = registerItem("tin_shovel", new ShovelItem(ModToolMaterials.TIN, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel", new ShovelItem(ModToolMaterials.TIN, 1.5F, -3.0F, new FabricItemSettings()));

    public static final Item SILVER_SHOVEL = registerItem("silver_shovel", new ShovelItem(ModToolMaterials.SILVER, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item BRONZE_SHOVEL = registerItem("bronze_shovel", new ShovelItem(ModToolMaterials.BRONZE, 1.5F, -3.0F, new FabricItemSettings()));

    public static final Item OBSIDIAN_SHOVEL = registerItem("obsidian_shovel", new ShovelItem(ModToolMaterials.OBSIDIAN, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item COBALT_SHOVEL = registerItem("cobalt_shovel", new ShovelItem(ModToolMaterials.COBALT, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item STEEL_SHOVEL = registerItem("steel_shovel", new ShovelItem(ModToolMaterials.STEEL, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item STERLING_SHOVEL = registerItem("sterling_shovel", new ShovelItem(ModToolMaterials.STERLING, 1.5F, -3.0F, new FabricItemSettings()));

    public static final Item AMETHYST_SHOVEL = registerItem("amethyst_shovel", new ShovelItem(ModToolMaterials.AMETHYST, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item EMERALD_SHOVEL = registerItem("emerald_shovel", new ShovelItem(ModToolMaterials.EMERALD, 1.5F, -3.0F, new FabricItemSettings()));

    public static final Item TOPAZ_SHOVEL = registerItem("topaz_shovel", new ShovelItem(ModToolMaterials.TOPAZ, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item TOURMALINE_SHOVEL = registerItem("tourmaline_shovel", new ShovelItem(ModToolMaterials.TOURMALINE, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item TANZANITE_SHOVEL = registerItem("tanzanite_shovel", new ShovelItem(ModToolMaterials.TANZANITE, 1.5F, -3.0F, new FabricItemSettings()));

    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterials.RUBY, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item SAPPHIRE_SHOVEL = registerItem("sapphire_shovel", new ShovelItem(ModToolMaterials.SAPPHIRE, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item TURQUOISE_SHOVEL = registerItem("turquoise_shovel", new ShovelItem(ModToolMaterials.TURQUOISE, 1.5F, -3.0F, new FabricItemSettings()));

    public static final Item MOISSANITE_SHOVEL = registerItem("moissanite_shovel", new ShovelItem(ModToolMaterials.MOISSANITE, 1.5F, -3.0F, new FabricItemSettings()));
    public static final Item ONYX_SHOVEL = registerItem("onyx_shovel", new ShovelItem(ModToolMaterials.ONYX, 1.5F, -3.0F, new FabricItemSettings()));

    public static final Item GRAPHENE_SHOVEL = registerItem("graphene_shovel", new ShovelItem(ModToolMaterials.GRAPHENE, 1.5F, -3.0F, new FabricItemSettings()));


    //All hoes
    public static final Item TIN_HOE = registerItem("tin_hoe", new HoeItem(ModToolMaterials.TIN, 0, -3.0F, new FabricItemSettings()));
    public static final Item COPPER_HOE = registerItem("copper_hoe", new HoeItem(ModToolMaterials.COPPER, 0, -3.0F, new FabricItemSettings()));

    public static final Item SILVER_HOE = registerItem("silver_hoe", new HoeItem(ModToolMaterials.SILVER, 0, -3.0F, new FabricItemSettings()));
    public static final Item BRONZE_HOE = registerItem("bronze_hoe", new HoeItem(ModToolMaterials.BRONZE, 0, -3.0F, new FabricItemSettings()));

    public static final Item OBSIDIAN_HOE = registerItem("obsidian_hoe", new HoeItem(ModToolMaterials.OBSIDIAN, 0, -3.0F, new FabricItemSettings()));
    public static final Item COBALT_HOE = registerItem("cobalt_hoe", new HoeItem(ModToolMaterials.COBALT, 0, -3.0F, new FabricItemSettings()));
    public static final Item STEEL_HOE = registerItem("steel_hoe", new HoeItem(ModToolMaterials.STEEL, 0, -3.0F, new FabricItemSettings()));
    public static final Item STERLING_HOE = registerItem("sterling_hoe", new HoeItem(ModToolMaterials.STERLING, 0, -3.0F, new FabricItemSettings()));

    public static final Item AMETHYST_HOE = registerItem("amethyst_hoe", new HoeItem(ModToolMaterials.AMETHYST, 0, -3.0F, new FabricItemSettings()));
    public static final Item EMERALD_HOE = registerItem("emerald_hoe", new HoeItem(ModToolMaterials.EMERALD, 0, -3.0F, new FabricItemSettings()));

    public static final Item TOPAZ_HOE = registerItem("topaz_hoe", new HoeItem(ModToolMaterials.TOPAZ, 0, -3.0F, new FabricItemSettings()));
    public static final Item TOURMALINE_HOE = registerItem("tourmaline_hoe", new HoeItem(ModToolMaterials.TOURMALINE, 0, -3.0F, new FabricItemSettings()));
    public static final Item TANZANITE_HOE = registerItem("tanzanite_hoe", new HoeItem(ModToolMaterials.TANZANITE, 0, -3.0F, new FabricItemSettings()));

    public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(ModToolMaterials.RUBY, 0, -3.0F, new FabricItemSettings()));
    public static final Item SAPPHIRE_HOE = registerItem("sapphire_hoe", new HoeItem(ModToolMaterials.SAPPHIRE, 0, -3.0F, new FabricItemSettings()));
    public static final Item TURQUOISE_HOE = registerItem("turquoise_hoe", new HoeItem(ModToolMaterials.TURQUOISE, 0, -3.0F, new FabricItemSettings()));

    public static final Item MOISSANITE_HOE = registerItem("moissanite_hoe", new HoeItem(ModToolMaterials.MOISSANITE, 0, -3.0F, new FabricItemSettings()));
    public static final Item ONYX_HOE = registerItem("onyx_hoe", new HoeItem(ModToolMaterials.ONYX, 0, -3.0F, new FabricItemSettings()));

    public static final Item GRAPHENE_HOE = registerItem("graphene_hoe", new HoeItem(ModToolMaterials.GRAPHENE, 0, -3.0F, new FabricItemSettings()));


    //Vanilla tools
    //W.I.P.


    //Shields
//    public static final Item TIN_SHIELD = registerItem("tin_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(84), 10, 5, ModItems.TIN_INGOT)); // FabricShieldItem(maxDamage(durability), cooldownTicks, enchantability, repairItems)
//    public static final Item COPPER_SHIELD = registerItem("copper_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(112), 10, 10, Items.COPPER_INGOT));
//    public static final Item SILVER_SHIELD = registerItem("silver_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(134), 10, 15, ModItems.SILVER_INGOT));
//    public static final Item BRONZE_SHIELD = registerItem("bronze_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(299), 10, 13, ModItems.BRONZE_INGOT));
//    public static final Item COBALT_SHIELD = registerItem("cobalt_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(388), 10, 22, ModItems.COBALT_INGOT));
//    public static final Item STERLING_SHIELD = registerItem("sterling_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(333), 10, 17, ModItems.STERLING_INGOT));
//    public static final Item AMETHYST_SHIELD = registerItem("amethyst_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(420), 10, 15, Items.AMETHYST_SHARD));
//    public static final Item STEEL_SHIELD = registerItem("steel_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(555), 10, 14, ModItems.STEEL_INGOT));
//    public static final Item EMERALD_SHIELD = registerItem("emerald_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(500), 10, 18, Items.EMERALD));
//    public static final Item TOPAZ_SHIELD = registerItem("topaz_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(632), 10, 14, ModItems.TOPAZ_GEM));
//    public static final Item TOURMALINE_SHIELD = registerItem("tourmaline_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(621), 10, 16, ModItems.TOURMALINE_GEM));
//    public static final Item TANZANITE_SHIELD = registerItem("tanzanite_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(784), 10, 11, ModItems.TANZANITE_GEM));
//    public static final Item RUBY_SHIELD = registerItem("ruby_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(809), 10, 15, ModItems.RUBY_GEM));
//    public static final Item SAPPHIRE_SHIELD = registerItem("sapphire_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(711), 10, 18, ModItems.SAPPHIRE_GEM));
//    public static final Item OBSIDIAN_SHIELD = registerItem("obsidian_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(821), 10, 21, ModItems.OBSIDIAN_INGOT));
//    public static final Item TURQUOISE_SHIELD = registerItem("turquoise_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(999), 10, 25, ModItems.TURQUOISE_GEM));
//    public static final Item MOISSANITE_SHIELD = registerItem("moissanite_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(913), 10, 10, ModItems.MOISSANITE_GEM));
//    public static final Item ONYX_SHIELD = registerItem("onyx_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(1111), 10, 13, ModItems.ONYX_GEM));
//    public static final Item GRAPHENE_SHIELD = registerItem("graphene_shield", new FabricShieldItem(new FabricItemSettings().maxDamage(1333), 10, 19, ModItems.GRAPHENE_GEM));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(ANTHRACITE);

        entries.add(RAW_TIN);
        entries.add(RAW_SILVER);
        entries.add(RAW_COBALT);

        entries.add(TIN_INGOT);
        entries.add(SILVER_INGOT);
        entries.add(BRONZE_INGOT);
        entries.add(STERLING_INGOT);
        entries.add(COBALT_INGOT);
        entries.add(STEEL_INGOT);
        entries.add(OBSIDIAN_INGOT);

        entries.add(TOURMALINE_GEM);
        entries.add(TOPAZ_GEM);
        entries.add(TANZANITE_GEM);
        entries.add(RUBY_GEM);
        entries.add(SAPPHIRE_GEM);
        entries.add(MOISSANITE_GEM);
        entries.add(TURQUOISE_GEM);
        entries.add(ONYX_GEM);
        entries.add(GRAPHENE_GEM);
//      entries.add(SWEET_CAROLINE_MUSIC_DISC);
//      entries.add(CIPHER_DISC);
    }
    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(WOOD_BATTLEAXE);
        entries.add(WOOD_MACE);
        entries.add(WOOD_DAGGER);

        entries.add(TIN_SWORD);
        entries.add(TIN_BATTLEAXE);
        entries.add(TIN_MACE);
        entries.add(TIN_DAGGER);

        entries.add(STONE_BATTLEAXE);
        entries.add(STONE_MACE);
        entries.add(STONE_DAGGER);

        entries.add(SILVER_SWORD);
        entries.add(SILVER_BATTLEAXE);
        entries.add(SILVER_MACE);
        entries.add(SILVER_DAGGER);

        entries.add(COPPER_SWORD);
        entries.add(COPPER_BATTLEAXE);
        entries.add(COPPER_MACE);
        entries.add(COPPER_DAGGER);

        entries.add(BRONZE_SWORD);
        entries.add(BRONZE_BATTLEAXE);
        entries.add(BRONZE_MACE);
        entries.add(BRONZE_DAGGER);

        entries.add(GOLD_BATTLEAXE);
        entries.add(GOLD_MACE);
        entries.add(GOLD_DAGGER);

        entries.add(IRON_BATTLEAXE);
        entries.add(IRON_MACE);
        entries.add(IRON_DAGGER);

        entries.add(COBALT_SWORD);
        entries.add(COBALT_BATTLEAXE);
        entries.add(COBALT_MACE);
        entries.add(COBALT_DAGGER);

        entries.add(STERLING_SWORD);
        entries.add(STERLING_BATTLEAXE);
        entries.add(STERLING_MACE);
        entries.add(STERLING_DAGGER);

        entries.add(STEEL_SWORD);
        entries.add(STEEL_BATTLEAXE);
        entries.add(STEEL_MACE);
        entries.add(STEEL_DAGGER);

        entries.add(AMETHYST_SWORD);
        entries.add(AMETHYST_BATTLEAXE);
        entries.add(AMETHYST_MACE);
        entries.add(AMETHYST_DAGGER);

        entries.add(EMERALD_SWORD);
        entries.add(EMERALD_BATTLEAXE);
        entries.add(EMERALD_MACE);
        entries.add(EMERALD_DAGGER);

        entries.add(TOPAZ_SWORD);
        entries.add(TOPAZ_BATTLEAXE);
        entries.add(TOPAZ_MACE);
        entries.add(TOPAZ_DAGGER);

        entries.add(TOURMALINE_SWORD);
        entries.add(TOURMALINE_BATTLEAXE);
        entries.add(TOURMALINE_MACE);
        entries.add(TOURMALINE_DAGGER);

        entries.add(TANZANITE_SWORD);
        entries.add(TANZANITE_BATTLEAXE);
        entries.add(TANZANITE_MACE);
        entries.add(TANZANITE_DAGGER);

        entries.add(RUBY_SWORD);
        entries.add(RUBY_BATTLEAXE);
        entries.add(RUBY_MACE);
        entries.add(RUBY_DAGGER);

        entries.add(SAPPHIRE_SWORD);
        entries.add(SAPPHIRE_BATTLEAXE);
        entries.add(SAPPHIRE_MACE);
        entries.add(SAPPHIRE_DAGGER);

        entries.add(DIAMOND_BATTLEAXE);
        entries.add(DIAMOND_MACE);
        entries.add(DIAMOND_DAGGER);

        entries.add(MOISSANITE_SWORD);
        entries.add(MOISSANITE_BATTLEAXE);
        entries.add(MOISSANITE_MACE);
        entries.add(MOISSANITE_DAGGER);

        entries.add(TURQUOISE_SWORD);
        entries.add(TURQUOISE_BATTLEAXE);
        entries.add(TURQUOISE_MACE);
        entries.add(TURQUOISE_DAGGER);

        entries.add(OBSIDIAN_SWORD);
        entries.add(OBSIDIAN_BATTLEAXE);
        entries.add(OBSIDIAN_MACE);
        entries.add(OBSIDIAN_DAGGER);

        entries.add(ONYX_SWORD);
        entries.add(ONYX_BATTLEAXE);
        entries.add(ONYX_MACE);
        entries.add(ONYX_DAGGER);

        entries.add(NETHERITE_BATTLEAXE);
        entries.add(NETHERITE_MACE);
        entries.add(NETHERITE_DAGGER);

        entries.add(GRAPHENE_SWORD);
        entries.add(GRAPHENE_BATTLEAXE);
        entries.add(GRAPHENE_MACE);
        entries.add(GRAPHENE_DAGGER);

//        entries.add(TIN_SHIELD);
//        entries.add(SILVER_SHIELD);
//        entries.add(COPPER_SHIELD);
//        entries.add(BRONZE_SHIELD);
//        entries.add(COBALT_SHIELD);
//        entries.add(STERLING_SHIELD);
//        entries.add(STEEL_SHIELD);
//        entries.add(AMETHYST_SHIELD);
//        entries.add(EMERALD_SHIELD);
//        entries.add(TOPAZ_SHIELD);
//        entries.add(TOURMALINE_SHIELD);
//        entries.add(TANZANITE_SHIELD);
//        entries.add(RUBY_SHIELD);
//        entries.add(SAPPHIRE_SHIELD);
//        entries.add(MOISSANITE_SHIELD);
//        entries.add(TURQUOISE_SHIELD);
//        entries.add(OBSIDIAN_SHIELD);
//        entries.add(ONYX_SHIELD);
//        entries.add(GRAPHENE_SHIELD);
    }
    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries) {
        entries.add(CHOCOLATE);
        entries.add(CARROT_PIE);
        entries.add(VELVET);
    }
    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        entries.add(TIN_PICKAXE);
        entries.add(TIN_AXE);
        entries.add(TIN_SHOVEL);
        entries.add(TIN_HOE);

        entries.add(COPPER_PICKAXE);
        entries.add(COPPER_AXE);
        entries.add(COPPER_SHOVEL);
        entries.add(COPPER_HOE);

        entries.add(BRONZE_PICKAXE);
        entries.add(BRONZE_AXE);
        entries.add(BRONZE_SHOVEL);
        entries.add(BRONZE_HOE);

        entries.add(SILVER_PICKAXE);
        entries.add(SILVER_AXE);
        entries.add(SILVER_SHOVEL);
        entries.add(SILVER_HOE);

        entries.add(STERLING_PICKAXE);
        entries.add(STERLING_AXE);
        entries.add(STERLING_SHOVEL);
        entries.add(STERLING_HOE);

        entries.add(STEEL_PICKAXE);
        entries.add(STEEL_AXE);
        entries.add(STEEL_SHOVEL);
        entries.add(STEEL_HOE);

        entries.add(COBALT_PICKAXE);
        entries.add(COBALT_AXE);
        entries.add(COBALT_SHOVEL);
        entries.add(COBALT_HOE);

        entries.add(AMETHYST_PICKAXE);
        entries.add(AMETHYST_AXE);
        entries.add(AMETHYST_SHOVEL);
        entries.add(AMETHYST_HOE);

        entries.add(EMERALD_PICKAXE);
        entries.add(EMERALD_AXE);
        entries.add(EMERALD_SHOVEL);
        entries.add(EMERALD_HOE);

        entries.add(TOPAZ_PICKAXE);
        entries.add(TOPAZ_AXE);
        entries.add(TOPAZ_SHOVEL);
        entries.add(TOPAZ_HOE);

        entries.add(TOURMALINE_PICKAXE);
        entries.add(TOURMALINE_AXE);
        entries.add(TOURMALINE_SHOVEL);
        entries.add(TOURMALINE_HOE);

        entries.add(TANZANITE_PICKAXE);
        entries.add(TANZANITE_AXE);
        entries.add(TANZANITE_SHOVEL);
        entries.add(TANZANITE_HOE);

        entries.add(RUBY_PICKAXE);
        entries.add(RUBY_AXE);
        entries.add(RUBY_SHOVEL);
        entries.add(RUBY_HOE);

        entries.add(SAPPHIRE_PICKAXE);
        entries.add(SAPPHIRE_AXE);
        entries.add(SAPPHIRE_SHOVEL);
        entries.add(SAPPHIRE_HOE);

        entries.add(MOISSANITE_PICKAXE);
        entries.add(MOISSANITE_AXE);
        entries.add(MOISSANITE_SHOVEL);
        entries.add(MOISSANITE_HOE);

        entries.add(TURQUOISE_PICKAXE);
        entries.add(TURQUOISE_AXE);
        entries.add(TURQUOISE_SHOVEL);
        entries.add(TURQUOISE_HOE);

        entries.add(OBSIDIAN_PICKAXE);
        entries.add(OBSIDIAN_AXE);
        entries.add(OBSIDIAN_SHOVEL);
        entries.add(OBSIDIAN_HOE);

        entries.add(ONYX_PICKAXE);
        entries.add(ONYX_AXE);
        entries.add(ONYX_SHOVEL);
        entries.add(ONYX_HOE);

        entries.add(GRAPHENE_PICKAXE);
        entries.add(GRAPHENE_AXE);
        entries.add(GRAPHENE_SHOVEL);
        entries.add(GRAPHENE_HOE);
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Mores.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Mores.LOGGER.info("Registering Mod Items for " + Mores.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
    }
}
