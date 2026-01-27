package com.example.kpiapi.controller;

import com.example.kpiapi.entity.KPIRecord;
import com.example.kpiapi.service.KPIRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kpi-records")
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

    //--KPIRecord取得
    @GetMapping("/kpi/{kpiId}")
    public List<KPIRecord> getByKpiId(@PathVariable Integer kpiId) {
        return kpiRecordService.findByKpiId(kpiId);
    }
}
