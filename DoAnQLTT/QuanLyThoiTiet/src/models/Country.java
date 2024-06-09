package models;

public class Country {
    private String county_id;
    private String county_name;

    public Country(String county_id, String county_name) {
        this.county_id = county_id;
        this.county_name = county_name;
    }

    public String getCountry_id() {
        return county_id;
    }

    public void setCountry_id(String county_id) {
        this.county_id = county_id;
    }

    public String getCountry_name() {
        return county_name;
    }

    public void setCountry_name(String county_name) {
        this.county_name = county_name;
    }
}
