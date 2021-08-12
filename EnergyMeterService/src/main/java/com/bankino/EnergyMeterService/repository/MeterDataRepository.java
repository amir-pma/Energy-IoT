package com.bankino.EnergyMeterService.repository;

import com.bankino.EnergyMeterService.model.MeterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface MeterDataRepository extends JpaRepository<MeterData, Long> {
    List<MeterData> findByEnergyMeterId(Long energyMeterId);

    List<MeterData> findByEnergyMeterIdIsAndTimestampBetween(Long energyMeterId, Date start, Date end);

    List<MeterData> findByEnergyMeterIdIsAndTimestampGreaterThanEqual(Long energyMeterId, Date start);

//    List<MeterData> findByTimestampGreaterThanEqual(Timestamp timestamp);

    @Query("select coalesce(sum(e.consumptionKWH), 0) from #{#entityName} e where e.energyMeter.id = ?1 and e.timestamp > ?2 and e.timestamp < ?3")
    double findSumBetweenForEnergyMeter(Long energyMeterId, Timestamp timestamp1, Timestamp timestamp2);
}
