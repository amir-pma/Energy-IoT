package com.bankino.EnergyMeterService.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "energyMeters")
public class EnergyMeter {

    @Id
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "stakeholderEmail")
    private String stakeholderEmail;

    @NotNull
    @NotBlank
    @Column(name = "neighbourhoodId")
    private String neighbourhoodId;

    @Column(name = "lastDataTimeStamp", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastDataTimeStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStakeholderEmail() {
        return stakeholderEmail;
    }

    public void setStakeholderEmail(String stakeholderEmail) {
        this.stakeholderEmail = stakeholderEmail;
    }

    public String getNeighbourhoodId() {
        return neighbourhoodId;
    }

    public void setNeighbourhoodId(String neighbourhoodId) {
        this.neighbourhoodId = neighbourhoodId;
    }

    public EnergyMeter() {
    }

    public EnergyMeter(Long id, @NotNull @NotBlank String stakeholderEmail, @NotNull @NotBlank String neighbourhoodId) {
        this.id = id;
        this.stakeholderEmail = stakeholderEmail;
        this.neighbourhoodId = neighbourhoodId;
    }
}
