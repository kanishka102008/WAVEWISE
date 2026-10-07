package com.wavewise.wavewise_backend.service;

import com.wavewise.wavewise_backend.dto.FuelResponse;
import org.springframework.stereotype.Service;

@Service
public class FuelService {

    public FuelResponse calculateFuel(double distance, double fuelRemaining) {

        // Assumption: boat consumes 2 litres per 10 km
        double fuelRequired = (distance / 10) * 2;

        String status;
        String recommendation;

        if (fuelRequired > fuelRemaining) {
            status = "INSUFFICIENT";
            recommendation = "Fuel is not sufficient for this journey.";
        } else if (fuelRequired > fuelRemaining * 0.8) {
            status = "LOW";
            recommendation = "Fuel is sufficient, but maintain a safe reserve.";
        } else {
            status = "SUFFICIENT";
            recommendation = "Fuel is sufficient for the planned journey.";
        }

        return new FuelResponse(
                distance,
                fuelRequired,
                fuelRemaining,
                status,
                recommendation
        );
    }
}