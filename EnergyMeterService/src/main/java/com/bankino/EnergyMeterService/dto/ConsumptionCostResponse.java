package com.bankino.EnergyMeterService.dto;

public class ConsumptionCostResponse {
    private double consumptionKW;
    private double cost;

    public ConsumptionCostResponse(double consumptionKW, double cost) {
        this.consumptionKW = consumptionKW;
        this.cost = cost;
    }

    public ConsumptionCostResponse() {
    }

    public double getConsumptionKW() {
        return consumptionKW;
    }

    public void setConsumptionKW(double consumptionKW) {
        this.consumptionKW = consumptionKW;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
