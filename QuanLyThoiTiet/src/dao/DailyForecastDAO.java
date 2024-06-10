package dao;

import models.DailyForecast;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import models.City;
import database.JDBCUtil;

public class DailyForecastDAO implements DAOInterface<DailyForecast> {
    
    public static DailyForecastDAO getInstance() {
        return new DailyForecastDAO();
    }

    @Override
    public int insert(DailyForecast df) {
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "{CALL InsertOrUpdateDailyForecast(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, df.getDaily_forecast_id());
            pre.setLong(2, df.getCity_id());
            pre.setLong(3, df.getDf_date());
            pre.setInt(4, df.getWeather_condition_id());            
            pre.setString(5, df.getIcon());
            pre.setLong(6, df.getSunrise());
            pre.setLong(7, df.getSunset());
            pre.setLong(8, df.getMoonrise());
            pre.setLong(9, df.getMoonset());
            pre.setString(10, df.getSummary());
            pre.setFloat(11, df.getTemperature_max());
            pre.setFloat(12, df.getTemperature_min());
            pre.setFloat(13, df.getTemperature_morn());
            pre.setFloat(14, df.getTemperature_day());
            pre.setFloat(15, df.getTemperature_eve());
            pre.setFloat(16, df.getTemperature_night());
            pre.setFloat(17, df.getFeels_like_morn());
            pre.setFloat(18, df.getFeels_like_day());
            pre.setFloat(19, df.getFeels_like_eve());
            pre.setFloat(20, df.getFeels_like_night());
            pre.setInt(21, df.getPressure());
            pre.setInt(22, df.getHumidity());
            pre.setFloat(23, df.getWind_speed());
            pre.setInt(24, df.getClouds());
            pre.setFloat(25, df.getUv());
            pre.setFloat(26, df.getPop());
            pre.setInt(27, df.getAqi());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }  

    @Override
    public int update(DailyForecast df) {
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "{CALL UpdateDailyForecast(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setLong(1, df.getCity_id());
            pre.setLong(2, df.getDf_date());
            pre.setInt(3, df.getWeather_condition_id());            
            pre.setString(4, df.getIcon());
            pre.setLong(5, df.getSunrise());
            pre.setLong(6, df.getSunset());
            pre.setLong(7, df.getMoonrise());
            pre.setLong(8, df.getMoonset());
            pre.setString(9, df.getSummary());
            pre.setFloat(10, df.getTemperature_max());
            pre.setFloat(11, df.getTemperature_min());
            pre.setFloat(12, df.getTemperature_morn());
            pre.setFloat(13, df.getTemperature_day());
            pre.setFloat(14, df.getTemperature_eve());
            pre.setFloat(15, df.getTemperature_night());
            pre.setFloat(16, df.getFeels_like_morn());
            pre.setFloat(17, df.getFeels_like_day());
            pre.setFloat(18, df.getFeels_like_eve());
            pre.setFloat(19, df.getFeels_like_night());
            pre.setInt(20, df.getPressure());
            pre.setInt(21, df.getHumidity());
            pre.setFloat(22, df.getWind_speed());
            pre.setInt(23, df.getClouds());
            pre.setFloat(24, df.getUv());
            pre.setFloat(25, df.getPop());
            pre.setInt(26, df.getAqi());
            pre.setInt(27, df.getDaily_forecast_id());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(DailyForecast df) {
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM DailyForecast WHERE daily_forecast_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, df.getDaily_forecast_id());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public ArrayList<DailyForecast> selectAll() {
        Connection connection = JDBCUtil.getConnection();
        ArrayList<DailyForecast> dsDailyForecast = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DailyForecast";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                DailyForecast df = new DailyForecast();
                df.setDaily_forecast_id(result.getInt("daily_forecast_id"));
                df.setWeather_condition_id(result.getInt("weather_condition_id"));
                df.setCity_id(result.getLong("city_id"));
                df.setDf_date(result.getLong("df_date"));
                df.setIcon(result.getString("icon"));
                df.setSunrise(result.getLong("sunrise"));
                df.setSunset(result.getLong("sunset"));
                df.setMoonrise(result.getLong("moonrise"));
                df.setMoonset(result.getLong("moonset"));
                df.setSummary(result.getString("summary"));
                df.setTemperature_max(result.getFloat("temperature_max"));
                df.setTemperature_min(result.getFloat("temperature_min"));
                df.setTemperature_morn(result.getFloat("temperature_morn"));
                df.setTemperature_day(result.getFloat("temperature_day"));
                df.setTemperature_eve(result.getFloat("temperature_eve"));
                df.setTemperature_night(result.getFloat("temperature_night"));
                df.setFeels_like_morn(result.getFloat("feels_like_morn"));
                df.setFeels_like_day(result.getFloat("feels_like_day"));
                df.setFeels_like_eve(result.getFloat("feels_like_eve"));
                df.setFeels_like_night(result.getFloat("feels_like_night"));
                df.setPressure(result.getInt("pressure"));
                df.setHumidity(result.getInt("humidity"));
                df.setWind_speed(result.getFloat("wind_speed"));
                df.setClouds(result.getInt("clouds"));
                df.setUv(result.getFloat("uv"));
                df.setPop(result.getFloat("pop"));
                df.setAqi(result.getInt("aqi"));
                dsDailyForecast.add(df);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsDailyForecast;
    }

    @Override
    public DailyForecast selectById(String id) {
        Connection connection = JDBCUtil.getConnection();
        DailyForecast df = null;
        try {
            String sql = "SELECT * FROM DailyForecast WHERE daily_forecast_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, id);
            ResultSet result = pre.executeQuery();
            if (result.next()) {
                df = new DailyForecast();
                df.setDaily_forecast_id(result.getInt("daily_forecast_id"));
                df.setWeather_condition_id(result.getInt("weather_condition_id"));
                df.setCity_id(result.getLong("city_id"));
                df.setDf_date(result.getLong("df_date"));
                df.setIcon(result.getString("icon"));
                df.setSunrise(result.getLong("sunrise"));
                df.setSunset(result.getLong("sunset"));
                df.setMoonrise(result.getLong("moonrise"));
                df.setMoonset(result.getLong("moonset"));
                df.setSummary(result.getString("summary"));
                df.setTemperature_max(result.getFloat("temperature_max"));
                df.setTemperature_min(result.getFloat("temperature_min"));
                df.setTemperature_morn(result.getFloat("temperature_morn"));
                df.setTemperature_day(result.getFloat("temperature_day"));
                df.setTemperature_eve(result.getFloat("temperature_eve"));
                df.setTemperature_night(result.getFloat("temperature_night"));
                df.setFeels_like_morn(result.getFloat("feels_like_morn"));
                df.setFeels_like_day(result.getFloat("feels_like_day"));
                df.setFeels_like_eve(result.getFloat("feels_like_eve"));
                df.setFeels_like_night(result.getFloat("feels_like_night"));
                df.setPressure(result.getInt("pressure"));
                df.setHumidity(result.getInt("humidity"));
                df.setWind_speed(result.getFloat("wind_speed"));
                df.setClouds(result.getInt("clouds"));
                df.setUv(result.getFloat("uv"));
                df.setPop(result.getFloat("pop"));
                df.setAqi(result.getInt("aqi"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return df;
    }
    
    public void CSVexport(City city, String path){
        
        String query = "SELECT * INTO OUTFILE '" + path + "'" +  
                       " FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n' " +
                       " WHERE city_id = " + city +
                       " FROM DailyForecast";
        
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
