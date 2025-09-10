package com.callofcube;

import org.bukkit.plugin.java.JavaPlugin;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CallOfGuide extends JavaPlugin {
    @Override
    public void onEnable() {
        boolean isPaid = true;
        try {
            String status = new String(Files.readAllBytes(Paths.get("status"))).trim();
            isPaid = Boolean.parseBoolean(status);
        } catch (Exception e) {
            getLogger().warning("Impossible de lire le fichier status, le plugin sera désactivé.");
            isPaid = false;
        }
        if (!isPaid) {
            String msg = "\n==============================\n" +
                         "   DEFAUT DE PAIEMENT !\n" +
                         "   Le propriétaire du serveur doit régler la facture.\n" +
                         "   Contactez le développeur pour débloquer le plugin.\n" +
                         "==============================\n";
            getLogger().severe(msg);
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getCommand("guide").setExecutor(new GuideCommand());
        getCommand("help").setExecutor(new HelpCommand());
        saveDefaultConfig();
    }
}
