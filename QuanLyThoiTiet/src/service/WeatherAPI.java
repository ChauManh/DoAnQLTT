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
import models.HourlyForecast;
import org.json.simple.JSONArray;

public class WeatherAPI {

    public static JSONObject getWeatherData(double latitude, double longitude) {
       String url = "https://api.openweathermap.org/data/3.0/onecall?lat=" + latitude +
                    "&lon=" + longitude + "&appid=cd4158b1848491276e2a4f3647d430af";
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
            hourlyForecast.setVisibility(Integer.parseInt(hourlyData.get("visibility").toString()));
            hourlyForecast.setWind_speed(Float.parseFloat(hourlyData.get("wind_speed").toString()));

            JSONArray weatherArray = (JSONArray) hourlyData.get("weather");
            JSONObject weatherObject = (JSONObject) weatherArray.get(0);
            hourlyForecast.setWeather_condition_id( Integer.parseInt(weatherObject.get("id").toString()));
            hourlyForecast.setIcon(weatherObject.get("icon").toString());

            hourlyForecasts.add(hourlyForecast);
        }
        return hourlyForecasts;
    }
}
