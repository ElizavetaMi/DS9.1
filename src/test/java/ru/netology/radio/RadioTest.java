package ru.netology.radio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    @Test
    void testSetCurrentStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());

        radio.setCurrentStation(10);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void testNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());

        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());


        radio.setCurrentStation(3);
        radio.next();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void testPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());

        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());

        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());

        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());

        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());

        radio.setCurrentStation(-1);
        assertEquals(9, radio.getCurrentStation());

        radio.setCurrentStation(10);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testIncreaseVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testMaxVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 150; i++) {
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


}
