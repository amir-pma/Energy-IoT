package com.bankino.TariffService.repository;

import com.bankino.TariffService.model.Neighbourhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NeighbourhoodRepository extends JpaRepository<Neighbourhood, Long> {

    @Query("select n.id from #{#entityName} n")
    List<Long> getAllIds();

}
