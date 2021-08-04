package fr.gonz.cosmetics.commands;

import fr.gonz.cosmetics.models.GUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Trail implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("trails")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can use this command!");
                return true;
            }
            Player p = (Player)sender;
            GUI menu = new GUI();
            menu.openInventory(p);
            return true;
        }
        return false;
    }
}
