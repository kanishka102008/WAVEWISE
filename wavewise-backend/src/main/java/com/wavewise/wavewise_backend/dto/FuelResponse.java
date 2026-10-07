package com.wavewise.wavewise_backend.dto;

public class FuelResponse {

    private double distance;
    private double fuelRequired;
    private double fuelRemaining;
    private String status;
    private String recommendation;

    public FuelResponse() {
    }

    public FuelResponse(double distance,
                        double fuelRequired,
                        double fuelRemaining,
                        String status,
                        String recommendation) {
        this.distance = distance;
        this.fuelRequired = fuelRequired;
        this.fuelRemaining = fuelRemaining;
        this.status = status;
        this.recommendation = recommendation;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getFuelRequired() {
        return fuelRequired;
    }

    public void setFuelRequired(double fuelRequired) {
        this.fuelRequired = fuelRequired;
    }

    public double getFuelRemaining() {
        return fuelRemaining;
    }

    public void setFuelRemaining(double fuelRemaining) {
        this.fuelRemaining = fuelRemaining;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}