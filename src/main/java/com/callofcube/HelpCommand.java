package com.callofcube;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Seuls les joueurs peuvent utiliser cette commande.");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("callofcube.help")) {
            player.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }
        FileConfiguration config = org.bukkit.plugin.java.JavaPlugin.getPlugin(CallOfGuide.class).getConfig();
        if (config.isList("help-messages")) {
            for (String msg : config.getStringList("help-messages")) {
                player.sendMessage(msg);
            }
        } else {
            player.sendMessage("§eVoici l'aide!");
        }
        return true;
    }
}
