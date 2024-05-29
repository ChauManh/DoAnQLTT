
package model;


public class ModelUser {
    int userID;
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
    String email;
    String password;
    String verifyCode;
    int currentCity;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public int getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(int currentCity) {
        this.currentCity = currentCity;
    }

    public ModelUser(int userID, String userName, String email, String password, String verifyCode) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
    }
    
    public ModelUser(int userID, String userName, String email, String password) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    
    public ModelUser(int userID, String userName, String email, String password, int currentCity) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.currentCity = currentCity;
    }
    
    public ModelUser(){
        
    }
}
