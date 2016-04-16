package de.teamfci.fcishop.entity.inventorys;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.teamfci.fcishop.entity.Haendler;

public class Splittershop implements Listener {

	public static List<String> lore = new LinkedList<String>();
	static Inventory inv;
	static Haendler invholder;

	public static void open(Player p) {
		inv = Bukkit.createInventory(null, 18, "Splittershop");
		p.playSound(p.getLocation(), Sound.IRONGOLEM_HIT, 100, 1);
		// Klassenshop
		ItemStack Mage = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		ItemMeta magemeta = Mage.getItemMeta();
		magemeta.setDisplayName("§4§lKlassenshop");
		lore.add("§aFortress§8-§aCombat§8-§aShop");
		lore.add("§9§m------------------------------");
		lore.add("§6§lHier kannst du spezielle Items");
		lore.add("§6§lund Ränge für deine Klasse auswählen");
		magemeta.setLore(lore);
		magemeta.addEnchant(Enchantment.WATER_WORKER, 10, true);
		magemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		lore.clear();
		Mage.setItemMeta(magemeta);
		SkullMeta mtas = (SkullMeta) Mage.getItemMeta();
		mtas.setOwner("MHF_Question");
		Mage.setItemMeta(mtas);
		inv.setItem(3, Mage);
		// Spittershop
		ItemStack Splitter = new ItemStack(Material.PRISMARINE_SHARD);
		ItemMeta splitmeta = Splitter.getItemMeta();
		splitmeta.setDisplayName("§4§lSplittershop");
		lore.add("§aFortress§8-§aCombat§8-§aShop");
		lore.add("§9§m------------------------------");
		lore.add("§6§lHier kannst du dir spezielle");
		lore.add("§6§lItems für Blutsplitter besorgen.");
		splitmeta.setLore(lore);
		lore.clear();
		Splitter.setItemMeta(splitmeta);
		inv.setItem(5, Splitter);
		Haendler.hm.put(p, inv);
		p.openInventory(Haendler.hm.get(p));
	}

}
