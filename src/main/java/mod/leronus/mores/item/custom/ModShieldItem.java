package mod.leronus.mores.item.custom;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;

import java.util.Collection;

public class ModShieldItem extends FabricShieldItem {

    public ModShieldItem(Item.Settings settings, int coolDownTicks, int enchantability, Item... repairItems) {
        super(settings, coolDownTicks, enchantability, repairItems);
    }

    public ModShieldItem(Item.Settings settings, int coolDownTicks, int enchantability, TagKey<Item> repairItemTag) {
        super(settings, coolDownTicks, enchantability, repairItemTag);
    }

    public ModShieldItem(Item.Settings settings, int coolDownTicks, int enchantability, Collection<TagKey<Item>> repairItemTags) {
        super(settings, coolDownTicks, enchantability, repairItemTags);
    }

    @Override
    public boolean supportsBanner() {
        return true;
    }

    @Override
    public Text getName(ItemStack stack) {
        DyeColor base = stack.get(DataComponentTypes.BASE_COLOR);
        if (base == null) return super.getName(stack);

        Text colorText = Text.translatable("color.minecraft." + base.getName());
        return Text.translatable("%s %s", colorText, super.getName(stack));
    }
}
