package com.example.kpiapi.service;

import com.example.kpiapi.entity.AppUser;
import com.example.kpiapi.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    //コンストラクタインジェクション
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    //ユーザーIDで1件取得
    public Optional<AppUser> findById(Integer id) {
        return appUserRepository.findById(id);
    }
    //ユーザー新規登録
    public AppUser create(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

}
