package com.github.majisyou.dimmanage.system;

import com.github.majisyou.dimmanage.DimManage;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public class ConfigManager {

    private static final DimManage plugin = DimManage.getInstance();
    private static final FileConfiguration config = plugin.getConfig();

    private static String Host;
    private static String Database;
    private static Integer Port;
    private static String UserName;
    private static String PassWord;
    private static String TableName;

    private static String world;
    private static double loc_x;
    private static double loc_y;
    private static double loc_z;
    private static double loc_yaw;
    private static double loc_pitch;

    private static HashMap<String,String> dimensions;

    public static void loadConfig(){
        Host = config.getString("MySql.Host");
        Database = config.getString("MySql.Database");
        Port = config.getInt("MySql.Port");
        UserName = config.getString("MySql.UserName");
        PassWord = config.getString("MySql.PassWord");
        TableName = config.getString("MySql.TableName");
        dimensions = new HashMap<>();
        for (String key: config.getConfigurationSection("dimensions").getKeys(false)){
            dimensions.put(key,config.getString("dimensions."+key));
        }
    }

    public static void loadWorld(String worldName){
        String path = "dimension."+worldName;
        world = config.getString(path+".name");
        loc_x = config.getDouble(path+".locationx");
        loc_y = config.getDouble(path+".locationy");
        loc_z =config.getDouble(path+".locationz");
        loc_yaw = config.getDouble(path+".locYaw");
        loc_pitch = config.getDouble(path+".locPitch");
    }

    public static String getWorld(){return world;}
    public static double getLoc_x(){return loc_x;}
    public static double getLoc_y(){return loc_y;}
    public static double getLoc_z(){return loc_z;}
    public static double getLoc_yaw(){return loc_yaw;}
    public static double getLoc_pitch(){return loc_pitch;}

    public static String getHost(){return Host;}
    public static String getDatabase(){return Database;}
    public static Integer getPort(){return Port;}
    public static String getUserName(){return UserName;}
    public static String getPassWord(){return PassWord;}
    public static String getTableName(){return TableName;}

    public static HashMap<String,String> getDimensions(){return dimensions;}



}
