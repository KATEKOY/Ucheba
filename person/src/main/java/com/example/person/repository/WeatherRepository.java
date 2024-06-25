package com.example.person.repository;

import com.example.person.model.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Integer> {
    Optional<Weather> findByLatitudeAndLongitude(double latitude, double longitude);
}
