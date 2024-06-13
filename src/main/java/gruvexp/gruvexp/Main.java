package gruvexp.gruvexp;

import gruvexp.gruvexp.commands.TestCommand;
import gruvexp.gruvexp.listeners.FloorListener;
import gruvexp.gruvexp.listeners.MenuListener;
import gruvexp.gruvexp.commands.MenuCommand;
import gruvexp.gruvexp.commands.StartCommand;
import gruvexp.gruvexp.handlers.TNTHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    public static int activeBattle = 0;
    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getLogger().info("Sumo plugin enabled! Version 2024.05.06");
        new TNTHandler(this);

        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("start").setExecutor(new StartCommand());
        getCommand("test").setExecutor(new TestCommand());
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new FloorListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Sumo plugin disabled!");
    }

    public static Main getPlugin() {
        return instance;
    }
}
