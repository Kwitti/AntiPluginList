package com.theharofreak.antipluginlist;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.theharofreak.antipluginlist.listener.PluginsListener;
import com.theharofreak.antipluginlist.listener.VersionListener;
import com.theharofreak.antipluginlist.util.ConfigFile;

public class AntiPluginList extends JavaPlugin {
	
	//Strings
	public String prefix = "[AntiPluginList] ";
	public String sc = ChatColor.GRAY + "[" + ChatColor.GOLD + "AntiPluginList" + ChatColor.GRAY + "] ";
	
	//Classes
	ConfigFile config = new ConfigFile(this);
	
	//Events
	public PluginsListener blockPlugins;
	public VersionListener blockVersion;
	
	@Override
	public void onDisable() {
		//PrintStuff
		System.out.println(prefix + "Plugin disabled.");
	}
	
	@Override
	public void onEnable() {
		//Events
		blockPlugins = new PluginsListener(this);
		blockVersion = new VersionListener(this);
		registerEvents();
		
		//Config
		config.createConfig();
		
		//PrintStuff
		System.out.println(prefix + "Plugin enabled.");
	}
	
	public void registerEvents() {
		getServer().getPluginManager().registerEvents(blockPlugins, this);
		getServer().getPluginManager().registerEvents(blockVersion, this);
	}
	
	

}
