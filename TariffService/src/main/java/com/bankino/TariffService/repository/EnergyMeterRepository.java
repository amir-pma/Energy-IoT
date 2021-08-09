package com.bankino.TariffService.repository;

import com.bankino.TariffService.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyMeterRepository extends JpaRepository<Country, Long> {

}
