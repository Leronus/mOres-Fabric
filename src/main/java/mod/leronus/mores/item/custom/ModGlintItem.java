package mod.leronus.mores.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModGlintItem extends Item {
    public ModGlintItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
