package com.pesach.tutorial.commands;

import com.pesach.tutorial.tutorial;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


public class Staff
  implements CommandExecutor
{
  private tutorial plugin;
  
  public Staff(tutorial pl) { plugin = pl; }
  
  @SuppressWarnings("deprecation")
public String online(String player) {
    String onlineChk = "";
    Player p = Bukkit.getPlayerExact(player);
    if (p == null) {
      onlineChk = ChatColor.RED + "OFFLINE";
    } else if(p.isOnline())
      onlineChk = ChatColor.GREEN + "ONLINE";
    return onlineChk;
  }
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (label.equalsIgnoreCase("staff")) {
      if (!(sender instanceof Player)) {
        sender.sendMessage("You must be a player to use this command!");
        return false;
      }
      
      Player player = (Player)sender;
      player.sendMessage(ChatColor.RED + "Hello, " + player.getName() + ", here are the current staff.");
      
      List<String> ServerAdmins = plugin.getConfig().getStringList("Server Admins");
      for (String admin : ServerAdmins)
      {
        player.sendMessage(admin + ": " + online(admin));
      }
    }
    

    return false;
  }
}