package dao;

import java.util.ArrayList;
import models.UserAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.JDBCUtil;

public class UserAlertDAO implements DAOInterface<UserAlert> {
    
    Connection connection = JDBCUtil.getConnection();
    
    public static UserAlertDAO getInstance() {
        return new UserAlertDAO();
    }
   
    @Override
    public ArrayList<UserAlert> selectAll () {
        ArrayList<UserAlert> dsUserAlert = new ArrayList<>();
        try {
            String sql = "SELECT * FROM UserAlert";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                UserAlert ua = new UserAlert();
                ua.setUserAlertId(result.getInt("user_alert_id"));
                ua.setNdId(result.getInt("nd_id"));
                ua.setAlertTypeId(result.getInt("alert_type_id"));
                ua.setCityId(result.getInt("city_id"));
                ua.setConditionType(result.getString("condition_type").charAt(0));
                ua.setAlertValue(result.getFloat("alert_value"));
                ua.setComment(result.getString("comment"));
                ua.setActivated(result.getBoolean("activated"));
                dsUserAlert.add(ua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsUserAlert;
    }

    @Override
    public UserAlert selectById(String userAlertId) {
        UserAlert ua = null;
        try {
            String sql = "SELECT * FROM UserAlert WHERE user_alert_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, userAlertId);
            ResultSet result = pre.executeQuery();
            if (result.next()) {
                ua = new UserAlert();
                ua.setUserAlertId(result.getInt("user_alert_id"));
                ua.setNdId(result.getInt("nd_id"));
                ua.setAlertTypeId(result.getInt("alert_type_id"));
                ua.setCityId(result.getInt("city_id"));
                ua.setConditionType(result.getString("condition_type").charAt(0));
                ua.setAlertValue(result.getFloat("alert_value"));
                ua.setComment(result.getString("comment"));
                ua.setActivated(result.getBoolean("activated"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ua;
    }

    @Override
    public int insert(UserAlert ua) {
        try {
            String sql = "INSERT INTO UserAlert (nd_id, alert_type_id, city_id, condition_type, alert_value, comment, activated) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, ua.getNdId());
            pre.setInt(2, ua.getAlertTypeId());
            pre.setInt(3, ua.getCityId());
            pre.setString(4, String.valueOf(ua.getConditionType()));
            pre.setFloat(5, ua.getAlertValue());
            pre.setString(6, ua.getComment());
            pre.setBoolean(7, ua.isActivated());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    
    @Override
    public int delete (UserAlert df) {
        try {
            String sql = "DELETE FROM UserAlert WHERE user_alert_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, df.getAlertTypeId());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    
    @Override
    public int update(UserAlert ua) {
        try {
            String sql = "UPDATE UserAlert SET nd_id = ?, alert_type_id = ?, city_id = ?, condition_type = ?, alert_value = ?, comment = ?, timeframe = ?, activated = ? WHERE user_alert_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, ua.getNdId());
            pre.setInt(2, ua.getAlertTypeId());
            pre.setInt(3, ua.getCityId());
            pre.setString(4, String.valueOf(ua.getConditionType()));
            pre.setFloat(5, ua.getAlertValue());
            pre.setString(6, ua.getComment());
            pre.setBoolean(7, ua.isActivated());
            pre.setInt(8, ua.getUserAlertId());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

