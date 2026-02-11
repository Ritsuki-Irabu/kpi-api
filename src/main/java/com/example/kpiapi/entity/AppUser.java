package com.example.kpiapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_users")
@Data //Getter/Setter/toString等が自動生成される
@NoArgsConstructor //引数なしコンストラクタを自動生成する
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}
