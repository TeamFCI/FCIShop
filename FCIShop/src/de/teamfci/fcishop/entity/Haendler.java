package de.teamfci.fcishop.entity;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.teamfci.fcishop.FCIShop;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.DespawnReason;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;

public class Haendler implements Listener {
	
	private List<String> lore = new LinkedList<String>();
	Inventory inv = Bukkit.createInventory(null, 9);
	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent ev) {
		Player p = ev.getPlayer();
		Entity e = ev.getRightClicked();
		NPCRegistry registry = CitizensAPI.getNPCRegistry();
		if (registry.isNPC(e)) {
			NPC npc = registry.getNPC(e);
			if(p.getItemInHand().getType().equals(Material.BLAZE_POWDER)){
				FCIShop.selection.put(p, npc);
				p.sendMessage("Du hast den NPC " + npc.getName() + " ausgewählt.");
			} else {
				// 00 01 02 #M 04 #S 06 07 08
				inv = Bukkit.createInventory(null, 9, "Splitter-Shop");
				ItemStack Mage = new ItemStack(Material.PRISMARINE_SHARD);
				ItemMeta magemeta = Mage.getItemMeta();
				magemeta.setDisplayName("Magier");
				lore.add("§aFortress§8-§aCombat§8-§aShop");
				lore.add("§9§m------------------------------");
				lore.add("§6Shop für den Magier.");
				lore.add("§6Hier kannst du Rang-Upgrades kaufen");
				magemeta.setLore(lore);
				lore.clear();
				Mage.setItemMeta(magemeta);
				inv.setItem(3, Mage);
				ItemStack Splitter = new ItemStack(Material.QUARTZ);
				ItemMeta splitmeta = Mage.getItemMeta();
				splitmeta.setDisplayName("Splittershop");
				lore.add("§aFortress§8-§aCombat§8-§aShop");
				lore.add("§9§m------------------------------");
				lore.add("§6Shop für Splitter.");
				lore.add("§6Hier kannst du FCI-Items kaufen");
				splitmeta.setLore(lore);
				lore.clear();
				Splitter.setItemMeta(splitmeta);
				inv.setItem(5, Splitter);
				p.openInventory(inv);
			}
		}
	}
	//00 01 02 03 04 05 06 07 08
	//09 10 11 R1 13 R2 15 16 17
	@EventHandler
	public void onClick(InventoryClickEvent ev){
		Inventory clicked = ev.getClickedInventory();
		Player p = (Player) ev.getWhoClicked();
		if(clicked.equals(inv)){
			ev.setCancelled(true);
			if(ev.getRawSlot() == 3){
				p.playSound(p.getLocation(), Sound.IRONGOLEM_HIT, 100, 1);
				inv = Bukkit.createInventory(null, 18, "Upgradeshop Magier");
				ItemStack Mage = new ItemStack(Material.PRISMARINE_SHARD);
				ItemMeta magemeta = Mage.getItemMeta();
				magemeta.setDisplayName("Magier");
				lore.add("§aFortress§8-§aCombat§8-§aShop");
				lore.add("§9§m------------------------------");
				lore.add("§6Shop für den Magier.");
				lore.add("§6Hier kannst du Rang-Upgrades kaufen");
				magemeta.setLore(lore);
				magemeta.addEnchant(Enchantment.WATER_WORKER, 10, true);
				magemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				lore.clear();
				Mage.setItemMeta(magemeta);
				inv.setItem(3, Mage);
				ItemStack Splitter = new ItemStack(Material.QUARTZ);
				ItemMeta splitmeta = Mage.getItemMeta();
				splitmeta.setDisplayName("Splittershop");
				lore.add("§aFortress§8-§aCombat§8-§aShop");
				lore.add("§9§m------------------------------");
				lore.add("§6Shop für Splitter.");
				lore.add("§6Hier kannst du FCI-Items kaufen");
				splitmeta.setLore(lore);
				lore.clear();
				Splitter.setItemMeta(splitmeta);
				inv.setItem(5, Splitter);
				ItemStack Rang1 = new ItemStack(Material.STICK);
				ItemMeta rang1meta = Rang1.getItemMeta();
				rang1meta.setDisplayName("Upgrade 1: Erfahrener Zauerer");
				Rang1.setItemMeta(rang1meta);
				inv.setItem(12, Rang1);
				ItemStack Rang2 = new ItemStack(Material.STICK);
				ItemMeta rang2meta = Rang2.getItemMeta();
				rang2meta.setDisplayName("Upgrade 1: Meister der Zauererei");
				Rang2.setItemMeta(rang2meta);
				inv.setItem(14, Rang2);
				p.openInventory(inv);
			} else {
				if (ev.getRawSlot() == 5) {
					p.playSound(p.getLocation(), Sound.IRONGOLEM_HIT, 100, 1);
				inv = Bukkit.createInventory(null, 18, "Splittershop");
				ItemStack Mage = new ItemStack(Material.PRISMARINE_SHARD);
				ItemMeta magemeta = Mage.getItemMeta();
				magemeta.setDisplayName("Magier");
				lore.add("§aFortress§8-§aCombat§8-§aShop");
				lore.add("§9§m------------------------------");
				lore.add("§6Shop für den Magier.");
				lore.add("§6Hier kannst du Rang-Upgrades kaufen");
				magemeta.setLore(lore);
				lore.clear();
				Mage.setItemMeta(magemeta);
				inv.setItem(3, Mage);
				ItemStack Splitter = new ItemStack(Material.QUARTZ);
				ItemMeta splitmeta = Mage.getItemMeta();
				splitmeta.setDisplayName("Splittershop");
				lore.add("§aFortress§8-§aCombat§8-§aShop");
				lore.add("§9§m------------------------------");
				lore.add("§6Shop für Splitter.");
				lore.add("§6Hier kannst du FCI-Items kaufen");
				splitmeta.setLore(lore);
				splitmeta.addEnchant(Enchantment.WATER_WORKER, 10, true);
				splitmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				lore.clear();
				Splitter.setItemMeta(splitmeta);
				inv.setItem(5, Splitter);
				p.openInventory(inv);
			}
			}
			
			if(ev.getSlot() == 12){
				if(clicked.getName().equals("Upgradeshop Magier"));{
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 100, 1);
//					String rank = dataprovider.getPlayerClass(p);
//					if(rank == "Zaubelehrling"){
//						int money = dataprovider.getMoney(p);
//						if(money >= 100){
//						} else {
//							p.sendMessage("Du benötigst mehr Geld.");
//						}
//					} else {
//						p.sendMessage("Du benötigst einen höheren Rang oder bist bereits in diesem Rang oder höher.");
//					}
				}
			}
			
			if(ev.getSlot() == 14){
				if(clicked.getName().equals("Upgradeshop Magier"));{
					p.playSound(p.getLocation(), Sound.ORB_PICKUP, 100, 1);
//					String rank = dataprovider.getPlayerClass(p);
//					if(rank == "Erfahrener Zauberer"){
//						int money = dataprovider.getMoney(p);
//						if(money >= 100){
//						} else {
//							p.sendMessage("Du benötigst mehr Geld.");
//						}
//					} else {
//						p.sendMessage("Du benötigst einen höheren Rang oder bist bereits in diesem Rang oder höher.");
//					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent ev){
		Action ac = ev.getAction();
		if(ac.equals(Action.RIGHT_CLICK_AIR)){
			Player p = ev.getPlayer();
			if(p.getItemInHand().getItemMeta().getLore().get(1).contains("Rechtsklick um zum Spawn zu gelangen")){
				p.performCommand("spawn");
				p.setItemInHand(new ItemStack(Material.AIR));
			}
		}
		if(ac.equals(Action.RIGHT_CLICK_BLOCK)){
			Player p = ev.getPlayer();
			if(p.getItemInHand().getItemMeta().getLore().get(1).contains("Rechtsklick um zum Spawn zu gelangen")){
				p.performCommand("spawn");
				p.setItemInHand(new ItemStack(Material.AIR));
			}
		}
	}
	
	public static void select(Player p){
	p.getInventory().addItem(new ItemStack(Material.BLAZE_POWDER));
	p.sendMessage("Rechtsklicke den NPC zum selektieren.");
	}
	
	public static void spawn(Location loc, String name, String Skin){
	    NPCRegistry registry = CitizensAPI.getNPCRegistry();
	    NPC npc = registry.createNPC(EntityType.PLAYER, name);
	    npc.setProtected(true);
	    npc.data().set(NPC.PLAYER_SKIN_UUID_METADATA, Skin);
	    npc.spawn(loc);
	}


	
	public static void tphere(Player p){
		FCIShop.selection.get(p).getEntity().teleport(p.getLocation());
	}
	public static void tpto(Player p){
		p.teleport(FCIShop.selection.get(p).getEntity().getLocation());
	}
	public static void delete(Player p){
		NPC npc = FCIShop.selection.get(p);
		npc.despawn(DespawnReason.REMOVAL);
		npc.destroy();
		NPCRegistry reg = CitizensAPI.getNPCRegistry();
		reg.deregister(npc);
	}
	
	
	
}
