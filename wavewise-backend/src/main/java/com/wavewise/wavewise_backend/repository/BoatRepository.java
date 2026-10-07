package com.wavewise.wavewise_backend.repository;

import com.wavewise.wavewise_backend.entity.Boat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoatRepository extends JpaRepository<Boat, Long> {
}