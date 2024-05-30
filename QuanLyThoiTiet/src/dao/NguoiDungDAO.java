package dao;

import models.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.JDBCUtil;

public class NguoiDungDAO implements DAOInterface<NguoiDung> {

    private Connection connection = JDBCUtil.getConnection();

    public static NguoiDungDAO getInstance() {
        return new NguoiDungDAO();
    }

    @Override
    public int insert(NguoiDung t) {
        int result = -1;
        try {
            String sql = "INSERT INTO NguoiDung (UserID, Username, Email, Password, VerifyCode, current_city_fk, hashSalt, nd_language, measurement_type, utc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, t.getUserID());
            pre.setString(2, t.getUsername());
            pre.setString(3, t.getEmail());
            pre.setString(4, t.getPassword());
            pre.setString(5, t.getVerifyCode());
            pre.setLong(6, t.getCurrent_city_fk());
            pre.setString(7, t.getHashSalt());
            pre.setString(8, t.getNd_language());
            pre.setString(9, t.getMeasurement_type());
            pre.setInt(10, t.getUtc());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(NguoiDung t) {
        int result = -1;
        try {
            String sql = "UPDATE NguoiDung SET Username = ?, Email = ?, Password = ?, VerifyCode = ?, current_city_fk = ?, hashSalt = ?, nd_language = ?, measurement_type = ?, utc = ? WHERE UserID = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, t.getUsername());
            pre.setString(2, t.getEmail());
            pre.setString(3, t.getPassword());
            pre.setString(4, t.getVerifyCode());
            pre.setLong(5, t.getCurrent_city_fk());
            pre.setString(6, t.getHashSalt());
            pre.setString(7, t.getNd_language());
            pre.setString(8, t.getMeasurement_type());
            pre.setInt(9, t.getUtc());
            pre.setInt(10, t.getUserID());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(NguoiDung t) {
        int result = -1;
        try {
            String sql = "DELETE FROM NguoiDung WHERE UserID = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, t.getUserID());
            result = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<NguoiDung> selectAll() {
        ArrayList<NguoiDung> dsNguoiDung = new ArrayList<>();
        try {
            String sql = "SELECT * FROM NguoiDung";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                NguoiDung nd = new NguoiDung(
                    result.getInt("UserID"),
                    result.getString("Username"),
                    result.getString("Email"),
                    result.getString("Password"),
                    result.getString("VerifyCode"),
                    result.getLong("current_city_fk"),
                    result.getString("hashSalt"),
                    result.getString("nd_language"),
                    result.getString("measurement_type"),
                    result.getInt("utc")
                );
                dsNguoiDung.add(nd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsNguoiDung;
    }

    @Override
    public NguoiDung selectById(String t) {
        NguoiDung nd = null;
        try {
            String sql = "SELECT * FROM NguoiDung WHERE Username = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, t);
            ResultSet result = pre.executeQuery();
            if (result.next()) {
                nd = new NguoiDung(
                    result.getInt("UserID"),
                    result.getString("Username"),
                    result.getString("Email"),
                    result.getString("Password"),
                    result.getString("VerifyCode"),
                    result.getLong("current_city_fk"),
                    result.getString("hashSalt"),
                    result.getString("nd_language"),
                    result.getString("measurement_type"),
                    result.getInt("utc")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nd;
    }
    
}
