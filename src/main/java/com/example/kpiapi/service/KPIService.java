package com.example.kpiapi.service;

import com.example.kpiapi.dto.kpi.KPIRequest;
import com.example.kpiapi.dto.kpi.KPIResponse;
import com.example.kpiapi.entity.KGI;
import com.example.kpiapi.entity.KPI;
import com.example.kpiapi.repository.KGIRepository;
import com.example.kpiapi.repository.KPIRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KPIService {

    private final KPIRepository kpiRepository;
    private final KGIRepository kgiRepository;

    public KPIService(KPIRepository kpiRepository,
                      KGIRepository kgiRepository) {
        this.kpiRepository = kpiRepository;
        this.kgiRepository = kgiRepository;
    }

    //新規作成
    public KPIResponse create(KPIRequest request) {

        KGI kgi = kgiRepository.findById(request.getKgiId())
                .orElseThrow(() -> new RuntimeException("KGI Not Found"));

        KPI entity = new KPI();
        entity.setKgi(kgi);
        entity.setTitle(request.getTitle());
        entity.setTargetValue(request.getTargetValue());

        KPI saved = kpiRepository.save(entity);

        return toResponse(saved);
    }

    //--KGI単位取得
    public List<KPIResponse> findByKgiId(Integer kgiId) {

        return kpiRepository.findByKgi_Id(kgiId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    //--全件取得
    public List<KPIResponse> findAll() {

        return kpiRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    //--１件取得
    public KPIResponse findById(Integer id) {

        KPI entity = kpiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KPI Not Found"));

        return toResponse(entity);
    }

    //--削除
    public void deleteById(Integer id) {

        if (!kpiRepository.existsById(id)) {
            throw new RuntimeException("KPI Not Found");
        }

        kpiRepository.deleteById(id);
    }

    // Entity → DTO
    private KPIResponse toResponse(KPI entity) {

        return KPIResponse.builder()
                .id(entity.getId())
                .kgiId(entity.getKgi().getId())
                .title(entity.getTitle())
                .targetValue(entity.getTargetValue())
                .build();
    }

}
