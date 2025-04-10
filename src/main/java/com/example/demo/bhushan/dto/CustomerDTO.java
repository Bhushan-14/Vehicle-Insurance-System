package com.example.demo.bhushan.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Boolean isActive;
    private LocalDate registrationDate;
    private List<VehicleDTO> vehicles;
    private List<InsurancePolicyDTO> policies;
}
