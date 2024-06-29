package com.example.weather.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weather {
    @NonNull
    private MainInfo main;

    @Data
    public static class MainInfo {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;
        private int sea_level;
        private int grnd_level;
    }

}