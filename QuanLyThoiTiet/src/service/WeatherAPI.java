package service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.CurrentWeather;
import models.DailyForecast;
import models.HourlyForecast;
import org.json.simple.JSONArray;

public class WeatherAPI {

    public static JSONObject getWeatherData(double latitude, double longitude) {
       String url = "https://api.openweathermap.org/data/3.0/onecall?lat=" + latitude +
                    "&lon=" + longitude + "&appid=f443d3b3fec99501b4d2ef262a3acdd5";
        try {
            HttpURLConnection apiConnection = fetchApiResponse(url);
            if (apiConnection.getResponseCode() != 200) {
                System.out.println("Error: Could not connect to API");
                return null;
            }
            String jsonResponse = readApiResponse(apiConnection);
            JSONParser parser = new JSONParser();
            return (JSONObject) parser.parse(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static HttpURLConnection fetchApiResponse(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        return conn;
    }

    private static String readApiResponse(HttpURLConnection apiConnection) throws IOException {
        StringBuilder resultJson = new StringBuilder();
        Scanner scanner = new Scanner(apiConnection.getInputStream());
        while (scanner.hasNext()) {
            resultJson.append(scanner.nextLine());
        }
        scanner.close();
        return resultJson.toString();
    }
    
    public static CurrentWeather getCurrentWeather(double latitude, double longitude, int city_id) {
        CurrentWeather currentWeather = new CurrentWeather();
        JSONObject weatherDataFromAPI = WeatherAPI.getWeatherData(latitude, longitude);
        JSONObject currentWeatherFromAPI = (JSONObject) weatherDataFromAPI.get("current");
        JSONArray weatherArray = (JSONArray) currentWeatherFromAPI.get("weather");

        JSONObject currentWeatherObject = (JSONObject) weatherArray.get(0);
        int IdCondition = Integer.parseInt(currentWeatherObject.get("id").toString());
        currentWeather.setCityId(city_id); // ID của thành phố
        currentWeather.setWeatherCondition(IdCondition); // Điều kiện thời tiết
        currentWeather.setCurTimestamp(Integer.parseInt(currentWeatherFromAPI.get("dt").toString())); // Thời gian của dữ liệu thời tiết hiện tại
        currentWeather.setIcon(currentWeatherObject.get("icon").toString()); // Biểu tượng thời tiết
        currentWeather.setTemperature(Float.parseFloat(currentWeatherFromAPI.get("temp").toString())-273.15f);
        currentWeather.setFeels_like(Float.parseFloat(currentWeatherFromAPI.get("feels_like").toString())-273.15f);
        currentWeather.setPressure(Integer.parseInt(currentWeatherFromAPI.get("pressure").toString()));
        currentWeather.setHumidity(Integer.parseInt(currentWeatherFromAPI.get("humidity").toString()));
        currentWeather.setClouds(Integer.parseInt(currentWeatherFromAPI.get("clouds").toString()));
        currentWeather.setUv(Float.parseFloat(currentWeatherFromAPI.get("uvi").toString()));
        currentWeather.setVisibility(Integer.parseInt(currentWeatherFromAPI.get("visibility").toString())/1000);
        currentWeather.setWindSpeed(Float.parseFloat(currentWeatherFromAPI.get("wind_speed").toString()));
        currentWeather.setAqi(0);
        return currentWeather;
    }
    
    public static List<HourlyForecast> getHourlyForecast(double latitude, double longitude, int city_id) {
        List<HourlyForecast> hourlyForecasts = new ArrayList<>();
        JSONObject weatherDataFromAPI = WeatherAPI.getWeatherData(latitude, longitude);
        JSONArray hourlyArray = (JSONArray) weatherDataFromAPI.get("hourly");

        for (Object hourlyObj : hourlyArray) {
            JSONObject hourlyData = (JSONObject) hourlyObj;
            HourlyForecast hourlyForecast = new HourlyForecast();
            
            hourlyForecast.setCity_id(city_id);
            hourlyForecast.setHf_timestamp(Long.parseLong(hourlyData.get("dt").toString()));
            hourlyForecast.setTemperature(Float.parseFloat(hourlyData.get("temp").toString()) - 273.15f);
            hourlyForecast.setFeels_like(Float.parseFloat(hourlyData.get("feels_like").toString()) - 273.15f);
            hourlyForecast.setPressure(Integer.parseInt(hourlyData.get("pressure").toString()));
            hourlyForecast.setHumidity(Integer.parseInt(hourlyData.get("humidity").toString()));
            hourlyForecast.setClouds(Integer.parseInt(hourlyData.get("clouds").toString()));
            hourlyForecast.setUv(Float.parseFloat(hourlyData.get("uvi").toString()));
            hourlyForecast.setVisibility(Integer.parseInt(hourlyData.get("visibility").toString())/1000);
            hourlyForecast.setWind_speed(Float.parseFloat(hourlyData.get("wind_speed").toString()));

            JSONArray weatherArray = (JSONArray) hourlyData.get("weather");
            JSONObject weatherObject = (JSONObject) weatherArray.get(0);
            hourlyForecast.setWeather_condition_id( Integer.parseInt(weatherObject.get("id").toString()));
            hourlyForecast.setIcon(weatherObject.get("icon").toString());

            hourlyForecasts.add(hourlyForecast);
        }
        return hourlyForecasts;
    }
    
    public static List<DailyForecast> getDailyForecast(double latitude, double longitude, int city_id) {
        List<DailyForecast> dailyForecasts = new ArrayList<>();
        JSONObject weatherDataFromAPI = WeatherAPI.getWeatherData(latitude, longitude);
        JSONArray dailyArray = (JSONArray) weatherDataFromAPI.get("daily");

        for (Object dailyObj : dailyArray) {
            JSONObject dailyData = (JSONObject) dailyObj;
            DailyForecast dailyForecast = new DailyForecast();

            dailyForecast.setCity_id(city_id);
            dailyForecast.setDf_date(Long.parseLong(dailyData.get("dt").toString()));
            dailyForecast.setSunrise(Long.parseLong(dailyData.get("sunrise").toString()));
            dailyForecast.setSunset(Long.parseLong(dailyData.get("sunset").toString()));
            dailyForecast.setMoonrise(Long.parseLong(dailyData.get("moonrise").toString()));
            dailyForecast.setMoonset(Long.parseLong(dailyData.get("moonset").toString()));
            
            JSONObject tempObject = (JSONObject) dailyData.get("temp");
            dailyForecast.setTemperature_day(Float.parseFloat(tempObject.get("day").toString()) - 273.15f);
            dailyForecast.setTemperature_min(Float.parseFloat(tempObject.get("min").toString()) - 273.15f);
            dailyForecast.setTemperature_max(Float.parseFloat(tempObject.get("max").toString()) - 273.15f);
            dailyForecast.setTemperature_night(Float.parseFloat(tempObject.get("night").toString()) - 273.15f);
            dailyForecast.setTemperature_eve(Float.parseFloat(tempObject.get("eve").toString()) - 273.15f);
            dailyForecast.setTemperature_morn(Float.parseFloat(tempObject.get("morn").toString()) - 273.15f);
            
            JSONObject feelsLikeObject = (JSONObject) dailyData.get("feels_like");
            dailyForecast.setFeels_like_day(Float.parseFloat(feelsLikeObject.get("day").toString()) - 273.15f);
            dailyForecast.setFeels_like_night(Float.parseFloat(feelsLikeObject.get("night").toString()) - 273.15f);
            dailyForecast.setFeels_like_eve(Float.parseFloat(feelsLikeObject.get("eve").toString()) - 273.15f);
            dailyForecast.setFeels_like_morn(Float.parseFloat(feelsLikeObject.get("morn").toString()) - 273.15f);
            
            dailyForecast.setPressure(Integer.parseInt(dailyData.get("pressure").toString()));
            dailyForecast.setHumidity(Integer.parseInt(dailyData.get("humidity").toString()));
            dailyForecast.setWind_speed(Float.parseFloat(dailyData.get("wind_speed").toString()));
            dailyForecast.setClouds(Integer.parseInt(dailyData.get("clouds").toString()));
            dailyForecast.setPop(Float.parseFloat(dailyData.get("pop").toString()));
            dailyForecast.setUv(Float.parseFloat(dailyData.get("uvi").toString()));

            JSONArray weatherArray = (JSONArray) dailyData.get("weather");
            JSONObject weatherObject = (JSONObject) weatherArray.get(0);
            dailyForecast.setWeather_condition_id(Integer.parseInt(weatherObject.get("id").toString()));
            dailyForecast.setIcon(weatherObject.get("icon").toString());
            dailyForecasts.add(dailyForecast);
        }
        return dailyForecasts;
    }
}
