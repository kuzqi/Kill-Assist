package me.dev.kuzqi.killassist.utils.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.dev.kuzqi.killassist.Main;

/**
 * @author kuzqi
 */
public class Configuration {

    private final Main plugin;
    private final File configFile;
    private final File messagesFile;

    private FileConfiguration configConfig;
    private FileConfiguration messagesConfig;

    public Configuration(Main plugin) {
        this.plugin = plugin;
        this.plugin.getDataFolder().mkdirs();
        this.configFile = new File(plugin.getDataFolder() + "/config.yml");
        this.messagesFile = new File(plugin.getDataFolder() + "/messages.yml");
        loadConfigs();
    }

    public FileConfiguration getConfig() {
        return configConfig;
    }

    public FileConfiguration getMessages() {
        return messagesConfig;
    }
    
    public void loadConfigs() {
        configConfig = loadFile(configFile, "config.yml");
        messagesConfig = loadFile(messagesFile, "messages.yml");
    }

    public void reloadConfigs() {
        loadConfigs();
    }

    public void saveConfigs() {
    	loadConfigs();
    }

    private FileConfiguration loadFile(File file, String resourceName) {
        if (!file.exists()) {
            try {
      
                InputStream resourceStream = plugin.getResource(resourceName);
                if (resourceStream == null) {
                    throw new IOException("Resource not found: " + resourceName);
                }
                
                Files.copy(resourceStream, file.toPath());
                System.out.println("[KillAssist] Created new config file: " + resourceName);
                
            } catch (IOException e) {
                System.err.println("[KillAssist] Failed to create config file: " + resourceName + " - " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        return YamlConfiguration.loadConfiguration(file);
    }
    
	public void reloadConfigsCommand(CommandSender cs) {
        if (!(cs.hasPermission("killassist.reload"))) {
            cs.sendMessage(Messages.NO_PERMISSION.from(getMessages()));
            return;
        }

        reloadConfigs();
        cs.sendMessage(Messages.PLUGIN_RELOAD.from(getMessages()));
	}
}