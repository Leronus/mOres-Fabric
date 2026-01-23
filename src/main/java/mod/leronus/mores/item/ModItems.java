package mod.leronus.mores.item;

import mod.leronus.mores.Mores;
import mod.leronus.mores.entity.ModEntities;
import mod.leronus.mores.item.custom.*;
import mod.leronus.mores.sound.ModJukeboxSongs;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

/**
 * Class that initialise all items from mOres
 */
public class ModItems {
    /**
     * Fills the registry with items
     */
    public static final Item SWEET_CAROLINE_MUSIC_DISC =
            registerItem("sweet_caroline_music_disc",
                    new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.SWEET_CAROLINE).rarity(Rarity.RARE).maxCount(1)));
    public static final Item CIPHER_MUSIC_DISC =
            registerItem("cipher_music_disc",
                    new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.CIPHER).rarity(Rarity.RARE).maxCount(1)));


    public static final Item HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE = registerItem("hardened_steel_upgrade_smithing_template", ModSmithingTemplateItem.createHardenedSteelUpgradeTemplate());
    public static final Item OBSIDIAN_UPGRADE_SMITHING_TEMPLATE = registerItem("obsidian_upgrade_smithing_template", ModSmithingTemplateItem.createObsidianUpgradeTemplate());
    public static final Item ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE = registerItem("adamantium_upgrade_smithing_template", ModSmithingTemplateItem.createAdamantiumUpgradeTemplate());
    public static final Item ENDERITE_UPGRADE_SMITHING_TEMPLATE = registerItem("enderite_upgrade_smithing_template", ModSmithingTemplateItem.createEnderiteUpgradeTemplate());

    public static final Item DARK_CHOCOLATE = registerItem("dark_chocolate", new Item(new Item.Settings().food(ModFoodComponents.DARK_CHOCOLATE)));
    public static final Item MILK_CHOCOLATE = registerItem("milk_chocolate", new ModMilkItem(new Item.Settings().food(ModFoodComponents.MILK_CHOCOLATE)));
    public static final Item WHITE_CHOCOLATE = registerItem("white_chocolate", new ModMilkItem(new Item.Settings().food(ModFoodComponents.WHITE_CHOCOLATE)));
    public static final Item CARROT_PIE = registerItem("carrot_pie", new Item(new Item.Settings().food(ModFoodComponents.CARROT_PIE)));
    public static final Item LEMON_PIE = registerItem("lemon_pie", new Item(new Item.Settings().food(ModFoodComponents.LEMON_PIE)));
    public static final Item APPLE_PIE = registerItem("apple_pie", new Item(new Item.Settings().food(ModFoodComponents.APPLE_PIE)));
    public static final Item SWEET_BERRY_PIE = registerItem("sweet_berry_pie", new Item(new Item.Settings().food(ModFoodComponents.SWEET_BERRY_PIE)));
    public static final Item VELVET = registerItem("velvet", new Item(new Item.Settings().food(ModFoodComponents.VELVET)));
    public static final Item LEMON = registerItem("lemon", new Item(new Item.Settings().food(ModFoodComponents.LEMON_FRUIT)));
    public static final Item SILVER_CARROT = registerItem("silver_carrot", new Item(new Item.Settings().food(ModFoodComponents.SILVER_CARROT)));
    public static final Item SILVER_APPLE = registerItem("silver_apple", new Item(new Item.Settings().food(ModFoodComponents.SILVER_APPLE).rarity(Rarity.UNCOMMON)));
    public static final Item BRONZE_APPLE = registerItem("bronze_apple", new Item(new Item.Settings().food(ModFoodComponents.BRONZE_APPLE).rarity(Rarity.UNCOMMON)));
    public static final Item COBALT_APPLE = registerItem("cobalt_apple", new Item(new Item.Settings().food(ModFoodComponents.COBALT_APPLE).rarity(Rarity.RARE)));
    public static final Item ENCHANTED_COBALT_APPLE = registerItem("enchanted_cobalt_apple", new ModGlintItem(new Item.Settings().food(ModFoodComponents.ENCHANTED_COBALT_APPLE).rarity(Rarity.EPIC)));
    public static final Item ROSE_GOLD_APPLE = registerItem("rose_gold_apple", new Item(new Item.Settings().food(ModFoodComponents.ROSE_GOLD_APPLE).rarity(Rarity.RARE)));
    public static final Item ENCHANTED_ROSE_GOLD_APPLE = registerItem("enchanted_rose_gold_apple", new ModGlintItem(new Item.Settings().food(ModFoodComponents.ENCHANTED_ROSE_GOLD_APPLE).rarity(Rarity.EPIC)));

    public static final Item RAW_DUCK = registerItem("raw_duck", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3F).build())));
    public static final Item COOKED_DUCK = registerItem("cooked_duck", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).build())));

    public static final Item ANTHRACITE = registerItem("anthracite", new Item(new Item.Settings()));

    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new Item.Settings()));
    public static final Item RAW_SILVER = registerItem("raw_silver", new Item(new Item.Settings()));
    public static final Item RAW_COBALT = registerItem("raw_cobalt", new Item(new Item.Settings()));

    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new Item.Settings()));
    public static final Item SILVER_INGOT = registerItem("silver_ingot", new Item(new Item.Settings()));
    public static final Item STERLING_SILVER_INGOT = registerItem("sterling_silver_ingot", new Item(new Item.Settings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new Item.Settings()));
    public static final Item COBALT_INGOT = registerItem("cobalt_ingot", new Item(new Item.Settings()));
    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot", new Item(new Item.Settings()));
    public static final Item CARBON_STEEL_INGOT = registerItem("carbon_steel_ingot", new Item(new Item.Settings()));
    public static final Item HARDENED_STEEL_INGOT = registerItem("hardened_steel_ingot", new Item(new Item.Settings()));
    public static final Item OBSIDIAN_INGOT = registerItem("obsidian_ingot", new Item(new Item.Settings()));
    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot", new Item(new Item.Settings()));
    public static final Item ADAMANTIUM_INGOT = registerItem("adamantium_ingot", new Item(new Item.Settings()));

    public static final Item HOT_CARBON_STEEL_SCRAP = registerItem("hot_carbon_steel_scrap", new Item(new Item.Settings()));
    public static final Item CARBON_STEEL_SCRAP = registerItem("carbon_steel_scrap", new Item(new Item.Settings()));
    public static final Item OBSIDIAN_SCRAP = registerItem("obsidian_scrap", new Item(new Item.Settings()));
    public static final Item ENDERITE_SCRAP = registerItem("enderite_scrap", new Item(new Item.Settings()));

    public static final Item LAPIS_LAZULI_DUST = registerItem("lapis_lazuli_dust", new Item(new Item.Settings()));
    public static final Item TURQUOISE_DUST = registerItem("turquoise_dust", new Item(new Item.Settings()));
    public static final Item AMETHYST_DUST = registerItem("amethyst_dust", new Item(new Item.Settings()));
    public static final Item QUARTZ_DUST = registerItem("quartz_dust", new Item(new Item.Settings()));

    public static final Item LAPIS_LAZULI_GEM = registerItem("lapis_lazuli_gem", new Item(new Item.Settings()));
    public static final Item TURQUOISE_GEM = registerItem("turquoise_gem", new Item(new Item.Settings()));
    public static final Item AMETHYST_GEM = registerItem("amethyst_gem", new Item(new Item.Settings()));
    public static final Item TANZANITE_GEM = registerItem("tanzanite_gem", new Item(new Item.Settings()));
    public static final Item TOPAZ_GEM = registerItem("topaz_gem", new Item(new Item.Settings()));
    public static final Item TOURMALINE_GEM = registerItem("tourmaline_gem", new Item(new Item.Settings()));
    public static final Item RUBY_GEM = registerItem("ruby_gem", new Item(new Item.Settings()));
    public static final Item SAPPHIRE_GEM = registerItem("sapphire_gem", new Item(new Item.Settings()));
    public static final Item SPINEL_GEM = registerItem("spinel_gem", new Item(new Item.Settings()));
    public static final Item CITRINE_GEM = registerItem("citrine_gem", new Item(new Item.Settings()));
    public static final Item MOISSANITE_GEM = registerItem("moissanite_gem", new Item(new Item.Settings()));
    public static final Item ONYX_GEM = registerItem("onyx_gem", new Item(new Item.Settings()));
    public static final Item GRAPHENE_CHAINMAIL = registerItem("graphene_chainmail", new Item(new Item.Settings()));

    public static final Item CHAINMAIL = registerItem("chainmail", new Item(new Item.Settings()));
    public static final Item CITRINE = registerItem("citrine", new Item(new Item.Settings()));
    public static final Item TURQUOISE = registerItem("turquoise", new Item(new Item.Settings()));
    public static final Item ONYX = registerItem("onyx", new Item(new Item.Settings()));

    public static final Item TIN_NUGGET = registerItem("tin_nugget", new Item(new Item.Settings()));
    public static final Item SILVER_NUGGET = registerItem("silver_nugget", new Item(new Item.Settings()));
    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new Item.Settings()));
    public static final Item STERLING_SILVER_NUGGET = registerItem("sterling_silver_nugget", new Item(new Item.Settings()));
    public static final Item ROSE_GOLD_NUGGET = registerItem("rose_gold_nugget", new Item(new Item.Settings()));
    public static final Item BRONZE_NUGGET = registerItem("bronze_nugget", new Item(new Item.Settings()));
    public static final Item COBALT_NUGGET = registerItem("cobalt_nugget", new Item(new Item.Settings()));
    public static final Item CARBON_STEEL_NUGGET = registerItem("carbon_steel_nugget", new Item(new Item.Settings()));
    public static final Item HARDENED_STEEL_NUGGET = registerItem("hardened_steel_nugget", new Item(new Item.Settings()));

    public static final Item HARDENED_STEEL_GOLEM_SPAWN_EGG = registerItem("hardened_steel_golem_spawn_egg", new SpawnEggItem(ModEntities.HARDENED_STEEL_GOLEM, 14405058, 0x006808, new Item.Settings()));
    public static final Item DUCK_SPAWN_EGG  = registerItem("duck_spawn_egg", new SpawnEggItem(ModEntities.DUCK, 0x006808, 0xFFD400, new Item.Settings()));
    public static final Item DUCK_EGG  = registerItem("duck_egg", new ModEggItem(new Item.Settings().maxCount(16)));

    // Horse Armor (1.21.1 uses AnimalArmorItem)
    public static final Item TIN_HORSE_ARMOR = registerItem("tin_horse_armor", new AnimalArmorItem(ModArmorMaterials.TIN, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item SILVER_HORSE_ARMOR = registerItem("silver_horse_armor", new AnimalArmorItem(ModArmorMaterials.SILVER, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item COPPER_HORSE_ARMOR = registerItem("copper_horse_armor", new AnimalArmorItem(ModArmorMaterials.COPPER, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item STERLING_SILVER_HORSE_ARMOR = registerItem("sterling_silver_horse_armor", new AnimalArmorItem(ModArmorMaterials.STERLING_SILVER, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item ROSE_GOLD_HORSE_ARMOR = registerItem("rose_gold_horse_armor", new AnimalArmorItem(ModArmorMaterials.ROSE_GOLD, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item BRONZE_HORSE_ARMOR = registerItem("bronze_horse_armor", new AnimalArmorItem(ModArmorMaterials.BRONZE, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item COBALT_HORSE_ARMOR = registerItem("cobalt_horse_armor", new AnimalArmorItem(ModArmorMaterials.COBALT, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item CARBON_STEEL_HORSE_ARMOR = registerItem("carbon_steel_horse_armor", new AnimalArmorItem(ModArmorMaterials.CARBON_STEEL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item HARDENED_STEEL_HORSE_ARMOR = registerItem("hardened_steel_horse_armor", new AnimalArmorItem(ModArmorMaterials.HARDENED_STEEL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item TURQUOISE_HORSE_ARMOR = registerItem("turquoise_horse_armor", new AnimalArmorItem(ModArmorMaterials.TURQUOISE, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item AMETHYST_HORSE_ARMOR = registerItem("amethyst_horse_armor", new AnimalArmorItem(ModArmorMaterials.AMETHYST, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item LAPIS_LAZULI_HORSE_ARMOR = registerItem("lapis_lazuli_horse_armor", new AnimalArmorItem(ModArmorMaterials.LAPIS_LAZULI, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item TOURMALINE_HORSE_ARMOR = registerItem("tourmaline_horse_armor", new AnimalArmorItem(ModArmorMaterials.TOURMALINE, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item TANZANITE_HORSE_ARMOR = registerItem("tanzanite_horse_armor", new AnimalArmorItem(ModArmorMaterials.TANZANITE, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item TOPAZ_HORSE_ARMOR = registerItem("topaz_horse_armor", new AnimalArmorItem(ModArmorMaterials.TOPAZ, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item EMERALD_HORSE_ARMOR = registerItem("emerald_horse_armor", new AnimalArmorItem(ModArmorMaterials.EMERALD, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item RUBY_HORSE_ARMOR = registerItem("ruby_horse_armor", new AnimalArmorItem(ModArmorMaterials.RUBY, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item SAPPHIRE_HORSE_ARMOR = registerItem("sapphire_horse_armor", new AnimalArmorItem(ModArmorMaterials.SAPPHIRE, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item SPINEL_HORSE_ARMOR = registerItem("spinel_horse_armor", new AnimalArmorItem(ModArmorMaterials.SPINEL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item CITRINE_HORSE_ARMOR = registerItem("citrine_horse_armor", new AnimalArmorItem(ModArmorMaterials.CITRINE, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item MOISSANITE_HORSE_ARMOR = registerItem("moissanite_horse_armor", new AnimalArmorItem(ModArmorMaterials.MOISSANITE, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item ONYX_HORSE_ARMOR = registerItem("onyx_horse_armor", new AnimalArmorItem(ModArmorMaterials.ONYX, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item OBSIDIAN_HORSE_ARMOR = registerItem("obsidian_horse_armor", new AnimalArmorItem(ModArmorMaterials.OBSIDIAN, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
//    public static final Item GRAPHENE_HORSE_ARMOR = registerItem("graphene_horse_armor", new AnimalArmorItem(ModArmorMaterials.GRAPHENE, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item NETHERITE_HORSE_ARMOR = registerItem("netherite_horse_armor", new AnimalArmorItem(ModArmorMaterials.NETHERITE, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item ADAMANTIUM_HORSE_ARMOR = registerItem("adamantium_horse_armor", new AnimalArmorItem(ModArmorMaterials.ADAMANTIUM, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
    public static final Item ENDERITE_HORSE_ARMOR = registerItem("enderite_horse_armor", new AnimalArmorItem(ModArmorMaterials.ENDERITE, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));

    public static final Item TIN_WOLF_ARMOR = registerItem(
            "tin_wolf_armor", new ModWolfArmorItem(
                    ModArmorMaterials.TIN,
                    false,
                    new Item.Settings().maxCount(1),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_tin.png"),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_tin_overlay.png")
            )
    );
    public static final Item GOLD_WOLF_ARMOR = registerItem(
            "gold_wolf_armor",
            new ModWolfArmorItem(
                    ArmorMaterials.GOLD,
                    false,
                    new Item.Settings().maxCount(1),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_gold.png"),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_gold_overlay.png")
            )
    );
    public static final Item SILVER_WOLF_ARMOR = registerItem(
            "silver_wolf_armor",
            new ModWolfArmorItem(
                    ModArmorMaterials.SILVER,
                    false,
                    new Item.Settings().maxCount(1),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_silver.png"),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_silver_overlay.png")
            )
    );
    public static final Item COPPER_WOLF_ARMOR = registerItem(
            "copper_wolf_armor",
            new ModWolfArmorItem(
                    ModArmorMaterials.COPPER,
                    false,
                    new Item.Settings().maxCount(1),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_copper.png"),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_copper_overlay.png")
            )
    );
    public static final Item STERLING_SILVER_WOLF_ARMOR = registerItem(
            "sterling_silver_wolf_armor",
            new ModWolfArmorItem(
                    ModArmorMaterials.STERLING_SILVER,
                    false,
                    new Item.Settings().maxCount(1),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_sterling_silver.png"),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_sterling_silver_overlay.png")
            )
    );
    public static final Item BRONZE_WOLF_ARMOR = registerItem(
            "bronze_wolf_armor",
            new ModWolfArmorItem(
                    ModArmorMaterials.BRONZE,
                    false,
                    new Item.Settings().maxCount(1),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_bronze.png"),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_bronze_overlay.png")
            )
    );
    public static final Item ROSE_GOLD_WOLF_ARMOR = registerItem(
            "rose_gold_wolf_armor",
            new ModWolfArmorItem(
                    ModArmorMaterials.ROSE_GOLD,
                    false,
                    new Item.Settings().maxCount(1),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_rose_gold.png"),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_rose_gold_overlay.png")
            )
    );
    public static final Item IRON_WOLF_ARMOR = registerItem(
            "iron_wolf_armor",
            new ModWolfArmorItem(
                    ArmorMaterials.IRON,
                    false,
                    new Item.Settings().maxCount(1),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_iron.png"),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_iron_overlay.png")
            )
    );
    public static final Item COBALT_WOLF_ARMOR = registerItem(
            "cobalt_wolf_armor",
            new ModWolfArmorItem(
                    ModArmorMaterials.COBALT,
                    false,
                    new Item.Settings().maxCount(1),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_cobalt.png"),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_cobalt_overlay.png")
            )
    );
    public static final Item CARBON_STEEL_WOLF_ARMOR = registerItem(
            "carbon_steel_wolf_armor",
            new ModWolfArmorItem(
                    ModArmorMaterials.CARBON_STEEL,
                    false,
                    new Item.Settings().maxCount(1),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_carbon_steel.png"),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_carbon_steel_overlay.png")
            )
    );
    public static final Item HARDENED_STEEL_WOLF_ARMOR = registerItem(
            "hardened_steel_wolf_armor",
            new ModWolfArmorItem(
                    ModArmorMaterials.HARDENED_STEEL,
                    false,
                    new Item.Settings().maxCount(1),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_hardened_steel.png"),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_hardened_steel_overlay.png")
            )
    );
    public static final Item DIAMOND_WOLF_ARMOR = registerItem(
            "diamond_wolf_armor",
            new ModWolfArmorItem(
                    ArmorMaterials.DIAMOND,
                    false,
                    new Item.Settings().maxCount(1),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_diamond.png"),
                    Identifier.of("mores", "textures/entity/wolf/wolf_armor_diamond_overlay.png")
            )
    );


// All armor (durability via ModArmorDurability.scale(base, piece))

    public static final Item TIN_HELMET = registerItem("tin_helmet",
            new ModArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TIN, ArmorItem.Type.HELMET))));
    public static final Item TIN_CHESTPLATE = registerItem("tin_chestplate",
            new ModArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TIN, ArmorItem.Type.CHESTPLATE))));
    public static final Item TIN_LEGGINGS = registerItem("tin_leggings",
            new ModArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TIN, ArmorItem.Type.LEGGINGS))));
    public static final Item TIN_BOOTS = registerItem("tin_boots",
            new ModArmorItem(ModArmorMaterials.TIN, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TIN, ArmorItem.Type.BOOTS))));

    public static final Item SILVER_HELMET = registerItem("silver_helmet",
            new ModArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.SILVER, ArmorItem.Type.HELMET))));
    public static final Item SILVER_CHESTPLATE = registerItem("silver_chestplate",
            new ModArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.SILVER, ArmorItem.Type.CHESTPLATE))));
    public static final Item SILVER_LEGGINGS = registerItem("silver_leggings",
            new ModArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.SILVER, ArmorItem.Type.LEGGINGS))));
    public static final Item SILVER_BOOTS = registerItem("silver_boots",
            new ModArmorItem(ModArmorMaterials.SILVER, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.SILVER, ArmorItem.Type.BOOTS))));

    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            new ModArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.COPPER, ArmorItem.Type.HELMET))));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
            new ModArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.COPPER, ArmorItem.Type.CHESTPLATE))));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            new ModArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.COPPER, ArmorItem.Type.LEGGINGS))));
    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            new ModArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.COPPER, ArmorItem.Type.BOOTS))));

    public static final Item STERLING_SILVER_HELMET = registerItem("sterling_silver_helmet",
            new ModArmorItem(ModArmorMaterials.STERLING_SILVER, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.STERLING_SILVER, ArmorItem.Type.HELMET))));
    public static final Item STERLING_SILVER_CHESTPLATE = registerItem("sterling_silver_chestplate",
            new ModArmorItem(ModArmorMaterials.STERLING_SILVER, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.STERLING_SILVER, ArmorItem.Type.CHESTPLATE))));
    public static final Item STERLING_SILVER_LEGGINGS = registerItem("sterling_silver_leggings",
            new ModArmorItem(ModArmorMaterials.STERLING_SILVER, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.STERLING_SILVER, ArmorItem.Type.LEGGINGS))));
    public static final Item STERLING_SILVER_BOOTS = registerItem("sterling_silver_boots",
            new ModArmorItem(ModArmorMaterials.STERLING_SILVER, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.STERLING_SILVER, ArmorItem.Type.BOOTS))));

    public static final Item ROSE_GOLD_HELMET = registerItem("rose_gold_helmet",
            new ModArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ROSE_GOLD, ArmorItem.Type.HELMET))));
    public static final Item ROSE_GOLD_CHESTPLATE = registerItem("rose_gold_chestplate",
            new ModArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ROSE_GOLD, ArmorItem.Type.CHESTPLATE))));
    public static final Item ROSE_GOLD_LEGGINGS = registerItem("rose_gold_leggings",
            new ModArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ROSE_GOLD, ArmorItem.Type.LEGGINGS))));
    public static final Item ROSE_GOLD_BOOTS = registerItem("rose_gold_boots",
            new ModArmorItem(ModArmorMaterials.ROSE_GOLD, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ROSE_GOLD, ArmorItem.Type.BOOTS))));

    public static final Item BRONZE_HELMET = registerItem("bronze_helmet",
            new ModArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.BRONZE, ArmorItem.Type.HELMET))));
    public static final Item BRONZE_CHESTPLATE = registerItem("bronze_chestplate",
            new ModArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.BRONZE, ArmorItem.Type.CHESTPLATE))));
    public static final Item BRONZE_LEGGINGS = registerItem("bronze_leggings",
            new ModArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.BRONZE, ArmorItem.Type.LEGGINGS))));
    public static final Item BRONZE_BOOTS = registerItem("bronze_boots",
            new ModArmorItem(ModArmorMaterials.BRONZE, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.BRONZE, ArmorItem.Type.BOOTS))));

    public static final Item COBALT_HELMET = registerItem("cobalt_helmet",
            new ModArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.COBALT, ArmorItem.Type.HELMET))));
    public static final Item COBALT_CHESTPLATE = registerItem("cobalt_chestplate",
            new ModArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.COBALT, ArmorItem.Type.CHESTPLATE))));
    public static final Item COBALT_LEGGINGS = registerItem("cobalt_leggings",
            new ModArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.COBALT, ArmorItem.Type.LEGGINGS))));
    public static final Item COBALT_BOOTS = registerItem("cobalt_boots",
            new ModArmorItem(ModArmorMaterials.COBALT, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.COBALT, ArmorItem.Type.BOOTS))));

    public static final Item CARBON_STEEL_HELMET = registerItem("carbon_steel_helmet",
            new ModArmorItem(ModArmorMaterials.CARBON_STEEL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.CARBON_STEEL, ArmorItem.Type.HELMET))));
    public static final Item CARBON_STEEL_CHESTPLATE = registerItem("carbon_steel_chestplate",
            new ModArmorItem(ModArmorMaterials.CARBON_STEEL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.CARBON_STEEL, ArmorItem.Type.CHESTPLATE))));
    public static final Item CARBON_STEEL_LEGGINGS = registerItem("carbon_steel_leggings",
            new ModArmorItem(ModArmorMaterials.CARBON_STEEL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.CARBON_STEEL, ArmorItem.Type.LEGGINGS))));
    public static final Item CARBON_STEEL_BOOTS = registerItem("carbon_steel_boots",
            new ModArmorItem(ModArmorMaterials.CARBON_STEEL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.CARBON_STEEL, ArmorItem.Type.BOOTS))));

    public static final Item HARDENED_STEEL_HELMET = registerItem("hardened_steel_helmet",
            new ModArmorItem(ModArmorMaterials.HARDENED_STEEL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.HARDENED_STEEL, ArmorItem.Type.HELMET))));
    public static final Item HARDENED_STEEL_CHESTPLATE = registerItem("hardened_steel_chestplate",
            new ModArmorItem(ModArmorMaterials.HARDENED_STEEL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.HARDENED_STEEL, ArmorItem.Type.CHESTPLATE))));
    public static final Item HARDENED_STEEL_LEGGINGS = registerItem("hardened_steel_leggings",
            new ModArmorItem(ModArmorMaterials.HARDENED_STEEL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.HARDENED_STEEL, ArmorItem.Type.LEGGINGS))));
    public static final Item HARDENED_STEEL_BOOTS = registerItem("hardened_steel_boots",
            new ModArmorItem(ModArmorMaterials.HARDENED_STEEL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.HARDENED_STEEL, ArmorItem.Type.BOOTS))));

    public static final Item TURQUOISE_HELMET = registerItem("turquoise_helmet",
            new ModArmorItem(ModArmorMaterials.TURQUOISE, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TURQUOISE, ArmorItem.Type.HELMET))));
    public static final Item TURQUOISE_CHESTPLATE = registerItem("turquoise_chestplate",
            new ModArmorItem(ModArmorMaterials.TURQUOISE, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TURQUOISE, ArmorItem.Type.CHESTPLATE))));
    public static final Item TURQUOISE_LEGGINGS = registerItem("turquoise_leggings",
            new ModArmorItem(ModArmorMaterials.TURQUOISE, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TURQUOISE, ArmorItem.Type.LEGGINGS))));
    public static final Item TURQUOISE_BOOTS = registerItem("turquoise_boots",
            new ModArmorItem(ModArmorMaterials.TURQUOISE, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TURQUOISE, ArmorItem.Type.BOOTS))));

    public static final Item LAPIS_LAZULI_HELMET = registerItem("lapis_lazuli_helmet",
            new ModArmorItem(ModArmorMaterials.LAPIS_LAZULI, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.LAPIS_LAZULI, ArmorItem.Type.HELMET))));
    public static final Item LAPIS_LAZULI_CHESTPLATE = registerItem("lapis_lazuli_chestplate",
            new ModArmorItem(ModArmorMaterials.LAPIS_LAZULI, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.LAPIS_LAZULI, ArmorItem.Type.CHESTPLATE))));
    public static final Item LAPIS_LAZULI_LEGGINGS = registerItem("lapis_lazuli_leggings",
            new ModArmorItem(ModArmorMaterials.LAPIS_LAZULI, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.LAPIS_LAZULI, ArmorItem.Type.LEGGINGS))));
    public static final Item LAPIS_LAZULI_BOOTS = registerItem("lapis_lazuli_boots",
            new ModArmorItem(ModArmorMaterials.LAPIS_LAZULI, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.LAPIS_LAZULI, ArmorItem.Type.BOOTS))));

    public static final Item AMETHYST_HELMET = registerItem("amethyst_helmet",
            new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.AMETHYST, ArmorItem.Type.HELMET))));
    public static final Item AMETHYST_CHESTPLATE = registerItem("amethyst_chestplate",
            new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.AMETHYST, ArmorItem.Type.CHESTPLATE))));
    public static final Item AMETHYST_LEGGINGS = registerItem("amethyst_leggings",
            new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.AMETHYST, ArmorItem.Type.LEGGINGS))));
    public static final Item AMETHYST_BOOTS = registerItem("amethyst_boots",
            new ModArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.AMETHYST, ArmorItem.Type.BOOTS))));

    public static final Item TANZANITE_HELMET = registerItem("tanzanite_helmet",
            new ModArmorItem(ModArmorMaterials.TANZANITE, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TANZANITE, ArmorItem.Type.HELMET))));
    public static final Item TANZANITE_CHESTPLATE = registerItem("tanzanite_chestplate",
            new ModArmorItem(ModArmorMaterials.TANZANITE, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TANZANITE, ArmorItem.Type.CHESTPLATE))));
    public static final Item TANZANITE_LEGGINGS = registerItem("tanzanite_leggings",
            new ModArmorItem(ModArmorMaterials.TANZANITE, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TANZANITE, ArmorItem.Type.LEGGINGS))));
    public static final Item TANZANITE_BOOTS = registerItem("tanzanite_boots",
            new ModArmorItem(ModArmorMaterials.TANZANITE, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TANZANITE, ArmorItem.Type.BOOTS))));

    public static final Item TOURMALINE_HELMET = registerItem("tourmaline_helmet",
            new ModArmorItem(ModArmorMaterials.TOURMALINE, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TOURMALINE, ArmorItem.Type.HELMET))));
    public static final Item TOURMALINE_CHESTPLATE = registerItem("tourmaline_chestplate",
            new ModArmorItem(ModArmorMaterials.TOURMALINE, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TOURMALINE, ArmorItem.Type.CHESTPLATE))));
    public static final Item TOURMALINE_LEGGINGS = registerItem("tourmaline_leggings",
            new ModArmorItem(ModArmorMaterials.TOURMALINE, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TOURMALINE, ArmorItem.Type.LEGGINGS))));
    public static final Item TOURMALINE_BOOTS = registerItem("tourmaline_boots",
            new ModArmorItem(ModArmorMaterials.TOURMALINE, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TOURMALINE, ArmorItem.Type.BOOTS))));

    public static final Item TOPAZ_HELMET = registerItem("topaz_helmet",
            new ModArmorItem(ModArmorMaterials.TOPAZ, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TOPAZ, ArmorItem.Type.HELMET))));
    public static final Item TOPAZ_CHESTPLATE = registerItem("topaz_chestplate",
            new ModArmorItem(ModArmorMaterials.TOPAZ, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TOPAZ, ArmorItem.Type.CHESTPLATE))));
    public static final Item TOPAZ_LEGGINGS = registerItem("topaz_leggings",
            new ModArmorItem(ModArmorMaterials.TOPAZ, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TOPAZ, ArmorItem.Type.LEGGINGS))));
    public static final Item TOPAZ_BOOTS = registerItem("topaz_boots",
            new ModArmorItem(ModArmorMaterials.TOPAZ, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.TOPAZ, ArmorItem.Type.BOOTS))));

    public static final Item EMERALD_HELMET = registerItem("emerald_helmet",
            new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.EMERALD, ArmorItem.Type.HELMET))));
    public static final Item EMERALD_CHESTPLATE = registerItem("emerald_chestplate",
            new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.EMERALD, ArmorItem.Type.CHESTPLATE))));
    public static final Item EMERALD_LEGGINGS = registerItem("emerald_leggings",
            new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.EMERALD, ArmorItem.Type.LEGGINGS))));
    public static final Item EMERALD_BOOTS = registerItem("emerald_boots",
            new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.EMERALD, ArmorItem.Type.BOOTS))));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.RUBY, ArmorItem.Type.HELMET))));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.RUBY, ArmorItem.Type.CHESTPLATE))));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.RUBY, ArmorItem.Type.LEGGINGS))));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.RUBY, ArmorItem.Type.BOOTS))));

    public static final Item SAPPHIRE_HELMET = registerItem("sapphire_helmet",
            new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.SAPPHIRE, ArmorItem.Type.HELMET))));
    public static final Item SAPPHIRE_CHESTPLATE = registerItem("sapphire_chestplate",
            new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.SAPPHIRE, ArmorItem.Type.CHESTPLATE))));
    public static final Item SAPPHIRE_LEGGINGS = registerItem("sapphire_leggings",
            new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.SAPPHIRE, ArmorItem.Type.LEGGINGS))));
    public static final Item SAPPHIRE_BOOTS = registerItem("sapphire_boots",
            new ModArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.SAPPHIRE, ArmorItem.Type.BOOTS))));

    public static final Item SPINEL_HELMET = registerItem("spinel_helmet",
            new ModArmorItem(ModArmorMaterials.SPINEL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.SPINEL, ArmorItem.Type.HELMET))));
    public static final Item SPINEL_CHESTPLATE = registerItem("spinel_chestplate",
            new ModArmorItem(ModArmorMaterials.SPINEL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.SPINEL, ArmorItem.Type.CHESTPLATE))));
    public static final Item SPINEL_LEGGINGS = registerItem("spinel_leggings",
            new ModArmorItem(ModArmorMaterials.SPINEL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.SPINEL, ArmorItem.Type.LEGGINGS))));
    public static final Item SPINEL_BOOTS = registerItem("spinel_boots",
            new ModArmorItem(ModArmorMaterials.SPINEL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.SPINEL, ArmorItem.Type.BOOTS))));

    public static final Item CITRINE_HELMET = registerItem("citrine_helmet",
            new ModArmorItem(ModArmorMaterials.CITRINE, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.CITRINE, ArmorItem.Type.HELMET))));
    public static final Item CITRINE_CHESTPLATE = registerItem("citrine_chestplate",
            new ModArmorItem(ModArmorMaterials.CITRINE, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.CITRINE, ArmorItem.Type.CHESTPLATE))));
    public static final Item CITRINE_LEGGINGS = registerItem("citrine_leggings",
            new ModArmorItem(ModArmorMaterials.CITRINE, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.CITRINE, ArmorItem.Type.LEGGINGS))));
    public static final Item CITRINE_BOOTS = registerItem("citrine_boots",
            new ModArmorItem(ModArmorMaterials.CITRINE, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.CITRINE, ArmorItem.Type.BOOTS))));

    public static final Item MOISSANITE_HELMET = registerItem("moissanite_helmet",
            new ModArmorItem(ModArmorMaterials.MOISSANITE, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.MOISSANITE, ArmorItem.Type.HELMET))));
    public static final Item MOISSANITE_CHESTPLATE = registerItem("moissanite_chestplate",
            new ModArmorItem(ModArmorMaterials.MOISSANITE, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.MOISSANITE, ArmorItem.Type.CHESTPLATE))));
    public static final Item MOISSANITE_LEGGINGS = registerItem("moissanite_leggings",
            new ModArmorItem(ModArmorMaterials.MOISSANITE, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.MOISSANITE, ArmorItem.Type.LEGGINGS))));
    public static final Item MOISSANITE_BOOTS = registerItem("moissanite_boots",
            new ModArmorItem(ModArmorMaterials.MOISSANITE, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.MOISSANITE, ArmorItem.Type.BOOTS))));

    public static final Item OBSIDIAN_HELMET = registerItem("obsidian_helmet",
            new ModArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.OBSIDIAN, ArmorItem.Type.HELMET))));
    public static final Item OBSIDIAN_CHESTPLATE = registerItem("obsidian_chestplate",
            new ModArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.OBSIDIAN, ArmorItem.Type.CHESTPLATE))));
    public static final Item OBSIDIAN_LEGGINGS = registerItem("obsidian_leggings",
            new ModArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.OBSIDIAN, ArmorItem.Type.LEGGINGS))));
    public static final Item OBSIDIAN_BOOTS = registerItem("obsidian_boots",
            new ModArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.OBSIDIAN, ArmorItem.Type.BOOTS))));

    public static final Item ONYX_HELMET = registerItem("onyx_helmet",
            new ModArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ONYX, ArmorItem.Type.HELMET))));
    public static final Item ONYX_CHESTPLATE = registerItem("onyx_chestplate",
            new ModArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ONYX, ArmorItem.Type.CHESTPLATE))));
    public static final Item ONYX_LEGGINGS = registerItem("onyx_leggings",
            new ModArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ONYX, ArmorItem.Type.LEGGINGS))));
    public static final Item ONYX_BOOTS = registerItem("onyx_boots",
            new ModArmorItem(ModArmorMaterials.ONYX, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ONYX, ArmorItem.Type.BOOTS))));
    public static final Item GRAPHENE_CHAINMAIL_HELMET = registerItem("graphene_chainmail_helmet",
            new ModArmorItem(ModArmorMaterials.GRAPHENE_CHAINMAIL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.GRAPHENE_CHAINMAIL, ArmorItem.Type.HELMET))));
    public static final Item GRAPHENE_CHAINMAIL_CHESTPLATE = registerItem("graphene_chainmail_chestplate",
            new ModArmorItem(ModArmorMaterials.GRAPHENE_CHAINMAIL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.GRAPHENE_CHAINMAIL, ArmorItem.Type.CHESTPLATE))));
    public static final Item GRAPHENE_CHAINMAIL_LEGGINGS = registerItem("graphene_chainmail_leggings",
            new ModArmorItem(ModArmorMaterials.GRAPHENE_CHAINMAIL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.GRAPHENE_CHAINMAIL, ArmorItem.Type.LEGGINGS))));
    public static final Item GRAPHENE_CHAINMAIL_BOOTS = registerItem("graphene_chainmail_boots",
            new ModArmorItem(ModArmorMaterials.GRAPHENE_CHAINMAIL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.GRAPHENE_CHAINMAIL, ArmorItem.Type.BOOTS))));

    public static final Item ADAMANTIUM_HELMET = registerItem("adamantium_helmet",
            new ModArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ADAMANTIUM, ArmorItem.Type.HELMET))));
    public static final Item ADAMANTIUM_CHESTPLATE = registerItem("adamantium_chestplate",
            new ModArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ADAMANTIUM, ArmorItem.Type.CHESTPLATE))));
    public static final Item ADAMANTIUM_LEGGINGS = registerItem("adamantium_leggings",
            new ModArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ADAMANTIUM, ArmorItem.Type.LEGGINGS))));
    public static final Item ADAMANTIUM_BOOTS = registerItem("adamantium_boots",
            new ModArmorItem(ModArmorMaterials.ADAMANTIUM, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ADAMANTIUM, ArmorItem.Type.BOOTS))));

    public static final Item ENDERITE_HELMET = registerItem("enderite_helmet",
            new ModArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ENDERITE, ArmorItem.Type.HELMET))));
    public static final Item ENDERITE_CHESTPLATE = registerItem("enderite_chestplate",
            new ModArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ENDERITE, ArmorItem.Type.CHESTPLATE))));
    public static final Item ENDERITE_LEGGINGS = registerItem("enderite_leggings",
            new ModArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ENDERITE, ArmorItem.Type.LEGGINGS))));
    public static final Item ENDERITE_BOOTS = registerItem("enderite_boots",
            new ModArmorItem(ModArmorMaterials.ENDERITE, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ModArmorDurability.scale(ModArmorDurability.ENDERITE, ArmorItem.Type.BOOTS))));

    //All swords
    //p_i48460_2_: Attack Damage (1 = 1 Attack Point)
    //p_i48460_3_: Attack Speed (1.0F = ... Attack Speed)
    public static final Item TIN_SWORD = registerItem("tin_sword", new ModSwordItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TIN, 3, -2.4f))));
    public static final Item SILVER_SWORD = registerItem("silver_sword", new ModSwordItem(ModToolMaterials.SILVER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SILVER, 3, -2.4f))));
    public static final Item COPPER_SWORD = registerItem("copper_sword", new ModSwordItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER, 3, -2.4f))));
    public static final Item STERLING_SILVER_SWORD = registerItem("sterling_silver_sword", new ModSwordItem(ModToolMaterials.STERLING_SILVER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STERLING_SILVER, 3, -2.4f))));
    public static final Item ROSE_GOLD_SWORD = registerItem("rose_gold_sword", new ModSwordItem(ModToolMaterials.ROSE_GOLD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ROSE_GOLD, 3, -2.4f))));
    public static final Item BRONZE_SWORD = registerItem("bronze_sword", new ModSwordItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BRONZE, 3, -2.4f))));
    public static final Item COBALT_SWORD = registerItem("cobalt_sword", new ModSwordItem(ModToolMaterials.COBALT, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COBALT, 3, -2.4f))));
    public static final Item CARBON_STEEL_SWORD = registerItem("carbon_steel_sword", new ModSwordItem(ModToolMaterials.CARBON_STEEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CARBON_STEEL, 3, -2.4f))));
    public static final Item HARDENED_STEEL_SWORD = registerItem("hardened_steel_sword", new ModSwordItem(ModToolMaterials.HARDENED_STEEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.HARDENED_STEEL, 3, -2.4f))));

    public static final Item TURQUOISE_SWORD = registerItem("turquoise_sword", new ModSwordItem(ModToolMaterials.TURQUOISE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TURQUOISE, 3, -2.4f))));
    public static final Item LAPIS_LAZULI_SWORD = registerItem("lapis_lazuli_sword", new ModSwordItem(ModToolMaterials.LAPIS_LAZULI, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.LAPIS_LAZULI, 3, -2.4f))));
    public static final Item AMETHYST_SWORD = registerItem("amethyst_sword", new ModSwordItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 3, -2.4f))));

    public static final Item CITRINE_SWORD = registerItem("citrine_sword", new ModSwordItem(ModToolMaterials.CITRINE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CITRINE, 3, -2.4f))));
    public static final Item TANZANITE_SWORD = registerItem("tanzanite_sword", new ModSwordItem(ModToolMaterials.TANZANITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TANZANITE, 3, -2.4f))));
    public static final Item TOURMALINE_SWORD = registerItem("tourmaline_sword", new ModSwordItem(ModToolMaterials.TOURMALINE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TOURMALINE, 3, -2.4f))));
    public static final Item TOPAZ_SWORD = registerItem("topaz_sword", new ModSwordItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TOPAZ, 3, -2.4f))));

    public static final Item SPINEL_SWORD = registerItem("spinel_sword", new ModSwordItem(ModToolMaterials.SPINEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CITRINE, 3, -2.4f))));
    public static final Item EMERALD_SWORD = registerItem("emerald_sword", new ModSwordItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.EMERALD, 3, -2.4f))));
    public static final Item RUBY_SWORD = registerItem("ruby_sword", new ModSwordItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY, 3, -2.4f))));
    public static final Item SAPPHIRE_SWORD = registerItem("sapphire_sword", new ModSwordItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 3, -2.4f))));

    public static final Item MOISSANITE_SWORD = registerItem("moissanite_sword", new ModSwordItem(ModToolMaterials.MOISSANITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MOISSANITE, 3, -2.4f))));
    public static final Item ONYX_SWORD = registerItem("onyx_sword", new ModSwordItem(ModToolMaterials.ONYX, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ONYX, 3, -2.4f))));
    public static final Item OBSIDIAN_SWORD = registerItem("obsidian_sword", new ModSwordItem(ModToolMaterials.OBSIDIAN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, 3, -2.4f))));

//    public static final Item GRAPHENE_SWORD = registerItem("graphene_sword", new ModSwordItem(ModToolMaterials.GRAPHENE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.GRAPHENE, 3, -2.4f))));
    public static final Item ADAMANTIUM_SWORD = registerItem("adamantium_sword", new ModSwordItem(ModToolMaterials.ADAMANTIUM, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM, 3, -2.4f))));
    public static final Item ENDERITE_SWORD = registerItem("enderite_sword", new ModSwordItem(ModToolMaterials.ENDERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ENDERITE, 3, -2.4f))));

    //All battle_axes
    //p_i48460_2_: Attack Damage (1 = 1 Attack Point)
    //p_i48460_3_: Attack Speed (1.0F = ... Attack Speed)
    public static final Item WOODEN_BATTLE_AXE = registerItem("wood_battle_axe", new ModBattleAxeItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 5, -2.8f))));
    public static final Item STONE_BATTLE_AXE = registerItem("stone_battle_axe", new ModBattleAxeItem(ToolMaterials.STONE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 5, -2.8f))));
    public static final Item TIN_BATTLE_AXE = registerItem("tin_battle_axe", new ModBattleAxeItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TIN, 5, -2.8f))));
    public static final Item GOLD_BATTLE_AXE = registerItem("gold_battle_axe", new ModBattleAxeItem(ToolMaterials.GOLD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 5, -2.8f))));
    public static final Item SILVER_BATTLE_AXE = registerItem("silver_battle_axe", new ModBattleAxeItem(ModToolMaterials.STERLING_SILVER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STERLING_SILVER, 5, -2.8f))));
    public static final Item COPPER_BATTLE_AXE = registerItem("copper_battle_axe", new ModBattleAxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER, 5, -2.8f))));
    public static final Item STERLING_SILVER_BATTLE_AXE = registerItem("sterling_silver_battle_axe", new ModBattleAxeItem(ModToolMaterials.STERLING_SILVER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STERLING_SILVER, 5, -2.7f))));
    public static final Item ROSE_GOLD_BATTLE_AXE = registerItem("rose_gold_battle_axe", new ModBattleAxeItem(ModToolMaterials.ROSE_GOLD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STERLING_SILVER, 5, -2.7f))));
    public static final Item BRONZE_BATTLE_AXE = registerItem("bronze_battle_axe", new ModBattleAxeItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BRONZE, 5, -2.8f))));
    public static final Item IRON_BATTLE_AXE = registerItem("iron_battle_axe", new ModBattleAxeItem(ToolMaterials.IRON, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 5, -2.8f))));
    public static final Item COBALT_BATTLE_AXE = registerItem("cobalt_battle_axe", new ModBattleAxeItem(ModToolMaterials.COBALT, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COBALT, 5, -2.7f))));
    public static final Item CARBON_STEEL_BATTLE_AXE = registerItem("carbon_steel_battle_axe", new ModBattleAxeItem(ModToolMaterials.CARBON_STEEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CARBON_STEEL, 5, -2.7f))));
    public static final Item HARDENED_STEEL_BATTLE_AXE = registerItem("hardened_steel_battle_axe", new ModBattleAxeItem(ModToolMaterials.HARDENED_STEEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CARBON_STEEL, 5, -2.7f))));

    public static final Item TURQUOISE_BATTLE_AXE = registerItem("turquoise_battle_axe", new ModBattleAxeItem(ModToolMaterials.TURQUOISE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TURQUOISE, 5, -2.6f))));
    public static final Item LAPIS_LAZULI_BATTLE_AXE = registerItem("lapis_lazuli_battle_axe", new ModBattleAxeItem(ModToolMaterials.LAPIS_LAZULI, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.LAPIS_LAZULI, 5, -2.6f))));
    public static final Item AMETHYST_BATTLE_AXE = registerItem("amethyst_battle_axe", new ModBattleAxeItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 5, -2.7f))));
    public static final Item TANZANITE_BATTLE_AXE = registerItem("tanzanite_battle_axe", new ModBattleAxeItem(ModToolMaterials.TANZANITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TANZANITE, 5, -2.5f))));
    public static final Item TOURMALINE_BATTLE_AXE = registerItem("tourmaline_battle_axe", new ModBattleAxeItem(ModToolMaterials.TOURMALINE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TOURMALINE, 5, -2.5f))));
    public static final Item TOPAZ_BATTLE_AXE = registerItem("topaz_battle_axe", new ModBattleAxeItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TOPAZ, 5, -2.5f))));

    public static final Item EMERALD_BATTLE_AXE = registerItem("emerald_battle_axe", new ModBattleAxeItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.EMERALD, 5, -2.7f))));
    public static final Item DIAMOND_BATTLE_AXE = registerItem("diamond_battle_axe", new ModBattleAxeItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5, -2.8f))));
    public static final Item RUBY_BATTLE_AXE = registerItem("ruby_battle_axe", new ModBattleAxeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY, 5, -2.6f))));
    public static final Item SAPPHIRE_BATTLE_AXE = registerItem("sapphire_battle_axe", new ModBattleAxeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 5, -2.6f))));
    public static final Item SPINEL_BATTLE_AXE = registerItem("spinel_battle_axe", new ModBattleAxeItem(ModToolMaterials.SPINEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CITRINE, 5, -2.5f))));

    public static final Item CITRINE_BATTLE_AXE = registerItem("citrine_battle_axe", new ModBattleAxeItem(ModToolMaterials.CITRINE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CITRINE, 5, -2.5f))));
    public static final Item MOISSANITE_BATTLE_AXE = registerItem("moissanite_battle_axe", new ModBattleAxeItem(ModToolMaterials.MOISSANITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MOISSANITE, 5, -2.6f))));
    public static final Item ONYX_BATTLE_AXE = registerItem("onyx_battle_axe", new ModBattleAxeItem(ModToolMaterials.ONYX, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ONYX, 5, -2.6f))));

    public static final Item OBSIDIAN_BATTLE_AXE = registerItem("obsidian_battle_axe", new ModBattleAxeItem(ModToolMaterials.OBSIDIAN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, 5, -2.7f))));
    public static final Item NETHERITE_BATTLE_AXE = registerItem("netherite_battle_axe", new ModBattleAxeItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 5, -2.8f))));
//    public static final Item GRAPHENE_BATTLE_AXE = registerItem("graphene_battle_axe", new ModBattleAxeItem(ModToolMaterials.GRAPHENE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.GRAPHENE, 5, -2.6f))));
    public static final Item ADAMANTIUM_BATTLE_AXE = registerItem("adamantium_battle_axe", new ModBattleAxeItem(ModToolMaterials.ADAMANTIUM, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM, 5, -2.6f))));
    public static final Item ENDERITE_BATTLE_AXE = registerItem("enderite_battle_axe", new ModBattleAxeItem(ModToolMaterials.ENDERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ENDERITE, 5, -2.6f))));


    //All battle_maces
    //p_i48460_2_: Attack Damage (1 = 1 Attack Point)
    //p_i48460_3_: Attack Speed (1.0F = ... Attack Speed)
    //TODO Check attack speed
    public static final Item WOODEN_BATTLE_MACE = registerItem("wood_battle_mace", new ModSwordItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD,
    3, -2.2f))));
    public static final Item STONE_BATTLE_MACE = registerItem("stone_battle_mace", new ModSwordItem(ToolMaterials.STONE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE,
    3, -2.2f))));
    public static final Item TIN_BATTLE_MACE = registerItem("tin_battle_mace", new ModSwordItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TIN,
    3, -2.2f))));
    public static final Item GOLD_BATTLE_MACE = registerItem("gold_battle_mace", new ModSwordItem(ToolMaterials.GOLD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD,
    3, -2.2f))));
    public static final Item SILVER_BATTLE_MACE = registerItem("silver_battle_mace", new ModSwordItem(ModToolMaterials.SILVER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SILVER,
    3, -2.2f))));
    public static final Item COPPER_BATTLE_MACE = registerItem("copper_battle_mace", new ModSwordItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER,
    3, -2.2f))));
    public static final Item STERLING_SILVER_BATTLE_MACE = registerItem("sterling_silver_battle_mace", new ModSwordItem(ModToolMaterials.STERLING_SILVER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STERLING_SILVER,
    3, -2.1f))));
    public static final Item ROSE_GOLD_BATTLE_MACE = registerItem("rose_gold_battle_mace", new ModSwordItem(ModToolMaterials.ROSE_GOLD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ROSE_GOLD,
    3, -2.1f))));
    public static final Item BRONZE_BATTLE_MACE = registerItem("bronze_battle_mace", new ModSwordItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BRONZE,
    3, -2.2f))));
    public static final Item IRON_BATTLE_MACE = registerItem("iron_battle_mace", new ModSwordItem(ToolMaterials.IRON, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON,
    3, -2.2f))));
    public static final Item COBALT_BATTLE_MACE = registerItem("cobalt_battle_mace", new ModSwordItem(ModToolMaterials.COBALT, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COBALT,
    3, -2.1f))));
    public static final Item CARBON_STEEL_BATTLE_MACE = registerItem("carbon_steel_battle_mace", new ModSwordItem(ModToolMaterials.CARBON_STEEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CARBON_STEEL,
    3, -2.1f))));
    public static final Item HARDENED_STEEL_BATTLE_MACE = registerItem("hardened_steel_battle_mace", new ModSwordItem(ModToolMaterials.HARDENED_STEEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CARBON_STEEL,
    3, -2.1f))));
    public static final Item TURQUOISE_BATTLE_MACE = registerItem("turquoise_battle_mace", new ModSwordItem(ModToolMaterials.TURQUOISE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TURQUOISE,
    3, -2.0f))));
    public static final Item LAPIS_LAZULI_BATTLE_MACE = registerItem("lapis_lazuli_battle_mace", new ModSwordItem(ModToolMaterials.LAPIS_LAZULI, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.LAPIS_LAZULI,
    3, -2.0f))));
    public static final Item AMETHYST_BATTLE_MACE = registerItem("amethyst_battle_mace", new ModSwordItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST,
    3, -2.1f))));
    public static final Item TANZANITE_BATTLE_MACE = registerItem("tanzanite_battle_mace", new ModSwordItem(ModToolMaterials.TANZANITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TANZANITE,
    3, -2.0f))));
    public static final Item TOURMALINE_BATTLE_MACE = registerItem("tourmaline_battle_mace", new ModSwordItem(ModToolMaterials.TOURMALINE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TOURMALINE,
    3, -2.1f))));
    public static final Item TOPAZ_BATTLE_MACE = registerItem("topaz_battle_mace", new ModSwordItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TOPAZ,
    3, -2.1f))));
    public static final Item EMERALD_BATTLE_MACE = registerItem("emerald_battle_mace", new ModSwordItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.EMERALD,
    3, -2.1f))));
    public static final Item DIAMOND_BATTLE_MACE = registerItem("diamond_battle_mace", new ModSwordItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND,
    3, -2.1f))));
    public static final Item RUBY_BATTLE_MACE = registerItem("ruby_battle_mace", new ModSwordItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY,
    3, -2.0f))));
    public static final Item SAPPHIRE_BATTLE_MACE = registerItem("sapphire_battle_mace", new ModSwordItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE,
    3, -2.0f))));
    public static final Item SPINEL_BATTLE_MACE = registerItem("spinel_battle_mace", new ModSwordItem(ModToolMaterials.SPINEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SPINEL,
    3, -2.0f))));
    public static final Item CITRINE_BATTLE_MACE = registerItem("citrine_battle_mace", new ModSwordItem(ModToolMaterials.CITRINE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CITRINE,
    3, -2.1f))));
    public static final Item MOISSANITE_BATTLE_MACE = registerItem("moissanite_battle_mace", new ModSwordItem(ModToolMaterials.MOISSANITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MOISSANITE,
    3, -2.0f))));
    public static final Item ONYX_BATTLE_MACE = registerItem("onyx_battle_mace", new ModSwordItem(ModToolMaterials.ONYX, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ONYX,
    3, -2.0f))));
    public static final Item OBSIDIAN_BATTLE_MACE = registerItem("obsidian_battle_mace", new ModSwordItem(ModToolMaterials.OBSIDIAN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN,
    3, -2.1f))));
    public static final Item NETHERITE_BATTLE_MACE = registerItem("netherite_battle_mace", new ModSwordItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE,
    3, -2.0f))));
//    public static final Item GRAPHENE_BATTLE_MACE = registerItem("graphene_battle_mace", new ModSwordItem(ModToolMaterials.GRAPHENE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.GRAPHENE, 3, -2.0f))));
    public static final Item ADAMANTIUM_BATTLE_MACE = registerItem("adamantium_battle_mace", new ModSwordItem(ModToolMaterials.ADAMANTIUM, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM,
    3, -2.0f))));
    public static final Item ENDERITE_BATTLE_MACE = registerItem("enderite_battle_mace", new ModSwordItem(ModToolMaterials.ENDERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ENDERITE,
    3, -2.0f))));


    //All daggers
    //p_i48460_2_: Attack Damage (1 = 1 Attack Point)
    //p_i48460_3_: Attack Speed (1.0F = ... Attack Speed)
    public static final Item WOODEN_DAGGER = registerItem("wood_dagger", new ModSwordItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD,
    1, -1.8f))));
    public static final Item STONE_DAGGER = registerItem("stone_dagger", new ModSwordItem(ToolMaterials.STONE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE,
    1, -1.8f))));
    public static final Item TIN_DAGGER = registerItem("tin_dagger", new ModSwordItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TIN,
    1, -1.8f))));
    public static final Item GOLD_DAGGER = registerItem("gold_dagger", new ModSwordItem(ToolMaterials.GOLD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD,
    1, -1.8f))));
    public static final Item SILVER_DAGGER = registerItem("silver_dagger", new ModSwordItem(ModToolMaterials.SILVER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SILVER,
    1, -1.8f))));
    public static final Item COPPER_DAGGER = registerItem("copper_dagger", new ModSwordItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER,
    1, -1.8f))));
    public static final Item STERLING_SILVER_DAGGER = registerItem("sterling_silver_dagger", new ModSwordItem(ModToolMaterials.STERLING_SILVER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STERLING_SILVER,
    1, -1.8f))));
    public static final Item ROSE_GOLD_DAGGER = registerItem("rose_gold_dagger", new ModSwordItem(ModToolMaterials.ROSE_GOLD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ROSE_GOLD,
    1, -1.8f))));
    public static final Item BRONZE_DAGGER = registerItem("bronze_dagger", new ModSwordItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BRONZE,
    1, -1.8f))));
    public static final Item IRON_DAGGER = registerItem("iron_dagger", new ModSwordItem(ToolMaterials.IRON, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON,
    1, -1.8f))));
    public static final Item COBALT_DAGGER = registerItem("cobalt_dagger", new ModSwordItem(ModToolMaterials.COBALT, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COBALT,
    1, -1.8f))));
    public static final Item CARBON_STEEL_DAGGER = registerItem("carbon_steel_dagger", new ModSwordItem(ModToolMaterials.CARBON_STEEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CARBON_STEEL,
    1, -1.8f))));
    public static final Item HARDENED_STEEL_DAGGER = registerItem("hardened_steel_dagger", new ModSwordItem(ModToolMaterials.HARDENED_STEEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.HARDENED_STEEL,
    1, -1.8f))));

    public static final Item TURQUOISE_DAGGER = registerItem("turquoise_dagger", new ModSwordItem(ModToolMaterials.TURQUOISE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TURQUOISE, 1, -1.7f))));
    public static final Item LAPIS_LAZULI_DAGGER = registerItem("lapis_lazuli_dagger", new ModSwordItem(ModToolMaterials.LAPIS_LAZULI, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.LAPIS_LAZULI, 1, -1.7f))));
    public static final Item AMETHYST_DAGGER = registerItem("amethyst_dagger", new ModSwordItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 1, -1.8f))));
    public static final Item TANZANITE_DAGGER = registerItem("tanzanite_dagger", new ModSwordItem(ModToolMaterials.TANZANITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TANZANITE, 1, -1.7f))));
    public static final Item TOURMALINE_DAGGER = registerItem("tourmaline_dagger", new ModSwordItem(ModToolMaterials.TOURMALINE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TOURMALINE, 1, -1.7f))));
    public static final Item TOPAZ_DAGGER = registerItem("topaz_dagger", new ModSwordItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TOPAZ, 1, -1.7f))));
    public static final Item EMERALD_DAGGER = registerItem("emerald_dagger", new ModSwordItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.EMERALD, 1, -1.8f))));
    public static final Item DIAMOND_DAGGER = registerItem("diamond_dagger", new ModSwordItem(ToolMaterials.DIAMOND, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -1.7f))));
    public static final Item RUBY_DAGGER = registerItem("ruby_dagger", new ModSwordItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY, 1, -1.7f))));
    public static final Item SAPPHIRE_DAGGER = registerItem("sapphire_dagger", new ModSwordItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 1, -1.7f))));
    public static final Item SPINEL_DAGGER = registerItem("spinel_dagger", new ModSwordItem(ModToolMaterials.SPINEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SPINEL, 1, -1.7f))));
    public static final Item CITRINE_DAGGER = registerItem("citrine_dagger", new ModSwordItem(ModToolMaterials.CITRINE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CITRINE, 1, -1.7f))));
    public static final Item MOISSANITE_DAGGER = registerItem("moissanite_dagger", new ModSwordItem(ModToolMaterials.MOISSANITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MOISSANITE, 1, -1.7f))));
    public static final Item ONYX_DAGGER = registerItem("onyx_dagger", new ModSwordItem(ModToolMaterials.ONYX, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ONYX, 1, -1.6f))));
    public static final Item OBSIDIAN_DAGGER = registerItem("obsidian_dagger", new ModSwordItem(ModToolMaterials.OBSIDIAN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN, 1, -1.8f))));
    public static final Item NETHERITE_DAGGER = registerItem("netherite_dagger", new ModSwordItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 1, -1.6f))));
//    public static final Item GRAPHENE_DAGGER = registerItem("graphene_dagger", new ModSwordItem(ModToolMaterials.GRAPHENE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.GRAPHENE, 1, -1.5f))));
    public static final Item ADAMANTIUM_DAGGER = registerItem("adamantium_dagger", new ModSwordItem(ModToolMaterials.ADAMANTIUM, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM, 1, -1.5f))));
    public static final Item ENDERITE_DAGGER = registerItem("enderite_dagger", new ModSwordItem(ModToolMaterials.ENDERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ENDERITE, 1, -1.5f))));

    public static final Item ROSE_GOLD_SPEAR = registerItem("rose_gold_spear", new ModSpearItem(ModToolMaterials.ROSE_GOLD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ROSE_GOLD,
                0, -2.95f)).maxCount(1)));
    public static final Item CARBON_STEEL_SPEAR = registerItem("carbon_steel_spear", new ModSpearItem(ModToolMaterials.CARBON_STEEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CARBON_STEEL,
                0, -2.95f)).maxCount(1)));
    public static final Item HARDENED_STEEL_SPEAR = registerItem("hardened_steel_spear", new ModSpearItem(ModToolMaterials.HARDENED_STEEL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.HARDENED_STEEL,
                0, -3.00f)).maxCount(1)));
    public static final Item ENDERITE_SPEAR = registerItem("enderite_spear", new ModSpearItem(ModToolMaterials.ENDERITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ENDERITE,
                0, -3.20f)).maxCount(1)));

    // All pickaxes
    public static final Item TIN_PICKAXE = registerItem("tin_pickaxe", new ModPickaxeItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TIN,
    1, -2.8F))));
    public static final Item SILVER_PICKAXE = registerItem("silver_pickaxe", new ModPickaxeItem(ModToolMaterials.SILVER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SILVER,
    1, -2.8F))));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", new ModPickaxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER,
    1, -2.8F))));
    public static final Item STERLING_SILVER_PICKAXE = registerItem("sterling_silver_pickaxe", new ModPickaxeItem(ModToolMaterials.STERLING_SILVER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.STERLING_SILVER,
    1, -2.8F))));
    public static final Item ROSE_GOLD_PICKAXE = registerItem("rose_gold_pickaxe", new ModPickaxeItem(ModToolMaterials.ROSE_GOLD, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ROSE_GOLD,
    1, -2.8F))));
    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe", new ModPickaxeItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BRONZE,
    1, -2.8F))));
    public static final Item COBALT_PICKAXE = registerItem("cobalt_pickaxe", new ModPickaxeItem(ModToolMaterials.COBALT, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COBALT,
    1, -2.8F))));
    public static final Item CARBON_STEEL_PICKAXE = registerItem("carbon_steel_pickaxe", new ModPickaxeItem(ModToolMaterials.CARBON_STEEL, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.CARBON_STEEL,
    1, -2.8F))));
    public static final Item HARDENED_STEEL_PICKAXE = registerItem("hardened_steel_pickaxe", new ModPickaxeItem(ModToolMaterials.HARDENED_STEEL, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.HARDENED_STEEL,
    1, -2.8F))));
    public static final Item TURQUOISE_PICKAXE = registerItem("turquoise_pickaxe", new ModPickaxeItem(ModToolMaterials.TURQUOISE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TURQUOISE,
    1, -2.8F))));
    public static final Item LAPIS_LAZULI_PICKAXE = registerItem("lapis_lazuli_pickaxe", new ModPickaxeItem(ModToolMaterials.LAPIS_LAZULI, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.LAPIS_LAZULI,
    1, -2.8F))));
    public static final Item AMETHYST_PICKAXE = registerItem("amethyst_pickaxe", new ModPickaxeItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.AMETHYST,
    1, -2.8F))));
    public static final Item CITRINE_PICKAXE = registerItem("citrine_pickaxe", new ModPickaxeItem(ModToolMaterials.CITRINE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.CITRINE,
    1, -2.8F))));
    public static final Item ONYX_PICKAXE = registerItem("onyx_pickaxe", new ModPickaxeItem(ModToolMaterials.ONYX, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ONYX,
    1, -2.8F))));
    public static final Item TANZANITE_PICKAXE = registerItem("tanzanite_pickaxe", new ModPickaxeItem(ModToolMaterials.TANZANITE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TANZANITE,
    1, -2.8F))));
    public static final Item TOURMALINE_PICKAXE = registerItem("tourmaline_pickaxe", new ModPickaxeItem(ModToolMaterials.TOURMALINE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TOURMALINE,
    1, -2.8F))));
    public static final Item TOPAZ_PICKAXE = registerItem("topaz_pickaxe", new ModPickaxeItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TOPAZ,
    1, -2.8F))));
    public static final Item SPINEL_PICKAXE = registerItem("spinel_pickaxe", new ModPickaxeItem(ModToolMaterials.SPINEL, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SPINEL,
    1, -2.8F))));
    public static final Item EMERALD_PICKAXE = registerItem("emerald_pickaxe", new ModPickaxeItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.EMERALD,
    1, -2.8F))));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new ModPickaxeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.RUBY,
    1, -2.8F))));
    public static final Item SAPPHIRE_PICKAXE = registerItem("sapphire_pickaxe", new ModPickaxeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE,
    1, -2.8F))));
    public static final Item MOISSANITE_PICKAXE = registerItem("moissanite_pickaxe", new ModPickaxeItem(ModToolMaterials.MOISSANITE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.MOISSANITE,
    1, -2.8F))));
    public static final Item OBSIDIAN_PICKAXE = registerItem("obsidian_pickaxe", new ModPickaxeItem(ModToolMaterials.OBSIDIAN, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN,
    1, -2.8F))));
//    public static final Item GRAPHENE_PICKAXE = registerItem("graphene_pickaxe", new ModPickaxeItem(ModToolMaterials.GRAPHENE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.GRAPHENE,
//    1, -2.8F))));
    public static final Item ADAMANTIUM_PICKAXE = registerItem("adamantium_pickaxe", new ModPickaxeItem(ModToolMaterials.ADAMANTIUM, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM,
    1, -2.8F))));
    public static final Item ENDERITE_PICKAXE = registerItem("enderite_pickaxe", new ModPickaxeItem(ModToolMaterials.ENDERITE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ENDERITE,
    1, -2.8F))));


    // All axes
    public static final Item TIN_AXE = registerItem("tin_axe", new ModAxeItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.TIN,
    6.0F, -3.2F))));
    public static final Item SILVER_AXE = registerItem("silver_axe", new ModAxeItem(ModToolMaterials.SILVER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SILVER,
    6.0F, -3.2F))));
    public static final Item COPPER_AXE = registerItem("copper_axe", new ModAxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.COPPER,
    6.0F, -3.2F))));
    public static final Item STERLING_SILVER_AXE = registerItem("sterling_silver_axe", new ModAxeItem(ModToolMaterials.STERLING_SILVER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.STERLING_SILVER,
    6.0F, -3.2F))));
    public static final Item ROSE_GOLD_AXE = registerItem("rose_gold_axe", new ModAxeItem(ModToolMaterials.ROSE_GOLD, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ROSE_GOLD,
    6.0F, -3.2F))));
    public static final Item BRONZE_AXE = registerItem("bronze_axe", new ModAxeItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.BRONZE,
    6.0F, -3.2F))));
    public static final Item COBALT_AXE = registerItem("cobalt_axe", new ModAxeItem(ModToolMaterials.COBALT, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.COBALT,
    6.0F, -3.2F))));
    public static final Item CARBON_STEEL_AXE = registerItem("carbon_steel_axe", new ModAxeItem(ModToolMaterials.CARBON_STEEL, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.CARBON_STEEL,
    6.0F, -3.2F))));
    public static final Item HARDENED_STEEL_AXE = registerItem("hardened_steel_axe", new ModAxeItem(ModToolMaterials.HARDENED_STEEL, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.HARDENED_STEEL,
    6.0F, -3.2F))));
    public static final Item LAPIS_LAZULI_AXE = registerItem("lapis_lazuli_axe", new ModAxeItem(ModToolMaterials.LAPIS_LAZULI, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.LAPIS_LAZULI,
    6.0F, -3.2F))));
    public static final Item AMETHYST_AXE = registerItem("amethyst_axe", new ModAxeItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.AMETHYST,
    6.0F, -3.2F))));
    public static final Item TANZANITE_AXE = registerItem("tanzanite_axe", new ModAxeItem(ModToolMaterials.TANZANITE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.TANZANITE,
    6.0F, -3.2F))));
    public static final Item TURQUOISE_AXE = registerItem("turquoise_axe", new ModAxeItem(ModToolMaterials.TURQUOISE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.TURQUOISE,
    6.0F, -3.2F))));
    public static final Item TOURMALINE_AXE = registerItem("tourmaline_axe", new ModAxeItem(ModToolMaterials.TOURMALINE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.TOURMALINE,
    6.0F, -3.2F))));
    public static final Item TOPAZ_AXE = registerItem("topaz_axe", new ModAxeItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.TOPAZ,
    6.0F, -3.2F))));
    public static final Item EMERALD_AXE = registerItem("emerald_axe", new ModAxeItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.EMERALD,
    6.0F, -3.2F))));
    public static final Item RUBY_AXE = registerItem("ruby_axe", new ModAxeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.RUBY,
    6.0F, -3.2F))));
    public static final Item SAPPHIRE_AXE = registerItem("sapphire_axe", new ModAxeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE,
    6.0F, -3.2F))));
    public static final Item SPINEL_AXE = registerItem("spinel_axe", new ModAxeItem(ModToolMaterials.SPINEL, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SPINEL,
    6.0F, -3.2F))));
    public static final Item CITRINE_AXE = registerItem("citrine_axe", new ModAxeItem(ModToolMaterials.CITRINE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.CITRINE,
    6.0F, -3.2F))));
    public static final Item MOISSANITE_AXE = registerItem("moissanite_axe", new ModAxeItem(ModToolMaterials.MOISSANITE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.MOISSANITE,
    6.0F, -3.2F))));
    public static final Item ONYX_AXE = registerItem("onyx_axe", new ModAxeItem(ModToolMaterials.ONYX, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ONYX,
    6.0F, -3.2F))));
    public static final Item OBSIDIAN_AXE = registerItem("obsidian_axe", new ModAxeItem(ModToolMaterials.OBSIDIAN, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN,
    6.0F, -3.2F))));
//    public static final Item GRAPHENE_AXE = registerItem("graphene_axe",new ModAxeItem(ModToolMaterials.GRAPHENE,new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.GRAPHENE,
//    6.0F, -3.2F))));
    public static final Item ADAMANTIUM_AXE = registerItem("adamantium_axe", new ModAxeItem(ModToolMaterials.ADAMANTIUM, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM,
    6.0F, -3.2F))));
    public static final Item ENDERITE_AXE = registerItem("enderite_axe", new ModAxeItem(ModToolMaterials.ENDERITE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ENDERITE,
    6.0F, -3.2F))));


    // All shovels
    public static final Item TIN_SHOVEL = registerItem("tin_shovel", new ModShovelItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.TIN,
    1.5F, -3.0F))));
    public static final Item SILVER_SHOVEL = registerItem("silver_shovel", new ModShovelItem(ModToolMaterials.SILVER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SILVER,
    1.5F, -3.0F))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel", new ModShovelItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.COPPER,
    1.5F, -3.0F))));
    public static final Item STERLING_SILVER_SHOVEL = registerItem("sterling_silver_shovel", new ModShovelItem(ModToolMaterials.STERLING_SILVER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.STERLING_SILVER,
    1.5F, -3.0F))));
    public static final Item ROSE_GOLD_SHOVEL = registerItem("rose_gold_shovel", new ModShovelItem(ModToolMaterials.ROSE_GOLD, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ROSE_GOLD,
    1.5F, -3.0F))));
    public static final Item BRONZE_SHOVEL = registerItem("bronze_shovel", new ModShovelItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.BRONZE,
    1.5F, -3.0F))));
    public static final Item COBALT_SHOVEL = registerItem("cobalt_shovel", new ModShovelItem(ModToolMaterials.COBALT, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.COBALT,
    1.5F, -3.0F))));
    public static final Item CARBON_STEEL_SHOVEL = registerItem("carbon_steel_shovel", new ModShovelItem(ModToolMaterials.CARBON_STEEL, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.CARBON_STEEL,
    1.5F, -3.0F))));
    public static final Item HARDENED_STEEL_SHOVEL = registerItem("hardened_steel_shovel", new ModShovelItem(ModToolMaterials.HARDENED_STEEL, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.HARDENED_STEEL,
    1.5F, -3.0F))));
    public static final Item LAPIS_LAZULI_SHOVEL = registerItem("lapis_lazuli_shovel", new ModShovelItem(ModToolMaterials.LAPIS_LAZULI, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.LAPIS_LAZULI,
    1.5F, -3.0F))));
    public static final Item AMETHYST_SHOVEL = registerItem("amethyst_shovel", new ModShovelItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.AMETHYST,
    1.5F, -3.0F))));
    public static final Item TURQUOISE_SHOVEL = registerItem("turquoise_shovel", new ModShovelItem(ModToolMaterials.TURQUOISE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.TURQUOISE,
    1.5F, -3.0F))));
    public static final Item TANZANITE_SHOVEL = registerItem("tanzanite_shovel", new ModShovelItem(ModToolMaterials.TANZANITE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.TANZANITE,
    1.5F, -3.0F))));
    public static final Item TOURMALINE_SHOVEL = registerItem("tourmaline_shovel", new ModShovelItem(ModToolMaterials.TOURMALINE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.TOURMALINE,
    1.5F, -3.0F))));
    public static final Item TOPAZ_SHOVEL = registerItem("topaz_shovel", new ModShovelItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.TOPAZ,
    1.5F, -3.0F))));
    public static final Item EMERALD_SHOVEL = registerItem("emerald_shovel", new ModShovelItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.EMERALD,
    1.5F, -3.0F))));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ModShovelItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.RUBY,
    1.5F, -3.0F))));
    public static final Item SAPPHIRE_SHOVEL = registerItem("sapphire_shovel", new ModShovelItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE,
    1.5F, -3.0F))));
    public static final Item SPINEL_SHOVEL = registerItem("spinel_shovel", new ModShovelItem(ModToolMaterials.SPINEL, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SPINEL,
    1.5F, -3.0F))));
    public static final Item CITRINE_SHOVEL = registerItem("citrine_shovel", new ModShovelItem(ModToolMaterials.CITRINE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.CITRINE,
    1.5F, -3.0F))));
    public static final Item MOISSANITE_SHOVEL = registerItem("moissanite_shovel", new ModShovelItem(ModToolMaterials.MOISSANITE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.MOISSANITE,
    1.5F, -3.0F))));
    public static final Item ONYX_SHOVEL = registerItem("onyx_shovel", new ModShovelItem(ModToolMaterials.ONYX, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ONYX,
    1.5F, -3.0F))));
    public static final Item OBSIDIAN_SHOVEL = registerItem("obsidian_shovel",new ModShovelItem(ModToolMaterials.OBSIDIAN, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN,
    1.5F, -3.0F))));
//    public static final Item GRAPHENE_SHOVEL = registerItem("graphene_shovel",new ModShovelItem(ModToolMaterials.GRAPHENE,new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.GRAPHENE,
                //    1.5F, -3.0F))));
    public static final Item ADAMANTIUM_SHOVEL = registerItem("adamantium_shovel", new ModShovelItem(ModToolMaterials.ADAMANTIUM, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM,
    1.5F, -3.0F))));
    public static final Item ENDERITE_SHOVEL = registerItem("enderite_shovel", new ModShovelItem(ModToolMaterials.ENDERITE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ENDERITE,
    1.5F, -3.0F))));


    // All hoes
    public static final Item TIN_HOE = registerItem("tin_hoe", new ModHoeItem(ModToolMaterials.TIN, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.TIN,
    0, -3.0F))));
    public static final Item SILVER_HOE = registerItem("silver_hoe", new ModHoeItem(ModToolMaterials.SILVER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.SILVER,
    0, -3.0F))));
    public static final Item COPPER_HOE = registerItem("copper_hoe", new ModHoeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COPPER,
    0, -3.0F))));
    public static final Item STERLING_SILVER_HOE = registerItem("sterling_silver_hoe", new ModHoeItem(ModToolMaterials.STERLING_SILVER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.STERLING_SILVER,
    0, -3.0F))));
    public static final Item ROSE_GOLD_HOE = registerItem("rose_gold_hoe", new ModHoeItem(ModToolMaterials.ROSE_GOLD, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ROSE_GOLD,
    0, -3.0F))));
    public static final Item BRONZE_HOE = registerItem("bronze_hoe", new ModHoeItem(ModToolMaterials.BRONZE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.BRONZE,
    0, -3.0F))));
    public static final Item COBALT_HOE = registerItem("cobalt_hoe", new ModHoeItem(ModToolMaterials.COBALT, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COBALT,
    0, -3.0F))));
    public static final Item CARBON_STEEL_HOE = registerItem("carbon_steel_hoe", new ModHoeItem(ModToolMaterials.CARBON_STEEL, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.CARBON_STEEL,
    0, -3.0F))));
    public static final Item HARDENED_STEEL_HOE = registerItem("hardened_steel_hoe", new ModHoeItem(ModToolMaterials.HARDENED_STEEL, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.HARDENED_STEEL,
    0, -3.0F))));
    public static final Item LAPIS_LAZULI_HOE = registerItem("lapis_lazuli_hoe", new ModHoeItem(ModToolMaterials.LAPIS_LAZULI, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.LAPIS_LAZULI,
    0, -3.0F))));
    public static final Item TURQUOISE_HOE = registerItem("turquoise_hoe", new ModHoeItem(ModToolMaterials.TURQUOISE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.TURQUOISE,
    0, -3.0F))));
    public static final Item TANZANITE_HOE = registerItem("tanzanite_hoe", new ModHoeItem(ModToolMaterials.TANZANITE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.TANZANITE,
    0, -3.0F))));
    public static final Item AMETHYST_HOE = registerItem("amethyst_hoe", new ModHoeItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.AMETHYST,
    0, -3.0F))));
    public static final Item TOPAZ_HOE = registerItem("topaz_hoe", new ModHoeItem(ModToolMaterials.TOPAZ, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.TOPAZ,
    0, -3.0F))));
    public static final Item TOURMALINE_HOE = registerItem("tourmaline_hoe", new ModHoeItem(ModToolMaterials.TOURMALINE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.TOURMALINE,
    0, -3.0F))));
    public static final Item EMERALD_HOE = registerItem("emerald_hoe", new ModHoeItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.EMERALD,
    0, -3.0F))));
    public static final Item RUBY_HOE = registerItem("ruby_hoe", new ModHoeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.RUBY,
    0, -3.0F))));
    public static final Item SAPPHIRE_HOE = registerItem("sapphire_hoe", new ModHoeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE,
    0, -3.0F))));
    public static final Item SPINEL_HOE = registerItem("spinel_hoe", new ModHoeItem(ModToolMaterials.SPINEL, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.SPINEL,
    0, -3.0F))));
    public static final Item CITRINE_HOE = registerItem("citrine_hoe", new ModHoeItem(ModToolMaterials.CITRINE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.CITRINE,
    0, -3.0F))));
    public static final Item MOISSANITE_HOE = registerItem("moissanite_hoe", new ModHoeItem(ModToolMaterials.MOISSANITE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.MOISSANITE,
    0, -3.0F))));
    public static final Item ONYX_HOE = registerItem("onyx_hoe", new ModHoeItem(ModToolMaterials.ONYX, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ONYX,
    0, -3.0F))));
    public static final Item OBSIDIAN_HOE = registerItem("obsidian_hoe", new ModHoeItem(ModToolMaterials.OBSIDIAN, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.OBSIDIAN,
    0, -3.0F))));
//    public static final Item GRAPHENE_HOE = registerItem("graphene_hoe",new ModHoeItem(ModToolMaterials.GRAPHENE,new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.GRAPHENE,
//    0, -3.0F))));
    public static final Item ADAMANTIUM_HOE = registerItem("adamantium_hoe", new ModHoeItem(ModToolMaterials.ADAMANTIUM,new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ADAMANTIUM,
    0, -3.0F))));
    public static final Item ENDERITE_HOE = registerItem("enderite_hoe", new ModHoeItem(ModToolMaterials.ENDERITE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ENDERITE,
    0, -3.0F))));


    //Vanilla tools
    //W.I.P.

    //TODO CHECK STATS
    //Shields
    public static final Item TIN_SHIELD = registerItem("tin_shield", new ModShieldItem(new Item.Settings().maxDamage(84), 10, 5, ModItems.TIN_INGOT)); // ModShieldItem(maxDamage(durability), cooldownTicks, enchantability, repairItems)
//    public static final Item GOLD_SHIELD = registerItem("gold_shield", new ModShieldItem(new Item.Settings().maxDamage(84), 10, 5, Items.GOLD_INGOT)); // ModShieldItem(maxDamage(durability), cooldownTicks, enchantability, repairItems)
    public static final Item SILVER_SHIELD = registerItem("silver_shield", new ModShieldItem(new Item.Settings().maxDamage(134), 10, 15, ModItems.SILVER_INGOT));
    public static final Item COPPER_SHIELD = registerItem("copper_shield", new ModShieldItem(new Item.Settings().maxDamage(112), 10, 10, Items.COPPER_INGOT));
    public static final Item STERLING_SILVER_SHIELD = registerItem("sterling_silver_shield", new ModShieldItem(new Item.Settings().maxDamage(333), 10, 17, ModItems.STERLING_SILVER_INGOT));
    public static final Item ROSE_GOLD_SHIELD = registerItem("rose_gold_shield", new ModShieldItem(new Item.Settings().maxDamage(333), 10, 17, ModItems.ROSE_GOLD_INGOT));
    public static final Item BRONZE_SHIELD = registerItem("bronze_shield", new ModShieldItem(new Item.Settings().maxDamage(299), 10, 13, ModItems.BRONZE_INGOT));
    public static final Item COBALT_SHIELD = registerItem("cobalt_shield", new ModShieldItem(new Item.Settings().maxDamage(388), 10, 22, ModItems.COBALT_INGOT));
    public static final Item CARBON_STEEL_SHIELD = registerItem("carbon_steel_shield", new ModShieldItem(new Item.Settings().maxDamage(555), 10, 14, ModItems.CARBON_STEEL_INGOT));
    public static final Item HARDENED_STEEL_SHIELD = registerItem("hardened_steel_shield", new ModShieldItem(new Item.Settings().maxDamage(555), 10, 14, ModItems.HARDENED_STEEL_INGOT));
    public static final Item TURQUOISE_SHIELD = registerItem("turquoise_shield", new ModShieldItem(new Item.Settings().maxDamage(999), 10, 25, ModItems.TURQUOISE_GEM));
    public static final Item LAPIS_LAZULI_SHIELD = registerItem("lapis_lazuli_shield", new ModShieldItem(new Item.Settings().maxDamage(999), 10, 25, ModItems.LAPIS_LAZULI_GEM));
    public static final Item AMETHYST_SHIELD = registerItem("amethyst_shield", new ModShieldItem(new Item.Settings().maxDamage(420), 10, 15, ModItems.AMETHYST_GEM));
    public static final Item TANZANITE_SHIELD = registerItem("tanzanite_shield", new ModShieldItem(new Item.Settings().maxDamage(621), 10, 16, ModItems.TOURMALINE_GEM));
    public static final Item TOURMALINE_SHIELD = registerItem("tourmaline_shield", new ModShieldItem(new Item.Settings().maxDamage(621), 10, 16, ModItems.TOURMALINE_GEM));
    public static final Item TOPAZ_SHIELD = registerItem("topaz_shield", new ModShieldItem(new Item.Settings().maxDamage(632), 10, 14, ModItems.TOPAZ_GEM));
    public static final Item EMERALD_SHIELD = registerItem("emerald_shield", new ModShieldItem(new Item.Settings().maxDamage(500), 10, 18, Items.EMERALD));
//    public static final Item DIAMOND_SHIELD = registerItem("diamond_shield", new ModShieldItem(new Item.Settings().maxDamage(500), 10, 18, Items.DIAMOND));
    public static final Item RUBY_SHIELD = registerItem("ruby_shield", new ModShieldItem(new Item.Settings().maxDamage(809), 10, 15, ModItems.RUBY_GEM));
    public static final Item SAPPHIRE_SHIELD = registerItem("sapphire_shield", new ModShieldItem(new Item.Settings().maxDamage(711), 10, 18, ModItems.SAPPHIRE_GEM));
    public static final Item CITRINE_SHIELD = registerItem("citrine_shield", new ModShieldItem(new Item.Settings().maxDamage(784), 10, 11, ModItems.CITRINE_GEM));
    public static final Item SPINEL_SHIELD = registerItem("spinel_shield", new ModShieldItem(new Item.Settings().maxDamage(784), 10, 11, ModItems.SPINEL_GEM));
    public static final Item MOISSANITE_SHIELD = registerItem("moissanite_shield", new ModShieldItem(new Item.Settings().maxDamage(913), 10, 10, ModItems.MOISSANITE_GEM));
    public static final Item ONYX_SHIELD = registerItem("onyx_shield", new ModShieldItem(new Item.Settings().maxDamage(1111), 10, 13, ModItems.ONYX_GEM));
    public static final Item OBSIDIAN_SHIELD = registerItem("obsidian_shield", new ModShieldItem(new Item.Settings().maxDamage(821), 10, 21, ModItems.OBSIDIAN_INGOT));
//    public static final Item GRAPHENE_SHIELD = registerItem("graphene_shield", new ModShieldItem(new Item.Settings().maxDamage(1333), 10, 19, ModItems.GRAPHENE_GEM));
    public static final Item ADAMANTIUM_SHIELD = registerItem("adamantium_shield", new ModShieldItem(new Item.Settings().maxDamage(1333), 10, 19, ModItems.ADAMANTIUM_INGOT));
    public static final Item ENDERITE_SHIELD = registerItem("enderite_shield", new ModShieldItem(new Item.Settings().maxDamage(1333), 10, 19, ModItems.ENDERITE_INGOT));
//    public static final Item NETHERITE_SHIELD = registerItem("netherite_shield", new ModShieldItem(new Item.Settings().maxDamage(1333), 10, 19, Items.NETHERITE_INGOT));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.addBefore(Items.COAL, ANTHRACITE);

        entries.addBefore(Items.RAW_IRON, RAW_TIN);
        entries.addAfter(RAW_TIN, RAW_SILVER);
        entries.addAfter(Items.RAW_GOLD, RAW_COBALT);

        entries.addAfter(Items.LAPIS_LAZULI, TURQUOISE);
        entries.addAfter(TURQUOISE, AMETHYST_GEM);
        entries.addAfter(AMETHYST_GEM, LAPIS_LAZULI_GEM);
        entries.addAfter(LAPIS_LAZULI_GEM, TURQUOISE_GEM);
        entries.addAfter(TURQUOISE_GEM, CITRINE_GEM);
        entries.addAfter(CITRINE_GEM, ONYX_GEM);

        entries.addAfter(Items.QUARTZ, CITRINE);
        entries.addAfter(CITRINE, ONYX);

        entries.addBefore(Items.IRON_NUGGET, SILVER_NUGGET);
        entries.addBefore(SILVER_NUGGET, TIN_NUGGET);
        entries.addAfter(Items.IRON_NUGGET, COPPER_NUGGET);
        entries.addAfter(Items.GOLD_NUGGET, STERLING_SILVER_NUGGET);
        entries.addAfter(STERLING_SILVER_NUGGET, ROSE_GOLD_NUGGET);
        entries.addAfter(ROSE_GOLD_NUGGET, BRONZE_NUGGET);
        entries.addAfter(BRONZE_NUGGET, COBALT_NUGGET);
        entries.addAfter(COBALT_NUGGET, CARBON_STEEL_NUGGET);
        entries.addAfter(CARBON_STEEL_NUGGET, HARDENED_STEEL_NUGGET);

        entries.addAfter(HARDENED_STEEL_NUGGET, CHAINMAIL);
        entries.addAfter(CHAINMAIL, GRAPHENE_CHAINMAIL);

        entries.addBefore(Items.DIAMOND, SPINEL_GEM);
        entries.addBefore(SPINEL_GEM, TOPAZ_GEM);
        entries.addBefore(TOPAZ_GEM, TOURMALINE_GEM);
        entries.addBefore(TOURMALINE_GEM, TANZANITE_GEM);

        entries.addAfter(Items.DIAMOND, RUBY_GEM);
        entries.addAfter(RUBY_GEM, SAPPHIRE_GEM);
        entries.addAfter(SAPPHIRE_GEM, MOISSANITE_GEM);

        entries.addBefore(Items.IRON_INGOT, TIN_INGOT);
        entries.addAfter(TIN_INGOT, SILVER_INGOT);
        entries.addAfter(Items.GOLD_INGOT, STERLING_SILVER_INGOT);
        entries.addAfter(STERLING_SILVER_INGOT, ROSE_GOLD_INGOT);
        entries.addAfter(ROSE_GOLD_INGOT, BRONZE_INGOT);
        entries.addAfter(BRONZE_INGOT, COBALT_INGOT);
        entries.addAfter(COBALT_INGOT, CARBON_STEEL_INGOT);
        entries.addBefore(CARBON_STEEL_INGOT, CARBON_STEEL_SCRAP);
        entries.addAfter(CARBON_STEEL_SCRAP, HOT_CARBON_STEEL_SCRAP);
        entries.addAfter(CARBON_STEEL_INGOT, HARDENED_STEEL_INGOT);
        entries.addAfter(HARDENED_STEEL_INGOT, OBSIDIAN_INGOT);
        entries.addBefore(OBSIDIAN_INGOT, OBSIDIAN_SCRAP);
        entries.addAfter(OBSIDIAN_INGOT, ADAMANTIUM_INGOT);
        entries.addAfter(ADAMANTIUM_INGOT, ENDERITE_INGOT);
        entries.addBefore(ENDERITE_INGOT, ENDERITE_SCRAP);

        entries.addAfter(Items.GUNPOWDER, AMETHYST_DUST);
        entries.addAfter(AMETHYST_DUST, QUARTZ_DUST);
        entries.addAfter(QUARTZ_DUST, LAPIS_LAZULI_DUST);
        entries.addAfter(LAPIS_LAZULI_DUST, TURQUOISE_DUST);

        entries.addAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE);
        entries.addAfter(HARDENED_STEEL_UPGRADE_SMITHING_TEMPLATE, OBSIDIAN_UPGRADE_SMITHING_TEMPLATE);
        entries.addAfter(OBSIDIAN_UPGRADE_SMITHING_TEMPLATE, ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE);
        entries.addAfter(ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, ENDERITE_UPGRADE_SMITHING_TEMPLATE);

        entries.addAfter(Items.EGG, ModItems.DUCK_EGG);
    }
    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Items.WOODEN_SWORD, WOODEN_BATTLE_AXE);
        entries.addAfter(WOODEN_BATTLE_AXE, WOODEN_BATTLE_MACE);
        entries.addAfter(WOODEN_BATTLE_MACE, WOODEN_DAGGER);

        entries.addAfter(Items.STONE_SWORD, STONE_BATTLE_AXE);
        entries.addAfter(STONE_BATTLE_AXE, STONE_BATTLE_MACE);
        entries.addAfter(STONE_BATTLE_MACE, STONE_DAGGER);

        entries.addAfter(STONE_DAGGER, TIN_SWORD);
        entries.addAfter(TIN_SWORD, TIN_BATTLE_AXE);
        entries.addAfter(TIN_BATTLE_AXE, TIN_BATTLE_MACE);
        entries.addAfter(TIN_BATTLE_MACE, TIN_DAGGER);

        entries.addAfter(TIN_DAGGER, SILVER_SWORD);
        entries.addAfter(SILVER_SWORD, SILVER_BATTLE_AXE);
        entries.addAfter(SILVER_BATTLE_AXE, SILVER_BATTLE_MACE);
        entries.addAfter(SILVER_BATTLE_MACE, SILVER_DAGGER);

        entries.addAfter(SILVER_DAGGER, COPPER_SWORD);
        entries.addAfter(COPPER_SWORD, COPPER_BATTLE_AXE);
        entries.addAfter(COPPER_BATTLE_AXE, COPPER_BATTLE_MACE);
        entries.addAfter(COPPER_BATTLE_MACE, COPPER_DAGGER);

        entries.addAfter(COPPER_DAGGER, STERLING_SILVER_SWORD);
        entries.addAfter(STERLING_SILVER_SWORD, STERLING_SILVER_BATTLE_AXE);
        entries.addAfter(STERLING_SILVER_BATTLE_AXE, STERLING_SILVER_BATTLE_MACE);
        entries.addAfter(STERLING_SILVER_BATTLE_MACE, STERLING_SILVER_DAGGER);

        entries.addAfter(STERLING_SILVER_DAGGER, BRONZE_SWORD);
        entries.addAfter(BRONZE_SWORD, BRONZE_BATTLE_AXE);
        entries.addAfter(BRONZE_BATTLE_AXE, BRONZE_BATTLE_MACE);
        entries.addAfter(BRONZE_BATTLE_MACE, BRONZE_DAGGER);

        entries.addAfter(Items.IRON_SWORD, IRON_BATTLE_AXE);
        entries.addAfter(IRON_BATTLE_AXE, IRON_BATTLE_MACE);
        entries.addAfter(IRON_BATTLE_MACE, IRON_DAGGER);

        entries.addAfter(Items.GOLDEN_SWORD, GOLD_BATTLE_AXE);
        entries.addAfter(GOLD_BATTLE_AXE, GOLD_BATTLE_MACE);
        entries.addAfter(GOLD_BATTLE_MACE, GOLD_DAGGER);

        entries.addAfter(GOLD_DAGGER, ROSE_GOLD_SWORD);
        entries.addAfter(ROSE_GOLD_SWORD, ROSE_GOLD_BATTLE_AXE);
        entries.addAfter(ROSE_GOLD_BATTLE_AXE, ROSE_GOLD_BATTLE_MACE);
        entries.addAfter(ROSE_GOLD_BATTLE_MACE, ROSE_GOLD_DAGGER);
//        entries.addAfter(ROSE_GOLD_DAGGER, ROSE_GOLD_SPEAR);

        entries.addAfter(ROSE_GOLD_DAGGER, COBALT_SWORD);
        entries.addAfter(COBALT_SWORD, COBALT_BATTLE_AXE);
        entries.addAfter(COBALT_BATTLE_AXE, COBALT_BATTLE_MACE);
        entries.addAfter(COBALT_BATTLE_MACE, COBALT_DAGGER);

        entries.addAfter(COBALT_DAGGER, CARBON_STEEL_SWORD);
        entries.addAfter(CARBON_STEEL_SWORD, CARBON_STEEL_BATTLE_AXE);
        entries.addAfter(CARBON_STEEL_BATTLE_AXE, CARBON_STEEL_BATTLE_MACE);
        entries.addAfter(CARBON_STEEL_BATTLE_MACE, CARBON_STEEL_DAGGER);
//        entries.addAfter(CARBON_STEEL_DAGGER, CARBON_STEEL_SPEAR);

        entries.addAfter(CARBON_STEEL_DAGGER, HARDENED_STEEL_SWORD);
        entries.addAfter(HARDENED_STEEL_SWORD, HARDENED_STEEL_BATTLE_AXE);
        entries.addAfter(HARDENED_STEEL_BATTLE_AXE, HARDENED_STEEL_BATTLE_MACE);
        entries.addAfter(HARDENED_STEEL_BATTLE_MACE, HARDENED_STEEL_DAGGER);
//        entries.addAfter(HARDENED_STEEL_DAGGER, HARDENED_STEEL_SPEAR);

        entries.addAfter(HARDENED_STEEL_DAGGER, TURQUOISE_SWORD);
        entries.addAfter(TURQUOISE_SWORD, TURQUOISE_BATTLE_AXE);
        entries.addAfter(TURQUOISE_BATTLE_AXE, TURQUOISE_BATTLE_MACE);
        entries.addAfter(TURQUOISE_BATTLE_MACE, TURQUOISE_DAGGER);

        entries.addAfter(TURQUOISE_DAGGER, LAPIS_LAZULI_SWORD);
        entries.addAfter(LAPIS_LAZULI_SWORD, LAPIS_LAZULI_BATTLE_AXE);
        entries.addAfter(LAPIS_LAZULI_BATTLE_AXE, LAPIS_LAZULI_BATTLE_MACE);
        entries.addAfter(LAPIS_LAZULI_BATTLE_MACE, LAPIS_LAZULI_DAGGER);

        entries.addAfter(TURQUOISE_DAGGER, LAPIS_LAZULI_SWORD);
        entries.addAfter(LAPIS_LAZULI_SWORD, LAPIS_LAZULI_BATTLE_AXE);
        entries.addAfter(LAPIS_LAZULI_BATTLE_AXE, LAPIS_LAZULI_BATTLE_MACE);
        entries.addAfter(LAPIS_LAZULI_BATTLE_MACE, LAPIS_LAZULI_DAGGER);

        entries.addAfter(LAPIS_LAZULI_DAGGER, TURQUOISE_SWORD);
        entries.addAfter(TURQUOISE_SWORD, TURQUOISE_BATTLE_AXE);
        entries.addAfter(TURQUOISE_BATTLE_AXE, TURQUOISE_BATTLE_MACE);
        entries.addAfter(TURQUOISE_BATTLE_MACE, TURQUOISE_DAGGER);

        entries.addAfter(TURQUOISE_DAGGER, TOURMALINE_SWORD);
        entries.addAfter(TOURMALINE_SWORD, TOURMALINE_BATTLE_AXE);
        entries.addAfter(TOURMALINE_BATTLE_AXE, TOURMALINE_BATTLE_MACE);
        entries.addAfter(TOURMALINE_BATTLE_MACE, TOURMALINE_DAGGER);

        entries.addAfter(TOURMALINE_DAGGER, CITRINE_SWORD);
        entries.addAfter(CITRINE_SWORD, CITRINE_BATTLE_AXE);
        entries.addAfter(CITRINE_BATTLE_AXE, CITRINE_BATTLE_MACE);
        entries.addAfter(CITRINE_BATTLE_MACE, CITRINE_DAGGER);

        entries.addAfter(CITRINE_DAGGER, ONYX_SWORD);
        entries.addAfter(ONYX_SWORD, ONYX_BATTLE_AXE);
        entries.addAfter(ONYX_BATTLE_AXE, ONYX_BATTLE_MACE);
        entries.addAfter(ONYX_BATTLE_MACE, ONYX_DAGGER);

        entries.addAfter(ONYX_DAGGER, TOPAZ_SWORD);
        entries.addAfter(TOPAZ_SWORD, TOPAZ_BATTLE_AXE);
        entries.addAfter(TOPAZ_BATTLE_AXE, TOPAZ_BATTLE_MACE);
        entries.addAfter(TOPAZ_BATTLE_MACE, TOPAZ_DAGGER);

        entries.addAfter(TOPAZ_DAGGER, SPINEL_SWORD);
        entries.addAfter(SPINEL_SWORD, SPINEL_BATTLE_AXE);
        entries.addAfter(SPINEL_BATTLE_AXE, SPINEL_BATTLE_MACE);
        entries.addAfter(SPINEL_BATTLE_MACE, SPINEL_DAGGER);

        entries.addAfter(SPINEL_DAGGER, EMERALD_SWORD);
        entries.addAfter(EMERALD_SWORD, EMERALD_BATTLE_AXE);
        entries.addAfter(EMERALD_BATTLE_AXE, EMERALD_BATTLE_MACE);
        entries.addAfter(EMERALD_BATTLE_MACE, EMERALD_DAGGER);

        entries.addAfter(Items.DIAMOND_SWORD, DIAMOND_BATTLE_AXE);
        entries.addAfter(DIAMOND_BATTLE_AXE, DIAMOND_BATTLE_MACE);
        entries.addAfter(DIAMOND_BATTLE_MACE, DIAMOND_DAGGER);

        entries.addAfter(DIAMOND_DAGGER, RUBY_SWORD);
        entries.addAfter(RUBY_SWORD, RUBY_BATTLE_AXE);
        entries.addAfter(RUBY_BATTLE_AXE, RUBY_BATTLE_MACE);
        entries.addAfter(RUBY_BATTLE_MACE, RUBY_DAGGER);

        entries.addAfter(RUBY_DAGGER, SAPPHIRE_SWORD);
        entries.addAfter(SAPPHIRE_SWORD, SAPPHIRE_BATTLE_AXE);
        entries.addAfter(SAPPHIRE_BATTLE_AXE, SAPPHIRE_BATTLE_MACE);
        entries.addAfter(SAPPHIRE_BATTLE_MACE, SAPPHIRE_DAGGER);

        entries.addAfter(SAPPHIRE_DAGGER, MOISSANITE_SWORD);
        entries.addAfter(MOISSANITE_SWORD, MOISSANITE_BATTLE_AXE);
        entries.addAfter(MOISSANITE_BATTLE_AXE, MOISSANITE_BATTLE_MACE);
        entries.addAfter(MOISSANITE_BATTLE_MACE, MOISSANITE_DAGGER);

        entries.addAfter(MOISSANITE_DAGGER, OBSIDIAN_SWORD);
        entries.addAfter(OBSIDIAN_SWORD, OBSIDIAN_BATTLE_AXE);
        entries.addAfter(OBSIDIAN_BATTLE_AXE, OBSIDIAN_BATTLE_MACE);
        entries.addAfter(OBSIDIAN_BATTLE_MACE, OBSIDIAN_DAGGER);

        entries.addAfter(OBSIDIAN_DAGGER, ADAMANTIUM_SWORD);
        entries.addAfter(ADAMANTIUM_SWORD, ADAMANTIUM_BATTLE_AXE);
        entries.addAfter(ADAMANTIUM_BATTLE_AXE, ADAMANTIUM_BATTLE_MACE);
        entries.addAfter(ADAMANTIUM_BATTLE_MACE, ADAMANTIUM_DAGGER);

        entries.addAfter(Items.NETHERITE_SWORD, NETHERITE_BATTLE_AXE);
        entries.addAfter(NETHERITE_BATTLE_AXE, NETHERITE_BATTLE_MACE);
        entries.addAfter(NETHERITE_BATTLE_MACE, NETHERITE_DAGGER);

        entries.addAfter(NETHERITE_DAGGER, ENDERITE_SWORD);
        entries.addAfter(ENDERITE_SWORD, ENDERITE_BATTLE_AXE);
        entries.addAfter(ENDERITE_BATTLE_AXE, ENDERITE_BATTLE_MACE);
        entries.addAfter(ENDERITE_BATTLE_MACE, ENDERITE_DAGGER);
        entries.addAfter(ENDERITE_DAGGER, ENDERITE_SPEAR);

        entries.add(ModItems.TIN_HELMET);
        entries.add(ModItems.TIN_CHESTPLATE);
        entries.add(ModItems.TIN_LEGGINGS);
        entries.add(ModItems.TIN_BOOTS);
        entries.add(ModItems.SILVER_HELMET);
        entries.add(ModItems.SILVER_CHESTPLATE);
        entries.add(ModItems.SILVER_LEGGINGS);
        entries.add(ModItems.SILVER_BOOTS);
        entries.add(ModItems.COPPER_HELMET);
        entries.add(ModItems.COPPER_CHESTPLATE);
        entries.add(ModItems.COPPER_LEGGINGS);
        entries.add(ModItems.COPPER_BOOTS);
        entries.add(ModItems.STERLING_SILVER_HELMET);
        entries.add(ModItems.STERLING_SILVER_CHESTPLATE);
        entries.add(ModItems.STERLING_SILVER_LEGGINGS);
        entries.add(ModItems.STERLING_SILVER_BOOTS);
        entries.add(ModItems.ROSE_GOLD_HELMET);
        entries.add(ModItems.ROSE_GOLD_CHESTPLATE);
        entries.add(ModItems.ROSE_GOLD_LEGGINGS);
        entries.add(ModItems.ROSE_GOLD_BOOTS);
        entries.add(ModItems.BRONZE_HELMET);
        entries.add(ModItems.BRONZE_CHESTPLATE);
        entries.add(ModItems.BRONZE_LEGGINGS);
        entries.add(ModItems.BRONZE_BOOTS);
        entries.add(ModItems.COBALT_HELMET);
        entries.add(ModItems.COBALT_CHESTPLATE);
        entries.add(ModItems.COBALT_LEGGINGS);
        entries.add(ModItems.COBALT_BOOTS);
        entries.add(ModItems.CARBON_STEEL_HELMET);
        entries.add(ModItems.CARBON_STEEL_CHESTPLATE);
        entries.add(ModItems.CARBON_STEEL_LEGGINGS);
        entries.add(ModItems.CARBON_STEEL_BOOTS);
        entries.add(ModItems.HARDENED_STEEL_HELMET);
        entries.add(ModItems.HARDENED_STEEL_CHESTPLATE);
        entries.add(ModItems.HARDENED_STEEL_LEGGINGS);
        entries.add(ModItems.HARDENED_STEEL_BOOTS);
        entries.add(ModItems.TURQUOISE_HELMET);
        entries.add(ModItems.TURQUOISE_CHESTPLATE);
        entries.add(ModItems.TURQUOISE_LEGGINGS);
        entries.add(ModItems.TURQUOISE_BOOTS);
        entries.add(ModItems.LAPIS_LAZULI_HELMET);
        entries.add(ModItems.LAPIS_LAZULI_CHESTPLATE);
        entries.add(ModItems.LAPIS_LAZULI_LEGGINGS);
        entries.add(ModItems.LAPIS_LAZULI_BOOTS);
        entries.add(ModItems.AMETHYST_HELMET);
        entries.add(ModItems.AMETHYST_CHESTPLATE);
        entries.add(ModItems.AMETHYST_LEGGINGS);
        entries.add(ModItems.AMETHYST_BOOTS);
        entries.add(ModItems.TANZANITE_HELMET);
        entries.add(ModItems.TANZANITE_CHESTPLATE);
        entries.add(ModItems.TANZANITE_LEGGINGS);
        entries.add(ModItems.TANZANITE_BOOTS);
        entries.add(ModItems.TOURMALINE_HELMET);
        entries.add(ModItems.TOURMALINE_CHESTPLATE);
        entries.add(ModItems.TOURMALINE_LEGGINGS);
        entries.add(ModItems.TOURMALINE_BOOTS);
        entries.add(ModItems.TOPAZ_HELMET);
        entries.add(ModItems.TOPAZ_CHESTPLATE);
        entries.add(ModItems.TOPAZ_LEGGINGS);
        entries.add(ModItems.TOPAZ_BOOTS);
        entries.add(ModItems.EMERALD_HELMET);
        entries.add(ModItems.EMERALD_CHESTPLATE);
        entries.add(ModItems.EMERALD_LEGGINGS);
        entries.add(ModItems.EMERALD_BOOTS);
        entries.add(ModItems.RUBY_HELMET);
        entries.add(ModItems.RUBY_CHESTPLATE);
        entries.add(ModItems.RUBY_LEGGINGS);
        entries.add(ModItems.RUBY_BOOTS);
        entries.add(ModItems.SAPPHIRE_HELMET);
        entries.add(ModItems.SAPPHIRE_CHESTPLATE);
        entries.add(ModItems.SAPPHIRE_LEGGINGS);
        entries.add(ModItems.SAPPHIRE_BOOTS);
        entries.add(ModItems.SPINEL_HELMET);
        entries.add(ModItems.SPINEL_CHESTPLATE);
        entries.add(ModItems.SPINEL_LEGGINGS);
        entries.add(ModItems.SPINEL_BOOTS);
        entries.add(ModItems.CITRINE_HELMET);
        entries.add(ModItems.CITRINE_CHESTPLATE);
        entries.add(ModItems.CITRINE_LEGGINGS);
        entries.add(ModItems.CITRINE_BOOTS);
        entries.add(ModItems.MOISSANITE_HELMET);
        entries.add(ModItems.MOISSANITE_CHESTPLATE);
        entries.add(ModItems.MOISSANITE_LEGGINGS);
        entries.add(ModItems.MOISSANITE_BOOTS);
        entries.add(ModItems.ONYX_HELMET);
        entries.add(ModItems.ONYX_CHESTPLATE);
        entries.add(ModItems.ONYX_LEGGINGS);
        entries.add(ModItems.ONYX_BOOTS);
        entries.add(ModItems.OBSIDIAN_HELMET);
        entries.add(ModItems.OBSIDIAN_CHESTPLATE);
        entries.add(ModItems.OBSIDIAN_LEGGINGS);
        entries.add(ModItems.OBSIDIAN_BOOTS);
        entries.add(ModItems.GRAPHENE_CHAINMAIL_HELMET);
        entries.add(ModItems.GRAPHENE_CHAINMAIL_CHESTPLATE);
        entries.add(ModItems.GRAPHENE_CHAINMAIL_LEGGINGS);
        entries.add(ModItems.GRAPHENE_CHAINMAIL_BOOTS);
        entries.add(ModItems.ADAMANTIUM_HELMET);
        entries.add(ModItems.ADAMANTIUM_CHESTPLATE);
        entries.add(ModItems.ADAMANTIUM_LEGGINGS);
        entries.add(ModItems.ADAMANTIUM_BOOTS);
        entries.add(ModItems.ENDERITE_HELMET);
        entries.add(ModItems.ENDERITE_CHESTPLATE);
        entries.add(ModItems.ENDERITE_LEGGINGS);
        entries.add(ModItems.ENDERITE_BOOTS);

        entries.add(TIN_SHIELD);
        entries.add(SILVER_SHIELD);
        entries.add(COPPER_SHIELD);
        entries.add(STERLING_SILVER_SHIELD);
        entries.add(ROSE_GOLD_SHIELD);
        entries.add(BRONZE_SHIELD);
        entries.add(COBALT_SHIELD);
        entries.add(CARBON_STEEL_SHIELD);
        entries.add(HARDENED_STEEL_SHIELD);
        entries.add(TURQUOISE_SHIELD);
        entries.add(AMETHYST_SHIELD);
        entries.add(LAPIS_LAZULI_SHIELD);
        entries.add(TANZANITE_SHIELD);
        entries.add(TOURMALINE_SHIELD);
        entries.add(TOPAZ_SHIELD);
        entries.add(EMERALD_SHIELD);
        entries.add(RUBY_SHIELD);
        entries.add(SAPPHIRE_SHIELD);
        entries.add(SPINEL_SHIELD);
        entries.add(CITRINE_SHIELD);
        entries.add(MOISSANITE_SHIELD);
        entries.add(ONYX_SHIELD);
        entries.add(OBSIDIAN_SHIELD);
//        entries.add(GRAPHENE_SHIELD);
        entries.add(ADAMANTIUM_SHIELD);
        entries.add(ENDERITE_SHIELD);

        entries.add(ModItems.TIN_HORSE_ARMOR);
        entries.add(ModItems.SILVER_HORSE_ARMOR);
        entries.add(ModItems.COPPER_HORSE_ARMOR);
        entries.add(ModItems.STERLING_SILVER_HORSE_ARMOR);
        entries.add(ModItems.ROSE_GOLD_HORSE_ARMOR);
        entries.add(ModItems.BRONZE_HORSE_ARMOR);
        entries.add(ModItems.COBALT_HORSE_ARMOR);
        entries.add(ModItems.CARBON_STEEL_HORSE_ARMOR);
        entries.add(ModItems.HARDENED_STEEL_HORSE_ARMOR);
        entries.add(ModItems.TURQUOISE_HORSE_ARMOR);
        entries.add(ModItems.LAPIS_LAZULI_HORSE_ARMOR);
        entries.add(ModItems.AMETHYST_HORSE_ARMOR);
        entries.add(ModItems.ONYX_HORSE_ARMOR);
        entries.add(ModItems.CITRINE_HORSE_ARMOR);
        entries.add(ModItems.TANZANITE_HORSE_ARMOR);
        entries.add(ModItems.TOURMALINE_HORSE_ARMOR);
        entries.add(ModItems.TOPAZ_HORSE_ARMOR);
        entries.add(ModItems.SPINEL_HORSE_ARMOR);
        entries.add(ModItems.EMERALD_HORSE_ARMOR);
        entries.add(ModItems.RUBY_HORSE_ARMOR);
        entries.add(ModItems.SAPPHIRE_HORSE_ARMOR);
        entries.add(ModItems.MOISSANITE_HORSE_ARMOR);
//        entries.add(ModItems.GRAPHENE_HORSE_ARMOR);
        entries.add(ModItems.OBSIDIAN_HORSE_ARMOR);
        entries.add(ModItems.NETHERITE_HORSE_ARMOR);
        entries.add(ModItems.ADAMANTIUM_HORSE_ARMOR);
        entries.add(ModItems.ENDERITE_HORSE_ARMOR);

        entries.add(ModItems.TIN_WOLF_ARMOR);
        entries.add(ModItems.GOLD_WOLF_ARMOR);
        entries.add(ModItems.SILVER_WOLF_ARMOR);
        entries.add(ModItems.COPPER_WOLF_ARMOR);
        entries.add(ModItems.STERLING_SILVER_WOLF_ARMOR);
        entries.add(ModItems.ROSE_GOLD_WOLF_ARMOR);
        entries.add(ModItems.BRONZE_WOLF_ARMOR);
        entries.add(ModItems.IRON_WOLF_ARMOR);
        entries.add(ModItems.COBALT_WOLF_ARMOR);
        entries.add(ModItems.CARBON_STEEL_WOLF_ARMOR);
        entries.add(ModItems.HARDENED_STEEL_WOLF_ARMOR);
        entries.add(ModItems.DIAMOND_WOLF_ARMOR);
    }
    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries) {
        entries.add(DARK_CHOCOLATE);
        entries.add(MILK_CHOCOLATE);
        entries.add(WHITE_CHOCOLATE);
        entries.add(LEMON);
        entries.add(BRONZE_APPLE);
        entries.add(COBALT_APPLE);
        entries.add(ENCHANTED_COBALT_APPLE);
        entries.add(ROSE_GOLD_APPLE);
        entries.add(ENCHANTED_ROSE_GOLD_APPLE);
        entries.add(SILVER_APPLE);
        entries.add(SILVER_CARROT);
        entries.add(CARROT_PIE);
        entries.add(LEMON_PIE);
        entries.add(APPLE_PIE);
        entries.add(SWEET_BERRY_PIE);
        entries.add(VELVET);
        entries.add(RAW_DUCK);
        entries.add(COOKED_DUCK);
    }
    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        entries.add(TIN_PICKAXE);
        entries.add(TIN_AXE);
        entries.add(TIN_SHOVEL);
        entries.add(TIN_HOE);

        entries.add(SILVER_PICKAXE);
        entries.add(SILVER_AXE);
        entries.add(SILVER_SHOVEL);
        entries.add(SILVER_HOE);

        entries.add(COPPER_PICKAXE);
        entries.add(COPPER_AXE);
        entries.add(COPPER_SHOVEL);
        entries.add(COPPER_HOE);

        entries.add(STERLING_SILVER_PICKAXE);
        entries.add(STERLING_SILVER_AXE);
        entries.add(STERLING_SILVER_SHOVEL);
        entries.add(STERLING_SILVER_HOE);

        entries.add(ROSE_GOLD_PICKAXE);
        entries.add(ROSE_GOLD_AXE);
        entries.add(ROSE_GOLD_SHOVEL);
        entries.add(ROSE_GOLD_HOE);

        entries.add(BRONZE_PICKAXE);
        entries.add(BRONZE_AXE);
        entries.add(BRONZE_SHOVEL);
        entries.add(BRONZE_HOE);

        entries.add(COBALT_PICKAXE);
        entries.add(COBALT_AXE);
        entries.add(COBALT_SHOVEL);
        entries.add(COBALT_HOE);

        entries.add(CARBON_STEEL_PICKAXE);
        entries.add(CARBON_STEEL_AXE);
        entries.add(CARBON_STEEL_SHOVEL);
        entries.add(CARBON_STEEL_HOE);

        entries.add(HARDENED_STEEL_PICKAXE);
        entries.add(HARDENED_STEEL_AXE);
        entries.add(HARDENED_STEEL_SHOVEL);
        entries.add(HARDENED_STEEL_HOE);

        entries.add(TURQUOISE_PICKAXE);
        entries.add(TURQUOISE_AXE);
        entries.add(TURQUOISE_SHOVEL);
        entries.add(TURQUOISE_HOE);

        entries.add(AMETHYST_PICKAXE);
        entries.add(AMETHYST_AXE);
        entries.add(AMETHYST_SHOVEL);
        entries.add(AMETHYST_HOE);

        entries.add(LAPIS_LAZULI_PICKAXE);
        entries.add(LAPIS_LAZULI_AXE);
        entries.add(LAPIS_LAZULI_SHOVEL);
        entries.add(LAPIS_LAZULI_HOE);

        entries.add(TANZANITE_PICKAXE);
        entries.add(TANZANITE_AXE);
        entries.add(TANZANITE_SHOVEL);
        entries.add(TANZANITE_HOE);

        entries.add(TOURMALINE_PICKAXE);
        entries.add(TOURMALINE_AXE);
        entries.add(TOURMALINE_SHOVEL);
        entries.add(TOURMALINE_HOE);

        entries.add(TOPAZ_PICKAXE);
        entries.add(TOPAZ_AXE);
        entries.add(TOPAZ_SHOVEL);
        entries.add(TOPAZ_HOE);

        entries.add(EMERALD_PICKAXE);
        entries.add(EMERALD_AXE);
        entries.add(EMERALD_SHOVEL);
        entries.add(EMERALD_HOE);

        entries.add(RUBY_PICKAXE);
        entries.add(RUBY_AXE);
        entries.add(RUBY_SHOVEL);
        entries.add(RUBY_HOE);

        entries.add(SAPPHIRE_PICKAXE);
        entries.add(SAPPHIRE_AXE);
        entries.add(SAPPHIRE_SHOVEL);
        entries.add(SAPPHIRE_HOE);

        entries.add(SPINEL_PICKAXE);
        entries.add(SPINEL_AXE);
        entries.add(SPINEL_SHOVEL);
        entries.add(SPINEL_HOE);

        entries.add(CITRINE_PICKAXE);
        entries.add(CITRINE_AXE);
        entries.add(CITRINE_SHOVEL);
        entries.add(CITRINE_HOE);

        entries.add(MOISSANITE_PICKAXE);
        entries.add(MOISSANITE_AXE);
        entries.add(MOISSANITE_SHOVEL);
        entries.add(MOISSANITE_HOE);

        entries.add(ONYX_PICKAXE);
        entries.add(ONYX_AXE);
        entries.add(ONYX_SHOVEL);
        entries.add(ONYX_HOE);

        entries.add(OBSIDIAN_PICKAXE);
        entries.add(OBSIDIAN_AXE);
        entries.add(OBSIDIAN_SHOVEL);
        entries.add(OBSIDIAN_HOE);

//        entries.add(GRAPHENE_PICKAXE);
//        entries.add(GRAPHENE_AXE);
//        entries.add(GRAPHENE_SHOVEL);
//        entries.add(GRAPHENE_HOE);

        entries.add(ADAMANTIUM_PICKAXE);
        entries.add(ADAMANTIUM_AXE);
        entries.add(ADAMANTIUM_SHOVEL);
        entries.add(ADAMANTIUM_HOE);

        entries.add(ENDERITE_PICKAXE);
        entries.add(ENDERITE_AXE);
        entries.add(ENDERITE_SHOVEL);
        entries.add(ENDERITE_HOE);

        entries.add(SWEET_CAROLINE_MUSIC_DISC);
        entries.add(CIPHER_MUSIC_DISC);
    }

    private static void addItemsToSpawnEggItemGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Items.DROWNED_SPAWN_EGG, HARDENED_STEEL_GOLEM_SPAWN_EGG);
        entries.addAfter(HARDENED_STEEL_GOLEM_SPAWN_EGG, DUCK_SPAWN_EGG);
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Mores.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Mores.LOGGER.info("Registering Mod Items for " + Mores.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToSpawnEggItemGroup);
    }
}
