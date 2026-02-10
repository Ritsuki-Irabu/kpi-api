package com.example.kpiapi.repository;

import com.example.kpiapi.entity.AppUser;
import com.example.kpiapi.entity.KGI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KGIRepository extends JpaRepository<KGI,Integer> {

    List<KGI> findByUserId(Integer userId);
}
