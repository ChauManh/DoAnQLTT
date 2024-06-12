package database;

import java.sql.Connection;
import java.sql.DriverManager;


public class JDBCUtil {
    
    private static Connection c = null;
    
    public static Connection getConnection(){
        return c;
    }
    
    public static Connection getUserConnection(){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/qltt?noAccessToProcedureBodies=true";
            String username = "WeatherUser";
            String password = "user@123";
            c = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    
    public static Connection getAdminConnection(){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/qltt?noAccessToProcedureBodies=true";
            String username = "WeatherAdmin";
            String password = "admin@123";
            c = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    
    public static Connection getLoginConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/qltt?noAccessToProcedureBodies=true";
            String username = "WeatherLogin";
            String password = "login@123";
            c = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    } 
    
    public static void closeConnection(){
        try {
            if (c!=null){
                c.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
    
