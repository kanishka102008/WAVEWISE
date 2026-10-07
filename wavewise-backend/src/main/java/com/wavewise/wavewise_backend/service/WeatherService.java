package com.wavewise.wavewise_backend.service;

import com.wavewise.wavewise_backend.dto.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    public WeatherResponse getWeather(String location) {

        WeatherResponse response = new WeatherResponse();

        response.setLocation(location);
        response.setTemperature(28.0);
        response.setWindSpeed(18.0);
        response.setWeather("High Waves");

        // Safety decision based on wind speed
        if (response.getWindSpeed() > 15) {

            response.setSafetyStatus("UNSAFE");

            response.setRecommendation(
                    "Strong winds detected. Avoid fishing and move to a safe location."
            );

        } else {

            response.setSafetyStatus("SAFE");

            response.setRecommendation(
                    "Weather conditions are suitable for fishing."
            );
        }

        return response;
    }
}