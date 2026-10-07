package com.wavewise.wavewise_backend.dto;

public class LocationResponse {

    private double latitude;
    private double longitude;
    private String status;
    private String message;

    public LocationResponse() {
    }

    public LocationResponse(double latitude,
                            double longitude,
                            String status,
                            String message) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.message = message;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}