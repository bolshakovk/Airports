package org.example;
/*
    Поиск ведется по колонке 2, airportName, следовательно позволил себе не определять такие поля как широта, долгота и
    т.п. В ТЗ так же указано что не важно за что отвечают колонки, но для репрезентативности перегрузил пару полей.
 */

public class Airport {
    private int id;

    private String airportName;

    private String cityName;

    private String country;

    @Override
    public String toString() {
        return id+ " "  + airportName+ " " + cityName+ " " + country;

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
