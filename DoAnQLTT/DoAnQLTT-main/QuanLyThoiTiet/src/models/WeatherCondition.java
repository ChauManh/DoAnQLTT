package models;

public class WeatherCondition {
    private int weather_condition_id;
    private String main;
    private String weather_description;

    public WeatherCondition(int weather_condition_id, String main, String weather_description) {
        this.weather_condition_id = weather_condition_id;
        this.main = main;
        this.weather_description = weather_description;
    }

    public int getWeather_condition_id() {
        return weather_condition_id;
    }

    public void setWeather_condition_id(int weather_condition_id) {
        this.weather_condition_id = weather_condition_id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getWeather_description() {
        return weather_description;
    }

    public void setWeather_description(String weather_description) {
        this.weather_description = weather_description;
    }
}
