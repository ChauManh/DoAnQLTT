package dao;

import models.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.JDBCUtil;

public class CountryDAO implements DAOInterface<Country> {

    public static CountryDAO getInstance() {
        return new CountryDAO();
    }

    @Override
    public int insert(Country t) {
        Connection connection = JDBCUtil.getConnection();
        int result = -1;
        try {
            String sql = "INSERT INTO Country (county_id, county_name) VALUES (?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, t.getCountry_id());
            pre.setString(2, t.getCountry_name());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Country t) {
        Connection connection = JDBCUtil.getConnection();
        int result = -1;
        try {
            String sql = "UPDATE Country SET county_name = ? WHERE county_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, t.getCountry_name());
            pre.setString(2, t.getCountry_id());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Country t) {
        Connection connection = JDBCUtil.getConnection();
        int result = -1;
        try {
            String sql = "DELETE FROM Country WHERE county_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, t.getCountry_id());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Country> selectAll() {
        Connection connection = JDBCUtil.getConnection();
        ArrayList<Country> dsCountry = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Country";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                Country country = new Country(
                    result.getString("county_id"),
                    result.getString("county_name")
                );
                dsCountry.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCountry;
    }

    @Override
    public Country selectById(String t) {
        Connection connection = JDBCUtil.getConnection();
        Country country = null;
        try {
            String sql = "SELECT * FROM Country WHERE county_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, t);
            ResultSet result = pre.executeQuery();
            if (result.next()) {
                country = new Country(
                    result.getString("county_id"),
                    result.getString("county_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }
}
