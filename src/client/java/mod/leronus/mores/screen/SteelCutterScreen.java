package mod.leronus.mores.screen;

import mod.leronus.mores.block.screen.SteelCutterScreenHandler;
import mod.leronus.mores.recipe.SteelCuttingRecipe;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.List;

@Environment(EnvType.CLIENT)
public class SteelCutterScreen extends HandledScreen<SteelCutterScreenHandler> {

    // GUI sprites: assets/mores/textures/gui/sprites/container/steel_cutter/*.png
    private static final Identifier SCROLLER_TEXTURE = Identifier.of("mores", "container/steel_cutter/scroller");
    private static final Identifier SCROLLER_DISABLED_TEXTURE = Identifier.of("mores", "container/steel_cutter/scroller_disabled");
    private static final Identifier RECIPE_SELECTED_TEXTURE = Identifier.of("mores", "container/steel_cutter/recipe_selected");
    private static final Identifier RECIPE_HIGHLIGHTED_TEXTURE = Identifier.of("mores", "container/steel_cutter/recipe_highlighted");
    private static final Identifier RECIPE_TEXTURE = Identifier.of("mores", "container/steel_cutter/recipe");

    // Background: assets/mores/textures/gui/steel_cutter.png
    private static final Identifier TEXTURE = Identifier.of("mores", "textures/gui/steel_cutter.png");

    private static final int SCROLLBAR_WIDTH = 12;
    private static final int SCROLLBAR_HEIGHT = 15;

    private static final int RECIPE_LIST_COLUMNS = 4;
    private static final int RECIPE_LIST_ROWS = 3;

    private static final int RECIPE_ENTRY_WIDTH = 16;
    private static final int RECIPE_ENTRY_HEIGHT = 18;

    private static final int SCROLLBAR_AREA_HEIGHT = 54;

    private static final int RECIPE_LIST_OFFSET_X = 52;
    private static final int RECIPE_LIST_OFFSET_Y = 14;

    private float scrollAmount;
    private boolean mouseClicked;
    private int scrollOffset;
    private boolean canCraft;

    public SteelCutterScreen(SteelCutterScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);

        handler.setContentsChangedListener(this::onInventoryChange);
        --this.titleY;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = this.x;
        int j = this.y;

        // main panel
        context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);

        // scrollbar thumb
        int k = (int) (41.0F * this.scrollAmount);
        Identifier scroller = this.shouldScroll() ? SCROLLER_TEXTURE : SCROLLER_DISABLED_TEXTURE;
        context.drawGuiTexture(scroller, i + 119, j + 15 + k, SCROLLBAR_WIDTH, SCROLLBAR_HEIGHT);

        // recipe grid
        int gridX = this.x + RECIPE_LIST_OFFSET_X;
        int gridY = this.y + RECIPE_LIST_OFFSET_Y;
        int end = this.scrollOffset + (RECIPE_LIST_COLUMNS * RECIPE_LIST_ROWS);

        this.renderRecipeBackground(context, mouseX, mouseY, gridX, gridY, end);
        this.renderRecipeIcons(context, gridX, gridY, end);
    }

    @Override
    protected void drawMouseoverTooltip(DrawContext context, int mouseX, int mouseY) {
        super.drawMouseoverTooltip(context, mouseX, mouseY);

        if (!this.canCraft || this.client == null || this.client.world == null) return;

        int i = this.x + RECIPE_LIST_OFFSET_X;
        int j = this.y + RECIPE_LIST_OFFSET_Y;
        int end = this.scrollOffset + (RECIPE_LIST_COLUMNS * RECIPE_LIST_ROWS);

        List<RecipeEntry<SteelCuttingRecipe>> list = this.handler.getAvailableRecipes();

        for (int idx = this.scrollOffset; idx < end && idx < this.handler.getAvailableRecipeCount(); ++idx) {
            int rel = idx - this.scrollOffset;
            int x = i + (rel % RECIPE_LIST_COLUMNS) * RECIPE_ENTRY_WIDTH;
            int row = rel / RECIPE_LIST_COLUMNS;
            int y = j + row * RECIPE_ENTRY_HEIGHT + 2;

            if (mouseX >= x && mouseX < x + RECIPE_ENTRY_WIDTH && mouseY >= y && mouseY < y + RECIPE_ENTRY_HEIGHT) {
                ItemStack result = list.get(idx).value().getResult(this.client.world.getRegistryManager());
                context.drawItemTooltip(this.textRenderer, result, mouseX, mouseY);
                return;
            }
        }
    }

    private void renderRecipeBackground(DrawContext context, int mouseX, int mouseY, int x, int y, int end) {
        for (int idx = this.scrollOffset; idx < end && idx < this.handler.getAvailableRecipeCount(); ++idx) {
            int rel = idx - this.scrollOffset;
            int bx = x + (rel % RECIPE_LIST_COLUMNS) * RECIPE_ENTRY_WIDTH;
            int row = rel / RECIPE_LIST_COLUMNS;
            int by = y + row * RECIPE_ENTRY_HEIGHT + 2;

            Identifier tex;
            if (idx == this.handler.getSelectedRecipe()) {
                tex = RECIPE_SELECTED_TEXTURE;
            } else if (mouseX >= bx && mouseY >= by && mouseX < bx + RECIPE_ENTRY_WIDTH && mouseY < by + RECIPE_ENTRY_HEIGHT) {
                tex = RECIPE_HIGHLIGHTED_TEXTURE;
            } else {
                tex = RECIPE_TEXTURE;
            }

            context.drawGuiTexture(tex, bx, by - 1, RECIPE_ENTRY_WIDTH, RECIPE_ENTRY_HEIGHT);
        }
    }

    private void renderRecipeIcons(DrawContext context, int x, int y, int end) {
        if (this.client == null || this.client.world == null) return;

        var regs = this.client.world.getRegistryManager();
        List<RecipeEntry<SteelCuttingRecipe>> list = this.handler.getAvailableRecipes();

        for (int idx = this.scrollOffset; idx < end && idx < this.handler.getAvailableRecipeCount(); ++idx) {
            int rel = idx - this.scrollOffset;
            int ix = x + (rel % RECIPE_LIST_COLUMNS) * RECIPE_ENTRY_WIDTH;
            int row = rel / RECIPE_LIST_COLUMNS;
            int iy = y + row * RECIPE_ENTRY_HEIGHT + 2;

            ItemStack result = list.get(idx).value().getResult(regs);

            // ✅ correct for your mappings
            context.drawItem(result, ix, iy, 0);
        }
    }


    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mouseClicked = false;

        if (this.canCraft) {
            int i = this.x + RECIPE_LIST_OFFSET_X;
            int j = this.y + RECIPE_LIST_OFFSET_Y;
            int end = this.scrollOffset + (RECIPE_LIST_COLUMNS * RECIPE_LIST_ROWS);

            for (int idx = this.scrollOffset; idx < end; ++idx) {
                int rel = idx - this.scrollOffset;
                double dx = mouseX - (double) (i + (rel % RECIPE_LIST_COLUMNS) * RECIPE_ENTRY_WIDTH);
                double dy = mouseY - (double) (j + (rel / RECIPE_LIST_COLUMNS) * RECIPE_ENTRY_HEIGHT);

                if (dx >= 0.0 && dy >= 0.0 && dx < RECIPE_ENTRY_WIDTH && dy < RECIPE_ENTRY_HEIGHT
                        && this.handler.onButtonClick(this.client.player, idx)) {

                    MinecraftClient.getInstance().getSoundManager()
                            .play(PositionedSoundInstance.master(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    this.client.interactionManager.clickButton(this.handler.syncId, idx);
                    return true;
                }
            }

            int sx = this.x + 119;
            int sy = this.y + 9;
            if (mouseX >= sx && mouseX < sx + SCROLLBAR_WIDTH && mouseY >= sy && mouseY < sy + SCROLLBAR_AREA_HEIGHT) {
                this.mouseClicked = true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dx, double dy) {
        if (this.mouseClicked && this.shouldScroll()) {
            int top = this.y + 14;
            int bottom = top + SCROLLBAR_AREA_HEIGHT;

            this.scrollAmount = ((float) mouseY - (float) top - 7.5F)
                    / ((float) (bottom - top) - (float) SCROLLBAR_HEIGHT);
            this.scrollAmount = MathHelper.clamp(this.scrollAmount, 0.0F, 1.0F);

            this.scrollOffset = (int) ((double) (this.scrollAmount * (float) this.getMaxScroll()) + 0.5D) * RECIPE_LIST_COLUMNS;
            return true;
        }

        return super.mouseDragged(mouseX, mouseY, button, dx, dy);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (this.shouldScroll()) {
            int max = this.getMaxScroll();
            float step = (float) verticalAmount / (float) max;

            this.scrollAmount = MathHelper.clamp(this.scrollAmount - step, 0.0F, 1.0F);
            this.scrollOffset = (int) ((double) (this.scrollAmount * (float) max) + 0.5D) * RECIPE_LIST_COLUMNS;
        }
        return true;
    }

    private boolean shouldScroll() {
        return this.canCraft && this.handler.getAvailableRecipeCount() > (RECIPE_LIST_COLUMNS * RECIPE_LIST_ROWS);
    }

    protected int getMaxScroll() {
        return (this.handler.getAvailableRecipeCount() + RECIPE_LIST_COLUMNS - 1) / RECIPE_LIST_COLUMNS - RECIPE_LIST_ROWS;
    }

    private void onInventoryChange() {
        this.canCraft = this.handler.canCraft();
        if (!this.canCraft) {
            this.scrollAmount = 0.0F;
            this.scrollOffset = 0;
        }
    }
}
