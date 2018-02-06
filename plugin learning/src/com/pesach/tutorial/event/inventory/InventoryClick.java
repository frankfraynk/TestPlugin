package com.pesach.tutorial.event.inventory;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import net.minecraft.server.v1_12_R1.ItemStack;

public class InventoryClick implements Listener {
@EventHandler
public void onInventoryClick(InventoryClickEvent event) {
	
	
	
	Inventory inv = event.getInventory();
	if(!inv.getTitle().equals("Custom Inventory")) {
	return;
	}
	
	
	Player p = (Player) event.getWhoClicked();
	org.bukkit.inventory.ItemStack item = event.getCurrentItem();
	
	if(item.getType() == Material.COMPASS) {
		p.teleport(p.getWorld().getSpawnLocation());
		p.sendMessage("You have been teleported to spawn.");
		
		
		p.getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 1);
		
		
	}
	event.setCancelled(true);
	p.closeInventory();
}
}
