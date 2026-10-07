package com.wavewise.wavewise_backend.entity;

import com.wavewise.wavewise_backend.service.BoatSafety;

public class FishingBoat extends Boat implements BoatSafety {

    private String fishingMethod;

    public FishingBoat() {
        super();
    }

    public FishingBoat(Long id,
                       String boatName,
                       String registrationNumber,
                       String ownerName,
                       String fishingZone,
                       double fuelCapacity,
                       String fishingMethod) {

        super(id, boatName, registrationNumber, ownerName,
                fishingZone, fuelCapacity);

        this.fishingMethod = fishingMethod;
    }

    public String getFishingMethod() {
        return fishingMethod;
    }

    public void setFishingMethod(String fishingMethod) {
        this.fishingMethod = fishingMethod;
    }

    public String getBoatType() {
        return "Fishing Boat";
    }

    @Override
    public String getSafetyRecommendation() {
        return "Check weather and fuel before fishing.";
    }
}