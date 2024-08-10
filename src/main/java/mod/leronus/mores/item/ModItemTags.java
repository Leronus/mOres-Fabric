package mod.leronus.mores.item;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> GRAPHENE_GEM = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/graphene"));
    public static final TagKey<Item> MOISSANITE_GEM = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/moissanite"));
    public static final TagKey<Item> ONYX_GEM = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/onyx"));
    public static final TagKey<Item> RUBY_GEM = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/ruby"));
    public static final TagKey<Item> SAPPHIRE_GEM = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/sapphire"));
    public static final TagKey<Item> TANZANITE_GEM = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tanzanite"));
    public static final TagKey<Item> TOPAZ_GEM = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/topaz"));
    public static final TagKey<Item> TOURMALINE_GEM = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/tourmaline"));
    public static final TagKey<Item> TURQUOISE_GEM = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "gem/turquoise"));

    public static final TagKey<Item> BRONZE_INGOT = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/bronze"));
    public static final TagKey<Item> COBALT_INGOT = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/cobalt"));
    public static final TagKey<Item> OBSIDIAN_INGOT = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/obsidian"));
    public static final TagKey<Item> SILVER_INGOT = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/silver"));
    public static final TagKey<Item> STEEL_INGOT = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/steel"));
    public static final TagKey<Item> STERLING_INGOT = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/sterling_silver"));
    public static final TagKey<Item> TIN_INGOT = TagKey.of(RegistryKeys.ITEM, Identifier.of("mores", "ingot/tin"));
}
