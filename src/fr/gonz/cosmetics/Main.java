package fr.gonz.cosmetics;

import fr.gonz.cosmetics.commands.ParticlesCommand;
import fr.gonz.cosmetics.commands.PetsCommand;
import fr.gonz.cosmetics.commands.ReloadCommand;
import fr.gonz.cosmetics.events.ClickEvent;
import fr.gonz.cosmetics.models.ParticlesGUI;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        ParticlesGUI menu = new ParticlesGUI();
        menu.register();

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new ClickEvent(), this);

        this.getCommand("particles").setExecutor(new ParticlesCommand());
        this.getCommand("creload").setExecutor(new ReloadCommand());
        this.getCommand("pets").setExecutor(new PetsCommand());
    }

    @Override
    public void onDisable() {}
    
    public static Main getInstance() {
        return INSTANCE;
    }
}
