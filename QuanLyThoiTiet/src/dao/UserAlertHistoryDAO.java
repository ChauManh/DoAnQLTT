package dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.JDBCUtil;
import models.NguoiDung;
import models.UserAlert;
import models.UserAlertHistory;

public class UserAlertHistoryDAO implements DAOInterface<UserAlertHistory> {
    
    
    public static UserAlertHistoryDAO getInstance() {
        return new UserAlertHistoryDAO();
    }
    
    @Override
    public int insert(UserAlertHistory uah) {
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO UserAlertHistory (user_alert_id, nd_id, city_id, condition_type, alert_value, comment, timeframe, activation_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, uah.getUserAlertId());
            pre.setInt(2, uah.getNdId());
            pre.setInt(3, uah.getCityId());
            pre.setString(4, String.valueOf(uah.getConditionType()));
            pre.setFloat(5, uah.getAlertValue());
            pre.setString(6, uah.getComment());
            pre.setString(7, uah.getTimeframe());
            pre.setTimestamp(8, new java.sql.Timestamp(uah.getActivation_time().getTime()));
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    @Override
    public int update(UserAlertHistory uah) {
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE UserAlertHistory SET user_alert_id = ?, nd_id = ?, city_id = ?, condition_type = ?, alert_value = ?, comment = ?, timeframe = ?, activation_time = ? WHERE history_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, uah.getUserAlertId());
            pre.setInt(2, uah.getNdId());
            pre.setLong(3, uah.getCityId());
            pre.setString(4, String.valueOf(uah.getConditionType()));
            pre.setFloat(5, uah.getAlertValue());
            pre.setString(6, uah.getComment());
            pre.setString(7, uah.getTimeframe());
            pre.setTimestamp(8, new java.sql.Timestamp(uah.getActivation_time().getTime()));
            pre.setInt(9, uah.getHistoryId());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    @Override
    public int delete(UserAlertHistory uah) {
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM UserAlertHistory WHERE history_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, uah.getHistoryId());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    @Override
    public ArrayList<UserAlertHistory> selectAll() {
        Connection connection = JDBCUtil.getConnection();
        ArrayList<UserAlertHistory> dsUserAlertHistory = new ArrayList<>();
        try {
            String sql = "SELECT * FROM UserAlertHistory";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                UserAlertHistory uah = new UserAlertHistory();
                uah.setHistoryId(result.getInt("history_id"));
                uah.setUserAlertId(result.getInt("user_alert_id"));
                uah.setNdId(result.getInt("nd_id"));
                uah.setCityId(result.getInt("city_id"));
                uah.setConditionType(result.getString("condition_type").charAt(0));
                uah.setAlertValue(result.getFloat("alert_value"));
                uah.setComment(result.getString("comment"));
                uah.setTimeframe(result.getString("timeframe"));
                uah.setActivation_time(result.getTimestamp("activation_time"));
                dsUserAlertHistory.add(uah);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsUserAlertHistory;
    }

    public ArrayList<UserAlertHistory> selectAllById(NguoiDung user) {
        Connection connection = JDBCUtil.getConnection();
        ArrayList<UserAlertHistory> dsUserAlertHistory = new ArrayList<>();
        try {
            String sql = "SELECT * FROM useralerthistory WHERE nd_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, user.getUserID());
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                UserAlertHistory uah = new UserAlertHistory();
                uah.setHistoryId(result.getInt("history_id"));
                uah.setAlert_type_id(result.getInt("alert_type_id"));
                uah.setNdId(result.getInt("nd_id"));
                uah.setCityId(result.getInt("city_id"));
                uah.setConditionType(result.getString("condition_type").charAt(0));
                uah.setAlertValue(result.getFloat("alert_value"));
                uah.setComment(result.getString("comment"));
                uah.setActivation_time(result.getTimestamp("activation_time"));
                dsUserAlertHistory.add(uah);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsUserAlertHistory;
    }
    
    @Override
    public UserAlertHistory selectById(String t) {
        Connection connection = JDBCUtil.getConnection();
        UserAlertHistory uah = null;
        try {
            String sql = "SELECT * FROM UserAlertHistory WHERE history_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, t);
            ResultSet result = pre.executeQuery();
            if (result.next()) {
                uah = new UserAlertHistory();
                uah.setHistoryId(result.getInt("history_id"));
                uah.setUserAlertId(result.getInt("user_alert_id"));
                uah.setNdId(result.getInt("nd_id"));
                uah.setCityId(result.getInt("city_id"));
                uah.setConditionType(result.getString("condition_type").charAt(0));
                uah.setAlertValue(result.getFloat("alert_value"));
                uah.setComment(result.getString("comment"));
                uah.setTimeframe(result.getString("timeframe"));
                uah.setActivation_time(result.getTimestamp("activation_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uah;
    }
    
    
}
