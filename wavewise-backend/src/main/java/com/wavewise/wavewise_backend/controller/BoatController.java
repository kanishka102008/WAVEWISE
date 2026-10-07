package com.wavewise.wavewise_backend.controller;

import com.wavewise.wavewise_backend.entity.Boat;
import com.wavewise.wavewise_backend.entity.FishingBoat;
import com.wavewise.wavewise_backend.entity.CommercialBoat;
import com.wavewise.wavewise_backend.service.BoatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boats")
public class BoatController {

    @Autowired
    private BoatService boatService;

    @PostMapping("/register")
    public Boat registerBoat(@Valid @RequestBody Boat boat) {
        return boatService.registerBoat(boat);
    }

    @GetMapping
    public List<Boat> getAllBoats() {
        return boatService.getAllBoats();
    }

    @GetMapping("/safety/fishing")
    public String fishingBoatSafety() {

        FishingBoat boat = new FishingBoat();

        return boatService.getBoatSafetyRecommendation(boat);
    }

    @GetMapping("/safety/commercial")
    public String commercialBoatSafety() {

        CommercialBoat boat = new CommercialBoat();

        return boatService.getBoatSafetyRecommendation(boat);
    }
}