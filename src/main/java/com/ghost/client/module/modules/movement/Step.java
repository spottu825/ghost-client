package com.ghost.client.module.modules.movement;

import com.ghost.client.module.Category;
import com.ghost.client.module.Module;
import net.minecraft.client.MinecraftClient;

public class Step extends Module {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public Step() {
        super("Step", "Step up blocks", Category.MOVEMENT);
    }

    @Override
    public void onEnable() {
        if (mc.player != null) {
            mc.player.setStepHeight(1.0f);
        }
    }

    @Override
    public void onDisable() {
        if (mc.player != null) {
            mc.player.setStepHeight(0.6f);
        }
    }
}
