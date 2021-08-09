package com.bankino.TariffService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "districts")


public class District {

    @Id
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tariffId", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TariffPlan tariffPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityId", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private City city;

    @JsonIgnore
    public double getTariffPlanCost() {
        if(tariffPlan == null)
            return city.getTariffPlanCost();
        return tariffPlan.getCostPerKWH();
    }

    public District(Long id, @NotNull @NotBlank String name, TariffPlan tariffPlan, City city) {
        this.id = id;
        this.name = name;
        this.tariffPlan = tariffPlan;
        this.city = city;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District() {
    }
}