package fr.jayrex.announcecommand.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.jayrex.announcecommand.Manager.CooldownManager;

public class AnnounceCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(CooldownManager.checkCooldowns(player.getPlayer())){
                CooldownManager.setCooldowns(player.getPlayer(), 10);

                if (cmd.getName().equalsIgnoreCase("annonce")){
                	if(args.length >= 1){
                	String message = "";
                	for (String part : args) {
                	if (message != "") message += " ";
                	message += part;
                	}
                	Bukkit.getServer().broadcastMessage("§c§lShop§8➤ §7 " + message);
                	 
                	}
                	}
            }else{
                player.getPlayer().sendMessage("§cVous pourrez refaire une annonce dans " + CooldownManager.getCooldowns(player.getPlayer()) + " minutes");
            }

            }
            return true;
        }
    }