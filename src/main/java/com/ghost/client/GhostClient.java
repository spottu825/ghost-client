package com.ghost.client;

import com.ghost.client.gui.ClickGui;
import com.ghost.client.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class GhostClient implements ClientModInitializer {
    public static final String MOD_ID = "ghost-client";
    public static ModuleManager moduleManager;
    public static ClickGui clickGui;

    private static KeyBinding guiKey;

    @Override
    public void onInitializeClient() {
        moduleManager = new ModuleManager();
        moduleManager.init();
        clickGui = new ClickGui();

        guiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.ghost-client.gui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.ghost-client"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (guiKey.wasPressed()) {
                client.setScreen(clickGui);
            }
            moduleManager.onTick();
        });

        System.out.println("[Ghost Client] Loaded successfully!");
    }
}
