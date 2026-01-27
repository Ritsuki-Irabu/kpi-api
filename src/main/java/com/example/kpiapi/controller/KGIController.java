package com.example.kpiapi.controller;

import com.example.kpiapi.entity.KGI;
import com.example.kpiapi.service.KGIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kgi")
public class KGIController {

    private final KGIService kgiService;

    public KGIController(KGIService kgiService) {
        this.kgiService = kgiService;
    }

    // --- KGI作成 ---
    @PostMapping
    public KGI create(@RequestBody KGI request) {
        return kgiService.create(request);
    }

    // --- KGI取得 ---
    @GetMapping("/{id}")
    public KGI getById(@PathVariable Integer id) {
        return kgiService.findById(id);
    }
}