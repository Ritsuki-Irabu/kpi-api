package com.example.kpiapi.controller;

import com.example.kpiapi.dto.kpirecord.KPIRecordRequest;
import com.example.kpiapi.dto.kpirecord.KPIRecordResponse;
import com.example.kpiapi.service.KPIRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kpi-record")
public class KPIRecordController {

    private final KPIRecordService kpiRecordService;

    public KPIRecordController(KPIRecordService kpiRecordService) {
        this.kpiRecordService = kpiRecordService;
    }

    //--KPIRecord作成
    @PostMapping
    public KPIRecordResponse create(@RequestBody KPIRecordRequest request){
        return kpiRecordService.create(request);
    }

    //--KPIからの取得
    @GetMapping("/kpi/{kpiId}")
    public List<KPIRecordResponse> getByKpiId(@PathVariable Integer kpiId) {
        return kpiRecordService.findByKpiId(kpiId);
    }

    //--全て取得
    @GetMapping
    public List<KPIRecordResponse> findAll() {
        return kpiRecordService.findAll();
    }

    //--１件取得
    @GetMapping("/{id}")
    public KPIRecordResponse findById(@PathVariable Integer id) {
        return kpiRecordService.findById(id);
    }

    //--ID削除
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        kpiRecordService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}