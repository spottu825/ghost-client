package com.ghost.client.module.modules.combat;

import com.ghost.client.module.Category;
import com.ghost.client.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;

public class TriggerBot extends Module {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private long lastAttack = 0;

    public TriggerBot() {
        super("TriggerBot", "Attacks when crosshair is on entity", Category.COMBAT);
    }

    @Override
    public void onTick() {
        if (mc.player == null || mc.world == null || mc.interactionManager == null) return;
        if (System.currentTimeMillis() - lastAttack < 450) return;

        if (mc.crosshairTarget != null && mc.crosshairTarget.getType() == HitResult.Type.ENTITY) {
            EntityHitResult hit = (EntityHitResult) mc.crosshairTarget;
            Entity target = hit.getEntity();
            if (target instanceof LivingEntity living && living.isAlive()) {
                mc.interactionManager.attackEntity(mc.player, living);
                mc.player.swingHand(Hand.MAIN_HAND);
                lastAttack = System.currentTimeMillis();
            }
        }
    }
}
