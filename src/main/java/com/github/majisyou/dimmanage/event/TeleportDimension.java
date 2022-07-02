package com.github.majisyou.dimmanage.event;

import com.github.majisyou.dimmanage.DimManage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportDimension implements Listener {
    private static final DimManage plugin = DimManage.getInstance();
    public TeleportDimension(DimManage plugin){plugin.getServer().getPluginManager().registerEvents(this,plugin);}

    @EventHandler
    public static void Teleport(PlayerTeleportEvent event){
        if(event.getTo().getWorld().getName().equals("world_the_end")||event.getTo().getWorld().getName().equals("world_nether")){
            event.getPlayer().sendMessage("このディメンションでは/worldもコンパスも使えないようだ");
        }
    }

}
