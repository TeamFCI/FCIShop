package de.teamfci.fcishop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.teamfci.fcishop.entity.Haendler;

public class FCISCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (p.hasPermission("fci.fci")) {
				if (args.length == 0) {
					p.sendMessage("§f[§bFCIShop§f] /fcis create [Name] [SkinOwner]");
					p.sendMessage("§f[§bFCIShop§f] Dies ist das Shopsystem von FCI");
					p.sendMessage("§f[§bFCIShop§f] /fcis tphere");
					p.sendMessage("§f[§bFCIShop§f] /fcis tpto");
					p.sendMessage("§f[§bFCIShop§f] /fcis select");
				}
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("tpto")){
						Haendler.tpto(p);
					}
					if(args[0].equalsIgnoreCase("tphere")){
						Haendler.tphere(p);
					}
					if(args[0].equalsIgnoreCase("select")){
						Haendler.select(p);
					}
					if(args[0].equalsIgnoreCase("delete")){
						Haendler.delete(p);
					}
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
