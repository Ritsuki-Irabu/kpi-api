package com.example.kpiapi.service;

import com.example.kpiapi.entity.KGI;
import com.example.kpiapi.repository.KGIRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KGIService {

    public final KGIRepository kgiRepository;

    public KGIService(KGIRepository kgiRepository) {

        this.kgiRepository = kgiRepository;
    }

    //--IDを取得する
    public KGI findById(Integer id) {
        return kgiRepository.findById(id).orElse(null);
    }

    //--新規作成する
    public KGI create(KGI kgi) {
        return kgiRepository.save(kgi);
    }



}
