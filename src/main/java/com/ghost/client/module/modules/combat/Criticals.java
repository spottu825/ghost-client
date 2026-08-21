package com.ghost.client.module.modules.combat;

import com.ghost.client.module.Category;
import com.ghost.client.module.Module;
import net.minecraft.client.MinecraftClient;

public class Criticals extends Module {
    public Criticals() {
        super("Criticals", "Forces critical hits", Category.COMBAT);
    }

    // Basic placeholder - real criticals usually need packet manipulation
    @Override
    public void onTick() {
        // Placeholder for future packet-based criticals
    }
}
