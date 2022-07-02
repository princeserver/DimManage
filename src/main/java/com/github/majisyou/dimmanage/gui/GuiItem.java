package com.github.majisyou.dimmanage.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GuiItem {

    public static ItemStack BackGround(){
        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = " ";
        itemMeta.setDisplayName(name);
        itemMeta.setCustomModelData(3410);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack GreenCheck(){
        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = ChatColor.WHITE+"クリックで決定する";
        itemMeta.setDisplayName(name);
        itemMeta.setCustomModelData(3400);
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack RedCross(){
        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = "キャンセルする";
        itemMeta.setDisplayName(name);
        itemMeta.setCustomModelData(3401);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack LobbyDim(){
        ItemStack item = new ItemStack(Material.OAK_SAPLING,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = "ロビー";
        itemMeta.setDisplayName(ChatColor.UNDERLINE+"§aクリック"+ChatColor.WHITE+"で"+name+"に移動する");
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack BuildingDim(){
        ItemStack item = new ItemStack(Material.CRAFTING_TABLE,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = "建築ワールド";
        itemMeta.setDisplayName(ChatColor.UNDERLINE+"§aクリック"+ChatColor.WHITE+"で"+name+"に移動する");
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack ResourceDim(){
        ItemStack item = new ItemStack(Material.DIAMOND_ORE,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = "採掘ワールド";
        itemMeta.setDisplayName(ChatColor.UNDERLINE+"§aクリック"+ChatColor.WHITE+"で"+name+"に移動する");
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack WorldDim(){
        ItemStack item = new ItemStack(Material.GRASS_BLOCK,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = "通常ワールド";
        itemMeta.setDisplayName(ChatColor.UNDERLINE+"§aクリック"+ChatColor.WHITE+"で"+name+"に移動する");
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack homeDim(){
        ItemStack item = new ItemStack(Material.RED_BED,1);
        ItemMeta itemMeta = item.getItemMeta();
        String name = "ホーム";
        itemMeta.setDisplayName(ChatColor.UNDERLINE+"§aクリック"+ChatColor.WHITE+"で"+name+"に移動する");
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack homeTeleport(){
        ItemStack item = new ItemStack(Material.WHITE_STAINED_GLASS_PANE,1);
        ItemMeta itemMeta = item.getItemMeta();
        List<String> Lore = new ArrayList<>();
        itemMeta.setCustomModelData(3404);
        itemMeta.setDisplayName(ChatColor.UNDERLINE+"§aクリック"+ChatColor.WHITE+"でホームを現在の位置に設定する+name+");
        Lore.add(ChatColor.WHITE+"ホーム地点は各ワールドに1つずつ設定可能です");
        Lore.add(ChatColor.WHITE+"ホーム機能は/homeのコマンドからも使用できます");
        itemMeta.setLore(Lore);
        item.setItemMeta(itemMeta);
        return item;
    }



}
