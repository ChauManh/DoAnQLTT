package models;

public class HourlyForecast {
    private int hourly_forecast_id;
    private int weather_condition_id;
    private long city_id;
    private long hf_timestamp;
    private String icon;
    private float temperature;
    private float feels_like;
    private int pressure;
    private int humidity;
    private int clouds;
    private float uv;
    private int visibility;
    private float pop;
    private int aqi;

    public HourlyForecast(int hourly_forecast_id, int weather_condition_id, long city_id, long hf_timestamp, String icon, float temperature, float feels_like, int pressure, int humidity, int clouds, float uv, int visibility, float pop, int aqi) {
        this.hourly_forecast_id = hourly_forecast_id;
        this.weather_condition_id = weather_condition_id;
        this.city_id = city_id;
        this.hf_timestamp = hf_timestamp;
        this.icon = icon;
        this.temperature = temperature;
        this.feels_like = feels_like;
        this.pressure = pressure;
        this.humidity = humidity;
        this.clouds = clouds;
        this.uv = uv;
        this.visibility = visibility;
        this.pop = pop;
        this.aqi = aqi;
    }

    // Getters and setters...
}
