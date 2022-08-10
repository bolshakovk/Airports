package org.example;

import java.util.Objects;
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
            if(args[0].equals("2")){
                reader.findAirportsByName(search);
            }
        }
    }
}