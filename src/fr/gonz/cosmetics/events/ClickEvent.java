package fr.gonz.cosmetics.events;

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

        Effects trails = new Effects(p);
        switch(e.getSlot()) {
            case 2:
                trails.startTotem();
                p.closeInventory();
                p.updateInventory();
                break;
            case 4:
                trails.startCampfire();
                p.closeInventory();
                p.updateInventory();
                break;
            case 6:
                trails.startWater();
                p.closeInventory();
                p.updateInventory();
                break;
            default:
                break;
        }
    }
}
