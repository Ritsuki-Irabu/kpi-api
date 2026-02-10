package com.example.kpiapi.service;

import com.example.kpiapi.entity.KPI;
import com.example.kpiapi.repository.KPIRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KPIService {

    public final KPIRepository kpiRepository;

    public KPIService(KPIRepository kpiRepository) {

        this.kpiRepository = kpiRepository;
    }

    //新規作成
    public KPI create(KPI kpi) {
        return kpiRepository.save(kpi);
    }

    //--KGIからの取得
    public List<KPI> findByKgiId(Integer kgiId) {
        return kpiRepository.findByKgiId(kgiId);
    }

    //--全て取得
    public List<KPI> findAll() {
        return kpiRepository.findAll();
    }

    //--一件取得
    public KPI findById(Integer id) {
        return kpiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KPI Not Found"));
    }

    //--ID削除
    public void deleteById(Integer id) {
        if(!kpiRepository.existsById(id)) {
            throw new RuntimeException("KPI Non Found");
        }
        kpiRepository.deleteById(id);
    }

}
