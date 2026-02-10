package com.example.kpiapi.controller;

import com.example.kpiapi.entity.AppUser;
import com.example.kpiapi.service.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    //--ID作成
    @PostMapping
    public AppUser create(@RequestBody AppUser request) {
        return appUserService.create(request);
    }

    //--１件取得
    @GetMapping("/{id}")
    public AppUser findById(@PathVariable Integer id) {
        return appUserService.findById(id);
    }

    //--全て取得
    @GetMapping
    public List<AppUser> findAll() {
        return appUserService.findAll();
    }

    //--ID削除
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        appUserService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
