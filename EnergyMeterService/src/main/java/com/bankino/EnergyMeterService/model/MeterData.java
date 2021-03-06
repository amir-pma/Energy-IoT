package com.bankino.EnergyMeterService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "meterDatas")
public class MeterData {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "timestamp", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @NotNull
    @Column(name = "consumptionKWH")
    private double consumptionKWH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "energyMeterId", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private EnergyMeter energyMeter;

    public MeterData(Long id, EnergyMeter energyMeter, Date timestamp, @NotNull double consumptionKWH) {
        this.id = id;
        this.energyMeter = energyMeter;
        this.timestamp = timestamp;
        this.consumptionKWH = consumptionKWH;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getConsumptionKWH() {
        return consumptionKWH;
    }

    public void setConsumptionKWH(double consumptionKWH) {
        this.consumptionKWH = consumptionKWH;
    }

    public EnergyMeter getEnergyMeter() {
        return energyMeter;
    }

    public void setEnergyMeter(EnergyMeter energyMeter) {
        this.energyMeter = energyMeter;
    }

    public MeterData() {
    }
}