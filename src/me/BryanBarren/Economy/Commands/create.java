package me.BryanBarren.Economy.Commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.BryanBarren.Economy.CompaniesManager;
import me.BryanBarren.Economy.Errors;
import me.BryanBarren.Economy.Files;
import me.BryanBarren.Economy.Permissions;

public class create extends command{
	
	public create() {
		super("create", "create a company", "<name>");
	}
	
	@Override
	public void run(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(args.length <1) {
				p.sendMessage(Errors.getErrorMessage(Errors.TOO_LESS_ARGUMENTS));
				return;
			}
			String name = args[0];
			CompaniesManager.getInstance().addCompany(p, name);
		}
	}
	

}
