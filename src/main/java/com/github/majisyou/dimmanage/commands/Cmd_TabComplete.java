package com.github.majisyou.dimmanage.commands;

import com.github.majisyou.dimmanage.DimManage;
import com.github.majisyou.dimmanage.system.DimSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Cmd_TabComplete implements TabCompleter {
    public Cmd_TabComplete(DimManage plugin){
        plugin.getCommand("world").setTabCompleter(this);
        plugin.getCommand("home").setTabCompleter(this);
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(DimSystem.isBedRock(player)){
                if(command.getName().equals("world")){
                    List<String> worldTab = new ArrayList<>();
                    if(args.length == 1){
                        worldTab.add("lobby");
                        worldTab.add("normal");
                    }
                    return worldTab;
                }
                return null;
            }
        }

        if(command.getName().equals("home")){
            List<String> homeTab = new ArrayList<>();
            if(args.length == 1){
                homeTab.add("teleport");
                homeTab.add("set");
            }
            if(args.length == 2){
                homeTab.add("here");
            }
            return homeTab;
        }
        if(command.getName().equals("world")){
            List<String> worldTab = new ArrayList<>();
            if(args.length == 1){
                worldTab.add("lobby");
                worldTab.add("normal");
                worldTab.add("building");
//                worldTab.add("mining");
            }
            return worldTab;
        }
        return null;
    }
}
