package models;

public class CurrentWeather {
    private int currenWeatherId;
    private int cityId;
    private int weatherCondition;
    private int curTimestamp;
    private String icon;
    private float temperature;
    private float feels_like;
    private int pressure;
    private int humidity;
    private int clouds;
    private float uv;
    private int visibility;
    private float windSpeed;
    private int aqi;

    public CurrentWeather(int currenWeatherId, int cityId, int weatherCondition, int curTimestamp, String icon, float temperature, float feels_like, int pressure, int humidity, int clouds, float uv, int visibility, float windSpeed, int aqi) {
        this.currenWeatherId = currenWeatherId;
        this.cityId = cityId;
        this.weatherCondition = weatherCondition;
        this.curTimestamp = curTimestamp;
        this.icon = icon;
        this.temperature = temperature;
        this.feels_like = feels_like;
        this.pressure = pressure;
        this.humidity = humidity;
        this.clouds = clouds;
        this.uv = uv;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.aqi = aqi;
    }

    public CurrentWeather(){
        
    }
    
    public int getCurrenWeatherId() {
        return currenWeatherId;
    }

    public void setCurrenWeatherId(int currenWeatherId) {
        this.currenWeatherId = currenWeatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(int weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public int getCurTimestamp() {
        return curTimestamp;
    }

    public void setCurTimestamp(int curTimestamp) {
        this.curTimestamp = curTimestamp;
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

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" + "currenWeatherId=" + currenWeatherId + ", cityId=" + cityId + ", weatherCondition=" + weatherCondition + ", curTimestamp=" + curTimestamp + ", icon=" + icon + ", temperature=" + temperature + ", feels_like=" + feels_like + ", pressure=" + pressure + ", humidity=" + humidity + ", clouds=" + clouds + ", uv=" + uv + ", visibility=" + visibility + ", windSpeed=" + windSpeed + ", aqi=" + aqi + '}';
    }
    
    
    
}
