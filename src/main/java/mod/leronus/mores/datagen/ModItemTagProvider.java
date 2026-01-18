package mod.leronus.mores.datagen;

import mod.leronus.mores.item.ModTags;
import mod.leronus.mores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    private static boolean isBackportedSpearsLoaded() {
        FabricLoader loader = FabricLoader.getInstance();
        return loader.isModLoaded("spears");
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //Meat
        getOrCreateTagBuilder(ItemTags.MEAT).add(ModItems.RAW_DUCK, ModItems.COOKED_DUCK);
        //Tools
        //TODO Add enderite, tanzanite, adamantium
        getOrCreateTagBuilder(ItemTags.SWORDS).add(
                ModItems.TIN_SWORD,
                ModItems.COPPER_SWORD,
                ModItems.SILVER_SWORD,
                ModItems.BRONZE_SWORD,
                ModItems.COBALT_SWORD,
                ModItems.STERLING_SILVER_SWORD,
                ModItems.ROSE_GOLD_SWORD,
                ModItems.CARBON_STEEL_SWORD,
                ModItems.HARDENED_STEEL_SWORD,
                ModItems.TURQUOISE_SWORD,
                ModItems.AMETHYST_SWORD,
                ModItems.TOPAZ_SWORD,
                ModItems.TANZANITE_SWORD,
                ModItems.TOURMALINE_SWORD,
                ModItems.EMERALD_SWORD,
                ModItems.RUBY_SWORD,
                ModItems.SAPPHIRE_SWORD,
                ModItems.SPINEL_SWORD,
                ModItems.CITRINE_SWORD,
                ModItems.MOISSANITE_SWORD,
                ModItems.ONYX_SWORD,
                ModItems.OBSIDIAN_SWORD,
//                ModItems.GRAPHENE_SWORD,
                ModItems.ADAMANTIUM_SWORD,
                ModItems.ENDERITE_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(
                ModItems.TIN_PICKAXE,
                ModItems.COPPER_PICKAXE,
                ModItems.SILVER_PICKAXE,
                ModItems.BRONZE_PICKAXE,
                ModItems.COBALT_PICKAXE,
                ModItems.STERLING_SILVER_PICKAXE,
                ModItems.ROSE_GOLD_PICKAXE,
                ModItems.CARBON_STEEL_PICKAXE,
                ModItems.HARDENED_STEEL_PICKAXE,
                ModItems.AMETHYST_PICKAXE,
                ModItems.EMERALD_PICKAXE,
                ModItems.OBSIDIAN_PICKAXE,
                ModItems.TANZANITE_PICKAXE,
                ModItems.TOPAZ_PICKAXE,
                ModItems.TOURMALINE_PICKAXE,
                ModItems.CITRINE_PICKAXE,
                ModItems.RUBY_PICKAXE,
                ModItems.SAPPHIRE_PICKAXE,
                ModItems.SPINEL_PICKAXE,
                ModItems.MOISSANITE_PICKAXE,
                ModItems.TURQUOISE_PICKAXE,
                ModItems.ONYX_PICKAXE,
//                ModItems.GRAPHENE_PICKAXE,
                ModItems.ADAMANTIUM_PICKAXE,
                ModItems.ENDERITE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(
                ModItems.TIN_SHOVEL, ModItems.COPPER_SHOVEL, ModItems.SILVER_SHOVEL, ModItems.BRONZE_SHOVEL, ModItems.COBALT_SHOVEL,
                ModItems.STERLING_SILVER_SHOVEL, ModItems.ROSE_GOLD_SHOVEL, ModItems.CARBON_STEEL_SHOVEL, ModItems.HARDENED_STEEL_SHOVEL, ModItems.AMETHYST_SHOVEL, ModItems.EMERALD_SHOVEL, ModItems.OBSIDIAN_SHOVEL,
                ModItems.TANZANITE_SHOVEL,
                ModItems.TOPAZ_SHOVEL, ModItems.TOURMALINE_SHOVEL, ModItems.CITRINE_SHOVEL, ModItems.RUBY_SHOVEL, ModItems.SAPPHIRE_SHOVEL, ModItems.SPINEL_SHOVEL,
                ModItems.MOISSANITE_SHOVEL, ModItems.TURQUOISE_SHOVEL,
                ModItems.ONYX_SHOVEL,
//                ModItems.GRAPHENE_SHOVEL,
                ModItems.ADAMANTIUM_SHOVEL,
                ModItems.ENDERITE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES).add(
                ModItems.TIN_AXE, ModItems.COPPER_AXE, ModItems.SILVER_AXE, ModItems.BRONZE_AXE, ModItems.COBALT_AXE, ModItems.STERLING_SILVER_AXE, ModItems.ROSE_GOLD_AXE,
                ModItems.CARBON_STEEL_AXE, ModItems.HARDENED_STEEL_AXE, ModItems.AMETHYST_AXE, ModItems.EMERALD_AXE, ModItems.OBSIDIAN_AXE,
                ModItems.TANZANITE_AXE, ModItems.TOPAZ_AXE, ModItems.TOURMALINE_AXE,
                ModItems.CITRINE_AXE, ModItems.RUBY_AXE, ModItems.SAPPHIRE_AXE,
                ModItems.SPINEL_AXE,ModItems.MOISSANITE_AXE, ModItems.TURQUOISE_AXE, ModItems.ONYX_AXE,
//                ModItems.GRAPHENE_AXE,
                ModItems.ADAMANTIUM_AXE,
                ModItems.ENDERITE_AXE
        );
        getOrCreateTagBuilder(ItemTags.HOES).add(
                ModItems.TIN_HOE, ModItems.COPPER_HOE, ModItems.SILVER_HOE, ModItems.BRONZE_HOE, ModItems.COBALT_HOE, ModItems.STERLING_SILVER_HOE, ModItems.ROSE_GOLD_HOE,
                ModItems.CARBON_STEEL_HOE, ModItems.HARDENED_STEEL_HOE,
                ModItems.AMETHYST_HOE, ModItems.EMERALD_HOE,
                ModItems.OBSIDIAN_HOE,
                ModItems.TANZANITE_HOE,
                ModItems.TOPAZ_HOE,
                ModItems.TOURMALINE_HOE,
                ModItems.CITRINE_HOE,
                ModItems.RUBY_HOE,
                ModItems.SAPPHIRE_HOE,
                ModItems.SPINEL_HOE,
                ModItems.MOISSANITE_HOE,
                ModItems.TURQUOISE_HOE,
                ModItems.ONYX_HOE,
//                ModItems.GRAPHENE_HOE,
                ModItems.ADAMANTIUM_HOE,
                ModItems.ENDERITE_HOE
        );
        //TODO Change to sharp for battleaxe?
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(
                ModItems.WOOD_BATTLE_AXE, ModItems.WOOD_BATTLE_MACE, ModItems.WOOD_DAGGER,
                ModItems.TIN_SWORD, ModItems.TIN_BATTLE_AXE, ModItems.TIN_BATTLE_MACE,
                ModItems.GOLD_BATTLE_AXE, ModItems.GOLD_BATTLE_MACE, ModItems.GOLD_DAGGER,
                ModItems.SILVER_SWORD, ModItems.SILVER_BATTLE_AXE, ModItems.SILVER_BATTLE_MACE,
                ModItems.COPPER_SWORD, ModItems.COPPER_BATTLE_AXE, ModItems.COPPER_BATTLE_MACE,
                ModItems.BRONZE_SWORD, ModItems.BRONZE_BATTLE_AXE, ModItems.BRONZE_BATTLE_MACE,
                ModItems.STERLING_SILVER_SWORD, ModItems.STERLING_SILVER_BATTLE_AXE, ModItems.STERLING_SILVER_BATTLE_MACE,
                ModItems.ROSE_GOLD_SWORD, ModItems.ROSE_GOLD_BATTLE_AXE, ModItems.ROSE_GOLD_BATTLE_MACE,
                ModItems.IRON_BATTLE_AXE, ModItems.IRON_BATTLE_MACE, ModItems.IRON_DAGGER,
                ModItems.COBALT_SWORD, ModItems.COBALT_BATTLE_AXE, ModItems.COBALT_BATTLE_MACE,
                ModItems.CARBON_STEEL_SWORD, ModItems.CARBON_STEEL_BATTLE_AXE, ModItems.CARBON_STEEL_BATTLE_MACE,
                ModItems.HARDENED_STEEL_SWORD, ModItems.HARDENED_STEEL_BATTLE_AXE, ModItems.HARDENED_STEEL_BATTLE_MACE,
                ModItems.AMETHYST_SWORD, ModItems.AMETHYST_BATTLE_AXE, ModItems.AMETHYST_BATTLE_MACE,
                ModItems.TURQUOISE_SWORD, ModItems.TURQUOISE_BATTLE_AXE, ModItems.TURQUOISE_BATTLE_MACE,
                ModItems.LAPIS_LAZULI_SWORD, ModItems.LAPIS_LAZULI_BATTLE_AXE, ModItems.LAPIS_LAZULI_BATTLE_MACE,
                ModItems.CITRINE_SWORD, ModItems.CITRINE_BATTLE_AXE, ModItems.CITRINE_BATTLE_MACE,
                ModItems.ONYX_SWORD, ModItems.ONYX_BATTLE_AXE, ModItems.ONYX_BATTLE_MACE,
                ModItems.TANZANITE_SWORD, ModItems.TANZANITE_BATTLE_AXE, ModItems.TANZANITE_BATTLE_MACE,
                ModItems.TOURMALINE_SWORD, ModItems.TOURMALINE_BATTLE_AXE, ModItems.TOURMALINE_BATTLE_MACE,
                ModItems.TOPAZ_SWORD, ModItems.TOPAZ_BATTLE_AXE, ModItems.TOPAZ_BATTLE_MACE,
                ModItems.SPINEL_SWORD, ModItems.SPINEL_BATTLE_AXE, ModItems.SPINEL_BATTLE_MACE,
                ModItems.EMERALD_SWORD, ModItems.EMERALD_BATTLE_AXE, ModItems.EMERALD_BATTLE_MACE,
                ModItems.DIAMOND_BATTLE_AXE, ModItems.DIAMOND_BATTLE_MACE, ModItems.DIAMOND_DAGGER,
                ModItems.RUBY_SWORD, ModItems.RUBY_BATTLE_AXE, ModItems.RUBY_BATTLE_MACE,
                ModItems.SAPPHIRE_SWORD, ModItems.SAPPHIRE_BATTLE_AXE, ModItems.SAPPHIRE_BATTLE_MACE,
                ModItems.MOISSANITE_SWORD, ModItems.MOISSANITE_BATTLE_AXE, ModItems.MOISSANITE_BATTLE_MACE,
//                ModItems.GRAPHENE_SWORD, ModItems.GRAPHENE_BATTLE_AXE, ModItems.GRAPHENE_BATTLE_MACE,
                ModItems.OBSIDIAN_SWORD, ModItems.OBSIDIAN_BATTLE_AXE, ModItems.OBSIDIAN_BATTLE_MACE,
                ModItems.NETHERITE_BATTLE_AXE, ModItems.NETHERITE_BATTLE_MACE, ModItems.NETHERITE_DAGGER,
                ModItems.ADAMANTIUM_BATTLE_AXE, ModItems.ADAMANTIUM_BATTLE_MACE, ModItems.ADAMANTIUM_DAGGER,
                ModItems.ENDERITE_BATTLE_AXE, ModItems.ENDERITE_BATTLE_MACE, ModItems.ENDERITE_DAGGER,

                ModItems.TIN_DAGGER, ModItems.COPPER_DAGGER, ModItems.SILVER_DAGGER, ModItems.BRONZE_DAGGER, ModItems.COBALT_DAGGER, ModItems.STERLING_SILVER_DAGGER, ModItems.ROSE_GOLD_DAGGER,
                ModItems.CARBON_STEEL_DAGGER, ModItems.HARDENED_STEEL_DAGGER, ModItems.AMETHYST_DAGGER, ModItems.EMERALD_DAGGER, ModItems.OBSIDIAN_DAGGER, ModItems.TOPAZ_DAGGER,
                ModItems.TOURMALINE_DAGGER, ModItems.CITRINE_DAGGER, ModItems.RUBY_DAGGER, ModItems.SAPPHIRE_DAGGER, ModItems.SPINEL_DAGGER, ModItems.MOISSANITE_DAGGER,
                ModItems.TURQUOISE_DAGGER, ModItems.ONYX_DAGGER
//                ,ModItems.GRAPHENE_DAGGER
                );

        //Raw Materials
        getOrCreateTagBuilder(ConventionalItemTags.RAW_MATERIALS).add(
                ModItems.RAW_TIN, ModItems.RAW_SILVER ,ModItems.RAW_COBALT
                );
        //Trim Materials
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(
                ModItems.TIN_INGOT,
                ModItems.SILVER_INGOT,
                ModItems.STERLING_SILVER_INGOT, ModItems.ROSE_GOLD_INGOT, ModItems.BRONZE_INGOT, ModItems.COBALT_INGOT,
                ModItems.CARBON_STEEL_INGOT, ModItems.HARDENED_STEEL_INGOT, ModItems.TURQUOISE_GEM, ModItems.ONYX_GEM, ModItems.CITRINE_GEM, ModItems.TANZANITE_GEM,
                ModItems.TOURMALINE_GEM, ModItems.TOPAZ_GEM, ModItems.SPINEL_GEM, ModItems.SAPPHIRE_GEM, ModItems.RUBY_GEM, ModItems.MOISSANITE_GEM,
                ModItems.GRAPHENE_CHAINMAIL, ModItems.OBSIDIAN_INGOT, ModItems.ADAMANTIUM_INGOT, ModItems.ENDERITE_INGOT
                );
        //Trimmable Armor
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR).add(
                ModItems.TIN_HELMET, ModItems.TIN_CHESTPLATE, ModItems.TIN_LEGGINGS, ModItems.TIN_BOOTS,
                ModItems.SILVER_HELMET, ModItems.SILVER_CHESTPLATE, ModItems.SILVER_LEGGINGS, ModItems.SILVER_BOOTS,
                ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS,
                ModItems.STERLING_SILVER_HELMET, ModItems.STERLING_SILVER_CHESTPLATE, ModItems.STERLING_SILVER_LEGGINGS, ModItems.STERLING_SILVER_BOOTS,
                ModItems.BRONZE_HELMET, ModItems.BRONZE_CHESTPLATE, ModItems.BRONZE_LEGGINGS, ModItems.BRONZE_BOOTS,
                ModItems.ROSE_GOLD_HELMET, ModItems.ROSE_GOLD_CHESTPLATE, ModItems.ROSE_GOLD_LEGGINGS, ModItems.ROSE_GOLD_BOOTS,
                ModItems.COBALT_HELMET, ModItems.COBALT_CHESTPLATE, ModItems.COBALT_LEGGINGS, ModItems.COBALT_BOOTS,
                ModItems.CARBON_STEEL_HELMET, ModItems.CARBON_STEEL_CHESTPLATE, ModItems.CARBON_STEEL_LEGGINGS, ModItems.CARBON_STEEL_BOOTS,
                ModItems.HARDENED_STEEL_HELMET, ModItems.HARDENED_STEEL_CHESTPLATE, ModItems.HARDENED_STEEL_LEGGINGS, ModItems.HARDENED_STEEL_BOOTS,
                ModItems.TURQUOISE_HELMET, ModItems.TURQUOISE_CHESTPLATE, ModItems.TURQUOISE_LEGGINGS, ModItems.TURQUOISE_BOOTS,
                ModItems.LAPIS_LAZULI_HELMET, ModItems.LAPIS_LAZULI_CHESTPLATE, ModItems.LAPIS_LAZULI_LEGGINGS, ModItems.LAPIS_LAZULI_BOOTS,
                ModItems.AMETHYST_HELMET, ModItems.AMETHYST_CHESTPLATE, ModItems.AMETHYST_LEGGINGS, ModItems.AMETHYST_BOOTS,
                ModItems.ONYX_HELMET, ModItems.ONYX_CHESTPLATE, ModItems.ONYX_LEGGINGS, ModItems.ONYX_BOOTS,
                ModItems.CITRINE_HELMET, ModItems.CITRINE_CHESTPLATE, ModItems.CITRINE_LEGGINGS, ModItems.CITRINE_BOOTS,
                ModItems.TANZANITE_HELMET, ModItems.TANZANITE_CHESTPLATE, ModItems.TANZANITE_LEGGINGS, ModItems.TANZANITE_BOOTS,
                ModItems.TOURMALINE_HELMET, ModItems.TOURMALINE_CHESTPLATE, ModItems.TOURMALINE_LEGGINGS, ModItems.TOURMALINE_BOOTS,
                ModItems.TOPAZ_HELMET, ModItems.TOPAZ_CHESTPLATE, ModItems.TOPAZ_LEGGINGS, ModItems.TOPAZ_BOOTS,
                ModItems.EMERALD_HELMET, ModItems.EMERALD_CHESTPLATE, ModItems.EMERALD_LEGGINGS, ModItems.EMERALD_BOOTS,
                ModItems.RUBY_HELMET, ModItems.RUBY_CHESTPLATE, ModItems.RUBY_LEGGINGS, ModItems.RUBY_BOOTS,
                ModItems.SAPPHIRE_HELMET, ModItems.SAPPHIRE_CHESTPLATE, ModItems.SAPPHIRE_LEGGINGS, ModItems.SAPPHIRE_BOOTS,
                ModItems.SPINEL_HELMET, ModItems.SPINEL_CHESTPLATE, ModItems.SPINEL_LEGGINGS, ModItems.SPINEL_BOOTS,
                ModItems.MOISSANITE_HELMET, ModItems.MOISSANITE_CHESTPLATE, ModItems.MOISSANITE_LEGGINGS, ModItems.MOISSANITE_BOOTS,
                ModItems.GRAPHENE_CHAINMAIL_HELMET, ModItems.GRAPHENE_CHAINMAIL_CHESTPLATE, ModItems.GRAPHENE_CHAINMAIL_LEGGINGS, ModItems.GRAPHENE_CHAINMAIL_BOOTS,
                ModItems.OBSIDIAN_HELMET, ModItems.OBSIDIAN_CHESTPLATE, ModItems.OBSIDIAN_LEGGINGS, ModItems.OBSIDIAN_BOOTS,
                ModItems.ADAMANTIUM_HELMET, ModItems.ADAMANTIUM_CHESTPLATE, ModItems.ADAMANTIUM_LEGGINGS, ModItems.ADAMANTIUM_BOOTS,
                ModItems.ENDERITE_HELMET, ModItems.ENDERITE_CHESTPLATE, ModItems.ENDERITE_LEGGINGS, ModItems.ENDERITE_BOOTS
                     );
        //Enchantable Armor
        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE).add(
                ModItems.TIN_HELMET, ModItems.TIN_CHESTPLATE, ModItems.TIN_LEGGINGS, ModItems.TIN_BOOTS,
                ModItems.SILVER_HELMET, ModItems.SILVER_CHESTPLATE, ModItems.SILVER_LEGGINGS, ModItems.SILVER_BOOTS,
                ModItems.COPPER_HELMET, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_LEGGINGS, ModItems.COPPER_BOOTS,
                ModItems.STERLING_SILVER_HELMET, ModItems.STERLING_SILVER_CHESTPLATE, ModItems.STERLING_SILVER_LEGGINGS, ModItems.STERLING_SILVER_BOOTS,
                ModItems.ROSE_GOLD_HELMET, ModItems.ROSE_GOLD_CHESTPLATE, ModItems.ROSE_GOLD_LEGGINGS, ModItems.ROSE_GOLD_BOOTS,
                ModItems.BRONZE_HELMET, ModItems.BRONZE_CHESTPLATE, ModItems.BRONZE_LEGGINGS, ModItems.BRONZE_BOOTS,
                ModItems.COBALT_HELMET, ModItems.COBALT_CHESTPLATE, ModItems.COBALT_LEGGINGS, ModItems.COBALT_BOOTS,
                ModItems.CARBON_STEEL_HELMET, ModItems.CARBON_STEEL_CHESTPLATE, ModItems.CARBON_STEEL_LEGGINGS, ModItems.CARBON_STEEL_BOOTS,
                ModItems.HARDENED_STEEL_HELMET, ModItems.HARDENED_STEEL_CHESTPLATE, ModItems.HARDENED_STEEL_LEGGINGS, ModItems.HARDENED_STEEL_BOOTS,
                ModItems.TURQUOISE_HELMET, ModItems.TURQUOISE_CHESTPLATE, ModItems.TURQUOISE_LEGGINGS, ModItems.TURQUOISE_BOOTS,
                ModItems.LAPIS_LAZULI_HELMET, ModItems.LAPIS_LAZULI_CHESTPLATE, ModItems.LAPIS_LAZULI_LEGGINGS, ModItems.LAPIS_LAZULI_BOOTS,
                ModItems.AMETHYST_HELMET, ModItems.AMETHYST_CHESTPLATE, ModItems.AMETHYST_LEGGINGS, ModItems.AMETHYST_BOOTS,
                ModItems.CITRINE_HELMET, ModItems.CITRINE_CHESTPLATE, ModItems.CITRINE_LEGGINGS, ModItems.CITRINE_BOOTS,
                ModItems.ONYX_HELMET, ModItems.ONYX_CHESTPLATE, ModItems.ONYX_LEGGINGS, ModItems.ONYX_BOOTS,
                ModItems.TANZANITE_HELMET, ModItems.TANZANITE_CHESTPLATE, ModItems.TANZANITE_LEGGINGS, ModItems.TANZANITE_BOOTS,
                ModItems.TOURMALINE_HELMET, ModItems.TOURMALINE_CHESTPLATE, ModItems.TOURMALINE_LEGGINGS, ModItems.TOURMALINE_BOOTS,
                ModItems.TOPAZ_HELMET, ModItems.TOPAZ_CHESTPLATE, ModItems.TOPAZ_LEGGINGS, ModItems.TOPAZ_BOOTS,
                ModItems.RUBY_HELMET, ModItems.RUBY_CHESTPLATE, ModItems.RUBY_LEGGINGS, ModItems.RUBY_BOOTS,
                ModItems.SAPPHIRE_HELMET, ModItems.SAPPHIRE_CHESTPLATE, ModItems.SAPPHIRE_LEGGINGS, ModItems.SAPPHIRE_BOOTS,
                ModItems.SPINEL_HELMET, ModItems.SPINEL_CHESTPLATE, ModItems.SPINEL_LEGGINGS, ModItems.SPINEL_BOOTS,
                ModItems.EMERALD_HELMET, ModItems.EMERALD_CHESTPLATE, ModItems.EMERALD_LEGGINGS, ModItems.EMERALD_BOOTS,
                ModItems.MOISSANITE_HELMET, ModItems.MOISSANITE_CHESTPLATE, ModItems.MOISSANITE_LEGGINGS, ModItems.MOISSANITE_BOOTS,
                ModItems.GRAPHENE_CHAINMAIL_HELMET, ModItems.GRAPHENE_CHAINMAIL_CHESTPLATE, ModItems.GRAPHENE_CHAINMAIL_LEGGINGS, ModItems.GRAPHENE_CHAINMAIL_BOOTS,
                ModItems.OBSIDIAN_HELMET, ModItems.OBSIDIAN_CHESTPLATE, ModItems.OBSIDIAN_LEGGINGS, ModItems.OBSIDIAN_BOOTS,
                ModItems.ADAMANTIUM_HELMET, ModItems.ADAMANTIUM_CHESTPLATE, ModItems.ADAMANTIUM_LEGGINGS, ModItems.ADAMANTIUM_BOOTS,
                ModItems.ENDERITE_HELMET, ModItems.ENDERITE_CHESTPLATE, ModItems.ENDERITE_LEGGINGS, ModItems.ENDERITE_BOOTS
                );
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(
                ModItems.TIN_HELMET, ModItems.COPPER_HELMET, ModItems.SILVER_HELMET, ModItems.BRONZE_HELMET, ModItems.COBALT_HELMET, ModItems.STERLING_SILVER_HELMET, ModItems.ROSE_GOLD_HELMET,
                ModItems.CARBON_STEEL_HELMET, ModItems.HARDENED_STEEL_HELMET, ModItems.AMETHYST_HELMET, ModItems.EMERALD_HELMET, ModItems.TURQUOISE_HELMET, ModItems.LAPIS_LAZULI_HELMET,
                ModItems.TOURMALINE_HELMET, ModItems.TOPAZ_HELMET, ModItems.TANZANITE_HELMET,
                ModItems.RUBY_HELMET, ModItems.SAPPHIRE_HELMET, ModItems.SPINEL_HELMET, ModItems.CITRINE_HELMET, ModItems.MOISSANITE_HELMET, ModItems.ONYX_HELMET, ModItems.OBSIDIAN_HELMET,
                ModItems.GRAPHENE_CHAINMAIL_HELMET,
                ModItems.ADAMANTIUM_HELMET,
                ModItems.ENDERITE_HELMET
        );
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(
                ModItems.TIN_CHESTPLATE, ModItems.COPPER_CHESTPLATE, ModItems.SILVER_CHESTPLATE, ModItems.BRONZE_CHESTPLATE, ModItems.COBALT_CHESTPLATE, ModItems.STERLING_SILVER_CHESTPLATE, ModItems.ROSE_GOLD_CHESTPLATE,
                ModItems.CARBON_STEEL_CHESTPLATE, ModItems.HARDENED_STEEL_CHESTPLATE, ModItems.AMETHYST_CHESTPLATE, ModItems.EMERALD_CHESTPLATE, ModItems.TURQUOISE_CHESTPLATE, ModItems.LAPIS_LAZULI_CHESTPLATE,
                ModItems.TOURMALINE_CHESTPLATE, ModItems.TOPAZ_CHESTPLATE,  ModItems.TANZANITE_CHESTPLATE,
                ModItems.RUBY_CHESTPLATE, ModItems.SAPPHIRE_CHESTPLATE, ModItems.SPINEL_CHESTPLATE, ModItems.CITRINE_CHESTPLATE, ModItems.MOISSANITE_CHESTPLATE, ModItems.ONYX_CHESTPLATE,
                ModItems.OBSIDIAN_CHESTPLATE,
                ModItems.GRAPHENE_CHAINMAIL_CHESTPLATE,
                ModItems.ADAMANTIUM_CHESTPLATE,
                ModItems.ENDERITE_CHESTPLATE,

                ModItems.TIN_HORSE_ARMOR, ModItems.COPPER_HORSE_ARMOR, ModItems.SILVER_HORSE_ARMOR, ModItems.BRONZE_HORSE_ARMOR, ModItems.COBALT_HORSE_ARMOR, ModItems.STERLING_SILVER_HORSE_ARMOR, ModItems.ROSE_GOLD_HORSE_ARMOR,
                ModItems.CARBON_STEEL_HORSE_ARMOR, ModItems.HARDENED_STEEL_HORSE_ARMOR, ModItems.AMETHYST_HORSE_ARMOR, ModItems.EMERALD_HORSE_ARMOR, ModItems.TURQUOISE_HORSE_ARMOR, ModItems.LAPIS_LAZULI_HORSE_ARMOR,
                ModItems.TOURMALINE_HORSE_ARMOR, ModItems.TOPAZ_HORSE_ARMOR,  ModItems.TANZANITE_HORSE_ARMOR,
                ModItems.RUBY_HORSE_ARMOR, ModItems.SAPPHIRE_HORSE_ARMOR, ModItems.SPINEL_HORSE_ARMOR, ModItems.CITRINE_HORSE_ARMOR, ModItems.MOISSANITE_HORSE_ARMOR, ModItems.ONYX_HORSE_ARMOR,
                ModItems.OBSIDIAN_HORSE_ARMOR,
//                ModItems.GRAPHENE_HORSE_ARMOR,
                ModItems.ADAMANTIUM_HORSE_ARMOR,
                ModItems.ENDERITE_HORSE_ARMOR,

                ModItems.ROSE_GOLD_WOLF_ARMOR
        );
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE).add(
                ModItems.TIN_LEGGINGS, ModItems.COPPER_LEGGINGS, ModItems.SILVER_LEGGINGS, ModItems.BRONZE_LEGGINGS, ModItems.COBALT_LEGGINGS, ModItems.STERLING_SILVER_LEGGINGS, ModItems.ROSE_GOLD_LEGGINGS,
                ModItems.CARBON_STEEL_LEGGINGS, ModItems.HARDENED_STEEL_LEGGINGS, ModItems.AMETHYST_LEGGINGS, ModItems.EMERALD_LEGGINGS, ModItems.TURQUOISE_LEGGINGS, ModItems.LAPIS_LAZULI_LEGGINGS,
                ModItems.TOURMALINE_LEGGINGS, ModItems.TOPAZ_LEGGINGS, ModItems.TANZANITE_LEGGINGS,
                ModItems.RUBY_LEGGINGS, ModItems.SAPPHIRE_LEGGINGS, ModItems.SPINEL_LEGGINGS, ModItems.CITRINE_LEGGINGS, ModItems.MOISSANITE_LEGGINGS, ModItems.ONYX_LEGGINGS, ModItems.OBSIDIAN_LEGGINGS,
                ModItems.GRAPHENE_CHAINMAIL_LEGGINGS,
                ModItems.ADAMANTIUM_LEGGINGS,
                ModItems.ENDERITE_LEGGINGS
        );
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(
                ModItems.TIN_BOOTS, ModItems.COPPER_BOOTS, ModItems.SILVER_BOOTS, ModItems.BRONZE_BOOTS, ModItems.COBALT_BOOTS, ModItems.STERLING_SILVER_BOOTS, ModItems.ROSE_GOLD_BOOTS,
                ModItems.CARBON_STEEL_BOOTS, ModItems.HARDENED_STEEL_BOOTS, ModItems.AMETHYST_BOOTS, ModItems.EMERALD_BOOTS, ModItems.TURQUOISE_BOOTS, ModItems.LAPIS_LAZULI_BOOTS,
                ModItems.TOURMALINE_BOOTS, ModItems.TOPAZ_BOOTS, ModItems.TANZANITE_BOOTS,
                ModItems.RUBY_BOOTS, ModItems.SAPPHIRE_BOOTS, ModItems.SPINEL_BOOTS, ModItems.CITRINE_BOOTS, ModItems.MOISSANITE_BOOTS, ModItems.ONYX_BOOTS, ModItems.OBSIDIAN_BOOTS,
                ModItems.GRAPHENE_CHAINMAIL_BOOTS,
                ModItems.ADAMANTIUM_BOOTS,
                ModItems.ENDERITE_BOOTS
        );
        //Regular Armor tags
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(
                ModItems.TIN_HELMET, ModItems.COPPER_HELMET, ModItems.SILVER_HELMET, ModItems.BRONZE_HELMET, ModItems.COBALT_HELMET, ModItems.STERLING_SILVER_HELMET, ModItems.ROSE_GOLD_HELMET,
                ModItems.CARBON_STEEL_HELMET, ModItems.HARDENED_STEEL_HELMET, ModItems.AMETHYST_HELMET, ModItems.EMERALD_HELMET, ModItems.TURQUOISE_HELMET, ModItems.LAPIS_LAZULI_HELMET,
                ModItems.TOURMALINE_HELMET, ModItems.TOPAZ_HELMET, ModItems.TANZANITE_HELMET,
                ModItems.RUBY_HELMET, ModItems.SAPPHIRE_HELMET, ModItems.SPINEL_HELMET, ModItems.CITRINE_HELMET, ModItems.MOISSANITE_HELMET, ModItems.ONYX_HELMET, ModItems.OBSIDIAN_HELMET,
                ModItems.GRAPHENE_CHAINMAIL_HELMET,
                ModItems.ADAMANTIUM_HELMET,
                ModItems.ENDERITE_HELMET
        );
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(
                ModItems.TIN_CHESTPLATE, ModItems.COPPER_CHESTPLATE, ModItems.SILVER_CHESTPLATE, ModItems.BRONZE_CHESTPLATE, ModItems.COBALT_CHESTPLATE, ModItems.STERLING_SILVER_CHESTPLATE, ModItems.ROSE_GOLD_CHESTPLATE,
                ModItems.CARBON_STEEL_CHESTPLATE, ModItems.HARDENED_STEEL_CHESTPLATE, ModItems.AMETHYST_CHESTPLATE, ModItems.EMERALD_CHESTPLATE, ModItems.TURQUOISE_CHESTPLATE, ModItems.LAPIS_LAZULI_CHESTPLATE,
                ModItems.TOURMALINE_CHESTPLATE, ModItems.TOPAZ_CHESTPLATE, ModItems.TANZANITE_CHESTPLATE,
                ModItems.RUBY_CHESTPLATE, ModItems.SAPPHIRE_CHESTPLATE, ModItems.SPINEL_CHESTPLATE, ModItems.CITRINE_CHESTPLATE, ModItems.MOISSANITE_CHESTPLATE, ModItems.ONYX_CHESTPLATE,
                ModItems.OBSIDIAN_CHESTPLATE,
                ModItems.GRAPHENE_CHAINMAIL_CHESTPLATE,
                ModItems.ADAMANTIUM_CHESTPLATE,
                ModItems.ENDERITE_CHESTPLATE
        );
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(
                ModItems.TIN_LEGGINGS, ModItems.COPPER_LEGGINGS, ModItems.SILVER_LEGGINGS, ModItems.BRONZE_LEGGINGS, ModItems.COBALT_LEGGINGS, ModItems.STERLING_SILVER_LEGGINGS, ModItems.ROSE_GOLD_LEGGINGS,
                ModItems.CARBON_STEEL_LEGGINGS, ModItems.HARDENED_STEEL_LEGGINGS, ModItems.AMETHYST_LEGGINGS, ModItems.EMERALD_LEGGINGS, ModItems.TURQUOISE_LEGGINGS, ModItems.LAPIS_LAZULI_LEGGINGS,
                ModItems.TOURMALINE_LEGGINGS, ModItems.TOPAZ_LEGGINGS, ModItems.TANZANITE_LEGGINGS,
                ModItems.RUBY_LEGGINGS, ModItems.SAPPHIRE_LEGGINGS, ModItems.SPINEL_LEGGINGS, ModItems.CITRINE_LEGGINGS, ModItems.MOISSANITE_LEGGINGS, ModItems.ONYX_LEGGINGS, ModItems.OBSIDIAN_LEGGINGS,
                ModItems.GRAPHENE_CHAINMAIL_LEGGINGS,
                ModItems.ADAMANTIUM_LEGGINGS,
                ModItems.ENDERITE_LEGGINGS
        );
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(
                ModItems.TIN_BOOTS, ModItems.COPPER_BOOTS, ModItems.SILVER_BOOTS, ModItems.BRONZE_BOOTS, ModItems.COBALT_BOOTS, ModItems.STERLING_SILVER_BOOTS, ModItems.ROSE_GOLD_BOOTS,
                ModItems.CARBON_STEEL_BOOTS, ModItems.HARDENED_STEEL_BOOTS, ModItems.AMETHYST_BOOTS, ModItems.EMERALD_BOOTS, ModItems.TURQUOISE_BOOTS, ModItems.LAPIS_LAZULI_BOOTS,
                ModItems.TOURMALINE_BOOTS, ModItems.TOPAZ_BOOTS, ModItems.TANZANITE_BOOTS,
                ModItems.RUBY_BOOTS, ModItems.SAPPHIRE_BOOTS, ModItems.SPINEL_BOOTS, ModItems.CITRINE_BOOTS, ModItems.MOISSANITE_BOOTS, ModItems.ONYX_BOOTS, ModItems.OBSIDIAN_BOOTS,
                ModItems.GRAPHENE_CHAINMAIL_BOOTS,
                ModItems.ADAMANTIUM_BOOTS,
                ModItems.ENDERITE_BOOTS
        );

        //Music Discs
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS).add(
                ModItems.SWEET_CAROLINE_MUSIC_DISC, ModItems.CIPHER_MUSIC_DISC
        );
        getOrCreateTagBuilder(ConventionalItemTags.MUSIC_DISCS).add(
                ModItems.SWEET_CAROLINE_MUSIC_DISC, ModItems.CIPHER_MUSIC_DISC);

        //Wolf food (raw duck)
        getOrCreateTagBuilder(ItemTags.WOLF_FOOD).add(
                ModItems.RAW_DUCK
        );

        //Tame cats (raw duck / tropical fish)
        getOrCreateTagBuilder(ItemTags.CAT_FOOD).add(
                ModItems.RAW_DUCK,
                Items.TROPICAL_FISH
        );

        //Backported Spears
        if (isBackportedSpearsLoaded()) {
            getOrCreateTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("spears"))).add(
                    ModItems.ROSE_GOLD_SPEAR,
                    ModItems.CARBON_STEEL_SPEAR,
                    ModItems.HARDENED_STEEL_SPEAR,
                    ModItems.ENDERITE_SPEAR
            );
        }

        /*
         * Modded tags
         */
        //Wolf Armors
        // Allow wolves to equip these (our mixin will check this tag)
        getOrCreateTagBuilder(ModTags.Items.WOLF_ARMOR).add(
                ModItems.TIN_WOLF_ARMOR,
                ModItems.GOLD_WOLF_ARMOR,
                ModItems.SILVER_WOLF_ARMOR,
                ModItems.COPPER_WOLF_ARMOR,
                ModItems.STERLING_SILVER_WOLF_ARMOR,
                ModItems.ROSE_GOLD_WOLF_ARMOR,
                ModItems.BRONZE_WOLF_ARMOR,
                ModItems.IRON_WOLF_ARMOR,
                ModItems.COBALT_WOLF_ARMOR,
                ModItems.CARBON_STEEL_WOLF_ARMOR,
                ModItems.HARDENED_STEEL_WOLF_ARMOR,
                ModItems.DIAMOND_WOLF_ARMOR
        );
        getOrCreateTagBuilder(ModTags.Items.SHEAR_REMOVES_ANIMAL_ARMOR)
                // Vanilla
                .add(Items.LEATHER_HORSE_ARMOR)
                .add(Items.IRON_HORSE_ARMOR)
                .add(Items.GOLDEN_HORSE_ARMOR)
                .add(Items.DIAMOND_HORSE_ARMOR)
                .add(Items.WOLF_ARMOR)

                // Horse armors (you have a lot; add all you want)
                .add(ModItems.TIN_HORSE_ARMOR)
                .add(ModItems.SILVER_HORSE_ARMOR)
                .add(ModItems.COPPER_HORSE_ARMOR)
                .add(ModItems.STERLING_SILVER_HORSE_ARMOR)
                .add(ModItems.ROSE_GOLD_HORSE_ARMOR)
                .add(ModItems.BRONZE_HORSE_ARMOR)
                .add(ModItems.COBALT_HORSE_ARMOR)
                .add(ModItems.CARBON_STEEL_HORSE_ARMOR)
                .add(ModItems.HARDENED_STEEL_HORSE_ARMOR)
                .add(ModItems.TURQUOISE_HORSE_ARMOR)
                .add(ModItems.AMETHYST_HORSE_ARMOR)
                .add(ModItems.LAPIS_LAZULI_HORSE_ARMOR)
                .add(ModItems.TOURMALINE_HORSE_ARMOR)
                .add(ModItems.TANZANITE_HORSE_ARMOR)
                .add(ModItems.TOPAZ_HORSE_ARMOR)
                .add(ModItems.EMERALD_HORSE_ARMOR)
                .add(ModItems.RUBY_HORSE_ARMOR)
                .add(ModItems.SAPPHIRE_HORSE_ARMOR)
                .add(ModItems.SPINEL_HORSE_ARMOR)
                .add(ModItems.CITRINE_HORSE_ARMOR)
                .add(ModItems.MOISSANITE_HORSE_ARMOR)
                .add(ModItems.ONYX_HORSE_ARMOR)
                .add(ModItems.OBSIDIAN_HORSE_ARMOR)
//                .add(ModItems.GRAPHENE_HORSE_ARMOR)
                .add(ModItems.NETHERITE_HORSE_ARMOR)
                .add(ModItems.ADAMANTIUM_HORSE_ARMOR)
                .add(ModItems.ENDERITE_HORSE_ARMOR)

                // Wolf armors
                .add(ModItems.TIN_WOLF_ARMOR)
                .add(ModItems.GOLD_WOLF_ARMOR)
                .add(ModItems.SILVER_WOLF_ARMOR)
                .add(ModItems.COPPER_WOLF_ARMOR)
                .add(ModItems.STERLING_SILVER_WOLF_ARMOR)
                .add(ModItems.BRONZE_WOLF_ARMOR)
                .add(ModItems.ROSE_GOLD_WOLF_ARMOR)
                .add(ModItems.IRON_WOLF_ARMOR)
                .add(ModItems.COBALT_WOLF_ARMOR)
                .add(ModItems.CARBON_STEEL_WOLF_ARMOR)
                .add(ModItems.HARDENED_STEEL_WOLF_ARMOR)
                .add(ModItems.DIAMOND_WOLF_ARMOR);

//        getOrCreateTagBuilder(ModTags.Items.SHEAR_REMOVES_SADDLE).add(Items.SADDLE);

        getOrCreateTagBuilder(ModTags.Items.ANTHRACITE).add(ModItems.ANTHRACITE);
        getOrCreateTagBuilder(ModTags.Items.LAPIS_LAZULI_DUST).add(ModItems.LAPIS_LAZULI_DUST);
        getOrCreateTagBuilder(ModTags.Items.TURQUOISE_DUST).add(ModItems.TURQUOISE_DUST);
        getOrCreateTagBuilder(ModTags.Items.QUARTZ_DUST).add(ModItems.QUARTZ_DUST);
        getOrCreateTagBuilder(ModTags.Items.AMETHYST_DUST).add(ModItems.AMETHYST_DUST);
        getOrCreateTagBuilder(ModTags.Items.TIN_NUGGET).add(ModItems.TIN_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.SILVER_NUGGET).add(ModItems.SILVER_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.BRONZE_NUGGET).add(ModItems.BRONZE_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.COBALT_NUGGET).add(ModItems.COBALT_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.STERLING_SILVER_NUGGET).add(ModItems.STERLING_SILVER_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.ROSE_GOLD_NUGGET).add(ModItems.ROSE_GOLD_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.CARBON_STEEL_NUGGET).add(ModItems.CARBON_STEEL_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.HARDENED_STEEL_NUGGET).add(ModItems.HARDENED_STEEL_NUGGET);
        getOrCreateTagBuilder(ModTags.Items.TIN_INGOT).add(ModItems.TIN_INGOT);
        getOrCreateTagBuilder(ModTags.Items.SILVER_INGOT).add(ModItems.SILVER_INGOT);
        getOrCreateTagBuilder(ModTags.Items.BRONZE_INGOT).add(ModItems.BRONZE_INGOT);
        getOrCreateTagBuilder(ModTags.Items.COBALT_INGOT).add(ModItems.COBALT_INGOT);
        getOrCreateTagBuilder(ModTags.Items.STERLING_SILVER_INGOT).add(ModItems.STERLING_SILVER_INGOT);
        getOrCreateTagBuilder(ModTags.Items.ROSE_GOLD_INGOT).add(ModItems.ROSE_GOLD_INGOT);
        getOrCreateTagBuilder(ModTags.Items.CARBON_STEEL_INGOT).add(ModItems.CARBON_STEEL_INGOT);
        getOrCreateTagBuilder(ModTags.Items.HARDENED_STEEL_INGOT).add(ModItems.HARDENED_STEEL_INGOT);
        getOrCreateTagBuilder(ModTags.Items.AMETHYST_GEM).add(ModItems.AMETHYST_GEM);
        getOrCreateTagBuilder(ModTags.Items.CITRINE_GEM).add(ModItems.CITRINE_GEM);
        getOrCreateTagBuilder(ModTags.Items.ONYX_GEM).add(ModItems.ONYX_GEM);
        getOrCreateTagBuilder(ModTags.Items.LAPIS_LAZULI_GEM).add(ModItems.LAPIS_LAZULI_GEM);
        getOrCreateTagBuilder(ModTags.Items.TURQUOISE_GEM).add(ModItems.TURQUOISE_GEM);
        getOrCreateTagBuilder(ModTags.Items.TANZANITE_GEM).add(ModItems.TANZANITE_GEM);
        getOrCreateTagBuilder(ModTags.Items.TOURMALINE_GEM).add(ModItems.TOURMALINE_GEM);
        getOrCreateTagBuilder(ModTags.Items.TOPAZ_GEM).add(ModItems.TOPAZ_GEM);
        getOrCreateTagBuilder(ModTags.Items.RUBY_GEM).add(ModItems.RUBY_GEM);
        getOrCreateTagBuilder(ModTags.Items.SAPPHIRE_GEM).add(ModItems.SAPPHIRE_GEM);
        getOrCreateTagBuilder(ModTags.Items.SPINEL_GEM).add(ModItems.SPINEL_GEM);
        getOrCreateTagBuilder(ModTags.Items.MOISSANITE_GEM).add(ModItems.MOISSANITE_GEM);
        getOrCreateTagBuilder(ModTags.Items.GRAPHENE_GEM).add(ModItems.GRAPHENE_CHAINMAIL);
        getOrCreateTagBuilder(ModTags.Items.OBSIDIAN_INGOT).add(ModItems.OBSIDIAN_INGOT);
        getOrCreateTagBuilder(ModTags.Items.ADAMANTIUM_INGOT).add(ModItems.ADAMANTIUM_INGOT);
        getOrCreateTagBuilder(ModTags.Items.ENDERITE_INGOT).add(ModItems.ENDERITE_INGOT);
    }
}