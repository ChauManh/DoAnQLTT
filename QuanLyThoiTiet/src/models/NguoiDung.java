package models;

public class NguoiDung {
    private int userID;
    private String username;
    private String email;
    private String password;
    private String verifyCode;
    private Long current_city_fk;
    private String hashSalt;
    private String nd_language;
    private String measurement_type;
    private Integer utc;
    
    public NguoiDung(int userID, String username, String email, String password, String verifyCode, Long current_city_fk, String hashSalt, String nd_language, String measurement_type, Integer utc) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
        this.current_city_fk = current_city_fk;
        this.hashSalt = hashSalt;
        this.nd_language = nd_language;
        this.measurement_type = measurement_type;
        this.utc = utc;
    }

    public NguoiDung(int userID, String username, String email, String password, String verifyCode) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
    }

    public NguoiDung(int userID, String username, String email, String password) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Long getCurrent_city_fk() {
        return current_city_fk;
    }

    public void setCurrent_city_fk(Long current_city_fk) {
        this.current_city_fk = current_city_fk;
    }

    public String getHashSalt() {
        return hashSalt;
    }

    public void setHashSalt(String hashSalt) {
        this.hashSalt = hashSalt;
    }

    public String getNd_language() {
        return nd_language;
    }

    public void setNd_language(String nd_language) {
        this.nd_language = nd_language;
    }

    public String getMeasurement_type() {
        return measurement_type;
    }

    public void setMeasurement_type(String measurement_type) {
        this.measurement_type = measurement_type;
    }

    public Integer getUtc() {
        return utc;
    }

    public void setUtc(Integer utc) {
        this.utc = utc;
    }   
    
}
