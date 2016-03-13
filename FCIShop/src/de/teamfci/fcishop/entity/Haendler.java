package de.teamfci.fcishop.entity;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.inventivegames.npc.NPC;
import de.inventivegames.npc.NPCLib;
import de.inventivegames.npc.event.NPCInteractEvent;
import de.inventivegames.npc.event.NPCInteractEvent.InteractType;

public class Haendler implements Listener {

	private List<String> lore;

	@SuppressWarnings("deprecation")
	public void spawn(Location loc, String name, String Skin){
		NPC npc = NPCLib.spawnNPC(loc, name, Skin);
		npc.setShownInList(false);
		NPC npc = NPCLib.getNPC(arg0)
	}
	
	public void tphere(Location loc,NPC npc){
		npc.teleport(loc);
	}
	public void tpto(Player p, NPC npc){
		p.teleport(npc.getLocation());
	}
	
	@EventHandler
	public void onInteract(NPCInteractEvent e){
		NPC npc = e.getNPC();
		Player p = e.getPlayer();
		InteractType t = e.getType();
		String npcname = npc.getName();
		if(t.equals(InteractType.LEFT_CLICK)){
			Inventory inv = Bukkit.createInventory(null, 9, npcname);
			ItemStack LEER = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)7);
			ItemStack Mage = new ItemStack(Material.STICK);
			ItemMeta magemeta = Mage.getItemMeta();
			magemeta.setDisplayName("Magier");
			lore.add("Shop für die Magierklasse");
			lore.add("Hier kannst du Blutsplitter");
			lore.add("gegen Upgrades eintauschen.");
			magemeta.setLore(lore);
			lore.clear();
			magemeta.addEnchant(Enchantment.WATER_WORKER, 10, true);
			magemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			Mage.setItemMeta(magemeta);
			ItemStack Splitter = new ItemStack(Material.PRISMARINE_SHARD);
			ItemMeta Splittermeta = Splitter.getItemMeta();
			Splittermeta.setDisplayName("Splitter");
			lore.add("Shop für CombatItems");
			lore.add("Hier kannst du Blutsplitter");
			lore.add("gegen CombatItems eintauschen.");
			magemeta.setLore(lore);
			lore.clear();
			for (int i = 0; i < 9; i++) {
				inv.setItem(i, LEER);
			}
			// 00 01 02 #M 04 #S 06 07 08
			inv.setItem(3, Mage);
			inv.setItem(5, Splitter);
			p.openInventory(inv);
		}
	}
	
}
