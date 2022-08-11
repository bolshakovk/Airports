package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AirportReaderByMap implements Readable {
    private int matches = 0;
    private final TreeMap<String,String> smallMap1 = new TreeMap<>();
    private long timeHasPassed;

    public void readFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(Config.AIRPORTS))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                smallMap1.put(values[1], Arrays.toString(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void findValue(String name) {
        long time = System.currentTimeMillis();
        if (compareStrings(name) < 0) {
            if (isFound(smallMap1, name)){
                printMap(smallMap1, name);
            }
            timeHasPassed = System.currentTimeMillis() - time;
            System.out.println("searching time: " + timeHasPassed);
        }
    }

    @Override
    public int getSize() {
        return matches;
    }
    public long getTimeHasPassed(){
        return timeHasPassed;
    }

    private int compareStrings(String s1){return s1.compareTo(Config.middle);}
    private boolean isFound(TreeMap<String, String> map, String name){
        if (!name.equals("")){
            for (Map.Entry<String, String> m : map.entrySet()){
                if (m.getKey().replace('"', ' ').trim().toUpperCase().startsWith(name.toUpperCase())){
                    return true;
                }
            }
        }
        return false;
    }
    private void printMap(TreeMap<String, String> map, String name){
        matches = 0;
        for (Map.Entry<String, String> m : map.entrySet()){
            if (m.getKey().equals("")){
            }else if (m.getKey().replace('"', ' ').trim().toUpperCase().startsWith(name.toUpperCase())){
                matches++;
                System.out.println(m.getKey() + " " + m.getValue());
            }
        }
        System.out.println(matches);
    }
}
