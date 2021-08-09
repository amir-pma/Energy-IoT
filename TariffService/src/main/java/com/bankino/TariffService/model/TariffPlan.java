package com.bankino.TariffService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tariffPlans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffPlan {

    @Id
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "costPerKWH")
    private double costPerKWH;

    public double getCostPerKWH() {
        return costPerKWH;
    }
}