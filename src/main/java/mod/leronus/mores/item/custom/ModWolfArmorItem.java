package mod.leronus.mores.item.custom;

import net.minecraft.item.AnimalArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class ModWolfArmorItem extends AnimalArmorItem {
    private final Identifier entityTexture;
    @Nullable private final Identifier overlayTexture;

    public ModWolfArmorItem(
            RegistryEntry<ArmorMaterial> material,
            boolean hasOverlay,
            Item.Settings settings,
            Identifier entityTexture,
            @Nullable Identifier overlayTexture
    ) {
        super(material, AnimalArmorItem.Type.CANINE, hasOverlay, settings.maxCount(1));
        this.entityTexture = entityTexture;
        this.overlayTexture = overlayTexture;
    }

    @Override
    public Identifier getEntityTexture() {
        return entityTexture;
    }

    @Override
    @Nullable
    public Identifier getOverlayTexture() {
        return overlayTexture;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
}
