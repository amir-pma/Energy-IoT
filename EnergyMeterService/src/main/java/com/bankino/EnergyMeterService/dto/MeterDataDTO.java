package com.bankino.EnergyMeterService.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class MeterDataDTO {

    public Date timestamp;
    public double consumptionKWH;

    @NotNull
    public Long energyMeterId;

}
