package com.ghost.client.module.modules.movement;

import com.ghost.client.module.Category;
import com.ghost.client.module.Module;
import net.minecraft.client.MinecraftClient;

public class NoFall extends Module {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public NoFall() {
        super("NoFall", "Prevents fall damage", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (mc.player != null && mc.player.fallDistance > 2.5f) {
            mc.player.fallDistance = 0;
        }
    }
}
