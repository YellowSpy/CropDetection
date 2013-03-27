package com.github.YellowSpy.CropDetection;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CropDetection extends JavaPlugin {
	public Logger logger = Logger.getLogger("Minecraft");
	public PlayerListener pl = new PlayerListener();
	public ArrayList<String> activePlayers = new ArrayList<String>();

	@Override
	public void onDisable() {
		this.logger.info("[" + this.getDescription().getName() + "] "
				+ this.getDescription().getName()
				+ this.getDescription().getVersion() + " has been disabled!");
	}

	@Override
	public void onEnable() {
		logger.info("[" + this.getDescription().getName() + "] "
				+ this.getDescription().getName() + " v"
				+ this.getDescription().getVersion() + "  has been enabled!");
		logger.info("[" + this.getDescription().getName() + "] "
				+ this.getDescription().getName() + " v"
				+ this.getDescription().getVersion() + " Developed by: "
				+ this.getDescription().getAuthors());
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.pl, this);
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		Player player = (Player) sender;
		String playerName = player.getName();

		if (cmd.getName().equalsIgnoreCase("crpon")) {

			if (this.activePlayers.contains(playerName)) {
				player.sendMessage(ChatColor.DARK_RED
						+ "You already have turned on "
						+ this.getDescription().getName());
				return true;
			}

			this.activePlayers.add(playerName);
			
			player.sendMessage(ChatColor.RED + this.getDescription().getName() +" turned on!");
			
		} else if (cmd.getName().equalsIgnoreCase("crpoff")) {

			if (this.activePlayers.contains(playerName) == false) {
				player.sendMessage(ChatColor.DARK_RED
						+ "You don't have turned on "
						+ this.getDescription().getName());
				return true;
			}

			this.activePlayers.remove(playerName);
			
			player.sendMessage(ChatColor.RED + this.getDescription().getName() +" turned off!");
			
		} else if (cmd.getName().equalsIgnoreCase("crp")) {
			player.sendMessage(ChatColor.DARK_GREEN
					+ this.getDescription().getName() + " help.");
			player.sendMessage("Show this help.");
			player.sendMessage("Use " + ChatColor.DARK_GREEN + "/crpon"
					+ ChatColor.WHITE + " to turn on "
					+ this.getDescription().getName() + "!");
			player.sendMessage("Use " + ChatColor.DARK_GREEN + "/crpoff"
					+ ChatColor.WHITE + " to turn off "
					+ this.getDescription().getName() + "!");
		}

		return false;
	}
}
