package de.teamfci.fcishop.entity.inventorys.waffenexperte;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstJoinListener implements Listener, CommandExecutor {

	@EventHandler
	public void onFirstJoin(PlayerJoinEvent ev) {
		Player p = ev.getPlayer();
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(
				new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Klassen//Waffenexperte//config.yml"));
		if (!p.hasPlayedBefore()) {
			for (int i = 1; i < 7; i++) {
				cfg.set(p.getName() + ".tier" + i, false);
			}
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(
				new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Klassen//Waffenexperte//config.yml"));
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 1) {
				for (int i = 1; i < 7; i++) {
					cfg.set(args[0] + ".tier" + i, false);
					try {
						cfg.save(new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Klassen//Waffenexperte//config.yml"));
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
