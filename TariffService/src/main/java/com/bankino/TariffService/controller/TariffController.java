package com.bankino.TariffService.controller;

import com.bankino.TariffService.service.TariffService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Tariff")
public class TariffController {

    private final TariffService tariffService;

    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping("/{neighbourhoodId}")
    public double getCostPerKWH(@PathVariable Long neighbourhoodId) {
        return tariffService.getTariffCost(neighbourhoodId);
    }

    @PostMapping("addEnergyMeter")
    public EnergyMeter saveEnergyMeter(@RequestBody EnergyMeter energyMeter) {
        return energyMeterService.saveEnergyMeter(energyMeter);
    }


}
