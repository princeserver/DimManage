package com.github.majisyou.dimmanage.system;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.security.PKCS12Attribute;

public class System {

    public void world_teleport(@NotNull Player player,Location teleport_location){
        if(player.getWorld() == teleport_location.getWorld())  return;
        //同一ワールドを選択した場合は何も起きない

        if (player.getWorld().getName() == "normal"){
            //normalワールドにいる場合
            //MySQLに座標を送信する
        }
        player.teleport(teleport_location);
    }

    public Location select_world(String world_name){
        if(!(Bukkit.getWorld(world_name)==null)){
            //この先に各ワールドの名前毎にテレポートするコマンドを付けたい
            if (world_name.equals("lobby")) return new Location(Bukkit.getWorld(world_name),0,-1,0);
            if (world_name=="mining") return new Location(Bukkit.getWorld(world_name),0,-1,0);
            if (world_name=="building") return new Location(Bukkit.getWorld(world_name),0,-1,0);
            if (world_name=="normal") return new Location(Bukkit.getWorld(world_name),0,-1,0);
            //ここconfigから持ってこられんかな？
        }

        return null;
    }

}
