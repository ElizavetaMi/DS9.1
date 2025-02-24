package ru.netology.radio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    @Test
    void testDefaultConstructor() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationsCount());
    }

    @Test
    void testParameterizedConstructor() {
        Radio radio = new Radio(15);
        assertEquals(15, radio.getStationsCount());
    }

    @Test
    void testInvalidStationCount() {
        Radio radio = new Radio(0);
        assertEquals(10, radio.getStationsCount());
    }

    @Test
    void testSetCurrentStationValid() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void testSetCurrentStationInvalid() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(15);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testNextStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testPrevStation() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolume() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testMaxVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void testMinVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 10; i++) {
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testNextStationIncrements() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(4);
        radio.next();
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void testNextStationWrapAround() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());}

    @Test
    void testPrevStationDecrements() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }


    @Test
    void testPrevStationWrapAround() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testDecreaseVolumeDecrements() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testMinVolumeDoesNotDecreaseBelowZero() {
        Radio radio = new Radio();
        for (int i = 0; i < 10; i++) {
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testMaxVolumeLimit() {
        Radio radio = new Radio();

        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void testMinVolumeLimit() {
        Radio radio = new Radio();
        for (int i = 0; i < 10; i++) {
            radio.decreaseVolume();
        }
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}