package com.pesach.tutorial.event.player;

import com.pesach.tutorial.tutorial;

import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_12_R1.PlayerConnection;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerJoin
  implements Listener
{
  //private tutorial plugin;
  
  public PlayerJoin(tutorial pl) { /*plugin = pl;*/ }
  
 
  
  
  
  @EventHandler
  public void OnPlayerJoin(PlayerJoinEvent event) {
   // String welcomeMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Welcome Message"));
    
	  
	  Player player = event.getPlayer();
    
	  
	 PacketPlayOutTitle welcomeTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE,
			 ChatSerializer.a("{\"text\":\"Welcome to the Server!\",\"bold\":true,\"italic\":true,\"underlined\":true}\""), 20, 40, 30);
	 PacketPlayOutTitle welcomeSubtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE,
			ChatSerializer.a("{\"text\":\"Enjoy your stay!!\",\"bold\":true,\"italic\":true,\"underlined\":true}"), 20, 40, 30);
	 
	 PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
	 connection.sendPacket(welcomeTitle);
	 connection.sendPacket(welcomeSubtitle);
  }
}
