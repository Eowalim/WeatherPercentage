package fr.eowalim.weatherpercentage.listeners;

import fr.eowalim.weatherpercentage.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;

public class WeatherPercentage implements Listener {

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        if (!event.isCancelled() && event.toWeatherState()) {
            final int random = (int)(Math.random() * 100);
            if (random > Main.getInstance().getConfig().getInt("percent")) {
                event.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onThunderChange(ThunderChangeEvent event) {
        if (!event.isCancelled() && event.toThunderState()) {
            final int random = (int)(Math.random() * 100);
            if (random > Main.getInstance().getConfig().getInt("percent")) {
                event.setCancelled(true);
            }
        }
    }
}
