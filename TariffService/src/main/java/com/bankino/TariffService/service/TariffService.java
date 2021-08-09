package com.bankino.TariffService.service;



import com.bankino.TariffService.dto.*;
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

    public Country saveCountry(CountryDTO countryDTO) {
        Country country = new Country();
        country.setId(countryDTO.id);
        country.setName(countryDTO.name);
        if(countryDTO.tariffPlanId != null) {
            TariffPlan tariffPlan = tariffPlanRepository.getById(countryDTO.tariffPlanId);
            country.setTariffPlan(tariffPlan);
        }
        return countryRepository.save(country);
    }

    public Boolean deleteCountry(Long id) {
        countryRepository.deleteById(id);
        return true;
    }

    public City saveCity(CityDTO cityDTO) {
        City city = new City();
        city.setId(cityDTO.id);
        city.setName(cityDTO.name);
        State state = stateRepository.getById(cityDTO.stateId);
        city.setState(state);
        if(cityDTO.tariffPlanId != null) {
            TariffPlan tariffPlan = tariffPlanRepository.getById(cityDTO.tariffPlanId);
            city.setTariffPlan(tariffPlan);
        }
        return cityRepository.save(city);
    }

    public Boolean deleteCity(Long id) {
        cityRepository.deleteById(id);
        return true;
    }

    public State saveState(StateDTO stateDTO) {
        State state = new State();
        state.setId(stateDTO.id);
        state.setName(stateDTO.name);
        Country country = countryRepository.getById(stateDTO.countryId);
        state.setCountry(country);
        if(stateDTO.tariffPlanId != null) {
            TariffPlan tariffPlan = tariffPlanRepository.getById(stateDTO.tariffPlanId);
            state.setTariffPlan(tariffPlan);
        }
        return stateRepository.save(state);
    }

    public Boolean deleteState(Long id) {
        stateRepository.deleteById(id);
        return true;
    }

    public District saveDistrict(DistrictDTO districtDTO) {
        District district = new District();
        district.setId(districtDTO.id);
        district.setName(districtDTO.name);
        City city = cityRepository.getById(districtDTO.cityId);
        district.setCity(city);
        if(districtDTO.tariffPlanId != null) {
            TariffPlan tariffPlan = tariffPlanRepository.getById(districtDTO.tariffPlanId);
            district.setTariffPlan(tariffPlan);
        }
        return districtRepository.save(district);
    }

    public Boolean deleteDistrict(Long id) {
        districtRepository.deleteById(id);
        return true;
    }

    public Neighbourhood saveNeighbourhood(NeighbourhoodDTO neighbourhoodDTO) {
        Neighbourhood neighbourhood = new Neighbourhood();
        neighbourhood.setId(neighbourhoodDTO.id);
        neighbourhood.setName(neighbourhoodDTO.name);
        District district = districtRepository.getById(neighbourhoodDTO.districtId);
        neighbourhood.setDistrict(district);
        if(neighbourhoodDTO.tariffPlanId != null) {
            TariffPlan tariffPlan = tariffPlanRepository.getById(neighbourhoodDTO.tariffPlanId);
            neighbourhood.setTariffPlan(tariffPlan);
        }
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
