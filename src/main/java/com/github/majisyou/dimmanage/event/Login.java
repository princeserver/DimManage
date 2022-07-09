package com.github.majisyou.dimmanage.event;

import com.github.majisyou.dimmanage.DimManage;
import com.github.majisyou.dimmanage.system.DimSystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class Login implements Listener {
    private static final DimManage plugin = DimManage.getInstance();
    public Login(DimManage plugin){plugin.getServer().getPluginManager().registerEvents(this,plugin);}

    @EventHandler
    public static void PlayerLogin(PlayerJoinEvent event){
        if(!event.getPlayer().getWorld().getName().equals("world_the_end")&& !event.getPlayer().getWorld().getName().equals("world_nether")){
           if(!DimSystem.Teleport(event.getPlayer(),"lobby")){
               event.getPlayer().sendMessage("lobbyにテレポートできなかった");
               plugin.getLogger().info("(DM)"+event.getPlayer().getName()+"がログインするときロビーにテレポートできなかった");
           }
        }
    }
}
