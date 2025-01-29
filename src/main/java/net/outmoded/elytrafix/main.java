package net.outmoded.elytrafix;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new ElytraListener(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ElytraFix] Loaded | Version 1.0 | Made by DRAGNIL68");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
