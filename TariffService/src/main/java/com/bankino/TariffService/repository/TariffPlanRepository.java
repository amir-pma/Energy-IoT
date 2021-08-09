package com.bankino.TariffService.repository;

import com.bankino.TariffService.model.TariffPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffPlanRepository extends JpaRepository<TariffPlan, Long> {
}
