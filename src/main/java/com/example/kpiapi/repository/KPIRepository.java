package com.example.kpiapi.repository;

import com.example.kpiapi.entity.KPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KPIRepository extends JpaRepository<KPI,Integer> {
}
