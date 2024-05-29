package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.util.ArrayList;
import models.City;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CityDAO implements DAOInterface<City> {

    public static CityDAO getInstance() {
        return new CityDAO();
    }

    @Override
    public int insert(City t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(City t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(City t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<City> selectAll() {
        ArrayList<City> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM city";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
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
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM city WHERE city_name = ?";
            PreparedStatement st = con.prepareStatement(sql);
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


    @Override
    public ArrayList<City> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
