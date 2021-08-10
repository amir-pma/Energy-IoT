package com.bankino.EnergyMeterService.service;

import com.bankino.EnergyMeterService.dto.ConsumptionCostResponse;
import com.bankino.EnergyMeterService.dto.MeterDataDTO;
import com.bankino.EnergyMeterService.model.EnergyMeter;
import com.bankino.EnergyMeterService.model.MeterData;
import com.bankino.EnergyMeterService.repository.EnergyMeterRepository;
import com.bankino.EnergyMeterService.repository.MeterDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class EnergyMeterService {

    @Autowired
    @Lazy
    private RestTemplate restTemplate;
    private static final String TARIFF_SERVICE_URL = "http://TARIFF-SERVICE/tariff/";

    private final EnergyMeterRepository energyMeterRepository;
    private final MeterDataRepository meterDataRepository;


    public EnergyMeterService(EnergyMeterRepository energyMeterRepository, MeterDataRepository meterDataRepository) {
        this.energyMeterRepository = energyMeterRepository;
        this.meterDataRepository = meterDataRepository;
    }

    public List<MeterData> findAllMeterDataByEnergyMeterId(Long energyMeterId) {
        return meterDataRepository.findByEnergyMeterId(energyMeterId);
    }

    public ConsumptionCostResponse findAllMeterDataForEnergyMeterBetween(Long energyMeterId, Date start, Date end) {
        List<MeterData> meterDataList = meterDataRepository.findByEnergyMeterIdIsAndTimestampBetween(energyMeterId, start, end);
        return calculateMeterDataListTotalCost(energyMeterId, meterDataList);
    }

    public ConsumptionCostResponse findAllMeterDataForEnergyMeterFromStart(Long energyMeterId, Date start) {
        List<MeterData> meterDataList = meterDataRepository.findByEnergyMeterIdIsAndTimestampGreaterThanEqual(energyMeterId, start);
        return calculateMeterDataListTotalCost(energyMeterId, meterDataList);
    }

    private ConsumptionCostResponse calculateMeterDataListTotalCost(Long energyMeterId, List<MeterData> meterDataList) {
        EnergyMeter energyMeter = energyMeterRepository.getById(energyMeterId);
        String energyMeterNeighbourhoodId = energyMeter.getNeighbourhoodId();
        double costPerKWH = restTemplate.getForObject(TARIFF_SERVICE_URL+energyMeterNeighbourhoodId, double.class);
        double totalCost = 0, totalConsumption = 0;
        for(MeterData meterData : meterDataList) {
            totalConsumption += meterData.getConsumptionKWH();
            totalCost += meterData.getConsumptionKWH() * costPerKWH;
        }
        return new ConsumptionCostResponse(totalConsumption, totalCost);
    }

    public EnergyMeter saveEnergyMeter(EnergyMeter energyMeter) {
        return energyMeterRepository.save(energyMeter);
    }

    public Boolean deleteEnergyMeter(Long id) {
        energyMeterRepository.deleteById(id);
        return true;
    }

    public MeterData saveMeterData(MeterDataDTO meterDataDTO) {
        MeterData meterData = new MeterData();
        meterData.setId(meterDataDTO.id);
        meterData.setConsumptionKWH(meterDataDTO.consumptionKWH);
        meterData.setTimestamp(meterDataDTO.timestamp);
        if(meterDataDTO.energyMeterId != null) {
            EnergyMeter energyMeter = energyMeterRepository.getById(meterDataDTO.energyMeterId);
            meterData.setEnergyMeter(energyMeter);
        }
        return meterDataRepository.save(meterData);
    }

    public Boolean deleteMeterData(Long id) {
        meterDataRepository.deleteById(id);
        return true;
    }

}
