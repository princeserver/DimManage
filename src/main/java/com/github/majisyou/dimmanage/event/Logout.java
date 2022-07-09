package com.github.majisyou.dimmanage.event;

import com.github.majisyou.dimmanage.DimManage;
import com.github.majisyou.dimmanage.system.DimSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Logout implements Listener {

    private static final DimManage plugin = DimManage.getInstance();
    public Logout(DimManage plugin){plugin.getServer().getPluginManager().registerEvents(this,plugin);}

    @EventHandler
    public void record_location(PlayerQuitEvent event){
//        if(event.getPlayer().getVehicle()!=null){
//            event.getPlayer().getVehicle().removePassenger(event.getPlayer());
//        }
        DimSystem.RecordNormal(event.getPlayer());
    }

}
