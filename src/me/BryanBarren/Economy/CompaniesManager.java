package me.BryanBarren.Economy;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CompaniesManager {
	private static CompaniesManager instance = new CompaniesManager();
	public ArrayList<Companies> companies = new ArrayList<Companies>();
	
	public static CompaniesManager getInstance() {
		return instance;
	}
	
	
	public void update(Companies c) {
		File file = new File(Files.getInstance().companydir + File.separator + c.getName() + ".yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		config.set("members", c.getMembers());
		config.set("associates", c.getAssociates());
		config.set("owner", c.getOwner());
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeCompany(Player p, String name) {
		File file = new File(Files.getInstance().companydir + File.separator + name + ".yml");
		if (!file.exists()) {
			p.sendMessage(Main.companies + "You don't have a company");
			return;
		}
		if (file.exists()) {
			Bukkit.broadcastMessage(Main.companies + name + " was disbanded by: " + p.getName());
			file.delete();
		}
	}
	
	public String getCompanyName(String name) {
		for(File f: new File(Files.getInstance().companydir.getPath()).listFiles()) {
			FileConfiguration config = YamlConfiguration.loadConfiguration(f);
			return config.getString("companyName");
		}
		return null;
	}
	
	public String companyWhereOwner(String name) {
		for(File f : new File(Files.getInstance().companydir.getPath()).listFiles()) {
			FileConfiguration config = YamlConfiguration.loadConfiguration(f);
			return config.getString("owner");
		}
		return null;
	}
	
	public void addCompany(Player p, String name) {
		File file = new File(Files.getInstance().companydir + File.separator + name + ".yml");
		if (file.exists()) {
			p.sendMessage(Main.companies + "That company name is already in use.");
			return;
		}
		if (!file.exists()) {
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			config.set("owner", p.getName());
			ArrayList<String> members = new ArrayList<String>();
			ArrayList<String> associates = new ArrayList<String>();
			config.set("members", members);
			config.set("associates", associates);
			config.set("creationDate", now("dd-mm-yyyy hh:mm-ss"));
			config.set("teamName", name);
			try {
				config.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String now(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}
}
