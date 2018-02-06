package com.pesach.tutorial.event.player;

import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements org.bukkit.event.Listener
{
  public PlayerChat() {}
  
  @org.bukkit.event.EventHandler
  public void onPlayerChat(AsyncPlayerChatEvent event)
  {
    org.bukkit.entity.Player player = event.getPlayer();
    String message = event.getMessage().toLowerCase();
    if (message.contains("banana")) {
      event.setCancelled(true);
      player.sendMessage(org.bukkit.ChatColor.RED + "You said a naughty word! Reconsider saying that in the future.");
    }
  }
}