package org.example;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        AirportsReader reader = new AirportsReader();
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();
        scanner.close();
        reader.findAirportsByName(search);
    }
}