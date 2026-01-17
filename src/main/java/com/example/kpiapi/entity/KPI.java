package com.example.kpiapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "kpi")
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

    // --- getter / setter ---

    public Integer getId() {
        return id;
    }

    public KGI getKgi() {
        return kgi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(Integer targetValue) {
        this.targetValue = targetValue;
    }


}
