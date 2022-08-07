package org.example;


public class Airport {
    private int id;

    private String airportName;

    private String cityName;

    private String country;

    @Override
    public String toString() {
        return "Airports{" +
                "id=" + id +
                ", airportName='" + airportName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
