package database;

import java.sql.Connection;
import java.sql.DriverManager;


public class JDBCUtil {
    
    public static Connection getConnection() {
        Connection c = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/qltt";
            String username = "root";
            String password = "";
            c = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    } 
    
    public static void closeConnection(Connection c){
        try {
            if (c!=null){
                c.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
    
