package dao;

import models.UserAlertType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.JDBCUtil;

public class UserAlertTypeDAO implements DAOInterface<UserAlertType> {

    public static UserAlertTypeDAO getInstance() {
        return new UserAlertTypeDAO();
    }

    @Override
    public int insert(UserAlertType t) {
        Connection connection = JDBCUtil.getConnection();
        int result = -1;
        try {
            String sql = "INSERT INTO UserAlertType (alert_type_id, alert_description) VALUES (?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, t.getAlert_type_id());
            pre.setString(2, t.getAlert_description());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(UserAlertType t) {
        Connection connection = JDBCUtil.getConnection();
        int result = -1;
        try {
            String sql = "UPDATE UserAlertType SET alert_description = ? WHERE alert_type_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, t.getAlert_description());
            pre.setInt(2, t.getAlert_type_id());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(UserAlertType t) {
        Connection connection = JDBCUtil.getConnection();
        int result = -1;
        try {
            String sql = "DELETE FROM UserAlertType WHERE alert_type_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, t.getAlert_type_id());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<UserAlertType> selectAll() {
        Connection connection = JDBCUtil.getConnection();
        ArrayList<UserAlertType> dsUserAlertType = new ArrayList<>();
        try {
            String sql = "SELECT * FROM UserAlertType";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                UserAlertType uat = new UserAlertType(
                    result.getInt("alert_type_id"),
                    result.getString("alert_description")
                );
                dsUserAlertType.add(uat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsUserAlertType;
    }

    @Override
    public UserAlertType selectById(String t) {
        Connection connection = JDBCUtil.getConnection();
        UserAlertType uat = null;
        try {
            String sql = "SELECT * FROM UserAlertType WHERE alert_description = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, t);
            ResultSet result = pre.executeQuery();
            if (result.next()) {
                uat = new UserAlertType(
                    result.getInt("alert_type_id"),
                    result.getString("alert_description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uat;
    }
    
    public String selectByIdR(int id) {
        Connection connection = JDBCUtil.getConnection();
        String alert_description = null;
        try {
            String sql = "SELECT * FROM UserAlertType WHERE alert_type_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet result = pre.executeQuery();
            if (result.next()) {
            alert_description = result.getString("alert_description");      
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alert_description;
    }
    
}
