package org.example;

import org.example.interfaces.Readable;
import org.example.readers.AirportReaderByMap;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AirportReaderByMapTest {
    Readable read = new AirportReaderByMap();
    private final int boSizeValue = 68;
    private final int bobSizeValue = 5;

    @Test
    void foundBo() throws IOException {
        read.setArg("2");
        read.readFile();
        read.findValue("Bob");
        assertEquals(bobSizeValue, read.getSize());
    }
    @Test
    void foundBO() throws IOException {
        read.setArg("2");
        read.readFile();
        read.findValue("BO");
        assertEquals(boSizeValue, read.getSize());
    }
    @Test
    void foundbo() throws IOException {
        read.setArg("2");
        read.readFile();
        read.findValue("bo");
        assertEquals(boSizeValue, read.getSize());
    }
    @Test
    void foundNoText() throws IOException {
        read.setArg("2");
        read.readFile();
        read.findValue("");
        assertEquals(0, read.getSize());
    }
    @Test
    void isFast() throws IOException {
        read.setArg("2");
        read.readFile();
        read.findValue("bo");
        assertTrue(read.getTimeHasPassed() <=25);
    }
    @Test
    void foundDigit() throws IOException {
        read.setArg("1");
        read.readFile();
        read.findValue("123");
        assertEquals(11, read.getSize());
    }
    @Test
    void noFoundDigit() throws IOException {
        read.setArg("1");
        read.readFile();
        read.findValue("");
        assertEquals(0, read.getSize());
    }

}