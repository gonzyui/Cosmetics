package fr.gonz.cosmetics.commands;

import fr.gonz.cosmetics.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("creload")) {
            if (!(sender instanceof Player)) {
                Main.getPlugin(Main.class).reloadConfig();
                sender.sendMessage(Main.getPlugin(Main.class).getConfig().getString("plugin-prefix").replace("&", "§") + Main.getPlugin(Main.class).getConfig().getString("messages.reload"));
                return true;
            }
            Player p = (Player)sender;
            if (p.hasPermission("cosmetics.reload") || p.isOp()) {
                Main.getPlugin(Main.class).reloadConfig();
                p.sendMessage(Main.getPlugin(Main.class).getConfig().getString("plugin-prefix").replace("&", "§") + Main.getPlugin(Main.class).getConfig().getString("messages.reload"));
                return true;
            } else {
                p.sendMessage(Main.getPlugin(Main.class).getConfig().getString("plugin-prefix").replace("&", "§") + Main.getPlugin(Main.class).getConfig().getString("no-permission").replace("&", "§"));
            }
        }
        return false;
    }
}
