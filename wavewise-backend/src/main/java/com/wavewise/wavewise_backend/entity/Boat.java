package com.wavewise.wavewise_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "boats")
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Boat name is required")
    private String boatName;

    @NotBlank(message = "Registration number is required")
    @Column(unique = true)
    private String registrationNumber;

    @NotBlank(message = "Owner name is required")
    private String ownerName;

    @NotBlank(message = "Fishing zone is required")
    private String fishingZone;

    @Positive(message = "Fuel capacity must be greater than 0")
    private double fuelCapacity;

    public Boat() {
    }

    public Boat(Long id, String boatName, String registrationNumber,
                String ownerName, String fishingZone, double fuelCapacity) {
        this.id = id;
        this.boatName = boatName;
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.fishingZone = fishingZone;
        this.fuelCapacity = fuelCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoatName() {
        return boatName;
    }

    public void setBoatName(String boatName) {
        this.boatName = boatName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getFishingZone() {
        return fishingZone;
    }

    public void setFishingZone(String fishingZone) {
        this.fishingZone = fishingZone;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
}