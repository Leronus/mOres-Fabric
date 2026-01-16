package mod.leronus.mores.item;

import mod.leronus.mores.Mores;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ADAMANTIUM_TOOL = createTag("needs_adamantium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ADAMANTIUM_TOOL = createTag("incorrect_for_adamantium_tool");


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Mores.MOD_ID, name));
        }
    }

    public static class Items {
        /** Vanilla does not expose ItemTags.WOLF_ARMOR in your mappings, but tags can still exist. */
        public static final TagKey<Item> WOLF_ARMOR =
                TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "wolf_armor"));

//        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> ANTHRACITE = createTag("coal/anthracite");

        public static final TagKey<Item> TURQUOISE_DUST = createTag("dust/turquoise");
        public static final TagKey<Item> QUARTZ_DUST = createTag("dust/quartz");
        public static final TagKey<Item> LAPIS_LAZULI_DUST = createTag("dust/lapis_lazuli");
        public static final TagKey<Item> AMETHYST_DUST = createTag("dust/amethyst");

        public static final TagKey<Item> TIN_NUGGET = createTag("nugget/tin");
        public static final TagKey<Item> SILVER_NUGGET = createTag("nugget/silver");
        public static final TagKey<Item> STERLING_SILVER_NUGGET = createTag("nugget/sterling_silver");
        public static final TagKey<Item> ROSE_GOLD_NUGGET = createTag("nugget/rose_gold");
        public static final TagKey<Item> BRONZE_NUGGET = createTag("nugget/bronze");
        public static final TagKey<Item> COBALT_NUGGET = createTag("nugget/cobalt");
        public static final TagKey<Item> CARBON_STEEL_NUGGET = createTag("nugget/carbon_steel");
        public static final TagKey<Item> HARDENED_STEEL_NUGGET = createTag("nugget/hardened_steel");

        public static final TagKey<Item> TIN_INGOT = createTag("ingot/tin");
        public static final TagKey<Item> SILVER_INGOT = createTag("ingot/silver");
        public static final TagKey<Item> STERLING_SILVER_INGOT = createTag("ingot/sterling_silver");
        public static final TagKey<Item> ROSE_GOLD_INGOT = createTag("ingot/rose_gold");
        public static final TagKey<Item> BRONZE_INGOT = createTag("ingot/bronze");
        public static final TagKey<Item> COBALT_INGOT = createTag("ingot/cobalt");
        public static final TagKey<Item> CARBON_STEEL_INGOT = createTag("ingot/carbon_steel");
        public static final TagKey<Item> HARDENED_STEEL_INGOT = createTag("ingot/hardened_steel");

        public static final TagKey<Item> TURQUOISE_GEM = createTag("gem/turquoise");
        public static final TagKey<Item> LAPIS_LAZULI_GEM = createTag("gem/lapis_lazuli");
        public static final TagKey<Item> AMETHYST_GEM = createTag("gem/amethyst");
        public static final TagKey<Item> CITRINE_GEM = createTag("gem/citrine");
        public static final TagKey<Item> ONYX_GEM = createTag("gem/onyx");
        public static final TagKey<Item> TANZANITE_GEM = createTag("gem/tanzanite");
        public static final TagKey<Item> TOPAZ_GEM = createTag("gem/topaz");
        public static final TagKey<Item> TOURMALINE_GEM = createTag("gem/tourmaline");
        public static final TagKey<Item> RUBY_GEM = createTag("gem/ruby");
        public static final TagKey<Item> SAPPHIRE_GEM = createTag("gem/sapphire");
        public static final TagKey<Item> SPINEL_GEM = createTag("gem/spinel");
        public static final TagKey<Item> MOISSANITE_GEM = createTag("gem/moissanite");
        public static final TagKey<Item> GRAPHENE_GEM = createTag("gem/graphene");

        public static final TagKey<Item> OBSIDIAN_INGOT = createTag("ingot/obsidian");
        public static final TagKey<Item> ADAMANTIUM_INGOT = createTag("ingot/adamantium");
        public static final TagKey<Item> ENDERITE_INGOT = createTag("ingot/enderite");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Mores.MOD_ID, name));
        }
    }
}
