package com.example.kpiapi.dto.kpirecord;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KPIRecordRequest {

    private Integer kpiId;
    private LocalDate recordDate;
    private Integer actualValue;
}