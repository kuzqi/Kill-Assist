package me.dev.kuzqi.killassist.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.dev.kuzqi.killassist.Main;

/**
 * @author kuzqi
 */
public class ReloadCommand implements CommandExecutor {

    private final Main m;
    public ReloadCommand(Main main) {
    	this.m = main;
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String command, String[] args) {
        if (command.equalsIgnoreCase("kareload") || command.equalsIgnoreCase("kar")) {
        	m.getConfigManager().reloadConfigsCommand(cs);
        }
        return false;
    }
}