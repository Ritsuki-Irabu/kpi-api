package com.example.kpiapi.service;

import com.example.kpiapi.entity.KPIRecord;
import com.example.kpiapi.repository.KPIRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KPIRecordService {

    public final KPIRecordRepository kpiRecordRepository;

    public KPIRecordService(KPIRecordRepository kpiRecordRepository) {
        this.kpiRecordRepository = kpiRecordRepository;
    }

    //--新規作成
    public KPIRecord create(KPIRecord kpiRecord) {
        return kpiRecordRepository.save(kpiRecord);
    }

    //--KPI IDに紐づく記録一覧取得
    public List<KPIRecord> findByKpiId(Integer id) {
        return kpiRecordRepository.findByKpiId(id);
    }

    //--全て取得
    public List<KPIRecord> findAll() {
        return kpiRecordRepository.findAll();
    }

    //--一件取得
    public KPIRecord findById(Integer id) {
        return kpiRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KPIRecord not found"));
    }

    //--ID削除
    public void deleteById(Integer id) {
        if(!kpiRecordRepository.existsById(id)) {
            throw new RuntimeException("KPIRecord Not Found");
        }
        kpiRecordRepository.deleteById(id);
    }

}
