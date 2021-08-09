package com.bankino.TariffService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "districts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @Id
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tariffId", nullable = true)
    @JsonIgnore
    private TariffPlan tariffPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityId", nullable = false)
    @JsonIgnore
    private City city;

    public double getTariffPlanCost() {
        if(tariffPlan == null)
            return city.getTariffPlanCost();
        return tariffPlan.getCostPerKWH();
    }

}