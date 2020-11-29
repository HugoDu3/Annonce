package fr.jayrex.announcecommand.Manager;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.UUID;

public class CooldownManager {

    public static HashMap<UUID, Long> cooldowns;

    public static void setupCooldown(){
        cooldowns = new HashMap<>();
    }

    public static void setCooldowns(Player player, int minutes){
        long delay = System.currentTimeMillis() + (minutes * 3600);
        cooldowns.put(player.getUniqueId(), delay);

    }

    public static int getCooldowns(Player player){
        return Math.toIntExact(Math.round((cooldowns.get(player.getUniqueId()) - System.currentTimeMillis()/1000)));
    }

    public static boolean checkCooldowns(Player player){
        if(!cooldowns.containsKey(player.getUniqueId()) || cooldowns.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
}