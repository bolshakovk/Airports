package org.example;

import org.example.interfaces.Readable;
import org.example.readers.AirportReaderByMap;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void scanningLines(Readable readable, Scanner scanner) throws IOException {
        while (scanner.hasNextLine()){
            String search = scanner.nextLine().replace('"', ' ').trim();
            if (search.equals("!quit")){
                scanner.close();
                break;
            }
            readable.findValue(search);
        }
    }
    public static void main(String[] args) throws IOException {
        Readable readable = new AirportReaderByMap();
        Scanner scanner = new Scanner(System.in);
        readable.readFile();
        if (args.length == 0){
            readable.setArg("1");
            scanningLines(readable,scanner);
            System.out.println("no args passed, find by digit default");
        }
        else if (args[0].equals("2")){
            scanningLines(readable,scanner);
        } else if (args[0].equals("1")) {
            scanningLines(readable,scanner);
        }
    }
}