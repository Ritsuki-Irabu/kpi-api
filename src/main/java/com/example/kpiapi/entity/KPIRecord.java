package com.example.kpiapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "kpi_record")
@Data
@NoArgsConstructor
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

}
