package com.mcstaralliance.nohungerreloaded.manager;

import com.mcstaralliance.nohungerreloaded.NoHungerReloaded;

import java.util.*;

public class ConfigManager {
    private static final NoHungerReloaded plugin = NoHungerReloaded.getInstance();

    public static boolean addNoHunger(String name) {
        List<String> nameList = plugin.getConfig().getStringList("no-hunger-player");
        Set<String> nameSet = new HashSet<>(nameList);
        final boolean added = nameSet.add(name);
        nameList = new ArrayList<>(nameSet);
        plugin.getConfig().set("no-hunger-player", nameList);
        plugin.saveConfig();
        return added;
    }

    public static boolean removeNoHunger(String name) {
        List<String> nameList = plugin.getConfig().getStringList("no-hunger-player");
        boolean removed = nameList.remove(name);
        plugin.getConfig().set("no-hunger-player", nameList);
        plugin.saveConfig();
        return removed;
    }

    public static List<String> getNoHungerList() {
        return plugin.getConfig().getStringList("no-hunger-player");
    }

    private static String getMessage(String key) {
        return plugin.getConfig().getString(key);
    }

    public static String getNoHungerOnMessage() {
        return getMessage("no-hunger-on-message");
    }

    public static String getNoHungerOffMessage() {
        return getMessage("no-hunger-off-message");
    }
}
