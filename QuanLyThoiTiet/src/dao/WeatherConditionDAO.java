package dao;

import models.WeatherCondition;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.JDBCUtil;

public class WeatherConditionDAO implements DAOInterface<WeatherCondition> {

    public static WeatherConditionDAO getInstance() {
        return new WeatherConditionDAO();
    }

    @Override
    public int insert(WeatherCondition t) {
        Connection connection = JDBCUtil.getConnection();
        int result = -1;
        try {
            String sql = "INSERT INTO WeatherCondition (weather_condition_id, main, weather_description) VALUES (?, ?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, t.getWeather_condition_id());
            pre.setString(2, t.getMain());
            pre.setString(3, t.getWeather_description());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(WeatherCondition t) {
        Connection connection = JDBCUtil.getConnection();
        int result = -1;
        try {
            String sql = "UPDATE WeatherCondition SET main = ?, weather_description = ? WHERE weather_condition_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, t.getMain());
            pre.setString(2, t.getWeather_description());
            pre.setInt(3, t.getWeather_condition_id());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(WeatherCondition t) {
        Connection connection = JDBCUtil.getConnection();
        int result = -1;
        try {
            String sql = "DELETE FROM WeatherCondition WHERE weather_condition_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, t.getWeather_condition_id());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<WeatherCondition> selectAll() {
        Connection connection = JDBCUtil.getConnection();
        ArrayList<WeatherCondition> dsWeatherCondition = new ArrayList<>();
        try {
            String sql = "SELECT * FROM WeatherCondition";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                WeatherCondition wc = new WeatherCondition(
                    result.getInt("weather_condition_id"),
                    result.getString("main"),
                    result.getString("weather_description")
                );
                dsWeatherCondition.add(wc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsWeatherCondition;
    }

    @Override
    public WeatherCondition selectById(String t) {
        Connection connection = JDBCUtil.getConnection();
        WeatherCondition wc = null;
        try {
            String sql = "SELECT * FROM WeatherCondition WHERE weather_condition_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(t));
            ResultSet result = pre.executeQuery();
            if (result.next()) {
                wc = new WeatherCondition(
                    result.getInt("weather_condition_id"),
                    result.getString("main"),
                    result.getString("weather_description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wc;
    }
    
     public static String getDescription(int id){
        return WeatherConditionDAO.getInstance().selectById(String.valueOf(id)).getWeather_description();
    }
    
}
