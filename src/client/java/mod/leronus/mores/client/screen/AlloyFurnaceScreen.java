package mod.leronus.mores.client.screen;

import mod.leronus.mores.block.screen.AlloyFurnaceScreenHandler;
import mod.leronus.mores.recipe.AlloyRecipeInput;
import mod.leronus.mores.recipe.ModRecipeTypes;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AlloyFurnaceScreen extends HandledScreen<AlloyFurnaceScreenHandler> {

    private static final Identifier BG =
            Identifier.of("mores", "textures/gui/alloy_furnace.png");

    private static final Identifier BURN_SOUL =
            Identifier.of("mores", "textures/gui/theme/soul_burn.png");
    private static final Identifier BURN_RED =
            Identifier.of("mores", "textures/gui/theme/red_burn.png");
    private static final Identifier BURN_PURPLE =
            Identifier.of("mores", "textures/gui/theme/purple_burn.png");
    private static final Identifier BURN_BLUE =
            Identifier.of("mores", "textures/gui/theme/blue_burn.png");

    private static final Identifier ARROW_SOUL =
            Identifier.of("mores", "textures/gui/theme/soul_arrow.png");
    private static final Identifier ARROW_RED =
            Identifier.of("mores", "textures/gui/theme/red_arrow.png");
    private static final Identifier ARROW_PURPLE =
            Identifier.of("mores", "textures/gui/theme/purple_arrow.png");
    private static final Identifier ARROW_BLUE =
            Identifier.of("mores", "textures/gui/theme/blue_arrow.png");

    public AlloyFurnaceScreen(AlloyFurnaceScreenHandler handler,
                              PlayerInventory inventory,
                              Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    // ---------------- THEME ----------------

    private Theme currentTheme() {
        if (client == null || client.world == null) return Theme.SOUL;

        ItemStack a = handler.getSlot(0).getStack();
        ItemStack b = handler.getSlot(1).getStack();
        if (a.isEmpty() || b.isEmpty()) return Theme.SOUL;

        var input = new AlloyRecipeInput(a, b);
        var match = client.world.getRecipeManager()
                .getFirstMatch(ModRecipeTypes.ALLOYING, input, client.world);

        return match
                .map(e -> Theme.fromId(e.value().getTheme()))
                .orElse(Theme.SOUL);
    }

    // ---------------- DRAW ----------------

    @Override
    protected void drawBackground(DrawContext ctx, float delta, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        // Background
        ctx.drawTexture(BG, x, y, 0, 0, backgroundWidth, backgroundHeight);

        Theme theme = currentTheme();

        // Flame (static overlay)
        if (handler.isBurning()) {
            ctx.drawTexture(
                    theme.burnTexture,
                    x + 56, y + 36,
                    0, 0,
                    14, 14,
                    14, 14
            );
        }

        // Arrow (progress-scaled width)
        int progress = handler.getCookProgress(); // 0..24
        if (progress > 0) {
            ctx.drawTexture(
                    theme.arrowTexture,
                    x + 79, y + 34,
                    0, 0,
                    progress, 16,
                    24, 16
            );
        }
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        this.renderBackground(ctx, mouseX, mouseY, delta);
        super.render(ctx, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(ctx, mouseX, mouseY);
    }

    // ---------------- THEME ENUM ----------------

    private enum Theme {
        SOUL(BURN_SOUL, ARROW_SOUL),
        RED(BURN_RED, ARROW_RED),
        PURPLE(BURN_PURPLE, ARROW_PURPLE),
        BLUE(BURN_BLUE, ARROW_BLUE);

        final Identifier burnTexture;
        final Identifier arrowTexture;

        Theme(Identifier burnTexture, Identifier arrowTexture) {
            this.burnTexture = burnTexture;
            this.arrowTexture = arrowTexture;
        }

        static Theme fromId(String id) {
            return switch (id) {
                case "red" -> RED;
                case "purple" -> PURPLE;
                case "blue" -> BLUE;
                default -> SOUL;
            };
        }
    }
}
