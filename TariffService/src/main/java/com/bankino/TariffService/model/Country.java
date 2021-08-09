package com.bankino.TariffService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "countries")


public class Country {

    @Id
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tariffId", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TariffPlan tariffPlan;

    @JsonIgnore
    public double getTariffPlanCost() {
        return tariffPlan.getCostPerKWH();
    }

    public Country() {
    }

    public Country(Long id, @NotNull @NotBlank String name, TariffPlan tariffPlan) {
        this.id = id;
        this.name = name;
        this.tariffPlan = tariffPlan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TariffPlan getTariffPlan() {
        return tariffPlan;
    }

    public void setTariffPlan(TariffPlan tariffPlan) {
        this.tariffPlan = tariffPlan;
    }
}