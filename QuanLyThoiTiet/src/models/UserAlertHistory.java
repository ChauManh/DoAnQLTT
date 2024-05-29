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

    // Getters and setters...
}
