package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.WeatherCondition;

public class WeatherConditionDAO implements DAOInterface<WeatherCondition> {

    public static WeatherConditionDAO getInstance() {
        return new WeatherConditionDAO();
    }
    
    @Override
    public int insert(WeatherCondition t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(WeatherCondition t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(WeatherCondition t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<WeatherCondition> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public WeatherCondition selectById(String id) {
        WeatherCondition weatherCondition = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM weathercondition WHERE weather_condition_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                weatherCondition = new WeatherCondition();
                weatherCondition.setWeather_condition_id(Integer.parseInt(id));
                weatherCondition.setMain(rs.getString("main"));
                weatherCondition.setWeather_description(rs.getString("weather_description"));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return weatherCondition;
    }

    @Override
    public ArrayList<WeatherCondition> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static String getDescription(int id){
        return WeatherConditionDAO.getInstance().selectById(String.valueOf(id)).getWeather_description();
    }
}
