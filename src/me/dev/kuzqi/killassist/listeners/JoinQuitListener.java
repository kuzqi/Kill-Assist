package me.dev.kuzqi.killassist.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.dev.kuzqi.killassist.Main;

/**
 * @author kuzqi
 */
public class JoinQuitListener implements Listener {

	private final Main m;
	public JoinQuitListener(Main m) {
	     this.m = m;
	}
	
	@EventHandler
	private void onPlayerJoin(PlayerJoinEvent e) {
    	if (e == null || e.getPlayer() == null) return;
		
    	     Player p = e.getPlayer();
		
	     if (m.damageMap.containsKey(p.getName())) {
		     m.damageMap.remove(p.getName());
	      }
	}
	
	@EventHandler
	private void onPlayerQuit(PlayerQuitEvent e) {
    	if (e == null || e.getPlayer() == null) return;
		
    	     Player p = e.getPlayer();
		
	     if (m.damageMap.containsKey(p.getName())) {
		     m.damageMap.remove(p.getName());
	      }
	}
}
