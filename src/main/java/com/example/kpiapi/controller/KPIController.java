package com.example.kpiapi.controller;

import com.example.kpiapi.entity.KPI;
import com.example.kpiapi.service.KPIService;
import org.springframework.web.bind.annotation.*;

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

    //--KPI取得
    @GetMapping("/{id}")
    public KPI getById(@PathVariable Integer id) {
        return kpiService.findById(id);
    }
}
