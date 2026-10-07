package com.wavewise.wavewise_backend.repository;

import com.wavewise.wavewise_backend.entity.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRepository extends JpaRepository<Emergency, Long> {
}