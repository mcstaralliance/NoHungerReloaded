package com.mcstaralliance.nohungerreloaded.command;

import com.mcstaralliance.nohungerreloaded.NoHungerReloaded;
import com.mcstaralliance.nohungerreloaded.manager.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;


public class NoHungerCommand implements CommandExecutor, TabCompleter {
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
                    return true;
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

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            List<String> subCommands = List.of("switch", "reload", "show");
            for (String subCommand : subCommands) {
                if (subCommand.toLowerCase().startsWith(args[0].toLowerCase())) {
                    completions.add(subCommand);
                }
            }
        }
        return completions;
    }
}
