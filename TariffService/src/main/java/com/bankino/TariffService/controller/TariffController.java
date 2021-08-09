package com.bankino.TariffService.controller;

import com.bankino.TariffService.model.*;
import com.bankino.TariffService.service.TariffService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tariff")
public class TariffController {

    private final TariffService tariffService;

    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping("/{neighbourhoodId}")
    public double getCostPerKWH(@PathVariable Long neighbourhoodId) {
        return tariffService.getTariffCost(neighbourhoodId);
    }

    @PostMapping("/country")
    public Country saveCountry(@RequestBody Country country) {
        return tariffService.saveCountry(country);
    }

    @DeleteMapping("/country/{countryId}")
    public Boolean deleteCountry(@PathVariable Long countryId) {
        return tariffService.deleteCountry(countryId);
    }

    @PostMapping("/city")
    public City saveCity(@RequestBody City city) {
        return tariffService.saveCity(city);
    }

    @DeleteMapping("/city/{cityId}")
    public Boolean deleteCity(@PathVariable Long cityId) {
        return tariffService.deleteCity(cityId);
    }

    @PostMapping("/state")
    public State saveState(@RequestBody State state) {
        return tariffService.saveState(state);
    }

    @DeleteMapping("/city/{stateId}")
    public Boolean deleteState(@PathVariable Long stateId) {
        return tariffService.deleteState(stateId);
    }

    @PostMapping("/district")
    public District saveDistrict(@RequestBody District district) {
        return tariffService.saveDistrict(district);
    }

    @DeleteMapping("/district/{districtId}")
    public Boolean deleteDistrict(@PathVariable Long districtId) {
        return tariffService.deleteDistrict(districtId);
    }

    @PostMapping("/neighbourhood")
    public Neighbourhood saveNeighbourhood(@RequestBody Neighbourhood neighbourhood) {
        return tariffService.saveNeighbourhood(neighbourhood);
    }

    @DeleteMapping("/neighbourhood/{neighbourhoodId}")
    public Boolean deleteNeighbourhood(@PathVariable Long neighbourhoodId) {
        return tariffService.deleteNeighbourhood(neighbourhoodId);
    }

    @PostMapping("/tariffPlan")
    public TariffPlan saveTariffPlan(@RequestBody TariffPlan tariffPlan) {
        return tariffService.saveTariffPlan(tariffPlan);
    }

    @DeleteMapping("/tariffPlan/{tariffPlanId}")
    public Boolean deleteTariffPlan(@PathVariable Long tariffPlanId) {
        return tariffService.deleteTariffPlan(tariffPlanId);
    }


}
