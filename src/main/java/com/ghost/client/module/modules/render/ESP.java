package com.ghost.client.module.modules.render;

import com.ghost.client.module.Category;
import com.ghost.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class ESP extends Module {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public ESP() {
        super("ESP", "Highlights players", Category.RENDER);
    }

    @Override
    public void onTick() {
        // Basic ESP usually needs rendering mixins / WorldRenderEvents
        // Placeholder - real ESP requires render hooks
    }
}
