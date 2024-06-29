package com.example.weather.service;
import com.example.weather.model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    @Value("${openweathermap.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeatherService() {
        this.restTemplate = new RestTemplate();
    }

    public Weather getWeather(double latitude, double longitude) {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude +
                "&lon=" + longitude + "&appid=" + apiKey;

        Weather weather = restTemplate.getForObject(url, Weather.class);

        if (weather != null && weather.getMain() != null) {
            double celsiusTemp = weather.getMain().getTemp() - 273.15;
            double celsiusFeelsLike = weather.getMain().getFeels_like() - 273.15;
            double celsiusTempMin = weather.getMain().getTemp_min() -273.15;
            double celsiusTempMax = weather.getMain().getTemp_max() -273.15;
            weather.getMain().setTemp(celsiusTemp);
            weather.getMain().setFeels_like(celsiusFeelsLike);
            weather.getMain().setTemp_min(celsiusTempMin);
            weather.getMain().setTemp_max(celsiusTempMax);
        }

        return weather;
    }
}
