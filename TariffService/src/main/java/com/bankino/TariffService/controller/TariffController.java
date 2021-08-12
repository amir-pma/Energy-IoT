package com.bankino.TariffService.controller;

import com.bankino.TariffService.dto.*;
import com.bankino.TariffService.model.*;
import com.bankino.TariffService.service.TariffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        @GetMapping("/neighbourhoodIds")
    public List<Long> getAllNeighbourhoodIds() {
        return tariffService.getAllNeighbourhoodIds();
    }

    @PostMapping("/country")
    public Country saveCountry(@RequestBody CountryDTO countryDTO) {
        return tariffService.saveCountry(countryDTO);
    }

    @DeleteMapping("/country/{countryId}")
    public Boolean deleteCountry(@PathVariable Long countryId) {
        return tariffService.deleteCountry(countryId);
    }

    @PostMapping("/city")
    public City saveCity(@RequestBody CityDTO cityDTO) {
        return tariffService.saveCity(cityDTO);
    }

    @DeleteMapping("/city/{cityId}")
    public Boolean deleteCity(@PathVariable Long cityId) {
        return tariffService.deleteCity(cityId);
    }

    @PostMapping("/state")
    public State saveState(@RequestBody StateDTO stateDTO) {
        return tariffService.saveState(stateDTO);
    }

    @DeleteMapping("/city/{stateId}")
    public Boolean deleteState(@PathVariable Long stateId) {
        return tariffService.deleteState(stateId);
    }

    @PostMapping("/district")
    public District saveDistrict(@RequestBody DistrictDTO districtDTO) {
        return tariffService.saveDistrict(districtDTO);
    }

    @DeleteMapping("/district/{districtId}")
    public Boolean deleteDistrict(@PathVariable Long districtId) {
        return tariffService.deleteDistrict(districtId);
    }

    @PostMapping("/neighbourhood")
    public Neighbourhood saveNeighbourhood(@RequestBody NeighbourhoodDTO neighbourhoodDTO) {
        return tariffService.saveNeighbourhood(neighbourhoodDTO);
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
