package com.github.YellowSpy.CropDetection;

import org.bukkit.ChatColor;
import org.bukkit.CropState;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Crops;

public class PlayerListener implements Listener {
	public CropDetection plugin;

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Block block = p.getTargetBlock(null, 0);

			if (event.getAction() == Action.RIGHT_CLICK_BLOCK
					& block.getType() == Material.CROPS) {
				Crops crops = (Crops) block.getState().getData();
				if (crops.getState() == CropState.SEEDED) {
					p.sendMessage(ChatColor.DARK_RED
							+ "You have just seeded the crop!");
				} else if (crops.getState() == CropState.GERMINATED) {
					p.sendMessage(ChatColor.RED + "The crop is germinated!");
				} else if (crops.getState() == CropState.SMALL) {
					p.sendMessage(ChatColor.GOLD + "The crop is small!");
				} else if (crops.getState() == CropState.MEDIUM) {
					p.sendMessage(ChatColor.LIGHT_PURPLE
							+ "The crop is medium!");
				} else if (crops.getState() == CropState.RIPE) {
					p.sendMessage(ChatColor.GREEN
							+ "The crop can be harvested!");
				} else if (crops.getState() == CropState.TALL) {
					p.sendMessage(ChatColor.YELLOW + "The crop is tall!");
				} else if (crops.getState() == CropState.VERY_SMALL) {
					p.sendMessage(ChatColor.GOLD + "The crop is very small!");
				} else if (crops.getState() == CropState.VERY_TALL) {
					p.sendMessage(ChatColor.DARK_GREEN
							+ "The crop is very tall!");
				}
			}

	}
}