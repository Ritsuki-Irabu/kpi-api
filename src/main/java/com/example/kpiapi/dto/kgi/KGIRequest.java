package com.example.kpiapi.dto.kgi;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KGIRequest {

    private Integer userId;
    private String title;
    private Integer targetValue;
}