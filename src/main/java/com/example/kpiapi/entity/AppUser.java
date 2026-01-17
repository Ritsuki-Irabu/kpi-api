package com.example.kpiapi.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "app_users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    //--- getter / setter ---

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
