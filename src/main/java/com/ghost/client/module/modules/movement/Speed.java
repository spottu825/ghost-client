package com.ghost.client.module.modules.movement;

import com.ghost.client.module.Category;
import com.ghost.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

public class Speed extends Module {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public Speed() {
        super("Speed", "Increases movement speed", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (mc.player == null || !mc.player.isOnGround()) return;

        if (mc.player.forwardSpeed > 0 || mc.player.sidewaysSpeed != 0) {
            double multiplier = 1.35;
            Vec3d vel = mc.player.getVelocity();
            mc.player.setVelocity(vel.x * multiplier, vel.y, vel.z * multiplier);
        }
    }
}
