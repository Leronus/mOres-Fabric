package mod.leronus.mores.compat.rei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;

import mod.leronus.mores.Mores;
import mod.leronus.mores.block.ModBlocks;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Element;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AlloyingCategory implements DisplayCategory<AlloyingDisplay> {

    public static final CategoryIdentifier<AlloyingDisplay> ID =
            CategoryIdentifier.of(Mores.MOD_ID, "alloying");

    // Your new REI-friendly texture (top-left contains the full framed panel)
    private static final Identifier BG =
            Identifier.of(Mores.MOD_ID, "textures/gui/alloy_furnace_rei.png");

    // Theme overlays
    private static final Identifier BURN_SOUL   = Identifier.of(Mores.MOD_ID, "textures/gui/sprites/container/alloy_furnace/soul_burn.png");
    private static final Identifier BURN_RED    = Identifier.of(Mores.MOD_ID, "textures/gui/sprites/container/alloy_furnace/red_burn.png");
    private static final Identifier BURN_PURPLE = Identifier.of(Mores.MOD_ID, "textures/gui/sprites/container/alloy_furnace/purple_burn.png");
    private static final Identifier BURN_BLUE   = Identifier.of(Mores.MOD_ID, "textures/gui/sprites/container/alloy_furnace/blue_burn.png");

    private static final Identifier ARROW_SOUL   = Identifier.of(Mores.MOD_ID, "textures/gui/sprites/container/alloy_furnace/soul_arrow.png");
    private static final Identifier ARROW_RED    = Identifier.of(Mores.MOD_ID, "textures/gui/sprites/container/alloy_furnace/red_arrow.png");
    private static final Identifier ARROW_PURPLE = Identifier.of(Mores.MOD_ID, "textures/gui/sprites/container/alloy_furnace/purple_arrow.png");
    private static final Identifier ARROW_BLUE   = Identifier.of(Mores.MOD_ID, "textures/gui/sprites/container/alloy_furnace/blue_arrow.png");

    // Panel size (slot coords assume vanilla 176px wide top section)
    private static final int BG_W = 176;
    private static final int BG_H = 83;

    /**
     * Move the whole panel UP to reduce the gap under the category header.
     * If this overlaps for you, tweak between -10..0.
     */
    private static final int Y_OFFSET = 0;

    // Slot coords (from your handler/screen)
    private static final int SLOT_IN_A_X = 45;
    private static final int SLOT_IN_A_Y = 17;

    private static final int SLOT_IN_B_X = 67;
    private static final int SLOT_IN_B_Y = 17;

    private static final int SLOT_FUEL_X = 56;
    private static final int SLOT_FUEL_Y = 53;

    private static final int SLOT_OUT_X = 116;
    private static final int SLOT_OUT_Y = 35;

    private static final int FLAME_X = 56;
    private static final int FLAME_Y = 36;

    private static final int ARROW_X = 79;
    private static final int ARROW_Y = 34;

    private static List<EntryStack<?>> CACHED_FUELS;

    @Override
    public CategoryIdentifier<? extends AlloyingDisplay> getCategoryIdentifier() {
        return ID;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("category.mores.alloying");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.ALLOY_FURNACE);
    }

    @Override
    public List<Widget> setupDisplay(AlloyingDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();

        int x = bounds.getX() + (bounds.getWidth() - BG_W) / 2;
        int y = bounds.getY() + Y_OFFSET;

        // Background (top-left 176x83 from 256x256 texture)
        widgets.add(Widgets.createTexturedWidget(BG, x, y, 0, 0, BG_W, BG_H, 256, 256));

        // Slots
        widgets.add(Widgets.createSlot(new Point(x + SLOT_IN_A_X, y + SLOT_IN_A_Y))
                .entries(display.getInputEntries().get(0))
                .markInput());

        widgets.add(Widgets.createSlot(new Point(x + SLOT_IN_B_X, y + SLOT_IN_B_Y))
                .entries(display.getInputEntries().get(1))
                .markInput());

        widgets.add(Widgets.createSlot(new Point(x + SLOT_FUEL_X, y + SLOT_FUEL_Y))
                .entries(getAllFuelEntries())
                .markInput());

        widgets.add(Widgets.createSlot(new Point(x + SLOT_OUT_X, y + SLOT_OUT_Y))
                .entries(display.getOutputEntries().get(0))
                .markOutput()
                .disableBackground());

        // Animated overlays
        Rectangle flameRect = new Rectangle(x + FLAME_X, y + FLAME_Y, 14, 14);
        Rectangle arrowRect = new Rectangle(x + ARROW_X, y + ARROW_Y, 24, 16);

        widgets.add(new ExtinguishingFlameWidget(flameRect, burnFor(display.getTheme()), display.getCookTime()));
        widgets.add(new AnimatedArrowWidget(arrowRect, arrowFor(display.getTheme()), display.getCookTime()));

        // XP/time text like vanilla REI smelting: top-right INSIDE the panel.
        widgets.add(Widgets.createDrawableWidget((ctx, mouseX, mouseY, delta) -> {
            TextRenderer tr = MinecraftClient.getInstance().textRenderer;
            String s = display.getExperience() + " XP in " + ticksToSeconds(display.getCookTime()) + " sec";

            // Position to match vanilla feel (top-right, a little inset)
            int textX = x + BG_W - 6 - tr.getWidth(s);
            int textY = y + 6;

            ctx.drawText(tr, s, textX, textY, 0x404040, false);
        }));

        // Tooltips (hover)
        widgets.add(Widgets.createTooltip(
                () -> new Rectangle(x + SLOT_FUEL_X, y + SLOT_FUEL_Y, 16, 16),
                Text.translatable("rei.mores.any_fuel")
        ));

        // If you want hover tooltip for arrow too (optional; smelting doesn't require it)
        widgets.add(Widgets.createTooltip(
                () -> arrowRect,
                Text.literal(display.getExperience() + " xp"),
                Text.literal(ticksToSeconds(display.getCookTime()) + " sec")
        ));

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        // Don't shrink this when Y_OFFSET is negative; REI can clip.
        // BG_H is enough because we're just moving content upward into the existing space.
        return BG_H;
    }

    @Override
    public int getDisplayWidth(AlloyingDisplay display) {
        return BG_W;
    }

    // ---------------- animation widgets ----------------

    /**
     * Furnace-style extinguish:
     * starts full, then turns off from TOP -> BOTTOM (cropping away the top over time).
     */
    private static class ExtinguishingFlameWidget extends Widget {
        private final Rectangle bounds;
        private final Identifier texture;
        private final int cookTimeTicks;

        ExtinguishingFlameWidget(Rectangle bounds, Identifier texture, int cookTimeTicks) {
            this.bounds = bounds;
            this.texture = texture;
            this.cookTimeTicks = Math.max(1, cookTimeTicks);
        }

        @Override
        public List<? extends Element> children() {
            return Collections.emptyList();
        }

        @Override
        public boolean containsMouse(double mouseX, double mouseY) {
            return bounds.contains(mouseX, mouseY);
        }

        @Override
        public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
            long tick = System.currentTimeMillis() / 50L;
            int t = (int) (tick % cookTimeTicks);

            int off = (int) Math.floor((t / (double) cookTimeTicks) * 14.0);
            if (off < 0) off = 0;
            if (off > 13) off = 13;

            int visibleH = 14 - off;
            if (visibleH <= 0) return;

            ctx.drawTexture(
                    texture,
                    bounds.x,
                    bounds.y + off,
                    0,
                    off,
                    14,
                    visibleH,
                    14,
                    14
            );
        }
    }

    private static class AnimatedArrowWidget extends Widget {
        private final Rectangle bounds;
        private final Identifier texture;
        private final int cookTimeTicks;

        AnimatedArrowWidget(Rectangle bounds, Identifier texture, int cookTimeTicks) {
            this.bounds = bounds;
            this.texture = texture;
            this.cookTimeTicks = Math.max(1, cookTimeTicks);
        }

        @Override
        public List<? extends Element> children() {
            return Collections.emptyList();
        }

        @Override
        public boolean containsMouse(double mouseX, double mouseY) {
            return bounds.contains(mouseX, mouseY);
        }

        @Override
        public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
            long tick = System.currentTimeMillis() / 50L;

            int t = (int) (tick % cookTimeTicks);
            int progress = (int) Math.floor((t / (double) cookTimeTicks) * 24.0);
            if (progress <= 0) return;

            ctx.drawTexture(
                    texture,
                    bounds.x,
                    bounds.y,
                    0,
                    0,
                    progress,
                    16,
                    24,
                    16
            );
        }
    }

    // ---------------- helpers ----------------

    private static List<EntryStack<?>> getAllFuelEntries() {
        if (CACHED_FUELS != null) return CACHED_FUELS;

        List<EntryStack<?>> fuels = new ArrayList<>();
        FuelRegistry registry = FuelRegistry.INSTANCE;

        for (Item item : Registries.ITEM) {
            Integer time = registry.get(item);
            if (time != null && time > 0) fuels.add(EntryStacks.of(item));
        }

        if (fuels.isEmpty()) fuels.add(EntryStacks.of(net.minecraft.item.Items.COAL));

        CACHED_FUELS = fuels;
        return CACHED_FUELS;
    }

    private static String ticksToSeconds(int ticks) {
        double sec = ticks / 20.0;
        if (sec == (int) sec) return Integer.toString((int) sec);
        return String.format("%.1f", sec);
    }

    private static Identifier arrowFor(String theme) {
        if (theme == null) return ARROW_SOUL;
        return switch (theme) {
            case "red" -> ARROW_RED;
            case "purple" -> ARROW_PURPLE;
            case "blue" -> ARROW_BLUE;
            default -> ARROW_SOUL;
        };
    }

    private static Identifier burnFor(String theme) {
        if (theme == null) return BURN_SOUL;
        return switch (theme) {
            case "red" -> BURN_RED;
            case "purple" -> BURN_PURPLE;
            case "blue" -> BURN_BLUE;
            default -> BURN_SOUL;
        };
    }
}
