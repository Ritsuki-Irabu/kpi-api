package com.example.kpiapi.service;

import com.example.kpiapi.dto.kpirecord.KPIRecordRequest;
import com.example.kpiapi.dto.kpirecord.KPIRecordResponse;
import com.example.kpiapi.entity.KPI;
import com.example.kpiapi.entity.KPIRecord;
import com.example.kpiapi.repository.KPIRecordRepository;
import com.example.kpiapi.repository.KPIRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KPIRecordService {

    private final KPIRecordRepository kpiRecordRepository;
    private final KPIRepository kpiRepository;

    public KPIRecordService(KPIRecordRepository kpiRecordRepository,
                            KPIRepository kpiRepository) {
        this.kpiRecordRepository = kpiRecordRepository;
        this.kpiRepository = kpiRepository;
    }

    //--新規作成
    public KPIRecordResponse create(KPIRecordRequest request) {

        KPI kpi = kpiRepository.findById(request.getKpiId())
                .orElseThrow(() -> new RuntimeException("KPI Not Found"));

        KPIRecord entity = new KPIRecord();
        entity.setKpi(kpi);
        entity.setRecordDate(request.getRecordDate());
        entity.setActualValue(request.getActualValue());

        KPIRecord saved = kpiRecordRepository.save(entity);

        return toResponse(saved);
    }

    //--KPI単位取得
    public List<KPIRecordResponse> findByKpiId(Integer kpiId) {

        return kpiRecordRepository.findByKpi_Id(kpiId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    //--全件取得
    public List<KPIRecordResponse> findAll() {

        return kpiRecordRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    //--１件取得
    public KPIRecordResponse findById(Integer id) {

        KPIRecord entity = kpiRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KPIRecord Not Found"));

        return toResponse(entity);
    }

    //--削除
    public void deleteById(Integer id) {

        if (!kpiRecordRepository.existsById(id)) {
            throw new RuntimeException("KPIRecord Not Found");
        }

        kpiRecordRepository.deleteById(id);
    }

    // Entity → DTO
    private KPIRecordResponse toResponse(KPIRecord entity) {

        return KPIRecordResponse.builder()
                .id(entity.getId())
                .kpiId(entity.getKpi().getId())
                .recordDate(entity.getRecordDate())
                .actualValue(entity.getActualValue())
                .build();
    }
}