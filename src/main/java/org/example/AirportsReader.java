package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AirportsReader {
    private int counter;
    private long timeHasPassed;
    private List<Airport> airports = new ArrayList<>();
    public void readAirport(){
        try (BufferedReader br = new BufferedReader(new FileReader(Config.AIRPORTS))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Airport airport = new Airport();
                airport.setId(Integer.parseInt(values[0]));
                airport.setAirportName(values[1].replace('"', ' ').trim()); // для поиска по значению без ковычек и пробелов
                airport.setCityName(values[2]);
                airport.setCountry(values[3]);
                airports.add(airport);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Придерживался принципа single-responsibility
    public void  findAirportsByName(String name){
        long time = System.currentTimeMillis();
        //List<Airport> newList = new ArrayList<>();
        counter = 0;
        for (Airport airport : airports){
            if (name.equals("")){
                System.out.println("No text value");
                break;
            }
            if (airport.getAirportName().toUpperCase().startsWith(name.toUpperCase())){
                //newList.add(airport);
                counter++; // Выйгрыш на 3-4 милисекунды!
                System.out.println(airport.getAirportName() +"[" +airport + "]");
            }
        }
        timeHasPassed = System.currentTimeMillis() - time;
        System.out.println("founded values: " + counter);
        System.out.println("searching time: " + timeHasPassed);
        //return newList;
    }
    // Для тестирования
    public int getSize(){
        return counter;
    }
    public long getTimeHasPassed(){
        return timeHasPassed;
    }
    public List<Airport> getAirports(String name){
        List<Airport> newList = new ArrayList<>();
        for (Airport airport : airports) {
            if (name.equals("")) {
                System.out.println("No text value");
                break;
            }
            if (airport.getAirportName().toUpperCase().startsWith(name.toUpperCase())) {
                newList.add(airport);
                System.out.println(airport.getAirportName() + "[" + airport + "]");

            }
        }
        System.out.println("founded values: " + counter);
        return newList;
    }
}
