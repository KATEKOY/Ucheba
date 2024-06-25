package com.example.person.controller;

import com.example.person.model.Weather;
import com.example.person.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping
    public Iterable<Weather> findAll() {
        return weatherRepository.findAll();
    }
    @GetMapping("/{latitude}/{longitude}")
    public ResponseEntity<Weather> findByCoordinates(@PathVariable double latitude, @PathVariable double longitude) {
        Optional<Weather> weather = weatherRepository.findByLatitudeAndLongitude(latitude, longitude);
        if (weather.isPresent()) {
            return ResponseEntity.ok(weather.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Weather> save(@RequestBody Weather weather) {
        return weatherRepository.findById(weather.getId()).isPresent()
                ? new ResponseEntity(weatherRepository.findById(weather.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(weatherRepository.save(weather), HttpStatus.CREATED);
    }
}
