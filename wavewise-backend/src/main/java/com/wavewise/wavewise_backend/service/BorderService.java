package com.wavewise.wavewise_backend.service;

import com.wavewise.wavewise_backend.dto.BorderResponse;
import com.wavewise.wavewise_backend.dto.LocationRequest;
import org.springframework.stereotype.Service;

@Service
public class BorderService {

    public BorderResponse checkBorder(LocationRequest location) {

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        // Demo maritime boundary coordinates
        double boundaryLatitude = 9.50;
        double minLongitude = 79.00;
        double maxLongitude = 80.00;

        if (latitude >= boundaryLatitude
                && longitude >= minLongitude
                && longitude <= maxLongitude) {

            return new BorderResponse(
                    "WARNING",
                    "You are approaching the international maritime boundary. Turn back immediately."
            );
        }

        return new BorderResponse(
                "SAFE",
                "You are in the safe fishing zone."
        );
    }
}