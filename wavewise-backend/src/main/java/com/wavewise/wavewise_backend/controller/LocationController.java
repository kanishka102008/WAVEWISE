package com.wavewise.wavewise_backend.controller;

import com.wavewise.wavewise_backend.dto.LocationRequest;
import com.wavewise.wavewise_backend.dto.LocationResponse;
import com.wavewise.wavewise_backend.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/update")
    public LocationResponse updateLocation(
            @Valid @RequestBody LocationRequest locationRequest) {

        return locationService.updateLocation(
                locationRequest.getLatitude(),
                locationRequest.getLongitude()
        );
    }
}