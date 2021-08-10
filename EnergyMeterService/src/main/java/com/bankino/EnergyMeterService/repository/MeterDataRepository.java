package com.bankino.EnergyMeterService.repository;

import com.bankino.EnergyMeterService.model.MeterData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

public interface MeterDataRepository extends JpaRepository<MeterData, Long> {
    List<MeterData> findByEnergyMeterId(Long energyMeterId);

    List<MeterData> findByEnergyMeterIdIsAndTimestampBetween(Long energyMeterId, Date start, Date end);

    List<MeterData> findByEnergyMeterIdIsAndTimestampGreaterThanEqual(Long energyMeterId, Date start);
}
