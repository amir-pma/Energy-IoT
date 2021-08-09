package com.bankino.TariffService.service;



import com.bankino.TariffService.model.EnergyMeter;
import com.bankino.TariffService.repository.EnergyMeterRepository;
import org.springframework.stereotype.Service;

@Service
public class EnergyMeterService {

    private final EnergyMeterRepository energyMeterRepository;

    public EnergyMeterService(EnergyMeterRepository energyMeterRepository) {
        this.energyMeterRepository = energyMeterRepository;
    }

    public EnergyMeter saveEnergyMeter(EnergyMeter energyMeter) {
        return energyMeterRepository.save(energyMeter);
    }
}
