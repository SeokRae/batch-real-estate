package com.example.realestate.application.infra.jpa;

import com.example.realestate.application.domain.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Long> {
}