package com.github.majisyou.dimmanage.commands;

import com.github.majisyou.dimmanage.DimManage;
import com.github.majisyou.dimmanage.system.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Cmd_Dimtest implements CommandExecutor{
    DimManage plugin = DimManage.getInstance();
    public Cmd_Dimtest(DimManage plugin){plugin.getCommand("Dimtest").setExecutor(this);}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage(ConfigManager.getDimensions().keySet()+"のkeySet");
        sender.sendMessage(ConfigManager.getHost());
        sender.sendMessage(ConfigManager.getWorld());
        sender.sendMessage(ConfigManager.getUserName());
        return true;
    }
}
