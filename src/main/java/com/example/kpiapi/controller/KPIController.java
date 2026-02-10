package com.example.kpiapi.controller;

import com.example.kpiapi.entity.KPI;
import com.example.kpiapi.service.KPIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kpi")
public class KPIController {

    public final KPIService kpiService;

    public KPIController(KPIService kpiService) {
        this.kpiService = kpiService;
    }

    //--KPI作成
    @PostMapping
    public KPI create(@RequestBody KPI request) {
        return kpiService.create(request);
    }

    //--KGIからの取得
    @GetMapping("/kgi/{kgiId}")
    public List<KPI> findByKgiId(@PathVariable Integer kgiId) {
        return kpiService.findByKgiId(kgiId);
    }

    //--全て取得
    @GetMapping
    public List<KPI> findAll() {
        return kpiService.findAll();
    }

    //--１件取得
    @GetMapping("/{id}")
    public KPI getById(@PathVariable Integer id) {
        return kpiService.findById(id);
    }

    //--ID削除
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        kpiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
