package models;

public class UserAlert {
    private int user_alert_id;
    private int nd_id;
    private int alert_type_id;
    private long city_id;
    private char condition_type;
    private float alert_value;
    private String comment;
    private String timeframe;
    private int activated;

    public UserAlert(int user_alert_id, int nd_id, int alert_type_id, long city_id, char condition_type, float alert_value, String comment, String timeframe, int activated) {
        this.user_alert_id = user_alert_id;
        this.nd_id = nd_id;
        this.alert_type_id = alert_type_id;
        this.city_id = city_id;
        this.condition_type = condition_type;
        this.alert_value = alert_value;
        this.comment = comment;
        this.timeframe = timeframe;
        this.activated = activated;
    }

    // Getters and setters...
}
