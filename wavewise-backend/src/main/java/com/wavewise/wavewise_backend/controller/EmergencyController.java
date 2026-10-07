package com.wavewise.wavewise_backend.controller;

import com.wavewise.wavewise_backend.entity.Emergency;
import com.wavewise.wavewise_backend.service.EmergencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergency")
public class EmergencyController {

    @Autowired
    private EmergencyService emergencyService;

    @PostMapping("/sos")
    public Emergency sendSOS(@Valid @RequestBody Emergency emergency) {
        return emergencyService.sendSOS(emergency);
    }

    @GetMapping
    public List<Emergency> getAllEmergencies() {
        return emergencyService.getAllEmergencies();
    }

    @PutMapping("/resolve/{id}")
    public Emergency resolveEmergency(@PathVariable Long id) {
        return emergencyService.resolveEmergency(id);
    }
}