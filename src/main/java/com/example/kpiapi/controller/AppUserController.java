package com.example.kpiapi.controller;

import com.example.kpiapi.entity.AppUser;
import com.example.kpiapi.service.AppUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping
    public AppUser create(@RequestBody AppUser request) {
        return appUserService.create(request);
    }
}
