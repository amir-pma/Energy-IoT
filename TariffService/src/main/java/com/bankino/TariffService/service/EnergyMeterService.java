package com.bankino.TariffService.service;



import com.bankino.TariffService.model.Country;
import com.bankino.TariffService.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class EnergyMeterService {

    private final CountryRepository countryRepository;

    public EnergyMeterService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country saveEnergyMeter(Country country) {
        return countryRepository.save(country);
    }
}
