package com.mcstaralliance.nohungerreloaded;

import com.mcstaralliance.nohungerreloaded.command.NoHungerCommand;
import com.mcstaralliance.nohungerreloaded.listener.BlockBreakListener;
import com.mcstaralliance.nohungerreloaded.listener.FoodLevelChangeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoHungerReloaded extends JavaPlugin {
    private static NoHungerReloaded instance;

    public static NoHungerReloaded getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new FoodLevelChangeListener(), this);
        Bukkit.getPluginCommand("nohunger").setExecutor(new NoHungerCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
