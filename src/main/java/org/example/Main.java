package org.example;

import org.example.interfaces.Readable;
import org.example.readers.AirportReaderByMap;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void scanningLines(Readable readable, Scanner scanner) throws IOException {
        readable.readFile();
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
        if (args.length == 0){
            System.out.println("no args passed, seeking with arg 1");
            scanningLines(readable,scanner);
        }
        else if (args[0].equals("2")){
            readable.setArg(args[0]);
            scanningLines(readable,scanner);
        } else if (args[0].equals("1")) {
            readable.setArg(args[0]);
            scanningLines(readable,scanner);
        }
    }
}