package com.github.majisyou.dimmanage.event;

import com.github.majisyou.dimmanage.DimManage;
import com.github.majisyou.dimmanage.gui.Gui;
import com.github.majisyou.dimmanage.system.ConfigManager;
import com.github.majisyou.dimmanage.system.SoundManage;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.DuplicateFormatFlagsException;

import static org.bukkit.event.block.Action.RIGHT_CLICK_AIR;
import static org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK;

public class PlayerRightClick implements Listener {
    private static final DimManage plugin = DimManage.getInstance();
    public PlayerRightClick(DimManage plugin){plugin.getServer().getPluginManager().registerEvents(this,plugin);}

    @EventHandler
    public static void PlayerInteractEvent(PlayerInteractEvent event){

        if(event.getAction() == RIGHT_CLICK_AIR || event.getAction() == RIGHT_CLICK_BLOCK) {
            if(event.getAction() == RIGHT_CLICK_BLOCK){
                if(event.getClickedBlock().getType().equals(Material.ENDER_CHEST)||event.getClickedBlock().getType().equals(Material.ANVIL)||event.getClickedBlock().getType().equals(Material.DAMAGED_ANVIL)||event.getClickedBlock().getType().equals(Material.CHIPPED_ANVIL)||event.getClickedBlock().getType().equals(Material.GRINDSTONE)||event.getClickedBlock().getType().equals(Material.LODESTONE)){
                    return;
                }
            }

            if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.COMPASS)){
                if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()){
                    return;
                }
                if(event.getPlayer().getWorld().getName().equals("world_the_end")||event.getPlayer().getWorld().getName().equals("world_nether")){
                    event.getPlayer().sendMessage("このディメンションではコンパスを使うことができない");
                    return;
                }
                if(ConfigManager.getDimensions().containsKey(event.getPlayer().getWorld().getName())){
                    String DimName =  ConfigManager.getDimensions().get(event.getPlayer().getWorld().getName());
                    Gui.OpenDimGui(DimName,event.getPlayer());
                    SoundManage.OpenEnder(event.getPlayer());
                }else {
                    plugin.getLogger().info("(DM)"+"プレイヤーの存在するワールドがconfigに登録されていない："+event.getPlayer().getWorld().getName());
                    event.getPlayer().sendMessage("Guiを開けませんでした");
                }
            }
        }
    }
}
