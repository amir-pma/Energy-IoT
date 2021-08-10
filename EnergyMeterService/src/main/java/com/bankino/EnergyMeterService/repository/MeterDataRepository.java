package com.bankino.EnergyMeterService.repository;

import com.bankino.EnergyMeterService.model.MeterData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface MeterDataRepository extends JpaRepository<MeterData, Long> {
    List<MeterData> findByEnergyMeterId(Long energyMeterId);

    List<MeterData> findByEnergyMeterIdIsAndTimestampBetween(Long energyMeterId, Timestamp start, Timestamp end);

    List<MeterData> findByEnergyMeterIdIsAndTimestampGreaterThanEqual(Long energyMeterId, Timestamp start);
}
