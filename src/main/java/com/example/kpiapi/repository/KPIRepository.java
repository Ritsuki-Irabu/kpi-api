package com.example.kpiapi.repository;

import com.example.kpiapi.entity.KPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KPIRepository extends JpaRepository<KPI,Integer> {

    List<KPI> findByKgiId(Integer kgiId);
}
