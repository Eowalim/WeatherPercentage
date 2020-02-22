package fr.eowalim.weatherpercent.listeners;

import fr.eowalim.weatherpercent.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

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
}