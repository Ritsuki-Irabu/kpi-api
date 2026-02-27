package com.example.kpiapi.controller;

import com.example.kpiapi.dto.kgi.KGIRequest;
import com.example.kpiapi.dto.kgi.KGIResponse;
import com.example.kpiapi.service.KGIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kgis")
@RequiredArgsConstructor
public class KGIController {

    private final KGIService kgiService;

    // 新規作成
    @PostMapping
    public KGIResponse create(@RequestBody KGIRequest request) {
        return kgiService.create(request);
    }

    // 全件取得
    @GetMapping
    public List<KGIResponse> findAll() {
        return kgiService.findAll();
    }

    // 1件取得
    @GetMapping("/{id}")
    public KGIResponse findById(@PathVariable Integer id) {
        return kgiService.findById(id);
    }

    // 削除
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        kgiService.deleteById(id);
    }
}