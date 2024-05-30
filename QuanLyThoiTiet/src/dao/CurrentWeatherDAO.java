package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.CurrentWeather;
import database.JDBCUtil;

public class CurrentWeatherDAO implements DAOInterface<CurrentWeather> {

    public static CurrentWeatherDAO getInstance() {
        return new CurrentWeatherDAO();
    }

   @Override
    public int insert(CurrentWeather t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO currentweather (city_id, weather_condition_id, cur_timestamp, icon, temperature, feels_like, pressure, humidity, clouds, uv, visibility, wind_speed, aqi) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, t.getCityId());
            pst.setInt(2, t.getWeatherCondition());
            pst.setInt(3, t.getCurTimestamp());
            pst.setString(4, t.getIcon());
            pst.setFloat(5, t.getTemperature());
            pst.setFloat(6, t.getFeels_like());
            pst.setInt(7, t.getPressure());
            pst.setInt(8, t.getHumidity());
            pst.setInt(9, t.getClouds());
            pst.setFloat(10, t.getUv());
            pst.setInt(11, t.getVisibility());
            pst.setFloat(12, t.getWindSpeed());
            pst.setInt(13, t.getAqi());

            pst.execute();
            ResultSet r = pst.getGeneratedKeys();
            if (r.next()) {
                int currentWeatherID = r.getInt(1);
                t.setCurrenWeatherId(currentWeatherID);
            }
            r.close();
            pst.close();
            ketQua = 1; // Số dòng bị thay đổi là 1 sau khi thêm dữ liệu thành công
            System.out.println("Da thuc thi: " + sql);
            System.out.println("Co " + ketQua + " dong bi thay doi.");
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }


    @Override
    public int update(CurrentWeather t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE current_weather SET cityId = ?, weatherCondition = ?, curTimestamp = ?, icon = ?, temperature = ?, feels_like = ?, pressure = ?, humidity = ?, clouds = ?, uv = ?, visibility = ?, windSpeed = ?, aqi = ? WHERE currenWeatherId = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getCityId());
            pst.setInt(2, t.getWeatherCondition());
            pst.setInt(3, t.getCurTimestamp());
            pst.setString(4, t.getIcon());
            pst.setFloat(5, t.getTemperature());
            pst.setFloat(6, t.getFeels_like());
            pst.setInt(7, t.getPressure());
            pst.setInt(8, t.getHumidity());
            pst.setInt(9, t.getClouds());
            pst.setFloat(10, t.getUv());
            pst.setInt(11, t.getVisibility());
            pst.setFloat(12, t.getWindSpeed());
            pst.setInt(13, t.getAqi());
            pst.setInt(14, t.getCurrenWeatherId());

            ketQua = pst.executeUpdate();
            System.out.println("Da thuc thi: " + sql);
            System.out.println("Co " + ketQua + " dong bi thay doi.");
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int delete(CurrentWeather t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM current_weather WHERE currenWeatherId = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getCurrenWeatherId());

            ketQua = pst.executeUpdate();
            System.out.println("Da thuc thi: " + sql);
            System.out.println("Co " + ketQua + " dong bi thay doi.");
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<CurrentWeather> selectAll() {
        ArrayList<CurrentWeather> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM currentweather";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                CurrentWeather currentWeather = new CurrentWeather();
                currentWeather.setCurrenWeatherId(rs.getInt("current_weather_id"));
                currentWeather.setCityId(rs.getInt("city_id"));
                currentWeather.setWeatherCondition(rs.getInt("weather_condition_id"));
                currentWeather.setCurTimestamp(rs.getInt("cur_Timestamp"));
                currentWeather.setIcon(rs.getString("icon"));
                currentWeather.setTemperature(rs.getFloat("temperature"));
                currentWeather.setFeels_like(rs.getFloat("feels_like"));
                currentWeather.setPressure(rs.getInt("pressure"));
                currentWeather.setHumidity(rs.getInt("humidity"));
                currentWeather.setClouds(rs.getInt("clouds"));
                currentWeather.setUv(rs.getFloat("uv"));
                currentWeather.setVisibility(rs.getInt("visibility"));
                currentWeather.setWindSpeed(rs.getFloat("wind_speed"));
                currentWeather.setAqi(rs.getInt("aqi"));

                ketQua.add(currentWeather);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public CurrentWeather selectById(String id) {
        CurrentWeather currentWeather = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM currentweather WHERE curren_Weather_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                currentWeather = new CurrentWeather();
                currentWeather.setCurrenWeatherId(rs.getInt("current_weather_id"));
                currentWeather.setCityId(rs.getInt("city_id"));
                currentWeather.setWeatherCondition(rs.getInt("weather_condition_id"));
                currentWeather.setCurTimestamp(rs.getInt("cur_Timestamp"));
                currentWeather.setIcon(rs.getString("icon"));
                currentWeather.setTemperature(rs.getFloat("temperature"));
                currentWeather.setFeels_like(rs.getFloat("feels_like"));
                currentWeather.setPressure(rs.getInt("pressure"));
                currentWeather.setHumidity(rs.getInt("humidity"));
                currentWeather.setClouds(rs.getInt("clouds"));
                currentWeather.setUv(rs.getFloat("uv"));
                currentWeather.setVisibility(rs.getInt("visibility"));
                currentWeather.setWindSpeed(rs.getFloat("wind_speed"));
                currentWeather.setAqi(rs.getInt("aqi"));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currentWeather;
    }
    
    public void updateWeather(
        long userId, 
        float temperature, 
        float feelsLike, 
        int pressure, 
        int humidity, 
        int clouds, 
        float uv, 
        int visibility, 
        float windSpeed, 
        int aqi
    ) {
        try {
            String sql = "{CALL UpdateWeather(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setLong(1, userId);
            pre.setFloat(2, temperature);
            pre.setFloat(3, feelsLike);
            pre.setInt(4, pressure);
            pre.setInt(5, humidity);
            pre.setInt(6, clouds);
            pre.setFloat(7, uv);
            pre.setInt(8, visibility);
            pre.setFloat(9, windSpeed);
            pre.setInt(10, aqi);
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
