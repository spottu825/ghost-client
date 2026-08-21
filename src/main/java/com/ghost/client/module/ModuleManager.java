package com.ghost.client.module;

import com.ghost.client.module.modules.combat.*;
import com.ghost.client.module.modules.movement.*;
import com.ghost.client.module.modules.render.*;
import com.ghost.client.module.modules.player.*;
import com.ghost.client.module.modules.misc.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public final List<Module> modules = new ArrayList<>();

    public void init() {
        // Combat
        modules.add(new KillAura());
        modules.add(new TriggerBot());
        modules.add(new Criticals());

        // Movement
        modules.add(new Fly());
        modules.add(new Speed());
        modules.add(new Sprint());
        modules.add(new NoFall());
        modules.add(new Step());

        // Render
        modules.add(new ESP());
        modules.add(new Fullbright());
        modules.add(new Tracers());

        // Player
        modules.add(new AutoArmor());

        // Misc
        modules.add(new Panic());
    }

    public void onTick() {
        for (Module m : modules) {
            if (m.enabled) m.onTick();
        }
    }

    public Module getModule(String name) {
        for (Module m : modules) {
            if (m.name.equalsIgnoreCase(name)) return m;
        }
        return null;
    }

    public List<Module> getModulesByCategory(Category category) {
        List<Module> list = new ArrayList<>();
        for (Module m : modules) {
            if (m.category == category) list.add(m);
        }
        return list;
    }
}
