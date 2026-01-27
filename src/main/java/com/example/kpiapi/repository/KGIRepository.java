package com.example.kpiapi.repository;

import com.example.kpiapi.entity.KGI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KGIRepository extends JpaRepository<KGI,Integer> {
}
