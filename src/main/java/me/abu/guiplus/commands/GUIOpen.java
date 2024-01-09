package me.abu.guiplus.commands;

import me.abu.guiplus.GUIPLUS;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class GUIOpen implements CommandExecutor {

    GUIPLUS plugin;

    public GUIOpen(GUIPLUS plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender p, Command event, String label, String[] args) {
        if(p instanceof Player) {

            Player player = (Player) p;
            player.openInventory(plugin.GUIInv);
            if(!plugin.psinv.containsKey(player)) {
                Inventory nuovoinv = plugin.SwordInvCreate();
                plugin.psinv.put(player, nuovoinv);
            }
            if(!plugin.Psword.containsKey(player)) {
                ItemStack nuovaspada = new ItemStack(Material.DIAMOND_SWORD);
                plugin.Psword.put(player, nuovaspada);
            }

            Inventory inv = plugin.psinv.get(player);
            ItemStack spada = plugin.Psword.get(player);
            inv.setItem(14, spada);
        } else {
            System.out.println("Non puoi eseguire questo comando da console!");
        }
        return true;
    }
}
