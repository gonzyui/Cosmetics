package fr.gonz.cosmetics.commands;

import fr.gonz.cosmetics.models.PetsGUI;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PetsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("pets") || label.equalsIgnoreCase("pet")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cOnly players can use this command!");
                return true;
            }
            Player p = (Player)sender;
            PetsGUI menu = new PetsGUI();
            menu.openInventory(p);
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.3F, 0.5F);
            return true;
        }
        return false;
    }
}