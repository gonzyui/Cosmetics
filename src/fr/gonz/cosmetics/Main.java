package fr.gonz.cosmetics;

import fr.gonz.cosmetics.commands.ParticlesCommand;
import fr.gonz.cosmetics.commands.ReloadCommand;
import fr.gonz.cosmetics.events.ClickEvent;
import fr.gonz.cosmetics.models.GUI;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        GUI menu = new GUI();
        menu.register();

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new ClickEvent(), this);

        getCommand("particles").setExecutor(new ParticlesCommand());
        getCommand("creload").setExecutor(new ReloadCommand());
    }

    @Override
    public void onDisable() {}
}
