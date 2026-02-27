package com.example.kpiapi.controller;

import com.example.kpiapi.dto.appuser.AppUserRequest;
import com.example.kpiapi.dto.appuser.AppUserResponse;
import com.example.kpiapi.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    // 作成
    @PostMapping
    public AppUserResponse create(@RequestBody AppUserRequest request) {
        return appUserService.create(request);
    }

    // 全件取得
    @GetMapping
    public List<AppUserResponse> findAll() {
        return appUserService.findAll();
    }

    // 1件取得
    @GetMapping("/{id}")
    public AppUserResponse findById(@PathVariable Integer id) {
        return appUserService.findById(id);
    }

    // 削除
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        appUserService.deleteById(id);
    }
}