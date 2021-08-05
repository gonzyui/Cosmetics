package fr.gonz.cosmetics.commands;

import fr.gonz.cosmetics.models.GUI;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ParticlesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("particles") || label.equalsIgnoreCase("particle")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can use this command!");
                return true;
            }
            Player p = (Player)sender;
            GUI menu = new GUI();
            menu.openInventory(p);
            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.3F, 0.5F);
            return true;
        }
        return false;
    }
}
