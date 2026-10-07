package com.wavewise.wavewise_backend.controller;

import com.wavewise.wavewise_backend.dto.BorderResponse;
import com.wavewise.wavewise_backend.dto.LocationRequest;
import com.wavewise.wavewise_backend.service.BorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/border")
public class BorderController {

    @Autowired
    private BorderService borderService;

    @GetMapping("/check")
    public BorderResponse checkBorder() {

        LocationRequest location = new LocationRequest();

        location.setLatitude(9.60);
        location.setLongitude(79.80);

        return borderService.checkBorder(location);
    }
}