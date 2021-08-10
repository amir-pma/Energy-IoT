package com.bankino.EnergyMeterService.repository;

import com.bankino.EnergyMeterService.model.MeterData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterDataRepository extends JpaRepository<MeterData, Long> {
}
