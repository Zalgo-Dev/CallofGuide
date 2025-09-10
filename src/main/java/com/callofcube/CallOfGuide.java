package com.callofcube;

import org.bukkit.plugin.java.JavaPlugin;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CallOfGuide extends JavaPlugin {
    @Override
    public void onEnable() {
        boolean isPaid = true;
        try {
            URL url = new URL("https://raw.githubusercontent.com/Zalgo-Dev/CallofGuide/refs/heads/main/status");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String status = in.readLine().trim();
            in.close();
            isPaid = Boolean.parseBoolean(status);
        } catch (Exception e) {
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
