package com.bankino.EnergyMeterService.controller;

import com.bankino.EnergyMeterService.dto.ConsumptionCostResponse;
import com.bankino.EnergyMeterService.dto.MeterDataDTO;
import com.bankino.EnergyMeterService.model.EnergyMeter;
import com.bankino.EnergyMeterService.model.MeterData;
import com.bankino.EnergyMeterService.service.EnergyMeterService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/energy_meter")
@EnableBinding(Sink.class)
public class EnergyMeterController {

    private final EnergyMeterService energyMeterService;

    public EnergyMeterController(EnergyMeterService energyMeterService) {
        this.energyMeterService = energyMeterService;
    }

    @GetMapping("/{energyMeterId}")
    public List<MeterData> findAllMeterDataByEnergyMeterId(@PathVariable Long energyMeterId) {
        return energyMeterService.findAllMeterDataByEnergyMeterId(energyMeterId);
    }

    @GetMapping("/cost_between/{energyMeterId}")
    public ConsumptionCostResponse findAllMeterDataForEnergyMeterBetween(@PathVariable Long energyMeterId,
                                                                         @RequestParam("t1") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date t1,
                                                                         @RequestParam("t2") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date t2) {
        return energyMeterService.findAllMeterDataForEnergyMeterBetween(energyMeterId, t1, t2);
    }

    @GetMapping("/cost_from/{energyMeterId}")
    public ConsumptionCostResponse findAllMeterDataForEnergyMeterFromStart(@PathVariable Long energyMeterId,
                                                                         @RequestParam("t") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date t) {
        return energyMeterService.findAllMeterDataForEnergyMeterFromStart(energyMeterId, t);
    }

    @PostMapping
    public EnergyMeter saveEnergyMeter(@RequestBody EnergyMeter energyMeter) {
        return energyMeterService.saveEnergyMeter(energyMeter);
    }

    @DeleteMapping("/{energyMeterId}")
    public Boolean deleteEnergyMeter(@PathVariable Long energyMeterId) {
        return energyMeterService.deleteEnergyMeter(energyMeterId);
    }

    @StreamListener("input")
    public void saveMeterData(MeterDataDTO meterDataDTO) {
        energyMeterService.saveMeterData(meterDataDTO);
    }

    @DeleteMapping("/data/{meterDataId}")
    public Boolean deleteMeterData(@PathVariable Long meterDataId) {
        return energyMeterService.deleteMeterData(meterDataId);
    }

}