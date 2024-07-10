package eu.xap3y.example.plugin.listener;

import eu.xap3y.example.plugin.Plugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().getInventory().addItem(Plugin.item);
    }
}
