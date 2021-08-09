package com.bankino.TariffService.service;



import com.bankino.TariffService.model.*;
import com.bankino.TariffService.repository.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TariffService {

    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;
    private final DistrictRepository districtRepository;
    private final NeighbourhoodRepository neighbourhoodRepository;
    private final TariffPlanRepository tariffPlanRepository;

    public TariffService(CountryRepository countryRepository, StateRepository stateRepository, CityRepository cityRepository, DistrictRepository districtRepository, NeighbourhoodRepository neighbourhoodRepository, TariffPlanRepository tariffPlanRepository) {
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
        this.districtRepository = districtRepository;
        this.neighbourhoodRepository = neighbourhoodRepository;
        this.tariffPlanRepository = tariffPlanRepository;
    }

    public double getTariffCost(Long neighbourhoodId) {
        Optional<Neighbourhood> neighbourhood = neighbourhoodRepository.findById(neighbourhoodId);
        return neighbourhood.map(Neighbourhood::getTariffPlanCost).orElse(-1.0);
    }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public Boolean deleteCountry(Long id) {
        countryRepository.deleteById(id);
        return true;
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    public Boolean deleteCity(Long id) {
        cityRepository.deleteById(id);
        return true;
    }

    public State saveState(State state) {
        return stateRepository.save(state);
    }

    public Boolean deleteState(Long id) {
        stateRepository.deleteById(id);
        return true;
    }

    public District saveDistrict(District district) {
        return districtRepository.save(district);
    }

    public Boolean deleteDistrict(Long id) {
        districtRepository.deleteById(id);
        return true;
    }

    public Neighbourhood saveNeighbourhood(Neighbourhood neighbourhood) {
        return neighbourhoodRepository.save(neighbourhood);
    }

    public Boolean deleteNeighbourhood(Long id) {
        neighbourhoodRepository.deleteById(id);
        return true;
    }

    public TariffPlan saveTariffPlan(TariffPlan tariffPlan) {
        return tariffPlanRepository.save(tariffPlan);
    }

    public Boolean deleteTariffPlan(Long id) {
        tariffPlanRepository.deleteById(id);
        return true;
    }
}
