package de.teamfci.fcishop.entity;

import java.util.HashMap;
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
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.teamfci.fcishop.FCIShop;
import de.teamfci.fcishop.entity.inventorys.Klassenubersicht;
import de.teamfci.fcishop.entity.inventorys.Magier;
import de.teamfci.fcishop.entity.inventorys.Splittershop;
import de.teamfci.fcishop.entity.inventorys.Waffenexperte;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.DespawnReason;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;

public class Haendler implements Listener {

	private List<String> lore = new LinkedList<String>();
	Inventory inv = null;
	public static HashMap<Player, Inventory> hm = new HashMap<Player, Inventory>();

	@EventHandler
	public void onInteract(PlayerInteractEntityEvent ev) {
		Player p = ev.getPlayer();
		Entity e = ev.getRightClicked();
		NPCRegistry registry = CitizensAPI.getNPCRegistry();
		if (registry.isNPC(e)) {
			NPC npc = registry.getNPC(e);
			if (p.getItemInHand().getType().equals(Material.BLAZE_POWDER)) {
				FCIShop.selection.put(p, npc);
				p.sendMessage("Du hast den NPC " + npc.getName() + " ausgewählt.");
			} else {
				// 00 01 02 #M 04 #S 06 07 08
				inv = Bukkit.createInventory(null, 9, "Shopübersicht");
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
				hm.put(p, inv);
				p.openInventory(hm.get(p));
			}
		}
	}

	// 00 01 02 MS 04 SS 06 07 08
	// 09 10 11 12 R3 14 15 16 17
	@EventHandler
	public void onClick(InventoryClickEvent ev) {
		Inventory clicked = ev.getClickedInventory();
		Player p = (Player) ev.getWhoClicked();
		if (clicked.equals(hm.get(p))) {
			ev.setCancelled(true);
			if (ev.getRawSlot() == 3) {
				Klassenubersicht.openInv(p);
			}

			if (ev.getRawSlot() == 5) {
				Splittershop.open(p, this);
			}

			if (!clicked.getName().equals("Splittershop")) {
				if (ev.getRawSlot() == 10) {
					p.playSound(p.getLocation(), Sound.IRONGOLEM_HIT, 1F, 1F);
					Magier.openInv(p);
				}

				if (ev.getRawSlot() == 11) {
					p.playSound(p.getLocation(), Sound.IRONGOLEM_HIT, 1F, 1F);
					Waffenexperte.openInv(p);
				}
			}
		}
	}

	public static void select(Player p) {
		p.getInventory().addItem(new ItemStack(Material.BLAZE_POWDER));
		p.sendMessage("Rechtsklicke den NPC zum selektieren.");
	}

	public static void spawn(Location loc, String name, String Skin) {
		NPCRegistry registry = CitizensAPI.getNPCRegistry();
		NPC npc = registry.createNPC(EntityType.PLAYER, name);
		npc.setProtected(true);
		npc.data().set(NPC.PLAYER_SKIN_UUID_METADATA, Skin);
		npc.spawn(loc);
	}

	public static void tphere(Player p) {
		FCIShop.selection.get(p).getEntity().teleport(p.getLocation());
	}

	public static void tpto(Player p) {
		p.teleport(FCIShop.selection.get(p).getEntity().getLocation());
	}

	public static void delete(Player p) {
		NPC npc = FCIShop.selection.get(p);
		npc.despawn(DespawnReason.REMOVAL);
		npc.destroy();
		NPCRegistry reg = CitizensAPI.getNPCRegistry();
		reg.deregister(npc);
	}

	public static void skin(NPC npc, String Skin) {
		npc.data().set(NPC.PLAYER_SKIN_UUID_METADATA, Skin);
	}

}
