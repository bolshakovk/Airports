package org.example;

import org.example.interfaces.Readable;
import org.example.readers.AirportReaderByMap;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Readable readable = new AirportReaderByMap();
        Scanner scanner = new Scanner(System.in);
        readable.readFile();
        if (args[0].equals("2")){
            System.out.println("args are 2!");
            while (scanner.hasNextLine()){
                String search = scanner.nextLine().replace('"', ' ').trim();
                if (search.equals("!quit")){
                    scanner.close();
                    break;
                }
                readable.findValue(search);
            }
        } else if (args[0].equals("1")) {
            System.out.println("args are 1!");
            while (scanner.hasNextLine()){
                String search = scanner.nextLine().replace('"', ' ').trim();
                if (search.equals("!quit")){
                    scanner.close();
                    break;
                }
                readable.findValue(search);
            }
        }

    }
}