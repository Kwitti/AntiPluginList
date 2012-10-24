package com.theharofreak.antipluginlist.util;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

import com.theharofreak.antipluginlist.AntiPluginList;

public class ConfigFile {
	
	private AntiPluginList plugin;
	public ConfigFile(AntiPluginList plugin) {
		this.plugin = plugin;
	}
	
	public void createConfig() {
		FileConfiguration config;
		if(new File("plugins/AntiPluginList/config.yml").exists()) {
			config = plugin.getConfig();
			System.out.println(plugin.prefix + "Config successfully loaded.");
			
		} else {
			plugin.saveDefaultConfig();
			config = plugin.getConfig();
			System.out.println(plugin.prefix + "No config found. Creating one ...");
			System.out.println(plugin.prefix + "Config successfully loaded.");
		}
	}

}
