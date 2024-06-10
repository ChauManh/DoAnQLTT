package models;

public class UserAlertType {
    private int alert_type_id;
    private String alert_description;

    public UserAlertType(int alert_type_id, String alert_description) {
        this.alert_type_id = alert_type_id;
        this.alert_description = alert_description;
    }

    public int getAlert_type_id() {
        return alert_type_id;
    }

    public void setAlert_type_id(int alert_type_id) {
        this.alert_type_id = alert_type_id;
    }

    public String getAlert_description() {
        return alert_description;
    }

    public void setAlert_description(String alert_description) {
        this.alert_description = alert_description;
    }
}
