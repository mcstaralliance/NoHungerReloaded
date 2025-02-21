package com.mcstaralliance.nohungerreloaded.listener;

import com.mcstaralliance.nohungerreloaded.manager.ConfigManager;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener {


    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        // FoodLevelChangeEvent 无法直接获取到 Player 对象，故使用 HumanEntity 转换
        HumanEntity entity = event.getEntity();
        Player player = (Player) entity;
        String name = player.getName();
        if (!ConfigManager.getNoHungerList().contains(name)) {
            return;
        }
        player.setFoodLevel(20);
    }
}
