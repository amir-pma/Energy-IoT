package com.bankino.EnergyMeterService.controller;

import com.bankino.EnergyMeterService.dto.ConsumptionCostResponse;
import com.bankino.EnergyMeterService.dto.MeterDataDTO;
import com.bankino.EnergyMeterService.model.EnergyMeter;
import com.bankino.EnergyMeterService.model.MeterData;
import com.bankino.EnergyMeterService.service.EnergyMeterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/energy_meter")
@EnableBinding(Sink.class)
@Api(description = "REST API for handling energy meters and their data.")
public class EnergyMeterController {

    private final EnergyMeterService energyMeterService;

    public EnergyMeterController(EnergyMeterService energyMeterService) {
        this.energyMeterService = energyMeterService;
    }

    @GetMapping("/{energyMeterId}")
    @ApiOperation(value = "Gets all the data an energy meter sent.")
    public List<MeterData> findAllMeterDataByEnergyMeterId(@PathVariable Long energyMeterId) {
        return energyMeterService.findAllMeterDataByEnergyMeterId(energyMeterId);
    }

    @GetMapping("/cost_between/{energyMeterId}")
    @ApiOperation(value = "Gets total cost of all data of an energy meter for period from t1 to t2.")
    public ConsumptionCostResponse getTotalCostOfMeterDataForEnergyMeterBetween(@PathVariable Long energyMeterId,
                                                                         @RequestParam("t1") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date t1,
                                                                         @RequestParam("t2") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date t2) {
        return energyMeterService.getTotalCostOfMeterDataForEnergyMeterBetween(energyMeterId, t1, t2);
    }

    @GetMapping("/cost_from/{energyMeterId}")
    @ApiOperation(value = "Gets total cost of all data of an energy meter for period from t to now.")
    public ConsumptionCostResponse getTotalCostOfMeterDataForEnergyMeterFromStart(@PathVariable Long energyMeterId,
                                                                         @RequestParam("t") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date t) {
        return energyMeterService.getTotalCostOfMeterDataForEnergyMeterFromStart(energyMeterId, t);
    }

    @PostMapping
    @ApiOperation(value = "Saves a new energy meter in database.")
    public EnergyMeter saveEnergyMeter(@RequestBody EnergyMeter energyMeter) {
        return energyMeterService.saveEnergyMeter(energyMeter);
    }

    @DeleteMapping("/{energyMeterId}")
    @ApiOperation(value = "Deletes an energy meter from database.")
    public Boolean deleteEnergyMeter(@PathVariable Long energyMeterId) {
        return energyMeterService.deleteEnergyMeter(energyMeterId);
    }

    @StreamListener("input")
    @ApiOperation(value = "Saves a new meter data in database.")
    public void saveMeterData(MeterDataDTO meterDataDTO) {
        energyMeterService.saveMeterData(meterDataDTO);
    }

    @DeleteMapping("/data/{meterDataId}")
    @ApiOperation(value = "Deletes a meter data from database.")
    public Boolean deleteMeterData(@PathVariable Long meterDataId) {
        return energyMeterService.deleteMeterData(meterDataId);
    }

}