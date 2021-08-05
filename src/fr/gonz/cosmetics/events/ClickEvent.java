package fr.gonz.cosmetics.events;

import fr.gonz.cosmetics.Main;
import fr.gonz.cosmetics.models.Effects;
import fr.gonz.cosmetics.models.GUI;
import fr.gonz.cosmetics.models.ParticleData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class ClickEvent implements Listener {
    private GUI menu;
    public ClickEvent() {
        menu = new GUI();
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!e.getInventory().equals(menu.getInventory()))
            return;

        Player p = (Player)e.getWhoClicked();
        e.setCancelled(true);

        if (e.getView().getType() == InventoryType.PLAYER)
            return;

        ParticleData particle = new ParticleData(p.getUniqueId());
        if (particle.hasID()) {
            particle.endTask();
            particle.removeID();
        }

        Effects particles = new Effects(p);
        switch(e.getSlot()) {
            case 2:
                particles.startTotem();
                p.closeInventory();
                p.updateInventory();
                p.sendMessage(Main.getPlugin(Main.class).getConfig().getString("plugin-prefix").replace("&", "§") + Main.getPlugin(Main.class).getConfig().getString("messages.totem-enabled").replace("&", "§"));
                break;
            case 4:
                particles.startCampfire();
                p.closeInventory();
                p.updateInventory();
                p.sendMessage("§7[§bCosmetics§7] §eYou activated §4Campfire §eparticles.");
                break;
            case 6:
                particles.fallingWater();
                p.closeInventory();
                p.updateInventory();
                p.sendMessage("§7[§bCosmetics§7] §eYou activated §3Water Falling §eparticles.");
                break;
            case 10:
                particles.dripLava();
                p.closeInventory();
                p.updateInventory();
                p.sendMessage("§7[§bCosmetics§7] §eYou activated §cDripLava §eparticles.");
            case 12:
                particles.hearts();
                p.closeInventory();
                p.updateInventory();
                p.sendMessage("§7[§bCosmetics§7] §eYou activated §4Hearts §eparticles.");
            case 26:
                p.closeInventory();
                p.updateInventory();
            default:
                break;
        }
    }
}
