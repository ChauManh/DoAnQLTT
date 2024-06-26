package models;

public class City {
    private int city_id;
    private String city_name;
    private String county_id;
    private double latitude;
    private double longitude;

    public City(int city_id, String city_name, String county_id, double latitude, double longitude) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.county_id = county_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    
    
    public City(){
    }
    
    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCounty_id() {
        return county_id;
    }

    public void setCounty_id(String county_id) {
        this.county_id = county_id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongtitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "City{" + "city_id=" + city_id + ", city_name=" + city_name + ", county_id=" + county_id + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }


    
}
