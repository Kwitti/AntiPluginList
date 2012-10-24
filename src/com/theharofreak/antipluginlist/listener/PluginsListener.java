package com.theharofreak.antipluginlist.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.theharofreak.antipluginlist.AntiPluginList;

public class PluginsListener implements Listener {
	
	//Constructor
	private AntiPluginList plugin;
	public PluginsListener (AntiPluginList plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void blockPlugins (PlayerCommandPreprocessEvent event) {
		
		//Get player
		Player player = event.getPlayer();
		
		//Get command
		String cmd = event.getMessage();
		
		//Check if player wants to list the plugins
		if(! (cmd.startsWith("/plugins") || cmd.startsWith("/pl") || cmd.startsWith("/?")))
			return;	
		
		//Check if player has bypass permission
		if(player.hasPermission("antipluginlist.plugins"))
			return;
		
		//Check boolean from config
		if(plugin.getConfig().getBoolean("AntiPluginList.Block-Plugins")) {
			
			event.setCancelled(true);
			
			String pstring = plugin.getConfig().getString("AntiPlugin.For-Player");
			String pstring2 = pstring.replaceAll("%player", player.getName());
			String pstring3 = pstring2.replaceAll("&" , "�");
			String playerMessage = pstring3.replaceAll("��" , "&");
			
			player.sendMessage(plugin.sc + playerMessage);
			
			//Send message to player with 'antipluginlist.spy' permission
			for(Player p : plugin.getServer().getOnlinePlayers()) {
				if(p.hasPermission("antipluginlist.spy")) {
					
					String string = plugin.getConfig().getString("AntiPlugin.For-OP");
					String string2 = string.replaceAll("%player", player.getName());
					String string3 = string2.replaceAll("&" , "�");
					String message = string3.replaceAll("��" , "&");
					
					p.sendMessage(plugin.sc + message);
					System.out.println(plugin.sc + message);
				}
			}
			
		} else {
			
			String pstring = plugin.getConfig().getString("AntiPlugin.For-Player");
			String pstring2 = pstring.replaceAll("%player", player.getName());
			String pstring3 = pstring2.replaceAll("&" , "�");
			String playerMessage = pstring3.replaceAll("��" , "&");
			
			player.sendMessage(plugin.sc + playerMessage);
			
			//Send message to player with 'antipluginlist.spy' permission
			for(Player p : plugin.getServer().getOnlinePlayers()) {
				if(p.hasPermission("antipluginlist.spy")) {
					
					String string = plugin.getConfig().getString("AntiPlugin.For-OP");
					String string2 = string.replaceAll("%player", player.getName());
					String string3 = string2.replaceAll("&" , "�");
					String message = string3.replaceAll("��" , "&");
					
					p.sendMessage(plugin.sc + message);
					System.out.println(plugin.sc + message);
				}
			}
			
		}
	}

}
