package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        AirportsReader reader = new AirportsReader();
        reader.readAirport();
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();
        reader.findAirportsByName(search);
        scanner.close();
    }
}