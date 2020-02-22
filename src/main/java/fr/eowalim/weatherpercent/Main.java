package fr.eowalim.weatherpercent;

import fr.eowalim.weatherpercent.commands.ChangePercentWeather;


import fr.eowalim.weatherpercent.listeners.WeatherPercentage;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public void onEnable(){
        instance = this;
        registerEvents();
        registerCommands();
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("§aUnknown activer");
    }

    private void registerEvents(){
        Bukkit.getPluginManager().registerEvents(new WeatherPercentage(), this);
    }

    private void registerCommands(){
        Bukkit.getPluginCommand("wp").setExecutor(new ChangePercentWeather());
    }

    public void onDisable() {
        this.saveConfig();
        Bukkit.getConsoleSender().sendMessage("§cUnknown desactiver");
    }

    public static Main getInstance() {
        return instance;
    }
}
