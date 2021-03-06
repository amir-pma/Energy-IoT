package com.bankino.TariffService.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tariffPlans")


public class TariffPlan {

    @Id
    private Long id;

    @NotNull
    @Column(name = "costPerKWH")
    private double costPerKWH;

    public double getCostPerKWH() {
        return costPerKWH;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCostPerKWH(double costPerKWH) {
        this.costPerKWH = costPerKWH;
    }

    public TariffPlan() {
    }

    public TariffPlan(Long id, @NotNull double costPerKWH) {
        this.id = id;
        this.costPerKWH = costPerKWH;
    }
}