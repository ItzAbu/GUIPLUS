package me.abu.guiplus.listeners;

import me.abu.guiplus.GUIPLUS;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

import static me.abu.guiplus.ChatColorExtern.cctrans;

public class SwordListener implements Listener {
    GUIPLUS plugin;

    public SwordListener(GUIPLUS plugin) {
        this.plugin = plugin;
    }
    int sharp = 0;
    int fire =0;
    int unbreaking = 0;
    int looting =0;
    int knockback = 0;
    int bane = 0;
    int smite = 0;
    boolean mending = false;
    int sweeping = 0;
    boolean unbreakable = false;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        ItemStack Spada = plugin.Psword.get((Player)e.getWhoClicked());
        Inventory SwordInv = plugin.psinv.get((Player)e.getWhoClicked());
        if(e.getClickedInventory() == e.getWhoClicked().getInventory() || e.getClickedInventory() == null) {
            return;
        }
        if (e.getCurrentItem().isSimilar(Spada)) {
            e.setCancelled(true);
            return;
        }

        Inventory inv = e.getClickedInventory();

        

        if(inv == (Inventory) plugin.psinv.get((Player) e.getWhoClicked())) {
            
            ItemMeta Spada_meta = Spada.getItemMeta();

            switch (e.getCurrentItem().getType()) {
                case DIAMOND_SWORD:
                    ItemStack controllo = e.getCurrentItem();
                    if(controllo == Spada) {
                        break;
                    }
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(cctrans("&b&lSharpness"))) {
                        if (e.isLeftClick()) {
                            sharp++;
                            Spada_meta.addEnchant(Enchantment.DAMAGE_ALL, sharp, true);
                            Spada.setItemMeta(Spada_meta);
                        } else {
                            if(sharp == 1) {
                                Spada_meta.removeEnchant(Enchantment.DAMAGE_ALL);
                                Spada.setItemMeta(Spada_meta);
                                sharp = 0;
                                break;
                            }

                            if (sharp > 0) {

                                sharp--;
                                Spada_meta.addEnchant(Enchantment.DAMAGE_ALL, sharp, true);
                                Spada.setItemMeta(Spada_meta);
                                break;

                            }

                            break;

                        }
                        break;



                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(cctrans("&b&lSpada"))) {
                        e.getWhoClicked().closeInventory();
                        e.getWhoClicked().getInventory().addItem(Spada);
                        ItemMeta vuoto = new ItemStack(Material.DIAMOND_SWORD).getItemMeta();
                        Spada.setItemMeta(vuoto);
                        sharp = 0;
                        fire = 0;
                    }else {
                        break;
                    }
                    break;
                case FIREBALL:
                    if (e.isLeftClick()) {
                        fire++;
                        Spada_meta.addEnchant(Enchantment.FIRE_ASPECT, fire, true);
                        Spada.setItemMeta(Spada_meta);


                    } else {
                        if(fire == 1) {
                            Spada_meta.removeEnchant(Enchantment.FIRE_ASPECT);
                            Spada.setItemMeta(Spada_meta);
                            fire = 0;
                            break;
                        }
                        if (fire > 0) {

                            fire--;
                            Spada_meta.addEnchant(Enchantment.FIRE_ASPECT, fire, true);
                            Spada.setItemMeta(Spada_meta);


                        }

                    }
                    break;

                case BARRIER:
                    ItemMeta vuoto = new ItemStack(Material.DIAMOND_SWORD).getItemMeta();
                    Spada.setItemMeta(vuoto);
                    sharp = 0;
                    fire = 0;
                    unbreaking = 0;
                    unbreakable = false;
                    looting = 0;
                    knockback = 0;
                    bane = 0;
                    smite = 0;
                    sweeping = 0;
                    mending = false;
                    break;

                case ANVIL:
                    if(e.isLeftClick()) {
                        unbreaking++;
                        Spada_meta.addEnchant(Enchantment.DURABILITY, unbreaking, true);
                        Spada.setItemMeta(Spada_meta);
                    } else {
                        if(unbreaking == 1) {
                            Spada_meta.removeEnchant(Enchantment.DURABILITY);
                            unbreaking = 0;
                            Spada.setItemMeta(Spada_meta);
                            break;
                        }
                        if(unbreaking > 0) {

                            unbreaking--;
                            Spada_meta.addEnchant(Enchantment.DURABILITY, unbreaking, true);
                            Spada.setItemMeta(Spada_meta);

                        }
                    }

                    break;
                case BEDROCK:
                    if(!unbreakable) {
                        Spada_meta.setUnbreakable(true);
                        Spada_meta.removeEnchant(Enchantment.DURABILITY);
                        ItemStack vuoto2 = new ItemStack(Material.AIR);
                        SwordInv.setItem(30, vuoto2);
                        unbreakable = true;
                        Spada.setItemMeta(Spada_meta);
                    } else {
                        Spada_meta.setUnbreakable(false);
                        if(unbreaking > 0) {
                            Spada_meta.addEnchant(Enchantment.DURABILITY, unbreaking, true);
                        }
                        SwordInv.setItem(30, plugin.unbreaking);
                        Spada.setItemMeta(Spada_meta);
                        unbreakable = false;
                    }
                    break;

                case GOLD_SWORD:
                    if(e.isLeftClick()) {
                        looting++;
                        Spada_meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, looting, true);
                        Spada.setItemMeta(Spada_meta);
                    } else {
                        if(looting == 1) {
                            Spada_meta.removeEnchant(Enchantment.LOOT_BONUS_MOBS);
                            looting = 0;
                            Spada.setItemMeta(Spada_meta);
                            break;
                        }
                        if(looting > 0) {

                            looting--;
                            Spada_meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, looting, true);
                            Spada.setItemMeta(Spada_meta);

                        }
                    }
                    break;

                case STICK:
                    if(e.isLeftClick()) {
                        knockback++;
                        Spada_meta.addEnchant(Enchantment.KNOCKBACK, knockback, true);
                        Spada.setItemMeta(Spada_meta);
                    } else {
                        if(knockback == 1) {
                            Spada_meta.removeEnchant(Enchantment.KNOCKBACK);
                            knockback = 0;
                            Spada.setItemMeta(Spada_meta);
                            break;
                        }
                        if(knockback > 0) {

                            knockback--;
                            Spada_meta.addEnchant(Enchantment.KNOCKBACK, knockback, true);
                            Spada.setItemMeta(Spada_meta);

                        }
                    }
                    break;
                case SPIDER_EYE:
                    if(e.isLeftClick()) {
                        Spada_meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 1, true);
                        Spada.setItemMeta(Spada_meta);
                    } else {
                        if(bane == 1) {
                            Spada_meta.removeEnchant(Enchantment.DAMAGE_ARTHROPODS);
                            bane = 0;
                            Spada.setItemMeta(Spada_meta);
                            break;
                        }
                        if(bane > 0) {

                            bane--;
                            Spada_meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, bane, true);
                            Spada.setItemMeta(Spada_meta);

                        }
                    }
                    break;
                case IRON_SWORD:
                    if(e.isLeftClick()) {
                        Spada_meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 1, true);
                        Spada.setItemMeta(Spada_meta);
                    } else {
                        if(smite == 1) {
                            Spada_meta.removeEnchant(Enchantment.DAMAGE_UNDEAD);
                            smite = 0;
                            Spada.setItemMeta(Spada_meta);
                            break;
                        }
                        if(smite > 0) {

                            smite--;
                            Spada_meta.addEnchant(Enchantment.DAMAGE_UNDEAD, smite, true);
                            Spada.setItemMeta(Spada_meta);

                        }
                    }
                    break;

                case BLAZE_POWDER:
                    if(e.isLeftClick()) {
                        Spada_meta.addEnchant(Enchantment.SWEEPING_EDGE, 1, true);
                        Spada.setItemMeta(Spada_meta);
                    } else {
                        if(sweeping == 1) {
                            Spada_meta.removeEnchant(Enchantment.SWEEPING_EDGE);
                            sweeping = 0;
                            Spada.setItemMeta(Spada_meta);
                            break;
                        }
                        if(sweeping > 0) {

                            sweeping--;
                            Spada_meta.addEnchant(Enchantment.SWEEPING_EDGE, sweeping, true);
                            Spada.setItemMeta(Spada_meta);

                        }
                    }
                    break;

                case EXP_BOTTLE:
                    if(!mending) {
                        Spada_meta.addEnchant(Enchantment.MENDING, 1, true);
                        mending = true;
                        Spada.setItemMeta(Spada_meta);
                    }else {
                        Spada_meta.removeEnchant(Enchantment.MENDING);
                        mending = false;
                        Spada.setItemMeta(Spada_meta);
                    }
                    break;
            }
            SwordInv.setItem(14, Spada);
            e.setCancelled(true);

        }

    }
    @EventHandler
    public void chiusura(InventoryCloseEvent e) {
        ItemStack Spada = plugin.Psword.get((Player) e.getPlayer());
        Inventory SwordInv = plugin.psinv.get((Player) e.getPlayer());
        if(e.getInventory() != SwordInv) {
            return;
        }


            ItemMeta vuoto = new ItemStack(Material.DIAMOND_SWORD).getItemMeta();
            Spada.setItemMeta(vuoto);
            sharp = 0;
            fire = 0;
            unbreaking = 0;
            looting = 0;
            knockback = 0;
            bane = 0;
            smite = 0;
            sweeping = 0;
            mending = false;


            if(unbreakable) {
                SwordInv.setItem(30, plugin.unbreaking);
            }
            unbreakable = false;


            SwordInv.setItem(14, Spada);


    }

}
