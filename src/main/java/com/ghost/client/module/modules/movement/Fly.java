package com.ghost.client.module.modules.movement;

import com.ghost.client.module.Category;
import com.ghost.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

public class Fly extends Module {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public Fly() {
        super("Fly", "Allows flying", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (mc.player == null) return;

        mc.player.getAbilities().flying = true;
        mc.player.getAbilities().allowFlying = true;

        double speed = 0.65;
        Vec3d velocity = mc.player.getVelocity();
        double y = 0;

        if (mc.options.jumpKey.isPressed()) y = speed;
        if (mc.options.sneakKey.isPressed()) y = -speed;

        mc.player.setVelocity(velocity.x, y, velocity.z);
    }

    @Override
    public void onDisable() {
        if (mc.player != null) {
            mc.player.getAbilities().flying = false;
            if (!mc.player.isCreative() && !mc.player.isSpectator()) {
                mc.player.getAbilities().allowFlying = false;
            }
        }
    }
}
