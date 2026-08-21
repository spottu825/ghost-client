package com.ghost.client.module.modules.combat;

import com.ghost.client.module.Category;
import com.ghost.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;

public class KillAura extends Module {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private long lastAttack = 0;

    public KillAura() {
        super("KillAura", "Attacks nearby entities", Category.COMBAT);
    }

    @Override
    public void onTick() {
        if (mc.player == null || mc.world == null || mc.interactionManager == null) return;
        if (System.currentTimeMillis() - lastAttack < 500) return;

        for (Entity entity : mc.world.getEntities()) {
            if (entity instanceof LivingEntity living && living.isAlive() && living != mc.player) {
                if (mc.player.distanceTo(living) <= 4.5f) {
                    mc.interactionManager.attackEntity(mc.player, living);
                    mc.player.swingHand(Hand.MAIN_HAND);
                    lastAttack = System.currentTimeMillis();
                    break;
                }
            }
        }
    }
}
