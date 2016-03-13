package de.teamfci.fcishop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.help.HelpTopicAmendment;
import org.bukkit.entity.Player;

import de.teamfci.fcishop.entity.Haendler;

public class FCISCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage("§f[§bFCIShop§f] Dies ist das Shopsystem von FCI");
			if (p.hasPermission("fci.fci")) {
				if (args.length == 0) {
					p.sendMessage("§f[§bFCIShop§f] /shop create [Name] [SkinOwner]");
					p.sendMessage("§f[§bFCIShop§f] /shop tphere [ID]");
					p.sendMessage("§f[§bFCIShop§f] /shop tpto [ID]");
				}
				if(args.length == 3){
					if(args[0].equalsIgnoreCase("create")){
						Haendler.spawn(p.getLocation(), args[1], args[2]);
					}
				}

			}

		} else {
			sender.sendMessage("Du musst ein Spieler sein um dies auszuführen");
		}

		return false;
	}

}
