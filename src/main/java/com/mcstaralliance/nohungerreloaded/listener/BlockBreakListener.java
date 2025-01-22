package com.mcstaralliance.nohungerreloaded.listener;

import com.mcstaralliance.nohungerreloaded.manager.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        String name = player.getName();
        if (!ConfigManager.getNoHungerList().contains(name)) {
            return;
        }
        player.setFoodLevel(20);
    }
}
