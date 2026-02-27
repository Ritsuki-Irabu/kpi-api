package com.example.kpiapi.service;

import com.example.kpiapi.dto.appuser.AppUserRequest;
import com.example.kpiapi.dto.appuser.AppUserResponse;
import com.example.kpiapi.entity.AppUser;
import com.example.kpiapi.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    //新規登録
    public AppUserResponse create(AppUserRequest request) {

        AppUser entity = new AppUser();
        entity.setUserName(request.getUserName());
        entity.setCreatedAt(LocalDateTime.now());

        AppUser saved = appUserRepository.save(entity);

        return toResponse(saved);
    }

    //---AppUser単位取得
    public AppUserResponse findById(Integer id) {

        AppUser entity = appUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return toResponse(entity);
    }

    //---全件取得
    public List<AppUserResponse> findAll() {

        return appUserRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    //--削除
    public void deleteById(Integer id) {

        if (!appUserRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        appUserRepository.deleteById(id);
    }

    // Entity → DTO
    private AppUserResponse toResponse(AppUser entity) {
        return AppUserResponse.builder()
                .id(entity.getId())
                .userName(entity.getUserName())
                .createdAt(entity.getCreatedAt())
                .build();
    }

}

