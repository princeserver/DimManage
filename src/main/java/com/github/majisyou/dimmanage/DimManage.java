package com.github.majisyou.dimmanage;

import com.github.majisyou.dimmanage.MySql.StatusRecord;
import com.github.majisyou.dimmanage.commands.Cmd_Home;
import com.github.majisyou.dimmanage.commands.Cmd_TabComplete;
import com.github.majisyou.dimmanage.commands.Cmd_World_teleport;
import com.github.majisyou.dimmanage.event.*;
import com.github.majisyou.dimmanage.system.ConfigManager;
import com.github.majisyou.dimmanage.system.DimSystem;
import org.bukkit.plugin.java.JavaPlugin;

public final class DimManage extends JavaPlugin {

    private static DimManage instance;
    public DimManage(){
        instance = this;
    }
    public static DimManage getInstance(){
        return instance;
    }


    @Override
    public void onEnable() {
        //プラグイン読み込み時のメッセージ
        saveDefaultConfig();
        ConfigManager.loadConfig();
        //command
        new Cmd_World_teleport(this);
        new Cmd_Home(this);
        new Cmd_TabComplete(this);

        //event
        new PlayerRightClick(this);
        new Logout(this);
        new InventoryClick(this);
        new Login(this);
        new TeleportDimension(this);


        getLogger().info("DimManageプラグインを読み込みました");
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        getLogger().info("DimManageプラグインを停止した");
        // Plugin shutdown logic
    }
}
