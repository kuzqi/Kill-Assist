package me.dev.kuzqi.killassist.utils;

import net.md_5.bungee.api.ChatColor;

/**
 * @author kuzqi
 */
public class TextUtils {

	public String Colorize(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
}
