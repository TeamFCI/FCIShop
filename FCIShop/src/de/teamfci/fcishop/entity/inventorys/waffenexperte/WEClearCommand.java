package de.teamfci.fcishop.entity.inventorys.waffenexperte;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class WEClearCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		System.out.println("a");
	File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Klassen//Waffenexperte//config.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		System.out.println("b");
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 1) {
				System.out.println("c");
				for (int i = 1; i < 7; i++) {
					System.out.println(i);
					cfg.set(args[0] + ".tier" + i, false);
					try {
						cfg.save(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				p.sendMessage("/weclear");
			}
		}
		return false;
	}
}
