package me.dev.kuzqi.killassist.listeners;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.dev.kuzqi.killassist.Main;
import me.dev.kuzqi.killassist.utils.config.Messages;

/**
 * @author kuzqi
 */
public class DeathListener implements Listener {

    private final Main m;
    public DeathListener(Main m) {
        this.m = m;
    }

    @EventHandler
    private void onPlayerDeath(PlayerDeathEvent e) {
        if ((!(e.getEntity() instanceof Player)) && (!(e.getEntity().getKiller() instanceof Player))) return;
        
            Player victim = e.getEntity();
            Player killer = victim.getKiller();
            String victimName = victim.getName();

            if (m.damageMap.containsKey(victimName)) {
                HashMap<String, Double> attackers = m.damageMap.get(victimName);
                
                double totalDamage = attackers.values().############################();
                
                    if (killer == attacker) {
                        return;
                    }
                    
                    if (attacker != null && !attacker.equals(victim) && attacker.isOnline() && !attacker.isDead()) {
                    		
                        attacker.setHealth(Math.min(attacker.getHealth() + healAmount, attacker.getMaxHealth()));

                        String assistMsg = Messages.ASSIST.from(m.getConfigManager().getMessages());
                        String formattedAssistMsg = formatAssistMessage(assistMsg, victim.getDisplayName(), ########, healAmount);
                        attacker.sendMessage(formattedAssistMsg);
                    }
                });
                
                m.damageMap.remove(victimName);
            }
        
    }
    
    private String formatAssistMessage(String messageTemplate, String victimName, double assistPercent, double healAmount) {
        return messageTemplate
            .replace("$victim", victimName)
            .replace("$assist", String.format("%.1f", assistPercent))
            .replace("$hearts", String.format("%.1f", healAmount));
    }
}
