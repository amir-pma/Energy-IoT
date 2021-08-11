package com.bankino.EnergyMeterService.repository;

import com.bankino.EnergyMeterService.model.EnergyMeter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Date;

public interface EnergyMeterRepository extends JpaRepository<EnergyMeter, Long> {

    @Modifying
    @Query("update EnergyMeter energyMeter set energyMeter.lastDataTimeStamp = ?1 where energyMeter.id = ?2")
    void setLastDataTimeStampForEnergyMeter(Timestamp timestamp, Long energyMeterId);

}
