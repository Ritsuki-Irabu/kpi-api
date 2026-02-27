package com.example.kpiapi.dto.kpi;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KPIResponse {

    private Integer id;
    private Integer kgiId;
    private String title;
    private Integer targetValue;
}