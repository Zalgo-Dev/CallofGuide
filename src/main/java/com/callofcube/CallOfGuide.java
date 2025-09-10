package com.callofcube;

import org.bukkit.plugin.java.JavaPlugin;

public class CallOfGuide extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("guide").setExecutor(new GuideCommand());
        getCommand("help").setExecutor(new HelpCommand());
    saveDefaultConfig();
    }
}
