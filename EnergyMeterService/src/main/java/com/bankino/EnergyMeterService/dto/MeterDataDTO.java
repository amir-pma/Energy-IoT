package com.bankino.EnergyMeterService.dto;

import java.sql.Timestamp;

public class MeterDataDTO {

    public Long id;
    public Timestamp timestamp;
    public double consumptionKWH;
    public Long energyMeterId;

}
