package fr.eowalim.weatherpercentage.commands;

import fr.eowalim.weatherpercentage.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ChangePercentWeather implements CommandExecutor {

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {

        if (sender instanceof Player) {

            final Player player = (Player) sender;
            final FileConfiguration cfg = Main.getInstance().getConfig();
            final String prefix = cfg.getString("prefix").replace("&", "§");

            if (label.equalsIgnoreCase("wp")) {
                if (player.hasPermission("weatherpercentage.use")) {
                    if (args.length == 0) {
                        commandList(player, prefix);
                    } else {
                        switch (args[0]) {
                            case "help":
                                commandList(player, prefix);
                                break;

                            case "percent":
                                if (args.length == 1) {
                                    player.sendMessage(prefix + "The command is: §b/wp percent <valeur>");
                                } else {
                                    final int percent = Integer.parseInt(args[1]);
                                    if (percent < 0 || percent > 100) {
                                        sender.sendMessage(prefix + "§cThe value must be between 0 and 100.");
                                    } else if (percent == cfg.getInt("percent")) {
                                        sender.sendMessage(prefix + "§fThe percentage is already of §c" + percent + "%§f.");
                                    } else {
                                        cfg.set("percent", percent);
                                        cfg.set("last", player.getName());
                                        Main.getInstance().saveConfig();
                                        Bukkit.broadcastMessage(prefix + "§aThe percentage has been changed to:§b " + args[1] + "% §7(§c" + sender.getName() + "§7)");
                                    }
                                }
                                break;

                            case "actual":
                                player.sendMessage(prefix + "§aThe current percentage is: §b" +
                                    Main.getInstance().getConfig().getInt("percent") +
                                    "% §7(last edit:§c " + cfg.getString("last") + "§7)");
                                break;
                            default:
                                commandList(player, prefix);
                        }
                    }
                } else {
                    player.sendMessage(prefix + "§cYou do not have permission to make this command");
                }
            }
        }
        return false;
    }

    private void commandList(Player player, String prefix) {
        player.sendMessage(prefix + "§eInvalid command. Try it: §b" +
            "\n/wp help" +
            "\n/wp actual" +
            "\n/wp percent <value>"
        );
    }
}
