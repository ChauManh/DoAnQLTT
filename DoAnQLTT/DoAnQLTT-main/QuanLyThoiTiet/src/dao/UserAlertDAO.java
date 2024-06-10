package dao;

import java.sql.CallableStatement;
import java.util.ArrayList;
import models.UserAlert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.JDBCUtil;
import java.sql.Types;
import javax.print.attribute.standard.PresentationDirection;
import models.CurrentWeather;
import models.NguoiDung;

public class UserAlertDAO implements DAOInterface<UserAlert> {

    public static UserAlertDAO getInstance() {
        return new UserAlertDAO();
    }

    @Override
    public ArrayList<UserAlert> selectAll() {
        Connection connection = JDBCUtil.getConnection();
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
        Connection connection = JDBCUtil.getConnection();
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
        Connection connection = JDBCUtil.getConnection();
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
    public int delete(UserAlert df) {
        Connection connection = JDBCUtil.getConnection();
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
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE UserAlert SET nd_id = ?, alert_type_id = ?, city_id = ?, condition_type = ?, alert_value = ?, comment = ? WHERE user_alert_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, ua.getNdId());
            pre.setInt(2, ua.getAlertTypeId());
            pre.setInt(3, ua.getCityId());
            pre.setString(4, String.valueOf(ua.getConditionType()));
            pre.setFloat(5, ua.getAlertValue());
            pre.setString(6, ua.getComment());
            pre.setInt(7, ua.getUserAlertId());
            return pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

//    public int setActive(UserAlert ua) {
//        Connection connection = JDBCUtil.getConnection();
//        try {
//            String sql = "UPDATE UserAlert SET activated = ? WHERE user_alert_id = ?";
//            PreparedStatement pre = connection.prepareStatement(sql);
//            pre.setInt(1, ua.getNdId());
//            pre.setInt(2, ua.getAlertTypeId());
//            pre.setInt(3, ua.getCityId());
//            pre.setString(4, String.valueOf(ua.getConditionType()));
//            pre.setFloat(5, ua.getAlertValue());
//            pre.setString(6, ua.getComment());
//            pre.setInt(7, ua.getUserAlertId());
//            return pre.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
    
    public ArrayList<UserAlert> selectAllById(NguoiDung user) {
        Connection connection = JDBCUtil.getConnection();
        ArrayList<UserAlert> dsUserAlert = new ArrayList<>();
        try {
            String sql = "CALL SelectCitiesWithMatchingUserAlertID(?);";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, user.getUserID());
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

    public int checkUserAlerts(CurrentWeather cw) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "{CALL CheckUserAlerts(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement pre = connection.prepareCall(sql);
            pre.setInt(1, cw.getCityId());
            pre.setLong(2, cw.getCurTimestamp());
            pre.setInt(3, cw.getWeatherCondition());
            pre.setString(4, cw.getIcon());
            pre.setFloat(5, cw.getTemperature());
            pre.setFloat(6, cw.getHumidity());
            pre.setInt(7, cw.getPressure());
            pre.setInt(8, cw.getHumidity());
            pre.setInt(9, cw.getClouds());
            pre.setFloat(10, cw.getUv());
            pre.setInt(11, cw.getVisibility());
            pre.setFloat(12, cw.getWindSpeed());
            pre.setInt(13, cw.getAqi());
            pre.registerOutParameter(14, Types.BIT);

            pre.execute();
            result = pre.getInt(14);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
