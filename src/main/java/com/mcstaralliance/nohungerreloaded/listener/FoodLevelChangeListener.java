package com.mcstaralliance.nohungerreloaded.listener;

import com.mcstaralliance.nohungerreloaded.manager.ConfigManager;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener {


    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        // if nohunger is on, player can eat foods.
        if (event.getItem() != null) {
            return;
        }
        HumanEntity entity = event.getEntity();
        String name = entity.getName();
        if (!ConfigManager.getNoHungerList().contains(name)) {
            return;
        }
        entity.setFoodLevel(20);
    }
}
