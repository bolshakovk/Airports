package org.example.readers;
import org.example.configs.Config;
import org.example.interfaces.Readable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AirportReaderByMap implements Readable {
    private static int matches;
    private final TreeMap<Integer,String> smallMap1 = new TreeMap<>();
    private long timeHasPassed;
    private static String arg;
    private int lineIndex = 0;

    public int getMatches(){
        return matches;
    }
    public void readFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(Config.AIRPORTS))) {
            String line;
            //буду хранить НЕ ВЕСЬ ФАЙЛ, а пары ключ значения, где ключ это номер строки, а значение меняется в зависимости от аргумента командной строки
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (getArg().equals("2")) {
                    smallMap1.put(lineIndex, values[1]);
                } else{
                    smallMap1.put(lineIndex, values[0]);
                }


                lineIndex++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void findValue(String name) throws IOException {
        long sTime = System.currentTimeMillis();
        matches = 0;
        if (compareStrings(name) < 0) {
            if(isFound(smallMap1, name)) {
                timeHasPassed = System.currentTimeMillis();
                printMap(smallMap1, name);
                System.out.println("searching time: " + (timeHasPassed - sTime));
            }else {
                System.out.println("matchers: " + getMatches());
                if ((timeHasPassed - sTime) < 0){
                    int t = (int)(timeHasPassed - sTime)/1000000000;
                    System.out.println("searching time: " + t);
                }
            }
        }
    }

    @Override
    public void setArg(String arg) {
        AirportReaderByMap.arg = arg;
    }

    public int getSize() {
        return matches;
    }
    public long getTimeHasPassed(){
        return timeHasPassed;
    }
    public String getArg() {
        if (arg == null){
            setArg("1");
        }
        return arg;
    }
    private int compareStrings(String s1){return s1.compareTo(Config.middle);}
    private boolean isFound(TreeMap<Integer, String> map, String name){
        if (!name.equals("")){
            for (Map.Entry<Integer, String> m : map.entrySet()){
                if (m.getValue().replace('"', ' ').trim().toUpperCase().startsWith(name.toUpperCase())){
                    timeHasPassed = System.currentTimeMillis();
                    return true;
                }
            }
        }
        return false;
    }
    private void printMap(TreeMap<Integer, String> map, String name) throws IOException {
        matches = 0;
        if (!name.equals("")) {
            for (Map.Entry<Integer, String> m : map.entrySet()) {
                if (m.getValue().replace('"', ' ').trim().toUpperCase().startsWith(name.toUpperCase())) {
                    //Считываю только строку под номером заданного ключа
                    String curLine = Files.readAllLines(Paths.get(String.valueOf(Config.AIRPORTS))).get(m.getKey());
                    System.out.println(m.getValue() + " [" + curLine + " ]");
                    matches++;
                }
            }
            System.out.println("matches: " + matches);
        }
    }
}
