package me.dev.kuzqi.killassist;

import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

import me.dev.kuzqi.killassist.utils.config.Configuration;
import me.dev.kuzqi.killassist.utils.plugin.PluginLoader;

/**
 * @author kuzqi
 */
public final class Main extends JavaPlugin {
	
    public final HashMap<String, HashMap<String, Double>> damageMap = new HashMap<>();
    
    private PluginLoader pluginloader;
    private Configuration configmanager;

    @Override
    public void onEnable() {
	this.configmanager = new Configuration(this);
	this.pluginloader = new PluginLoader(this);
	getPluginloader().loadThePlugin();
    }
	
    @Override
    public void onDisable() {
	getPluginloader().unLoadThePlugin();
    }
		
     public Configuration getConfigManager() {
	return this.configmanager;
     }
	
     public PluginLoader getPluginloader() {
	return this.pluginloader;
     }
}
