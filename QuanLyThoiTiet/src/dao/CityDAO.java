package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.City;

public class CityDAO implements DAOInterface<City> {

    private Connection connection = JDBCUtil.getConnection();

    public static CityDAO getInstance() {
        return new CityDAO();
    }

    @Override
    public int insert(City t) {
        int result = -1;
        try {
            String sql = "INSERT INTO city (city_id, city_name, country_id, latitude, longitude) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, t.getCity_id());
            pre.setString(2, t.getCity_name());
            pre.setString(3, t.getCounty_id());
            pre.setDouble(4, t.getLatitude());
            pre.setDouble(5, t.getLongitude());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(City t) {
        int result = -1;
        try {
            String sql = "UPDATE city SET city_name = ?, country_id = ?, latitude = ?, longitude = ? WHERE city_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, t.getCity_name());
            pre.setString(2, t.getCounty_id());
            pre.setDouble(3, t.getLatitude());
            pre.setDouble(4, t.getLongitude());
            pre.setInt(5, t.getCity_id());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(City t) {
        int result = -1;
        try {
            String sql = "DELETE FROM city WHERE city_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, t.getCity_id());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<City> selectAll() {
        ArrayList<City> ketQua = new ArrayList<>();
        try {
            String sql = "SELECT * FROM city";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                int city_id = rs.getInt("city_id");
                String city_name = rs.getString("city_name");
                String country_id = rs.getString("country_id");
                float latitude = rs.getFloat("latitude");
                float longitude = rs.getFloat("longitude");             
                City p = new City(city_id, city_name, country_id, latitude, longitude);
                ketQua.add(p);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public City selectById(String city_name) {
        City ketQua = null;
        try {
            String sql = "SELECT * FROM city WHERE city_name = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, city_name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int city_id = rs.getInt("city_id");
                String country_id = rs.getString("country_id");
                float latitude = rs.getFloat("latitude");
                float longitude = rs.getFloat("longitude");             
                ketQua = new City(city_id, city_name, country_id, latitude, longitude);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }   
    
    public ArrayList<City> findTopCities(String searchString) {
        ArrayList<City> ketQua = new ArrayList<>();
        try {
            String sql = "{CALL FindTopCities(?)}";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, searchString);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int city_id = rs.getInt("city_id");
                String city_name = rs.getString("city_name");
                String country_id = rs.getString("country_id");
                double latitude = rs.getDouble("latitude");
                double longitude = rs.getDouble("longitude");
                City city = new City(city_id, city_name, country_id, latitude, longitude);
                ketQua.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
