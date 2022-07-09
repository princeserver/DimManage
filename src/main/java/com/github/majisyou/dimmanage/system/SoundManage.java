package com.github.majisyou.dimmanage.system;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class SoundManage {

    public static void sendSuccess(Player player) {
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1.0F, 0.5F);
    }

    public static void OpenEnder(Player player){
        player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN,SoundCategory.BLOCKS, 1.0F, 1.0F);
    }


}
