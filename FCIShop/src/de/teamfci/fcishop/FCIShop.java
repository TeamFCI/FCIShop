package de.teamfci.fcishop;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.teamfci.fcishop.commands.FCISCommand;
import de.teamfci.fcishop.entity.Haendler;
import de.teamfci.fcishop.entity.inventorys.Magier;
import net.citizensnpcs.api.npc.NPC;

public class FCIShop extends JavaPlugin {
	public static HashMap<Player, NPC> selection = new HashMap<Player, NPC>();

	public void onEnable(){
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new PluginEnableListener(), this);
		pm.registerEvents(new Haendler(), this);
		pm.registerEvents(new Magier(), this);
		FCISCommand cFCISCommand = new FCISCommand();
		this.getCommand("fcis").setExecutor(cFCISCommand);
		this.getCommand("fortresscombat1shop").setExecutor(cFCISCommand);
	}
	
}
