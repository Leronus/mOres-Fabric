package mod.leronus.mores.item.custom;

import mod.leronus.mores.Mores;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem {
    private static final Formatting TITLE_FORMAT = Formatting.GRAY;
    private static final Formatting DESCRIPTION_FORMAT = Formatting.BLUE;
    private static final String DESCRIPTION_ID = Util.createTranslationKey("item", new Identifier("smithing_template"));
    private static final Text INGREDIENTS_TITLE = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID, "smithing_template.ingredients"))).formatted(TITLE_FORMAT);
    private static final Text APPLIES_TO_TITLE = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.applies_to"))).formatted(TITLE_FORMAT);
    private static final Text OBSIDIAN_UPGRADE = Text.translatable(Util.createTranslationKey("upgrade", new Identifier(Mores.MOD_ID,"obsidian_upgrade"))).formatted(TITLE_FORMAT);
    private static final Text ARMOR_TRIM_APPLIES_TO = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.armor_trim.applies_to"))).formatted(DESCRIPTION_FORMAT);
    private static final Text ARMOR_TRIM_INGREDIENTS = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.armor_trim.ingredients"))).formatted(DESCRIPTION_FORMAT);
    private static final Text ARMOR_TRIM_BASE_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.armor_trim.base_slot_description")));
    private static final Text ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.armor_trim.additions_slot_description")));
    private static final Text OBSIDIAN_UPGRADE_APPLIES_TO = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.obsidian_upgrade.applies_to"))).formatted(DESCRIPTION_FORMAT);
    private static final Text OBSIDIAN_UPGRADE_INGREDIENTS = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.obsidian_upgrade.ingredients"))).formatted(DESCRIPTION_FORMAT);
    private static final Text OBSIDIAN_UPGRADE_BASE_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.obsidian_upgrade.base_slot_description")));
    private static final Text OBSIDIAN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.obsidian_upgrade.additions_slot_description")));

    private static final Text BRONZE_ALLOY = Text.translatable(Util.createTranslationKey("alloy", new Identifier(Mores.MOD_ID,"bronze_alloy"))).formatted(TITLE_FORMAT);
    private static final Text BRONZE_ALLOY_APPLIES_TO = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.bronze_alloy.applies_to"))).formatted(DESCRIPTION_FORMAT);
    private static final Text BRONZE_ALLOY_INGREDIENTS = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.bronze_alloy.ingredients"))).formatted(DESCRIPTION_FORMAT);
    private static final Text BRONZE_ALLOY_BASE_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.bronze_alloy.base_slot_description")));
    private static final Text BRONZE_ALLOY_ADDITIONS_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.bronze_alloy.additions_slot_description")));

    private static final Text STERLING_ALLOY = Text.translatable(Util.createTranslationKey("alloy", new Identifier(Mores.MOD_ID,"sterling_alloy"))).formatted(TITLE_FORMAT);
    private static final Text STERLING_ALLOY_APPLIES_TO = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.sterling_alloy.applies_to"))).formatted(DESCRIPTION_FORMAT);
    private static final Text STERLING_ALLOY_INGREDIENTS = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.sterling_alloy.ingredients"))).formatted(DESCRIPTION_FORMAT);
    private static final Text STERLING_ALLOY_BASE_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.sterling_alloy.base_slot_description")));
    private static final Text STERLING_ALLOY_ADDITIONS_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.sterling_alloy.additions_slot_description")));

    private static final Text STEEL_ALLOY = Text.translatable(Util.createTranslationKey("alloy", new Identifier(Mores.MOD_ID,"steel_alloy"))).formatted(TITLE_FORMAT);
    private static final Text STEEL_ALLOY_APPLIES_TO = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.steel_alloy.applies_to"))).formatted(DESCRIPTION_FORMAT);
    private static final Text STEEL_ALLOY_INGREDIENTS = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.steel_alloy.ingredients"))).formatted(DESCRIPTION_FORMAT);
    private static final Text STEEL_ALLOY_BASE_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.steel_alloy.base_slot_description")));
    private static final Text STEEL_ALLOY_ADDITIONS_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.steel_alloy.additions_slot_description")));

    private static final Text GRAPHENE_ALLOY = Text.translatable(Util.createTranslationKey("alloy", new Identifier(Mores.MOD_ID,"graphene_alloy"))).formatted(TITLE_FORMAT);
    private static final Text GRAPHENE_ALLOY_APPLIES_TO = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.graphene_alloy.applies_to"))).formatted(DESCRIPTION_FORMAT);
    private static final Text GRAPHENE_ALLOY_INGREDIENTS = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.graphene_alloy.ingredients"))).formatted(DESCRIPTION_FORMAT);
    private static final Text GRAPHENE_ALLOY_BASE_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.graphene_alloy.base_slot_description")));
    private static final Text GRAPHENE_ALLOY_ADDITIONS_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", new Identifier(Mores.MOD_ID,"smithing_template.graphene_alloy.additions_slot_description")));

    private static final Identifier EMPTY_SLOT_HELMET = new Identifier("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_SLOT_CHESTPLATE = new Identifier("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_SLOT_LEGGINGS = new Identifier("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_SLOT_BOOTS = new Identifier("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_HOE = new Identifier("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE = new Identifier("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD = new Identifier("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL = new Identifier("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE = new Identifier("item/empty_slot_pickaxe");
    private static final Identifier EMPTY_SLOT_INGOT = new Identifier("item/empty_slot_ingot");
    private static final Identifier EMPTY_SLOT_REDSTONE_DUST = new Identifier("item/empty_slot_redstone_dust");
    private static final Identifier EMPTY_SLOT_QUARTZ = new Identifier("item/empty_slot_quartz");
    private static final Identifier EMPTY_SLOT_EMERALD = new Identifier("item/empty_slot_emerald");
    private static final Identifier EMPTY_SLOT_DIAMOND = new Identifier("item/empty_slot_diamond");
    private static final Identifier EMPTY_SLOT_LAPIS_LAZULI = new Identifier("item/empty_slot_lapis_lazuli");
    private static final Identifier EMPTY_SLOT_AMETHYST_SHARD = new Identifier("item/empty_slot_amethyst_shard");
    private static final Identifier EMPTY_SLOT_BATTLEAXE = new Identifier(Mores.MOD_ID, "item/empty_battleaxe");
    private static final Identifier EMPTY_SLOT_MACE = new Identifier(Mores.MOD_ID,"item/empty_mace");
    private static final Identifier EMPTY_SLOT_DAGGER = new Identifier(Mores.MOD_ID,"item/empty_dagger");
    private static final Identifier EMPTY_SLOT_COAL = new Identifier(Mores.MOD_ID, "item/empty_slot_coal");

    public ModSmithingTemplateItem(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
    }

    private static List<Identifier> getArmorTrimEmptyBaseSlotTextures() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }

    private static List<Identifier> getArmorTrimEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT, EMPTY_SLOT_REDSTONE_DUST, EMPTY_SLOT_LAPIS_LAZULI, EMPTY_SLOT_QUARTZ, EMPTY_SLOT_DIAMOND, EMPTY_SLOT_EMERALD, EMPTY_SLOT_AMETHYST_SHARD);
    }

    private static List<Identifier> getObsidianUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_SLOT_MACE, EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_BATTLEAXE, EMPTY_SLOT_SHOVEL, EMPTY_SLOT_DAGGER);
    }

    private static List<Identifier> createIngotAlloyIconList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
    private static List<Identifier> createCoalIconList() {
        return List.of(EMPTY_SLOT_COAL);
    }
    private static List<Identifier> createGemAlloyIconList() {
        return List.of(EMPTY_SLOT_DIAMOND);
    }
    public static SmithingTemplateItem createObsidianUpgrade() {
        return new SmithingTemplateItem(OBSIDIAN_UPGRADE_APPLIES_TO, OBSIDIAN_UPGRADE_INGREDIENTS, OBSIDIAN_UPGRADE, OBSIDIAN_UPGRADE_BASE_SLOT_DESCRIPTION, OBSIDIAN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, ModSmithingTemplateItem.getObsidianUpgradeEmptyBaseSlotTextures(), ModSmithingTemplateItem.createIngotAlloyIconList());
    }

    public static SmithingTemplateItem createBronzeAlloyTemplate() {
        return new SmithingTemplateItem(BRONZE_ALLOY_APPLIES_TO, BRONZE_ALLOY_INGREDIENTS, BRONZE_ALLOY, BRONZE_ALLOY_BASE_SLOT_DESCRIPTION, BRONZE_ALLOY_ADDITIONS_SLOT_DESCRIPTION, createIngotAlloyIconList(), createIngotAlloyIconList());
    }
    public static SmithingTemplateItem createSterlingAlloyTemplate() {
        return new SmithingTemplateItem(STERLING_ALLOY_APPLIES_TO, STERLING_ALLOY_INGREDIENTS, STERLING_ALLOY, STERLING_ALLOY_BASE_SLOT_DESCRIPTION, STERLING_ALLOY_ADDITIONS_SLOT_DESCRIPTION, createIngotAlloyIconList(), createIngotAlloyIconList());
    }

    public static SmithingTemplateItem createSteelAlloyTemplate() {
        return new SmithingTemplateItem(STEEL_ALLOY_APPLIES_TO, STEEL_ALLOY_INGREDIENTS, STEEL_ALLOY, STEEL_ALLOY_BASE_SLOT_DESCRIPTION, STEEL_ALLOY_ADDITIONS_SLOT_DESCRIPTION, getObsidianUpgradeEmptyBaseSlotTextures(), createCoalIconList());
    }

    public static SmithingTemplateItem createGrapheneAlloyTemplate() {
        return new SmithingTemplateItem(GRAPHENE_ALLOY_APPLIES_TO, GRAPHENE_ALLOY_INGREDIENTS, GRAPHENE_ALLOY, GRAPHENE_ALLOY_BASE_SLOT_DESCRIPTION, GRAPHENE_ALLOY_ADDITIONS_SLOT_DESCRIPTION, createGemAlloyIconList(), createGemAlloyIconList());
    }
}
