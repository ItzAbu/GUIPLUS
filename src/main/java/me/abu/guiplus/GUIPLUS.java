package me.abu.guiplus;

import me.abu.guiplus.commands.GUIOpen;
import me.abu.guiplus.listeners.GuiListener;
import me.abu.guiplus.listeners.SwordListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.ArrayList;
import java.util.HashMap;

import static me.abu.guiplus.ChatColorExtern.cctrans;


public final class GUIPLUS extends JavaPlugin {

    HashMap<Inventory, Integer> map = new HashMap< Inventory, Integer>();
    public HashMap<Player,Inventory> psinv = new HashMap<Player, Inventory>();

    public HashMap<Player, ItemStack> Psword = new HashMap<Player, ItemStack>();
    public HashMap< Inventory, Integer> getMap() {
        return map;
    }
    @Override
    public void onEnable() {
        GUIInvCreate();

        //GUI Menu Insert

        insertMap(1, GUIInv);

        getCommand("guiopen").setExecutor(new GUIOpen(this));
        Bukkit.getPluginManager().registerEvents(new GuiListener(this), this);
        Bukkit.getPluginManager().registerEvents(new SwordListener(this), this);


        System.console().printf("GUIPLUS avviato con successo!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Inventory GUIInv;


    public ItemStack unbreaking = new ItemStack(Material.ANVIL);

    public void insertMap(int i, Inventory inv) {
        map.put(inv, i);
    }

    public void GUIInvCreate() {
        GUIInv = Bukkit.createInventory(null, 54, cctrans("&b&lGUIPLUS"));
        //Item 1
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(cctrans("&b&lSpada"));
        ArrayList<String> lore = new ArrayList<>();
        lore.add(cctrans("&7Enchanta la tua sp ada per renderla potentissima!"));
        lore.add(cctrans("&7Clicca per aprire il menu!"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        GUIInv.setItem(22, item);
        //Item 2
        ItemStack item2 = new ItemStack(Material.BARRIER);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName(cctrans("&c&lChiudi"));
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add(cctrans("&7Clicca per chiudere il menu!"));
        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        GUIInv.setItem(53, item2);
    }



    public Inventory SwordInvCreate() {
        Inventory SwordInv = Bukkit.createInventory(null, 54, cctrans("&b&lSpada"));

        //Spada
        ItemStack spada1 = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta spadaMeta = spada1.getItemMeta();
        spadaMeta.setDisplayName(cctrans("&b&lSpada"));
        ArrayList<String> spadaLore = new ArrayList<>();
        spadaLore.add(cctrans("&7Clicca per ottenere una spada con gli enchant selezionati!"));
        spadaMeta.setLore(spadaLore);
        spada1.setItemMeta(spadaMeta);
        SwordInv.setItem(12, spada1);
        //reset
        ItemStack reset = new ItemStack(Material.BARRIER);
        ItemMeta resetMeta = reset.getItemMeta();
        resetMeta.setDisplayName(cctrans("&c&lReset"));
        ArrayList<String> resetLore = new ArrayList<>();
        resetLore.add(cctrans("&7Clicca per resettare la spada!"));
        resetMeta.setLore(resetLore);
        reset.setItemMeta(resetMeta);
        SwordInv.setItem(13, reset);



        //Sharpness
        ItemStack damage = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta damageMeta = damage.getItemMeta();
        damageMeta.setDisplayName(cctrans("&b&lSharpness"));
        ArrayList<String> damageLore = new ArrayList<>();
        damageLore.add(cctrans("&7Clicca per aggiungere un livello di Sharpness alla tua spada!"));
        damageMeta.setLore(damageLore);
        damage.setItemMeta(damageMeta);
        SwordInv.setItem(28, damage);

        //Fire Aspect
        ItemStack fire = new ItemStack(Material.FIREBALL);
        ItemMeta fireMeta = fire.getItemMeta();
        fireMeta.setDisplayName(cctrans("&b&lFire Aspect"));
        ArrayList<String> fireLore = new ArrayList<>();
        fireLore.add(cctrans("&7Clicca per aggiungere un livello di Fire Aspect alla tua spada!"));
        fireMeta.setLore(fireLore);
        fire.setItemMeta(fireMeta);
        SwordInv.setItem(29, fire);

        //Unbreaking

        ItemMeta unbreakingMeta = unbreaking.getItemMeta();
        unbreakingMeta.setDisplayName(cctrans("&b&lUnbreaking"));
        ArrayList<String> unbreakingLore = new ArrayList<>();
        unbreakingLore.add(cctrans("&7Clicca per aggiungere un livello di Unbreaking alla tua spada!"));
        unbreakingMeta.setLore(unbreakingLore);
        unbreaking.setItemMeta(unbreakingMeta);
        SwordInv.setItem(30, unbreaking);

        //Unbreakable
        ItemStack unbreakable = new ItemStack(Material.BEDROCK);
        ItemMeta unbreakableMeta = unbreakable.getItemMeta();
        unbreakableMeta.setDisplayName(cctrans("&b&lUnbreakable"));
        ArrayList<String> unbreakableLore = new ArrayList<>();
        unbreakableLore.add(cctrans("&7Clicca per rendere la tua spada indistruttibile!"));
        unbreakableMeta.setLore(unbreakableLore);
        unbreakable.setItemMeta(unbreakableMeta);
        SwordInv.setItem(31, unbreakable);


        //Looting
        ItemStack looting = new ItemStack(Material.GOLD_SWORD);
        ItemMeta lootingMeta = looting.getItemMeta();
        lootingMeta.setDisplayName(cctrans("&b&lLooting"));
        ArrayList<String> lootingLore = new ArrayList<>();
        lootingLore.add(cctrans("&7Clicca per aggiungere un livello di Looting alla tua spada!"));
        lootingMeta.setLore(lootingLore);
        looting.setItemMeta(lootingMeta);
        SwordInv.setItem(32, looting);

        //Knockback
        ItemStack knockback = new ItemStack(Material.STICK);
        ItemMeta knockbackMeta = knockback.getItemMeta();
        knockbackMeta.setDisplayName(cctrans("&b&lKnockback"));
        ArrayList<String> knockbackLore = new ArrayList<>();
        knockbackLore.add(cctrans("&7Clicca per aggiungere un livello di Knockback alla tua spada!"));
        knockbackMeta.setLore(knockbackLore);
        knockback.setItemMeta(knockbackMeta);
        SwordInv.setItem(33, knockback);

        //Bane of Arthropods
        ItemStack bane = new ItemStack(Material.SPIDER_EYE);
        ItemMeta baneMeta = bane.getItemMeta();
        baneMeta.setDisplayName(cctrans("&b&lBane of Arthropods"));
        ArrayList<String> baneLore = new ArrayList<>();
        baneLore.add(cctrans("&7Clicca per aggiungere un livello di Bane of Arthropods alla tua spada!"));
        baneMeta.setLore(baneLore);
        bane.setItemMeta(baneMeta);
        SwordInv.setItem(34, bane);

        //Smite
        ItemStack smite = new ItemStack(Material.IRON_SWORD);
        ItemMeta smiteMeta = smite.getItemMeta();
        smiteMeta.setDisplayName(cctrans("&b&lSmite"));
        ArrayList<String> smiteLore = new ArrayList<>();
        smiteLore.add(cctrans("&7Clicca per aggiungere un livello di Smite alla tua spada!"));
        smiteMeta.setLore(smiteLore);
        smite.setItemMeta(smiteMeta);
        SwordInv.setItem(39, smite);

        //Sweeeping Edge
        ItemStack sweeping = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta sweepingMeta = sweeping.getItemMeta();
        sweepingMeta.setDisplayName(cctrans("&b&lSweeping Edge"));
        ArrayList<String> sweepingLore = new ArrayList<>();
        sweepingLore.add(cctrans("&7Clicca per aggiungere un livello di Sweeping Edge alla tua spada!"));
        sweepingMeta.setLore(sweepingLore);
        sweeping.setItemMeta(sweepingMeta);
        SwordInv.setItem(40, sweeping);

        //Mending
        ItemStack mending = new ItemStack(Material.EXP_BOTTLE);
        ItemMeta mendingMeta = mending.getItemMeta();
        mendingMeta.setDisplayName(cctrans("&b&lMending"));
        ArrayList<String> mendingLore = new ArrayList<>();
        mendingLore.add(cctrans("&7Clicca per aggiungere un livello di Mending alla tua spada!"));
        mendingMeta.setLore(mendingLore);
        mending.setItemMeta(mendingMeta);
        SwordInv.setItem(41, mending);



        return SwordInv;






    }

}
