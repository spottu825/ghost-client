package com.ghost.client.module.modules.movement;

import com.ghost.client.module.Category;
import com.ghost.client.module.Module;
import net.minecraft.client.MinecraftClient;

public class Sprint extends Module {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public Sprint() {
        super("Sprint", "Always sprint", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (mc.player != null && mc.player.forwardSpeed > 0) {
            mc.player.setSprinting(true);
        }
    }
}
