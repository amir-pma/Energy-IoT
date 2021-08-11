package com.bankino.EnergyMeterService.service;

import com.bankino.EnergyMeterService.dto.Alert;
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

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class EnergyMeterService {

    @Autowired
    @Lazy
    private RestTemplate restTemplate;
    private static final String TARIFF_SERVICE_URL = "http://TARIFF-SERVICE/tariff/";
    private static final String ALERT_SERVICE_URL = "http://ALERT-SERVICE/alert/";
    private static final String DEFAULT_STAKEHOLDER_MAIL = "defaultAlertAddress@gmail.com";
    private static final String DEFAULT_ALERT_MAIL_SUBJECT = "Alert from EnergyIOT";
    private static final String ENERGY_METER_NOT_ADDED_ALERT_TEXT = "Alert: Energy Meter not added for this meter data!";
    private static final String CONSUMPTION_THRESHOLD_ALERT_TEXT = "Alert: Electricity consumption in data too high!";
    private static final double CONSUMPTION_THRESHOLD = 50;

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

    @Transactional
    public MeterData saveMeterData(MeterDataDTO meterDataDTO) {
        MeterData meterData = new MeterData();
        meterData.setConsumptionKWH(meterDataDTO.consumptionKWH);
        meterData.setTimestamp(meterDataDTO.timestamp);
        if(energyMeterRepository.existsById(meterDataDTO.energyMeterId)) {
            EnergyMeter energyMeter = energyMeterRepository.getById(meterDataDTO.energyMeterId);
            meterData.setEnergyMeter(energyMeter);
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            energyMeterRepository.setLastDataTimeStampForEnergyMeter(timestamp, meterDataDTO.energyMeterId);
            if(meterDataDTO.consumptionKWH > CONSUMPTION_THRESHOLD) {
                sendAlertMail(DEFAULT_ALERT_MAIL_SUBJECT, energyMeter.getStakeholderEmail(), CONSUMPTION_THRESHOLD_ALERT_TEXT);
            }
            return meterDataRepository.save(meterData);
        }
        else {
            sendAlertMail(DEFAULT_ALERT_MAIL_SUBJECT, DEFAULT_STAKEHOLDER_MAIL, ENERGY_METER_NOT_ADDED_ALERT_TEXT);
            if(meterDataDTO.consumptionKWH > CONSUMPTION_THRESHOLD) {
                sendAlertMail(DEFAULT_ALERT_MAIL_SUBJECT, DEFAULT_STAKEHOLDER_MAIL, CONSUMPTION_THRESHOLD_ALERT_TEXT);
            }
            return null;
        }
    }

    private void sendAlertMail(String mailSubject, String toMail, String mailText) {
        System.out.println(mailText);
        Alert alert = new Alert(mailSubject, toMail, mailText);
        restTemplate.postForObject(ALERT_SERVICE_URL, alert, void.class);
    }

    public Boolean deleteMeterData(Long id) {
        meterDataRepository.deleteById(id);
        return true;
    }

}
