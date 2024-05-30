package dao;

import models.UserAlertType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.JDBCUtil;

public class UserAlertTypeDAO implements DAOInterface<UserAlertType> {

    private Connection connection = JDBCUtil.getConnection();

    public static UserAlertTypeDAO getInstance() {
        return new UserAlertTypeDAO();
    }

    @Override
    public int insert(UserAlertType t) {
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
        UserAlertType uat = null;
        try {
            String sql = "SELECT * FROM UserAlertType WHERE alert_type_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, Integer.parseInt(t));
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
}
