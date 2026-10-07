package com.wavewise.wavewise_backend.controller;

import com.wavewise.wavewise_backend.dto.FuelResponse;
import com.wavewise.wavewise_backend.service.FuelService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fuel")
@Validated
public class FuelController {

    @Autowired
    private FuelService fuelService;

    @GetMapping("/calculate")
    public FuelResponse calculateFuel(

            @RequestParam
            @Positive(message = "Distance must be greater than 0")
            double distance,

            @RequestParam
            @PositiveOrZero(message = "Fuel remaining cannot be negative")
            double fuelRemaining) {

        return fuelService.calculateFuel(
                distance,
                fuelRemaining
        );
    }
}