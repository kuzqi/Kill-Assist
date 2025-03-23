package me.dev.kuzqi.killassist.utils.plugin;
import me.dev.kuzqi.killassist.Main;
import me.dev.kuzqi.killassist.commands.ReloadCommand;
import me.dev.kuzqi.killassist.listeners.DamageListener;
import me.dev.kuzqi.killassist.listeners.DeathListener;
import me.dev.kuzqi.killassist.listeners.HealListener;
import me.dev.kuzqi.killassist.listeners.JoinQuitListener;
import me.dev.kuzqi.killassist.listeners.KillListener;
import me.dev.kuzqi.killassist.listeners.RespawnListener;

/**
 * @author kuzqi
 */
public class PluginLoader {

	private final Main m;
	public PluginLoader(Main m) {
	     this.m = m;
	}
	
	public void loadThePlugin() {
	     m.getConfigManager().loadConfigs();
	     RegisterListeners();
	     RegisterCommands();
	}
	
	public void unLoadThePlugin() {
	     m.damageMap.clear();
	     m.getConfigManager().saveConfigs();
	}
	
	private void RegisterListeners() {
	     m.getServer().getPluginManager().registerEvents(new DamageListener(m), m);
	     m.getServer().getPluginManager().registerEvents(new DeathListener(m), m);
	     m.getServer().getPluginManager().registerEvents(new HealListener(m), m);
	     m.getServer().getPluginManager().registerEvents(new JoinQuitListener(m), m);
             m.getServer().getPluginManager().registerEvents(new KillListener(m), m);
             m.getServer().getPluginManager().registerEvents(new RespawnListener(m), m);
	}
	
	private void RegisterCommands() {
	     m.getCommand("kareload").setExecutor(new ReloadCommand(m));
	     m.getCommand("kar").setExecutor(new ReloadCommand(m));
	}
}
