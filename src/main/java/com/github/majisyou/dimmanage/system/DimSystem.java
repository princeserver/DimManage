package com.github.majisyou.dimmanage.system;

import com.github.majisyou.dimmanage.DimManage;
import com.github.majisyou.dimmanage.MySql.StatusRecord;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;


public class DimSystem {
    private static final DimManage plugin = DimManage.getInstance();
    private static FloodgateApi flood = DimManage.getFloodate();

    public static boolean Teleport(Player player,String worldName){
        ConfigManager.loadWorld(worldName);
        if(ConfigManager.getWorld()==null){
            plugin.getLogger().info("(DM)"+"configに設定されている"+worldName+"のworldが設定されていない");
            return false;
        }
        if(ConfigManager.getWorld().equals("normal")){
            StatusRecord status = new StatusRecord();
            Location loc = status.read(player.getUniqueId(),"normal");
            if(loc == null){
                loc = new Location(Bukkit.getWorld("world"),ConfigManager.getLoc_x(),ConfigManager.getLoc_y(),ConfigManager.getLoc_z(),(float) ConfigManager.getLoc_yaw(),(float) ConfigManager.getLoc_pitch());
            }
            player.teleport(loc);
            SoundManage.sendSuccess(player);
            SendTeleportMessage(player,worldName);
            return true;
        }
        if(Bukkit.getWorld(ConfigManager.getWorld())!=null){
            Location loc = new Location(Bukkit.getWorld(ConfigManager.getWorld()),ConfigManager.getLoc_x(),ConfigManager.getLoc_y(),ConfigManager.getLoc_z(),(float) ConfigManager.getLoc_yaw(),(float) ConfigManager.getLoc_pitch());
            player.teleport(loc);
            SoundManage.sendSuccess(player);
            SendTeleportMessage(player,worldName);
            return true;
        }
        return false;
    }

    public static void HomeRecord(Player player){
        StatusRecord statusRecord = new StatusRecord();
        if(statusRecord.read(player.getUniqueId(),ConfigManager.getDimensions().get(player.getWorld().getName()))==null){
            statusRecord.saveWorld(ConfigManager.getDimensions().get(player.getWorld().getName()),player.getUniqueId(),player.getLocation());
        }else{
            statusRecord.update(ConfigManager.getDimensions().get(player.getWorld().getName()),player.getUniqueId(),player.getLocation());
        }
        plugin.getLogger().info("(DM)"+player.getName()+"が("+player.getWorld().getName()+")ホームを"+"x:"+player.getLocation().getX()+"y:"+player.getLocation().getY()+"z:"+player.getLocation().getZ()+"に設定した");
    }
    public static Location HomeRead(Player player){
        StatusRecord statusRecord = new StatusRecord();
        return statusRecord.read(player.getUniqueId(),ConfigManager.getDimensions().get(player.getWorld().getName()));
    }

    public static void RecordNormal(Player player){
        if(player.getWorld().getName().equals("world")||player.getWorld().getName().equals("world_the_end")||player.getWorld().getName().equals("world_nether")){
            StatusRecord statusRecord = new StatusRecord();
            if(statusRecord.read(player.getUniqueId(),"normal")==null){
                statusRecord.saveWorld("normal",player.getUniqueId(),player.getLocation());
            }else{
                statusRecord.update("normal",player.getUniqueId(),player.getLocation());
            }
        }
    }

    public static boolean isBedRock(Player player){
        return flood.isFloodgatePlayer(player.getUniqueId());
    }

    public static void SendTeleportMessage(Player player, String worldname){
        String name = "設定されていない";
        switch (worldname){
            case "normal" ->{
                name = "通常";
            }
            case "mining" ->{
                name = "採掘";
            }
            case "building" ->{
                name = "建築";
            }
            case "lobby" ->{
                name = "ロビー";
            }
        }
        player.sendMessage("§a[情報]§r§f"+name+"ワールドに移動しました");
    }

    public static double Num10(double num){
        int a = (int) num*10;
        return  (double) a /10;
    }

}
