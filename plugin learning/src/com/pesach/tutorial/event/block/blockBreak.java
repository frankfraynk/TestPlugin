package com.pesach.tutorial.event.block;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;

public class blockBreak implements org.bukkit.event.Listener
{
  public blockBreak() {}
  
  @org.bukkit.event.EventHandler
  public void onBlockBreak(BlockBreakEvent event)
  {
    org.bukkit.entity.Player player = event.getPlayer();
    
    Block block = event.getBlock();
    Material material = block.getType();
    if (material != Material.GRASS) {
      event.setCancelled(true);
      player.sendMessage(org.bukkit.ChatColor.RED + "You can only break grass!!!");
    }
  }
}