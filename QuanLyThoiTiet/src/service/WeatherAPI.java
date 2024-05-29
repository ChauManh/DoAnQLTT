package service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import models.CurrentWeather;
import org.json.simple.JSONArray;

public class WeatherAPI {

//    private static final String API_KEY = "c3c95da6b898af1425bd63705b1f1fad";

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
        currentWeather.setTemperature(Float.parseFloat(currentWeatherFromAPI.get("temp").toString())-272.15f);
        currentWeather.setFeels_like(Float.parseFloat(currentWeatherFromAPI.get("feels_like").toString())-272.15f);
        currentWeather.setPressure(Integer.parseInt(currentWeatherFromAPI.get("pressure").toString()));
        currentWeather.setHumidity(Integer.parseInt(currentWeatherFromAPI.get("humidity").toString()));
        currentWeather.setClouds(Integer.parseInt(currentWeatherFromAPI.get("clouds").toString()));
        currentWeather.setUv(Float.parseFloat(currentWeatherFromAPI.get("uvi").toString()));
        currentWeather.setVisibility(Integer.parseInt(currentWeatherFromAPI.get("visibility").toString())/1000);
        currentWeather.setWindSpeed(Float.parseFloat(currentWeatherFromAPI.get("wind_speed").toString()));
        currentWeather.setAqi(0);
        return currentWeather;
    }
}
