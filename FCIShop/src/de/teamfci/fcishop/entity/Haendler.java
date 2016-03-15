package de.teamfci.fcishop.entity;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.teamfci.fcishop.FCIShop;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;

public class Haendler implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEntityEvent ev) {
		Player p = ev.getPlayer();
		Entity e = ev.getRightClicked();
		NPCRegistry registry = CitizensAPI.getNPCRegistry();
		if (registry.isNPC(e)) {
			NPC npc = registry.getNPC(e);
			if (FCIShop.selectionmode.get(p) == true) {
				FCIShop.selection.put(p, npc);
			} else {
				// 00 01 02 #M 04 #S 06 07 08
				Inventory inv = Bukkit.createInventory(null, 9);
				ItemStack Mage = new ItemStack(Material.PRISMARINE_SHARD);
				ItemMeta magemeta = Mage.getItemMeta();
				magemeta.setDisplayName("Magier");
				magemeta.addEnchant(Enchantment.WATER_WORKER, 10, true);
				magemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				lore.add("§aFortress§8-§aCombat§8-§aShop");
				lore.add("§9§m------------------------------");
				lore.add("§6Shop für den Magier.");
				lore.add("§6Hier kannst du Rang-Upgrades kaufen");
				magemeta.setLore(lore);
				lore.clear();
				inv.setItem(3, Mage);
			}
		}
	}
	public static void spawn(Location loc, String name, String Skin){
	    NPCRegistry registry = CitizensAPI.getNPCRegistry();
	    NPC npc = registry.createNPC(EntityType.PLAYER, name);
	    npc.setProtected(true);
	    npc.spawn(loc);
	}


	private List<String> lore = new LinkedList<String>();
	
	public void tphere(Location loc,NPC npc){
		npc.getEntity().teleport(loc);
		npc.teleport(loc, TeleportCause.PLUGIN);
	}
	public void tpto(Player p, NPC npc){
		p.teleport(npc.getEntity());
	}
	public void delete(NPC npc){
		npc.destroy();
	}
	
	
	
}
