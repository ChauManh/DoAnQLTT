package dao;

import models.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.JDBCUtil;
import java.text.DecimalFormat;
import java.util.Random;
import models.ModelLogin;

public class NguoiDungDAO implements DAOInterface<NguoiDung> {

    private Connection connection = JDBCUtil.getConnection();

    public static NguoiDungDAO getInstance() {
        return new NguoiDungDAO();
    }

    public NguoiDung login(ModelLogin login) throws SQLException {
        NguoiDung data = null;
        PreparedStatement p = connection.prepareStatement("select UserID, Username, Email, current_city_fk from `nguoidung` where BINARY(Email)=? and BINARY(`password`)=? and `Status`='Verified' limit 1");
        p.setString(1, login.getEmail());
        p.setString(2, login.getPassword());
        ResultSet r = p.executeQuery();
        if (r.next()) {
            int userID = r.getInt(1);
            String userName = r.getString(2);
            String email = r.getString(3);
            int user_cityId = r.getInt(4);
            data = new NguoiDung(userID, userName, email, user_cityId, "");
        }
        r.close();
        p.close();
        return data;
    }

    @Override
    public int insert(NguoiDung t) {
        int result = -1;
        try {
            String sql = "INSERT INTO NguoiDung (Username, Email, Password, VerifyCode) VALUES (?, ?, ?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            String code = generateVerifyCode();
            pre.setString(1, t.getUsername());
            pre.setString(2, t.getEmail());
            pre.setString(3, t.getPassword());
            pre.setString(4, code);
            result = pre.executeUpdate();

            ResultSet r = pre.getGeneratedKeys();
            if (r.next()) {
                int userID = r.getInt(1);
                t.setUserID(userID);
                t.setVerifyCode(code);
            }
            r.close();
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(NguoiDung t) {
        int result = -1;
        try {
            String sql = "UPDATE NguoiDung SET current_city_fk = ? WHERE UserID = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, t.getCurrent_city_fk());
            pre.setInt(2, t.getUserID());
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
                        result.getInt("current_city_fk"),
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
                        result.getInt("current_city_fk"),
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

    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  // Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = connection.prepareStatement("select UserID from `nguoidung` where VerifyCode=? limit 1");
        p.setString(1, code);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateUser(String user) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = connection.prepareStatement("select UserID from `nguoidung` where Username=? and `Status`='Verified' limit 1");
        p.setString(1, user);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateEmail(String email) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = connection.prepareStatement("select UserID from `nguoidung` where Email=? and `Status`='Verified' limit 1");
        p.setString(1, email);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public void doneVerify(int userID) throws SQLException {
        PreparedStatement p = connection.prepareStatement("update `nguoidung` set VerifyCode='', `Status`='Verified' where UserID=? limit 1");
        p.setInt(1, userID);
        p.execute();
        p.close();
    }

    public boolean verifyCodeWithUser(int userID, String code) throws SQLException {
        boolean verify = false;
        PreparedStatement p = connection.prepareStatement("select UserID from `nguoidung` where UserID=? and VerifyCode=? limit 1");
        p.setInt(1, userID);
        p.setString(2, code);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            verify = true;
        }
        r.close();
        p.close();
        return verify;
    }

}
