package com.example.kpiapi.service;

import com.example.kpiapi.dto.kgi.KGIRequest;
import com.example.kpiapi.dto.kgi.KGIResponse;
import com.example.kpiapi.entity.AppUser;
import com.example.kpiapi.entity.KGI;
import com.example.kpiapi.repository.AppUserRepository;
import com.example.kpiapi.repository.KGIRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KGIService {

    private final KGIRepository kgiRepository;
    private final AppUserRepository appUserRepository;

    public KGIService(KGIRepository kgiRepository,
                      AppUserRepository appUserRepository) {
        this.kgiRepository = kgiRepository;
        this.appUserRepository = appUserRepository;
    }

    //--新規作成
    public KGIResponse create(KGIRequest request) {

        AppUser user = appUserRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        KGI entity = new KGI();
        entity.setUser(user);
        entity.setTitle(request.getTitle());
        entity.setTargetValue(request.getTargetValue());

        KGI saved = kgiRepository.save(entity);

        return toResponse(saved);
    }

    //--AppUser単位取得
    public List<KGIResponse> findByUserId(Integer userId) {

        return kgiRepository.findByUser_Id(userId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    //--全件取得
    public List<KGIResponse> findAll() {

        return kgiRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    //--１件取得する
    public KGIResponse findById(Integer id) {

        KGI entity = kgiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KGI Not Found"));

        return toResponse(entity);
    }

    //--削除
    public void deleteById(Integer id) {

        if (!kgiRepository.existsById(id)) {
            throw new RuntimeException("KGI Not Found");
        }

        kgiRepository.deleteById(id);
    }

    // Entity → DTO
    private KGIResponse toResponse(KGI entity) {

        return KGIResponse.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .title(entity.getTitle())
                .targetValue(entity.getTargetValue())
                .build();
    }
}
