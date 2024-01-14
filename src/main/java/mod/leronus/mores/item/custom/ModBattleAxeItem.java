package mod.leronus.mores.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class ModBattleAxeItem extends SwordItem {
    public ModBattleAxeItem(ToolMaterial toolMaterial, int attackDamageModifier, float attackSpeedModifier, Item.Settings settings) {
        super(toolMaterial, attackDamageModifier, attackSpeedModifier, settings);
    }
}
