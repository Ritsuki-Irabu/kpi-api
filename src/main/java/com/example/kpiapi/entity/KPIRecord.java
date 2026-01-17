package com.example.kpiapi.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "kpi_record")
public class KPIRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "kpi_id", nullable = false)
    private KPI kpi;

    @Column(name = "record_date", nullable = false)
    private LocalDate recordDate;

    @Column(name = "actual_value", nullable = false)
    private Integer actualValue;

    // --- getter / setter ---

    public Integer getId() {
        return id;
    }

    public KPI getKpi() {
        return kpi;
    }

    public void setKpi(KPI kpi) {
        this.kpi = kpi;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public Integer getActualValue() {
        return actualValue;
    }

    public void setActualValue(Integer actualValue) {
        this.actualValue = actualValue;
    }
}
