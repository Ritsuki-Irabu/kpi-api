package com.example.kpiapi.dto.kpi;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KPIRequest {

    private Integer kgiId;
    private String title;
    private Integer targetValue;
}