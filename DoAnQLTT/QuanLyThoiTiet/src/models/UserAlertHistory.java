package models;

import java.util.Date;

public class UserAlertHistory {
    private int history_id;
    private int user_alert_id;
    private int nd_id;
    private long city_id;
    private char condition_type;
    private float alert_value;
    private String comment;
    private String timeframe;
    private Date activation_time;

    public UserAlertHistory(){
        
    }
    
    public UserAlertHistory(int history_id, int user_alert_id, int nd_id, long city_id, char condition_type, float alert_value, String comment, String timeframe, Date activation_time) {
        this.history_id = history_id;
        this.user_alert_id = user_alert_id;
        this.nd_id = nd_id;
        this.city_id = city_id;
        this.condition_type = condition_type;
        this.alert_value = alert_value;
        this.comment = comment;
        this.timeframe = timeframe;
        this.activation_time = activation_time;
    }

    // Getters
    public int getHistoryId() {
        return history_id;
    }

    public int getUserAlertId() {
        return user_alert_id;
    }

    public int getNdId() {
        return nd_id;
    }

    public long getCityId() {
        return city_id;
    }

    public char getConditionType() {
        return condition_type;
    }

    public float getAlertValue() {
        return alert_value;
    }

    public String getComment() {
        return comment;
    }

    public String getTimeframe() {
        return timeframe;
    }

    public Date getActivationTime() {
        return activation_time;
    }

    // Setters
    public void setHistoryId(int history_id) {
        this.history_id = history_id;
    }

    public void setUserAlertId(int user_alert_id) {
        this.user_alert_id = user_alert_id;
    }

    public void setNdId(int nd_id) {
        this.nd_id = nd_id;
    }

    public void setCityId(long city_id) {
        this.city_id = city_id;
    }

    public void setConditionType(char condition_type) {
        this.condition_type = condition_type;
    }

    public void setAlertValue(float alert_value) {
        this.alert_value = alert_value;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }

    public void setActivationTime(Date activation_time) {
        this.activation_time = activation_time;
    }
}
