package me.BryanBarren.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.BryanBarren.Economy.Commands.CommandManager;

public class Main extends JavaPlugin{
	
	public static String companies = ChatColor.BLACK + "[" + ChatColor.GOLD + "Mc" + ChatColor.AQUA + "Cities" + ChatColor.BLACK + "]" + ChatColor.RESET;
	
	public void onEnable() {
		saveConfig();
		Bukkit.getServer().getPluginCommand("company").setExecutor(new CommandManager(this));
		Files.getInstance().setup(this);
	}
	
	public void run(final Player p){
		Bukkit.getServer().getScheduler().runTaskTimer(this, new Runnable(){

			@Override
			public void run() {
				for(Companies c : CompaniesManager.getInstance().companies);
				CompaniesManager.getInstance().update(c);
			}
		}, (long) 40, 40);
	}
	
	public void onDisable() {
		saveConfig();
	}

}
