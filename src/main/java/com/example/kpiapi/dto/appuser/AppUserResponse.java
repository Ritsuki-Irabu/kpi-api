package com.example.kpiapi.dto.appuser;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUserResponse {

    private Integer id;
    private String userName;
    private LocalDateTime createdAt;
}