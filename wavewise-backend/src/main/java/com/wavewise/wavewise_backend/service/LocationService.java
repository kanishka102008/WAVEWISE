package com.wavewise.wavewise_backend.service;

import com.wavewise.wavewise_backend.dto.LocationResponse;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    public LocationResponse updateLocation(double latitude, double longitude) {

        String status = "ACTIVE";
        String message = "GPS location updated successfully.";

        return new LocationResponse(
                latitude,
                longitude,
                status,
                message
        );
    }
}