package com.github.majisyou.dimmanage.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class World_teleport implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("このコマンドはプレイヤーのみ使います");
            return true;
        }

        Player player = (Player) sender;

        if(!((args.length == 2) && (Bukkit.getWorld(args[1]) instanceof World_teleport))){
           //コマンドの長さが1もしくは3以上の時、また2引数目のworldが存在しないとき
            //guiを開く
            return true;
        }

        Location location = new Location(Bukkit.getWorld(args[2]),0,-1,0);

        if(args[1] == "normal"){
            //MySQLからデータを読み込む
            //MySQLのデータをLocationに代入して
            //teleportを行う
            return true;
        }

        if(args[1] == "lobby"){
            //通常ワールドにいるならMySQLに座標を記録する
            //
            //player.teleport()
            return true;
        }

        if(args[1] == "mining"){
            //通常ワールドにいるならMySQLに座標を記録する
            //
            //player.teleport()
            return true;
        }

        if(args[1] == "building"){
            //通常ワールドにいるならMySQLに座標を記録する
            //
            //player.teleport()
            return true;
        }

        if(args[1] == "normal"){
            //MySQLに座標を記録する
            //
            //player.teleport()

        }

        return true;
    }
}

//メソッドとして、ここに通常ワールドの座標を取ってMySQLに記録するソースを書く





//memo
/**
 * senderはコマンド実行者
 * command　はコマンドの名前
 * **/