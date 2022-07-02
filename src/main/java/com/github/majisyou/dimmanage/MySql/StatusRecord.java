package com.github.majisyou.dimmanage.MySql;

import com.github.majisyou.dimmanage.DimManage;
import com.github.majisyou.dimmanage.system.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.lang.reflect.Executable;
import java.sql.*;
import java.util.UUID;

public class StatusRecord {

    private Connection connection;
    private String host, database, username, password,tablename;
    private int port;
    private final DimManage plugin = DimManage.getInstance();

    public StatusRecord(){
        host = ConfigManager.getHost();
        port = ConfigManager.getPort();
        database = ConfigManager.getDatabase();
        username = ConfigManager.getUserName();
        password = ConfigManager.getPassWord();
        tablename = ConfigManager.getTableName();
    }

//    public static Location loadLocation(String name,UUID player){
//        World world = Bukkit.getWorld(name);
//        return new Location(world,0,64,0);
//    }

    public void saveWorld(String name, UUID player, Location location){
        try {
            openConnection();
            String sql = "INSERT IGNORE INTO "+tablename+" (dim, player, world, x, y, z, yaw, pitch) VALUES (?, ?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, player.toString());
            preparedStatement.setString(3, location.getWorld().getUID().toString());
            preparedStatement.setDouble(4, location.getX());
            preparedStatement.setDouble(5, location.getY());
            preparedStatement.setDouble(6, location.getZ());
            preparedStatement.setDouble(7, (double)location.getYaw());
            preparedStatement.setDouble(8, (double)location.getPitch());

            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public void update(String name,UUID player,Location loc){
        try {
            openConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE "+tablename+" SET world = ?, x = ?, y = ?, z = ?, yaw = ?, pitch = ? WHERE dim = ? AND player = ?;");
            try {
                statement.setString(1,loc.getWorld().getUID().toString());
                statement.setDouble(2,loc.getX());
                statement.setDouble(3,loc.getY());
                statement.setDouble(4,loc.getZ());
                statement.setDouble(5,(double) loc.getYaw());
                statement.setDouble(6,(double) loc.getPitch());
                statement.setString(7,name);
                statement.setString(8,player.toString());

                statement.executeUpdate();
            } finally {
                if(statement != null){
                    statement.close();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Location read(UUID player,String dim){
        try {
            openConnection();
            PreparedStatement statement = this.connection.prepareStatement("SELECT world, x, y, z, yaw, pitch FROM "+tablename+" WHERE dim = ? AND player = ?;");
            try {
                statement.setString(1, dim);
                statement.setString(2, player.toString());
                ResultSet result = statement.executeQuery();

                if(result.next()){
                    String uuid = result.getString("world");
                    UUID id = null;
                    try {
                        id = UUID.fromString(uuid);
                    }catch (IllegalArgumentException e){
                        e.printStackTrace();
                        plugin.getLogger().info("(DM)"+"SELECT FROM "+tablename+" WHERE dim = "+dim+" AND player = " + player);
                        statement.close();
                        return null;
                    }
                    World world = Bukkit.getWorld(id);
                    double x = result.getDouble("x");
                    double y = result.getDouble("y");
                    double z = result.getDouble("z");
                    double yaw = result.getDouble("yaw");
                    double pitch = result.getDouble("pitch");
                    statement.close();
                    return new Location(world, x, y, z, (float)yaw, (float)pitch);
                }

            } finally {
                if(statement != null){
                    statement.close();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        plugin.getLogger().info("(DM)"+player+"のDimが見つからなかった");
        return null;
    }



    private void openConnection() throws  SQLException, ClassNotFoundException{
        if (connection != null && !connection.isClosed()){
            return;
        }
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
    }
}
