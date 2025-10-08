package com.gastospessoaisapi.gastospessoais.domain.repository;

import com.gastospessoaisapi.gastospessoais.domain.model.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {
}