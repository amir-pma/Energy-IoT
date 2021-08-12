package com.bankino.EnergyMeterService.repository;

import com.bankino.EnergyMeterService.model.EnergyMeter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface EnergyMeterRepository extends JpaRepository<EnergyMeter, Long> {

    @Modifying
    @Query("update EnergyMeter energyMeter set energyMeter.lastDataTimestamp = ?1, energyMeter.alerted = false where energyMeter.id = ?2")
    void setLastDataTimeStampForEnergyMeter(Timestamp timestamp, Long energyMeterId);

    @Modifying
    @Query("update EnergyMeter energyMeter set energyMeter.alerted = ?1 where energyMeter.id = ?2")
    void setAlertedForEnergyMeter(Boolean alerted, Long energyMeterId);

    List<EnergyMeter> findByAlertedIsAndLastDataTimestampLessThanEqual(Boolean alerted, Timestamp timestamp);

    @Query("select e.id from #{#entityName} e")
    List<Long> getAllIds();

}
