package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportReaderByMapTest {
    Readable read = new AirportReaderByMap();
    private final int boSizeValue = 68;
    @Test
    void foundBo(){
        read.readFile();
        read.findValue("Bo");
        assertEquals(boSizeValue, read.getSize());
    }
    @Test
    void foundBO(){
        read.readFile();
        read.findValue("BO");
        assertEquals(boSizeValue, read.getSize());
    }
    @Test
    void foundbo(){
        read.readFile();
        read.findValue("bo");
        assertEquals(boSizeValue, read.getSize());
    }
    @Test
    void foundNoText(){
        read.readFile();
        read.findValue("");
        assertEquals(0, read.getSize());
    }
    @Test
    void isFast(){
        read.readFile();
        read.findValue("bo");
        assertTrue(read.getTimeHasPassed() <=25);
    }
}