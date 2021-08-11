package com.bankino.EnergyMeterService.scheduled;

import com.bankino.EnergyMeterService.service.EnergyMeterService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EnergyMeterScheduledMonitor {

    private static final long ENERGY_METER_ALLOWED_DEACTIVATED_PERIOD = 60 * 1000; //2*60*60*1000 (2 hours)

    private final EnergyMeterService energyMeterService;

    public EnergyMeterScheduledMonitor(EnergyMeterService energyMeterService) {
        this.energyMeterService = energyMeterService;
    }

    @Scheduled(fixedRate = ENERGY_METER_ALLOWED_DEACTIVATED_PERIOD)
    public void checkEnergyMeterLastUpdate() {
        energyMeterService.checkEnergyMeterLastUpdate();
    }
}
