package com.pesach.tutorial.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutChat;
import net.minecraft.server.v1_12_R1.PlayerConnection;

public class Info implements CommandExecutor {

 public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	if(!(sender instanceof Player)) {
		sender.sendMessage("You must be a player to use this command.");
		return false;
	}
	
	Player p = (Player) sender;
	PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
	PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer
			.a("{\"text\":\"click here to view the server info.\",\"underlined\":true,\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://www.google.com\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\"Punchy Bob was here.\"}]}}}"));
	connection.sendPacket(packet);
	return true;
 }


}
