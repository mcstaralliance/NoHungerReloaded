package com.mcstaralliance.nohungerreloaded.command;

import com.mcstaralliance.nohungerreloaded.NoHungerReloaded;
import com.mcstaralliance.nohungerreloaded.manager.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class NoHungerCommand implements CommandExecutor {
    public static NoHungerReloaded plugin;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player)sender;
        switch (args[0]) {
            case "switch":
                if (!player.hasPermission("nohunger.switch")) {
                    player.sendMessage(ChatColor.RED + "你没有使用此命令的权限。");
                    return false;
                }
                String name = player.getName();
                if (ConfigManager.getNoHungerList().contains(name)) {
                    ConfigManager.removeNoHunger(name);
                    player.sendMessage(ConfigManager.getNoHungerOffMessage());
                } else {
                    ConfigManager.addNoHunger(name);
                    player.sendMessage(ConfigManager.getNoHungerOnMessage());
                    player.setFoodLevel(20);
                    break;
                }

            case "reload":
                if (!player.isOp()) {
                    player.sendMessage(ChatColor.RED + "你没有使用此命令权限。");
                    return false;
                }
                plugin.reloadConfig();
                player.sendMessage(ChatColor.GREEN + "插件已重载。");
                break;
            case "show":
                sender.sendMessage(ConfigManager.getNoHungerList().toArray(new String[0]));
                break;
        }

        return false;
    }
}
