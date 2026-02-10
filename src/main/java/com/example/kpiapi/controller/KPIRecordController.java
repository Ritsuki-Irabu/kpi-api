package com.example.kpiapi.controller;

import com.example.kpiapi.entity.KPIRecord;
import com.example.kpiapi.service.KPIRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kpi-record")
public class KPIRecordController {

    public final KPIRecordService kpiRecordService;

    public KPIRecordController(KPIRecordService kpiRecordService) {
        this.kpiRecordService = kpiRecordService;
    }

    //--KPIRecord作成
    @PostMapping
    public KPIRecord create(@RequestBody KPIRecord request){
        return kpiRecordService.create(request);
    }

    //--KPIからの取得
    @GetMapping("/kpi/{KpiId}")
    public List<KPIRecord> getByKpiId(@PathVariable Integer kpiId) {
        return kpiRecordService.findByKpiId(kpiId);
    }

    //--全て取得
    @GetMapping
    public List<KPIRecord> findAll() {
        return kpiRecordService.findAll();
    }

    //--１件取得
    @GetMapping("/{id}")
    public KPIRecord findById(@PathVariable Integer id) {
        return kpiRecordService.findById(id);
    }

    //--ID削除
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        kpiRecordService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
