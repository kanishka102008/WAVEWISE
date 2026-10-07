package com.wavewise.wavewise_backend.service;

import com.wavewise.wavewise_backend.dto.DashboardResponse;
import com.wavewise.wavewise_backend.repository.UserRepository;
import com.wavewise.wavewise_backend.repository.BoatRepository;
import com.wavewise.wavewise_backend.repository.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoatRepository boatRepository;

    @Autowired
    private EmergencyRepository emergencyRepository;

    public DashboardResponse getDashboard() {

        long totalUsers = userRepository.count();

        long totalBoats = boatRepository.count();

        long activeEmergencies = emergencyRepository.count();

        String systemStatus = "ACTIVE";

        return new DashboardResponse(
                totalUsers,
                totalBoats,
                activeEmergencies,
                0,
                0,
                systemStatus
        );
    }
}