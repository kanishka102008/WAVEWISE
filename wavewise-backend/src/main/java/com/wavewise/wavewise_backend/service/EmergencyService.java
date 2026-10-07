package com.wavewise.wavewise_backend.service;

import com.wavewise.wavewise_backend.entity.Emergency;
import com.wavewise.wavewise_backend.repository.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmergencyService {

    @Autowired
    private EmergencyRepository emergencyRepository;

    public Emergency sendSOS(Emergency emergency) {

        emergency.setStatus("ACTIVE");
        emergency.setEmergencyTime(LocalDateTime.now());

        return emergencyRepository.save(emergency);
    }

    public List<Emergency> getAllEmergencies() {
        return emergencyRepository.findAll();
    }
    public Emergency resolveEmergency(Long id) {

        Emergency emergency = emergencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emergency not found"));

        emergency.setStatus("RESOLVED");

        return emergencyRepository.save(emergency);
    }
}