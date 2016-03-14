package de.teamfci.fcishop.entity;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;

import net.techcable.npclib.NPC;
import net.techcable.npclib.NPCLib;
import net.techcable.npclib.NPCRegistry;

public class Haendler implements Listener {


	public static void spawn(Location loc, String name, String Skin){
		NPCRegistry registry = NPCLib. getNPCRegistry(Bukkit.getPluginManager().getPlugin("FCIShop"));	
		NPC npc = registry. createNPC(EntityType.PLAYER, name);
		npc.setProtected(true);
		npc.setSkin(Skin);
		npc.spawn(loc);
	}
	
	public void tphere(Location loc,NPC npc){
		npc.getEntity().teleport(loc);
	}
	public void tpto(Player p, NPC npc){
		p.teleport(npc.getEntity().getLocation());
	}
	public void delete(NPC npc){
		npc.despawn();
	}
	
	
	@EventHandler
	public void onInteract(EntityInteractEvent e){
		
	}
}
