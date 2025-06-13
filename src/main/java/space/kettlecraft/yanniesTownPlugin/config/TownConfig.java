package space.kettlecraft.yanniesTownPlugin.config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

import space.kettlecraft.yanniesTownPlugin.Global;
import space.kettlecraft.yanniesTownPlugin.YanniesTownPlugin;

/**
 * This class will handle the plugin server configuration file.
 */
public class TownConfig {

    private YanniesTownPlugin plugin;

    private FileConfiguration config;

    /**
     * Sets up the class for reading and writing the config.
     * 
     * @param plugin Grab a reference of the plugin to get and read the config.
     */
    public TownConfig(YanniesTownPlugin plugin) {
        this.plugin = plugin;
        config = plugin.getConfig();
    }

    /**
     * Generates the config.yml if one is not present.
     */
    public void genConfig() {
        File file = new File(plugin.getDataFolder() + "/plugin.yml");
        //If the plugin.yml file exists then abort.
        if (file.exists())
            return;
        
        config.addDefault("server-name", "Ratelite");
        config.options().copyDefaults(true);
        plugin.saveConfig();
    }

    public void start() {
        getServerName();
    }

    public void getServerName() {
        //Check to see if it exists in the config.
        if(!config.contains("server-name"))
            return;
        //Set the global variable
        Global.serverName = config.getString("server-name");
    }
}
