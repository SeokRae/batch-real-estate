package com.example.realestate.application.infra.jpa;

import com.example.realestate.application.domain.entity.TradingRealEstate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradingRealEstateRepository extends JpaRepository<TradingRealEstate, Long> {
}