package com.example.kpiapi.dto.kpirecord;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KPIRecordResponse {

    private Integer id;
    private Integer kpiId;
    private LocalDate recordDate;
    private Integer actualValue;
}