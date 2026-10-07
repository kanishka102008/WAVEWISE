package com.wavewise.wavewise_backend.weather;

import com.wavewise.wavewise_backend.dto.WeatherResponse;
import com.wavewise.wavewise_backend.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin(origins = "http://localhost:5173")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{location}")
    public WeatherResponse getWeather(@PathVariable String location) {

        if (location == null || location.trim().isEmpty()) {
            throw new RuntimeException("Location is required");
        }

        return weatherService.getWeather(location);
    }
}