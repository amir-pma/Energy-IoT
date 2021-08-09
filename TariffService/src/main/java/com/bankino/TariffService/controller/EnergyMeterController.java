package com.bankino.TariffService.controller;


import com.bankino.EnergyMeterService.model.EnergyMeter;
import com.bankino.EnergyMeterService.service.EnergyMeterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("EnergyMeter")
public class EnergyMeterController {

    private final EnergyMeterService energyMeterService;

    public EnergyMeterController(EnergyMeterService energyMeterService) {
        this.energyMeterService = energyMeterService;
    }

    @PostMapping("addEnergyMeter")
    public EnergyMeter saveEnergyMeter(@RequestBody EnergyMeter energyMeter) {
        return energyMeterService.saveEnergyMeter(energyMeter);
    }


}
