package gruvexp.gruvexp.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import gruvexp.gruvexp.Main;

public class TNTHandler implements Listener{
    public TNTHandler(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onTNTPlace(BlockPlaceEvent e) {
        Block block = e.getBlock();
        if (block.getType() == Material.TNT) {
            Player p = e.getPlayer();
            Bukkit.getLogger().info(p.getPlayerListName() + " tried to place a TNT, but failed miserably");
            e.setCancelled(true);
        }
    }
}
