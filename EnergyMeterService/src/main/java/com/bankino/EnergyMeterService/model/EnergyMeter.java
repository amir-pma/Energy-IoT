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
    private Date lastDataTimestamp;

    @Column(name = "alerted")
    private Boolean alerted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStakeholderEmail() {
        return stakeholderEmail;
    }

    public Date getLastDataTimestamp() {
        return lastDataTimestamp;
    }

    public void setLastDataTimestamp(Date lastDataTimeStamp) {
        this.lastDataTimestamp = lastDataTimeStamp;
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

    public Boolean getAlerted() {
        return alerted;
    }

    public void setAlerted(Boolean alerted) {
        this.alerted = alerted;
    }

    public EnergyMeter(Long id, @NotNull @NotBlank String stakeholderEmail, @NotNull @NotBlank String neighbourhoodId, Date lastDataTimestamp, Boolean alerted) {
        this.id = id;
        this.stakeholderEmail = stakeholderEmail;
        this.neighbourhoodId = neighbourhoodId;
        this.lastDataTimestamp = lastDataTimestamp;
        this.alerted = alerted;
    }
}
