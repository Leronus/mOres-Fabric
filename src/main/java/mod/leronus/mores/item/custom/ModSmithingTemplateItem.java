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
    private static final String DESCRIPTION_ID = Util.createTranslationKey("item", Identifier.of("smithing_template"));
    private static final Text INGREDIENTS_TITLE = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID, "smithing_template.ingredients"))).formatted(TITLE_FORMAT);
    private static final Text APPLIES_TO_TITLE = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.applies_to"))).formatted(TITLE_FORMAT);
    private static final Text OBSIDIAN_UPGRADE = Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(Mores.MOD_ID,"obsidian_upgrade"))).formatted(TITLE_FORMAT);
    private static final Text ARMOR_TRIM_APPLIES_TO = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.armor_trim.applies_to"))).formatted(DESCRIPTION_FORMAT);
    private static final Text ARMOR_TRIM_INGREDIENTS = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.armor_trim.ingredients"))).formatted(DESCRIPTION_FORMAT);
    private static final Text ARMOR_TRIM_BASE_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.armor_trim.base_slot_description")));
    private static final Text ARMOR_TRIM_ADDITIONS_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.armor_trim.additions_slot_description")));
    private static final Text OBSIDIAN_UPGRADE_APPLIES_TO = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.obsidian_upgrade.applies_to"))).formatted(DESCRIPTION_FORMAT);
    private static final Text OBSIDIAN_UPGRADE_INGREDIENTS = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.obsidian_upgrade.ingredients"))).formatted(DESCRIPTION_FORMAT);
    private static final Text OBSIDIAN_UPGRADE_BASE_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.obsidian_upgrade.base_slot_description")));
    private static final Text OBSIDIAN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.obsidian_upgrade.additions_slot_description")));

    private static final Text HARDENED_STEEL_UPGRADE = Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(Mores.MOD_ID,"hardened_steel_upgrade"))).formatted(TITLE_FORMAT);
    private static final Text HARDENED_STEEL_UPGRADE_APPLIES_TO = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.hardened_steel_upgrade.applies_to"))).formatted(DESCRIPTION_FORMAT);
    private static final Text HARDENED_STEEL_UPGRADE_INGREDIENTS = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.hardened_steel_upgrade.ingredients"))).formatted(DESCRIPTION_FORMAT);
    private static final Text HARDENED_STEEL_UPGRADE_BASE_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.hardened_steel_upgrade.base_slot_description")));
    private static final Text HARDENED_STEEL_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", Identifier.of(Mores.MOD_ID,"smithing_template.hardened_steel_upgrade.additions_slot_description")));

    private static final Identifier EMPTY_SLOT_HELMET = Identifier.of("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_SLOT_CHESTPLATE = Identifier.of("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_SLOT_LEGGINGS = Identifier.of("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_SLOT_BOOTS = Identifier.of("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_HOE = Identifier.of("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE = Identifier.of("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD = Identifier.of("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL = Identifier.of("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE = Identifier.of("item/empty_slot_pickaxe");
    private static final Identifier EMPTY_SLOT_INGOT = Identifier.of("item/empty_slot_ingot");
    private static final Identifier EMPTY_SLOT_REDSTONE_DUST = Identifier.of("item/empty_slot_redstone_dust");
    private static final Identifier EMPTY_SLOT_QUARTZ = Identifier.of("item/empty_slot_quartz");
    private static final Identifier EMPTY_SLOT_EMERALD = Identifier.of("item/empty_slot_emerald");
    private static final Identifier EMPTY_SLOT_DIAMOND = Identifier.of("item/empty_slot_diamond");
    private static final Identifier EMPTY_SLOT_LAPIS_LAZULI = Identifier.of("item/empty_slot_lapis_lazuli");
    private static final Identifier EMPTY_SLOT_AMETHYST_SHARD = Identifier.of("item/empty_slot_amethyst_shard");
    private static final Identifier EMPTY_SLOT_BATTLEAXE = Identifier.of(Mores.MOD_ID, "item/empty_battleaxe");
    private static final Identifier EMPTY_SLOT_MACE = Identifier.of(Mores.MOD_ID,"item/empty_mace");
    private static final Identifier EMPTY_SLOT_DAGGER = Identifier.of(Mores.MOD_ID,"item/empty_dagger");
    private static final Identifier EMPTY_SLOT_COAL = Identifier.of(Mores.MOD_ID, "item/empty_slot_coal");

    public ModSmithingTemplateItem(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
    }

    private static List<Identifier> getArmorTrimEmptyBaseSlotTextures() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }

    private static List<Identifier> getArmorTrimEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT, EMPTY_SLOT_REDSTONE_DUST, EMPTY_SLOT_LAPIS_LAZULI, EMPTY_SLOT_QUARTZ, EMPTY_SLOT_DIAMOND, EMPTY_SLOT_EMERALD, EMPTY_SLOT_AMETHYST_SHARD);
    }

    private static List<Identifier> getUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_SLOT_MACE, EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_BATTLEAXE, EMPTY_SLOT_SHOVEL, EMPTY_SLOT_DAGGER);
    }

    private static List<Identifier> createIngotIconList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
    private static List<Identifier> createCoalIconList() {
        return List.of(EMPTY_SLOT_COAL);
    }
    private static List<Identifier> createGemIconList() {
        return List.of(EMPTY_SLOT_DIAMOND);
    }

    public static SmithingTemplateItem createObsidianUpgradeTemplate() {
        return new SmithingTemplateItem(OBSIDIAN_UPGRADE_APPLIES_TO, OBSIDIAN_UPGRADE_INGREDIENTS, OBSIDIAN_UPGRADE, OBSIDIAN_UPGRADE_BASE_SLOT_DESCRIPTION, OBSIDIAN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, getUpgradeEmptyBaseSlotTextures(), createIngotIconList());
    }
    public static SmithingTemplateItem createHardenedSteelUpgradeTemplate() {
        return new SmithingTemplateItem(HARDENED_STEEL_UPGRADE_APPLIES_TO, HARDENED_STEEL_UPGRADE_INGREDIENTS, HARDENED_STEEL_UPGRADE, HARDENED_STEEL_UPGRADE_BASE_SLOT_DESCRIPTION, HARDENED_STEEL_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, getUpgradeEmptyBaseSlotTextures(), createIngotIconList());
    }

}
