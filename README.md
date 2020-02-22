# WeatherPercentage

Plugin for minecraft that allows to change the percentage of weather change in game.

---

### How do you work the plugin ?
The working of the plugin is very simple. You have a command (see below) that allows you to change the percentage. Once changed this percentage will be stored in a **config.yml** file.
As soon as the rain, snow or thunderstorm event is triggered a value will be drawn between 0 and 100. 
 - If it is higher than the configured percentage the event will be cancelled.
 - If it is lower than the configured percentage the event will continue to run so there will be rain / snow / thunderstorm.

## Informations

- Minecraft version supported: **1.12 - 1.15**
- You can edit the **config.yml** file to change the prefix in front of chat messages.

```yml
prefix: "&7[§dWeatherPercent§7] &7&l>>&f "
```

## Commands

Permission is required to perform these commands: **WeatherPercentage.wr**

Command | Description 
--- | --- 
**/wp help** | *Gives the list of commands* 
**/wp actual** | *Gives the current percentage* 
**/wp percent value** | *Changes the value of the percentage which must be between 0 and 100.* 

## Support

If you need to report a bug or want to suggest a new feature, you can [open an issue on GitHub](https://github.com/Eowalim/WeatherPercentage/issues/new/choose).
