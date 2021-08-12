package com.bankino.TariffService.controller;

import com.bankino.TariffService.dto.*;
import com.bankino.TariffService.model.*;
import com.bankino.TariffService.service.TariffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tariff")
@Api(description = "REST API for handling tariff plans and regions that use them.")
public class TariffController {

    private final TariffService tariffService;

    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping("/{neighbourhoodId}")
    @ApiOperation(value = "Gets tariff plan for a neighbourhood.")
    public double getCostPerKWH(@PathVariable Long neighbourhoodId) {
        return tariffService.getTariffCost(neighbourhoodId);
    }

    @GetMapping("/neighbourhoodIds")
    @ApiOperation(value = "Gets all available neighborhood ids.")
    public List<Long> getAllNeighbourhoodIds() {
        return tariffService.getAllNeighbourhoodIds();
    }

    @PostMapping("/country")
    @ApiOperation(value = "Saves a new country in database.")
    public Country saveCountry(@RequestBody CountryDTO countryDTO) {
        return tariffService.saveCountry(countryDTO);
    }

    @DeleteMapping("/country/{countryId}")
    @ApiOperation(value = "Deletes a country from database.")
    public Boolean deleteCountry(@PathVariable Long countryId) {
        return tariffService.deleteCountry(countryId);
    }

    @PostMapping("/city")
    @ApiOperation(value = "Saves a new city in database.")
    public City saveCity(@RequestBody CityDTO cityDTO) {
        return tariffService.saveCity(cityDTO);
    }

    @DeleteMapping("/city/{cityId}")
    @ApiOperation(value = "Deletes a city from database.")
    public Boolean deleteCity(@PathVariable Long cityId) {
        return tariffService.deleteCity(cityId);
    }

    @PostMapping("/state")
    @ApiOperation(value = "Saves a new state in database.")
    public State saveState(@RequestBody StateDTO stateDTO) {
        return tariffService.saveState(stateDTO);
    }

    @DeleteMapping("/city/{stateId}")
    @ApiOperation(value = "Deletes a state from database.")
    public Boolean deleteState(@PathVariable Long stateId) {
        return tariffService.deleteState(stateId);
    }

    @PostMapping("/district")
    @ApiOperation(value = "Saves a new district in database.")
    public District saveDistrict(@RequestBody DistrictDTO districtDTO) {
        return tariffService.saveDistrict(districtDTO);
    }

    @DeleteMapping("/district/{districtId}")
    @ApiOperation(value = "Deletes a district from database.")
    public Boolean deleteDistrict(@PathVariable Long districtId) {
        return tariffService.deleteDistrict(districtId);
    }

    @PostMapping("/neighbourhood")
    @ApiOperation(value = "Saves a new neighbourhood in database.")
    public Neighbourhood saveNeighbourhood(@RequestBody NeighbourhoodDTO neighbourhoodDTO) {
        return tariffService.saveNeighbourhood(neighbourhoodDTO);
    }

    @DeleteMapping("/neighbourhood/{neighbourhoodId}")
    @ApiOperation(value = "Deletes a neighbourhood from database.")
    public Boolean deleteNeighbourhood(@PathVariable Long neighbourhoodId) {
        return tariffService.deleteNeighbourhood(neighbourhoodId);
    }

    @PostMapping("/tariffPlan")
    @ApiOperation(value = "Saves a new tariff plan in database.")
    public TariffPlan saveTariffPlan(@RequestBody TariffPlan tariffPlan) {
        return tariffService.saveTariffPlan(tariffPlan);
    }

    @DeleteMapping("/tariffPlan/{tariffPlanId}")
    @ApiOperation(value = "Deletes a tariff plan from database.")
    public Boolean deleteTariffPlan(@PathVariable Long tariffPlanId) {
        return tariffService.deleteTariffPlan(tariffPlanId);
    }

}
