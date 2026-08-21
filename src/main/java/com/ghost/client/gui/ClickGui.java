package com.ghost.client.gui;

import com.ghost.client.GhostClient;
import com.ghost.client.module.Category;
import com.ghost.client.module.Module;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import java.util.List;

public class ClickGui extends Screen {
    private int selectedCategory = 0;
    private final Category[] categories = Category.values();

    public ClickGui() {
        super(Text.literal("Ghost Client"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);

        int width = this.width;
        int height = this.height;

        // Background panel
        context.fill(width / 2 - 160, height / 2 - 140, width / 2 + 160, height / 2 + 140, 0xCC111111);

        // Title
        context.drawCenteredTextWithShadow(this.textRenderer, "Ghost Client", width / 2, height / 2 - 130, 0xFFFFFF);

        // Categories
        int catX = width / 2 - 150;
        for (int i = 0; i < categories.length; i++) {
            int color = (i == selectedCategory) ? 0xFF55FF55 : 0xFFAAAAAA;
            context.drawTextWithShadow(this.textRenderer, categories[i].name, catX + i * 60, height / 2 - 110, color);
        }

        // Modules of selected category
        List<Module> mods = GhostClient.moduleManager.getModulesByCategory(categories[selectedCategory]);
        int y = height / 2 - 80;
        for (Module m : mods) {
            int color = m.enabled ? 0xFF55FF55 : 0xFFFFFFFF;
            context.drawTextWithShadow(this.textRenderer, m.name + (m.enabled ? " [ON]" : " [OFF]"), width / 2 - 140, y, color);
            y += 14;
        }

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int width = this.width;
        int height = this.height;

        // Category click
        int catX = width / 2 - 150;
        for (int i = 0; i < categories.length; i++) {
            if (mouseX >= catX + i * 60 && mouseX <= catX + i * 60 + 50 &&
                mouseY >= height / 2 - 110 && mouseY <= height / 2 - 100) {
                selectedCategory = i;
                return true;
            }
        }

        // Module click
        List<Module> mods = GhostClient.moduleManager.getModulesByCategory(categories[selectedCategory]);
        int y = height / 2 - 80;
        for (Module m : mods) {
            if (mouseX >= width / 2 - 140 && mouseX <= width / 2 + 140 &&
                mouseY >= y && mouseY <= y + 12) {
                m.toggle();
                return true;
            }
            y += 14;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
