package com.example.demo.bhushan.dto;

import lombok.Data;
import java.util.List;

@Data
public class InsurancePolicyDTO {
    private Long id;
    private String policyNumber;
    private String coverageType;
    private double premiumAmount;
    private boolean isActive;
    private CustomerDTO customer;
    private VehicleDTO vehicle;
    private List<InsuranceClaimDTO> claims;
}
