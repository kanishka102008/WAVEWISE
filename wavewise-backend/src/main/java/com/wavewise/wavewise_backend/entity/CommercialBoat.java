package com.wavewise.wavewise_backend.entity;

import com.wavewise.wavewise_backend.service.BoatSafety;

public class CommercialBoat extends Boat implements BoatSafety {

    private int crewSize;

    public CommercialBoat() {
        super();
    }

    public CommercialBoat(Long id,
                          String boatName,
                          String registrationNumber,
                          String ownerName,
                          String fishingZone,
                          double fuelCapacity,
                          int crewSize) {

        super(id, boatName, registrationNumber, ownerName,
                fishingZone, fuelCapacity);

        this.crewSize = crewSize;
    }

    public int getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(int crewSize) {
        this.crewSize = crewSize;
    }

    public String getBoatType() {
        return "Commercial Boat";
    }

    @Override
    public String getSafetyRecommendation() {
        return "Ensure all crew members are accounted for before departure.";
    }
}