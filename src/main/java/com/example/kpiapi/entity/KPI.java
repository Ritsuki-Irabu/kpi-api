package com.example.kpiapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kpi")
@Data
@NoArgsConstructor
public class KPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "kgi_id", nullable = false)
    private KGI kgi;

    @Column(nullable = false)
    private String title;

    @Column(name = "target_value", nullable = false)
    private Integer targetValue;

}
