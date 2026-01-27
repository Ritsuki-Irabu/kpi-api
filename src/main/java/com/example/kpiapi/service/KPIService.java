package com.example.kpiapi.service;

import com.example.kpiapi.entity.KPI;
import com.example.kpiapi.repository.KPIRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KPIService {

    public final KPIRepository kpiRepository;

    public KPIService(KPIRepository kpiRepository) {

        this.kpiRepository = kpiRepository;
    }

    public KPI findById(Integer id) {
        return kpiRepository.findById(id).orElse(null);
    }

    public KPI create(KPI kpi) {
        return kpiRepository.save(kpi);
    }
}
