package com.bankino.EnergyMeterService.repository;

import com.bankino.EnergyMeterService.model.EnergyMeter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergyMeterRepository extends JpaRepository<EnergyMeter, Long> {
}
