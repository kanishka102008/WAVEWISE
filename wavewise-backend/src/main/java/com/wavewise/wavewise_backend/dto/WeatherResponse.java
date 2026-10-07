package com.wavewise.wavewise_backend.dto;

public class WeatherResponse {

    private String location;
    private String weather;
    private double temperature;
    private double windSpeed;
    private String safetyStatus;
    private String recommendation;

    public WeatherResponse() {
    }

    public WeatherResponse(String location, String weather, double temperature,
                           double windSpeed, String safetyStatus,
                           String recommendation) {
        this.location = location;
        this.weather = weather;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.safetyStatus = safetyStatus;
        this.recommendation = recommendation;
    }

    // Getters and Setters

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getSafetyStatus() {
        return safetyStatus;
    }

    public void setSafetyStatus(String safetyStatus) {
        this.safetyStatus = safetyStatus;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}