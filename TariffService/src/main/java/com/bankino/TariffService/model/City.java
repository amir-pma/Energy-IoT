package com.bankino.TariffService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

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
    @JoinColumn(name = "stateId", nullable = false)
    @JsonIgnore
    private State state;

    public double getTariffPlanCost() {
        if(tariffPlan == null)
            return state.getTariffPlanCost();
        return tariffPlan.getCostPerKWH();
    }

}