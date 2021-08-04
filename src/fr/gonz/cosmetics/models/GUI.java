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
        Inventory inv = Bukkit.createInventory(null, 9, "§bParticles GUI");
        ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§eTotem Particles");
        item.setItemMeta(meta);
        inv.setItem(2, item);

        item = new ItemStack(Material.CAMPFIRE);
        meta = item.getItemMeta();
        meta.setDisplayName("§eFire Particles");
        item.setItemMeta(meta);
        inv.setItem(4, item);

        item = new ItemStack(Material.WATER_BUCKET);
        meta = item.getItemMeta();
        meta.setDisplayName("§bWater Particles");
        item.setItemMeta(meta);
        inv.setItem(6, item);

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
