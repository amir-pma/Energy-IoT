package com.bankino.EnergyMeterService.service;

import com.bankino.EnergyMeterService.repository.EnergyMeterRepository;
import com.bankino.EnergyMeterService.repository.MeterDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

public class EnergyMeterService {

    @Autowired
    @Lazy
    private RestTemplate template;

    private final EnergyMeterRepository energyMeterRepository;
    private final MeterDataRepository meterDataRepository;


    public EnergyMeterService(EnergyMeterRepository energyMeterRepository, MeterDataRepository meterDataRepository) {
        this.energyMeterRepository = energyMeterRepository;
        this.meterDataRepository = meterDataRepository;
    }
}
