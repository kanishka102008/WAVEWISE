package com.wavewise.wavewise_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import java.time.LocalDateTime;

@Entity
public class Emergency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Fisherman name is required")
    private String fishermanName;

    @NotBlank(message = "Boat number is required")
    private String boatNumber;

    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private double latitude;

    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private double longitude;

    private String status;

    private LocalDateTime emergencyTime;

    public Emergency() {
    }

    public Long getId() {
        return id;
    }

    public String getFishermanName() {
        return fishermanName;
    }

    public void setFishermanName(String fishermanName) {
        this.fishermanName = fishermanName;
    }

    public String getBoatNumber() {
        return boatNumber;
    }

    public void setBoatNumber(String boatNumber) {
        this.boatNumber = boatNumber;
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

    public LocalDateTime getEmergencyTime() {
        return emergencyTime;
    }

    public void setEmergencyTime(LocalDateTime emergencyTime) {
        this.emergencyTime = emergencyTime;
    }
}