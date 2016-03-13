package de.teamfci.fcishop;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FCISCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player){
			Player p = (Player) sender;
			p.sendMessage("§f[§bFCIShop§f] Dies ist das Shopsystem von FCI");
		} else {
			sender.sendMessage("Du musst ein Spieler sein um dies auszuführen");
		}
		
		return false;
	}

}
