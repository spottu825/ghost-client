package com.ghost.client.module.modules.render;

import com.ghost.client.module.Category;
import com.ghost.client.module.Module;
import net.minecraft.client.MinecraftClient;

public class Fullbright extends Module {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private double oldGamma = 1.0;

    public Fullbright() {
        super("Fullbright", "Maximum brightness", Category.RENDER);
    }

    @Override
    public void onEnable() {
        if (mc.options != null) {
            oldGamma = mc.options.getGamma().getValue();
            mc.options.getGamma().setValue(16.0);
        }
    }

    @Override
    public void onDisable() {
        if (mc.options != null) {
            mc.options.getGamma().setValue(oldGamma);
        }
    }
}
