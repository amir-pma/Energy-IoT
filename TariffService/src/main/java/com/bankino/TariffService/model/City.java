package com.bankino.TariffService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cities")


public class City {

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
    @JoinColumn(name = "stateId", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private State state;

    @JsonIgnore
    public double getTariffPlanCost() {
        if(tariffPlan == null)
            return state.getTariffPlanCost();
        return tariffPlan.getCostPerKWH();
    }

    public City() {
    }

    public City(Long id, @NotNull @NotBlank String name, TariffPlan tariffPlan, State state) {
        this.id = id;
        this.name = name;
        this.tariffPlan = tariffPlan;
        this.state = state;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}