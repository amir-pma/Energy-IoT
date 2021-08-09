package com.bankino.TariffService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "neighbourhoods")


public class Neighbourhood {

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
    @JoinColumn(name = "districtId", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private District district;

    @JsonIgnore
    public double getTariffPlanCost() {
        if(tariffPlan == null)
            return district.getTariffPlanCost();
        return tariffPlan.getCostPerKWH();
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Neighbourhood(Long id, @NotNull @NotBlank String name, TariffPlan tariffPlan, District district) {
        this.id = id;
        this.name = name;
        this.tariffPlan = tariffPlan;
        this.district = district;
    }

    public Neighbourhood() {
    }
}