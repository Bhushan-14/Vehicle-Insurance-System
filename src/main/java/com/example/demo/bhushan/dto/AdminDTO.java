package com.example.demo.bhushan.dto;

import lombok.Data;

@Data
public class AdminDTO {
    private Long id;
    private String username;
    private String password;
    private String role;
    private boolean isActive;
}
