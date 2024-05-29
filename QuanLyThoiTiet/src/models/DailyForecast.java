package models;

public class DailyForecast {
    private int daily_forecast_id;
    private int weather_condition_id;
    private long city_id;
    private String df_date;
    private String icon;
    private long sunrise;
    private long sunset;
    private long moonrise;
    private long moonset;
    private String summary;
    private float temperature_max;
    private float temperature_min;
    private float temperature_morn;
    private float temperature_day;
    private float temperature_eve;
    private float temperature_night;
    private float feels_like_morn;
    private float feels_like_day;
    private float feels_like_eve;
    private float feels_like_night;
    private int pressure;
    private int humidity;
    private float wind_speed;
    private int clouds;
    private float uv;
    private float pop;
    private int aqi;

    public DailyForecast(int daily_forecast_id, int weather_condition_id, long city_id, String df_date, String icon, long sunrise, long sunset, long moonrise, long moonset, String summary, float temperature_max, float temperature_min, float temperature_morn, float temperature_day, float temperature_eve, float temperature_night, float feels_like_morn, float feels_like_day, float feels_like_eve, float feels_like_night, int pressure, int humidity, float wind_speed, int clouds, float uv, float pop, int aqi) {
        this.daily_forecast_id = daily_forecast_id;
        this.weather_condition_id = weather_condition_id;
        this.city_id = city_id;
        this.df_date = df_date;
        this.icon = icon;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
        this.summary = summary;
        this.temperature_max = temperature_max;
        this.temperature_min = temperature_min;
        this.temperature_morn = temperature_morn;
        this.temperature_day = temperature_day;
        this.temperature_eve = temperature_eve;
        this.temperature_night = temperature_night;
        this.feels_like_morn = feels_like_morn;
        this.feels_like_day = feels_like_day;
        this.feels_like_eve = feels_like_eve;
        this.feels_like_night = feels_like_night;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
        this.clouds = clouds;
        this.uv = uv;
        this.pop = pop;
        this.aqi = aqi;
    }

    public int getDaily_forecast_id() {
        return daily_forecast_id;
    }

    public void setDaily_forecast_id(int daily_forecast_id) {
        this.daily_forecast_id = daily_forecast_id;
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

    public String getDf_date() {
        return df_date;
    }

    public void setDf_date(String df_date) {
        this.df_date = df_date;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public long getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(long moonrise) {
        this.moonrise = moonrise;
    }

    public long getMoonset() {
        return moonset;
    }

    public void setMoonset(long moonset) {
        this.moonset = moonset;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public float getTemperature_max() {
        return temperature_max;
    }

    public void setTemperature_max(float temperature_max) {
        this.temperature_max = temperature_max;
    }

    public float getTemperature_min() {
        return temperature_min;
    }

    public void setTemperature_min(float temperature_min) {
        this.temperature_min = temperature_min;
    }

    public float getTemperature_morn() {
        return temperature_morn;
    }

    public void setTemperature_morn(float temperature_morn) {
        this.temperature_morn = temperature_morn;
    }

    public float getTemperature_day() {
        return temperature_day;
    }

    public void setTemperature_day(float temperature_day) {
        this.temperature_day = temperature_day;
    }

    public float getTemperature_eve() {
        return temperature_eve;
    }

    public void setTemperature_eve(float temperature_eve) {
        this.temperature_eve = temperature_eve;
    }

    public float getTemperature_night() {
        return temperature_night;
    }

    public void setTemperature_night(float temperature_night) {
        this.temperature_night = temperature_night;
    }

    public float getFeels_like_morn() {
        return feels_like_morn;
    }

    public void setFeels_like_morn(float feels_like_morn) {
        this.feels_like_morn = feels_like_morn;
    }

    public float getFeels_like_day() {
        return feels_like_day;
    }

    public void setFeels_like_day(float feels_like_day) {
        this.feels_like_day = feels_like_day;
    }

    public float getFeels_like_eve() {
        return feels_like_eve;
    }

    public void setFeels_like_eve(float feels_like_eve) {
        this.feels_like_eve = feels_like_eve;
    }

    public float getFeels_like_night() {
        return feels_like_night;
    }

    public void setFeels_like_night(float feels_like_night) {
        this.feels_like_night = feels_like_night;
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

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
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
