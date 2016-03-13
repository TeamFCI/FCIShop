package de.teamfci.fcishop;

import org.bukkit.craftbukkit.v1_8_R3.help.HelpTopicAmendment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.teamfci.fcishop.entity.Haendler;

public class FCIShop extends JavaPlugin {

	public void onEnable(){
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new PluginEnableListener(), this);
		pm.registerEvents(new Haendler(), this);
		FCISCommand cFCISCommand = new FCISCommand();
		getCommand("fcis").setExecutor(cFCISCommand);
		getCommand("fcishop").setExecutor(cFCISCommand);
		getCommand("fortresscombat1shop").setExecutor(cFCISCommand);
	}
	
}
