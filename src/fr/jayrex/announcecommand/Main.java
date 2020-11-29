package fr.jayrex.announcecommand;


import org.bukkit.plugin.java.JavaPlugin;

import fr.jayrex.announcecommand.Command.AnnounceCommand;
import fr.jayrex.announcecommand.Manager.CooldownManager;

public class Main extends JavaPlugin{

    @Override
    public void onEnable() {
        getCommand("annonce").setExecutor(new AnnounceCommand());
        CooldownManager.setupCooldown();
    }
}