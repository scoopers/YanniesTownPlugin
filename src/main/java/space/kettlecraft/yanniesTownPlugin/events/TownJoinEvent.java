package space.kettlecraft.yanniesTownPlugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import space.kettlecraft.yanniesTownPlugin.Global;

public class TownJoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        Location loc = player.getLocation();
        world.spawnParticle(Particle.CLOUD, loc, 10);
        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + String.format("Welcome to %s!", Global.serverName));
		player.sendMessage(ChatColor.AQUA + "If you are new, then please review the rules with /rules.");
    }
}
