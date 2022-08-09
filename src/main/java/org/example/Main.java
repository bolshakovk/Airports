package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        AirportsReader reader = new AirportsReader();
        reader.readAirport();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String search = scanner.nextLine();
            if (search.equals("!quit")){
                scanner.close();
                break;
            }
            reader.findAirportsByName(search);
        }
    }
}