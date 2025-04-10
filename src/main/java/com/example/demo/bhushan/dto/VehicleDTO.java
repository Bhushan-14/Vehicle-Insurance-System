package com.example.demo.bhushan.dto;

import lombok.Data;

@Data
public class VehicleDTO {
    private Long id;
    private String model;
    private String make;
    private String year;
    private String registrationNumber;
    private boolean isActive;
    private CustomerDTO customer;
}
