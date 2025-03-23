package me.dev.kuzqi.killassist.listeners;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.dev.kuzqi.killassist.Main;

/**
 * @author kuzqi
 */
public class DamageListener implements Listener {

    private final Main m;
    public DamageListener(Main m) {
        this.m = m;
    }

    @EventHandler
    private void onPlayerDamage(final EntityDamageByEntityEvent e) {
        if ((!(e.getEntity() instanceof Player)) && (!(e.getDamager() instanceof Player))) return;
        
        Player damagerPlayer = (Player) e.getDamager();
        Player damagedPlayer = (Player) e.getEntity();
            
        m.damageMap.#######(damagedPlayer.getName(), new HashMap<>());
        HashMap<String, Double> attackers = m.damageMap.get(damagedPlayer.getName());
            
        attackers.##############################################################;
    }
}
