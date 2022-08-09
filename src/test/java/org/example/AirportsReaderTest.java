package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AirportsReaderTest {
    AirportsReader reader = new AirportsReader();
    private final int boSizeValue = 68;
    @Test
    void isFoundBo() {
        reader.readAirport();
        reader.findAirportsByName("Bo");
        assertEquals(reader.getSize(), boSizeValue);
    }
    @Test
    void isFoundBO() {
        reader.readAirport();
        reader.findAirportsByName("BO");
        assertEquals(reader.getSize(), boSizeValue);
    }
    @Test
    void isFounbo() {
        reader.readAirport();
        reader.findAirportsByName("bo");
        assertEquals(reader.getSize(), boSizeValue);
    }
    @Test
    void isTimed() {
        reader.readAirport();
        reader.findAirportsByName("bo");
        assertTrue(reader.getTimeHasPassed() <= 25);
    }
    @Test
    void isNoText() {
        reader.readAirport();
        List<Airport> checkList = reader.getAirports("");
        int size = checkList.size();
        assertEquals(size, 0);
    }
    @Test
    void isDigitSearch() {
        reader.readAirport();
        List<Airport> checkList = reader.getAirports("1234");
        int size = checkList.size();
        assertEquals(size, 0);
    }
}