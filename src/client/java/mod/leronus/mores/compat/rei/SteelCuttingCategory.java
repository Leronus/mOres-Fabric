package mod.leronus.mores.compat.rei;

import java.util.ArrayList;
import java.util.List;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;

import mod.leronus.mores.block.ModBlocks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SteelCuttingCategory implements DisplayCategory<SteelCuttingDisplay> {

    public static final CategoryIdentifier<SteelCuttingDisplay> ID =
            CategoryIdentifier.of(Identifier.of("mores", "steel_cutting"));

    @Override
    public CategoryIdentifier<? extends SteelCuttingDisplay> getCategoryIdentifier() {
        return ID;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("category.mores.steel_cutting");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.STEEL_CUTTER); // adjust to your actual block id
    }

    @Override
    public List<Widget> setupDisplay(SteelCuttingDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createRecipeBase(bounds));

        // Layout (simple and clean)
        int centerX = bounds.getCenterX();
        int centerY = bounds.getCenterY();

        // input slot (left)
        widgets.add(
                Widgets.createSlot(new Point(centerX - 45, centerY - 9))
                        .entries(display.getInputEntries().get(0))
                        .markInput()
        );

        // arrow (middle)
        widgets.add(Widgets.createArrow(new Point(centerX - 12, centerY - 8)));

        // output slot (right)
        widgets.add(
                Widgets.createSlot(new Point(centerX + 25, centerY - 9))
                        .entries(display.getOutputEntries().get(0))
                        .markOutput()
        );

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 56;
    }
}
