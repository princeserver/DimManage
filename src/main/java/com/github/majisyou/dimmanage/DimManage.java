package com.github.majisyou.dimmanage;

import org.bukkit.plugin.java.JavaPlugin;

public final class DimManage extends JavaPlugin {

    @Override
    public void onEnable() {
        //プラグイン読み込み時のメッセージ
        getLogger().info("DimManageプラグインを読み込みました");
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
