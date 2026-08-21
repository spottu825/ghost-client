package com.ghost.client.module.modules.misc;

import com.ghost.client.GhostClient;
import com.ghost.client.module.Category;
import com.ghost.client.module.Module;

public class Panic extends Module {
    public Panic() {
        super("Panic", "Disables all modules", Category.MISC);
    }

    @Override
    public void onEnable() {
        for (Module m : GhostClient.moduleManager.modules) {
            if (m != this && m.enabled) {
                m.setEnabled(false);
            }
        }
        this.setEnabled(false);
    }
}
