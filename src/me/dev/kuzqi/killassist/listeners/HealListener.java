package me.dev.kuzqi.killassist.listeners;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

import me.dev.kuzqi.killassist.Main;

/**
 * @author kuzqi
 */
public class HealListener implements Listener {

    private final Main m;
    public HealListener(Main m) {
    	this.m = m;
    }
    
	@EventHandler
	private void onEntityHealthRegain(EntityRegainHealthEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        
        Player p = (Player)e.getEntity();
        String playerName = p.getName();
        
        if (m.damageMap.containsKey(playerName)) {
        	
            HashMap<String, Double> attackersMap = m.damageMap.get(playerName);
            #########################

            attackersMap.entrySet().removeIf(attackerEntry -> {
                double damageDealt = attackerEntry.getValue();
 
            });
        }
    }
}
