package com.callofcube;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class GuideCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Seuls les joueurs peuvent utiliser cette commande.");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("callofcube.guide")) {
            player.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }
        FileConfiguration config = JavaPlugin.getPlugin(CallOfGuide.class).getConfig();
        if (config.isList("guide-messages")) {
            for (String msg : config.getStringList("guide-messages")) {
                player.sendMessage(msg);
            }
        } else {
            player.sendMessage("§aBienvenue dans le guide!");
        }
        return true;
    }
}
