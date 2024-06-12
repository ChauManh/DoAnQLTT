package dao;

import java.util.ArrayList;
import models.HourlyForecast;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.JDBCUtil;
import models.City;


public class HourlyForecastDAO implements DAOInterface<HourlyForecast> {

    public static HourlyForecastDAO getInstance() {
        return new HourlyForecastDAO();
    }

    @Override
    public int insert(HourlyForecast hf) {
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "{CALL InsertOrUpdateHourlyForecast(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, hf.getHourly_forecast_id());
            pre.setLong(2, hf.getCity_id());
            pre.setLong(3, hf.getHf_timestamp());
            pre.setInt(4, hf.getWeather_condition_id());            
            pre.setString(5, hf.getIcon());
            pre.setFloat(6, hf.getTemperature());
            pre.setFloat(7, hf.getFeels_like());
            pre.setInt(8, hf.getPressure());
            pre.setInt(9, hf.getHumidity());
            pre.setInt(10, hf.getClouds());
            pre.setFloat(11, hf.getUv());
            pre.setInt(12, hf.getVisibility());
            pre.setFloat(13, hf.getWind_speed());
            pre.setFloat(14, hf.getPop());
            pre.setInt(15, hf.getAqi());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }  

    @Override
    public int update(HourlyForecast hf) {
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "{CALL UpdateHourlyForecast(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, hf.getHourly_forecast_id());              
            pre.setLong(2, hf.getCity_id());            
            pre.setLong(3, hf.getHf_timestamp());
            pre.setInt(4, hf.getWeather_condition_id());
            pre.setString(5, hf.getIcon());
            pre.setFloat(6, hf.getTemperature());
            pre.setFloat(7, hf.getFeels_like());
            pre.setInt(8, hf.getPressure());
            pre.setInt(9, hf.getHumidity());
            pre.setInt(10, hf.getClouds());
            pre.setFloat(11, hf.getUv());
            pre.setInt(12, hf.getVisibility());
            pre.setFloat(13, hf.getWind_speed());
            pre.setFloat(14, hf.getPop());
            pre.setInt(15, hf.getAqi());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    

    @Override
    public int delete(HourlyForecast t) {
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM HourlyForecast WHERE hourly_forecast_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, t.getHourly_forecast_id());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public ArrayList<HourlyForecast> selectAll() {
        Connection connection = JDBCUtil.getConnection();
        ArrayList<HourlyForecast> dsHourlyForecast = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HourlyForecast";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                HourlyForecast hf = new HourlyForecast();
                hf.setHourly_forecast_id(result.getInt("hourly_forecast_id"));
                hf.setWeather_condition_id(result.getInt("weather_condition_id"));
                hf.setCity_id(result.getLong("city_id"));
                hf.setHf_timestamp(result.getLong("hf_timestamp"));
                hf.setIcon(result.getString("icon"));
                hf.setTemperature(result.getFloat("temperature"));
                hf.setFeels_like(result.getFloat("feels_like"));
                hf.setPressure(result.getInt("pressure"));
                hf.setHumidity(result.getInt("humidity"));
                hf.setClouds(result.getInt("clouds"));
                hf.setUv(result.getFloat("uv"));
                hf.setVisibility(result.getInt("visibility"));
                hf.setWind_speed(result.getFloat("wind_speed"));
                hf.setPop(result.getFloat("pop"));
                hf.setAqi(result.getInt("aqi"));
                dsHourlyForecast.add(hf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHourlyForecast;
    }

    @Override
    public HourlyForecast selectById(String t) {
        Connection connection = JDBCUtil.getConnection();
        HourlyForecast hf = null;
        try {
            String sql = "SELECT * FROM HourlyForecast WHERE hourly_forecast_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, t);
            ResultSet result = pre.executeQuery();
            if (result.next()) {
                hf = new HourlyForecast();
                hf.setHourly_forecast_id(result.getInt("hourly_forecast_id"));
                hf.setWeather_condition_id(result.getInt("weather_condition_id"));
                hf.setCity_id(result.getLong("city_id"));
                hf.setHf_timestamp(result.getLong("hf_timestamp"));
                hf.setIcon(result.getString("icon"));
                hf.setTemperature(result.getFloat("temperature"));
                hf.setFeels_like(result.getFloat("feels_like"));
                hf.setPressure(result.getInt("pressure"));
                hf.setHumidity(result.getInt("humidity"));
                hf.setClouds(result.getInt("clouds"));
                hf.setUv(result.getFloat("uv"));
                hf.setVisibility(result.getInt("visibility"));
                hf.setWind_speed(result.getFloat("wind_speed"));
                hf.setPop(result.getFloat("pop"));
                hf.setAqi(result.getInt("aqi"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hf;
    }
    
    public double getAverageTemperatureNextXHours(long cityID, int X) {
        Connection connection = JDBCUtil.getConnection();
        double avgTemperature = -1;
        try {
            String sql = "{CALL AverageTemperatureNextXHours(?, ?)}";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setLong(1, cityID);
            pre.setInt(2, X);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                avgTemperature = rs.getDouble("AvgTemperature");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avgTemperature;
    }

    public double getAverageRainProbabilityNextXHours(long cityID, int X) {
        Connection connection = JDBCUtil.getConnection();
        double avgRainProbability = -1;
        try {
            String sql = "{CALL AverageRainProbabilityNextXHours(?, ?)}";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setLong(1, cityID);
            pre.setInt(2, X);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                avgRainProbability = rs.getDouble("AvgRainProbability");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avgRainProbability;
    }

    public double getAverageAQINextXHours(long cityID, int X) {
        Connection connection = JDBCUtil.getConnection();
        double avgAQI = -1;
        try {
            String sql = "{CALL AverageAQINextXHours(?, ?)}";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setLong(1, cityID);
            pre.setInt(2, X);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                avgAQI = rs.getDouble("AvgAQI");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avgAQI;
    }

    public double getAverageHumidityNextXHours(long cityID, int X) {
        Connection connection = JDBCUtil.getConnection();
        double avgHumidity = -1;
        try {
            String sql = "{CALL AverageHumidityNextXHours(?, ?)}";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setLong(1, cityID);
            pre.setInt(2, X);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                avgHumidity = rs.getDouble("AvgHumidity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avgHumidity;
    }
    
    private String GetTruePath(String path){
        if (path == null) {
            return null;
        }
        return path.replace("\\", "/");
    }
    
    public void CSVexport(City city, String path){
        
        path = GetTruePath(path);
        
        String query = "SELECT * INTO OUTFILE '" + path + "'" +  
                       " FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n' " +
                       " FROM HourlyForecast WHERE city_id = " + city.getCity_id();
        
        Connection connection = JDBCUtil.getConnection();
        try{
            Statement stmt = connection.createStatement();
            
            stmt.execute(query);
            System.out.println("Data exported to CSV successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}