package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import models.HourlyForecast;
import java.sql.PreparedStatement;

public class HourlyForecastDAO implements DAOInterface<HourlyForecast> {

    public static HourlyForecastDAO getInstance() {
        return new HourlyForecastDAO();
    }

    @Override
    public int insert(HourlyForecast t) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO HourlyForecast (hourly_forecast_id, weather_condition_id, city_id, hf_timestamp, icon, temperature, feels_like, pressure, humidity, clouds, uv, visibility, wind_speed, pop, aqi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, t.getHourly_forecast_id());
            pre.setInt(2, t.getWeather_condition_id());
            pre.setLong(3, t.getCity_id());
            pre.setLong(4, t.getHf_timestamp());
            pre.setString(5, t.getIcon());
            pre.setFloat(6, t.getTemperature());
            pre.setFloat(7, t.getFeels_like());
            pre.setInt(8, t.getPressure());
            pre.setInt(9, t.getHumidity());
            pre.setInt(10, t.getClouds());
            pre.setFloat(11, t.getUv());
            pre.setInt(12, t.getVisibility());
            pre.setFloat(13, t.getWind_speed());
            pre.setFloat(14, t.getPop());
            pre.setInt(15, t.getAqi());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int xoaHourlyForecast(int hourlyForecastId) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM HourlyForecast WHERE hourly_forecast_id = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, hourlyForecastId);
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(HourlyForecast t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(HourlyForecast t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<HourlyForecast> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HourlyForecast selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<HourlyForecast> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
