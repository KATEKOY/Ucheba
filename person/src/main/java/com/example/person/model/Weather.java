package com.example.person.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weather {
    @Id
    @GeneratedValue
    private int id;
    @NonNull
    private double latitude;
    @NonNull private double longitude;
    @NonNull private String weatherDescription;
    @NonNull private int temperature;

    public Weather ( @NonNull double latitude,  @NonNull double longitude, @NonNull String weatherDescription,  @NonNull int temperature){
        this.longitude = longitude;
        this.latitude = latitude;
        this.weatherDescription =weatherDescription;
        this.temperature = temperature;
    }

}
