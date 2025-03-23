package me.dev.kuzqi.killassist.utils.config;

import org.bukkit.configuration.file.FileConfiguration;

import net.md_5.bungee.api.ChatColor;

/**
 * @author kuzqi
 */

public enum Messages {
	
    ASSIST("messages.assist-msg"),
    KILL("messages.kill-msg"),
    DEATH("messages.death-msg"),
    RESPAWN("messages.respawn-msg"),
	
    PLUGIN_RELOAD("system.config-reload-msg"),
    NO_PERMISSION("system.no-permission");
	
    private final String message;
    Messages(String message) {
        this.message = message;
    }
    
    public String from(FileConfiguration config) {
        String msg = config.getString(message);
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
