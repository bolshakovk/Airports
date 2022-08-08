package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AirportsReader {
    public List<Airport> airports = new ArrayList<>();
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
        readAirport();
        long time = System.currentTimeMillis();
        //List<Airport> newList = new ArrayList<>();
        int counter = 0;
        for (Airport airport : airports){
            if (airport.getAirportName().toUpperCase().startsWith(name.toUpperCase())){
                //newList.add(airport);
                counter++; // Выйгрыш на 3-4 милисекунды!
                System.out.println(airport.getAirportName() +"[" +airport + "]");
            }
        }
        System.out.println("founded values: " + counter);
        System.out.println("searching time: " + (System.currentTimeMillis() - time));
        //return newList;
    }
}
