package com.wavewise.wavewise_backend.service;

import com.wavewise.wavewise_backend.entity.Boat;
import com.wavewise.wavewise_backend.entity.FishingBoat;
import com.wavewise.wavewise_backend.entity.CommercialBoat;
import com.wavewise.wavewise_backend.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public Boat registerBoat(Boat boat) {
        return boatRepository.save(boat);
    }

    public List<Boat> getAllBoats() {
        return boatRepository.findAll();
    }

    public String getBoatSafetyRecommendation(Boat boat) {

        BoatSafety safetyBoat;

        if (boat instanceof FishingBoat) {
            safetyBoat = (FishingBoat) boat;
        } else if (boat instanceof CommercialBoat) {
            safetyBoat = (CommercialBoat) boat;
        } else {
            return "General safety check required.";
        }

        return safetyBoat.getSafetyRecommendation();
    }
}