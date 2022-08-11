package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Readable readable = new AirportReaderByMap();
        Scanner scanner = new Scanner(System.in);
        readable.readFile();
        while (scanner.hasNextLine()){
            String search = scanner.nextLine().replace('"', ' ').trim();
            System.out.println(search);
            if (search.equals("!quit")){
                scanner.close();
                break;
            }
            readable.findValue(search);
        }
    }
}