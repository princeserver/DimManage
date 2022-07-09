package com.github.majisyou.dimmanage.gui;

import com.github.majisyou.dimmanage.DimManage;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Gui {
    private static final DimManage plugin = DimManage.getInstance();

    public static void OpenDimGui(String DimName, Player player){
        Inventory inventory = Bukkit.createInventory(null,27,"ワールドを移動する");
        ItemStack BackGround = GuiItem.BackGround();
        ItemStack LobbyDim = GuiItem.LobbyDim();
        ItemStack BuildingDim = GuiItem.BuildingDim();
        ItemStack ResourceDim = GuiItem.ResourceDim();
        ItemStack NormalDim = GuiItem.WorldDim();
        ItemStack HomeDim = GuiItem.homeDim();
        ItemStack HomeTele = GuiItem.homeTeleport();

        if(DimName.equals("normal")){
            ItemStack[] GuiContainer = new  ItemStack[]{NormalDim,BackGround,BackGround,LobbyDim,BuildingDim,ResourceDim,NormalDim,BackGround,BackGround,
                                                        BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,
                                                        BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,};
            inventory.setContents(GuiContainer);
            player.openInventory(inventory);
            return;
        }
        if(DimName.equals("lobby")){
            ItemStack[] GuiContainer = new  ItemStack[]{LobbyDim,BackGround,BackGround,LobbyDim,BuildingDim,ResourceDim,NormalDim,BackGround,BackGround,
                                            BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,
                                            BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,};
            inventory.setContents(GuiContainer);
            player.openInventory(inventory);
            return;
        }
        if(DimName.equals("building")){
            ItemStack[] GuiContainer = new  ItemStack[]{BuildingDim,HomeDim,BackGround,LobbyDim,BuildingDim,ResourceDim,NormalDim,BackGround,BackGround,
                                                        BackGround,HomeTele,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,
                                                        BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,};
            inventory.setContents(GuiContainer);
            player.openInventory(inventory);
            return;
        }
        if(DimName.equals("mining")){
            ItemStack[] GuiContainer = new  ItemStack[]{ResourceDim,HomeDim,BackGround,LobbyDim,BuildingDim,ResourceDim,NormalDim,BackGround,BackGround,
                    BackGround,HomeTele,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,
                    BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,BackGround,};
            inventory.setContents(GuiContainer);
            player.openInventory(inventory);
            return;
        }
        plugin.getLogger().info("DM"+DimName+"が間違えてる(Guiを開けなかった)");
        player.sendMessage("Guiを開けなかった");
    }

    public static void OpenConfirmGui(Player player){
        Inventory inventory = Bukkit.createInventory(null,9,"ホームを設定する");
        ItemStack GreenCheck = GuiItem.GreenCheck();
        ItemStack RedCross = GuiItem.RedCross();
        ItemStack[] GuiContainer = new  ItemStack[]{GreenCheck,null,null,null,null,null,null,null,RedCross};
        inventory.setContents(GuiContainer);
        player.openInventory(inventory);
    }

}
