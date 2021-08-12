package com.bankino.EnergyMeterService.scheduled;

import com.bankino.EnergyMeterService.service.EnergyMeterService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EnergyMeterScheduledMonitor {

    private static final long ENERGY_METER_ALLOWED_DEACTIVATED_PERIOD = 60 * 1000; //2*60*60*1000 (2 hours)
    private static final long CHECK_NEIGHBOURHOOD_USAGE_PERIOD = 2 * 60 * 1000; //1*24*60*60*1000 (1 day)
    private static final long CHECK_METER_SUSPICIOUS_USAGE_PERIOD = 2 * 60 * 1000; //1*24*60*60*1000 (1 day)

    private final EnergyMeterService energyMeterService;

    public EnergyMeterScheduledMonitor(EnergyMeterService energyMeterService) {
        this.energyMeterService = energyMeterService;
    }

    @Scheduled(fixedRate = ENERGY_METER_ALLOWED_DEACTIVATED_PERIOD)
    public void checkEnergyMeterLastUpdate() {
        energyMeterService.checkEnergyMeterLastUpdate();
    }

    @Scheduled(fixedRate = CHECK_NEIGHBOURHOOD_USAGE_PERIOD)
    public void checkNeighbourhoodUsage() {
        energyMeterService.checkNeighbourhoodUsage();
    }

    @Scheduled(fixedRate = CHECK_METER_SUSPICIOUS_USAGE_PERIOD)
    public void checkMeterSuspiciousUsage() {
        energyMeterService.checkMeterSuspiciousUsage();
    }
}
