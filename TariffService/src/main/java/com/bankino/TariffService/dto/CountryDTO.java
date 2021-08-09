package com.bankino.TariffService.dto;

import javax.validation.constraints.NotNull;

public class CountryDTO {

    public Long id;
    public String name;
    @NotNull
    public Long tariffPlanId;
}