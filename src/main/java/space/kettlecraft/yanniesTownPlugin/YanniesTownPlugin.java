package space.kettlecraft.yanniesTownPlugin;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import space.kettlecraft.yanniesTownPlugin.config.TownConfig;
import space.kettlecraft.yanniesTownPlugin.events.TownJoinEvent;

public final class YanniesTownPlugin extends JavaPlugin {
	
	public TownConfig tConfig;

	public Logger log = Bukkit.getLogger();

	@Override
	public void onEnable() {
		//Use the TownConfig to handle config.yml
		tConfig = new TownConfig(this);
		//Generate the config
		tConfig.genConfig();
		//Load the variables from the config.
		tConfig.start();
		//Register Event
		registerEvents();
		//Register Commands
		registerCommands();
	}
	
	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	/*
	 * Register main server events
	 */
	public void registerEvents() {
		getServer().getPluginManager().registerEvents(new TownJoinEvent(), this);
	}

	/*
	 * Register commands
	 */
	public void registerCommands() {

	}

}
