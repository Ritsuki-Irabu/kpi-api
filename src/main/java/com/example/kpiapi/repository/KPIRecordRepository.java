package com.example.kpiapi.repository;

import java.util.List;
import com.example.kpiapi.entity.KPIRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KPIRecordRepository extends JpaRepository<KPIRecord,Integer> {

    List<KPIRecord> findByKpi_Id(Integer kpiId);
}
