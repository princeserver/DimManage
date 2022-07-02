package com.github.majisyou.dimmanage.commands;

import com.github.majisyou.dimmanage.DimManage;
import com.github.majisyou.dimmanage.system.ConfigManager;
import com.github.majisyou.dimmanage.system.DimSystem;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class Cmd_Home implements CommandExecutor {
    DimManage plugin = DimManage.getInstance();
    public Cmd_Home(DimManage plugin){plugin.getCommand("home").setExecutor(this);}


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if(!sender.hasPermission("Dim.User")){
                return false;
            }

            if (ConfigManager.getDimensions().get(player.getWorld().getName()).equals("building") || ConfigManager.getDimensions().get(player.getWorld().getName()).equals("mining")) {
                if (args.length == 1) {
                    if (args[0].equals("teleport")) {
                        Location loc = DimSystem.HomeRead(player);
                        if (loc == null) {
                            player.sendMessage("homeを設定してください");
                            return true;
                        }
                        player.teleport(loc);
                        return true;
                    }
                }
                if (args.length == 2) {
                    if (args[0].equals("set")) {
                        if (args[1].equals("here")) {
                            DimSystem.HomeRecord(player);
                            player.sendMessage("homeを" + "x:" + player.getLocation().getX() + "y:" + player.getLocation().getY() + "z:" + player.getLocation().getZ() + "に設定した");
                            return true;
                        }
                    }
                }
                player.sendMessage("コマンドは/home set here もしくは /home teleport です");
                return true;
            }
            player.sendMessage("このディメンションではhomeを使うことができません");
            return true;
        }
        sender.sendMessage("これはコンソールから打てません");
        return true;
    }

}
