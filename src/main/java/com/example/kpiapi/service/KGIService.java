package com.example.kpiapi.service;

import com.example.kpiapi.entity.KGI;
import com.example.kpiapi.repository.KGIRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KGIService {

    public final KGIRepository kgiRepository;

    public KGIService(KGIRepository kgiRepository) {

        this.kgiRepository = kgiRepository;
    }

    //--新規作成する
    public KGI create(KGI kgi) {
        return kgiRepository.save(kgi);
    }

    //--AppUserから取得する
    public List<KGI> findByUserId(Integer userId) {
        return kgiRepository.findByUserId(userId);
    }

    //--IDを全て取得する
    public List<KGI> findAll(){
        return kgiRepository.findAll();
    }

    //--IDを一件取得する
    public KGI findById(Integer id) {
        return kgiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("KGI Not Found"));
    }

    //--IDを削除する
    public void deleteById(Integer id) {
        if(!kgiRepository.existsById(id)) {
            throw new RuntimeException("KGI Not Found");
        }
        kgiRepository.deleteById(id);
    }
}
