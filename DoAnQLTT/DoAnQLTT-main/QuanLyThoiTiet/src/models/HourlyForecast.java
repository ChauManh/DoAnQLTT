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
    private float wind_speed; // Thêm thuộc tính này vì nó được sử dụng trong đoạn mã Java được cung cấp
    private float pop;
    private int aqi;

    public HourlyForecast(){
        
    }
    
    public HourlyForecast(int hourly_forecast_id, int weather_condition_id, long city_id, long hf_timestamp, String icon, float temperature, float feels_like, int pressure, int humidity, int clouds, float uv, int visibility, float wind_speed, float pop, int aqi) {
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
        this.wind_speed = wind_speed;
        this.pop = pop;
        this.aqi = aqi;
    }

    public int getHourly_forecast_id() {
        return hourly_forecast_id;
    }

    public void setHourly_forecast_id(int hourly_forecast_id) {
        this.hourly_forecast_id = hourly_forecast_id;
    }

    public int getWeather_condition_id() {
        return weather_condition_id;
    }

    public void setWeather_condition_id(int weather_condition_id) {
        this.weather_condition_id = weather_condition_id;
    }

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
    }

    public long getHf_timestamp() {
        return hf_timestamp;
    }

    public void setHf_timestamp(long hf_timestamp) {
        this.hf_timestamp = hf_timestamp;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public float getUv() {
        return uv;
    }

    public void setUv(float uv) {
        this.uv = uv;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public float getPop() {
        return pop;
    }

    public void setPop(float pop) {
        this.pop = pop;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }
}
