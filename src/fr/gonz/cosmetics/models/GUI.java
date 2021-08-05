package fr.gonz.cosmetics.models;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI {

    private static Inventory INV;

    public void register() {
        Inventory inv = Bukkit.createInventory(null, 27, "§9Particles Menu");
        ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§eTotem §fParticles");
        item.setItemMeta(meta);
        inv.setItem(2, item);

        item = new ItemStack(Material.CAMPFIRE);
        meta = item.getItemMeta();
        meta.setDisplayName("§cCampfire §fParticles");
        item.setItemMeta(meta);
        inv.setItem(4, item);

        item = new ItemStack(Material.WATER_BUCKET);
        meta = item.getItemMeta();
        meta.setDisplayName("§bWater Falling §fParticles");
        item.setItemMeta(meta);
        inv.setItem(6, item);

        item = new ItemStack(Material.LAVA_BUCKET);
        meta = item.getItemMeta();
        meta.setDisplayName("§4DripLava §fParticles");
        item.setItemMeta(meta);
        inv.setItem(10, item);

        item = new ItemStack(Material.SPLASH_POTION, 1, (short) 8197);
        meta = item.getItemMeta();
        meta.setDisplayName("§4Hearts §fparticles");
        item.setItemMeta(meta);
        inv.setItem(12, item);

        item = new ItemStack(Material.BARRIER);
        meta = item.getItemMeta();
        meta.setDisplayName("§cExit");
        item.setItemMeta(meta);
        inv.setItem(26, item);

        setInventory(inv);
    }

    public Inventory getInventory() {
        return INV;
    }

    private void setInventory(Inventory inv) {
        INV = inv;
    }

    public void openInventory(Player p) {
        p.openInventory(INV);
    }
}
