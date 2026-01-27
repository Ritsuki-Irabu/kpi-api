package com.example.kpiapi.service;

import com.example.kpiapi.entity.KPIRecord;
import com.example.kpiapi.repository.KPIRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KPIRecordService {

    public final KPIRecordRepository kpiRecordRepository;

    public KPIRecordService(KPIRecordRepository kpiRecordRepository) {
        this.kpiRecordRepository = kpiRecordRepository;
    }

    public List<KPIRecord> findByKpiId(Integer id) {
        return kpiRecordRepository.findByKpiId(id);
    }

    public KPIRecord create(KPIRecord kpiRecord) {
        return kpiRecordRepository.save(kpiRecord);
    }
}
