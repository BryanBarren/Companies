package me.BryanBarren.Economy;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Files {
	private File file;
	private YamlConfiguration fileConfig;
	
	private static Files instance = new Files();
	
	public static Files getInstance() {
		return instance;
	}
	public Main plugin;
	public File companydir;
	
	public void setup(Main main) {
		this.plugin = main;
		if(!main.getDataFolder().exists()) {
			main.getDataFolder().mkdirs();
		}
		companydir.mkdir();
	}

}
