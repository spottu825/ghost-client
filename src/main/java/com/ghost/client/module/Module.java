package com.ghost.client.module;

public abstract class Module {
    public final String name;
    public final String description;
    public final Category category;
    public boolean enabled = false;
    public int key = -1;

    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public void toggle() {
        setEnabled(!enabled);
    }

    public void setEnabled(boolean state) {
        this.enabled = state;
        if (enabled) onEnable();
        else onDisable();
    }

    public void onEnable() {}
    public void onDisable() {}
    public void onTick() {}
}
