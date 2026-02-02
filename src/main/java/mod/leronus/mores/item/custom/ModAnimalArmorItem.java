package mod.leronus.mores.item.custom;

import net.minecraft.item.AnimalArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.item.ArmorMaterial;

/**
 * Vanilla AnimalArmorItem forces isEnchantable() = false.
 * This subclass re-enables enchanting (table + books + anvil),
 * while keeping all vanilla AnimalArmorItem behavior (textures, break sounds, type).
 */
public class ModAnimalArmorItem extends AnimalArmorItem {
    public ModAnimalArmorItem(RegistryEntry<ArmorMaterial> material,
                                      Type type,
                                      boolean hasOverlay,
                                      Item.Settings settings) {
        super(material, type, hasOverlay, settings);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
}
