package com.github.majisyou.dimmanage.commands;

import com.github.majisyou.dimmanage.DimManage;
import com.github.majisyou.dimmanage.MySql.StatusRecord;
import com.github.majisyou.dimmanage.gui.Gui;
import com.github.majisyou.dimmanage.system.ConfigManager;
import com.github.majisyou.dimmanage.system.DimSystem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Cmd_World_teleport implements CommandExecutor {
    DimManage plugin = DimManage.getInstance();
    public Cmd_World_teleport(DimManage plugin){plugin.getCommand("world").setExecutor(this);}


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player player)){
            sender.sendMessage("このコマンドはプレイヤーのみ使います");
            return true;
        }

        if(!sender.hasPermission("Dim.User")){
            return false;
        }

        if(player.getWorld().getName().equals("world_the_end")||player.getWorld().getName().equals("world_nether")){
            player.sendMessage("このディメンションでは/worldは使えない");
            return true;
        }

        if(!(args.length == 1)){
           //コマンドの長さが1もしくは3以上の時、また2引数目のworldが存在しないとき
            //guiを開く
            if(ConfigManager.getDimensions().containsKey(player.getWorld().getName())){
                String DimName =  ConfigManager.getDimensions().get(player.getWorld().getName());
                Gui.OpenDimGui(DimName,player);
            }else {
                plugin.getLogger().info("(DM)"+"プレイヤーの存在するワールドがconfigに登録されていない："+player.getWorld().getName());
                player.sendMessage("Guiを開けませんでした");
            }
            return true;
        }
//
//        if(Objects.equals(args[1], "normal")){
//            //MySQLからデータを読み込む
//            //MySQLのデータをLocationに代入して
//            //teleportを行う
//            return true;
//        }

        if(args[0].equals("lobby") || args[0].equals("mining") || args[0].equals("building") || args[0].equals("normal")){
            DimSystem.RecordNormal(player);
            DimSystem.Teleport(player,args[0]);
        }

//        sender.sendMessage(args[1]);

        return true;
    }
}

//メソッドとして、ここに通常ワールドの座標を取ってMySQLに記録するソースを書く





//memo
/**
 * senderはコマンド実行者
 * command　はコマンドの名前
 * **/