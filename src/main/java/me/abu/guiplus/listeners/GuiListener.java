package me.abu.guiplus.listeners;

import me.abu.guiplus.GUIPLUS;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

import static me.abu.guiplus.ChatColorExtern.cctrans;

public class GuiListener implements Listener {

    GUIPLUS plugin;

    public GuiListener(GUIPLUS plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        HashMap map = plugin.getMap();

        if(e.getClickedInventory() == e.getWhoClicked().getInventory() || e.getClickedInventory() == null) {
            return;
        }
        Inventory inv = e.getClickedInventory();
        Integer i = (Integer) map.get(inv);
        if(i == 1) {
            if(e.getCurrentItem() == null) {
                return;
            }
            switch (e.getCurrentItem().getType()) {
                case DIAMOND_SWORD:
                    Inventory inv_player = plugin.psinv.get(e.getWhoClicked());
                    e.getWhoClicked().closeInventory();
                    e.getWhoClicked().openInventory(inv_player);
                    break;
                case BARRIER:
                    e.getWhoClicked().closeInventory();
                    break;
            }
            e.setCancelled(true);

        }

    }


}
