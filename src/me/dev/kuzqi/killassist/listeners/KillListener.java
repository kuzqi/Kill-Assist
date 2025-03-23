package me.dev.kuzqi.killassist.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.dev.kuzqi.killassist.Main;
import me.dev.kuzqi.killassist.utils.config.Messages;

/**
 * @author kuzqi
 */
public class KillListener implements Listener {

    private final Main m;
    public KillListener(Main m) {
         this.m = m;
    }

    @EventHandler
    private void onPlayerKill(PlayerDeathEvent e) {
        if ((!(e.getEntity() instanceof Player)) && (!(e.getEntity().getKiller() instanceof Player))) return;
        
        Player victim = e.getEntity();       Player killer = victim.getKiller();
        	
        sendKillMessage(killer, victim);
        sendDeathMessage(victim, killer);
            
        killer.setHealth(20);
    }

    private void sendKillMessage(Player killer, Player victim) {
        String killMsg = Messages.KILL.from(m.getConfigManager().getMessages())
        .replace("$victim", victim.getDisplayName())
        .replace("$health", String.format("%.1f", killer.getHealth()));
        killer.sendMessage(killMsg);
    }

    private void sendDeathMessage(Player victim, Player killer) {
        String deathMsg = Messages.DEATH.from(m.getConfigManager().getMessages())
        .replace("$killer", killer.getDisplayName());
        victim.sendMessage(deathMsg);
    }
}
