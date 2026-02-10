package com.example.kpiapi.controller;

import com.example.kpiapi.entity.KGI;
import com.example.kpiapi.service.KGIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kgi")
public class KGIController {

    private final KGIService kgiService;

    public KGIController(KGIService kgiService) {
        this.kgiService = kgiService;
    }

    //--KGI作成
    @PostMapping
    public KGI create(@RequestBody KGI request) {
        return kgiService.create(request);
    }

    //--AppUserからの取得
    @GetMapping("/User/{UserId}")
    public List<KGI> findByUserId(@PathVariable Integer UserId) {
        return kgiService.findByUserId(UserId);
    }

    //--全て取得
    @GetMapping
    public List<KGI> findAll() {
        return kgiService.findAll();
    }

    //--１件取得
    @GetMapping("/{id}")
    public KGI getById(@PathVariable Integer id) {
        return kgiService.findById(id);
    }

    //--ID削除
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        kgiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}