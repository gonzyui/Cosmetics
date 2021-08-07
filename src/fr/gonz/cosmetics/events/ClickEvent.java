package fr.gonz.cosmetics.events;

import fr.gonz.cosmetics.Main;
import fr.gonz.cosmetics.models.Effects;
import fr.gonz.cosmetics.models.ParticlesGUI;
import fr.gonz.cosmetics.models.ParticleData;
import fr.gonz.cosmetics.models.PetsGUI;
import fr.gonz.cosmetics.models.pets.BabyZombie;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.WorldServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class ClickEvent implements Listener {
    private ParticlesGUI menu;
    public ClickEvent() {
        menu = new ParticlesGUI();
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
        BabyZombie zombie = new BabyZombie(p.getLocation(), p);
        zombie.setCustomName(new ChatComponentText("§5" + p.getName()));
        WorldServer world = ((CraftWorld) p.getWorld()).getHandle();
        Effects particles = new Effects(p);
        switch(e.getSlot()) {
            case 2:
                particles.startTotem();
                p.closeInventory();
                p.updateInventory();
                p.sendMessage(Main.getInstance().getConfig().getString("plugin-prefix") + Main.getInstance().getConfig().getString("particles.totem.enabled"));
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
            case 14:
                world.addEntity(zombie);
                p.closeInventory();
                p.updateInventory();
                p.sendMessage("§7[§bCosmetics§7] §eYou spawned §2BabyZombie");
            case 26:
                p.closeInventory();
                p.updateInventory();
            default:
                break;
        }
    }
}
