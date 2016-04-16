package de.teamfci.fcishop.entity.inventorys.waffenexperte;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Tiermanager {
	
	public static File file;
	
	public void setbought(Player p, int tier){

		file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Klassen//Waffenexperte//" + p.getName() + "config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set(p.getName() + ".tier" + tier, true);
	}
	
	public boolean isavaiable(Player p, int tier){
		
		file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Klassen//Waffenexperte//tiers.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		int boughttier = tier-1;
		
		return cfg.getBoolean(p.getName() + ".tier" + boughttier);
	}
	
}
