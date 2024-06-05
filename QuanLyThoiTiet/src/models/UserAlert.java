package models;

public class UserAlert {
    private int user_alert_id;
    private int nd_id;
    private int alert_type_id;
    private int city_id;
    private char condition_type;
    private float alert_value;
    private String comment;
    private boolean activated;

    public UserAlert(){
        
    }
    
    public UserAlert(int user_alert_id, int nd_id, int alert_type_id, int city_id, char condition_type, float alert_value, String comment, boolean activated) {
        this.user_alert_id = user_alert_id;
        this.nd_id = nd_id;
        this.alert_type_id = alert_type_id;
        this.city_id = city_id;
        this.condition_type = condition_type;
        this.alert_value = alert_value;
        this.comment = comment;
        this.activated = activated;
    }

    // Getters
    public int getUserAlertId() {
        return user_alert_id;
    }

    public int getNdId() {
        return nd_id;
    }

    public int getAlertTypeId() {
        return alert_type_id;
    }

    public int getCityId() {
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

    public boolean isActivated() {
        return activated;
    }

    // Setters
    public void setUserAlertId(int user_alert_id) {
        this.user_alert_id = user_alert_id;
    }

    public void setNdId(int nd_id) {
        this.nd_id = nd_id;
    }

    public void setAlertTypeId(int alert_type_id) {
        this.alert_type_id = alert_type_id;
    }

    public void setCityId(int city_id) {
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

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
