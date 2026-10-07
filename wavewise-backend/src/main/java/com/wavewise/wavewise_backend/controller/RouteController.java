package com.wavewise.wavewise_backend.controller;

import com.wavewise.wavewise_backend.dto.RouteResponse;
import com.wavewise.wavewise_backend.service.RouteService;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/route")
@Validated
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/plan")
    public RouteResponse planRoute(

            @RequestParam
            @DecimalMin(value = "-90.0", message = "Start latitude must be between -90 and 90")
            @DecimalMax(value = "90.0", message = "Start latitude must be between -90 and 90")
            double startLatitude,

            @RequestParam
            @DecimalMin(value = "-180.0", message = "Start longitude must be between -180 and 180")
            @DecimalMax(value = "180.0", message = "Start longitude must be between -180 and 180")
            double startLongitude,

            @RequestParam
            @DecimalMin(value = "-90.0", message = "Destination latitude must be between -90 and 90")
            @DecimalMax(value = "90.0", message = "Destination latitude must be between -90 and 90")
            double destinationLatitude,

            @RequestParam
            @DecimalMin(value = "-180.0", message = "Destination longitude must be between -180 and 180")
            @DecimalMax(value = "180.0", message = "Destination longitude must be between -180 and 180")
            double destinationLongitude) {

        return routeService.planRoute(
                startLatitude,
                startLongitude,
                destinationLatitude,
                destinationLongitude
        );
    }
}