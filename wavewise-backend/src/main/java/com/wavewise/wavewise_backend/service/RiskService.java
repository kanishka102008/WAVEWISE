package com.wavewise.wavewise_backend.service;

import com.wavewise.wavewise_backend.dto.RiskResponse;
import com.wavewise.wavewise_backend.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiskService {

    @Autowired
    private WeatherService weatherService;

    public RiskResponse calculateRisk(String location) {

        WeatherResponse weather = weatherService.getWeather(location);

        int riskScore = 0;

        // Wind Speed
        if (weather.getWindSpeed() > 20) {
            riskScore += 50;
        } else if (weather.getWindSpeed() > 10) {
            riskScore += 30;
        } else {
            riskScore += 10;
        }

        // Weather Condition
        String condition = weather.getWeather().toLowerCase();

        if (condition.contains("storm")) {
            riskScore += 40;
        } else if (condition.contains("rain")) {
            riskScore += 20;
        } else if (condition.contains("cloud")) {
            riskScore += 10;
        }

        String riskLevel;
        String recommendation;

        if (riskScore >= 70) {
            riskLevel = "HIGH";
            recommendation = "Do NOT go fishing.";
        } else if (riskScore >= 40) {
            riskLevel = "MEDIUM";
            recommendation = "Proceed with caution.";
        } else {
            riskLevel = "LOW";
            recommendation = "Safe to fish.";
        }

        return new RiskResponse(riskScore, riskLevel, recommendation);
    }
}