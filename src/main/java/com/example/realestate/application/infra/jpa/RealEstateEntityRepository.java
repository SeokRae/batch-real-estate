package com.example.realestate.application.infra.jpa;

import com.example.realestate.application.domain.entity.RealEstateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealEstateEntityRepository extends JpaRepository<RealEstateEntity, Long> {
}