package com.bankino.TariffService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "neighbourhoods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Neighbourhood {

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
    @JoinColumn(name = "districtId", nullable = false)
    @JsonIgnore
    private District district;

    public TariffPlan getTariffPlan() {
        if(tariffPlan == null)
            return district.getTariffPlan();
        return tariffPlan;
    }

}