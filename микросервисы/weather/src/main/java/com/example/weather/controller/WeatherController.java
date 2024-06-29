package com.example.weather.controller;

import com.example.weather.model.Weather;
import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/lat={latitude}&lon={longitude}")
    public Weather getWeather(@PathVariable double latitude, @PathVariable double longitude) {
        return weatherService.getWeather(latitude, longitude);
    }
}
