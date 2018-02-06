package com.pesach.tutorial;

import com.pesach.tutorial.event.block.blockBreak;
import com.pesach.tutorial.event.inventory.InventoryClick;

import java.util.logging.Logger;
import org.bukkit.Server;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;

public class tutorial extends org.bukkit.plugin.java.JavaPlugin
{
  public tutorial() {}
  
  public void onEnable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    Logger logger = getLogger();
    registerCommands();
    registerEvents();
    registerConfig();
    registerPerms();
    logger.info(pdfFile.getName() + " has been enabled!  (V." + pdfFile.getVersion() + ")");
  }
  
  public void onDisable() {
    PluginDescriptionFile pdfFile = getDescription();
    Logger logger = getLogger();
    
    logger.info(pdfFile.getName() + " has been disabled!  (V." + pdfFile.getVersion() + ")");
    
    
  }
  
  public void registerCommands() {
    getCommand("staff").setExecutor(new com.pesach.tutorial.commands.Staff(this));
    getCommand("menu").setExecutor(new com.pesach.tutorial.commands.Menu());
    getCommand("info").setExecutor(new com.pesach.tutorial.commands.Info());
    getCommand("skeleton").setExecutor(new com.pesach.tutorial.commands.Skeleton());
  }
  
  public void registerEvents() {
    PluginManager pm = getServer().getPluginManager();
    
    pm.registerEvents(new blockBreak(), this);
    pm.registerEvents(new com.pesach.tutorial.event.player.PlayerChat(), this);
    pm.registerEvents(new com.pesach.tutorial.event.player.PlayerJoin(this), this);
    pm.registerEvents(new com.pesach.tutorial.event.inventory.InventoryClick(), this);
    pm.registerEvents(new com.pesach.tutorial.event.other.ProjectileHit(), this);
    
  }
  
  private void registerConfig() {
    getConfig().options().copyDefaults(true);
    saveConfig();
  }
  
  
  private void registerPerms() {
	  Permission p = new Permission("FrankFraynk.snowball");
	  PluginManager pm = getServer().getPluginManager();
	  pm.addPermission(p);
	  
  }
}
