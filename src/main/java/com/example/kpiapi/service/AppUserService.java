package com.example.kpiapi.service;

import com.example.kpiapi.entity.AppUser;
import com.example.kpiapi.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    //コンストラクタインジェクション
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    //ユーザー新規登録
    public AppUser create(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    //---ユーザーIDで1件取得
    public AppUser findById(Integer id) {
        return appUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    //---ユーザーIDを全て取得
    public List<AppUser> findAll(){
        return appUserRepository.findAll();
    }

    //--ID削除
    public void deleteById(Integer id) {
        if(!appUserRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        appUserRepository.deleteById(id);
    }

}

