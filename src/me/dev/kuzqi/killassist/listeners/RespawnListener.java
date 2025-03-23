package me.dev.kuzqi.killassist.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.dev.kuzqi.killassist.Main;

/**
 * @author kuzqi
 */
public class RespawnListener implements Listener {

    private final Main m;
    public RespawnListener(Main m) {
         this.m = m;
    }
    
    @EventHandler
    private void onPlayerRespawn(PlayerRespawnEvent e) {
    	if (e == null || e.getPlayer() == null) return;
        
    	Player p = e.getPlayer();
        
    	if (m.damageMap.containsKey(p.getName())) {
    	    m.damageMap.remove(p.getName());
    	}
    }
}
