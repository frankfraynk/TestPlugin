package com.pesach.tutorial.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.world.SpawnChangeEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import net.minecraft.server.v1_12_R1.EntitySkeleton;
import net.minecraft.server.v1_12_R1.WorldServer;

public class Skeleton implements CommandExecutor {

 @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	if(!(sender instanceof Player)) {
		sender.sendMessage("You must be a player to use this command.");
		return false;
	}
	
	Player p = (Player) sender;
	Location l = p.getLocation();
	World world = p.getWorld();
	
	
	ItemStack diamondSword =  new ItemStack(276);
		diamondSword.addEnchantment(Enchantment.FIRE_ASPECT, 1);
		diamondSword.addEnchantment(Enchantment.KNOCKBACK, 1);
		diamondSword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	
	
	
	ItemStack diamondHelmet = new ItemStack(310);
		diamondHelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		diamondHelmet.addEnchantment(Enchantment.THORNS, 1);
	
	
	
	ItemStack diamondChest = new ItemStack(311);
		diamondChest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		diamondChest.addEnchantment(Enchantment.THORNS, 1);
	
	
	ItemStack diamondLeggings = new ItemStack(312);
		diamondLeggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		diamondLeggings.addEnchantment(Enchantment.THORNS, 1);
	
	
	ItemStack diamondBoots = new ItemStack(313);
		diamondBoots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
		diamondBoots.addEnchantment(Enchantment.THORNS, 1);
	
	
	LivingEntity zombo = (LivingEntity) l.getWorld().spawnEntity(l, EntityType.ZOMBIE);
	
		EntityEquipment equipment =  zombo.getEquipment();
	
	
		zombo.setCustomName(ChatColor.RED + "ZomboBombo");
		zombo.setCustomNameVisible(true);
		zombo.setMaxHealth(50);
		zombo.setHealth(50);
		//equipment.setItemInMainHand(diamondSword);
		//equipment.setHelmet(diamondHelmet);
		//equipment.setChestplate(diamondChest);
		//equipment.setLeggings(diamondLeggings);
		//equipment.setBoots(diamondBoots);
			while(zombo.getHealth() != 0) {
		
		
		
					if(zombo.getHealth() <= 25) {
			
			
			
						((LivingEntity) getNearbyPlayers(zombo)).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 600, 0));
						((Player) getNearbyPlayers(zombo)).sendMessage("You have been confused!!");
		}
	}
	return true;
	
 }

 private ItemStack nameItem(ItemStack item, String name) {
	    ItemMeta meta = item.getItemMeta();
	    meta.setDisplayName(name);
	    item.setItemMeta(meta);
	    return item;
	  }
	  
	  public ArrayList<Player> getNearbyPlayers(LivingEntity pl) {
		  ArrayList<Player> nearby = new ArrayList<Player>();
		  double range = 50;
		  for (Entity e : pl.getNearbyEntities(range, range, range)) {
			  
			  if(e instanceof Player) {
				  nearby.add((Player) e); 
			  }
		  }
		  return nearby;
	  }
}