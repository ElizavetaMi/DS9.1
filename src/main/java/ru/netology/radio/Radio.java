package ru.netology.radio;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private final int stationsCount;

    // Конструктор без параметров (по умолчанию 10 станций)
    public Radio() {
        this.stationsCount = 10;
    }

    // Конструктор с параметром для задания количества станций
    public Radio(int stationsCount) {
        if (stationsCount < 1) {
            this.stationsCount = 10; // Защита от некорректных значений
        } else {
            this.stationsCount = stationsCount;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < stationsCount) {
            this.currentStation = station;
        }
    }

    public void next() {
        if (currentStation >= stationsCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation <= 0) {
            currentStation = stationsCount - 1;
        } else {
            currentStation--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public int getStationsCount() {
        return stationsCount;
    }
}
