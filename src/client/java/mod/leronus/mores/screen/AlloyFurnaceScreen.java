package mod.leronus.mores.screen;

import mod.leronus.mores.block.screen.AlloyFurnaceScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AlloyFurnaceScreen extends HandledScreen<AlloyFurnaceScreenHandler> {

    private static final Identifier BG =
            Identifier.of("mores", "textures/gui/alloy_furnace.png");

    private static final Identifier BURN_SOUL =
            Identifier.of("mores", "textures/gui/sprites/container/alloy_furnace/soul_burn.png");
    private static final Identifier BURN_RED =
            Identifier.of("mores", "textures/gui/sprites/container/alloy_furnace/red_burn.png");
    private static final Identifier BURN_PURPLE =
            Identifier.of("mores", "textures/gui/sprites/container/alloy_furnace/purple_burn.png");
    private static final Identifier BURN_BLUE =
            Identifier.of("mores", "textures/gui/sprites/container/alloy_furnace/blue_burn.png");

    private static final Identifier ARROW_SOUL =
            Identifier.of("mores", "textures/gui/sprites/container/alloy_furnace/soul_arrow.png");
    private static final Identifier ARROW_RED =
            Identifier.of("mores", "textures/gui/sprites/container/alloy_furnace/red_arrow.png");
    private static final Identifier ARROW_PURPLE =
            Identifier.of("mores", "textures/gui/sprites/container/alloy_furnace/purple_arrow.png");
    private static final Identifier ARROW_BLUE =
            Identifier.of("mores", "textures/gui/sprites/container/alloy_furnace/blue_arrow.png");

    public AlloyFurnaceScreen(AlloyFurnaceScreenHandler handler,
                              PlayerInventory inventory,
                              Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    // ---------------- THEME (SERVER-SYNCED) ----------------

    private Theme currentTheme() {
        // themeId is synced from server via PropertyDelegate (index 4)
        return Theme.fromId(handler.getThemeId());
    }

    // ---------------- DRAW ----------------

    @Override
    protected void drawBackground(DrawContext ctx, float delta, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        // Background
        ctx.drawTexture(BG, x, y, 0, 0, backgroundWidth, backgroundHeight);

        Theme theme = currentTheme();

        // Flame (animated height, like vanilla: 0..13)
        if (handler.isBurning()) {
            int flame = handler.getFuelProgress(); // 0..13
            if (flame > 0) {
                // draw only bottom "flame" pixels so it shrinks as fuel runs out
                ctx.drawTexture(
                        theme.burnTexture,
                        x + 56, y + 36 + (13 - flame),
                        0, 13 - flame,
                        14, flame + 1,
                        14, 14
                );
            }
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

        static Theme fromId(int id) {
            return switch (id) {
                case 1 -> RED;
                case 2 -> PURPLE;
                case 3 -> BLUE;
                default -> SOUL;
            };
        }
    }
}
