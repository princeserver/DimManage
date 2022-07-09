package com.github.majisyou.dimmanage.event;

import com.github.majisyou.dimmanage.DimManage;
import com.github.majisyou.dimmanage.gui.Gui;
import com.github.majisyou.dimmanage.system.ConfigManager;
import com.github.majisyou.dimmanage.system.DimSystem;
import com.github.majisyou.dimmanage.system.SoundManage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryClick implements Listener {
    private static final DimManage plugin = DimManage.getInstance();
    public InventoryClick(DimManage plugin){plugin.getServer().getPluginManager().registerEvents(this,plugin);}


    @EventHandler
    public static void DimClick(InventoryClickEvent event){
        if(event.getView().getTitle().equals("ワールドを移動する")){
            if(event.getCurrentItem()!=null){
                event.setCancelled(true);
                if(!event.getClickedInventory().getType().equals(InventoryType.PLAYER)){
                    if(event.getSlot()==3){
                        event.getWhoClicked().closeInventory();
                        DimSystem.RecordNormal((Player) event.getWhoClicked());
                        DimSystem.Teleport((Player) event.getWhoClicked(),"lobby");
                        plugin.getLogger().info("(DM)"+event.getWhoClicked().getName()+"がlobbyに移動した");
                    }
                    if(event.getSlot()==4){
                        event.getWhoClicked().closeInventory();
                        DimSystem.RecordNormal((Player) event.getWhoClicked());
                        DimSystem.Teleport((Player) event.getWhoClicked(),"building");
                        plugin.getLogger().info("(DM)"+event.getWhoClicked().getName()+"がbuildingに移動した");
                    }
                    if(event.getSlot()==5){
                        event.getWhoClicked().closeInventory();
                        DimSystem.RecordNormal((Player) event.getWhoClicked());
                        DimSystem.Teleport((Player) event.getWhoClicked(),"mining");
                        plugin.getLogger().info("(DM)"+event.getWhoClicked().getName()+"がminingに移動した");
                    }
                    if(event.getSlot()==6){
                        event.getWhoClicked().closeInventory();
                        DimSystem.RecordNormal((Player) event.getWhoClicked());
                        DimSystem.Teleport((Player) event.getWhoClicked(),"normal");
                        plugin.getLogger().info("(DM)"+event.getWhoClicked().getName()+"がnormalに移動した");

                    }
                    if(event.getSlot()==1){
                        if(event.getCurrentItem().getType().equals(Material.RED_BED)){
                            Location loc = DimSystem.HomeRead((Player) event.getWhoClicked());
                            if (loc == null) {
                                event.getWhoClicked().sendMessage("homeを設定してください");
                                return;
                            }
                            event.getWhoClicked().teleport(loc);
                            SoundManage.sendSuccess((Player) event.getWhoClicked());
                        }
                    }
                    if(event.getSlot()==10){
                        if(event.getCurrentItem().getType().equals(Material.WHITE_STAINED_GLASS_PANE)){
                            event.getWhoClicked().closeInventory();
                            Gui.OpenConfirmGui((Player) event.getWhoClicked());
                        }
                    }

                }
            }
        }
        if(event.getView().getTitle().equals("ホームを設定する")){
            if(event.getCurrentItem()!=null){
                event.setCancelled(true);
                if(!event.getClickedInventory().getType().equals(InventoryType.PLAYER)){
                    if(event.getSlot()==0){
                        if(event.getCurrentItem().getType().equals(Material.WHITE_STAINED_GLASS_PANE)){
                            Location newLoc = event.getWhoClicked().getLocation();
                            if(DimSystem.HomeRead((Player) event.getWhoClicked()) != null){
                                Location old = DimSystem.HomeRead((Player) event.getWhoClicked());
                                event.getWhoClicked().sendMessage("homeをx:"+DimSystem.Num10(old.getX())+"y:"+DimSystem.Num10(old.getY())+"z:"+DimSystem.Num10(old.getZ())+"から"+"x:"+DimSystem.Num10(newLoc.getX())+"y:"+DimSystem.Num10(newLoc.getY())+"z:"+DimSystem.Num10(newLoc.getZ())+"に変更した");
                            }else {
                                event.getWhoClicked().sendMessage("homeをx:"+DimSystem.Num10(newLoc.getX())+"y:"+DimSystem.Num10(newLoc.getY())+"z:"+DimSystem.Num10(newLoc.getZ())+"に設定した");
                            }
                            SoundManage.sendSuccess((Player) event.getWhoClicked());
                            DimSystem.HomeRecord((Player) event.getWhoClicked());
                            event.getWhoClicked().closeInventory();
                        }
                    }
                    if(event.getSlot()==8){
                        event.getWhoClicked().closeInventory();
                    }
                }
            }
        }
    }
}
